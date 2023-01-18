package peaksoft.service;

import peaksoft.models.Student;

import java.util.List;

public interface StudentService {
    // create table
    String creatTable();

    // save students
    String saveStudents(Student student);

    // find by studentsId
    Student findByStudentId(Long studentId);

    //find all
    List<Student> findAllStudents();

    // update students
    String updateStudent(Long studentId, Student newStudent);

    //delete
    String deleteByStudentId(Long studentID);
    String getAllStudentsSortByAge(String ascOrDesc);

    boolean checkByAge();

    String addColumnGender(String str);

   // Map<Gender,List<Student>> groupByGender();

    String deleteAllStudents();
    //ddl

}
