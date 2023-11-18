package ls_11_23.ls_18_11_23.pattern.behavorial.template_method;

public class TemplateMethod {
    public static void main(String[] args) {
        House wh = new WoodHouse();

//        wh.buildHouse();

        House gh = new GlassHouse();

        gh.buildHouse();
    }
}

abstract class House {
    private void foundation() {
        System.out.println("Install foundation");
    }
    private void pillars() {
        System.out.println("Install pillars");
    }

    abstract void windows();
    abstract void doors();

    public final void buildHouse() {
        foundation();
        pillars();
        windows();
        doors();
    }
}

class WoodHouse extends House {
    @Override
    void windows() {
        System.out.println("Install wood windows");
    }

    @Override
    void doors() {
        System.out.println("Install wood doors");
    }
}

class GlassHouse extends House {
    @Override
    void windows() {
        System.out.println("Install glass windows");
    }

    @Override
    void doors() {
        System.out.println("Install glass doors");
    }
}
