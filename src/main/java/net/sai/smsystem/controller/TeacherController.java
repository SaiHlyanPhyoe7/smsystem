package net.sai.smsystem.controller;

import lombok.AllArgsConstructor;
import net.sai.smsystem.dto.TeacherDto;
import net.sai.smsystem.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private TeacherService teacherService;

//    Build Add Teacher REST API
    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto){
        TeacherDto saveTeacher = teacherService.createTeacher(teacherDto);
        return new ResponseEntity<>(saveTeacher, HttpStatus.CREATED);
    }
}
