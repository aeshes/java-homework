package aoizora.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Address extends IdentifiableObject {

    private String street;
    @OneToOne
    private User user;

    public Address() {
    }

    public Address(String street) {
        this.street = street;
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

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", id=" + id +
                '}';
    }
}
