package hibernate.model;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Cast", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Id"})})
public class Cast {

    @Id @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Column(name = "film_id")
    private Integer filmid;

    @Column(name = "actor_id")
    private Integer actorid;

    public Cast() {}

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public Integer getFilmid() { return filmid; }
    public void setFilmid (Integer filmid ) { this.filmid = filmid; }

    public Integer getActorid() { return actorid; }
    public void setActorid (Integer actorid ) { this.actorid = actorid; }


}