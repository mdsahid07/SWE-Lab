package edu.miu.cs.cs425.sahid.mystudentmgmtapp;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Course;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Student;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Transcript;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.ClassroomService;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.CourseService;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.StudentService;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.TranscriptService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class MyStudentMgmtAppApplication{

    private final StudentService studentService;
    private final ClassroomService classroomService;
    private final TranscriptService transcriptService;
    private final CourseService courseService;

    public MyStudentMgmtAppApplication(StudentService studentService, ClassroomService classroomService, TranscriptService transcriptService, CourseService courseService) {
        this.studentService = studentService;
        this.classroomService = classroomService;
        this.transcriptService = transcriptService;
        this.courseService = courseService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Hello World");
            Transcript transcript = new Transcript("BS Computer Science");
            Classroom classroom=saveClassroom("McLaughlin building", "M105");
			System.out.println("New Student");

			saveStudent("000-61-0001", "Anna", "Lynn",
                    "Smith", 3.45, LocalDate.of(2019, 5, 24),transcript,classroom);

        };
    }
    public void saveStudent(String studentNumber, String firstName,String middleName, String lastName,double cgpa, LocalDate birthDate,Transcript transcript,Classroom classroom) {
        Course cs401 = new Course("CS401", "Modern Prog Practices");
        Course cs425 = new Course("CS425", "Software Engineering");
        Course cs435 = new Course("CS435", "Algorithms");

        // Save courses
        courseService.saveAll(List.of(cs401, cs425, cs435));

        Student s1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24), transcript,classroom);
        Set<Long> courseIds = new HashSet<>();
        courseIds.add(cs401.getCourseId());
        courseIds.add(cs425.getCourseId());

        Student savedStudent = studentService.registerStudent(s1, courseIds);
        System.out.println("Saved Student: " + savedStudent);
    }
    public Classroom saveClassroom(String bldingName,String roomNo){
        Classroom c1 = new Classroom(bldingName, roomNo);

        Classroom savedClassroom = classroomService.saveClassroom(c1);
       return savedClassroom;
    }
//    public Transcript saveTranscript(String name){
//        Transcript t1 = new Transcript(name);
//
//        Transcript savedTranscript = transcriptService.saveTranscript(t1);
//        return savedTranscript;
//    }
}
