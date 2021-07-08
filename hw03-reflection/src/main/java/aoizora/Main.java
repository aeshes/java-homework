package aoizora;

import aoizora.runner.Runner;
import aoizora.test.Example;

public class Main {

    public static void main(String[] args) {
        Class<Example> exampleClass = Example.class;
        new Runner(exampleClass).run();
    }
}
