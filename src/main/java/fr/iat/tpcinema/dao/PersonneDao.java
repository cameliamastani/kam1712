package fr.iat.tpcinema.dao;



import fr.iat.tpcinema.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component

public class PersonneDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Personne p) {

        entityManager.merge(p);
    }


    @Transactional
    public void remove (Personne p) {

        entityManager.remove(p);
    }

    public List<Personne> getAll(){
        Query query = entityManager.createQuery("Select p from Personne p");
        return query.getResultList();
    }

    public Personne getById(long id){
        Personne retVal = null;
        Query query = entityManager.createQuery("select p from Personne p where p.id = :id");
        query.setParameter("id", id);
        List<Personne> persons = query.getResultList();
        if(!persons.isEmpty()){
            retVal = persons.get(0);

        }
        return retVal;
    }


}
