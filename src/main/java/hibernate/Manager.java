package hibernate;
import hibernate.model.Actor;
import hibernate.model.Movie;
import hibernate.model.Director;
import hibernate.model.Employee;
import hibernate.model.Movie_Cast;
import hibernate.model.Movie_Crew;
import hibernate.model.Profession;
import hibernate.queries.Queries;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;

class Manager {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void main(String[] args) {


        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            System.out.println("\n"+ ANSI_RED_BACKGROUND + ANSI_BLACK +"Data insertion start"+ ANSI_RESET + "\n");
            //-----------------------------------ACTORS--------------------------------------
            System.out.println(ANSI_RED + "Actors: Start" + ANSI_RESET);
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
            System.out.println(ANSI_GREEN + "Actors: Complete" + ANSI_RESET + "\n");

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
            System.out.println(ANSI_GREEN + "Directors: Complete" + ANSI_RESET + "\n");

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
            System.out.println(ANSI_GREEN + "Professions: Complete" + ANSI_RESET + "\n");

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
            System.out.println(ANSI_GREEN + "Employees: Complete" + ANSI_RESET + "\n");

            //-----------------------------------MOVIES--------------------------------------
            System.out.println(ANSI_RED + "Movies: Start" + ANSI_RESET);
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
            System.out.println(ANSI_GREEN + "Movies: Complete" + ANSI_RESET + "\n");
            //-----------------------------------CREW-------------------------------------------
            System.out.println(ANSI_RED + "Crew: Start" + ANSI_RESET);
            entityManager.getTransaction().begin();

            Movie_Crew crw1 = new Movie_Crew();
            movie1.getMovie().add(crw1);
            emp1.getEmployee().add(crw1);
            entityManager.persist(crw1);

            Movie_Crew crw2 = new Movie_Crew();
            movie1.getMovie().add(crw2);
            emp2.getEmployee().add(crw2);
            entityManager.persist(crw2);

            Movie_Crew crw3 = new Movie_Crew();
            movie1.getMovie().add(crw3);
            emp3.getEmployee().add(crw2);
            entityManager.persist(crw3);

            entityManager.getTransaction().commit();
            System.out.println(ANSI_GREEN + "Crew: Complete" + ANSI_RESET + "\n");

            //-----------------------------------CAST-------------------------------------------
            System.out.println(ANSI_RED + "Cast: Start" + ANSI_RESET);
            entityManager.getTransaction().begin();

            Movie_Cast cc1 = new Movie_Cast();
            cc1.setActorid(4);
            cc1.setMovie_id(1);
            entityManager.persist(cc1);

            Movie_Cast cc2 = new Movie_Cast();
            cc2.setActorid(4);
            cc2.setMovie_id(2);
            entityManager.persist(cc2);

            Movie_Cast cc3 = new Movie_Cast();
            cc3.setActorid(4);
            cc3.setMovie_id(3);
            entityManager.persist(cc3);

            Movie_Cast cc4 = new Movie_Cast();
            cc4.setActorid(4);
            cc4.setMovie_id(4);
            entityManager.persist(cc4);

            Movie_Cast cc5 = new Movie_Cast();
            cc5.setActorid(1);
            cc5.setMovie_id(1);
            entityManager.persist(cc5);

            Movie_Cast cc6 = new Movie_Cast();
            cc6.setActorid(1);
            cc6.setMovie_id(2);
            entityManager.persist(cc6);

            Movie_Cast cc7 = new Movie_Cast();
            cc7.setActorid(1);
            cc7.setMovie_id(3);
            entityManager.persist(cc7);

            Movie_Cast cc8 = new Movie_Cast();
            cc8.setActorid(2);
            cc8.setMovie_id(1);
            entityManager.persist(cc8);

            Movie_Cast cc9 = new Movie_Cast();
            cc9.setActorid(2);
            cc9.setMovie_id(2);
            entityManager.persist(cc9);

            Movie_Cast cc10 = new Movie_Cast();
            cc10.setActorid(2);
            cc10.setMovie_id(3);
            entityManager.persist(cc10);

            Movie_Cast cc11 = new Movie_Cast();
            cc11.setActorid(3);
            cc11.setMovie_id(3);
            entityManager.persist(cc11);

            Movie_Cast cc12 = new Movie_Cast();
            cc12.setActorid(3);
            cc12.setMovie_id(2);
            entityManager.persist(cc12);

            Movie_Cast cc13 = new Movie_Cast();
            cc13.setActorid(3);
            cc13.setMovie_id(1);
            entityManager.persist(cc12);



            System.out.println(ANSI_GREEN + "Cast: Complete" + ANSI_RESET + "\n");

            System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK  + "Data insertion: Complete"+ ANSI_RESET + "\n");

            //-------------------------------------QUERIES-------------------------------------------

            System.out.println("\n"+ANSI_CYAN_BACKGROUND + ANSI_BLACK+"Queries: Start"+ ANSI_RESET + "\n");



            System.out.println(ANSI_YELLOW+"Current title: " + movie1.getTitle() + "\n");
            System.out.println(ANSI_RED + "Change title to Hobbit"+ ANSI_RESET);
            ChangeMovieTitle(entityManager);

            System.out.println(ANSI_RED + "Count actors in Lord of The Rings Two Towers"+ ANSI_RESET);
            CountActorsForSelectedMovie(entityManager);

            System.out.println(ANSI_RED + "Profession of John Dew"+ ANSI_RESET);
            ProfessionOfSelectedEmployee(entityManager);

            System.out.println(ANSI_RED + "Number of movies between 2000 and 2003"+ ANSI_RESET);
            NumberOfMoviesBetween(entityManager);




            System.out.println(ANSI_RESET + ANSI_CYAN_BACKGROUND + ANSI_BLACK + "Queries: Complete"+ ANSI_RESET + "\n");


            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            assert entityManagerFactory != null;
            entityManagerFactory.close();
        }

    }



    static void ChangeMovieTitle(EntityManager entityManager) {
        System.out.println("-------");
        List<Movie> movies = new Queries(entityManager).getMoviesByPage(1);
        movies.get(0).setTitle("Hobbit");
        System.out.println("-------");
        System.out.println(ANSI_GREEN +"Title changed to: " + movies.get(0).getTitle()+ ANSI_RESET);
        System.out.println("-------");
    }

    static void CountActorsForSelectedMovie(EntityManager entityManager) {
        System.out.println("-------");
        List<Movie_Cast> number = new Queries(entityManager).CountActorsByMovieId(3);
        System.out.println("-------");
        System.out.println(ANSI_GREEN +"Actors in Lord of The Rings Two Towers: "+ number.get(0)+ ANSI_RESET);
        System.out.println("-------");
    }

    static void ProfessionOfSelectedEmployee(EntityManager entityManager) {
        System.out.println("-------");
        List<Profession> profession_id = new Queries(entityManager).getProfessionIdByName("John", "Dew");
        System.out.println("-------");
        System.out.println(ANSI_GREEN +"Profession name: " + profession_id.get(0).getProfessionName()+ ANSI_RESET);
        System.out.println("-------");
    }

    static void NumberOfMoviesBetween(EntityManager entityManager){
        System.out.println("-------");
        List<Movie> movies = new Queries(entityManager).getNumberOfMoviesBetween(ZonedDateTime.parse("2000-01-01T00:00:00+01:00[Europe/Warsaw]"),ZonedDateTime.parse( "2003-12-31T23:59:59+01:00[Europe/Warsaw]"));
        System.out.println("-------");
        System.out.println(ANSI_GREEN +"Number of movies between 2000 and 2001: " + movies.get(0) + ANSI_RESET);
        System.out.println("-------");
    }


    }


