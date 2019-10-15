package com.kirilo.game.interfaces.sound;

import com.kirilo.game.interfaces.listeners.MoveResultListener;

public interface SoundPlayer extends MoveResultListener {
    void startBackgroundMusic(String name);

    void stopBackgroundMusic();

    void playSound(String name, final boolean loop);
}
