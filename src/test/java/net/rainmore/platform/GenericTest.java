package net.rainmore.platform;


import org.junit.After;
import org.junit.Before;
import org.springframework.context.annotation.ComponentScan;

public abstract class GenericTest {
    @Before
    public void setup() {
        System.out.println("Before");
    }

    @After
    public void verify() {
        System.out.println("After");
    }

}
