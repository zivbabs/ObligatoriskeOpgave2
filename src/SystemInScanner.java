import java.util.Scanner;

public class SystemInScanner {
    Texthandling th = new Texthandling();
    public int inputInt() {
        boolean success = false;
        int output = 0;

        while (!success) {
            try {

                Scanner scn = new Scanner(System.in);
                String input = scn.next();

                if(input.length() < 4) {
                    output = Integer.parseInt(input);
                    success = true;
                }
                else{
                    th.forMangeCharPrint();
                }
            }catch (NumberFormatException e) {
                th.kunTalPrint();
            }
        }
        return output;
    }
    public String inputString(){
        boolean success = false;
        String output = "";

        while(!success){

            Scanner scn = new Scanner(System.in);
            String input = scn.next();
            char[] chars = input.toCharArray();

            if(input.length() < 20) {
                for (char aChar : chars) {
                    if(Character.isLetter(aChar) || aChar == 'æ' || aChar == 'Æ' || aChar == 'ø' || aChar == 'Ø' || aChar == 'å' || aChar == 'Å'){
                        output = output.concat(Character.toString(aChar));
                        if(output.length() == input.length() && output.lastIndexOf(output) == input.lastIndexOf(input)){
                            success = true;
                        }                    }
                    else{
                        th.ingenBogstavPrint();
                        output = "";
                        break;
                    }
                }
            }
            else{
                th.forMangeCharPrint();
            }
        }
        return output;
    }
    public String inputPassword(){
        boolean success = false;
        String output = "";

        while(!success) {

            Scanner scn = new Scanner(System.in);
            th.max15PWPrint();
            String input1 = scn.next();
            th.gentagPWPrint();
            String input2 = scn.next();

            if(input1.equals(input2) && !input2.contains(" ") && input2.length() < 15){
                output = input2;
                success = true;
            }
            else{
                th.PWIkkeEnsTooLongPrint();
            }
        }
        return output;
    }
    public String inputDisciplin(){
        th.vælgDiciplinPrint();
        String diciplin = "";
        switch(inputInt()){
            case 1: diciplin = "Butterfly.txt"; break;
            case 2: diciplin = "Crawl"; break;
            case 3: diciplin = "Rygcrawl"; break;
            case 4: diciplin = "Brystsvømning"; break;
            case 5: diciplin = "Hundesvømning"; break;
        }
        return diciplin;
    }
}
