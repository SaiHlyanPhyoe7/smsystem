package net.sai.smsystem.mapper;

import net.sai.smsystem.dto.StudentDto;
import net.sai.smsystem.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto mapToStudentDto(Student student);

    Student mapToStudent(StudentDto studentDto);
}
