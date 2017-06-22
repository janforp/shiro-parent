package com.janita.project.service.base;

import com.janita.project.dao.StudentDAO;
import com.janita.project.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017/6/21 0021-下午 1:21
 * 该类是：
 */
@Service
public class StudentService {

    private final StudentDAO studentDAO;

    @Autowired(required = false)
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Student create(Student student) {
        studentDAO.insert(student);
        return student;
    }

    public void delete(String studentId) {
        studentDAO.deleteByPrimaryKey(studentId);
    }

    public Student update(Student student){
        studentDAO.updateByPrimaryKey(student);
        return student;
    }

    public Student find(String  studentId) {
        return studentDAO.selectByPrimaryKey(studentId);
    }
}
