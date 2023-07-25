package com.fastcampus.programming.repository;

import com.fastcampus.programming.entity.RetiredDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetiredDeveloperRepository extends JpaRepository<RetiredDeveloper, Long> {
}
