package aoizora.agent;

import aoizora.annotation.Log;
import javassist.ByteArrayClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class ClassTransformer implements ClassFileTransformer {

    private ClassPool pool = ClassPool.getDefault();

    public byte[] transform(ClassLoader loader,
                            String className,
                            Class classBeingRedefined,
                            ProtectionDomain pd,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            pool.insertClassPath(new ByteArrayClassPath(className, classfileBuffer));
            CtClass cclass = pool.get(className.replace("/", "."));

            if (!cclass.getName().startsWith("aoizora")) {
                return null;
            }

            for (CtMethod method: cclass.getDeclaredMethods()) {
                Log annotation = (Log) method.getAnnotation(Log.class);
                if (annotation != null) {
                    method.insertBefore("{System.out.println(\"message\");}");
                }
            }

            return cclass.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
