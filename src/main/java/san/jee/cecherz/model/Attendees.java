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
    private Profiles profiles;

    public Attendees() {};

    public Attendees(Attendees a)
    {
        this.id = a.id;
        this.idprof = a.idprof;
        this.name = a.name;
        this.surname = a.surname;
        this.phone = a.phone;
        this.city = a.city;
        this.postcode = a.postcode;
        this.street = a.street;
        this.profiles = a.profiles;
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

    public Profiles getProfiles() {
        return profiles;
    }

    public void setProfiles(Profiles profiles) {
        this.profiles = profiles;
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
                ", profiles=" + profiles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendees attendees = (Attendees) o;
        return id.equals(attendees.id) &&
                idprof.equals(attendees.idprof) &&
                name.equals(attendees.name) &&
                surname.equals(attendees.surname) &&
                phone.equals(attendees.phone) &&
                city.equals(attendees.city) &&
                postcode.equals(attendees.postcode) &&
                street.equals(attendees.street) &&
                profiles.equals(attendees.profiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idprof, name, surname, phone, city, postcode, street, profiles);
    }
}
