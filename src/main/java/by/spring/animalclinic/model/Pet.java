package by.spring.animalclinic.model;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pet extends NamedEntity{
    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    public Pet() {
        super();
    }

    public Pet(LocalDate dateOfBirth, Owner owner, PetType petType) {
        this.dateOfBirth = dateOfBirth;
        this.owner = owner;
        this.petType = petType;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner){
        this.owner = owner;
    }
}
