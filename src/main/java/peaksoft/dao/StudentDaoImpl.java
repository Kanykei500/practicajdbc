package peaksoft.dao;

import peaksoft.config.DataBaseConnection;
import peaksoft.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao  {

    private final Connection connection;

    public StudentDaoImpl(){
        this.connection= DataBaseConnection.gerConnection();
    }
    @Override
    public void creatTable() {
        String query= """
                create table if not exists students(
                id serial primary key,
                name varchar (50) not null,
                age smallint not null
                );
                """;
        try (Statement statement = connection.createStatement();){

            statement.execute(query);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void saveStudent(Student student) {
        String sqlQuery= """
                insert into students(name,age)
                values (?,?)
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setByte(2,student.getAge());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Student findByStudentId(Long studentId) {
        String query = """
                select* from students where id =?; 
                
                """;
        try(PreparedStatement preparedStatement = connection .prepareStatement(query);) {

            preparedStatement.setLong(1,studentId);

            ResultSet resultSet= preparedStatement.executeQuery();
            Student student=new Student();
            while (resultSet.next()) {
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
            } resultSet.close();
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Student> findAllStudents() {
        List<Student>allStudents=new ArrayList<>();
        String query= """
                select * from students;
                
                """;
        try (Statement statement = connection. createStatement();
            ResultSet resultSet=statement.executeQuery(query)){
            while (resultSet.next()){
                Student student=new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                allStudents.add(student);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allStudents;
    }

    @Override
    public void updateStudent(Long studentId, Student newStudent) {
        String query = """
                update students
                set name= ?,
                age = ?
                where id = ?;
                
                """;
        try(PreparedStatement preparedStatement = connection. prepareStatement(query)) {
            preparedStatement.setString(1, newStudent.getName());
            preparedStatement.setByte(2, newStudent.getAge());
            preparedStatement.setLong(3, studentId);
            int i = preparedStatement.executeUpdate();

            if (i > 0){
                System.out.println("Successfully updated");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteByStudentId(Long studentId) {
        String query= """
                delete from students
                where id=?
                """;
        try(PreparedStatement preparedStatement = connection. prepareStatement(query)) {
            preparedStatement.setLong(1,studentId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getAllStudentsSortByAge(String ascOrDesc) {
        List<Student>studentList=new ArrayList<>();
        String queryy= """
                select* from students order by age
                """;
        String queryyy= """
                select * from students order by age desc
                """;
        String query=" ";
        if (ascOrDesc.equals("asc")) {
            query = queryy;
        }else
        {query=queryyy;
        };


        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                studentList.add(new Student(resultSet.getLong("id"),
                        resultSet.getString(2),resultSet.getByte(3)));
            }
            return studentList.toString();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean checkByAge() {
        String query = """
                SELECT * FROM students WHERE age > 18;
                """;
        boolean isExists = false;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            isExists = resultSet.next();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isExists;
    }



   @Override
   public void addColumnGender(String str) {
        String query= """
               
         alter table students
         add column gender gender;
                """;
           try(Statement statement=connection.createStatement()){
               statement.executeQuery(query);
               System.out.println("Successfully added column");
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
       }

        // @Override
        //  public Map<Gender, List<Student>> groupByGender() {
        //     return null;
        //   }






    @Override
    public void deleteAllStudents() {
        String query= """
                truncate table  students
                """;
        try ( PreparedStatement preparedStatement = connection. prepareStatement(query);){
            preparedStatement.executeUpdate();

            System.out.println("Successfully deleted");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

