package sim.inmemorydb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sim.inmemorydb.dto.AccountRequest;
import sim.inmemorydb.dto.NameRequest;
import sim.inmemorydb.dto.RecordRequest;
import sim.inmemorydb.dto.ValueRequest;
import sim.inmemorydb.model.Records;
import sim.inmemorydb.repository.RecordRepository;


import java.util.List;

@RestController
@RequestMapping("api/")
public class RecordController {


    @Autowired
    private RecordRepository repository;

    @PostMapping("add")
    public ResponseEntity<Records> save(@RequestBody Records records) {
        return ResponseEntity.ok(repository.save(records));
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Records>> getAllRecords() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("get-by-name")
    public ResponseEntity<List<Records>> getRecordsByName(@RequestBody NameRequest request) {
        return ResponseEntity.ok(repository.findByName(request.getName()));
    }

    @GetMapping("get-by-value")
    public ResponseEntity<List<Records>> getRecordsByName(@RequestBody ValueRequest request) {
        return ResponseEntity.ok(repository.findByValue(request.getValue()));
    }

    @GetMapping("get-by-account")
    public ResponseEntity<List<Records>> getRecordsByName(@RequestBody AccountRequest request) {
        return ResponseEntity.ok(repository.findByAccount(request.getAccount()));
    }


    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestBody RecordRequest request) {
        repository.delete(request);
        return ResponseEntity.ok("Record successfully deleted.");
    }
}
