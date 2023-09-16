package net.sai.smsystem.service.impl;

import lombok.AllArgsConstructor;
import net.sai.smsystem.dto.TeacherDto;
import net.sai.smsystem.entity.Teacher;
import net.sai.smsystem.repository.TeacherRepository;
import net.sai.smsystem.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
//        Teacher teacher=
        return null;
    }

    @Override
    public TeacherDto getTeacherById(Long teacherId) {
        return null;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        return null;
    }

    @Override
    public TeacherDto updateTeacher(Long teacherId, TeacherDto teacherDto) {
        return null;
    }

    @Override
    public void deleteTeacher(Long teacherId) {

    }
}
