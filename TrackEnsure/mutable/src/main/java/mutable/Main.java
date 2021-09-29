package mutable;

import org.apache.commons.lang3.mutable.MutableInt;

public class Main {

	
	public static void main(String[] args) {
		System.out.println(Gorinich.headCount.toInteger());
		Gorinich.headCount.setValue(3);
		System.out.println(Gorinich.headCount.longValue());
	}
}

class Dragon {
	
	final static int headCount = 1;
}

class Gorinich {
	
	final static MutableInt headCount = new MutableInt(1);
}
