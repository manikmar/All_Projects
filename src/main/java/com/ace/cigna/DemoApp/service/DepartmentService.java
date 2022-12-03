package com.ace.cigna.DemoApp.service;

import com.ace.cigna.DemoApp.error.DepartmentNotFoundException;
import com.ace.cigna.DemoApp.entity.Department;

import java.util.List;

public interface DepartmentService {

   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

   Department fetchDepartmentByNamer(String departmentName);
}
