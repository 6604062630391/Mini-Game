import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class MusicThread extends Thread {
    private Clip clip;
    private String currentMusic = "";


    public void playMusic(String musicFilePath, boolean loop) {
        if (currentMusic.equals(musicFilePath)) {
            return; // Don't play the same music again
        }

        stopMusic();
        try {
            File musicFile = new File(musicFilePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(musicFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);


            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }

            currentMusic = musicFilePath;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void stopAllMusic() {
        stopMusic();
        currentMusic = "";
    }
}
