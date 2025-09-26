package commands;

import devices.MusicPlayer;
import interfaces.Command;

public class MusicPlayerStatus implements Command {
    private MusicPlayer musicPlayer;
    private boolean isPlaying;

    public MusicPlayerStatus(MusicPlayer musicPlayer, boolean isPlaying) {
        this.musicPlayer = musicPlayer;
        this.isPlaying = isPlaying;
    }
    @Override
    public String execute() {
        return isPlaying?musicPlayer.pause():musicPlayer.play();
    }
}
