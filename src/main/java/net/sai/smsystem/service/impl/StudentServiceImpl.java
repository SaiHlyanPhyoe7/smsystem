package net.sai.smsystem.service.impl;

import lombok.AllArgsConstructor;
import net.sai.smsystem.dto.StudentDto;
import net.sai.smsystem.entity.Student;
import net.sai.smsystem.exception.ResourceNotFoundException;
import net.sai.smsystem.mapper.StudentMapper;
import net.sai.smsystem.repository.StudentRepository;
import net.sai.smsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student is not exist with the given id."+ studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student is not exist with given id : "+ studentId)
        );

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        student.setAge(updatedStudent.getAge());

        Student updatedStudentObj = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student= studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student is not exist with the given id."+ studentId)
                );
        studentRepository.deleteById(studentId);
    };
}
