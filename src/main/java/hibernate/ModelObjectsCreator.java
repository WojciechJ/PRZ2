package hibernate;
import hibernate.model.Actor;
import hibernate.model.Employee;
import hibernate.model.Profession;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ModelObjectsCreator {

    Employee emp1;
    Employee emp2;
    Employee emp3;

    Actor act1;
    Actor act2;
    Actor act3;
    Actor act4;

    List<Employee> employees;
    List<Actor> actors;

    public void init(){


        act1 = new Actor();
        act1.setFirstName("Elijah");
        act1.setLastName("Wood");
        //act1.setDate_of_birth(ZonedDateTime.parse("1981-01-28T00:00:00+01:00[Europe/Warsaw]"));

        act2 = new Actor();
        act2.setFirstName("Viggo");
        act2.setLastName("Mortensen");
        //act2.setDate_of_birth(ZonedDateTime.parse("1958-10-20T00:00:00+01:00[Europe/Warsaw]"));

        act3 = new Actor();
        act3.setFirstName("Ian");
        act3.setLastName("McKellen");
        //act3.setDate_of_birth(ZonedDateTime.parse("1939-05-25T00:00:00+01:00[Europe/Warsaw]"));

        act4 = new Actor();
        act4.setFirstName("Andy");
        act4.setLastName("Seriks");
        //act4.setDate_of_birth(ZonedDateTime.parse("1964-04-20T00:00:00+01:00[Europe/Warsaw]"));

        actors = new ArrayList<Actor>();
        actors.add(act1);
        actors.add(act2);
        actors.add(act3);
        actors.add(act4);


        Profession pro1 = new Profession();
        pro1.setProfessionName("camera operator");

        Profession pro2 = new Profession();
        pro2.setProfessionName("make-up artist");

        Profession pro3 = new Profession();
        pro3.setProfessionName("stuntman");


        emp1 = new Employee();
        emp1.setFirstName("John");
        emp1.setLastName("Dew");
        emp1.setProfession(pro1);
        emp1.setSalary(1500);
        emp1.setDateofbirth(ZonedDateTime.parse("1976-08-10T00:00:00+01:00[Europe/Warsaw]"));

        emp2 = new Employee();
        emp2.setFirstName("Julie");
        emp2.setLastName("Roberts");
        emp2.setProfession(pro2);
        emp2.setSalary(2000);
        emp2.setDateofbirth(ZonedDateTime.parse("1991-11-16T00:00:00+01:00[Europe/Warsaw]"));

        emp3 = new Employee();
        emp3.setFirstName("Mark");
        emp3.setLastName("House");
        emp3.setProfession(pro3);
        emp3.setSalary(2500);
        emp3.setDateofbirth(ZonedDateTime.parse("1988-07-21T00:00:00+01:00[Europe/Warsaw]"));


        employees = new ArrayList<Employee>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

    }

    public ModelObjectsCreator(){
        init();
    }


}
