package san.jee.cecherz.model;

import java.math.BigInteger;
import java.util.Objects;

public class Attendees {
    private BigInteger id;
    private BigInteger idprof;
    private String name;
    private String surname;
    private String phone;
    private String city;
    private String postcode;
    private String street;

    public Attendees() {};

    public Attendees(BigInteger id, BigInteger idprof, String name,
                     String surname, String phone, String city,
                     String postcode, String street)
    {
        this.id = id;
        this.idprof = idprof;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
        this.postcode = postcode;
        this.street = street;
    }
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getIdprof() {
        return idprof;
    }

    public void setIdprof(BigInteger idprof) {
        this.idprof = idprof;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Attendees{" +
                "id=" + id +
                ", idprof=" + idprof +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendees attendees = (Attendees) o;
        return Objects.equals(id, attendees.id) &&
                Objects.equals(idprof, attendees.idprof) &&
                Objects.equals(name, attendees.name) &&
                Objects.equals(surname, attendees.surname) &&
                Objects.equals(phone, attendees.phone) &&
                Objects.equals(city, attendees.city) &&
                Objects.equals(postcode, attendees.postcode) &&
                Objects.equals(street, attendees.street);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, idprof, name, surname, phone, city, postcode, street);
    }
}
