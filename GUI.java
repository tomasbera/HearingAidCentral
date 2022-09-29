import static javax.swing.JOptionPane.*;

public class GUI {

    public static void main(String[] args) throws Exception {

        boolean start = true;
        Centra ntnu = new Centra("NTNU-sentralen");



            while (start) {
                try{
                    String[] muligheter = {"List all informasjon", "Registrer nytt hjelpemiddel", "Registrer Utlån",
                        "Registrer Innlevering", "Avslutt"};

                    final int LIST_ALLE = 0;
                    final int REGISTRER_NYTT_HJELPEMIDDEL = 1;
                    final int UTLEVERING_AV_HJELPEMIDDEL = 2;
                    final int INNLEVERING_AV_HJELPEMIDDEL = 3;
                    final int AVSLUTT = 4;
                    int valg = showOptionDialog(null, "Hjelpemiddelsentralen " + ntnu.getNameOfCentral() + "\nVelg funksjon",
                            "Eksamen des 2019", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
                switch (valg) {
                    case LIST_ALLE -> {
                        ntnu.allHearingAids();
                        System.out.println(ntnu.allHearingAids().toString());
                    }
                    case REGISTRER_NYTT_HJELPEMIDDEL -> {
                        String newID = showInputDialog("Skriv inn den nye ID-en til det nye hjelpemiddelet");
                        String newType = showInputDialog("Skriv inn typen på hjelpemiddelet");
                        ntnu.registerNew(newID, newType, false, ""); //Siden et høreappaerat ikke er utleid i starten eller har en som leier det, trengs det ikke.
                    }
                    case UTLEVERING_AV_HJELPEMIDDEL -> {
                        String IDrented = showInputDialog("Skriv inn ID-en til hjelpemiddelet som skal leies ut");
                        String nameOfRenter = showInputDialog("hva heter persone som skal leie hjelpemiddelet");
                        ntnu.rent(IDrented, nameOfRenter);
                    }
                    case INNLEVERING_AV_HJELPEMIDDEL -> {
                        String Idreturn = showInputDialog("Hva er ID på hjelpemiddelet som skal lever tilbake");
                        ntnu.unrent(Idreturn);
                    }
                    case AVSLUTT -> {
                        start = false;
                    }
                }
            }catch (Exception e) {
                    e.printStackTrace();
        }
        }
    }
}

