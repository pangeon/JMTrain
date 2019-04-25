package san.jee.cecherz.model;

import java.math.BigInteger;
import java.util.Objects;

public class Workplace {
    private BigInteger id;
    private String name;
    private String city;
    private String street;
    private Integer floor;
    private Integer room;

    public Workplace() {}

    public Workplace(BigInteger id, String name, String city, String street, Integer floor, Integer room) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.floor = floor;
        this.room = room;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Workplace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", floor=" + floor +
                ", room=" + room +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workplace workplace = (Workplace) o;
        return Objects.equals(id, workplace.id) &&
                Objects.equals(name, workplace.name) &&
                Objects.equals(city, workplace.city) &&
                Objects.equals(street, workplace.street) &&
                Objects.equals(floor, workplace.floor) &&
                Objects.equals(room, workplace.room);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, street, floor, room);
    }
}
