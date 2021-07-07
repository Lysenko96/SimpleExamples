package edu.lysenko.patterns.creational.builder;

public class BuilderMain {

	public static void main(String[] args) {
		Director director = new Director();
		PoemCompose poemCompose = new PoemCompose();
		director.writePoem(poemCompose);
		SongCompose songCompose = new SongCompose();
		director.writeSong(songCompose);
		Poem poem = poemCompose.getResult();
		Song song = songCompose.getResult();
		System.out.println(poem);
		System.out.println(song);
		Poem myPoem = new Poem.InnerCompose().withType(ProductType.POEM).withGenre("genre").withTableOfContents("table")
				.withContent("my last poem").compose();
		System.out.println(myPoem);
	}
}
