package aoizora.loader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Loader extends ClassLoader {

    public Class<?> defineClass(String className) throws IOException {
        File file = new File(getFileName(className));
        byte[] bytecode = Files.readAllBytes(file.toPath());
        return super.defineClass(className, bytecode, 0, bytecode.length);
    }

    public String getFileName(String className) {
        return "src/main/java/aoizora" + File.separator + className.substring(className.lastIndexOf(".") + 1) + ".class";
    }
}
