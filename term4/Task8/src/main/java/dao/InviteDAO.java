package dao;

import java.util.List;

import model.CV;
import model.Invite;
import model.Vacancy;

public interface InviteDAO extends CRUDDao<Invite> {
	
	public List<Invite> findInvitesByCv(Long cv);
	public List<Invite> findInvitesByVacancy(Long vacancy);
}
