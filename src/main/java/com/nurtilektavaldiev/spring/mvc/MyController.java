package com.nurtilektavaldiev.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {

//        Employee emp= new Employee();
//        emp.setName("Ivan");
//        emp.setSurname("Petrov");
//        emp.setSalary(500);
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) {

        System.out.println("surname length=" + emp.getSurname().length());

        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";

        }
    }
}

