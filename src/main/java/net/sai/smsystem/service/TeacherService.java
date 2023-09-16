package net.sai.smsystem.service;

import net.sai.smsystem.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto createTeacher(TeacherDto teacherDto);

    TeacherDto getTeacherById(Long teacherId);

    List<TeacherDto> getAllTeachers();

    TeacherDto updateTeacher(Long teacherId, TeacherDto teacherDto);

    void deleteTeacher(Long teacherId);
}
