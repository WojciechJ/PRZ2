package hibernate;
import hibernate.model.Actor;
import hibernate.model.Movie;
import hibernate.model.Director;
import hibernate.model.Employee;
import hibernate.model.Movie_Cast;
import hibernate.model.Movie_Crew;
import hibernate.model.Profession;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.ZonedDateTime;

class Manager {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {


        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            //-----------------------------------ACTORS--------------------------------------
            System.out.println("\n" + ANSI_RED + "Actors: Start" + ANSI_RESET);
            entityManager.getTransaction().begin();

                Actor act1 = new Actor();
                    act1.setFirstName("Elijah");
                    act1.setLastName("Wood");
                    act1.setDate_of_birth(ZonedDateTime.parse("1981-01-28T00:00:00+01:00[Europe/Warsaw]"));
                entityManager.persist(act1);

                Actor act2 = new Actor();
                    act2.setFirstName("Viggo");
                    act2.setLastName("Mortensen");
                    act2.setDate_of_birth(ZonedDateTime.parse("1958-10-20T00:00:00+01:00[Europe/Warsaw]"));
                entityManager.persist(act2);

                Actor act3 = new Actor();
                    act3.setFirstName("Ian");
                    act3.setLastName("McKellen");
                    act3.setDate_of_birth(ZonedDateTime.parse("1939-05-25T00:00:00+01:00[Europe/Warsaw]"));
                entityManager.persist(act3);

                Actor act4 = new Actor();
                    act4.setFirstName("Andy");
                    act4.setLastName("Seriks");
                    act4.setDate_of_birth(ZonedDateTime.parse("1964-04-20T00:00:00+01:00[Europe/Warsaw]"));
                entityManager.persist(act4);

            entityManager.getTransaction().commit();
            System.out.println(ANSI_GREEN + "Actors: End" + ANSI_RESET + "\n");

            //-----------------------------------DIRECTORS--------------------------------------
            System.out.println(ANSI_RED + "Directors: Start" + ANSI_RESET);
            entityManager.getTransaction().begin();
                Director dir1 = new Director();
                    dir1.setFirstName("Peter Robert");
                    dir1.setLastName("Jackson");
                    dir1.setDate_of_birth(ZonedDateTime.parse("1961-10-31T00:00:00+01:00[Europe/Warsaw]"));
                entityManager.persist(dir1);

                Director dir2 = new Director();
                    dir2.setFirstName("Matt");
                    dir2.setLastName("Reeves");
                    dir2.setDate_of_birth(ZonedDateTime.parse("1966-04-26T00:00:00+01:00[Europe/Warsaw]"));
                entityManager.persist(dir2);
            entityManager.getTransaction().commit();
            System.out.println(ANSI_GREEN + "Directors: End" + ANSI_RESET + "\n");

            //-----------------------------------PROFESSIONS--------------------------------------
            System.out.println(ANSI_RED + "Professions: Start" + ANSI_RESET);
            entityManager.getTransaction().begin();

                Profession pro1 = new Profession();
                    pro1.setProfessionName("camera operator");
                entityManager.persist(pro1);

                Profession pro2 = new Profession();
                    pro2.setProfessionName("make-up artist");
                entityManager.persist(pro2);

                Profession pro3 = new Profession();
                    pro3.setProfessionName("stuntman");
                entityManager.persist(pro3);

            entityManager.getTransaction().commit();
            System.out.println(ANSI_GREEN + "Professions: End" + ANSI_RESET + "\n");

            //-----------------------------------EMPLOYEES--------------------------------------
            System.out.println(ANSI_RED + "Employees: Start" + ANSI_RESET);
            entityManager.getTransaction().begin();

                Employee emp1 = new Employee();
                    emp1.setFirstName("John");
                    emp1.setLastName("Dew");
                    emp1.setProfession(pro1);
                    emp1.setDateofbirth(ZonedDateTime.parse("1976-08-10T00:00:00+01:00[Europe/Warsaw]"));
                entityManager.persist(emp1);

                Employee emp2 = new Employee();
                    emp2.setFirstName("Julie");
                    emp2.setLastName("Roberts");
                    emp2.setProfession(pro2);
                    emp2.setDateofbirth(ZonedDateTime.parse("1991-11-16T00:00:00+01:00[Europe/Warsaw]"));
                entityManager.persist(emp2);

                Employee emp3 = new Employee();
                    emp3.setFirstName("Mark");
                    emp3.setLastName("House");
                    emp3.setProfession(pro3);
                    emp3.setDateofbirth(ZonedDateTime.parse("1988-07-21T00:00:00+01:00[Europe/Warsaw]"));
                entityManager.persist(emp3);

            entityManager.getTransaction().commit();
            System.out.println(ANSI_GREEN + "Employees: End" + ANSI_RESET + "\n");

            //-----------------------------------MOVIES--------------------------------------
            System.out.println(ANSI_RED + "Films: Start" + ANSI_RESET);
            entityManager.getTransaction().begin();

                Movie movie1 = new Movie();
                    movie1.setTitle("War for the Planet of the Apes");
                    movie1.setPremiereDate(ZonedDateTime.parse("2017-07-10T00:00:00+01:00[Europe/Warsaw]"));
                    movie1.setGenre("Drama, Action, Sci-Fi");
                    movie1.setBoxOffice(490664238.0);
                    movie1.setDirectorid(dir2);
                entityManager.persist(movie1);

                Movie movie2 = new Movie();
                    movie2.setTitle("The Lord of the Rings: The Return of the King ");
                    movie2.setPremiereDate(ZonedDateTime.parse("2004-01-04T00:00:00+01:00[Europe/Warsaw]"));
                    movie2.setGenre("Fanatsy, Drama, Action");
                    movie2.setBoxOffice(1119929521.0);
                    movie2.setDirectorid(dir1);
                entityManager.persist(movie2);

                Movie movie3 = new Movie();
                    movie3.setTitle("The Lord of The Rings: Two Towers");
                    movie3.setPremiereDate(ZonedDateTime.parse("2002-01-31T00:00:00+01:00[Europe/Warsaw]"));
                    movie3.setGenre("Fanatsy, Drama, Action");
                    movie3.setBoxOffice(926047111.0);
                    movie3.setDirectorid(dir1);
                entityManager.persist(movie3);

                Movie movie4 = new Movie();
                    movie4.setTitle("The Lord of the Rings: The Fellowship of the Ring");
                    movie4.setPremiereDate(ZonedDateTime.parse("2001-12-10T00:00:00+01:00[Europe/Warsaw]"));
                    movie4.setGenre("Fanatsy, Drama, Action");
                    movie4.setBoxOffice(871530324.0);
                    movie4.setDirectorid(dir1);
                entityManager.persist(movie4);

            entityManager.getTransaction().commit();
            System.out.println(ANSI_GREEN + "Films: End" + ANSI_RESET + "\n");
            //-----------------------------------CREW-------------------------------------------
            System.out.println(ANSI_RED + "Crew: Start" + ANSI_RESET);
            entityManager.getTransaction().begin();

                Movie_Crew crw1 = new Movie_Crew();
                    crw1.setFilmid(1);
                    crw1.setEmployeeid(1);
                entityManager.persist(crw1);

                Movie_Crew crw2 = new Movie_Crew();
                    crw2.setFilmid(1);
                    crw2.setEmployeeid(2);
                entityManager.persist(crw2);

                Movie_Crew crw3 = new Movie_Crew();
                    crw3.setFilmid(1);
                    crw3.setEmployeeid(3);
                entityManager.persist(crw3);

            entityManager.getTransaction().commit();
            System.out.println(ANSI_GREEN + "Crew: End" + ANSI_RESET + "\n");

            //-----------------------------------CAST-------------------------------------------
            System.out.println(ANSI_RED + "Cast: Start" + ANSI_RESET);
            entityManager.getTransaction().begin();

                Movie_Cast cc1 = new Movie_Cast();
                    cc1.setActorid(4);
                    cc1.setFilmid(1);
                entityManager.persist(cc1);

                Movie_Cast cc2 = new Movie_Cast();
                    cc2.setActorid(4);
                    cc2.setFilmid(2);
                entityManager.persist(cc2);

                Movie_Cast cc3 = new Movie_Cast();
                    cc3.setActorid(4);
                    cc3.setFilmid(3);
                entityManager.persist(cc3);

                Movie_Cast cc4 = new Movie_Cast();
                    cc4.setActorid(4);
                    cc4.setFilmid(4);
                entityManager.persist(cc4);

                Movie_Cast cc5 = new Movie_Cast();
                    cc5.setActorid(1);
                    cc5.setFilmid(1);
                entityManager.persist(cc5);

                Movie_Cast cc6 = new Movie_Cast();
                    cc6.setActorid(1);
                    cc6.setFilmid(2);
                entityManager.persist(cc6);

                Movie_Cast cc7 = new Movie_Cast();
                    cc7.setActorid(1);
                    cc7.setFilmid(3);
                entityManager.persist(cc7);

                Movie_Cast cc8 = new Movie_Cast();
                    cc8.setActorid(2);
                    cc8.setFilmid(1);
                entityManager.persist(cc8);

                Movie_Cast cc9 = new Movie_Cast();
                    cc9.setActorid(2);
                    cc9.setFilmid(2);
                entityManager.persist(cc9);

                Movie_Cast cc10 = new Movie_Cast();
                    cc10.setActorid(2);
                    cc10.setFilmid(3);
                entityManager.persist(cc10);

                Movie_Cast cc11 = new Movie_Cast();
                    cc11.setActorid(3);
                    cc11.setFilmid(3);
                entityManager.persist(cc11);

                Movie_Cast cc12 = new Movie_Cast();
                    cc12.setActorid(3);
                    cc12.setFilmid(2);
                entityManager.persist(cc12);

                Movie_Cast cc13 = new Movie_Cast();
                    cc13.setActorid(3);
                    cc13.setFilmid(1);
                entityManager.persist(cc12);

            entityManager.getTransaction().commit();

            System.out.println(ANSI_GREEN + "Cast: End" + ANSI_RESET + "\n");

            System.out.println("Done");

            entityManager.close();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            assert entityManagerFactory != null;
            entityManagerFactory.close();
        }

    }

}
