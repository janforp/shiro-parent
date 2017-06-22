package com.janita.like.controller.server;

import com.janita.like.dto.CreateStudentDto;
import com.janita.like.entity.Student;
import com.janita.like.result.ResultDto;
import com.janita.like.result.ResultDtoFactory;
import com.janita.like.service.base.StudentService;
import com.janita.like.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Janita on 2017/6/21 0021-下午 1:16
 * 该类是：
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResultDto createStudent(@RequestBody @Validated CreateStudentDto studentDto) {
        Student student = new Student();
        student.setStudentId(CommonUtils.getRandomUUID());
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());

        student = studentService.create(student);
        return ResultDtoFactory.toSuccess(student);
    }

    @DeleteMapping("/delete")
    public ResultDto deleteStudent(@RequestParam("studentId") String studentId){
        studentService.delete(studentId);
        return ResultDtoFactory.toSuccess("删除成功");
    }

    @PutMapping("/update")
    public ResultDto update(@RequestBody Student student) {
        student.setStudentId(CommonUtils.getRandomUUID());
        student = studentService.update(student);
        return ResultDtoFactory.toSuccess(student);
    }

    @GetMapping("/find")
    public Student find(@RequestParam("studentId") String studentId) {
        return studentService.find(studentId);
    }
}
