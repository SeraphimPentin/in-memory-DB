package sim.inmemorydb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sim.inmemorydb.model.Records;
import sim.inmemorydb.repository.RecordRepository;


import java.util.List;

@RestController
@RequestMapping("api/")
public class RecordController {


    @Autowired
    private RecordRepository repository;

    @PostMapping("add")
    public Records save(@RequestBody Records records) {
        return repository.save(records);
    }

    @GetMapping("get-all")
    public List<Records> getAllRecords() {
        return repository.findAll();
    }

    @GetMapping("get-by-name")
    public ResponseEntity<Records> getRecordsByName(String name) {
        return ResponseEntity.ok(repository.findByName(name));
    }

    @GetMapping("get-by-value")
    public ResponseEntity<Records> getRecordsByName(Double value) {
        return ResponseEntity.ok(repository.findByValue(value));
    }

    @GetMapping("get-by-account")
    public ResponseEntity<Records> getRecordsByName(Long account) {
        return ResponseEntity.ok(repository.findByAccount(account));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(Records records)   {
        repository.delete(records);
        return ResponseEntity.ok("Record removed");
    }




//    @PostMapping("/add")
//    public ResponseEntity<Records> addRecord(@RequestBody Records record) {
//        Records savedRecord = recordsService.add(record);
//        return ResponseEntity.ok(savedRecord);
//    }
//
//    @GetMapping("/{account}")
//    public ResponseEntity<Records> getRecordByAccount(Long account) {
//        return ResponseEntity.ok(recordsService.findRecordByAccount(account));
//    }
//
//    @GetMapping("/show-all")
//    public  ResponseEntity<List<Records>> getAllRecords(){
//        return ResponseEntity.ok(recordsService.findAll());
//    }

    //    @PostMapping("remove")
//    public ResponseEntity<RecordResponse> remove(Records record){
//        recordsService.remove(record);
//        return ;
//    }


}
