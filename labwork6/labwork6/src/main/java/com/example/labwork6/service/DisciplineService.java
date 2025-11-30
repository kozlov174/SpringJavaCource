package com.example.labwork6.service;

import com.example.labwork6.entity.Discipline;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface DisciplineService {

    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);

    void createDiscipline(Discipline discipline);

}
