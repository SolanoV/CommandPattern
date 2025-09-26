package commands;

import interfaces.Command;
import interfaces.Device;

public class DevicePower implements Command {
    private Device device;
    private boolean on;

    public DevicePower(Device device, boolean on) {
        this.device = device;
        this.on = on;
    }
    public boolean getOn(){
        return on;
    }

    @Override
    public String execute() {
        return on? device.turnOn() : device.turnOff();
    }
}
