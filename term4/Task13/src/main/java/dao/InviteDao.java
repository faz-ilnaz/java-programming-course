package dao;

import model.Invite;

import java.util.List;

public interface InviteDao extends CRUDDao<Invite> {
    public List<Invite> findInvitesByCv(Long cv);
    public List<Invite> findInvitesByVacancy(Long vacancy);
}
