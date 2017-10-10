package pl.mysan.roman.app.core.models.entities;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean wasBorrowed;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date lastModified;

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

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
