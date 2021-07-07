package edu.lysenko.patterns.creational.builder;

public class Director {

	void writePoem(Compose compose) {
		compose.setProductType(ProductType.POEM);
		compose.setGenre("poemGenre");
		compose.setTableOfContents("poemTableOfContents");
		compose.setContent("this is a poem");
	}

	void writeSong(Compose compose) {
		compose.setProductType(ProductType.SONG);
		compose.setGenre("songGenre");
		compose.setTableOfContents("songTableOfContents");
		compose.setContent("Bones");
	}
}
