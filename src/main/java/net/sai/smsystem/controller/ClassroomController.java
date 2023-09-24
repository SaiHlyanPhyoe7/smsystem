package net.sai.smsystem.controller;

import lombok.AllArgsConstructor;
import net.sai.smsystem.dto.ClassroomDto;
import net.sai.smsystem.service.ClassroomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
    private ClassroomService classroomService;

//    Build Add Classroom REST API
    @PostMapping
    public ResponseEntity<ClassroomDto> createClassroom(@RequestBody ClassroomDto classroomDto){
        ClassroomDto saveClassroom = classroomService.createClassroom(classroomDto);
        return new ResponseEntity<>(saveClassroom, HttpStatus.CREATED);
    }

//    Build Get Classroom by id REST API
    @GetMapping("{id}")
    public ResponseEntity<ClassroomDto> getClassroomById(@PathVariable("id") Long classroomId){
        ClassroomDto classroomDto = classroomService.getClassroomById(classroomId);
        return ResponseEntity.ok(classroomDto);
    }

//    Build Get all classrooms REST API
    @GetMapping
    public ResponseEntity<List <ClassroomDto>> getAllClassroom() {
        List<ClassroomDto> classrooms = classroomService.getAllClassroom();
        return ResponseEntity.ok(classrooms);
    }

//    Build Update Classroom Rest API
    @PutMapping("{id}")
    public ResponseEntity<ClassroomDto> updateClassroom(@PathVariable("id") Long classroomId,
                                                        @RequestBody ClassroomDto updateClassroom){
        ClassroomDto classroomDto = classroomService.updateClassroom(classroomId, updateClassroom);
        return ResponseEntity.ok(classroomDto);
    }

//    Build Delete Classroom REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClassroom(@PathVariable("id") Long classroomId){
        classroomService.deleteClassroom(classroomId);
        return ResponseEntity.ok("Classroom Deleted Success");
    }

}
