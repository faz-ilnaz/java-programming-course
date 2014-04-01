package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CompanyService;

@Controller
public class VacancyController {

    private CompanyService companyService;

    @Autowired
    public VacancyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/vacancy/{id}")
    public ModelAndView getVacancy(@PathVariable Long id) {
        return new ModelAndView("vacancy_page", "vacancy", companyService.getVacancyById(id));
    }
}
