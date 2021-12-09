package app.dto;

public class DivisionDTOGritch {

    private int idgritch;
    private int numgritch;
    private String addressgritch;
    private boolean statuscashregistersgritch;
    private boolean statusmebligritch;

    public DivisionDTOGritch() {
    }

    public DivisionDTOGritch(int idgritch, int numgritch, String addressgritch, boolean statuscashregistersgritch, boolean statusmebligritch) {
        this.idgritch = idgritch;
        this.numgritch = numgritch;
        this.addressgritch = addressgritch;
        this.statuscashregistersgritch = statuscashregistersgritch;
        this.statusmebligritch = statusmebligritch;
    }

    public int getIdgritch() {
        return idgritch;
    }

    public void setIdgritch(int idgritch) {
        this.idgritch = idgritch;
    }

    public int getNumgritch() {
        return numgritch;
    }

    public void setNumgritch(int numgritch) {
        this.numgritch = numgritch;
    }

    public String getAddressgritch() {
        return addressgritch;
    }

    public void setAddressgritch(String addressgritch) {
        this.addressgritch = addressgritch;
    }

    public boolean isStatuscashregistersgritch() {
        return statuscashregistersgritch;
    }

    public void setStatuscashregistersgritch(boolean statuscashregistersgritch) {
        this.statuscashregistersgritch = statuscashregistersgritch;
    }

    public boolean isStatusmebligritch() {
        return statusmebligritch;
    }

    public void setStatusmebligritch(boolean statusmebligritch) {
        this.statusmebligritch = statusmebligritch;
    }

    @Override
    public String toString() {
        return "DivisionDTOGrithc{" +
                "idgritch=" + idgritch +
                ", numgritch=" + numgritch +
                ", addressgritch='" + addressgritch + '\'' +
                ", statuscashregistersgritch=" + statuscashregistersgritch +
                ", statusmebligritch=" + statusmebligritch +
                '}';
    }
}
