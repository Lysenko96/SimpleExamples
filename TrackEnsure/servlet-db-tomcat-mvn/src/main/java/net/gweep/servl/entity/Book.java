package net.gweep.servl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	private int id;
	private String name;
	private String author;
	private Genre genre;
	private int pageCount;

	public Book(String name, String author, int pageCount, Genre genre) {
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.pageCount = pageCount;
	}
}