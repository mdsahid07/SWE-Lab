package edu.miu.cs.cs425.sahid.eregister.controller.sysadmin;

import edu.miu.cs.cs425.sahid.eregister.model.Student;
import edu.miu.cs.cs425.sahid.eregister.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value={"secured/sysadmin/student"})
public class StudentController {
    private StudentService studentService;
    @Autowired  // Ensure Spring injects this dependency
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping(value = {"/index"})
    public String displaySysAdminPage() {
        return "secured/sysadmin/student/index";
    }
//    @GetMapping(value = {"/list"})
//    public String listStudents(Model model) {
//
//        List<Student> students = studentService.getAllStudents();
//
//        // Debugging - Print students in console
//        logger.info("Fetched Students: " + students);
//
//        model.addAttribute("students", students);
//        return "secured/sysadmin/student/list";
//    }

    @GetMapping("/list")
    public String listStudents(
            @RequestParam(value = "searchQuery", required = false) String searchQuery,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("studentId").ascending());  // Pagination setup

        Page<Student> studentPage;
        if (searchQuery != null && !searchQuery.isEmpty()) {
            studentPage = studentService.searchStudents(searchQuery, pageable);
            model.addAttribute("searchQuery", searchQuery);
        } else {
            studentPage = studentService.getAllStudents(pageable);
        }

        model.addAttribute("students", studentPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", studentPage.getTotalPages());
        model.addAttribute("totalStudents", studentPage.getTotalElements());

        return "secured/sysadmin/student/list";
    }
// Show the Student Registration Form
@GetMapping("/new")
public String showRegistrationForm(Model model) {
    model.addAttribute("student", new Student()); // Empty student object for form binding
    return "secured/sysadmin/student/register";
}

    // Handle Form Submission
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/secured/sysadmin/student/list"; // Redirect to the student list page
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "/secured/sysadmin/student/edit";
    }

    // Handle Update Request
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/secured/sysadmin/student/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);  // Call the delete method in service
        return "redirect:/secured/sysadmin/student/list";  // Redirect back to the list
    }

    @GetMapping(value = {"/search"})
    public ModelAndView searchStudents(
            @RequestParam String searchString,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        ModelAndView modelAndView = new ModelAndView();
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentPage = studentService.searchStudents(searchString, pageable);

        modelAndView.addObject("students", studentPage.getContent()); // List of students
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", studentPage.getTotalPages());
        modelAndView.addObject("totalItems", studentPage.getTotalElements());
        modelAndView.setViewName("secured/sysadmin/student/search-result");

        return modelAndView;
    }
}

