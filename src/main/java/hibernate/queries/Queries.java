package hibernate.queries;
import hibernate.model.Actor;
import hibernate.model.Film;
import hibernate.model.Director;
import hibernate.model.Cast;
import hibernate.model.Crew;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Queries {

    EntityManager entityManager;

    public Queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Actor> getActorByName(String name) {
        TypedQuery<Actor> query = entityManager.createQuery(
                "SELECT c FROM Actor c WHERE c.lastName LIKE :name", Actor.class);
        return query.setParameter("name", name).getResultList();
    }


}
