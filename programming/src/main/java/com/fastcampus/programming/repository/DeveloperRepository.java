package com.fastcampus.programming.repository;

import com.fastcampus.programming.dto.CreateDeveloper;
import com.fastcampus.programming.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Optional<Developer> findByMemberId(String memberId);
}
