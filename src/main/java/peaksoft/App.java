package peaksoft;

import peaksoft.models.Student;
import peaksoft.service.StudentService;
import peaksoft.service.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentService service=new StudentServiceImpl();
        System.out.println(service.creatTable());
        System.out.println(service.saveStudents(new Student("Altynbek", (byte) 16)));
        System.out.println(service.saveStudents(new Student("Adil", (byte) 18)));
        System.out.println(service.saveStudents(new Student("Ilim", (byte) 19)));
        System.out.println(service.saveStudents(new Student("Osmon", (byte) 20)));
       System.out.println(service.findByStudentId(4L));


       service.findAllStudents().forEach(System.out::println);
       System.out.println(service.updateStudent(3L, new Student("Kanykei", (byte) 19)));
        System.out.println(service.deleteByStudentId(6L));
        System.out.println(service.checkByAge());
        System.out.println(service.deleteAllStudents());
        System.out.println(service.getAllStudentsSortByAge("asc"));



    }
}
