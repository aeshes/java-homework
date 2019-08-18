package aoizora;

import aoizora.proxy.IoC;
import aoizora.proxy.TestInterface;

public class Main {

    public static void main(String[] args) {
        TestInterface test = IoC.create();
        test.add(1, 2);
        System.out.println(test.getClass().getName());
    }
}
