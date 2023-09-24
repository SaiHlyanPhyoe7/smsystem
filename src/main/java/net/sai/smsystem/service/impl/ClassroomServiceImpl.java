package net.sai.smsystem.service.impl;

import net.sai.smsystem.dto.ClassroomDto;
import net.sai.smsystem.entity.Classroom;
import net.sai.smsystem.exception.ResourceNotFoundException;
import net.sai.smsystem.mapper.ClassroomMapper;
import net.sai.smsystem.repository.ClassroomRepository;
import net.sai.smsystem.service.ClassroomService;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Classroom> classrooms = classroomRepository.findAll();
        return classrooms.stream().map(classroomMapper::mapToClassroomDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClassroomDto updateClassroom(Long classroomId, ClassroomDto updateClassroom) {
        Classroom classroom= classroomRepository.findById(classroomId)
                .orElseThrow(() -> new ResourceNotFoundException("Classroom not found with this id : " + classroomId)
                );
        classroom.setClassName(updateClassroom.getClassName());
        classroom.setClassType(updateClassroom.getClassType());
        classroom.setStudentCount(updateClassroom.getStudentCount());
        classroom.setTeacherCount(updateClassroom.getTeacherCount());

        Classroom updateClassroomObj = classroomRepository.save(classroom);
        return classroomMapper.mapToClassroomDto(updateClassroomObj);
    }

    @Override
    public void deleteClassroom(Long classroomId) {
        Classroom classroom= classroomRepository.findById(classroomId)
                .orElseThrow(()->new ResourceNotFoundException("Classroom not found with this id : " + classroomId));
        classroomRepository.delete(classroom);
    }
}
