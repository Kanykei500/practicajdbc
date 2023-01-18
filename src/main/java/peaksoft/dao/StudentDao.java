package peaksoft.dao;

import peaksoft.models.Student;

import java.util.List;

public interface StudentDao {
    // create table
    void creatTable();
    // save students
    void saveStudent(Student student);

    //find by studentsId
    Student findByStudentId(Long studentId);

    //find all

    List<Student> findAllStudents();

    //update students
    void updateStudent(Long studentId,Student newStudent);

    //deklete
    void deleteByStudentId(Long studentId);
    String getAllStudentsSortByAge(String ascOrDesc);

    boolean checkByAge();


   // Map<Gender,List<Student>>groupByGender();

  //  void addColumnGender(Gender gender);

    void deleteAllStudents();
    //ddl

}
