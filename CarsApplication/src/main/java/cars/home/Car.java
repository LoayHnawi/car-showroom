package cars.home;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import cars.repository.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="num_disk")
    private Integer num_disk;

    @OneToMany(targetEntity = Parameter.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fid", referencedColumnName = "id")
    List<Parameter> parameters =new ArrayList<>();

    public Car() {}
    public Car(String name, double price, Integer num_disk) {
        this.name = name;
        this.price = price;
        this.num_disk = num_disk;
    }

    public Car(Integer id, String name, double price, Integer num_disk) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num_disk = num_disk;
    }

    public Car(String name, double price, Integer num_disk, List<Parameter> parameters) {
        this.name = name;
        this.price = price;
        this.num_disk = num_disk;
        this.parameters = parameters;
    }

    public Car(Integer id, String name, double price, Integer num_disk, List<Parameter> parameters) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num_disk = num_disk;
        this.parameters = parameters;
    }

    public Car(List<Parameter> parameters)
    {
     this.setNum_disk(parameters.get(1).getValue());
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum_disk(Integer num_disk) {
        this.num_disk = num_disk;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Integer getNum_disk() {
        return num_disk;
    }

    public String getName() {
        return name;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Car"+ id + " [ Name=" + name +" "+ ",Price="+ price + " "+ ",NumDisk="+ num_disk+ " ]  " ;
    }

}
