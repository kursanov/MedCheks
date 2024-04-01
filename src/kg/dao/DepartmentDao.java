package kg.dao;

import kg.model.Department;
import kg.service.GenericService;

import java.util.List;

public interface DepartmentDao extends GenericService<Department> {

    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
}
