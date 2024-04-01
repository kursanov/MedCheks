package kg.dao;

import kg.model.Patient;
import kg.service.GenericService;

import java.util.List;
import java.util.Map;

public interface PatientDao extends GenericService<Patient> {

    String addPatientsToHospital(Long id, List<Patient> patients);
    Patient getPatientById(Long id);
    Map<Integer, Patient> getPatientByAge();
    List<Patient> sortPatientsByAge(String ascOrDesc);


}
