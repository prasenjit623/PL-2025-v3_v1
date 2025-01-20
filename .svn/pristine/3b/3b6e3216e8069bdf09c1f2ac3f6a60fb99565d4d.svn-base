
import java.io.IOException;
import java.io.ByteArrayOutputStream;

import java.text.ParseException;

import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.naming.Context;
import javax.naming.InitialContext;

import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.apps.xdo.template.FOProcessor;
import oracle.apps.xdo.template.RTFProcessor;

import javax.sql.DataSource;

import java.math.BigDecimal;

import java.math.BigInteger;

import java.math.RoundingMode;

import java.sql.SQLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.domain.Number;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

import view.backing.MailServices;
import view.backing.MailTemplates;

public class addEditOffers {
    private RichPopup p1;
    private RichTable t4;
    private RichTable t1;
    private RichInputText offerTotal;
    private RichInputText lineAmnt;
    private RichInputText reason;
    private RichPopup popup3;
    private RichTable t6;
    private RichPopup p3;
    private RichInputComboboxListOfValues leaseNumber;
    private RichSelectOneChoice socmap;
    private RichSelectOneChoice bleaseNo;
    int countt = 0;
    private RichInputListOfValues leaseNumber_TransId;

    Object flagSession;
    private RichSelectOneChoice extensionDays;
    private RichInputDate id6;
    String baseRate;
    private RichInputText extnDays;
    private RichInputDate id4;
    private RichInputText it38;
    private RichInputText it57disc;
    private RichInputText it47TaxAmt;
    private RichPopup popup22;
    private RichInputText reasonAprAndComp;
    private RichInputText it62ExpectedDisc;
    private RichInputText offerTotalWithoutTax;
    private RichInputText netRentWithoutTaxDtlLine;
    private RichSelectOneChoice soc18;

    public addEditOffers() {
    }
    ViewObject offerhdr =
        ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
    ViewObject milesOtherVo =
        ADFUtils.findIterator("OfferMilestoneDetail_VO5Iterator").getViewObject();
    ViewObject milesOtherVo6 =
        ADFUtils.findIterator("OfferMilestoneDetail_VO6Iterator").getViewObject();
    ViewObject minbasepriceRVO =
        ADFUtils.findIterator("MinPriceValidationROVO1Iterator").getViewObject();
    ViewObject offerDtl =
        ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();


    ArrayList<Object> list = new ArrayList<Object>();
    public String validateMinBaseRate(Object plid, Object unitid,
                                      Object baseRate) {
        String BaseRate = baseRate == null ? "0" : baseRate.toString();
        minbasepriceRVO.setNamedWhereClauseParam("P_PL_ID", plid);
        minbasepriceRVO.setNamedWhereClauseParam("P_UNIT_ID", unitid);
        minbasepriceRVO.executeQuery();
                System.err.println("min base price ROVO" +
                                   minbasepriceRVO.getEstimatedRowCount());
        if (minbasepriceRVO.first() != null) {
            Row re = minbasepriceRVO.first();
            BigDecimal BAseRAte = new BigDecimal(BaseRate);
            String MinRate =
                re.getAttribute("MinPrice") == null ? "0" : re.getAttribute("MinPrice").toString();
            BigDecimal minRate = new BigDecimal(MinRate);

            int res = BAseRAte.compareTo(minRate);
                        System.err.println("==Comparision results==" + res);
            if (res < 0) {
                BaseRate = "0";

                //                JSFUtils.addFacesErrorMessage("Offer Amount and Offer Total not Should be lesser than " +
                //                                              minRate);
                JSFUtils.addFacesErrorMessage("Offer Value Cannot be less than Min Value " +
                                              minRate);

                countt++;

            }


        }


        return BaseRate;
    }

    public int validateMandatoryFileds() {
        ViewObject BkHdrVo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        int count = 0;

        if (BkHdrVo.getCurrentRow().getAttribute("LeadId") == "" ||
            BkHdrVo.getCurrentRow().getAttribute("LeadId") == null) {

            count = 1;

        }

        if (BkHdrVo.getCurrentRow().getAttribute("OfferFromDate") == "" ||
            BkHdrVo.getCurrentRow().getAttribute("OfferFromDate") == null) {

            count = 2;

        }

        if (BkHdrVo.getCurrentRow().getAttribute("OfferType") == "" ||
            BkHdrVo.getCurrentRow().getAttribute("OfferType") == null) {
            count = 3;
        }
        if (BkHdrVo.getCurrentRow().getAttribute("MsHdrId") == "" ||
            BkHdrVo.getCurrentRow().getAttribute("MsHdrId") == null) {
            count = 4;
        }

        return count;
    }


    public Object validateDays(Object NoOfdays) {
        ViewObject BkHdrVo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row re = BkHdrVo.getCurrentRow();
        oracle.jbo.domain.Date DateFr =
            (oracle.jbo.domain.Date)(re.getAttribute("OfferFromDate") == null ?
                                     "" : re.getAttribute("OfferFromDate"));
        Object result = DateFr;

        if (NoOfdays != null) {

            String val = NoOfdays == null ? "0" : NoOfdays.toString();
            int noOfDays = Integer.parseInt(val);
            //            System.err.println("OFFERFROMDATE" + DateFr);
            try {
                Calendar c = Calendar.getInstance();
                c.setTime(DateFr.getValue());
                c.add(Calendar.DATE, noOfDays);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.format(c.getTime());
                String formatted = sdf.format(c.getTime());
                result = formatted;
                //                System.err.println("Formatted Date" + result);
            } catch (Exception e) {
                //                System.err.println("ERROR" + e);
            }
        }
        //        System.err.println("RESULT" + result);

        return result;
    }

    public static Date addDays(Date d, int days) {
        d.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
        return d;
    }
    ViewObject offerHrdVO =
        ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
    ViewObject offerLnsVO =
        ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
    ViewObject offerMilesDtlsVO =
        ADFUtils.findIterator("OfferMilestoneDetail_VO1Iterator").getViewObject();
    ViewObject findMileSDtlVO =
        ADFUtils.findIterator("findMS_DetailsROVO1Iterator").getViewObject();

    public void onAttributesSave() {

        if (offerLnsVO.getEstimatedRowCount() > 0) {
            offerHrdVO.getCurrentRow().setAttribute("PropertyId",
                                                    offerLnsVO.first().getAttribute("PropertyId"));
            offerHrdVO.getCurrentRow().setAttribute("BuildingId",
                                                    offerLnsVO.first().getAttribute("BuildingId"));
        
            String userName =
                ADFContext.getCurrent().getSessionScope().get("userName") ==
                null ? "Anonymous" :
                ADFContext.getCurrent().getSessionScope().get("userName").toString();
            System.out.println("USER NAME :: "+ userName);
            offerHrdVO.getCurrentRow().setAttribute("LastUpdatedBy", userName);
        }


    }

    public String onValidateDuplicateUnit(Object ob) {
        String result = "N";
        ViewObject offerLnsVO2 =
            ADFUtils.findIterator("OfferDetail_VO2Iterator").getViewObject();
        ViewCriteria vc = offerLnsVO2.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();

        vcRow.setAttribute("UnitId", ob);
        vc.addRow(vcRow);
        offerLnsVO2.applyViewCriteria(vc);
        offerLnsVO2.executeQuery();


        if (offerLnsVO2.getEstimatedRowCount() > 0) {
            result = "Y";
        }


        return result;
    }


    //    public String validateTotalRate(){
    //
    //
    //
    //        return null;
    //    }


    public String onSave() {
        String ret = "";

        try {
            int count = 0;
            Object val =
                ADFContext.getCurrent().getSessionScope().get("addEditOffer") ==
                null ? "" :
                ADFContext.getCurrent().getSessionScope().get("addEditOffer").toString();
            if (val.equals("Add")) {
                RowSetIterator mileDtlRs =
                    offerLnsVO.createRowSetIterator(null);

                while (mileDtlRs.hasNext()) {
                    Row mileDtlRow = mileDtlRs.next();
                    // Create New row in offer Milestone Detail
                    Row offerMileStoneDtlRow = offerLnsVO.first();
                    String result =
                        onValidateDuplicateUnit(offerMileStoneDtlRow.getAttribute("UnitId")).toString();
                    if (result.equals("Y")) {
                        count++;
                    }
                }
            }
            //#{sessionScope.addEditOffer}


            ViewObject OfferHdrVo =
                ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
            Row re = OfferHdrVo.getCurrentRow();
            //to handle ms due date for renewal and short renewal
            String msHdrId = re.getAttribute("MsHdrId")==null ? "0" : re.getAttribute("MsHdrId").toString();
            if(!msHdrId.equals("0")){
                System.out.println("msHdrId :"+msHdrId);
                OnValidateMilestoneProcessDueDate(re.getAttribute("MsHdrId"));
            }
            Row offerLnsRow = offerLnsVO.getCurrentRow();
            baseRate =
                    offerLnsRow.getAttribute("TotalRate") == null ? "0" : offerLnsRow.getAttribute("TotalRate").toString();
            Double offTotalRate = Double.parseDouble(baseRate);

            if (re.getAttribute("OfferFlag") != null &&
                re.getAttribute("LeadId") != null &&
                re.getAttribute("OfferFromDate") != null &&
                re.getAttribute("OfferType") != null &&
                re.getAttribute("MsHdrId") != null &&
                re.getAttribute("Checklist") != null &&
                re.getAttribute("Currency") != null &&
                re.getAttribute("PlId") != null &&
                offerLnsRow.getAttribute("BaseRate") != null) {

                ViewObject getFuncodeVo =
                    ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                getFuncodeVo.setNamedWhereClauseParam("F_ID", "OF");
                getFuncodeVo.executeQuery();
                Object Funcode = getFuncodeVo.first().getAttribute("FuncId");

System.out.println("offerTotalRate :: "+offTotalRate);
                if (offTotalRate >= 0) {
                    if (re.getAttribute("OfferNumber") == null) {
                        String name =
                            xxfnd.generateDocNo("OF", "OfferAppModuleDataControl").toString();
                        Object valu = name;
                        re.setAttribute("OfferNumber", valu);
                        re.setAttribute("FuncId",
                                        getFuncodeVo.first().getAttribute("FuncId"));
                    }
                    onCalculateTotal();
                    onAttributesSave();
                    if (countt == 0) {
                        ADFUtils.findOperation("Commit").execute();
                        JSFUtils.addFacesInformationMessage("Saved.....");
                        ret = "save";
                    } else {
                        JSFUtils.addFacesInformationMessage("Offer Amount and Offer Total Rent should be lesser than Minimum Rate");
                        ret = null;
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Negative values are not allowed,Validate your offer Total Rate");
                    ret = null;

                }
            } else {

                if (re.getAttribute("OfferFlag") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Offer Flag");
                }
                if (re.getAttribute("LeadId") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Lead");
                }
                if (re.getAttribute("OfferFromDate") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Expected Lease Start Date");
                }
                if (re.getAttribute("OfferType") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Offer Type");
                }
                if (re.getAttribute("MsHdrId") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Payment Plane");
                }
                if (re.getAttribute("Checklist") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Check list");
                }
                if (re.getAttribute("Currency") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Currency");
                }
                if (re.getAttribute("PlId") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Price List");
                }
                if (offerLnsRow.getAttribute("BaseRate") == null) {
                    JSFUtils.addFacesErrorMessage("Base Price can't be null");
                }    
                ret = null;

            }

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return ret;


    }


    public void onClickSave(ActionEvent actionEvent) {

        ViewObject OfferHdrVo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row re = OfferHdrVo.getCurrentRow();
        //expected discount mandatory
        String exptdDisc = re.getAttribute("ExpectedDiscount_Trans")==null ? "" : re.getAttribute("ExpectedDiscount_Trans").toString();
        if(!exptdDisc.equalsIgnoreCase("")){
        //to handle ms due date for renewal and short renewal
        String msHdrId = re.getAttribute("MsHdrId")==null ? "0" : re.getAttribute("MsHdrId").toString();
        if(!msHdrId.equals("0")){
            System.out.println("msHdrId :"+msHdrId);
            OnValidateMilestoneProcessDueDate(re.getAttribute("MsHdrId"));
        }
        onClickOfferLineCal(actionEvent);
//        onClickSaveorCalcAllNew();
        try {
            int count = 0;
            Object val =
                ADFContext.getCurrent().getSessionScope().get("addEditOffer") ==
                null ? "" :
                ADFContext.getCurrent().getSessionScope().get("addEditOffer").toString();
            if (val.equals("Add")) {
                RowSetIterator mileDtlRs =
                    offerLnsVO.createRowSetIterator(null);

                while (mileDtlRs.hasNext()) {
                    Row mileDtlRow = mileDtlRs.next();
                    // Create New row in offer Milestone Detail
                    Row offerMileStoneDtlRow = offerLnsVO.first();
                    String result =
                        onValidateDuplicateUnit(offerMileStoneDtlRow.getAttribute("UnitId")).toString();
                    if (result.equals("Y")) {
                        count++;
                    }
                }
            }
            //#{sessionScope.addEditOffer}


//            ViewObject OfferHdrVo =
//                ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
//            Row re = OfferHdrVo.getCurrentRow();

            Row offerLnsRow = offerLnsVO.getCurrentRow();
            baseRate =
                    offerLnsRow.getAttribute("TotalRate") == null ? "0" : offerLnsRow.getAttribute("TotalRate").toString();
            Double offTotalRate = Double.parseDouble(baseRate);

            if (re.getAttribute("OfferFlag") != null &&
                re.getAttribute("LeadId") != null &&
                re.getAttribute("OfferFromDate") != null &&
                re.getAttribute("OfferType") != null &&
                re.getAttribute("MsHdrId") != null &&
                re.getAttribute("Checklist") != null &&
                re.getAttribute("Currency") != null &&
                re.getAttribute("PlId") != null &&
                offerLnsRow.getAttribute("BaseRate") != null)  {

                ViewObject getFuncodeVo =
                    ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                getFuncodeVo.setNamedWhereClauseParam("F_ID", "OF");
                getFuncodeVo.executeQuery();
                Object Funcode = getFuncodeVo.first().getAttribute("FuncId");


                if (offTotalRate >= 0) {
                    if (re.getAttribute("OfferNumber") == null) {
                        String name =
                            xxfnd.generateDocNo("OF", "OfferAppModuleDataControl").toString();
                        Object valu = name;
                        re.setAttribute("OfferNumber", valu);
                        re.setAttribute("FuncId",
                                        getFuncodeVo.first().getAttribute("FuncId"));
                    }
                    onCalculateTotal();
                    onAttributesSave();
                    if (countt == 0) {
                        ADFUtils.findOperation("Commit").execute();
                        JSFUtils.addFacesInformationMessage("Saved.....");

                    } else {
                        JSFUtils.addFacesInformationMessage("Offer Amount and Offer Total Rent should be lesser than Minimum Rate");
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Negative values are not allowed,Validate your offer Total Rate");

                }
            } else {

                if (re.getAttribute("OfferFlag") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Offer Flag");
                }
                if (re.getAttribute("LeadId") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Lead");
                }
                if (re.getAttribute("OfferFromDate") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Expected Lease Start Date");
                }
                if (re.getAttribute("OfferType") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Offer Type");
                }
                if (re.getAttribute("MsHdrId") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Payment Plane");
                }
                if (re.getAttribute("Checklist") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Check list");
                }
                if (re.getAttribute("Currency") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Currency");
                }
                if (re.getAttribute("PlId") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Price List");
                }
                if (offerLnsRow.getAttribute("BaseRate") == null) {
                    JSFUtils.addFacesErrorMessage("Base Price can't be null");
                }
            }

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        }else{
            JSFUtils.addFacesErrorMessage("Expected Discount should not be null !!!");
        }

    }

    public void onClickPopupCancel(ActionEvent actionEvent) {
        this.getP1().cancel();
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void omChangeFlag(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        deleteAllRows();
        if (valueChangeEvent.getNewValue() != null) {
            ADFContext.getCurrent().getPageFlowScope().put("offerFlag",
                                                           valueChangeEvent.getNewValue().toString());
            //            JSFUtils.setExpressionValue("#{pageFlowScope.offerFlag}",
            //                                        valueChangeEvent.getNewValue().toString());
            //            System.err.println("==Scope value=="+ADFContext.getCurrent().getSessionScope().get("offerFlag"));
            //            System.err.println("==Session Scop==" +
            //                               JSFUtils.resolveExpression("#{pageFlowScope.offerFlag}"));
            if (valueChangeEvent.getNewValue().equals("N")) {
                offerHrdVO.getCurrentRow().setAttribute("LeadId", null);
                offerHrdVO.getCurrentRow().setAttribute("MsHdrId", null);
                offerHrdVO.getCurrentRow().setAttribute("NetOfferAmount",
                                                        null);
                offerHrdVO.getCurrentRow().setAttribute("OfferFromDate", null);
                offerHrdVO.getCurrentRow().setAttribute("OfferToDate", null);
                offerHrdVO.getCurrentRow().setAttribute("OfferType", null);
                offerHrdVO.getCurrentRow().setAttribute("OrgId", null);
                offerHrdVO.getCurrentRow().setAttribute("PlId", null);
                offerHrdVO.getCurrentRow().setAttribute("Currency", null);
                offerHrdVO.getCurrentRow().setAttribute("OfferTotal", null);
                offerHrdVO.getCurrentRow().setAttribute("Terms", null);
                offerHrdVO.getCurrentRow().setAttribute("Checklist", null);

            } else if ((offerHrdVO.getCurrentRow().getAttribute("OfferFlag").toString() ==
                        "S") &&
                       (offerHrdVO.getCurrentRow().getAttribute("OfferFlag") !=
                        null)) {
                ADFContext.getCurrent().getPageFlowScope().put("offerFlag",
                                                               offerHrdVO.getCurrentRow().getAttribute("OfferFlag"));
            }
        }


    }


    public void onChangeMileHrd(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getOldValue() != null) {
            RowSetIterator rs = offerMilesDtlsVO.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                r.remove();
            }

            //            System.err.println("Milestone Success");
            String mileHrdId =
                valueChangeEvent.getNewValue() == null ? "" : valueChangeEvent.getNewValue().toString();
            String OffHrdId =
                offerHrdVO.getCurrentRow().getAttribute("OfferHdrId") == null ?
                "" :
                offerHrdVO.getCurrentRow().getAttribute("OfferHdrId").toString();
            if (mileHrdId != null && OffHrdId != null) {
                // Filtering MileStone Detail
                findMileSDtlVO.setNamedWhereClauseParam("BV_MS_HR_ID",
                                                        mileHrdId);
                findMileSDtlVO.executeQuery();

                // Count not equal to 0
                if (findMileSDtlVO.getEstimatedRowCount() != 0) {
                    // MileStone Detail Iterator
                    RowSetIterator mileDtlRs =
                        findMileSDtlVO.createRowSetIterator(null);
                    while (mileDtlRs.hasNext()) {
                        Row mileDtlRow = mileDtlRs.next();
                        // Create New row in offer Milestone Detail
                        Row offerMileStoneDtlRow =
                            offerMilesDtlsVO.createRow();
                        offerMileStoneDtlRow.setAttribute("OfferHdrId",
                                                          OffHrdId);
                        offerMileStoneDtlRow.setAttribute("MsDtlId",
                                                          mileDtlRow.getAttribute("MsDtlId"));
                        offerMileStoneDtlRow.setAttribute("SeqNumber",
                                                          mileDtlRow.getAttribute("SeqNumber"));
                        offerMileStoneDtlRow.setAttribute("InstallmentType",
                                                          mileDtlRow.getAttribute("InstallmentType"));
                        offerMileStoneDtlRow.setAttribute("InstallmentPct",
                                                          mileDtlRow.getAttribute("InstallmentPct"));
                        //                        offerMileStoneDtlRow.setAttribute("InstallmentAmount", null);
                        offerMileStoneDtlRow.setAttribute("Criteria",
                                                          mileDtlRow.getAttribute("Criteria"));
                        offerMileStoneDtlRow.setAttribute("ChargeType",
                                                          mileDtlRow.getAttribute("ChargeType"));
                        offerMileStoneDtlRow.setAttribute("PaymentTerm",
                                                          mileDtlRow.getAttribute("PaymentTerm"));
                        String val =
                            validateDays(mileDtlRow.getAttribute("NoOfDays")) ==
                            null ? "" :
                            validateDays(mileDtlRow.getAttribute("NoOfDays")).toString();
                        if (val != "") {
                            try {
                                Date date1 =
                                    new SimpleDateFormat("dd/MM/yyyy").parse(val);


                                java.sql.Date sqlDate =
                                    new java.sql.Date(date1.getTime());
                                oracle.jbo.domain.Date domadate =
                                    new oracle.jbo.domain.Date(sqlDate);
                                offerMileStoneDtlRow.setAttribute("DueDate",
                                                                  domadate);
                            } catch (ParseException e) {
                                //                                System.err.println("ERROR" + e);
                            }
                        }

                        offerMileStoneDtlRow.setAttribute("Remarks",
                                                          mileDtlRow.getAttribute("Remarks"));

                        offerMilesDtlsVO.insertRow(offerMileStoneDtlRow);
                    }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(t4);

                }
            } else {
                JSFUtils.addFacesErrorMessage("Please select Payment Plan");
            }
        } else {
            String mileHrdId =
                valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
            String OffHrdId =
                offerHrdVO.getCurrentRow().getAttribute("OfferHdrId") == null ?
                "" :
                offerHrdVO.getCurrentRow().getAttribute("OfferHdrId").toString();
            if (mileHrdId != null && OffHrdId != null) {
                // Filtering MileStone Detail
                findMileSDtlVO.setNamedWhereClauseParam("BV_MS_HR_ID",
                                                        mileHrdId);
                findMileSDtlVO.executeQuery();

                // Count not equal to 0
                if (findMileSDtlVO.getEstimatedRowCount() != 0) {
                    // MileStone Detail Iterator
                    RowSetIterator mileDtlRs =
                        findMileSDtlVO.createRowSetIterator(null);
                    while (mileDtlRs.hasNext()) {
                        Row mileDtlRow = mileDtlRs.next();
                        // Create New row in offer Milestone Detail
                        Row offerMileStoneDtlRow =
                            offerMilesDtlsVO.createRow();
                        offerMileStoneDtlRow.setAttribute("OfferHdrId",
                                                          OffHrdId);
                        offerMileStoneDtlRow.setAttribute("MsDtlId",
                                                          mileDtlRow.getAttribute("MsDtlId"));
                        offerMileStoneDtlRow.setAttribute("SeqNumber",
                                                          mileDtlRow.getAttribute("SeqNumber"));
                        offerMileStoneDtlRow.setAttribute("InstallmentType",
                                                          mileDtlRow.getAttribute("InstallmentType"));
                        offerMileStoneDtlRow.setAttribute("InstallmentPct",
                                                          mileDtlRow.getAttribute("InstallmentPct"));
                        //                        offerMileStoneDtlRow.setAttribute("InstallmentAmount", null);
                        offerMileStoneDtlRow.setAttribute("Criteria",
                                                          mileDtlRow.getAttribute("Criteria"));
                        offerMileStoneDtlRow.setAttribute("ChargeType",
                                                          mileDtlRow.getAttribute("ChargeType"));
                        offerMileStoneDtlRow.setAttribute("PaymentTerm",
                                                          mileDtlRow.getAttribute("PaymentTerm"));
                        offerMileStoneDtlRow.setAttribute("Remarks",
                                                          mileDtlRow.getAttribute("Remarks"));
                        offerMileStoneDtlRow.setAttribute("DueDate",
                                                          mileDtlRow.getAttribute("DueDate"));
                        offerMilesDtlsVO.insertRow(offerMileStoneDtlRow);
                    }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(t4);

                }
            } else {
                JSFUtils.addFacesErrorMessage("Please select Payment Plan");
            }
        }
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void OnchangePriceList(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject HCurrvo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row Hcurr = HCurrvo.getCurrentRow();
        ViewObject Currvo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        Row curr = Currvo.getCurrentRow();
        System.err.println("leadname="+Hcurr.getAttribute("Trans_LeadNumber"));
        System.err.println("unitname="+valueChangeEvent.getNewValue());
        
        Long count=offervalidation(Hcurr.getAttribute("Trans_LeadNumber"),valueChangeEvent.getNewValue());
        if(count>0)
               {
                    curr.setAttribute("Uom",null);
                    curr.setAttribute("AreaSq",null);
                    curr.setAttribute("UnitType",null);
                    curr.setAttribute("UnitId",null);
                    curr.setAttribute("Tra_UnitName",null);
        JSFUtils.addFacesErrorMessage("Same combination of lead and unit number is already created for Offer");
                }
        else{
       //----
        ViewObject vo =
            ADFUtils.findIterator("PlLinesVO1Iterator").getViewObject();
        ViewCriteria vc = vo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        //        System.err.println("PropertyId" + curr.getAttribute("PropertyId"));
        //        System.err.println("BuildingId" + curr.getAttribute("BuildingId"));
        //        System.err.println("PlId" + curr.getAttribute("PlId"));
        //        System.err.println("UnitId" + curr.getAttribute("UnitId"));

        vcRow.setAttribute("PropertyId", curr.getAttribute("PropertyId"));
        vcRow.setAttribute("BuildId", curr.getAttribute("BuildingId"));
        vcRow.setAttribute("UnitId", curr.getAttribute("UnitId"));
        vcRow.setAttribute("PlId", Hcurr.getAttribute("PlId"));
        vc.addRow(vcRow);
        vo.applyViewCriteria(vc);
        vo.executeQuery();
        long io = vo.getEstimatedRowCount();
        //        System.err.println("estimationrowCount" + io);

        if (vo.getEstimatedRowCount() > 0) {
            Row re = vo.first();
//            curr.setAttribute("Uom",
//                              re.getAttribute("Uom") == null ? "" : re.getAttribute("Uom"));


            curr.setAttribute("BaseRate",
                              re.getAttribute("BasePrice") == null ? "" :
                              re.getAttribute("BasePrice"));
            curr.setAttribute("SetRentPerAnnum",
                              re.getAttribute("BasePrice") == null ? "" :
                              re.getAttribute("BasePrice"));

            curr.setAttribute("MunicipalityCharges",
                              re.getAttribute("MunicipalityCharges") == null ?
                              "" : re.getAttribute("MunicipalityCharges"));

            curr.setAttribute("ElectricityCharges",
                              re.getAttribute("ElectricityCharges") == null ?
                              "" : re.getAttribute("ElectricityCharges"));


            curr.setAttribute("SecurityDeposite",
                              re.getAttribute("SecurityDeposite") == null ?
                              "" : re.getAttribute("SecurityDeposite"));


            curr.setAttribute("MunicipalityPercentage",
                              re.getAttribute("MunicipalityPercentage") ==
                              null ? "" :
                              re.getAttribute("MunicipalityPercentage"));

            curr.setAttribute("EjariPaymentCharge",
                              re.getAttribute("EjariPaymentCharge") == null ?
                              "" : re.getAttribute("EjariPaymentCharge"));
            curr.setAttribute("ThirdPartyServCharge",
                              re.getAttribute("ThirdPartyServCharge") == null ?
                              "" : re.getAttribute("ThirdPartyServCharge"));
            curr.setAttribute("OtherGovntChargeNew",
                              re.getAttribute("OtherGovntChargeNew") == null ?
                              "" : re.getAttribute("OtherGovntChargeNew"));
            curr.setAttribute("OtherGovntChargeRnew",
                              re.getAttribute("OtherGovntChargeRnew") == null ?
                              "" : re.getAttribute("OtherGovntChargeRnew"));

            curr.setAttribute("PremiumRate1",
                              re.getAttribute("Premium1") == null ? "" :
                              re.getAttribute("Premium1"));
            curr.setAttribute("PremiumRate2",
                              re.getAttribute("Premium2") == null ? "" :
                              re.getAttribute("Premium2"));
            curr.setAttribute("PremiumRate3",
                              re.getAttribute("Premium3") == null ? "" :
                              re.getAttribute("Premium3"));
            curr.setAttribute("PremiumRate4",
                              re.getAttribute("Premium4") == null ? "" :
                              re.getAttribute("Premium4"));
            curr.setAttribute("PremiumRate5",
                              re.getAttribute("Premium5") == null ? "" :
                              re.getAttribute("Premium5"));
            //for updaing unit incharge and owner
            ViewObject unitDtlsRoVo = ADFUtils.findIterator("findByUnitName1Iterator").getViewObject();
            String unitidd = curr.getAttribute("UnitId")==null?"":curr.getAttribute("UnitId").toString();
            RowSetIterator utRSI = unitDtlsRoVo.createRowSetIterator(null);
            ViewCriteria vcc = unitDtlsRoVo.createViewCriteria();
            ViewCriteriaRow vccRow = vcc.createViewCriteriaRow();
            vccRow.setAttribute("UnitId", unitidd);
            vcc.addRow(vccRow);
            unitDtlsRoVo.applyViewCriteria(vcc);
            unitDtlsRoVo.executeQuery();
            if(unitDtlsRoVo.getEstimatedRowCount()>0){
                while (utRSI.hasNext()) {
                    Row r1 = utRSI.next();
                String unitInChrg = r1.getAttribute("UnitIncharge")==null?"":r1.getAttribute("UnitIncharge").toString();
                String owner = r1.getAttribute("Owner")==null?"":r1.getAttribute("Owner").toString();
                Hcurr.setAttribute("UnitIncharge", unitInChrg);
                Hcurr.setAttribute("UnitOwner", owner);
                }
                utRSI.closeRowSetIterator();
            }

        }else{
            JSFUtils.addFacesErrorMessage("This unit is not available in price list !!!");
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
       // ----
        }

    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }
    public long offervalidation(Object leadname,Object unitid)
    {
    ViewObject vo=ADFUtils.findIterator("OfferDuplicateCheck_ROVO1Iterator").getViewObject();   
        ViewCriteria vc=vo.createViewCriteria();
               ViewCriteriaRow vcr=vc.createViewCriteriaRow();
               vcr.setAttribute("LeadNumber",leadname);
               vcr.setAttribute("UnitName",unitid);
               vc.addRow(vcr);
               vo.applyViewCriteria(vc);
               vo.executeQuery();
        Long count=vo.getEstimatedRowCount();
        System.err.println("Count"+count);
               String Flag="ND";
               if(count>0)
               {
                   RowSetIterator itr=vo.createRowSetIterator(null);
                     while(itr.hasNext())
                     {
                         Row r=itr.next();
                         
                         System.err.println("Print="+r.getAttribute("Status"));
                         if(!r.getAttribute("Status").toString().equalsIgnoreCase("REJ"))
                         {
                             if(!r.getAttribute("Status").toString().equalsIgnoreCase("CANC"))
                             {
                                 if(!r.getAttribute("Status").toString().equalsIgnoreCase("EXP"))
                                 {
                             Flag="D";
                             System.err.println("Flag="+Flag);
                                 }
                             }
                             
                         }
                        
                 
                         
                     }
                   itr.closeRowSetIterator();  
                   if(Flag.equalsIgnoreCase("D"))
                   {
                       count = new Long(1);
                   }
                   else
                   {
                       count=new Long(0);
                   }
               }
           
               
               
               return count;
    }
    
    public void onCalculateTotal() {

        onCalculateRateDis();
        ViewObject Hvo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row re = Hvo.getCurrentRow();

        ViewObject vo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        if (vo.getEstimatedRowCount() > 0) {
            RowSetIterator mileDtlRs = vo.createRowSetIterator(null);
            BigDecimal Total = new BigDecimal(0);

            while (mileDtlRs.hasNext()) {
                Row mileDtlRow = mileDtlRs.next();
                String tot =
                    mileDtlRow.getAttribute("TotalRate") == null ? "0" :
                    mileDtlRow.getAttribute("TotalRate").toString();
                Total = Total.add(new BigDecimal(tot));
            }
            mileDtlRs.closeRowSetIterator();
            float val = Total.floatValue();
            oracle.jbo.domain.Number TotalAmt =
                new oracle.jbo.domain.Number(val);
                      System.err.println("==Total Amount==" + TotalAmt);//totalRate
            re.setAttribute("OfferTotal", TotalAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(offerTotal);
        }


    }


    public void onCalculateRateDis() {

        ViewObject vo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        //for avoiding min validtn when no of days is less then year for N and R
        oracle.jbo.domain.Date st = (oracle.jbo.domain.Date)id4.getValue();
        oracle.jbo.domain.Date en = (oracle.jbo.domain.Date)id6.getValue();
        System.out.println("st date and end date : "+st+ " "+en);
        long ndays = getDifferenceDaysBetweenTwoDates(st, en);
        int nodays = (int)ndays;
        BigDecimal VTotal = new BigDecimal(0);
        BigDecimal TAmount = new BigDecimal(0);
        BigDecimal DAmnt = new BigDecimal(0);
        BigDecimal BRate = new BigDecimal(0);
        String Dresult = "0";
        String BaseRate = "0";
        String vetotal = "0";
        BigDecimal OfferRent = new BigDecimal(0);
        if (vo.getEstimatedRowCount() > 0) {
            RowSetIterator mileDtlRs = vo.createRowSetIterator(null);
            while (mileDtlRs.hasNext()) {
                Row mileDtlRow = mileDtlRs.next();
                System.err.println("==Flag Session==" +
                                   (offerhdr.getCurrentRow().getAttribute("OfferFlag")));
                String flagVlaue = offerhdr.getCurrentRow().getAttribute("OfferFlag")==null?"": offerhdr.getCurrentRow().getAttribute("OfferFlag").toString();
                if ((flagVlaue.equalsIgnoreCase("N") && !offerhdr.getCurrentRow().getAttribute("LeaseType").equals("CAR_PARKING") && nodays >364 ) || (flagVlaue.equalsIgnoreCase("R") && nodays >364 )){
                    BaseRate =
                            validateMinBaseRate(offerhdr.getCurrentRow().getAttribute("PlId"),
                                                mileDtlRow.getAttribute("UnitId"),
                                                mileDtlRow.getAttribute("BaseRate"));
//                    System.err.println("==Base Rate=="+BaseRate);
                }else{
                    BaseRate = mileDtlRow.getAttribute("BaseRate").toString();
                }

                //                String TaxAmount =
                //                    TaxCalculation(mileDtlRow.getAttribute("BaseRate")) ==
                //                    null ? "0" :
                //                    TaxCalculation(mileDtlRow.getAttribute("BaseRate")).toString();
                // TAmount = new BigDecimal(TaxAmount);
                DAmnt = new BigDecimal(0);
                BRate = new BigDecimal(BaseRate);

//                System.err.println("==DAmnt=="+DAmnt);
//                System.err.println("==BRate =="+BRate);

                if (mileDtlRow.getAttribute("DiscountAmount") != null) {
                    VTotal =
                            onDiscount(mileDtlRow.getAttribute("DiscountAmount"),
                                       mileDtlRow.getAttribute("BaseRate"));

                    //Added to Get Discount Result
//                    DAmnt =
//                            onDiscount(mileDtlRow.getAttribute("DiscountAmount"),
//                                       mileDtlRow.getAttribute("BaseRate"));

                    Dresult =
                            onDiscountValue(mileDtlRow.getAttribute("DiscountAmount"),
                                            mileDtlRow.getAttribute("BaseRate"));
                } else {
                    VTotal = new BigDecimal(BaseRate);
//                    System.err.println("else total==="+VTotal);
                }
                Object lineTot = VTotal;
                String TaxAmount =
                    TaxCalculation(lineTot) == null ? "0" : TaxCalculation(lineTot).toString();

                TAmount = new BigDecimal(TaxAmount);


//                if (VTotal.equals(new BigDecimal(0))) {
//                    VTotal = BRate;
//                }// Commented for calculation validaion on 5-5-2019


                VTotal = VTotal.add(TAmount);
                int res = VTotal.compareTo(new BigDecimal(0));
//                if (res == 0) {
//                    VTotal = BRate;
//                }// Commented for calculation validaion on 5-5-2019
                /********100% logic commented bcoz of error while doing parking offer**************/
                //                System.err.println("==Dis Amt==" + DAmnt);
                //                if (DAmnt.equals(new BigDecimal(0))) {
                //                    VTotal = new BigDecimal(0);
                //                }

                //                System.err.println("Dresult"+Dresult);
                if (Dresult.equals("%100")) {
                    VTotal = new BigDecimal(0);
                }

                float tax = TAmount.floatValue();
                oracle.jbo.domain.Number taxamnt =
                    new oracle.jbo.domain.Number(tax);
                String vetott = VTotal.toString();
                Object totRes = vetott;
            if ((flagVlaue.equalsIgnoreCase("N") && !offerhdr.getCurrentRow().getAttribute("LeaseType").equals("CAR_PARKING") && nodays >364 ) || (flagVlaue.equalsIgnoreCase("R") && nodays >364 )){
                    vetotal =
                            validateMinBaseRate(offerhdr.getCurrentRow().getAttribute("PlId"),
                                                mileDtlRow.getAttribute("UnitId"),
                                                totRes);
                    OfferRent = new BigDecimal(vetotal);
//                    System.err.println("=====Ve total==="+vetotal);
                } else {
                    OfferRent = VTotal;
//                    System.err.println("else total 2==="+VTotal);

                }

                float OfferTotal = OfferRent.floatValue();
                oracle.jbo.domain.Number offerTotal =
                    new oracle.jbo.domain.Number(OfferTotal);
                //                System.err.println("==offer Total Inside Discount==" +
                //                                   offerTotal);
                //                System.err.println("==tax amnt==" + taxamnt);
                BigDecimal netWithoutTax = new BigDecimal(0);
                netWithoutTax = OfferRent.subtract(TAmount);
                mileDtlRow.setAttribute("TotalRate", offerTotal);
                mileDtlRow.setAttribute("TaxAmount", taxamnt);
                mileDtlRow.setAttribute("NetRentWithoutTax", netWithoutTax);
            }
        }

    }


    public String TaxCalculation(Object BaserAte) {
        String baseRate = BaserAte == null ? "0" : BaserAte.toString();
        BigDecimal BaseRate = new BigDecimal(baseRate);
        String TaxPercentage =
            offerHrdVO.getCurrentRow().getAttribute("TaxCode") == null ? "0" :
            offerHrdVO.getCurrentRow().getAttribute("TaxCode").toString();

        BigDecimal TaxPErcenatge = new BigDecimal(TaxPercentage);
        BigDecimal TotalPercentage = new BigDecimal(100);
        BigDecimal TaxAmount =
            ((BaseRate.multiply(TaxPErcenatge)).divide(TotalPercentage));
        //        System.err.println("Base Rate " + baseRate);
        //        System.err.println("Tax Percentage" + TaxPercentage);


        return TaxAmount.toString();
    }


    public void setOfferTotal(RichInputText offerTotal) {
        this.offerTotal = offerTotal;
    }

    public RichInputText getOfferTotal() {
        return offerTotal;
    }

    public void onChangeOfferDtlAmnt(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null &&
            valueChangeEvent.getNewValue() != "") {
            onCalculateTotal();
        }

    }

    public void OnChangeDiscount(ValueChangeEvent valueChangeEvent) {
        // Add event code here...

        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null &&
            valueChangeEvent.getNewValue() != "") {
            onCalculateTotal();
        }


    }

    public void OnChangeTax(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null &&
            valueChangeEvent.getNewValue() != "") {
            onCalculateTotal();
        }


    }

    public void setLineAmnt(RichInputText lineAmnt) {
        this.lineAmnt = lineAmnt;
    }

    public RichInputText getLineAmnt() {
        return lineAmnt;
    }

    public void onChangeBRate(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null &&
            valueChangeEvent.getNewValue() != "") {
            onCalculateTotal();
        }
    }


    public void MilestoneCalculate() {


    }


    public void OnClickCalculate(ActionEvent actionEvent) {
        // Add event code here...
        onClickCalculates();


    }

    public void onTotaalCalculation() {

        ViewObject vo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        RowSetIterator mileDtlRs = vo.createRowSetIterator(null);
        BigDecimal Total = new BigDecimal(0);

        while (mileDtlRs.hasNext()) {
            Row mileDtlRow = mileDtlRs.next();
            String tot =
                mileDtlRow.getAttribute("TotalRate") == null ? "0" : mileDtlRow.getAttribute("TotalRate").toString();
            Total = Total.add(new BigDecimal(tot));


        }

        float val = Total.floatValue();
        oracle.jbo.domain.Number TotalAmt = new oracle.jbo.domain.Number(val);
        this.offerTotal.setValue(TotalAmt);
        // re.setAttribute("OfferTotal", TotalAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(offerTotal);


    }


    public String onClickCalculates() {
        try {
            // onCalculateTotal();

            ViewObject vo =
                ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
            RowSetIterator mileDtlRs = vo.createRowSetIterator(null);
            BigDecimal Total = new BigDecimal(0);
            BigDecimal totatTax = new BigDecimal(0);
            while (mileDtlRs.hasNext()) {
                Row mileDtlRow = mileDtlRs.next();
                String tot =
                    mileDtlRow.getAttribute("TotalRate") == null ? "0" :
                    mileDtlRow.getAttribute("TotalRate").toString();
                String lineTax =
                    mileDtlRow.getAttribute("TaxAmount") == null ? "0" :
                    mileDtlRow.getAttribute("TaxAmount").toString();
                Total = Total.add(new BigDecimal(tot));
                totatTax = totatTax.add(new BigDecimal(lineTax));
            }
            BigDecimal netWithoutTax = new BigDecimal(0);
            netWithoutTax = Total.subtract(totatTax);
            float val = Total.floatValue();
            oracle.jbo.domain.Number TotalAmt =
                new oracle.jbo.domain.Number(val);
            offerHrdVO.getCurrentRow().setAttribute("OfferTotal", TotalAmt);
            offerHrdVO.getCurrentRow().setAttribute("OfferTotalWithoutTax", netWithoutTax);
            AdfFacesContext.getCurrentInstance().addPartialTarget(offerTotal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(offerTotalWithoutTax);
            //auto calculate expected discount on 14-july-2021
//            doSetExptedDisc();
//            AdfFacesContext.getCurrentInstance().addPartialTarget(it62ExpectedDisc);
            RowSetIterator dtlsRS =
                offerMilesDtlsVO.createRowSetIterator(null);
            BigDecimal pct = new BigDecimal(0);
            while (dtlsRS.hasNext()) {
                Row r = dtlsRS.next();
                Object instPct = r.getAttribute("InstallmentPct");
                if (instPct != null) {
                    pct = new BigDecimal(r.getAttribute("InstallmentPct").toString());
                }
                String OfferTot =
                    this.offerTotal.getValue() == null ? "0" : this.offerTotal.getValue().toString();
                BigDecimal offerTotal = new BigDecimal(OfferTot);
                //                System.err.println("==offer Total==" + offerTotal);
                BigDecimal Amt =
                    (pct.multiply(offerTotal)).divide(new BigDecimal(100));
                //                System.err.println("==Installment Amount==" + Amt);
                r.setAttribute("InstallmentAmount", Amt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String onClickSubmit() {
        onSave();
        String values = null;
        //offer total should not be null validation on 28-Aug
        ViewObject ofrDtlvo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        RowSetIterator mileDtlRs = ofrDtlvo.createRowSetIterator(null);
        BigDecimal Total = new BigDecimal(0);
        while (mileDtlRs.hasNext()) {
            Row mileDtlRow = mileDtlRs.next();
            String bsRate =
                mileDtlRow.getAttribute("BaseRate") == null ? "" :
                mileDtlRow.getAttribute("BaseRate").toString();
            if(bsRate.equals("")){
                JSFUtils.addFacesErrorMessage("Offer Total can't be null !!!");
                return "";
            }
        }    
        //
// for allowing to click calculate button
            ViewObject ofrMsDtlVo =
        ADFUtils.findIterator("OfferMilestoneDetail_VO1Iterator").getViewObject();
        Row r = ofrMsDtlVo.getCurrentRow();
        if (r.getAttribute("InstallmentAmount") != null){
            
        if (countt == 0) {

            values = "save";

            String ResultVal = null;
            ViewObject vo =
                ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();

            Row row = vo.getCurrentRow();

            Object org =
                offerHrdVO.getCurrentRow().getAttribute("OrgId") == null ? 0 :
                offerHrdVO.getCurrentRow().getAttribute("OrgId");
            Object prop =
                offerLnsVO.first().getAttribute("PropertyId") == null ? 0 :
                offerLnsVO.first().getAttribute("PropertyId");
            Object unit =
                offerLnsVO.first().getAttribute("BuildingId") == null ? 0 :
                offerLnsVO.first().getAttribute("BuildingId");

            try {
//                ResultVal =
//                        xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
//                                              row.getAttribute("FuncId"),
//                                              row.getAttribute("OfferHdrId"),
//                                              0, "XXPM_OFFER_HEADER", "STATUS",
//                                              "OFFER_HDR_ID", org, prop, unit,
//                                              null, null);
          OperationBinding op=ADFUtils.findOperation("submitOfForAppr");
          op.getParamsMap().put("offerHdrId",row.getAttribute("OfferHdrId").toString());
          ResultVal=op.execute().toString();
//          JSFUtils.addFacesInformationMessage(flag);

            } catch (Exception e) {
                e.printStackTrace();
            }

            if (ResultVal.equalsIgnoreCase("Success")) {
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Submitted For Approval");
                //for creating discount flow line
                String ofHdrId = offerHrdVO.getCurrentRow().getAttribute("OfferHdrId") == null ? "0" : offerHrdVO.getCurrentRow().getAttribute("OfferHdrId").toString();
                String userId =
                    ADFContext.getCurrent().getSessionScope().get("userId") == null ?
                    null :
                    ADFContext.getCurrent().getSessionScope().get("userId").toString();
                String userName =
                    ADFContext.getCurrent().getSessionScope().get("userName") == null ?
                    null :
                    ADFContext.getCurrent().getSessionScope().get("userName").toString();
                //calling package
                try{
                offerHrdVO.executeQuery();
                doCreateDiscFlowLine(ofHdrId,userId,userName);
                //mail service
                doSendMailOnSubmit();
                }catch(Exception e){
                    System.out.println(e);
                }
            } else {
                JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
            }


        } else {
            JSFUtils.addFacesInformationMessage("Offer Amount and Offer Total Rent should be lesser than Minimum Rate");
        }
        }else {
            JSFUtils.addFacesInformationMessage("Please click Calculate button and then proceed");
        }

        return values;
    }
    //doSendMailOnSubmit
    public void doSendMailOnSubmit(){
        
    ArrayList<String> ar = new ArrayList<String>();
    ArrayList<String> unitNameAL = new ArrayList<String>();
    ArrayList<String> buildNameAL = new ArrayList<String>();
    ArrayList<String> propNameAL = new ArrayList<String>();
    String emailId = null;
    String userNameDisp = null;
    String buildName= null;
    String propName= null;
    String custName= null;
    String startDate= null;
    String endDate= null;
    String netRent= null;
    String pdfReport=null;
    
    String ofNo = offerHrdVO.getCurrentRow().getAttribute("OfferNumber") == null ? "0" : offerHrdVO.getCurrentRow().getAttribute("OfferNumber").toString();
   //report download url
     pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/offer/"+ofNo;
//     pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/offer/"+ofNo;
    String ofId = offerHrdVO.getCurrentRow().getAttribute("OfferHdrId") == null ? "0" : offerHrdVO.getCurrentRow().getAttribute("OfferHdrId").toString();
    String flowWithId = offerHrdVO.getCurrentRow().getAttribute("FlowWith") == null ? "0" : offerHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
    ViewObject usrRoVo = ADFUtils.findIterator("userROVO1Iterator").getViewObject();//UserEmailId
    ViewCriteria vc = usrRoVo.createViewCriteria();
    ViewCriteriaRow vcr = vc.createViewCriteriaRow();
    vcr.setAttribute("UserId", flowWithId);
    vc.addRow(vcr);
    usrRoVo.applyViewCriteria(vc);
    usrRoVo.executeQuery();
    if (usrRoVo.getEstimatedRowCount() > 0) {
        Row rw = usrRoVo.first();
        emailId = rw.getAttribute("UserEmailId") == null ? "prasenjit.d@4iapps.com" : rw.getAttribute("UserEmailId").toString();
        userNameDisp = rw.getAttribute("UserNameDisp") == null ? "User" : rw.getAttribute("UserNameDisp").toString();
    }
          
     ViewObject ofSrchRoVo = ADFUtils.findIterator("searchOfferDetailROVO1Iterator").getViewObject();
            ViewCriteria vwc = ofSrchRoVo.createViewCriteria();
            ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
            vwcr.setAttribute("OfferHdrId", ofId);
            vwc.addRow(vwcr);
            ofSrchRoVo.applyViewCriteria(vwc);
            ofSrchRoVo.executeQuery();
        if (ofSrchRoVo.getEstimatedRowCount() > 0) {
            RowSetIterator rsi = ofSrchRoVo.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row row = rsi.next();
                    String unitName= row.getAttribute("UnitName")==null ? "" : row.getAttribute("UnitName").toString();
                    unitNameAL.add(unitName);
                    buildName= row.getAttribute("BuildName")==null ? "" : row.getAttribute("BuildName").toString();
                    buildNameAL.add(buildName);
                    propName= row.getAttribute("PropertyName")==null ? "" : row.getAttribute("PropertyName").toString();
                    propNameAL.add(propName);
                    custName= row.getAttribute("LeadName")==null ? "" : row.getAttribute("LeadName").toString();
                    startDate= row.getAttribute("OfferFromDate")==null ? "" : row.getAttribute("OfferFromDate").toString();
                    endDate= row.getAttribute("OfferToDate")==null ? "" : row.getAttribute("OfferToDate").toString();
                    netRent= row.getAttribute("OfferTotal")==null ? "" : row.getAttribute("OfferTotal").toString();
                }
                //testing additional unit
//                unitNameAL.add("Test Unit");
        }
//     ar.add("prasenjit.d@4iapps.com");
//     ar.add("prasenjitdas623@gmail.com");
     ar.add(emailId);
     String htmlBody =MailTemplates.onSubmitForAprTmplt(propName,buildName,unitNameAL,userNameDisp,ofNo,"Offer No",custName,startDate,endDate,netRent,pdfReport);
     String subject = "Approval Notification";
     MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
     JSFUtils.addFacesInformationMessage("Mail has been sent successfully");        
        }
    
    //doSendMailOnApproved
    public void doSendMailOnApproved(){
                 
    ArrayList<String> ar = new ArrayList<String>();
    ArrayList<String> unitNameAL = new ArrayList<String>();
    ArrayList<String> buildNameAL = new ArrayList<String>();
    ArrayList<String> propNameAL = new ArrayList<String>();
    String emailId = null;
    String userNameDisp = null;
    String buildName= null;
    String propName= null;
    String custName= null;
    String startDate= null;
    String endDate= null;
    String netRent= null;
    String pdfReport=null;
    
    String ofNo = offerHrdVO.getCurrentRow().getAttribute("OfferNumber") == null ? "0" : offerHrdVO.getCurrentRow().getAttribute("OfferNumber").toString();
     //report download url
     pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/offer/"+ofNo;
//     pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/offer/"+ofNo;
    String ofId = offerHrdVO.getCurrentRow().getAttribute("OfferHdrId") == null ? "0" : offerHrdVO.getCurrentRow().getAttribute("OfferHdrId").toString();
    String userName = offerHrdVO.getCurrentRow().getAttribute("CreatedBy") == null ? "0" : offerHrdVO.getCurrentRow().getAttribute("CreatedBy").toString();
    //for email id
    ViewObject usrRoVo = ADFUtils.findIterator("userROVO1Iterator").getViewObject();//UserEmailId
    ViewCriteria vc = usrRoVo.createViewCriteria();
    ViewCriteriaRow vcr = vc.createViewCriteriaRow();
    vcr.setAttribute("UserName", userName);
    vc.addRow(vcr);
    usrRoVo.applyViewCriteria(vc);
    usrRoVo.executeQuery();
    if (usrRoVo.getEstimatedRowCount() > 0) {
        Row rw = usrRoVo.first();
        emailId = rw.getAttribute("UserEmailId") == null ? "prasenjit.d@4iapps.com" : rw.getAttribute("UserEmailId").toString();
        userNameDisp = rw.getAttribute("UserNameDisp") == null ? "User" : rw.getAttribute("UserNameDisp").toString();
    }
  //for offer related details
     ViewObject ofSrchRoVo = ADFUtils.findIterator("searchOfferDetailROVO1Iterator").getViewObject();
            ViewCriteria vwc = ofSrchRoVo.createViewCriteria();
            ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
            vwcr.setAttribute("OfferHdrId", ofId);
            vwc.addRow(vwcr);
            ofSrchRoVo.applyViewCriteria(vwc);
            ofSrchRoVo.executeQuery();
        if (ofSrchRoVo.getEstimatedRowCount() > 0) {
            RowSetIterator rsi = ofSrchRoVo.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row row = rsi.next();
                    String unitName= row.getAttribute("UnitName")==null ? "" : row.getAttribute("UnitName").toString();
                    unitNameAL.add(unitName);
                    buildName= row.getAttribute("BuildName")==null ? "" : row.getAttribute("BuildName").toString();
                    buildNameAL.add(buildName);
                    propName= row.getAttribute("PropertyName")==null ? "" : row.getAttribute("PropertyName").toString();
                    propNameAL.add(propName);
                    custName= row.getAttribute("LeadName")==null ? "" : row.getAttribute("LeadName").toString();
                    startDate= row.getAttribute("OfferFromDate")==null ? "" : row.getAttribute("OfferFromDate").toString();
                    endDate= row.getAttribute("OfferToDate")==null ? "" : row.getAttribute("OfferToDate").toString();
                    netRent= row.getAttribute("OfferTotal")==null ? "" : row.getAttribute("OfferTotal").toString();
                }
                //testing additional unit
//                unitNameAL.add("Test Unit");
        }       
//     ar.add("prasenjit.d@4iapps.com");
//     ar.add("prasenjitdas623@gmail.com");
     ar.add(emailId);
     String htmlBody =MailTemplates.onApprovedTmplt(propName,buildName,unitNameAL,userNameDisp,ofNo,"Offer No",custName,startDate,endDate,netRent,pdfReport);
     String subject = "Approval Notification";
     MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
     JSFUtils.addFacesInformationMessage("Mail has been sent successfully");        
        }
    
    public void doCreateDiscFlowLine(String ofHdrId,String userId,String userName){
            
                  OperationBinding op=ADFUtils.findOperation("discountFlowLine");
                  op.getParamsMap().put("ofHdrId",ofHdrId);
                  op.getParamsMap().put("userId",userId);
                  op.getParamsMap().put("userName",userName);
                  String flag=op.execute().toString();
                  JSFUtils.addFacesInformationMessage(flag);
            }

//    public void onClickApprove(ActionEvent actionEvent) {
//
//        Map<String, BigDecimal> ResultVal = new HashMap<String, BigDecimal>();
//
//        ViewObject vo =
//            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
//        Row row = vo.getCurrentRow();
//        String Reason =
//            this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
//
//
//        try {
//            ResultVal =
//                    xxfnd.invokeResponsePkgs("xxfnd_util_pkg.update_response",
//                                             row.getAttribute("FuncId"),
//                                             row.getAttribute("OfferHdrId"),
//                                             row.getAttribute("UserGrpId"),
//                                             row.getAttribute("FlowLevel"),
//                                             row.getAttribute("FlowWith"),
//                                             Reason, "A", 0,
//                                             "XXPM_OFFER_HEADER", "STATUS",
//                                             "OFFER_HDR_ID");
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        // System.err.println("FLOW"+ ADFContext.getCurrent().getSessionScope().get("StatusFlow"));
//
//        for (Map.Entry m : ResultVal.entrySet()) {
//            System.out.println("KEY" + m.getKey() + "VALUE " + m.getValue());
//
//            if (m.getKey().equals("Success")) {                
//                //for auto creation of booking transaction
////                if (row.getAttribute("OfferFlag").equals("N") && row.getAttribute("FlowWith") == null){
////                    if(row.getAttribute("Attribute2") == null){
////                        row.setAttribute("Attribute2", "BK Created");
////                        onClickForBK();
////                        ADFUtils.findOperation("Commit").execute();
////                    }
////                }
//                
//            //for creating discount flow line
//            ADFUtils.findOperation("Commit").execute();
//            vo.executeQuery();
//            String status = row.getAttribute("Status") == null ? "" : row.getAttribute("Status").toString();
//                if (status.equalsIgnoreCase("PEN")){
//                String ofHdrId = offerHrdVO.getCurrentRow().getAttribute("OfferHdrId") == null ? "0" : offerHrdVO.getCurrentRow().getAttribute("OfferHdrId").toString();
//                String userId =
//                    ADFContext.getCurrent().getSessionScope().get("userId") == null ?
//                    null :
//                    ADFContext.getCurrent().getSessionScope().get("userId").toString();
//                String userName =
//                    ADFContext.getCurrent().getSessionScope().get("userName") == null ?
//                    null :
//                    ADFContext.getCurrent().getSessionScope().get("userName").toString();
//                //calling package
//                try {
//                doCreateDiscFlowLine(ofHdrId,userId,userName);
//                }catch(Exception e){
//                    System.out.println(e);
//                }
//                //mail service
//                    doSendMailOnSubmit();
//                }
//                if (status.equalsIgnoreCase("APR")){
//                    //mail service
//                        doSendMailOnApproved();
//                }
//                JSFUtils.addFacesInformationMessage("Approved Successfully");
//            } else {
//                JSFUtils.addFacesErrorMessage("Error in Approve process!");
//            }
//
//
//        }
//
//
//    }
    
        public void onClickApprove(ActionEvent actionEvent) {

        String ResultVal=null;
        ViewObject vo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();


        try {
            OperationBinding op=ADFUtils.findOperation("responseOfForAppr");
                      op.getParamsMap().put("offerHdrId",row.getAttribute("OfferHdrId").toString());
                      op.getParamsMap().put("reason",Reason);
                      op.getParamsMap().put("apr_rej","A");
                      ResultVal=op.execute().toString();
            //          JSFUtils.addFacesInformationMessage(flag);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ResultVal ::"+ResultVal);
            if (ResultVal.equals("Success")) {                
            //for creating discount flow line
            ADFUtils.findOperation("Commit").execute();
            vo.executeQuery();
            String status = row.getAttribute("Status") == null ? "" : row.getAttribute("Status").toString();
                if (status.equalsIgnoreCase("PEN")){
                String ofHdrId = offerHrdVO.getCurrentRow().getAttribute("OfferHdrId") == null ? "0" : offerHrdVO.getCurrentRow().getAttribute("OfferHdrId").toString();
                String userId =
                    ADFContext.getCurrent().getSessionScope().get("userId") == null ?
                    null :
                    ADFContext.getCurrent().getSessionScope().get("userId").toString();
                String userName =
                    ADFContext.getCurrent().getSessionScope().get("userName") == null ?
                    null :
                    ADFContext.getCurrent().getSessionScope().get("userName").toString();
                //calling package
                try {
                doCreateDiscFlowLine(ofHdrId,userId,userName);
                }catch(Exception e){
                    System.out.println(e);
                }
                //mail service
                    doSendMailOnSubmit();
                }
                if (status.equalsIgnoreCase("APR")){
                    //mail service
                        doSendMailOnApproved();
                }
                JSFUtils.addFacesInformationMessage("Approved Successfully");
            } else {
                JSFUtils.addFacesErrorMessage("Error in Approve process!");
            }

    }

    public void onClickDate(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject BkHdrVo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row re = BkHdrVo.getCurrentRow();
        String DateFr =
            re.getAttribute("OfferFromDate") == null ? "" : re.getAttribute("OfferFromDate").toString();
        Date date1 = new Date();
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE, 364);
        DateFormat format12 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format12.format(c.getTime());

        Date date2 = new Date();
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(formatted);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
        oracle.jbo.domain.Date domadate = new oracle.jbo.domain.Date(sqlDate);
        //for checking leap year and setting end date
        String endDt = domadate.toString();
        String isLeapYr = doCheckLeapYr(endDt);
        if(isLeapYr.equalsIgnoreCase("Y")){
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar d = Calendar.getInstance();
            d.setTime(date1);
            d.add(Calendar.DATE, 365);
            DateFormat dFmt = new SimpleDateFormat("yyyy-MM-dd");
            String frmtd = dFmt.format(d.getTime());

            Date date3 = new Date();
            try {
                date3 = new SimpleDateFormat("yyyy-MM-dd").parse(frmtd);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            java.sql.Date sqlDateY = new java.sql.Date(date3.getTime());
            oracle.jbo.domain.Date domadateY = new oracle.jbo.domain.Date(sqlDateY);
            re.setAttribute("OfferToDate", domadateY);
            extnDays.setValue("366");
        }else{
            re.setAttribute("OfferToDate", domadate);
            extnDays.setValue("365");
        }

    }
    //for checking leap year
    public String doCheckLeapYr(String endDt){
        try{
       
        oracle.jbo.domain.Date st = (oracle.jbo.domain.Date)id4.getValue();
    //        oracle.jbo.domain.Date en = (oracle.jbo.domain.Date)id6.getValue();
        System.out.println("st date and end date : "+st+ " "+endDt);
        String toST = st.toString();
        String toEN = endDt;
        System.out.println("toST nad toEN :"+toST+" "+toEN);
        
        Row ofrHdrRow = offerhdr.getCurrentRow();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String oeStartDateStr = st.toString();
        String oeEndDateStr = endDt;
        String g = oeEndDateStr.substring(0, 4);
        String h = oeStartDateStr.substring(0, 4);
        //          String given = "2020-02-29";
        String given = g+"-02-29";
        String given1 = h+"-02-29";
            
        System.out.println("GIVEN :"+given);
        System.out.println("GIVEN1 :"+given1);
        System.out.println("offer from date "+oeStartDateStr +" offer end date "+oeEndDateStr );

        Calendar cal = Calendar.getInstance();
        Date startDate = sdf.parse(oeStartDateStr);
        Date endDate = sdf.parse(oeEndDateStr);
        //        Date d = new Date(given);
        Date d =new SimpleDateFormat("yyyy-MM-dd").parse(given);
            Date e =new SimpleDateFormat("yyyy-MM-dd").parse(given1);
        String currDt = sdf.format(d);
            String currDt1 = sdf.format(e);
        
        System.out.println("last before if" +currDt);
            System.out.println("last before if" +currDt1);
        if( (((d.after(startDate) && (d.before(endDate))) || (currDt.equals(sdf.format(startDate)) ||currDt.equals(sdf.format(endDate)))) && !currDt.contains("03-01")) 
        || (((e.after(startDate) && (e.before(endDate))) || (currDt1.equals(sdf.format(startDate)) ||currDt1.equals(sdf.format(endDate)))) && !currDt1.contains("03-01")) ){
        System.out.println("Current date "+ currDt);
        System.out.println("Date "+currDt+" is between "+startDate+" and "+endDate);
    //        long ndays = getDifferenceDaysBetweenTwoDates(st, en);
           return "Y";
        }
        else{
        System.out.println("Date is not between given date");
        System.out.println("Current date "+ currDt);
    //        long ndays = getDifferenceDaysBetweenTwoDates(st, en);
            return "N";
        }
    
        
        }catch(Exception e){
        System.out.println(e);
        }
        return "";
    }

    public void onClickReject(ActionEvent actionEvent) {
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Rejected" : this.reason.getValue().toString();

        try {
//            ResultVal =
//                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
//                                            row.getAttribute("FuncId"),
//                                            row.getAttribute("OfferHdrId"),
//                                            row.getAttribute("UserGrpId"),
//                                            row.getAttribute("FlowLevel"),
//                                            row.getAttribute("FlowWith"),
//                                            Reason, "R", 0,
//                                            "XXPM_OFFER_HEADER", "STATUS",
//                                            "OFFER_HDR_ID");
            OperationBinding op=ADFUtils.findOperation("responseOfForAppr");
                      op.getParamsMap().put("offerHdrId",row.getAttribute("OfferHdrId").toString());
                      op.getParamsMap().put("reason",Reason);
                      op.getParamsMap().put("apr_rej","R");
                      ResultVal=op.execute().toString();
            //          JSFUtils.addFacesInformationMessage(flag);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            vo.executeQuery();
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Rejected Successfully");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Reject process!");
        }

    }


    public String onDiscountValue(Object DiscType, Object Baserate) {
        BigDecimal ResultVal = new BigDecimal(0);
        String DiscountValue = null;
        String DiscountType = null;

        ViewObject vo =
            ADFUtils.findIterator("DiscountsROVO1Iterator").getViewObject();
        vo.setNamedWhereClauseParam("D_ID", DiscType);
        vo.executeQuery();
        Row re = vo.first();
        if (vo.getEstimatedRowCount() > 0) {
            String OfferAmnt = Baserate == null ? "0" : Baserate.toString();
            DiscountValue =
                    re.getAttribute("DiscountValue") == null ? "0" : re.getAttribute("DiscountValue").toString();
            DiscountType =
                    re.getAttribute("DiscountType") == null ? "0" : re.getAttribute("DiscountType").toString();
            BigDecimal TotalPercentage = new BigDecimal(100);
            BigDecimal DisValue = new BigDecimal(DiscountValue);
            BigDecimal OfrAmnt = new BigDecimal(OfferAmnt);

            if (DiscountType.equals("%")) {
                ResultVal =
                        OfrAmnt.subtract((DisValue.multiply(OfrAmnt)).divide(TotalPercentage));

                if (DisValue.equals(new BigDecimal(100))) {
                    ResultVal = new BigDecimal(0);
                }
            }
            if (DiscountType.equals("CASH")) {
                ResultVal = OfrAmnt.subtract(DisValue);
            }
        }
        return DiscountType + DiscountValue;
    }


    public BigDecimal onDiscount(Object DiscType, Object Baserate) {
        BigDecimal ResultVal = new BigDecimal(0);
        ViewObject vo =
            ADFUtils.findIterator("DiscountsROVO1Iterator").getViewObject();
        vo.setNamedWhereClauseParam("D_ID", DiscType);
        vo.executeQuery();
        Row re = vo.first();
        if (vo.getEstimatedRowCount() > 0) {
            String OfferAmnt = Baserate == null ? "0" : Baserate.toString();
            String DiscountValue =
                re.getAttribute("DiscountValue") == null ? "0" :
                re.getAttribute("DiscountValue").toString();
            String DiscountType =
                re.getAttribute("DiscountType") == null ? "0" :
                re.getAttribute("DiscountType").toString();
            BigDecimal TotalPercentage = new BigDecimal(100);
            BigDecimal DisValue = new BigDecimal(DiscountValue);
            BigDecimal OfrAmnt = new BigDecimal(OfferAmnt);

            if (DiscountType.equals("%")) {
                ResultVal =
                        OfrAmnt.subtract((DisValue.multiply(OfrAmnt)).divide(TotalPercentage));

                if (DisValue.equals(new BigDecimal(100))) {
                    ResultVal = new BigDecimal(0);
                }
            }
            if (DiscountType.equals("CASH")) {
                ResultVal = OfrAmnt.subtract(DisValue);
            }
        }
        return ResultVal;
    }

    public void onChangeDiscountValue(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            onCalculateTotal();
        }
    }

    public void onClickPDFReport(FacesContext facesContext,
                                 java.io.OutputStream outputStream) {

        try {
            Object result = runReport("//reports//Offer Form.rtf");
            outputStream.write((byte[])result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getXMLData(String p_offer_number) throws Exception {
        String retStr = "";
        Context ctx;
        Connection con = null;
        ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("PL");
        con = ds.getConnection();
        String selectSQL =
            "SELECT XXPM_REPORT_PKG.XXPM_OFFER_FORM('" + p_offer_number +
            "') xml FROM dual";
        //        System.err.println("Query " + selectSQL);
        PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
        ResultSet rs1 = preparedStatement.executeQuery(selectSQL);
        while (rs1.next()) {
            retStr = rs1.getString("xml");
            //            System.err.println("XML O/P" + rs1.getString("xml"));
        }
        return retStr;
    }

    public byte[] runReport(String templateFile) {

        byte[] dataBytes = null;

        try {
            ViewObject quoteVO =
                ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
            Row re = quoteVO.getCurrentRow();
            String quoteNumber =
                re.getAttribute("OfferNumber") == null ? "" : re.getAttribute("OfferNumber").toString();
            ServletContext context = getContext();
            InputStream fs = context.getResourceAsStream(templateFile);
            RTFProcessor rtfp = new RTFProcessor(fs);
            ByteArrayOutputStream xslOutStream = new ByteArrayOutputStream();
            rtfp.setOutput(xslOutStream);
            rtfp.process();

            ByteArrayInputStream xslInStream =
                new ByteArrayInputStream(xslOutStream.toByteArray());

            FOProcessor processor = new FOProcessor();
            ByteArrayInputStream dataStream =

                new ByteArrayInputStream((getXMLData(quoteNumber).getBytes()));

            processor.setData(dataStream);
            processor.setTemplate(xslInStream);

            ByteArrayOutputStream pdfOutStream = new ByteArrayOutputStream();
            processor.setOutput(pdfOutStream);
            byte outFileTypeByte = FOProcessor.FORMAT_PDF;
            processor.setOutputFormat(outFileTypeByte);
            processor.generate();

            dataBytes = pdfOutStream.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            //            System.err.println("ERROR" + e.toString());

        }
        return dataBytes;
    }

    public ServletContext getContext() {
        return (ServletContext)getFacesContext().getExternalContext().getContext();
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public void onSelectLease(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());

        deleteAllRows();

        if (valueChangeEvent.getNewValue() != "") {
            ViewObject offerhdr =
                ADFUtils.findIterator("OfferHrd_VO2Iterator").getViewObject();
            ViewObject offerDtl3 =
                ADFUtils.findIterator("OfferDetail_VO3Iterator").getViewObject();
            ViewObject LeadVO =
                ADFUtils.findIterator("LeadVO1Iterator").getViewObject();
            //      --------------------------------------------------------------------------------
            String leaseid =
                valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
            //            System.err.println("===Lease Id=="+leaseid);
            JSFUtils.setExpressionValue("#{pageFlowScope.leaseNumber}",
                                        leaseid);
            ViewObject offervo =
                ADFUtils.findIterator("GetOfferId_ROVO1Iterator").getViewObject();
            offervo.setNamedWhereClauseParam("LEid", leaseid);
            offervo.executeQuery();

            if (offervo.getEstimatedRowCount() > 0) {
                Row r = offervo.first();
                r.getAttribute("OfferHdrId");

                //        JSFUtils.addFacesInformationMessage("offerid"+r.getAttribute("OfferHdrId"));
                //        ---------------------------------------------------------------------------------

                ViewCriteria vc = offerhdr.createViewCriteria();
                ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                vcRow.setAttribute("OfferHdrId", r.getAttribute("OfferHdrId"));
                vc.addRow(vcRow);
                offerhdr.applyViewCriteria(vc);
                offerhdr.executeQuery();
                Row offhdrRw = offerhdr.first();
                ViewCriteria vcss = LeadVO.createViewCriteria();
                ViewCriteriaRow vcRowe = vcss.createViewCriteriaRow();
                vcRowe.setAttribute("LeadId", offhdrRw.getAttribute("LeadId"));
                vcss.addRow(vcRowe);
                LeadVO.applyViewCriteria(vcss);
                LeadVO.executeQuery();
                Row leadrw = LeadVO.first();
                offerHrdVO.getCurrentRow().setAttribute("Trans_LeadNumber",
                                                        leadrw.getAttribute("LeadNumber"));
                offerHrdVO.getCurrentRow().setAttribute("LeadId",
                                                        leadrw.getAttribute("LeadId"));
                offerHrdVO.getCurrentRow().setAttribute("MsHdrId",
                                                        offhdrRw.getAttribute("MsHdrId"));
                offerHrdVO.getCurrentRow().setAttribute("NetOfferAmount",
                                                        offhdrRw.getAttribute("NetOfferAmount"));
                OnProcessRenwalDate(offhdrRw.getAttribute("OfferToDate"));
                offerHrdVO.getCurrentRow().setAttribute("OfferType",
                                                        offhdrRw.getAttribute("OfferType"));
                offerHrdVO.getCurrentRow().setAttribute("OrgId",
                                                        offhdrRw.getAttribute("OrgId"));
                offerHrdVO.getCurrentRow().setAttribute("PlId",
                                                        offhdrRw.getAttribute("PlId"));
                offerHrdVO.getCurrentRow().setAttribute("Attribute4",null);
                //on 03-Sep-2020 for updated new PL in case of Renewal and short renewal
//                ViewObject plLinesVo =
//                            ADFUtils.findIterator("PlLinesVO1Iterator").getViewObject();
//                        ViewCriteria plLinesVovcR = plLinesVo.createViewCriteria();
//                        ViewCriteriaRow plLinesVovcRRow = plLinesVovcR.createViewCriteriaRow();
//                                System.err.println("PropertyId" + offhdrRw.getAttribute("PropertyId"));
//                                System.err.println("BuildingId" + offhdrRw.getAttribute("BuildingId"));
//                                System.err.println("PlId" + offhdrRw.getAttribute("PlId"));
////                                System.err.println("UnitId based on current row :" + offerDtl3.getCurrentRow().getAttribute("UnitId"));
//                        plLinesVovcRRow.setAttribute("PropertyId", offhdrRw.getAttribute("PropertyId") == null ? "" : offhdrRw.getAttribute("PropertyId"));
//                        plLinesVovcRRow.setAttribute("BuildId", offhdrRw.getAttribute("BuildingId") == null ? "" : offhdrRw.getAttribute("BuildingId"));
////                        plLinesVovcRRow.setAttribute("UnitId", offerDtl3.getCurrentRow().getAttribute("UnitId") == null ? "" : offerDtl3.getCurrentRow().getAttribute("UnitId"));
//                        plLinesVovcRRow.setAttribute("PlId", offhdrRw.getAttribute("PlId") == null ? "" : offhdrRw.getAttribute("PlId"));
//                        plLinesVovcR.addRow(plLinesVovcRRow);
//                        plLinesVo.applyViewCriteria(plLinesVovcR);
//                        plLinesVo.executeQuery();
//                        long ioo = plLinesVo.getEstimatedRowCount();
//                          System.err.println("1st estimationrowCount" + ioo);
//                        if (plLinesVo.getEstimatedRowCount()==0) {
//                            System.err.println("1nst inside estimationrowCount" + ioo);
//                            Row re = plLinesVo.first();
//                
//                ViewObject plHdrVo =
//                            ADFUtils.findIterator("PlHeader_VO1Iterator").getViewObject();
//                        ViewCriteria plHdrVoVc = plHdrVo.createViewCriteria();
//                        ViewCriteriaRow plHdrVoVcR = plHdrVoVc.createViewCriteriaRow();
//                        plHdrVoVcR.setAttribute("PlId", offhdrRw.getAttribute("PlId") == null ? "" : offhdrRw.getAttribute("PlId").toString());
//                        plHdrVoVc.addRow(plHdrVoVcR);
//                        plHdrVo.applyViewCriteria(plHdrVoVc);
//                        plHdrVo.executeQuery();
//                if (plHdrVo.getEstimatedRowCount()>0) {
//                     Row plHdrVoRow = plHdrVo.first();
//                     String plName = plHdrVoRow.getAttribute("PlName")==null ? "" : plHdrVoRow.getAttribute("PlName").toString();
//                     System.out.println("PL name :"+plName);
//                     ViewObject lookUpVo = ADFUtils.findIterator("PlHeader_VO1Iterator").getViewObject();
//                     ViewCriteria vC = lookUpVo.createViewCriteria();
//                     ViewCriteriaRow vCRow = vC.createViewCriteriaRow();
//                     vCRow.setAttribute("PlName", plName);
//                     vCRow.setAttribute("PlId", "not like "+offhdrRw.getAttribute("PlId") == null ? "" : offhdrRw.getAttribute("PlId"));
//                     vC.addRow(vCRow);
//                     lookUpVo.applyViewCriteria(vC);
//                     lookUpVo.executeQuery();
//                     if (lookUpVo.getEstimatedRowCount() > 0) { 
//                         Row lookUpVoRow = lookUpVo.first();
//                         String lookupValueDisp = lookUpVoRow.getAttribute("PlId").toString();
//                         System.out.println("lookupValueDisp :"+lookupValueDisp);
//                         offerHrdVO.getCurrentRow().setAttribute("PlId", lookupValueDisp);
//                                }            
//                else{
//                         System.out.println("1st else");
//                     offerHrdVO.getCurrentRow().setAttribute("PlId", offhdrRw.getAttribute("PlId"));
//            }
//                }
//                        }else{
//                            System.out.println("2nd else");
//                            offerHrdVO.getCurrentRow().setAttribute("PlId",
//                                                                    offhdrRw.getAttribute("PlId"));    
//                        }
//                System.out.println("Finally PlId ::"+offerHrdVO.getCurrentRow().getAttribute("PlId"));  
                //
                offerHrdVO.getCurrentRow().setAttribute("Currency",
                                                        offhdrRw.getAttribute("Currency"));
                offerHrdVO.getCurrentRow().setAttribute("OfferTotal",
                                                        offhdrRw.getAttribute("OfferTotal"));
                offerHrdVO.getCurrentRow().setAttribute("Terms",
                                                        offhdrRw.getAttribute("Terms"));
                offerHrdVO.getCurrentRow().setAttribute("Checklist",
                                                        offhdrRw.getAttribute("Checklist"));
//24-May-2020 for lease type and car park lease id
                offerHrdVO.getCurrentRow().setAttribute("LeaseType",
                                                        offhdrRw.getAttribute("LeaseType"));
                String leaseTyp = offhdrRw.getAttribute("LeaseType").toString();
                System.out.println("Lease type : "+leaseTyp);
                if(leaseTyp.equalsIgnoreCase("CAR_PARKING")){
                    if(offhdrRw.getAttribute("CarParkLeaseAgreId") != null){
                    offerHrdVO.getCurrentRow().setAttribute("CarParkLeaseAgreId",
                                                            offhdrRw.getAttribute("CarParkLeaseAgreId"));
                    }
                }

                RowSetIterator OfferDtlRS =
                    offerDtl3.createRowSetIterator(null);
                while (OfferDtlRS.hasNext()) {
                    Row OfferDtlRow = OfferDtlRS.next();
                    // inserting Row
                    Row offerLnsRow = offerLnsVO.createRow();
                    offerLnsRow.setAttribute("PropertyId",
                                             OfferDtlRow.getAttribute("PropertyId"));
                    offerLnsRow.setAttribute("BuildingId",
                                             OfferDtlRow.getAttribute("BuildingId"));
                    offerLnsRow.setAttribute("UnitId",
                                             OfferDtlRow.getAttribute("UnitId"));
                    offerLnsRow.setAttribute("Purpose",
                                             OfferDtlRow.getAttribute("Purpose"));
                    offerLnsRow.setAttribute("Uom",
                                             OfferDtlRow.getAttribute("Uom"));
                    //25-May-2020  for unit map in case of car parking
                    if(OfferDtlRow.getAttribute("LeaseUnitMap")!=null){
                        offerLnsRow.setAttribute("LeaseUnitMap",
                                                 OfferDtlRow.getAttribute("LeaseUnitMap")); 
                    }
                    //
                    //12-May-2020 for handling base price in case of renewal after short renewal
                    if (offerHrdVO.getCurrentRow().getAttribute("OfferFlag").toString().equals("R")){
                    String st = offhdrRw.getAttribute("OfferFromDate")==null ? "" : offhdrRw.getAttribute("OfferFromDate").toString();
                    String en = offhdrRw.getAttribute("OfferToDate")==null ? "" : offhdrRw.getAttribute("OfferToDate").toString();
                    java.util.Date dateF;
                    java.util.Date dateT;
                    try {         
                         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                         dateF = formatter.parse(st);
                            dateT = formatter.parse(en);
                         java.sql.Date sqlDateF = new java.sql.Date(dateF.getTime());
                         java.sql.Date sqlDateT = new java.sql.Date(dateT.getTime());
                         oracle.jbo.domain.Date jboDateF = new oracle.jbo.domain.Date(sqlDateF);
                         oracle.jbo.domain.Date jboDateT = new oracle.jbo.domain.Date(sqlDateT);        
                     
//                    oracle.jbo.domain.Date st = (oracle.jbo.domain.Date)id4.getValue();
//                    oracle.jbo.domain.Date en = (oracle.jbo.domain.Date)id6.getValue();
                    System.out.println("st date and end date : "+jboDateF+ " "+jboDateT);
                    long ndays = getDifferenceDaysBetweenTwoDates(jboDateF, jboDateT);
                        int nodays = (int)ndays;
                        if (offerHrdVO.getCurrentRow().getAttribute("OfferFlag").toString().equals("R") && nodays < 363){ 
                            ViewObject vo =
                                    ADFUtils.findIterator("LeaseOffer_detail_RoVo1Iterator").getViewObject();
                                    System.out.println("Lead ID :"+offerHrdVO.getCurrentRow().getAttribute("LeadId") == null ? "" : offerHrdVO.getCurrentRow().getAttribute("LeadId").toString());
                                    System.out.println("OfferFlag :"+offerHrdVO.getCurrentRow().getAttribute("OfferFlag") == null ? "" : offerHrdVO.getCurrentRow().getAttribute("OfferFlag").toString());  
                                    System.out.println("Unit ID :"+OfferDtlRow.getAttribute("UnitId") == null ? "" : OfferDtlRow.getAttribute("UnitId").toString());
                                            ViewCriteria vCriteria = vo.createViewCriteria();
                                            ViewCriteriaRow vCriteriaRow = vCriteria.createViewCriteriaRow();
                                            vCriteriaRow.setAttribute("LeadId", offerHrdVO.getCurrentRow().getAttribute("LeadId") == null ? "" : offerHrdVO.getCurrentRow().getAttribute("LeadId").toString());
                                            vCriteriaRow.setAttribute("OfferFlag", "not like 'S'");
                                            vCriteriaRow.setAttribute("UnitId", OfferDtlRow.getAttribute("UnitId") == null ? "" : OfferDtlRow.getAttribute("UnitId").toString());
                                            vCriteria.addRow(vCriteriaRow);
                                            vo.applyViewCriteria(vCriteria);
                                            vo.executeQuery();
                                            System.out.println("Estimated lease offer rovo count :"+vo.getEstimatedRowCount());
                                            if (vo.getEstimatedRowCount() > 0){
                                            System.out.println("BaseRate lease offer rovo :"+vo.first().getAttribute("BaseRate"));
                            offerLnsRow.setAttribute("BaseRate", vo.first().getAttribute("BaseRate"));
                        }
                    }
                        else{                   
                    offerLnsRow.setAttribute("BaseRate",
                                             OfferDtlRow.getAttribute("BaseRate"));
                        }
                    } catch (ParseException e) {           
                     e.printStackTrace();
                    }
                    }else {
                        offerLnsRow.setAttribute("BaseRate",
                                                 OfferDtlRow.getAttribute("BaseRate"));
                    }
//                    offerLnsRow.setAttribute("DiscountAmount",
//                                             OfferDtlRow.getAttribute("DiscountAmount"));
                    //21-Sep-2020 for viewing associated LA discount and net rate
                    offerLnsRow.setAttribute("Attribute1",
                                             OfferDtlRow.getAttribute("DiscountAmount"));
                    offerLnsRow.setAttribute("Attribute2",
                                             OfferDtlRow.getAttribute("TotalRate"));
                    //
                    offerLnsRow.setAttribute("TaxAmount",
                                             OfferDtlRow.getAttribute("TaxAmount"));
                    offerLnsRow.setAttribute("TotalRate",
                                             OfferDtlRow.getAttribute("TotalRate"));
                    offerLnsRow.setAttribute("SetRentPerAnnum",
                                             OfferDtlRow.getAttribute("SetRentPerAnnum"));

                    offerLnsRow.setAttribute("MunicipalityCharges",
                                             OfferDtlRow.getAttribute("MunicipalityCharges") ==
                                             null ? "" :
                                             OfferDtlRow.getAttribute("MunicipalityCharges"));

                    offerLnsRow.setAttribute("ElectricityCharges",
                                             OfferDtlRow.getAttribute("ElectricityCharges") ==
                                             null ? "" :
                                             OfferDtlRow.getAttribute("ElectricityCharges"));

                    //                    offerLnsRow.setAttribute("SecurityDeposite",
                    //                                             OfferDtlRow.getAttribute("SecurityDeposite") ==
                    //                                             null ? "" :
                    //                                             OfferDtlRow.getAttribute("SecurityDeposite"));

                    offerLnsRow.setAttribute("MunicipalityPercentage",
                                             OfferDtlRow.getAttribute("MunicipalityPercentage") ==
                                             null ? "" :
                                             OfferDtlRow.getAttribute("MunicipalityPercentage"));

                    offerLnsRow.setAttribute("EjariPaymentCharge",
                                             OfferDtlRow.getAttribute("EjariPaymentCharge") ==
                                             null ? "" :
                                             OfferDtlRow.getAttribute("EjariPaymentCharge"));
                    offerLnsRow.setAttribute("ThirdPartyServCharge",
                                             OfferDtlRow.getAttribute("ThirdPartyServCharge") ==
                                             null ? "" :
                                             OfferDtlRow.getAttribute("ThirdPartyServCharge"));
                    offerLnsRow.setAttribute("OtherGovntChargeNew",
                                             OfferDtlRow.getAttribute("OtherGovntChargeNew") ==
                                             null ? "" :
                                             OfferDtlRow.getAttribute("OtherGovntChargeNew"));
                    offerLnsRow.setAttribute("OtherGovntChargeRnew",
                                             OfferDtlRow.getAttribute("OtherGovntChargeRnew") ==
                                             null ? "" :
                                             OfferDtlRow.getAttribute("OtherGovntChargeRnew"));
                    offerLnsVO.insertRow(offerLnsRow);
                }
                offerLnsVO.executeQuery();
                OnValidateMilestoneProcess(offhdrRw.getAttribute("MsHdrId"));
                onRetriveOtherPayments(r.getAttribute("OfferHdrId"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(t6);

                //notification for renewal of car parking if it is there
                Row row = offerhdr.getCurrentRow();
                ViewObject leaseAgrVo =
                    ADFUtils.findIterator("LeaseAgreement_VO2Iterator").getViewObject();
                ViewCriteria viewC = leaseAgrVo.createViewCriteria();
                ViewCriteriaRow viewCRow = viewC.createViewCriteriaRow();
                viewCRow.setAttribute("LeaseNumber",
                                      this.getLeaseNumber_TransId().getValue());
                viewC.addRow(viewCRow);
                leaseAgrVo.applyViewCriteria(viewC);
                leaseAgrVo.executeQuery();
                //                System.out.println("count "+leaseAgrVo.getEstimatedRowCount());
                if (leaseAgrVo.getEstimatedRowCount() > 0) {
                    Row rw = leaseAgrVo.first();
                    rw.getAttribute("CarParkLeaseAgreId");
                    if (rw.getAttribute("CarParkLeaseAgreId") != null) {
                        JSFUtils.addFacesInformationMessage("There is a Car Parking Unit associated with this Lease Number !!! ");
                    }

                }

            }


        } else {

            offerHrdVO.getCurrentRow().setAttribute("LeadId", null);
            offerHrdVO.getCurrentRow().setAttribute("MsHdrId", null);
            offerHrdVO.getCurrentRow().setAttribute("NetOfferAmount", null);
            offerHrdVO.getCurrentRow().setAttribute("OfferFromDate", null);
            offerHrdVO.getCurrentRow().setAttribute("OfferToDate", null);
            offerHrdVO.getCurrentRow().setAttribute("OfferType", null);
            offerHrdVO.getCurrentRow().setAttribute("OrgId", null);
            offerHrdVO.getCurrentRow().setAttribute("PlId", null);
            offerHrdVO.getCurrentRow().setAttribute("Currency", null);
            offerHrdVO.getCurrentRow().setAttribute("OfferTotal", null);
            offerHrdVO.getCurrentRow().setAttribute("Terms", null);
            offerHrdVO.getCurrentRow().setAttribute("Checklist", null);

            if (offerLnsVO.getEstimatedRowCount() > 0) {
                RowSetIterator OfferDtlRS =
                    offerLnsVO.createRowSetIterator(null);
                while (OfferDtlRS.hasNext()) {
                    Row OfferDtlRow = OfferDtlRS.next();
                    OfferDtlRow.remove();
                }
            }
            if (offerMilesDtlsVO.getEstimatedRowCount() > 0) {
                RowSetIterator OfferMsDtlRS =
                    offerMilesDtlsVO.createRowSetIterator(null);
                while (OfferMsDtlRS.hasNext()) {
                    Row offerMsDtl3Row = OfferMsDtlRS.next();
                    offerMsDtl3Row.remove();
                }
            }
        }
    }

    public void onChangeleaseid(ValueChangeEvent valueChangeEvent) {

    }

    public void onClickchecklist(ActionEvent actionEvent) {
        ViewObject quoteVO =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row row = quoteVO.getCurrentRow();
        JSFUtils.setExpressionValue("#{pageFlowScope.offfuncid}", 6);
        JSFUtils.setExpressionValue("#{pageFlowScope.offfuncrefid}",
                                    row.getAttribute("OfferHdrId"));
        JSFUtils.setExpressionValue("#{pageFlowScope.offlookup}",
                                    row.getAttribute("Checklist"));
    }


    public void onAddOtherPaymentsusingMap(Map<Object, Object> map) {
        ViewObject quoteVO =
            ADFUtils.findIterator("OfferMilestoneDetail_VO5Iterator").getViewObject();

        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object Chargetype = entry.getKey();
            Object Amount = entry.getValue();
            ViewCriteria vcss = quoteVO.createViewCriteria();
            ViewCriteriaRow vcRowe = vcss.createViewCriteriaRow();
            vcRowe.setAttribute("InstallmentType1", Chargetype);
            vcss.addRow(vcRowe);
            quoteVO.applyViewCriteria(vcss);
            quoteVO.executeQuery();
            if (Amount.equals("0")) {

            } else {
                if (quoteVO.getEstimatedRowCount() > 0) {
                    quoteVO.first().setAttribute("InstallmentAmount", Amount);

                } else {
                    Row offerMsLnsRow = quoteVO.createRow();
                    offerMsLnsRow.setAttribute("InstallmentType1", Chargetype);
                    offerMsLnsRow.setAttribute("InstallmentAmount", Amount);
                    offerMsLnsRow.setAttribute("MsDtlId", 1);
                    offerMsLnsRow.setAttribute("MilestoneType", "OC");
                    quoteVO.insertRow(offerMsLnsRow);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.t6);
                }
            }
        }
    }


    public void onAddOtherPayments(Object Chargetype, Object Amount) {
        if (Amount.equals("0")) {

        } else {
            ViewObject BquoteVO =
                ADFUtils.findIterator("OfferMilestoneDetail_VO5Iterator").getViewObject();
            Row offerMsLnsRow = BquoteVO.createRow();
            offerMsLnsRow.setAttribute("InstallmentType1", Chargetype);
            offerMsLnsRow.setAttribute("InstallmentAmount", Amount);
            offerMsLnsRow.setAttribute("Attribute2", "0");
            offerMsLnsRow.setAttribute("Attribute3", "0");
            offerMsLnsRow.setAttribute("Attribute4", Amount);
            offerMsLnsRow.setAttribute("MsDtlId", 1);
            offerMsLnsRow.setAttribute("MilestoneType", "OC");
            BquoteVO.insertRow(offerMsLnsRow);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.t6);
        }
    }

    public void onCalculateOtherTotalChargesUsingMap(HashMap<String, String> map) {
        ViewObject vo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        if (vo.getEstimatedRowCount() > 0) {
            RowSetIterator mileDtlRs = vo.createRowSetIterator(null);
            BigDecimal Total = new BigDecimal(0);
            Map<Object, Object> mapsss = new HashMap<Object, Object>();

            for (Map.Entry<String, String> entry : map.entrySet()) {
                String Attribute = entry.getKey();
                String Type = entry.getValue();
                while (mileDtlRs.hasNext()) {
                    Row mileDtlRow = mileDtlRs.next();
                    String tot =
                        mileDtlRow.getAttribute(Attribute) == null ? "0" :
                        mileDtlRow.getAttribute(Attribute).toString();
                    Total = Total.add(new BigDecimal(tot));
                }
                String Totamnt = Total.toString();
                Object Amnt = Totamnt;
                Object Chrgetype = Type;
                if (Total.equals(0)) {
                } else {
                    mapsss.put(Chrgetype, Amnt);
                    onAddOtherPaymentsusingMap(mapsss);
                }
            }
        }
    }

    public void onCalculateOtherTotalCharges(String Attribute, String Type) {
        ViewObject vo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        if (vo.getEstimatedRowCount() > 0) {
            RowSetIterator mileDtlRs = vo.createRowSetIterator(null);
            BigDecimal Total = new BigDecimal(0);
            while (mileDtlRs.hasNext()) {
                Row mileDtlRow = mileDtlRs.next();
                String tot =
                    mileDtlRow.getAttribute(Attribute) == null ? "0" : mileDtlRow.getAttribute(Attribute).toString();
                Total = Total.add(new BigDecimal(tot));
            }
            String Totamnt = Total.toString();
            Object Amnt = Totamnt;
            Object Chrgetype = Type;
            if (Total.equals(0)) {
            } else {
                onAddOtherPayments(Chrgetype, Amnt);
            }
        }
    }

    public void onClickOfferLineCal(ActionEvent actionEvent) {
        if (offerLnsVO.getEstimatedRowCount() > 0) {
            onCalculateTotal();
            onClickCalculates();
            String noCalc = ADFContext.getCurrent().getPageFlowScope().get("handleCalcSavButton")==null ? "" : ADFContext.getCurrent().getPageFlowScope().get("handleCalcSavButton").toString();
            if(noCalc.equalsIgnoreCase("NO_CALC")){
                System.out.println("Under if No calculation");
            }else{
            ClearLines();
            list = new ArrayList<Object>();
            list = ValidateOtherChargeTypes();

//            onCalculateOtherTotalCharges("MunicipalityCharges", "MC");
//            String orgId = offerhdr.getCurrentRow().getAttribute("OrgId")==null?"":offerhdr.getCurrentRow().getAttribute("OrgId").toString();
////                if(orgId.equals("300000001937026")){
////                    onCalculateOtherTotalCharges("SecurityDeposite", "SEC_DEP_SHJ");
////                }
////                if(orgId.equals("300000001937102")){
////                    onCalculateOtherTotalCharges("SecurityDeposite", "SEC_DEP_DXB");
////                }else{
////                    onCalculateOtherTotalCharges("SecurityDeposite", "SEC_DEP");
////                }
//            onCalculateOtherTotalCharges("SecurityDeposite", "SEC_DEP");
//            onCalculateOtherTotalCharges("ElectricityCharges", "DEWA");
//            onCalculateOtherTotalCharges("OtherGovntChargeNew",
//                                         "OTHER_GOVNT_NEW");
//            onCalculateOtherTotalCharges("ThirdPartyServCharge", "TPC");
//            onCalculateOtherTotalCharges("OtherGovntChargeRnew",
//                                         "OTHER_GOVNT_RNEW");
//            onCalculateOtherTotalCharges("EjariPaymentCharge",
//                                         "EJARI_PAYMENT");
            }
        }


    }

    public void onChangeBU(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ADFContext.getCurrent().getPageFlowScope().put("Buid",
                                                       valueChangeEvent.getNewValue());

    }

    public void onClickCancel(ActionEvent actionEvent) {
        ADFUtils.findOperation("Rollback").execute();
    }

    public void onClickAddOfferLine(ActionEvent actionEvent) {
        ViewObject offerHrdVO =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        ViewObject offerDtlVO =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        //        System.err.println("offerHrdVO.getCurrentRow().getAttribute(\"PlId\")" +
        //                           offerHrdVO.getCurrentRow().getAttribute("PlId"));
        String Plid =
            offerHrdVO.getCurrentRow().getAttribute("PlId") == null ? "" :
            offerHrdVO.getCurrentRow().getAttribute("PlId").toString();
        String MsHdrId =
            offerHrdVO.getCurrentRow().getAttribute("MsHdrId") == null ? "" :
            offerHrdVO.getCurrentRow().getAttribute("MsHdrId").toString();
        if (Plid != "") {
            if (MsHdrId != "") {
               
                ADFUtils.findOperation("CreateInsert").execute();
                //
                if (offerDtlVO.getEstimatedRowCount()==1){
                    offerDtlVO.getCurrentRow().setAttribute("PrimaryUnit", "Y");
                }
                if(offerHrdVO.getCurrentRow().getAttribute("OfferType") != null){
                String purpose =
                    offerHrdVO.getCurrentRow().getAttribute("OfferType").toString();
                System.out.println("Offer type :"+purpose);
                if(purpose != null){
                    System.out.println("Offer type inside :"+purpose);
                    System.out.println("Offer id :"+offerDtlVO.getCurrentRow().getAttribute("OfferHdrId"));
                offerDtlVO.getCurrentRow().setAttribute("Purpose", purpose);
                }
                }
            } else {
                JSFUtils.addFacesErrorMessage("Payment Plan Required");
            }
        } else {
            JSFUtils.addFacesErrorMessage("Price List Required");
        }


    }

    public void onRetriveOtherPayments(Object offerHdrid) {

        ViewCriteria vcss = milesOtherVo6.createViewCriteria();
        ViewCriteriaRow vcRowe = vcss.createViewCriteriaRow();
        vcRowe.setAttribute("OfferHdrId", offerHdrid);
        vcRowe.setAttribute("MilestoneType", "OC");
        vcss.addRow(vcRowe);
        milesOtherVo6.applyViewCriteria(vcss);
        milesOtherVo6.executeQuery();
        if (milesOtherVo6.getEstimatedRowCount() > 0) {
            RowSetIterator mileDtlRs =
                milesOtherVo6.createRowSetIterator(null);
            while (mileDtlRs.hasNext()) {
                Row mileDtlRow = mileDtlRs.next();
                //                Row offerMileStoneDtlRows = milesOtherVo.createRow();
                // for removing security deposit on renewal from other charges
                String securityDeposit =
                    mileDtlRow.getAttribute("InstallmentType1").toString();
                System.out.println("security deposit " + securityDeposit);
                if (!securityDeposit.equals("SEC_DEP")) {
//                    Row offerMileStoneDtlRows = milesOtherVo.createRow();
//                    offerMileStoneDtlRows.setAttribute("OfferHdrId",
//                                                       offerHrdVO.getCurrentRow().getAttribute("OfferHdrId"));
//                    System.out.println("security deposit inside " +
//                                       securityDeposit);
//                    offerMileStoneDtlRows.setAttribute("InstallmentType1",
//                                                       mileDtlRow.getAttribute("InstallmentType1"));
//                    offerMileStoneDtlRows.setAttribute("InstallmentAmount",
//                                                       mileDtlRow.getAttribute("InstallmentAmount"));
//
//                    offerMileStoneDtlRows.setAttribute("MsDtlId", 1);
//                    offerMileStoneDtlRows.setAttribute("MilestoneType", "OC");
//                    offerMileStoneDtlRows.setAttribute("Remarks",
//                                                       mileDtlRow.getAttribute("Remarks"));
//                    milesOtherVo.insertRow(offerMileStoneDtlRows);
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t6);
        }
    }


    public Object OnValidateMilestoneProcess(Object MshDrId) {
        String OffHrdId =
            offerHrdVO.getCurrentRow().getAttribute("OfferHdrId") == null ?
            "" :
            offerHrdVO.getCurrentRow().getAttribute("OfferHdrId").toString();
        if (MshDrId != null && OffHrdId != null) {
            // Filtering MileStone Detail
            findMileSDtlVO.setNamedWhereClauseParam("BV_MS_HR_ID", MshDrId);
            findMileSDtlVO.executeQuery();
            // Count not equal to 0
            if (findMileSDtlVO.getEstimatedRowCount() != 0) {
                // MileStone Detail Iterator
                RowSetIterator mileDtlRs =
                    findMileSDtlVO.createRowSetIterator(null);
                while (mileDtlRs.hasNext()) {
                    Row mileDtlRow = mileDtlRs.next();
                    // Create New row in offer Milestone Detail
                    Row offerMileStoneDtlRow = offerMilesDtlsVO.createRow();
                    offerMileStoneDtlRow.setAttribute("OfferHdrId", OffHrdId);
                    offerMileStoneDtlRow.setAttribute("MsDtlId",
                                                      mileDtlRow.getAttribute("MsDtlId"));
                    offerMileStoneDtlRow.setAttribute("SeqNumber",
                                                      mileDtlRow.getAttribute("SeqNumber"));
                    offerMileStoneDtlRow.setAttribute("InstallmentType",
                                                      mileDtlRow.getAttribute("InstallmentType"));
                    offerMileStoneDtlRow.setAttribute("InstallmentPct",
                                                      mileDtlRow.getAttribute("InstallmentPct"));
                    offerMileStoneDtlRow.setAttribute("Criteria",
                                                      mileDtlRow.getAttribute("Criteria"));
                    offerMileStoneDtlRow.setAttribute("ChargeType",
                                                      mileDtlRow.getAttribute("ChargeType"));
                    offerMileStoneDtlRow.setAttribute("PaymentTerm",
                                                      mileDtlRow.getAttribute("PaymentTerm"));
                    String val =
                        validateDays(mileDtlRow.getAttribute("NoOfDays")) ==
                        null ? "" :
                        validateDays(mileDtlRow.getAttribute("NoOfDays")).toString();
                    if (val != "") {
                        try {
                            Date date1 =
                                new SimpleDateFormat("dd/MM/yyyy").parse(val);

                            java.sql.Date sqlDate =
                                new java.sql.Date(date1.getTime());
                            oracle.jbo.domain.Date domadate =
                                new oracle.jbo.domain.Date(sqlDate);
                            offerMileStoneDtlRow.setAttribute("DueDate",
                                                              domadate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    offerMileStoneDtlRow.setAttribute("Remarks",
                                                      mileDtlRow.getAttribute("Remarks"));
                    offerMilesDtlsVO.insertRow(offerMileStoneDtlRow);
                }
                AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
            }
        }
        return "Success";
    }
    //to handle due date
    public Object OnValidateMilestoneProcessDueDate(Object MshDrId) {
        String OffHrdId =
            offerHrdVO.getCurrentRow().getAttribute("OfferHdrId") == null ?
            "" :
            offerHrdVO.getCurrentRow().getAttribute("OfferHdrId").toString();
        if (MshDrId != null && OffHrdId != null) {
            // Filtering MileStone Detail
            findMileSDtlVO.setNamedWhereClauseParam("BV_MS_HR_ID", MshDrId);
            findMileSDtlVO.executeQuery();
            // Count not equal to 0
            if (findMileSDtlVO.getEstimatedRowCount() != 0) {
                // MileStone Detail Iterator
                RowSetIterator mileDtlRs =
                    findMileSDtlVO.createRowSetIterator(null);
                while (mileDtlRs.hasNext()) {
                    Row mileDtlRow = mileDtlRs.next();
                    String seqNo1 = mileDtlRow.getAttribute("SeqNumber")==null?"":mileDtlRow.getAttribute("SeqNumber").toString();
            //
                    RowSetIterator ofMsdRs = offerMilesDtlsVO.createRowSetIterator(null);    
                    while (ofMsdRs.hasNext()) {
                        Row ofMsdRsRw = ofMsdRs.next();
                        String seqNo2 = ofMsdRsRw.getAttribute("SeqNumber")==null?"":ofMsdRsRw.getAttribute("SeqNumber").toString();
                        if(seqNo1.equals(seqNo2)){
                            String val =
                                validateDays(mileDtlRow.getAttribute("NoOfDays")) ==
                                null ? "" :
                                validateDays(mileDtlRow.getAttribute("NoOfDays")).toString();
                            if (val != "") {
                                try {
                                    Date date1 =
                                        new SimpleDateFormat("dd/MM/yyyy").parse(val);

                                    java.sql.Date sqlDate =
                                        new java.sql.Date(date1.getTime());
                                    oracle.jbo.domain.Date domadate =
                                        new oracle.jbo.domain.Date(sqlDate);
                                    ofMsdRsRw.setAttribute("DueDate", domadate);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    ofMsdRs.closeRowSetIterator();
                }
                AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
            }
        }
        return "Success";
    }

    public void onclickAppOrRej(ActionEvent actionEvent) {
        Object val =
            ADFContext.getCurrent().getPageFlowScope().get("Action") == null ?
            "" :
            ADFContext.getCurrent().getPageFlowScope().get("Action").toString();
        if (val.equals("Approval")) {
            onClickApprove(actionEvent);
        }
        if (val.equals("Rejection")) {
            onClickReject(actionEvent);
        }
    }

    public void setReason(RichInputText reason) {
        this.reason = reason;
    }

    public RichInputText getReason() {
        return reason;
    }

    public void onInvokeAppOrrejec(ActionEvent actionEvent) {
//        doSendMailOnSubmit();
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup3().show(popup34);
    }

    public void setPopup3(RichPopup popup3) {
        this.popup3 = popup3;
    }

    public RichPopup getPopup3() {
        return popup3;
    }

    public void setT6(RichTable t6) {
        this.t6 = t6;
    }

    public RichTable getT6() {
        return t6;
    }


    public ArrayList<Object> ValidateOtherChargeTypes() {
        ViewObject quoteVO =
            ADFUtils.findIterator("OfferMilestoneDetail_VO5Iterator").getViewObject();
        ArrayList<Object> list = new ArrayList<Object>();
        RowSetIterator mileDtlRs = quoteVO.createRowSetIterator(null);
        while (mileDtlRs.hasNext()) {
            Row mileDtlRow = mileDtlRs.next();
            list.add(mileDtlRow.getAttribute("InstallmentType1"));
        }
        return list;
    }


    public void ClearLines() {
        ViewObject quoteVO =
            ADFUtils.findIterator("OfferMilestoneDetail_VO5Iterator").getViewObject();
        RowSetIterator mileDtlRs = quoteVO.createRowSetIterator(null);
        while (mileDtlRs.hasNext()) {
            Row mileDtlRow = mileDtlRs.next();
            mileDtlRow.remove();
        }
    }

    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public void onChangeLeaseType(ValueChangeEvent valueChangeEvent) {
        if (offerLnsVO.getEstimatedRowCount() > 0) {
            RichPopup.PopupHints p3 = new RichPopup.PopupHints();
            this.getP3().show(p3);
        }
    }

    public String deleteRows() {
        ViewObject offerHdr =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row offerHdrRow = offerHdr.getCurrentRow();
        offerHdrRow.setAttribute("OfferTotal", null);
        offerHdrRow.setAttribute("CarParkLeaseAgreId", null);
        ViewObject vo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        RowSetIterator rs = vo.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row r = rs.first();
            r.remove();
        }
        ViewObject voMileDtl =
            ADFUtils.findIterator("OfferMilestoneDetail_VO5Iterator").getViewObject();
        RowSetIterator rsMileDtl = voMileDtl.createRowSetIterator(null);

        while (rsMileDtl.hasNext()) {
            Row rMileDtl = rsMileDtl.first();
            rMileDtl.remove();
        }
        return null;
    }


    public String deleteAllRows() {
        ViewObject offerHdr =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row offerHdrRow = offerHdr.getCurrentRow();
        offerHdrRow.setAttribute("OfferTotal", null);
        //        CarParkLeaseAgreId
        //offerHdrRow.setAttribute("CarParkLeaseAgreId", null);


        ViewObject vo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();

        if (vo.getEstimatedRowCount() > 0) {


            RowSetIterator rs = vo.createRowSetIterator(null);


            while (rs.hasNext()) {
                Row r = rs.first();
                r.remove();
            }


        }
        ViewObject voMileDtl1 =
            ADFUtils.findIterator("OfferMilestoneDetail_VO1Iterator").getViewObject();

        if (voMileDtl1.getEstimatedRowCount() > 0) {
            RowSetIterator rsMileDtl1 = voMileDtl1.createRowSetIterator(null);

            while (rsMileDtl1.hasNext()) {
                Row rMileDtl1 = rsMileDtl1.first();
                rMileDtl1.remove();
            }
        }
        ViewObject voMileDtl =
            ADFUtils.findIterator("OfferMilestoneDetail_VO5Iterator").getViewObject();


        if (voMileDtl.getEstimatedRowCount() > 0) {
            RowSetIterator rsMileDtl = voMileDtl.createRowSetIterator(null);

            while (rsMileDtl.hasNext()) {
                Row rMileDtl = rsMileDtl.first();
                rMileDtl.remove();
            }
            //        ADFUtils.findOperation("Commit");
        }
        return null;
    }


    public void OnProcessRenwalDate(Object Date1) {

        ViewObject BkHdrVo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row re = BkHdrVo.getCurrentRow();
        String DateFr = Date1 == null ? "" : Date1.toString();
        Date date1 = new Date();
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE, 1);
        DateFormat format12 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format12.format(c.getTime());

        Date date2 = new Date();
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(formatted);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
        oracle.jbo.domain.Date domadate = new oracle.jbo.domain.Date(sqlDate);
        re.setAttribute("OfferFromDate", domadate);
        JSFUtils.setExpressionValue("#{pageFlowScope.extensionFromDate}",
                                    re.getAttribute("OfferFromDate"));
        if ((re.getAttribute("OfferFlag") != null) &&
            ((re.getAttribute("OfferFlag").toString().equalsIgnoreCase("R") ||
              (re.getAttribute("OfferFlag").toString().equalsIgnoreCase("N"))))) {
            //            System.err.println("===-Flag session-===" +
            //                               re.getAttribute("OfferFlag").toString());
            //            System.err.println("===RENEWAL offer from Date===" +
            //                               JSFUtils.resolveExpression("#{pageFlowScope.extensionFromDate}"));
            onexecuteLeaseEndDate(re.getAttribute("OfferFromDate"));

        } else if (re.getAttribute("OfferFlag") != null &&
                   re.getAttribute("OfferFlag").toString().equalsIgnoreCase("S")) {
            //            System.err.println("===SHORT RENEWAL offer from Date===" +
            //                                           JSFUtils.resolveExpression("#{pageFlowScope.extensionFromDate}"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(id6);
            re.setAttribute("OfferToDate", null);
        }


    }
    ViewObject BkHdrVo =
        ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
    Row re = BkHdrVo.getCurrentRow();

    public void onexecuteLeaseEndDate(Object date23) {

        String DateFr = date23 == null ? "" : date23.toString();
        //        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE, 364);
        DateFormat format12 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format12.format(c.getTime());

        Date date2 = new Date();
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(formatted);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
        oracle.jbo.domain.Date domadate = new oracle.jbo.domain.Date(sqlDate);
        //for checking leap year and setting end date 
        String endDt = domadate.toString();
        String isLeapYr = doCheckLeapYr(endDt);
        if(isLeapYr.equalsIgnoreCase("Y")){
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar d = Calendar.getInstance();
            d.setTime(date1);
            d.add(Calendar.DATE, 365);
            DateFormat dFmt = new SimpleDateFormat("yyyy-MM-dd");
            String frmtd = dFmt.format(d.getTime());

            Date date3 = new Date();
            try {
                date3 = new SimpleDateFormat("yyyy-MM-dd").parse(frmtd);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            java.sql.Date sqlDateY = new java.sql.Date(date3.getTime());
            oracle.jbo.domain.Date domadateY = new oracle.jbo.domain.Date(sqlDateY);
            re.setAttribute("OfferToDate", domadateY);
            extnDays.setValue("366");
        }else{
            re.setAttribute("OfferToDate", domadate);
            extnDays.setValue("365");
        }

    }


    public void setLeaseNumber(RichInputComboboxListOfValues leaseNumber) {
        this.leaseNumber = leaseNumber;
    }

    public RichInputComboboxListOfValues getLeaseNumber() {
        return leaseNumber;
    }

    public void onChangeLease(ValueChangeEvent valueChangeEvent) {
        if (offerhdr.getCurrentRow().getAttribute("OfferFlag").toString().equals("N")){
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        RowSetIterator rs = offerDtl.createRowSetIterator(null);
        int i = 0;
        while (rs.hasNext()) {
            Row cu = rs.next();
            cu.setAttribute("LeaseNo_Trans", valueChangeEvent.getNewValue());
//            AdfFacesContext.getCurrentInstance().addPartialTarget(bleaseNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.t1);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.socmap);
            i++;
        }
//        AdfFacesContext.getCurrentInstance().addPartialTarget(bleaseNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.t1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.socmap);
        }
    }

    public void setSocmap(RichSelectOneChoice socmap) {
        this.socmap = socmap;
    }

    public RichSelectOneChoice getSocmap() {
        return socmap;
    }

    public void onLeaseNo(ValueChangeEvent valueChangeEvent) {
        //        System.err.println("11111");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //offerhdr.getCurrentRow().setAttribute("", arg1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.socmap);

    }

    public void setBleaseNo(RichSelectOneChoice bleaseNo) {
        this.bleaseNo = bleaseNo;
    }

    public RichSelectOneChoice getBleaseNo() {
        return bleaseNo;
    }

    public String onBack() {
        // Add event code here...
        String val = null;
        if (countt == 0) {
            val = "save";
        }


        return null;
    }

    public void onClickAttachment(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject vo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        JSFUtils.setExpressionValue("#{pageFlowScope.bookfuncId}", 1);
        JSFUtils.setExpressionValue("#{pageFlowScope.bookId}",
                                    row.getAttribute("OfferHdrId"));
    }

    public boolean getApprovalUser() {
        ViewObject OfferHrdVO =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        boolean flag = false;
        String flowWith =
            OfferHrdVO.getCurrentRow().getAttribute("FlowWith") == null ?
            null :
            OfferHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
        String LoginUserId =
            ADFContext.getCurrent().getSessionScope().get("userId") == null ?
            null :
            ADFContext.getCurrent().getSessionScope().get("userId").toString();
        System.out.println("==User id==="+LoginUserId);
        System.out.println("==Flow with id=="+flowWith);
        if (flowWith != null && LoginUserId != null) {
            if (flowWith.equalsIgnoreCase(LoginUserId)) {
                flag = true;
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }
        System.out.println("Return value=="+flag);
        return flag;

    }

    public void setLeaseNumber_TransId(RichInputListOfValues leaseNumber_TransId) {
        this.leaseNumber_TransId = leaseNumber_TransId;
    }

    public RichInputListOfValues getLeaseNumber_TransId() {
        return leaseNumber_TransId;
    }

    public void setExtensionDays(RichSelectOneChoice extensionDays) {
        this.extensionDays = extensionDays;
    }

    public RichSelectOneChoice getExtensionDays() {
        return extensionDays;
    }

    public String onClickExtDateValidation(ValueChangeEvent valueChangeEvent) {
//        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
//        if (valueChangeEvent.getNewValue() != null) {
//            String ex = valueChangeEvent.getNewValue().toString(); 
//            try{
//            // checking valid integer using parseInt() method 
//                     int exten =  Integer.parseInt(ex); 
//                        System.out.println(exten + " is a valid integer number");
//                if (exten >0 && exten < 183){
//                    System.out.println("greater than 0 and less than 183 :"+exten);
//                
//            //Object to String and String to Integer conversion
//            System.err.println("==VCL==" + valueChangeEvent.getNewValue());
//            Object extensionObj = valueChangeEvent.getNewValue();
//            String extDays = extensionObj.toString();
//            int extensionDaysActual = Integer.parseInt(extDays);
//            //            String requestDateObj = "";
//            //            System.err.println("From date==="+JSFUtils.resolveExpression("#{pageFlowScope.extensionFromDate}"));
//            //            if((offerhdr.getCurrentRow().getAttribute("OfferFromDate").toString()==null&&
//            //            offerhdr.getCurrentRow().getAttribute("OfferFlag").toString()=="S")){
//            //                 requestDateObj =
//            //                    JSFUtils.resolveExpression("#{pageFlowScope.extensionFromDate}") ==
//            //                    null ? "" :
//            //                    JSFUtils.resolveExpression("#{pageFlowScope.extensionFromDate}").toString();
//            //            }else{
//            //                 requestDateObj = offerhdr.getCurrentRow().getAttribute("OfferFromDate").toString();
//            //            }
//            System.err.println("==Offer From Date==" +
//                               offerhdr.getCurrentRow().getAttribute("OfferFromDate").toString());
//
//            String requestDateObj =
//                offerhdr.getCurrentRow().getAttribute("OfferFromDate") ==
//                null ? "" :
//                offerhdr.getCurrentRow().getAttribute("OfferFromDate").toString();
//            //            String requestDateObj =
//            //                JSFUtils.resolveExpression("#{pageFlowScope.extensionFromDate}") ==
//            //                null ? "" :
//            //                JSFUtils.resolveExpression("#{pageFlowScope.extensionFromDate}").toString();
//
//            Date requestDate = new Date();
//            try {
//                requestDate =
//                        new SimpleDateFormat("yyyy-MM-dd").parse(requestDateObj);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//            //Adding the extesnion days with the date
//            Calendar c = Calendar.getInstance();
//            c.setTime(requestDate);
//
//            //Passing the days extesnion days to add with extesnion date
//            c.add(Calendar.DATE, extensionDaysActual-1);
//
//            DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
//            String extesnionDateObj = dateFormate.format(c.getTime());
//            Date extesnionDate = new Date();
//            try {
//                extesnionDate =
//                        new SimpleDateFormat("yyyy-MM-dd").parse(extesnionDateObj);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//            java.sql.Date sqlDate = new java.sql.Date(extesnionDate.getTime());
//            oracle.jbo.domain.Date domaindate =
//                new oracle.jbo.domain.Date(sqlDate);
//            System.err.println("==O/P date==" + domaindate);
//            re.setAttribute("OfferToDate", domaindate);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(id6);
//            System.err.println("==After setting the value==" +
//                               offerHrdVO.getCurrentRow().getAttribute("OfferToDate"));
//            onclickSaveUsingProcedure();
//            
//                }else{
//                    offerhdr.getCurrentRow().setAttribute("ExtensionDays", null);
//                    JSFUtils.addFacesInformationMessage("No of days should be between 0 and 183 !!!");
//                     
//                }
//        } catch(NumberFormatException e) { 
////             System.out.println(ex + " is not a valid integer number");
//               offerhdr.getCurrentRow().setAttribute("ExtensionDays", null); 
//               JSFUtils.addFacesInformationMessage("Please enter valid integer no of days !!!");
//            }
//        AdfFacesContext.getCurrentInstance().addPartialTarget(extnDays);
//    }
        return null;
    }

    public void setId6(RichInputDate id6) {
        this.id6 = id6;
    }

    public RichInputDate getId6() {
        return id6;
    }


    public void onclickSaveUsingProcedure() {
        String leaseId = "";
        String extdays = "";
        String flag = "";
        BigDecimal extAmt = new BigDecimal(0);
        List extList;
        if (re.getAttribute("LeaseNumber_Trans") != null &&
            re.getAttribute("ExtensionDays") != null) {
            //Getting Input parameters
            leaseId =
                    ADFContext.getCurrent().getSessionScope().get("LeaseId") ==
                    null ? "N" :
                    ADFContext.getCurrent().getSessionScope().get("LeaseId").toString();
            System.err.println("==Lease Agreement Id==" + leaseId);
            extdays =
                    re.getAttribute("ExtensionDays") == null ? "N" : re.getAttribute("ExtensionDays").toString();
            System.err.println("==Extension Days==" +
                               re.getAttribute("ExtensionDays").toString());
            flag = "EXT";
            //            Package invoking
            extList =
                    xxfnd.extensionCalculation(leaseId, extdays, flag, "OfferAppModuleDataControl");

            if (extList.size() == 2) {
                if (extList.get(0).toString().equalsIgnoreCase("Success") &&
                    !extList.get(1).toString().equalsIgnoreCase("")) {
                    extAmt = new BigDecimal(extList.get(1).toString());
                } else if (extList.get(0).toString().equalsIgnoreCase("Success") &&
                           extList.get(1).toString().equalsIgnoreCase("")) {
                    JSFUtils.addFacesErrorMessage("No Data returned from package");
                }
            } else {
                JSFUtils.addFacesErrorMessage("Package Return Message : " +
                                              extList.get(0).toString());
                JSFUtils.addFacesErrorMessage("Error in Extension Calculation : " +
                                              extList.get(2).toString());
            }
            System.out.println("Amount before setting extAmt " + extAmt);
            Number extensionAmount = new Number(0);
            /******************Offer Detail table update************************/
            try {
                extensionAmount = new Number(extAmt.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //            ViewObject offerDetailTable =
            //                ADFUtils.findIterator("OfferDetail_VO3Iterator").getViewObject();
            //            //            RowSetIterator OfferDtlRS = offerDetailTable.createRowSetIterator(null);
            //            //            while (OfferDtlRS.hasNext()) {
            Row offerLnsRow = offerLnsVO.getCurrentRow();
            System.err.println("==Extension Amount==" + extensionAmount);
            offerLnsRow.setAttribute("BaseRate", extensionAmount);
            offerLnsRow.setAttribute("TotalRate", extensionAmount);
            ADFContext.getCurrent().getPageFlowScope().put("extensionAmount",
                                                           extensionAmount);
            //            }else{
            //                JSFUtils.addFacesErrorMessage("Negavite values are not allowed in Offer total");
            //            }

            System.err.println("==Base Rate==" +
                               offerLnsRow.getAttribute("BaseRate"));
            System.err.println("==Total Rate==" +
                               offerLnsRow.getAttribute("TotalRate"));
            //            }
            offerLnsVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(t6);
            JSFUtils.addFacesInformationMessage("Extension calculation executed");

        } else {
            if (re.getAttribute("LeaseNumber_Trans") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Lease Number");
            }

            if (re.getAttribute("ExtensionDays") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Extension Days");
            }
        }
    }


    //    public void onCalculateExtensionValues(){
    //
    //    }

    public void setExtnDays(RichInputText extnDays) {
        this.extnDays = extnDays;
    }

    public RichInputText getExtnDays() {
        return extnDays;
    }


    public void onClickOfferDate(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        
        ViewObject getFuncodeVo =
                          ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                      getFuncodeVo.setNamedWhereClauseParam("F_ID", "OF");
                      getFuncodeVo.executeQuery();
                      Object Funcode = getFuncodeVo.first().getAttribute("Attribute1");
                      System.err.println("FunctionId"+Funcode);
                      Integer days=Integer.parseInt(Funcode.toString());

        //        ----------------date+15-----------
        String offerdate = valueChangeEvent.getNewValue().toString();
        System.err.println("offerdate" + offerdate);
        Date date = new Date();
        Date date1=new Date();
        String date3="";
        Calendar cal = Calendar.getInstance();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(offerdate);
            System.err.println("date"+date);
            
            cal.setTime(date);
            cal.add(Calendar.DATE,days);
            date=cal.getTime();
            System.err.println("after 15"+date);
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
                        String strDate = formatter.format(date); 
          System.err.println("after 15 formate="+strDate);
            date1 = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
        } catch (ParseException e) {
        }
           java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
                oracle.jbo.domain.Date domadate = new oracle.jbo.domain.Date(sqlDate);
                System.err.println("domain.date"+domadate);
        ViewObject offervo=ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        offervo.getCurrentRow().setAttribute("Offerexpireddate",domadate);
        

    }

    public void onClickAutoBooking(ActionEvent actionEvent) {
        ViewObject vo=ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row r=vo.getCurrentRow();
        //validation of global site before proceeding to RC on 28-Aug-2020
        String validtnFlag = "Y";
        String laId = r.getAttribute("LeaseAgreementId")== null ? "" : r.getAttribute("LeaseAgreementId").toString();
        System.out.println("Lease id ---"+laId);
        ViewObject laVo=ADFUtils.findIterator("LeaseAgreement_VO2Iterator").getViewObject();   
        ViewObject bkCustVo=ADFUtils.findIterator("BookingCustomer_VO2Iterator").getViewObject(); 
        ViewObject custSiteVo=ADFUtils.findIterator("getCustomerSiteDetailsROVO1Iterator").getViewObject();
            System.out.println("Count cust site "+custSiteVo.getEstimatedRowCount());
            ViewCriteria vc = laVo.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("LeaseAgreementId", laId);
            vc.addRow(vcRow);
            laVo.applyViewCriteria(vc);
            laVo.executeQuery();
            if (laVo.getEstimatedRowCount() > 0) {
                Row re = laVo.first();
                String bkId = re.getAttribute("BookingId") ==null ? "" : re.getAttribute("BookingId").toString();
                System.out.println("BK id ---"+bkId);
                System.out.println("Count bk cust "+bkCustVo.getEstimatedRowCount());
        //            System.out.println("cust id-------"+bkCustVo.getCurrentRow().getAttribute("CustIdAr"));
                    ViewCriteria bkCustvc = bkCustVo.createViewCriteria();
                    ViewCriteriaRow bkCustvcRow = bkCustvc.createViewCriteriaRow();
                    bkCustvcRow.setAttribute("BookingId", bkId);
                    bkCustvc.addRow(bkCustvcRow);
                    bkCustVo.applyViewCriteria(bkCustvc);
                    bkCustVo.executeQuery();
                    System.out.println("Count bk cust "+bkCustVo.getEstimatedRowCount());
                    if (bkCustVo.getEstimatedRowCount() > 0) {
                        Row bkCustRe = bkCustVo.first();
                        String custId = bkCustRe.getAttribute("CustIdAr") ==null ? "" : bkCustRe.getAttribute("CustIdAr").toString();
                        System.out.println("Cust id ---"+custId);
                        ViewCriteria custSiteVc = custSiteVo.createViewCriteria();
                        ViewCriteriaRow custSiteVcRow = custSiteVc.createViewCriteriaRow();
                        custSiteVcRow.setAttribute("CustId", custId);
                        custSiteVc.addRow(custSiteVcRow);
                        custSiteVo.applyViewCriteria(custSiteVc);
                        custSiteVo.executeQuery();
                        if (custSiteVo.getEstimatedRowCount() > 0) 
                        {
                            RowSetIterator rsi = custSiteVo.createRowSetIterator(null);
                            while (rsi.hasNext()) {
                                Row r1 = rsi.next();
                                String orgId = r1.getAttribute("OrgId")==null ? "" : r1.getAttribute("OrgId").toString();
                                if(orgId.equalsIgnoreCase("")){
                                        validtnFlag ="Y";
                                break;
                                }else{
                                    validtnFlag ="N";    
                                }
                            }
                            rsi.closeRowSetIterator();
                        }else{
                            validtnFlag ="N";
                        }
                    }
            }  
            if (validtnFlag.equalsIgnoreCase("Y"))  {     
        //
        String offernumber=r.getAttribute("OfferNumber")==null?"null":r.getAttribute("OfferNumber").toString();
        String offerFlag=r.getAttribute("OfferFlag")==null?"null":r.getAttribute("OfferFlag").toString();
        if (offerFlag.equalsIgnoreCase("R")){
          OperationBinding op=ADFUtils.findOperation("autoBooking");
          op.getParamsMap().put("offerNo",offernumber);
          op.getParamsMap().put("userId","null");
          String flag=op.execute().toString();
          JSFUtils.addFacesInformationMessage(flag);
          r.setAttribute("Status", "BO");
          r.setAttribute("Attribute2", "BK Created");
        }
            if (offerFlag.equalsIgnoreCase("S")){
              OperationBinding op=ADFUtils.findOperation("autoBooking_sr");
              op.getParamsMap().put("offerNo",offernumber);
              op.getParamsMap().put("userId","null");
              String flag=op.execute().toString();
              JSFUtils.addFacesInformationMessage(flag);
              r.setAttribute("Status", "BO");
              r.setAttribute("Attribute2", "BK Created");
            }
            ADFUtils.findOperation("Commit").execute();
            }else{
                JSFUtils.addFacesErrorMessage("Please Create Global site for the associated customer !!!");
            }
    }

    public void onSelectOfferToDate(ValueChangeEvent valueChangeEvent) {
        // Add event code here... 
        //21-June-2020 for calculation even on multiple units
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        System.out.println("OfferFlag :"+ offerhdr.getCurrentRow().getAttribute("OfferFlag"));
        System.out.println("PL ID :"+ offerhdr.getCurrentRow().getAttribute("PlId"));
        //
        System.out.println("Estimated no of units ::::"+offerDtl.getEstimatedRowCount());
        if (offerDtl.getEstimatedRowCount() >0){
        Row ofDtlRow = offerDtl.getCurrentRow();
        //for offerFlag S and date input
        if (offerhdr.getCurrentRow().getAttribute("OfferFlag").equals("S")){
                try{
            if (valueChangeEvent.getNewValue() != null) {
            oracle.jbo.domain.Date st = (oracle.jbo.domain.Date)id4.getValue();
            oracle.jbo.domain.Date en = (oracle.jbo.domain.Date)id6.getValue();
            System.out.println("st date and end date : "+st+ " "+en);
            String toST = st.toString();
            String toEN = en.toString();
            System.out.println("toST nad toEN :"+toST+" "+toEN);
            
        long ndays = getDifferenceDaysBetweenTwoDates(st, en);
                int nodays = (int)ndays;
                if (nodays >0 && nodays < 183){ 
                    extnDays.setValue(nodays);
                    String n = extnDays.getValue().toString();
                    String isLeap = doCheckLeapYr(toEN);
                    doCalculateShortRBasedOnLeapYear(n,isLeap);
                    JSFUtils.addFacesInformationMessage("Extension Calculation executed");
                }
        else{
                        offerhdr.getCurrentRow().setAttribute("ExtensionDays", null);
                        JSFUtils.addFacesInformationMessage("No of days should be between 0 and 183 !!!");
                         
                    }
             }       
            }catch(Exception e){
               System.out.println(e); 
            }
        }
        //to do calc based on no of days 14-June-2020
        if (offerhdr.getCurrentRow().getAttribute("OfferFlag").equals("N")){

        try{
            if (valueChangeEvent.getNewValue() != null) {
            oracle.jbo.domain.Date st = (oracle.jbo.domain.Date)id4.getValue();
            oracle.jbo.domain.Date en = (oracle.jbo.domain.Date)id6.getValue();
            System.out.println("st date and end date : "+st+ " "+en);
            String toST = st.toString();
            String toEN = en.toString();
            System.out.println("toST nad toEN :"+toST+" "+toEN);
        long ndays = getDifferenceDaysBetweenTwoDates(st, en);
                int nodays = (int)ndays;
                    extnDays.setValue(nodays);
                   String n = extnDays.getValue().toString();
                   String isLeap = doCheckLeapYr(toEN);
                   doCalForNofferFlag(n,isLeap);
                }
        
            }catch(Exception e){
               System.out.println(e); 
            }
            JSFUtils.addFacesInformationMessage("Calculation executed");
        }
        //for offerFlag R day calcu 15-June-2020
        if (offerhdr.getCurrentRow().getAttribute("OfferFlag").equals("R")){

                try{
            if (valueChangeEvent.getNewValue() != null) {
            oracle.jbo.domain.Date st = (oracle.jbo.domain.Date)id4.getValue();
            oracle.jbo.domain.Date en = (oracle.jbo.domain.Date)id6.getValue();
            System.out.println("st date and end date : "+st+ " "+en);
            String toST = st.toString();
            String toEN = en.toString();
            System.out.println("toST nad toEN :"+toST+" "+toEN);
            
        long ndays = getDifferenceDaysBetweenTwoDates(st, en);
                int nodays = (int)ndays;
                if (nodays >= 183){ 
                    extnDays.setValue(nodays);
                   String n = extnDays.getValue().toString();
                    String isLeap = doCheckLeapYr(toEN);
                    doCalculateShortRBasedOnLeapYear(n,isLeap);
                    JSFUtils.addFacesInformationMessage("Extension Calculation executed");
                }
        else{
                        offerhdr.getCurrentRow().setAttribute("ExtensionDays", null);
                        JSFUtils.addFacesInformationMessage("No of days should be greater than or equal to 183 !!!");
                         
                    }
        
               }        
            }catch(Exception e){
               System.out.println(e); 
            }
         }
        } //first if
    }
    
    public void doCalForNofferFlag(String nodays, String isLyr) {
      
      Row ofrHdrRow = offerhdr.getCurrentRow();
      RowSetIterator ofDtVoRSI = offerDtl.createRowSetIterator(null);
          while (ofDtVoRSI.hasNext()) {
              Row ofrDtlRow = ofDtVoRSI.next();
//      Row ofrDtlRow = offerDtl.getCurrentRow();
      ViewObject vo =
                  ADFUtils.findIterator("PlLinesVO1Iterator").getViewObject();
              ViewCriteria vc = vo.createViewCriteria();
              ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                      System.err.println("PropertyId" + ofrDtlRow.getAttribute("PropertyId"));
                      System.err.println("BuildingId" + ofrDtlRow.getAttribute("BuildingId"));
                      System.err.println("PlId" + offerhdr.getCurrentRow().getAttribute("PlId"));
                      System.err.println("UnitId based on current row :" + ofrDtlRow.getAttribute("UnitId"));
//                      System.err.println("UnitId based on unit passed :" + unitId);

              vcRow.setAttribute("PropertyId", ofrDtlRow.getAttribute("PropertyId") == null ? "" : ofrDtlRow.getAttribute("PropertyId"));
              vcRow.setAttribute("BuildId", ofrDtlRow.getAttribute("BuildingId") == null ? "" : ofrDtlRow.getAttribute("BuildingId"));
    //              vcRow.setAttribute("UnitId", ofrDtlRow.getAttribute("UnitId") == null ? "" : ofrDtlRow.getAttribute("UnitId"));
              vcRow.setAttribute("UnitId", ofrDtlRow.getAttribute("UnitId") == null ? "" : ofrDtlRow.getAttribute("UnitId"));
              vcRow.setAttribute("PlId", offerhdr.getCurrentRow().getAttribute("PlId") == null ? "" : offerhdr.getCurrentRow().getAttribute("PlId"));
              vc.addRow(vcRow);
              vo.applyViewCriteria(vc);
              vo.executeQuery();
              long io = vo.getEstimatedRowCount();
                System.err.println("estimationrowCount" + io);

              if (vo.getEstimatedRowCount() > 0) {
                  Row re = vo.first();
                  baseRate =
                                    re.getAttribute("BasePrice") == null ? "0" :
                                    re.getAttribute("BasePrice").toString();
              }else {
                  baseRate =  ofrDtlRow.getAttribute("BaseRate") ==null ?  "0" : ofrDtlRow.getAttribute("BaseRate").toString();
              }
      //
      System.out.println("baseRate ::::: "+ baseRate);
        BigDecimal bRate = new BigDecimal(baseRate);
        BigDecimal nDays = new BigDecimal(nodays);
        BigDecimal netM = bRate.multiply(nDays);
        BigDecimal year = new BigDecimal("365");
        if (isLyr.equalsIgnoreCase("Y")){
            year = new BigDecimal("365");
        }
    //        BigDecimal net = netM.divide(year, 2);
        BigDecimal net = netM.divide(year,2,BigDecimal.ROUND_HALF_UP);
        System.out.println("net :::: "+ net);
        ofrDtlRow.setAttribute("BaseRate", net);
        ofrDtlRow.setAttribute("TotalRate", net);
        AdfFacesContext.getCurrentInstance().addPartialTarget(it38);
          } //while loop
    }
    
    public long getDifferenceDaysBetweenTwoDates(oracle.jbo.domain.Date st,oracle.jbo.domain.Date en) {
            if (st != null && en != null) {
                long diffms = en.getValue().getTime() - st.getValue().getTime();
                System.out.println(diffms);
                long msPerDay = 1000 * 60 * 60 * 24;
                long duration = diffms / msPerDay;
                System.out.println("duration " + duration);
                return duration +1;
         }
           return 0;
         } 
   //method is for offer to date input  
    public void onclickSaveUsingProcedure(String nodays) {
        String leaseId = "";
        String extdays = "";
        String flag = "";
        BigDecimal extAmt = new BigDecimal(0);
        List extList;
        Row ofrHdrRow = offerhdr.getCurrentRow();
        Row ofrDtlRow = offerDtl.getCurrentRow();
        ViewObject vo =
                    ADFUtils.findIterator("LeaseOffer_detail_RoVo1Iterator").getViewObject();
        System.out.println("Lead ID :"+ofrHdrRow.getAttribute("LeadId") == null ? "" : ofrHdrRow.getAttribute("LeadId"));
        System.out.println("OfferFlag :"+ofrHdrRow.getAttribute("OfferFlag") == null ? "" : ofrHdrRow.getAttribute("OfferFlag"));  
        System.out.println("Unit ID :"+ofrDtlRow.getAttribute("UnitId") == null ? "" : ofrDtlRow.getAttribute("UnitId"));
                ViewCriteria vc = vo.createViewCriteria();
                ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                vcRow.setAttribute("LeadId", ofrHdrRow.getAttribute("LeadId") == null ? "" : ofrHdrRow.getAttribute("LeadId"));
                vcRow.setAttribute("OfferFlag", "not like 'S'");
                vcRow.setAttribute("UnitId", ofrDtlRow.getAttribute("UnitId") == null ? "" : ofrDtlRow.getAttribute("UnitId"));
                vc.addRow(vcRow);
                vo.applyViewCriteria(vc);
                vo.executeQuery();
                System.out.println("Estimated lease offer rovo count :"+vo.getEstimatedRowCount());
                if (vo.getEstimatedRowCount() > 0){
                System.out.println("BaseRate lease offer rovo :"+vo.first().getAttribute("BaseRate"));                                                                                
        if (re.getAttribute("LeaseNumber_Trans") != null){
    //            re.getAttribute("ExtensionDays") != null) {
            //Getting Input parameters
//            leaseId =
//                    ADFContext.getCurrent().getSessionScope().get("LeaseId") ==
//                    null ? "N" :
//                    ADFContext.getCurrent().getSessionScope().get("LeaseId").toString();
            leaseId = vo.first().getAttribute("LeaseAgreementId").toString();
            System.err.println("==Lease Agreement Id==" + leaseId);
            extdays = nodays;
    //            extdays =
    //                    re.getAttribute("ExtensionDays") == null ? "N" : re.getAttribute("ExtensionDays").toString();
    //            System.err.println("==Extension Days==" +
    //                               re.getAttribute("ExtensionDays").toString());
            flag = "EXT";
            //            Package invoking
            extList =
                    xxfnd.extensionCalculation(leaseId, extdays, flag, "OfferAppModuleDataControl");

            if (extList.size() == 2) {
                if (extList.get(0).toString().equalsIgnoreCase("Success") &&
                    !extList.get(1).toString().equalsIgnoreCase("")) {
                    extAmt = new BigDecimal(extList.get(1).toString());                    
                } else if (extList.get(0).toString().equalsIgnoreCase("Success") &&
                           extList.get(1).toString().equalsIgnoreCase("")) {
                    JSFUtils.addFacesErrorMessage("No Data returned from package");
                }
            } else {
                JSFUtils.addFacesErrorMessage("Package Return Message : " +
                                              extList.get(0).toString());
                JSFUtils.addFacesErrorMessage("Error in Extension Calculation : " +
                                              extList.get(2).toString());
            }
            System.out.println("Amount before setting extAmt " + extAmt);
            Number extensionAmount = new Number(0);
            /******************Offer Detail table update************************/
            try {
                extensionAmount = new Number(extAmt.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //            ViewObject offerDetailTable =
            //                ADFUtils.findIterator("OfferDetail_VO3Iterator").getViewObject();
            //            //            RowSetIterator OfferDtlRS = offerDetailTable.createRowSetIterator(null);
            //            //            while (OfferDtlRS.hasNext()) {
            Row offerLnsRow = offerLnsVO.getCurrentRow();
            System.err.println("==Extension Amount==" + extensionAmount);
            offerLnsRow.setAttribute("BaseRate", extensionAmount);
            offerLnsRow.setAttribute("TotalRate", extensionAmount);
            ADFContext.getCurrent().getPageFlowScope().put("extensionAmount",
                                                           extensionAmount);
            //            }else{
            //                JSFUtils.addFacesErrorMessage("Negavite values are not allowed in Offer total");
            //            }

            System.err.println("==Base Rate==" +
                               offerLnsRow.getAttribute("BaseRate"));
            System.err.println("==Total Rate==" +
                               offerLnsRow.getAttribute("TotalRate"));
            //            }
            offerLnsVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(t6);
            JSFUtils.addFacesInformationMessage("Extension calculation executed");

        } else {
            if (re.getAttribute("LeaseNumber_Trans") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Lease Number");
            }
        }
    //            if (re.getAttribute("ExtensionDays") == null) {
    //                JSFUtils.addFacesErrorMessage("You must select a Extension Days");
    //            }
        }
    }

    public void setId4(RichInputDate id4) {
        this.id4 = id4;
    }

    public RichInputDate getId4() {
        return id4;
    }

    public void setIt38(RichInputText it38) {
        this.it38 = it38;
    }

    public RichInputText getIt38() {
        return it38;
    }
    public void onClickForBK() {
        // Add event code here...
        ViewObject vo=ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row r=vo.getCurrentRow();
        String offernumber=r.getAttribute("OfferNumber")==null?"null":r.getAttribute("OfferNumber").toString();
        String offerFlag=r.getAttribute("OfferFlag")==null?"null":r.getAttribute("OfferFlag").toString();
        if (offerFlag.equalsIgnoreCase("N")){
          OperationBinding op=ADFUtils.findOperation("autoBookingBK");
          op.getParamsMap().put("offerNo",offernumber);
          op.getParamsMap().put("userId","null");
          String flag=op.execute().toString();
          JSFUtils.addFacesInformationMessage(flag);
        }
    }
    public void doCalculateShortRBasedOnLeapYear(String extdys, String leapYearD){
        String leapYear = leapYearD;    
        String baseR = "";
        String bsRate = null;
        String baseRateOneDay = "0";
        BigDecimal baseRateOneDayBD = new BigDecimal(0);
        BigDecimal oneYrBD = new BigDecimal(365);
        BigDecimal oneYrBaseRateDB = new BigDecimal(0);
        BigDecimal baseRate = new BigDecimal(0);
        String leaseId = "";
        String extd = extdys;
        BigDecimal extdays = new BigDecimal(extd);
        String totalDays = "";
        BigDecimal extAmt = new BigDecimal(0);
        List extList;
        Row ofrHdrRow = offerhdr.getCurrentRow();
        //
        RowSetIterator ofDtVoRSI = offerDtl.createRowSetIterator(null);
            while (ofDtVoRSI.hasNext()) {
                Row ofrDtlRow = ofDtVoRSI.next();
     
//        Row ofrDtlRow = offerDtl.getCurrentRow();
        ViewObject vo =
                    ADFUtils.findIterator("LeaseOffer_detail_RoVo1Iterator").getViewObject();
        System.out.println("Lead ID :"+ofrHdrRow.getAttribute("LeadId") == null ? "" : ofrHdrRow.getAttribute("LeadId"));
        System.out.println("OfferFlag :"+ofrHdrRow.getAttribute("OfferFlag") == null ? "" : ofrHdrRow.getAttribute("OfferFlag"));  
        System.out.println("Unit ID :"+ofrDtlRow.getAttribute("UnitId") == null ? "" : ofrDtlRow.getAttribute("UnitId"));
                ViewCriteria vc = vo.createViewCriteria();
                ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                vcRow.setAttribute("LeadId", ofrHdrRow.getAttribute("LeadId") == null ? "" : ofrHdrRow.getAttribute("LeadId"));
//                vcRow.setAttribute("OfferFlag", "not like 'S'");
                vcRow.setAttribute("UnitId", ofrDtlRow.getAttribute("UnitId") == null ? "" : ofrDtlRow.getAttribute("UnitId"));
                vc.addRow(vcRow);
                vo.applyViewCriteria(vc);
                vo.executeQuery();
                System.out.println("Estimated lease offer rovo count :"+vo.getEstimatedRowCount());
                if (vo.getEstimatedRowCount() > 0){
                System.out.println("BaseRate lease offer rovo :"+vo.first().getAttribute("BaseRate")); 
                System.out.println("BaseRateOneDay lease offer rovo :"+vo.first().getAttribute("BaseRateOneDay"));
        if (re.getAttribute("LeaseNumber_Trans") != null){
    
            leaseId = vo.first().getAttribute("LeaseAgreementId").toString();
            baseRateOneDay = vo.first().getAttribute("BaseRateOneDay")==null ? "0" : vo.first().getAttribute("BaseRateOneDay").toString();
            baseRateOneDayBD = new BigDecimal(baseRateOneDay);
            oneYrBaseRateDB = baseRateOneDayBD.multiply(oneYrBD);
            baseR = oneYrBaseRateDB.toString();  
            //on 20-Sep-2022
                if ((offerhdr.getCurrentRow().getAttribute("OfferFlag").equals("S")) ||
                (offerhdr.getCurrentRow().getAttribute("OfferFlag").equals("R") && extdays.compareTo(new BigDecimal(365))<1)
                ){
            baseR = ofrDtlRow.getAttribute("Attribute5")==null ? baseR : ofrDtlRow.getAttribute("Attribute5").toString();
            }
            //
//            baseR = vo.first().getAttribute("BaseRate").toString();
            //from current row 
//            baseR =  ofrDtlRow.getAttribute("BaseRate") ==null ? "0" : ofrDtlRow.getAttribute("BaseRate").toString();
            String flagForBsRtPull = ofrHdrRow.getAttribute("Attribute4")==null ? "" : ofrHdrRow.getAttribute("Attribute4").toString();
            if(flagForBsRtPull.equalsIgnoreCase("PULL_BASERATE")){
            //
            //for getting base rate from Price List
            ViewObject voR =
                        ADFUtils.findIterator("PlLinesVO1Iterator").getViewObject();
                    ViewCriteria vcR = voR.createViewCriteria();
                    ViewCriteriaRow vcRRow = vcR.createViewCriteriaRow();
                            System.err.println("PropertyId" + ofrDtlRow.getAttribute("PropertyId"));
                            System.err.println("BuildingId" + ofrDtlRow.getAttribute("BuildingId"));
                            System.err.println("PlId" + offerhdr.getCurrentRow().getAttribute("PlId"));
                            System.err.println("UnitId based on current row :" + ofrDtlRow.getAttribute("UnitId"));
//                            System.err.println("UnitId based on unit passed :" + unitId);

                    vcRRow.setAttribute("PropertyId", ofrDtlRow.getAttribute("PropertyId") == null ? "" : ofrDtlRow.getAttribute("PropertyId"));
                    vcRRow.setAttribute("BuildId", ofrDtlRow.getAttribute("BuildingId") == null ? "" : ofrDtlRow.getAttribute("BuildingId"));
            //              vcRow.setAttribute("UnitId", ofrDtlRow.getAttribute("UnitId") == null ? "" : ofrDtlRow.getAttribute("UnitId"));
                    vcRRow.setAttribute("UnitId", ofrDtlRow.getAttribute("UnitId") == null ? "" : ofrDtlRow.getAttribute("UnitId"));
                    vcRRow.setAttribute("PlId", offerhdr.getCurrentRow().getAttribute("PlId") == null ? "" : offerhdr.getCurrentRow().getAttribute("PlId"));
                    vcR.addRow(vcRRow);
                    voR.applyViewCriteria(vcR);
                    voR.executeQuery();
                    long ioo = voR.getEstimatedRowCount();
                      System.err.println("estimationrowCount" + ioo);
                    if (voR.getEstimatedRowCount() > 0) {
                        Row re = voR.first();
                        bsRate =  re.getAttribute("BasePrice") == null ? "0" : re.getAttribute("BasePrice").toString();
                    }
                    //
                baseRate = new BigDecimal(bsRate);  
            }else{           
            baseRate = new BigDecimal(baseR);
            }
            System.err.println("==Lease Agreement Id==" + leaseId);
            System.err.println("==Base Rate==" + baseRate);
            if (leapYear.equals("Y")){
    //            BigDecimal extD =new BigDecimal(extdays);
                BigDecimal tDays =new BigDecimal(365);
                      extAmt = (baseRate.multiply(extdays)).divide(tDays,2,BigDecimal.ROUND_HALF_UP);
                      System.out.println("ext amt :"+extAmt);
    //                      String s =baseR/"0";
    //                    extAmt = new BigDecimal(netAmt);
            } 
            else{
                BigDecimal tDays =new BigDecimal(365);
                extAmt = (baseRate.multiply(extdays)).divide(tDays,2,BigDecimal.ROUND_HALF_UP);
                System.out.println("ext amt :"+extAmt);                  
            } 
           
            System.out.println("Amount before setting extAmt " + extAmt);
            Number extensionAmount = new Number(0);
            /******************Offer Detail table update************************/
            try {
                System.out.println("converted to no");
                extensionAmount = new Number(extAmt.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
            Row offerLnsRow = offerLnsVO.getCurrentRow();
            System.err.println("==Extension Amount==" + extensionAmount);
//            offerLnsRow.setAttribute("BaseRate", extensionAmount);
//            offerLnsRow.setAttribute("TotalRate", extensionAmount);
            ofrDtlRow.setAttribute("BaseRate", extensionAmount);
            ofrDtlRow.setAttribute("TotalRate", extensionAmount);
            ADFContext.getCurrent().getPageFlowScope().put("extensionAmount",
                                                           extensionAmount);
            //            }else{
            //                JSFUtils.addFacesErrorMessage("Negavite values are not allowed in Offer total");
            //            }

//            System.err.println("==Base Rate==" +
//                               offerLnsRow.getAttribute("BaseRate"));
//            System.err.println("==Total Rate==" +
//                               offerLnsRow.getAttribute("TotalRate"));
            System.err.println("==Base Rate==" +
                               ofrDtlRow.getAttribute("BaseRate"));
            System.err.println("==Total Rate==" +
                               ofrDtlRow.getAttribute("TotalRate"));
            //            }
//            offerLnsVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(t6);
//            JSFUtils.addFacesInformationMessage("Extension calculation executed");

        } else {
            if (re.getAttribute("LeaseNumber_Trans") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Lease Number");
            }
        }
    
        }
            } //while loop
            ofDtVoRSI.closeRowSetIterator();
    }

    public void doCreateBKonClick(ActionEvent actionEvent) {
        // Add event code here...
        Row row = offerhdr.getCurrentRow();
        if (row.getAttribute("OfferFlag").equals("N") && row.getAttribute("FlowWith") == null){
            if(row.getAttribute("Attribute2") == null){
                row.setAttribute("Attribute2", "BK Created");
                onClickForBK();
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Booking Created successfully !!!");
            }else{
                JSFUtils.addFacesErrorMessage("Booking is already Created !!!");
            }
        }
    }
//pulling base price from Price list on click
    public void doPullBasePfromPL(ActionEvent actionEvent) {
        // Add event code here...
        Row row = offerhdr.getCurrentRow();
        ViewObject Currvo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        Row curr = Currvo.getCurrentRow();
        System.err.println("leadname="+row.getAttribute("Trans_LeadNumber"));
//        if (row.getAttribute("OfferFlag").equals("R") || row.getAttribute("OfferFlag").equals("S")){
            String plId = row.getAttribute("PlId") == null ? "" : row.getAttribute("PlId").toString();
            ViewObject plLinesVo =
                ADFUtils.findIterator("PlLinesVO1Iterator").getViewObject();
            ViewCriteria vc = plLinesVo.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                    System.err.println("PropertyId" + curr.getAttribute("PropertyId"));
                    System.err.println("BuildingId" + curr.getAttribute("BuildingId"));
                    System.err.println("PlId" + curr.getAttribute("PlId"));
                    System.err.println("UnitId" + curr.getAttribute("UnitId"));
            vcRow.setAttribute("PropertyId", curr.getAttribute("PropertyId"));
            vcRow.setAttribute("BuildId", curr.getAttribute("BuildingId"));
            vcRow.setAttribute("UnitId", curr.getAttribute("UnitId"));
            vcRow.setAttribute("PlId", plId);
            vc.addRow(vcRow);
            plLinesVo.applyViewCriteria(vc);
            plLinesVo.executeQuery();
            long io = plLinesVo.getEstimatedRowCount();
            //        System.err.println("estimationrowCount" + io);
            if (plLinesVo.getEstimatedRowCount() > 0) {
                Row re = plLinesVo.first();
                String basePrice = re.getAttribute("BasePrice")==null ? "" : re.getAttribute("BasePrice").toString();
                curr.setAttribute("BaseRate", basePrice);
                System.out.println("basePrice %%%%%%%% "+basePrice);
                if(row.getAttribute("Attribute4")==null){
                row.setAttribute("Attribute4", "PULL_BASERATE");
                }else{
                    row.setAttribute("Attribute4", null);
                }
            }
//        }
    }

    public void doChangeStatusToDraft(ActionEvent actionEvent) {
        // Add event code here...
        Row row = offerhdr.getCurrentRow();
        ViewObject funApvHistRoVo = ADFUtils.findIterator("getApprovalHistoryROVo2Iterator").getViewObject();
        System.err.println("Offer ID="+row.getAttribute("OfferHdrId"));
        String status = row.getAttribute("Status") == null ? "" : row.getAttribute("Status").toString();
        String ofHdrId = row.getAttribute("OfferHdrId") == null ? "0" : row.getAttribute("OfferHdrId").toString();
        String userName =   ADFContext.getCurrent().getSessionScope().get("userName") == null ?
                            null :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
        String userId =   ADFContext.getCurrent().getSessionScope().get("userId") == null ?
                            null :
                            ADFContext.getCurrent().getSessionScope().get("userId").toString();
        String funcId = row.getAttribute("FuncId") == null ? "0" : row.getAttribute("FuncId").toString();
        String reason = "Request Change to Draft";
        System.out.println("Status :"+status);
        //calling pkg
        onDirectToDraft(ofHdrId,userId,funcId,reason);
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Changes done Successfully");
    }

    public void onEntrDiscValueCal(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject ofDiscFlwVo = ADFUtils.findIterator("OfferDiscountFlow_VO1Iterator").getViewObject();
        Row row = ofDiscFlwVo.getCurrentRow();
        BigDecimal disValueBD = new BigDecimal(0);
        BigDecimal baseRateBD = new BigDecimal(0);
        BigDecimal disValCompareSeq1 = new BigDecimal(5);
        BigDecimal disValCompareSeq2 = new BigDecimal(5);
        
        String disType = row.getAttribute("DiscountType")==null?"0":row.getAttribute("DiscountType").toString();
        String expDisc = row.getAttribute("ExpectedDiscount")==null?"0":row.getAttribute("ExpectedDiscount").toString();
        String discValue = valueChangeEvent.getNewValue()==null ? "0" : valueChangeEvent.getNewValue().toString();
        String baseRate = row.getAttribute("BaseRate")==null?"0":row.getAttribute("BaseRate").toString();
        disValueBD= new BigDecimal(discValue);
        baseRateBD= new BigDecimal(baseRate);
        String seq = row.getAttribute("SeqApprover")==null?"0":row.getAttribute("SeqApprover").toString();
        if((seq.equalsIgnoreCase("1") && disValueBD.compareTo(disValCompareSeq1)<=0) ||
            (seq.equalsIgnoreCase("2") && disValueBD.compareTo(disValCompareSeq2)<=0) ||
            (seq.equalsIgnoreCase("3"))
        ){
        JSFUtils.addFacesInformationMessage("Discount value : "+disValueBD+" Base rate : "+baseRateBD+" Discount Type :"+disType);
        onDiscountCal(disValueBD, baseRateBD, disType);       
        System.out.println("onDiscountCal Method :: disValueBD:"+disValueBD+"baseRateBD :"+baseRateBD+"disType :"+disType);
        }else{
            if(seq.equalsIgnoreCase("1")){
                JSFUtils.addFacesErrorMessage("Discount Value should be less than or equal to 5");
            }
            if(seq.equalsIgnoreCase("2")){
                JSFUtils.addFacesErrorMessage("Discount Value should be less than or equal to 5");  
            }
        }
    }
    
    public void onDiscountCal(BigDecimal disValueBD,BigDecimal baseRateBD,String disType){
        BigDecimal TotalPercent = new BigDecimal(100);
        BigDecimal disAmt = new BigDecimal(0);
        BigDecimal netAmt = new BigDecimal(0);
        if (disType.equals("%")) {
            netAmt = baseRateBD.subtract((disValueBD.multiply(baseRateBD)).divide(TotalPercent));
            disAmt = (disValueBD.multiply(baseRateBD)).divide(TotalPercent);
        }else{
                  netAmt = baseRateBD.subtract(disValueBD);
                  disAmt = disValueBD;
                }
        ViewObject ofHdrVo = ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row rowHdr = ofHdrVo.getCurrentRow();
        Row ofrDtlRow = offerDtl.getCurrentRow();
        ViewObject ofDiscFlwVo = ADFUtils.findIterator("OfferDiscountFlow_VO1Iterator").getViewObject();
        Row row = ofDiscFlwVo.getCurrentRow();
        row.setAttribute("DiscountAmount", disAmt);
//        row.setAttribute("NetRate", netAmt);
        
        BigDecimal disAmtB = new BigDecimal(0);
        BigDecimal disAmtTotalB = new BigDecimal(0);
        
        BigDecimal netRateDiscFlowLevelBD = new BigDecimal(0);
        BigDecimal netTotalRateDiscFlowLevelBD = new BigDecimal(0);
        BigDecimal taxBD = new BigDecimal(0);
        BigDecimal baseR = new BigDecimal(0);
        BigDecimal totalTax = new BigDecimal(0);
        BigDecimal netRateOfLine = new BigDecimal(0);
        BigDecimal exptdDisBD = new BigDecimal(0);
        BigDecimal TAmount = new BigDecimal(0);
        BigDecimal VTotal = new BigDecimal(0);
        BigDecimal netWoTaxDisFlwLine = new BigDecimal(0);
        
        RowSetIterator rs = ofDiscFlwVo.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row r = rs.next();
            String disAmtS = r.getAttribute("DiscountAmount")==null ?"0": r.getAttribute("DiscountAmount").toString();
            String netRateDiscFlowLevel = r.getAttribute("NetRate")==null ?"0": r.getAttribute("NetRate").toString();
            disAmtB = new BigDecimal(disAmtS);
            disAmtTotalB = disAmtTotalB.add(disAmtB);
            //            
            netRateDiscFlowLevelBD = new BigDecimal(netRateDiscFlowLevel);
            netTotalRateDiscFlowLevelBD = netTotalRateDiscFlowLevelBD.add(netRateDiscFlowLevelBD);

        }
        ofDiscFlwVo.closeRowSetIterator();
        row.setAttribute("TotalDiscount", disAmtTotalB);
        Object pnet= baseRateBD.subtract(disAmtTotalB).toString();
        Object lineTot = pnet;
        String TaxAmount = TaxCalculation(lineTot) == null ? "0" : TaxCalculation(lineTot).toString();
         TAmount = new BigDecimal(TaxAmount);
         VTotal = baseRateBD.subtract(disAmtTotalB).add(TAmount);
        Object netRte = VTotal;
        row.setAttribute("NetRate", netRte);
        //NetRentWithoutTax
        netWoTaxDisFlwLine = VTotal.subtract(TAmount);
        row.setAttribute("NetRentWithoutTax", netWoTaxDisFlwLine);
        //all calculation calculate and save button based
        onClickSaveorCalcAllNew(disAmtTotalB);
        //on setting expected discount on 14-July-2021
//        doSetExptedDisc();
        //validation of Total discount and expected discount
        String exptdDisc = rowHdr.getAttribute("ExpectedDiscount")==null ?"0": rowHdr.getAttribute("ExpectedDiscount").toString();
        exptdDisBD = new BigDecimal(exptdDisc);
        if (!disAmtTotalB.equals(0) && disAmtTotalB.compareTo(exptdDisBD) >0){
            JSFUtils.addFacesErrorMessage("Total Discount is more than Expected discount !!!"); 
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(it57disc);
        AdfFacesContext.getCurrentInstance().addPartialTarget(it47TaxAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(lineAmnt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(netRentWithoutTaxDtlLine);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(it62ExpectedDisc);
    }

    public void onClickSaveForDiscFlow(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved.....");
    }
    
    public void onClickSaveorCalcAllNew(BigDecimal disAmtTotalB){
            if (offerLnsVO.getEstimatedRowCount() > 0) {
                onCalcDiscTax(disAmtTotalB);
                doCalInstalment();
                String noCalc = ADFContext.getCurrent().getPageFlowScope().get("handleCalcSavButton")==null ? "" : ADFContext.getCurrent().getPageFlowScope().get("handleCalcSavButton").toString();
                
                AdfFacesContext.getCurrentInstance().addPartialTarget(it57disc);
                AdfFacesContext.getCurrentInstance().addPartialTarget(it47TaxAmt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineAmnt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(offerTotal);
                AdfFacesContext.getCurrentInstance().addPartialTarget(offerTotalWithoutTax);
            }
        }
    
    public void onCalcDiscTax(BigDecimal disAmtTotalB) {

            ViewObject ofHdrVo = ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
            Row rowHdr = ofHdrVo.getCurrentRow();
            ViewObject vo = ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();      
            BigDecimal VTotal = new BigDecimal(0);
            BigDecimal TAmount = new BigDecimal(0);
            BigDecimal totOfferTotBD = new BigDecimal(0);
            BigDecimal perDisAmtBD = new BigDecimal(0);
            BigDecimal baseRateBD = new BigDecimal(0);
            BigDecimal totOfferTotBDWoTax = new BigDecimal(0);
            BigDecimal totTaxBD = new BigDecimal(0);
            BigDecimal lineTotWoTax = new BigDecimal(0);
            long i =vo.getEstimatedRowCount();
            String ofDtlCount = String.valueOf(i);
            BigDecimal countBD = new BigDecimal(ofDtlCount);
                    
            if (vo.getEstimatedRowCount() > 0) {
                RowSetIterator ofDtlVoRsi = vo.createRowSetIterator(null);
                while (ofDtlVoRsi.hasNext()) {
                    Row r = ofDtlVoRsi.next();
                    String baseRate = r.getAttribute("BaseRate")==null ?"0": r.getAttribute("BaseRate").toString();
                    baseRateBD = new BigDecimal(baseRate);  
                    
//                    perDisAmtBD = disAmtTotalB.divide(countBD);
                    perDisAmtBD = disAmtTotalB.divide(countBD,2,RoundingMode.CEILING);
//                    perDisAmtBD = perDisAmtBD.setScale(2, BigDecimal.ROUND_UP);
                    VTotal = baseRateBD.subtract(perDisAmtBD);
                                    
                    Object lineTot = VTotal;
                    String TaxAmount = TaxCalculation(lineTot) == null ? "0" : TaxCalculation(lineTot).toString();

                    TAmount = new BigDecimal(TaxAmount);
                    VTotal = VTotal.add(TAmount);
                    Object netRte = VTotal;
                    r.setAttribute("TotalRate", netRte);
                    r.setAttribute("TaxAmount", TaxAmount);    
                    //discount
                    Object perDiscAmt = perDisAmtBD.toString();
                    r.setAttribute("Attribute3", perDiscAmt);
                    //total base rate
                    totOfferTotBD = totOfferTotBD.add(VTotal);
                    //total tax
                    lineTotWoTax = VTotal.subtract(TAmount);
                    r.setAttribute("NetRentWithoutTax", lineTotWoTax);
                    totTaxBD = totTaxBD.add(TAmount);
                }
                totOfferTotBDWoTax = totOfferTotBD.subtract(totTaxBD);
                //setting offer total Rate header 
                Object ofTotal = totOfferTotBD.toString();
                rowHdr.setAttribute("OfferTotal", ofTotal); 
                rowHdr.setAttribute("OfferTotalWithoutTax", totOfferTotBDWoTax);
            }
        }
    public void doCalInstalment() {
         try {
                BigDecimal pct = new BigDecimal(0);           
                RowSetIterator dtlsRS = offerMilesDtlsVO.createRowSetIterator(null);               
                while (dtlsRS.hasNext()) {
                    Row r = dtlsRS.next();
                    Object instPct = r.getAttribute("InstallmentPct");
                    if (instPct != null) {
                        pct = new BigDecimal(r.getAttribute("InstallmentPct").toString());
                    }
                    String OfferTot =
                        this.offerTotal.getValue() == null ? "0" : this.offerTotal.getValue().toString();
                    BigDecimal offerTotal = new BigDecimal(OfferTot);
                    //                System.err.println("==offer Total==" + offerTotal);
                    BigDecimal Amt =
                        (pct.multiply(offerTotal)).divide(new BigDecimal(100));
                    //                System.err.println("==Installment Amount==" + Amt);
                    r.setAttribute("InstallmentAmount", Amt);
                }
                dtlsRS.closeRowSetIterator();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void onEntrExptdDisct(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        BigDecimal exptDiscBD = new BigDecimal(0);
        Row row = offerhdr.getCurrentRow();
        if(valueChangeEvent.getNewValue()!=null){
        String exptDisc = valueChangeEvent.getNewValue()==null ? "0" : valueChangeEvent.getNewValue().toString();
            exptDiscBD = new BigDecimal(exptDisc);
            row.setAttribute("ExpectedDiscount", exptDiscBD);
        }
    }
    //calling from discount lines
    public void doSetExptedDisc() {
        BigDecimal rqstedNetRentBD = new BigDecimal(0);
        BigDecimal ofrTotalBD = new BigDecimal(0);
        BigDecimal exptdDiscBD = new BigDecimal(0);
        Row row = offerhdr.getCurrentRow();
        String rqstedNetRent = row.getAttribute("RequestedNetRent")==null ? "0" : row.getAttribute("RequestedNetRent").toString();
        String offerTotal = row.getAttribute("OfferTotal")==null ? "0" : row.getAttribute("OfferTotal").toString();
            rqstedNetRentBD = new BigDecimal(rqstedNetRent);
            ofrTotalBD = new BigDecimal(offerTotal);
            exptdDiscBD = rqstedNetRentBD.subtract(ofrTotalBD);
            BigDecimal abs = exptdDiscBD.abs();
            String exptdDisc = abs.toString();
            row.setAttribute("ExpectedDiscount", exptdDisc);
            row.setAttribute("ExpectedDiscount_Trans", exptdDisc);
    }

    public void setIt57disc(RichInputText it57disc) {
        this.it57disc = it57disc;
    }

    public RichInputText getIt57disc() {
        return it57disc;
    }

    public void setIt47TaxAmt(RichInputText it47TaxAmt) {
        this.it47TaxAmt = it47TaxAmt;
    }

    public RichInputText getIt47TaxAmt() {
        return it47TaxAmt;
    }

    public void onClickApproveAndComplete(ActionEvent actionEvent) {
        // Add event code here...
        
    }

    public void setPopup22(RichPopup popup22) {
        this.popup22 = popup22;
    }

    public RichPopup getPopup22() {
        return popup22;
    }

    public void onclickAppAndComplt(ActionEvent actionEvent) {
        // Add event code here...
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup22().show(popup34);
    }

    public void onClickAprAndFinish(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject vo = ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String funcRefId = row.getAttribute("OfferHdrId") == null ? "" : row.getAttribute("OfferHdrId").toString();
        String funcId = row.getAttribute("FuncId") == null ? "" : row.getAttribute("FuncId").toString();
        String reason = this.reasonAprAndComp.getValue() == null ? "Approved and Completed" : this.reasonAprAndComp.getValue().toString();
        //Caling for package
        onDirectApproveandComp(funcRefId,funcId,reason);
        ADFUtils.findOperation("Commit").execute();
    }
    
    public void onDirectApproveandComp(String funcRefId,String funcId,String reason){
        
              OperationBinding op=ADFUtils.findOperation("directAprAndComplete");
              op.getParamsMap().put("funcRefId",funcRefId);
              op.getParamsMap().put("funcId",funcId);
              op.getParamsMap().put("reason",reason);
              String flag=op.execute().toString();
              JSFUtils.addFacesInformationMessage(flag);
        }
    
    public void onDirectToDraft(String rcId,String userId,String funcId,String reason){
        
              OperationBinding op=ADFUtils.findOperation("directToDraft");
              op.getParamsMap().put("rcId",rcId);
              op.getParamsMap().put("userId",userId);
              op.getParamsMap().put("funcId",funcId);
              op.getParamsMap().put("reason",reason);
              String flag=op.execute().toString();
              JSFUtils.addFacesInformationMessage(flag);
        }

    public void setReasonAprAndComp(RichInputText reasonAprAndComp) {
        this.reasonAprAndComp = reasonAprAndComp;
    }

    public RichInputText getReasonAprAndComp() {
        return reasonAprAndComp;
    }
    //for discount access
    public String getUserDiscount() {
            ViewObject OfferHrdVO =
                ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
            ViewObject ofDiscFlwVo = ADFUtils.findIterator("OfferDiscountFlow_VO1Iterator").getViewObject();
            Row row = ofDiscFlwVo.getCurrentRow();
            String flowLevel =
                OfferHrdVO.getCurrentRow().getAttribute("FlowLevel") == null ?
                "" :
                OfferHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
            String seqApprver =
                row.getAttribute("SeqApprover") == null ?
                null :
                row.getAttribute("SeqApprover").toString();
                        
            return flowLevel;
        }
    //for delete of discflow on change to draft
    public void doDeleteDiscFlowLine(String ofHdrId,String userName){
            
                  OperationBinding op=ADFUtils.findOperation("deleteDiscountFlowLine");
                  op.getParamsMap().put("ofHdrId",ofHdrId);
                  op.getParamsMap().put("userName",userName);
                  String flag=op.execute().toString();
                  JSFUtils.addFacesInformationMessage(flag);
            }

    public void onEntrRqstedNetRent(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        BigDecimal rqstedNetRentBD = new BigDecimal(0);
        BigDecimal ofrTotalBD = new BigDecimal(0);
        BigDecimal exptdDiscBD = new BigDecimal(0);
        Row row = offerhdr.getCurrentRow();
        if(valueChangeEvent.getNewValue()!=null){
        String rqstedNetRent = valueChangeEvent.getNewValue()==null ? "0" : valueChangeEvent.getNewValue().toString();
        String offerTotal = row.getAttribute("OfferTotal")==null ? "0" : row.getAttribute("OfferTotal").toString();
            rqstedNetRentBD = new BigDecimal(rqstedNetRent);
            ofrTotalBD = new BigDecimal(offerTotal);
            exptdDiscBD = rqstedNetRentBD.subtract(ofrTotalBD);
            BigDecimal abs = exptdDiscBD.abs();
            String exptdDisc = abs.toString();
        row.setAttribute("ExpectedDiscount", exptdDisc);
        row.setAttribute("ExpectedDiscount_Trans", exptdDisc);
        }
    }

    public void setIt62ExpectedDisc(RichInputText it62ExpectedDisc) {
        this.it62ExpectedDisc = it62ExpectedDisc;
    }

    public RichInputText getIt62ExpectedDisc() {
        return it62ExpectedDisc;
    }

    public void doPullSteRentPaBasedOnPl(ActionEvent actionEvent) {
        // Add event code here...
        Row row = offerhdr.getCurrentRow();
        ViewObject Currvo =
            ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        Row curr = Currvo.getCurrentRow();
        System.err.println("leadname="+row.getAttribute("Trans_LeadNumber"));
        //        if (row.getAttribute("OfferFlag").equals("R") || row.getAttribute("OfferFlag").equals("S")){
            String plId = row.getAttribute("PlId") == null ? "" : row.getAttribute("PlId").toString();
            ViewObject plLinesVo =
                ADFUtils.findIterator("PlLinesVO1Iterator").getViewObject();
            ViewCriteria vc = plLinesVo.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                    System.err.println("PropertyId" + curr.getAttribute("PropertyId"));
                    System.err.println("BuildingId" + curr.getAttribute("BuildingId"));
                    System.err.println("PlId" + curr.getAttribute("PlId"));
                    System.err.println("UnitId" + curr.getAttribute("UnitId"));
            vcRow.setAttribute("PropertyId", curr.getAttribute("PropertyId"));
            vcRow.setAttribute("BuildId", curr.getAttribute("BuildingId"));
            vcRow.setAttribute("UnitId", curr.getAttribute("UnitId"));
            vcRow.setAttribute("PlId", plId);
            vc.addRow(vcRow);
            plLinesVo.applyViewCriteria(vc);
            plLinesVo.executeQuery();
            long io = plLinesVo.getEstimatedRowCount();
            //        System.err.println("estimationrowCount" + io);
            if (plLinesVo.getEstimatedRowCount() > 0) {
                Row re = plLinesVo.first();
                String basePrice = re.getAttribute("BasePrice")==null ? "" : re.getAttribute("BasePrice").toString();
                curr.setAttribute("SetRentPerAnnum", basePrice);
                System.out.println("SetRentPerAnnum %%%%%%%% "+basePrice);
            }
    }

    public void setOfferTotalWithoutTax(RichInputText offerTotalWithoutTax) {
        this.offerTotalWithoutTax = offerTotalWithoutTax;
    }

    public RichInputText getOfferTotalWithoutTax() {
        return offerTotalWithoutTax;
    }

    public void setNetRentWithoutTaxDtlLine(RichInputText netRentWithoutTaxDtlLine) {
        this.netRentWithoutTaxDtlLine = netRentWithoutTaxDtlLine;
    }

    public RichInputText getNetRentWithoutTaxDtlLine() {
        return netRentWithoutTaxDtlLine;
    }

    public void onSelectTaxOCline(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Row r = milesOtherVo.getCurrentRow();
        String taxCode=null;
        BigDecimal taxCbd = new BigDecimal(0);
        BigDecimal amtBD = new BigDecimal(0);
        BigDecimal taxamtBD = new BigDecimal(0);
        BigDecimal percntBD = new BigDecimal(100);
        BigDecimal totlAmtBD = new BigDecimal(0);
        System.out.println("New value :"+soc18.getValue());
        System.out.println("New value :"+valueChangeEvent.getNewValue());
        String amt = r.getAttribute("Attribute4")==null?"0":r.getAttribute("Attribute4").toString();
        String vatStng = valueChangeEvent.getNewValue()==null ? "0" : valueChangeEvent.getNewValue().toString();
        int vatInt = Integer.parseInt(vatStng);
        if(valueChangeEvent.getNewValue()!=null){
            System.out.println("In");
            if(vatInt==2){
                taxCode="5"; 
                System.out.println("tax code 5 :::"+taxCode);
            }else{
                taxCode="0";
                System.out.println("tax code 0 :::"+taxCode);
            }
            System.out.println("New value again inside :"+taxCode);
            taxCbd = new BigDecimal(taxCode);
            amtBD = new BigDecimal(amt);
            taxamtBD = (amtBD.multiply(taxCbd)).divide(percntBD);
            taxamtBD = taxamtBD.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            totlAmtBD = amtBD.add(taxamtBD);
        }
        r.setAttribute("InstallmentAmount", totlAmtBD);
        r.setAttribute("Attribute3", taxamtBD);
    }

    public void onEntrrOcLineAmt(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Row r = milesOtherVo.getCurrentRow();
        String amtLine=null;
        BigDecimal taxCbd = new BigDecimal(0);
        BigDecimal amtBD = new BigDecimal(0);
        BigDecimal taxamtBD = new BigDecimal(0);
        BigDecimal percntBD = new BigDecimal(100);
        BigDecimal totlAmtBD = new BigDecimal(0);
        System.out.println("New value line amt :"+valueChangeEvent.getNewValue());
        String taxCode = r.getAttribute("Attribute2")==null?"0":r.getAttribute("Attribute2").toString();
        if(valueChangeEvent.getNewValue()!=null){
            amtLine = valueChangeEvent.getNewValue().toString();
            amtBD = new BigDecimal(amtLine);
            taxCbd = new BigDecimal(taxCode);            
            taxamtBD = (amtBD.multiply(taxCbd)).divide(percntBD);
//                .divide(percntBD, 2);
            taxamtBD = taxamtBD.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            totlAmtBD = amtBD.add(taxamtBD);
        }
        r.setAttribute("InstallmentAmount", totlAmtBD);
        r.setAttribute("Attribute3", taxamtBD);
    }

    public void setSoc18(RichSelectOneChoice soc18) {
        this.soc18 = soc18;
    }

    public RichSelectOneChoice getSoc18() {
        return soc18;
    }
}
