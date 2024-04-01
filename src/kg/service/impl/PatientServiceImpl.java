package kg.service.impl;

import kg.dao.PatientDao;
import kg.db.Database;
import kg.model.Hospital;
import kg.model.Patient;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientDao {
    private final PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        patientDao.addPatientsToHospital(id, patients);
        return "Success!";
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return patientDao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDao.sortPatientsByAge(ascOrDesc);
    }



    @Override
    public String add(Long hospitalId, Patient patient) {
        System.out.println(patientDao.add(hospitalId, patient));
        return "Success!";
    }

    @Override
    public void removeById(Long id) {
        patientDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Patient patient) {
        return patientDao.updateById(id, patient);
    }

}