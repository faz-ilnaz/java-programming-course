package dao.impl;

import java.util.List;

import model.Invite;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.InviteDAO;

@Repository
public class InviteDaoImpl extends CRUDDaoImpl<Invite> implements InviteDAO {

	@Autowired
	public InviteDaoImpl(SessionFactory sessionFactory) {
		super(Invite.class, sessionFactory);
	}

	@Override
	public List<Invite> findInvitesByCv(Long cv) {
		return getSession()
				.createQuery("from Invite invite where invite.cv.id=?")
				.setParameter(0, cv).list();
	}

	@Override
	public List<Invite> findInvitesByVacancy(Long vacancy) {
		return getSession()
				.createQuery("from Invite invite where invite.vacancy.id=?")
				.setParameter(0, vacancy).list();
	}

}
