package ls_11_23.ls_07_11_23;

import java.util.List;

public class SuppressWarningExample {
    public static void main(String[] args) {

    }
}

class Machine {
    private List versions;
//    private List<Object> versions;

    /*   @SuppressWarnings("unchecked")
       // or*/
    @SuppressWarnings({"unchecked"})
    public void addVersion(String version) {
        versions.add(5);

        int b = 10;
        int a = 10;
    }
}
