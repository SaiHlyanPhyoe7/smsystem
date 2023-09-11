package net.sai.smsystem.service.impl;

import lombok.AllArgsConstructor;
import net.sai.smsystem.dto.StudentDto;
import net.sai.smsystem.entity.Student;
import net.sai.smsystem.mapper.StudentMapper;
import net.sai.smsystem.repository.StudentRepository;
import net.sai.smsystem.service.StudentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedEmployee = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(savedEmployee);
    }
}
