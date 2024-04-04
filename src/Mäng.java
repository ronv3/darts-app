import java.util.ArrayList;
import java.util.List;
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

    public static void lisa(Mängija mängija, int vise) {
        mängija.kõikVisked.add(vise);
    }

    public static int number(String skoor) { // fsaab veel cleanimaks, arusaadavamaks teha
        if (skoor.toLowerCase().startsWith("d")) {
            if (Integer.parseInt(skoor.substring(1)) > 0 && Integer.parseInt(skoor.substring(1)) <= 20)
                return Integer.parseInt(skoor.substring(1)) * 2;
        } else if (skoor.toLowerCase().startsWith("t")) {
            if (Integer.parseInt(skoor.substring(1)) > 0 && Integer.parseInt(skoor.substring(1)) <= 20)
                return Integer.parseInt(skoor.substring(1)) * 3;
        } else {
            if (Integer.parseInt(skoor) == 50) return 50;
            else if (Integer.parseInt(skoor) == 25) return 25;
            else if (Integer.parseInt(skoor) >= 0 && Integer.parseInt(skoor) <= 20) return Integer.parseInt(skoor);
        }
        System.out.println("Viga. Sisesta korrektne number! (numbrid 0-20, 25, 50 või nt D15 või T20)");
        return -1;
    }

    public void mängi() {

        int jääkMängija1 = algusPunktid;
        int jääkMängija2 = algusPunktid;

        int round = 1;
        Scanner scanner = new Scanner(System.in); // Loome skanneri ainult üks kord

        System.out.println("Alustab " + mängija1.getNimi());
        lõppedes:
        while (true) {

            List<Integer> viskedRoundiKohta = new ArrayList<>();
            int enneRoundiJääk1 = jääkMängija1;
            int enneRoundiJääk2 = jääkMängija2;
            int[] roundiVisked = new int[3];
            String scanned;

            // Mängija1
            if (round == 1) {
                System.out.println("\n" + mängija1.getNimi() + " puntkid: " + jääkMängija1);
                System.out.println(mängija2.getNimi() + " punktid: " + jääkMängija2 + "\n");
            }

            System.out.println("Mängib " + mängija1.getNimi());

            for (int i = 1; i <= 3; i++) {

                System.out.print("Sisesta " + i + ". tabamus: ");

                scanned = scanner.nextLine();
                int number = number(scanned);
                if (number == -1) {
                    i--;
                    continue;
                }

                viskedRoundiKohta.add(number);

                // kui viskega läks jääk lõhki
                if ((jääkMängija1 - number) < 0) {
                    System.out.println("Viskasid lõhki!");
                    System.out.println("\n" + mängija1.getNimi() + " jääk: " + enneRoundiJääk1 + " pärast " + i + ". viset." + "\n");
                    jääkMängija1 = enneRoundiJääk1;
                    break;
                }

                jääkMängija1 -= number;

                // kui visati täpselt jääk nulli
                if (jääkMängija1 == 0) {
                    System.out.println("\n" + "Võitis " + mängija1.getNimi() + "!" + "\n");
                    break lõppedes;
                }
                System.out.println("\n" + mängija1.getNimi() + " jääk: " + jääkMängija1 + " pärast " + i + ". viset." + "\n");

                if (i == 3) {
                    System.out.println(mängija1.getNimi()+" viimased visatud visked: "+viskedRoundiKohta.get(0)+", "+viskedRoundiKohta.get(1)+", "+viskedRoundiKohta.get(2));
                    System.out.print("\n" + "Sisestasid numbrid õigesti? (J/E): ");
                    scanned = scanner.nextLine();
                    if (scanned.equalsIgnoreCase("e")) {
                        i -= 3;
                        for (int vise : viskedRoundiKohta)
                            jääkMängija1 += vise;
                    }
                }
            }


            // lisab kõik kolm viset listi alles nüüd, kui tsükkel tehtud ja lõhki ei läinud
            lisa(mängija1, viskedRoundiKohta.get(0));
            lisa(mängija1, viskedRoundiKohta.get(1));
            lisa(mängija1, viskedRoundiKohta.get(2));
            viskedRoundiKohta.clear();


            // Mängija 2
            if (round == 1) {
                System.out.println("\n" + mängija1.getNimi() + " puntkid: " + jääkMängija1);
                System.out.println(mängija2.getNimi() + " punktid: " + jääkMängija2 + "\n");
            }

            System.out.println("Mängib " + mängija2.getNimi());

            for (int i = 1; i <= 3; i++) {

                System.out.print("Sisesta " + i + ". tabamus: ");

                scanned = scanner.nextLine();
                int number = number(scanned);
                if (number == -1) {
                    i--;
                    continue;
                }

                viskedRoundiKohta.add(number);

                // kui viskega läks jääk lõhki
                if ((jääkMängija2 - number) < 0) {
                    System.out.println("Viskasid lõhki!");
                    System.out.println("\n" + mängija2.getNimi() + " jääk: " + enneRoundiJääk2 + " pärast " + i + ". viset." + "\n");
                    jääkMängija2 = enneRoundiJääk2;
                    break;
                }

                jääkMängija2 -= number;

                // kui visati täpselt jääk nulli
                if (jääkMängija2 == 0) {
                    System.out.println("\n" + "Võitis " + mängija2.getNimi() + "!" + "\n");
                    break lõppedes;
                }
                System.out.println("\n" + mängija2.getNimi() + " jääk: " + jääkMängija2 + " pärast " + i + ". viset." + "\n");

                if (i == 3) {
                    System.out.println(mängija2.getNimi()+" viimased visatud visked: "+viskedRoundiKohta.get(0)+", "+viskedRoundiKohta.get(1)+", "+viskedRoundiKohta.get(2));
                    System.out.print("\n" + "Sisestasid numbrid õigesti? (J/E): ");
                    scanned = scanner.nextLine();
                    if (scanned.equalsIgnoreCase("e")) {
                        i -= 3;
                        for (int vise : viskedRoundiKohta)
                            jääkMängija2 += vise;
                    }
                }
            }


            // lisab kõik kolm viset listi alles nüüd, kui tsükkel tehtud ja lõhki ei läinud
            lisa(mängija2, viskedRoundiKohta.get(0));
            lisa(mängija2, viskedRoundiKohta.get(1));
            lisa(mängija2, viskedRoundiKohta.get(2));
            viskedRoundiKohta.clear();

            System.out.println(mängija1.getNimi() + " skoor: " + jääkMängija1 + " pärast " + round + ". roundi.");
            System.out.println(mängija2.getNimi() + " skoor: " + jääkMängija2 + " pärast " + round + ". roundi.");
            System.out.println();
            round += 1;
        }
        scanner.close();
    }

}

