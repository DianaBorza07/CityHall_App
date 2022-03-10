package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
    @Id
    private String id;

    @Column
    private String city;

    public Address(String name) {
        this.city = name;
    }

    public Address() {}

    public String getCity() {
        return city;
    }

    public void setCity(String name) {
        this.city = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
