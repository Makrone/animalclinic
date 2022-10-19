package by.spring.animalclinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@MappedSuperclass
public class Person extends BaseEntity {
    @NotEmpty
    @Column(name = "first_name")
    protected String firstName;
    @NotEmpty
    @Column(name = "last_name")
    protected String lastName;
    @NotEmpty
    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    protected LocalDate dateOfBirth;

    public Person() {
        super();
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Person person = (Person) object;
        return java.util.Objects.equals(firstName, person.firstName) && java.util.Objects.equals(lastName, person.lastName) && java.util.Objects.equals(dateOfBirth, person.dateOfBirth);
    }



}
