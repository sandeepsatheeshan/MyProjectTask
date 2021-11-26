package com.projectreact.task.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.projectreact.task.entity.Squences;
import com.projectreact.task.entity.Task;
import com.projectreact.task.repo.TaskRepo;

@Service
public class TaskServices {
	@Autowired
	TaskRepo tr;
	
	@Autowired
	TaskServices ts;
	
	@Autowired
	private MongoOperations mongo;
	
	public int getNextSquence(String seqname) {
		Squences counter=mongo.findAndModify(query(where("_id").is(seqname)),
			new Update().inc("squ",1),
			options().returnNew(true).upsert(true),
			Squences.class);
		return counter.getSqu();
	}
	
	public Task savetask(Task t) {
		t.setId(ts.getNextSquence(Task.Squence_Name));
		t.setStatus("created");
		tr.save(t);
		return t;
	}
	
	public List<Task> display(){
		return tr.findAll();
	}
	public void deletetask(int id) {
		tr.deleteById(id);
	}
	public Task taskupdate(int id) {
		
		Optional<Task> li=tr.findById(id);
		Task t=li.get();
		t.setStatus("completed");
		tr.save(t);
		return t;
	}

}
