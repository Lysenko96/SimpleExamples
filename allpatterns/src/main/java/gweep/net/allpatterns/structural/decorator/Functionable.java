package gweep.net.allpatterns.structural.decorator;

import java.util.Random;

public interface Functionable {

	int RESULT = new Random().nextInt(100);

	int addFunc();
}
