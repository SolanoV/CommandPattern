package devices;

import interfaces.Device;
import interfaces.Variables;

import java.util.Scanner;

public class MusicPlayer implements Device, Variables {
    private boolean turnedOn;
    public static boolean isPlaying=false;
    private int playlist=1;
    private int volume=100;
    private int defaultVolume;

    public String play(){
        if(isPlaying){
            return "[Currently Playing \""+playlistDict(playlist)+"\"]";
        }
        else{
            isPlaying=true;
            return turnedOn?"[Playing Music \""+playlistDict(playlist)+"\"]":"[Turn it on first]";
        }

    }

    public String pause(){
        if(!isPlaying){
            return "[Currently Paused]";
        }
        else{
            isPlaying=false;
            return !isPlaying?"[Paused Music \""+playlistDict(playlist)+"\"]":"[Already paused]";
        }

    }


    public String changePlaylist(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a playlist: ");
        System.out.println("1. Beatles Album");
        System.out.println("2. Classical Music");
        System.out.println("3. Hip-hop Playlist");
        System.out.print("Pick a number: ");
        char choice = scanner.next().charAt(0);
        playlist = choice-'0';
        return "[Currently playing "+playlistDict(playlist)+"]\n";
    }

    public String playlistDict(int playlist){//helper method
        if(playlist==1) return "Beatles Album";
        else if(playlist==2) return "Classical Music";
        else if(playlist==3) return "Hip-hop Playlist";
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
        if(turnedOn){return "[Music Player already turned on, volume at "+volume+"%]";}
        else {
            turnedOn=true;
            return "[Music Player turned on, volume at "+volume+"%]";
        }
    }

    @Override
    public String turnOff() {
        if(!turnedOn){return "[Music Player already turned off]";}
        else{
            turnedOn=false;
            volume=defaultVolume;
            return "[Music Player turned off]";
        }
    }

    @Override
    public String setValue(int value) {
        if(value<0||value>100)volume=100;
        else volume = value;
        return "Set volume to "+volume+"%";
    }

    @Override
    public String setDefaultValue(int defaultValue) {
        if(defaultValue<0||defaultValue>100)defaultVolume=100;
        else defaultVolume = defaultValue;
        return "Set default volume to "+defaultVolume+"%";
    }
}
