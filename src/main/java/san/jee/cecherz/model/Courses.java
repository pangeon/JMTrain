package san.jee.cecherz.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

public class Courses {
    private BigInteger id;
    private BigInteger trainer;
    private String title;
    private Timestamp start_date;
    private Timestamp end_date;
    private String describtion;
    private Integer max_attende;

    public Courses() {}

    public Courses(BigInteger id, BigInteger trainer, String title,
                   Timestamp start_date, Timestamp end_date,
                   String describtion, Integer max_attende)
    {
        this.id = id;
        this.trainer = trainer;
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.describtion = describtion;
        this.max_attende = max_attende;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getTrainer() {
        return trainer;
    }

    public void setTrainer(BigInteger trainer) {
        this.trainer = trainer;
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

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
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
                ", trainer=" + trainer +
                ", title='" + title + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", describtion='" + describtion + '\'' +
                ", max_attende=" + max_attende +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courses courses = (Courses) o;
        return Objects.equals(id, courses.id) &&
                Objects.equals(trainer, courses.trainer) &&
                Objects.equals(title, courses.title) &&
                Objects.equals(start_date, courses.start_date) &&
                Objects.equals(end_date, courses.end_date) &&
                Objects.equals(describtion, courses.describtion) &&
                Objects.equals(max_attende, courses.max_attende);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, trainer, title, start_date, end_date, describtion, max_attende);
    }
}
