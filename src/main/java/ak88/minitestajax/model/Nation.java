package ak88.minitestajax.model;

import javax.persistence.*;

@Entity
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nation(String name) {
        this.name = name;
    }

    public Nation(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Nation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
