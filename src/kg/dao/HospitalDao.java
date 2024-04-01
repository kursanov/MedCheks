package kg.dao;

import kg.model.Hospital;
import kg.model.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalDao {

    String addHospital(Hospital hospital);
    Hospital findHospitalById(Long id);
    List<Hospital> getAllHospital();
    List<Patient> getAllPatientFromHospital(Long id);
    String deleteHospitalById(Long id);
    Map<String, Hospital> getAllHospitalByAddress(String address);
}
