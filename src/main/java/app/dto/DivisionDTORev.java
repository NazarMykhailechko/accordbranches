package app.dto;

public class DivisionDTORev {

    private int idrev;
    private int numrev;
    private String addressrev;
    private boolean statusorendarev;
    private boolean statussafesrev;

    public DivisionDTORev() {
    }

    public DivisionDTORev(int idrev, int numrev, String addressrev, boolean statusorendarev, boolean statussafesrev) {
        this.idrev = idrev;
        this.numrev = numrev;
        this.addressrev = addressrev;
        this.statusorendarev = statusorendarev;
        this.statussafesrev = statussafesrev;
    }

    public int getIdrev() {
        return idrev;
    }

    public void setIdrev(int idrev) {
        this.idrev = idrev;
    }

    public int getNumrev() {
        return numrev;
    }

    public void setNumrev(int numrev) {
        this.numrev = numrev;
    }

    public String getAddressrev() {
        return addressrev;
    }

    public void setAddressrev(String addressrev) {
        this.addressrev = addressrev;
    }

    public boolean isStatusorendarev() {
        return statusorendarev;
    }

    public void setStatusorendarev(boolean statusorendarev) {
        this.statusorendarev = statusorendarev;
    }

    public boolean isStatussafesrev() {
        return statussafesrev;
    }

    public void setStatussafesrev(boolean statussafesrev) {
        this.statussafesrev = statussafesrev;
    }

    @Override
    public String toString() {
        return "DivisionDTORev{" +
                "idrev=" + idrev +
                ", numrev=" + numrev +
                ", addressrev='" + addressrev + '\'' +
                ", statusorendarev=" + statusorendarev +
                ", statussafesrev=" + statussafesrev +
                '}';
    }
}
