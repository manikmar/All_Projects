package com.ace.cigna.DemoApp.repository;

import com.ace.cigna.DemoApp.entity.Guardian;
import com.ace.cigna.DemoApp.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("mani@gmail.com")
                .firstName("mani")
                .lastName("kumar")
//                .guardianName("evan")
//                .guardianEmail("evan@gmail.com")
//                .guardianMobil("999999999")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("ethan")
                .email("ethan@gmail.com")
                .mobil("999999999")
                .build();

        Student student = Student.builder()
                .emailId("kumar@gmail.com")
                .firstName("kumar")
                .lastName("panithi")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> all = studentRepository.findAll();
        all.stream().forEach(System.out::println);

    }

    @Test
    public void printStudentByFirstName(){
        List<Student> name = studentRepository.findByFirstName("mani");
        System.out.println("Studeent Name :: "+name);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> name = studentRepository.findByFirstNameContaining("ma");
        System.out.println("Studeent Name :: "+name);
    }

    @Test
    public void printStudentByFindByLastNameNotNull(){
        List<Student> name = studentRepository.findByLastNameNotNull();
        System.out.println("Studeent Name :: "+name);
    }
    @Test
    public void printStudentByfindByGuardianName(){
        List<Student> name = studentRepository.findByGuardianName("ethan");
        System.out.println("Studeent Name :: "+name);
    }

    @Test
    public void printStudentGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("mani@gmail.com");
        System.out.println("Student Data = "+student);
    }

    @Test
    public void printStudentGetStudentFirstNameByEmailAddress(){
        String student = studentRepository.getStudentFirstNameByEmailAddress("mani@gmail.com");
        System.out.println("Student Data = "+student);
    }

    @Test
    public void printStudentGetStudentByEmailAddressByNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("mani@gmail.com");
        System.out.println("Student Data = "+student);
    }

    @Test
    public void printStudentGetStudentByEmailAddressByNativeParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("mani@gmail.com");
        System.out.println("Student Data = "+student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        int value = studentRepository.updateStudentNameByEmailId("mani", "mani@gmail.com");
        System.out.println("value :: "+value);
    }
}