package aoizora;

import java.util.ArrayList;
import java.util.List;

public class Benchmark {

    public void run() throws InterruptedException {
        List<Integer> objects = new ArrayList<>();
        Integer counter = 0;
        while (true) {
            counter += Integer.valueOf(1);
            for (int i = 0; i < 10; i++) {
                objects.add(Integer.valueOf(i));
            }
            objects.remove(objects.size() - 1);
            objects.remove(objects.size() - 1);

            if (counter % 10 == 0) {
                Thread.sleep(1);
            }
        }
    }
}
