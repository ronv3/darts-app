import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) {

        String mängija1Nimi = "";
        String mängija2Nimi = "";
        String nimi1 = "";
        String nimi2 = "";
        int algskoor = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // nimede sisestamine
            System.out.print("Sisesta mängija nimi: ");
            nimi1 = scanner.nextLine();
            System.out.print("Sisesta mängija nimi: ");
            nimi2 = scanner.nextLine();
            System.out.println("Soovid nende nimedega jätkata? (J/E): ");
            String vastus = scanner.nextLine();
            if (!vastus.equalsIgnoreCase("j")) {
                System.out.println("Proovi uuesti!");
                continue;
            } else {

                // kumb alustab?
                System.out.println("Kumb alustab? (1. mängija nimi  / 2. mängija nimi / \"juhuslik\")");
                vastus = scanner.nextLine();
                if (vastus.equalsIgnoreCase(nimi1)) {
                    mängija1Nimi = nimi1;
                    mängija2Nimi = nimi2;
                } else if (vastus.equalsIgnoreCase(nimi2)) {
                    mängija1Nimi = nimi2;
                    mängija2Nimi = nimi1;
                }else if (vastus.equalsIgnoreCase("juhuslik"))
                    if (Math.random() > 0.5) {
                        mängija1Nimi = nimi1;
                        mängija2Nimi = nimi2;
                    } else {
                        mängija1Nimi = nimi2;
                        mängija2Nimi = nimi1;
                    }

                break;
            }
        }

        Mängija mängija1 = new Mängija(mängija1Nimi);
        Mängija mängija2 = new Mängija(mängija2Nimi);

        while (true) {
            boolean uuesti = true;
            System.out.print("Sisesta algskoor (301/501): ");
            algskoor = Integer.parseInt(scanner.nextLine());
            if (algskoor == 301 || algskoor == 501) {
                while (true) {
                    System.out.print("Algskoor läheb lukku? (J/E): ");
                    String vastus = scanner.nextLine();
                    if (vastus.equalsIgnoreCase("j")) {
                        uuesti = false;
                        break;
                    } else {;
                        break;
                    }
                }
            }
            if (uuesti) {
                System.out.println("Proovi uuesti!");
            } else {
                break;
            }
        }

        int algskooriks = algskoor;

        Mäng mäng = new Mäng(algskooriks, mängija1, mängija2);
        mäng.mängi();

        Statistika statistika1 = new Statistika(mängija1);
        statistika1.mängijaStatistika();
        System.out.println();
        Statistika statistika2 = new Statistika(mängija2);
        statistika2.mängijaStatistika();

    }
}