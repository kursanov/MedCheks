package kg.service.impl;

import kg.dao.DepartmentDao;
import kg.db.Database;
import kg.model.Department;
import kg.model.Hospital;
import kg.service.DepartmentService;
import kg.service.GenericService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService, GenericService<Department> {
    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


    @Override
    public String add(Long hospitalId, Department department) {
        departmentDao.add(hospitalId,department);
        return "Success";
    }

    @Override
    public void removeById(Long id) {
        departmentDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Department department) {
     departmentDao.updateById(id,department);
        return "Success";
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        System.out.println(departmentDao.getAllDepartmentByHospital(id));
        return departmentDao.getAllDepartmentByHospital(id) ;
    }

    @Override
    public Department findDepartmentByName(String name) {
        System.out.println(departmentDao.findDepartmentByName(name));
        return departmentDao.findDepartmentByName(name);
    }
}
