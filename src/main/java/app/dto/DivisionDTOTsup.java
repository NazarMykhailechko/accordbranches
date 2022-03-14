package app.dto;

public class DivisionDTOTsup {

    private int idtsup;
    private int numtsup;
    private String addresstsup;
    private boolean statusstampstsup;
    private boolean statuscleaningtsup;
    private String commentsstampstsup;
    private String commentscleaningtsup;

    public DivisionDTOTsup() {
    }

    public DivisionDTOTsup(int idtsup, int numtsup, String addresstsup, boolean statusstampstsup, boolean statuscleaningtsup, String commentsstampstsup, String commentscleaningtsup) {
        this.idtsup = idtsup;
        this.numtsup = numtsup;
        this.addresstsup = addresstsup;
        this.statusstampstsup = statusstampstsup;
        this.statuscleaningtsup = statuscleaningtsup;
        this.commentsstampstsup = commentsstampstsup;
        this.commentscleaningtsup = commentscleaningtsup;
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

    public String getCommentsstampstsup() {
        return commentsstampstsup;
    }

    public void setCommentsstampstsup(String commentsstampstsup) {
        this.commentsstampstsup = commentsstampstsup;
    }

    public String getCommentscleaningtsup() {
        return commentscleaningtsup;
    }

    public void setCommentscleaningtsup(String commentscleaningtsup) {
        this.commentscleaningtsup = commentscleaningtsup;
    }

    @Override
    public String toString() {
        return "DivisionDTOTsup{" +
                "idtsup=" + idtsup +
                ", numtsup=" + numtsup +
                ", addresstsup='" + addresstsup + '\'' +
                ", statusstampstsup=" + statusstampstsup +
                ", statuscleaningtsup=" + statuscleaningtsup +
                ", commentsstampstsup='" + commentsstampstsup + '\'' +
                ", commentscleaningtsup='" + commentscleaningtsup + '\'' +
                '}';
    }
}
