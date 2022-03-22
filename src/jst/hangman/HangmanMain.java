package jst.hangman;

import javax.swing.*;
import java.util.Locale;

public class HangmanMain {
    static String wort;
    static StringBuilder loesungsWort;
    static StringBuilder anzeigeWort;
    static int versuche = 10;
    static int anzahlTreffer;
    static boolean treffer = false;

    public static void main(String[] args) {

        wort = HangmanWordhelper.wortErmitteln();
        loesungsWort = new StringBuilder(wort);

        anzeigeWort = new StringBuilder();

        for (int i = 0; i <= loesungsWort.length() - 1; i++) {
            anzeigeWort.append("_");
        }

        while (versuche >= 1) {
            char zeichen = eingabeDialogAnzeigen();

            for (int i = 0; i <= loesungsWort.length()-1; i++) {
                if (loesungsWort.charAt(i) == zeichen){
                    treffer = true;
                    anzeigeWort.replace(i,i+1, String.valueOf(zeichen));
                    anzahlTreffer = anzahlTreffer + 1;
                }
            }
            if (treffer == true) {
                JOptionPane.showMessageDialog(null, "Treffer!\n\nSie haben weiterhin " + Integer.toString(versuche) + " Versuche.");
                treffer = false;
            }
            else {
                versuche = versuche - 1;
                JOptionPane.showMessageDialog(null, "Leider kein Treffer!\n\nSie haben noch " + Integer.toString(versuche) + " Versuche.");
            }


            if (anzahlTreffer == loesungsWort.length())
                spielenede(true);

        }

        spielenede(false);

    }

    static char eingabeDialogAnzeigen() {
        String zeichen = JOptionPane.showInputDialog("Sie Haben noch " + Integer.toString(versuche) + " Versuche.\n\nSuchwort: " + anzeigeWort.toString() + "\nGeben Sie ein Zeichen ein:").toLowerCase(Locale.ROOT);
        return zeichen.charAt(0);
    }

    static void spielenede(boolean gewonnen) {
        if (gewonnen == true)
            JOptionPane.showMessageDialog(null, "Das Spiel ist zuende.\nSie haben gewonnen");
        else
            JOptionPane.showMessageDialog(null, "Das Spiel ist zuende.\nSie haben leider verloren");

        System.exit(0);
    }

}
