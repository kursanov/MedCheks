package kg;

import kg.dao.DepartmentDao;
import kg.dao.DoctorDao;
import kg.dao.HospitalDao;
import kg.dao.PatientDao;
import kg.dao.impl.DepartmentDaoImpl;
import kg.dao.impl.DoctorDaoImpl;
import kg.dao.impl.HospitalDaoImpl;
import kg.dao.impl.PatientDaoImpl;
import kg.enums.Gender;
import kg.id.IdGenerator;
import kg.model.Department;
import kg.model.Doctor;
import kg.model.Hospital;
import kg.model.Patient;
import kg.service.impl.HospitalServiceImpl;
import kg.service.impl.PatientServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {



        HospitalDao hospital = new HospitalServiceImpl(new HospitalDaoImpl());
        DepartmentDao department = new DepartmentDaoImpl();
        DoctorDao doctor =  new DoctorDaoImpl();
        PatientDao patient = new PatientServiceImpl(new PatientDaoImpl());



        List<Long> idDoctors = List.of(1L,2L);




        while (true){
            try {
            menu();
            System.out.println("Write command: ");

            switch (new Scanner(System.in).nextInt()){
               case 1:{
                    hospital.addHospital(new Hospital(IdGenerator.idGeneratorHospital(),"Borborduk","Bishkek"));break;
                }
                case 2:{
                    hospital.findHospitalById(2L);break;
                }
                case 3:{
                    hospital.getAllHospital();break;
                }
                case 4:{
                    System.out.println(hospital.getAllPatientFromHospital(1L));//kkd
                }
                case 5:{
                    hospital.deleteHospitalById(2L);break;
                }
                case 6:{
                    hospital.getAllHospitalByAddress("Bishkek");break; // караш  керек
                }
                case 7:{
                    department.add(1L,new Department(IdGenerator.idGeneratorDepartment(),"Хирургия"));break;
                }
                case 8:{
                    department.removeById(2L);break;
                }
                case 9:{
                    department.updateById(1L,new Department(IdGenerator.idGeneratorDepartment(),"Травматология"));break;
                }
                case 10:{
                    department.getAllDepartmentByHospital(2L);break;
                }
                case 11:{
                    department.findDepartmentByName("Травматология");break;
                }
                case 12:{
                    doctor.add(1L,new Doctor(IdGenerator.idGeneratorDoctor(),"Arzybek","Akylbekov", Gender.MALE,10));break;
                }
                case 13:{
                    doctor.removeById(1L);
                }
                case 14:{
                    doctor.updateById(2L,new Doctor(IdGenerator.idGeneratorDoctor(),"Salamat","Shirinbek",Gender.FEMALE,5));break;
                }
                case 15:{
                    doctor.findDoctorById(2L);break;
                }
                case 16:{
                    System.out.println(doctor.assignDoctorToDepartment(1L, idDoctors));break;
                }
                case 17:{
                    doctor.getAllDoctorsByHospitalId(1L);break;
                }
                case 18:{
                    System.out.println(doctor.getAllDoctorsByDepartmentId(1L));break;
                }
                case 19:{
                    System.out.println(patient.add(1L, new Patient(IdGenerator.idGeneratorPatient(), "Datka", "Mamatjanova", 20, Gender.FEMALE)));break;
                }
                case 20:{
                    patient.removeById(2L);break;
                }
                case 21:{
                    System.out.println(patient.updateById(1L, new Patient(IdGenerator.idGeneratorPatient(), "Kylym", "Asanov", 22, Gender.MALE)));break;
                }
                case 22:{
                    System.out.println(patient.addPatientsToHospital(1L, patients()));break;
                }
                case 23:{
                    System.out.println(patient.getPatientById(1L));break;
                }
                case 24:{
                    System.out.println(patient.getPatientByAge());break;
                }
                case 25:{
                    System.out.println(patient.sortPatientsByAge("desc"));break;
                }
            }
        }catch (InputMismatchException e) {
                System.err.println("Write command:");
                new Scanner(System.in).next();
            }
        }

    }

    private static void menu() {
        System.out.println("""
                0 ->  Exit                                         13 -> Remove Doctor by ID
                1 ->  Add Hospital                                 14 -> Update Doctor by ID
                2 ->  Find Hospital by ID                          15 -> Find Doctor by ID
                3 ->  Get all Hospitals                            16 -> Assign Doctors to Department
                4 ->  Get all Patient from Hospital                17 -> Get all Doctors by Hospital ID
                5 ->  Delete Hospital by ID                        18 -> Get all Doctors by Department ID
                6 ->  Get all Hospitals by address                 19 -> Add Patient to Hospital by ID
                7 ->  Add Department to Hospital by ID             20 -> Remove Patient by ID
                8 ->  Remove Department by ID                      21 -> Update Patient by ID
                9 -> Update Department by ID                       22 -> Add Patients to Hospital by ID
                10 -> Get all Department by Hospital ID            23 -> Get Patient by ID
                11 -> Find Department by name                      24 -> Get Patient by age
                12 -> Add Doctor to Hospital by ID                 25 -> Sort Patient by age
                """);

    }



    private static List<Patient> patients(){
        return new LinkedList<>(Arrays.asList(
                new Patient(IdGenerator.idGeneratorPatient(), "Мурат", "Газыев", 24, Gender.MALE),
                new Patient(IdGenerator.idGeneratorPatient(), "Гулжигит", "Сатыбеков", 24, Gender.MALE),
                new Patient(IdGenerator.idGeneratorPatient(), "Канышай", "Садирова", 19, Gender.FEMALE),
                new Patient(IdGenerator.idGeneratorPatient(), "Айзат", "Дуйшеева", 18, Gender.FEMALE),
                new Patient(IdGenerator.idGeneratorPatient(), "Датка", "Маматжанова", 21, Gender.FEMALE)
        ));
    }
}