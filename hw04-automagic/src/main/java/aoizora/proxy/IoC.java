package aoizora.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class IoC {

    public static TestInterface create() {
        InvocationHandler handler = new TestInvocationHandler(new TestClass());
        return (TestInterface) Proxy.newProxyInstance(IoC.class.getClassLoader(),
                new Class<?>[]{TestInterface.class}, handler);
    }

    static class TestInvocationHandler implements InvocationHandler {

        private final TestInterface target;

        public TestInvocationHandler(TestInterface target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Invoking method: " + method);
            Arrays.stream(args).forEach(System.out::println);
            return method.invoke(target, args);
        }
    }
}
