package edu.miu.cs.cs425.sahid.mystudentmgmtapp.service;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Student;

import java.util.List;

public interface ClassroomService {
    Classroom saveClassroom(Classroom classroom);
    List<Classroom> getAllClassrooms();
    Classroom getClassroomById(Integer id);
    Classroom updateClassroom(Classroom classroom);
    void deleteClassroom(Classroom classroom);
}
