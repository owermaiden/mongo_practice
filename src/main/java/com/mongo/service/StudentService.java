package com.mongo.service;

import com.mongo.documents.Student;
import com.mongo.repository.StudentRepository;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> getAll();

    List<Student> getByScore(int score);

    List<Student> getBySpringQuery(String firstName);

    List<Student> getBylastName(String lastName);
}
