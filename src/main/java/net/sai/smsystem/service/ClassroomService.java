package net.sai.smsystem.service;

import net.sai.smsystem.dto.ClassroomDto;

import java.util.List;

public interface ClassroomService {
    ClassroomDto createClassroom(ClassroomDto classroomDto);

    ClassroomDto getClassroomById(Long classroomId);

    List<ClassroomDto> getAllClassroom();

    ClassroomDto updateClassroom(Long classroomId, ClassroomDto classroomDto);

    void deleteClassroom(Long classroomId);
}
