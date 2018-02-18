package hibernate.model;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.*;


@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="id", scope=Employee.class)
@Entity
@Table(name = "EMPLOYEES", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Id"})})
public class Employee {

    @JsonIgnore
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @Column(name = "date_of_birth")
    private ZonedDateTime dateofbirth;

    @Column(name = "salary")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profession", referencedColumnName = "id")
    Profession profession;

    @ManyToMany(fetch = FetchType.EAGER ,mappedBy = "employeesid",cascade = CascadeType.ALL)
    private List<Movie_Crew> employees= new ArrayList<>();

    public List<Movie_Crew> getEmployee(){ return employees; }
    public void setEmployee( List<Movie_Crew> employees) { this.employees = employees; }

    public Employee(){}

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

    public ZonedDateTime getDateofbirth() {
        return dateofbirth;
    }
    public void setDateofbirth( ZonedDateTime dateofbirth ) {
        this.dateofbirth = dateofbirth;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary( int salary ) {
        this.salary = salary;
    }



    public Profession getProfession(){return profession;}
    public void setProfession(Profession profession){this.profession = profession;}



}