package com.te.myservletmvn.entity;

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
	private String genre;
	private int pageCount;

}