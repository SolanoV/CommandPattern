package devices;

import interfaces.Device;
import interfaces.Variables;

import java.util.Scanner;

public class Light implements Device, Variables {
    private int brightness=100;
    private int defaultBrightness=100;
    private int colorTemperature=1;
    private static boolean turnedOn=false;

    public String changeColorTemperature(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Color temperature: ");
        System.out.println("1. Warm (Yellowish)");
        System.out.println("2. Cool (White) ");
        System.out.println("3. Daylight (Bluish)");
        System.out.print("Pick a number: ");
        char choice = scanner.next().charAt(0);
        colorTemperature = choice - '0';
        return "Color temperature changed to "+colorTemperatureDict(colorTemperature);
    }

    public String colorTemperatureDict(int colorTemperature){//helper method
        if(colorTemperature==1) return "Warm (Yellowish)";
        else if(colorTemperature==2) return "Cool (White)";
        else if(colorTemperature==3) return "Daylight (Bluish)";
        else return "Warm (Yellowish)";
    }

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
        if(turnedOn){
            return "[Light already turned on, brightness at "+ brightness+"%, color temperature: "+colorTemperatureDict(colorTemperature)+"]";
        }
        else {
            turnedOn=true;
            return "[Light turned on, brightness at "+ brightness+"%, color temperature: "+colorTemperatureDict(colorTemperature)+"]";
        }

    }

    @Override
    public String turnOff() {
        if(!turnedOn){return "[Light already turned off]";}
        else{
            turnedOn=false;
            brightness=defaultBrightness;
            return "[Light turned off]";
        }
    }

    @Override
    public String setValue(int value) {
        if(value<0||value>100)brightness=100;
        else brightness = value;
        return "Set brightness to "+brightness+"%";
    }

    @Override
    public String setDefaultValue(int defaultValue) {
        if(defaultValue<0||defaultValue>100)brightness=100;
        else defaultBrightness = defaultValue;
        return "Set default brightness to "+defaultBrightness+"%";
    }
}
