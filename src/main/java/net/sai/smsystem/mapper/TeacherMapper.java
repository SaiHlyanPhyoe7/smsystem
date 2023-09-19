package net.sai.smsystem.mapper;

import net.sai.smsystem.dto.TeacherDto;
import net.sai.smsystem.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherDto mapToTeacherDto(Teacher teacher);

    Teacher mapToTeacher(TeacherDto teacherDto);
}
