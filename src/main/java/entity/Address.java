package entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    private String id;

    @Column
    private String city;

    @Column
    private String street;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
