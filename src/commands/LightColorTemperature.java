package commands;

import devices.Light;
import interfaces.Command;

public class LightColorTemperature implements Command {
    private Light light;

    public LightColorTemperature(Light light) {
        this.light = light;
    }

    @Override
    public String execute() {
        return light.isTurnedOn()?light.changeColorTemperature():"Turn on the light first.";
    }
}
