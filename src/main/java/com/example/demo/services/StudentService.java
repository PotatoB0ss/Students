package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAllByOrderByIdAsc();
    }

    public Optional<Student> getOne(Integer Id){
        return studentRepository.findById(Id);
    }

    public void addNew(Student student){
        studentRepository.save(student);
    }


    public void update(Student student){
        studentRepository.save(student);
    }

    public void delete(Integer id){
        studentRepository.deleteById(id);
    }


}
