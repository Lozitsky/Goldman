package com.kirilo.game.utils;

import javax.swing.*;
import java.awt.*;

public class MessageManager {
    public static void showInformMessage(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Message Dialog", JOptionPane.PLAIN_MESSAGE);
    }
}
