package com.example.Lab8Ex2.Controller;

import com.example.Lab8Ex2.Model.Employee;
import com.example.Lab8Ex2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("employees", empService.getAllEmployees());
        return "index";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm() {
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        empService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Employee employee = empService.getEmployeeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "edit";
    }


    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") int id, @ModelAttribute Employee employee) {
        Employee existingEmployee = empService.getEmployeeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setAddress(employee.getAddress());
        empService.updateEmployee(id,existingEmployee);
        return "redirect:/employees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        empService.deleteEmployee(id);
        return "redirect:/employees";
    }



}
