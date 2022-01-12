package ak88.minitestajax.model;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double acreage;
    private int population;
    private double GDP;
    private String introduce;
    @ManyToOne
    private Nation nation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGDP() {
        return GDP;
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public City(String name, double acreage, int population, double GDP, String introduce, Nation nation) {
        this.name = name;
        this.acreage = acreage;
        this.population = population;
        this.GDP = GDP;
        this.introduce = introduce;
        this.nation = nation;
    }

    public City(long id, String name, double acreage, int population, double GDP, String introduce, Nation nation) {
        this.id = id;
        this.name = name;
        this.acreage = acreage;
        this.population = population;
        this.GDP = GDP;
        this.introduce = introduce;
        this.nation = nation;
    }

    public City() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
