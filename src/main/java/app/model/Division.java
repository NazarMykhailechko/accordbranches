package app.model;


import app.dto.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@NamedNativeQueries({
        @NamedNativeQuery(name = "Divisions", query = "select id,num,address,comments, cast(datesorenda as CHAR(255)) as datesorenda, cast(datescreated  as CHAR(255)) as datescreated,cast(datesplaned as CHAR(255)) as datesplaned, cast(daystoopen as CHAR(255)) as daystoopen, cast(datessafes_rev as CHAR(255)) as datessafes_rev, commentssafes_rev, cast(datesvideo_loz as CHAR(255)) as datesvideo_loz, commentsvideo_loz, cast(datessignal_loz as CHAR(255)) as datessignal_loz, commentssignal_loz, cast(datesfiresignal_loz as CHAR(255)) as datesfiresignal_loz, commentsfiresignal_loz, cast(datesworkplace_pos as CHAR(255)) as datesworkplace_pos, commentsworkplace_pos, cast(datesremont_pos as CHAR(255)) as datesremont_pos, commentsremont_pos, cast(datescasacabins_pos as CHAR(255)) as datescasacabins_pos, commentscasacabins_pos, cast(datesbanner_shyan as CHAR(255)) as datesbanner_shyan, commentsbanner_shyan, cast(datesforextablo_shyan as CHAR(255)) as datesforextablo_shyan, commentsforextablo_shyan, cast(datesposter_shyan as CHAR(255)) as datesposter_shyan, commentsposter_shyan, cast(datesconnection_sem as CHAR(255)) as datesconnection_sem, commentsconnection_sem, cast(datessks_sem as CHAR(255)) as datessks_sem, commentssks_sem, cast(datescomputers_sem as CHAR(255)) as datescomputers_sem, commentscomputers_sem, cast(datesstamps_tsup as CHAR(255)) as datesstamps_tsup, commentsstamps_tsup, cast(datescleaning_tsup as CHAR(255)) as datescleaning_tsup, commentscleaning_tsup, cast(datescashregisters_gritch as CHAR(255)) as datescashregisters_gritch, commentscashregisters_gritch, cast(datesmebli_gritch as CHAR(255)) as datesmebli_gritch, commentsmebli_gritch from divisions\n" +
                "union all\n" +
                "select id,num,address,comments, cast(datesorenda as CHAR(255)) as datesorenda, 'К-ть днів до дедлайну' as datescreated, '' as datesplaned, '' as daystoopen, CONCAT('d', statussafes_rev, cast(datessafes_rev as CHAR(255))) as datessafes_rev, commentssafes_rev, CONCAT('d', statusvideo_loz, cast(datesvideo_loz as CHAR(255))) as datesvideo_loz, commentsvideo_loz, CONCAT('d', statussignal_loz, cast(datessignal_loz as CHAR(255))) as datessignal_loz, commentssignal_loz, CONCAT('d', statusfiresignal_loz, cast(datesfiresignal_loz as CHAR(255))) as datesfiresignal_loz, commentsfiresignal_loz, CONCAT('d', statusworkplace_pos, cast(datesworkplace_pos as CHAR(255))) as datesworkplace_pos, commentsworkplace_pos, CONCAT('d', statusremont_pos, cast(datesremont_pos as CHAR(255))) as datesremont_pos, commentsremont_pos, CONCAT('d', statuscasacabins_pos, cast(datescasacabins_pos as CHAR(255))) as datescasacabins_pos, commentscasacabins_pos, CONCAT('d', statusbanner_shyan, cast(datesbanner_shyan as CHAR(255))) as datesbanner_shyan, commentsbanner_shyan, CONCAT('d', statusforextablo_shyan, cast(datesforextablo_shyan as CHAR(255))) as datesforextablo_shyan, commentsforextablo_shyan, CONCAT('d', statusposter_shyan, cast(datesposter_shyan as CHAR(255))) as datesposter_shyan, commentsposter_shyan, CONCAT('d', statusconnection_sem, cast(datesconnection_sem as CHAR(255))) as datesconnection_sem, commentsconnection_sem, CONCAT('d', statussks_sem, cast(datessks_sem as CHAR(255))) as datessks_sem, commentssks_sem, CONCAT('d', statuscomputers_sem, cast(datescomputers_sem as CHAR(255))) as datescomputers_sem, commentscomputers_sem, CONCAT('d', statusstamps_tsup, cast(datesstamps_tsup as CHAR(255))) as datesstamps_tsup, commentsstamps_tsup, CONCAT('d', statuscleaning_tsup, cast(datescleaning_tsup as CHAR(255))) as datescleaning_tsup, commentscleaning_tsup, CONCAT('d', statuscashregisters_gritch, cast(datescashregisters_gritch as CHAR(255))) as datescashregisters_gritch, commentscashregisters_gritch, CONCAT('d', statusmebli_gritch, cast(datesmebli_gritch as CHAR(255))) as datesmebli_gritch, commentsmebli_gritch from divisions\n" +
                "union all\n" +
                "select id,num,address,comments, cast(datesorenda as CHAR(255)) as datesorenda, 'Акцептування виконання заходу' as datescreated, '' as datesplaned, '' as daystoopen, statussafes_rev, commentssafes_rev, statusvideo_loz, commentsvideo_loz, statussignal_loz, commentssignal_loz, statusfiresignal_loz, commentsfiresignal_loz, statusworkplace_pos, commentsworkplace_pos, statusremont_pos, commentsremont_pos, statuscasacabins_pos, commentscasacabins_pos, statusbanner_shyan, commentsbanner_shyan, statusforextablo_shyan, commentsforextablo_shyan, statusposter_shyan, commentsposter_shyan, statusconnection_sem, commentsconnection_sem, statussks_sem, commentssks_sem, statuscomputers_sem, commentscomputers_sem, statusstamps_tsup, commentsstamps_tsup, statuscleaning_tsup, commentscleaning_tsup, statuscashregisters_gritch, commentscashregisters_gritch, statusmebli_gritch, commentsmebli_gritch from divisions\n", resultSetMapping = "Divisions"),
        @NamedNativeQuery(name = "DivisionByIdForUpdate", query = "Select * from divisions where id=?", resultSetMapping = "DivisionsAll"),
        @NamedNativeQuery(name = "DivisionDTORev", query = "Select id, num, address, statussafes_rev, commentssafes_rev from divisions where id=?", resultSetMapping = "DivisionDTORev"),
        @NamedNativeQuery(name = "DivisionDTOLoz", query = "Select id, num, address, statusvideo_loz, statussignal_loz, statusfiresignal_loz, commentsvideo_loz, commentssignal_loz,commentsfiresignal_loz from divisions where id=?", resultSetMapping = "DivisionDTOLoz"),
        @NamedNativeQuery(name = "DivisionDTOPos", query = "Select id, num, address, statusworkplace_pos, statusremont_pos, statuscasacabins_pos, commentsworkplace_pos, commentsremont_pos, commentscasacabins_pos from divisions where id=?", resultSetMapping = "DivisionDTOPos"),
        @NamedNativeQuery(name = "DivisionDTOShyan", query = "Select id, num, address, statusbanner_shyan, statusforextablo_shyan, statusposter_shyan, commentsbanner_shyan, commentsforextablo_shyan, commentsposter_shyan from divisions where id=?", resultSetMapping = "DivisionDTOShyan"),
        @NamedNativeQuery(name = "DivisionDTOSem", query = "Select id, num, address, statusconnection_sem, statussks_sem, statuscomputers_sem, commentsconnection_sem, commentssks_sem, commentscomputers_sem from divisions where id=?", resultSetMapping = "DivisionDTOSem"),
        @NamedNativeQuery(name = "DivisionDTOTsup", query = "Select id, num, address, statusstamps_tsup, statuscleaning_tsup, commentsstamps_tsup, commentscleaning_tsup from divisions where id=?", resultSetMapping = "DivisionDTOTsup"),
        @NamedNativeQuery(name = "DivisionDTOGritch", query = "Select id, num, address, statuscashregisters_gritch, statusmebli_gritch, commentscashregisters_gritch, commentsmebli_gritch from divisions where id=?", resultSetMapping = "DivisionDTOGritch")
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
                @ColumnResult(name = "datesorenda"),
                @ColumnResult(name = "datessafes_rev"),
                @ColumnResult(name = "commentssafes_rev"),
                @ColumnResult(name = "datesvideo_loz"),
                @ColumnResult(name = "commentsvideo_loz"),
                @ColumnResult(name = "datessignal_loz"),
                @ColumnResult(name = "commentssignal_loz"),
                @ColumnResult(name = "datesfiresignal_loz"),
                @ColumnResult(name = "commentsfiresignal_loz"),
                @ColumnResult(name = "datesworkplace_pos"),
                @ColumnResult(name = "commentsworkplace_pos"),
                @ColumnResult(name = "datesremont_pos"),
                @ColumnResult(name = "commentsremont_pos"),
                @ColumnResult(name = "datescasacabins_pos"),
                @ColumnResult(name = "commentscasacabins_pos"),
                @ColumnResult(name = "datesbanner_shyan"),
                @ColumnResult(name = "commentsbanner_shyan"),
                @ColumnResult(name = "datesforextablo_shyan"),
                @ColumnResult(name = "commentsforextablo_shyan"),
                @ColumnResult(name = "datesposter_shyan"),
                @ColumnResult(name = "commentsposter_shyan"),
                @ColumnResult(name = "datesconnection_sem"),
                @ColumnResult(name = "commentsconnection_sem"),
                @ColumnResult(name = "datessks_sem"),
                @ColumnResult(name = "commentssks_sem"),
                @ColumnResult(name = "datescomputers_sem"),
                @ColumnResult(name = "commentscomputers_sem"),
                @ColumnResult(name = "datesstamps_tsup"),
                @ColumnResult(name = "commentsstamps_tsup"),
                @ColumnResult(name = "datescleaning_tsup"),
                @ColumnResult(name = "commentscleaning_tsup"),
                @ColumnResult(name = "datescashregisters_gritch"),
                @ColumnResult(name = "commentscashregisters_gritch"),
                @ColumnResult(name = "datesmebli_gritch"),
                @ColumnResult(name = "commentsmebli_gritch")

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
                @ColumnResult(name = "datesorenda"),
                @ColumnResult(name = "datessafes_rev"),
                @ColumnResult(name = "statussafes_rev", type = boolean.class),
                @ColumnResult(name = "commentssafes_rev"),
                @ColumnResult(name = "datesvideo_loz"),
                @ColumnResult(name = "statusvideo_loz", type = boolean.class),
                @ColumnResult(name = "commentsvideo_loz"),
                @ColumnResult(name = "datessignal_loz"),
                @ColumnResult(name = "statussignal_loz", type = boolean.class),
                @ColumnResult(name = "commentssignal_loz"),
                @ColumnResult(name = "datesfiresignal_loz"),
                @ColumnResult(name = "statusfiresignal_loz", type = boolean.class),
                @ColumnResult(name = "commentsfiresignal_loz"),
                @ColumnResult(name = "datesworkplace_pos"),
                @ColumnResult(name = "statusworkplace_pos", type = boolean.class),
                @ColumnResult(name = "commentsworkplace_pos"),
                @ColumnResult(name = "datesremont_pos"),
                @ColumnResult(name = "statusremont_pos", type = boolean.class),
                @ColumnResult(name = "commentsremont_pos"),
                @ColumnResult(name = "datescasacabins_pos"),
                @ColumnResult(name = "statuscasacabins_pos", type = boolean.class),
                @ColumnResult(name = "commentscasacabins_pos"),
                @ColumnResult(name = "datesbanner_shyan"),
                @ColumnResult(name = "statusbanner_shyan", type = boolean.class),
                @ColumnResult(name = "commentsbanner_shyan"),
                @ColumnResult(name = "datesforextablo_shyan"),
                @ColumnResult(name = "statusforextablo_shyan", type = boolean.class),
                @ColumnResult(name = "commentsforextablo_shyan"),
                @ColumnResult(name = "datesposter_shyan"),
                @ColumnResult(name = "statusposter_shyan", type = boolean.class),
                @ColumnResult(name = "commentsposter_shyan"),
                @ColumnResult(name = "datesconnection_sem"),
                @ColumnResult(name = "statusconnection_sem", type = boolean.class),
                @ColumnResult(name = "commentsconnection_sem"),
                @ColumnResult(name = "datessks_sem"),
                @ColumnResult(name = "statussks_sem", type = boolean.class),
                @ColumnResult(name = "commentssks_sem"),
                @ColumnResult(name = "datescomputers_sem"),
                @ColumnResult(name = "statuscomputers_sem", type = boolean.class),
                @ColumnResult(name = "commentscomputers_sem"),
                @ColumnResult(name = "datesstamps_tsup"),
                @ColumnResult(name = "statusstamps_tsup", type = boolean.class),
                @ColumnResult(name = "commentsstamps_tsup"),
                @ColumnResult(name = "datescleaning_tsup"),
                @ColumnResult(name = "statuscleaning_tsup", type = boolean.class),
                @ColumnResult(name = "commentscleaning_tsup"),
                @ColumnResult(name = "datescashregisters_gritch"),
                @ColumnResult(name = "statuscashregisters_gritch", type = boolean.class),
                @ColumnResult(name = "commentscashregisters_gritch"),
                @ColumnResult(name = "datesmebli_gritch"),
                @ColumnResult(name = "statusmebli_gritch", type = boolean.class),
                @ColumnResult(name = "commentsmebli_gritch")

        }
)
)
@SqlResultSetMapping(name = "DivisionDTORev", classes = @ConstructorResult(targetClass = DivisionDTORev.class,
        columns = {
                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                //@ColumnResult(name = "statusorenda_rev", type = boolean.class),
                @ColumnResult(name = "statussafes_rev", type = boolean.class),
                @ColumnResult(name = "commentssafes_rev")
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
                @ColumnResult(name = "statusfiresignal_loz", type = boolean.class),
                @ColumnResult(name = "commentsvideo_loz"),
                @ColumnResult(name = "commentssignal_loz"),
                @ColumnResult(name = "commentsfiresignal_loz")
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
                @ColumnResult(name = "statuscasacabins_pos", type = boolean.class),
                @ColumnResult(name = "commentsworkplace_pos"),
                @ColumnResult(name = "commentsremont_pos"),
                @ColumnResult(name = "commentscasacabins_pos")
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
                @ColumnResult(name = "statusposter_shyan", type = boolean.class),
                @ColumnResult(name = "commentsbanner_shyan"),
                @ColumnResult(name = "commentsforextablo_shyan"),
                @ColumnResult(name = "commentsposter_shyan")
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
                @ColumnResult(name = "statuscomputers_sem", type = boolean.class),
                @ColumnResult(name = "commentsconnection_sem"),
                @ColumnResult(name = "commentssks_sem"),
                @ColumnResult(name = "commentscomputers_sem")
        }
)
)
@SqlResultSetMapping(name = "DivisionDTOTsup", classes = @ConstructorResult(targetClass = DivisionDTOTsup.class,
        columns = {
                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "statusstamps_tsup", type = boolean.class),
                @ColumnResult(name = "statuscleaning_tsup", type = boolean.class),
                @ColumnResult(name = "commentsstamps_tsup"),
                @ColumnResult(name = "commentscleaning_tsup")
        }
)
)
@SqlResultSetMapping(name = "DivisionDTOGritch", classes = @ConstructorResult(targetClass = DivisionDTOGritch.class,
        columns = {
                @ColumnResult(name = "id", type = int.class),
                @ColumnResult(name = "num", type = int.class),
                @ColumnResult(name = "address"),
                @ColumnResult(name = "statuscashregisters_gritch", type = boolean.class),
                @ColumnResult(name = "statusmebli_gritch", type = boolean.class),
                @ColumnResult(name = "commentscashregisters_gritch"),
                @ColumnResult(name = "commentsmebli_gritch")
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

    @Column(name = "datesorenda")
    private String datesorenda;


    // РЕВУЦЬКИЙ
    //@Column(name = "datesorendaRev", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
/*    @Column(name = "statusorendaRev", columnDefinition = "tinyint(1) default false")
    private boolean statusorendaRev = false;*/

    @Column(name = "datessafesRev", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datessafesRev;

    @Column(name = "statussafesRev", columnDefinition = "tinyint(1) default false")
    private boolean statussafesRev = false;

    @Column
    private String commentssafesRev;

    // ЛОЗИНСЬКИЙ
    @Column(name = "datesvideoLoz", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesvideoLoz;

    @Column(name = "statusvideoLoz", columnDefinition = "tinyint(1) default false")
    private boolean statusvideoLoz = false;

    @Column
    private String commentsvideoLoz;

    @Column(name = "datessignalLoz", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datessignalLoz;

    @Column(name = "statussignalLoz", columnDefinition = "tinyint(1) default false")
    private boolean statussignalLoz = false;

    @Column
    private String commentssignalLoz;

    @Column(name = "datesfiresignalLoz", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesfiresignalLoz;

    @Column(name = "statusfiresignalLoz", columnDefinition = "tinyint(1) default false")
    private boolean statusfiresignalLoz = false;

    @Column
    private String commentsfiresignalLoz;

    // ПОСТОЛ
    @Column(name = "datesworkplacePos", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesworkplacePos;

    @Column(name = "statusworkplacePos", columnDefinition = "tinyint(1) default false")
    private boolean statusworkplacePos = false;

    @Column
    private String commentsworkplacePos;

    @Column(name = "datesremontPos", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesremontPos;

    @Column(name = "statusremontPos", columnDefinition = "tinyint(1) default false")
    private boolean statusremontPos = false;

    @Column
    private String commentsremontPos;

    @Column(name = "datescasacabinsPos", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datescasacabinsPos;

    @Column(name = "statuscasacabinsPos", columnDefinition = "tinyint(1) default false")
    private boolean statuscasacabinsPos = false;

    @Column
    private String commentscasacabinsPos;

    // ШИЯН
    @Column(name = "datesbannerShyan", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesbannerShyan;

    @Column(name = "statusbannerShyan", columnDefinition = "tinyint(1) default false")
    private boolean statusbannerShyan = false;

    @Column
    private String commentsbannerShyan;

    @Column(name = "datesforextabloShyan", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesforextabloShyan;

    @Column(name = "statusforextabloShyan", columnDefinition = "tinyint(1) default false")
    private boolean statusforextabloShyan = false;

    @Column
    private String commentsforextabloShyan;

    @Column(name = "datesposterShyan", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesposterShyan;

    @Column(name = "statusposterShyan", columnDefinition = "tinyint(1) default false")
    private boolean statusposterShyan = false;

    @Column
    private String commentsposterShyan;

    // СЕМЕНЦУЛ
    @Column(name = "datesconnectionSem", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesconnectionSem;

    @Column(name = "statusconnectionSem", columnDefinition = "tinyint(1) default false")
    private boolean statusconnectionSem = false;

    @Column
    private String commentsconnectionSem;

    @Column(name = "datessksSem", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datessksSem;

    @Column(name = "statussksSem", columnDefinition = "tinyint(1) default false")
    private boolean statussksSem = false;

    @Column
    private String commentssksSem;

    @Column(name = "datescomputersSem", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datescomputersSem;

    @Column(name = "statuscomputersSem", columnDefinition = "tinyint(1) default false")
    private boolean statuscomputersSem = false;

    @Column
    private String commentscomputersSem;

    // ЦЮПКО
    @Column(name = "datesstampsTsup", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesstampsTsup;

    @Column(name = "statusstampsTsup", columnDefinition = "tinyint(1) default false")
    private boolean statusstampsTsup = false;

    @Column
    private String commentsstampsTsup;

    @Column(name = "datescleaningTsup", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datescleaningTsup;

    @Column(name = "statuscleaningTsup", columnDefinition = "tinyint(1) default false")
    private boolean statuscleaningTsup = false;

    @Column
    private String commentscleaningTsup;

    // ГРІТЧИНА
    @Column(name = "datescashregistersGritch", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datescashregistersGritch;

    @Column(name = "statuscashregistersGritch", columnDefinition = "tinyint(1) default false")
    private boolean statuscashregistersGritch = false;

    @Column
    private String commentscashregistersGritch;

    @Column(name = "datesmebliGritch", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    ///@Temporal(TemporalType.TIMESTAMP)
    private Date datesmebliGritch;

    @Column(name = "statusmebliGritch", columnDefinition = "tinyint(1) default false")
    private boolean statusmebliGritch = false;

    @Column
    private String commentsmebliGritch;

    public Division() {
    }

    public Division(int id, int num, String address, String comments, Date datescreated, Date datesplaned, int daystoopen, String datesorenda, Date datessafesRev, boolean statussafesRev, String commentssafesRev, Date datesvideoLoz, boolean statusvideoLoz, String commentsvideoLoz, Date datessignalLoz, boolean statussignalLoz, String commentssignalLoz, Date datesfiresignalLoz, boolean statusfiresignalLoz, String commentsfiresignalLoz, Date datesworkplacePos, boolean statusworkplacePos, String commentsworkplacePos, Date datesremontPos, boolean statusremontPos, String commentsremontPos, Date datescasacabinsPos, boolean statuscasacabinsPos, String commentscasacabinsPos, Date datesbannerShyan, boolean statusbannerShyan, String commentsbannerShyan, Date datesforextabloShyan, boolean statusforextabloShyan, String commentsforextabloShyan, Date datesposterShyan, boolean statusposterShyan, String commentsposterShyan, Date datesconnectionSem, boolean statusconnectionSem, String commentsconnectionSem, Date datessksSem, boolean statussksSem, String commentssksSem, Date datescomputersSem, boolean statuscomputersSem, String commentscomputersSem, Date datesstampsTsup, boolean statusstampsTsup, String commentsstampsTsup, Date datescleaningTsup, boolean statuscleaningTsup, String commentscleaningTsup, Date datescashregistersGritch, boolean statuscashregistersGritch, String commentscashregistersGritch, Date datesmebliGritch, boolean statusmebliGritch, String commentsmebliGritch) {
        this.id = id;
        this.num = num;
        this.address = address;
        this.comments = comments;
        this.datescreated = datescreated;
        this.datesplaned = datesplaned;
        this.daystoopen = daystoopen;
        this.datesorenda = datesorenda;
        this.datessafesRev = datessafesRev;
        this.statussafesRev = statussafesRev;
        this.commentssafesRev = commentssafesRev;
        this.datesvideoLoz = datesvideoLoz;
        this.statusvideoLoz = statusvideoLoz;
        this.commentsvideoLoz = commentsvideoLoz;
        this.datessignalLoz = datessignalLoz;
        this.statussignalLoz = statussignalLoz;
        this.commentssignalLoz = commentssignalLoz;
        this.datesfiresignalLoz = datesfiresignalLoz;
        this.statusfiresignalLoz = statusfiresignalLoz;
        this.commentsfiresignalLoz = commentsfiresignalLoz;
        this.datesworkplacePos = datesworkplacePos;
        this.statusworkplacePos = statusworkplacePos;
        this.commentsworkplacePos = commentsworkplacePos;
        this.datesremontPos = datesremontPos;
        this.statusremontPos = statusremontPos;
        this.commentsremontPos = commentsremontPos;
        this.datescasacabinsPos = datescasacabinsPos;
        this.statuscasacabinsPos = statuscasacabinsPos;
        this.commentscasacabinsPos = commentscasacabinsPos;
        this.datesbannerShyan = datesbannerShyan;
        this.statusbannerShyan = statusbannerShyan;
        this.commentsbannerShyan = commentsbannerShyan;
        this.datesforextabloShyan = datesforextabloShyan;
        this.statusforextabloShyan = statusforextabloShyan;
        this.commentsforextabloShyan = commentsforextabloShyan;
        this.datesposterShyan = datesposterShyan;
        this.statusposterShyan = statusposterShyan;
        this.commentsposterShyan = commentsposterShyan;
        this.datesconnectionSem = datesconnectionSem;
        this.statusconnectionSem = statusconnectionSem;
        this.commentsconnectionSem = commentsconnectionSem;
        this.datessksSem = datessksSem;
        this.statussksSem = statussksSem;
        this.commentssksSem = commentssksSem;
        this.datescomputersSem = datescomputersSem;
        this.statuscomputersSem = statuscomputersSem;
        this.commentscomputersSem = commentscomputersSem;
        this.datesstampsTsup = datesstampsTsup;
        this.statusstampsTsup = statusstampsTsup;
        this.commentsstampsTsup = commentsstampsTsup;
        this.datescleaningTsup = datescleaningTsup;
        this.statuscleaningTsup = statuscleaningTsup;
        this.commentscleaningTsup = commentscleaningTsup;
        this.datescashregistersGritch = datescashregistersGritch;
        this.statuscashregistersGritch = statuscashregistersGritch;
        this.commentscashregistersGritch = commentscashregistersGritch;
        this.datesmebliGritch = datesmebliGritch;
        this.statusmebliGritch = statusmebliGritch;
        this.commentsmebliGritch = commentsmebliGritch;
    }

    public Division(int id, int num, String address, String comments, Date datescreated, Date datesplaned, int daystoopen, String datesorenda, Date datessafesRev, Date datesvideoLoz, Date datessignalLoz, Date datesfiresignalLoz, Date datesworkplacePos, Date datesremontPos, Date datescasacabinsPos, Date datesbannerShyan, Date datesforextabloShyan, Date datesposterShyan, Date datesconnectionSem, Date datessksSem, Date datescomputersSem, Date datesstampsTsup, Date datescleaningTsup, Date datescashregistersGritch, Date datesmebliGritch) {
        this.id = id;
        this.num = num;
        this.address = address;
        this.comments = comments;
        this.datescreated = datescreated;
        this.datesplaned = datesplaned;
        this.daystoopen = daystoopen;
        this.datesorenda = datesorenda;
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

    public Division(int id, int num, String address) {
        this.id = id;
        this.num = num;
        this.address = address;
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

    public String getDatesorenda() {
        return datesorenda;
    }

    public void setDatesorenda(String datesorenda) {
        this.datesorenda = datesorenda;
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

    public String getCommentssafesRev() {
        return commentssafesRev;
    }

    public void setCommentssafesRev(String commentssafesRev) {
        this.commentssafesRev = commentssafesRev;
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

    public String getCommentsvideoLoz() {
        return commentsvideoLoz;
    }

    public void setCommentsvideoLoz(String commentsvideoLoz) {
        this.commentsvideoLoz = commentsvideoLoz;
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

    public String getCommentssignalLoz() {
        return commentssignalLoz;
    }

    public void setCommentssignalLoz(String commentssignalLoz) {
        this.commentssignalLoz = commentssignalLoz;
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

    public String getCommentsfiresignalLoz() {
        return commentsfiresignalLoz;
    }

    public void setCommentsfiresignalLoz(String commentsfiresignalLoz) {
        this.commentsfiresignalLoz = commentsfiresignalLoz;
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

    public String getCommentsworkplacePos() {
        return commentsworkplacePos;
    }

    public void setCommentsworkplacePos(String commentsworkplacePos) {
        this.commentsworkplacePos = commentsworkplacePos;
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

    public String getCommentsremontPos() {
        return commentsremontPos;
    }

    public void setCommentsremontPos(String commentsremontPos) {
        this.commentsremontPos = commentsremontPos;
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

    public String getCommentscasacabinsPos() {
        return commentscasacabinsPos;
    }

    public void setCommentscasacabinsPos(String commentscasacabinsPos) {
        this.commentscasacabinsPos = commentscasacabinsPos;
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

    public String getCommentsbannerShyan() {
        return commentsbannerShyan;
    }

    public void setCommentsbannerShyan(String commentsbannerShyan) {
        this.commentsbannerShyan = commentsbannerShyan;
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

    public String getCommentsforextabloShyan() {
        return commentsforextabloShyan;
    }

    public void setCommentsforextabloShyan(String commentsforextabloShyan) {
        this.commentsforextabloShyan = commentsforextabloShyan;
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

    public String getCommentsposterShyan() {
        return commentsposterShyan;
    }

    public void setCommentsposterShyan(String commentsposterShyan) {
        this.commentsposterShyan = commentsposterShyan;
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

    public String getCommentsconnectionSem() {
        return commentsconnectionSem;
    }

    public void setCommentsconnectionSem(String commentsconnectionSem) {
        this.commentsconnectionSem = commentsconnectionSem;
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

    public String getCommentssksSem() {
        return commentssksSem;
    }

    public void setCommentssksSem(String commentssksSem) {
        this.commentssksSem = commentssksSem;
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

    public String getCommentscomputersSem() {
        return commentscomputersSem;
    }

    public void setCommentscomputersSem(String commentscomputersSem) {
        this.commentscomputersSem = commentscomputersSem;
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

    public String getCommentsstampsTsup() {
        return commentsstampsTsup;
    }

    public void setCommentsstampsTsup(String commentsstampsTsup) {
        this.commentsstampsTsup = commentsstampsTsup;
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

    public String getCommentscleaningTsup() {
        return commentscleaningTsup;
    }

    public void setCommentscleaningTsup(String commentscleaningTsup) {
        this.commentscleaningTsup = commentscleaningTsup;
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

    public String getCommentscashregistersGritch() {
        return commentscashregistersGritch;
    }

    public void setCommentscashregistersGritch(String commentscashregistersGritch) {
        this.commentscashregistersGritch = commentscashregistersGritch;
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

    public String getCommentsmebliGritch() {
        return commentsmebliGritch;
    }

    public void setCommentsmebliGritch(String commentsmebliGritch) {
        this.commentsmebliGritch = commentsmebliGritch;
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
                ", datesorenda='" + datesorenda + '\'' +
                ", datessafesRev=" + datessafesRev +
                ", statussafesRev=" + statussafesRev +
                ", commentssafesRev='" + commentssafesRev + '\'' +
                ", datesvideoLoz=" + datesvideoLoz +
                ", statusvideoLoz=" + statusvideoLoz +
                ", commentsvideoLoz='" + commentsvideoLoz + '\'' +
                ", datessignalLoz=" + datessignalLoz +
                ", statussignalLoz=" + statussignalLoz +
                ", commentssignalLoz='" + commentssignalLoz + '\'' +
                ", datesfiresignalLoz=" + datesfiresignalLoz +
                ", statusfiresignalLoz=" + statusfiresignalLoz +
                ", commentsfiresignalLoz='" + commentsfiresignalLoz + '\'' +
                ", datesworkplacePos=" + datesworkplacePos +
                ", statusworkplacePos=" + statusworkplacePos +
                ", commentsworkplacePos='" + commentsworkplacePos + '\'' +
                ", datesremontPos=" + datesremontPos +
                ", statusremontPos=" + statusremontPos +
                ", commentsremontPos='" + commentsremontPos + '\'' +
                ", datescasacabinsPos=" + datescasacabinsPos +
                ", statuscasacabinsPos=" + statuscasacabinsPos +
                ", commentscasacabinsPos='" + commentscasacabinsPos + '\'' +
                ", datesbannerShyan=" + datesbannerShyan +
                ", statusbannerShyan=" + statusbannerShyan +
                ", commentsbannerShyan='" + commentsbannerShyan + '\'' +
                ", datesforextabloShyan=" + datesforextabloShyan +
                ", statusforextabloShyan=" + statusforextabloShyan +
                ", commentsforextabloShyan='" + commentsforextabloShyan + '\'' +
                ", datesposterShyan=" + datesposterShyan +
                ", statusposterShyan=" + statusposterShyan +
                ", commentsposterShyan='" + commentsposterShyan + '\'' +
                ", datesconnectionSem=" + datesconnectionSem +
                ", statusconnectionSem=" + statusconnectionSem +
                ", commentsconnectionSem='" + commentsconnectionSem + '\'' +
                ", datessksSem=" + datessksSem +
                ", statussksSem=" + statussksSem +
                ", commentssksSem='" + commentssksSem + '\'' +
                ", datescomputersSem=" + datescomputersSem +
                ", statuscomputersSem=" + statuscomputersSem +
                ", commentscomputersSem='" + commentscomputersSem + '\'' +
                ", datesstampsTsup=" + datesstampsTsup +
                ", statusstampsTsup=" + statusstampsTsup +
                ", commentsstampsTsup='" + commentsstampsTsup + '\'' +
                ", datescleaningTsup=" + datescleaningTsup +
                ", statuscleaningTsup=" + statuscleaningTsup +
                ", commentscleaningTsup='" + commentscleaningTsup + '\'' +
                ", datescashregistersGritch=" + datescashregistersGritch +
                ", statuscashregistersGritch=" + statuscashregistersGritch +
                ", commentscashregistersGritch='" + commentscashregistersGritch + '\'' +
                ", datesmebliGritch=" + datesmebliGritch +
                ", statusmebliGritch=" + statusmebliGritch +
                ", commentsmebliGritch='" + commentsmebliGritch + '\'' +
                '}';
    }
}
