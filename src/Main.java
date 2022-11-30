import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Kasserer ksr = new Kasserer();
        ksr.betalKontigentMedlemmer();
    }
}