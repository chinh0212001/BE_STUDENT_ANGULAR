package chinh.linh.controller;

import chinh.linh.dto.reponse.ResponseMessage;
import chinh.linh.model.Students;
import chinh.linh.model.User;
import chinh.linh.security.userpincal.UserDetailService;
import chinh.linh.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/student" )
public class StudentController {
    @Autowired
    IStudentService studentService;
    @Autowired
    UserDetailService userDetailService;

    @PostMapping
    public ResponseEntity<?> createStudents(@Valid @RequestBody Students students) {
        User user = userDetailService.getCurrentUser();
        if (user.getUsername().equals("Anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("chua login nhe!"), HttpStatus.OK);
        }
        if (user.getAvatar().trim().equals("")) {
            return new ResponseEntity<>(new ResponseMessage("avatar_null"), HttpStatus.OK);
        }
        students.setUser(user);
        studentService.save(students);
        return new ResponseEntity<>(new ResponseMessage("create_success!!!"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> showListStudent() {
        List<Students> studentsList = studentService.findAll();
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        if (!studentService.findById(id).isPresent()) {
            return new ResponseEntity<>(new ResponseMessage("not_found"), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentService.findById(id).get(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteStudentById(@PathVariable Long id){
        Optional<Students>students = studentService.findById(id);
        if (!students.isPresent()){
            return new ResponseEntity<>(new ResponseMessage("not_found"),HttpStatus.OK);
        }
        studentService.deleteById(id);
        return new ResponseEntity<>(new ResponseMessage("delete_success!!!"),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>updateStudentById(@PathVariable Long id, @RequestBody Students students ){
        Optional<Students>students1 = studentService.findById(id);
        if (!students1.isPresent()){
            return new ResponseEntity<>(new ResponseMessage("not_found"),HttpStatus.OK);
        }
        if (students.getName().trim().equals("")){
            return new ResponseEntity<>(new ResponseMessage("name_student_invalid"),HttpStatus.OK);
        }
        students1.get().setName(students.getName());
        //muon sua gi thi them vao
//        students1.get().setAge(students.getAge());
//        students1.get().setAvatar(students.getAvatar());
//        students1.get().setAddress(students.getAddress());
        studentService.save(students1.get());
        return new ResponseEntity<>(new ResponseMessage("update_success!!!"),HttpStatus.OK);
    }
    //tim kiem gan dung
    @GetMapping("search/{name}")
    public ResponseEntity<?>searchStudentByName(@PathVariable String name){
        if (name.trim().equals("")){
            return new ResponseEntity<>(new ResponseMessage("not_found"),HttpStatus.OK);
        }
        return new ResponseEntity<>(studentService.findAllByNameContaining(name),HttpStatus.OK);
    }
}
