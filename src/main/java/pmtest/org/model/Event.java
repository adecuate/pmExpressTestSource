package pmtest.org.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table (name = "team")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;
    @Column (name = "nameEvent")
    private String nameEvent;
    @Column (name = "kefEvent")
    private int kefEvent;
    @Column (name = "loseEvent")
    private String loseEvent;
    @Column (name = "backEvent")
    private String backEvent;
    @Column (name = "sumEvent")
    private String sumEvent;

    public Event() {
    }



    @Override
    public String toString() {
        return "Event [nameEvent=" + nameEvent +
                        ", kefEvent=" + kefEvent +
                        ", loseEvent=" + loseEvent +
                        ", backEvent=" + backEvent +
                        ", SumEvent=" + sumEvent+"]";
    }
}
