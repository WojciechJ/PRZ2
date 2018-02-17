package hibernate;

import hibernate.model.Actor;
import hibernate.model.Film;
import hibernate.queries.Queries;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
            Actor act = new Actor();
            act.setFirstName("Janusz");
            act.setLastName("Aktor" + new Random().nextInt());
            act.setDate_of_birth(ZonedDateTime.parse("1992-12-03"));

            Actor act2 = new Actor();
            act2.setFirstName("Janusz");
            act2.setLastName("Aktor" + new Random().nextInt());
            act2.setDate_of_birth(ZonedDateTime.parse("1992-12-03"));

            //save
            entityManager.persist(act);
            entityManager.persist(act2);

            //add films
            Film film = new Film();
            film.setTitle("The Lord of The Rings: Two Towers");
            film.setPremiereDate(ZonedDateTime.parse("2002-01-31"));
            film.setDirector(1);
            film.setGenre("Fanatsy, Drama, Action");
            film.setBoxOffice(2557391.17);

            Film film2 = new Film();
            film.setTitle("The Lord of the Rings: The Return of the King ");
            film.setPremiereDate(ZonedDateTime.parse("2004-01-04"));
            film.setDirector(1);
            film.setGenre("Fanatsy, Drama, Action");
            film.setBoxOffice(5957381.19);

            //save
            entityManager.persist(film);
            entityManager.persist(film2);


            Actor actor = entityManager.find(Actor.class, act.getId());
            if (actor == null) {
                System.out.println(act.getId() + " not found! ");
            } else {
                System.out.println("Found: " + actor);
            }

            System.out.println("Actor: " + actor.getId() + " " + actor.getFirstName() + actor.getLastName());

           // changeFirstGuyToNowak(entityManager);

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

    // read a page of empleyees and change first one to Nowak
    //static void changeFirstGuyToNowak(EntityManager entityManager) {

      //  Query query = entityManager.createQuery("SELECT k FROM Employee k");
     //   List<Actor> actors = new Queries(entityManager).getAllEmployeeByPage(1);

     //   actors.get(0).setLastName("NowakPRE" + new Random().nextInt());

    }

}