import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Texthandler {
    public void forMangeCharPrint() {
    }

    public void kunTalPrint() {
    }

    public void ingenBogstavPrint() {
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
        mdl.addAll(ftl.FilTilListe("Medlemmer.txt"));

        for(Medlem m : mdl){
            if(m instanceof Motionist && m.restance.equals("I restance")){
                System.out.println(m.medlemsskab + m.fornavn + m.restance);
            }
            if(m instanceof KonkurrenceSvømmer && m.restance.equals("I restance")){
                System.out.println(m.medlemsskab + m.fornavn + m.restance);
            }
        }
    }

    public void printMedlemmer() throws FileNotFoundException {
        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.FilTilListe("Medlemmer.txt"));

        for(Medlem m : mdl){
            System.out.println(m.medlemsskab);
        }
    }

    public void redigerMedlemRestance() {
        System.out.println("Vælg medlem som du vil ændre restance på.");
    }

    public void annuleretBetaling() {
        System.out.println("Medlem har stadig ikke betalt.");
    }

    public void visKontingentBeløb(int alder, String medlemsskab) {
        String beløb = "";

        if(alder < 18 && medlemsskab.contains("KonkurrenceSvømmer")){
            beløb = "Dit medlem er en " + medlemsskab + " og er " + alder + " år gammel, kontingent er " + "1000 kr.";
        }
        else if(alder > 18 && medlemsskab.contains("KonkurrenceSvømmer")){
            beløb = "Dit medlem er en " + medlemsskab + " og er " + alder + " år gammel, kontingent er " + "1600 kr.";
        }
        else if(alder >= 60 && medlemsskab.contains("KonkurrenceSvømmer")){
            beløb = "Dit medlem er en " + medlemsskab + " og er " + alder + " år gammel, kontingent er " + "1200 kr.";
        }
        else{
            beløb = "Dit medlem er en " + medlemsskab + " og er " + alder + " år gammel, kontingent er " + "500 kr.";
        }
        System.out.println(beløb);
        System.out.println("Hvis restance skal betales tryk [1] ellers indtast vilkårligt tal.");
    }

    public void printIndtastÅrstal() {
        System.out.println("Indtast årstal på medlem fødselsdato. Fx. 1987");
    }

    public void printIndtastMåned() {
        System.out.println("Indtast måned på medlem fødselsdato. Fx. 11");
    }

    public void printIndtastDag() {
        System.out.println("Indtast dag på medlem fødselsdato. Fx. 25");
    }

    public void printKonkurrenceSvømmere() throws FileNotFoundException {
        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.FilTilListe("KonkurrenceSvømmere.txt"));

        for(Medlem m : mdl){
            System.out.println(m.medlemsskab);
        }
    }

    public void redigerDisciplin() {
        System.out.println("Vælg medlem du gerne vil ændre disciplin på.");
    }

    public void printDisciplin(String fornavn) {
        System.out.println("Hvilken disciplin vil du gerne tilføje til " + fornavn + ".");
        System.out.println("Crawl [1], Brystsvømning [2], Butterfly[3], Rygcrawl [4], Medley [5]");
    }

    public void flereDiscPrint() {
        System.out.println("Skal der tilføjes flere discipliner? Ja [1] ellers tryk vilkårligt tal");
    }
}
