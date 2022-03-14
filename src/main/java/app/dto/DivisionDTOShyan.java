package app.dto;

public class DivisionDTOShyan {

    private int idshyan;
    private int numshyan;
    private String addressshyan;
    private boolean statusbannershyan;
    private boolean statusforextabloshyan;
    private boolean statuspostershyan;
    private String commentsbannershyan;
    private String commentsforextabloshyan;
    private String commentspostershyan;

    public DivisionDTOShyan() {
    }

    public DivisionDTOShyan(int idshyan, int numshyan, String addressshyan, boolean statusbannershyan, boolean statusforextabloshyan, boolean statuspostershyan, String commentsbannershyan, String commentsforextabloshyan, String commentspostershyan) {
        this.idshyan = idshyan;
        this.numshyan = numshyan;
        this.addressshyan = addressshyan;
        this.statusbannershyan = statusbannershyan;
        this.statusforextabloshyan = statusforextabloshyan;
        this.statuspostershyan = statuspostershyan;
        this.commentsbannershyan = commentsbannershyan;
        this.commentsforextabloshyan = commentsforextabloshyan;
        this.commentspostershyan = commentspostershyan;
    }

    public int getIdshyan() {
        return idshyan;
    }

    public void setIdshyan(int idshyan) {
        this.idshyan = idshyan;
    }

    public int getNumshyan() {
        return numshyan;
    }

    public void setNumshyan(int numshyan) {
        this.numshyan = numshyan;
    }

    public String getAddressshyan() {
        return addressshyan;
    }

    public void setAddressshyan(String addressshyan) {
        this.addressshyan = addressshyan;
    }

    public boolean isStatusbannershyan() {
        return statusbannershyan;
    }

    public void setStatusbannershyan(boolean statusbannershyan) {
        this.statusbannershyan = statusbannershyan;
    }

    public boolean isStatusforextabloshyan() {
        return statusforextabloshyan;
    }

    public void setStatusforextabloshyan(boolean statusforextabloshyan) {
        this.statusforextabloshyan = statusforextabloshyan;
    }

    public boolean isStatuspostershyan() {
        return statuspostershyan;
    }

    public void setStatuspostershyan(boolean statuspostershyan) {
        this.statuspostershyan = statuspostershyan;
    }

    public String getCommentsbannershyan() {
        return commentsbannershyan;
    }

    public void setCommentsbannershyan(String commentsbannershyan) {
        this.commentsbannershyan = commentsbannershyan;
    }

    public String getCommentsforextabloshyan() {
        return commentsforextabloshyan;
    }

    public void setCommentsforextabloshyan(String commentsforextabloshyan) {
        this.commentsforextabloshyan = commentsforextabloshyan;
    }

    public String getCommentspostershyan() {
        return commentspostershyan;
    }

    public void setCommentspostershyan(String commentspostershyan) {
        this.commentspostershyan = commentspostershyan;
    }

    @Override
    public String toString() {
        return "DivisionDTOShyan{" +
                "idshyan=" + idshyan +
                ", numshyan=" + numshyan +
                ", addressshyan='" + addressshyan + '\'' +
                ", statusbannershyan=" + statusbannershyan +
                ", statusforextabloshyan=" + statusforextabloshyan +
                ", statuspostershyan=" + statuspostershyan +
                ", commentsbannershyan='" + commentsbannershyan + '\'' +
                ", commentsforextabloshyan='" + commentsforextabloshyan + '\'' +
                ", commentspostershyan='" + commentspostershyan + '\'' +
                '}';
    }
}
