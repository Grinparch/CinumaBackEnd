/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.controller;

import tfg.Cinuma.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import tfg.Cinuma.service.StudentService;
import tfg.Cinuma.Modelo.Student;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 * @author ragcrix
 */
@RestController
@RequestMapping("/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/")
    public List<StudentDTO> getAllStudents() {
        return ObjectMapperUtils.mapAll(studentService.findAll(), StudentDTO.class);
    }

    @GetMapping(value = "/byStudentNumber/{studentNumber}")
    public StudentDTO getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber) {
        return ObjectMapperUtils.map(studentService.findByStudentNumber(studentNumber), StudentDTO.class);
    }

    @GetMapping(value = "/byEmail/{email}")
    public StudentDTO getStudentByEmail(@PathVariable("email") String email) {
        return ObjectMapperUtils.map(studentService.findByEmail(email), StudentDTO.class);
    }

    @GetMapping(value = "/orderByGpa")
    public List<StudentDTO> findAllByOrderByGpaDesc() {
        return ObjectMapperUtils.mapAll(studentService.findAllByOrderByGpaDesc(), StudentDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.saveOrUpdateStudent(ObjectMapperUtils.map(studentDTO, Student.class));
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{studentNumber}")
    public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable long studentNumber) {
        studentService.deleteStudentById(studentService.findByStudentNumber(studentNumber).getId());
        return new ResponseEntity("Student deleted successfully", HttpStatus.OK);
    }

}