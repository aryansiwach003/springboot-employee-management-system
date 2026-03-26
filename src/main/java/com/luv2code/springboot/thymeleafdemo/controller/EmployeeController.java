package com.luv2code.springboot.thymeleafdemo.controller;


import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

     private EmployeeService employeeService;

     @Autowired
     public EmployeeController(EmployeeService employeeService){
           this.employeeService=employeeService;
     }


     @GetMapping("/list")
    public String listEmployees(Model model){

          // get the daTA from db
         List<Employee> theEmployees =employeeService.findAll();

         // add to the spring model
          model.addAttribute("employees",theEmployees);

          return "employees/list-employees";

     }

     @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

           // create model attribute to bind form data

         Employee emp=new Employee();

         model.addAttribute("employee",emp);

         return "employees/employee-form";

     }

     @GetMapping("/showFormForUpdate")
     public String updateForm(@RequestParam("employeeId") int id,Model model){

         //get the employee from the service

         Employee emp=employeeService.findById(id);

         model.addAttribute("employee",emp);

         return "employees/employee-form";

     }

     @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee emp){
           //save the employee
         employeeService.save(emp);
         //use a redirect to prevent duplicate submissions

         return "redirect:/employees/list";
     }

     @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
           employeeService.deleteById(id);

           return "redirect:/employees/list";

     }
}
