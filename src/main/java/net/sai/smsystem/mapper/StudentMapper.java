package net.sai.smsystem.mapper;

import net.sai.smsystem.dto.StudentDto;
import net.sai.smsystem.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
          student.getId(),
          student.getFirstName(),
          student.getLastName(),
          student.getEmail(),
          student.getAge()
        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail(),
                studentDto.getAge()
        );
    }
}
