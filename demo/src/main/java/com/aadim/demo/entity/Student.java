package com.aadim.demo.entity;

import com.aadim.demo.dto.request.StudentRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="stu")
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="stu_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_STU_ADDR"))
    private Address location;
    private Date createdOn;

    public Student(StudentRequest request){
        this.name = request.getName();
    }
}
