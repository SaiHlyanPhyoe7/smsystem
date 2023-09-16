package net.sai.smsystem.mapper;

import net.sai.smsystem.dto.TeacherDto;
import net.sai.smsystem.entity.Teacher;

public class TeacherMapper {
    public static TeacherDto mapToTeacherDto(Teacher teacher){
        return new TeacherDto(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getEmail(),
                teacher.getSubject(),
                teacher.getAge(),
                teacher.getYearOfExperience()
        );
    }

    public static Teacher mapToTeacher(TeacherDto teacherDto){
        return new Teacher(
                teacherDto.getId(),
                teacherDto.getFirstName(),
                teacherDto.getLastName(),
                teacherDto.getEmail(),
                teacherDto.getSubject(),
                teacherDto.getAge(),
                teacherDto.getYearOfExperience()
        );
    }
}
