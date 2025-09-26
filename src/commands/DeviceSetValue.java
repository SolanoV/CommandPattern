package commands;

import interfaces.Command;
import interfaces.Variables;

public class DeviceSetValue implements Command {
    private Variables device;
    private int value;
    private boolean isDefault;
    private boolean isOn;

    public DeviceSetValue(Variables device, int value, boolean isOn) {
        this.device = device;
        this.value = value;
        this.isOn = isOn;
    }

    public DeviceSetValue(Variables device, int value, boolean isOn ,boolean isDefault) {
        this.device = device;
        this.value = value;
        this.isOn = isOn;
        this.isDefault=isDefault;
    }

    @Override
    public String execute() {
        if(isOn) {
            return isDefault ? device.setDefaultValue(value) : device.setValue(value);
        }
        else {
            return "Turn the device on first";
        }
    }
}
