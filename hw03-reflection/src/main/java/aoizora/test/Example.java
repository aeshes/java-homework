package aoizora.test;

import aoizora.annotation.After;
import aoizora.annotation.Before;
import aoizora.annotation.Test;

public class Example {

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @Test
    public void testA() {
        System.out.println("Running test A");
        throw new RuntimeException("Tests that exceptions not stop testing");
    }

    @Test
    public void testB() {
        System.out.println("Running test B");
    }
}
