package com.aadim.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fmd")
public class FamilyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="fmd_familyFirstName")
    private String familyFirstname;

    @Column(name="fmd_familyLastName")
    private String familyLastname;

    @Column(name="fmd_familyDateOfBirth")
    private Date familyDateOfBirth;

    @Column(name="fmd_familyAge")
    private Integer familyAge;

    @Column(name="fmd_familyEmail")
    private String familyEmail;

    @Column(name="fmd_familyPhone")
    private String familyPhone;

    @ManyToOne
    @JsonBackReference //very important do not miss it
    @JoinColumn(name = "personal_detail_id")
    private PersonalDetail personalDetail;
}
