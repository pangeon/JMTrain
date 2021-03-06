package san.jee.cecherz.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

public class Subscriptions {
    private BigInteger id;
    private BigInteger idcour;
    private BigInteger idworkpl;
    private BigInteger idattend;
    private Timestamp regstamp;
    private Courses course;
    private Workplaces workplaces;
    private Attendees attendee;

    public Subscriptions() {}

    public Subscriptions(Subscriptions s)
    {
        this.id = s.id;
        this.idcour = s.idcour;
        this.idworkpl = s.idworkpl;
        this.idattend = s.idattend;
        this.regstamp = s.regstamp;
        this.course = s.course;
        this.workplaces = s.workplaces;
        this.attendee = s.attendee;
    }
    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }
    public BigInteger getIdcour() {
        return idcour;
    }
    public void setIdcour(BigInteger idcour) {
        this.idcour = idcour;
    }
    public BigInteger getIdworkpl() {
        return idworkpl;
    }
    public void setIdworkpl(BigInteger idworkpl) {
        this.idworkpl = idworkpl;
    }
    public BigInteger getIdattend() {
        return idattend;
    }
    public void setIdattend(BigInteger idattend) {
        this.idattend = idattend;
    }
    public Timestamp getRegstamp() {
        return regstamp;
    }
    public void setRegstamp(Timestamp regstamp) {
        this.regstamp = regstamp;
    }
    public Courses getCourse() {
        return course;
    }
    public void setCourse(Courses course) {
        this.course = course;
    }
    public Workplaces getWorkplace() {
        return workplaces;
    }
    public void setWorkplace(Workplaces workplaces) {
        this.workplaces = workplaces;
    }
    public Attendees getAttendee() {
        return attendee;
    }
    public void setAttendee(Attendees attendee) {
        this.attendee = attendee;
    }
    @Override
    public String toString() {
        return "Subscriptions{" +
                "id=" + id +
                ", idcour=" + idcour +
                ", idworkpl=" + idworkpl +
                ", idattend=" + idattend +
                ", regstamp=" + regstamp +
                ", course=" + course +
                ", workplace=" + workplaces +
                ", attendee=" + attendee +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriptions that = (Subscriptions) o;
        return id.equals(that.id) &&
                idcour.equals(that.idcour) &&
                idworkpl.equals(that.idworkpl) &&
                idattend.equals(that.idattend) &&
                regstamp.equals(that.regstamp) &&
                course.equals(that.course) &&
                workplaces.equals(that.workplaces) &&
                attendee.equals(that.attendee);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, idcour, idworkpl, idattend, regstamp, course, workplaces, attendee);
    }
}
