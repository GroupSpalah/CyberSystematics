package ls_11_23.ls_04_11_23;

import java.io.File;
import java.io.Serializable;

public class Man extends File implements Serializable, Cloneable {
    private String name;
    private int age;

    public Man(String name, int age) {
        super("");
        this.name = name;
        this.age = age;
    }
}
