package com.ace.cigna.DemoApp.controller;

import com.ace.cigna.DemoApp.error.DepartmentNotFoundException;
import com.ace.cigna.DemoApp.entity.Department;
import com.ace.cigna.DemoApp.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepartmentController {
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

   @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
       LOGGER.info("in side of saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("in side of fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("in side of fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("in side of deleteDepartmentById of DepartmentController");
       departmentService.deleteDepartmentById(departmentId);
       return "Department deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,
                                           @RequestBody Department department){
        LOGGER.info("in side of updateDepartmentById of DepartmentController");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("in side of fetchDepartmentByName of DepartmentController");
       return departmentService.fetchDepartmentByNamer(departmentName);
    }
}
