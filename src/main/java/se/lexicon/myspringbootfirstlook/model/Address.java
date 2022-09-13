package se.lexicon.myspringbootfirstlook.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

// ONE-TO-MANY
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int userId;
    @Column(nullable = false, length = 100)
    private String street;
    @Column(nullable = false, length = 100)
    private String zipCode;
    @Column(nullable = false, length = 100)
    private String city;

    @OneToMany(mappedBy = "address")
//    @JoinColumn(name = "address_user_id")
    private Set<AppUser> appUserlist;

    protected Address() {}

    public Address(int userId, String street, String zipCode, String city, Set<AppUser> appUserlist) {
        this.userId = userId;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.appUserlist = appUserlist;
    }

    public Address(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<AppUser> getAppUserlist() {
        return appUserlist;
    }

    public void setAppUserlist(Set<AppUser> appUserlist) {
        this.appUserlist = appUserlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return userId == address.userId && Objects.equals(street, address.street) && Objects.equals(zipCode, address.zipCode) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, street, zipCode, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "userId=" + userId +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", appUserlist=" + appUserlist +
                '}';
    }

    private class list<T> {
    }
}
