package com.aadim.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "psd")
@Builder
public class PersonalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="psd_firstname")
    private String firstname;

    @Column(name="psd_lastname")
    private String lastname;

    @Column(name="psd_dateOfBirth")
    private Date dateOfBirth;

    @Column(name="psd_age")
    private Integer age;

    @Column(name="psd_email")
    private String email;

    @Column(name="psd_phone")
    private String phone;

    @OneToMany(mappedBy = "personalDetail")
    private List<FamilyDetail> familyDetailArray;
}
