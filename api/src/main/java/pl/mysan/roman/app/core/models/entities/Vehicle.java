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

    public Vehicle(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getWasBorrowed() {
        return wasBorrowed;
    }

    public void setWasBorrowed(Boolean wasBorrowed) {
        this.wasBorrowed = wasBorrowed;
    }
}
