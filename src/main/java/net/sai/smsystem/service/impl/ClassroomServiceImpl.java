package net.sai.smsystem.service.impl;

import net.sai.smsystem.dto.ClassroomDto;
import net.sai.smsystem.entity.Classroom;
import net.sai.smsystem.exception.ResourceNotFoundException;
import net.sai.smsystem.mapper.ClassroomMapper;
import net.sai.smsystem.repository.ClassroomRepository;
import net.sai.smsystem.service.ClassroomService;

import java.util.List;

public class ClassroomServiceImpl implements ClassroomService {

    private ClassroomRepository classroomRepository;
    private ClassroomMapper classroomMapper;

    @Override
    public ClassroomDto createClassroom(ClassroomDto classroomDto) {

        Classroom classroom = classroomMapper.mapToClassroom(classroomDto);
        Classroom saveClassroom = classroomRepository.save(classroom);

        return classroomMapper.mapToClassroomDto(saveClassroom);
    }

    @Override
    public ClassroomDto getClassroomById(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(()-> new ResourceNotFoundException("Classroom not found with this id : " + classroomId));
        return classroomMapper.mapToClassroomDto(classroom);
    }

    @Override
    public List<ClassroomDto> getAllClassroom() {
        return null;
    }

    @Override
    public ClassroomDto updateClassroom(Long classroomId, ClassroomDto classroomDto) {
        return null;
    }

    @Override
    public void deleteClassroom(Long classroomId) {

    }
}
