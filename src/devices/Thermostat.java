package devices;

import interfaces.Device;
import interfaces.Variables;

public class Thermostat implements Device, Variables {
    private boolean turnedOn;
    private int temperature=25;
    private int defaultTemperature=25;

    public boolean isTurnedOn(){
        if(!turnedOn){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String turnOn() {
        if(turnedOn){return "[Thermostat already turned on, temperature at "+ temperature+"°C]";}
        else {
            turnedOn=true;
            return "[Thermostat turned on, temperature at "+ temperature+"°C]";
        }
    }

    @Override
    public String turnOff() {
        if(!turnedOn){return "[Thermostat already turned off]";}
        else{
            turnedOn=false;
            return "[Thermostat turned off]";
        }
    }

    @Override
    public String setValue(int value) {
        if(value<16||value>25)temperature=25;
        else temperature = value;
        return "[Set brightness to "+temperature+"°C]";
    }

    @Override
    public String setDefaultValue(int defaultValue) {
        if(defaultValue<16||defaultValue>25)temperature=25;
        else defaultTemperature = defaultValue;
        return "[Set default temperature to "+defaultTemperature+"°C]";
    }
}
