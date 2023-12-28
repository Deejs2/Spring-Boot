package com.aadim.demo.dto.response;

import com.aadim.demo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Integer id;
    private String name;
    private String address;

    public StudentResponse(Student student){
        this.id=student.getId();
        this.name=student.getName();
        this.address = student.getLocation().getStreet()+", "+student.getLocation().getState()+", "+student.getLocation().getCountry();
    }
}
