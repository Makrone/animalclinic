package by.spring.animalclinic.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    @NotEmpty
    private String address;
    @Column(name = "phone")
    @NotEmpty
    @Digits(integer = 10, fraction = 0)
    private String phone;
    @Column(name = "city")
    @NotEmpty
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Pet> pets;

    public Owner() {
        super();
    }

    public Owner(String firstName, String lastName, String address, String phone, String city, List<Pet> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.pets = pets;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return firstName.equals(owner.firstName) && lastName.equals(owner.lastName) && address.equals(owner.address) && phone.equals(owner.phone) && city.equals(owner.city) && pets.equals(owner.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, phone, city, pets);
    }
}
