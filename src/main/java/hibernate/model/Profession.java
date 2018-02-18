package hibernate.model;
import javax.persistence.*;

@Entity
@Table(name = "PROFESSIONS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Id"})})
public class Profession {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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