package kg.id;

public class IdGenerator {


    private static Long idHospital = 0L;
    public static  Long idPatient = 0L;
    public static  Long idDepartment = 0L;
    public static  Long idDoctor = 0L;




    public synchronized static Long idGeneratorHospital() {
        return ++idHospital;
    }

    public static Long idGeneratorPatient(){
        return ++ idPatient;
    }

    public synchronized static  Long idGeneratorDepartment(){
        return ++idDepartment;
    }

    public static  Long idGeneratorDoctor(){
        return ++idDoctor;
    }

}
