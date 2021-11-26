package com.projectreact.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectreact.task.entity.Task;
import com.projectreact.task.services.TaskServices;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class TaskControler {
	
	@Autowired
	TaskServices ts;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Task savingtask(@RequestBody Task t) {
		return ts.savetask(t);
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public List<Task> view(){
		return ts.display();
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public int delete(@PathVariable("id") int id) {
	  ts.deletetask(id);
	  return id;
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public Task update(@PathVariable("id") int id) {
		return ts.taskupdate(id);
		
	}
}
