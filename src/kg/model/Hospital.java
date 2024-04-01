package kg.model;

import java.util.LinkedList;
import java.util.List;

public class Hospital {

    private Long id;
    private String hospitalName;
    private String address;
    private List<Department> departments = new LinkedList<>();
    private List<Doctor> doctors = new LinkedList<>();
    private List<Patient> patients = new LinkedList<>();



    public Hospital(Long id, String hospitalName, String address) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
    }

    public Hospital() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }


    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }



    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public  void addDepartment(Department department){
        departments.add(department);
        System.out.println("Department success added!");
    }


    public  void addDoctor(Doctor doctor){
        doctors.add(doctor);
        System.out.println("Doctor success added!");
    }

    public  void addPatient(Patient patient){
        patients.add(patient);
        System.out.println("Doctor success added!");
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", hospitalName='" + hospitalName + '\'' +
                ", address='" + address + '\'' +
                ", departments=" + departments +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}
