package edu.lysenko.patterns.creational.builder;

public class PoemCompose implements Compose {

	private ProductType type;
	private String genre;
	private String tableOfContents;
	private String content;

	@Override
	public void setProductType(ProductType type) {
		this.type = type;
	}

	@Override
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public void setTableOfContents(String tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	@Override
	public void setContent(String content) {
		this.content = content;
	}

	public Poem getResult() {
		return new Poem(type, genre, tableOfContents, content);
	}

}
