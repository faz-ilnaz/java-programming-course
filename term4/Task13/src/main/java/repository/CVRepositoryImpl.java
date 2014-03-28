package repository;

import model.CV;
import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;

@Repository
public class CVRepositoryImpl implements CVRepositoryCustom, CVRepositoryNew {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Long getIdsByTitle(String title) {
        return ((BigInteger)entityManager.createNativeQuery("SELECT id FROM cv WHERE title=?1").
                setParameter(1, title).getSingleResult()).longValue();
    }

    @Override
    public List<CV> findCVsByOwner(User owner) {
        return entityManager.createQuery("SELECT c FROM CV c WHERE c.owner = ?1").setParameter(1, owner).getResultList();
    }
}
