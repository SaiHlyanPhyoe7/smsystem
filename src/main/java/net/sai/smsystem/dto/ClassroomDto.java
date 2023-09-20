package net.sai.smsystem.dto;

import lombok.Data;

@Data
public class ClassroomDto {
    private Long id;
    private String className;
    private String classType;
    private int studentCount;
    private int teacherCount;
}
