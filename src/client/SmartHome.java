package client;

import commands.*;
import devices.Light;
import devices.MusicPlayer;
import devices.Thermostat;
import interfaces.Device;
import invoker.Remote;

import java.util.Scanner;

public class SmartHome {
    static Light light = new Light();
    static MusicPlayer musicPlayer = new MusicPlayer();
    static Thermostat thermostat = new Thermostat();

    static Remote remote=new Remote();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            System.out.println("Welcome to Smart Home Automation!: ");
            System.out.println("1. Light");
            System.out.println("2. Music Player");
            System.out.println("3. Thermostat ");
            System.out.println("4. Exit");
            System.out.print("Pick a device by picking a number: ");
            char choice = sc.next().charAt(0);
            System.out.println();
            switch(choice) {
                case '1':
                    lightMenu();
                    break;
                case '2':
                    mpMenu();
                    break;
                case '3':
                    thermostatMenu();
                    break;
                case '4':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

    }

    public static void lightMenu(){
        boolean isTrue=true;
        while(isTrue) {
            System.out.println("Light Controls:");
            System.out.println("1. On");
            System.out.println("2. Off");
            System.out.println("3. Set Brightness");
            System.out.println("4. Set Default Brightness");
            System.out.println("5. Change the Color Temperature");
            System.out.println("6. Back");
            System.out.print("Pick an option: ");
            char choice = sc.next().charAt(0);
            System.out.println();
            switch (choice) {
                case '1':
                    remote.setCommand(new DevicePower(light, true));
                    System.out.println(remote.pressButton());
                    break;
                case '2':
                    remote.setCommand(new DevicePower(light, false));
                    System.out.println(remote.pressButton());
                    break;
                case '3':
                    System.out.print("Set Brightness: ");
                    int brightness = sc.nextInt();
                    remote.setCommand(new DeviceSetValue(light, brightness, light.isTurnedOn()));
                    System.out.println(remote.pressButton());
                    break;
                case '4':
                    System.out.print("Set Default Brightness: ");
                    int defaultBrightness = sc.nextInt();
                    remote.setCommand(new DeviceSetValue(light, defaultBrightness, light.isTurnedOn(),true));
                    System.out.println(remote.pressButton());
                    break;
                case '5':
                    remote.setCommand(new LightColorTemperature(light));
                    System.out.println(remote.pressButton());
                    break;
                case '6':
                    isTrue=false;
                    break;
                default:
                    break;
            }
        }
    }
    public static void mpMenu(){
        boolean isTrue=true;
        while(isTrue) {
            System.out.println("Music Player Controls:");
            System.out.println("1. On");
            System.out.println("2. Off");
            System.out.println("3. Play");
            System.out.println("4. Pause");
            System.out.println("5. Change Playlist");
            System.out.println("6. Set Volume");
            System.out.println("7. Set Default Volume");
            System.out.println("8. Back");
            System.out.print("Pick an option: ");
            char choice = sc.next().charAt(0);
            System.out.println();
            switch (choice) {
                case '1':
                    remote.setCommand(new DevicePower(musicPlayer, true));
                    System.out.println(remote.pressButton());
                    break;
                case '2':
                    remote.setCommand(new DevicePower(musicPlayer, false));
                    System.out.println(remote.pressButton());
                    break;
                case '3':
                    remote.setCommand(new MusicPlayerStatus(musicPlayer, false));
                    System.out.println(remote.pressButton());
                    break;
                case '4':
                    remote.setCommand(new MusicPlayerStatus(musicPlayer, true));
                    System.out.println(remote.pressButton());
                    break;
                case '5':
                    remote.setCommand(new MusicPlayerChangePlaylist(musicPlayer));
                    System.out.println(remote.pressButton());
                    break;
                case '6':
                    System.out.print("Set Volume: ");
                    int volume = sc.nextInt();
                    remote.setCommand(new DeviceSetValue(musicPlayer, volume, musicPlayer.isTurnedOn()));
                    System.out.println(remote.pressButton());
                    break;
                case '7':
                    System.out.print("Set Default Volume: ");
                    int defaultVolume = sc.nextInt();
                    remote.setCommand(new DeviceSetValue(musicPlayer, defaultVolume, musicPlayer.isTurnedOn(),true));
                    System.out.println(remote.pressButton());
                    break;
                case '8':
                    isTrue=false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;

            }
        }
    }
    public static void thermostatMenu(){
        boolean isTrue=true;
        while(isTrue) {
            System.out.println("Thermostat Controls:");
            System.out.println("1. On");
            System.out.println("2. Off");
            System.out.println("3. Set Temperature");
            System.out.println("4. Set Default Temperature");
            System.out.println("5. Back");
            System.out.print("Pick an option: ");
            char choice = sc.next().charAt(0);
            System.out.println();
            switch (choice) {
                case '1':
                    remote.setCommand(new DevicePower(thermostat, true));
                    System.out.println(remote.pressButton());
                    break;
                case '2':
                    remote.setCommand(new DevicePower(thermostat, false));
                    System.out.println(remote.pressButton());
                    break;
                case '3':
                    System.out.print("Set Temperature (16 to 25): ");
                    int temperature = sc.nextInt();
                    remote.setCommand(new DeviceSetValue(thermostat, temperature, thermostat.isTurnedOn()));
                    System.out.println(remote.pressButton());
                    break;
                case '4':
                    System.out.print("Set Default Temperature (16 to 25): ");
                    int defaultTemperature = sc.nextInt();
                    remote.setCommand(new DeviceSetValue(thermostat, defaultTemperature, thermostat.isTurnedOn(),true));
                    System.out.println(remote.pressButton());
                    break;
                case '5':
                    isTrue=false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;

            }
        }
    }
}