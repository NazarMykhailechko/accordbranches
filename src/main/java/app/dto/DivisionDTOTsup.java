package app.dto;

public class DivisionDTOTsup {

    private int idtsup;
    private int numtsup;
    private String addresstsup;
    private boolean statusstampstsup;
    private boolean statuscleaningtsup;

    public DivisionDTOTsup() {
    }

    public DivisionDTOTsup(int idtsup, int numtsup, String addresstsup, boolean statusstampstsup, boolean statuscleaningtsup) {
        this.idtsup = idtsup;
        this.numtsup = numtsup;
        this.addresstsup = addresstsup;
        this.statusstampstsup = statusstampstsup;
        this.statuscleaningtsup = statuscleaningtsup;
    }

    public int getIdtsup() {
        return idtsup;
    }

    public void setIdtsup(int idtsup) {
        this.idtsup = idtsup;
    }

    public int getNumtsup() {
        return numtsup;
    }

    public void setNumtsup(int numtsup) {
        this.numtsup = numtsup;
    }

    public String getAddresstsup() {
        return addresstsup;
    }

    public void setAddresstsup(String addresstsup) {
        this.addresstsup = addresstsup;
    }

    public boolean isStatusstampstsup() {
        return statusstampstsup;
    }

    public void setStatusstampstsup(boolean statusstampstsup) {
        this.statusstampstsup = statusstampstsup;
    }

    public boolean isStatuscleaningtsup() {
        return statuscleaningtsup;
    }

    public void setStatuscleaningtsup(boolean statuscleaningtsup) {
        this.statuscleaningtsup = statuscleaningtsup;
    }

    @Override
    public String toString() {
        return "DivisionDTOTsup{" +
                "idtsup=" + idtsup +
                ", numtsup=" + numtsup +
                ", addresstsup='" + addresstsup + '\'' +
                ", statusstampstsup=" + statusstampstsup +
                ", statuscleaningtsup=" + statuscleaningtsup +
                '}';
    }
}
