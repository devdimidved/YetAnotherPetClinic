package me.devdimidved.playground.petclinic.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "VET")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @OneToMany(mappedBy = "vet")
    private Set<Visit> petVisits;

    //todo change to private
    public Vet() {
    }

    public Vet(Integer id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Visit> getPetVisits() {
        return petVisits;
    }

    public void setPetVisits(Set<Visit> petVisits) {
        this.petVisits = petVisits;
    }

    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
