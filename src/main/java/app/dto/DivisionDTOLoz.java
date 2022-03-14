package app.dto;

public class DivisionDTOLoz {

    private int idloz;
    private int numloz;
    private String addressloz;
    private boolean statusvideoloz;
    private boolean statussignalloz;
    private boolean statusfiresignalloz;
    private String commentsvideoloz;
    private String commentssignalloz;
    private String commentsfiresignalloz;

    public DivisionDTOLoz() {
    }

    public DivisionDTOLoz(int idloz, int numloz, String addressloz, boolean statusvideoloz, boolean statussignalloz, boolean statusfiresignalloz, String commentsvideoloz, String commentssignalloz, String commentsfiresignalloz) {
        this.idloz = idloz;
        this.numloz = numloz;
        this.addressloz = addressloz;
        this.statusvideoloz = statusvideoloz;
        this.statussignalloz = statussignalloz;
        this.statusfiresignalloz = statusfiresignalloz;
        this.commentsvideoloz = commentsvideoloz;
        this.commentssignalloz = commentssignalloz;
        this.commentsfiresignalloz = commentsfiresignalloz;
    }

    public int getIdloz() {
        return idloz;
    }

    public void setIdloz(int idloz) {
        this.idloz = idloz;
    }

    public int getNumloz() {
        return numloz;
    }

    public void setNumloz(int numloz) {
        this.numloz = numloz;
    }

    public String getAddressloz() {
        return addressloz;
    }

    public void setAddressloz(String addressloz) {
        this.addressloz = addressloz;
    }

    public boolean isStatusvideoloz() {
        return statusvideoloz;
    }

    public void setStatusvideoloz(boolean statusvideoloz) {
        this.statusvideoloz = statusvideoloz;
    }

    public boolean isStatussignalloz() {
        return statussignalloz;
    }

    public void setStatussignalloz(boolean statussignalloz) {
        this.statussignalloz = statussignalloz;
    }

    public boolean isStatusfiresignalloz() {
        return statusfiresignalloz;
    }

    public void setStatusfiresignalloz(boolean statusfiresignalloz) {
        this.statusfiresignalloz = statusfiresignalloz;
    }

    public String getCommentsvideoloz() {
        return commentsvideoloz;
    }

    public void setCommentsvideoloz(String commentsvideoloz) {
        this.commentsvideoloz = commentsvideoloz;
    }

    public String getCommentssignalloz() {
        return commentssignalloz;
    }

    public void setCommentssignalloz(String commentssignalloz) {
        this.commentssignalloz = commentssignalloz;
    }

    public String getCommentsfiresignalloz() {
        return commentsfiresignalloz;
    }

    public void setCommentsfiresignalloz(String commentsfiresignalloz) {
        this.commentsfiresignalloz = commentsfiresignalloz;
    }

    @Override
    public String toString() {
        return "DivisionDTOLoz{" +
                "idloz=" + idloz +
                ", numloz=" + numloz +
                ", addressloz='" + addressloz + '\'' +
                ", statusvideoloz=" + statusvideoloz +
                ", statussignalloz=" + statussignalloz +
                ", statusfiresignalloz=" + statusfiresignalloz +
                ", commentsvideoloz='" + commentsvideoloz + '\'' +
                ", commentssignalloz='" + commentssignalloz + '\'' +
                ", commentsfiresignalloz='" + commentsfiresignalloz + '\'' +
                '}';
    }
}
