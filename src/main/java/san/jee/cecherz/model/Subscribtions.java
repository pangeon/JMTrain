package san.jee.cecherz.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

public class Subscribtions {
    private BigInteger id;
    private BigInteger idcour;
    private BigInteger idworkpl;
    private BigInteger idattend;
    private Timestamp regstamp;

    public Subscribtions() {}

    public Subscribtions(BigInteger id, BigInteger idcour, BigInteger idworkpl,
                         BigInteger idattend, Timestamp regstamp)
    {
        this.id = id;
        this.idcour = idcour;
        this.idworkpl = idworkpl;
        this.idattend = idattend;
        this.regstamp = regstamp;
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

    @Override
    public String toString() {
        return "Subscribtions{" +
                "id=" + id +
                ", idcour=" + idcour +
                ", idworkpl=" + idworkpl +
                ", idattend=" + idattend +
                ", regstamp=" + regstamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscribtions that = (Subscribtions) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(idcour, that.idcour) &&
                Objects.equals(idworkpl, that.idworkpl) &&
                Objects.equals(idattend, that.idattend) &&
                Objects.equals(regstamp, that.regstamp);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, idcour, idworkpl, idattend, regstamp);
    }
}
