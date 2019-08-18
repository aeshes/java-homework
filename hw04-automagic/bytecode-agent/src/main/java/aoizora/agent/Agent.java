package aoizora.agent;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String args, Instrumentation inst) {
        System.out.println("Premain");
        System.out.println("Classes loaded: " + inst.getAllLoadedClasses().length);
        inst.addTransformer(new ClassTransformer());
    }
}
