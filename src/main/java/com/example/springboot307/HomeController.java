package com.example.springboot307;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @RequestMapping("/")
    public String index(Model model){
        // first lets create an employee
        Employee employee = new Employee();
        employee.setName("patricia lopez");
        employee.setSsn("292-48-2838");

        // now lets create a laptop
        Laptop laptop = new Laptop();

        laptop.setBrand("apple");
        laptop.setModel("macbook");
        // add the laptop to the employee
        employee.setLaptop(laptop);

        // save the employee to the database
        employeeRepository.save(employee);

        // grab all the employees from the database and send them to the template
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }
}
