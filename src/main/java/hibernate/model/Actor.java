package hibernate.model;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "ACTORs", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"first_name","last_name"})})
public class Actor {

    @Id @GeneratedValue
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