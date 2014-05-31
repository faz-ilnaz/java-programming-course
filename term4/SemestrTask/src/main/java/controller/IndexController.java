package controller;

import controller.editor.EmployeeEditor;
import model.Attendance;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;
import utils.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    private String message;

    @Autowired
    private EmployeeService employeeService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Employee.class, new EmployeeEditor());
    }

    @RequestMapping("/table")
    public String main(Model model) {
        return "empl_list";
    }

    @RequestMapping("/fetch")
    public String list(Model model,
                       @DateTimeFormat(pattern="dd-MM-yyyy") @RequestParam(value = "start", required = false) Date start,
                       @DateTimeFormat(pattern="dd-MM-yyyy") @RequestParam(value = "end", required = false) Date end) {
        Calendar cal = Calendar.getInstance();
        if(end == null) {
            end = new Date();
        }
        if(start == null) {
            cal.add(Calendar.DAY_OF_YEAR, -7);
            start = cal.getTime();
        } else {
            cal.setTime(start);
            cal.add(Calendar.DAY_OF_YEAR, 7);
            end = cal.getTime();
        }

        Iterable<Employee> employees = employeeService.getAllEmployees();

        for(Employee e : employees) {
            List<Attendance> attendances = (List<Attendance>) employeeService
                    .getAttendanceByEmployeeAndDateBetween(e,start, end);

            e.setAttendances(attendances);
        }
        model.addAttribute("dataList", employees);
        return "empl_list::resultsList";
    }


    @RequestMapping(value = "/attendance/save", method = RequestMethod.POST)
    public @ResponseBody String save(@RequestParam String login, @RequestParam String pass, @RequestParam Long type) {
        Employee e = employeeService.getEmployeeByLogin(login);
        if(e == null) {
//            message = "Пользователя с таким логином не существует в базе!";
            message = "Login was not found in DB!";
            return message;
        }

        if(!Utils.check(e.getPass(), pass, e.getSalt())) {
//            message = "Неверный пароль!";
            message = "Wrong combination of login/password!";
            return message;
        }

        Long empl_id = e.getId();
        Attendance attendance = employeeService.getAttendanceByDateAndEmployee(new Date(), empl_id);
        if (attendance == null) {
            attendance = new Attendance();
            attendance.setEmployee(new Employee(empl_id));
            attendance.setActualDate(new Date());
        }

//        message = "Данные успешно переданы на сервер";
        message = "Data was sent successful";
        if (type == 777) {
            attendance.setStart(new Date());
        } else if (type == 666) {
            attendance.setEnd(new Date());
        }
        employeeService.saveAttendance(attendance);
        return message;
    }

    @RequestMapping("/new")
    public String newRecord(Model model) {
        model.addAttribute("attendance", new Attendance());
        model.addAttribute("allEmployees", employeeService.getAllEmployees());
        return "new_record";
    }

    @RequestMapping("/")
    public String signin(Model model) {
        return "signin";
    }


}
