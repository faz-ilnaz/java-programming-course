package repository;

import model.CV;
import model.Invite;
import model.Vacancy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InviteRepository extends CrudRepository<Invite, Long> {
//    public List<Invite> findInvitesByCv(CV cv);

    @Query("select i from Invite i where i.cv=?1")
    public List<Invite> findInvitesByCv(CV cv);

    public List<Invite> findInvitesByVacancy(Vacancy vacancy);
}
