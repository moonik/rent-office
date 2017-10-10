package pl.mysan.roman.app.core.models.entities;

import org.hibernate.annotations.UpdateTimestamp;
import pl.mysan.roman.app.core.dto.CarDTO;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Car")
public class Car extends Vehicle{

    private String producent;

    private String name;

    private String color;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    public Car(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void edit(CarDTO carDTO){
        this.producent = carDTO.getProducent();
        this.name = carDTO.getName();
        this.color = carDTO.getColor();
        this.releaseDate = carDTO.getReleaseDate();
    }
}
