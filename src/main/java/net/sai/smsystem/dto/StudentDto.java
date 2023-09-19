package net.sai.smsystem.dto;

import lombok.*;

@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
