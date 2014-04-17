package controller;

import controller.editor.CategoryEditor;
import model.Category;
import model.Company;
import model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CompanyService;
import service.SearchService;

@Controller
public class VacancyController {

    private CompanyService companyService;
    private SearchService searchService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class, new CategoryEditor());
    }

    @Autowired
    public VacancyController(CompanyService companyService, SearchService searchService) {
        this.companyService = companyService;
        this.searchService = searchService;
    }

    @RequestMapping("/vacancy/{id}")
    public ModelAndView getVacancy(@PathVariable Long id) {
        return new ModelAndView("vacancy_page", "vacancy", companyService.getVacancyById(id));
    }

    @RequestMapping("/vacancy/list")
    public ModelAndView getVacancy() {
        ModelAndView mv = new ModelAndView("vacancy_list");
        mv.addObject("vacancyList", companyService.getAllVacancies());
        mv.addObject("allCategories", searchService.getAllCategories());
        return mv;
    }

    @RequestMapping("/vacancy/list/{id}")
    public ModelAndView getVacancyByCategory(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("vacancy_list");
        mv.addObject("vacancyList", companyService.getVacancyListByCategoryId(id));
        mv.addObject("allCategories", searchService.getAllCategories());
        return mv;
    }

    @RequestMapping("/vacancy/edit/{id}")
    public ModelAndView editVacancy(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("vacancy_edit");
        mv.addObject("vacancy", companyService.getVacancyById(id));
        mv.addObject("allCategories", searchService.getAllCategories());
        return mv;
    }

    @RequestMapping("/vacancy/create")
    public ModelAndView editVacancy() {
        ModelAndView mv = new ModelAndView("vacancy_edit");
        mv.addObject("vacancy", new Vacancy());
        mv.addObject("allCategories", searchService.getAllCategories());
        return mv;
    }

    @RequestMapping("vacancy/save")
    public String saveVacancy(Vacancy vacancy) {
        vacancy.setCompany(new Company(1L));
        companyService.saveVacancy(vacancy);
        return "redirect:/vacancy/list";
    }
}
