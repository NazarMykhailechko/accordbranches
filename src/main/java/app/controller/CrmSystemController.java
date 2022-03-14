package app.controller;


import app.dao.DivisionDao;
import app.dto.*;
import app.model.Division;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CrmSystemController {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    DivisionDao divisionDao;


    @RequestMapping("/mainform")
    public String divisions(Model model, Principal principal, Authentication authentication, HttpServletRequest request) throws IOException {
        return "mainform";
    }

    @RequestMapping(value ="/addnewdivision")
    public String showNewClientPage(Model model) {
        Division division = new Division();
        model.addAttribute("division", division);
        return "addnewdivision";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("division") Division division, @RequestParam("datescreated") String datescreated, Principal principal) throws ParseException {

        //System.out.println(division);

        //division.setDatescreated(new SimpleDateFormat("yyyy-MM-dd").parse(datescreated));
        divisionDao.save(division);
        return "redirect:/mainform";
    }

    @RequestMapping("/mainform/updatedivision/{id}")
    public ModelAndView updateDivision(@PathVariable(name = "id") String id, Principal principal, Authentication authentication) {

        ModelAndView mav = new ModelAndView("updatedivision");
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CORP"))){
            Division division = em.createNamedQuery("DivisionByIdForUpdate", Division.class).setParameter(1,id).getSingleResult();
            mav.addObject("division", division);
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_OREN"))){
            DivisionDTORev divisionRev = em.createNamedQuery("DivisionDTORev", DivisionDTORev.class).setParameter(1,id).getSingleResult();
            mav.addObject("divisionRev", divisionRev);
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_SECU"))){
            DivisionDTOLoz divisionLoz = em.createNamedQuery("DivisionDTOLoz", DivisionDTOLoz.class).setParameter(1,id).getSingleResult();
            mav.addObject("divisionLoz", divisionLoz);
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_REMO"))){
            DivisionDTOPos divisionPos = em.createNamedQuery("DivisionDTOPos", DivisionDTOPos.class).setParameter(1,id).getSingleResult();
            mav.addObject("divisionPos", divisionPos);
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_BANN"))){
            DivisionDTOShyan divisionShyan = em.createNamedQuery("DivisionDTOShyan", DivisionDTOShyan.class).setParameter(1,id).getSingleResult();
            mav.addObject("divisionShyan", divisionShyan);
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_COMP"))){
            DivisionDTOSem divisionSem= em.createNamedQuery("DivisionDTOSem", DivisionDTOSem.class).setParameter(1,id).getSingleResult();
            mav.addObject("divisionSem", divisionSem);
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_CLEA"))){
            DivisionDTOTsup divisionTsup= em.createNamedQuery("DivisionDTOTsup", DivisionDTOTsup.class).setParameter(1,id).getSingleResult();
            mav.addObject("divisionTsup", divisionTsup);
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_MEBL"))){
            DivisionDTOGritch divisionGritch= em.createNamedQuery("DivisionDTOGritch", DivisionDTOGritch.class).setParameter(1,id).getSingleResult();
            mav.addObject("divisionGritch", divisionGritch);
        }
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveUpdateClient(@RequestParam("id") int id,
                                   @RequestParam("num") int num,
                                   @RequestParam("address") String address,
                                   @RequestParam("comments") String comments,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datescreated") Date datescreated,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesplaned") Date datesplaned,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesorenda") String datesorenda,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datessafesRev") Date datessafesRev,
                                   @RequestParam(defaultValue="false") boolean statussafesRev,
                                   @RequestParam("commentssafesRev") String commentssafesRev,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesvideoLoz") Date datesvideoLoz,
                                   @RequestParam(defaultValue="false") boolean statusvideoLoz,
                                   @RequestParam("commentsvideoLoz") String commentsvideoLoz,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datessignalLoz") Date datessignalLoz,
                                   @RequestParam(defaultValue="false") boolean statussignalLoz,
                                   @RequestParam("commentssignalLoz") String commentssignalLoz,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesfiresignalLoz") Date datesfiresignalLoz,
                                   @RequestParam(defaultValue="false") boolean statusfiresignalLoz,
                                   @RequestParam("commentsfiresignalLoz") String commentsfiresignalLoz,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesworkplacePos") Date datesworkplacePos,
                                   @RequestParam(defaultValue="false") boolean statusworkplacePos,
                                   @RequestParam("commentsworkplacePos") String commentsworkplacePos,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesremontPos") Date datesremontPos,
                                   @RequestParam(defaultValue="false") boolean statusremontPos,
                                   @RequestParam("commentsremontPos") String commentsremontPos,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datescasacabinsPos") Date datescasacabinsPos,
                                   @RequestParam(defaultValue="false") boolean statuscasacabinsPos,
                                   @RequestParam("commentscasacabinsPos") String commentscasacabinsPos,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesbannerShyan") Date datesbannerShyan,
                                   @RequestParam(defaultValue="false") boolean statusbannerShyan,
                                   @RequestParam("commentsbannerShyan") String commentsbannerShyan,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesforextabloShyan") Date datesforextabloShyan,
                                   @RequestParam(defaultValue="false") boolean statusforextabloShyan,
                                   @RequestParam("commentsforextabloShyan") String commentsforextabloShyan,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesposterShyan") Date datesposterShyan,
                                   @RequestParam(defaultValue="false") boolean statusposterShyan,
                                   @RequestParam("commentsposterShyan") String commentsposterShyan,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesconnectionSem") Date datesconnectionSem,
                                   @RequestParam(defaultValue="false") boolean statusconnectionSem,
                                   @RequestParam("commentsconnectionSem") String commentsconnectionSem,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datessksSem") Date datessksSem,
                                   @RequestParam(defaultValue="false") boolean statussksSem,
                                   @RequestParam("commentssksSem") String commentssksSem,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datescomputersSem") Date datescomputersSem,
                                   @RequestParam(defaultValue="false") boolean statuscomputersSem,
                                   @RequestParam("commentscomputersSem") String commentscomputersSem,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesstampsTsup") Date datesstampsTsup,
                                   @RequestParam(defaultValue="false") boolean statusstampsTsup,
                                   @RequestParam("commentsstampsTsup") String commentsstampsTsup,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datescleaningTsup") Date datescleaningTsup,
                                   @RequestParam(defaultValue="false") boolean statuscleaningTsup,
                                   @RequestParam("commentscleaningTsup") String commentscleaningTsup,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datescashregistersGritch") Date datescashregistersGritch,
                                   @RequestParam(defaultValue="false") boolean statuscashregistersGritch,
                                   @RequestParam("commentscashregistersGritch") String commentscashregistersGritch,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam("datesmebliGritch") Date datesmebliGritch,
                                   @RequestParam(defaultValue="false") boolean statusmebliGritch,
                                   @RequestParam("commentsmebliGritch") String commentsmebliGritch

    ) throws ParseException {

        Division division = divisionDao.findById(id).get();

        division.setNum(num);
        division.setAddress(address);
        division.setComments(comments);
        division.setDatescreated(datescreated);
        division.setDatesplaned(datesplaned);
        division.setDatesorenda(datesorenda);
        division.setDatessafesRev(datessafesRev);
        division.setStatussafesRev(statussafesRev);
        division.setCommentssafesRev(commentssafesRev);
        division.setDatesvideoLoz(datesvideoLoz);
        division.setStatusvideoLoz(statusvideoLoz);
        division.setCommentsvideoLoz(commentsvideoLoz);
        division.setDatessignalLoz(datessignalLoz);
        division.setStatussignalLoz(statussignalLoz);
        division.setCommentssignalLoz(commentssignalLoz);
        division.setDatesfiresignalLoz(datesfiresignalLoz);
        division.setStatusfiresignalLoz(statusfiresignalLoz);
        division.setCommentsfiresignalLoz(commentsfiresignalLoz);
        division.setDatesworkplacePos(datesworkplacePos);
        division.setStatusworkplacePos(statusworkplacePos);
        division.setCommentsworkplacePos(commentsworkplacePos);
        division.setDatesremontPos(datesremontPos);
        division.setStatusremontPos(statusremontPos);
        division.setCommentsremontPos(commentsremontPos);
        division.setDatescasacabinsPos(datescasacabinsPos);
        division.setStatuscasacabinsPos(statuscasacabinsPos);
        division.setCommentscasacabinsPos(commentscasacabinsPos);
        division.setDatesbannerShyan(datesbannerShyan);
        division.setStatusbannerShyan(statusbannerShyan);
        division.setCommentsbannerShyan(commentsbannerShyan);
        division.setDatesforextabloShyan(datesforextabloShyan);
        division.setStatusforextabloShyan(statusforextabloShyan);
        division.setCommentsforextabloShyan(commentsforextabloShyan);
        division.setDatesposterShyan(datesposterShyan);
        division.setStatusposterShyan(statusposterShyan);
        division.setCommentsposterShyan(commentsposterShyan);
        division.setDatesconnectionSem(datesconnectionSem);
        division.setStatusconnectionSem(statusconnectionSem);
        division.setCommentsconnectionSem(commentsconnectionSem);
        division.setDatessksSem(datessksSem);
        division.setStatussksSem(statussksSem);
        division.setCommentssksSem(commentssksSem);
        division.setDatescomputersSem(datescomputersSem);
        division.setStatuscomputersSem(statuscomputersSem);
        division.setCommentscomputersSem(commentscomputersSem);
        division.setDatesstampsTsup(datesstampsTsup);
        division.setStatusstampsTsup(statusstampsTsup);
        division.setCommentsstampsTsup(commentsstampsTsup);
        division.setDatescleaningTsup(datescleaningTsup);
        division.setStatuscleaningTsup(statuscleaningTsup);
        division.setCommentscleaningTsup(commentscleaningTsup);
        division.setDatescashregistersGritch(datescashregistersGritch);
        division.setStatuscashregistersGritch(statuscashregistersGritch);
        division.setCommentscashregistersGritch(commentscashregistersGritch);
        division.setDatesmebliGritch(datesmebliGritch);
        division.setStatusmebliGritch(statusmebliGritch);
        division.setCommentsmebliGritch(commentsmebliGritch);

        divisionDao.save(division);
        return "redirect:/mainform";
    }

    @RequestMapping(value = "/updaterev", method = RequestMethod.POST)
    public String saveUpdateDivisionRev(@RequestParam("idrev") int idrev,
                                   @RequestParam("numrev") int numrev,
                                   @RequestParam("addressrev") String addressrev,
                                   @RequestParam(defaultValue="false") boolean statussafesrev,
                                   @RequestParam("commentssafesrev") String commentssafesrev) throws ParseException {

        Division division = divisionDao.findById(idrev).get();
        division.setNum(numrev);
        division.setAddress(addressrev);
        division.setStatussafesRev(statussafesrev);
        division.setCommentssafesRev(commentssafesrev);

        divisionDao.save(division);
        return "redirect:/mainform";
    }

    @RequestMapping(value = "/updateloz", method = RequestMethod.POST)
    public String saveUpdateDivisionLoz(@RequestParam("idloz") int idloz,
                                   @RequestParam("numloz") int numloz,
                                   @RequestParam("addressloz") String addressloz,
                                   @RequestParam(defaultValue="false") boolean statusvideoloz,
                                   @RequestParam(defaultValue="false") boolean statussignalloz,
                                   @RequestParam(defaultValue="false") boolean statusfiresignalloz,
                                   @RequestParam("commentsvideoloz") String commentsvideoloz,
                                   @RequestParam("commentssignalloz") String commentssignalloz,
                                   @RequestParam("commentsfiresignalloz") String commentsfiresignalloz) throws ParseException {

        Division division = divisionDao.findById(idloz).get();
        division.setNum(numloz);
        division.setAddress(addressloz);
        division.setStatusvideoLoz(statusvideoloz);
        division.setStatussignalLoz(statussignalloz);
        division.setStatusfiresignalLoz(statusfiresignalloz);
        division.setCommentsvideoLoz(commentsvideoloz);
        division.setCommentssignalLoz(commentssignalloz);
        division.setCommentsfiresignalLoz(commentsfiresignalloz);

        divisionDao.save(division);
        return "redirect:/mainform";
    }

    @RequestMapping(value = "/updatepos", method = RequestMethod.POST)
    public String saveUpdateDivisionPos(@RequestParam("idpos") int idpos,
                                   @RequestParam("numpos") int numpos,
                                   @RequestParam("addresspos") String addresspos,
                                   @RequestParam(defaultValue="false") boolean statusworkplacepos,
                                   @RequestParam(defaultValue="false") boolean statusremontpos,
                                   @RequestParam(defaultValue="false") boolean statuscasacabinspos,
                                   @RequestParam("commentsworkplacepos") String commentsworkplacepos,
                                   @RequestParam("commentsremontpos") String commentsremontpos,
                                   @RequestParam("commentscasacabinspos") String commentscasacabinspos) throws ParseException {

        Division division = divisionDao.findById(idpos).get();
        division.setNum(numpos);
        division.setAddress(addresspos);
        division.setStatusworkplacePos(statusworkplacepos);
        division.setStatusremontPos(statusremontpos);
        division.setStatuscasacabinsPos(statuscasacabinspos);
        division.setCommentsworkplacePos(commentsworkplacepos);
        division.setCommentsremontPos(commentsremontpos);
        division.setCommentscasacabinsPos(commentscasacabinspos);

        divisionDao.save(division);
        return "redirect:/mainform";
    }

    @RequestMapping(value = "/updateshyan", method = RequestMethod.POST)
    public String saveUpdateDivisionShyan(@RequestParam("idshyan") int idshyan,
                                          @RequestParam("numshyan") int numshyan,
                                          @RequestParam("addressshyan") String addressshyan,
                                          @RequestParam(defaultValue="false") boolean statusbannershyan,
                                          @RequestParam(defaultValue="false") boolean statusforextabloshyan,
                                          @RequestParam(defaultValue="false") boolean statuspostershyan,
                                          @RequestParam("commentsbannershyan") String commentsbannershyan,
                                          @RequestParam("commentsforextabloshyan") String commentsforextabloshyan,
                                          @RequestParam("commentspostershyan") String commentspostershyan) throws ParseException {

        Division division = divisionDao.findById(idshyan).get();
        division.setNum(numshyan);
        division.setAddress(addressshyan);
        division.setStatusbannerShyan(statusbannershyan);
        division.setStatusforextabloShyan(statusforextabloshyan);
        division.setStatusposterShyan(statuspostershyan);
        division.setCommentsbannerShyan(commentsbannershyan);
        division.setCommentsforextabloShyan(commentsforextabloshyan);
        division.setCommentsposterShyan(commentspostershyan);

        divisionDao.save(division);
        return "redirect:/mainform";
    }

    @RequestMapping(value = "/updatesem", method = RequestMethod.POST)
    public String saveUpdateDivisionSem(@RequestParam("idsem") int idsem,
                                          @RequestParam("numsem") int numsem,
                                          @RequestParam("addresssem") String addresssem,
                                          @RequestParam(defaultValue="false") boolean statusconnectionsem,
                                          @RequestParam(defaultValue="false") boolean statusskssem,
                                          @RequestParam(defaultValue="false") boolean statuscomputerssem,
                                          @RequestParam("commentsconnectionsem") String commentsconnectionsem,
                                          @RequestParam("commentsskssem") String commentsskssem,
                                          @RequestParam("commentscomputerssem") String commentscomputerssem) throws ParseException {

        Division division = divisionDao.findById(idsem).get();
        division.setNum(numsem);
        division.setAddress(addresssem);
        division.setStatusconnectionSem(statusconnectionsem);
        division.setStatussksSem(statusskssem);
        division.setStatuscomputersSem(statuscomputerssem);
        division.setCommentsconnectionSem(commentsconnectionsem);
        division.setCommentssksSem(commentsskssem);
        division.setCommentscomputersSem(commentscomputerssem);

        divisionDao.save(division);
        return "redirect:/mainform";
    }

    @RequestMapping(value = "/updatetsup", method = RequestMethod.POST)
    public String saveUpdateDivisionTsup(@RequestParam("idtsup") int idtsup,
                                          @RequestParam("numtsup") int numtsup,
                                          @RequestParam("addresstsup") String addresstsup,
                                          @RequestParam(defaultValue="false") boolean statusstampstsup,
                                          @RequestParam(defaultValue="false") boolean statuscleaningtsup,
                                          @RequestParam("commentsstampstsup") String commentsstampstsup,
                                          @RequestParam("commentscleaningtsup") String commentscleaningtsup) throws ParseException {

        Division division = divisionDao.findById(idtsup).get();
        division.setNum(numtsup);
        division.setAddress(addresstsup);
        division.setStatusstampsTsup(statusstampstsup);
        division.setStatuscleaningTsup(statuscleaningtsup);
        division.setCommentsstampsTsup(commentsstampstsup);
        division.setCommentscleaningTsup(commentscleaningtsup);

        divisionDao.save(division);
        return "redirect:/mainform";
    }

    @RequestMapping(value = "/updategritch", method = RequestMethod.POST)
    public String saveUpdateDivisionGritch(@RequestParam("idgritch") int idgritch,
                                         @RequestParam("numgritch") int numgritch,
                                         @RequestParam("addressgritch") String addressgritch,
                                         @RequestParam(defaultValue="false") boolean statuscashregistersgritch,
                                         @RequestParam(defaultValue="false") boolean statusmebligritch,
                                         @RequestParam("commentscashregistersgritch") String commentscashregistersgritch,
                                         @RequestParam("commentsmebligritch") String commentsmebligritch) throws ParseException {

        Division division = divisionDao.findById(idgritch).get();
        division.setNum(numgritch);
        division.setAddress(addressgritch);
        division.setStatuscashregistersGritch(statuscashregistersgritch);
        division.setStatusmebliGritch(statusmebligritch);
        division.setCommentscashregistersGritch(commentscashregistersgritch);
        division.setCommentsmebliGritch(commentsmebligritch);

        divisionDao.save(division);
        return "redirect:/mainform";
    }


    @RequestMapping(value = "findalldivisions", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<DivisionDto>> findAllDivisions(Principal principal, Authentication authentication) {

        List<DivisionDto> res = em.createNamedQuery("Divisions", DivisionDto.class).getResultList();

        try {
            return new ResponseEntity<Iterable<DivisionDto>>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Iterable<DivisionDto>>(HttpStatus.BAD_REQUEST);
        }
    }
}
