package edu.lysenko.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	private int id;
	private String name;
	private String title;

	public Task(String name, String title) {
		this.name = name;
		this.title = title;
	}

}
