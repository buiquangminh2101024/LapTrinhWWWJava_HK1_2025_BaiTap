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

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String enterHome(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "home";
    }

    @GetMapping(value = "/register")
    public ModelAndView registerEmployee(ModelAndView model) {
        model.setViewName("register");
        model.addObject("employee", new Employee());
        return model;
    }

    @PostMapping("/save")
    public ModelAndView registerEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        if (bindingResult.hasErrors()) {
            model.setViewName("register");
            return model;
        }
        employeeService.add(employee);
        model.setViewName("success");
        return model;
    }

    @GetMapping(value = "/update_intermediate")
    public String updateEmployee(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.findById(id);
        redirectAttributes.addFlashAttribute("employee", employee);
        return "redirect:/update";
    }

    @GetMapping(value = "/update")
    public ModelAndView updateEmployee(ModelAndView model, @ModelAttribute Employee employee) {
        model.setViewName("register");
        model.addObject("employee", employee);
        return model;
    }
}
