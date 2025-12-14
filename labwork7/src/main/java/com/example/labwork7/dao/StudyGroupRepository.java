package com.example.labwork7.dao;

import com.example.labwork7.entity.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Integer> {

}

