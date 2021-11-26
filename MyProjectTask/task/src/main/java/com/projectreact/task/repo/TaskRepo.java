package com.projectreact.task.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectreact.task.entity.Task;

public interface TaskRepo extends MongoRepository<Task, Integer> {

}
