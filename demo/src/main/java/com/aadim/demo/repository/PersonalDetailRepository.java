package com.aadim.demo.repository;

import com.aadim.demo.entity.PersonalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDetailRepository extends JpaRepository<PersonalDetail, Integer> {
}
