package edu.lysenko.patterns.creational.builder;

public class Song {

	private ProductType type;
	private String genre;
	private String tableOfContents;
	private String content;

	public Song() {
	}

	public Song(ProductType type, String genre, String tableOfContents, String content) {
		this.type = type;
		this.genre = genre;
		this.tableOfContents = tableOfContents;
		this.content = content;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTableOfContents() {
		return tableOfContents;
	}

	public void setTableOfContents(String tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Song [type=" + type + ", genre=" + genre + ", tableOfContents=" + tableOfContents + ", content="
				+ content + "]";
	}
}
