package sim.inmemorydb.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RecordUpdateRequest {
    private Long account;
    private String newName;
    private Double newValue;

    public Long getAccount() {
        return account;
    }
    public String getNewName() {
        return newName;
    }
    public Double getNewValue() {
        return newValue;
    }
}
