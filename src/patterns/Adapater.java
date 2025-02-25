package patterns;

interface UsbDevice {
    void connect();
}

class MicroUsbDevice implements UsbDevice {
    @Override
    public void connect() {
        System.out.println("Micro USB device connected.");
    }
}

class MiniUsbDevice implements UsbDevice {
    @Override
    public void connect() {
        System.out.println("Mini USB device connected.");
    }
}

class TypeCUsbDevice implements UsbDevice {
    @Override
    public void connect() {
        System.out.println("Type-C USB device connected.");
    }
}

interface LightningConnector {
    void connectLightning();
}



class MicroUsbToLightningAdapter implements LightningConnector {
    // source device
    private MicroUsbDevice microUsbDevice;

    public MicroUsbToLightningAdapter(MicroUsbDevice microUsbDevice) {
        this.microUsbDevice = microUsbDevice;
    }

    // call the target device
    @Override
    public void connectLightning() {
        System.out.println("Adapter: Converting Micro USB to Lightning...");
        microUsbDevice.connect();
        System.out.println("Adapter: Lightning connection established.");
    }
}

class MiniUsbToLightningAdapter implements LightningConnector {
    private MiniUsbDevice miniUsbDevice;

    public MiniUsbToLightningAdapter(MiniUsbDevice miniUsbDevice) {
        this.miniUsbDevice = miniUsbDevice;
    }

    @Override
    public void connectLightning() {
        System.out.println("Adapter: Converting Mini USB to Lightning...");
        miniUsbDevice.connect();
        System.out.println("Adapter: Lightning connection established.");
    }
}

class TypeCToLightningAdapter implements LightningConnector {
    private TypeCUsbDevice typeCUsbDevice;

    public TypeCToLightningAdapter(TypeCUsbDevice typeCUsbDevice) {
        this.typeCUsbDevice = typeCUsbDevice;
    }

    @Override
    public void connectLightning() {
        System.out.println("Adapter: Converting Type-C to Lightning...");
        typeCUsbDevice.connect();
        System.out.println("Adapter: Lightning connection established.");
    }
}


public class Adapater {

    public static void main(String[] args) {


        MicroUsbDevice microDevice = new MicroUsbDevice();
        MiniUsbDevice miniDevice = new MiniUsbDevice();
        TypeCUsbDevice typeCDevice = new TypeCUsbDevice();

        LightningConnector microAdapter = new MicroUsbToLightningAdapter(microDevice);
        microAdapter.connectLightning();

        LightningConnector miniAdapter = new MiniUsbToLightningAdapter(miniDevice);
        miniAdapter.connectLightning();

        LightningConnector typeCAdapter = new TypeCToLightningAdapter(typeCDevice);
        typeCAdapter.connectLightning();

    }
}
