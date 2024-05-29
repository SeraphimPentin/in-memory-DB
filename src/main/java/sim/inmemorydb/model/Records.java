package sim.inmemorydb.model;


import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Records")
public class Records implements Serializable {

    private Long account;
    private String name;
    private Double value;

    public Records(Long account, String name, Double value) {
        this.account = account;
        this.name = name;
        this.value = value;
    }

    public Long getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}