package edu.lysenko.patterns.creational.builder;

public class Poem {

	private ProductType type;
	private String genre;
	private String tableOfContents;
	private String content;

	public Poem() {

	}

	public Poem(ProductType type, String genre, String tableOfContents, String content) {
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
		return "Poem [type=" + type + ", genre=" + genre + ", tableOfContents=" + tableOfContents + ", content="
				+ content + "]";
	}

	static class InnerCompose {

		private Poem newPoem;

		InnerCompose() {
			newPoem = new Poem();
		}

		InnerCompose withType(ProductType type) {
			newPoem.type = type;
			return this;
		}

		InnerCompose withGenre(String genre) {
			newPoem.genre = genre;
			return this;
		}

		InnerCompose withTableOfContents(String tableOfContents) {
			newPoem.tableOfContents = tableOfContents;
			return this;
		}

		InnerCompose withContent(String content) {
			newPoem.content = content;
			return this;
		}

		Poem compose() {
			return newPoem;
		}
	}
}
