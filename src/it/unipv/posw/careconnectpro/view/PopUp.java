package it.unipv.posw.careconnectpro.view;

import javax.swing.*;

public class PopUp {

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.PLAIN_MESSAGE, null);
    }
}
