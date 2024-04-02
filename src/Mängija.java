import java.util.ArrayList;
import java.util.List;

public class Mängija {
    private String nimi;
    public List<Integer> kõikVisked = new ArrayList<>();

    public Mängija(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return "Mängija{" +
                "nimi='" + nimi + '\'' +
                ", kõikVisked=" + kõikVisked +
                '}';
    }

    public static void main(String[] args) {

    }

}
