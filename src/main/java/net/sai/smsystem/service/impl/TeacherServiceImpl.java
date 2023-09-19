package net.sai.smsystem.service.impl;

import lombok.AllArgsConstructor;
import net.sai.smsystem.dto.TeacherDto;
import net.sai.smsystem.entity.Teacher;
import net.sai.smsystem.exception.ResourceNotFoundException;
import net.sai.smsystem.mapper.TeacherMapper;
import net.sai.smsystem.repository.TeacherRepository;
import net.sai.smsystem.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private TeacherMapper teacherMapper;

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.mapToTeacher(teacherDto);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return teacherMapper.mapToTeacherDto(savedTeacher);
    }

    @Override
    public TeacherDto getTeacherById(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + teacherId));
        return teacherMapper.mapToTeacherDto(teacher);
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(teacherMapper::mapToTeacherDto).collect(Collectors.toList());
    }

    @Override
    public TeacherDto updateTeacher(Long teacherId, TeacherDto updateTeacher) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + teacherId));

        // Update teacher information
        teacher.setFirstName(updateTeacher.getFirstName());
        teacher.setLastName(updateTeacher.getLastName());
        teacher.setEmail(updateTeacher.getEmail());
        teacher.setSubject(updateTeacher.getSubject());
        teacher.setAge(updateTeacher.getAge());
        teacher.setYearOfExperience(updateTeacher.getYearOfExperience());

        Teacher updatedTeacher = teacherRepository.save(teacher);
        return teacherMapper.mapToTeacherDto(updatedTeacher);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + teacherId));
        teacherRepository.delete(teacher);
    }
}
