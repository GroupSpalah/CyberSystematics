package ls_11_23.ls_18_11_23.pattern.creational.fabric_method;

public interface SomeVehicle {
    String getModel();
}

interface VehicleCreator {
    SomeVehicle getVehicle(String model);
}

class VehicleCreatorImpl implements VehicleCreator {
    @Override
    public SomeVehicle getVehicle(String model) {
        return switch (model) {
            case "Bmw" -> new Bmw();
            case "Ford" -> new Ford();
            case "Fiat" -> new Fiat();
            default -> new Bmw();
        };
    }
}

class Bmw implements SomeVehicle {
    @Override
    public String getModel() {
        return "Bmw";
    }
}
class Fiat implements SomeVehicle {
    @Override
    public String getModel() {
        return "Fiat";
    }
}

class Ford implements SomeVehicle {
    @Override
    public String getModel() {
        return "Ford";
    }
}

class TestFabricMethod {
    public static void main(String[] args) {
        VehicleCreator vc = new VehicleCreatorImpl();

        SomeVehicle bmw = vc.getVehicle("Bmw");

        System.out.println(bmw.getModel());
    }
}
