package cars.home;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="parameters")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name = "keyPar")
    private String  keyPar;
    @Column(name="value")
    private Integer value;

    Parameter() {}

    public Parameter(Integer id, String keyPar, int value) {
        this.id = id;
        this.keyPar = keyPar;
        this.value = value;
    }

    public Parameter(String keyPar, Integer value) {

        this.keyPar = keyPar;
        this.value = value;
    }


    public Integer getIdPar() {
        return id;
    }

    public void setIdPar(Integer idPar) {
        this.id = idPar;
    }

    public String getKeyPar() {
        return keyPar;
    }

    public void setKeyPar(String keyPar) {
        this.keyPar = keyPar;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
