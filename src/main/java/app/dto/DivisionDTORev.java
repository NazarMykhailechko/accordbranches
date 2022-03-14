package app.dto;

public class DivisionDTORev {

    private int idrev;
    private int numrev;
    private String addressrev;
    private boolean statussafesrev;
    private String commentssafesrev;

    public DivisionDTORev() {
    }

    public DivisionDTORev(int idrev, int numrev, String addressrev, boolean statussafesrev, String commentssafesrev) {
        this.idrev = idrev;
        this.numrev = numrev;
        this.addressrev = addressrev;
        this.statussafesrev = statussafesrev;
        this.commentssafesrev = commentssafesrev;
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

    public boolean isStatussafesrev() {
        return statussafesrev;
    }

    public void setStatussafesrev(boolean statussafesrev) {
        this.statussafesrev = statussafesrev;
    }

    public String getCommentssafesrev() {
        return commentssafesrev;
    }

    public void setCommentssafesrev(String commentssafesrev) {
        this.commentssafesrev = commentssafesrev;
    }

    @Override
    public String toString() {
        return "DivisionDTORev{" +
                "idrev=" + idrev +
                ", numrev=" + numrev +
                ", addressrev='" + addressrev + '\'' +
                ", statussafesrev=" + statussafesrev +
                ", commentssafesrev='" + commentssafesrev + '\'' +
                '}';
    }
}
