package hibernate.model;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "PROFESSIONS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Id"})})
public class Profession {

    @Id @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Column(name = "profession")
    private String professionName;


    public Profession(){}

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public String getProfessionName(){return professionName;}
    public void setProfessionName(String professionName){this.professionName = professionName;}
}