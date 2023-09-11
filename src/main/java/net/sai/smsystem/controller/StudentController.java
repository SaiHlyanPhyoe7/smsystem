package net.sai.smsystem.controller;

import lombok.AllArgsConstructor;
import net.sai.smsystem.dto.StudentDto;
import net.sai.smsystem.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

//    Build Add Student REST API
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto saveStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }
}
