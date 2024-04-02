import java.util.Scanner;


public class Mäng {
    int algusPunktid;
    Mängija mängija1;
    Mängija mängija2;


    public Mäng(int algusPunktid, Mängija mängija1, Mängija mängija2) {
        this.algusPunktid = algusPunktid;
        this.mängija1 = mängija1;
        this.mängija2 = mängija2;
    }

    // mingi oopimise error et kui panna = alguspunktid siis võtab 0, mitte 301. idk
    int jääkMängija1 = 301; // = algusPunktid;
    int jääkMängija2 = 301; // = algusPunktid;

    public static void lisa(Mängija mängija, int vise) {
        mängija.kõikVisked.add(vise);
    }

    public static void eemalda() {
    }

    public static int number(String skoor) { // saab veel cleanimaks, arusaadavamaks teha
        if (skoor.toLowerCase().startsWith("d")) {
            if (Integer.parseInt(skoor.substring(1)) >= 0 && Integer.parseInt(skoor.substring(1)) <= 20)
                return Integer.parseInt(skoor.substring(1)) * 2;
        } else if (skoor.toLowerCase().startsWith("t")) {
            if (Integer.parseInt(skoor.substring(1)) >= 0 && Integer.parseInt(skoor.substring(1)) <= 20)
                return Integer.parseInt(skoor.substring(1)) * 3;
        } else {
            if (Integer.parseInt(skoor) == 50) return 50;
            else if (Integer.parseInt(skoor) == 25) return 25;
            else if (Integer.parseInt(skoor) >= 0 && Integer.parseInt(skoor) <= 20) return Integer.parseInt(skoor);
        }
        System.out.println("Viga. Sisesta korrektne number! (numbrid 1-20, 25, 50 või nt D15 või T20)");
        return -1;
    }

    public void mängi() {
        int round = 1;
        Scanner scanner = new Scanner(System.in); // Loome skanneri ainult üks kord

        lõppedes:
        while (true) {

            int enneRoundiJääk1 = jääkMängija1;
            int enneRoundiJääk2 = jääkMängija2;
            int[] roundiVisked = new int[3];
            String scanned;

            // Mängija1
            System.out.println(mängija1.getNimi() + " jääk " + jääkMängija1);
            for (int i = 1; i <= 3; i++) {

                int visketabamus = 0;
                System.out.print("Sisesta " + i + ". tabamus: ");

                scanned = scanner.nextLine();
                int number = number(scanned);
                if (number == -1) {
                    i--;
                    continue;
                }
                roundiVisked[i - 1] = number;
                visketabamus += number;

                // kui viskega läks jääk lõhki
                if ((jääkMängija1 - visketabamus) < 0) {
                    System.out.println("Viskasid lõhki!");
                    jääkMängija1 = enneRoundiJääk1;
                    break;
                }

                jääkMängija1 -= visketabamus;

                // kui visati täpselt jääk nulli
                if (jääkMängija1 == 0) {
                    System.out.println("Võitis " + mängija1.getNimi() + "!");
                    break lõppedes;
                }
                System.out.println(mängija1.getNimi() + " jääk: " + jääkMängija1 + " pärast " + i + ". viset.");
            }

            // lisab kõik kolm viset listi alles nüüd, kui tsükkel tehtud ja lõhki ei läind
            lisa(mängija1, roundiVisked[0]);
            lisa(mängija1, roundiVisked[1]);
            lisa(mängija1, roundiVisked[2]);

            // Mängija2
            System.out.println(mängija2.getNimi() + " jääk " + jääkMängija2);
            for (int i = 1; i <= 3; i++) {

                int visketabamus = 0;
                System.out.print("Sisesta " + i + ". tabamus: ");

                scanned = scanner.nextLine();
                int number = number(scanned);
                if (number == -1) {
                    i--;
                    continue;
                }
                roundiVisked[i - 1] = number;
                visketabamus += number;

                // kui viskega läks jääk lõhki
                if ((jääkMängija2 - visketabamus) < 0) {
                    System.out.println("Viskasid lõhki!");
                    jääkMängija2 = enneRoundiJääk2;
                    break;
                }

                jääkMängija2 -= visketabamus;

                // kui visati täpselt jääk nulli
                if (jääkMängija2 == 0) {
                    System.out.println("Võitis " + mängija2 + "!");
                    break lõppedes;
                }
                System.out.println(mängija2.getNimi() + " jääk: " + jääkMängija2 + " pärast " + i + ". viset.");
            }

            // lisab kõik kolm viset listi alles nüüd, kui tsükkel tehtud ja lõhki ei läind
            lisa(mängija2, roundiVisked[0]);
            lisa(mängija2, roundiVisked[1]);
            lisa(mängija2, roundiVisked[2]);


            round += 1;
            System.out.println();
            System.out.println(mängija1.getNimi() + " skoor: " + jääkMängija1 + " pärast " + round + ". roundi.");
            System.out.println(mängija2.getNimi() + " skoor: " + jääkMängija2 + " pärast " + round + ". roundi.");
            System.out.println();
        }

        // mäng lõppenud, väljastab viimased andmed

        scanner.close();
    }

}

