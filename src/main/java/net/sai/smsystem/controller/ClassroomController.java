package net.sai.smsystem.controller;

import lombok.AllArgsConstructor;
import net.sai.smsystem.dto.ClassroomDto;
import net.sai.smsystem.service.ClassroomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/classrooms")
public class ClassroomController {
    private ClassroomService classroomService;

//    Build Add Classroom REST API
    @PostMapping
    public ResponseEntity<ClassroomDto> createClassroom(@RequestBody ClassroomDto classroomDto){
        ClassroomDto saveClassroom = classroomService.createClassroom(classroomDto);
        return new ResponseEntity<>(saveClassroom, HttpStatus.CREATED);
    }
}
