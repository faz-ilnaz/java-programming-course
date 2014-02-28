package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.Invite;

public interface InviteDAO {
	public void addInvite(Invite invite) throws SQLException;
	public void updateInvite(Invite invite) throws SQLException;
	public Invite getInviteById(Long id) throws SQLException;
	public List getAllInvites() throws SQLException;
	public void deleteInvite(Invite invite) throws SQLException; 
}
