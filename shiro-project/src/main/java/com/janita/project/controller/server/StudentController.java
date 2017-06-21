package com.janita.like.controller.server;

import com.janita.like.constant.PermissionConsts;
import com.janita.like.constant.RoleConsts;
import com.janita.like.dto.CreateStudentDto;
import com.janita.like.entity.Student;
import com.janita.like.result.ResultDto;
import com.janita.like.result.ResultDtoFactory;
import com.janita.like.service.base.StudentService;
import com.janita.like.util.CommonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    @RequiresRoles({RoleConsts.TEACHER})
    public ResultDto createStudent(@RequestBody @Validated CreateStudentDto studentDto) {
        Student student = new Student();
        student.setStudentId(CommonUtils.getRandomUUID());
        student.setAddress(studentDto.getAddress());
        student.setName(studentDto.getName());

        student = studentService.create(student);
        return ResultDtoFactory.toSuccess(student);
    }

    @RequiresPermissions({PermissionConsts.QUERY_STUDENT, PermissionConsts.CREATE_STUDENT})
    @GetMapping("/{studentId}")
    public Student find(@PathVariable String studentId) {
        return studentService.find(studentId);
    }
}
