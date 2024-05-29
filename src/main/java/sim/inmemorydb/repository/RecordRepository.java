package sim.inmemorydb.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import sim.inmemorydb.dto.RecordRequest;
import sim.inmemorydb.dto.RecordUpdateRequest;
import sim.inmemorydb.exception.RecordsNotFoundException;
import sim.inmemorydb.model.Records;

import java.util.*;


@Repository
public class RecordRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final HashOperations hashOperations;
    public static final String HASH_KEY_NAME = "RECORD-ITEM";

    public static final String ACCOUNT_KEY_PREFIX = "account:";
    public static final String NAME_KEY_PREFIX = "name:";
    public static final String VALUE_KEY_PREFIX = "value:";

    public RecordRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }


    public Records save(Records record) {
        String key = getKeyForAccount(record.getAccount());
        hashOperations.put(HASH_KEY_NAME, key, record);
        return record;
    }

    public List<Records> findAll() {
        List<Records> allRecords = new ArrayList<>();
        Map<Object, Object> recordsMap = hashOperations.entries(HASH_KEY_NAME);
        for (Map.Entry<Object, Object> entry : recordsMap.entrySet()) {
            allRecords.add((Records) entry.getValue());
        }
        return allRecords;
    }

    public void delete(RecordRequest request) {
        String key = getKeyForAccount(request.getAccount());
        Records record = (Records) redisTemplate.opsForHash().get(HASH_KEY_NAME, key);
        if (record != null && record.getName().equals(request.getName()) && record.getValue().equals(request.getValue())) {
            redisTemplate.opsForHash().delete(HASH_KEY_NAME, key);
        } else {
            throw new RecordsNotFoundException("Record not found or does not match the provided name and value");
        }
    }

    public Records update(RecordUpdateRequest request) {
        Long account = request.getAccount();
        String key = getKeyForAccount(account);
        Records existingRecord = (Records) hashOperations.get(HASH_KEY_NAME, key);

        if (existingRecord == null) {
            throw new RecordsNotFoundException("Record not found for account: " + account);
        }

        existingRecord.setName(request.getNewName());
        existingRecord.setValue(request.getNewValue());
        hashOperations.put(HASH_KEY_NAME, key, existingRecord);

        return existingRecord;
    }

    public List<Records> findByAccount(Long account) {
        if (account == null) {
            throw new IllegalArgumentException("Account parameter is required");
        }
        List<Records> matchingRecords = new ArrayList<>();
        List<Object> records = redisTemplate.opsForHash().values(HASH_KEY_NAME);
        for (Object record : records) {
            if (record instanceof Records) {
                Records currentRecord = (Records) record;
                if (currentRecord.getAccount().equals(account)) {
                    matchingRecords.add(currentRecord);
                }
            }
        }
        if (matchingRecords.isEmpty()) {
            throw new RecordsNotFoundException("Record not found");
        }
        return matchingRecords;
    }

    public List<Records> findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name parameter is required");
        }
        List<Records> matchingRecords = new ArrayList<>();
        List<Object> records = redisTemplate.opsForHash().values(HASH_KEY_NAME);
        for (Object record : records) {
            if (record instanceof Records) {
                Records currentRecord = (Records) record;
                if (currentRecord.getName().equals(name)) {
                    matchingRecords.add(currentRecord);
                }
            }
        }
        if (matchingRecords.isEmpty()) {
            throw new RecordsNotFoundException("Record not found");
        }
        return matchingRecords;
    }

    public List<Records> findByValue(Double value) {
        if (value == null) {
            throw new IllegalArgumentException("Value parameter is required");
        }
        List<Records> matchingRecords = new ArrayList<>();
        List<Object> records = redisTemplate.opsForHash().values(HASH_KEY_NAME);
        for (Object record : records) {
            if (record instanceof Records) {
                Records currentRecord = (Records) record;
                if (currentRecord.getValue().equals(value)) {
                    matchingRecords.add(currentRecord);
                }
            }
        }
        if (matchingRecords.isEmpty()) {
            throw new RecordsNotFoundException("Record not found");
        }
        return matchingRecords;
    }

    private String getKeyForAccount(Long account) {
        return ACCOUNT_KEY_PREFIX + account;
    }

    private String getKeyForName(String name) {
        return NAME_KEY_PREFIX + name;
    }

    private String getKeyForValue(Double value) {
        return VALUE_KEY_PREFIX + value;
    }

    private String getHashKeyName(String key) {
        return HASH_KEY_NAME;
    }
}
