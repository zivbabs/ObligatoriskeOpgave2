import java.io.FileNotFoundException; //Import af exception og arraylist til metoder
import java.util.ArrayList;
//Klasse der indeholder alle udprintninger til konsol da en del af krav er at det skal være overskueligt at læse i konsol.
//Det betyder der vil være en stor del af opgaven der er den korrekte formattering af udprintninger.
//Flere metoder i udprintning skal også bruges flere gange og nogle formatteringer kan laves om til metoder for at undgå repetition.
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
    //printRestance of flere andre udprintninger bruger filtiliste til at læse data in derefter fordele den med for each loop.
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
    //visKontingentBeløb har paramtre alder og medlemsskab ind for at checke medlemsinfo så den kan vise korrekte beløb.
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

    public void redigerTrænerPrint() {
        System.out.println("Vælg medlem som du gerne vil tilføje træner til.");
    }

    public void indtastTræner() {
        System.out.println("Indtast initialer på den træner du gerne vil tilføje. Fx. FK");
    }

    public void vælgMedlemNyTid() {
        System.out.println("Vælg medlem du gerne vil oprette ny træningstid på.");
    }

    public void printValgteDiscipliner(String dicipliner) {
        System.out.println("Det valgte medlem har " + dicipliner);
    }

    public void valgTræningsTid() {
        System.out.println("Indtast ny træningstid på medlem.");
    }

    public void printMinutter() {
        System.out.println("Indtast antal minutter med 2 tal. Fx 00 eller 10");
    }

    public void printSekunder() {
        System.out.println("Indtast antal sekunder med 2 tal. Fx 00 eller 10");
    }

    public void print100dele() {
        System.out.println("Print de 2 hundrededele i tiden. Fx 00 eller 10");
    }

    public void printTræningsTider() throws FileNotFoundException
    {
        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.FilTilListe("Træningstider.txt"));
        for (Medlem m : mdl) {
            System.out.println("Navn: "+m.fornavn + m.efternavn + " Disciplin: " + m.discipliner + m.bedsteTid);
        }
    }


    public void redigerTræningPrint()
    {
        System.out.println("Indtast index nummer på det medlem du gerne vil redigere træningstid på: ");
    }
}
