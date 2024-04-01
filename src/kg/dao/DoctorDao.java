package kg.dao;

import kg.model.Doctor;
import kg.service.GenericService;

import java.util.List;

public interface DoctorDao extends GenericService<Doctor> {

    Doctor findDoctorById(Long id);

    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
    List<Doctor> getAllDoctorsByHospitalId(Long id);
    List<Doctor> getAllDoctorsByDepartmentId(Long id);
}
