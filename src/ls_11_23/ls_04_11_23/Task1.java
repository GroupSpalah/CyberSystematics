package ls_11_23.ls_04_11_23;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Modifier;

public class Task1 {
    public static void main(String[] args) {
        Man john = new Man("John", 32);

        Class<? extends Man> aClass = john.getClass();

        /*System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());*/

        Class<?> superclass = aClass.getSuperclass();

//        System.out.println(superclass.getSimpleName());

        Class<?>[] interfaces = aClass.getInterfaces();

        for (Class<?> anInterface : interfaces) {
//            System.out.println(anInterface.getSimpleName());
        }

        int modifiers = aClass.getModifiers();

        if (Modifier.isPublic(modifiers)) {
            System.out.println("Public");
        }
    }
}

