package controller;

import controller.editor.EmployeeEditor;
import model.Attendance;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.EmployeeService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private EmployeeService employeeService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Employee.class, new EmployeeEditor());
    }

    @RequestMapping("/")
    public String list(Model model) {
        Iterable<Employee> employees = employeeService.getAllEmployees();
        Date d1 = new Date(2014, 4, 23);
        Date d2 = new Date(2014, 4, 21);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(2014, 4, 20);
        List<Attendance> attendances = (List<Attendance>) employeeService.getAttendancesByDateBetween(new Date(), calendar.getTime());
        for (Attendance a : attendances) {
            System.out.println(a);
            System.out.println(a.getEmployee());
        }
//        for(Employee e : employees) {
//            List<Attendance> empAttendances = new ArrayList<>();
//            for (Attendance a : attendances) {
//                if(a.getEmployee().getId() == e.getId()) {
//                    empAttendances.add(a);
//                }
//            }
//            attendances.removeAll(empAttendances);
//        }
        model.addAttribute("list", employees);
        return "empl_list";
    }


    @RequestMapping(value = "/attendance/save", method = RequestMethod.POST)
    public String saveStart(@RequestParam Long empl_id, @RequestParam Long type) {
        Attendance attendance = employeeService.getAttendanceByDateAndEmployee(new Date(), empl_id);
        if (attendance == null) {
            attendance = new Attendance();
            attendance.setEmployee(new Employee(empl_id));
            attendance.setActualDate(new Date());
        }
        if (type == 777) {
            attendance.setStart(new Date());
        } else if (type == 666) {
            attendance.setEnd(new Date());
        }
        employeeService.saveAttendance(attendance);
        return "redirect:/";
    }

    @RequestMapping("/new")
    public String newRecord(Model model) {
        model.addAttribute("attendance", new Attendance());
        model.addAttribute("allEmployees", employeeService.getAllEmployees());
        return "new_record";
    }
}
