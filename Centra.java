import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

public class Centra {

    private final ArrayList<HearingAid> centrals;
    private final String nameOfCentral;

    public Centra(String nameOfCentral) {
        this.nameOfCentral = nameOfCentral;
        centrals = new ArrayList<>();
    }

    public String registerNew(String newID, String Type, Boolean starterStatus, String starterName) throws Exception {

        String re = "(\\d{0,4}[-]\\d{0,4})";
        Pattern pt = Pattern.compile(re);
        Matcher mt = pt.matcher(newID);
        boolean result = mt.matches();

        if(!result){
            throw new Exception("""
                    Formate på ID-en må være av denne formen
                    xxxx-xxxx
                    der x er et tall mellom 0 og 9""");
        }

        for (HearingAid central : centrals) {
            if (central.getID().equals(newID)) {
                throw new Exception("Dette hjelpeapparetet er allerede registrert");
            }
        }
        centrals.add(new HearingAid(newID, Type, starterStatus, starterName));
        return centrals.toString();
    }

    public void rent(String rentID, String nameOfRenter) throws Exception {
        for (HearingAid equal : centrals){
            if(equal.isStatus() || !equal.getID().equals(rentID)){
                throw new Exception("Noe er feil, enten så er den allerde utleid, eller så skrev du feil ID");
            }
        }
        for (HearingAid central : centrals) {
            if (!central.isStatus() && central.getID().equals(rentID)) {
                central.setNameOfRent(nameOfRenter);
                central.setStatus(true);
            }
        }
    }

    public void unrent(String wantedID) throws Exception {
        for (HearingAid central : centrals){
            if(!central.getID().equals(wantedID) || !central.isStatus()){
                throw new Exception("Noe gikk galt, enten er ikke apperatet utleid, eller så skrev du inn feil ID nr");
            }
        }
        for (HearingAid central : centrals){
            if(central.getID().equals(wantedID) && central.isStatus()){
                central.setStatus(false);
            }
        }
    }

    public ArrayList<HearingAid> allHearingAids(){
        ArrayList<HearingAid> allOfAids;
        allOfAids = deepCopyMethod(centrals);
        return allOfAids;
    }

    public ArrayList<HearingAid> allAidsType(String type){
        ArrayList<HearingAid> allOfAidsType = new ArrayList<>();
        for (int i = 0; i < centrals.size(); i++) {
            if (centrals.get(i).getType().equals(type)){
                allOfAidsType.add(centrals.get(i));
            }
        }
        allOfAidsType = deepCopyMethod(allOfAidsType);
        return allOfAidsType;
    }

    public ArrayList<HearingAid> deepCopyMethod(ArrayList<HearingAid> CopyMe){
        ArrayList<HearingAid> thisIsTheCopy = new ArrayList<>();
        for (HearingAid central : CopyMe){
            thisIsTheCopy.add(new HearingAid(central.getID(), central.getType(), central.isStatus(), central.getNameOfRent()));
        }
        return thisIsTheCopy;
    }

    public String getNameOfCentral() {
        return nameOfCentral;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (HearingAid central : centrals) {
            sb.append(central.toString()).append("\n");
            }
        return sb.toString();
    }
}
