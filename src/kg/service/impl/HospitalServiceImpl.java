package kg.service.impl;

import kg.dao.HospitalDao;
import kg.model.Hospital;
import kg.model.Patient;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalDao {

    private final HospitalDao hospitalDao;

    public HospitalServiceImpl(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }


    @Override
    public String addHospital(Hospital hospital) {
        hospitalDao.addHospital(hospital);
        return "Success!";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        hospitalDao.findHospitalById(id);
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        hospitalDao.deleteHospitalById(id);
        return null;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        System.out.println(hospitalDao.getAllHospitalByAddress(address));
        return hospitalDao.getAllHospitalByAddress(address);
    }
}
