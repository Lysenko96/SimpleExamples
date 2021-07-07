package edu.lysenko.patterns.creational.builder;

public interface Compose {

	void setProductType(ProductType type);

	void setGenre(String genre);
	
	void setTableOfContents(String tableOfContents);

	void setContent(String content);
}
