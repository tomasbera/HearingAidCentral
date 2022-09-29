public class HearingAid {
    private final String ID;
    private final String type;
    private boolean status;
    private String nameOfRent;

    public HearingAid(String ID, String type, boolean status, String nameOfRent) {
        this.ID = ID;
        this.type = type;
        this.status = status;
        this.nameOfRent = nameOfRent;
    }

    public String getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public boolean isStatus() {
        return status;
    }

    public String getNameOfRent() {
        return nameOfRent;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setNameOfRent(String nameOfRent) {
        this.nameOfRent = nameOfRent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HearingAid)) return false;

        HearingAid that = (HearingAid) o;

        return getType().equals(that.getType());
    }

    @Override
    public String toString() {
        String out;
        if (!isStatus()){
            out = "tilgejengelig";
        }
        else {
            out = "utilgjengelig";
        }
        return "\nHjelpemiddel\n" +
                getID() + " " + getType() + " " + "Hjelpemiddel er " + out;

    }
}
