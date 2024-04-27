//package sim.inmemorydb.service.serviceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.stereotype.Service;
//import sim.inmemorydb.model.Records;
//import sim.inmemorydb.repository.RecordRepository;
//import sim.inmemorydb.service.RecordsService;
//import sim.inmemorydb.utils.Mapper;
//
//import java.util.List;
//
//
//@Service
//@EnableCaching
//public class RecordsServiceImpl implements RecordsService {
//
//
//    private final RecordRepository repository;
//    private final Mapper mapper;
//
//    @Autowired
//    public RecordsServiceImpl(RecordRepository repository, Mapper mapper) {
//        this.repository = repository;
//        this.mapper = mapper;
//    }
//
//
////    @CacheEvict(cacheNames = "record", allEntries = true)
//    @Override
//    public Records add(Records record) {
//
//        return repository.save(record);
//    }
//
//    @Override
//    public void remove(Records record) {
//
//    }
//
//    @Override
//    public Records update(Records records) {
//        return null;
//    }
//
////    @CacheEvict(cacheNames = "record", key = "#record.id")
////    @Override
////    public void remove(RecordDTO record) {
////        repository.delete(record);
////    }
////
////    @CacheEvict(cacheNames = "record", key = "#record.id")
////    @Override
////    public Records update(RecordDTO record) {
////        Records exist = findRecordById(record.getId());
////        return exist;
////    }
//
//    @Override
//    public Record getRecordByAccount(Long account) {
//        return null;
//    }
//
//
//    @Override
//    public Record getRecordByName(String name) {
//        return null;
//    }
//
//    @Override
//    public Record getRecordByValue(Double value) {
//        return null;
//    }
//
//    public List<Records> findAll(){
//        return (List<Records>) repository.findAll();
//    }
//
//    @Cacheable(value = "recordByAccount", key = "#account")
//    public Records findRecordByAccount(Long account) {
//        return repository.findRecordsByAccount(account).orElseThrow(() -> new IllegalArgumentException("Record not found"));
//    }
//    @Cacheable(value = "recordByName", key = "#name")
//    public Records findRecordByAccount(String name) {
//        return repository.findRecordsByName(name).orElseThrow(() -> new IllegalArgumentException("Record not found"));
//    }
//    @Cacheable(value = "recordByValue", key = "#value")
//    public Records findRecordByAccount(Double value) {
//        return repository.findRecordsByValue(value).orElseThrow(() -> new IllegalArgumentException("Record not found"));
//    }
//}
