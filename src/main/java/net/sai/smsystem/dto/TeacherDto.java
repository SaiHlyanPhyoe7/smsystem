package net.sai.smsystem.dto;

import lombok.Data;

@Data
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String subject;
    private int age;
    private int yearOfExperience;
}
