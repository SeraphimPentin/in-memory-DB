package sim.inmemorydb.model;


import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Records")
public class Records implements Serializable {

//    @Id
//    private Long id;
//    @Indexed
    private Long account;
//    @Indexed
    private String name;
//    @Indexed
    private Double value;


    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}