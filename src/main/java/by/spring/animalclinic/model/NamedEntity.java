package by.spring.animalclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class NamedEntity extends BaseEntity {
    @Column(name = "name")
    protected String name;
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
