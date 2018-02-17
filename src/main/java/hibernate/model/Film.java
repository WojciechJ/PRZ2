package hibernate.model;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "FILMS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Film {

    @Id @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "premiere_date")
    private ZonedDateTime premiereDate;

    @Column(name = "directorid")
    private Integer directorid;

    @Column(name = "genre")
    private String genre;

    @Column(name = "box_office")
    private Double boxOffice;


    public Film() {}

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle( String title ) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre( String genre ){ this.genre = genre; }

    public Double getBoxOffice() { return boxOffice; }
    public void setBoxOffice( Double boxOffice ) { this.boxOffice = boxOffice; }

    public ZonedDateTime getPremiereDate() {
        return premiereDate;
    }
    public void setPremiereDate( ZonedDateTime premiereDate ) {
        this.premiereDate = premiereDate;
    }

    public Integer getDirectorid(){ return directorid; }
    public void setDirectorid( Integer directorid) { this.directorid = directorid; }



}