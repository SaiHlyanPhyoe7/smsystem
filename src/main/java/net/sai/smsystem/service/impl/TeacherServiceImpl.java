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

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher= TeacherMapper.mapToTeacher(teacherDto);
        Teacher saveTeacher= teacherRepository.save(teacher);

        return TeacherMapper.mapToTeacherDto(saveTeacher);
    }

    @Override
    public TeacherDto getTeacherById(Long teacherId) {
        Teacher teacher= teacherRepository.findById(teacherId)
                .orElseThrow(()-> new ResourceNotFoundException("Teacher is not exist with given id :" + teacherId));
        return TeacherMapper.mapToTeacherDto((teacher));
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map((teacher) -> TeacherMapper.mapToTeacherDto(teacher))
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto updateTeacher(Long teacherId, TeacherDto updateTeacher) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new ResourceNotFoundException("Teacher is not exist with given id :" + teacherId)
        );
        teacher.setFirstName(updateTeacher.getFirstName());
        teacher.setLastName(updateTeacher.getLastName());
        teacher.setEmail(updateTeacher.getEmail());
        teacher.setSubject(updateTeacher.getSubject());
        teacher.setAge(updateTeacher.getAge());
        teacher.setYearOfExperience(updateTeacher.getYearOfExperience());

        Teacher updatedTeacherObj = teacherRepository.save(teacher);

        return TeacherMapper.mapToTeacherDto(updatedTeacherObj);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        Teacher teacher= teacherRepository.findById(teacherId)
                .orElseThrow(()-> new ResourceNotFoundException("Teacher is no exist with given id " + teacherId)
                );
        teacherRepository.deleteById(teacherId);
    }
}
