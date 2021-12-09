package app.model;


import app.dto.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@NamedNativeQueries({
        @NamedNativeQuery(name = "Divisions", query = "select id,num,address,comments,cast(datescreated  as CHAR(255)) as datescreated,cast(datesplaned as CHAR(255)) as datesplaned, cast(daystoopen as CHAR(255)) as daystoopen, cast(datesorenda_rev as CHAR(255)) as datesorenda_rev, cast(datessafes_rev as CHAR(255)) as datessafes_rev, cast(datesvideo_loz as CHAR(255)) as datesvideo_loz, cast(datessignal_loz as CHAR(255)) as datessignal_loz, cast(datesfiresignal_loz as CHAR(255)) as datesfiresignal_loz, cast(datesworkplace_pos as CHAR(255)) as datesworkplace_pos, cast(datesremont_pos as CHAR(255)) as datesremont_pos, cast(datescasacabins_pos as CHAR(255)) as datescasacabins_pos, cast(datesbanner_shyan as CHAR(255)) as datesbanner_shyan, cast(datesforextablo_shyan as CHAR(255)) as datesforextablo_shyan, cast(datesposter_shyan as CHAR(255)) as datesposter_shyan, cast(datesconnection_sem as CHAR(255)) as datesconnection_sem, cast(datessks_sem as CHAR(255)) as datessks_sem, cast(datescomputers_sem as CHAR(255)) as datescomputers_sem , cast(datesstamps_tsup as CHAR(255)) as datesstamps_tsup, cast(datescleaning_tsup as CHAR(255)) as datescleaning_tsup, cast(datescashregisters_gritch as CHAR(255)) as datescashregisters_gritch, cast(datesmebli_gritch as CHAR(255)) as datesmebli_gritch from divisions\n" +
                "union all\n" +
                "select id,num,address,comments,'К-ть днів до дедлайну' as datescreated, '' as datesplaned, '' as daystoopen, CONCAT('d', statusorenda_rev, cast(datesorenda_rev as CHAR(255))) as datesorenda_rev, CONCAT('d', statussafes_rev, cast(datessafes_rev as CHAR(255))) as datessafes_rev, CONCAT('d', statusvideo_loz, cast(datesvideo_loz as CHAR(255))) as datesvideo_loz, CONCAT('d', statussignal_loz, cast(datessignal_loz as CHAR(255))) as datessignal_loz, CONCAT('d', statusfiresignal_loz, cast(datesfiresignal_loz as CHAR(255))) as datesfiresignal_loz, CONCAT('d', statusworkplace_pos, cast(datesworkplace_pos as CHAR(255))) as datesworkplace_pos, CONCAT('d', statusremont_pos, cast(datesremont_pos as CHAR(255))) as datesremont_pos, CONCAT('d', statuscasacabins_pos, cast(datescasacabins_pos as CHAR(255))) as datescasacabins_pos, CONCAT('d', statusbanner_shyan, cast(datesbanner_shyan as CHAR(255))) as datesbanner_shyan, CONCAT('d', statusforextablo_shyan, cast(datesforextablo_shyan as CHAR(255))) as datesforextablo_shyan, CONCAT('d', statusposter_shyan, cast(datesposter_shyan as CHAR(255))) as datesposter_shyan, CONCAT('d', statusconnection_sem, cast(datesconnection_sem as CHAR(255))) as datesconnection_sem, CONCAT('d', statussks_sem, cast(datessks_sem as CHAR(255))) as datessks_sem, CONCAT('d', statuscomputers_sem, cast(datescomputers_sem as CHAR(255))) as datescomputers_sem , CONCAT('d', statusstamps_tsup, cast(datesstamps_tsup as CHAR(255))) as datesstamps_tsup, CONCAT('d', statuscleaning_tsup, cast(datescleaning_tsup as CHAR(255))) as datescleaning_tsup, CONCAT('d', statuscashregisters_gritch, cast(datescashregisters_gritch as CHAR(255))) as datescashregisters_gritch, CONCAT('d', statusmebli_gritch, cast(datesmebli_gritch as CHAR(255))) as datesmebli_gritch from divisions\n" +
                "union all\n" +
                "select id,num,address,comments, 'Акцептування виконання заходу' as datescreated, '' as datesplaned, '' as daystoopen, statusorenda_rev, statussafes_rev, statusvideo_loz, statussignal_loz, statusfiresignal_loz, statusworkplace_pos, statusremont_pos, statuscasacabins_pos, statusbanner_shyan, statusforextablo_shyan, statusposter_shyan, statusconnection_sem, statussks_sem, statuscomputers_sem , statusstamps_tsup, statuscleaning_tsup, statuscashregisters_gritch, statusmebli_gritch from divisions\n", resultSetMapping = "Divisions"),
        @NamedNativeQuery(name = "DivisionByIdForUpdate", query = "Select * from divisions where id=?", resultSetMapping = "DivisionsAll"),
        @NamedNativeQuery(name = "DivisionDTORev", query = "Select id, num, address, statusorenda_rev, statussafes_rev from divisions where id=?", resultSetMapping = "DivisionDTORev"),
        @NamedNativeQuery(name = "DivisionDTOLoz", query = "Select id, num, address, statusvideo_loz, statussignal_loz, statusfiresignal_loz from divisions where id=?", resultSetMapping = "DivisionDTOLoz"),
        @NamedNativeQuery(name = "DivisionDTOPos", query = "Select id, num, address, statusworkplace_pos, statusremont_pos, statuscasacabins_pos from divisions where id=?", resultSetMapping = "DivisionDTOPos"),
        @NamedNativeQuery(name = "DivisionDTOShyan", query = "Select id, num, address, statusbanner_shyan, statusforextablo_shyan, statusposter_shyan from divisions where id=?", resultSetMapping = "DivisionDTOShyan"),
        @NamedNativeQuery(name = "DivisionDTOSem", query = "Select id, num, address, statusconnection_sem, statussks_sem, statuscomputers_sem from divisions where id=?", resultSetMapping = "DivisionDTOSem"),
        @NamedNativeQuery(name = "DivisionDTOTsup", query = "Select id, num, address, statusstamps_tsup, statuscleaning_tsup from divisions where id=?", resultSetMapping = "DivisionDTOTsup"),
        @NamedNativeQuery(name = "DivisionDTOGritch", query = "Select id, num, address, statuscashregisters_gritch, statusmebli_gritch from divisions where id=?", resultSetMapping = "DivisionDTOGritch")
        })

@SqlResultSetMapping(name = "Divisions", classes = @ConstructorResult(targetClass = DivisionDto.class,
        columns = {

                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "comments"),
                @ColumnResult(name = "datescreated"),
                @ColumnResult(name = "datesplaned"),
                @ColumnResult(name = "daystoopen"),
                @ColumnResult(name = "datesorenda_rev"),
                @ColumnResult(name = "datessafes_rev"),
                @ColumnResult(name = "datesvideo_loz"),
                @ColumnResult(name = "datessignal_loz"),
                @ColumnResult(name = "datesfiresignal_loz"),
                @ColumnResult(name = "datesworkplace_pos"),
                @ColumnResult(name = "datesremont_pos"),
                @ColumnResult(name = "datescasacabins_pos"),
                @ColumnResult(name = "datesbanner_shyan"),
                @ColumnResult(name = "datesforextablo_shyan"),
                @ColumnResult(name = "datesposter_shyan"),
                @ColumnResult(name = "datesconnection_sem"),
                @ColumnResult(name = "datessks_sem"),
                @ColumnResult(name = "datescomputers_sem"),
                @ColumnResult(name = "datesstamps_tsup"),
                @ColumnResult(name = "datescleaning_tsup"),
                @ColumnResult(name = "datescashregisters_gritch"),
                @ColumnResult(name = "datesmebli_gritch")

        }
)
)
@SqlResultSetMapping(name = "DivisionsAll", classes = @ConstructorResult(targetClass = Division.class,
        columns = {

                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "comments"),
                @ColumnResult(name = "datescreated"),
                @ColumnResult(name = "datesplaned"),
                @ColumnResult(name = "daystoopen"),
                @ColumnResult(name = "datesorenda_rev"),
                @ColumnResult(name = "statusorenda_rev"),
                @ColumnResult(name = "datessafes_rev"),
                @ColumnResult(name = "statussafes_rev"),
                @ColumnResult(name = "datesvideo_loz"),
                @ColumnResult(name = "statusvideo_loz"),
                @ColumnResult(name = "datessignal_loz"),
                @ColumnResult(name = "statussignal_loz"),
                @ColumnResult(name = "datesfiresignal_loz"),
                @ColumnResult(name = "statusfiresignal_loz"),
                @ColumnResult(name = "datesworkplace_pos"),
                @ColumnResult(name = "statusworkplace_pos"),
                @ColumnResult(name = "datesremont_pos"),
                @ColumnResult(name = "statusremont_pos"),
                @ColumnResult(name = "datescasacabins_pos"),
                @ColumnResult(name = "statuscasacabins_pos"),
                @ColumnResult(name = "datesbanner_shyan"),
                @ColumnResult(name = "statusbanner_shyan"),
                @ColumnResult(name = "datesforextablo_shyan"),
                @ColumnResult(name = "statusforextablo_shyan"),
                @ColumnResult(name = "datesposter_shyan"),
                @ColumnResult(name = "statusposter_shyan"),
                @ColumnResult(name = "datesconnection_sem"),
                @ColumnResult(name = "statusconnection_sem"),
                @ColumnResult(name = "datessks_sem"),
                @ColumnResult(name = "statussks_sem"),
                @ColumnResult(name = "datescomputers_sem"),
                @ColumnResult(name = "statuscomputers_sem"),
                @ColumnResult(name = "datesstamps_tsup"),
                @ColumnResult(name = "statusstamps_tsup"),
                @ColumnResult(name = "datescleaning_tsup"),
                @ColumnResult(name = "statuscleaning_tsup"),
                @ColumnResult(name = "datescashregisters_gritch"),
                @ColumnResult(name = "statuscashregisters_gritch"),
                @ColumnResult(name = "datesmebli_gritch"),
                @ColumnResult(name = "statusmebli_gritch")

        }
)
)
@SqlResultSetMapping(name = "DivisionDTORev", classes = @ConstructorResult(targetClass = DivisionDTORev.class,
        columns = {
                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "statusorenda_rev", type = boolean.class),
                @ColumnResult(name = "statussafes_rev", type = boolean.class)
        }
)
)
@SqlResultSetMapping(name = "DivisionDTOLoz", classes = @ConstructorResult(targetClass = DivisionDTOLoz.class,
        columns = {
                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "statusvideo_loz", type = boolean.class),
                @ColumnResult(name = "statussignal_loz", type = boolean.class),
                @ColumnResult(name = "statusfiresignal_loz", type = boolean.class)
        }
)
)
@SqlResultSetMapping(name = "DivisionDTOPos", classes = @ConstructorResult(targetClass = DivisionDTOPos.class,
        columns = {
                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "statusworkplace_pos", type = boolean.class),
                @ColumnResult(name = "statusremont_pos", type = boolean.class),
                @ColumnResult(name = "statuscasacabins_pos", type = boolean.class)
        }
)
)
@SqlResultSetMapping(name = "DivisionDTOShyan", classes = @ConstructorResult(targetClass = DivisionDTOShyan.class,
        columns = {
                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "statusbanner_shyan", type = boolean.class),
                @ColumnResult(name = "statusforextablo_shyan", type = boolean.class),
                @ColumnResult(name = "statusposter_shyan", type = boolean.class)
        }
)
)
@SqlResultSetMapping(name = "DivisionDTOSem", classes = @ConstructorResult(targetClass = DivisionDTOSem.class,
        columns = {
                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "statusconnection_sem", type = boolean.class),
                @ColumnResult(name = "statussks_sem", type = boolean.class),
                @ColumnResult(name = "statuscomputers_sem", type = boolean.class)
        }
)
)
@SqlResultSetMapping(name = "DivisionDTOTsup", classes = @ConstructorResult(targetClass = DivisionDTOTsup.class,
        columns = {
                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "statusstamps_tsup", type = boolean.class),
                @ColumnResult(name = "statuscleaning_tsup", type = boolean.class)
        }
)
)
@SqlResultSetMapping(name = "DivisionDTOGritch", classes = @ConstructorResult(targetClass = DivisionDTOGritch.class,
        columns = {
                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "statuscashregisters_gritch", type = boolean.class),
                @ColumnResult(name = "statusmebli_gritch", type = boolean.class)
        }
)
)
@Entity
@Table(name="divisions")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int num;

    @Column
    private String address;

    @Column
    private String comments;


    @Column(name = "datescreated", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datescreated;

    @Column(name = "datesplaned", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesplaned;

    @Column(name = "daystoopen", columnDefinition = "int default 0")
    private int daystoopen = 0;


    // РЕВУЦЬКИЙ
    @Column(name = "datesorendaRev", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesorendaRev;

    @Column(name = "statusorendaRev", columnDefinition = "tinyint(1) default false")
    private boolean statusorendaRev = false;

    @Column(name = "datessafesRev", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datessafesRev;

    @Column(name = "statussafesRev", columnDefinition = "tinyint(1) default false")
    private boolean statussafesRev = false;


    // ЛОЗИНСЬКИЙ
    @Column(name = "datesvideoLoz", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesvideoLoz;

    @Column(name = "statusvideoLoz", columnDefinition = "tinyint(1) default false")
    private boolean statusvideoLoz = false;

    @Column(name = "datessignalLoz", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datessignalLoz;

    @Column(name = "statussignalLoz", columnDefinition = "tinyint(1) default false")
    private boolean statussignalLoz = false;

    @Column(name = "datesfiresignalLoz", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesfiresignalLoz;

    @Column(name = "statusfiresignalLoz", columnDefinition = "tinyint(1) default false")
    private boolean statusfiresignalLoz = false;


    // ПОСТОЛ
    @Column(name = "datesworkplacePos", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesworkplacePos;

    @Column(name = "statusworkplacePos", columnDefinition = "tinyint(1) default false")
    private boolean statusworkplacePos = false;

    @Column(name = "datesremontPos", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesremontPos;

    @Column(name = "statusremontPos", columnDefinition = "tinyint(1) default false")
    private boolean statusremontPos = false;

    @Column(name = "datescasacabinsPos", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datescasacabinsPos;

    @Column(name = "statuscasacabinsPos", columnDefinition = "tinyint(1) default false")
    private boolean statuscasacabinsPos = false;


    // ШИЯН
    @Column(name = "datesbannerShyan", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesbannerShyan;

    @Column(name = "statusbannerShyan", columnDefinition = "tinyint(1) default false")
    private boolean statusbannerShyan = false;

    @Column(name = "datesforextabloShyan", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesforextabloShyan;

    @Column(name = "statusforextabloShyan", columnDefinition = "tinyint(1) default false")
    private boolean statusforextabloShyan = false;

    @Column(name = "datesposterShyan", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesposterShyan;

    @Column(name = "statusposterShyan", columnDefinition = "tinyint(1) default false")
    private boolean statusposterShyan = false;


    // СЕМЕНЦУЛ
    @Column(name = "datesconnectionSem", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesconnectionSem;

    @Column(name = "statusconnectionSem", columnDefinition = "tinyint(1) default false")
    private boolean statusconnectionSem = false;

    @Column(name = "datessksSem", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datessksSem;

    @Column(name = "statussksSem", columnDefinition = "tinyint(1) default false")
    private boolean statussksSem = false;

    @Column(name = "datescomputersSem", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datescomputersSem;

    @Column(name = "statuscomputersSem", columnDefinition = "tinyint(1) default false")
    private boolean statuscomputersSem = false;


    // ЦЮПКО
    @Column(name = "datesstampsTsup", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesstampsTsup;

    @Column(name = "statusstampsTsup", columnDefinition = "tinyint(1) default false")
    private boolean statusstampsTsup = false;

    @Column(name = "datescleaningTsup", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datescleaningTsup;

    @Column(name = "statuscleaningTsup", columnDefinition = "tinyint(1) default false")
    private boolean statuscleaningTsup = false;


    // ГРІТЧИНА
    @Column(name = "datescashregistersGritch", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datescashregistersGritch;

    @Column(name = "statuscashregistersGritch", columnDefinition = "tinyint(1) default false")
    private boolean statuscashregistersGritch = false;

    @Column(name = "datesmebliGritch", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesmebliGritch;

    @Column(name = "statusmebliGritch", columnDefinition = "tinyint(1) default false")
    private boolean statusmebliGritch = false;

    public Division() {
    }

    public Division(int id, int num, String address, String comments, Date datescreated, Date datesplaned, int daystoopen, Date datesorendaRev, boolean statusorendaRev, Date datessafesRev, boolean statussafesRev, Date datesvideoLoz, boolean statusvideoLoz, Date datessignalLoz, boolean statussignalLoz, Date datesfiresignalLoz, boolean statusfiresignalLoz, Date datesworkplacePos, boolean statusworkplacePos, Date datesremontPos, boolean statusremontPos, Date datescasacabinsPos, boolean statuscasacabinsPos, Date datesbannerShyan, boolean statusbannerShyan, Date datesforextabloShyan, boolean statusforextabloShyan, Date datesposterShyan, boolean statusposterShyan, Date datesconnectionSem, boolean statusconnectionSem, Date datessksSem, boolean statussksSem, Date datescomputersSem, boolean statuscomputersSem, Date datesstampsTsup, boolean statusstampsTsup, Date datescleaningTsup, boolean statuscleaningTsup, Date datescashregistersGritch, boolean statuscashregistersGritch, Date datesmebliGritch, boolean statusmebliGritch) {
        this.id = id;
        this.num = num;
        this.address = address;
        this.comments = comments;
        this.datescreated = datescreated;
        this.datesplaned = datesplaned;
        this.daystoopen = daystoopen;
        this.datesorendaRev = datesorendaRev;
        this.statusorendaRev = statusorendaRev;
        this.datessafesRev = datessafesRev;
        this.statussafesRev = statussafesRev;
        this.datesvideoLoz = datesvideoLoz;
        this.statusvideoLoz = statusvideoLoz;
        this.datessignalLoz = datessignalLoz;
        this.statussignalLoz = statussignalLoz;
        this.datesfiresignalLoz = datesfiresignalLoz;
        this.statusfiresignalLoz = statusfiresignalLoz;
        this.datesworkplacePos = datesworkplacePos;
        this.statusworkplacePos = statusworkplacePos;
        this.datesremontPos = datesremontPos;
        this.statusremontPos = statusremontPos;
        this.datescasacabinsPos = datescasacabinsPos;
        this.statuscasacabinsPos = statuscasacabinsPos;
        this.datesbannerShyan = datesbannerShyan;
        this.statusbannerShyan = statusbannerShyan;
        this.datesforextabloShyan = datesforextabloShyan;
        this.statusforextabloShyan = statusforextabloShyan;
        this.datesposterShyan = datesposterShyan;
        this.statusposterShyan = statusposterShyan;
        this.datesconnectionSem = datesconnectionSem;
        this.statusconnectionSem = statusconnectionSem;
        this.datessksSem = datessksSem;
        this.statussksSem = statussksSem;
        this.datescomputersSem = datescomputersSem;
        this.statuscomputersSem = statuscomputersSem;
        this.datesstampsTsup = datesstampsTsup;
        this.statusstampsTsup = statusstampsTsup;
        this.datescleaningTsup = datescleaningTsup;
        this.statuscleaningTsup = statuscleaningTsup;
        this.datescashregistersGritch = datescashregistersGritch;
        this.statuscashregistersGritch = statuscashregistersGritch;
        this.datesmebliGritch = datesmebliGritch;
        this.statusmebliGritch = statusmebliGritch;
    }

    public Division(int id, int num, String address, String comments, Date datescreated, Date datesplaned, int daystoopen, Date datesorendaRev, Date datessafesRev, Date datesvideoLoz, Date datessignalLoz, Date datesfiresignalLoz, Date datesworkplacePos, Date datesremontPos, Date datescasacabinsPos, Date datesbannerShyan, Date datesforextabloShyan, Date datesposterShyan, Date datesconnectionSem, Date datessksSem, Date datescomputersSem, Date datesstampsTsup, Date datescleaningTsup, Date datescashregistersGritch, Date datesmebliGritch) {
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

    public Division(int id, int num, String address, boolean statusorendaRev) {
        this.id = id;
        this.num = num;
        this.address = address;
        this.statusorendaRev = statusorendaRev;
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

    public Date getDatescreated() {
        return datescreated;
    }

    public void setDatescreated(Date datescreated) {
        this.datescreated = datescreated;
    }

    public Date getDatesplaned() {
        return datesplaned;
    }

    public void setDatesplaned(Date datesplaned) {
        this.datesplaned = datesplaned;
    }

    public int getDaystoopen() {
        return daystoopen;
    }

    public void setDaystoopen(int daystoopen) {
        this.daystoopen = daystoopen;
    }

    public Date getDatesorendaRev() {
        return datesorendaRev;
    }

    public void setDatesorendaRev(Date datesorendaRev) {
        this.datesorendaRev = datesorendaRev;
    }

    public boolean isStatusorendaRev() {
        return statusorendaRev;
    }

    public void setStatusorendaRev(boolean statusorendaRev) {
        this.statusorendaRev = statusorendaRev;
    }

    public Date getDatessafesRev() {
        return datessafesRev;
    }

    public void setDatessafesRev(Date datessafesRev) {
        this.datessafesRev = datessafesRev;
    }

    public boolean isStatussafesRev() {
        return statussafesRev;
    }

    public void setStatussafesRev(boolean statussafesRev) {
        this.statussafesRev = statussafesRev;
    }

    public Date getDatesvideoLoz() {
        return datesvideoLoz;
    }

    public void setDatesvideoLoz(Date datesvideoLoz) {
        this.datesvideoLoz = datesvideoLoz;
    }

    public boolean isStatusvideoLoz() {
        return statusvideoLoz;
    }

    public void setStatusvideoLoz(boolean statusvideoLoz) {
        this.statusvideoLoz = statusvideoLoz;
    }

    public Date getDatessignalLoz() {
        return datessignalLoz;
    }

    public void setDatessignalLoz(Date datessignalLoz) {
        this.datessignalLoz = datessignalLoz;
    }

    public boolean isStatussignalLoz() {
        return statussignalLoz;
    }

    public void setStatussignalLoz(boolean statussignalLoz) {
        this.statussignalLoz = statussignalLoz;
    }

    public Date getDatesfiresignalLoz() {
        return datesfiresignalLoz;
    }

    public void setDatesfiresignalLoz(Date datesfiresignalLoz) {
        this.datesfiresignalLoz = datesfiresignalLoz;
    }

    public boolean isStatusfiresignalLoz() {
        return statusfiresignalLoz;
    }

    public void setStatusfiresignalLoz(boolean statusfiresignalLoz) {
        this.statusfiresignalLoz = statusfiresignalLoz;
    }

    public Date getDatesworkplacePos() {
        return datesworkplacePos;
    }

    public void setDatesworkplacePos(Date datesworkplacePos) {
        this.datesworkplacePos = datesworkplacePos;
    }

    public boolean isStatusworkplacePos() {
        return statusworkplacePos;
    }

    public void setStatusworkplacePos(boolean statusworkplacePos) {
        this.statusworkplacePos = statusworkplacePos;
    }

    public Date getDatesremontPos() {
        return datesremontPos;
    }

    public void setDatesremontPos(Date datesremontPos) {
        this.datesremontPos = datesremontPos;
    }

    public boolean isStatusremontPos() {
        return statusremontPos;
    }

    public void setStatusremontPos(boolean statusremontPos) {
        this.statusremontPos = statusremontPos;
    }

    public Date getDatescasacabinsPos() {
        return datescasacabinsPos;
    }

    public void setDatescasacabinsPos(Date datescasacabinsPos) {
        this.datescasacabinsPos = datescasacabinsPos;
    }

    public boolean isStatuscasacabinsPos() {
        return statuscasacabinsPos;
    }

    public void setStatuscasacabinsPos(boolean statuscasacabinsPos) {
        this.statuscasacabinsPos = statuscasacabinsPos;
    }

    public Date getDatesbannerShyan() {
        return datesbannerShyan;
    }

    public void setDatesbannerShyan(Date datesbannerShyan) {
        this.datesbannerShyan = datesbannerShyan;
    }

    public boolean isStatusbannerShyan() {
        return statusbannerShyan;
    }

    public void setStatusbannerShyan(boolean statusbannerShyan) {
        this.statusbannerShyan = statusbannerShyan;
    }

    public Date getDatesforextabloShyan() {
        return datesforextabloShyan;
    }

    public void setDatesforextabloShyan(Date datesforextabloShyan) {
        this.datesforextabloShyan = datesforextabloShyan;
    }

    public boolean isStatusforextabloShyan() {
        return statusforextabloShyan;
    }

    public void setStatusforextabloShyan(boolean statusforextabloShyan) {
        this.statusforextabloShyan = statusforextabloShyan;
    }

    public Date getDatesposterShyan() {
        return datesposterShyan;
    }

    public void setDatesposterShyan(Date datesposterShyan) {
        this.datesposterShyan = datesposterShyan;
    }

    public boolean isStatusposterShyan() {
        return statusposterShyan;
    }

    public void setStatusposterShyan(boolean statusposterShyan) {
        this.statusposterShyan = statusposterShyan;
    }

    public Date getDatesconnectionSem() {
        return datesconnectionSem;
    }

    public void setDatesconnectionSem(Date datesconnectionSem) {
        this.datesconnectionSem = datesconnectionSem;
    }

    public boolean isStatusconnectionSem() {
        return statusconnectionSem;
    }

    public void setStatusconnectionSem(boolean statusconnectionSem) {
        this.statusconnectionSem = statusconnectionSem;
    }

    public Date getDatessksSem() {
        return datessksSem;
    }

    public void setDatessksSem(Date datessksSem) {
        this.datessksSem = datessksSem;
    }

    public boolean isStatussksSem() {
        return statussksSem;
    }

    public void setStatussksSem(boolean statussksSem) {
        this.statussksSem = statussksSem;
    }

    public Date getDatescomputersSem() {
        return datescomputersSem;
    }

    public void setDatescomputersSem(Date datescomputersSem) {
        this.datescomputersSem = datescomputersSem;
    }

    public boolean isStatuscomputersSem() {
        return statuscomputersSem;
    }

    public void setStatuscomputersSem(boolean statuscomputersSem) {
        this.statuscomputersSem = statuscomputersSem;
    }

    public Date getDatesstampsTsup() {
        return datesstampsTsup;
    }

    public void setDatesstampsTsup(Date datesstampsTsup) {
        this.datesstampsTsup = datesstampsTsup;
    }

    public boolean isStatusstampsTsup() {
        return statusstampsTsup;
    }

    public void setStatusstampsTsup(boolean statusstampsTsup) {
        this.statusstampsTsup = statusstampsTsup;
    }

    public Date getDatescleaningTsup() {
        return datescleaningTsup;
    }

    public void setDatescleaningTsup(Date datescleaningTsup) {
        this.datescleaningTsup = datescleaningTsup;
    }

    public boolean isStatuscleaningTsup() {
        return statuscleaningTsup;
    }

    public void setStatuscleaningTsup(boolean statuscleaningTsup) {
        this.statuscleaningTsup = statuscleaningTsup;
    }

    public Date getDatescashregistersGritch() {
        return datescashregistersGritch;
    }

    public void setDatescashregistersGritch(Date datescashregistersGritch) {
        this.datescashregistersGritch = datescashregistersGritch;
    }

    public boolean isStatuscashregistersGritch() {
        return statuscashregistersGritch;
    }

    public void setStatuscashregistersGritch(boolean statuscashregistersGritch) {
        this.statuscashregistersGritch = statuscashregistersGritch;
    }

    public Date getDatesmebliGritch() {
        return datesmebliGritch;
    }

    public void setDatesmebliGritch(Date datesmebliGritch) {
        this.datesmebliGritch = datesmebliGritch;
    }

    public boolean isStatusmebliGritch() {
        return statusmebliGritch;
    }

    public void setStatusmebliGritch(boolean statusmebliGritch) {
        this.statusmebliGritch = statusmebliGritch;
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", num=" + num +
                ", address='" + address + '\'' +
                ", comments='" + comments + '\'' +
                ", datescreated=" + datescreated +
                ", datesplaned=" + datesplaned +
                ", daystoopen=" + daystoopen +
                ", datesorendaRev=" + datesorendaRev +
                ", statusorendaRev=" + statusorendaRev +
                ", datessafesRev=" + datessafesRev +
                ", statussafesRev=" + statussafesRev +
                ", datesvideoLoz=" + datesvideoLoz +
                ", statusvideoLoz=" + statusvideoLoz +
                ", datessignalLoz=" + datessignalLoz +
                ", statussignalLoz=" + statussignalLoz +
                ", datesfiresignalLoz=" + datesfiresignalLoz +
                ", statusfiresignalLoz=" + statusfiresignalLoz +
                ", datesworkplacePos=" + datesworkplacePos +
                ", statusworkplacePos=" + statusworkplacePos +
                ", datesremontPos=" + datesremontPos +
                ", statusremontPos=" + statusremontPos +
                ", datescasacabinsPos=" + datescasacabinsPos +
                ", statuscasacabinsPos=" + statuscasacabinsPos +
                ", datesbannerShyan=" + datesbannerShyan +
                ", statusbannerShyan=" + statusbannerShyan +
                ", datesforextabloShyan=" + datesforextabloShyan +
                ", statusforextabloShyan=" + statusforextabloShyan +
                ", datesposterShyan=" + datesposterShyan +
                ", statusposterShyan=" + statusposterShyan +
                ", datesconnectionSem=" + datesconnectionSem +
                ", statusconnectionSem=" + statusconnectionSem +
                ", datessksSem=" + datessksSem +
                ", statussksSem=" + statussksSem +
                ", datescomputersSem=" + datescomputersSem +
                ", statuscomputersSem=" + statuscomputersSem +
                ", datesstampsTsup=" + datesstampsTsup +
                ", statusstampsTsup=" + statusstampsTsup +
                ", datescleaningTsup=" + datescleaningTsup +
                ", statuscleaningTsup=" + statuscleaningTsup +
                ", datescashregistersGritch=" + datescashregistersGritch +
                ", statuscashregistersGritch=" + statuscashregistersGritch +
                ", datesmebliGritch=" + datesmebliGritch +
                ", statusmebliGritch=" + statusmebliGritch +
                '}';
    }
}
