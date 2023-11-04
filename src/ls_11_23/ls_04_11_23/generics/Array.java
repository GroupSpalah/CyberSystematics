package ls_11_23.ls_04_11_23.generics;

public class Array<T extends Number> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}
