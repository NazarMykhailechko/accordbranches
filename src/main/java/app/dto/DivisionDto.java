package app.dto;

import java.util.Date;

public class DivisionDto {

    private int id;
    private int num;
    private String address;
    private String comments;
    private String datescreated;
    private String datesplaned;
    private String daystoopen;


    // РЕВУЦЬКИЙ
    private String datesorendaRev;
    private String datessafesRev;

    // ЛОЗИНСЬКИЙ
    private String datesvideoLoz;
    private String datessignalLoz;
    private String datesfiresignalLoz;

    // ПОСТОЛ
    private String datesworkplacePos;
    private String datesremontPos;
    private String datescasacabinsPos;

    // ШИЯН
    private String datesbannerShyan;
    private String datesforextabloShyan;
    private String datesposterShyan;

    // СЕМЕНЦУЛ
    private String datesconnectionSem;
    private String datessksSem;
    private String datescomputersSem;

    // ЦЮПКО
    private String datesstampsTsup;
    private String datescleaningTsup;

    // ГРІТЧИНА
    private String datescashregistersGritch;
    private String datesmebliGritch;


    public DivisionDto() {
    }

    public DivisionDto(int id, int num, String address, String comments, String datescreated, String datesplaned, String daystoopen, String datesorendaRev, String datessafesRev, String datesvideoLoz, String datessignalLoz, String datesfiresignalLoz, String datesworkplacePos, String datesremontPos, String datescasacabinsPos, String datesbannerShyan, String datesforextabloShyan, String datesposterShyan, String datesconnectionSem, String datessksSem, String datescomputersSem, String datesstampsTsup, String datescleaningTsup, String datescashregistersGritch, String datesmebliGritch) {
        this.id = id;
        this.num = num;
        this.address = address;
        this.comments = comments;
        this.datescreated = datescreated;
        this.datesplaned = datesplaned;
        this.daystoopen = daystoopen;
        this.datesorendaRev = datesorendaRev;
        this.datessafesRev = datessafesRev;
        this.datesvideoLoz = datesvideoLoz;
        this.datessignalLoz = datessignalLoz;
        this.datesfiresignalLoz = datesfiresignalLoz;
        this.datesworkplacePos = datesworkplacePos;
        this.datesremontPos = datesremontPos;
        this.datescasacabinsPos = datescasacabinsPos;
        this.datesbannerShyan = datesbannerShyan;
        this.datesforextabloShyan = datesforextabloShyan;
        this.datesposterShyan = datesposterShyan;
        this.datesconnectionSem = datesconnectionSem;
        this.datessksSem = datessksSem;
        this.datescomputersSem = datescomputersSem;
        this.datesstampsTsup = datesstampsTsup;
        this.datescleaningTsup = datescleaningTsup;
        this.datescashregistersGritch = datescashregistersGritch;
        this.datesmebliGritch = datesmebliGritch;
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

    public String getDatesorendaRev() {
        return datesorendaRev;
    }

    public void setDatesorendaRev(String datesorendaRev) {
        this.datesorendaRev = datesorendaRev;
    }

    public String getDatessafesRev() {
        return datessafesRev;
    }

    public void setDatessafesRev(String datessafesRev) {
        this.datessafesRev = datessafesRev;
    }

    public String getDatesvideoLoz() {
        return datesvideoLoz;
    }

    public void setDatesvideoLoz(String datesvideoLoz) {
        this.datesvideoLoz = datesvideoLoz;
    }

    public String getDatessignalLoz() {
        return datessignalLoz;
    }

    public void setDatessignalLoz(String datessignalLoz) {
        this.datessignalLoz = datessignalLoz;
    }

    public String getDatesfiresignalLoz() {
        return datesfiresignalLoz;
    }

    public void setDatesfiresignalLoz(String datesfiresignalLoz) {
        this.datesfiresignalLoz = datesfiresignalLoz;
    }

    public String getDatesworkplacePos() {
        return datesworkplacePos;
    }

    public void setDatesworkplacePos(String datesworkplacePos) {
        this.datesworkplacePos = datesworkplacePos;
    }

    public String getDatesremontPos() {
        return datesremontPos;
    }

    public void setDatesremontPos(String datesremontPos) {
        this.datesremontPos = datesremontPos;
    }

    public String getDatescasacabinsPos() {
        return datescasacabinsPos;
    }

    public void setDatescasacabinsPos(String datescasacabinsPos) {
        this.datescasacabinsPos = datescasacabinsPos;
    }

    public String getDatesbannerShyan() {
        return datesbannerShyan;
    }

    public void setDatesbannerShyan(String datesbannerShyan) {
        this.datesbannerShyan = datesbannerShyan;
    }

    public String getDatesforextabloShyan() {
        return datesforextabloShyan;
    }

    public void setDatesforextabloShyan(String datesforextabloShyan) {
        this.datesforextabloShyan = datesforextabloShyan;
    }

    public String getDatesposterShyan() {
        return datesposterShyan;
    }

    public void setDatesposterShyan(String datesposterShyan) {
        this.datesposterShyan = datesposterShyan;
    }

    public String getDatesconnectionSem() {
        return datesconnectionSem;
    }

    public void setDatesconnectionSem(String datesconnectionSem) {
        this.datesconnectionSem = datesconnectionSem;
    }

    public String getDatessksSem() {
        return datessksSem;
    }

    public void setDatessksSem(String datessksSem) {
        this.datessksSem = datessksSem;
    }

    public String getDatescomputersSem() {
        return datescomputersSem;
    }

    public void setDatescomputersSem(String datescomputersSem) {
        this.datescomputersSem = datescomputersSem;
    }

    public String getDatesstampsTsup() {
        return datesstampsTsup;
    }

    public void setDatesstampsTsup(String datesstampsTsup) {
        this.datesstampsTsup = datesstampsTsup;
    }

    public String getDatescleaningTsup() {
        return datescleaningTsup;
    }

    public void setDatescleaningTsup(String datescleaningTsup) {
        this.datescleaningTsup = datescleaningTsup;
    }

    public String getDatescashregistersGritch() {
        return datescashregistersGritch;
    }

    public void setDatescashregistersGritch(String datescashregistersGritch) {
        this.datescashregistersGritch = datescashregistersGritch;
    }

    public String getDatesmebliGritch() {
        return datesmebliGritch;
    }

    public void setDatesmebliGritch(String datesmebliGritch) {
        this.datesmebliGritch = datesmebliGritch;
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
                ", datesorendaRev='" + datesorendaRev + '\'' +
                ", datessafesRev='" + datessafesRev + '\'' +
                ", datesvideoLoz='" + datesvideoLoz + '\'' +
                ", datessignalLoz='" + datessignalLoz + '\'' +
                ", datesfiresignalLoz='" + datesfiresignalLoz + '\'' +
                ", datesworkplacePos='" + datesworkplacePos + '\'' +
                ", datesremontPos='" + datesremontPos + '\'' +
                ", datescasacabinsPos='" + datescasacabinsPos + '\'' +
                ", datesbannerShyan='" + datesbannerShyan + '\'' +
                ", datesforextabloShyan='" + datesforextabloShyan + '\'' +
                ", datesposterShyan='" + datesposterShyan + '\'' +
                ", datesconnectionSem='" + datesconnectionSem + '\'' +
                ", datessksSem='" + datessksSem + '\'' +
                ", datescomputersSem='" + datescomputersSem + '\'' +
                ", datesstampsTsup='" + datesstampsTsup + '\'' +
                ", datescleaningTsup='" + datescleaningTsup + '\'' +
                ", datescashregistersGritch='" + datescashregistersGritch + '\'' +
                ", datesmebliGritch='" + datesmebliGritch + '\'' +
                '}';
    }
}
