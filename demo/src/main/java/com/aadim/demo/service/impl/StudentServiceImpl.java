package com.aadim.demo.service.impl;

import com.aadim.demo.dto.request.StudentRequest;
import com.aadim.demo.dto.response.StudentResponse;
import com.aadim.demo.entity.Address;
import com.aadim.demo.entity.Student;
import com.aadim.demo.repository.AddressRepository;
import com.aadim.demo.repository.StudentRepository;
import com.aadim.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    @Override
    public StudentResponse saveStudent(StudentRequest request) {
        Address address = addressRepository.getReferenceById(request.getAddressID());
        //from getters and setters
        Student student = new Student();
        student.setName(request.getName());
        student.setLocation(address);
        student.setCreatedOn(new Date());

        /*
        builder
        Student student1 = Student.builder()
                .address(request.getAddress())
                .name(request.getName())
                .build();

        //constructer
        Student student2 = new Student(request);
        */


        Student saveStudent = studentRepository.save(student);
        return new StudentResponse(saveStudent);


    }

    @Override
    public List<StudentResponse> getAllStudent(){
        List<StudentResponse> studentResponses = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for(Student student : students){
            studentResponses.add(new StudentResponse(student));
        }
        return studentResponses;
    }

    @Override
    public StudentResponse getById(Integer id){
        Student student = studentRepository.getReferenceById(id);
        return new StudentResponse(student);
    }

    @Override
    public StudentResponse updateStudent(Integer id, StudentRequest request){
        Student student = studentRepository.findById(id).orElse(null);
        if(student != null){
            student.setName(request.getName());
//            student.setLocation(request.getAddressID());
            Student saveStudent = studentRepository.save(student);
            return new StudentResponse(saveStudent);
        }
        return null;
    }

    @Override
    public String deleteStudent(Integer id){
        studentRepository.deleteById(id);
        return "Student with id "+id+" deleted successfully";
    }
}
