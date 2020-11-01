package san.jee.cecherz.model;

import java.math.BigInteger;
import java.util.Objects;

public class Workplaces {
    private BigInteger id;
    private String name;
    private String city;
    private String street;
    private Integer floor;
    private Integer room;

    public Workplaces() {}

    public Workplaces(BigInteger id, String name, String city, String street, Integer floor, Integer room) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.floor = floor;
        this.room = room;
    }
    public Workplaces(Workplaces w) {
        this.id = w.id;
        this.name = w.name;
        this.city = w.city;
        this.street = w.street;
        this.floor = w.floor;
        this.room = w.room;
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
        return "Workplaces{" +
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
        Workplaces workplaces = (Workplaces) o;
        return Objects.equals(id, workplaces.id) &&
                Objects.equals(name, workplaces.name) &&
                Objects.equals(city, workplaces.city) &&
                Objects.equals(street, workplaces.street) &&
                Objects.equals(floor, workplaces.floor) &&
                Objects.equals(room, workplaces.room);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, street, floor, room);
    }
}
