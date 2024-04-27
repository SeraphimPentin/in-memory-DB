package sim.inmemorydb.service;

import sim.inmemorydb.model.Records;

public interface RecordsService {

    Records add(Records record);
    void remove(Records record);

    Records update(Records records);
    Record getRecordByAccount(Long account);
    Record getRecordByName(String name);
    Record getRecordByValue(Double value);

}
