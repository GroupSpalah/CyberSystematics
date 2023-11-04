package ls_11_23.ls_04_11_23.figure;

public abstract class Figure implements Calculatable {
    private double length;
    private double heigth;

    public Figure(double length, double heigth) {
        this.length = length;
        this.heigth = heigth;
    }
}
