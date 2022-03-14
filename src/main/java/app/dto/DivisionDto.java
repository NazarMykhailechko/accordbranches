package app.dto;

import javax.persistence.Column;
import java.util.Date;

public class DivisionDto {

    private int id;
    private int num;
    private String address;
    private String comments;
    private String datescreated;
    private String datesplaned;
    private String daystoopen;

    private String datesorenda;

    // РЕВУЦЬКИЙ
    private String datessafesRev;
    private String commentssafesRev;

    // ЛОЗИНСЬКИЙ
    private String datesvideoLoz;
    private String commentsvideoLoz;
    private String datessignalLoz;
    private String commentssignalLoz;
    private String datesfiresignalLoz;
    private String commentsfiresignalLoz;

    // ПОСТОЛ
    private String datesworkplacePos;
    private String commentsworkplacePos;
    private String datesremontPos;
    private String commentsremontPos;
    private String datescasacabinsPos;
    private String commentscasacabinsPos;

    // ШИЯН
    private String datesbannerShyan;
    private String commentsbannerShyan;
    private String datesforextabloShyan;
    private String commentsforextabloShyan;
    private String datesposterShyan;
    private String commentsposterShyan;

    // СЕМЕНЦУЛ
    private String datesconnectionSem;
    private String commentsconnectionSem;
    private String datessksSem;
    private String commentssksSem;
    private String datescomputersSem;
    private String commentscomputersSem;

    // ЦЮПКО
    private String datesstampsTsup;
    private String commentsstampsTsup;
    private String datescleaningTsup;
    private String commentscleaningTsup;

    // ГРІТЧИНА
    private String datescashregistersGritch;
    private String commentscashregistersGritch;
    private String datesmebliGritch;
    private String commentsmebliGritch;

    public DivisionDto() {
    }

    public DivisionDto(int id, int num, String address, String comments, String datescreated, String datesplaned, String daystoopen, String datesorenda, String datessafesRev, String commentssafesRev, String datesvideoLoz, String commentsvideoLoz, String datessignalLoz, String commentssignalLoz, String datesfiresignalLoz, String commentsfiresignalLoz, String datesworkplacePos, String commentsworkplacePos, String datesremontPos, String commentsremontPos, String datescasacabinsPos, String commentscasacabinsPos, String datesbannerShyan, String commentsbannerShyan, String datesforextabloShyan, String commentsforextabloShyan, String datesposterShyan, String commentsposterShyan, String datesconnectionSem, String commentsconnectionSem, String datessksSem, String commentssksSem, String datescomputersSem, String commentscomputersSem, String datesstampsTsup, String commentsstampsTsup, String datescleaningTsup, String commentscleaningTsup, String datescashregistersGritch, String commentscashregistersGritch, String datesmebliGritch, String commentsmebliGritch) {
        this.id = id;
        this.num = num;
        this.address = address;
        this.comments = comments;
        this.datescreated = datescreated;
        this.datesplaned = datesplaned;
        this.daystoopen = daystoopen;
        this.datesorenda = datesorenda;
        this.datessafesRev = datessafesRev;
        this.commentssafesRev = commentssafesRev;
        this.datesvideoLoz = datesvideoLoz;
        this.commentsvideoLoz = commentsvideoLoz;
        this.datessignalLoz = datessignalLoz;
        this.commentssignalLoz = commentssignalLoz;
        this.datesfiresignalLoz = datesfiresignalLoz;
        this.commentsfiresignalLoz = commentsfiresignalLoz;
        this.datesworkplacePos = datesworkplacePos;
        this.commentsworkplacePos = commentsworkplacePos;
        this.datesremontPos = datesremontPos;
        this.commentsremontPos = commentsremontPos;
        this.datescasacabinsPos = datescasacabinsPos;
        this.commentscasacabinsPos = commentscasacabinsPos;
        this.datesbannerShyan = datesbannerShyan;
        this.commentsbannerShyan = commentsbannerShyan;
        this.datesforextabloShyan = datesforextabloShyan;
        this.commentsforextabloShyan = commentsforextabloShyan;
        this.datesposterShyan = datesposterShyan;
        this.commentsposterShyan = commentsposterShyan;
        this.datesconnectionSem = datesconnectionSem;
        this.commentsconnectionSem = commentsconnectionSem;
        this.datessksSem = datessksSem;
        this.commentssksSem = commentssksSem;
        this.datescomputersSem = datescomputersSem;
        this.commentscomputersSem = commentscomputersSem;
        this.datesstampsTsup = datesstampsTsup;
        this.commentsstampsTsup = commentsstampsTsup;
        this.datescleaningTsup = datescleaningTsup;
        this.commentscleaningTsup = commentscleaningTsup;
        this.datescashregistersGritch = datescashregistersGritch;
        this.commentscashregistersGritch = commentscashregistersGritch;
        this.datesmebliGritch = datesmebliGritch;
        this.commentsmebliGritch = commentsmebliGritch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDatescreated() {
        return datescreated;
    }

    public void setDatescreated(String datescreated) {
        this.datescreated = datescreated;
    }

    public String getDatesplaned() {
        return datesplaned;
    }

    public void setDatesplaned(String datesplaned) {
        this.datesplaned = datesplaned;
    }

    public String getDaystoopen() {
        return daystoopen;
    }

    public void setDaystoopen(String daystoopen) {
        this.daystoopen = daystoopen;
    }

    public String getDatesorenda() {
        return datesorenda;
    }

    public void setDatesorenda(String datesorenda) {
        this.datesorenda = datesorenda;
    }

    public String getDatessafesRev() {
        return datessafesRev;
    }

    public void setDatessafesRev(String datessafesRev) {
        this.datessafesRev = datessafesRev;
    }

    public String getCommentssafesRev() {
        return commentssafesRev;
    }

    public void setCommentssafesRev(String commentssafesRev) {
        this.commentssafesRev = commentssafesRev;
    }

    public String getDatesvideoLoz() {
        return datesvideoLoz;
    }

    public void setDatesvideoLoz(String datesvideoLoz) {
        this.datesvideoLoz = datesvideoLoz;
    }

    public String getCommentsvideoLoz() {
        return commentsvideoLoz;
    }

    public void setCommentsvideoLoz(String commentsvideoLoz) {
        this.commentsvideoLoz = commentsvideoLoz;
    }

    public String getDatessignalLoz() {
        return datessignalLoz;
    }

    public void setDatessignalLoz(String datessignalLoz) {
        this.datessignalLoz = datessignalLoz;
    }

    public String getCommentssignalLoz() {
        return commentssignalLoz;
    }

    public void setCommentssignalLoz(String commentssignalLoz) {
        this.commentssignalLoz = commentssignalLoz;
    }

    public String getDatesfiresignalLoz() {
        return datesfiresignalLoz;
    }

    public void setDatesfiresignalLoz(String datesfiresignalLoz) {
        this.datesfiresignalLoz = datesfiresignalLoz;
    }

    public String getCommentsfiresignalLoz() {
        return commentsfiresignalLoz;
    }

    public void setCommentsfiresignalLoz(String commentsfiresignalLoz) {
        this.commentsfiresignalLoz = commentsfiresignalLoz;
    }

    public String getDatesworkplacePos() {
        return datesworkplacePos;
    }

    public void setDatesworkplacePos(String datesworkplacePos) {
        this.datesworkplacePos = datesworkplacePos;
    }

    public String getCommentsworkplacePos() {
        return commentsworkplacePos;
    }

    public void setCommentsworkplacePos(String commentsworkplacePos) {
        this.commentsworkplacePos = commentsworkplacePos;
    }

    public String getDatesremontPos() {
        return datesremontPos;
    }

    public void setDatesremontPos(String datesremontPos) {
        this.datesremontPos = datesremontPos;
    }

    public String getCommentsremontPos() {
        return commentsremontPos;
    }

    public void setCommentsremontPos(String commentsremontPos) {
        this.commentsremontPos = commentsremontPos;
    }

    public String getDatescasacabinsPos() {
        return datescasacabinsPos;
    }

    public void setDatescasacabinsPos(String datescasacabinsPos) {
        this.datescasacabinsPos = datescasacabinsPos;
    }

    public String getCommentscasacabinsPos() {
        return commentscasacabinsPos;
    }

    public void setCommentscasacabinsPos(String commentscasacabinsPos) {
        this.commentscasacabinsPos = commentscasacabinsPos;
    }

    public String getDatesbannerShyan() {
        return datesbannerShyan;
    }

    public void setDatesbannerShyan(String datesbannerShyan) {
        this.datesbannerShyan = datesbannerShyan;
    }

    public String getCommentsbannerShyan() {
        return commentsbannerShyan;
    }

    public void setCommentsbannerShyan(String commentsbannerShyan) {
        this.commentsbannerShyan = commentsbannerShyan;
    }

    public String getDatesforextabloShyan() {
        return datesforextabloShyan;
    }

    public void setDatesforextabloShyan(String datesforextabloShyan) {
        this.datesforextabloShyan = datesforextabloShyan;
    }

    public String getCommentsforextabloShyan() {
        return commentsforextabloShyan;
    }

    public void setCommentsforextabloShyan(String commentsforextabloShyan) {
        this.commentsforextabloShyan = commentsforextabloShyan;
    }

    public String getDatesposterShyan() {
        return datesposterShyan;
    }

    public void setDatesposterShyan(String datesposterShyan) {
        this.datesposterShyan = datesposterShyan;
    }

    public String getCommentsposterShyan() {
        return commentsposterShyan;
    }

    public void setCommentsposterShyan(String commentsposterShyan) {
        this.commentsposterShyan = commentsposterShyan;
    }

    public String getDatesconnectionSem() {
        return datesconnectionSem;
    }

    public void setDatesconnectionSem(String datesconnectionSem) {
        this.datesconnectionSem = datesconnectionSem;
    }

    public String getCommentsconnectionSem() {
        return commentsconnectionSem;
    }

    public void setCommentsconnectionSem(String commentsconnectionSem) {
        this.commentsconnectionSem = commentsconnectionSem;
    }

    public String getDatessksSem() {
        return datessksSem;
    }

    public void setDatessksSem(String datessksSem) {
        this.datessksSem = datessksSem;
    }

    public String getCommentssksSem() {
        return commentssksSem;
    }

    public void setCommentssksSem(String commentssksSem) {
        this.commentssksSem = commentssksSem;
    }

    public String getDatescomputersSem() {
        return datescomputersSem;
    }

    public void setDatescomputersSem(String datescomputersSem) {
        this.datescomputersSem = datescomputersSem;
    }

    public String getCommentscomputersSem() {
        return commentscomputersSem;
    }

    public void setCommentscomputersSem(String commentscomputersSem) {
        this.commentscomputersSem = commentscomputersSem;
    }

    public String getDatesstampsTsup() {
        return datesstampsTsup;
    }

    public void setDatesstampsTsup(String datesstampsTsup) {
        this.datesstampsTsup = datesstampsTsup;
    }

    public String getCommentsstampsTsup() {
        return commentsstampsTsup;
    }

    public void setCommentsstampsTsup(String commentsstampsTsup) {
        this.commentsstampsTsup = commentsstampsTsup;
    }

    public String getDatescleaningTsup() {
        return datescleaningTsup;
    }

    public void setDatescleaningTsup(String datescleaningTsup) {
        this.datescleaningTsup = datescleaningTsup;
    }

    public String getCommentscleaningTsup() {
        return commentscleaningTsup;
    }

    public void setCommentscleaningTsup(String commentscleaningTsup) {
        this.commentscleaningTsup = commentscleaningTsup;
    }

    public String getDatescashregistersGritch() {
        return datescashregistersGritch;
    }

    public void setDatescashregistersGritch(String datescashregistersGritch) {
        this.datescashregistersGritch = datescashregistersGritch;
    }

    public String getCommentscashregistersGritch() {
        return commentscashregistersGritch;
    }

    public void setCommentscashregistersGritch(String commentscashregistersGritch) {
        this.commentscashregistersGritch = commentscashregistersGritch;
    }

    public String getDatesmebliGritch() {
        return datesmebliGritch;
    }

    public void setDatesmebliGritch(String datesmebliGritch) {
        this.datesmebliGritch = datesmebliGritch;
    }

    public String getCommentsmebliGritch() {
        return commentsmebliGritch;
    }

    public void setCommentsmebliGritch(String commentsmebliGritch) {
        this.commentsmebliGritch = commentsmebliGritch;
    }

    @Override
    public String toString() {
        return "DivisionDto{" +
                "id=" + id +
                ", num=" + num +
                ", address='" + address + '\'' +
                ", comments='" + comments + '\'' +
                ", datescreated='" + datescreated + '\'' +
                ", datesplaned='" + datesplaned + '\'' +
                ", daystoopen='" + daystoopen + '\'' +
                ", datesorenda='" + datesorenda + '\'' +
                ", datessafesRev='" + datessafesRev + '\'' +
                ", commentssafesRev='" + commentssafesRev + '\'' +
                ", datesvideoLoz='" + datesvideoLoz + '\'' +
                ", commentsvideoLoz='" + commentsvideoLoz + '\'' +
                ", datessignalLoz='" + datessignalLoz + '\'' +
                ", commentssignalLoz='" + commentssignalLoz + '\'' +
                ", datesfiresignalLoz='" + datesfiresignalLoz + '\'' +
                ", commentsfiresignalLoz='" + commentsfiresignalLoz + '\'' +
                ", datesworkplacePos='" + datesworkplacePos + '\'' +
                ", commentsworkplacePos='" + commentsworkplacePos + '\'' +
                ", datesremontPos='" + datesremontPos + '\'' +
                ", commentsremontPos='" + commentsremontPos + '\'' +
                ", datescasacabinsPos='" + datescasacabinsPos + '\'' +
                ", commentscasacabinsPos='" + commentscasacabinsPos + '\'' +
                ", datesbannerShyan='" + datesbannerShyan + '\'' +
                ", commentsbannerShyan='" + commentsbannerShyan + '\'' +
                ", datesforextabloShyan='" + datesforextabloShyan + '\'' +
                ", commentsforextabloShyan='" + commentsforextabloShyan + '\'' +
                ", datesposterShyan='" + datesposterShyan + '\'' +
                ", commentsposterShyan='" + commentsposterShyan + '\'' +
                ", datesconnectionSem='" + datesconnectionSem + '\'' +
                ", commentsconnectionSem='" + commentsconnectionSem + '\'' +
                ", datessksSem='" + datessksSem + '\'' +
                ", commentssksSem='" + commentssksSem + '\'' +
                ", datescomputersSem='" + datescomputersSem + '\'' +
                ", commentscomputersSem='" + commentscomputersSem + '\'' +
                ", datesstampsTsup='" + datesstampsTsup + '\'' +
                ", commentsstampsTsup='" + commentsstampsTsup + '\'' +
                ", datescleaningTsup='" + datescleaningTsup + '\'' +
                ", commentscleaningTsup='" + commentscleaningTsup + '\'' +
                ", datescashregistersGritch='" + datescashregistersGritch + '\'' +
                ", commentscashregistersGritch='" + commentscashregistersGritch + '\'' +
                ", datesmebliGritch='" + datesmebliGritch + '\'' +
                ", commentsmebliGritch='" + commentsmebliGritch + '\'' +
                '}';
    }
}
