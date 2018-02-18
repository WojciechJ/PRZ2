package hibernate.queries;
import hibernate.model.Actor;
import hibernate.model.Employee;
import hibernate.model.Movie;
import hibernate.model.Director;
import hibernate.model.Movie_Cast;
import hibernate.model.Movie_Crew;
import hibernate.model.Profession;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.ZonedDateTime;
import java.util.List;

public class Queries {

    EntityManager entityManager;

    public Queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Actor> getActorList(){
        String hql = "select ac from Actor ac";
        Query result = entityManager.createQuery(hql);
        return  result.getResultList();
    }

    public List<Movie_Cast> CountActorsByMovieId(int movie_id) {
        String hql = "Select count(mc) from Movie_Cast mc where mc.movie_id = ?";
        Query result = entityManager.createQuery(hql).setParameter(0,movie_id);
        return result.getResultList();

    }

    public List<Profession> getProfessionIdByName(String name, String surname) {
        String hql = "Select emp.profession from  Employee emp  where emp.firstName = ? and emp.lastName = ? ";
        Query result = entityManager.createQuery(hql).setParameter(0,name).setParameter(1,surname);
        return result.getResultList();

    }
    public List<Movie> getNumberOfMoviesBetween(ZonedDateTime start, ZonedDateTime end){


        String hql = "Select count(mov) from Movie mov where mov.premiereDate between ? and ? ";
        Query result = entityManager.createQuery(hql).setParameter(0, start).setParameter(1,end);
        return result.getResultList();
    }

    public List<Movie> getMoviesByPage(int pagenr) {
        Query queryTotal = entityManager.createQuery
                ("Select count(m1) from Movie m1");
        long countResult = (long)queryTotal.getSingleResult();
        Query query = entityManager.createQuery("Select m2 FROM Movie m2");
        int pageSize = 2;
        int pageNumber = (int) ((countResult / pageSize) + 1);

        if (pagenr > pageNumber) pagenr = pageNumber;
        query.setFirstResult((pagenr-1) * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

}
