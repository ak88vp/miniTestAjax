package ak88.minitestajax.model;

import javax.persistence.*;

@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int bathroom;
    @ManyToOne
    private Category category;

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public Home(String name, int bathroom, Category category) {
        this.name = name;
        this.bathroom = bathroom;
        this.category = category;
    }

    public Home(Long id, String name, int bathroom, Category category) {
        this.id = id;
        this.name = name;
        this.bathroom = bathroom;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }





    public Home() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
