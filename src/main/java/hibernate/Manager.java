package hibernate;
import hibernate.model.Actor;
import hibernate.model.Film;
import hibernate.model.Director;
import hibernate.model.Employee;
import hibernate.model.Film_Crew;
import hibernate.model.Film_Cast;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.ZonedDateTime;


class Manager {

    public static void main(String[] args) {

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            //add actors
            Actor act1 = new Actor();
            act1.setFirstName("Elijah");
            act1.setLastName("Wood");
            act1.setDate_of_birth(ZonedDateTime.parse("1981-01-28T00:00:00+01:00[Europe/Warsaw]"));

            Actor act2 = new Actor();
            act2.setFirstName("Viggo");
            act2.setLastName("Mortensen");
            act2.setDate_of_birth(ZonedDateTime.parse("1958-10-20T00:00:00+01:00[Europe/Warsaw]"));

            Actor act3 = new Actor();
            act3.setFirstName("Ian");
            act3.setLastName("McKellen");
            act3.setDate_of_birth(ZonedDateTime.parse("1939-05-25T00:00:00+01:00[Europe/Warsaw]"));

            Actor act4 = new Actor();
            act4.setFirstName("Andy");
            act4.setLastName("Seriks");
            act4.setDate_of_birth(ZonedDateTime.parse("1964-04-20T00:00:00+01:00[Europe/Warsaw]"));

            //save actors
            entityManager.persist(act1);
            entityManager.persist(act2);
            entityManager.persist(act3);
            entityManager.persist(act4);

            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();
            //add directors
            Director dir1 = new Director();
            dir1.setFirstName("Peter Robert");
            dir1.setLastName("Jackson");
            dir1.setDate_of_birth(ZonedDateTime.parse("1961-10-31T00:00:00+01:00[Europe/Warsaw]"));

            Director dir2 = new Director();
            dir2.setFirstName("Matt");
            dir2.setLastName("Reeves");
            dir2.setDate_of_birth(ZonedDateTime.parse("1966-04-26T00:00:00+01:00[Europe/Warsaw]"));

            //save directors
            entityManager.persist(dir1);
            entityManager.persist(dir2);
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();
            //add employees
            Employee emp1 = new Employee();
            emp1.setFirstName("John");
            emp1.setLastName("Dew");
            emp1.setProfession("camera operator");
            emp1.setDateofbirth(ZonedDateTime.parse("1976-08-10T00:00:00+01:00[Europe/Warsaw]"));
            Employee emp2 = new Employee();
            emp2.setFirstName("Julie");
            emp2.setLastName("Roberts");
            emp2.setProfession("make-up artist");
            emp2.setDateofbirth(ZonedDateTime.parse("1991-11-16T00:00:00+01:00[Europe/Warsaw]"));
            Employee emp3 = new Employee();
            emp3.setFirstName("Mark");
            emp3.setLastName("House");
            emp3.setProfession("stuntman");
            emp3.setDateofbirth(ZonedDateTime.parse("1988-07-21T00:00:00+01:00[Europe/Warsaw]"));

            //save employees
            entityManager.persist(emp1);
            entityManager.persist(emp2);
            entityManager.persist(emp3);
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();
            //add films
            Film film1 = new Film();
            film1.setTitle("War for the Planet of the Apes");
            film1.setPremiereDate(ZonedDateTime.parse("2017-07-10T00:00:00+01:00[Europe/Warsaw]"));
            film1.setGenre("Drama, Action, Sci-Fi");
            film1.setBoxOffice(490664238.0);

            Film film2 = new Film();
            film2.setTitle("The Lord of the Rings: The Return of the King ");
            film2.setPremiereDate(ZonedDateTime.parse("2004-01-04T00:00:00+01:00[Europe/Warsaw]"));
            film2.setGenre("Fanatsy, Drama, Action");
            film2.setBoxOffice(1119929521.0);

            Film film3 = new Film();
            film3.setTitle("The Lord of The Rings: Two Towers");
            film3.setPremiereDate(ZonedDateTime.parse("2002-01-31T00:00:00+01:00[Europe/Warsaw]"));
            film3.setGenre("Fanatsy, Drama, Action");
            film3.setBoxOffice(926047111.0);

            Film film4 = new Film();
            film4.setTitle("The Lord of the Rings: The Fellowship of the Ring");
            film4.setPremiereDate(ZonedDateTime.parse("2001-12-10T00:00:00+01:00[Europe/Warsaw]"));
            film4.setGenre("Fanatsy, Drama, Action");
            film4.setBoxOffice(871530324.0);

            //save films
            entityManager.persist(film1);
            entityManager.persist(film2);
            entityManager.persist(film3);
            entityManager.persist(film4);
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();
            //add crew
            Film_Crew crw1 = new Film_Crew();
            crw1.setFilmid(1);
            crw1.setEmployeeid(1);

            Film_Crew crw2 = new Film_Crew();
            crw2.setFilmid(1);
            crw2.setEmployeeid(2);

            Film_Crew crw3 = new Film_Crew();
            crw3.setFilmid(1);
            crw3.setEmployeeid(3);

            //save crew
            entityManager.persist(crw1);
            entityManager.persist(crw2);
            entityManager.persist(crw3);
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();
            //add cast
            Film_Cast cc1 = new Film_Cast();
            cc1.setActorid(4);
            cc1.setFilmid(1);
            Film_Cast cc2 = new Film_Cast();
            cc2.setActorid(4);
            cc2.setFilmid(2);
            Film_Cast cc3 = new Film_Cast();
            cc3.setActorid(4);
            cc3.setFilmid(3);
            Film_Cast cc4 = new Film_Cast();
            cc4.setActorid(4);
            cc4.setFilmid(4);
            Film_Cast cc5 = new Film_Cast();
            cc5.setActorid(1);
            cc5.setFilmid(1);
            Film_Cast cc6 = new Film_Cast();
            cc6.setActorid(1);
            cc6.setFilmid(2);
            Film_Cast cc7 = new Film_Cast();
            cc7.setActorid(1);
            cc7.setFilmid(3);
            Film_Cast cc8 = new Film_Cast();
            cc8.setActorid(2);
            cc8.setFilmid(1);
            Film_Cast cc9 = new Film_Cast();
            cc9.setActorid(2);
            cc9.setFilmid(2);
            Film_Cast cc10 = new Film_Cast();
            cc10.setActorid(2);
            cc10.setFilmid(3);
            Film_Cast cc11 = new Film_Cast();
            cc11.setActorid(3);
            cc11.setFilmid(3);
            Film_Cast cc12 = new Film_Cast();
            cc12.setActorid(3);
            cc12.setFilmid(2);
            Film_Cast cc13 = new Film_Cast();
            cc13.setActorid(3);
            cc13.setFilmid(1);

            //save cast
            entityManager.persist(cc1);
            entityManager.persist(cc2);
            entityManager.persist(cc3);
            entityManager.persist(cc4);
            entityManager.persist(cc5);
            entityManager.persist(cc6);
            entityManager.persist(cc7);
            entityManager.persist(cc8);
            entityManager.persist(cc9);
            entityManager.persist(cc10);
            entityManager.persist(cc11);
            entityManager.persist(cc12);
            entityManager.persist(cc13);

            entityManager.getTransaction().commit();


            System.out.println("Done");

            entityManager.close();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }

}
