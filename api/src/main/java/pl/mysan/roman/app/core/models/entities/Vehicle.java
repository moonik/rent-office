package pl.mysan.roman.app.core.models.entities;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean wasBorrowed;

    @UpdateTimestamp
    private Timestamp lastModified;

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

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }
}
