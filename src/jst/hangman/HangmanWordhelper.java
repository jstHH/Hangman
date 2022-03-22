package jst.hangman;

public class HangmanWordhelper {
    static String[] worte = {"hund", "giraffe", "auto", "regenrinne"};

    static String wortErmitteln() {
        int wortindex;

        wortindex = (int) (((double) worte.length) * Math.random());
        return worte[wortindex];
    }
}
