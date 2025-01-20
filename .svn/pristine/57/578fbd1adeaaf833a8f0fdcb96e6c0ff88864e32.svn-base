import com.model.util.CommonJBOException;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.TimeZone;

import javax.faces.event.ActionEvent;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.RequestBody;

import okhttp3.Response;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;
import java.io.StringReader;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.naming.Context;

import javax.naming.InitialContext;

import javax.servlet.ServletContext;

import javax.sql.DataSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.PopupFetchEvent;


import oracle.apps.xdo.template.FOProcessor;
import oracle.apps.xdo.template.RTFProcessor;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.security.idm.providers.ad.ADUtils;

import org.apache.myfaces.trinidad.context.RequestContext;

import org.apache.myfaces.trinidad.event.ReturnEvent;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

import view.backing.MailServices;
import view.backing.MailTemplates;


public class BookingProcess {
    private RichPopup popUp;
    private Object utilDate;
    private RichTable t41;
    private RichCommandImageLink cil3;
    private RichInputListOfValues offer;
    private RichInputText responseTxt;
    private RichSelectOneChoice customerAR;
    private RichInputText attributResponse;
    private RichTable t4;
    private RichTable t8;
    private RichInputDate leaseStartDate;
    private RichInputDate leaseEndDate;
    private RichInputText bookingAmt;
    private RichPopup popup3;
    private RichInputText reason;
    private RichInputDate bookingDuedate;
    private RichSelectOneChoice billToAddress;
    private RichInputText applyReceiptTxt;
    private RichInputText invoiceResponseTxt;
    private RichInputComboboxListOfValues customerAR_T;
    private static String propertyBundle = "view.PropertyLease_ViewControllerBundle";

    String flag = "Y";
    private RichCommandImageLink cil5;
    private RichPopup popup5;
    private RichInputText it7;
    private RichInputDate id2;
    private RichInputText it5;
    private RichInputText it14;
    private RichInputText it15;
    private RichInputText it17;
    private RichInputDate id3;
    private RichInputDate id7;
    private RichInputText it12;
    private RichSelectBooleanCheckbox sbc1;
    private RichPopup popup27;

    public BookingProcess() {
    }
    String ress = "Y";

    public int onUnitValidation() {
        int count = 0;

        ViewObject BookingLineVo =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        RowSetIterator BookingLineVoRS =
            BookingLineVo.createRowSetIterator(null);

        if (BookingLineVo.getEstimatedRowCount() > 0) {
            while (BookingLineVoRS.hasNext()) {
                Row BookingLineVoRSRow = BookingLineVoRS.next();
                ViewObject OfferHdrDtlVo =
                    ADFUtils.findIterator("PropertyUnits_VO3Iterator").getViewObject();
                ViewCriteria vc = OfferHdrDtlVo.createViewCriteria();
                ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                vcRow.setAttribute("UnitId",
                                   BookingLineVoRSRow.getAttribute("UnitId"));
                vc.addRow(vcRow);
                OfferHdrDtlVo.applyViewCriteria(vc);
                OfferHdrDtlVo.executeQuery();
                if (OfferHdrDtlVo.first().getAttribute("Status").equals("AVAL")) {

                    count++;
                }


            }


        }
        return count;
    }


    public void onOtherOfferStatusChange() {
        ViewObject BookingLineVo =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        RowSetIterator BookingLineVoRS =
            BookingLineVo.createRowSetIterator(null);

        if (BookingLineVo.getEstimatedRowCount() > 0) {
            while (BookingLineVoRS.hasNext()) {
                Row BookingLineVoRSRow = BookingLineVoRS.next();
                ViewObject OfferHdrDtlVo =
                    ADFUtils.findIterator("OfferDetail_VO3Iterator").getViewObject();
                ViewCriteria vc = OfferHdrDtlVo.createViewCriteria();
                ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                vcRow.setAttribute("UnitId",
                                   BookingLineVoRSRow.getAttribute("UnitId"));
                vc.addRow(vcRow);
                OfferHdrDtlVo.applyViewCriteria(vc);
                OfferHdrDtlVo.executeQuery();

                if (OfferHdrDtlVo.getEstimatedRowCount() > 0) {
                    RowSetIterator OfferHdrDtlVoRS =
                        OfferHdrDtlVo.createRowSetIterator(null);
                    while (OfferHdrDtlVoRS.hasNext()) {
                        Row OfferHdrDtlVoRSrow = OfferHdrDtlVoRS.next();
                        ViewObject OfferHdrVo =
                            ADFUtils.findIterator("OfferHrd_VO4Iterator").getViewObject();
                        ViewCriteria vcs = OfferHdrVo.createViewCriteria();
                        ViewCriteriaRow vcsRow = vcs.createViewCriteriaRow();
                        vcsRow.setAttribute("OfferHdrId",
                                            OfferHdrDtlVoRSrow.getAttribute("OfferHdrId"));
                        vcs.addRow(vcsRow);
                        OfferHdrVo.applyViewCriteria(vcs);
                        OfferHdrVo.executeQuery();
                        OfferHdrVo.first().setAttribute("Status", "TERM");
                        OfferHdrVo.executeQuery();

                    }

                }
            }

        }
        //ADFUtils.findOperation("Commit").execute();
    }

    public void onChangeOfferStatus() {
        ViewObject BookingHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();

        ViewObject OfferHdrVo =
            ADFUtils.findIterator("OfferHrd_VO3Iterator").getViewObject();
        ViewCriteria vc = OfferHdrVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        //JSFUtils.addFacesErrorMessage("ERROR"+BookingHdrVo.getCurrentRow().getAttribute("OfferHdrId"));
        vcRow.setAttribute("OfferHdrId",
                           BookingHdrVo.getCurrentRow().getAttribute("OfferHdrId"));
        vc.addRow(vcRow);
        OfferHdrVo.applyViewCriteria(vc);
        OfferHdrVo.executeQuery();
        OfferHdrVo.first().setAttribute("Status", "BO");
    }


    public void setUnitStatus() {
        ViewObject BookingDtlVO1 =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        ViewObject PropertyUnits_VO1 =
            ADFUtils.findIterator("PropertyUnits_VO1Iterator").getViewObject();
        RowSetIterator quoteMileRS = BookingDtlVO1.createRowSetIterator(null);
        while (quoteMileRS.hasNext()) {
            Row r1 = quoteMileRS.next();
            ViewCriteria vc = PropertyUnits_VO1.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("UnitId", r1.getAttribute("UnitId"));
            vc.addRow(vcRow);
            PropertyUnits_VO1.applyViewCriteria(vc);
            PropertyUnits_VO1.executeQuery();
            Row re = PropertyUnits_VO1.first();
            re.setAttribute("Status", "BOOK");
        }
        PropertyUnits_VO1.executeQuery();
        ADFUtils.findOperation("Commit").execute();

    }

    public Object getBuisnessUnit(Object PropertyId) {
        Object result = null;
        ViewObject PropertyMaster_VO1Iterator =
            ADFUtils.findIterator("PropertyMaster_VO1Iterator").getViewObject();
        ViewCriteria offerDtlVC =
            PropertyMaster_VO1Iterator.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("PropertyId", PropertyId);
        offerDtlVC.addRow(offerDtlVCR);
        PropertyMaster_VO1Iterator.applyViewCriteria(offerDtlVC);
        PropertyMaster_VO1Iterator.executeQuery();
        Row re = PropertyMaster_VO1Iterator.first();
        if (PropertyMaster_VO1Iterator.getEstimatedRowCount() > 0) {
            result = re.getAttribute("OrgId");
        }


        return result;
    }


    public void onAttributesSave() {
        ViewObject BookingHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        ViewObject BookingDtlVo =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        BookingHdrVo.getCurrentRow().setAttribute("PropertyId",
                                                  BookingDtlVo.first().getAttribute("PropertyId"));
        BookingHdrVo.getCurrentRow().setAttribute("BuildingId",
                                                  BookingDtlVo.first().getAttribute("BuildingId"));
        //        BookingHdrVo.getCurrentRow().setAttribute("OrgId",
        //                                                  getBuisnessUnit(BookingDtlVo.first().getAttribute("PropertyId")));


    }


    public Object validateDays(Object MsDtlId) {

        ViewObject BookingHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();

        ViewObject milestoneDtlVO =
            ADFUtils.findIterator("MilestonesDtl_VO1Iterator").getViewObject();
        // ViewObject milestoneDtlVO = this.MilestoneDetail_VO1;
        ViewCriteria offerDtlVC = milestoneDtlVO.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("MsDtlId", MsDtlId);
        offerDtlVC.addRow(offerDtlVCR);
        milestoneDtlVO.applyViewCriteria(offerDtlVC);
        milestoneDtlVO.executeQuery();
        Object result = null;
        if (milestoneDtlVO.getEstimatedRowCount() > 0) {
            Row re = milestoneDtlVO.first();


            String val =
                re.getAttribute("NoOfDays") == null ? "0" : re.getAttribute("NoOfDays").toString();
            int noOfDays = Integer.parseInt(val);


            String DateFr =
                BookingHdrVo.getCurrentRow().getAttribute("BookingDate") ==
                null ? "" :
                BookingHdrVo.getCurrentRow().getAttribute("BookingDate").toString();
            SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = new Date();
            try {
                date1 = new SimpleDateFormat("dd/MM/yyyy").parse(DateFr);
            } catch (ParseException e) {
            }
            Calendar c = Calendar.getInstance();
            c.setTime(date1);
            c.add(Calendar.DATE, noOfDays);

            DateFormat format12 = new SimpleDateFormat("dd/MM/yyyy");
            String formatted = format12.format(c.getTime());

            result = formatted;
        }


        return result;
    }

    public String CreateBooking(Object offerid) {
        Object Val = offerid;
        ADFContext.getCurrent().getPageFlowScope().put("OfferId", offerid);

        ViewObject offerDtlVO =
            ADFUtils.findIterator("OfferDetail_VO2Iterator").getViewObject();
        ViewCriteria offerDtlVC = offerDtlVO.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        offerDtlVCR.setAttribute("OfferHdrId", Val);
        offerDtlVC.addRow(offerDtlVCR);
        offerDtlVO.applyViewCriteria(offerDtlVC);
        offerDtlVO.executeQuery();
        ViewObject BookingDtlVo =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        if (BookingDtlVo.getEstimatedRowCount() > 0) {
            RowSetIterator BookingDtlVoRS =
                BookingDtlVo.createRowSetIterator(null);
            while (BookingDtlVoRS.hasNext()) {
                Row cRow = BookingDtlVoRS.next();
                cRow.remove();
            }

        }


        // Iterating Lines
        RowSetIterator OfferDtlRS = offerDtlVO.createRowSetIterator(null);
        while (OfferDtlRS.hasNext()) {
            Row OfferDtlRow = OfferDtlRS.next();
            // inserting Row
            Row bookingRow = BookingDtlVo.createRow();
            //            bookingRow.setAttribute("BookingId", this.getBookingHeader_VO1().getCurrentRow().getAttribute("BookingId"));
            bookingRow.setAttribute("PropertyId",
                                    OfferDtlRow.getAttribute("PropertyId"));
            bookingRow.setAttribute("BuildingId",
                                    OfferDtlRow.getAttribute("BuildingId"));
            String UnitStatus =
                ValidateUnitStatus(OfferDtlRow.getAttribute("UnitId")) ==
                null ? "" :
                ValidateUnitStatus(OfferDtlRow.getAttribute("UnitId")).toString();
            String val = validateDate(UnitStatus).toString();
            //String val= validateDate(UnitStatus).toString();
            Date date1 = new Date();
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(val);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            bookingRow.setAttribute("UnitId",
                                    OfferDtlRow.getAttribute("UnitId"));


            if (!UnitStatus.equalsIgnoreCase("AVAL")) {
                if (OfferDtlRow.getAttribute("UnitId") != null) {
                    String leaseVa =
                        InvokeLeasenumber(OfferDtlRow.getAttribute("UnitId").toString()) ==
                        null ? "0" :
                        InvokeLeasenumber(OfferDtlRow.getAttribute("UnitId").toString());
                    BigDecimal LeadID = new BigDecimal(leaseVa);
                    bookingRow.setAttribute("LeaseId", LeadID);


                }
            }

            bookingRow.setAttribute("BaseRate",
                                    OfferDtlRow.getAttribute("BaseRate"));
            bookingRow.setAttribute("MunicipalityCharges",
                                    OfferDtlRow.getAttribute("MunicipalityCharges"));
            bookingRow.setAttribute("ElectricityCharges",
                                    OfferDtlRow.getAttribute("ElectricityCharges"));
            bookingRow.setAttribute("SecurityDeposite",
                                    OfferDtlRow.getAttribute("SecurityDeposite"));
//            bookingRow.setAttribute("DiscountRate",
//                                    OfferDtlRow.getAttribute("DiscountAmount"));
            bookingRow.setAttribute("Attribute3",
                                    OfferDtlRow.getAttribute("Attribute3"));
            bookingRow.setAttribute("MunicipalityPercentage",
                                    OfferDtlRow.getAttribute("MunicipalityPercentage"));
            bookingRow.setAttribute("ThirdPartyServCharge",
                                    OfferDtlRow.getAttribute("ThirdPartyServCharge"));
            bookingRow.setAttribute("OtherGovntChargeRnew",
                                    OfferDtlRow.getAttribute("OtherGovntChargeRnew"));
            bookingRow.setAttribute("OtherGovntChargeNew",
                                    OfferDtlRow.getAttribute("OtherGovntChargeNew"));
            bookingRow.setAttribute("EjariPaymentCharge",
                                    OfferDtlRow.getAttribute("EjariPaymentCharge"));


            bookingRow.setAttribute("TaxAmount",
                                    OfferDtlRow.getAttribute("TaxAmount"));
            bookingRow.setAttribute("TotalRate",
                                    OfferDtlRow.getAttribute("TotalRate"));

            java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
            oracle.jbo.domain.Date domadate =
                new oracle.jbo.domain.Date(sqlDate);
            bookingRow.setAttribute("UnitAvlFrom", domadate);
            bookingRow.setAttribute("UnitAvlStatus", UnitStatus);

            BookingDtlVo.insertRow(bookingRow);
        }
        BookingDtlVo.executeQuery();


        CreateMilestone();
        CreateOtherPaymentsFromOffer();

        ViewObject BookingCustomer_VO1 =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();

        if (BookingCustomer_VO1.getEstimatedRowCount() == 0) {
            Row BRe = BookingCustomer_VO1.createRow();
            BookingCustomer_VO1.insertRow(BRe);
            BookingCustomer_VO1.executeQuery();
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(t8);
        }
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(t8);
        return "Suceess";
    }


    public String CreateOtherPaymentsFromOffer() {
        Object Val =
            ADFContext.getCurrent().getPageFlowScope().get("OfferId") == null ?
            "" :
            ADFContext.getCurrent().getPageFlowScope().get("OfferId").toString();

        ViewObject BookingMsDtlVo2 =
            ADFUtils.findIterator("BookingMilestonesOtherChargesVO1Iterator").getViewObject();
        // Filetering Offer Line
        if (BookingMsDtlVo2.getEstimatedRowCount() > 0) {
            RowSetIterator BookingMsDtlVo2rs =
                BookingMsDtlVo2.createRowSetIterator(null);
            while (BookingMsDtlVo2rs.hasNext()) {
                Row cRow = BookingMsDtlVo2rs.next();
                cRow.remove();

            }

        }
        ViewObject milestoneDtlVO =
            ADFUtils.findIterator("OfferMilestoneDetail_VO3Iterator").getViewObject();
        //        ViewObject milestoneDtlVO =
        //            this.OfferMilestoneDetail_VO4.getViewObject();
        ViewCriteria offerDtlVC = milestoneDtlVO.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("OfferHdrId", Val);
        offerDtlVCR.setAttribute("MilestoneType", "OC");
        offerDtlVC.addRow(offerDtlVCR);
        milestoneDtlVO.applyViewCriteria(offerDtlVC);
        milestoneDtlVO.executeQuery();

        // Iterating Lines
        RowSetIterator OfferDtlRS = milestoneDtlVO.createRowSetIterator(null);
        while (OfferDtlRS.hasNext()) {
            Row OfferDtlRow = OfferDtlRS.next();
            // inserting Row
            Row bookingRow = BookingMsDtlVo2.createRow();
            //            bookingRow.setAttribute("BookingId", this.getBookingHeader_VO1().getCurrentRow().getAttribute("BookingId"));

            bookingRow.setAttribute("InstallmentType",
                                    OfferDtlRow.getAttribute("InstallmentType"));


            bookingRow.setAttribute("InstallmentAmount",
                                    OfferDtlRow.getAttribute("InstallmentAmount"));


            bookingRow.setAttribute("MilestoneType", "OC");
            //            MilestoneType
            //                  java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
            //                  oracle.jbo.domain.Date domadate=new oracle.jbo.domain.Date(sqlDate);
            //                  bookingRow.setAttribute("UnitAvlFrom", domadate);
            //                  bookingRow.setAttribute("UnitAvlStatus", UnitStatus);

            BookingMsDtlVo2.insertRow(bookingRow);
        }
        BookingMsDtlVo2.executeQuery();


        //        ViewObject OfferHdrVo=this.getOfferHrd_VO1().getViewObject();
        //        ViewCriteria vc = OfferHdrVo.createViewCriteria();
        //        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        //        vcRow.setAttribute("OfferHdrId", Val);
        //        vc.addRow(vcRow);
        //
        //        OfferHdrVo.applyViewCriteria(vc);
        //        OfferHdrVo.executeQuery();
        //        Row OfferHdrRow=OfferHdrVo.first();
        //
        //        ViewObject BookingHdrVo=this.getBookingHeader_VO1().getViewObject();
        //        Row BHdrrow=BookingHdrVo.createRow();
        //        BHdrrow.setAttribute("OfferHdrId", OfferHdrRow.getAttribute("OfferHdrId"));
        //        BHdrrow.setAttribute("TotalRent", OfferHdrRow.getAttribute("OfferTotal"));
        //
        //        //BHdrrow.setAttribute("BookingDueDate", OfferHdrRow.getAttribute("OfferDate"));
        //
        //        BookingHdrVo.insertRow(BHdrrow);
        //       BookingHdrVo.executeQuery();


        //
        //        ViewObject BookingDtlVo=this.getBookingDetail_VO1().getViewObject();
        //        Row BKdtlRe=BookingDtlVo.createRow();
        //


        // BookingDtl.executeQuery();

        return "Suceess";

    }

    public String CreateMilestone() {
        Object Val =
            ADFContext.getCurrent().getPageFlowScope().get("OfferId") == null ?
            "" :
            ADFContext.getCurrent().getPageFlowScope().get("OfferId").toString();

        ViewObject BookingMsDtlVo =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        // Filetering Offer Line
        if (BookingMsDtlVo.getEstimatedRowCount() > 0) {
            RowSetIterator BookingMsDtlVors =
                BookingMsDtlVo.createRowSetIterator(null);
            while (BookingMsDtlVors.hasNext()) {
                Row cRow = BookingMsDtlVors.next();
                cRow.remove();

            }

        }

        ViewObject milestoneDtlVO =
            ADFUtils.findIterator("OfferMilestoneDetail_VO1Iterator").getViewObject();
        //        ViewObject milestoneDtlVO =
        //            this.OfferMilestoneDetail_VO1.getViewObject();
        ViewCriteria offerDtlVC = milestoneDtlVO.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("OfferHdrId", Val);
        offerDtlVCR.setAttribute("MilestoneType", "BK");
        offerDtlVC.addRow(offerDtlVCR);
        milestoneDtlVO.applyViewCriteria(offerDtlVC);
        milestoneDtlVO.executeQuery();

        // Iterating Lines
        RowSetIterator OfferDtlRS = milestoneDtlVO.createRowSetIterator(null);
        while (OfferDtlRS.hasNext()) {
            Row OfferDtlRow = OfferDtlRS.next();
            // inserting Row
            Row bookingRow = BookingMsDtlVo.createRow();
            //            bookingRow.setAttribute("BookingId", this.getBookingHeader_VO1().getCurrentRow().getAttribute("BookingId"));
            bookingRow.setAttribute("SeqNumber",
                                    OfferDtlRow.getAttribute("SeqNumber"));
            bookingRow.setAttribute("InstallmentType",
                                    OfferDtlRow.getAttribute("InstallmentType"));
            //            String UnitStatus =ValidateUnitStatus(OfferDtlRow.getAttribute("UnitId")) == null ? "" :ValidateUnitStatus(OfferDtlRow.getAttribute("UnitId")).toString();
            // String val= validateDate(UnitStatus).toString();
            //String val= validateDate(UnitStatus).toString();
            //            Date date1=new Date();
            //                  try {
            //                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(val);
            //                    } catch (ParseException e) {
            //                                   }

            //OfferMsDtlId
            bookingRow.setAttribute("OfferMsDtlId",
                                    OfferDtlRow.getAttribute("OfferMsDtlId"));

            bookingRow.setAttribute("InstallmentPct",
                                    OfferDtlRow.getAttribute("InstallmentPct"));
            bookingRow.setAttribute("InstallmentAmount",
                                    OfferDtlRow.getAttribute("InstallmentAmount"));
            bookingRow.setAttribute("Criteria",
                                    OfferDtlRow.getAttribute("Criteria"));
            bookingRow.setAttribute("ChargeType",
                                    OfferDtlRow.getAttribute("ChargeType"));
            bookingRow.setAttribute("PaymentTerm",
                                    OfferDtlRow.getAttribute("PaymentTerm"));
            bookingRow.setAttribute("DueDate",
                                    OfferDtlRow.getAttribute("DueDate"));

            if (OfferDtlRow.getAttribute("MsDtlId") != null) {
                String val =
                    validateDays(OfferDtlRow.getAttribute("MsDtlId")) == null ?
                    "" : OfferDtlRow.getAttribute("MsDtlId").toString();

                if (val != "") {
                    Date date1 = new Date();
                    try {
                        date1 = new SimpleDateFormat("dd/MM/yyyy").parse(val);
                    } catch (ParseException e) {
                    }
                    java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
                    oracle.jbo.domain.Date domadate =
                        new oracle.jbo.domain.Date(sqlDate);
                    System.err.println("==Date==" + domadate);


                    // bookingRow.setAttribute("DueDate", domadate);
                    bookingRow.setAttribute("MilestoneType", "BK");
                    //            MilestoneType
                    //                  java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
                    //                  oracle.jbo.domain.Date domadate=new oracle.jbo.domain.Date(sqlDate);
                    //                  bookingRow.setAttribute("UnitAvlFrom", domadate);
                    //                  bookingRow.setAttribute("UnitAvlStatus", UnitStatus);


                }

            }

            BookingMsDtlVo.insertRow(bookingRow);
        }

        //        BookingMsDtlVo.executeQuery();


        //        ViewObject OfferHdrVo=this.getOfferHrd_VO1().getViewObject();
        //        ViewCriteria vc = OfferHdrVo.createViewCriteria();
        //        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        //        vcRow.setAttribute("OfferHdrId", Val);
        //        vc.addRow(vcRow);
        //
        //        OfferHdrVo.applyViewCriteria(vc);
        //        OfferHdrVo.executeQuery();
        //        Row OfferHdrRow=OfferHdrVo.first();
        //
        //        ViewObject BookingHdrVo=this.getBookingHeader_VO1().getViewObject();
        //        Row BHdrrow=BookingHdrVo.createRow();
        //        BHdrrow.setAttribute("OfferHdrId", OfferHdrRow.getAttribute("OfferHdrId"));
        //        BHdrrow.setAttribute("TotalRent", OfferHdrRow.getAttribute("OfferTotal"));
        //
        //        //BHdrrow.setAttribute("BookingDueDate", OfferHdrRow.getAttribute("OfferDate"));
        //
        //        BookingHdrVo.insertRow(BHdrrow);
        //       BookingHdrVo.executeQuery();


        //
        //        ViewObject BookingDtlVo=this.getBookingDetail_VO1().getViewObject();
        //        Row BKdtlRe=BookingDtlVo.createRow();
        //


        // BookingDtl.executeQuery();

        return "Suceess";
    }

    public void onClickOffer(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            //booking duplicate validation
            ViewObject offerVo =ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
            Row r=offerVo.getCurrentRow();
            Object offerid=r.getAttribute("OfferHdrId");
            System.err.println("print1"+r.getAttribute("OfferHdrId"));
            System.err.println("Print="+valueChangeEvent.getNewValue());
            Long count=BookingDuplicateValidate(offerid);
            System.err.println("count"+count);
            //
            if(count==0){
           
            Object OfferId =
                offerVo.getCurrentRow().getAttribute("OfferHdrId");
            CreateBooking(OfferId);
            AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
            }
            else
            {
                r.setAttribute("OrgId",null);
                r.setAttribute("TotalRent1",null);
                r.setAttribute("PaymentPlan_Trans",null);
                r.setAttribute("Lease_Start_Date_Trans",null);
                r.setAttribute("Lease_End_Date_trans",null);
                r.setAttribute("OfferHdrIdTrans",null);
                r.setAttribute("OfferHdrId",null);
                JSFUtils.addFacesErrorMessage("Offer number already exist for another transaction");
            }
        }

    }
    public long BookingDuplicateValidate(Object offerid)
    {
        ViewObject vo=ADFUtils.findIterator("BookingDuplicateValidation_ROVO1Iterator").getViewObject();   
                        ViewCriteria vc=vo.createViewCriteria();
                               ViewCriteriaRow vcr=vc.createViewCriteriaRow();
                               vcr.setAttribute("OfferHdrId",offerid);
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
                                                     //
                                                     String attb1 = r.getAttribute("Attribute1")==null ? "":r.getAttribute("Attribute1").toString();
                                                     String rvsnNo = r.getAttribute("RevisionNo")==null ? "":r.getAttribute("RevisionNo").toString();
                                                     if(attb1.equalsIgnoreCase(rvsnNo))
                                                     {
                                                     
                                             Flag="D";
                                             System.err.println("Flag="+Flag);
                                                     }
                                                     //
                                                     if(attb1.equalsIgnoreCase(""))
                                                     {
                                                         Flag="D";
                                                         System.err.println("Flag when attribute1 is null= "+Flag);
                                                     }
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
    public String ValidateUnitStatus(Object val) {
        ViewObject OfferDtlVo =
            ADFUtils.findIterator("PropertyUnits_VO2Iterator").getViewObject();


        ViewCriteria vc = OfferDtlVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();


        vcRow.setAttribute("UnitId", val);
        vc.addRow(vcRow);

        OfferDtlVo.applyViewCriteria(vc);
        OfferDtlVo.executeQuery();
        Row re = OfferDtlVo.first();

        String St = re.getAttribute("Status").toString();
        return St;


    }

    public Object validateDate(String Status) {
        Object result = null;
        if (Status.equals("AVAL")) {
            ViewObject BkHdrVo =
                ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
            Row re = BkHdrVo.getCurrentRow();
            String DateFr =
                re.getAttribute("BookingDate") == null ? "" : re.getAttribute("BookingDate").toString();
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

            result = formatted;

        } else {
            ViewObject BkHdrVo =
                ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
            Row re = BkHdrVo.getCurrentRow();
            String DateFr =
                re.getAttribute("Lease_End_Date_trans") == null ? "" :
                re.getAttribute("Lease_End_Date_trans").toString();
            Date date1 = new Date();
            try {
                date1 =
                        new SimpleDateFormat("yyyy-MM-dd").parse(DateFr); //dd/MM/yyyy
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar c = Calendar.getInstance();
            c.setTime(date1);
            c.add(Calendar.DATE, 1);

            DateFormat format12 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = format12.format(c.getTime());
            result = formatted;

        }


        return result;
    }


    public String InvokeLeasenumber(String value) {
        OperationBinding obs = ADFUtils.findOperation("InvokeLeaseNumber");
        obs.getParamsMap().put("b_unitid", value);
        obs.execute();


        return obs.getResult().toString();
    }


    public void onClickBook(ActionEvent actionEvent) {

        ViewObject BookingDtl =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();

        ViewObject OfferHdrVo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        RowSetIterator quoteMileRS = BookingDtl.createRowSetIterator(null);
        while (quoteMileRS.hasNext()) {
            Row r1 = quoteMileRS.next();
            r1.remove();
        }
        BookingDtl.executeQuery();

        Row Hdrr = OfferHdrVo.getCurrentRow();
        //        ViewCriteria vc = OfferHdrVo.createViewCriteria();
        //               ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        //
        //               vcRow.setAttribute("OfferHdrId", ADFContext.getCurrent().getSessionScope().get("OfferId"));
        //               vc.addRow(vcRow);
        //
        //               OfferHdrVo.applyViewCriteria(vc);
        //               OfferHdrVo.executeQuery();

        ViewObject OfferDtlVo =
            ADFUtils.findIterator("OfferDetail_VO2Iterator").getViewObject();


        ViewCriteria vc = OfferDtlVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();


        vcRow.setAttribute("OfferHdrId",
                           ADFContext.getCurrent().getPageFlowScope().get("OfferId"));
        vc.addRow(vcRow);

        OfferDtlVo.applyViewCriteria(vc);
        OfferDtlVo.executeQuery();


        Row detailRow = OfferDtlVo.first();


        RowSetIterator rs = OfferDtlVo.createRowSet("");
        while (rs.hasNext()) {

            detailRow = rs.next();

            Row detBokrow = BookingDtl.createRow();
            // ADFUtils.findOperation("CreateInsert").execute();
            //Row detBokrow=BookingDtl.getCurrentRow();
            detBokrow.setAttribute("PropertyId",
                                   detailRow.getAttribute("PropertyId"));
            detBokrow.setAttribute("BuildingId",
                                   detailRow.getAttribute("BuildingId"));
            String UnitStatus =
                ValidateUnitStatus(detailRow.getAttribute("UnitId")) == null ?
                "" :
                ValidateUnitStatus(detailRow.getAttribute("UnitId")).toString();
            String val = validateDate(UnitStatus).toString();


            Date date1 = new Date();

            try {
                date1 = new SimpleDateFormat("yyyy/MM/dd").parse(val);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (UnitStatus != "AVAL") {
                if (detailRow.getAttribute("UnitId") != null) {
                    String leaseVa =
                        InvokeLeasenumber(detailRow.getAttribute("UnitId").toString());
                    BigDecimal LeadID = new BigDecimal(leaseVa);
                    detBokrow.setAttribute("LeaseId", LeadID);


                }
                //InvokeLeasenumber(detailRow.getAttribute("UnitId").toString());
            }


            detBokrow.setAttribute("UnitId", detailRow.getAttribute("UnitId"));
            detBokrow.setAttribute("BaseRate",
                                   detailRow.getAttribute("BaseRate"));
//            detBokrow.setAttribute("DiscountRate",
//                                   detailRow.getAttribute("DiscountAmount"));
            detBokrow.setAttribute("Attribute3",
                                   detailRow.getAttribute("Attribute3"));
            detBokrow.setAttribute("TaxAmount",
                                   detailRow.getAttribute("TaxAmount"));
            detBokrow.setAttribute("TotalRate",
                                   detailRow.getAttribute("TotalRate"));
            //UnitAvlFrom
            java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
            oracle.jbo.domain.Date domadate =
                new oracle.jbo.domain.Date(sqlDate);
            detBokrow.setAttribute("UnitAvlFrom", domadate);
            detBokrow.setAttribute("UnitAvlStatus", UnitStatus);
            BookingDtl.insertRow(detBokrow);

        }
        BookingDtl.executeQuery();
    }

    public void onClickClose(ActionEvent actionEvent) {
        ADFUtils.findOperation("Rollback").execute();
    }

    public String onValidatebookingDateLeaseDate() {
        ViewObject BookingHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        String reval = "Y";
        String dateStart =
            BookingHdrVo.getCurrentRow().getAttribute("BookingDate").toString();
        String dateStop =
            BookingHdrVo.getCurrentRow().getAttribute("Lease_Start_Date_Trans").toString();

        System.err.println("dateStart" + dateStart);

        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();


        }
        int diffInDays =
            (int)((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));

        System.err.println("DIFFDAYS" + diffInDays);

        //diffInDays=16;
//        if (diffInDays > 15) { 
       
        Row bookingHdrRow = BookingHdrVo.getCurrentRow();
        String offerNo= bookingHdrRow.getAttribute("OfferHdrIdTrans").toString();
        ViewObject offerHdrVo =
            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        ViewCriteria vc = offerHdrVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("OfferNumber",offerNo);
        vc.addRow(vcRow);
        offerHdrVo.applyViewCriteria(vc);
        offerHdrVo.executeQuery();
        Row re = offerHdrVo.first();
        String offerType = re.getAttribute("OfferType")==null ? "" : re.getAttribute("OfferType").toString();
        
        System.out.println("offer type :: "+offerType);
        if(offerType.equalsIgnoreCase("COM")){
            if (diffInDays > 30) { //New Request on 25-APR from client
                ress = "N";
                reval = "C";
            }
        }else{
//            if (diffInDays > 15) { //New Request on 25-APR from client
            if (diffInDays > 30) { //New Request on 18-AUG from client
                ress = "N";
                reval = "N";
            }
        }
       

        return reval;

    }


    public void onClickSave(ActionEvent actionEvent) {

        ViewObject ReceiptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();

        ViewObject BookingHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row bookRow = BookingHdrVo.getCurrentRow();
//        String finance = (String)JSFUtils.resolveExpression("#{sessionScope.UR}");
//        if((!bookRow.getAttribute("Status").toString().equalsIgnoreCase("DRA") && finance.equalsIgnoreCase("ACCCOUNTS"))
//           || (!bookRow.getAttribute("Status1").toString().equalsIgnoreCase("DRA") && finance.equalsIgnoreCase("ACCOUNTS_MANAGER"))){
//            ADFUtils.findOperation("Commit1").execute();
//            System.out.println("for Ack comit");
//        }else{
        if (bookRow.getAttribute("OfferHdrId") != null &&
            bookRow.getAttribute("BookingDate") != null &&
            bookRow.getAttribute("PaymentPlan_Trans") != null) {
            //27-May-2020 stoping booking and lease start date validation on save and moving to on submit
//            String onval = onValidatebookingDateLeaseDate();
//            if (onval == "Y") {
                //this code is been used for min booking amt 500
                //                String bookingAmount =
                //                    bookRow.getAttribute("BookingAmount") == null ? "" :
                //                    bookRow.getAttribute("BookingAmount").toString();
                //                Double bkAmount = Double.parseDouble(bookingAmount);
                //                    if(bkAmount>=500){


                String result = "Y";
                ViewObject bookCustVO =
                    ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
                Row cusRow = bookCustVO.getCurrentRow();
                String custArName =
                    cusRow.getAttribute("Trans_CustIdAr") == null ? "" :
                    cusRow.getAttribute("Trans_CustIdAr").toString();
                String custArNo =
                    cusRow.getAttribute("CustomerNumberAr") == null ? "" :
                    cusRow.getAttribute("CustomerNumberAr").toString();
                String billToAddr =
                    cusRow.getAttribute("BillToAddr") == null ? "" :
                    cusRow.getAttribute("BillToAddr").toString();
                String shipToAddr =
                    cusRow.getAttribute("ShipToAddr") == null ? "" :
                    cusRow.getAttribute("ShipToAddr").toString();
//                System.out.println("custArName " + custArName + " custArNo " +
//                                   custArNo + " billToAddr " + billToAddr);

//                if ((custArName != null && !custArName.equals("")) &&
//                    (billToAddr != null && !billToAddr.equals(""))) {
                    //            System.out.println("Entered CustomerName ::::::::::");
                    ViewObject getFuncodeVo =
                        ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                    getFuncodeVo.setNamedWhereClauseParam("F_ID", "BK");
                    getFuncodeVo.executeQuery();
                    if (bookRow.getAttribute("BookingNumber1") == null) {
                        String name =
                            xxfnd.generateDocNo("BK", "Booking_AMDataControl").toString();
                        Object valu = name;
                        bookRow.setAttribute("BookingNumber1", valu);
                        bookRow.setAttribute("FuncId",
                                             getFuncodeVo.first().getAttribute("FuncId"));
                    }
                    onAttributesSave();
                    //13-May-2020 for setting BkAmt and BkDueDate
                    doCalBkAmtAndBkDueDate();
                    ADFUtils.findOperation("Commit1").execute();
                    JSFUtils.addFacesInformationMessage("Booking Saved.....!");
                    //                }else{
                    //                    JSFUtils.addFacesInformationMessage("Minimum booking amount should be 500");
                    //                }

                    if (ReceiptVo.getEstimatedRowCount() > 0) {
                    }

//                } 
//                else {
//                    ress = "N";
//                    if (custArName == null || custArName.equals("")) {
//                        result = "N";
//                        JSFUtils.addFacesErrorMessage("You must select Custom AR Name");
//                    }
//                    //                        if (custArNo == null || custArNo.equals("")) {
//                    //                            result = "N";
//                    //                            JSFUtils.addFacesErrorMessage("You must Provide Customer AR Number");
//                    //                        }
//                    //            if (row1.getAttribute("ShipToAddr") == null) {
//                    //                JSFUtils.addFacesErrorMessage("You must select Ship to address");
//                    //            }
//                    if (shipToAddr == null || shipToAddr.equals("")) {
//                        result = "N";
//                        JSFUtils.addFacesErrorMessage("You must select Ship to address");
//                    }
//                    if (billToAddr == null || billToAddr.equals("")) {
//                        result = "N";
//                        JSFUtils.addFacesErrorMessage("You must select Bill to address");
//                    }
//
//
//                }

//            } else {
//                if(onval.equalsIgnoreCase("C")){   //New Request on 25-APR from client
//                    JSFUtils.addFacesErrorMessage("Free Days should be less than or equals to 30..!");   
//                }else{
//                JSFUtils.addFacesErrorMessage("Free Days should be less than or equals to 15..!");
//                }
//            }


        } else {

            ress = "N";
            if (bookRow.getAttribute("OfferHdrId") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Offer Number");
            }
            if (bookRow.getAttribute("BookingDate") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Booking Date");
            }
            if (bookRow.getAttribute("PaymentPlan_Trans") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Payment Plan");
            }
        }
//        }
    }

    public String OnClickPageClose() {
        if (ress == "Y") {
            return "back";
        }
        return null;
    }


    public void OnTotalRent(ValueChangeEvent valueChangeEvent) {

    }


    public void onClickAddReceipt(ActionEvent actionEvent) {
        OperationBinding operBnd =
            ADFUtils.getBindingContainer().getOperationBinding("CreateInsert3");
        operBnd.execute();
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        ViewObject bookCustVO =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        Row cusRow = bookCustVO.getCurrentRow();

        Object custName =
            cusRow.getAttribute("CustName") == null ? "" : cusRow.getAttribute("CustName").toString();
        if (custName == null) {
            JSFUtils.addFacesErrorMessage("You must enter the data in Customer details");
        } else {
            Row receiptRow = receiptVo.getCurrentRow();
            receiptRow.setAttribute("CustomerName",
                                    cusRow.getAttribute("CustName"));
            receiptRow.setAttribute("BankName",
                                    cusRow.getAttribute("CustBankName"));
            receiptRow.setAttribute("PayRefNumber",
                                    cusRow.getAttribute("CustBankAccNumber"));
            receiptRow.setAttribute("BankBranchName",
                                    cusRow.getAttribute("CustBranchName"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(t41);
            RichPopup.PopupHints rp = new RichPopup.PopupHints();

            popUp.show(rp);
        }

    }

    public void onChangeAmnt(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject BookHdr =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        String Totalrent =
            BookHdr.getCurrentRow().getAttribute("TotalRent") == null ? "0" :
            BookHdr.getCurrentRow().getAttribute("TotalRent").toString();
        String BookAmnt =
            valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
        Double Totalre = new Double(Totalrent);
        Double BookAm = new Double(BookAmnt);
        Double ValueforYear = Totalre / 365;
        Double NofDuDays = BookAm / ValueforYear;


        ViewObject BkHdrVo =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        Row re = BkHdrVo.getCurrentRow();
        String DateFr =
            re.getAttribute("BaseRate") == null ? "" : re.getAttribute("BaseRate").toString();
        Date date1 = new Date();
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE, (int)Math.round(NofDuDays));
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
        re.setAttribute("BookingDueDate", domadate);


    }

    public String onReturn() {
        // Add event code here...
        String bu = null;
        Object Val =
            ADFContext.getCurrent().getPageFlowScope().get("TaskFlowVal") ==
            null ? "" :
            ADFContext.getCurrent().getPageFlowScope().get("TaskFlowVal").toString();

        if (Val.equals("Offer")) {
            bu = "return";
        } else {
            bu = "back";
        }

        return bu;
    }

    public void setPopUp(RichPopup popUp) {

        this.popUp = popUp;

    }


    public RichPopup getPopUp() {

        return popUp;

    }

    public void onClickPopupClose(ActionEvent actionEvent) {
        ADFUtils.findOperation("Rollback").execute();
        this.getPopUp().cancel();
    }

    public void onClickPopupOpenEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        popUp.show(hints);
    }

    public void onClickSaveReceipt(ActionEvent actionEvent) {

        OperationBinding operBnd =

            ADFUtils.getBindingContainer().getOperationBinding("Commit1");

        operBnd.execute();

    }


    public void onclickBookingConfirm(ActionEvent actionEvent) {
        ViewObject BookingDtlVO1 =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        RowSetIterator quoteMileRS = BookingDtlVO1.createRowSetIterator(null);
        while (quoteMileRS.hasNext()) {
            Row r1 = quoteMileRS.next();
            ViewObject PropertyUnits_VO1 =
                ADFUtils.findIterator("PropertyUnits_VO1Iterator").getViewObject();
            ViewCriteria vc = PropertyUnits_VO1.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("UnitId", r1.getAttribute("UnitId"));
            vc.addRow(vcRow);
            PropertyUnits_VO1.applyViewCriteria(vc);
            PropertyUnits_VO1.executeQuery();
            Row re = PropertyUnits_VO1.first();
            re.setAttribute("Status", "BK");


        }
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Booking Process Confirmed...!");

    }

    public void setT41(RichTable t41) {
        this.t41 = t41;
    }

    public RichTable getT41() {
        return t41;
    }

    public void addReceiptDetailInPopUp(PopupFetchEvent popupFetchEvent) {
        if (popupFetchEvent.getLaunchSourceClientId().equals(cil3)) {
            ViewObject receiptVo =
                ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
            ViewObject bookCustVO =
                ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
            Row cusRow = bookCustVO.getCurrentRow();

            Object custName =
                cusRow.getAttribute("CustName") == null ? "" : cusRow.getAttribute("CustName").toString();
            if (custName == null) {
                JSFUtils.addFacesErrorMessage("You must enter the data in Customer details");
            } else {
                Row receiptRow = receiptVo.createRow();


                receiptRow.setAttribute("CustomerName",
                                        cusRow.getAttribute("CustName"));
                receiptRow.setAttribute("BankName",
                                        cusRow.getAttribute("CustBankName"));
                receiptRow.setAttribute("PayRefNumber",
                                        cusRow.getAttribute("CustBankAccNumber"));
                receiptRow.setAttribute("BankBranchName",
                                        cusRow.getAttribute("CustBranchName"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(popUp);
            }
        }
    }

    public void setCil3(RichCommandImageLink cil3) {
        this.cil3 = cil3;
    }

    public RichCommandImageLink getCil3() {
        return cil3;
    }

    public void onClickDeleRecpt(ActionEvent actionEvent) {
//        // Add event code here...
//        ViewObject vo =
//            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
//        vo.getCurrentRow().remove();
//        AdfFacesContext.getCurrentInstance().addPartialTarget(t41);
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup5().show(popup34);

    }

    public void onclickSubmit(ActionEvent actionEvent) {
        
        //17-dec-20 to proceed based on offer status
        String ofrStatus = valdtOfferStatusOnSubmit();
        if(ofrStatus.equalsIgnoreCase("Y")){
        //27-May-2020 stoping booking and lease start date validation on save and moving to on submit
        String onval = onValidatebookingDateLeaseDate();
        if (onval.equalsIgnoreCase("Y")) {
        onClickSave(actionEvent);
        String ResultVal = null;
        Double bkAmount = 0.0;
        ViewObject BookingHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        ViewObject vo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        Object org = BookingHdrVo.getCurrentRow().getAttribute("OrgId");
        Object prop = BookingHdrVo.getCurrentRow().getAttribute("PropertyId");
        Object unit = BookingHdrVo.getCurrentRow().getAttribute("BuildingId");

                            String bookingAmount =
                                row.getAttribute("BookingAmount") == null ? "0" :
                                row.getAttribute("BookingAmount").toString();
        //                    bkAmount = Double.parseDouble(bookingAmount);
        //        if (bkAmount == 0.0) {
//                            System.out.println("Booking Amount :: "+bookingAmount);
                            
        ViewObject rcptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
//        System.out.println("Estm :: "+rcptVo.getEstimatedRowCount());
        if(rcptVo.getEstimatedRowCount()==0){
//        if (bookingAmount.equals("0")) {
//            System.out.println("Booking Amount inside if :: "+bookingAmount);
//            String bookingAmount =
//                row.getAttribute("BookingAmount") == null ? "" :
//                row.getAttribute("BookingAmount").toString();
            bkAmount = Double.parseDouble(bookingAmount);
            ress = "N";
            JSFUtils.addFacesErrorMessage("Please Generate the Receipt....!");
        } else {
            //            if (bkAmount >= 500) {
            try {
//                ResultVal =
//                        xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
//                                              row.getAttribute("FuncId"),
//                                              row.getAttribute("BookingId1"),
//                                              0, "XXPM_BOOKING_HEADER",
//                                              "STATUS", "BOOKING_ID", org,
//                                              prop, unit, null, null);
        OperationBinding op=ADFUtils.findOperation("submitBkForAppr");
          op.getParamsMap().put("bookingId",row.getAttribute("BookingId1").toString());
          ResultVal=op.execute().toString();
//          JSFUtils.addFacesInformationMessage(flag);   

            } catch (Exception e) {
                e.printStackTrace();
            }

            if (ResultVal.equalsIgnoreCase("Success")) {
                onChangeReceiptStatus();
                ADFUtils.findOperation("Commit").execute();
                vo.executeQuery();
                //mail service
//                    doSendMailOnSubmit();
                JSFUtils.addFacesInformationMessage("Submitted For Approval");
            } else {
                JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
            }
            // 27-May-2020 stoping booking and lease start date validation on save and moving to on submit
        }
            } else {
                            if(onval.equalsIgnoreCase("C")){   //New Request on 25-APR from client
                                JSFUtils.addFacesErrorMessage("Free Days should be less than or equals to 30..!");
                            }else{
                            JSFUtils.addFacesErrorMessage("Free Days should be less than or equals to 30..!");
                            }
                        }
        }else{
            JSFUtils.addFacesErrorMessage("Associated Offer should be approved !!!");
        }
            //            if ((ResultVal.equalsIgnoreCase("Success")) && (bkAmount >= 500)) {
            //                ADFUtils.findOperation("Commit").execute();
            //                JSFUtils.addFacesInformationMessage("Submitted For Approval");
            //            } else {
            //                if (ResultVal!="Success") {
            //                    JSFUtils.addFacesInformationMessage("Error in Submission Process...!");
            //                }
            //                if ((bkAmount < 500)) {
            //                    JSFUtils.addFacesInformationMessage("Minimum booking amount should be 500");
            //                }
            //            }
            //            } else {
            //                JSFUtils.addFacesInformationMessage("Minimum booking amount should be 500 for Booking");
            //            }
//        }
    }
    public String valdtOfferStatusOnSubmit() {
        String sts = "N";
        ViewObject BkHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row row = BkHdrVo.getCurrentRow();
        ViewObject OfferHdrVo =
            ADFUtils.findIterator("OfferHrd_VO3Iterator").getViewObject();
        ViewCriteria ovc = OfferHdrVo.createViewCriteria();
        ViewCriteriaRow ovcRow = ovc.createViewCriteriaRow();
        ovcRow.setAttribute("OfferHdrId",row.getAttribute("OfferHdrId"));
        ovc.addRow(ovcRow);
        OfferHdrVo.applyViewCriteria(ovc);
        OfferHdrVo.executeQuery();
        if (OfferHdrVo.getEstimatedRowCount() > 0) {
        String ofStatus = OfferHdrVo.first().getAttribute("Status")==null ? "" : OfferHdrVo.first().getAttribute("Status").toString();
        if (ofStatus.equalsIgnoreCase("APR") || ofStatus.equalsIgnoreCase("BO")){
            sts = "Y";
        }
      }
        return sts;
    }

    public String validateFinalApprovals() {
        String resultt = "Y";
        ViewObject BookingHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Object userGrpId =
            BookingHdrVo.getCurrentRow().getAttribute("UserGrpId");
        if (userGrpId != null) {
            ViewObject getUserlevels =
                ADFUtils.findIterator("getUserLevels1Iterator").getViewObject();
            getUserlevels.setNamedWhereClauseParam("P_USER_GRP",
                                                   BookingHdrVo.getCurrentRow().getAttribute("UserGrpId"));
            getUserlevels.executeQuery();

            long userlevelcount = getUserlevels.getEstimatedRowCount();


            // long FlowLevel=//(long)BookingHdrVo.getCurrentRow().getAttribute("FlowLevel");
            long FlowLevel =
                ((Number)BookingHdrVo.getCurrentRow().getAttribute("FlowLevel")).longValue();


            if (userlevelcount == FlowLevel) {
                resultt = "N";
            }


        }
        //if(getUserlevels.get)


        return resultt;
    }

//    public void onClickApprove(ActionEvent actionEvent) {
//        String result = "Y";
//        String Finance =
//            (String)JSFUtils.resolveExpression("#{sessionScope.UR}");
//        //        System.err.println("-----User Role-----" + Finance);
//        ViewObject bkHdrVo = ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
//        Row bkRow = bkHdrVo.getCurrentRow();
//
//        String validationUSerLevel = validateFinalApprovals().toString();
//        ViewObject vo1 =
//            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
//        Row row1 = vo1.getCurrentRow();
//        if (Finance.equalsIgnoreCase("ACCCOUNTS") ||
//            Finance.equalsIgnoreCase("ACCOUNTS_MANAGER") ||
//            validationUSerLevel.equals("N")) {
//            
//            String orgId = bkRow.getAttribute("OrgId")==null ? "" :bkRow.getAttribute("OrgId").toString();
//            if(orgId.equals("300000007801262")){
//            //Alfa Holdings
//            }else{
//            if (row1.getAttribute("Trans_CustIdAr") == null) {
//                result = "N";
//                JSFUtils.addFacesErrorMessage("You must select Custom AR Name");
//            }
//            if (row1.getAttribute("CustomerNumberAr") == null) {
//                result = "N";
//                JSFUtils.addFacesErrorMessage("You must Provide Customer AR Number");
//            }
//            //            if (row1.getAttribute("ShipToAddr") == null) {
//            //                JSFUtils.addFacesErrorMessage("You must select Ship to address");
//            //            }
//            if (row1.getAttribute("BillToAddr") == null) {
//                result = "N";
//                JSFUtils.addFacesErrorMessage("You must select Bill to address");
//            }
//
//        }
//            }
//
//        //  else {
//
//        if (result.equalsIgnoreCase("Y")) {
//            Map<String, BigDecimal> ResultVal =
//                new HashMap<String, BigDecimal>();
//            ViewObject vo =
//                ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
//            Row row = vo.getCurrentRow();
//            int res=1;
////            int res = onUnitValidation();
//            String Reason =
//                this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
//
//
//            if (res == 0) {
//                JSFUtils.addFacesErrorMessage("Unit for this booking is not Avilable..!!");
//            } else {
//                try {
//                    ResultVal =
//                            xxfnd.invokeResponsePkgs("xxfnd_util_pkg.update_response",
//                                                     row.getAttribute("FuncId"),
//                                                     row.getAttribute("BookingId1"),
//                                                     row.getAttribute("UserGrpId"),
//                                                     row.getAttribute("FlowLevel"),
//                                                     row.getAttribute("FlowWith"),
//                                                     Reason, "A", 0,
//                                                     "XXPM_BOOKING_HEADER",
//                                                     "STATUS", "BOOKING_ID");
//
//
//                } catch (SQLException e) {
//                    System.err.println("ERROR" + e);
//                }
//                //ResultVal
//                System.err.println("ERROR" + ResultVal);
//
//
//                for (Map.Entry m : ResultVal.entrySet()) {
//                    System.out.println("KEY" + m.getKey() + "VALUE " +
//                                       m.getValue());
//
//                    if (m.getKey().equals("Success")) {
//                        String ress =
//                            m.getValue() == null ? "null" : m.getValue().toString();
//                        if (ress.equals("null")) {
//                            setUnitStatus();
//                            onOtherOfferStatusChange(); //Hided For UAT
//                            onChangeOfferStatus();
//                            onChangeReceiptStatus();
//                            if(row.getAttribute("Attribute2") == null){
//                                row.setAttribute("Attribute2", "RC Created");
//                                onClickForRC();
//                            }
//                            //flag for latest customer update in maintenance wo module
//                            row.setAttribute("Attribute3", "Y");                                                        
//                        }
//                       
//                //Temporry receipt to permanent receipt convert
//                        ViewObject rcptVo1 = ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
//                        System.out.println("Count RcptVo1 for temp receipt conversion :"+rcptVo1.getEstimatedRowCount());
//                        String custNameAR = row1.getAttribute("Trans_CustIdAr") == null ? "" : row1.getAttribute("Trans_CustIdAr").toString();
//                        if(rcptVo1.getEstimatedRowCount() >0){
//                        RowSetIterator rsi = rcptVo1.createRowSetIterator(null);
//                        while(rsi.hasNext()){
//                        Row tempRw = rsi.next();
//                        String isTempRcpt = tempRw.getAttribute("Attribute4")==null?"":tempRw.getAttribute("Attribute4").toString();
//                        if(isTempRcpt.equalsIgnoreCase("TEMP_RECEIPT")){
//                            tempRw.setAttribute("Attribute4", null);
//                            tempRw.setAttribute("CustomerName", custNameAR);
//                          }
//                        }
//                        rcptVo1.closeRowSetIterator();
//                        }
//                        ADFUtils.findOperation("Commit").execute();
//                        vo.executeQuery();
//                        String status = row.getAttribute("Status1") == null ? "" : row.getAttribute("Status1").toString();
//                        System.out.println("Status1 print :"+status);
//                        String bkId = row.getAttribute("BookingId1") == null ? "0" : row.getAttribute("BookingId1").toString();
//                        String bkNo = row.getAttribute("BookingNumber1") == null ? "0" : row.getAttribute("BookingNumber1").toString();
//                        String flowWithId = row.getAttribute("FlowWith") == null ? "0" : row.getAttribute("FlowWith").toString();
//                        String userName = row.getAttribute("CreatedBy") == null ? "" : row.getAttribute("CreatedBy").toString();
//                        String startDate = row.getAttribute("Lease_Start_Date_Trans") == null ? "" : row.getAttribute("Lease_Start_Date_Trans").toString();
//                        String endDate = row.getAttribute("Lease_End_Date_trans") == null ? "" : row.getAttribute("Lease_End_Date_trans").toString();
//                        if(status.equalsIgnoreCase("PEN")){                            
//                            //mail service
//                           doSendMailOnSubmitApr(bkId,bkNo,flowWithId,userName,startDate,endDate);
//                        }
//                        if(status.equalsIgnoreCase("APR")){                               
//                        //mail service
//                            doSendMailOnApproved(bkId,bkNo,flowWithId,userName,startDate,endDate);
//                            }
//                        JSFUtils.addFacesInformationMessage("Approved....");
//                    } else {
//                        JSFUtils.addFacesErrorMessage("Error in Approve process!");
//                    }
//
//                }
//
//            }
//
//        } else {
//            JSFUtils.addFacesErrorMessage("Provide applicable Customer Name and Number");
//        }
//        //  }
//
//
//    }
    
    public void onClickApprove(ActionEvent actionEvent) {
        String result = "Y";
        String Finance =
            (String)JSFUtils.resolveExpression("#{sessionScope.UR}");
        //        System.err.println("-----User Role-----" + Finance);
        ViewObject bkHdrVo = ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row bkRow = bkHdrVo.getCurrentRow();

        String validationUSerLevel = validateFinalApprovals().toString();
        ViewObject vo1 =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        Row row1 = vo1.getCurrentRow();
        if (Finance.equalsIgnoreCase("ACCCOUNTS") ||
            Finance.equalsIgnoreCase("ACCOUNTS_MANAGER") ||
            validationUSerLevel.equals("N")) {
            
            String orgId = bkRow.getAttribute("OrgId")==null ? "" :bkRow.getAttribute("OrgId").toString();
            if(orgId.equals("300000007801262")){
            //Alfa Holdings
            }else{
            if (row1.getAttribute("Trans_CustIdAr") == null) {
                result = "N";
                JSFUtils.addFacesErrorMessage("You must select Custom AR Name");
            }
            if (row1.getAttribute("CustomerNumberAr") == null) {
                result = "N";
                JSFUtils.addFacesErrorMessage("You must Provide Customer AR Number");
            }
            //            if (row1.getAttribute("ShipToAddr") == null) {
            //                JSFUtils.addFacesErrorMessage("You must select Ship to address");
            //            }
            if (row1.getAttribute("BillToAddr") == null) {
                result = "N";
                JSFUtils.addFacesErrorMessage("You must select Bill to address");
            }

        }
            }

        //  else {

        if (result.equalsIgnoreCase("Y")) {

        String ResultVal = null;
            ViewObject vo =
                ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
            Row row = vo.getCurrentRow();
            String Reason = "Approved";
            String val =
                ADFContext.getCurrent().getPageFlowScope().get("Action") == null ?
                "" :
                ADFContext.getCurrent().getPageFlowScope().get("Action").toString();
            if(val.equalsIgnoreCase("BYPASS_APPR")){
                String usrName = ADFContext.getCurrent().getSessionScope().get("userName")==null ? "" :
                                 ADFContext.getCurrent().getSessionScope().get("userName").toString();
                Reason = "Approval Bypassed by : "+usrName;
            }else{
                Reason =
                this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
            }
                try {
                    OperationBinding op=ADFUtils.findOperation("responseBkForAppr");
                              op.getParamsMap().put("bookingId",row.getAttribute("BookingId1").toString());
                              op.getParamsMap().put("reason",Reason);
                              op.getParamsMap().put("apr_rej","A");
                              ResultVal=op.execute().toString();
                    //          JSFUtils.addFacesInformationMessage(flag);

                } catch (Exception e) {
                    System.err.println("ERROR" + e);
                }
                //ResultVal
                System.err.println("ERROR" + ResultVal);

                    if (ResultVal.equals("Success")) {
                       
                //Temporry receipt to permanent receipt convert
                        ViewObject rcptVo1 = ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
                        System.out.println("Count RcptVo1 for temp receipt conversion :"+rcptVo1.getEstimatedRowCount());
                        String custNameAR = row1.getAttribute("Trans_CustIdAr") == null ? "" : row1.getAttribute("Trans_CustIdAr").toString();
                        if(rcptVo1.getEstimatedRowCount() >0){
                        RowSetIterator rsi = rcptVo1.createRowSetIterator(null);
                        while(rsi.hasNext()){
                        Row tempRw = rsi.next();
                        String isTempRcpt = tempRw.getAttribute("Attribute4")==null?"":tempRw.getAttribute("Attribute4").toString();
                        if(isTempRcpt.equalsIgnoreCase("TEMP_RECEIPT")){
                            tempRw.setAttribute("Attribute4", null);
                            tempRw.setAttribute("CustomerName", custNameAR);
                          }
                        }
                        rcptVo1.closeRowSetIterator();
                        }
                        ADFUtils.findOperation("Commit").execute();
                        vo.executeQuery();
                        String status = row.getAttribute("Status1") == null ? "" : row.getAttribute("Status1").toString();
                        System.out.println("Status1 print :"+status);
                        String bkId = row.getAttribute("BookingId1") == null ? "0" : row.getAttribute("BookingId1").toString();
                        String bkNo = row.getAttribute("BookingNumber1") == null ? "0" : row.getAttribute("BookingNumber1").toString();
                        String flowWithId = row.getAttribute("FlowWith") == null ? "0" : row.getAttribute("FlowWith").toString();
                        String userName = row.getAttribute("CreatedBy") == null ? "" : row.getAttribute("CreatedBy").toString();
                        String startDate = row.getAttribute("Lease_Start_Date_Trans") == null ? "" : row.getAttribute("Lease_Start_Date_Trans").toString();
                        String endDate = row.getAttribute("Lease_End_Date_trans") == null ? "" : row.getAttribute("Lease_End_Date_trans").toString();
                        if(status.equalsIgnoreCase("PEN")){                            
                            //mail service
//                           doSendMailOnSubmitApr(bkId,bkNo,flowWithId,userName,startDate,endDate);
                        }
                        if(status.equalsIgnoreCase("APR")){     
                                setUnitStatus();
                                onOtherOfferStatusChange(); //Hided For UAT
                                onChangeOfferStatus();
                                onChangeReceiptStatus();
                                if(row.getAttribute("Attribute2") == null){
                                    row.setAttribute("Attribute2", "RC Created");
                                    onClickForRC();
                                }
                                //flag for latest customer update in maintenance wo module
                                row.setAttribute("Attribute3", "Y");                                                        
                        //mail service
//                            doSendMailOnApproved(bkId,bkNo,flowWithId,userName,startDate,endDate);
                            }
                        JSFUtils.addFacesInformationMessage("Approved....");
                    } else {
                        JSFUtils.addFacesErrorMessage("Error in Approve process!");
                    }

        } else {
            JSFUtils.addFacesErrorMessage("Provide applicable Customer Name and Number");
        }
        //  }


    }
    //doSendMailOnSubmit during approve
    public void doSendMailOnSubmitApr(String bkId,String bkNo,String flowWithId,String userName,String startDate,String endDate){
        
    ArrayList<String> ar = new ArrayList<String>();
    ArrayList<String> unitNameAL = new ArrayList<String>();
    ArrayList<String> buildNameAL = new ArrayList<String>();
    ArrayList<String> propNameAL = new ArrayList<String>();
    String emailId = null;
    String userNameDisp = null;
    String buildName= null;
    String propName= null;
    String custName= null;
    String netRent= null;
    String pdfReport=null;
    
    //roport download url
    pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/booking/"+bkNo;
//    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/booking/"+bkNo;
    
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
          
     ViewObject bkSrchRoVo = ADFUtils.findIterator("SearchBkDtls_RoVo1Iterator").getViewObject();
            ViewCriteria vwc = bkSrchRoVo.createViewCriteria();
            ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
            vwcr.setAttribute("BookingId", bkId);
            vwc.addRow(vwcr);
            bkSrchRoVo.applyViewCriteria(vwc);
            bkSrchRoVo.executeQuery();
        if (bkSrchRoVo.getEstimatedRowCount() > 0) {
            RowSetIterator rsi = bkSrchRoVo.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row row = rsi.next();
                    String unitName= row.getAttribute("UnitName")==null ? "" : row.getAttribute("UnitName").toString();
                    unitNameAL.add(unitName);
                    buildName= row.getAttribute("BuildName")==null ? "" : row.getAttribute("BuildName").toString();
                    buildNameAL.add(buildName);
                    propName= row.getAttribute("PropertyName")==null ? "" : row.getAttribute("PropertyName").toString();
                    propNameAL.add(propName);
                    custName= row.getAttribute("CustName")==null ? "" : row.getAttribute("CustName").toString();
                    netRent= row.getAttribute("OfferTotal")==null ? "" : row.getAttribute("OfferTotal").toString();
                }
        }
//     ar.add("prasenjit.d@4iapps.com");
         ar.add(emailId);
     String htmlBody =MailTemplates.onSubmitForAprTmplt(propName,buildName,unitNameAL,userNameDisp,bkNo,"Booking No",custName,startDate,endDate,netRent,pdfReport);
     String subject = "Approval Notification";
     MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
     JSFUtils.addFacesInformationMessage("Mail has been sent successfully");        
        }
        
    //doSendMailOnSubmit during submit
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
    String netRent= null;
    String pdfReport=null;
    
    ViewObject bkHdrVo = ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
    String bkId = bkHdrVo.getCurrentRow().getAttribute("BookingId1") == null ? "0" : bkHdrVo.getCurrentRow().getAttribute("BookingId1").toString();
    String bkNo = bkHdrVo.getCurrentRow().getAttribute("BookingNumber1") == null ? "0" : bkHdrVo.getCurrentRow().getAttribute("BookingNumber1").toString();
    String flowWithId = bkHdrVo.getCurrentRow().getAttribute("FlowWith") == null ? "0" : bkHdrVo.getCurrentRow().getAttribute("FlowWith").toString();
    //roport download url
    pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/booking/"+bkNo;
    //    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/booking/"+bkNo;
    
    String startDate = bkHdrVo.getCurrentRow().getAttribute("Lease_Start_Date_Trans") == null ? "" : bkHdrVo.getCurrentRow().getAttribute("Lease_Start_Date_Trans").toString();
    String endDate = bkHdrVo.getCurrentRow().getAttribute("Lease_End_Date_trans") == null ? "" : bkHdrVo.getCurrentRow().getAttribute("Lease_End_Date_trans").toString();
    //    String flowWithId = bkHdrVo.getCurrentRow().getAttribute("FlowWith") == null ? "0" : bkHdrVo.getCurrentRow().getAttribute("FlowWith").toString();
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
          
     ViewObject bkSrchRoVo = ADFUtils.findIterator("SearchBkDtls_RoVo1Iterator").getViewObject();
            ViewCriteria vwc = bkSrchRoVo.createViewCriteria();
            ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
            vwcr.setAttribute("BookingId", bkId);
            vwc.addRow(vwcr);
            bkSrchRoVo.applyViewCriteria(vwc);
            bkSrchRoVo.executeQuery();
        if (bkSrchRoVo.getEstimatedRowCount() > 0) {
            RowSetIterator rsi = bkSrchRoVo.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row row = rsi.next();
                    String unitName= row.getAttribute("UnitName")==null ? "" : row.getAttribute("UnitName").toString();
                    unitNameAL.add(unitName);
                    buildName= row.getAttribute("BuildName")==null ? "" : row.getAttribute("BuildName").toString();
                    buildNameAL.add(buildName);
                    propName= row.getAttribute("PropertyName")==null ? "" : row.getAttribute("PropertyName").toString();
                    propNameAL.add(propName);
                    custName= row.getAttribute("CustName")==null ? "" : row.getAttribute("CustName").toString();
                    netRent= row.getAttribute("OfferTotal")==null ? "" : row.getAttribute("OfferTotal").toString();
                }
        }
    //     ar.add("prasenjit.d@4iapps.com");
         ar.add(emailId);
     String htmlBody =MailTemplates.onSubmitForAprTmplt(propName,buildName,unitNameAL,userNameDisp,bkNo,"Booking No",custName,startDate,endDate,netRent,pdfReport);
     String subject = "Approval Notification";
     MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
     JSFUtils.addFacesInformationMessage("Mail has been sent successfully");        
        }
    
    //doSendMailOnApproved
    public void doSendMailOnApproved(String bkId,String bkNo,String flowWithId,String userName,String startDate,String endDate){
        
    ArrayList<String> ar = new ArrayList<String>();
    ArrayList<String> unitNameAL = new ArrayList<String>();
    ArrayList<String> buildNameAL = new ArrayList<String>();
    ArrayList<String> propNameAL = new ArrayList<String>();
    String emailId = null;
    String userNameDisp = null;
    String buildName= null;
    String propName= null;
    String custName= null;
    String netRent= null;
    String pdfReport=null;
    String custEmailId=null;
    
    //roport download url
    pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/booking/"+bkNo;
    //    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/booking/"+bkNo;
    
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
          
     ViewObject bkSrchRoVo = ADFUtils.findIterator("SearchBkDtls_RoVo1Iterator").getViewObject();
            ViewCriteria vwc = bkSrchRoVo.createViewCriteria();
            ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
            vwcr.setAttribute("BookingId", bkId);
            vwc.addRow(vwcr);
            bkSrchRoVo.applyViewCriteria(vwc);
            bkSrchRoVo.executeQuery();
        if (bkSrchRoVo.getEstimatedRowCount() > 0) {
            RowSetIterator rsi = bkSrchRoVo.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row row = rsi.next();
                    String unitName= row.getAttribute("UnitName")==null ? "" : row.getAttribute("UnitName").toString();
                    unitNameAL.add(unitName);
                    buildName= row.getAttribute("BuildName")==null ? "" : row.getAttribute("BuildName").toString();
                    buildNameAL.add(buildName);
                    propName= row.getAttribute("PropertyName")==null ? "" : row.getAttribute("PropertyName").toString();
                    propNameAL.add(propName);
                    custName= row.getAttribute("CustName")==null ? "" : row.getAttribute("CustName").toString();
                    custEmailId= row.getAttribute("EmailId")==null ? "prasenjit.d@4iapps.com" : row.getAttribute("EmailId").toString();
                    netRent= row.getAttribute("OfferTotal")==null ? "" : row.getAttribute("OfferTotal").toString();
                }
        }
    //     ar.add("prasenjit.d@4iapps.com");
         ar.add(emailId);
//         ar.add(custEmailId);
     String htmlBody =MailTemplates.onApprovedTmplt(propName,buildName,unitNameAL,userNameDisp,bkNo,"Booking No",custName,startDate,endDate,netRent,pdfReport);
     String subject = "Approval Notification";
     MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
     JSFUtils.addFacesInformationMessage("Mail has been sent successfully");        
        }
    //receipt status change
    public void onChangeReceiptStatus() {
            ViewObject receiptVo1 =
                ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
            Object val =
                ADFContext.getCurrent().getPageFlowScope().get("Action") == null ?
                "" :
                ADFContext.getCurrent().getPageFlowScope().get("Action").toString();

            RowSetIterator rsi = null;
            if (receiptVo1.getEstimatedRowCount() > 0) {
                System.out.println("No of Rcpt on "+ val +
                                   receiptVo1.getEstimatedRowCount());
                try {
                    rsi = receiptVo1.createRowSetIterator(null);
                    while (rsi.hasNext()) {
                        Row r = rsi.next();
       //
       
       if (val.equals("Approval")) {         
            r.setAttribute("ReceiptStatus", "APR");
       }
       if (val.equals("Rejection")) {         
            r.setAttribute("ReceiptStatus", "REJ");
              }
       if (val.equals("Pending")) {         
            r.setAttribute("ReceiptStatus", "PEN");
              }                 
                    }
                } catch (Exception e) {
                     System.out.println(e);
                } finally {
                    rsi.closeRowSetIterator();
                }
            }
        }


    public void OnClickReject(ActionEvent actionEvent) {
        // Add event code here...
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Rejected" : this.reason.getValue().toString();


        try {
//            ResultVal =
//                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
//                                            row.getAttribute("FuncId"),
//                                            row.getAttribute("BookingId1"),
//                                            row.getAttribute("UserGrpId"),
//                                            row.getAttribute("FlowLevel"),
//                                            row.getAttribute("FlowWith"),
//                                            Reason, "R", 0,
//                                            "XXPM_BOOKING_HEADER", "STATUS",
//                                            "BOOKING_ID");
          OperationBinding op=ADFUtils.findOperation("responseBkForAppr");
          op.getParamsMap().put("bookingId",row.getAttribute("BookingId1").toString());
          op.getParamsMap().put("reason",Reason);
          op.getParamsMap().put("apr_rej","R");
          ResultVal=op.execute().toString();
//          JSFUtils.addFacesInformationMessage(flag);

        } catch (Exception e) {
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            onChangeReceiptStatus();
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Rejected....");

        } else {
            JSFUtils.addFacesErrorMessage("Error in Reject process!");
        }

    }

    public void onClickOKRec(ActionEvent actionEvent) {
        // Add event code here..
        ViewObject vo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();

        if (row.getAttribute("ReceiptNumber") == null) {
            String val = xxfnd.generateDocNo("RT", "Booking_AMDataControl");
            Object rVal = val;
            row.setAttribute("ReceiptNumber", rVal);


        }


    }

    public String DiffinDays(String startDate, String endDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date2 = simpleDateFormat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diffInDays = date2.getTime() - date1.getTime();

        long getDiff =
            TimeUnit.DAYS.convert(diffInDays, TimeUnit.MILLISECONDS);

        // using TimeUnit class from java.util.concurrent package
        //long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);


        long diffDays = diffInDays / (24 * 60 * 60 * 1000);

        String str = String.valueOf(diffDays);
        return str;
    }


    public void onCalCDiffDays(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        if (valueChangeEvent != null) {
            String endDate =
                re.getAttribute("PayRevDate") == null ? "" : re.getAttribute("PayRevDate").toString();

            //String endDate = (String)receiptVo.getCurrentRow().getAttribute("PayRecDate");
            String stDate =
                re.getAttribute("PayRecDate") == null ? "" : re.getAttribute("PayRecDate").toString();
            String res =
                DiffinDays(stDate, endDate) == null ? "" : DiffinDays(stDate,
                                                                      endDate).toString();
            Object days = res;
            re.setAttribute("DiffInDays", days);
        }

    }

    public String onClickReceiptTaskFlow() {
        // Add event code here...
        ViewObject bookCustVO =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        Row cusRow = bookCustVO.getCurrentRow();
        ViewObject vo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ViewObject BMtlvo =
                    ADFUtils.findIterator("BookingMilestonesOtherChargesVO1Iterator").getViewObject();
                Row BMrows = BMtlvo.getCurrentRow();
        
        ADFContext.getCurrent().getPageFlowScope().put("funcId",
                                                       row.getAttribute("FuncId") ==
                                                       null ? "" :
                                                       row.getAttribute("FuncId"));
        ADFContext.getCurrent().getPageFlowScope().put("scfnId",
                                                       row.getAttribute("BookingId1") ==
                                                       null ? "" :
                                                       row.getAttribute("BookingId1"));

        ADFContext.getCurrent().getPageFlowScope().put("OrgId",
                                                       row.getAttribute("OrgId") ==
                                                       null ? "" :
                                                       row.getAttribute("OrgId"));
        ADFContext.getCurrent().getPageFlowScope().put("CustName",
                                                       cusRow.getAttribute("CustName") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustName"));
        //15-Nov-22 for oc divide based on vat and non vat//for attribute6
        String isVat = ADFContext.getCurrent().getPageFlowScope().get("isVat")==null ? "NO_VAT" : ADFContext.getCurrent().getPageFlowScope().get("isVat").toString();
        //Temporary receipt
        String leadName = row.getAttribute("Customer_Name_Trans")==null?"":row.getAttribute("Customer_Name_Trans").toString();
        String custAr = cusRow.getAttribute("Trans_CustIdAr")==null?"":cusRow.getAttribute("Trans_CustIdAr").toString();
        String orgID = row.getAttribute("OrgId")==null?"":row.getAttribute("OrgId").toString();
            if (custAr.equalsIgnoreCase("") && !orgID.equals("300000007801262")){
            ADFContext.getCurrent().getPageFlowScope().put("CustName",leadName);
            ADFContext.getCurrent().getPageFlowScope().put("TempReceipt","TEMP_RECEIPT");
            }
        ADFContext.getCurrent().getPageFlowScope().put("CustBankName",
                                                       cusRow.getAttribute("CustBankName") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustBankName"));
        ADFContext.getCurrent().getPageFlowScope().put("CustBankAccNumber",
                                                       cusRow.getAttribute("CustBankAccNumber") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustBankAccNumber"));
        ADFContext.getCurrent().getPageFlowScope().put("CustBranchName",
                                                       cusRow.getAttribute("CustBranchName") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustBranchName"));
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId1") ==
                                                       null ? "" :
                                                       row.getAttribute("BookingId1"));
        //08-sep-2020 for all receipts to capture BookingMsDtlId in receipt Attribute3 mainly for OC report
        String addIcon = ADFContext.getCurrent().getPageFlowScope().get("bkMsDtlID")==null ? "" : ADFContext.getCurrent().getPageFlowScope().get("bkMsDtlID").toString();
//        String staxcode=JSFUtils.resolveExpression("#{row.bindings.TaxCode.attributeValue}")==null?"0":JSFUtils.resolveExpression("#{row.bindings.TaxCode.attributeValue}").toString();
        if(addIcon.equalsIgnoreCase("noBKmsDtlID")){
            ADFContext.getCurrent().getPageFlowScope().put("remark", "");
        }else{
        String bkMsdtlId = BMrows.getAttribute("BookingMsDtlId") == null ? "" : BMrows.getAttribute("BookingMsDtlId").toString();
        System.out.println("bkMsdtlId ::"+bkMsdtlId);
        ADFContext.getCurrent().getPageFlowScope().put("remark", bkMsdtlId);
    }
        //17-sep-2020 for security deposit SD payment mode
        ADFContext.getCurrent().getPageFlowScope().put("SDPayMode","");
        //
        ADFContext.getCurrent().getPageFlowScope().put("modeType","Normal");
        ADFContext.getCurrent().getPageFlowScope().put("receiptType", "BK");
        ADFContext.getCurrent().getPageFlowScope().put("DueDate", "");
        ADFContext.getCurrent().getPageFlowScope().put("description", "" );
        String a = ADFContext.getCurrent().getPageFlowScope().get("A").toString();
          if(a.equalsIgnoreCase("A")){
          ADFContext.getCurrent().getPageFlowScope().put("Amount", "" );
          ADFContext.getCurrent().getPageFlowScope().put("Dscrption", "" );
          ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "" );
          ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "" );
          String rcptTypDescrptn = ADFContext.getCurrent().getPageFlowScope().get("rcptTypDescrptn").toString();
              if(rcptTypDescrptn.equalsIgnoreCase("Booking")){
                  ADFContext.getCurrent().getPageFlowScope().put("Dscrption", "Booking" );
              }
          }else{
          ADFContext.getCurrent().getPageFlowScope().put("Amount",
                                                             BMrows.getAttribute("InstallmentAmount") ==
                                                             null ? "" :
                                                             BMrows.getAttribute("InstallmentAmount"));
            //description
                            ViewObject lookUpVo =
                                    ADFUtils.findIterator("Lookup_View_ROVO1Iterator").getViewObject();
                        ViewCriteria vC = lookUpVo.createViewCriteria();
                        ViewCriteriaRow vCRow = vC.createViewCriteriaRow();
                        vCRow.setAttribute("LookupValueName", BMrows.getAttribute("InstallmentType"));
                        vC.addRow(vCRow);
                        lookUpVo.applyViewCriteria(vC);
                        lookUpVo.executeQuery();
                        if (lookUpVo.getEstimatedRowCount() > 0) { 
                            Row lookUpVoRow = lookUpVo.first();
                            String lookupValueDisp = lookUpVoRow.getAttribute("LookupValueNameDisp").toString();
                            ADFContext.getCurrent().getPageFlowScope().put("Dscrption", lookupValueDisp ); 
                            if (orgID.equals("300000021774129")){
                                ADFContext.getCurrent().getPageFlowScope().put("OrgId", "300000021774129" ); 
                            }else{
                            ADFContext.getCurrent().getPageFlowScope().put("OrgId", "300000001937178" );
                        }
                            ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "OT" );
                            ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "" );
                        }    
        }


        return "receipt";
    }

    public String onEdit() {
        // Add event code here...
        ViewObject vo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("recid",
                                                       re.getAttribute("ReceiptId"));
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId1"));
        ADFContext.getCurrent().getPageFlowScope().put("TransId", "ER");
        //04-apr-2021
        String payM=re.getAttribute("PayMode")==null?"":re.getAttribute("PayMode").toString();
        if(payM.contains("SEC_DEP")){
            ADFContext.getCurrent().getPageFlowScope().put("SDPayMode","SD");
        //            ADFContext.getCurrent().getPageFlowScope().put("modeType","SD");
        }else{
            ADFContext.getCurrent().getPageFlowScope().put("SDPayMode","");
        //            ADFContext.getCurrent().getPageFlowScope().put("modeType","Normal");
        }

        return "Edit";
    }


    public void onRefresh() {
        // Add event code here...

        //    BindingContext bc = BindingContext.getCurrent();
        //      DCBindingContainer dcb =
        //        (DCBindingContainer)bc.getCurrentBindingsEntry();
        //      DCIteratorBinding iter =
        //        dcb.findIteratorBinding("Receipt_VO1Iterator");
        //      iter.executeQuery();
        //     RequestContext.getCurrentInstance().addPartialTarget(returnEvent.getComponent().getParent().getParent());

        //    JUCtrlValueBinding ware =
        //      (JUCtrlValueBinding)ADFUtils.findControlBinding("Receipt_VO1Iterator");
        //    DCIteratorBinding wareDC = ware.getDCIteratorBinding();
        //    wareDC.executeQuery();
        //
        //    AdfFacesContext.getCurrentInstance().addPartialTarget(this.t41);

        // return "Success";
    }

    public void onEditing(ReturnEvent returnEvent) {
        // Add event code here...

        ViewObject vo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId1"));
    }
    //    ViewObject vo =
    //        ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
    //    Row row = vo.getCurrentRow();

    public void onClickAttachments(ActionEvent actionEvent) {
        ViewObject vo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        JSFUtils.setExpressionValue("#{pageFlowScope.bookfuncId}", 1);
        JSFUtils.setExpressionValue("#{pageFlowScope.bookId}",
                                    row.getAttribute("BookingId1"));


    }


    public void onClickCheckList(ActionEvent actionEvent) {
        ViewObject vo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        JSFUtils.setExpressionValue("#{pageFlowScope.bookfuncId}", 7);
        JSFUtils.setExpressionValue("#{pageFlowScope.bookId}",
                                    row.getAttribute("BookingId1"));
        JSFUtils.setExpressionValue("#{pageFlowScope.Lookup}", "");


    }

    public void setOffer(RichInputListOfValues offer) {
        this.offer = offer;
    }

    public RichInputListOfValues getOffer() {
        return offer;
    }


    public void onClickPDFReport(FacesContext facesContext,
                                 java.io.OutputStream outputStream) {

        try {
            Object result = runReport("//reports//Booking Form.rtf");
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
            "SELECT XXPM_REPORT_PKG.xxpm_booking_form('" + p_offer_number +
            "') xml FROM dual";
        PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
        ResultSet rs1 = preparedStatement.executeQuery(selectSQL);
        while (rs1.next()) {
            retStr = rs1.getString("xml");
        }
        return retStr;
    }

    public byte[] runReport(String templateFile) {

        byte[] dataBytes = null;

        try {
            ViewObject quoteVO =
                ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
            Row re = quoteVO.getCurrentRow();

            String quoteNumber =
                re.getAttribute("BookingNumber1") == null ? "" :
                re.getAttribute("BookingNumber1").toString();
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

        }
        return dataBytes;
    }

    public ServletContext getContext() {
        return (ServletContext)getFacesContext().getExternalContext().getContext();
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    //    //==============================================================================//
    //    public void pushInvoice(String OrgId, String trxSrc, String trxTyp,
    //                            String trxDate, String CustSiteNum,
    //                            String custAccNum, String payTerm, String currency,
    //                            String dffVal, String lineDescr, String qty,
    //                            String lineAmt, BigDecimal msHdrId) {
    //      String trxStatus = null;
    //      //    String trxNumber = null;
    //      //    String trxId = null;
    //      //        String reqPayload = " <soapenv:Body>\n" +
    //      //            "      <typ:createSimpleInvoice>\n" +
    //      //            "         <typ:invoiceHeaderInformation>\n" +
    //      //            "            <inv:BusinessUnit>" + bu + "</inv:BusinessUnit>\n" +
    //      //            "            <inv:TransactionSource>" + trxSrc +
    //      //            "</inv:TransactionSource>\n" +
    //      //            "            <inv:TransactionType>" + trxTyp +
    //      //            "</inv:TransactionType>\n" +
    //      //            "            <inv:TrxNumber>1000</inv:TrxNumber>\n" +
    //      //            "            <inv:TrxDate>" + trxDate + "</inv:TrxDate>\n" +
    //      //            "            <inv:GlDate>" + trxDate + "</inv:GlDate>\n" +
    //      //            "            <inv:BillToCustomerName>" + custName +
    //      //            "</inv:BillToCustomerName>\n" +
    //      //            "            <inv:BillToAccountNumber>" + custAccNum +
    //      //            "</inv:BillToAccountNumber>\n" +
    //      //            "            <inv:PaymentTermsName>" + payTerm +
    //      //            "</inv:PaymentTermsName>\n" +
    //      //            "            <inv:InvoiceCurrencyCode>" + currency +
    //      //            "</inv:InvoiceCurrencyCode>\n" +
    //      //            "            <inv:InvoiceLine>\n" +
    //      //            "               <inv:LineNumber>" + lineNum +
    //      //            "</inv:LineNumber>\n" +
    //      //            "               <inv:Description>" + lineDescr +
    //      //            "</inv:Description>\n" +
    //      //            "               <inv:Quantity>" + qty + "</inv:Quantity>\n" +
    //      //            "               <inv:UnitSellingPrice currencyCode=\"AED\">" +
    //      //            lineAmt + "</inv:UnitSellingPrice>\n" +
    //      //            "            </inv:InvoiceLine>\n" +
    //      //            "         </typ:invoiceHeaderInformation>\n" +
    //      //            "      </typ:createSimpleInvoice>\n" +
    //      //            "   </soapenv:Body>\n" +
    //      //            "</soapenv:Envelope>";
    //
    //      String reqPayload = " <soapenv:Body>\n" +
    //        "      <typ:createInterfaceLine>\n" +
    //        "         <typ:interfaceLine>\n" +
    //        "            <inv:OrgId>" + OrgId + "</inv:OrgId>\n" +
    //        "            <inv:Amount>" + lineAmt + "</inv:Amount>\n" +
    //        "            <inv:BatchSourceName>" + trxSrc +
    //        "</inv:BatchSourceName>\n" +
    //        "            <inv:CustomerTrxTypeName>" + trxTyp +
    //        "</inv:CustomerTrxTypeName>\n" +
    //        //            "            <inv:ShipCustomerAccountNumber>4006</inv:ShipCustomerAccountNumber>\n" +
    //        //            "            <inv:ShipCustomerSiteNumber>11027</inv:ShipCustomerSiteNumber>\n" +
    //        "            <inv:BillCustomerAccountNumber>" + custAccNum +
    //        "</inv:BillCustomerAccountNumber>\n" +
    //        "            <inv:SoldCustomerAccountNumber>" + custAccNum +
    //        "</inv:SoldCustomerAccountNumber>\n" +
    //        "            <inv:BillCustomerSiteNumber>" + CustSiteNum +
    //        "</inv:BillCustomerSiteNumber>\n" +
    //        "            <inv:Comments>" + lineDescr + "</inv:Comments>\n" +
    //        "            <inv:TrxDate>" + trxDate + "</inv:TrxDate>\n" +
    //        "            <inv:CurrencyCode>" + currency + "</inv:CurrencyCode>\n" +
    //        "            <inv:Description>" + lineDescr + "</inv:Description>\n" +
    //        "            <inv:GlDate>" + trxDate + "</inv:GlDate>\n" +
    //        "            <inv:InvoicingRuleName>Advance Invoice</inv:InvoicingRuleName>\n" +
    //        "            <inv:AccountingRuleName>Custom Rule</inv:AccountingRuleName>\n" +
    //        "            <inv:RuleStartDate>2018-01-12</inv:RuleStartDate>\n" +
    //        "            <inv:AccountingRuleDuration>1</inv:AccountingRuleDuration>\n" +
    //        "            <inv:LineType>LINE</inv:LineType>\n" +
    //        "            <inv:Quantity>" + qty + "</inv:Quantity>\n" +
    //        "            <inv:UnitSellingPrice currencyCode=\"" + currency + "\">" +
    //        lineAmt + "</inv:UnitSellingPrice>\n" +
    //        "            <inv:ReasonCode/>\n" +
    //        "            <inv:PaymentTermsName>" + payTerm +
    //        "</inv:PaymentTermsName>\n" +
    //        "            <inv:TrxNumber/>\n" +
    //        "            <inv:TransactionInterfaceLineDff xsi:type=\"tran2:testFlex\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
    //        "               <tran2:__FLEX_Context>TestFlex</tran2:__FLEX_Context>\n" +
    //        "               <tran2:testname>testdff_" + dffVal +
    //        "</tran2:testname>\n" +
    //        "            </inv:TransactionInterfaceLineDff>\n" +
    //        "         </typ:interfaceLine>\n" +
    //        "      </typ:createInterfaceLine>\n" +
    //        "   </soapenv:Body>\n" +
    //        "</soapenv:Envelope>";
    //
    //      reqPayload = getHeaderPayload(reqPayload);
    //      try {
    //        reqPayload = reqPayload.replaceAll("&", "&");
    //        OkHttpClient client = new OkHttpClient();
    //        MediaType mediaType = MediaType.parse("text/xml");
    //        RequestBody body = RequestBody.create(mediaType, reqPayload);
    //    //      Request request =
    //    //        new Request.Builder().url("https://efnt-test.fin.us6.oraclecloud.com:443/finArTrxnsInvoices/InvoiceService?WSDL").post(body).addHeader("content-type",
    //    //                                                                                                                                               "text/xml").addHeader("cache-control",
    //    //                                                                                                                                                                     "no-cache").build();
    //        Request request =
    //          new Request.Builder().url("https://egzy-test.fa.em2.oraclecloud.com/finArTrxnsInvoices/InvoiceService?WSDL").post(body).addHeader("content-type",
    //                                                                                                                                                 "text/xml").addHeader("cache-control",
    //                                                                                                                                                                       "no-cache").build();
    //
    //        String strResp = null;
    //        Response response = client.newCall(request).execute();
    //        InputStream isr = response.body().byteStream();
    //        BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
    //        StringBuilder out = new StringBuilder();
    //        String resultsXml;
    //        while ((resultsXml = reader.readLine()) != null) {
    //          out.append(resultsXml);
    //        }
    //
    //        int responseCode = response.code();
    //        if (responseCode > 200) {
    //          strResp = out.toString();
    //          strResp =
    //              strResp.substring(0, strResp.length() > 3998 ? 3998 : strResp.length());
    //        } else {
    //          trxStatus = "S";
    //          //                DocumentBuilder builder =
    //          //                    DocumentBuilderFactory.newInstance().newDocumentBuilder();
    //          //                InputSource src = new InputSource();
    //          //                src.setCharacterStream(new StringReader(out.toString()));
    //          //                Document doc = builder.parse(src);
    //          //                trxStatus =
    //          //                        doc.getElementsByTagName("ServiceStatus").item(0).getTextContent();
    //          //                trxNumber =
    //          //                        doc.getElementsByTagName("TransactionNumber").item(0).getTextContent();
    //          //                trxId =
    //          //                        doc.getElementsByTagName("CustomerTrxId").item(0).getTextContent();
    //        }
    //        reader.close();
    //        ViewObject Billvo =
    //          ADFUtils.findIterator("XxpmBillingMilestones_VO1Iterator").getViewObject();
    //        ViewObjectImpl voInvImpl = (ViewObjectImpl)Billvo.getViewObject();
    //        ViewCriteria voInvVC = voInvImpl.getViewCriteria("findMsId");
    //        Billvo.applyViewCriteria(voInvVC);
    //        Billvo.setNamedWhereClauseParam("BV_BillingMsId", msHdrId);
    //        Billvo.executeQuery();
    //        Row billRo = Billvo.first();
    //        if (trxStatus == null) {
    //          billRo.setAttribute("CusTrxnStatus", "E");
    //          billRo.setAttribute("ErrorMsg", strResp);
    //        } else {
    //          //                      billRo.setAttribute("CusTrxId", trxId);
    //          //                      billRo.setAttribute("CusTrxNumber", trxNumber);
    //          billRo.setAttribute("CusTrxnStatus", trxStatus);
    //          billRo.setAttribute("DueDate", billRo.getAttribute("Date_Trans"));
    //          billRo.setAttribute("Status", "IN");
    //        }
    //      } catch (Exception e) {
    //        e.printStackTrace();
    //      }
    //    }
    //
    //    public String getHeaderPayload(String xmlData) {
    //      String xml = "";
    //      String webservice_username = "dilipkumar.pd";
    //      String webservice_password = "welcome123";
    //      try {
    //        Date date = new Date();
    //        SimpleDateFormat dateFormat =
    //          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'");
    //        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    //        long t = date.getTime();
    //        Date expDate = new Date(t + (10 * 60000));
    //        String createdTS = dateFormat.format(date);
    //        String expiresTS = dateFormat.format(expDate);
    //        //            xml +=
    //        //"<soapenv:Envelope xmlns:inv=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tran=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceLineDff/\" xmlns:tran1=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/\" xmlns:tran2=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineGdf/\" xmlns:tran3=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/\" xmlns:tran4=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/\" xmlns:tran5=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionInterfaceHeaderDff/\" xmlns:tran6=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionDistributionDff/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/types/\">\n" +
    //        //                    "   <soapenv:Header>\n" +
    //        //                    "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
    //        //                    "         <wsu:Timestamp wsu:Id=\"TS-58DE36E5314DC5A85A15054011598778\">\n" +
    //        //                    "            <wsu:Created>" + createdTS +
    //        //                    "</wsu:Created>\n" +
    //        //                    "            <wsu:Expires>" + expiresTS +
    //        //                    "</wsu:Expires>\n" +
    //        //                    "         </wsu:Timestamp>\n" +
    //        //                    "         <wsse:UsernameToken wsu:Id=\"UsernameToken-58DE36E5314DC5A85A15053855015324\">\n" +
    //        //                    "            <wsse:Username>" + webservice_username +
    //        //                    "</wsse:Username>\n" +
    //        //                    "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" +
    //        //                    webservice_password + "</wsse:Password>\n" +
    //        //                    "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">gzelfuHjaNMaQvhYDTyXrw==</wsse:Nonce>\n" +
    //        //                    "            <wsu:Created>2017-09-14T10:38:21.532Z</wsu:Created>\n" +
    //        //                    "         </wsse:UsernameToken>\n" +
    //        //                    "      </wsse:Security>\n" +
    //        //                    "   </soapenv:Header>" + xmlData;
    //
    //        xml +=
    //            "<soapenv:Envelope xmlns:inv=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tran=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/\" xmlns:tran1=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionLineInterfaceGdf/\" xmlns:tran2=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/\" xmlns:tran3=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceLinkToDff/\" xmlns:tran4=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceReferenceDff/\" xmlns:tran5=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineDff/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/types/\">\n" +
    //            "   <soapenv:Header>\n" +
    //            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
    //            "         <wsu:Timestamp wsu:Id=\"TS-3B4F87F1781C2AD9F115157523310101\">\n" +
    //            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
    //            "            <wsu:Expires>" + expiresTS + "</wsu:Expires>\n" +
    //            "         </wsu:Timestamp>\n" +
    //            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-BEEEC159ABCE3D23A215146988302931\">\n" +
    //            "            <wsse:Username>" + webservice_username +
    //            "</wsse:Username>\n" +
    //            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" +
    //            webservice_password + "</wsse:Password>\n" +
    //            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">danqgbqmtCS7Tdq5qBomMQ==</wsse:Nonce>\n" +
    //            "            <wsu:Created>2017-12-31T05:40:30.292Z</wsu:Created>\n" +
    //            "         </wsse:UsernameToken>\n" +
    //            "      </wsse:Security>\n" +
    //            "   </soapenv:Header>" + xmlData;
    //      } catch (Exception e) {
    //        e.printStackTrace();
    //      }
    //      return xml;
    //    }
    //
    //
    //    public static String getFaultString(String xml) {
    //      String faultString = "";
    //      try {
    //        int firstFault = xml.indexOf(";TEXT&gt;");
    //        int firstFault_last = xml.indexOf("&lt;/TEXT&");
    //        faultString = xml.substring(firstFault + 9, firstFault_last);
    //      } catch (Exception e) {
    //        e.printStackTrace();
    //      }
    //      return faultString;
    //    }
    //
    //
    //    public static String getTrxNum(String xml) {
    //      String status = "";
    //      try {
    //        DocumentBuilder builder =
    //          DocumentBuilderFactory.newInstance().newDocumentBuilder();
    //        InputSource src = new InputSource();
    //        src.setCharacterStream(new StringReader(xml));
    //        Document doc = builder.parse(src);
    //        status =
    //            doc.getElementsByTagName("TransactionNumber").item(0).getTextContent();
    //      } catch (Exception e) {
    //        e.printStackTrace();
    //      }
    //      return status;
    //    }

    public void pushData(ActionEvent actionEvent) {
        Object p_receipt_Number = null;
        //
        //        ViewObject receiptVO =
        //            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        //        Row currReceiptRow = receiptVO.getCurrentRow();
        Object customer_name =
            this.customerAR.getValue() == null ? null : this.customerAR.getValue().toString();
        //        Object customer_name =
        //            this.customerAR_T.getValue() == null ? null : this.customerAR_T.getValue().toString();
        //        Calendar cal = Calendar.getInstance();
        //        String dateFormat = "yyyy-MM-dd";
        //        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        //        Object sysDate = sdf.format(cal.getTime());

        ViewObject BookingHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();

        ViewObject customerVO =
            ADFUtils.findIterator("GetCustomerDetailsROVO1Iterator").getViewObject();

        ViewObjectImpl voInvImpl = (ViewObjectImpl)customerVO.getViewObject();
        ViewCriteria voInvVC = voInvImpl.getViewCriteria("findById");
        customerVO.applyViewCriteria(voInvVC);
        customerVO.setNamedWhereClauseParam("CUSID", customer_name);
        customerVO.executeQuery();
        Row firstRow = customerVO.first();

        System.err.println("CUSTOMER NAME" +
                           firstRow.getAttribute("CustomerName"));
        Object customer_name1 = firstRow.getAttribute("CustomerName");
        System.err.println("ogrId" +
                           BookingHdrVo.getCurrentRow().getAttribute("OrgId"));
        Object orgIdObj =
            BookingHdrVo.getCurrentRow().getAttribute("OrgId") == null ?
            "300000001727604" :
            BookingHdrVo.getCurrentRow().getAttribute("OrgId");

        BookingHdrVo.getCurrentRow().getAttribute("OrgId");
        Calendar cal = Calendar.getInstance();

        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Object sysDate = sdf.format(cal.getTime());

        ViewObject receiptVO =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row currRow = receiptVO.getCurrentRow();
        System.err.println("Amount" + currRow.getAttribute("ReceiptAmount"));

        Object receiptAmt =
            currRow.getAttribute("RecommendedAmount") == null ? "0" :
            currRow.getAttribute("RecommendedAmount");

        Object receiptNumberObj =
            currRow.getAttribute("ReceiptNumber") == null ? "0" :
            currRow.getAttribute("ReceiptNumber");


        try {
            String trxStatus = null;
            String errMsg = null;
            Object p_currency_code = "AED";
            Object p_amount = receiptAmt;
            p_receipt_Number = receiptNumberObj;
            Object p_receipt_date = sysDate;
            Object p_gl_date = sysDate;
            Object p_receipt_method_name = "PDC-UAB-002";
            Object p_ORG_id = orgIdObj;
            Object p_maturity_date = sysDate;
            Object p_customer_name = customer_name1;
            String enStr = "</env:Envelope>";
            String reqPayload = "<soapenv:Body>\n" +
                "      <typ:CreateReceipt>\n" +
                "         <typ:p_currency_code>" + p_currency_code +
                "</typ:p_currency_code>\n" +
                "         <typ:p_amount>" + p_amount + "</typ:p_amount>\n" +
                "         <typ:p_receipt_Number>" + p_receipt_Number +
                "</typ:p_receipt_Number>\n" +
                "         <typ:p_receipt_date>" + p_receipt_date +
                "</typ:p_receipt_date>\n" +
                "         <typ:p_gl_date>" + p_gl_date + "</typ:p_gl_date>\n" +
                "         <typ:p_receipt_method_name>" +
                p_receipt_method_name + "</typ:p_receipt_method_name>\n" +
                "         <typ:p_ORG_id>" + p_ORG_id + "</typ:p_ORG_id>\n" +
                "         <typ:p_maturity_date>" + p_maturity_date +
                "</typ:p_maturity_date>\n" +
                "         <typ:p_customer_name>" + p_customer_name +
                "</typ:p_customer_name>\n" +
                "      </typ:CreateReceipt>\n" +
                "   </soapenv:Body> " + "</soapenv:Envelope>";

            reqPayload = getHeaderPayload(reqPayload);
            System.err.println("HELLO" + reqPayload);
            this.responseTxt.setValue(reqPayload);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getResponseTxt());
            try {
                reqPayload = reqPayload.replaceAll("&", "&");
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("text/xml");
                RequestBody body = RequestBody.create(mediaType, reqPayload);
                Request request =
                    new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com:443/fscmService/StandardReceiptAPIService?WSDL").post(body).addHeader("content-type",
                                                                                                                                                         "text/xml").addHeader("cache-control",
                                                                                                                                                                               "no-cache").build();

                String strResp = null;
                Response response = client.newCall(request).execute();
                InputStream isr = response.body().byteStream();
                BufferedReader reader =
                    new BufferedReader(new InputStreamReader(isr));
                StringBuilder out = new StringBuilder();
                String resultsXml;
                while ((resultsXml = reader.readLine()) != null) {
                    out.append(resultsXml);
                }

                int responseCode = response.code();
                System.out.println("Response Code : " + responseCode);
                //            System.err.println("Response : " + response.body().toString());
                if (responseCode > 200) {
                    strResp = out.toString();
                    //                strResp =
                    //                        strResp.substring(0, strResp.length() > 3998 ? 3998 : strResp.length());
                    System.err.println("Error Response : " + out.toString());
                } else {
                    //                System.err.println("Sucess Response : " + out.toString());
                    System.err.println("Sucess Response : " +
                                       out.toString().substring(out.toString().indexOf("<env:Envelope"),
                                                                out.toString().indexOf(enStr) +
                                                                enStr.length()));
                    DocumentBuilder builder =
                        DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    InputSource src = new InputSource();
                    //                src.setCharacterStream(new StringReader(out.toString()));
                    src.setCharacterStream(new StringReader(out.toString().substring(out.toString().indexOf("<env:Envelope"),
                                                                                     out.toString().indexOf(enStr) +
                                                                                     enStr.length())));
                    Document doc = builder.parse(src);
                    trxStatus =
                            doc.getElementsByTagName("result").item(0).getTextContent();
                    //                System.out.println("Result 2 : " +
                    //                                   doc.getElementsByTagName("result").item(1).getTextContent());
                    errMsg =
                            doc.getElementsByTagName("result").item(2).getTextContent();


                }
                reader.close();
                if (trxStatus.equalsIgnoreCase("E")) {
                    currRow.setAttribute("Attribute1", errMsg);
                    this.attributResponse.setValue(errMsg);
                    JSFUtils.addFacesInformationMessage("Receipt Payload Response: " +
                                                        errMsg);

                    //this.AttributResponse.setValue(reqPayload);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAttributResponse());
                    System.out.println("Error : " + errMsg);
                    //                JSFUtils.addFacesInformationMessage("Invoice not generated successfully");
                } else {
                    //this.responseTxt.setValue(reqPayload);

                    currRow.setAttribute("Attribute1", p_receipt_Number);
                    this.attributResponse.setValue(p_receipt_Number);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAttributResponse());
                    JSFUtils.addFacesInformationMessage("Receipt Payload Response: " +
                                                        p_receipt_Number);

                    System.out.println("Receipt Number : " + trxStatus);
                    //                JSFUtils.addFacesInformationMessage("Invoice generated successfully");
                }
            } catch (Exception e) {
                JSFUtils.addFacesInformationMessage("Receipt Payload Response: " +
                                                    e);
                e.printStackTrace();
            }


        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

    }

    public String getHeaderPayload(String xmlData) {
        String xml = "";
        String webservice_username = "deepak.r@4iapps.com";
        String webservice_password = "welcome@4i";

        try {
            Date date = new Date();
            SimpleDateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'");
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            long t = date.getTime();
            Date expDate = new Date(t + (10 * 60000));
            String createdTS = dateFormat.format(date);
            String expiresTS = dateFormat.format(expDate);
            xml +=
"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptAPIService/types/\">\n" +
                    "   <soapenv:Header>\n" +
                    "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                    "         <wsu:Timestamp wsu:Id=\"TS-2F1FB5791F42235AD715286248169523\">\n" +
                    "            <wsu:Created>" + createdTS +
                    "</wsu:Created>\n" +
                    "            <wsu:Expires>" + expiresTS +
                    "</wsu:Expires>\n" +
                    "         </wsu:Timestamp>\n" +
                    "         <wsse:UsernameToken wsu:Id=\"UsernameToken-7A5DA39F515F1BF2A415269962607085\">\n" +
                    "            <wsse:Username>" + webservice_username +
                    "</wsse:Username>\n" +
                    "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" +
                    webservice_password + "</wsse:Password>\n" +
                    "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">RbsIPfPOF5iLkM0AjfdFlA==</wsse:Nonce>\n" +
                    "            <wsu:Created>2018-05-22T13:37:40.708Z</wsu:Created>\n" +
                    "         </wsse:UsernameToken>\n" +
                    "      </wsse:Security>\n" +
                    "   </soapenv:Header>" + xmlData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    public void setResponseTxt(RichInputText responseTxt) {
        this.responseTxt = responseTxt;
    }

    public RichInputText getResponseTxt() {
        return responseTxt;
    }

    public void setCustomerAR(RichSelectOneChoice customerAR) {
        this.customerAR = customerAR;
    }

    public RichSelectOneChoice getCustomerAR() {
        return customerAR;
    }


    public void onChangeCustomerNo(ValueChangeEvent valueChangeEvent) {

        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {

            ViewObject offerDtlVO =
                ADFUtils.findIterator("GetCustomerDetailsROVO1Iterator1").getViewObject();
            ViewCriteria offerDtlVC = offerDtlVO.createViewCriteria();
            ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
            offerDtlVCR.setAttribute("CustId", valueChangeEvent.getNewValue());
            offerDtlVC.addRow(offerDtlVCR);
            offerDtlVO.applyViewCriteria(offerDtlVC);
            offerDtlVO.executeQuery();
            if (offerDtlVO.getEstimatedRowCount() > 0) {
                ViewObject BookingCustomer_VO1 =
                    ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
                BookingCustomer_VO1.getCurrentRow().setAttribute("Trans_CustomerNo",
                                                                 offerDtlVO.first().getAttribute("CustomerNumber"));
            }


        }

    }

    public void setAttributResponse(RichInputText attributResponse) {
        this.attributResponse = attributResponse;
    }

    public RichInputText getAttributResponse() {
        return attributResponse;
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void setT8(RichTable t8) {
        this.t8 = t8;
    }

    public RichTable getT8() {
        return t8;
    }

    public void onClickPDFReportReceipt(FacesContext facesContext,
                                        java.io.OutputStream outputStream) {

        try {
            Object result = runReciptReport("//reports//Booking Receipt.rtf");
            outputStream.write((byte[])result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getXMLDataforReceipt(String p_booking_number) throws Exception {
        String retStr = "";
        Context ctx;
        Connection con = null;
        ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("PL");
        con = ds.getConnection();
        String selectSQL =
            "SELECT XXPM_REPORT_PKG.xxpm_provisional_bk_receipt('" +
            p_booking_number + "') xml FROM dual";
        PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
        ResultSet rs1 = preparedStatement.executeQuery(selectSQL);
        while (rs1.next()) {
            retStr = rs1.getString("xml");
        }
        return retStr;
    }

    public byte[] runReciptReport(String templateFile) {

        byte[] dataBytes = null;

        try {
            ViewObject quoteVO =
                ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
            Row re = quoteVO.getCurrentRow();

            String quoteNumber =
                re.getAttribute("BookingNumber1") == null ? "" :
                re.getAttribute("BookingNumber1").toString();
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

                new ByteArrayInputStream((getXMLDataforReceipt(quoteNumber).getBytes()));

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

        }
        return dataBytes;
    }

    /*Invoice Line Start*/


    public void pushInvoiceLineData(ActionEvent actionEvent) {


        String trxStatus = null;
        String errMsg = null;

        Random rand = new Random();
        int value = rand.nextInt(1000);

        Calendar cal = Calendar.getInstance();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Object sysDate = sdf.format(cal.getTime());

        Object customer_name =
            this.customerAR.getValue() == null ? null : this.customerAR.getValue().toString();

        Object customerSiteObj =
            this.billToAddress.getValue() == null ? null : this.billToAddress.getValue().toString();


        ViewObject customerVO =
            ADFUtils.findIterator("GetCustomerDetailsROVO1Iterator").getViewObject();

        ViewObjectImpl voInvImpl = (ViewObjectImpl)customerVO.getViewObject();
        ViewCriteria voInvVC = voInvImpl.getViewCriteria("findById");
        customerVO.applyViewCriteria(voInvVC);
        customerVO.setNamedWhereClauseParam("CUSID", customer_name);
        customerVO.executeQuery();
        Row firstRow = customerVO.first();

        Object batchSourceNameObj = "Lease";
        Object customerTrxTypeNameObj = "Leasing Invoice";
        Object invoicingRuleNameObj = "Advance Invoice";
        Object accountingRuleNameObj = "Daily Rate All Periods";
        Object lineTypeObj = "LINE";
        Object quantityObj = "1";
        Object paymentTermsNameObj = "IMMEDIATE";
        Object taxCodeObj = "SR UAT 5%";
        Object currencyCodeObj = "AED";
        Object testObj = "INV" + value;

        ViewObject BookingHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();

        Object orgIdObj =
            BookingHdrVo.getCurrentRow().getAttribute("OrgId") == null ?
            "300000001727604" :
            BookingHdrVo.getCurrentRow().getAttribute("OrgId");

        Object amountObj =
            BookingHdrVo.getCurrentRow().getAttribute("BookingAmount") ==
            null ? "3000" :
            BookingHdrVo.getCurrentRow().getAttribute("BookingAmount");

        Object billCustomerAccountNumberObj =
            firstRow.getAttribute("CustomerNumber") == null ? null :
            firstRow.getAttribute("CustomerNumber");

        Object billCustomerSiteNumberObj =
            this.billToAddress.getValue() == null ? null :
            this.billToAddress.getValue().toString();

        Object billingDateObj = sysDate;
        Object commentsObj = "From Property Lease Module";
        Object trxDateObj = sysDate;
        Object descriptionObj = "From Property Lease Module";
        Object glDateObj = sysDate;
        Object ruleStartDateObj =
            BookingHdrVo.getCurrentRow().getAttribute("Lease_Start_Date_Trans") ==
            null ? "300000001727604" :
            BookingHdrVo.getCurrentRow().getAttribute("Lease_Start_Date_Trans");
        Object ruleEndDateObj =
            BookingHdrVo.getCurrentRow().getAttribute("Lease_End_Date_trans") ==
            null ? "300000001727604" :
            BookingHdrVo.getCurrentRow().getAttribute("Lease_End_Date_trans");
        Object unitSellingPriceObj = amountObj;

        String enStr = "</env:Envelope>";
        String reqPayload = "<soapenv:Body>\n" +
            "      <typ:createInterfaceLine>\n" +
            "         <typ:interfaceLine>\n" +
            "            <inv:OrgId>" + orgIdObj + "</inv:OrgId>\n" +
            "            <inv:Amount currencyCode=\"AED\">" + amountObj +
            "</inv:Amount>\n" +
            "            <inv:BatchSourceName>" + batchSourceNameObj +
            "</inv:BatchSourceName>\n" +
            "            <inv:CustomerTrxTypeName>" + customerTrxTypeNameObj +
            "</inv:CustomerTrxTypeName>\n" +
            "            <inv:BillCustomerAccountNumber>" +
            billCustomerAccountNumberObj +
            "</inv:BillCustomerAccountNumber>\n" +
            "            <inv:BillCustomerSiteNumber>" +
            billCustomerSiteNumberObj + "</inv:BillCustomerSiteNumber>\n" +
            "            <inv:BillingDate>" + billingDateObj +
            "</inv:BillingDate>\n" +
            "            <inv:Comments>" + commentsObj + "</inv:Comments>\n" +
            "            <inv:TrxDate>" + trxDateObj + "</inv:TrxDate>\n" +
            "            <inv:CurrencyCode>" + currencyCodeObj +
            "</inv:CurrencyCode>\n" +
            "            <inv:Description>" + descriptionObj +
            "</inv:Description>\n" +
            "            <inv:GlDate>" + glDateObj + "</inv:GlDate>\n" +
            "            <inv:InvoicingRuleName>" + invoicingRuleNameObj +
            "</inv:InvoicingRuleName>\n" +
            "            <inv:AccountingRuleName>" + accountingRuleNameObj +
            "</inv:AccountingRuleName>\n" +
            "            <!--inv:AccountingRuleDuration>20</inv:AccountingRuleDuration-->\n" +
            "            <inv:RuleEndDate>" + ruleEndDateObj +
            "</inv:RuleEndDate>\n" +
            "            <inv:RuleStartDate>" + ruleStartDateObj +
            "</inv:RuleStartDate>\n" +
            "            <inv:UnitSellingPrice currencyCode=\"AED\">" +
            unitSellingPriceObj + "</inv:UnitSellingPrice>\n" +
            "            <inv:LineType>" + lineTypeObj + "</inv:LineType>\n" +
            "            <inv:Quantity>" + quantityObj + "</inv:Quantity>\n" +
            "            <inv:PaymentTermsName>" + paymentTermsNameObj +
            "</inv:PaymentTermsName>\n" +
            "            <inv:TaxCode>" + taxCodeObj + "</inv:TaxCode>\n" +
            "            <inv:TransactionInterfaceLineDff xsi:type=\"tran2:test\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "               <tran2:__FLEX_Context>test</tran2:__FLEX_Context>\n" +
            "               <tran2:test>" + testObj + "</tran2:test>\n" +
            "            </inv:TransactionInterfaceLineDff>\n" +
            "         </typ:interfaceLine>\n" +
            "      </typ:createInterfaceLine>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";

        reqPayload = getInvoiceLineHeaderPayload(reqPayload);
        try {
            reqPayload = reqPayload.replaceAll("&", "&");
            System.err.println("Invoice Payload--" + reqPayload);
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");
            RequestBody body = RequestBody.create(mediaType, reqPayload);
            Request request =
                new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com/fscmService/RecInvoiceService?wsdl").post(body).addHeader("content-type",
                                                                                                                                         "text/xml").addHeader("cache-control",
                                                                                                                                                               "no-cache").build();
            String strResp = null;
            Response response = client.newCall(request).execute();
            InputStream isr = response.body().byteStream();
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }

            int responseCode = response.code();
            System.out.println("Response Code : " + responseCode);
            //            System.err.println("Response : " + response.body().toString());
            if (responseCode > 200) {
                strResp = out.toString();
                System.err.println("Error Response : " + out.toString());
                System.err.println("Error " +
                                   getInvoiceLineRespValue(responseCode,
                                                           out.toString()));
                this.invoiceResponseTxt.setValue(getInvoiceLineRespValue(responseCode,
                                                                         out.toString()));
            } else {
                System.err.println("Sucess Response : " + out.toString());
                //                System.err.println("Sucess Response : " +
                //                                   out.toString().substring(out.toString().indexOf("<env:Envelope"),
                //                                                            out.toString().indexOf(enStr) +
                //                                                            enStr.length()));
                System.err.println("Success " +
                                   getInvoiceLineRespValue(responseCode,
                                                           out.toString()));
                this.invoiceResponseTxt.setValue(getInvoiceLineRespValue(responseCode,
                                                                         out.toString()));

            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getInvoiceLineHeaderPayload(String xmlData) {
        String xml = "";
        String webservice_username = "deepak.r@4iapps.com";
        String webservice_password = "welcome@4i";

        try {
            Date date = new Date();
            SimpleDateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'");
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            long t = date.getTime();
            Date expDate = new Date(t + (10 * 60000));
            String createdTS = dateFormat.format(date);
            String expiresTS = dateFormat.format(expDate);
            xml +=
"<soapenv:Envelope xmlns:inv=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tran=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/\" xmlns:tran1=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionLineInterfaceGdf/\" xmlns:tran2=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/\" xmlns:tran3=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceLinkToDff/\" xmlns:tran4=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceReferenceDff/\" xmlns:tran5=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineDff/\" xmlns:tran6=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/types/\">\n" +
                    "   <soapenv:Header>\n" +
                    "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                    "         <wsu:Timestamp wsu:Id=\"TS-2F1FB5791F42235AD715286248169523\">\n" +
                    "            <wsu:Created>" + createdTS +
                    "</wsu:Created>\n" +
                    "            <wsu:Expires>" + expiresTS +
                    "</wsu:Expires>\n" +
                    "         </wsu:Timestamp>\n" +
                    "         <wsse:UsernameToken wsu:Id=\"UsernameToken-7A5DA39F515F1BF2A415269962607085\">\n" +
                    "            <wsse:Username>" + webservice_username +
                    "</wsse:Username>\n" +
                    "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" +
                    webservice_password + "</wsse:Password>\n" +
                    "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">RbsIPfPOF5iLkM0AjfdFlA==</wsse:Nonce>\n" +
                    "            <wsu:Created>2018-05-22T13:37:40.708Z</wsu:Created>\n" +
                    "         </wsse:UsernameToken>\n" +
                    "      </wsse:Security>\n" +
                    "   </soapenv:Header>" + xmlData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    public String getInvoiceLineRespValue(int respCode, String out) {
        String resp = "";

        try {
            DocumentBuilder builder =
                DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(out));
            //                src.setCharacterStream(new StringReader(out.toString().substring(out.toString().indexOf("<env:Envelope"),
            //                                                                                 out.toString().indexOf(enStr) +
            //                                                                                 enStr.length())));
            Document doc = builder.parse(src);
            if (respCode > 200) {
                resp =
doc.getElementsByTagName("faultstring").item(0).getTextContent();
                src = new InputSource();
                src.setCharacterStream(new StringReader("<faultstring>" +
                                                        resp +
                                                        "</faultstring>"));
                doc = builder.parse(src);
                resp =
doc.getElementsByTagName("TEXT").item(0).getTextContent();
            } else {
                resp =
doc.getElementsByTagName("InterfaceLineGuid").item(0).getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    /*Invoice Line End*/

    public void setLeaseStartDate(RichInputDate leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public RichInputDate getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseEndDate(RichInputDate leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public RichInputDate getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setBookingAmt(RichInputText bookingAmt) {
        this.bookingAmt = bookingAmt;
    }

    public RichInputText getBookingAmt() {
        return bookingAmt;
    }


    /*Receipt Apply START*/

    public void pushReceiptApplyData(ActionEvent actionEvent) {


        String trxStatus = null;
        String errMsg = null;

        Random rand = new Random();
        int value = rand.nextInt(1000);
        Calendar cal = Calendar.getInstance();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Object sysDate = sdf.format(cal.getTime());

        ViewObject receiptVO =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row currRow = receiptVO.getCurrentRow();

        Object amountAppliedObj =
            currRow.getAttribute("RecommendedAmount") == null ? "0" :
            currRow.getAttribute("RecommendedAmount");

        Object commentsObj = "APPLY";

        Object customerTrxIdObj = "300000001741429";

        Object receiptNumberObj =
            currRow.getAttribute("ReceiptNumber") == null ? "0" :
            currRow.getAttribute("ReceiptNumber");

        Object receiptAmountObj =
            currRow.getAttribute("RecommendedAmount") == null ? "0" :
            currRow.getAttribute("RecommendedAmount");

        Object receiptDateObj =
            currRow.getAttribute("ReceiptDate") == null ? "0" :
            currRow.getAttribute("ReceiptDate");

        Object transactionDateObj = sysDate;
        Object applicationDateObj = sysDate;
        Object accountingDateObj = sysDate;

        String enStr = "</env:Envelope>";
        String reqPayload = "<soapenv:Body>\n" +
            "      <typ:createApplyReceipt>\n" +
            "         <typ:applyReceipt>           \n" +
            "            <com:AmountApplied>" + amountAppliedObj +
            "</com:AmountApplied>            \n" +
            "            <com:Comments>" + commentsObj + "</com:Comments>\n" +
            "            <com:CustomerTrxId>" + customerTrxIdObj +
            "</com:CustomerTrxId>\n" +
            "            <com:ReceiptNumber>" + receiptNumberObj +
            "</com:ReceiptNumber>\n" +
            "            <com:ReceiptAmount currencyCode=\"AED\">" +
            receiptAmountObj + "</com:ReceiptAmount>\n" +
            "            <com:ReceiptDate>" + receiptDateObj +
            "</com:ReceiptDate>\n" +
            "            <com:TransactionDate>" + transactionDateObj +
            "</com:TransactionDate>\n" +
            "            <com:ApplicationDate>" + applicationDateObj +
            "</com:ApplicationDate>\n" +
            "            <com:AccountingDate>" + accountingDateObj +
            "</com:AccountingDate>\n" +
            "         </typ:applyReceipt>\n" +
            "      </typ:createApplyReceipt>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";

        reqPayload = getHeaderPayload(reqPayload);
        try {
            reqPayload = reqPayload.replaceAll("&", "&");
            System.err.println("RECEIPT Payload" + reqPayload);
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");
            RequestBody body = RequestBody.create(mediaType, reqPayload);
            Request request =
                new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com/fscmService/RecInvoiceService?wsdl").post(body).addHeader("content-type",
                                                                                                                                         "text/xml").addHeader("cache-control",
                                                                                                                                                               "no-cache").build();
            String strResp = null;
            Response response = client.newCall(request).execute();
            InputStream isr = response.body().byteStream();
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }
            int responseCode = response.code();
            System.out.println("Response Code : " + responseCode);
            //            System.err.println("Response : " + response.body().toString());
            if (responseCode > 200) {
                strResp = out.toString();
                System.err.println("Error Response : " + out.toString());
                System.err.println("Error " +
                                   getReceiptApplyRespValue(responseCode,
                                                            out.toString()));
                this.applyReceiptTxt.setValue(getReceiptApplyRespValue(responseCode,
                                                                       out.toString()));
                AdfFacesContext.getCurrentInstance().addPartialTarget(applyReceiptTxt);
            } else {
                System.err.println("Sucess Response : " + out.toString());
                //                System.err.println("Sucess Response : " +
                //                                   out.toString().substring(out.toString().indexOf("<env:Envelope"),
                //                                                            out.toString().indexOf(enStr) +
                //                                                            enStr.length()));

                System.err.println("Success " +
                                   getReceiptApplyRespValue(responseCode,
                                                            out.toString()));
                this.applyReceiptTxt.setValue(getReceiptApplyRespValue(responseCode,
                                                                       out.toString()));
                AdfFacesContext.getCurrentInstance().addPartialTarget(applyReceiptTxt);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getReceiptApplyHeaderPayload(String xmlData) {
        String xml = "";
        String webservice_username = "deepak.r@4iapps.com";
        String webservice_password = "welcome@4i";

        try {
            Date date = new Date();
            SimpleDateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'");
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            long t = date.getTime();
            Date expDate = new Date(t + (10 * 60000));
            String createdTS = dateFormat.format(date);
            String expiresTS = dateFormat.format(expDate);
            xml +=
"<soapenv:Envelope xmlns:inv=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tran=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionInterfaceLineDff/\" xmlns:tran1=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/types/\">\n" +
                    "   <soapenv:Header>\n" +
                    "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                    "         <wsu:Timestamp wsu:Id=\"TS-2F1FB5791F42235AD715286248169523\">\n" +
                    "            <wsu:Created>" + createdTS +
                    "</wsu:Created>\n" +
                    "            <wsu:Expires>" + expiresTS +
                    "</wsu:Expires>\n" +
                    "         </wsu:Timestamp>\n" +
                    "         <wsse:UsernameToken wsu:Id=\"UsernameToken-7A5DA39F515F1BF2A415269962607085\">\n" +
                    "            <wsse:Username>" + webservice_username +
                    "</wsse:Username>\n" +
                    "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" +
                    webservice_password + "</wsse:Password>\n" +
                    "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">RbsIPfPOF5iLkM0AjfdFlA==</wsse:Nonce>\n" +
                    "            <wsu:Created>2018-05-22T13:37:40.708Z</wsu:Created>\n" +
                    "         </wsse:UsernameToken>\n" +
                    "      </wsse:Security>\n" +
                    "   </soapenv:Header>" + xmlData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    public String getReceiptApplyRespValue(int respCode, String out) {
        String resp = "";
        try {
            DocumentBuilder builder =
                DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(out));
            //                src.setCharacterStream(new StringReader(out.toString().substring(out.toString().indexOf("<env:Envelope"),
            //                                                                                 out.toString().indexOf(enStr) +
            //                                                                                 enStr.length())));
            Document doc = builder.parse(src);
            if (respCode > 200) {
                resp =
doc.getElementsByTagName("faultstring").item(0).getTextContent();
                src = new InputSource();
                src.setCharacterStream(new StringReader("<faultstring>" +
                                                        resp +
                                                        "</faultstring>"));
                doc = builder.parse(src);
                resp =
doc.getElementsByTagName("TEXT").item(0).getTextContent();
            } else {
                resp =
doc.getElementsByTagName("InterfaceDistributionGuid").item(0).getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void onclickAppOrRej(ActionEvent actionEvent) {
        // Add event code here...
        Object val =
            ADFContext.getCurrent().getPageFlowScope().get("Action") == null ?
            "" :
            ADFContext.getCurrent().getPageFlowScope().get("Action").toString();

        if (val.equals("Approval")) {
            onClickApprove(actionEvent);
        }


        if (val.equals("Rejection")) {
            OnClickReject(actionEvent);
        }


    }

    public void onInvokeAppOrrejec(ActionEvent actionEvent) {
        String ackFlagStatus="Y";
        ViewObject rcptVo1 =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        System.out.println("Count RcptVo1 :"+rcptVo1.getEstimatedRowCount());
        String action = ADFContext.getCurrent().getPageFlowScope().get("Action").toString();
        if (action.equalsIgnoreCase("Rejection")){
//            System.out.println("Rejection action :"+action);
        }else{
        ViewObject bkHdrVo = ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row re = bkHdrVo.getCurrentRow();
        String flowLvl =  re.getAttribute("FlowLevel") == null ? "" : re.getAttribute("FlowLevel").toString();
            if(flowLvl.equalsIgnoreCase("1")){
                //skip for approver 1 as finance not for legal
            }else{
        if (rcptVo1.getEstimatedRowCount() > 0) {
        RowSetIterator rs = rcptVo1.createRowSet(null);
            while(rs.hasNext()){
                 Row rsRow = rs.next();
                String rctType = rsRow.getAttribute("RctType")==null ? "" : rsRow.getAttribute("RctType").toString();
                if(rctType.equalsIgnoreCase("BK")){
                System.out.println("Ack Flag : "+rsRow.getAttribute("AckFlag"));  
                String ackF = rsRow.getAttribute("AckFlag")==null ? "" : rsRow.getAttribute("AckFlag").toString();
                if (ackF.equalsIgnoreCase("N") || ackF.equalsIgnoreCase("")) {
                    ackFlagStatus="N";
                    break;
                }
                }
            }
            rs.closeRowSetIterator();
        }
            }
    }
        if (ackFlagStatus.equalsIgnoreCase("Y")){
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup3().show(popup34);
        }else{
            JSFUtils.addFacesErrorMessage("Please Acknowledge all Booking charge type receipts before approval"); 
        }
    }

    public void setPopup3(RichPopup popup3) {
        this.popup3 = popup3;
    }

    public RichPopup getPopup3() {
        return popup3;
    }

    /*Receipt Apply END*/

    public void setReason(RichInputText reason) {
        this.reason = reason;
    }

    public RichInputText getReason() {
        return reason;
    }

    public void receiptReturnListener(ReturnEvent returnEvent) {
        //        ViewObject VO=ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        //        VO.executeQuery();
        String Totalrent = "";
        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer dcb =
            (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding iter =
            dcb.findIteratorBinding("Receipt_VO1Iterator");
        iter.executeQuery();
        //RequestContext.getCurrentInstance().addPartialTarget(returnEvent.getComponent().getParent().getParent());


        ViewObject OfferDtlVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        if (OfferDtlVo.getEstimatedRowCount() > 0) {
            RowSetIterator rs = OfferDtlVo.createRowSet("");
            //BigDecimal totalRecAmnt=new BigDecimal(0);
            Double totalRecAmnt = new Double(0);

            while (rs.hasNext()) {

                Row detailRow = rs.next();

                System.err.println("==========AMOUNT" +
                                   detailRow.getAttribute("RecommendedAmount"));

                String amnt =
                    detailRow.getAttribute("RecommendedAmount") == null ? "0" :
                    detailRow.getAttribute("RecommendedAmount").toString();
                Double RecAmnt = new Double(amnt);
                totalRecAmnt = totalRecAmnt + RecAmnt;


            }

            BigDecimal TotalRecAmn = BigDecimal.valueOf(totalRecAmnt);

            ViewObject BookHdr =
                ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
            if (BookHdr.first() != null) {
                Totalrent =
                        BookHdr.first().getAttribute("BaseRate") == null ? "0" :
                        BookHdr.first().getAttribute("BaseRate").toString();
            } else {
                Totalrent = "0";
            }
            //            String BookAmnt = "0";
            // valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
            Double Totalre = new Double(Totalrent);
            //            Double BookAm = new Double(BookAmnt);
            Double ValueforYear = Totalre / 365;
            Double NofDuDays = totalRecAmnt / ValueforYear;


            ViewObject BkHdrVo =
                ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
            Row re = BkHdrVo.getCurrentRow();
            String DateFr =
                re.getAttribute("BookingDate") == null ? "" : re.getAttribute("BookingDate").toString();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = new Date();
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar c = Calendar.getInstance();
            c.setTime(date1);
            c.add(Calendar.DATE, (int)Math.round(NofDuDays));
            DateFormat format12 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = format12.format(c.getTime());

            Date date2 = new Date();
            try {
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(formatted);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
            oracle.jbo.domain.Date domadate =
                new oracle.jbo.domain.Date(sqlDate);
            re.setAttribute("BookingDueDate", domadate);
            re.setAttribute("BookingAmount", TotalRecAmn);

            this.bookingAmt.setValue(TotalRecAmn);
            this.bookingDuedate.setValue(re.getAttribute("BookingDueDate"));

        }
    }

    public void makeReceipToMilestone() {
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        RowSetIterator quoteMileRS = receiptVo.createRowSetIterator(null);
        ViewObject OfferMilestoneDetail_VO4 =
            ADFUtils.findIterator("OfferMilestoneDetail_VO4Iterator1").getViewObject();
        ViewObject BookingMsDtlVo =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        while (quoteMileRS.hasNext()) {
            Row r1 = quoteMileRS.next();
            Row bookingRow = BookingMsDtlVo.createRow();
            bookingRow.setAttribute("InstallmentType", "BA");
            //MsDtlId
            bookingRow.setAttribute("InstallmentAmount",
                                    r1.getAttribute("RecommendedAmount"));
            bookingRow.setAttribute("MilestoneType", "BK");
            BookingMsDtlVo.insertRow(bookingRow);
            //OfferMilestoneDetail_VO4Iterator1
            Row bookingRows = OfferMilestoneDetail_VO4.createRow();
            bookingRows.setAttribute("MsDtlId", 1);
            bookingRows.setAttribute("InstallmentType", "BA");
            bookingRows.setAttribute("InstallmentAmount",
                                     r1.getAttribute("RecommendedAmount"));
            bookingRows.setAttribute("MilestoneType", "BK");
            OfferMilestoneDetail_VO4.insertRow(bookingRows);

        }
        OfferMilestoneDetail_VO4.executeQuery();
        BookingMsDtlVo.executeQuery();

    }


    public void setBookingDuedate(RichInputDate bookingDuedate) {
        this.bookingDuedate = bookingDuedate;
    }

    public RichInputDate getBookingDuedate() {
        return bookingDuedate;
    }

    public void setBillToAddress(RichSelectOneChoice billToAddress) {
        this.billToAddress = billToAddress;
    }

    public RichSelectOneChoice getBillToAddress() {


        return billToAddress;
    }

    public void setApplyReceiptTxt(RichInputText applyReceiptTxt) {
        this.applyReceiptTxt = applyReceiptTxt;
    }

    public RichInputText getApplyReceiptTxt() {
        return applyReceiptTxt;
    }

    public void setInvoiceResponseTxt(RichInputText invoiceResponseTxt) {
        this.invoiceResponseTxt = invoiceResponseTxt;
    }

    public RichInputText getInvoiceResponseTxt() {
        return invoiceResponseTxt;
    }

    public void setCustomerAR_T(RichInputComboboxListOfValues customerAR_T) {
        this.customerAR_T = customerAR_T;
    }

    public RichInputComboboxListOfValues getCustomerAR_T() {
        return customerAR_T;
    }

    //****************************Line level Receipt genration-Start****************************//

    public void onClickPDFLineReceipt(FacesContext facesContext,
                                      java.io.OutputStream outputStream) {

        try {
            Object result =
                runLineReciptReport("//reports//Booking Line Receipt.rtf");
            outputStream.write((byte[])result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getXMLDataforLineReceipt(String p_receipt_number) throws Exception {
        String retStr = "";
        Context ctx;
        Connection con = null;
        ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("PL");
        con = ds.getConnection();
        String selectSQL =
            "SELECT XXPM_REPORT_PKG.Xxpm_bookingreceipt_form('" +
            p_receipt_number + "') xml FROM dual";
        //        System.err.println("Query " + selectSQL);
        PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
        ResultSet rs1 = preparedStatement.executeQuery(selectSQL);
        while (rs1.next()) {
            retStr = rs1.getString("xml");
            //            System.err.println("XML O/P" + rs1.getString("xml"));
        }
        return retStr;
    }

    public byte[] runLineReciptReport(String templateFile) {

        byte[] dataBytes = null;

        try {
            ViewObject receiptVO =
                ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
            Row re = receiptVO.getCurrentRow();
            String quoteNumber =
                re.getAttribute("ReceiptNumber") == null ? "" :
                re.getAttribute("ReceiptNumber").toString();
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

                new ByteArrayInputStream((getXMLDataforLineReceipt(quoteNumber).getBytes()));

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
    //****************************Line level Receipt genration-End****************************//

    /* This method is used to create the receipt in AR */

    public void arReceiptCreatePayload(ActionEvent actionEvent) {
        String validationFlag = "Y";
        try {
            Object amount = null;
            Object currencyCode = "AED";
            //            Object glDate = getCurrentDateForPayload();
            //            Object maturityDate = getCurrentDateForPayload();
            Object orgId = null;
            Object customerId = null;
            Object receiptDate = null;
            Object receiptMethodId = null;
            Object receiptNumber = null;
            Object leaseNumber = null;
            Object bookingNumber = null;
            Object building = null;
            Object unit = null;
            Object receiptPayMode = null;
            Object environment = "prod";
            Object bookingId = null;
            Object chequeEffectiveDate = null;
            Object chequeNo = null;
            Object comments = null;

            ViewObject receiptVO =
                ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
            receiptPayMode = receiptVO.getCurrentRow().getAttribute("PayMode");
            receiptNumber =
                    receiptVO.getCurrentRow().getAttribute("ReceiptNumber");
            if (receiptPayMode == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Receipt Payment Mode is Required");
            } else {
                chequeEffectiveDate =
                        receiptVO.getCurrentRow().getAttribute("PayRefDate");
                chequeNo =
                        receiptVO.getCurrentRow().getAttribute("PayRefNumber");
                receiptNumber =
                        receiptVO.getCurrentRow().getAttribute("ReceiptNumber");
                receiptDate =
                        receiptVO.getCurrentRow().getAttribute("ReceiptDate");
                amount =
                        receiptVO.getCurrentRow().getAttribute("RecommendedAmount");
                comments =
                        receiptVO.getCurrentRow().getAttribute("Description");

                ViewObject bookingVO =
                    ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
                bookingId =
                        bookingVO.getCurrentRow().getAttribute("BookingId1");
                orgId = bookingVO.getCurrentRow().getAttribute("OrgId");
                bookingNumber =
                        bookingVO.getCurrentRow().getAttribute("BookingNumber1");
                ViewObject invoiceInterfaceValueVO =
                    ADFUtils.findIterator("getReceiptPayloadDtlForBooing_ROVO1Iterator").getViewObject();
                invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_BOOKING_ID",
                                                                 bookingId);
                invoiceInterfaceValueVO.executeQuery();
                if (invoiceInterfaceValueVO.first() != null) {
                    customerId =
                            invoiceInterfaceValueVO.first().getAttribute("CustIdAr");
                    building =
                            invoiceInterfaceValueVO.first().getAttribute("BuildName");
                    unit =
                            invoiceInterfaceValueVO.first().getAttribute("UnitName");
                }

                if (orgId != null && receiptPayMode != null) {
                    ViewObject receiptMethodVO =
                        ADFUtils.findIterator("getReceiptMethod_ROVO1Iterator").getViewObject();
                    receiptMethodVO.setNamedWhereClauseParam("BV_ORG_ID",
                                                             orgId.toString());
                    receiptMethodVO.setNamedWhereClauseParam("BV_TYPE",
                                                             receiptPayMode.toString());
                    receiptMethodVO.executeQuery();
                    if (receiptMethodVO.first() != null) {
                        receiptMethodId =
                                receiptMethodVO.first().getAttribute("ReceiptMethodId");
                    }
                }

                if (amount == null) {
                    validationFlag = "N";
                    JSFUtils.addFacesErrorMessage("Receipt amount is Required");
                }

                //                if (maturityDate == null) {
                //                    validationFlag = "N";
                //                    JSFUtils.addFacesErrorMessage("Maturity Date is Required");
                //                }
                if (orgId == null) {
                    validationFlag = "N";
                    JSFUtils.addFacesErrorMessage("Organization details is Required");
                }
                if (customerId == null) {
                    validationFlag = "N";
                    JSFUtils.addFacesErrorMessage("customer details is Required");
                }
                if (receiptDate == null) {
                    validationFlag = "N";
                    JSFUtils.addFacesErrorMessage("Receipt Date is Required");
                }
                if (receiptMethodId == null) {
                    validationFlag = "N";
                    JSFUtils.addFacesErrorMessage("Receipt Method is Required");
                }
                if (receiptNumber == null) {
                    validationFlag = "N";
                    JSFUtils.addFacesErrorMessage("Receipt Number is Required");
                }

                if (bookingNumber == null) {
                    validationFlag = "N";
                    JSFUtils.addFacesErrorMessage("Booking Number is Required");
                }
            }


            if (validationFlag == "Y") {
                JSONObject obj = new JSONObject();

                obj.put("amount", amount.toString());
                obj.put("currencyCode", currencyCode.toString());
                obj.put("comments", comments.toString());
                obj.put("orgId", orgId.toString());
                obj.put("customerId", customerId.toString());
                obj.put("receiptDate", receiptDate.toString());
                obj.put("receiptMethodId", receiptMethodId.toString());
                if (chequeEffectiveDate != null) {
                    obj.put("maturityDate", chequeEffectiveDate.toString());
                } else {
                    obj.put("maturityDate", receiptDate.toString());
                }
                if (chequeNo != null) {
                    obj.put("chequeNo", chequeNo.toString());
                } 
                obj.put("receiptNumber", receiptNumber.toString());
                //obj.put("leaseNumber", leaseNumber.toString());
                obj.put("bookingNumber", bookingNumber.toString());
                obj.put("building", building);
                obj.put("unit", unit);
                obj.put("environment", environment.toString());

                //                JSFUtils.addFacesInformationMessage("Receipt Create JSON Payload" +
                //                                                    obj.toString());
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body =
                    RequestBody.create(mediaType, obj.toJSONString());
                Request request =
                    new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/receipt/create/v1").post(body).addHeader("Content-Type",
                                                                                                                                              "application/json").addHeader("Cache-Control",
                                                                                                                                                                            "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                  "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                //test instance
//                Request request =
//                    new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/receipt/create/v1").post(body).addHeader("Content-Type",
//                                                                                                                                              "application/json").addHeader("Cache-Control",
//                                                                                                                                                                            "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                  "493ffe37-eaac-45fc-9962-8c6883aff73e").build();

                Response response = client.newCall(request).execute();
                //                JSFUtils.addFacesInformationMessage("Receipt Create JSON Payload Response" +
                //                                                    response);
                InputStream isr = response.body().byteStream();
                BufferedReader reader =
                    new BufferedReader(new InputStreamReader(isr));
                StringBuilder out = new StringBuilder();
                String resultsXml;

                while ((resultsXml = reader.readLine()) != null) {
                    out.append(resultsXml);
                }
                JSFUtils.addFacesInformationMessage("Receipt Response" + out);

                JSONParser parser = new JSONParser();
                JSONObject jsonObject =
                    (JSONObject)parser.parse(out.toString());
                JSFUtils.addFacesInformationMessage("Invoice Response as JSON" +
                                                    jsonObject);
                Object receiptId = jsonObject.get("cash_reciept_id");
                JSFUtils.addFacesInformationMessage("Invoice Response in  receiptId" +
                                                    jsonObject);

                receiptVO.getCurrentRow().setAttribute("Attribute1",
                                                       receiptId);
                this.attributResponse.setValue(receiptId);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAttributResponse());
                ADFUtils.findOperation("Commit").execute();
            }

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error in Receipt Create--" +
                                                e);
        }
    }

    public Object getCurrentDateForPayload() {
        Calendar cal = Calendar.getInstance();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Object sysDate = sdf.format(cal.getTime());
        return sysDate;
    }

    public void setCil5(RichCommandImageLink cil5) {
        this.cil5 = cil5;
    }

    public RichCommandImageLink getCil5() {
        return cil5;
    }

    public boolean getApprovalUser() {
        ViewObject bookingHeaderVO =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        boolean flag = false;
        String flowWith =
            bookingHeaderVO.getCurrentRow().getAttribute("FlowWith") == null ?
            null :
            bookingHeaderVO.getCurrentRow().getAttribute("FlowWith").toString();
        String LoginUserId =
            ADFContext.getCurrent().getSessionScope().get("userId") == null ?
            null :
            ADFContext.getCurrent().getSessionScope().get("userId").toString();
        if (flowWith != null && LoginUserId != null) {
            if (flowWith.equalsIgnoreCase(LoginUserId)) {
                flag = true;
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean getApprovalUser_rej() {
        ViewObject bookingHeaderVO =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        boolean flag = false;
        String flowWith =
            bookingHeaderVO.getCurrentRow().getAttribute("FlowWith") == null ?
            null :
            bookingHeaderVO.getCurrentRow().getAttribute("FlowWith").toString();
        String LoginUserId =
            ADFContext.getCurrent().getSessionScope().get("userId") == null ?
            null :
            ADFContext.getCurrent().getSessionScope().get("userId").toString();
        String userRole =
            ADFContext.getCurrent().getSessionScope().get("UR") == null ?
            null :
            ADFContext.getCurrent().getSessionScope().get("UR").toString();
        if (flowWith != null && LoginUserId != null) {
            if(userRole.equalsIgnoreCase("ACCCOUNTS") || userRole.equalsIgnoreCase("ACCOUNTS_MANAGER")){
                flag = false;
            }else{
            if (flowWith.equalsIgnoreCase(LoginUserId)) {
                flag = true;
            } else {
                flag = false;
            }
            }
        } else {
            flag = false;
        }
        return flag;
    }
    
    public void setPopup5(RichPopup popup5) {
        this.popup5 = popup5;
    }

    public RichPopup getPopup5() {
        return popup5;
    }

    public void onClickDelete(ActionEvent actionEvent) {
        // Add event code here...
                ViewObject vo =
                    ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
                vo.getCurrentRow().remove();
                ADFUtils.findOperation("Commit").execute();
                AdfFacesContext.getCurrentInstance().addPartialTarget(t41);
    }

    public void onSelectBkDate(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void onSelectBookingDate(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        
        ViewObject getFuncodeVo =
                          ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                      getFuncodeVo.setNamedWhereClauseParam("F_ID", "BK");
                      getFuncodeVo.executeQuery();
                      Object Funcode = getFuncodeVo.first().getAttribute("Attribute1");
                      System.err.println("FunctionId"+Funcode);
                      Integer days=Integer.parseInt(Funcode.toString());

        //        ----------------date+15-----------
        String bookingDate = valueChangeEvent.getNewValue().toString();
        System.err.println("bookingDate" + bookingDate);
        Date date = new Date();
        Date date1=new Date();
        String date3="";
        Calendar cal = Calendar.getInstance();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(bookingDate);
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
        ViewObject bookingVo=ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        bookingVo.getCurrentRow().setAttribute("Bookingexpirydate",domadate);
    }

//    public void onChangePayMode(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//    }
//
//    public void onChangeRecCharge(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//    }
//
//    public void setIt7(RichInputText it7) {
//        this.it7 = it7;
//    }
//
//    public RichInputText getIt7() {
//        return it7;
//    }
//
//    public void setId2(RichInputDate id2) {
//        this.id2 = id2;
//    }
//
//    public RichInputDate getId2() {
//        return id2;
//    }
//
//    public void setIt5(RichInputText it5) {
//        this.it5 = it5;
//    }
//
//    public RichInputText getIt5() {
//        return it5;
//    }
//
//    public void setIt14(RichInputText it14) {
//        this.it14 = it14;
//    }
//
//    public RichInputText getIt14() {
//        return it14;
//    }
//
//    public void setIt15(RichInputText it15) {
//        this.it15 = it15;
//    }
//
//    public RichInputText getIt15() {
//        return it15;
//    }
//
//    public void setIt17(RichInputText it17) {
//        this.it17 = it17;
//    }
//
//    public RichInputText getIt17() {
//        return it17;
//    }
//
//    public void setId3(RichInputDate id3) {
//        this.id3 = id3;
//    }
//
//    public RichInputDate getId3() {
//        return id3;
//    }
//
//    public void onChangeChequeDate(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//    }
//
//    public void onCalcDateDiff(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//    }
//
//    public void onValidate30Days(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//    }
//
//    public void onChangeReceivedAmnt(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//    }
//
//    public void onClickRcptCancel(ActionEvent actionEvent) {
//        // Add event code here...
//    }
//
//    public String onClickRcptSave() {
//        // Add event code here...
//        return null;
//    }
//
//    public void onClickOKRecActnLstn(ActionEvent actionEvent) {
//        // Add event code here...
//    }

    public String onCreateInstallReceipt() {
        // Add event code here...
        ViewObject bookCustVO =
                    ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
                Row cusRow = bookCustVO.getCurrentRow();
                ViewObject vo =
                    ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
                Row row = vo.getCurrentRow();
        ViewObject BookingMsVo =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
                Row DetRow = BookingMsVo.getCurrentRow();
                
                ADFContext.getCurrent().getPageFlowScope().put("Type","INS");
                ADFContext.getCurrent().getPageFlowScope().put("funcId",
                                                               row.getAttribute("FuncId") ==
                                                               null ? "" :
                                                               row.getAttribute("FuncId"));
                ADFContext.getCurrent().getPageFlowScope().put("scfnId",
                                                               row.getAttribute("BookingId1") ==
                                                               null ? "" :
                                                               row.getAttribute("BookingId1"));
                System.out.println("BookingId1 :"+row.getAttribute("BookingId1"));
                System.out.println("BookingId :"+row.getAttribute("BookingId"));
        System.out.println("BookingMsDtlId :"+DetRow.getAttribute("BookingMsDtlId"));

                ADFContext.getCurrent().getPageFlowScope().put("OrgId",
                                                               row.getAttribute("OrgId") ==
                                                               null ? "" :
                                                               row.getAttribute("OrgId"));
                ADFContext.getCurrent().getPageFlowScope().put("CustName",
                                                               cusRow.getAttribute("CustName") ==
                                                               null ? "" :
                                                               cusRow.getAttribute("CustName"));
               //Temporary receipt
               String leadName = row.getAttribute("Customer_Name_Trans")==null?"":row.getAttribute("Customer_Name_Trans").toString();
                String custAr = cusRow.getAttribute("Trans_CustIdAr")==null?"":cusRow.getAttribute("Trans_CustIdAr").toString();
                String orgID = row.getAttribute("OrgId")==null?"":row.getAttribute("OrgId").toString();
                    if (custAr.equalsIgnoreCase("") && !orgID.equals("300000007801262")){
                    ADFContext.getCurrent().getPageFlowScope().put("CustName",leadName);
                    ADFContext.getCurrent().getPageFlowScope().put("TempReceipt","TEMP_RECEIPT");
                }
                ADFContext.getCurrent().getPageFlowScope().put("CustBankName",
                                                               cusRow.getAttribute("CustBankName") ==
                                                               null ? "" :
                                                               cusRow.getAttribute("CustBankName"));
                ADFContext.getCurrent().getPageFlowScope().put("CustBankAccNumber",
                                                               cusRow.getAttribute("CustBankAccNumber") ==
                                                               null ? "" :
                                                               cusRow.getAttribute("CustBankAccNumber"));
                ADFContext.getCurrent().getPageFlowScope().put("CustBranchName",
                                                               cusRow.getAttribute("CustBranchName") ==
                                                               null ? "" :
                                                               cusRow.getAttribute("CustBranchName"));
                ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                               row.getAttribute("BookingId1") ==
                                                               null ? "" :
                                                               row.getAttribute("BookingId1"));
                ADFContext.getCurrent().getPageFlowScope().put("receiptType", "");
                ADFContext.getCurrent().getPageFlowScope().put("DueDate",
                                                                   DetRow.getAttribute("DueDate") ==
                                                                   null ? "" :
                                                                   DetRow.getAttribute("DueDate"));

                    //#{pageFlowScope.BookingMsId}

                            ADFContext.getCurrent().getPageFlowScope().put("BookingMsId",
                                                                           DetRow.getAttribute("BookingMsDtlId") ==
                                                                           null ? "" :
                                                                           DetRow.getAttribute("BookingMsDtlId"));
                                ADFContext.getCurrent().getPageFlowScope().put("Amount",
                                                                   DetRow.getAttribute("InstallmentAmount") ==
                                                                   null ? "" :
                                                                   DetRow.getAttribute("InstallmentAmount"));
        //08-sep-2020 for all receipts to capture BookingMsDtlId in receipt Attribute3 mainly for OC report
        String bkMsdtlId = DetRow.getAttribute("BookingMsDtlId") == null ? "" : DetRow.getAttribute("BookingMsDtlId").toString();
        System.out.println("bkMsdtlId ::"+bkMsdtlId);
        ADFContext.getCurrent().getPageFlowScope().put("remark", bkMsdtlId);
        //17-sep-2020 for security deposit SD payment mode
        ADFContext.getCurrent().getPageFlowScope().put("SDPayMode","");
        ADFContext.getCurrent().getPageFlowScope().put("modeType","Normal");
//description
                ViewObject lookUpVo =
                        ADFUtils.findIterator("Lookup_View_ROVO1Iterator").getViewObject();
            ViewCriteria vC = lookUpVo.createViewCriteria();
            ViewCriteriaRow vCRow = vC.createViewCriteriaRow();
            vCRow.setAttribute("LookupValueName", DetRow.getAttribute("InstallmentType"));
            vC.addRow(vCRow);
            lookUpVo.applyViewCriteria(vC);
            lookUpVo.executeQuery();
            if (lookUpVo.getEstimatedRowCount() > 0) { 
                Row lookUpVoRow = lookUpVo.first();
                String lookupValueDisp = lookUpVoRow.getAttribute("LookupValueNameDisp").toString();
                ADFContext.getCurrent().getPageFlowScope().put("Dscrption", lookupValueDisp );
                ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "DV" );
                ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "Developer Charges" );
            }    
                return "receipt";
    }
    //auto creation of RC transaction
    public void onClickForRC() {
        // Add event code here...
        ViewObject vo=ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row r=vo.getCurrentRow();
        String bookingNo=r.getAttribute("BookingNumber1")==null?"null":r.getAttribute("BookingNumber1").toString();
        System.out.println("Inside onClickForRC method :"+bookingNo);
          OperationBinding op=ADFUtils.findOperation("autoRecomRC");
          op.getParamsMap().put("bookingNo",bookingNo);
          op.getParamsMap().put("userId","null");
          String flag=op.execute().toString();
          JSFUtils.addFacesInformationMessage(flag);
        
    }
    //for AckFlag from addEditBooking screen itself
    public void onCheckCashierFlag(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject vo=ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row r=vo.getCurrentRow();
        if (valueChangeEvent.getNewValue() != null) {
            String cshrFlg = valueChangeEvent.getNewValue().toString();
            if (cshrFlg.equalsIgnoreCase("true")){
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
                       System.out.println("timeStamp "+timeStamp);
//                        Date date = new Date(timeStamp);
//             this.getId7().setValue(timeStamp);
    try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(timeStamp);
            java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
            oracle.jbo.domain.Date domadate = new oracle.jbo.domain.Date(sqlDate);
            r.setAttribute("AckDate", domadate);
         } catch (ParseException e) {
        System.out.println(e);
         }
//                       r.setAttribute("AckDate",timeStamp);
             String uName = ADFContext.getCurrent().getSessionScope().get("userName").toString();
             System.out.println("uName : " + uName);
             this.getIt12().setValue(uName);
             
            }else{
//                this.getId7().setValue(null); 
                r.setAttribute("AckDate", null);
                this.getIt12().setValue(null);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.sbc1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.it12);
    }

    public void setId7(RichInputDate id7) {
        this.id7 = id7;
    }

    public RichInputDate getId7() {
        return id7;
    }

    public void setIt12(RichInputText it12) {
        this.it12 = it12;
    }

    public RichInputText getIt12() {
        return it12;
    }

    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }

    public void doCalBkAmtAndBkDueDate() {
        // Add event code here...
        String Totalrent = "";
        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer dcb =
            (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding iter =
            dcb.findIteratorBinding("Receipt_VO1Iterator");
        iter.executeQuery();
        //RequestContext.getCurrentInstance().addPartialTarget(returnEvent.getComponent().getParent().getParent());


        ViewObject OfferDtlVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        if (OfferDtlVo.getEstimatedRowCount() > 0) {
            RowSetIterator rs = OfferDtlVo.createRowSet("");
            //BigDecimal totalRecAmnt=new BigDecimal(0);
            Double totalRecAmnt = new Double(0);

            while (rs.hasNext()) {

                Row detailRow = rs.next();
                String rctTyp = detailRow.getAttribute("RctType")== null ? "" :detailRow.getAttribute("RctType").toString();
                String amnt = "0";
                if (rctTyp.equalsIgnoreCase("BK")){
                System.err.println("==========AMOUNT" +
                                   detailRow.getAttribute("RecommendedAmount"));

                amnt =
                    detailRow.getAttribute("RecommendedAmount") == null ? "0" :
                    detailRow.getAttribute("RecommendedAmount").toString();               
                Double RecAmnt = new Double(amnt);
                totalRecAmnt = totalRecAmnt + RecAmnt;

                }
                else{
                    Double RecAmnt = new Double(amnt);
                    totalRecAmnt = totalRecAmnt + RecAmnt;
                }
            }

            BigDecimal TotalRecAmn = BigDecimal.valueOf(totalRecAmnt);

            ViewObject BookHdr =
                ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
            if (BookHdr.first() != null) {
                Totalrent =
                        BookHdr.first().getAttribute("BaseRate") == null ? "0" :
                        BookHdr.first().getAttribute("BaseRate").toString();
            } else {
                Totalrent = "0";
            }
            //            String BookAmnt = "0";
            // valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
            Double Totalre = new Double(Totalrent);
            //            Double BookAm = new Double(BookAmnt);
            Double ValueforYear = Totalre / 365;
            Double NofDuDays = totalRecAmnt / ValueforYear;


            ViewObject BkHdrVo =
                ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
            Row re = BkHdrVo.getCurrentRow();
            String DateFr =
                re.getAttribute("BookingDate") == null ? "" : re.getAttribute("BookingDate").toString();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = new Date();
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar c = Calendar.getInstance();
            c.setTime(date1);
            c.add(Calendar.DATE, (int)Math.round(NofDuDays));
            DateFormat format12 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = format12.format(c.getTime());

            Date date2 = new Date();
            try {
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(formatted);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
            oracle.jbo.domain.Date domadate =
                new oracle.jbo.domain.Date(sqlDate);
            re.setAttribute("BookingDueDate", domadate);
            re.setAttribute("BookingAmount", TotalRecAmn);

            this.bookingAmt.setValue(TotalRecAmn);
            this.bookingDuedate.setValue(re.getAttribute("BookingDueDate"));
    }
    }

    public String onClickCreateReceipt_SecDepoOC() {
        // Add event code here...
        ViewObject bookCustVO =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        Row cusRow = bookCustVO.getCurrentRow();
        ViewObject vo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        //only difference between two method is iterator of vo
        ViewObject BMtlvo =
                    ADFUtils.findIterator("BookingMilestonesOtherChargesVO2Iterator").getViewObject();
                Row BMrows = BMtlvo.getCurrentRow();
        
        ADFContext.getCurrent().getPageFlowScope().put("funcId",
                                                       row.getAttribute("FuncId") ==
                                                       null ? "" :
                                                       row.getAttribute("FuncId"));
        ADFContext.getCurrent().getPageFlowScope().put("scfnId",
                                                       row.getAttribute("BookingId1") ==
                                                       null ? "" :
                                                       row.getAttribute("BookingId1"));

        ADFContext.getCurrent().getPageFlowScope().put("OrgId",
                                                       row.getAttribute("OrgId") ==
                                                       null ? "" :
                                                       row.getAttribute("OrgId"));
        ADFContext.getCurrent().getPageFlowScope().put("CustName",
                                                       cusRow.getAttribute("CustName") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustName"));
        //Temporary receipt
        String leadName = row.getAttribute("Customer_Name_Trans")==null?"":row.getAttribute("Customer_Name_Trans").toString();
        String custAr = cusRow.getAttribute("Trans_CustIdAr")==null?"":cusRow.getAttribute("Trans_CustIdAr").toString();
        String orgID = row.getAttribute("OrgId")==null?"":row.getAttribute("OrgId").toString();
            if (custAr.equalsIgnoreCase("") && !orgID.equals("300000007801262")){
            ADFContext.getCurrent().getPageFlowScope().put("CustName",leadName);
            ADFContext.getCurrent().getPageFlowScope().put("TempReceipt","TEMP_RECEIPT");
            }
        ADFContext.getCurrent().getPageFlowScope().put("CustBankName",
                                                       cusRow.getAttribute("CustBankName") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustBankName"));
        ADFContext.getCurrent().getPageFlowScope().put("CustBankAccNumber",
                                                       cusRow.getAttribute("CustBankAccNumber") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustBankAccNumber"));
        ADFContext.getCurrent().getPageFlowScope().put("CustBranchName",
                                                       cusRow.getAttribute("CustBranchName") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustBranchName"));
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId1") ==
                                                       null ? "" :
                                                       row.getAttribute("BookingId1"));
        //08-sep-2020 for all receipts to capture BookingMsDtlId in receipt Attribute3 mainly for OC report
        String bkMsdtlId = BMrows.getAttribute("BookingMsDtlId") == null ? "" : BMrows.getAttribute("BookingMsDtlId").toString();
        System.out.println("bkMsdtlId ::"+bkMsdtlId);
        ADFContext.getCurrent().getPageFlowScope().put("remark", bkMsdtlId);
        //17-sep-2020 for security deposit SD payment mode
        ADFContext.getCurrent().getPageFlowScope().put("SDPayMode","SD");
        //
        ADFContext.getCurrent().getPageFlowScope().put("modeType","SD");
        ADFContext.getCurrent().getPageFlowScope().put("receiptType", "BK");
        ADFContext.getCurrent().getPageFlowScope().put("DueDate", "");
        ADFContext.getCurrent().getPageFlowScope().put("description", "" );
        String a = ADFContext.getCurrent().getPageFlowScope().get("A").toString();
          if(a.equalsIgnoreCase("A")){
          ADFContext.getCurrent().getPageFlowScope().put("Amount", "" );
          ADFContext.getCurrent().getPageFlowScope().put("Dscrption", "" );
          ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "" );
          ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "" );
          }else{
          ADFContext.getCurrent().getPageFlowScope().put("Amount",
                                                             BMrows.getAttribute("InstallmentAmount") ==
                                                             null ? "" :
                                                             BMrows.getAttribute("InstallmentAmount"));
            //description
                            ViewObject lookUpVo =
                                    ADFUtils.findIterator("Lookup_View_ROVO1Iterator").getViewObject();
                        ViewCriteria vC = lookUpVo.createViewCriteria();
                        ViewCriteriaRow vCRow = vC.createViewCriteriaRow();
                        vCRow.setAttribute("LookupValueName", BMrows.getAttribute("InstallmentType"));
                        vC.addRow(vCRow);
                        lookUpVo.applyViewCriteria(vC);
                        lookUpVo.executeQuery();
                        if (lookUpVo.getEstimatedRowCount() > 0) { 
                            Row lookUpVoRow = lookUpVo.first();
                            String lookupValueDisp = lookUpVoRow.getAttribute("LookupValueNameDisp").toString();
                            ADFContext.getCurrent().getPageFlowScope().put("Dscrption", lookupValueDisp ); 
//                            ADFContext.getCurrent().getPageFlowScope().put("OrgId", "300000001937178" );
                            ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "DV" );
                            ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "Developer Charges" );
                        }    
        }


        return "receipt";
    }

    public void doSaveHandleGlobalSite(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Commit1").execute();
//        JSFUtils.addFacesInformationMessage("Booking Saved.....!");
    }

    public void onClickRefreshToPullOffer(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject vo=ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row r=vo.getCurrentRow();
        String bookingId=r.getAttribute("BookingId1")==null?"null":r.getAttribute("BookingId1").toString();
        String offerId=r.getAttribute("OfferHdrId")==null?"null":r.getAttribute("OfferHdrId").toString();
        System.out.println("Inside onClickRefreshToPullOffer method : bookingId :"+bookingId+" :offer ID :"+offerId);
          OperationBinding op=ADFUtils.findOperation("refresh_update_bk");
          op.getParamsMap().put("bookingId",bookingId);
          op.getParamsMap().put("offerId",offerId);
          op.getParamsMap().put("userId","null");
          String flag=op.execute().toString();
          JSFUtils.addFacesInformationMessage(flag);
        
    }
    
        public void doChangeStatusToDraft(ActionEvent actionEvent) {
            // Add event code here...
            ViewObject vo=ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
            Row row=vo.getCurrentRow();
            ViewObject funApvHistRoVo = ADFUtils.findIterator("getApprovalHistoryROVo1Iterator").getViewObject();
            System.err.println("Booking ID="+row.getAttribute("BookingId1"));
            String status = row.getAttribute("Status1") == null ? "" : row.getAttribute("Status1").toString();
            String bkId = row.getAttribute("BookingId1") == null ? "" : row.getAttribute("BookingId1").toString();
            String userId =
                ADFContext.getCurrent().getSessionScope().get("userId") == null ?
                null :
                ADFContext.getCurrent().getSessionScope().get("userId").toString();
            String funcId = row.getAttribute("FuncId") == null ? "0" : row.getAttribute("FuncId").toString();
            String reason = "Request Change to Draft";
            System.out.println("Status1 :"+status);
            ViewObject OfferHdrVo = ADFUtils.findIterator("OfferHrd_VO3Iterator").getViewObject();
            ViewCriteria ovc = OfferHdrVo.createViewCriteria();
            ViewCriteriaRow ovcRow = ovc.createViewCriteriaRow();
            ovcRow.setAttribute("OfferHdrId",row.getAttribute("OfferHdrId"));
            ovc.addRow(ovcRow);
            OfferHdrVo.applyViewCriteria(ovc);
            OfferHdrVo.executeQuery();
//        if (OfferHdrVo.getEstimatedRowCount() != 1) {
//        } else {
//           String ofStatus = OfferHdrVo.first().getAttribute("Status")==null ? "" : OfferHdrVo.first().getAttribute("Status").toString();
//            if (ofStatus.equalsIgnoreCase("BO")){
//            OfferHdrVo.first().setAttribute("Status", "APR");
//            }
//            }
            //calling pkg
            onDirectToDraft(bkId,userId,funcId,reason);
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Changes done Successfully");
        }

    public void onSelectPaymentType(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }
    //caliing package for change to draft
    public void onDirectToDraft(String rcId,String userId,String funcId,String reason){
        
              OperationBinding op=ADFUtils.findOperation("directToDraft");
              op.getParamsMap().put("rcId",rcId);
              op.getParamsMap().put("userId",userId);
              op.getParamsMap().put("funcId",funcId);
              op.getParamsMap().put("reason",reason);
              String flag=op.execute().toString();
              JSFUtils.addFacesInformationMessage(flag);
        }

    public void responseCashRcptId(ActionEvent actionEvent) {
        try {
                            ViewObject rcptVo =
                                ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
                            String rcptNo =
                                ADFContext.getCurrent().getPageFlowScope().get("rcptNos") == null ?
                                "0" :
                                ADFContext.getCurrent().getPageFlowScope().get("rcptNos").toString();

                            invokeReceiptResponseBIWS(rcptNo);
                            rcptVo.executeQuery();
        //                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTable1());

                        } catch (Exception e) {
                            //JSFUtils.addFacesInformationMessage("Error" + e);
                            //System.out.println("Exception : " + e.getMessage());

                            BindingContext bctx = BindingContext.getCurrent();
                            ((DCBindingContainer)bctx.getCurrentBindingsEntry()).reportException(new CommonJBOException("TEST", propertyBundle));
                        }        
    }
    
    public void invokeReceiptResponseBIWS(String p_receiptNo) {
            try {
                String Payload =
                    "<soapenv:Envelope xmlns:pub=\"http://xmlns.oracle.com/oxp/service/PublicReportService\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "       <pub:runReport>\n" +
                    "        <pub:reportRequest>\n" +
                    "           <pub:attributeCalendar/>\n" +
                    "           <pub:attributeFormat>xml</pub:attributeFormat>\n" +
                    "           <pub:attributeLocale>en-US</pub:attributeLocale>\n" +
                    "           <pub:attributeTemplate>Simple</pub:attributeTemplate>\n" +
                    "           <pub:attributeTimezone/>\n" +
                    "           <pub:attributeUILocale/>\n" +
                    "           <pub:byPassCache>true</pub:byPassCache>\n" +
                    "           <pub:dynamicDataSource/>\n" +
                    "           <pub:flattenXML>true</pub:flattenXML>\n" +
                    "           <pub:parameterNameValues>\n" +
                    "              <pub:item>\n" +
                    "                 <pub:name>p_receiptNo</pub:name>\n" +
                    "                 <pub:values>\n" +
                    "                    <pub:item>" + p_receiptNo +
                    "</pub:item>\n" +
                    "                 </pub:values>\n" +
                    "              </pub:item>\n" +
                    "           </pub:parameterNameValues>\n" +
                    "           <pub:reportAbsolutePath>Custom/Property Lease/Reports/Receipt Response.xdo</pub:reportAbsolutePath>\n" +
                    "           <pub:reportData/>\n" +
                    "           <pub:reportOutputPath/>\n" +
                    "           <pub:reportRawData/>\n" +
                    "           <pub:sizeOfDataChunkDownload>-1</pub:sizeOfDataChunkDownload>\n" +
                    "        </pub:reportRequest>\n" +
                    "        <pub:userID>ERP_user</pub:userID>\n" +
                    "        <pub:password>welcome@4i</pub:password>\n" +
                    "     </pub:runReport>\n" +
                    "  </soapenv:Body>\n" +
                    "</soapenv:Envelope>\n";


                Payload = Payload.replaceAll("&", "&");
                System.err.println("Bi Payload--" + Payload);
                JSFUtils.addFacesInformationMessage("" + Payload);
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("text/xml");
                RequestBody body = RequestBody.create(mediaType, Payload);
                Request request =
                    new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com/xmlpserver/services/PublicReportService?wsdl").post(body).addHeader("SOAPAction",
                                                                                                                                                       "").build();
                //            Request request =
                //                new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com/xmlpserver/services/PublicReportService?wsdl").post(body).addHeader("SOAPAction",
                //                                                                                                                                                   "").build();
                String strResp = null;
                Response response = client.newCall(request).execute();
                InputStream isr = response.body().byteStream();
                BufferedReader reader =
                    new BufferedReader(new InputStreamReader(isr));
                StringBuilder out = new StringBuilder();
                String resultsXml;
                while ((resultsXml = reader.readLine()) != null) {
                    out.append(resultsXml);
                }

                System.err.println("Response String--" + out);
                int responseCode = response.code();
                System.err.println("RESPONSE CODE--" + responseCode);
                getRcptRspnseBIWSRespValue(responseCode, out.toString());


            } catch (Exception e) {
                JSFUtils.addFacesInformationMessage("ERROR IN CATCH BLOCK--" + e);
            }

        }
    
    public String getRcptRspnseBIWSRespValue(int respCode, String out) {
            String resp = "";
            JSFUtils.addFacesInformationMessage("Output Stream--" + out);
            try {
                DocumentBuilder builder =
                    DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource src = new InputSource();
                src.setCharacterStream(new StringReader(out));
                Document doc = builder.parse(src);
                if (respCode > 200) {
                    resp =
    doc.getElementsByTagName("faultstring").item(0).getTextContent();
                    System.err.println("ERROR--" +
                                       doc.getElementsByTagName("faultstring").item(0).getTextContent());
                    JSFUtils.addFacesInformationMessage("ERROR--" +
                                                        doc.getElementsByTagName("faultstring").item(0).getTextContent().toString());
                    src = new InputSource();
                    src.setCharacterStream(new StringReader("<faultstring>" +
                                                            resp +
                                                            "</faultstring>"));
                    doc = builder.parse(src);
                    resp =
    doc.getElementsByTagName("TEXT").item(0).getTextContent();
                } else {
                    resp =
    doc.getElementsByTagName("reportBytes").item(0).getTextContent();
                    System.err.println("Wlcome--" +
                                       doc.getElementsByTagName("reportBytes").item(0).getTextContent());
                    byte b[] =
                        Base64.decode(doc.getElementsByTagName("reportBytes").item(0).getTextContent());
                    String tempPass = new String(b);
                    System.err.println("HELLO" + tempPass);
                    DocumentBuilder builder1 =
                        DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    InputSource src1 = new InputSource();
                    src1.setCharacterStream(new StringReader(tempPass));
                    Document reportOutput = builder1.parse(src1);

                    if (notNull(reportOutput.getElementsByTagName("RECEIPT_NUMBER").item(0)) 
                        && notNull(reportOutput.getElementsByTagName("CASH_RECEIPT_ID").item(0))
                    ) {

                        BindingContainer bindings =
                            BindingContext.getCurrent().getCurrentBindingsEntry();
                        OperationBinding method =
                            bindings.getOperationBinding("getCashRcptIdRspnse");
                        Map args = method.getParamsMap();
                        args.put("pReceiptNo",
                                 reportOutput.getElementsByTagName("RECEIPT_NUMBER").item(0).getTextContent().toString());
                        args.put("pCshRcptId",
                                 reportOutput.getElementsByTagName("CASH_RECEIPT_ID").item(0).getTextContent().toString());
                        Object a = method.execute();
                        JSFUtils.addFacesInformationMessage("RESPONSE--" + a);
                        JSFUtils.addFacesInformationMessage("OUT PUT RECEIPT_NUMBER" +
                                                            reportOutput.getElementsByTagName("RECEIPT_NUMBER").item(0).getTextContent());
                        JSFUtils.addFacesInformationMessage("OUT PUT CASH_RECEIPT_ID" +
                                                            reportOutput.getElementsByTagName("CASH_RECEIPT_ID").item(0).getTextContent());

                        System.err.println("P_RECEIPT_NO" +
                                           reportOutput.getElementsByTagName("P_RECEIPT_NO").item(0).getTextContent());
                        
                    }
                    JSFUtils.addFacesInformationMessage("No Cash Receipt Id  !!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resp;
        }
    
    public boolean notNull(Object ob) {
        if (ob != null && !"".equals(ob)) {
            return true;
        } else {
            return false;
        }
    }

    public void onInvokeBypassAppr(ActionEvent actionEvent) {
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup27().show(popup34);
    }

    public void setPopup27(RichPopup popup27) {
        this.popup27 = popup27;
    }

    public RichPopup getPopup27() {
        return popup27;
    }
}

