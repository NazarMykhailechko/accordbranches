package app.dto;

public class DivisionDTOSem {

    private int idsem;
    private int numsem;
    private String addresssem;
    private boolean statusconnectionsem;
    private boolean statusskssem;
    private boolean statuscomputerssem;
    private String commentsconnectionsem;
    private String commentsskssem;
    private String commentscomputerssem;

    public DivisionDTOSem() {
    }

    public DivisionDTOSem(int idsem, int numsem, String addresssem, boolean statusconnectionsem, boolean statusskssem, boolean statuscomputerssem, String commentsconnectionsem, String commentsskssem, String commentscomputerssem) {
        this.idsem = idsem;
        this.numsem = numsem;
        this.addresssem = addresssem;
        this.statusconnectionsem = statusconnectionsem;
        this.statusskssem = statusskssem;
        this.statuscomputerssem = statuscomputerssem;
        this.commentsconnectionsem = commentsconnectionsem;
        this.commentsskssem = commentsskssem;
        this.commentscomputerssem = commentscomputerssem;
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

    public String getCommentsconnectionsem() {
        return commentsconnectionsem;
    }

    public void setCommentsconnectionsem(String commentsconnectionsem) {
        this.commentsconnectionsem = commentsconnectionsem;
    }

    public String getCommentsskssem() {
        return commentsskssem;
    }

    public void setCommentsskssem(String commentsskssem) {
        this.commentsskssem = commentsskssem;
    }

    public String getCommentscomputerssem() {
        return commentscomputerssem;
    }

    public void setCommentscomputerssem(String commentscomputerssem) {
        this.commentscomputerssem = commentscomputerssem;
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
                ", commentsconnectionsem='" + commentsconnectionsem + '\'' +
                ", commentsskssem='" + commentsskssem + '\'' +
                ", commentscomputerssem='" + commentscomputerssem + '\'' +
                '}';
    }
}
