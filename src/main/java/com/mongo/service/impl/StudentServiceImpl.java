package com.mongo.service.impl;

import com.mongo.documents.Student;
import com.mongo.repository.StudentRepository;
import com.mongo.service.StudentService;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    private final MongoTemplate mongoTemplate;

    public StudentServiceImpl(StudentRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Student> getByScore(int score) {
        return repository.getStudentsByScore(score);
    }

    @Override
    public List<Student> getBySpringQuery(String firstName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(firstName));
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> getBylastName(String lastName) {
        return repository.findBylastName(lastName);
    }

//    Query query = new Query();
//    query.addCriteria(Criteria.where("name").regex("^A"));
//    List<User> users = mongoTemplate.find(query,User.class);

//    all users that have names ending with c:
//    query.addCriteria(Criteria.where("name").regex("c$"));

//    all users between the ages of 20 and 50
//    query.addCriteria(Criteria.where("age").lt(50).gt(20));

//    sorting
//    query.with(Sort.by(Sort.Direction.ASC, "age"));

//    pageable
//    final Pageable pageableRequest = PageRequest.of(0, 2);
//    Query query = new Query();
//    query.with(pageableRequest);




}
