package hibernate.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MOVIE_CREW", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Id"})})
public class Movie_Crew {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<Movie_Crew> employeesid = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<Movie_Crew> moviesid = new ArrayList<>();

    public Movie_Crew(){}

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public List<Movie_Crew> getMovieId(){ return moviesid; }
    public void setMovieId( List<Movie_Crew> moviesid) { this.moviesid = moviesid; }


    public List<Movie_Crew> getEmployeeid(){ return employeesid; }
    public void setEmployeeid( List<Movie_Crew> employeesid) { this.employeesid = employeesid; }

}