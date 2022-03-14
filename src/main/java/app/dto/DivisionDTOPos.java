package app.dto;

public class DivisionDTOPos {

    private int idpos;
    private int numpos;
    private String addresspos;
    private boolean statusworkplacepos;
    private boolean statusremontpos;
    private boolean statuscasacabinspos;
    private String commentsworkplacepos;
    private String commentsremontpos;
    private String commentscasacabinspos;

    public DivisionDTOPos() {
    }

    public DivisionDTOPos(int idpos, int numpos, String addresspos, boolean statusworkplacepos, boolean statusremontpos, boolean statuscasacabinspos, String commentsworkplacepos, String commentsremontpos, String commentscasacabinspos) {
        this.idpos = idpos;
        this.numpos = numpos;
        this.addresspos = addresspos;
        this.statusworkplacepos = statusworkplacepos;
        this.statusremontpos = statusremontpos;
        this.statuscasacabinspos = statuscasacabinspos;
        this.commentsworkplacepos = commentsworkplacepos;
        this.commentsremontpos = commentsremontpos;
        this.commentscasacabinspos = commentscasacabinspos;
    }

    public int getIdpos() {
        return idpos;
    }

    public void setIdpos(int idpos) {
        this.idpos = idpos;
    }

    public int getNumpos() {
        return numpos;
    }

    public void setNumpos(int numpos) {
        this.numpos = numpos;
    }

    public String getAddresspos() {
        return addresspos;
    }

    public void setAddresspos(String addresspos) {
        this.addresspos = addresspos;
    }

    public boolean isStatusworkplacepos() {
        return statusworkplacepos;
    }

    public void setStatusworkplacepos(boolean statusworkplacepos) {
        this.statusworkplacepos = statusworkplacepos;
    }

    public boolean isStatusremontpos() {
        return statusremontpos;
    }

    public void setStatusremontpos(boolean statusremontpos) {
        this.statusremontpos = statusremontpos;
    }

    public boolean isStatuscasacabinspos() {
        return statuscasacabinspos;
    }

    public void setStatuscasacabinspos(boolean statuscasacabinspos) {
        this.statuscasacabinspos = statuscasacabinspos;
    }

    public String getCommentsworkplacepos() {
        return commentsworkplacepos;
    }

    public void setCommentsworkplacepos(String commentsworkplacepos) {
        this.commentsworkplacepos = commentsworkplacepos;
    }

    public String getCommentsremontpos() {
        return commentsremontpos;
    }

    public void setCommentsremontpos(String commentsremontpos) {
        this.commentsremontpos = commentsremontpos;
    }

    public String getCommentscasacabinspos() {
        return commentscasacabinspos;
    }

    public void setCommentscasacabinspos(String commentscasacabinspos) {
        this.commentscasacabinspos = commentscasacabinspos;
    }

    @Override
    public String toString() {
        return "DivisionDTOPos{" +
                "idpos=" + idpos +
                ", numpos=" + numpos +
                ", addresspos='" + addresspos + '\'' +
                ", statusworkplacepos=" + statusworkplacepos +
                ", statusremontpos=" + statusremontpos +
                ", statuscasacabinspos=" + statuscasacabinspos +
                ", commentsworkplacepos='" + commentsworkplacepos + '\'' +
                ", commentsremontpos='" + commentsremontpos + '\'' +
                ", commentscasacabinspos='" + commentscasacabinspos + '\'' +
                '}';
    }
}
