package net.sai.smsystem.controller;

import lombok.AllArgsConstructor;
import net.sai.smsystem.dto.TeacherDto;
import net.sai.smsystem.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    Build Get Teacher by id REST API
    @GetMapping("id")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable("id") Long teacherId){
        TeacherDto teacherDto = teacherService.getTeacherById(teacherId);
        return ResponseEntity.ok(teacherDto);
    }

//    Build Get all Teachers REST API
    @GetMapping
    public ResponseEntity<List <TeacherDto>> getAllTeacher(){
        List<TeacherDto> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

//    Build Update Teacher REST API

    @PutMapping("{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable("id") Long teacherId,
                                                    @RequestBody TeacherDto updateTeacher){
        TeacherDto teacherDto = teacherService.updateTeacher(teacherId, updateTeacher);
        return ResponseEntity.ok(teacherDto);
    }
}
