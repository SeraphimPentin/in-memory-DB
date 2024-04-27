package sim.inmemorydb.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import sim.inmemorydb.model.Records;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
public class RecordRepository { // extends CrudRepository<Records, Long> {

//    Optional<Records> findRecordsByAccount(Long account);
//    Optional<Records> findRecordsByValue(Double value);
//    Optional<Records> findRecordsByName(String name);

    public static final String HASH_KEY_NAME = "RECORD-ITEM";

    public static final String ACCOUNT_KEY_PREFIX = "account:";
    public static final String NAME_KEY_PREFIX = "name:";
    public static final String VALUE_KEY_PREFIX = "value:";
    @Autowired
    private RedisTemplate redisTemplate;


    public Records save(Records record) {
        redisTemplate.opsForValue().set(getKeyForAccount(record.getAccount()), record.getAccount());
        redisTemplate.opsForValue().set(getKeyForName(record.getName()), record.getName());
        redisTemplate.opsForValue().set(getKeyForValue(record.getValue()), record.getValue());
        return record;
    }


    public Records findByAccount(Long account) {
        String key = getKeyForAccount(account);
        return (Records) redisTemplate.opsForValue().get(key);
    }

    public Records findByName(String name) {
        String key = getKeyForName(name);
        return (Records) redisTemplate.opsForValue().get(key);
    }

    public Records findByValue(Double value) {
        String key = getKeyForValue(value);
        return (Records) redisTemplate.opsForValue().get(key);
    }

    public List<Records> findAll() {
        Set<String> keys = redisTemplate.keys("*");
        List<Records> allRecords = new ArrayList<>();
        Set<String> processedKeys = new HashSet<>(); // Храним обработанные ключи, чтобы избежать дублирования
        for (String key : keys) {
            if (!processedKeys.contains(key)) { // Проверяем, не был ли ключ уже обработан
                Records record = (Records) redisTemplate.opsForValue().get(key);
                allRecords.add(record);
                processedKeys.add(key); // Добавляем обработанный ключ в множество
            }
        }
        return allRecords;
    }

    public void delete(Records record) {
        redisTemplate.delete(getKeyForAccount(record.getAccount()));
        redisTemplate.delete(getKeyForName(record.getName()));
        redisTemplate.delete(getKeyForValue(record.getValue()));
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

    private String getHashKeyName(String key){
        return HASH_KEY_NAME;
    }
}
