package kg.dao.impl;

import kg.dao.DoctorDao;
import kg.dao.GenericDao;
import kg.db.Database;
import kg.model.Department;
import kg.model.Doctor;
import kg.model.Hospital;


import java.util.LinkedList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao, GenericDao<Doctor> {



    @Override
    public Doctor findDoctorById(Long id) {
        try {
            for (Hospital hospital : Database.hospitals) {
                for (Doctor doctor : hospital.getDoctors()) {
                    if (doctor.getId().equals(id)) {
                        System.out.println(doctor);
                        return doctor;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        try {
            for (Hospital hospital : Database.hospitals) {
                for (Department department : hospital.getDepartments()) {
                    if (department.getId().equals(departmentId)) {
                        if (department.getDoctors() == null) {
                            department.setDoctors(new LinkedList<>());
                        }

                        for (Doctor doctor : hospital.getDoctors()) {
                            for (Long doctorId : doctorsId) {
                                if (doctor.getId().equals(doctorId)) {
                                    department.getDoctors().add(doctor);
                                }
                            }
                        }
                        return "Doctors assigned to department successfully" + department.getDoctors().toString();
                    }
                }
            }
            return "Department id   " + departmentId + " tabylgan jok";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error chykty: " + e.getMessage();
        }
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(id)) {
                    System.out.println(hospital.getDoctors());
                    return hospital.getDoctors();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        try {
            for (Hospital hospital : Database.hospitals) {
                for (Department department : hospital.getDepartments()) {
                    if (department.getId().equals(id)) {
                        return department.getDoctors();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(hospitalId)) {
                    hospital.addDoctor(doctor);
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error chykty: " + e.getMessage();
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            for (Hospital hospital : Database.hospitals) {
                for (Doctor doctor : hospital.getDoctors()) {
                    if (doctor.getId().equals(id)) {
                        hospital.getDoctors().remove(doctor);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        try {
            for (Hospital hospital : Database.hospitals) {
                for (Doctor doctor1 : hospital.getDoctors()) {
                    if (doctor1.getId().equals(id)) {
                        doctor1.setFirstName(doctor.getFirstName());
                        doctor1.setLastName(doctor.getLastName());
                        doctor1.setGender(doctor.getGender());
                        doctor1.setExperienceYear(doctor.getExperienceYear());
                    }
                }
            }
            return "Success ozgordu!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error chykty: " + e.getMessage();
        }
    }}
