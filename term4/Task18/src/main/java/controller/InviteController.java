package controller;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.InviteRepository;
import service.CompanyService;
import service.UserService;

@RestController
public class InviteController {

    private CompanyService companyService;
    private UserService userService;
    private InviteRepository inviteRepository;

    @Autowired
    public InviteController(CompanyService companyService, UserService userService, InviteRepository inviteRepository) {
        this.companyService = companyService;
        this.userService = userService;
        this.inviteRepository = inviteRepository;
    }

    @RequestMapping("/invite/saveInvite")
    public void invite(@RequestParam Long cv_id, @RequestParam Long vacancy_id) {
        Invite invite = new Invite();
        invite.setType(InviteType.INVITE);;
        Vacancy vacancy = companyService.getVacancyById(vacancy_id);
        CV cv = userService.getCVById(cv_id);
        invite.setKey(new InvitePK(vacancy,cv));
        inviteRepository.save(invite);
    }

    @RequestMapping("/invite/saveResponse")
    public void response(@RequestParam Long cv_id, @RequestParam Long vacancy_id) {
        Invite invite = new Invite();
        invite.setType(InviteType.RESPONSE);
        Vacancy vacancy = companyService.getVacancyById(vacancy_id);
        CV cv = userService.getCVById(cv_id);
        invite.setKey(new InvitePK(vacancy,cv));
        inviteRepository.save(invite);
    }
}
