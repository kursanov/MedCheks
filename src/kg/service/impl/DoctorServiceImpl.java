package kg.service.impl;

import kg.dao.DoctorDao;
import kg.model.Doctor;
import kg.service.DoctorService;
import kg.service.GenericService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {

    private final DoctorDao doctorDao;

    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        doctorDao.findDoctorById(id);
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        doctorDao.assignDoctorToDepartment(departmentId,doctorsId);
        return null;

    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        doctorDao.getAllDoctorsByHospitalId(id);
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        doctorDao.getAllDoctorsByDepartmentId(id);
        return null;
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        doctorDao.add(hospitalId,doctor);
        return "Sucesss!";
    }

    @Override
    public void removeById(Long id) {
        doctorDao.removeById(id);
        System.out.println("Success deleted!");

    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        doctorDao.updateById(id,doctor);
        return null;
    }
}
