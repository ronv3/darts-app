import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Statistika {
    Mängija mängija;

    public Statistika(Mängija mängija) {
        this.mängija = mängija;
    }

    public static void main(String[] args) {

    }

    public void mängijaStatistika() {
        List<Integer> visked = mängija.getKõikVisked();

        if (visked.isEmpty()) {
            System.out.println("Mängija " + mängija.getNimi() + " pole teinud ühtegi viset!");
            return;
        }

        double keskmineRoundiSkoor = keskmineRoundiSkoor(visked);
        int[] parimKolmik = parimKolmik(visked);
        List<Integer> tihedaimVisatudNumber = tihedaimVisatudNumber(visked);

        System.out.println("Statistika mängija " + mängija.getNimi() + " kohta:");
        System.out.println("Keskmine punktiskoor: " + keskmineRoundiSkoor);
        System.out.println("Kõige parem kolmik: " + parimKolmik[0] + ", " + parimKolmik[1] + ", " + parimKolmik[2]);

        if (tihedaimVisatudNumber.size() < 2) {
            System.out.println("Kõige tihedamini visatud number: " + tihedaimVisatudNumber.get(0));
        } else {
            System.out.println("Kõige tihedamini visetatud numbrid: " + tihedaimVisatudNumber);
            for (int number : tihedaimVisatudNumber) {
                System.out.println(number);
            }
        }

        System.out.println("Mängija skooride ajajoon: ");
        skoorideAjajoon(visked);
    }

    private static double keskmineRoundiSkoor(List<Integer> visked) {
        int summa = 0;
        for (int punktidRoundis : visked) {
            summa += punktidRoundis;
        }
        double keskmine = (double) summa / visked.size();
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(keskmine));
    }

    private static int[] parimKolmik(List<Integer> visked) {
        int[] parimKolmik = new int[3];
        int maxSumma = 0;

        for (int i = 0; i < visked.size() - 2; i++) {
            int summa = visked.get(i) + visked.get(i+1) + visked.get(i+2);
            if (summa > maxSumma) {
                maxSumma = summa;
                parimKolmik[0] = visked.get(i);
                parimKolmik[1] = visked.get(i+1);
                parimKolmik[2] = visked.get(i+2);
            }
        }
        return parimKolmik;
    }

    private static List<Integer> tihedaimVisatudNumber(List<Integer> visked) {
        int sagedasemArv = 0;
        int eelnevSagedasemArv = 0;
        int suurimLoeKokku = 1;
        List<Integer> mituSagedasemat = new ArrayList<>();

        for (int i = 0; i < visked.size(); i++) {

            int loeKokku = 0;
            for (int j = 0; j < visked.size(); j++) {
                if (Objects.equals(visked.get(j), visked.get(i))) {
                    loeKokku += 1;
                }
            }
            if (loeKokku > suurimLoeKokku) {
                sagedasemArv = visked.get(i);
                suurimLoeKokku = loeKokku;
                mituSagedasemat.add(visked.get(i));
            }
        }

        return mituSagedasemat;
    }

    private static void skoorideAjajoon(List<Integer> visked) {
        for (int i = 0; i <= visked.size() - 2; i += 3) {
            System.out.println((i / 3 + 1) + ". round");
            System.out.println(visked.get(i));
            System.out.println(visked.get(i+1));
            System.out.println(visked.get(i+2));
            System.out.println();
        }
    }
}
