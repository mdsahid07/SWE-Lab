package edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.impl;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.repository.ClassroomRepository;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.ClassroomService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return List.of();
    }

    @Override
    public Classroom getClassroomById(Integer id) {
        return null;
    }

    @Override
    public Classroom updateClassroom(Classroom classroom) {
        return null;
    }

    @Override
    public void deleteClassroom(Classroom classroom) {

    }
}
