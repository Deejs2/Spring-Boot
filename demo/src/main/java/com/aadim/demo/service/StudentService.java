package com.aadim.demo.service;

import com.aadim.demo.dto.request.StudentRequest;
import com.aadim.demo.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse saveStudent(StudentRequest request);

    List<StudentResponse> getAllStudent();

    StudentResponse getById(Integer id);

    StudentResponse updateStudent(Integer id,StudentRequest request);

    String deleteStudent(Integer id);
}
