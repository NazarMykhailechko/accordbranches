package app.dto;

public class DivisionDTOGritch {

    private int idgritch;
    private int numgritch;
    private String addressgritch;
    private boolean statuscashregistersgritch;
    private boolean statusmebligritch;
    private String commentscashregistersgritch;
    private String commentsmebligritch;

    public DivisionDTOGritch() {
    }

    public DivisionDTOGritch(int idgritch, int numgritch, String addressgritch, boolean statuscashregistersgritch, boolean statusmebligritch, String commentscashregistersgritch, String commentsmebligritch) {
        this.idgritch = idgritch;
        this.numgritch = numgritch;
        this.addressgritch = addressgritch;
        this.statuscashregistersgritch = statuscashregistersgritch;
        this.statusmebligritch = statusmebligritch;
        this.commentscashregistersgritch = commentscashregistersgritch;
        this.commentsmebligritch = commentsmebligritch;
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

    public String getCommentscashregistersgritch() {
        return commentscashregistersgritch;
    }

    public void setCommentscashregistersgritch(String commentscashregistersgritch) {
        this.commentscashregistersgritch = commentscashregistersgritch;
    }

    public String getCommentsmebligritch() {
        return commentsmebligritch;
    }

    public void setCommentsmebligritch(String commentsmebligritch) {
        this.commentsmebligritch = commentsmebligritch;
    }

    @Override
    public String toString() {
        return "DivisionDTOGritch{" +
                "idgritch=" + idgritch +
                ", numgritch=" + numgritch +
                ", addressgritch='" + addressgritch + '\'' +
                ", statuscashregistersgritch=" + statuscashregistersgritch +
                ", statusmebligritch=" + statusmebligritch +
                ", commentscashregistersgritch='" + commentscashregistersgritch + '\'' +
                ", commentsmebligritch='" + commentsmebligritch + '\'' +
                '}';
    }
}
