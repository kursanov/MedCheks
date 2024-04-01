package kg.dao.impl;

import kg.dao.GenericDao;
import kg.dao.PatientDao;
import kg.db.Database;
import kg.model.Hospital;
import kg.model.Patient;

import java.util.*;

public class PatientDaoImpl implements PatientDao, GenericDao<Patient> {
    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(id)) {
                    if (hospital.getPatients() == null) {
                        hospital.setPatients(new LinkedList<>());
                    }
                    hospital.getPatients().addAll(patients);
                    return "Patients added to hospital successfully!" + hospital.getPatients();
                }
            }
            return "Hospital with ID " + id + " not found";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error : " + e.getMessage();
        }
    }

    @Override
    public Patient getPatientById(Long id) {
        try {
            Patient patient1 = null;
            for (Hospital hospital : Database.hospitals) {
                for (Patient patient : hospital.getPatients()) {
                    if (patient.getId().equals(id)) {
                        patient1 = patient;
                        System.out.println(patient);
                    }
                }
            }
            return patient1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        try {
            Map<Integer, Patient> patientMap = new HashMap<>();
            for (Hospital hospital : Database.hospitals) {
                for (Patient patient : hospital.getPatients()) {
                    patientMap.put(patient.getAge(), patient);
                }
            }
            return patientMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        try {
            List<Patient> patients = new LinkedList<>();
            for (Hospital hospital : Database.hospitals) {
                patients.addAll(hospital.getPatients());
            }

            Comparator<Patient> comparator = Comparator.comparing(Patient::getAge);

            if (ascOrDesc.equalsIgnoreCase("desc")) {
                comparator = comparator.reversed();
            }

            Collections.sort(patients, comparator);
            return patients;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public String add(Long hospitalId, Patient patient) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(hospitalId)) {
                    hospital.addPatient(patient);
                }
            }
            return "Success adet!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error : " + e.getMessage();
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            for (Hospital hospital : Database.hospitals) {
                Iterator<Patient> iterator = hospital.getPatients().iterator();
                while (iterator.hasNext()) {
                    Patient patient = iterator.next();
                    if (patient.getId().equals(id)) {
                        iterator.remove();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String updateById(Long id, Patient patient) {
        try {
            for (Hospital hospital : Database.hospitals) {
                for (Patient hospitalPatient : hospital.getPatients()) {
                    if (hospitalPatient.getId().equals(id)) {
                        hospitalPatient.setFirstName(patient.getFirstName());
                        hospitalPatient.setLastName(patient.getLastName());
                        hospitalPatient.setAge(patient.getAge());
                        hospitalPatient.setGender(patient.getGender());
                    }
                }
            }
            return "Success updated!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error : " + e.getMessage();
        }
    }
}
