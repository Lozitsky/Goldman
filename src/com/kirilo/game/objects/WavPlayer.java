package com.kirilo.game.objects;

import com.kirilo.game.abstracts.AbstractMovingObject;
import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.interfaces.SoundObject;
import com.kirilo.game.interfaces.listeners.MoveResultListener;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WavPlayer implements MoveResultListener {
    public static final String DIE_WAV = "die.wav";

    @Override
    public void notifyActionResult(ActionResult actionResult, final AbstractMovingObject movingObject) {
        if (!(movingObject instanceof SoundObject)) {
            return;
        }
        playSound(((SoundObject) movingObject).getSoundName(actionResult),false,true);
    }

    public void playSound(String name, final boolean loop) {
        playSound(name, loop, false);
    }

    public void playSound(String name, final boolean loop, final boolean stopPrev) {
        if (name == null) {
            return;
        }
        URL url = getClass().getClassLoader().getResource("com/kirilo/game/sounds/" + name);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Wav file is " + (url == null ? null : url.getPath()));
        try {
            final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            SwingUtilities.invokeLater(() -> {
                try {
                    Clip clip = AudioSystem.getClip();
/*                    if (stopPrev && clip != null) {
                    clip.stop();
                    clip.close();
                }*/
                    clip.open(audioInputStream);
                    if (loop) {
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    } else {
                        clip.start();
                    }
//                    clip.stop();
                } catch (LineUnavailableException e) {
                    Logger.getLogger(WavPlayer.this.getClass().getName()).log(Level.SEVERE, "can't get clip!", e);
                } catch (IOException e) {
                    Logger.getLogger(WavPlayer.this.getClass().getName()).log(Level.SEVERE, "can't open audio clip", e);
                } finally {
                    if (audioInputStream != null) {
                        try {
                            audioInputStream.close();
                        } catch (IOException e) {
                            Logger.getLogger(WavPlayer.this.getClass().getName()).log(Level.SEVERE, "can't close audio stream", e);
                        }
                    }
                }
            });
        } catch (UnsupportedAudioFileException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "can't get audio stream", e);
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        }
    }
}
