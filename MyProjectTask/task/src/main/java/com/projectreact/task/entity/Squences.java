package com.projectreact.task.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="d_squence")
public class Squences {
	
	@Id
	private String id;
	private int squ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSqu() {
		return squ;
	}
	public void setSqu(int squ) {
		this.squ = squ;
	}

}
