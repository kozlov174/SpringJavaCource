package com.example.labwork7.controllers;

import com.example.labwork7.dao.StudyGroupRepository;
import com.example.labwork7.entity.StudyGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Slf4j
@RestController
public class StudyGroupController {

    private final StudyGroupRepository studyGroupRepository;

    @Autowired
    public StudyGroupController(StudyGroupRepository studyGroupRepository) {
        this.studyGroupRepository = studyGroupRepository;
    }

    @GetMapping("/listGroups")
    public ModelAndView getAllStudyGroups(){
        ModelAndView nav = new ModelAndView("list-studygroups");
        nav.addObject("studygroups", studyGroupRepository.findAll());
        return nav;
    }

    @GetMapping("/addStudyGroupForm")
    public ModelAndView addStudyGroupForm(){
        ModelAndView nav = new ModelAndView("add-studygroup-form");
        StudyGroup studyGroup = new StudyGroup();
        nav.addObject("studygroup", studyGroup);
        return nav;
    }

    @PostMapping("/saveStudyGroup")
    public RedirectView saveStudyGroup(@ModelAttribute StudyGroup studyGroup){
        studyGroupRepository.save(studyGroup);
        return new RedirectView("listGroups");
    }

    @GetMapping("/showUpdateGroupForm")
    public ModelAndView showUpdateGroupForm(@RequestParam Long groupId){
        ModelAndView nav = new ModelAndView("add-studygroup-form");
        Optional<StudyGroup> optionalStudyGroup = studyGroupRepository.findById(Math.toIntExact(groupId));
        StudyGroup studyGroup = new StudyGroup();
        if(optionalStudyGroup.isPresent()) {
            studyGroup = optionalStudyGroup.get();
        }
        nav.addObject("studygroup", studyGroup);
        return nav;
    }

    @GetMapping("/deleteStudyGroup")
    public RedirectView deleteStudyGroup(@RequestParam Long groupId, ModelAndView model){
        studyGroupRepository.deleteById(Math.toIntExact(groupId));
        return new RedirectView("listGroups");
    }
}

