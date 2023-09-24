package net.sai.smsystem.mapper;

import net.sai.smsystem.dto.ClassroomDto;
import net.sai.smsystem.entity.Classroom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {
    ClassroomDto mapToClassroomDto(Classroom classroom);

    Classroom mapToClassroom(ClassroomDto classroomDto);
}
