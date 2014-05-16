package controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/employee/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "empl_create";
    }

    @RequestMapping("/employee/save")
    public String save(Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }
}
