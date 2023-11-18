package ls_11_23.ls_18_11_23.pattern.structural.adapter;

public class AdapterUsb extends MiniUsb implements MicroUsb {
    @Override
    public void readMicroUsb() {
        readMiniUsb();
    }

    @Override
    public void writeMicroUsb() {
        writeMiniUsb();
    }
}
