package net.sai.smsystem.controller;

import lombok.AllArgsConstructor;
import net.sai.smsystem.service.ClassroomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/classrooms")
public class ClassroomController {
    private ClassroomService classroomService;
}
