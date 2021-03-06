package hibernate.model;
import javax.persistence.*;
import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.*;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="id", scope=Actor.class)
@Entity
@Table(name = "ACTORS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Id"})})
public class Actor {

    @JsonIgnore
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private ZonedDateTime dateofbirth;


    public Actor() {}

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName( String first_name ) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName( String last_name ) {
        this.lastName = last_name;
    }

    public ZonedDateTime getDate_of_Birth() {
        return dateofbirth;
    }
    public void setDate_of_birth( ZonedDateTime dateofbirth ) {
        this.dateofbirth = dateofbirth;
    }



}