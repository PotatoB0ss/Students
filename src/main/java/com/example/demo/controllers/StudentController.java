package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getAll")
    public String getAll(Model model){
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "students";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<Student> getOne(Integer Id){
        return studentService.getOne(Id);
    }

    @PostMapping("/addNew")
    public String addNew(Student student){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        student.setUpdatedBy("PotatoBoss");
        student.setUpdatedOn(timeStamp);
        studentService.addNew(student);
        return "redirect:/students/getAll";
    }





}
