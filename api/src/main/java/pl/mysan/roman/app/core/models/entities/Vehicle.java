package pl.mysan.roman.app.core.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean wasBorrowed;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Borrow> borrow;

    public Vehicle(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        this.borrow = borrow;
    }

    public Boolean getWasBorrowed() {
        return wasBorrowed;
    }

    public void setWasBorrowed(Boolean wasBorrowed) {
        this.wasBorrowed = wasBorrowed;
    }
}
