package app.dto;

public class DivisionDTOSem {

    private int idsem;
    private int numsem;
    private String addresssem;
    private boolean statusconnectionsem;
    private boolean statusskssem;
    private boolean statuscomputerssem;

    public DivisionDTOSem() {
    }

    public DivisionDTOSem(int idsem, int numsem, String addresssem, boolean statusconnectionsem, boolean statusskssem, boolean statuscomputerssem) {
        this.idsem = idsem;
        this.numsem = numsem;
        this.addresssem = addresssem;
        this.statusconnectionsem = statusconnectionsem;
        this.statusskssem = statusskssem;
        this.statuscomputerssem = statuscomputerssem;
    }

    public int getIdsem() {
        return idsem;
    }

    public void setIdsem(int idsem) {
        this.idsem = idsem;
    }

    public int getNumsem() {
        return numsem;
    }

    public void setNumsem(int numsem) {
        this.numsem = numsem;
    }

    public String getAddresssem() {
        return addresssem;
    }

    public void setAddresssem(String addresssem) {
        this.addresssem = addresssem;
    }

    public boolean isStatusconnectionsem() {
        return statusconnectionsem;
    }

    public void setStatusconnectionsem(boolean statusconnectionsem) {
        this.statusconnectionsem = statusconnectionsem;
    }

    public boolean isStatusskssem() {
        return statusskssem;
    }

    public void setStatusskssem(boolean statusskssem) {
        this.statusskssem = statusskssem;
    }

    public boolean isStatuscomputerssem() {
        return statuscomputerssem;
    }

    public void setStatuscomputerssem(boolean statuscomputerssem) {
        this.statuscomputerssem = statuscomputerssem;
    }

    @Override
    public String toString() {
        return "DivisionDTOSem{" +
                "idsem=" + idsem +
                ", numsem=" + numsem +
                ", addresssem='" + addresssem + '\'' +
                ", statusconnectionsem=" + statusconnectionsem +
                ", statusskssem=" + statusskssem +
                ", statuscomputerssem=" + statuscomputerssem +
                '}';
    }
}
