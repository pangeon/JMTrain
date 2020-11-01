package san.jee.cecherz.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

public class Courses {
    private BigInteger id;
    private String title;
    private Timestamp start_date;
    private Timestamp end_date;
    private String description;
    private Integer max_attende;

    public Courses() {}
    public Courses(BigInteger id) {
        this.id = id;
    }

    public Courses(BigInteger id, BigInteger trainer, String title,
                   Timestamp start_date, Timestamp end_date,
                   String description, Integer max_attende)
    {
        this.id = id;
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.max_attende = max_attende;
    }
    public Courses(Courses c) {
        this.id = c.id;
        this.title = c.title;
        this.start_date = c.start_date;
        this.end_date = c.end_date;
        this.description = c.description;
        this.max_attende = c.max_attende;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMax_attende() {
        return max_attende;
    }

    public void setMax_attende(Integer max_attende) {
        this.max_attende = max_attende;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", describtion='" + description + '\'' +
                ", max_attende=" + max_attende +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courses courses = (Courses) o;
        return Objects.equals(id, courses.id) &&
                Objects.equals(title, courses.title) &&
                Objects.equals(start_date, courses.start_date) &&
                Objects.equals(end_date, courses.end_date) &&
                Objects.equals(description, courses.description) &&
                Objects.equals(max_attende, courses.max_attende);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, title, start_date, end_date, description, max_attende);
    }
}
