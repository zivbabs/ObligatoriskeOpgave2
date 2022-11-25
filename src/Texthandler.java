import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Texthandler {
    public void forMangeCharPrint() {
    }

    public void kunTalPrint() {
    }

    public void ingenBogstavPrint() {
    }

    public void max15PWPrint() {
    }

    public void gentagPWPrint() {
    }

    public void PWIkkeEnsTooLongPrint() {
    }

    public void vælgDiciplinPrint() {
    }
    public void opretMedlemMedlemskab(){
        System.out.println("Motionist eller KonkurrenceSvømmer? (1,2)");

    }

    public void opretMedlemAlder(){
        System.out.println("Indtast fødselsdato på medlem: ");
    }

    public void medlemFornavnPrint() {
        System.out.println("Skriv fornavn på medlem: ");
    }

    public void medlemEfternavnPrint() {
        System.out.println("Skriv efternavn på medlem: ");
    }

    public void forkertInputPrint() {
        System.out.println("Forkert input prøv igen.");
    }

    public void printRestance() throws FileNotFoundException {
        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.FilTilListeRestance("Medlemmer.txt"));

        for(Medlem m : mdl){
            if(m instanceof Motionist && m.restance.equals("I restance")){
                System.out.println(m.medlemsskab + m.fornavn + m.restance);
            }
            if(m instanceof KonkurrenceSvømmer && m.restance.equals("I restance")){
                System.out.println(m.medlemsskab + m.fornavn + m.restance);
            }
        }
    }
}
