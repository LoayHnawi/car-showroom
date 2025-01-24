package cars.home;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="sell")
public class Sell {

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
        @Column(name="sell_price")
        private double sell_price;
        @Column(name="name_buyer")
        private String name_buyer;

    @OneToMany(targetEntity = Parameter.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "sp_fid", referencedColumnName = "id")
    List<Parameter> parameters =new ArrayList<>();

    public Sell() {}

    public Sell(double sell_price, String name_buyer) {
        this.sell_price = sell_price;
        this.name_buyer = name_buyer;
    }

    public Sell(Integer id, String name, double price, Integer num_disk, double sell_price, String name_buyer, List<Parameter> parameters) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num_disk = num_disk;
        this.sell_price = sell_price;
        this.name_buyer = name_buyer;
        this.parameters = parameters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getNum_disk() {
        return num_disk;
    }

    public void setNum_disk(Integer num_disk) {
        this.num_disk = num_disk;
    }

    public double getSell_price() {
        return sell_price;
    }

    public void setSell_price(double sell_price) {
        this.sell_price = sell_price;
    }

    public String getName_buyer() {
        return name_buyer;
    }

    public void setName_buyer(String name_buyer) {
        this.name_buyer = name_buyer;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
