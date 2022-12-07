import java.io.FileNotFoundException; //Import af exception og arraylist til metoder
import java.util.ArrayList;
import java.util.Comparator;

//Klasse der indeholder alle udprintninger til konsol da en del af krav er at det skal være overskueligt at læse i konsol.
//Det betyder der vil være en stor del af opgaven der er den korrekte formattering af udprintninger.
//Flere metoder i udprintning skal også bruges flere gange og nogle formatteringer kan laves om til metoder for at undgå repetition.
public class Texthandler {

    public void forMangeCharPrint() {
        System.out.println("Du har indtastet for mange karakterer. Prøv igen.");
    }

    public void kunTalPrint() {
        System.out.println("Du har indtastet andet end et tal. Prøv igen.");
    }

    public void ingenBogstavPrint() {
        System.out.println("Du har indtastet en karakter som ikke er godkendt. Prøv igen.");
    }

    public void opretMedlemskab(){
        System.out.println("Skal det være: \nMotionist [1] \nKonkurrenceSvømmer [2]");

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
        int counter1 = 0;
        int counter2 = 0;
        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.filTilListe("Medlemmer.txt"));

        for(Medlem m : mdl){
            if(m instanceof Motionist && m.restance.equals("I restance")){
                if (counter1==0) {
                    System.out.printf("\nMOTIONIST DATA%n");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                    System.out.printf("| %-20s | %-25s | %-25s | %-12s | %-20s |%n", "Medlemskab", "Fornavn", "Efternavn", "Fødselsdato", "Restance");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                    counter1++;
                }
                System.out.printf("| %-20s | %-25s | %-25s | %-12s | %-20s |%n",m.medlemsskab, m.fornavn, m.efternavn, m.alder, m.restance);
                System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
            }

            if(m instanceof KonkurrenceSvømmer && m.restance.equals("I restance")){
                if (counter2==0) {
                    System.out.printf("\nKONKURRENCESVØMMER DATA%n");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                    System.out.printf("| %-20s | %-25s | %-25s | %-12s | %-20s |%n", "Medlemskab", "Fornavn", "Efternavn", "Fødselsdato", "Restance");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                    counter2++;
                }
                System.out.printf("| %-20s | %-25s | %-25s | %-12s | %-20s |%n",m.medlemsskab, m.fornavn, m.efternavn, m.alder, m.restance);
                System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
            }
        }
    }

    public void printMedlemmer() throws FileNotFoundException {
        int idcounter = 0;
        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.filTilListe("Medlemmer.txt"));

        System.out.printf("MEDLEMMER DATA%n");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("|%-5s | %-20s | %-25s | %-25s | %-12s | %-20s |%n", "ID", "Medlemskab", "Fornavn", "Efternavn", "Fødselsdato", "Restance");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------%n");


        for(Medlem m : mdl) {

            System.out.printf("|%-5s | %-20s | %-25s | %-25s | %-12s | %-20s |%n", idcounter, m.medlemsskab, m.fornavn, m.efternavn, m.alder, m.restance);
            System.out.printf("-----------------------------------------------------------------------------------------------------------------------------%n");

            idcounter++;

        }
    }

    public void redigerMedlemRestance() {
        System.out.println("Vælg ID ud fra det medlem, som du vil ændre restance på.");
    }

    public void annuleretBetaling() {
        System.out.println("Medlem har stadig ikke betalt.");
    }
    //visKontingentBeløb har paramtre alder og medlemsskab ind for at checke medlemsinfo så den kan vise korrekte beløb.
    public void visKontingentBeløb(int alder, String medlemsskab, String status) {
        String beløb;

        if(alder < 18 && medlemsskab.equals("KonkurrenceSvømmer") && status.equals("Aktiv")){
            beløb = "Dit medlem er en " + medlemsskab + " og er " + alder + " år gammel, kontingent er " + "1000 kr.";
        }
        else if(alder > 18 && alder < 60 && medlemsskab.equals("KonkurrenceSvømmer") && status.equals("Aktiv")){
            beløb = "Dit medlem er en " + medlemsskab + " og er " + alder + " år gammel, kontingent er " + "1600 kr.";
        }
        else if(alder >= 60 && medlemsskab.contains("KonkurrenceSvømmer") && status.equals("Aktiv")){
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
        mdl.addAll(ftl.filTilListe("KonkurrenceSvømmere.txt"));
        int idcounter = 0;

        System.out.printf("KONKURRENCESVØMMER DATA%n");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("|%-5s | %-25s | %-25s | %-12s | %-41s | %-7s |%n", "ID", "Fornavn", "Efternavn", "Fødselsdato", "Discipliner", "Træner");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------------%n");

        for(Medlem m : mdl){
            System.out.printf("|%-5s | %-25s | %-25s | %-12s | %-41s | %-7s |%n", idcounter, m.fornavn, m.efternavn, m.alder, m.discipliner, m.træner);
            System.out.printf("-------------------------------------------------------------------------------------------------------------------------------------%n");
            idcounter++;
        }
    }

    public void redigerDisciplin() {
        System.out.println("Vælg ID ud fra det medlem du gerne vil ændre disciplin på.");
    }

    public void printDisciplin(String fornavn) {
        System.out.println("Hvilken disciplin vil du gerne tilføje til " + fornavn + ".");
        System.out.println("Crawl [1], Brystsvømning [2], Butterfly[3], Rygcrawl [4], Medley [5]");
    }
    public void redigerTrænerPrint() {
        System.out.println("Vælg ID ud fra medlem som du gerne vil tilføje træner til.");
    }

    public void indtastTræner() {
        System.out.println("Indtast initialer på den træner du gerne vil tilføje (Maks 3 bogstaver). Fx. FOK");
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

    //Metoder som printer træningstiderne formateret, og giver hvert index et nummer.
    public void printTræningsTider() throws FileNotFoundException
    {
        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.filTilListe("Træningstider.txt"));
        int idcounter = 0;

        System.out.printf("TRÆNINGSTIDER DATA%n");
        System.out.printf("-------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("|%-5s | %-25s | %-25s | %-12s | %-12s | %-12s |%n", "ID", "Fornavn", "Efternavn", "Fødselsdato", "Disciplin", "Træningstid");
        System.out.printf("-------------------------------------------------------------------------------------------------------------%n");

        for(Medlem m : mdl){
            System.out.printf("|%-5s | %-25s | %-25s | %-12s | %-12s | %-12s |%n", idcounter, m.fornavn, m.efternavn, m.alder, m.discValgt, m.resultat);
            System.out.printf("-------------------------------------------------------------------------------------------------------------%n");
            idcounter++;
        }
    }


    public void redigerTræningPrint()
    {
        System.out.println("Indtast ID på det medlem du gerne vil redigere træningstid på: ");
    }

    public void vælgMedlemStævnePrint()
    {
        System.out.println("Vælg ID på det medlem du vil indtaste stævne information på: ");
    }

    public void indtastStævne()
    {
        System.out.println("Indtast navn på stævne: ");
    }

    public void indtastPlacering()
    {
        System.out.println("Indtast placering i stævnet: ");
    }
    public void discValgStævne()
    {
        System.out.println("Vælg disciplin fra valgte medlem som du vil tilføje stævneplacering til: ");
        System.out.println("Crawl [1], Brystsvømning [2], Butterfly[3], Rygcrawl [4], Medley [5]");
    }

    public void harAlleredeDisciplin() {
        System.out.println("Medlem har allerede den disciplin tilføjet.");
    }

    public void opretStatus() {
        System.out.println("Indtast om medlem er aktiv[1] eller passiv[2].");
    }

    //Metode som tæger træningstiderne, smider informationen over i en midlertidig arrayliste, sorterer efter tid og printer top 5
    public void printTop5(String a) throws FileNotFoundException {

        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.filTilListe("Træningstider.txt"));
        ArrayList<Medlem> temp = new ArrayList<>();

        for (Medlem m : mdl) {
            if (a.equals(m.discValgt)) {
                temp.add(m);
            }
        }
        temp.sort(Comparator.comparing(m -> m.resultat));

        System.out.printf("BEDSTE TIDER " + a.toUpperCase() + "%n");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-25s | %-25s | %-12s | %-41s | %-7s | %-10s |%n", "Fornavn", "Efternavn", "Fødselsdato", "Discipliner", "Træner", "Resultat");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------------%n");

        for (int i = 0; i < 5; i++) {
                System.out.printf("| %-25s | %-25s | %-12s | %-41s | %-7s | %-10s |%n", temp.get(i).fornavn, temp.get(i).efternavn, temp.get(i).alder, temp.get(i).discValgt, temp.get(i).træner, temp.get(i).resultat);
                System.out.printf("-------------------------------------------------------------------------------------------------------------------------------------%n");
        }
    }

    public void vælgDiscTop5() {
        System.out.println("Vælg disciplin du gerne vil se top5 for.");
        System.out.println("Crawl [1], Brystsvømning [2], Butterfly[3], Rygcrawl [4], Medley [5]");
    }

    public void passwordAnsat() {
        System.out.println("Indtast dit respektive password for at logge ind.");
    }

    public void loginOptions() {
        System.out.println("Indtast [1] for login som Formand\nIndtast [2] for login som Kasserer\nIndtast [3] for login som Træner\nIndtast [4] for at lukke programmet.");
    }

    public void formandMenuOptions() {
        System.out.println("Indtast [1] for a oprette medlem\nIndtast [2] for at gå tilbage til hovedmenuen.");
    }

    public void kassererMenuOptions() {
        System.out.println("Indtast [1] for at printe medlemmer i restance\nIndtast [2] for at redigere kontingentbetaling\nindtast [3] for at gå tilbage til hovedmenuen.");
    }

    public void trænerMenuOptions() {
        System.out.println("Indtast [1] for at registrere svømmediscipliner\nIndtast [2] for at registrere træner\nIndtast [3] for at redigere træningstid\nIndtast [4] for at indtaste en stævnetid\nIndtast [5] for at se top5 indenfor en disciplin\nIndtast [6] for at vende tilbage til hovedmenuen.");
    }
}
