package kg.dao.impl;

import kg.dao.HospitalDao;
import kg.db.Database;
import kg.model.Hospital;
import kg.model.Patient;

import java.util.*;

public class HospitalDaoImpl implements HospitalDao {

    @Override
    public String addHospital(Hospital hospital) {
        try {
            Database.hospitals.add(hospital);
            return "Success!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error : " + e.getMessage();
        }
    }

    @Override
    public Hospital findHospitalById(Long id) {
        try {
            Hospital hospital1 = null;
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(id)) {
                    hospital1 = hospital;
                    System.out.println(hospital);
                    return hospital1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        try {
            System.out.println(Database.hospitals);
            return Database.hospitals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        try {
            List<Patient> patients = new LinkedList<>();
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(id)) {
                    for (Patient patient : hospital.getPatients()) {
                        System.out.println(patients.add(patient));
                    }
                }
            }
            return patients;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteHospitalById(Long id) {
        try {
            Iterator<Hospital> iterator = Database.hospitals.iterator();
            while (iterator.hasNext()) {
                Hospital hospital = iterator.next();
                if (hospital.getId().equals(id)) {
                    iterator.remove();
                    return "Success deleted";
                }
            }
            return "Hospital with ID " + id + " not found";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error chykty: " + e.getMessage();
        }
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        try {
            Map<String, Hospital> hospitalMap = new HashMap<>();

            for (Hospital hospital : Database.hospitals) {
                if (hospital.getAddress().equalsIgnoreCase(address)) {
                    hospitalMap.put(hospital.getHospitalName(), hospital);
                }
            }

            System.out.println(hospitalMap);
            return hospitalMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
