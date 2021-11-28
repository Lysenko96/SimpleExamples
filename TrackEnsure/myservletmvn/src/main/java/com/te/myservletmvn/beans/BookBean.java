package com.te.myservletmvn.beans;

import java.util.List;

import com.te.myservletmvn.entity.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBean {

	private List<Book> books;
	
	public int getSize() {
		return books.size();
	}
}