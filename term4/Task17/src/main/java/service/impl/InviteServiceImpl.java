package service.impl;

import model.Invite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InviteRepository;
import service.InviteService;

@Service
public class InviteServiceImpl implements InviteService {

    private InviteRepository inviteRepository;

    @Autowired
    public InviteServiceImpl(InviteRepository inviteRepository) {
        this.inviteRepository = inviteRepository;
    }

    @Override
    public void save(Invite invite) {
        inviteRepository.save(invite);
    }
}
