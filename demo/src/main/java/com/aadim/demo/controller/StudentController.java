package com.aadim.demo.controller;

import com.aadim.demo.dto.request.StudentRequest;
import com.aadim.demo.dto.response.StudentResponse;
import com.aadim.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/save")
    public StudentResponse save(@RequestBody StudentRequest request){
        return studentService.saveStudent(request);
    }

    @GetMapping("/fetch")
    public List<StudentResponse> getAll(){
        return studentService.getAllStudent();
    }

    @GetMapping("/fetch/{id}")
    public StudentResponse getById(@PathVariable Integer id){
        return studentService.getById(id);
    }

    @PutMapping("/update/{id}")
    public StudentResponse updateStudent(@PathVariable Integer id, @RequestBody StudentRequest request){
        return studentService.updateStudent(id, request);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }

}
