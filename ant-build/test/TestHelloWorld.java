import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHelloWorld {

    @Test
    public void testHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals("Hello World!!!", helloWorld.sayHello());
    }
}
