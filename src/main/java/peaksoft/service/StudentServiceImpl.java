package peaksoft.service;

import peaksoft.dao.StudentDao;
import peaksoft.dao.StudentDaoImpl;
import peaksoft.models.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    StudentDao studentDao=new StudentDaoImpl();
    @Override
    public String creatTable() {
        studentDao.creatTable();
        return "Successfully created";
    }

    @Override
    public String saveStudents(Student student) {
        studentDao.saveStudent(student);
        return "Successfully added";
    }

    @Override
    public Student findByStudentId(Long studentId) {
        return studentDao. findByStudentId(studentId);

    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();


    }

    @Override
    public String updateStudent(Long studentId, Student newStudent) {
        studentDao.updateStudent(studentId,newStudent);

        return "Successfully updated";
    }

    @Override
    public String deleteByStudentId(Long studentID) {
        studentDao.deleteByStudentId(studentID);
        return "Successfully deleted ";
    }

    @Override
    public String getAllStudentsSortByAge(String ascOrDesc) {
        return studentDao.getAllStudentsSortByAge(ascOrDesc);

    }

    @Override
    public boolean checkByAge() {
        studentDao.checkByAge();
        return false;
    }

//    @Override
//    public String addColumnGender(Gender gender) {
//        return null;
//    }
//
//    @Override
//    public Map<Gender, List<Student>> groupByGender() {
//        return null;
//    }

    @Override
    public String deleteAllStudents() {
        studentDao.deleteAllStudents();
        return "Successfully deleted";
    }
}
