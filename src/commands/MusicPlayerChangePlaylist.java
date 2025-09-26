package commands;

import devices.MusicPlayer;
import interfaces.Command;

public class MusicPlayerChangePlaylist implements Command {
    private MusicPlayer musicPlayer;

    public MusicPlayerChangePlaylist(MusicPlayer musicPlayer) {
        this.musicPlayer = new MusicPlayer();
    }

    @Override
    public String execute() {
        return musicPlayer.isTurnedOn()?"Turn on the Music Player first.":musicPlayer.changePlaylist();
    }
}
