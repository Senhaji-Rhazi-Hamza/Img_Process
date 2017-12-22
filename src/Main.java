import space.Utils;
import test.testUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        abs1 a = new abs1();
        abs2 b = new abs2();
        abs c = new abs();
        ArrayList<abs> labs = new ArrayList<>();
        labs.add(a);
        labs.add((b));
        labs.add(c);
        for (abs lab : labs) lab.pr();



    }

}
