package kg.dao.impl;

import kg.dao.DepartmentDao;
import kg.dao.GenericDao;
import kg.db.Database;

import kg.model.Department;
import kg.model.Hospital;


import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao,GenericDao<Department> {



    @Override
    public String add(Long hospitalId, Department department) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(hospitalId)) {
                    hospital.addDepartment(department);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error chykty: " + e.getMessage();
        }
        return null;
    }

    @Override
    public void removeById(Long id) {
        try {
            for (Hospital hospital : Database.hospitals) {
                for (Department department : hospital.getDepartments()) {
                    if (department.getId().equals(id)) {
                        hospital.getDepartments().remove(department);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String updateById(Long id, Department department) {
        try {
            for (Hospital hospital : Database.hospitals) {
                for (Department hospitalDepartment : hospital.getDepartments()) {
                    if (hospitalDepartment.getId().equals(id)) {
                        hospitalDepartment.setDepartmentName(department.getDepartmentName());
                    }
                }
            }
            return "Success!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error chykty: " + e.getMessage();
        }
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        try {
            List<Department> departments = null;
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(id)) {
                    departments = hospital.getDepartments();
                }
            }
            System.out.println(departments);
            return departments;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Department findDepartmentByName(String name) {
        try {
            for (Hospital hospital : Database.hospitals) {
                for (Department department : hospital.getDepartments()) {
                    if (department.getDepartmentName().equalsIgnoreCase(name)) {
                        System.out.println(department);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
