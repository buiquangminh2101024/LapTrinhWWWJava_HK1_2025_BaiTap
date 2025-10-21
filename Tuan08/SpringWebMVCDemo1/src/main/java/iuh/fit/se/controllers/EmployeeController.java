package iuh.fit.se.controllers;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String enterHome(Model model) {
        if (!model.containsAttribute("employees"))
            model.addAttribute("employees", employeeService.findAll());

        return "home";
    }

    @GetMapping(value = "/register")
    public String registerEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "register";
    }

    @PostMapping("/save")
    public ModelAndView registerEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        if (bindingResult.hasErrors()) {
            model.setViewName("register");
            return model;
        }
        if (employee.getId() == 0) {
            employeeService.add(employee);
            model.addObject("type", "add");
        }
        else {
            employeeService.update(employee);
            model.addObject("type", "update");
        }
        model.setViewName("success");
        return model;
    }

    @GetMapping(value = "/update_intermediate")
    public String updateEmployee(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.findById(id);
        if (employee == null)
            return "error";
        redirectAttributes.addFlashAttribute("employee", employee);
        return "redirect:/update";
    }

//    //Cái này chạy được
//    @GetMapping(value = "/update")
//    public ModelAndView updateEmployee(ModelAndView model, @ModelAttribute Employee employee) {
//        model.setViewName("register");
//        model.addObject("employee", employee);
//        return model;
//    }

    @GetMapping(value = "/update")
    public ModelAndView updateEmployee(ModelAndView model) {
        model.setViewName("register");
        return model;
    }

    @GetMapping(value = "/delete_intermediate")
    public ModelAndView deleteEmployee(ModelAndView model, @ModelAttribute Employee employee) {
        model.setViewName("redirect:/");
        employeeService.delete(employee.getId());
        return model;
    }

    @PostMapping("/find")
    public String searchEmployee(RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String en = request.getParameter("email_name");
        List<Employee> employees = employeeService.findByFirstNameContainingOrLastNameContainingOrEmailContaining(en);
        redirectAttributes.addFlashAttribute("employees", employees);
        return "redirect:/";
    }
}
