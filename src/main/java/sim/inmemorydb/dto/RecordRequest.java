package sim.inmemorydb.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RecordRequest {


    private Long account;
    private String name;
    private Double value;

    public Long getAccount() {
        return account;
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
