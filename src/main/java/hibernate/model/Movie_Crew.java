package hibernate.model;
import javax.persistence.*;

@Entity
@Table(name = "MOVIE_CREW", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Id"})})
public class Movie_Crew {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "film_id")
    private Integer filmid;

    @Column(name = "employee_id")
    private Integer employeeid;

    public Movie_Crew(){}

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public Integer getFilmid() { return filmid; }
    public void setFilmid (Integer filmid ) { this.filmid = filmid; }

    public Integer getEmployeeid(){ return employeeid; }
    public void setEmployeeid( Integer employeeid) { this.employeeid = employeeid; }

}