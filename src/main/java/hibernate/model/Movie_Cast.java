package hibernate.model;
import javax.persistence.*;

@Entity
@Table(name = "MOVIE_CAST", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Id"})})
public class Movie_Cast {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "movie_id")
    private Integer movie_id;

    @Column(name = "actor_id")
    private Integer actor_id;

    public Movie_Cast(){}

    public int getId() { return id; }
    public void setId( int id ) { this.id = id; }

    public Integer getMovie_id() { return movie_id; }
    public void setMovie_id (Integer movie_id ) { this.movie_id = movie_id; }

    public Integer getActorid(){ return actor_id; }
    public void setActorid( Integer actor_id) { this.actor_id = actor_id; }

}