package net.sai.smsystem.service;

import net.sai.smsystem.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getEmployeeById(Long studentId);

    List<StudentDto> getAllStudents();
}
