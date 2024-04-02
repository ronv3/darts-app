import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {

        // nimesid peab veel kuidagi konsoolis küsima (set method)
        Mängija mängija1 = new Mängija("Ron");
        Mängija mängija2 = new Mängija("Reno");

        Mäng mäng = new Mäng(301, mängija1, mängija2);
        mäng.mängi();
        System.out.println(mängija1);
        System.out.println(mängija2);

    }
}