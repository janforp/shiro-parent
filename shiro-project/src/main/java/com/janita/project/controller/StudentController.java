package com.janita.project.controller;

import com.janita.project.entity.Student;
import com.janita.project.result.ResultDto;
import com.janita.project.result.ResultDtoFactory;
import com.janita.project.service.StudentService;
import com.janita.project.util.CommonUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Janita on 2017/6/21 0021-下午 1:16
 * 该类是：
 */
@RestController
@RequestMapping(value = "/stu")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @RequiresRoles({"老师"})
    public ResultDto createStudent(@RequestBody Student student) {
        student.setStudentId(CommonUtils.getRandomUUID());
        student = studentService.create(student);
        return ResultDtoFactory.toSuccess(student);
    }

    @GetMapping("/{studentId}")
    public Student find(@PathVariable String studentId) {
        return studentService.find(studentId);
    }
}
