package ls_11_23.ls_04_11_23.figure;
/**
 * Создать интерфейс Calculatable с
 * абстрактным методом calculateSquare и default метод print, который печатает название фигуры
 *
 * Создать абстрактный класс Figure с полями(длина стороны, высота), который реализует интерфейс Calculatable.
 * Создать классы Triangle, Parallelogram, Romb. В классах наследниках переопределить метод calculateSquare,
 * для расчета площади. Протестировать функционал.
 */

public interface Calculatable {
    double calculateSquare();

    default void printName() {
        Class<? extends Calculatable> aClass = this.getClass();

        System.out.println(aClass.getSimpleName());
    }
}
