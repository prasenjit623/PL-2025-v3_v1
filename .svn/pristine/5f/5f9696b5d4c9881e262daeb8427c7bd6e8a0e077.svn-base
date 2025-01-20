
import com.model.util.CommonJBOException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.ServletContext;

import javax.sql.DataSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.apps.xdo.template.FOProcessor;
import oracle.apps.xdo.template.RTFProcessor;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.TimeZone;

import javax.faces.event.ActionEvent;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.RequestBody;

import okhttp3.Response;


import java.util.HashMap;
import java.util.Map;

import java.util.concurrent.TimeUnit;


import javax.xml.bind.DatatypeConverter;


import javax.xml.parsers.ParserConfigurationException;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;


import oracle.adf.view.rich.component.rich.data.RichTable;


import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;


import org.apache.poi.hssf.usermodel.HSSFRow;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;


import org.xml.sax.SAXException;

import view.WsPayloadForCreateAccounts;

import view.backing.MailServices;
import view.backing.MailTemplates;

//import view.backing.InvoiceSync;

public class LeaseAgreement {
    private RichInputText reason;
    private RichInputText customerTrxnIdTxt;
    private RichInputText attributResponse;
    private RichTable table1;
    private static String propertyBundle =
        "view.PropertyLease_ViewControllerBundle";
    private RichCommandButton generate_invoice_cb15;

    public LeaseAgreement() {
    }
    private RichPopup popup3;
    ViewObject BookingDtlVo =
        ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
    ViewObject PropertyMaster_VO1Iterator =
        ADFUtils.findIterator("PropertyMaster_VO1Iterator").getViewObject();
    ViewObject OfferDetailVo1 =
        ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
    ViewObject contractVo =
        ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();

    public void onBookingUnitsStatus() {
        ViewObject BookingLineVo =
            ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
        RowSetIterator BookingLineVoRS =
            BookingLineVo.createRowSetIterator(null);

        if (BookingLineVo.getEstimatedRowCount() > 0) {
            System.out.println("*********onBookingUnitsStatus on adEdtLease* count* " +
                               BookingLineVo.getEstimatedRowCount());
            while (BookingLineVoRS.hasNext()) {
                Row BookingLineVoRSRow = BookingLineVoRS.next();
                BookingLineVoRSRow.setAttribute("UnitAvlStatus", "BOOK");


            }


        }

    }


    public String getDiscount(Object offerid, Object unitid, Object baseRate) {
        BigDecimal ResultVal = new BigDecimal(0);
        String res = "0";
        ViewCriteria vc = OfferDetailVo1.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("OfferHdrId", offerid);
        vcRow.setAttribute("UnitId", unitid);
        vc.addRow(vcRow);
        OfferDetailVo1.applyViewCriteria(vc);
        OfferDetailVo1.executeQuery();
        if (OfferDetailVo1.first() != null) {

            System.err.println("OfferDetailVo1.first()" +
                               OfferDetailVo1.first().getAttribute("DiscountAmount"));
            ViewObject vo =
                ADFUtils.findIterator("DiscountsROVO1Iterator").getViewObject();

            vo.setNamedWhereClauseParam("D_ID",
                                        OfferDetailVo1.first().getAttribute("DiscountAmount"));
            //mileDtlRow.getAttribute("DiscountAmount"));
            vo.executeQuery();

            Row re = vo.first();
            if (vo.getEstimatedRowCount() > 0) {
                String OfferAmnt =
                    baseRate == null ? "0" : baseRate.toString();
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
                            (DisValue.multiply(OfrAmnt)).divide(TotalPercentage);
                    res = ResultVal.toString();


                }
                if (DiscountType.equals("CASH")) {

                    ResultVal = DisValue;
                    res = ResultVal.toString();
                }
            }

        }
        System.err.println("DISCOUNT AMT--" + res);
        return res;

    }


    public void setUnitStatus() {
        ViewObject BookingDtlVO1 =
            ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
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
            re.setAttribute("Status", "ALOT");


        }
        PropertyUnits_VO1.executeQuery();
        ADFUtils.findOperation("Commit").execute();
    }

    public Object getBuisnessUnit(Object PropertyId) {
        Object result = null;
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
        ViewObject Leasevo =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        Leasevo.getCurrentRow().setAttribute("PropertyId",
                                             BookingDtlVo.first().getAttribute("PropertyId"));
        Leasevo.getCurrentRow().setAttribute("BuildingId",
                                             BookingDtlVo.first().getAttribute("BuildingId"));
        Leasevo.getCurrentRow().setAttribute("OrgId",
                                             getBuisnessUnit(BookingDtlVo.first().getAttribute("PropertyId")));


    }

    public void onClickAttachments(ActionEvent actionEvent) {
        ViewObject vo =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        JSFUtils.setExpressionValue("#{pageFlowScope.lefuncId}", 1);
        JSFUtils.setExpressionValue("#{pageFlowScope.leId}",
                                    row.getAttribute("BookingId"));
    }

    public void onClickChecklist(ActionEvent actionEvent) {
        ViewObject vo =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        JSFUtils.setExpressionValue("#{pageFlowScope.leasefuncid}", 1);
        JSFUtils.setExpressionValue("#{pageFlowScope.leasefuncrefid}",
                                    row.getAttribute("LeaseAgreementId"));
        JSFUtils.setExpressionValue("#{pageFlowScope.leaselookup}", "");
    }


    public void onClickSubmit(ActionEvent actionEvent) {
        onClickSave(actionEvent);
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        //17-dec-20 to proceed based on booking status
        String rcStatus = valdtRcStatusOnSubmit();
        if(rcStatus.equalsIgnoreCase("Y")){
        //
        Object org = vo.getCurrentRow().getAttribute("OrgId");
        Object prop = vo.getCurrentRow().getAttribute("PropertyId");
        Object unit = vo.getCurrentRow().getAttribute("BuildingId");
        Object recomId = vo.getCurrentRow().getAttribute("RecommendId");
        //
        Long count=submitLeaseValidation(recomId);
        if(count==0)
        {

        try {
            if (vo.getCurrentRow().getAttribute("TenancyConDocNo") != null) {
//                ResultVal =
//                        xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
//                                              row.getAttribute("FuncId"),
//                                              row.getAttribute("LeaseAgreementId"),
//                                              0, "XXPM_LEASE_AGREEMENT",
//                                              "STATUS", "LEASE_AGREEMENT_ID",
//                                              org, prop, unit, null, null);
          OperationBinding op=ADFUtils.findOperation("submitLaForAppr");
          op.getParamsMap().put("laId",row.getAttribute("LeaseAgreementId").toString());
          ResultVal=op.execute().toString();
//          JSFUtils.addFacesInformationMessage(flag);
            } else {
                JSFUtils.addFacesErrorMessage("You must enter the Tenancy Document No");
                ResultVal = "Wrong";
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ResultVal.equalsIgnoreCase("Success")) {
//            ADFUtils.findOperation("Commit").execute();
            //mail service
//            vo.executeQuery();
//            doSendMailOnSubmit();
            JSFUtils.addFacesInformationMessage("Submitted For Approval");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
        }
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(table_resId1);
        }
        else{
            JSFUtils.addFacesErrorMessage("Already submitted for same RC number");
        }
        }else{
         JSFUtils.addFacesErrorMessage("Associated Payments & Documents should be approved !!!");
            }
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
    String netRent= null;
    String pdfReport=null;
    String startDate = null;
    String endDate = null;
    
    ViewObject laHdrVo = ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
    String laId = laHdrVo.getCurrentRow().getAttribute("LeaseAgreementId") == null ? "0" : laHdrVo.getCurrentRow().getAttribute("LeaseAgreementId").toString();
    String bkId = laHdrVo.getCurrentRow().getAttribute("BookingId") == null ? "0" : laHdrVo.getCurrentRow().getAttribute("BookingId").toString();
    String laNo = laHdrVo.getCurrentRow().getAttribute("LeaseNumber") == null ? "0" : laHdrVo.getCurrentRow().getAttribute("LeaseNumber").toString();
    String flowWithId = laHdrVo.getCurrentRow().getAttribute("FlowWith") == null ? "0" : laHdrVo.getCurrentRow().getAttribute("FlowWith").toString();
    String orgId = laHdrVo.getCurrentRow().getAttribute("OrgId") == null ? "0" : laHdrVo.getCurrentRow().getAttribute("OrgId").toString();
    //roport download url
    if(orgId.equals("300000001937102")){
    pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/lease/dubai/"+laNo;
    //    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/lease/dubai/"+laNo;   
    }else{
        pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/lease/sharjah/"+laNo;
    //    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/lease/sharjah/"+laNo;
    }
    //user
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
                    startDate= row.getAttribute("OfferFromDate")==null ? "" : row.getAttribute("OfferFromDate").toString();
                    endDate= row.getAttribute("OfferToDate")==null ? "" : row.getAttribute("OfferToDate").toString();
                }
        }
    //     ar.add("prasenjit.d@4iapps.com");
         ar.add(emailId);
     String htmlBody =MailTemplates.onSubmitForAprTmplt(propName,buildName,unitNameAL,userNameDisp,laNo,"Contracts",custName,startDate,endDate,netRent,pdfReport);
     String subject = "Approval Notification";
     MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
     JSFUtils.addFacesInformationMessage("Mail has been sent successfully");        
        }
    
    //doSendMailOnSubmit
    public void doSendMailOnSubmitApr(String laId,String bkId,String laNo,String flowWithId,String userName,String orgId){
        
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
    String startDate = null;
    String endDate = null;
    
    //roport download url
    if(orgId.equals("300000001937102")){
    pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/lease/dubai/"+laNo;
    //    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/lease/dubai/"+laNo;   
    }else{
        pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/lease/sharjah/"+laNo;
    //    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/lease/sharjah/"+laNo;
    }
    //user
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
                    startDate= row.getAttribute("OfferFromDate")==null ? "" : row.getAttribute("OfferFromDate").toString();
                    endDate= row.getAttribute("OfferToDate")==null ? "" : row.getAttribute("OfferToDate").toString();
                }
        }
    //     ar.add("prasenjit.d@4iapps.com");
         ar.add(emailId);
     String htmlBody =MailTemplates.onSubmitForAprTmplt(propName,buildName,unitNameAL,userNameDisp,laNo,"Contracts",custName,startDate,endDate,netRent,pdfReport);
     String subject = "Approval Notification";
     MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
     JSFUtils.addFacesInformationMessage("Mail has been sent successfully");        
        }
        
    //doSendMailOnApproved
    public void doSendMailOnApproved(String laId,String bkId,String laNo,String flowWithId,String userName,String orgId){

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
    String startDate = null;
    String endDate = null;
            
    //roport download url
    if(orgId.equals("300000001937102")){
        pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/lease/dubai/"+laNo;
        //    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/lease/dubai/"+laNo;   
    }else{
        pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/lease/sharjah/"+laNo;
        //    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/lease/sharjah/"+laNo;
        }
    
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
                    startDate= row.getAttribute("OfferFromDate")==null ? "" : row.getAttribute("OfferFromDate").toString();
                    endDate= row.getAttribute("OfferToDate")==null ? "" : row.getAttribute("OfferToDate").toString();
                }
        }
    //     ar.add("prasenjit.d@4iapps.com");
         ar.add(emailId);
//         ar.add(custEmailId);
     String htmlBody =MailTemplates.onApprovedTmplt(propName,buildName,unitNameAL,userNameDisp,laNo,"Contracts",custName,startDate,endDate,netRent,pdfReport);
     String subject = "Approval Notification";
     MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
     JSFUtils.addFacesInformationMessage("Mail has been sent successfully");        
        }
    
    public long submitLeaseValidation(Object recomId)
      {
          ViewObject vo=ADFUtils.findIterator("LeaseDuplicateROVO1Iterator").getViewObject();   
                 ViewCriteria vc=vo.createViewCriteria();
                 vc.reset();
                 ViewCriteriaRow vcr=vc.createViewCriteriaRow();
                 vcr.setAttribute("RecommendId",recomId);
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
    //                               if(!r.getAttribute("Status").toString().equalsIgnoreCase("CANC"))
    //                               {
                                   if(!r.getAttribute("Status").toString().equalsIgnoreCase("DRA"))
                                   {
                               Flag="D";
                               System.err.println("Flag="+Flag);
                                   }
                                   }
                               
    //                           }
                          
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
    
    public String valdtRcStatusOnSubmit() {
        String sts = "N";
        ViewObject vo =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ViewObject rcHdrVo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        ViewCriteria ovc = rcHdrVo.createViewCriteria();
        ViewCriteriaRow ovcRow = ovc.createViewCriteriaRow();
        ovcRow.setAttribute("RecommendId",row.getAttribute("RecommendId"));
        ovc.addRow(ovcRow);
        rcHdrVo.applyViewCriteria(ovc);
        rcHdrVo.executeQuery();
        if (rcHdrVo.getEstimatedRowCount() > 0) {
        String ofStatus = rcHdrVo.first().getAttribute("Status")==null ? "" : rcHdrVo.first().getAttribute("Status").toString();
        if (ofStatus.equalsIgnoreCase("APR") || ofStatus.equalsIgnoreCase("BO")){
            sts = "Y";
        }
      }
        return sts;
    }

//    public void onClickApprove(ActionEvent actionEvent) {
//        Map<String, BigDecimal> ResultVal = new HashMap<String, BigDecimal>();
//        ViewObject vo =
//            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
//        Row row = vo.getCurrentRow();
//        String Reason =
//            this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
//
//
//        try {
//            ResultVal =
//                    xxfnd.invokeResponsePkgs("xxfnd_util_pkg.update_response",
//                                             row.getAttribute("FuncId"),
//                                             row.getAttribute("LeaseAgreementId"),
//                                             row.getAttribute("UserGrpId"),
//                                             row.getAttribute("FlowLevel"),
//                                             row.getAttribute("FlowWith"),
//                                             Reason, "A", 0,
//                                             "XXPM_LEASE_AGREEMENT", "STATUS",
//                                             "LEASE_AGREEMENT_ID");
//
//
//        } catch (SQLException e) {
//        }
//
//        for (Map.Entry m : ResultVal.entrySet()) {
//            System.out.println("KEY" + m.getKey() + "VALUE " + m.getValue());
//
//            if (m.getKey().equals("Success")) {
//                // vo.executeQuery();
//                String ress =
//                    m.getValue() == null ? "null" : m.getValue().toString();
//                if (ress.equals("null")) {
//                    setUnitStatus();
//                    onBookingUnitsStatus();
//                    forBookingStatusChange();
//                    //for attestation flag as attribute4 for rightnow
//                    String unitTypeValid = doValidUnitType();
//                        if (unitTypeValid.equalsIgnoreCase("Y")){
//                            doUpdateAttestationFlag();
//                        }
//                }
//                ADFUtils.findOperation("Commit").execute();
//                vo.executeQuery();
//                System.out.println("estm Count after execute query :::"+vo.getEstimatedRowCount());
//                String sts = row.getAttribute("Status")==null ? "" : row.getAttribute("Status").toString();
//                System.out.println("Status%%%"+sts);
//                String laId = row.getAttribute("LeaseAgreementId").toString();
//                String bkId = row.getAttribute("BookingId") == null ? "0" : row.getAttribute("BookingId").toString();
//                String laNo = row.getAttribute("LeaseNumber") == null ? "0" : row.getAttribute("LeaseNumber").toString();
//                String flowWithId = row.getAttribute("FlowWith") == null ? "0" : row.getAttribute("FlowWith").toString();
//                String userName = row.getAttribute("CreatedBy") == null ? "" : row.getAttribute("CreatedBy").toString();
//                String orgId = row.getAttribute("OrgId") == null ? "0" : row.getAttribute("OrgId").toString();
//                System.out.println("bkId ::"+bkId+" flowWithId :"+flowWithId+" userName :"+userName+" orgId :"+orgId);
//                if(sts.equalsIgnoreCase("PEN")){
//                    //mail service
//                    doSendMailOnSubmitApr(laId,bkId,laNo,flowWithId,userName,orgId);
//                }
//                if(sts.equalsIgnoreCase("APR")){
//                    //mail service
//                    doSendMailOnApproved(laId,bkId,laNo,flowWithId,userName,orgId);
//                }
//                JSFUtils.addFacesInformationMessage("Approved Successfully");
//            } else {
//                JSFUtils.addFacesErrorMessage("Error in Approve process!");
//            }
//        }
//    }
     public void onClickApprove(ActionEvent actionEvent) {
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();


        try {
            OperationBinding op=ADFUtils.findOperation("responseLaForAppr");
                      op.getParamsMap().put("laId",row.getAttribute("LeaseAgreementId").toString());
                      op.getParamsMap().put("reason",Reason);
                      op.getParamsMap().put("apr_rej","A");
                      ResultVal=op.execute().toString();
            //          JSFUtils.addFacesInformationMessage(flag);

        } catch (Exception e) {
            System.out.println(e);
        }
        String sts = "";
            if (ResultVal.equals("Success")) {
            
                ViewObject laRoVo = ADFUtils.findIterator("LeaseDuplicateROVO1Iterator").getViewObject();
                       ViewCriteria vwcc = laRoVo.createViewCriteria();
                       ViewCriteriaRow vwccr = vwcc.createViewCriteriaRow();
                       vwccr.setAttribute("LeaseAgreementId", row.getAttribute("LeaseAgreementId"));
                       vwcc.addRow(vwccr);
                       laRoVo.applyViewCriteria(vwcc);
                       laRoVo.executeQuery();
                   if (laRoVo.getEstimatedRowCount() > 0) {
                       Row laRow = laRoVo.first();
                       sts = laRow.getAttribute("Status")==null ? "" : laRow.getAttribute("Status").toString();
                   }
//                // vo.executeQuery();
//                 ADFUtils.findOperation("Commit").execute();
//                vo.executeQuery();
//                System.out.println("estm Count after execute query :::"+vo.getEstimatedRowCount());
//                String sts = row.getAttribute("Status")==null ? "" : row.getAttribute("Status").toString();
//                System.out.println("Status%%%"+sts);
//                String laId = row.getAttribute("LeaseAgreementId").toString();
//                String bkId = row.getAttribute("BookingId") == null ? "0" : row.getAttribute("BookingId").toString();
//                String laNo = row.getAttribute("LeaseNumber") == null ? "0" : row.getAttribute("LeaseNumber").toString();
//                String flowWithId = row.getAttribute("FlowWith") == null ? "0" : row.getAttribute("FlowWith").toString();
//                String userName = row.getAttribute("CreatedBy") == null ? "" : row.getAttribute("CreatedBy").toString();
//                String orgId = row.getAttribute("OrgId") == null ? "0" : row.getAttribute("OrgId").toString();
//                System.out.println("bkId ::"+bkId+" flowWithId :"+flowWithId+" userName :"+userName+" orgId :"+orgId);
                if(sts.equalsIgnoreCase("PEN")){
                    //mail service
//                    doSendMailOnSubmitApr(laId,bkId,laNo,flowWithId,userName,orgId);
                }
                if(sts.equalsIgnoreCase("APR")){
                    setUnitStatus();
                    onBookingUnitsStatus();
                    forBookingStatusChange();
                    //for attestation flag as attribute4 for rightnow
                    String unitTypeValid = doValidUnitType();
                        if (unitTypeValid.equalsIgnoreCase("Y")){
                            doUpdateAttestationFlag();
                        }
                    //mail service
//                    doSendMailOnApproved(laId,bkId,laNo,flowWithId,userName,orgId);
                }
                JSFUtils.addFacesInformationMessage("Approved Successfully");
            } else {
                JSFUtils.addFacesErrorMessage("Error in Approve process!");
            }
    }
            
    public String doValidUnitType() {
        
        ViewObject bookingDtlVO2 =
            ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
        ViewObject propertyUnits_VO1 =
            ADFUtils.findIterator("PropertyUnits_VO1Iterator").getViewObject();
        RowSetIterator quoteMileRS = bookingDtlVO2.createRowSetIterator(null);
        while (quoteMileRS.hasNext()) {
            Row r1 = quoteMileRS.next();
            System.out.println("Unit id : "+r1.getAttribute("UnitId"));
            ViewCriteria vc = propertyUnits_VO1.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("UnitId", r1.getAttribute("UnitId"));
            vc.addRow(vcRow);
            propertyUnits_VO1.applyViewCriteria(vc);
            propertyUnits_VO1.executeQuery();
            Row re = propertyUnits_VO1.first();
            String unitType = re.getAttribute("UnitType")==null ? "" : re.getAttribute("UnitType").toString();
            if (unitType.equalsIgnoreCase("CAR_PARKING")){
//                doUpdateAttestationFlag();
                return "N";
            }
        }
        quoteMileRS.closeRowSetIterator();
        return "Y";
    }
    public void forBookingStatusChange() {
        ViewObject leaseAgreementVo =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();

        ViewObject recommendHdrVo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();

        ViewCriteria vc = recommendHdrVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("RecommendId",
                           leaseAgreementVo.getCurrentRow().getAttribute("RecommendId"));
        System.out.println("Reco====" + vcRow.getAttribute("RecommendId"));
        System.out.println("PLease====" +
                           leaseAgreementVo.getCurrentRow().getAttribute("RecommendId"));
        vc.addRow(vcRow);
        recommendHdrVo.applyViewCriteria(vc);
        recommendHdrVo.executeQuery();
        recommendHdrVo.first().setAttribute("Status", "BO");
        //        System.out.println("count=="+recommendHdrVo.getEstimatedRowCount());
    }

    public void onClickReject(ActionEvent actionEvent) {
        // Add event code here...
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Rejected" : this.reason.getValue().toString();


        try {
//            ResultVal =
//                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
//                                            row.getAttribute("FuncId"),
//                                            row.getAttribute("LeaseAgreementId"),
//                                            row.getAttribute("UserGrpId"),
//                                            row.getAttribute("FlowLevel"),
//                                            row.getAttribute("FlowWith"),
//                                            Reason, "R", 0,
//                                            "XXPM_LEASE_AGREEMENT", "STATUS",
//                                            "LEASE_AGREEMENT_ID");
            OperationBinding op=ADFUtils.findOperation("responseLaForAppr");
                      op.getParamsMap().put("laId",row.getAttribute("LeaseAgreementId").toString());
                      op.getParamsMap().put("reason",Reason);
                      op.getParamsMap().put("apr_rej","R");
                      ResultVal=op.execute().toString();
            //          JSFUtils.addFacesInformationMessage(flag);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
//            vo.executeQuery();
            JSFUtils.addFacesInformationMessage("Rejected Successfully");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Approve process!");
        }
    }

    public void onClickSave(ActionEvent actionEvent) {

        ViewObject getFuncodeVo =
            ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
        getFuncodeVo.setNamedWhereClauseParam("F_ID", "LA");
        getFuncodeVo.executeQuery();
        Object Funcode = getFuncodeVo.first().getAttribute("FuncId");
        String Fcode = Funcode == null ? "" : Funcode.toString();
        ViewObject OfferHdrVo =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        Row re = OfferHdrVo.getCurrentRow();
        if (re.getAttribute("LeaseNumber") == null) {
            String name =
                xxfnd.generateDocNo("LA", "MoveInOut_AMDataControl").toString();
            Object valu = name;
            re.setAttribute("LeaseNumber", valu);
            re.setAttribute("FuncId",
                            getFuncodeVo.first().getAttribute("FuncId"));
        }
        onAttributesSave();
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully !!");
            
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

    public void onClickPDFReport(FacesContext facesContext,
                                 java.io.OutputStream outputStream) {

        try {
            Object result =
                runReport("//reports//Tendancy Contract Dubai.rtf");
            outputStream.write((byte[])result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getXMLData(String p_lease_number) throws Exception {
        String retStr = "";
        Context ctx;
        Connection con = null;
        ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("PL");
        con = ds.getConnection();
        String selectSQL =
            "SELECT XXPM_REPORT_PKG.Xxpm_tc_dubai_form('" + p_lease_number +
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
                ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
            Row re = quoteVO.getCurrentRow();
            String quoteNumber =
                re.getAttribute("LeaseNumber") == null ? "" : re.getAttribute("LeaseNumber").toString();
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

    public void onClikcInvoice(ActionEvent actionEvent) {
        ViewObject leaseVO =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        String booking_Id =
            leaseVO.getCurrentRow().getAttribute("BookingId") == null ? "0" :
            leaseVO.getCurrentRow().getAttribute("BookingId").toString();
        System.err.println("booking_Id==>" + booking_Id);
        ViewObject getNameVO =
            ADFUtils.findIterator("getID1Iterator").getViewObject();
        getNameVO.setNamedWhereClauseParam("BV_SELECT_COLUMN", "ORG_ID");
        getNameVO.setNamedWhereClauseParam("BV_TABLENAME",
                                           "XXPM_BOOKING_HEADER");
        getNameVO.setNamedWhereClauseParam("BV_WHERE_COLUMN", "BOOKING_ID");
        getNameVO.setNamedWhereClauseParam("BV_VALUE", booking_Id);
        getNameVO.executeQuery();
        String orgID =
            getNameVO.first().getAttribute("Id") == null ? "0" : getNameVO.first().getAttribute("Id").toString();
        System.err.println("orgID===>" + orgID);
        // amount and payemnt term
        ViewObject bookingMileStoneVO =
            ADFUtils.findIterator("BookingMileStoneROVO1Iterator").getViewObject();
        bookingMileStoneVO.setNamedWhereClauseParam("BV_BOOK_ID", booking_Id);
        bookingMileStoneVO.executeQuery();
        System.err.println("COUNT-->" +
                           bookingMileStoneVO.getEstimatedRowCount());
        RowSetIterator bookingMileStoneRS =
            bookingMileStoneVO.createRowSetIterator(null);
        while (bookingMileStoneRS.hasNext()) {
            Row bookingMileStoneRow = bookingMileStoneRS.next();
            System.err.println("InstallmentAmount==>" +
                               bookingMileStoneRow.getAttribute("InstallmentAmount") +
                               "InstallmentType==>" +
                               bookingMileStoneRow.getAttribute("InstallmentType"));
        }
        // Property Building Unit
        ViewObject bookingDetailVO =
            ADFUtils.findIterator("BookingDetailsROVO1Iterator").getViewObject();
        bookingDetailVO.setNamedWhereClauseParam("BV_BOOK_ID", booking_Id);
        bookingDetailVO.executeQuery();
        System.err.println("COUNT-->" +
                           bookingDetailVO.getEstimatedRowCount());
        RowSetIterator bookingDetailRS =
            bookingDetailVO.createRowSetIterator(null);
        while (bookingDetailRS.hasNext()) {
            Row bookingDetailRow = bookingDetailRS.next();
            // Property
            getNameVO.setNamedWhereClauseParam("BV_SELECT_COLUMN",
                                               "PROPERTY_NAME");
            getNameVO.setNamedWhereClauseParam("BV_TABLENAME",
                                               "XXPL_PROPERTY_MASTER");
            getNameVO.setNamedWhereClauseParam("BV_WHERE_COLUMN",
                                               "PROPERTY_ID");
            getNameVO.setNamedWhereClauseParam("BV_VALUE",
                                               bookingDetailRow.getAttribute("PropertyId"));
            getNameVO.executeQuery();
            String propertyName =
                getNameVO.first().getAttribute("Id") == null ? "0" :
                getNameVO.first().getAttribute("Id").toString();
            // Building
            getNameVO.setNamedWhereClauseParam("BV_SELECT_COLUMN",
                                               "BUILD_NAME");
            getNameVO.setNamedWhereClauseParam("BV_TABLENAME",
                                               "XXPL_PROPERTY_BUILDINGS");
            getNameVO.setNamedWhereClauseParam("BV_WHERE_COLUMN", "BUILD_ID");
            getNameVO.setNamedWhereClauseParam("BV_VALUE",
                                               bookingDetailRow.getAttribute("BuildingId"));
            getNameVO.executeQuery();
            String buildingName =
                getNameVO.first().getAttribute("Id") == null ? "0" :
                getNameVO.first().getAttribute("Id").toString();
            // Unit
            getNameVO.setNamedWhereClauseParam("BV_SELECT_COLUMN",
                                               "UNIT_NAME");
            getNameVO.setNamedWhereClauseParam("BV_TABLENAME",
                                               "XXPL_PROPERTY_UNITS");
            getNameVO.setNamedWhereClauseParam("BV_WHERE_COLUMN", "UNIT_ID");
            getNameVO.setNamedWhereClauseParam("BV_VALUE",
                                               bookingDetailRow.getAttribute("UnitId"));
            getNameVO.executeQuery();
            String unitName =
                getNameVO.first().getAttribute("Id") == null ? "0" :
                getNameVO.first().getAttribute("Id").toString();

            System.err.println("PropertyId==>" +
                               bookingDetailRow.getAttribute("PropertyId") +
                               "propertyName==>" + propertyName);
            System.err.println("BuildingId==>" +
                               bookingDetailRow.getAttribute("BuildingId") +
                               "buildingName==>" + buildingName);
            System.err.println("UnitId==>" +
                               bookingDetailRow.getAttribute("UnitId") +
                               "unitName===>" + unitName);

            System.err.println("TotalRate==>" +
                               bookingDetailRow.getAttribute("TotalRate"));

            System.err.println("TotalRate==>" +
                               bookingDetailRow.getAttribute("TotalRate"));

        }

        ViewObject customerVO =
            ADFUtils.findIterator("findCustomerROVO1Iterator").getViewObject();
        customerVO.setNamedWhereClauseParam("BV_BOOK_ID", booking_Id);
        customerVO.executeQuery();
        String custId =
            customerVO.first().getAttribute("CustId") == null ? "null" :
            customerVO.first().getAttribute("CustId").toString();
        String custName =
            customerVO.first().getAttribute("CustomerName") == null ? "null" :
            customerVO.first().getAttribute("CustomerName").toString();
        String custNumber =
            customerVO.first().getAttribute("CustomerNumber") == null ?
            "null" :
            customerVO.first().getAttribute("CustomerNumber").toString();

        System.err.println("CustomerNumber==>" +
                           customerVO.first().getAttribute("CustomerNumber"));

        System.err.println("CUSTID==>" + custId + "CUSTNAME==>" + custName +
                           custNumber);


        ViewObject customerSiteVO =
            ADFUtils.findIterator("custSiteROVO1Iterator").getViewObject();
        customerSiteVO.setNamedWhereClauseParam("BV_CUSID", custId);
        customerVO.executeQuery();
        String sitenumber =
            customerVO.first().getAttribute("CustId") == null ? "null" :
            customerVO.first().getAttribute("CustId").toString();
        System.err.println("sitenumber==>" +
                           customerVO.first().getAttribute("SiteNumber"));

        //BookingHdrRecomm_ROVO1Iterator
        ViewObject Offerdet =
            ADFUtils.findIterator("BookingHdrRecomm_ROVO1Iterator").getViewObject();
        ViewCriteria offerDtlVCs = leaseVO.createViewCriteria();
        ViewCriteriaRow offerDtlVCRs = offerDtlVCs.createViewCriteriaRow();
        //1
        offerDtlVCRs.setAttribute("BookingId",
                                  leaseVO.getCurrentRow().getAttribute("BookingId"));
        offerDtlVCs.addRow(offerDtlVCRs);
        Offerdet.applyViewCriteria(offerDtlVCs);
        Offerdet.executeQuery();

        System.err.println("OfferFromDate==>" +
                           Offerdet.first().getAttribute("OfferFromDate==>"));

        System.err.println("OfferToDate==>" +
                           Offerdet.first().getAttribute("OfferToDate==>"));


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
            onClickReject(actionEvent);
        }


    }

    public void onInvokeAppOrrejec(ActionEvent actionEvent) {
        // Add event code here...
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup3().show(popup34);
    }

    public void setPopup3(RichPopup popup3) {
        this.popup3 = popup3;
    }

    public RichPopup getPopup3() {
        return popup3;
    }


    public void setReason(RichInputText reason) {
        this.reason = reason;
    }

    public RichInputText getReason() {
        return reason;
    }

    public void onClickApply(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject BookingMilestVo =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        System.err.println("CustomerTrxnId" +
                           BookingMilestVo.getCurrentRow().getAttribute("CustomerTrxnId"));
        ViewObject RecptVo =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        ViewCriteria offerDtlVC = RecptVo.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("SourceFuncRefId",
                                 BookingMilestVo.getCurrentRow().getAttribute("BookingId"));
        offerDtlVC.addRow(offerDtlVCR);
        RecptVo.applyViewCriteria(offerDtlVC);
        RecptVo.executeQuery();


        ViewObject RecptVoln =
            ADFUtils.findIterator("ReceiptDtlVO3Iterator").getViewObject();
        ViewCriteria offerDtlVCs = RecptVo.createViewCriteria();
        ViewCriteriaRow offerDtlVCRs = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCRs.setAttribute("ReceiptId",
                                  RecptVo.first().getAttribute("ReceiptId"));
        offerDtlVCs.addRow(offerDtlVCRs);
        RecptVoln.applyViewCriteria(offerDtlVCs);
        RecptVoln.executeQuery();

        System.err.println("ReceiptNo" +
                           RecptVo.first().getAttribute("ReceiptNumber"));
        System.err.println("ReceiptNo" +
                           RecptVoln.first().getAttribute("InstallmentAmount"));


    }

    public void onClickCreate(ActionEvent actionEvent) {
        // Add event code here...

        ViewObject leaseVO =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();

        ViewObject BookingMilestVo =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        System.err.println("CustomerTrxnId" +
                           BookingMilestVo.getCurrentRow().getAttribute("CustomerTrxnId"));
        ViewObject RecptVo =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        ViewCriteria offerDtlVC = RecptVo.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("SourceFuncRefId",
                                 BookingMilestVo.getCurrentRow().getAttribute("BookingId"));
        offerDtlVC.addRow(offerDtlVCR);
        RecptVo.applyViewCriteria(offerDtlVC);
        RecptVo.executeQuery();


        ViewObject RecptVoln =
            ADFUtils.findIterator("ReceiptDtlVO3Iterator").getViewObject();
        ViewCriteria offerDtlVCs = RecptVo.createViewCriteria();
        ViewCriteriaRow offerDtlVCRs = offerDtlVCs.createViewCriteriaRow();
        offerDtlVCRs.setAttribute("ReceiptId",
                                  RecptVo.first().getAttribute("ReceiptId"));
        offerDtlVCs.addRow(offerDtlVCRs);
        RecptVoln.applyViewCriteria(offerDtlVCs);
        RecptVoln.executeQuery();

        System.err.println("ReceiptNo" +
                           RecptVo.first().getAttribute("ReceiptNumber"));
        System.err.println("InstallmentAmount" +
                           RecptVoln.first().getAttribute("InstallmentAmount"));
        System.err.println("ReceiptNo" +
                           RecptVoln.first().getAttribute("InstallmentAmount"));
        System.err.println("Customer" +
                           leaseVO.getCurrentRow().getAttribute("InstallmentAmount"));
    }

    public void pushInvoiceInterfaceLinePayload(ActionEvent actionEvent) throws IOException {
        try {
            String validate = "Y";
            Calendar cal = Calendar.getInstance();
            String dateFormat = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Object sysDate = sdf.format(cal.getTime());

            Random rand = new Random();
            int value = rand.nextInt(1000);
            int value1 = rand.nextInt(2500);

            ViewObject leaseVO =
                ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
            System.err.println("OFFER" +
                               leaseVO.getCurrentRow().getAttribute("OfferHdrId"));
            String booking_Id =
                leaseVO.getCurrentRow().getAttribute("BookingId") == null ?
                "0" :
                leaseVO.getCurrentRow().getAttribute("BookingId").toString();
            String leaseNo =
                leaseVO.getCurrentRow().getAttribute("LeaseNumber") == null ?
                null :
                leaseVO.getCurrentRow().getAttribute("LeaseNumber").toString();
            System.err.println("booking_Id==>" + booking_Id);
            ViewObject getNameVO =
                ADFUtils.findIterator("getID1Iterator").getViewObject();
            getNameVO.setNamedWhereClauseParam("BV_SELECT_COLUMN", "ORG_ID");
            getNameVO.setNamedWhereClauseParam("BV_TABLENAME",
                                               "XXPM_BOOKING_HEADER");
            getNameVO.setNamedWhereClauseParam("BV_WHERE_COLUMN",
                                               "BOOKING_ID");
            getNameVO.setNamedWhereClauseParam("BV_VALUE", booking_Id);
            getNameVO.executeQuery();
            String orgID =
                getNameVO.first().getAttribute("Id") == null ? "0" : getNameVO.first().getAttribute("Id").toString();
            System.err.println("orgID===>" + orgID);
            ViewObject customerVO =
                ADFUtils.findIterator("findCustomerROVO1Iterator").getViewObject();
            customerVO.setNamedWhereClauseParam("BV_BOOK_ID", booking_Id);
            customerVO.executeQuery();
            String custId =
                customerVO.first().getAttribute("CustId") == null ? null :
                customerVO.first().getAttribute("CustId").toString();
            String custName =
                customerVO.first().getAttribute("CustomerName") == null ?
                null :
                customerVO.first().getAttribute("CustomerName").toString();
            String custNumber =
                customerVO.first().getAttribute("CustomerNumber") == null ?
                null :
                customerVO.first().getAttribute("CustomerNumber").toString();

            ViewObject BookingDtlVO1 =
                ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
            System.err.println("custId" + custId);
            ViewObject customerSiteVO =
                ADFUtils.findIterator("custSiteROVO1Iterator").getViewObject();
            customerSiteVO.setNamedWhereClauseParam("BV_CUSID", custId);
            customerSiteVO.executeQuery();
            System.err.println("ROW COUNT--" +
                               customerSiteVO.getEstimatedRowCount());
            String TaxCode =
                leaseVO.getCurrentRow().getAttribute("TaxCode") == null ?
                null :
                leaseVO.getCurrentRow().getAttribute("TaxCode").toString();
            Object batchSourceNameObj = "Lease";
            Object customerTrxTypeNameObj = "Leasing Invoice";
            Object invoicingRuleNameObj = "Advance Invoice";
            Object accountingRuleNameObj = "Daily Rate All Periods";
            Object lineTypeObj = "LINE";
            Object quantityObj = "1";
            Object paymentTermsNameObj = "IMMEDIATE";
            Object taxCodeObj = getTaxCode(TaxCode);
            Object currencyCodeObj = "AED";
            Object testObj = leaseNo;
            Object testObj1 = getBookingDtls(booking_Id);

            Object orgIdObj = orgID;
            Object amountObj =
                BookingDtlVO1.getCurrentRow().getAttribute("BaseRate") ==
                null ? "3000" :
                BookingDtlVO1.getCurrentRow().getAttribute("BaseRate");

            String getDiscountValue =
                getDiscount(leaseVO.getCurrentRow().getAttribute("OfferHdrId"),
                            BookingDtlVO1.getCurrentRow().getAttribute("UnitId"),
                            BookingDtlVO1.getCurrentRow().getAttribute("BaseRate"));

            System.err.println("DiscountedValue" + getDiscountValue);

            Object billCustomerAccountNumberObj = custNumber;
            Object billCustomerSiteNumberObj =
                customerSiteVO.first().getAttribute("SiteNumber");

            Object billingDateObj = sysDate;
            Object commentsObj = "From Property Lease Module";
            Object trxDateObj = sysDate;
            Object descriptionObj = "From Property Lease Module";
            Object glDateObj = sysDate;
            Object ruleStartDateObj =
                leaseVO.getCurrentRow().getAttribute("LeaseStartDate") ==
                null ? "2018-07-01" :
                leaseVO.first().getAttribute("LeaseStartDate");
            Object ruleEndDateObj =
                leaseVO.getCurrentRow().getAttribute("LeaseEndDate") == null ?
                "2018-10-01" : leaseVO.first().getAttribute("LeaseEndDate");
            Object unitSellingPriceObj = amountObj;

            System.err.println("batchSourceNameObj--" + batchSourceNameObj);
            System.err.println("customerTrxTypeNameObj--" +
                               customerTrxTypeNameObj);
            System.err.println("invoicingRuleNameObj--" +
                               invoicingRuleNameObj);
            System.err.println("accountingRuleNameObj--" +
                               accountingRuleNameObj);
            System.err.println("lineTypeObj--" + lineTypeObj);
            System.err.println("quantityObj--" + quantityObj);
            System.err.println("paymentTermsNameObj--" + paymentTermsNameObj);
            System.err.println("taxCodeObj--" + taxCodeObj);
            System.err.println("currencyCodeObj--" + currencyCodeObj);
            System.err.println("testObj--" + testObj);
            System.err.println("orgIdObj--" + orgIdObj);
            System.err.println("amountObj--" + amountObj);
            System.err.println("billCustomerAccountNumberObj--" +
                               billCustomerAccountNumberObj);
            System.err.println("billCustomerSiteNumberObj--" +
                               billCustomerSiteNumberObj);
            System.err.println("billingDateObj--" + billingDateObj);
            System.err.println("commentsObj--" + commentsObj);
            System.err.println("trxDateObj--" + trxDateObj);
            System.err.println("descriptionObj--" + descriptionObj);
            System.err.println("glDateObj--" + glDateObj);
            System.err.println("ruleStartDateObj--" + ruleStartDateObj);
            System.err.println("ruleEndDateObj--" + ruleEndDateObj);
            System.err.println("unitSellingPriceObj--" + unitSellingPriceObj);

            if (batchSourceNameObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Batch Source Name is Required");
            }

            if (customerTrxTypeNameObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Customer Transaction Type is Required");
            }
            if (invoicingRuleNameObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Invoicing Rule is Required");
            }
            if (accountingRuleNameObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Accounting Rule  is Required");
            }
            if (lineTypeObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Line Type is Required");
            }
            if (quantityObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Quantity is Required");
            }
            if (paymentTermsNameObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Payment Terms is Required");
            }
            if (taxCodeObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Tax code is Required");
            }
            if (currencyCodeObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Currency Code is Required");
            }
            if (orgIdObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Organiztion is Required");
            }
            if (billCustomerAccountNumberObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Bill to Customer Account Number is Required");
            }
            if (billCustomerSiteNumberObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Bill to Customer Account Site is Required");
            }
            if (trxDateObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Tax Date is Required");
            }
            if (descriptionObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Description is Required");
            }
            if (glDateObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("GL Date is Required");
            }
            if (ruleStartDateObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Rule Start Date is Required");
            }
            if (ruleEndDateObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Rule End Date is Required");
            }
            if (unitSellingPriceObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Unit Selling Price is Required");
            }
            if (taxCodeObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("VAT Code is Required");
            }
            if (testObj == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Lease Number is Required");
            }
            if (testObj1 == null) {
                validate = "N";
                JSFUtils.addFacesErrorMessage("Booking Number is Required");
            }


            if (validate == "Y") {


                String enStr = "</env:Envelope>";
                String reqPayload = "<soapenv:Body>\n" +
                    "      <typ:createInterfaceLine>\n" +
                    "         <typ:interfaceLine>\n" +
                    "            <inv:OrgId>" + orgIdObj + "</inv:OrgId>\n" +
                    "            <inv:Amount currencyCode=\"AED\">" +
                    amountObj + "</inv:Amount>\n" +
                    "            <inv:BatchSourceName>" + batchSourceNameObj +
                    "</inv:BatchSourceName>\n" +
                    "            <inv:CustomerTrxTypeName>" +
                    customerTrxTypeNameObj + "</inv:CustomerTrxTypeName>\n" +
                    "            <inv:BillCustomerAccountNumber>" +
                    billCustomerAccountNumberObj +
                    "</inv:BillCustomerAccountNumber>\n" +
                    "            <inv:BillCustomerSiteNumber>" +
                    billCustomerSiteNumberObj +
                    "</inv:BillCustomerSiteNumber>\n" +
                    "            <inv:BillingDate>" + billingDateObj +
                    "</inv:BillingDate>\n" +
                    "            <inv:Comments>" + commentsObj +
                    "</inv:Comments>\n" +
                    "            <inv:TrxDate>" + trxDateObj +
                    "</inv:TrxDate>\n" +
                    "            <inv:CurrencyCode>" + currencyCodeObj +
                    "</inv:CurrencyCode>\n" +
                    "            <inv:Description>" + descriptionObj +
                    "</inv:Description>\n" +
                    "            <inv:GlDate>" + glDateObj +
                    "</inv:GlDate>\n" +
                    "            <inv:InvoicingRuleName>" +
                    invoicingRuleNameObj + "</inv:InvoicingRuleName>\n" +
                    "            <inv:AccountingRuleName>" +
                    accountingRuleNameObj + "</inv:AccountingRuleName>\n" +
                    "            <!--inv:AccountingRuleDuration>20</inv:AccountingRuleDuration-->\n" +
                    "            <inv:RuleEndDate>" + ruleEndDateObj +
                    "</inv:RuleEndDate>\n" +
                    "            <inv:RuleStartDate>" + ruleStartDateObj +
                    "</inv:RuleStartDate>\n" +
                    "            <inv:UnitSellingPrice currencyCode=\"AED\">" +
                    unitSellingPriceObj + "</inv:UnitSellingPrice>\n" +
                    "            <inv:LineType>" + lineTypeObj +
                    "</inv:LineType>\n" +
                    "            <inv:Quantity>" + quantityObj +
                    "</inv:Quantity>\n" +
                    "            <inv:PaymentTermsName>" +
                    paymentTermsNameObj + "</inv:PaymentTermsName>\n" +
                    "            <inv:TaxCode>" + taxCodeObj +
                    "</inv:TaxCode>\n" +
                    "            <inv:TransactionInterfaceLineDff xsi:type=\"tran2:test\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "               <tran2:__FLEX_Context>test</tran2:__FLEX_Context>\n" +
                    "               <tran2:test>" + leaseNo +
                    "</tran2:test>\n" +
                    "               <tran2:bookingnumber>" + testObj1 +
                    "</tran2:bookingnumber>\n" +
                    "            </inv:TransactionInterfaceLineDff>\n" +
                    "         </typ:interfaceLine>\n" +
                    "      </typ:createInterfaceLine>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";

                reqPayload = getInvoiceLineHeaderPayload(reqPayload);

                reqPayload = reqPayload.replaceAll("&", "&");
                System.err.println("Invoice Payload--" + reqPayload);
                JSFUtils.addFacesInformationMessage("Invoice Payload FOR ACTUAL" +
                                                    reqPayload);
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
                    //                this.invoiceResponseTxt.setValue(getInvoiceLineRespValue(responseCode,
                    //                                                                         out.toString()));
                } else {
                    System.err.println("Sucess Response : " + out.toString());
                    //                System.err.println("Sucess Response : " +
                    //                                   out.toString().substring(out.toString().indexOf("<env:Envelope"),
                    //                                                            out.toString().indexOf(enStr) +
                    //                                                            enStr.length()));
                    System.err.println("Success " +
                                       getInvoiceLineRespValue(responseCode,
                                                               out.toString()));
                    //                this.invoiceResponseTxt.setValue(getInvoiceLineRespValue(responseCode,
                    //                                                                         out.toString()));

                }
                reader.close();
                JSFUtils.addFacesInformationMessage("Reader Close 1 get Unit Id" +
                                                    BookingDtlVO1.getCurrentRow().getAttribute("UnitId").toString());
                Object ccIdObj =
                    getCodeCombinationId(orgID, "LOU", BookingDtlVO1.getCurrentRow().getAttribute("UnitId").toString());
                if (ccIdObj == null)
                    JSFUtils.addFacesInformationMessage("ccIdObj == null---- pushInvoiceLineDist Function---" +
                                                        "ccIdObj.toString()----" +
                                                        ccIdObj.toString() +
                                                        "orgID.toString()---" +
                                                        orgID.toString() +
                                                        "leaseNo.toString()----" +
                                                        leaseNo.toString() +
                                                        "testObj1.toString()----" +
                                                        testObj1.toString());

                pushInvoiceLineDist(ccIdObj.toString(), orgID.toString(),
                                    leaseNo.toString(), testObj1.toString());

            }

            if (getDiscountValue != "0") {
                String discountAmountObj = "-" + getDiscountValue;
                descriptionObj = "For Discount";
                String enStr = "</env:Envelope>";
                String reqPayload = "<soapenv:Body>\n" +
                    "      <typ:createInterfaceLine>\n" +
                    "         <typ:interfaceLine>\n" +
                    "            <inv:OrgId>" + orgIdObj + "</inv:OrgId>\n" +
                    "            <inv:Amount currencyCode=\"AED\">" +
                    discountAmountObj + "</inv:Amount>\n" +
                    "            <inv:BatchSourceName>" + batchSourceNameObj +
                    "</inv:BatchSourceName>\n" +
                    "            <inv:CustomerTrxTypeName>" +
                    customerTrxTypeNameObj + "</inv:CustomerTrxTypeName>\n" +
                    "            <inv:BillCustomerAccountNumber>" +
                    billCustomerAccountNumberObj +
                    "</inv:BillCustomerAccountNumber>\n" +
                    "            <inv:BillCustomerSiteNumber>" +
                    billCustomerSiteNumberObj +
                    "</inv:BillCustomerSiteNumber>\n" +
                    "            <inv:BillingDate>" + billingDateObj +
                    "</inv:BillingDate>\n" +
                    "            <inv:Comments>" + commentsObj +
                    "</inv:Comments>\n" +
                    "            <inv:TrxDate>" + trxDateObj +
                    "</inv:TrxDate>\n" +
                    "            <inv:CurrencyCode>" + currencyCodeObj +
                    "</inv:CurrencyCode>\n" +
                    "            <inv:Description>" + descriptionObj +
                    "</inv:Description>\n" +
                    "            <inv:GlDate>" + glDateObj +
                    "</inv:GlDate>\n" +
                    "            <inv:InvoicingRuleName>" +
                    invoicingRuleNameObj + "</inv:InvoicingRuleName>\n" +
                    "            <inv:AccountingRuleName>" +
                    accountingRuleNameObj + "</inv:AccountingRuleName>\n" +
                    "            <!--inv:AccountingRuleDuration>20</inv:AccountingRuleDuration-->\n" +
                    "            <inv:RuleEndDate>" + ruleEndDateObj +
                    "</inv:RuleEndDate>\n" +
                    "            <inv:RuleStartDate>" + ruleStartDateObj +
                    "</inv:RuleStartDate>\n" +
                    "            <inv:UnitSellingPrice currencyCode=\"AED\">" +
                    unitSellingPriceObj + "</inv:UnitSellingPrice>\n" +
                    "            <inv:LineType>" + lineTypeObj +
                    "</inv:LineType>\n" +
                    "            <inv:Quantity>" + quantityObj +
                    "</inv:Quantity>\n" +
                    "            <inv:PaymentTermsName>" +
                    paymentTermsNameObj + "</inv:PaymentTermsName>\n" +
                    "            <inv:TaxCode>" + taxCodeObj +
                    "</inv:TaxCode>\n" +
                    "            <inv:TransactionInterfaceLineDff xsi:type=\"tran2:test\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "               <tran2:__FLEX_Context>test</tran2:__FLEX_Context>\n" +
                    "               <tran2:test>" + leaseNo +
                    "</tran2:test>\n" +
                    "               <tran2:bookingnumber>" + testObj1 +
                    "</tran2:bookingnumber>\n" +
                    "            </inv:TransactionInterfaceLineDff>\n" +
                    "         </typ:interfaceLine>\n" +
                    "      </typ:createInterfaceLine>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";

                reqPayload = getInvoiceLineHeaderPayload(reqPayload);

                reqPayload = reqPayload.replaceAll("&", "&");
                System.err.println("Invoice Payload--" + reqPayload);
                JSFUtils.addFacesInformationMessage("Invoice Payload" +
                                                    reqPayload);
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
                    //                this.invoiceResponseTxt.setValue(getInvoiceLineRespValue(responseCode,
                    //                                                                         out.toString()));
                } else {
                    System.err.println("Sucess Response : " + out.toString());
                    //                System.err.println("Sucess Response : " +
                    //                                   out.toString().substring(out.toString().indexOf("<env:Envelope"),
                    //                                                            out.toString().indexOf(enStr) +
                    //                                                            enStr.length()));
                    System.err.println("Success " +
                                       getInvoiceLineRespValue(responseCode,
                                                               out.toString()));
                    //                this.invoiceResponseTxt.setValue(getInvoiceLineRespValue(responseCode,
                    //                                                                         out.toString()));

                }
                reader.close();
                Object ccIdObj =
                    getCodeCombinationId(orgID, "LOU", BookingDtlVO1.getCurrentRow().getAttribute("UnitId").toString());
                if (ccIdObj == null)
                    pushInvoiceLineDist(ccIdObj.toString(), orgID.toString(),
                                        leaseNo.toString(),
                                        testObj1.toString());

            }
        }

        catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Invoice Payload Error" + e);
            e.printStackTrace();
        }

    }
    //300000001765441 //300000001727604

    public void pushInvoiceLineDist(String ccid, String orgId, String dff,
                                    String dff1) {
        try {
            String distributionPayload = "<soapenv:Body>\n" +
                "      <typ:createInterfaceDistribution>\n" +
                "         <typ:interfaceDistribution>           \n" +
                "            <inv:AccountClass>REV</inv:AccountClass>          \n" +
                "            <inv:CodeCombinationId>" + ccid +
                "</inv:CodeCombinationId>           \n" +
                "            <inv:OrgId>" + orgId +
                "</inv:OrgId>           \n" +
                "            <inv:Percent>100</inv:Percent>           \n" +
                "            <inv:DistributionInterfacLineDff xsi:type=\"tran:test\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "               <tran:__FLEX_Context>test</tran:__FLEX_Context>\n" +
                "               <tran:_FLEX_NumOfSegments>2</tran:_FLEX_NumOfSegments>\n" +
                "               <tran:test>" + dff + "</tran:test>\n" +
                "               <tran:bookingnumber>" + dff1 +
                "</tran:bookingnumber>\n" +
                "            </inv:DistributionInterfacLineDff>\n" +
                "         </typ:interfaceDistribution>\n" +
                "      </typ:createInterfaceDistribution>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

            distributionPayload =
                    getInvoiceLineDistPayload(distributionPayload);
            distributionPayload = distributionPayload.replaceAll("&", "&");
            System.err.println("DistInvoice Payload--" + distributionPayload);
            JSFUtils.addFacesInformationMessage("Distribution Payload" +
                                                distributionPayload);
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");
            RequestBody body =
                RequestBody.create(mediaType, distributionPayload);
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

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Dist Payload Error" + e);
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


    public String getInvoiceLineDistPayload(String xmlData) {
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

            Object temp =
                "<soapenv:Envelope xmlns:inv=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tran=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionInterfaceLineDff/\" xmlns:tran1=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/types/\">\n";
            xml += temp + "   <soapenv:Header>\n" +
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

    public void pushReceiptPayload(ActionEvent actionEvent) {

        try {
            Calendar cal = Calendar.getInstance();
            String dateFormat = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Object sysDate = sdf.format(cal.getTime());

            ViewObject leaseVO =
                ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
            String booking_Id =
                leaseVO.getCurrentRow().getAttribute("BookingId") == null ?
                "0" :
                leaseVO.getCurrentRow().getAttribute("BookingId").toString();
            System.err.println("booking_Id==>" + booking_Id);
            ViewObject getNameVO =
                ADFUtils.findIterator("getID1Iterator").getViewObject();
            getNameVO.setNamedWhereClauseParam("BV_SELECT_COLUMN", "ORG_ID");
            getNameVO.setNamedWhereClauseParam("BV_TABLENAME",
                                               "XXPM_BOOKING_HEADER");
            getNameVO.setNamedWhereClauseParam("BV_WHERE_COLUMN",
                                               "BOOKING_ID");
            getNameVO.setNamedWhereClauseParam("BV_VALUE", booking_Id);
            getNameVO.executeQuery();
            String orgID =
                getNameVO.first().getAttribute("Id") == null ? "0" : getNameVO.first().getAttribute("Id").toString();
            System.err.println("orgID===>" + orgID);
            ViewObject customerVO =
                ADFUtils.findIterator("findCustomerROVO1Iterator").getViewObject();
            customerVO.setNamedWhereClauseParam("BV_BOOK_ID", booking_Id);
            customerVO.executeQuery();
            String custId =
                customerVO.first().getAttribute("CustId") == null ? null :
                customerVO.first().getAttribute("CustId").toString();
            String custName =
                customerVO.first().getAttribute("CustomerName") == null ?
                null :
                customerVO.first().getAttribute("CustomerName").toString();
            String custNumber =
                customerVO.first().getAttribute("CustomerNumber") == null ?
                null :
                customerVO.first().getAttribute("CustomerNumber").toString();

            System.err.println("CustomerNumber==>" +
                               customerVO.first().getAttribute("CustomerNumber"));

            System.err.println("CUSTID==>" + custId + "CUSTNAME==>" +
                               custName + custNumber);
            System.err.println("orgID===>" + orgID);


            ViewObject receiptVO =
                ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
            System.err.println("---" +
                               receiptVO.getCurrentRow().getAttribute("ReceiptNumber"));
            System.err.println("---" +
                               receiptVO.getCurrentRow().getAttribute("ReceiptDate"));
            System.err.println("---" +
                               receiptVO.getCurrentRow().getAttribute("RecommendedAmount"));


            Random rand = new Random();
            int value = rand.nextInt(1000);
            String trxStatus = null;
            String errMsg = null;

            Object p_currency_code = "AED";
            Object p_amount =
                receiptVO.getCurrentRow().getAttribute("RecommendedAmount");
            Object p_receipt_Number =
                receiptVO.getCurrentRow().getAttribute("ReceiptNumber");
            Object p_receipt_date = sysDate;
            Object p_gl_date = sysDate;
            Object p_receipt_method_name = "PDC-UAB-002";
            Object p_ORG_id = orgID;
            Object p_maturity_date = sysDate;
            Object p_customer_name = custName;
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

            reqPayload = getHeaderPayloadForReceiptPayload(reqPayload);
            System.err.println("HELLO" + reqPayload);

            reqPayload = reqPayload.replaceAll("&", "&");
            JSFUtils.addFacesInformationMessage("Receipt Payload" +
                                                reqPayload);
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

                JSFUtils.addFacesInformationMessage("Receipt Payload Response: " +
                                                    out.toString());

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
                JSFUtils.addFacesInformationMessage("Receipt Payload Response: " +
                                                    errMsg);


            }
            reader.close();
            if (trxStatus.equalsIgnoreCase("E")) {
                //                    currRow.setAttribute("Attribute1", errMsg);
                //                    this.attributResponse.setValue(errMsg);
                //this.AttributResponse.setValue(reqPayload);
                //AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAttributResponse());
                System.out.println("Error : " + errMsg);

                JSFUtils.addFacesInformationMessage("Receipt Payload Response: " +
                                                    errMsg);
                //                JSFUtils.addFacesInformationMessage("Invoice not generated successfully");
            } else {
                //this.responseTxt.setValue(reqPayload);

                //                    currRow.setAttribute("Attribute1", p_receipt_Number);
                //                    this.attributResponse.setValue(trxStatus);
                //AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAttributResponse());
                receiptVO.getCurrentRow().setAttribute("Attribute1",
                                                       p_receipt_Number);
                this.attributResponse.setValue(p_receipt_Number);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAttributResponse());
                System.out.println("Receipt Number : " + trxStatus);
                //                JSFUtils.addFacesInformationMessage("Invoice generated successfully");
                JSFUtils.addFacesInformationMessage("Receipt Payload Response: " +
                                                    p_receipt_Number);
            }
        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Receipt Payload Error" + e);
        }
    }

    public String getHeaderPayloadForReceiptPayload(String xmlData) {
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


    public void pushApplyReceiptPayload(ActionEvent actionEvent) {
        String trxStatus = null;
        String errMsg = null;

        ViewObject BookingDtlVO1 =
            ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
        Object customerTrxIdObj =
            BookingDtlVO1.getCurrentRow().getAttribute("CustomerTrxnId") ==
            null ? null :
            BookingDtlVO1.getCurrentRow().getAttribute("CustomerTrxnId");

        // Object customerTrxIdObj = customerTrxIdObj1;

        //        Object customerTrxIdObj =
        //            customerTrxnIdTxt.getValue() == null ? 0 :
        //            customerTrxnIdTxt.getValue();


        Calendar cal = Calendar.getInstance();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Object sysDate = sdf.format(cal.getTime());

        ViewObject receiptVO =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row currRow = receiptVO.getCurrentRow();


        System.err.println("---" +
                           receiptVO.getCurrentRow().getAttribute("ReceiptNumber"));
        System.err.println("---" +
                           receiptVO.getCurrentRow().getAttribute("ReceiptDate"));
        System.err.println("---" +
                           receiptVO.getCurrentRow().getAttribute("RecommendedAmount"));

        Object amountAppliedObj =
            currRow.getAttribute("RecommendedAmount") == null ? "0" :
            currRow.getAttribute("RecommendedAmount");

        Object commentsObj = "APPLY";


        Object receiptNumberObj = currRow.getAttribute("ReceiptNumber");

        Object receiptDateObj = currRow.getAttribute("ReceiptDate");

        Object cashReceiptId = currRow.getAttribute("Attribute2");

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
            amountAppliedObj + "</com:ReceiptAmount>\n" +
            "            <com:ReceiptDate>" + receiptDateObj +
            "</com:ReceiptDate>\n" +
            "            <com:TransactionDate/>" +
            "            <com:ApplicationDate>" + applicationDateObj +
            "</com:ApplicationDate>\n" +
            "            <com:AccountingDate>" + accountingDateObj +
            "</com:AccountingDate>\n" +
            "         </typ:applyReceipt>\n" +
            "      </typ:createApplyReceipt>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";

        reqPayload = getReceiptApplyHeaderPayload(reqPayload);
        try {
            reqPayload = reqPayload.replaceAll("&", "&");
            JSFUtils.addFacesInformationMessage(reqPayload);

            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");
            RequestBody body = RequestBody.create(mediaType, reqPayload);
            Request request =
                new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com:443/fscmService/StandardReceiptService?wsdl").post(body).addHeader("content-type",
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
                JSFUtils.addFacesInformationMessage("ERROR" + strResp);
                //                this.applyReceiptTxt.setValue(getReceiptApplyRespValue(responseCode,
                //                                                                       out.toString()));
                // AdfFacesContext.getCurrentInstance().addPartialTarget(applyReceiptTxt);
            } else {
                System.err.println("Sucess Response : " + out.toString());
                //                System.err.println("Sucess Response : " +
                //                                   out.toString().substring(out.toString().indexOf("<env:Envelope"),
                //                                                            out.toString().indexOf(enStr) +
                //                                                            enStr.length()));

                System.err.println("Success " +
                                   getReceiptApplyRespValue(responseCode,
                                                            out.toString()));
                JSFUtils.addFacesInformationMessage("Success" + strResp);
                //this.applyReceiptTxt.setValue(getReceiptApplyRespValue(responseCode,
                // out.toString()));
                //AdfFacesContext.getCurrentInstance().addPartialTarget(applyReceiptTxt);

            }
        }

        catch (Exception e) {
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
"<soapenv:Envelope xmlns:app=\"http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ApplyReceiptDff/\" xmlns:com=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/types/\">\n" +
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

    public void setCustomerTrxnIdTxt(RichInputText customerTrxnIdTxt) {
        this.customerTrxnIdTxt = customerTrxnIdTxt;
    }

    public RichInputText getCustomerTrxnIdTxt() {
        return customerTrxnIdTxt;
    }

    /*public void syncInvoiceDtls(ActionEvent actionEvent) {

        //        JSFUtils.addFacesInformationMessage(customerTrxnIdTxt.getValue() ==
        //                                            null ? "No data" :
        //                                            customerTrxnIdTxt.getValue().toString());
        //        ViewObject leaseVO =
        //            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        //        String booking_Id =
        //            leaseVO.getCurrentRow().getAttribute("BookingId") == null ? "0" :
        //            leaseVO.getCurrentRow().getAttribute("BookingId").toString();
        //
        //        //        ViewObject bookingDtlVO =
        //        //            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        //        //        ViewCriteria bookingDtlVC = bookingDtlVO.createViewCriteria();
        //        //        ViewCriteriaRow bookingDtlVCR = bookingDtlVC.createViewCriteriaRow();
        //        //        bookingDtlVCR.setAttribute("bnd_bookId", booking_Id);
        //        //        bookingDtlVC.addRow(bookingDtlVCR);
        //        //        bookingDtlVO.applyViewCriteria(bookingDtlVC);
        //        //        bookingDtlVO.executeQuery();
        //        //        bookingDtlVO.first().setAttribute("CustomerTrxnId",
        //        //                                          customerTrxnIdTxt.getValue());
        //
        //        ViewObject bookingDtlVO =
        //            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        //        ViewObjectImpl bookingDtlVOImpl =
        //            (ViewObjectImpl)bookingDtlVO.getViewObject();
        //        ViewCriteria partVC = bookingDtlVOImpl.getViewCriteria("SetBookingId");
        //        bookingDtlVO.applyViewCriteria(partVC);
        //        bookingDtlVO.setNamedWhereClauseParam("bnd_bookId", booking_Id);
        //        bookingDtlVO.executeQuery();
        //        JSFUtils.addFacesInformationMessage(bookingDtlVO.getEstimatedRowCount() +
        //                                            "");
        //        bookingDtlVO.first().setAttribute("CustomerTrxnId",
        //                                          customerTrxnIdTxt.getValue());
        //        JSFUtils.addFacesInformationMessage(bookingDtlVO.first().getAttribute("CustomerTrxnId") +
        //                                            "");
        //        OperationBinding operBnd =
        //            ADFUtils.getBindingContainer().getOperationBinding("Commit");
        //        operBnd.execute();

        try {
            //        ViewObject leaseVO =
            //            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
            //
            //        String leaseNo =
            //            leaseVO.getCurrentRow().getAttribute("") == null ? "0" :
            //            leaseVO.getCurrentRow().getAttribute("").toString();
            //
            //
            //        InvoiceSync i = new InvoiceSync();
            //
            //        try {
            //            i.invokeBIWebService(leaseNo, "");
            //            ViewObject BookingDtlVo =
            //                ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
            //            BookingDtlVo.executeQuery();
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTable1());
            //        } catch (Exception e) {
            //            System.out.println("Exception : " + e.getMessage());
            //        }

            //            String leaseNo =
            //                leaseVO.getCurrentRow().getAttribute("LeaseNumber") == null ?
            //                "0" :
            //                leaseVO.getCurrentRow().getAttribute("LeaseNumber").toString();


            //            InvoiceSync i = new InvoiceSync();
            //
            //
            //            i.invokeBIWebService(leaseNo, "");
            //            ViewObject BookingDtlVo =
            //                ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
            //            BookingDtlVo.executeQuery();
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTable1());
        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error" + e);
            System.out.println("Exception : " + e.getMessage());
        }
    }*/

    public void setAttributResponse(RichInputText attributResponse) {
        this.attributResponse = attributResponse;
    }

    public RichInputText getAttributResponse() {
        return attributResponse;
    }

    public void setTable1(RichTable table1) {
        this.table1 = table1;
    }

    public RichTable getTable1() {
        return table1;
    }

    public void invokeARInvoiceBIWS(String p_lease_number,
                                    String p_charge_type) {
        try {
            //            String webservice_username = "deepak.r@4iapps.com";
            //            String webservice_password = "welcome@4i";
            //            Date date = new Date();
            //            SimpleDateFormat dateFormat =
            //                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'");
            //            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            //            long t = date.getTime();
            //            Date expDate = new Date(t + (10 * 60000));
            //            String createdTS = dateFormat.format(date);
            //            String expiresTS = dateFormat.format(expDate);

            //            String Payload1 ="";
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
                "                 <pub:name>p_lease_number</pub:name>\n" +
                "                 <pub:values>\n" +
                "                    <pub:item>" + p_lease_number +
                "</pub:item>\n" +
                "                 </pub:values>\n" +
                "              </pub:item>\n" +
                "              <pub:item>\n" +
                "                 <pub:name>p_charge_type</pub:name>\n" +
                "                 <pub:values>\n" +
                "                    <pub:item/>\n" +
                "                 </pub:values>\n" +
                "              </pub:item>              \n" +
                "           </pub:parameterNameValues>\n" +
                "           <pub:reportAbsolutePath>Custom/Property Lease/Reports/Receivable Invoice Number.xdo</pub:reportAbsolutePath>\n" +
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
            getARInvoiceBIWSRespValue(responseCode, out.toString());


        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("ERROR IN CATCH BLOCK--" + e);
        }

    }


    public String getARInvoiceBIWSRespValue(int respCode, String out) {
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

                if (notNull(reportOutput.getElementsByTagName("LEASE_NUMBER").item(0)) &&
                    notNull(reportOutput.getElementsByTagName("TRX_NUMBER").item(0)) &&
                    notNull(reportOutput.getElementsByTagName("CUSTOMER_TRX_ID").item(0))) {

                    BindingContainer bindings =
                        BindingContext.getCurrent().getCurrentBindingsEntry();
                    OperationBinding method =
                        bindings.getOperationBinding("getARInvoiceTrxDetails");
                    Map args = method.getParamsMap();
                    args.put("pLeaseNo",
                             reportOutput.getElementsByTagName("P_LEASE_NUMBER").item(0).getTextContent().toString());
                    args.put("pChargeTyp", null);
                    args.put("pCustomerTrxId",
                             reportOutput.getElementsByTagName("CUSTOMER_TRX_ID").item(0).getTextContent().toString());
                    args.put("pCustomerTrxNo",
                             reportOutput.getElementsByTagName("TRX_NUMBER").item(0).getTextContent().toString());
                    Object a = method.execute();
                    JSFUtils.addFacesInformationMessage("RESPONSE--" + a);
                    JSFUtils.addFacesInformationMessage("OUT PUT" +
                                                        reportOutput.getElementsByTagName("P_LEASE_NUMBER").item(0).getTextContent());

                    System.err.println("P_LEASE_NUMBER" +
                                       reportOutput.getElementsByTagName("P_LEASE_NUMBER").item(0).getTextContent());
                    System.err.println("CUSTOMER_TRX_ID" +
                                       reportOutput.getElementsByTagName("CUSTOMER_TRX_ID").item(0).getTextContent());
                    System.err.println("TRX_NUMBER" +
                                       reportOutput.getElementsByTagName("TRX_NUMBER").item(0).getTextContent());
                }

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


    public void syncInvoiceDtls(ActionEvent actionEvent) {

        try {
            ViewObject leaseVO =
                ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
            String leaseNo =
                leaseVO.getCurrentRow().getAttribute("LeaseNumber") == null ?
                "0" :
                leaseVO.getCurrentRow().getAttribute("LeaseNumber").toString();

            invokeARInvoiceBIWS(leaseNo, "");

            ViewObject BookingDtlVo =
                ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
            BookingDtlVo.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTable1());


            //            BindingContainer bindings =
            //                BindingContext.getCurrent().getCurrentBindingsEntry();
            //            OperationBinding method =
            //                bindings.getOperationBinding("getARInvoiceTrxDetails");
            //            Map args = method.getParamsMap();
            //            args.put("pLeaseNo", leaseNo);
            //            args.put("pChargeTyp", null);
            //            args.put("pCustomerTrxId", "20021");
            //            args.put("pCustomerTrxNo", "18001");
            //            Object a = method.execute();
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTable1());


            //            BindingContainer bindings =
            //                BindingContext.getCurrent().getCurrentBindingsEntry();
            //            OperationBinding method =
            //                bindings.getOperationBinding("getARInvoiceTrxDetails");
            //            Map args = method.getParamsMap();
            //            args.put("pLeaseNumber", "LA-1039");
            //            args.put("chargeTyp", "");
            //            Object a = method.execute();
            //            JSFUtils.addFacesInformationMessage("RESPONSE--" + a);

        } catch (Exception e) {
            //JSFUtils.addFacesInformationMessage("Error" + e);
            //System.out.println("Exception : " + e.getMessage());

            BindingContext bctx = BindingContext.getCurrent();
            ((DCBindingContainer)bctx.getCurrentBindingsEntry()).reportException(new CommonJBOException("TEST",
                                                                                                        propertyBundle));
        }
    }

    public String getCodeCombinationId(String pBusinessUnitId,
                                       String pChargeType,
                                       String pUnitId) throws IOException {
        try {

            JSFUtils.addFacesInformationMessage("CC Param" + pBusinessUnitId +
                                                pChargeType + pUnitId);
            BindingContainer bindings =
                BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding operation =
                bindings.getOperationBinding("getCodeSegmentCombination");
            //ADFUtils.getBindingContainer().getOperationBinding("getCodeSegmentCombination");
            operation.getParamsMap().put("pBusinessUnitId", pBusinessUnitId);
            operation.getParamsMap().put("pChargeType", pChargeType);
            operation.getParamsMap().put("pUnitId", pUnitId);
            Object returnResult = operation.execute();
            JSFUtils.addFacesInformationMessage("returnResult" + returnResult);

            if (returnResult != "E") {
                String webservice_username = "ERP_user";
                String webservice_password = "welcome@4i";
                Date date = new Date();
                SimpleDateFormat dateFormat =
                    new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'");
                dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                long t = date.getTime();
                Date expDate = new Date(t + (10 * 60000));


                String segmentWithDelimiter = returnResult.toString();
                // "01.01.4ITEST.009.14501.01.000.000";
                String segments[] = segmentWithDelimiter.split("\\.");
                String created = dateFormat.format(date);
                String expries = dateFormat.format(expDate);

                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("text/xml");
                WsPayloadForCreateAccounts payload =
                    new WsPayloadForCreateAccounts();
                String xmlInput =
                    payload.getPayload(created, expries, segments,
                                       webservice_username,
                                       webservice_password);
                RequestBody body = RequestBody.create(mediaType, xmlInput);
                Request request =
                    new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com:443/fscmService/AccountCombinationService?wsdl").post(body).addHeader("content-type",
                                                                                                                                                         "no-cache").addHeader("SOAPACTION",
                                                                                                                                                                               "validateAndCreateAccounts").build();
                Response response = null;

                response = client.newCall(request).execute();

                InputStream isr = response.body().byteStream();
                BufferedReader reader =
                    new BufferedReader(new InputStreamReader(isr));
                StringBuilder out = new StringBuilder();
                String resultsXml;
                while ((resultsXml = reader.readLine()) != null) {
                    out.append(resultsXml);
                }


                JSFUtils.addFacesInformationMessage("Response" +
                                                    out.toString());

                return xmlExtractor(response.code(), out.toString());

            }
        } catch (Exception ex) {
            JSFUtils.addFacesInformationMessage("Error----getCodeCombinationId" +
                                                ex);
            return "Error in Invoking webservice";
        }
        return null;
    }


    public String xmlExtractor(int responseCode, String responseString) {
        try {
            DocumentBuilder builder =
                DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(responseString));
            Document doc = builder.parse(src);
            if (responseCode == 200) {
                // gets the error Information Except the error in segment
                if (doc.getElementsByTagName("CcId").item(0).getTextContent().isEmpty()) {
                    System.out.println(doc.getElementsByTagName("Error").item(0).getTextContent());
                    return doc.getElementsByTagName("Error").item(0).getTextContent();
                } // gets the error if it occurs in segments
                else if (doc.getElementsByTagName("CcId").item(0).getTextContent().equalsIgnoreCase("-1")) {
                    return "Enter the required value attributes for the segment values  and error code : " +
                        doc.getElementsByTagName("ErrorCode").item(0).getTextContent();
                } // gets the data if payload has no errors
                else {
                    return doc.getElementsByTagName("CcId").item(0).getTextContent();
                }

            } else {
                return doc.getElementsByTagName("faultstring").item(0).getTextContent();
            }
        } catch (SAXException ex) {
            JSFUtils.addFacesInformationMessage("Error" + ex);
        } catch (IOException ex) {
            JSFUtils.addFacesInformationMessage("Error" + ex);
        } catch (ParserConfigurationException ex) {
            JSFUtils.addFacesInformationMessage("Error" + ex);
        }
        return "Parsing Error";
    }

    public HashMap<String, String> getUnitDetails() {
        HashMap<String, String> map = new HashMap<String, String>();
        ViewObject bookingDtlVO =
            ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
        if (bookingDtlVO.first() != null) {
            map.put("UNIT_ID",
                    bookingDtlVO.getCurrentRow().getAttribute("UnitId") ==
                    null ? "N" :
                    bookingDtlVO.getCurrentRow().getAttribute("UnitId").toString());
            map.put("CHARGE_TYPE", "LOU");
        }
        ViewObject trxForInvoiceVO =
            ADFUtils.findIterator("getARTrxDltsForInvoice_ROVO1Iterator").getViewObject();
        // ViewCriteria trxForInvoiceVC = trxForInvoiceVO.createViewCriteria();
        // ViewCriteriaRow trxForInvoiceVCR =
        //trxForInvoiceVC.createViewCriteriaRow();
        // trxForInvoiceVCR.setAttribute("BV_BusinessUnitId","300000001727604");
        //trxForInvoiceVCR.setAttribute("BV_ChargeType","LOU");
        // trxForInvoiceVC.addRow(trxForInvoiceVCR);
        //trxForInvoiceVO.applyViewCriteria(trxForInvoiceVC);
        trxForInvoiceVO.setNamedWhereClauseParam("BV_BusinessUnitId",
                                                 "300000001727604");
        trxForInvoiceVO.setNamedWhereClauseParam("BV_ChargeType", "LOU");
        trxForInvoiceVO.executeQuery();
        if (trxForInvoiceVO.first() != null) {
            map.put("CUST_TRX_TYPE",
                    trxForInvoiceVO.getCurrentRow().getAttribute("CustTrxType") ==
                    null ? "N" :
                    trxForInvoiceVO.getCurrentRow().getAttribute("CustTrxType").toString());

            map.put("BATCH_SOURCE",
                    trxForInvoiceVO.getCurrentRow().getAttribute("BatchSource") ==
                    null ? "N" :
                    trxForInvoiceVO.getCurrentRow().getAttribute("BatchSource").toString());

            map.put("NATURAL_ACCT",
                    trxForInvoiceVO.getCurrentRow().getAttribute("NaturalAcct") ==
                    null ? "N" :
                    trxForInvoiceVO.getCurrentRow().getAttribute("NaturalAcct").toString());

            map.put("LEDGER_ID",
                    trxForInvoiceVO.getCurrentRow().getAttribute("LedgerId") ==
                    null ? "N" :
                    trxForInvoiceVO.getCurrentRow().getAttribute("LedgerId").toString());

            map.put("LEDGER_NAME",
                    trxForInvoiceVO.getCurrentRow().getAttribute("LedgerName") ==
                    null ? "N" :
                    trxForInvoiceVO.getCurrentRow().getAttribute("LedgerName").toString());

            map.put("CODE_COMBINATION",
                    trxForInvoiceVO.getCurrentRow().getAttribute("CodeCombination") ==
                    null ? "N" :
                    trxForInvoiceVO.getCurrentRow().getAttribute("CodeCombination").toString());
        }

        return map;
    }

    public String checkingMethod() {
        HashMap<String, String> map = getUnitDetails();
        if (!map.isEmpty()) {
            JSFUtils.addFacesInformationMessage(map.get("UNIT_ID"));
            JSFUtils.addFacesInformationMessage(map.get("CHARGE_TYPE"));
            JSFUtils.addFacesInformationMessage(map.get("CUST_TRX_TYPE"));
            JSFUtils.addFacesInformationMessage(map.get("BATCH_SOURCE"));
            JSFUtils.addFacesInformationMessage(map.get("NATURAL_ACCT"));
            JSFUtils.addFacesInformationMessage(map.get("LEDGER_ID"));
            JSFUtils.addFacesInformationMessage(map.get("LEDGER_NAME"));
            JSFUtils.addFacesInformationMessage(map.get("CODE_COMBINATION"));
        }
        return null;
    }

    public String getTaxCode(Object p_TaxVal) {
        String taxCode = null;
        ViewObject taxCodeVO =
            ADFUtils.findIterator("getTaxCodeROVO1Iterator").getViewObject();
        taxCodeVO.setNamedWhereClauseParam("p_TaxVal", p_TaxVal);
        taxCodeVO.executeQuery();
        if (taxCodeVO.first() != null) {
            taxCode =
                    taxCodeVO.first().getAttribute("LookupValueNameDisp") == null ?
                    "ZR 0%" :
                    taxCodeVO.first().getAttribute("LookupValueNameDisp").toString();
        }
        return taxCode;
    }

    public String getBookingDtls(Object p_BookingId) {
        String bookingNumber = null;
        ViewObject bookingVO =
            ADFUtils.findIterator("getBookingDetailsROVO1Iterator").getViewObject();
        bookingVO.setNamedWhereClauseParam("p_BookingId", p_BookingId);
        bookingVO.executeQuery();
        if (bookingVO.first() != null) {
            bookingNumber =
                    bookingVO.first().getAttribute("BookingNumber") == null ?
                    null :
                    bookingVO.first().getAttribute("BookingNumber").toString();
        }
        return bookingNumber;
    }

    /*
     * This method is used for pushing the Property Lease data
     * to Oracle AR Invoice module through invoice interface payload
     * */

    public void pushInvoiceInterfaceLineDlts(ActionEvent actionEvent) throws IOException {
        try {

            ViewObject BookingDtlVO1 =
                ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
//            RowSetIterator bookingDtRS =
//                BookingDtlVO1.createRowSetIterator(null);
            int transactionValue = 1;
//            while (bookingDtRS.hasNext()) {
                String getLeaseType = "";
                String getTrxnsType = "";
                //                int transactionValue = 1;
//                Row currRow = bookingDtRS.next();
                String validationFlag = "Y";
                ViewObject leaseVO =
                    ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
                Object bookingId =
                    leaseVO.getCurrentRow().getAttribute("BookingId");
                //                System.err.println(bookingId);

                ViewObject invoiceInterfaceValueVO =
                    ADFUtils.findIterator("getInvoiceInterfacePayloadValues_ROVO1Iterator").getViewObject();

                invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_BOOKING_ID",
                                                                 bookingId);
                invoiceInterfaceValueVO.executeQuery();
            RowSetIterator invoiceRS = invoiceInterfaceValueVO.createRowSetIterator(null);
                while (invoiceRS.hasNext()) {
                Row currRow = invoiceRS.next();
//                if (invoiceInterfaceValueVO.first() != null) {
                    Object taxValue =
                        currRow.getAttribute("TaxCode") ==
                        null ? "0" :
                        currRow.getAttribute("TaxCode");
                    Object unitId = currRow.getAttribute("UnitId");
                    Object orgId =
                        currRow.getAttribute("OrgId");
                    Object amount =
                        currRow.getAttribute("BaseRate");
                    Object billCustomerAccountNumber =
                        currRow.getAttribute("CustomerNumber");
                    Object billCustomerSiteNumber =
                        currRow.getAttribute("BillToAddr");
                    Object billingDate = getCurrentDateForPayload();
                    Object comments = "Property Lease Module";
                    Object ruleStartDate =
                        currRow.getAttribute("LeaseStartDate");
                    //                    Object trxDate = getCurrentDateForPayload(); //JAN-8 commented bcoz logic change
                    Object trxDate = ruleStartDate;
                    Object currencyCode = "AED";
                    Object description = "Property Lease Module";
//                    Object glDate = getCurrentDateForPayload(); //JAN-8 commented bcoz logic change
                    JSFUtils.addFacesInformationMessage("===Lease Start Date==" +
                                                        ruleStartDate);
                    Object glDate = invokeReport(ruleStartDate.toString());
                    JSFUtils.addFacesInformationMessage("===Output from BI Report==" +
                                                        glDate);
                    Object ruleEndDate =
                        currRow.getAttribute("LeaseEndDate");
                    //Lease End Date
                    Object glFromBookingDtl="";
                    RowSetIterator bookingDtRS = BookingDtlVO1.createRowSetIterator(null);
                    while (bookingDtRS.hasNext()) {
                        Row bkdlR = bookingDtRS.next();
                    bkdlR.setAttribute("GlDate", glDate);
                    glFromBookingDtl = bkdlR.getAttribute("GlDate");
                    }
                    bookingDtRS.closeRowSetIterator();
                    JSFUtils.addFacesInformationMessage("===GL Date From DB==" +
                                                        glFromBookingDtl);
                    //*****JAN-8 commented bcoz logic changes*****//
                    //                    Date gld =
                    //                        new SimpleDateFormat("yyyy-MM-dd").parse(glDate.toString());
                    //                    Date lsd =
                    //                        new SimpleDateFormat("yyyy-MM-dd").parse(ruleStartDate.toString());
                    //                    if (lsd.after(gld)) {
                    //                        glDate = ruleStartDate;
                    //                    }
                    Object unitSellingPrice =
                        currRow.getAttribute("BaseRate");
                    Object lineType = "LINE";
                    Object quantity = "1";
                    Object paymentTermsName = "IMMEDIATE";
                    Object taxCode = getTaxCodeFromLookup(taxValue);
                    Object flexContext = "Property_Leasing";
                    Object leaseNumber =
                        currRow.getAttribute("LeaseNumber");
                    Object bookingNumber =
                        currRow.getAttribute("BookingNumber");
                    Object dynamicInsertion = "Y";
                    Object segmentedCode = null;
                    Object enabledFlag = "true";
                    Object fromDate = getCurrentDateForPayload();
                    Object toDate = getCurrentDateForPayload();
                    Object environment = null;
                    Object ledgerName = null;
                    Object accountClass = null;
                    Object invoicingRuleName = null;
                    Object batchSourceName = null;
                    Object customerTrxTypeName = null;
                    Object codeCombinationId = null;
                    Object accountingRuleName = null;
                    Object revAccountId = null;
                    Object unitName = currRow.getAttribute("UnitName");
                    Object buildingName = currRow.getAttribute("BuildName");
//                    Object noOfYears = invoiceInterfaceValueVO.first().getAttribute("NoOfYears");
                    if (orgId == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("==Business Unit is Required==");
                    }
//                    if (noOfYears == null) {
//                        validationFlag = "N";
//                        JSFUtils.addFacesErrorMessage("==No Of Tenant Years is Required==");
//                    }
                    if (unitName == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("==Unit Name is Required==");
                    }
                    if (buildingName == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("==Building Name is Required==");
                        
                    } else {
                        System.err.println("Lease Type--" +
                                           currRow.getAttribute("LeaseType"));
                        if (currRow.getAttribute("LeaseType") !=
                            null) {
                            if (currRow.getAttribute("LeaseType").toString().equalsIgnoreCase("DEFAULT")) {
                                Map<String, Object> arSetupMap = null;
                                arSetupMap =
                                        getArSetupDetails(orgId.toString(),
                                                          "LOU");
                                environment = arSetupMap.get("environment");
                                ledgerName = arSetupMap.get("ledgerName");
                                accountClass = arSetupMap.get("accountClass");
                                invoicingRuleName =
                                        arSetupMap.get("invoicingRuleName");
                                batchSourceName =
                                        arSetupMap.get("batchSourceName");
                                customerTrxTypeName =
                                        arSetupMap.get("customerTrxTypeName");
                                codeCombinationId =
                                        arSetupMap.get("codeCombinationId");
                                accountingRuleName =
                                        arSetupMap.get("accountingRuleName");

                                revAccountId = arSetupMap.get("revAccountId");

//                                System.err.println("Exit in to the Ar Setup table");

                            }
                            if (currRow.getAttribute("LeaseType").toString().equalsIgnoreCase("CAR_PARKING")) {
                                Map<String, Object> arSetupMap = null;
                                System.err.println("Enter in to the loop car parking");
                                arSetupMap =
                                        getArSetupDetails(orgId.toString(),
                                                          "CP");
                                getLeaseType = "CAR_PARKING";
                                getTrxnsType =
                                        arSetupMap.get("customerTrxTypeName") ==
                                        null ? "N" :
                                        arSetupMap.get("customerTrxTypeName").toString();

                                environment = arSetupMap.get("environment");
                                ledgerName = arSetupMap.get("ledgerName");
                                accountClass = arSetupMap.get("accountClass");
                                invoicingRuleName =
                                        arSetupMap.get("invoicingRuleName");
                                batchSourceName =
                                        arSetupMap.get("batchSourceName");
                                customerTrxTypeName =
                                        arSetupMap.get("customerTrxTypeName");
                                codeCombinationId =
                                        arSetupMap.get("codeCombinationId");
                                accountingRuleName =
                                        arSetupMap.get("accountingRuleName");
                                revAccountId = arSetupMap.get("revAccountId");
                                System.err.println("Exit in to the loop car parking");
                            }
                        }
                    }

                    //                    System.err.println("==Business Unit=="+orgId);
                    //                    System.err.println("==amount=="+amount);
                    //                    System.err.println("==batchSourceName=="+batchSourceName);
                    //                    System.err.println("==customerTrxTypeName=="+customerTrxTypeName);
                    //                    System.err.println("==billCustomerAccountNumber=="+billCustomerAccountNumber);
                    //                    System.err.println("==billCustomerSiteNumber=="+billCustomerSiteNumber);
                    //                    System.err.println("==billingDate=="+billingDate);
                    //                    System.err.println("==comments=="+comments);
                    //                    System.err.println("==trxDate=="+trxDate);
                    //                    System.err.println("==currencyCode=="+currencyCode);
                    //                    System.err.println("==description=="+description);
                    //                    System.err.println("==glDate=="+glDate);
                    //                    System.err.println("==invoicingRuleName=="+invoicingRuleName);
                    //                    System.err.println("==accountingRuleName=="+accountingRuleName);
                    //                    System.err.println("==ruleEndDate=="+ruleEndDate);
                    //                    System.err.println("==ruleStartDate=="+ruleStartDate);
                    //                    System.err.println("==unitSellingPrice=="+unitSellingPrice);
                    //                    System.err.println("==lineType=="+lineType);
                    //                    System.err.println("==quantity=="+quantity);
                    //                    System.err.println("==paymentTermsName=="+paymentTermsName);
                    //                    System.err.println("==taxCode=="+taxCode);
                    //                    System.err.println("==flexContext=="+flexContext);
                    //                    System.err.println("==leaseNumber=="+leaseNumber);
                    //                    System.err.println("==bookingNumber=="+bookingNumber);
                    //                    System.err.println("==accountClass=="+accountClass);
                    //                    System.err.println("==dynamicInsertion=="+dynamicInsertion);
                    //                    System.err.println("==segmentedCode=="+segmentedCode);
                    //                    System.err.println("==ledgerName=="+ledgerName);
                    //                    System.err.println("==enabledFlag=="+enabledFlag);
                    //                    System.err.println("==fromDate=="+fromDate);
                    //                    System.err.println("==toDate=="+toDate);
                    if (orgId == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Business Unit is Required");
                    } else {
                        if (unitId != null)
                            segmentedCode =
                                    getCodeCombination(orgId.toString(), "LOU",
                                                       unitId.toString());
                    }

                    //validation added 27-SEPT-2018

                    //                    if (orgId == null) {
                    //                        validationFlag = "N";
                    //                        JSFUtils.addFacesErrorMessage("Business Unit is Required");
                    //                    }
                    //

                    //

                    if (amount == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Amount is Required");

                    }

                    if (batchSourceName == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Batch Source Name is Required");

                    }

                    if (customerTrxTypeName == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Customer Transaction Type Name Unit is Required");

                    }
                    if (billCustomerAccountNumber == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Bill Customer AccountNumber Unit is Required");

                    }
                    if (billCustomerSiteNumber == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Bill Customer Site Number is Required");

                    }

                    if (billingDate == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Billing Date is Required");
                    }


                    if (comments == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("comments is Required");
                    }

                    if (trxDate == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("trxDate is Required");
                    }


                    if (currencyCode == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("currencyCode is Required");
                    }


                    if (description == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("description is Required");
                    }


                    //glDate

                    if (glDate == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("GL Date is Required");
                    }


                    if (invoicingRuleName == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Invoicing Rule Name is Required");
                    }


                    if (accountingRuleName == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Accounting Rule Name is Required");

                    }

                    if (ruleEndDate == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Rule End Date is Required");
                    }

                    if (ruleStartDate == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Rule Start Date is Required");

                    }

                    if (unitSellingPrice == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Unit Selling Price is Required");

                    }
                    if (lineType == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("LineType is Required");

                    }
                    if (quantity == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Quantity is Required");

                    }
                    if (paymentTermsName == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Payment Terms Name is Required");

                    }
                    if (taxCode == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Tax Code is Required");

                    }
                    if (flexContext == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Flex Context is Required");

                    }
                    if (leaseNumber == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Lease Number is Required");

                    }
                    if (bookingNumber == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Booking Number is Required");

                    }
                    if (accountClass == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Account Class is Required");

                    }
                    if (dynamicInsertion == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Dynamic Insertion is Required");

                    }
                    if (segmentedCode == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Segmented Code is Required");

                    }
                    if (ledgerName == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Ledger Name is Required");

                    }
                    if (enabledFlag == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Enabled Flag is Required");

                    }
                    if (fromDate == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("From Date is Required");

                    }

                    if (toDate == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("To Date is Required");

                    }
                    if (validationFlag == "Y") {
                        JSONObject obj = new JSONObject();
                        obj.put("orgId", orgId.toString());
                        obj.put("unitName", unitName);
                        obj.put("buildingName", buildingName);
//                        obj.put("tenantYears", noOfYears.toString());
                        obj.put("amount", amount.toString());
                        obj.put("batchSourceName", batchSourceName.toString());
                        obj.put("customerTrxTypeName",
                                customerTrxTypeName.toString());
                        obj.put("billCustomerAccountNumber",
                                billCustomerAccountNumber.toString());
                        obj.put("billCustomerSiteNumber",
                                billCustomerSiteNumber.toString());
                        obj.put("billingDate", billingDate.toString());
                        obj.put("comments", comments.toString());
                        obj.put("trxDate", trxDate.toString());
                        obj.put("currencyCode", currencyCode.toString());
                        obj.put("description", description.toString());
                        obj.put("glDate", glFromBookingDtl.toString());
                        //                        obj.put("glDate", cutOffDate);
                        obj.put("invoicingRuleName",
                                invoicingRuleName.toString());
                        obj.put("accountingRuleName",
                                accountingRuleName.toString());
                        obj.put("ruleEndDate", ruleEndDate.toString());
                        obj.put("ruleStartDate", ruleStartDate.toString());
                        obj.put("unitSellingPrice",
                                unitSellingPrice.toString());
                        obj.put("lineType", lineType.toString());
                        obj.put("quantity", quantity.toString());
                        obj.put("paymentTermsName",
                                paymentTermsName.toString());
                        obj.put("taxCode", taxCode.toString());
                        obj.put("flexContext", flexContext.toString());
                        obj.put("leaseNumber", leaseNumber.toString());
                        obj.put("bookingNumber", bookingNumber.toString());
                        obj.put("accountClass", accountClass.toString());
                        obj.put("dynamicInsertion",
                                dynamicInsertion.toString());
                        obj.put("segmentedCode", segmentedCode.toString());
                        obj.put("ledgerName", ledgerName.toString());
                        obj.put("enabledFlag", enabledFlag.toString());
                        obj.put("fromDate", fromDate.toString());
                        obj.put("toDate", toDate.toString());
                        obj.put("environment", environment.toString());
                        obj.put("transactions", transactionValue + "");
                        obj.put("ccId", revAccountId);
                        obj.put("cancellationNo", "null");


                        JSFUtils.addFacesInformationMessage("Invoice Actual JSON Object" +
                                                            obj.toString());
                        System.out.println("Invoice Actual JSON Object" +
                                           obj.toString());
                        OkHttpClient client = new OkHttpClient();
                        MediaType mediaType =
                            MediaType.parse("application/json");
                        RequestBody body =
                            RequestBody.create(mediaType, obj.toJSONString());
                        Request request =
                            new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body).addHeader("Content-Type",
                                                                                                                                                       "application/json").addHeader("Cache-Control",
                                                                                                                                                                                     "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                       "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                        //test instance
//                        Request request =
//                            new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body).addHeader("Content-Type",
//                                                                                                                                                       "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                     "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                           "493ffe37-eaac-45fc-9962-8c6883aff73e").build();

                        Response response = client.newCall(request).execute();

                        JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                            response);
                        InputStream isr = response.body().byteStream();
                        BufferedReader reader =
                            new BufferedReader(new InputStreamReader(isr));
                        StringBuilder out = new StringBuilder();
                        String resultsXml;

                        while ((resultsXml = reader.readLine()) != null) {
                            out.append(resultsXml);
                        }

                        JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                            out.toString());
                        String responseOut = out.toString();
                        if (responseOut != null){
//                        responseOut.contains("{\"result\":\"Success\"}");
                        leaseVO.getCurrentRow().setAttribute("IntegrationResponse", responseOut);
                        ADFUtils.findOperation("Commit").execute();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(generate_invoice_cb15);
                        }
                        System.out.println("Invoice Response in json" +
                                           out.toString());
                        transactionValue++;

                        String getDiscountValue = currRow.getAttribute("DiscAmt")==null ? "0.00" : currRow.getAttribute("DiscAmt").toString();

                        if ((!getDiscountValue.equalsIgnoreCase("0.00")) && (!getDiscountValue.equalsIgnoreCase("0"))) {

                            Map<String, Object> arSetupMap = null;
                            arSetupMap =
                                    getArSetupDetails(orgId.toString(), "DSNT");
                            environment = arSetupMap.get("environment");
                            ledgerName = arSetupMap.get("ledgerName");
                            accountClass = arSetupMap.get("accountClass");
                            invoicingRuleName =
                                    arSetupMap.get("invoicingRuleName");
                            batchSourceName =
                                    arSetupMap.get("batchSourceName");

                            if (getLeaseType.equalsIgnoreCase("CAR_PARKING")) {
                                customerTrxTypeName = getTrxnsType;
                            } else {
                                customerTrxTypeName =
                                        arSetupMap.get("customerTrxTypeName");
                            }
                            codeCombinationId =
                                    arSetupMap.get("codeCombinationId");
                            accountingRuleName =
                                    arSetupMap.get("accountingRuleName");
                            revAccountId = arSetupMap.get("revAccountId");
                            if (!arSetupMap.isEmpty()) {


                                JSFUtils.addFacesInformationMessage("Inside Discount");
                                JSONObject invoicediscountObj =
                                    new JSONObject();
                                invoicediscountObj.put("orgId",
                                                       orgId.toString());
                                invoicediscountObj.put("unitName", unitName);
                                invoicediscountObj.put("buildingName", buildingName);
//                                invoicediscountObj.put("tenantYears", noOfYears.toString());
                                invoicediscountObj.put("amount", "-" + getDiscountValue);
//                                                       "-" + getDiscountValue.toString());
                                invoicediscountObj.put("batchSourceName",
                                                       batchSourceName.toString());
                                invoicediscountObj.put("customerTrxTypeName",
                                                       customerTrxTypeName.toString());
                                invoicediscountObj.put("billCustomerAccountNumber",
                                                       billCustomerAccountNumber.toString());
                                invoicediscountObj.put("billCustomerSiteNumber",
                                                       billCustomerSiteNumber.toString());
                                invoicediscountObj.put("billingDate",
                                                       billingDate.toString());
                                invoicediscountObj.put("comments",
                                                       comments.toString());
                                invoicediscountObj.put("trxDate",
                                                       trxDate.toString());
                                invoicediscountObj.put("currencyCode",
                                                       currencyCode.toString());
                                invoicediscountObj.put("description",
                                                       description.toString());
                                invoicediscountObj.put("glDate",
                                                       glFromBookingDtl.toString());
                                invoicediscountObj.put("invoicingRuleName",
                                                       invoicingRuleName.toString());
                                invoicediscountObj.put("accountingRuleName",
                                                       accountingRuleName.toString());
                                invoicediscountObj.put("ruleEndDate",
                                                       ruleEndDate.toString());
                                invoicediscountObj.put("ruleStartDate",
                                                       ruleStartDate.toString());
                                invoicediscountObj.put("unitSellingPrice", "-" + getDiscountValue);
//                                                       "-" +
//                                                       getDiscountValue.toString());
                                invoicediscountObj.put("lineType",
                                                       lineType.toString());
                                invoicediscountObj.put("quantity",
                                                       quantity.toString());
                                invoicediscountObj.put("paymentTermsName",
                                                       paymentTermsName.toString());
                                invoicediscountObj.put("taxCode",
                                                       taxCode.toString());
                                invoicediscountObj.put("flexContext",
                                                       flexContext.toString());
                                invoicediscountObj.put("leaseNumber",
                                                       leaseNumber.toString());
                                invoicediscountObj.put("bookingNumber",
                                                       bookingNumber.toString());
                                invoicediscountObj.put("accountClass",
                                                       accountClass.toString());
                                invoicediscountObj.put("dynamicInsertion",
                                                       dynamicInsertion.toString());
                                invoicediscountObj.put("segmentedCode",
                                                       segmentedCode.toString());
                                invoicediscountObj.put("ledgerName",
                                                       ledgerName.toString());
                                invoicediscountObj.put("enabledFlag",
                                                       enabledFlag.toString());
                                invoicediscountObj.put("fromDate",
                                                       fromDate.toString());
                                invoicediscountObj.put("toDate",
                                                       toDate.toString());
                                invoicediscountObj.put("environment",
                                                       environment.toString());
                                invoicediscountObj.put("transactions",
                                                       transactionValue + "");
                                invoicediscountObj.put("ccId", revAccountId);
                                invoicediscountObj.put("cancellationNo", "null");

                                JSFUtils.addFacesInformationMessage("Invoice Discount JSON Object" +
                                                                    invoicediscountObj.toString());

                                OkHttpClient discountClient =
                                    new OkHttpClient();
                                MediaType dicountMediaType =
                                    MediaType.parse("application/json");
                                RequestBody discountBody =
                                    RequestBody.create(dicountMediaType,
                                                       invoicediscountObj.toJSONString());
                                Request discountRequest =
                                    new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(discountBody).addHeader("Content-Type",
                                                                                                                                                                       "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                     "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                           "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                           //test instance
//                                Request discountRequest =
//                                    new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(discountBody).addHeader("Content-Type",
//                                                                                                                                                                       "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                                     "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                                           "493ffe37-eaac-45fc-9962-8c6883aff73e").build();

                                Response discountResponse =
                                    discountClient.newCall(discountRequest).execute();
                                JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                    discountResponse);
                                InputStream isrDiscount =
                                    discountResponse.body().byteStream();
                                BufferedReader readerDiscount =
                                    new BufferedReader(new InputStreamReader(isrDiscount));
                                StringBuilder outDiscount =
                                    new StringBuilder();
                                String resultsXmlDiscount;
                                while ((resultsXmlDiscount =
                                        readerDiscount.readLine()) != null) {
                                    outDiscount.append(resultsXmlDiscount);
                                }

                                JSFUtils.addFacesInformationMessage("Invoice Response in JSON" +
                                                                    outDiscount.toString());
                            }
                            transactionValue++;
                        } else {
                            //                            JSFUtils.addFacesInformationMessage("Please check the AR Setup details...");
                            JSFUtils.addFacesInformationMessage("No Discount...");
                        }

                    }

//                }
            } // first while loop

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error in invoicePayload" + e);
        }
    }


    /* This method is used to call the DB package for fetching the code combination */

    public Object getCodeCombination(String pBusinessUnitId,
                                     String pChargeType, String pUnitId) {
        Object returnResult = null;
        try {
            BindingContainer bindings =
                BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding operation =
                bindings.getOperationBinding("getCodeSegmentCombination");
            System.err.println("pBusinessUnitId" + pBusinessUnitId);
            System.err.println("pChargeType" + pChargeType);
            System.err.println("pUnitId" + pUnitId);

            JSFUtils.setExpressionValue("#{pageFlowScope.pChargeType}",
                                        pChargeType);
            JSFUtils.setExpressionValue("#{pageFlowScope.pBusinessUnitId}",
                                        pBusinessUnitId);
            JSFUtils.setExpressionValue("#{pageFlowScope.pUnitId}", pUnitId);

            //            Object unitId = pUnitId;
            //            Map map = new HashMap();
            //            map.put("pBusinessUnitId", bid.toString());
            //            map.put("pChargeType", chargeType.toString());
            //            map.put("pUnitId", unitId.toString());
            //            operation.getParamsMap().putAll(map);
            returnResult = operation.execute();

            //            operation.getParamsMap().put("pBusinessUnitId", bid.toString());
            //            operation.getParamsMap().put("pChargeType", chargeType.toString());
            //            operation.getParamsMap().put("pUnitId", unitId.toString());
            returnResult = operation.execute();
        } catch (Exception e) {
            System.err.println("e" + e.toString());
            JSFUtils.addFacesInformationMessage("Error in getCCMethod" + e);
        }
        return returnResult;
    }

    /* This method will return the Tax code for Lookup */

    public Object getTaxCodeFromLookup(Object p_TaxVal) {
        Object taxCode = null;
        try {
            ViewObject taxCodeVO =
                ADFUtils.findIterator("getTaxCodeROVO1Iterator").getViewObject();
            taxCodeVO.setNamedWhereClauseParam("p_TaxVal", p_TaxVal);
            taxCodeVO.executeQuery();
            if (taxCodeVO.first() != null) {
                taxCode =
                        taxCodeVO.first().getAttribute("LookupValueNameDisp") ==
                        null ? "ZR 0%" :
                        taxCodeVO.first().getAttribute("LookupValueNameDisp").toString();
            }
        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error in TaxCode" + e);
        }
        return taxCode;
    }

    /* This method will retirn the lease discount amount */

    public String getDiscountAmt(Object offerid, Object unitid,
                                 Object baseRate) {
        BigDecimal ResultVal = new BigDecimal(0);
        String returnVal = "0";
        try {
            ViewCriteria vc = OfferDetailVo1.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("OfferHdrId", offerid);
            vcRow.setAttribute("UnitId", unitid);
            vc.addRow(vcRow);
            OfferDetailVo1.applyViewCriteria(vc);
            OfferDetailVo1.executeQuery();
            if (OfferDetailVo1.first() != null) {
                System.err.println("OfferDetailVo1.first()" +
                                   OfferDetailVo1.first().getAttribute("DiscountAmount"));
                ViewObject vo =
                    ADFUtils.findIterator("DiscountsROVO1Iterator").getViewObject();

                vo.setNamedWhereClauseParam("D_ID",
                                            OfferDetailVo1.first().getAttribute("DiscountAmount"));
                vo.executeQuery();
                Row re = vo.first();
                if (vo.getEstimatedRowCount() > 0) {
                    String OfferAmnt =
                        baseRate == null ? "0" : baseRate.toString();
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
                                (DisValue.multiply(OfrAmnt)).divide(TotalPercentage);
                        returnVal = ResultVal.toString();
                    }
                    if (DiscountType.equals("CASH")) {
                        ResultVal = DisValue;
                        returnVal = ResultVal.toString();
                    }
                }
            }
        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error in Discount" + e);
        }
        System.err.println("DISCOUNT AMT--" + returnVal);
        return returnVal;
    }

    /* This method is used to apply the receipt in AR using invoice details */

    public void arReceiptApplyPayload(ActionEvent actionEvent) {
        try {
            String validationFlag = "Y";
            Object amountApplied = null;
            Object comments = "Receipt Applied from Property Lease";
            Object customerTrxId = null;
            Object receipt_Number = null;
            Object receiptAmount = null;
            Object receipt_Date = null;
            Object transactionDate = null;
            Object accountingDate = null;
            Object applicationDate = null;
            Object currencyCode = "AED";
            Object cashRecieptId = null;
            Object environment = "prod";
            Object invoiceDateLS = null;
            //            transactionDate = getCurrentDateForPayload();
            //            accountingDate = getCurrentDateForPayload();
            //            applicationDate = getCurrentDateForPayload();
            transactionDate = null; //Changed on Dec-10-18
            accountingDate = null; //Changed on Dec-10-18
            applicationDate = null; //Changed on Dec-10-18

            ViewObject receiptVO =
                ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
            Row currRow = receiptVO.getCurrentRow();
            ViewObject BookingDtlVO1 =
                ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
            ViewObject leaseAgreemntVo =
                ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
            Row leaseRow = leaseAgreemntVo.getCurrentRow();

            amountApplied = currRow.getAttribute("RecommendedAmount");
            customerTrxId =
                    BookingDtlVO1.getCurrentRow().getAttribute("CustomerTrxnId");
            receipt_Number = currRow.getAttribute("ReceiptNumber");
            receiptAmount = currRow.getAttribute("RecommendedAmount");
            receipt_Date = currRow.getAttribute("ReceiptDate");
            cashRecieptId = currRow.getAttribute("Attribute1");

            invoiceDateLS = leaseRow.getAttribute("LeaseStartDate"); //Jan-8


            /**************Date validation for Integration on JAN 8*********************************/


            Date invoiceDate =
                new SimpleDateFormat("yyyy-MM-dd").parse(invoiceDateLS.toString());
            Date recDate =
                new SimpleDateFormat("yyyy-MM-dd").parse(receipt_Date.toString());
            if (invoiceDate.after(recDate)) {
                transactionDate = invoiceDate;
                accountingDate = invoiceDate;
                JSFUtils.addFacesInformationMessage("== IF block Accounting Date==" +
                                                    accountingDate);
                applicationDate = invoiceDate;
            } else if (invoiceDate.before(recDate)) {
                transactionDate = recDate;
                accountingDate = recDate;
                JSFUtils.addFacesInformationMessage("==ELSE IF Accounting Date==" +
                                                    accountingDate);
                applicationDate = recDate;
            } else {
                transactionDate = recDate;
                accountingDate = recDate;
                JSFUtils.addFacesInformationMessage("==ELSE Accounting Date==" +
                                                    accountingDate);
                applicationDate = recDate;
            }


            if (amountApplied == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Amount Applied is Required");
            }
            if (customerTrxId == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Customer Transaction Id is Required");
            }
            if (receipt_Number == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Receipt Number is Required");
            }
            if (receiptAmount == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Receipt Amount is Required");

            }
            if (receipt_Date == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Receipt Date is Required");

            }
            if (transactionDate == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Transaction Date is Required");

            }
            if (accountingDate == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Accounting Date is Required");

            }
            if (cashRecieptId == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Cash Reciept Id is Required");

            }
            if (validationFlag == "Y") {
                JSONObject obj = new JSONObject();

                obj.put("amountApplied", amountApplied.toString());
                obj.put("comments", comments.toString());
                obj.put("customerTrxId", customerTrxId.toString());
                obj.put("receipt_Number", receipt_Number.toString());
                obj.put("receiptAmount", receiptAmount.toString());
                obj.put("receipt_Date", receipt_Date.toString());

                /*****************Transaction Date**********/
                SimpleDateFormat dateFormatTrx =
                    new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                Date dateTrx = dateFormatTrx.parse(transactionDate.toString());
                SimpleDateFormat simpleDateFormatTrx =
                    new SimpleDateFormat("yyyy-MM-dd");
                transactionDate = simpleDateFormatTrx.format(dateTrx);
                JSFUtils.addFacesInformationMessage("==Transaction date==" +
                                                    transactionDate);
                obj.put("transactionDate",
                        transactionDate.toString()); //Included on Jan-09-19
                //GL Validation
                //                accountingDate =
                //                    new SimpleDateFormat("yyyy-MM-dd").parse(accountingDate.toString());

                /*****************Accounting Date**********/
                SimpleDateFormat dateFormat =
                    new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                Date date = dateFormat.parse(accountingDate.toString());
                SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("yyyy-MM-dd");
                accountingDate = simpleDateFormat.format(date);
                JSFUtils.addFacesInformationMessage("==Accounting date==" +
                                                    accountingDate);
                String glDateValidation =
                    invokeReport(accountingDate.toString());
                obj.put("accountingDate",
                        glDateValidation); //Included on Jan-09-19

                /*****************Application Date**********/
                SimpleDateFormat dateFormatApplication =
                    new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                Date dateApp =
                    dateFormatApplication.parse(applicationDate.toString());
                SimpleDateFormat simpleDateFormatApp =
                    new SimpleDateFormat("yyyy-MM-dd");
                applicationDate = simpleDateFormatApp.format(dateApp);
                JSFUtils.addFacesInformationMessage("==Application date==" +
                                                    applicationDate);

                obj.put("applicationDate",
                        applicationDate.toString()); //Jan-09-19
                obj.put("currencyCode", currencyCode.toString());
                obj.put("cashRecieptId", cashRecieptId.toString());
                obj.put("environment", environment.toString());

                JSFUtils.addFacesInformationMessage("JSON Object" +
                                                    obj.toString());
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body =
                    RequestBody.create(mediaType, obj.toJSONString());
                Request request =
                    new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/receipt/apply/v1").post(body).addHeader("Content-Type",
                                                                                                                                             "application/json").addHeader("Cache-Control",
                                                                                                                                                                           "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                 "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
         //test instance
//                Request request =
//                    new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/receipt/apply/v1").post(body).addHeader("Content-Type",
//                                                                                                                                             "application/json").addHeader("Cache-Control",
//                                                                                                                                                                           "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                 "493ffe37-eaac-45fc-9962-8c6883aff73e").build();

                Response response = client.newCall(request).execute();
                JSFUtils.addFacesInformationMessage("Receipt Apply response Payload" +
                                                    response);
                InputStream isr = response.body().byteStream();
                BufferedReader reader =
                    new BufferedReader(new InputStreamReader(isr));
                StringBuilder out = new StringBuilder();
                String resultsXml;

                while ((resultsXml = reader.readLine()) != null) {
                    out.append(resultsXml);
                }
                JSFUtils.addFacesInformationMessage("Receipt Apply Response in JSON" +
                                                    out.toString());
            }
        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error in Receipt Apply--" +
                                                e);
        }
    }

    /* This method is used to create the receipt in AR */

    public void arReceiptCreatePayload(ActionEvent actionEvent) {
        String validationFlag = "Y";
        try {
            Object amount = null;
            Object currencyCode = "AED";
            //            Object glDate = getCurrentDateForPayload();
            //            Object maturityDate = getCurrentDateForPayload();
            Object maturityDateSys = getCurrentDateForPayload();
            //            Object maturityDate = null;
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
            Object chequeEffectiveDate = null;
            Object chequeNo = null;
            Object comments = null;
            Object environment = "prod";

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
                    receiptVO.getCurrentRow().getAttribute("Description")==null?" "
                    :receiptVO.getCurrentRow().getAttribute("Description");

                ViewObject leaseVO =
                    ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
                Object bookingId =
                    leaseVO.getCurrentRow().getAttribute("BookingId");
                Object leaseId =
                    leaseVO.getCurrentRow().getAttribute("LeaseAgreementId");
                ViewObject invoiceInterfaceValueVO =
                    ADFUtils.findIterator("getReceiptPayloadDtls_ROVO1Iterator").getViewObject();
                invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_BOOKING_ID",
                                                                 bookingId);
                invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_LEASE_ID",
                                                                 leaseId);
                invoiceInterfaceValueVO.executeQuery();
                if (invoiceInterfaceValueVO.first() != null) {
                    orgId =
                            invoiceInterfaceValueVO.first().getAttribute("OrgId");
                    bookingNumber =
                            invoiceInterfaceValueVO.first().getAttribute("BookingNumber");
                    leaseNumber =
                            invoiceInterfaceValueVO.first().getAttribute("LeaseNumber");
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

                //                if (chequeEffectiveDate == null) {
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
                if (leaseNumber == null) {
                    validationFlag = "N";
                    JSFUtils.addFacesErrorMessage("Lease Number is Required");
                }
                if (bookingNumber == null) {
                    validationFlag = "N";
                    JSFUtils.addFacesErrorMessage("Booking Number is Required");
                }
            }


            if (validationFlag == "Y") {
                JSONObject obj = new JSONObject();

//                System.out.println("==amount==" + amount);
//                System.out.println("==maturityDate==" + chequeEffectiveDate);
//                System.out.println("==receiptDate==" + receiptDate);
//                System.out.println("==receiptNumber==" + receiptNumber);
//                System.out.println("==chequeNo==" + chequeNo);

                obj.put("amount", amount.toString());
                obj.put("currencyCode", currencyCode.toString());
                obj.put("comments", comments.toString());
                obj.put("glDate", receiptDate.toString());
                if (chequeEffectiveDate != null) {
                    obj.put("maturityDate", chequeEffectiveDate.toString());
                } else {
                    obj.put("maturityDate", receiptDate.toString());
                }
                obj.put("orgId", orgId.toString());
                obj.put("customerId", customerId.toString());
                obj.put("receiptDate", receiptDate.toString());
                obj.put("receiptMethodId", receiptMethodId.toString());
//                if (chequeNo == null) {
//                    obj.put("receiptNumber", receiptNumber.toString());
//                } else {
//                    obj.put("receiptNumber", chequeNo.toString());
//                }
                 if (chequeNo != null) {
                    obj.put("chequeNo", chequeNo.toString());
                } 
                obj.put("receiptNumber", receiptNumber.toString());
                obj.put("leaseNumber", leaseNumber.toString());
                obj.put("bookingNumber", bookingNumber.toString());
                obj.put("building", building);
                obj.put("unit", unit);
                obj.put("environment", environment.toString());

                JSFUtils.addFacesInformationMessage("Receipt Create JSON Payload" +
                                                    obj.toString());
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
                JSFUtils.addFacesInformationMessage("Receipt Create JSON Payload Response" +
                                                    response);
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
    /* This method is used to get the AR setup details for interface invoice and distribution payloads */

    public Map<String, Object> getArSetupDetails(String p_orgdId,
                                                 String p_chargeType) {
        Map<String, Object> arSetupMap = null;

        arSetupMap = new HashMap<String, Object>();
        ViewObject arSetupVO =
            ADFUtils.findIterator("getARSetupDetails_ROVO1Iterator").getViewObject();
        //        ViewCriteriaManager vcm = arSetupVO.getViewCriteriaManager();
        //        ViewCriteria vc = vcm.getViewCriteria("findByChargeTypeAndOrg");
        //        VariableValueManager vvm = vc.ensureVariableManager();
        //        vvm.setVariableValue("p_Org", p_orgdId);
        //        vvm.setVariableValue("p_ChargeType", p_chargeType);
        //        arSetupVO.applyViewCriteria(vc);
        arSetupVO.setNamedWhereClauseParam("p_Org", p_orgdId);
        arSetupVO.setNamedWhereClauseParam("p_ChargeType", p_chargeType);
        System.err.println("Org ID " + p_orgdId + "Charge ID " + p_chargeType);
        arSetupVO.executeQuery();
        if (arSetupVO.first() != null) {
            arSetupMap.put("customerTrxTypeName",
                           arSetupVO.first().getAttribute("TxnType"));
            arSetupMap.put("batchSourceName",
                           arSetupVO.first().getAttribute("TxnSource"));
            arSetupMap.put("codeCombinationId",
                           arSetupVO.first().getAttribute("RevAccountId"));
            arSetupMap.put("accountingRuleName",
                           arSetupVO.first().getAttribute("AccountingRuleName"));
            arSetupMap.put("invoicingRuleName",
                           arSetupVO.first().getAttribute("InvoicingRule"));
            arSetupMap.put("ledgerName",
                           arSetupVO.first().getAttribute("LedgerName"));
            arSetupMap.put("environment",
                           arSetupVO.first().getAttribute("Environment"));
            arSetupMap.put("accountClass",
                           arSetupVO.first().getAttribute("AccountClass"));
            arSetupMap.put("revAccountId",
                           arSetupVO.first().getAttribute("RevAccountId"));
        } else {
            JSFUtils.addFacesErrorMessage("Please define the AR Setup details");

        }
        return arSetupMap;
    }

    public String testMethod() {
        Map<String, Object> arSetupMap =
            getArSetupDetails("300000001181195", "DSNT");

        JSFUtils.addFacesInformationMessage("customerTrxTypeName" +
                                            arSetupMap.get("customerTrxTypeName"));

        JSFUtils.addFacesInformationMessage("batchSourceName" +
                                            arSetupMap.get("batchSourceName"));

        JSFUtils.addFacesInformationMessage("codeCombinationId" +
                                            arSetupMap.get("codeCombinationId"));

        JSFUtils.addFacesInformationMessage("invoicingRuleName" +
                                            arSetupMap.get("invoicingRuleName"));

        JSFUtils.addFacesInformationMessage("ledgerName" +
                                            arSetupMap.get("ledgerName"));

        JSFUtils.addFacesInformationMessage("environment" +
                                            arSetupMap.get("environment"));

        JSFUtils.addFacesInformationMessage("AccountingRuleName" +
                                            arSetupMap.get("accountingRuleName"));


        return null;
    }


    public synchronized String invokeReport(String glDate) throws IOException,
                                                                  ParserConfigurationException,
                                                                  SAXException,
                                                                  Exception {

        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder1 = new OkHttpClient.Builder();
        builder1.connectTimeout(30, TimeUnit.SECONDS);
        builder1.readTimeout(30, TimeUnit.SECONDS);
        builder1.writeTimeout(30, TimeUnit.SECONDS);
        client = builder1.build();
        MediaType mediaType = MediaType.parse("text/xml");
        String xmlInput = getPayload(glDate);
        RequestBody body = RequestBody.create(mediaType, xmlInput);
        //                System.out.println("Request Payload ----> " + xmlInput);
        JSFUtils.addFacesInformationMessage("==Request to Report==" +
                                            xmlInput);
        String error = null;
        String cutOffDate = null;
        Request request =
            new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com/xmlpserver/services/PublicReportService").post(body).addHeader("content-type",
                                                                                                                                          "text/xml").addHeader("cache-control",
                                                                                                                                                                "no-cache").addHeader("SOAPAction",
                                                                                                                                                                                      "").build();
        try {

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
            if (responseCode > 200) {
                String fault = null;

                if (out.toString().contains(";TEXT&gt;")) {
                    fault = getFaultString(out.toString());
                } else {
                    DocumentBuilder builder =
                        DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    InputSource src = new InputSource();
                    src.setCharacterStream(new StringReader(out.toString()));
                    Document doc = builder.parse(src);
                    //                    System.err.println("Error Response----> " +
                    //                                       out.toString());
                    fault =
                            doc.getElementsByTagName("faultstring").item(0).getTextContent();
                }
                JSFUtils.addFacesInformationMessage("==Error Reponse form Report==" +
                                                    fault);
                return fault;

            } else {

                String reportResponse = getResponseAsString(out.toString());
                //                System.out.println("Report Reponse : " + reportResponse);
                //                DocumentBuilder db;
                //                db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                //                InputSource is = new InputSource();
                //                is.setCharacterStream(new StringReader(reportResponse));
                //                Document doc = db.parse(is);
                //                NodeList nodes = doc.getElementsByTagName("G_1");
                //                Node n = nodes.item(0);
                //                Element e = (Element)n;
                //                cutOffDate = e.getAttribute("CUTOFF_DATE");


                JSFUtils.addFacesInformationMessage("==Response Bytes to String==" +
                                                    reportResponse);

                DocumentBuilder builder =
                    DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource src = new InputSource();
                src.setCharacterStream(new StringReader(reportResponse));
                Document doc = builder.parse(src);
                cutOffDate =
                        doc.getElementsByTagName("CUTOFF_DATE").item(0).getTextContent();

                JSFUtils.addFacesInformationMessage("==GL DATE FORM REPORT RES==" +
                                                    cutOffDate);
            }
            reader.close();
        } catch (Exception e) {
            error = e.toString();
            e.printStackTrace();
        }
        return cutOffDate;
    }

    public synchronized static String getResponseAsString(String resp) throws ParserConfigurationException,
                                                                              SAXException,
                                                                              IOException {
        String response = resp;
        DocumentBuilder builder =
            DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(response));
        Document doc = builder.parse(src);
        response =
                doc.getElementsByTagName("reportBytes").item(0).getTextContent();


        /*******DECODE BYTES TO STRING************/
        byte[] val = DatatypeConverter.parseBase64Binary(response);
        response = new String(val);
        return response;
    }


    public synchronized static String getFaultString(String xml) {

        String faultString = "";
        int firstFault = xml.indexOf(";TEXT&gt;");
        int firstFault_last = xml.indexOf("&lt;/TEXT&");
        faultString = xml.substring(firstFault + 9, firstFault_last);
        //        System.err.println("FAULT STRING : " + faultString);
        return faultString;
    }

    public String getPayload(String glDate) {

        String payload =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pub=\"http://xmlns.oracle.com/oxp/service/PublicReportService\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <pub:runReport>\n" +
            "         <pub:reportRequest>\n" +
            "            <pub:parameterNameValues>\n" +
            "               <pub:item>\n" +
            "                  <pub:name>p_date</pub:name>\n" +
            "                  <pub:values>\n" +
            "                     <pub:item>" + glDate + "</pub:item>\n" +
            "                  </pub:values>\n" +
            "               </pub:item>\n" +
            "            </pub:parameterNameValues>\n" +
            "            <pub:reportAbsolutePath>/Custom/Property Lease/Reports/GL Period.xdo</pub:reportAbsolutePath>\n" +
            "         </pub:reportRequest>\n" +
            "         <pub:userID>erp_user</pub:userID>\n" +
            "         <pub:password>welcome@4i</pub:password>\n" +
            "      </pub:runReport>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";

        return payload;
    }


    public boolean getApprovalUser() {
        ViewObject OfferHrdVO =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        boolean flag = false;
        String flowWith =
            OfferHrdVO.getCurrentRow().getAttribute("FlowWith") == null ?
            null :
            OfferHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
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

    public void exportToExcel(FacesContext facesContext,
                              java.io.OutputStream outputStream) {
        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Contracts");
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("Contract No");
            sheet.setColumnWidth(0, 3000);
            rowhead.createCell(1).setCellValue("Payments & Documents No");
            sheet.setColumnWidth(1, 5500);
            //            rowhead.createCell(1).setCellValue("Property Name");
            //            sheet.setColumnWidth(1, 3000);
            rowhead.createCell(2).setCellValue("Building Name");
            sheet.setColumnWidth(2, 5000);
            rowhead.createCell(3).setCellValue("Unit Name");
            sheet.setColumnWidth(3, 3000);
            rowhead.createCell(4).setCellValue("Unit Short Code");
            sheet.setColumnWidth(4, 3000);
            rowhead.createCell(5).setCellValue("Offer No");
            sheet.setColumnWidth(5, 3000);
            rowhead.createCell(6).setCellValue("Booking No");
            sheet.setColumnWidth(6, 3500);
            rowhead.createCell(7).setCellValue("Customer");
            sheet.setColumnWidth(7, 6000);
            rowhead.createCell(8).setCellValue("Tenancy Document No");
            sheet.setColumnWidth(8, 6000);
            rowhead.createCell(9).setCellValue("Lease Start Date");
            sheet.setColumnWidth(9, 5000);
            rowhead.createCell(10).setCellValue("Lease End Date");
            sheet.setColumnWidth(10, 5000);
            rowhead.createCell(11).setCellValue("Creation Date");
            sheet.setColumnWidth(11, 5000);
            rowhead.createCell(12).setCellValue("Contract Status");
            sheet.setColumnWidth(12, 4000);
            rowhead.createCell(13).setCellValue("Contract Sub Status");
            sheet.setColumnWidth(13, 5000);
            rowhead.createCell(14).setCellValue("Unit Status");
            sheet.setColumnWidth(14, 4000);
            rowhead.createCell(15).setCellValue("Description");
            sheet.setColumnWidth(15, 6000);
            rowhead.createCell(16).setCellValue("Set Rent");
            sheet.setColumnWidth(16, 4000);
            rowhead.createCell(17).setCellValue("Net Rent");
            sheet.setColumnWidth(17, 4000);
            rowhead.createCell(18).setCellValue("Discount Value");
            sheet.setColumnWidth(18, 4000);
            rowhead.createCell(19).setCellValue("Tax Amount");
            sheet.setColumnWidth(19, 3500);
            rowhead.createCell(20).setCellValue("Unit Description");
            sheet.setColumnWidth(20, 8000);
            rowhead.createCell(21).setCellValue("Mobile No");
            sheet.setColumnWidth(21, 6000);
            rowhead.createCell(22).setCellValue("Phone No");
            sheet.setColumnWidth(22, 6000);
            rowhead.createCell(23).setCellValue("Email Id");
            sheet.setColumnWidth(23, 6000);
            rowhead.createCell(24).setCellValue("Offer Flag");
            sheet.setColumnWidth(24, 4500);
            rowhead.createCell(25).setCellValue("Tenancy Status");
            sheet.setColumnWidth(25, 4500);
            rowhead.createCell(26).setCellValue("NOC Date");
            sheet.setColumnWidth(26, 4500);
            rowhead.createCell(27).setCellValue("Unit Category");
            sheet.setColumnWidth(27, 4000);
            rowhead.createCell(28).setCellValue("Area Value");
            sheet.setColumnWidth(28, 4000);
            ViewObject actVO =
                ADFUtils.findIterator("SearchLeaseAgreementInfo_RoVo1Iterator").getViewObject();
            actVO.executeQuery();
            if (actVO.getEstimatedRowCount() > 0) {
                RowSetIterator rs = actVO.createRowSetIterator(null);
                int excelRowData = 1;
                while (rs.hasNext()) {
                    Row actRow = rs.next();
                    String leaseNo =
                        actRow.getAttribute("LeaseNumber") != null ?
                        actRow.getAttribute("LeaseNumber").toString() : "";
                    String recommNo =
                        actRow.getAttribute("RecommendnoTrans") != null ?
                        actRow.getAttribute("RecommendnoTrans").toString() :
                        "";
                    String buildName =
                        actRow.getAttribute("Buildname") != null ?
                        actRow.getAttribute("Buildname").toString() : "";
                    String unitName =
                        actRow.getAttribute("Unitname") != null ? actRow.getAttribute("Unitname").toString() :
                        "";
                    String unitShortCode =
                        actRow.getAttribute("UnitShortcode") != null ? actRow.getAttribute("UnitShortcode").toString() :
                        "";
                    String offerNo =
                        actRow.getAttribute("OffernoTrans") != null ?
                        actRow.getAttribute("OffernoTrans").toString() : "";
                    String bookingNo =
                        actRow.getAttribute("BookingnoTrans") != null ?
                        actRow.getAttribute("BookingnoTrans").toString() : "";
                    String customerName =
                        actRow.getAttribute("Customer") != null ?
                        actRow.getAttribute("Customer").toString() : "";
                    String tenancyConDocNo =
                        actRow.getAttribute("TenancyConDocNo") != null ?
                        actRow.getAttribute("TenancyConDocNo").toString() : "";
                    String leaseStartDate =
                        actRow.getAttribute("LeaseStartDate") != null ?
                        actRow.getAttribute("LeaseStartDate").toString() : "";
                    String leaseEndDate =
                        actRow.getAttribute("LeaseEndDate") != null ?
                        actRow.getAttribute("LeaseEndDate").toString() : "";
                    String createDate =
                        actRow.getAttribute("CreateDate") != null ?
                        actRow.getAttribute("CreateDate").toString() : "";
                    String laStatus =
                        actRow.getAttribute("Status") == null ? "" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("DRA") ?
                        "Draft" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("PEN") ?
                        "Pending" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("APR") ?
                        "Approved" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("BO") ?
                        "Booked" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("REJ") ?
                        "Rejected" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("CANC") ?
                        "Cancelled" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("TERM") ?
                        "Terminated" :
                        actRow.getAttribute("Status").toString();
                    String unitStatus =    actRow.getAttribute("UnitStatus")==null ? "" 
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("ALOT") ? "Allotted"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("BOOK") ? "Booked"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("AVAL") ? "Available"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("BLOCK") ? "Blocked"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("NOT_AVAL") ? "Not Available"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("OFFER") ? "Offered"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("HOLD") ? "Hold"
                        : actRow.getAttribute("UnitStatus").toString();
                    String subStatus =
                        actRow.getAttribute("SubStatus") != null ?
                        actRow.getAttribute("SubStatus").toString() : "";
                    String description =
                        actRow.getAttribute("Description") != null ?
                        actRow.getAttribute("Description").toString() : "";
                    String SetRent =
                        actRow.getAttribute("SetRent") != null ?
                        actRow.getAttribute("SetRent").toString() : "";
                    String NetRent =
                        actRow.getAttribute("NetRent") != null ?
                        actRow.getAttribute("NetRent").toString() : "";
//                    String DiscountName =
//                        actRow.getAttribute("DiscountName") != null ?
//                        actRow.getAttribute("DiscountName").toString() : "";
                    String DiscountValue =
                        actRow.getAttribute("DiscAmt") != null ?
                        actRow.getAttribute("DiscAmt").toString() : "";
                    String TaxAmount =
                        actRow.getAttribute("TaxAmount") != null ?
                        actRow.getAttribute("TaxAmount").toString() : "";
                    String UnitDescription =
                        actRow.getAttribute("UnitDescription") != null ?
                        actRow.getAttribute("UnitDescription").toString() : "";
                    String MobileNumber =
                        actRow.getAttribute("MobileNumber") != null ?
                        actRow.getAttribute("MobileNumber").toString() : "";
                    String PhoneNumber =
                        actRow.getAttribute("PhoneNumber") != null ?
                        actRow.getAttribute("PhoneNumber").toString() : "";
                    String EmailId =
                        actRow.getAttribute("EmailId") != null ?
                        actRow.getAttribute("EmailId").toString() : "";
                    String offerFlag =
                        actRow.getAttribute("OfferFlag") == null ? ""
                        : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("N") ? "New" 
                        : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("R") ? "Renewal"
                        : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("S") ? "Short Renewal"
                        : "";
                    String tenancyStatus =
                        actRow.getAttribute("TenanctStatus") == null ? "" :
                        actRow.getAttribute("TenanctStatus").toString().equalsIgnoreCase("OP") ?
                        "On Going" :
                        actRow.getAttribute("TenanctStatus").toString().equalsIgnoreCase("TERM") ?
                        "Terminated" :
                        actRow.getAttribute("TenanctStatus").toString();
                    String cnNocDate =
                        actRow.getAttribute("CancellationNocDate") != null ?
                        actRow.getAttribute("CancellationNocDate").toString() : "";
                    String unitCatg =
                        actRow.getAttribute("UnitCategory") != null ? actRow.getAttribute("UnitCategory").toString() :
                        "";
                    String areaValue =
                        actRow.getAttribute("AreaValue") != null ? actRow.getAttribute("AreaValue").toString() :
                        "";

                    HSSFRow row = sheet.createRow((short)excelRowData);
                    row.createCell(0).setCellValue(leaseNo);
                    row.createCell(1).setCellValue(recommNo);
                    row.createCell(2).setCellValue(buildName);
                    row.createCell(3).setCellValue(unitName);
                    row.createCell(4).setCellValue(unitShortCode);
                    row.createCell(5).setCellValue(offerNo);
                    row.createCell(6).setCellValue(bookingNo);
                    row.createCell(7).setCellValue(customerName);
                    row.createCell(8).setCellValue(tenancyConDocNo);
                    row.createCell(9).setCellValue(leaseStartDate);
                    row.createCell(10).setCellValue(leaseEndDate);
                    row.createCell(11).setCellValue(createDate);
                    row.createCell(12).setCellValue(laStatus);
                    row.createCell(13).setCellValue(subStatus);
                    row.createCell(14).setCellValue(unitStatus);
                    row.createCell(15).setCellValue(description);
                    row.createCell(16).setCellValue(SetRent);
                    row.createCell(17).setCellValue(NetRent);
                    row.createCell(18).setCellValue(DiscountValue);
                    row.createCell(19).setCellValue(TaxAmount);
                    row.createCell(20).setCellValue(UnitDescription);
                    row.createCell(21).setCellValue(MobileNumber);
                    row.createCell(22).setCellValue(PhoneNumber);
                    row.createCell(23).setCellValue(EmailId);
                    row.createCell(24).setCellValue(offerFlag);
                    row.createCell(25).setCellValue(tenancyStatus);
                    row.createCell(26).setCellValue(cnNocDate);
                    row.createCell(27).setCellValue(unitCatg);
                    row.createCell(28).setCellValue(areaValue);
                    excelRowData++;
                }
            }
            workbook.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            System.err.println("BDS" + e.getMessage());
        }
    }

    public void setGenerate_invoice_cb15(RichCommandButton generate_invoice_cb15) {
        this.generate_invoice_cb15 = generate_invoice_cb15;
    }

    public RichCommandButton getGenerate_invoice_cb15() {
        return generate_invoice_cb15;
    }

    public void onClickRecommendationid(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                System.err.println("PRINT="+valueChangeEvent.getNewValue());
                ViewObject vo=ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
                Row r=vo.getCurrentRow();
                System.err.println("PRINT2"+r.getAttribute("RecommendId"));
                Object RecommendId=r.getAttribute("RecommendId");
                Long count=LeaseDuplicateValidation(RecommendId);
                if(count==1)
                {     
                    r.setAttribute("RecommendationIdTrans",null);
                    r.setAttribute("RecommendId",null);
                    r.setAttribute("BookingId",null);
                   
                vo.executeQuery();
                JSFUtils.addFacesErrorMessage("Recommendation number already exist for another lease transaction");
                }
    }
    public long LeaseDuplicateValidation(Object recommedationId)
        {
            ViewObject vo=ADFUtils.findIterator("LeaseDuplicateROVO1Iterator").getViewObject();   
                    ViewCriteria vc=vo.createViewCriteria();
                           ViewCriteriaRow vcr=vc.createViewCriteriaRow();
                           vcr.setAttribute("RecommendId",recommedationId);
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

    public void doHandleIntgrResponse(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject leaseVO =
                            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        String resp = leaseVO.getCurrentRow().getAttribute("IntegrationResponse")==null ? "" : leaseVO.getCurrentRow().getAttribute("IntegrationResponse").toString();
        System.out.println("Response :"+resp);
        if(resp.equalsIgnoreCase("{\"result\":\"Success\"}")){
        leaseVO.getCurrentRow().setAttribute("IntegrationResponse", null);
        ADFUtils.findOperation("Commit").execute();      
        }
    }
    //for update flag for attestation process as attribute4 for rightnow
    public void doUpdateAttestationFlag() {
        ViewObject leaseVO =
                            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        String flag = leaseVO.getCurrentRow().getAttribute("Attribute4")==null ? "" : leaseVO.getCurrentRow().getAttribute("Attribute4").toString();
        System.out.println("Response :"+flag);
        if(flag.equalsIgnoreCase("")){
        leaseVO.getCurrentRow().setAttribute("Attribute4", "Y");
//        ADFUtils.findOperation("Commit").execute();      
        }
    }

    public void doRenewalOffer(ActionEvent actionEvent) {
        String offerHdrId=null;
        ViewObject leaseVO = ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        ViewObject bkHdrVO = ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        Row r = leaseVO.getCurrentRow();
        String leaseId = r.getAttribute("LeaseAgreementId")==null ? "" : r.getAttribute("LeaseAgreementId").toString();
        String userName = ADFContext.getCurrent().getSessionScope().get("userName")==null ? "Anonymous" : ADFContext.getCurrent().getSessionScope().get("userName").toString();
        String rOrSinvoke = ADFContext.getCurrent().getPageFlowScope().get("RenewalOrShort")==null ? "Anonymous" : ADFContext.getCurrent().getPageFlowScope().get("RenewalOrShort").toString();
        String bkId = r.getAttribute("BookingId")==null ? "" : r.getAttribute("BookingId").toString();
        ViewCriteria vc = bkHdrVO.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("BookingId1", bkId);
        vc.addRow(vcRow);
        bkHdrVO.applyViewCriteria(vc);
        bkHdrVO.executeQuery();
        if (bkHdrVO.first() != null) {
            System.err.println("bkHdrVO.first()" +  bkHdrVO.first().getAttribute("OfferHdrId"));
            offerHdrId= bkHdrVO.first().getAttribute("OfferHdrId")==null ? "" : bkHdrVO.first().getAttribute("OfferHdrId").toString();
        }
        System.out.println("leaseId :"+leaseId+" userName :"+userName+" rOrSinvoke :"+rOrSinvoke+" offerHdrId :"+offerHdrId);
        if(rOrSinvoke.equals("R")){
        OperationBinding op=ADFUtils.findOperation("autoRoffer");
        op.getParamsMap().put("offerHdrId",offerHdrId);
        op.getParamsMap().put("leaseId",leaseId);
        op.getParamsMap().put("userName",userName);
        String flag=op.execute().toString();
        if(flag.equalsIgnoreCase("Success")){
            r.setAttribute("Attribute5", flag);
            ADFUtils.findOperation("Commit").execute();
        }
        JSFUtils.addFacesInformationMessage(flag);
        }
        else if(rOrSinvoke.equals("S")){
        OperationBinding op=ADFUtils.findOperation("autoSoffer");
        op.getParamsMap().put("offerHdrId",offerHdrId);
        op.getParamsMap().put("leaseId",leaseId);
        op.getParamsMap().put("userName",userName);
        String flag=op.execute().toString();
            if(flag.equalsIgnoreCase("Success")){
                r.setAttribute("Attribute5", flag);
                ADFUtils.findOperation("Commit").execute();
            }
        JSFUtils.addFacesInformationMessage(flag);
        }
        else{
            JSFUtils.addFacesErrorMessage("Please try again !!!");
        }
    }

    public void doRemoveMultipleError(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject rcptVo = ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row r = rcptVo.getCurrentRow();
        String receiptResponse = r.getAttribute("Attribute1")==null ? "" : r.getAttribute("Attribute1").toString();
        System.out.println("receiptResponse :"+receiptResponse);
        if(receiptResponse.contains("Multiple") && !receiptResponse.equalsIgnoreCase("")){
            r.setAttribute("Attribute1", null);
            ADFUtils.findOperation("Commit").execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAttributResponse());
        }
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
                        &&
//                        notNull(reportOutput.getElementsByTagName("TRX_NUMBER").item(0)) &&
                        notNull(reportOutput.getElementsByTagName("CASH_RECEIPT_ID").item(0))
                    ) {

                        BindingContainer bindings =
                            BindingContext.getCurrent().getCurrentBindingsEntry();
                        OperationBinding method =
                            bindings.getOperationBinding("getCashRcptIdRspnse");
                        Map args = method.getParamsMap();
                        args.put("pReceiptNo",
                                 reportOutput.getElementsByTagName("RECEIPT_NUMBER").item(0).getTextContent().toString());
//                        args.put("pChargeTyp", null);
                        args.put("pCshRcptId",
                                 reportOutput.getElementsByTagName("CASH_RECEIPT_ID").item(0).getTextContent().toString());
//                        args.put("pCustomerTrxNo",
//                                 reportOutput.getElementsByTagName("TRX_NUMBER").item(0).getTextContent().toString());
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

    public void doCancellation(ActionEvent actionEvent) {
        ViewObject leaseVO = ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        Row r = leaseVO.getCurrentRow();
        String leaseId = r.getAttribute("LeaseAgreementId")==null ? "" : r.getAttribute("LeaseAgreementId").toString();
        String userName = ADFContext.getCurrent().getSessionScope().get("userName")==null ? "Anonymous" : ADFContext.getCurrent().getSessionScope().get("userName").toString();
        OperationBinding op=ADFUtils.findOperation("cancellationCall");
        op.getParamsMap().put("leaseId",leaseId);
        op.getParamsMap().put("userName",userName);
        String flag=op.execute().toString();
        if(flag.equalsIgnoreCase("Success")){
            r.setAttribute("Attribute6", flag);
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage(flag);
        }        
        else{
            JSFUtils.addFacesErrorMessage("Please try again !!!");
        }
//        JSFUtils.addFacesInformationMessage(flag);
    }
}


