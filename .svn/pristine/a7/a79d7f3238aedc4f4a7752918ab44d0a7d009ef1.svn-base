import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.ServletContext;

import javax.sql.DataSource;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.nav.RichGoImageLink;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.apps.xdo.template.FOProcessor;
import oracle.apps.xdo.template.RTFProcessor;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.event.ReturnEvent;

import org.apache.poi.hssf.usermodel.HSSFRow;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

import view.backing.MailServices;
import view.backing.MailTemplates;

public class Recommendation {
    private RichTable t6;
    private RichInputText receipt;
    private RichPopup popup3;
    private RichInputText reason;
    private RichGoImageLink gil2;
    private RichPopup popup5;
    private RichSelectBooleanCheckbox sbc1;
    private RichInputText it70;
    private RichPopup p20;
    private RichInputText dirctRejctReason;
    private RichInputText it5;
    private RichPopup popup27;

    public Recommendation() {
    }

    ViewObject BookingDtlVo =
        ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
    ViewObject RecoomenHdrVo =
        ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
    ViewObject RecoomenDtlVo =
        ADFUtils.findIterator("RecommendDetail_VO1Iterator").getViewObject();


    ViewObject PropertyMaster_VO1Iterator =
        ADFUtils.findIterator("PropertyMaster_VO1Iterator").getViewObject();
    ViewObject vo =
        ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
    Row row = vo.getCurrentRow();


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


    public void SumofReceiptAmount() {

        OperationBinding obs =
            ADFUtils.findOperation("InvokeSumofRceiptAmount");
        obs.getParamsMap().put("bookid",
                               RecoomenHdrVo.getCurrentRow().getAttribute("BookingId"));
        obs.execute();

        System.err.println("RESULT" + obs.getResult());


    }


    public void onAttributesSave() {
        ViewObject getBookingDtl =
            ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();
        ViewCriteria offerDtlVC = getBookingDtl.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("BookingId",
                                 RecoomenHdrVo.getCurrentRow().getAttribute("BookingId"));
        offerDtlVC.addRow(offerDtlVCR);
        getBookingDtl.applyViewCriteria(offerDtlVC);
        //getBookingDtl.setNamedWhereClauseParam
        getBookingDtl.executeQuery();


        RecoomenHdrVo.getCurrentRow().setAttribute("PropertyId",
                                                   getBookingDtl.first().getAttribute("PropertyId"));
        RecoomenHdrVo.getCurrentRow().setAttribute("BuildingId",
                                                   getBookingDtl.first().getAttribute("BuildingId"));
//        RecoomenHdrVo.getCurrentRow().setAttribute("OrgId",
//                                                   getBuisnessUnit(getBookingDtl.first().getAttribute("PropertyId")));


    }

    public void onSave(ActionEvent actionEvent) {

        ViewObject getFuncodeVo =
            ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
        getFuncodeVo.setNamedWhereClauseParam("F_ID", "RC");
        getFuncodeVo.executeQuery();
        Object Funcode = getFuncodeVo.first().getAttribute("FuncId");
        String Fcode = Funcode == null ? "" : Funcode.toString();

        Row re = RecoomenHdrVo.getCurrentRow();
        System.err.println("re" + re);
        if (re.getAttribute("RecommendNumber") == null) {
            String name =
                xxfnd.generateDocNo("RC", "Recommendation_AMDataControl").toString();
            Object valu = name;

            re.setAttribute("RecommendNumber", valu);
            re.setAttribute("FuncId",
                            getFuncodeVo.first().getAttribute("FuncId"));
            onAttributesSave();
        }
//        onAttributesSave();
        // Revise();
        OperationBinding binding =
            (OperationBinding)ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully");
        //        OperationBinding bindings =
        //            (OperationBinding)ADFUtils.findOperation("Rollback").execute();
    }

    public String onClickSave() {
        ViewObject getFuncodeVo =
            ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
        getFuncodeVo.setNamedWhereClauseParam("F_ID", "RC");
        getFuncodeVo.executeQuery();
        Object Funcode = getFuncodeVo.first().getAttribute("FuncId");
        String Fcode = Funcode == null ? "" : Funcode.toString();
        Row re = RecoomenHdrVo.getCurrentRow();
        if (re.getAttribute("RecommendNumber") == null) {
            String name =
                xxfnd.generateDocNo("RC", "Recommendation_AMDataControl").toString();
            Object valu = name;

            re.setAttribute("RecommendNumber", valu);
            re.setAttribute("FuncId",
                            getFuncodeVo.first().getAttribute("FuncId"));
            onAttributesSave();
        }
//        onAttributesSave();
        //Revise();
        OperationBinding binding =
            (OperationBinding)ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully");
        OperationBinding bindings =
            (OperationBinding)ADFUtils.findOperation("Rollback").execute();
        return "backToSearch";
    }

    public void OnClickCancel(ActionEvent actionEvent) {
        ADFUtils.findOperation("Rollback").execute();
    }

    public void setT6(RichTable t6) {
        this.t6 = t6;
    }

    public RichTable getT6() {
        return t6;
    }

    public void addBookingMilestoneDtl(ActionEvent actionEvent) {
        Object recommendationListener =
            JSFUtils.resolveExpression("#{pageFlowScope.TransId}");
//        if (recommendationListener.equals("OT")) {
         if (recommendationListener.equals("OC")) {
            ViewObject bookingMilestoneDtlVo =
                ADFUtils.findIterator("Booking_Milestone_VO2Iterator").getViewObject();
            ADFUtils.findOperation("CreateInsert1").execute();
//            RecoomenHdrVo.getCurrentRow().getAttribute("OrgId");
            bookingMilestoneDtlVo.getCurrentRow().setAttribute("OfferRecoOrgId", RecoomenHdrVo.getCurrentRow().getAttribute("OrgId"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(t6);
        }

    }

    public void onAddReceipt(ActionEvent actionEvent) {
        // Add event code here...

    }


    public String onCreateReceipt() {


        ViewObject vo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));
        ViewObject BMtlvo =
                    ADFUtils.findIterator("Booking_Milestone_VO2Iterator").getViewObject();
                Row BMrows = BMtlvo.getCurrentRow();
        ViewObject offerLnsVO2 =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        ViewCriteria vc = offerLnsVO2.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();

        vcRow.setAttribute("BookingId", row.getAttribute("BookingId"));
        vc.addRow(vcRow);
        offerLnsVO2.applyViewCriteria(vc);
        offerLnsVO2.executeQuery();

        if (offerLnsVO2.getEstimatedRowCount() > 0) {
            Row cusRow = offerLnsVO2.first();
            
            ADFContext.getCurrent().getPageFlowScope().put("funcId",
                                                           row.getAttribute("FuncId") ==
                                                           null ? "" :
                                                           row.getAttribute("FuncId"));
            ADFContext.getCurrent().getPageFlowScope().put("scfnId",
                                                           row.getAttribute("RecommendId") ==
                                                           null ? "" :
                                                           row.getAttribute("RecommendId"));
            ADFContext.getCurrent().getPageFlowScope().put("OrgId",
                                                           row.getAttribute("OrgId") ==
                                                           null ? "" :
                                                           row.getAttribute("OrgId"));
            ADFContext.getCurrent().getPageFlowScope().put("CustName",
                                                           cusRow.getAttribute("CustName") ==
                                                           null ? "" :
                                                           cusRow.getAttribute("CustName"));
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
            //15-Nov-22 for oc divide based on vat and non vat//for attribute6
            String isVat = ADFContext.getCurrent().getPageFlowScope().get("isVat")==null ? "NO_VAT" : ADFContext.getCurrent().getPageFlowScope().get("isVat").toString();
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
            //passing null as to avoid pagePlowScope
            ADFContext.getCurrent().getPageFlowScope().put("DueDate", "" );
          String a = ADFContext.getCurrent().getPageFlowScope().get("A").toString();
          System.out.println("a : "+a);
            if(a.equalsIgnoreCase("A")){
            ADFContext.getCurrent().getPageFlowScope().put("Amount", "" );
            ADFContext.getCurrent().getPageFlowScope().put("Dscrption", "" );
            ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "DV" );
            ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "Developer Charges" );
            }else{
            ADFContext.getCurrent().getPageFlowScope().put("Amount",
                                                               BMrows.getAttribute("InstallmentAmount") ==
                                                               null ? "" :
                                                               BMrows.getAttribute("InstallmentAmount"));
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
                String orgID = row.getAttribute("OrgId")==null?"":row.getAttribute("OrgId").toString();
                if (orgID.equals("300000021774129")){
                    ADFContext.getCurrent().getPageFlowScope().put("OrgId", "300000021774129" );
                }else{
                ADFContext.getCurrent().getPageFlowScope().put("OrgId", "300000001937178" );
                }
                ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "OT" );
                ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "" );
            }
        }

         }
        return "receipt";
    }

    public String onCreateInstallReceipt() {


        ViewObject BMtlvo =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        Row rows = BMtlvo.getCurrentRow();


        Map map = new HashMap();
        String bookid = rows.getAttribute("BookingHdrId").toString();
        String milesid = rows.getAttribute("BookingMsDtlId").toString();
        map.put("bookid", bookid);
        map.put("milesid", milesid);


        OperationBinding ob = ADFUtils.findOperation("InvokeReceiptStatus");
        ob.getParamsMap().putAll(map);
        ob.execute();
        
        System.err.println("ERRORA STATUS" + ob.getResult());

        ViewObject vo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));
        ViewObject offerLnsVO2 =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        ViewCriteria vc = offerLnsVO2.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();

        vcRow.setAttribute("BookingId", row.getAttribute("BookingId"));
        vc.addRow(vcRow);
        offerLnsVO2.applyViewCriteria(vc);
        offerLnsVO2.executeQuery();

        Row DetRow = BookingDtlVo.getCurrentRow();

        if (offerLnsVO2.getEstimatedRowCount() > 0) {
            Row cusRow = offerLnsVO2.first();
            ADFContext.getCurrent().getPageFlowScope().put("Type","INS");
            ADFContext.getCurrent().getPageFlowScope().put("funcId",
                                                           row.getAttribute("FuncId") ==
                                                           null ? "" :
                                                           row.getAttribute("FuncId"));
            ADFContext.getCurrent().getPageFlowScope().put("scfnId",
                                                           row.getAttribute("RecommendId") ==
                                                           null ? "" :
                                                           row.getAttribute("RecommendId"));
            ADFContext.getCurrent().getPageFlowScope().put("OrgId",
                                                           row.getAttribute("OrgId") ==
                                                           null ? "" :
                                                           row.getAttribute("OrgId"));
            ADFContext.getCurrent().getPageFlowScope().put("CustName",
                                                           cusRow.getAttribute("CustName") ==
                                                           null ? "" :
                                                           cusRow.getAttribute("CustName"));
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
            ADFContext.getCurrent().getPageFlowScope().put("DueDate",
                                                           DetRow.getAttribute("DueDate") ==
                                                           null ? "" :
                                                           DetRow.getAttribute("DueDate"));
            //08-sep-2020 for all receipts to capture BookingMsDtlId in receipt Attribute3 mainly for OC report
            String bkMsdtlId = rows.getAttribute("BookingMsDtlId") == null ? "" : rows.getAttribute("BookingMsDtlId").toString();
            System.out.println("bkMsdtlId ::"+bkMsdtlId);
            ADFContext.getCurrent().getPageFlowScope().put("remark", bkMsdtlId);
            //17-sep-2020 for security deposit SD payment mode
            ADFContext.getCurrent().getPageFlowScope().put("SDPayMode","");
            //
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
            //#{pageFlowScope.BookingMsId}

            ADFContext.getCurrent().getPageFlowScope().put("BookingMsId",
                                                           rows.getAttribute("BookingMsDtlId") ==
                                                           null ? "" :
                                                           rows.getAttribute("BookingMsDtlId"));

            String res =
                ob.getResult() == null ? "" : ob.getResult().toString();

            if (res.equals("UNAPPLIED")) {
                OperationBinding obs =
                    ADFUtils.findOperation("InvokeReceiptAmnValidate");
                obs.getParamsMap().putAll(map);
                obs.execute();
                System.err.println("ERROR AMOUNT" + obs.getResult());
                ADFContext.getCurrent().getPageFlowScope().put("Amount",
                                                               obs.getResult() ==
                                                               null ? "" :
                                                               obs.getResult());
            } else {

                ADFContext.getCurrent().getPageFlowScope().put("Amount",
                                                               DetRow.getAttribute("InstallmentAmount") ==
                                                               null ? "" :
                                                               DetRow.getAttribute("InstallmentAmount"));


            }


            //
            //            ADFContext.getCurrent().getPageFlowScope().put("InstallmentType",
            //                                                           DetRow.getAttribute("InstallmentType") ==
            //                                                           null ? "" :
            //                                                           DetRow.getAttribute("InstallmentType"));


        }


        return "receipt";
    }


    public String onEdit() {
        ViewObject vo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ViewObject Rvo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row re = Rvo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("recid",
                                                       re.getAttribute("ReceiptId"));
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));
        ADFContext.getCurrent().getPageFlowScope().put("TransId", "ER");
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

    public void onDeleteReceipt(ActionEvent actionEvent) {
//        ADFUtils.findOperation("Delete1").execute();
         RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup5().show(popup34);
    }

    public void onSumofReceipt() {
        Double totalRecAmnt = new Double(0);
        ViewObject OfferDtlVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        if (OfferDtlVo.getEstimatedRowCount() > 0) {
            RowSetIterator rs = OfferDtlVo.createRowSet("");
            //BigDecimal totalRecAmnt=new BigDecimal(0);


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
        }

        BigDecimal TotalRecAmn = BigDecimal.valueOf(totalRecAmnt);


        this.receipt.setValue(TotalRecAmn);

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getReceipt());
    }


    public void onSumofReceiptFormBooking() {
        Double totalRecAmnt = new Double(0);
        ViewObject OfferDtlVo =
            ADFUtils.findIterator("Receipt_VO2Iterator").getViewObject();
        //        ViewObject offerLnsVO2 =
        //            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        ViewCriteria vc = OfferDtlVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();

        vcRow.setAttribute("SourceFuncRefId", row.getAttribute("BookingId"));
        vc.addRow(vcRow);
        OfferDtlVo.applyViewCriteria(vc);
        OfferDtlVo.executeQuery();
        if (OfferDtlVo.getEstimatedRowCount() > 0) {
            RowSetIterator rs = OfferDtlVo.createRowSet("");
            //BigDecimal totalRecAmnt=new BigDecimal(0);


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
        }

        ViewObject bookingDtlVo =
            ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();

        ViewCriteria vwc = bookingDtlVo.createViewCriteria();
        ViewCriteriaRow vwcRow = vwc.createViewCriteriaRow();
        vwcRow.setAttribute("BookingId", row.getAttribute("BookingId"));
        vwc.addRow(vwcRow);
        bookingDtlVo.applyViewCriteria(vwc);
        bookingDtlVo.executeQuery();

        BigDecimal TotalRecAmn = BigDecimal.valueOf(totalRecAmnt);


        this.receipt.setValue(TotalRecAmn);

        //        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getReceipt());
    }


    public void returnreceipt(ReturnEvent returnEvent) {

        Double totalRecAmnt = new Double(0);
        ViewObject OfferDtlVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        if (OfferDtlVo.getEstimatedRowCount() > 0) {
            RowSetIterator rs = OfferDtlVo.createRowSet("");
            //BigDecimal totalRecAmnt=new BigDecimal(0);


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
        }

        BigDecimal TotalRecAmn = BigDecimal.valueOf(totalRecAmnt);

        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer dcb =
            (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding iter =
            dcb.findIteratorBinding("Receipt_VO1Iterator");
        iter.executeQuery();
        RequestContext.getCurrentInstance().addPartialTarget(returnEvent.getComponent().getParent().getParent());
//
        System.out.println("Estimated row count on return ::"+ OfferDtlVo.getEstimatedRowCount());

        this.receipt.setValue(TotalRecAmn);
        SumofReceiptAmount();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getReceipt());

    }
   
    public void onClickAttachments(ActionEvent actionEvent) {
        JSFUtils.setExpressionValue("#{pageFlowScope.recfuncId}", 1);
        JSFUtils.setExpressionValue("#{pageFlowScope.recId}",
                                    row.getAttribute("BookingId"));
    }

    public void onClickChecklist(ActionEvent actionEvent) {
        JSFUtils.setExpressionValue("#{pageFlowScope.Recomfuncid}", 1);
        JSFUtils.setExpressionValue("#{pageFlowScope.Recomfuncrefid}",
                                    row.getAttribute("RecommendId"));
        JSFUtils.setExpressionValue("#{pageFlowScope.Recomflookup}", "");
    }


    public void onClickSubmit(ActionEvent actionEvent) {
 
        SumofReceiptAmount();
        onSave(actionEvent);
        
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        Object bookid = vo.getCurrentRow().getAttribute("BookingId");
        //17-dec-20 to proceed based on booking status
        String bkStatus = valdtBkStatusOnSubmit();
        if(bkStatus.equalsIgnoreCase("Y")){
        Long count=submitrecommendationvalidation(bookid);
        if(count==0)
        {
            Object org = vo.getCurrentRow().getAttribute("OrgId");
            Object prop = vo.getCurrentRow().getAttribute("PropertyId");
            Object unit = vo.getCurrentRow().getAttribute("BuildingId");


            ViewObject receiptVo =
                ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
            if (receiptVo.getEstimatedRowCount() > 0) {
                Object paymentAmount =
                    vo.getCurrentRow().getAttribute("Payment_amount_Trans") ==
                    null ? "0" :
                    vo.getCurrentRow().getAttribute("Payment_amount_Trans");

                //            System.err.println("RecAmnt" +
                //                               vo.getCurrentRow().getAttribute("Trans_ReceiptAmount"));

                Object receiptAmount =
                    vo.getCurrentRow().getAttribute("ReceiptAmount") == null ?
                    "0" : vo.getCurrentRow().getAttribute("ReceiptAmount");


                BigDecimal payAmount = new BigDecimal(paymentAmount.toString());
                payAmount = payAmount.setScale(2, BigDecimal.ROUND_HALF_UP);

                BigDecimal receiptAmou = new BigDecimal(receiptAmount.toString());
                receiptAmou = receiptAmou.setScale(2, BigDecimal.ROUND_HALF_UP);
            //            System.err.println("==payAmount==" + payAmount);
            //            System.err.println("==receiptAmou==" + receiptAmou);

                boolean res = payAmount.equals(receiptAmou);

            //            System.err.println("RRRRRRRR " + res);

                if (res == true) {

                    ADFContext.getCurrent().getPageFlowScope().put("Resval",
                                                                   "backToSearch");

                    try {
//                        ResultVal =
//                                xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
//                                                      row.getAttribute("FuncId"),
//                                                      row.getAttribute("RecommendId"),
//                                                      0, "XXPM_RECOMMEND_HEADER",
//                                                      "STATUS", "RECOMMEND_ID",
//                                                      org, prop, unit, null, null);
                        OperationBinding op=ADFUtils.findOperation("submitRcForAppr");
                          op.getParamsMap().put("rcId",row.getAttribute("RecommendId").toString());
                          ResultVal=op.execute().toString();
                        //          JSFUtils.addFacesInformationMessage(flag);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (ResultVal.equalsIgnoreCase("Success")) {
                        onChangeReceiptStatus();
                        ADFUtils.findOperation("Commit").execute();
                        //mail service
                        doSendMailOnSubmit();
                        JSFUtils.addFacesInformationMessage("Submitted For Approval");


                    } else {
                        JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Payment Amount and Receipt Amount are not same");
                }
            } else {
                JSFUtils.addFacesErrorMessage("Receipts are not Found");
            }
        
        }
        else{
         JSFUtils.addFacesErrorMessage("Already submitted for same booking");
            }
        }
        else{
         JSFUtils.addFacesErrorMessage("Associated Booking should be approved !!!");
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
    
    ViewObject rcHdrVo = ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
    String rcId = rcHdrVo.getCurrentRow().getAttribute("RecommendId") == null ? "0" : rcHdrVo.getCurrentRow().getAttribute("RecommendId").toString();
    String bkId = rcHdrVo.getCurrentRow().getAttribute("BookingId") == null ? "0" : rcHdrVo.getCurrentRow().getAttribute("BookingId").toString();
    String rcNo = rcHdrVo.getCurrentRow().getAttribute("RecommendNumber") == null ? "0" : rcHdrVo.getCurrentRow().getAttribute("RecommendNumber").toString();
    String flowWithId = rcHdrVo.getCurrentRow().getAttribute("FlowWith") == null ? "0" : rcHdrVo.getCurrentRow().getAttribute("FlowWith").toString();
    //roport download url
    pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/recomendation/"+rcNo;
    //    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/recomendation/"+rcNo;   
    String startDate = rcHdrVo.getCurrentRow().getAttribute("LeaseStartDate_Trans") == null ? "" : rcHdrVo.getCurrentRow().getAttribute("LeaseStartDate_Trans").toString();
    String endDate = rcHdrVo.getCurrentRow().getAttribute("LeaseEndDate_Trans") == null ? "" : rcHdrVo.getCurrentRow().getAttribute("LeaseEndDate_Trans").toString();
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
                }
        }
    //     ar.add("prasenjit.d@4iapps.com");
         ar.add(emailId);
     String htmlBody =MailTemplates.onSubmitForAprTmplt(propName,buildName,unitNameAL,userNameDisp,rcNo,"Payments & Documents No",custName,startDate,endDate,netRent,pdfReport);
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
    String netRent= null;
    String pdfReport=null;
    String custEmailId=null;
    
    ViewObject rcHdrVo = ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
    String rcId = rcHdrVo.getCurrentRow().getAttribute("RecommendId") == null ? "0" : rcHdrVo.getCurrentRow().getAttribute("RecommendId").toString();
    String bkId = rcHdrVo.getCurrentRow().getAttribute("BookingId") == null ? "0" : rcHdrVo.getCurrentRow().getAttribute("BookingId").toString();
    String rcNo = rcHdrVo.getCurrentRow().getAttribute("RecommendNumber") == null ? "0" : rcHdrVo.getCurrentRow().getAttribute("RecommendNumber").toString();
    String flowWithId = rcHdrVo.getCurrentRow().getAttribute("FlowWith") == null ? "0" : rcHdrVo.getCurrentRow().getAttribute("FlowWith").toString();
    String userName = rcHdrVo.getCurrentRow().getAttribute("CreatedBy") == null ? "" : rcHdrVo.getCurrentRow().getAttribute("CreatedBy").toString();
    //roport download url
    pdfReport ="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/recomendation/"+rcNo;
    //    pdfReport ="https://almsoatst.miskprops.com:8002/Al-MuskRtfServicesDemo1/webresources/rest/recomendation/"+rcNo;
    
    String startDate = rcHdrVo.getCurrentRow().getAttribute("LeaseStartDate_Trans") == null ? "" : rcHdrVo.getCurrentRow().getAttribute("LeaseStartDate_Trans").toString();
    String endDate = rcHdrVo.getCurrentRow().getAttribute("LeaseEndDate_Trans") == null ? "" : rcHdrVo.getCurrentRow().getAttribute("LeaseEndDate_Trans").toString();
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
     String htmlBody =MailTemplates.onApprovedTmplt(propName,buildName,unitNameAL,userNameDisp,rcNo,"Payments & Documents No",custName,startDate,endDate,netRent,pdfReport);
     String subject = "Approval Notification";
     MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
     JSFUtils.addFacesInformationMessage("Mail has been sent successfully");        
        }

    public String valdtBkStatusOnSubmit() {
        String sts = "N";
        ViewObject vo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ViewObject bkHdrVO =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        ViewCriteria ovc = bkHdrVO.createViewCriteria();
        ViewCriteriaRow ovcRow = ovc.createViewCriteriaRow();
        ovcRow.setAttribute("BookingId1",row.getAttribute("BookingId"));
        ovc.addRow(ovcRow);
        bkHdrVO.applyViewCriteria(ovc);
        bkHdrVO.executeQuery();
        if (bkHdrVO.getEstimatedRowCount() > 0) {
        String ofStatus = bkHdrVO.first().getAttribute("Status1")==null ? "" : bkHdrVO.first().getAttribute("Status1").toString();
        if (ofStatus.equalsIgnoreCase("APR") || ofStatus.equalsIgnoreCase("BO")){
            sts = "Y";
        }
      }
        return sts;
    }

    public String onClickSubmitBtn() {
        String response = "backToSearch";
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        Object org = vo.getCurrentRow().getAttribute("OrgId");
        Object prop = vo.getCurrentRow().getAttribute("PropertyId");
        Object unit = vo.getCurrentRow().getAttribute("BuildingId");


        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();

        Object paymentAmount =
            vo.getCurrentRow().getAttribute("Payment_amount_Trans") == null ?
            "" : vo.getCurrentRow().getAttribute("Payment_amount_Trans");
        Object receiptAmount =
            receiptVo.getCurrentRow().getAttribute("Trans_ReceiptAmountSum") ==
            null ? "" :
            receiptVo.getCurrentRow().getAttribute("Trans_ReceiptAmountSum");

        if (paymentAmount.equals(receiptAmount)) {
            try {
                ResultVal =
                        xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
                                              row.getAttribute("FuncId"),
                                              row.getAttribute("RecommendId"),
                                              0, "XXPM_RECOMMEND_HEADER",
                                              "STATUS", "RECOMMEND_ID", org,
                                              prop, unit, null, null);


            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (ResultVal.equalsIgnoreCase("Success")) {

                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Submitted For Approval");


            } else {
                JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
            }
        } else {
            response = null;
            JSFUtils.addFacesErrorMessage("Payment Amount and Receipt Amount are not same");
        }
        return response;
    }

//    public void onClickApprove(ActionEvent actionEvent) {
//        // String ResultVal = null;
//        Map<String, BigDecimal> ResultVal = new HashMap<String, BigDecimal>();
//        ViewObject vo =
//            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
//        Row row = vo.getCurrentRow();
////        String sts = row.getAttribute("Status")==null ? "" : row.getAttribute("Status").toString();
//        String Reason =
//            this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
//
//
//        try {
//            ResultVal =
//                    xxfnd.invokeResponsePkgs("xxfnd_util_pkg.update_response",
//                                             row.getAttribute("FuncId"),
//                                             row.getAttribute("RecommendId"),
//                                             row.getAttribute("UserGrpId"),
//                                             row.getAttribute("FlowLevel"),
//                                             row.getAttribute("FlowWith"),
//                                             Reason, "A", 0,
//                                             "XXPM_RECOMMEND_HEADER", "STATUS",
//                                             "RECOMMEND_ID");
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        for (Map.Entry m : ResultVal.entrySet()) {
////            System.out.println("KEY" + m.getKey() + "VALUE " + m.getValue());
//
//            if (m.getKey().equals("Success")) {
//                //vo.executeQuery();
//
//                String ress =
//                    m.getValue() == null ? "null" : m.getValue().toString();
//                if (ress.equals("null")) {
//
//                    // vo.executeQuery();
//                    forChangeBookingStatus();
//                    onChangeReceiptStatus();
//                    if(row.getAttribute("Attribute2") == null){
//                        row.setAttribute("Attribute2", "LA Created");
//                        System.out.println("Attribute2 after :"+row.getAttribute("Attribute2"));
//                        onClickForLA();
//                        //for OC
//                        ViewObject bookMSvo =
//                            ADFUtils.findIterator("Booking_Milestone_VO2Iterator").getViewObject();
//                        if(bookMSvo.getEstimatedRowCount()>0){
//                        onClickForOC();
//                        }
//                        //for tkt to track LA for renewal or short renewal and also tkt for mov in, in case of offer flag New for RC on approve
//                        ViewObject bkHdrVO =
//                            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
//                        ViewCriteria bkvc = bkHdrVO.createViewCriteria();
//                        ViewCriteriaRow bkvcRow = bkvc.createViewCriteriaRow();
//                        bkvcRow.setAttribute("BookingId1", row.getAttribute("BookingId"));
//                        bkvc.addRow(bkvcRow);
//                        bkHdrVO.applyViewCriteria(bkvc);
//                        bkHdrVO.executeQuery();
//                        Row bkRw = bkHdrVO.first();
//                        ViewObject ofHdrVO =
//                            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
//                        ViewCriteria vcss = ofHdrVO.createViewCriteria();
//                        ViewCriteriaRow vcRowe = vcss.createViewCriteriaRow();
//                        vcRowe.setAttribute("OfferHdrId", bkRw.getAttribute("OfferHdrId"));
//                        vcss.addRow(vcRowe);
//                        ofHdrVO.applyViewCriteria(vcss);
//                        ofHdrVO.executeQuery();
//                        Row ofRw = ofHdrVO.first();
//                        if(!ofRw.getAttribute("OfferFlag").toString().equalsIgnoreCase("N")){
//                        row.setAttribute("TktRnwlLaFlag", "Y");
//                        }
//                        //for move in excluding car parking
//                        String unitTypeValid = doValidUnitType();
//                        //14-July-2020 for move in tkt creation on approve of offer flag N RC
//                        if(ofRw.getAttribute("OfferFlag").toString().equalsIgnoreCase("N") && unitTypeValid.equalsIgnoreCase("Y")){
//                        row.setAttribute("TktMovInFlag", "Y");
//                        }
//                    }
//                }
//                ADFUtils.findOperation("Commit").execute();
//                String sts = row.getAttribute("Status")==null ? "" : row.getAttribute("Status").toString();
//                //mail service
//                if(sts.equalsIgnoreCase("PEN")){
//                    System.out.println("Status %%1%"+sts);
//                    doSendMailOnSubmit();
//                }
//                if(sts.equalsIgnoreCase("APR")){
//                    System.out.println("Status %%2%"+sts);
//                    doSendMailOnApproved();
//                    //flag for latest customer update in maintenance wo module
//                   row.setAttribute("Attribute3", "Y"); 
//                }
//                System.out.println("Status %%3%"+sts);
//                ADFUtils.findOperation("Commit").execute();
//                JSFUtils.addFacesInformationMessage("Approved Successfully");
//            } else {
//                JSFUtils.addFacesErrorMessage("Error in Approve process!");
//            }
//        }
//
//    }
    
    public void onClickApprove(ActionEvent actionEvent) {
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
//        String sts = row.getAttribute("Status")==null ? "" : row.getAttribute("Status").toString();
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
            Reason = this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
        }


        try {
            OperationBinding op=ADFUtils.findOperation("responseRcForAppr");
                      op.getParamsMap().put("rcId",row.getAttribute("RecommendId").toString());
                      op.getParamsMap().put("reason",Reason);
                      op.getParamsMap().put("apr_rej","A");
                      ResultVal=op.execute().toString();
            //          JSFUtils.addFacesInformationMessage(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sts = "";
            if (ResultVal.equals("Success")) {
            //            
            ViewObject recomRoVo = ADFUtils.findIterator("getRecommendRoVo1Iterator").getViewObject();
                   ViewCriteria vwc = recomRoVo.createViewCriteria();
                   ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
                   vwcr.setAttribute("RecommendId", row.getAttribute("RecommendId"));
                   vwc.addRow(vwcr);
                   recomRoVo.applyViewCriteria(vwc);
                   recomRoVo.executeQuery();
               if (recomRoVo.getEstimatedRowCount() > 0) {
                   Row recomRow = recomRoVo.first();
                   sts = recomRow.getAttribute("Status")==null ? "" : recomRow.getAttribute("Status").toString();
               }
            //
                //mail service
                if(sts.equalsIgnoreCase("PEN")){
                    System.out.println("Status %%1%"+sts);
//                    doSendMailOnSubmit();
                }
                if(sts.equalsIgnoreCase("APR")){
                    System.out.println("Status %%2%"+sts);
                    // vo.executeQuery();
                    forChangeBookingStatus();
                    onChangeReceiptStatus();
                    if(row.getAttribute("Attribute2") == null){
                        row.setAttribute("Attribute2", "LA Created");
                        System.out.println("Attribute2 after :"+row.getAttribute("Attribute2"));
                        onClickForLA();
                        //for OC
                        ViewObject bookMSvo =
                            ADFUtils.findIterator("Booking_Milestone_VO2Iterator").getViewObject();
                        if(bookMSvo.getEstimatedRowCount()>0){
                        onClickForOC();
                        }
                        //for tkt to track LA for renewal or short renewal and also tkt for mov in, in case of offer flag New for RC on approve
                        ViewObject bkHdrVO =
                            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
                        ViewCriteria bkvc = bkHdrVO.createViewCriteria();
                        ViewCriteriaRow bkvcRow = bkvc.createViewCriteriaRow();
                        bkvcRow.setAttribute("BookingId1", row.getAttribute("BookingId"));
                        bkvc.addRow(bkvcRow);
                        bkHdrVO.applyViewCriteria(bkvc);
                        bkHdrVO.executeQuery();
                        Row bkRw = bkHdrVO.first();
                        ViewObject ofHdrVO =
                            ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
                        ViewCriteria vcss = ofHdrVO.createViewCriteria();
                        ViewCriteriaRow vcRowe = vcss.createViewCriteriaRow();
                        vcRowe.setAttribute("OfferHdrId", bkRw.getAttribute("OfferHdrId"));
                        vcss.addRow(vcRowe);
                        ofHdrVO.applyViewCriteria(vcss);
                        ofHdrVO.executeQuery();
                        Row ofRw = ofHdrVO.first();
                        if(!ofRw.getAttribute("OfferFlag").toString().equalsIgnoreCase("N")){
                        row.setAttribute("TktRnwlLaFlag", "Y");
                        }
                        //for move in excluding car parking
                        String unitTypeValid = doValidUnitType();
                        //14-July-2020 for move in tkt creation on approve of offer flag N RC
                        if(ofRw.getAttribute("OfferFlag").toString().equalsIgnoreCase("N") && unitTypeValid.equalsIgnoreCase("Y")){
                        row.setAttribute("TktMovInFlag", "Y");
                        }
                    }
                    //
//                    doSendMailOnApproved();
                    //flag for latest customer update in maintenance wo module
                   row.setAttribute("Attribute3", "Y"); 
                }
                System.out.println("Status %%3%"+sts);
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Approved Successfully");
            } else {
                JSFUtils.addFacesErrorMessage("Error in Approve process!");
            }

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


    //for Changing Booking status on Approved

    public void forChangeBookingStatus() {

        ViewObject recommendHdrVo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();

        ViewObject bookingHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();

        ViewCriteria vc = bookingHdrVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("BookingId1",
                           recommendHdrVo.getCurrentRow().getAttribute("BookingId"));
        vc.addRow(vcRow);
        bookingHdrVo.applyViewCriteria(vc);
        bookingHdrVo.executeQuery();
        System.err.println("Count row in Booking=="+bookingHdrVo.getEstimatedRowCount());
        bookingHdrVo.first().setAttribute("Status1", "BO");
    }

    public void onClickReject(ActionEvent actionEvent) {
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Rejected" : this.reason.getValue().toString();


        try {
//            ResultVal =
//                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
//                                            row.getAttribute("FuncId"),
//                                            row.getAttribute("RecommendId"),
//                                            row.getAttribute("UserGrpId"),
//                                            row.getAttribute("FlowLevel"),
//                                            row.getAttribute("FlowWith"),
//                                            Reason, "R", 0,
//                                            "XXPM_RECOMMEND_HEADER", "STATUS",
//                                            "RECOMMEND_ID");
            OperationBinding op=ADFUtils.findOperation("responseRcForAppr");
                      op.getParamsMap().put("rcId",row.getAttribute("RecommendId").toString());
                      op.getParamsMap().put("reason",Reason);
                      op.getParamsMap().put("apr_rej","R");
                      ResultVal=op.execute().toString();
            //          JSFUtils.addFacesInformationMessage(flag);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            vo.executeQuery();
            onChangeReceiptStatus();
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Rejected Successfully");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Approve process!");
        }
    }


    public void onRefresh(DisclosureEvent disclosureEvent) {
        onSumofReceipt();
        SumofReceiptAmount();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getReceipt());
    }

    public void setReceipt(RichInputText receipt) {
        this.receipt = receipt;
    }

    public RichInputText getReceipt() {
        return receipt;
    }

    public String onClickReceiptDetails() {
        //Booking_Milestone_VO1Iterator
        ViewObject vo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));
        ViewObject offerLnsVO2 =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        ViewCriteria vc = offerLnsVO2.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();

        vcRow.setAttribute("BookingId", row.getAttribute("BookingId"));
        vc.addRow(vcRow);
        offerLnsVO2.applyViewCriteria(vc);
        offerLnsVO2.executeQuery();

        if (offerLnsVO2.getEstimatedRowCount() > 0) {
            Row cusRow = offerLnsVO2.first();
            ADFContext.getCurrent().getPageFlowScope().put("CustName",
                                                           cusRow.getAttribute("CustName") ==
                                                           null ? "" :
                                                           cusRow.getAttribute("CustName"));
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

            ADFContext.getCurrent().getPageFlowScope().put("CustBranchName",
                                                           cusRow.getAttribute("CustBranchName") ==
                                                           null ? "" :
                                                           cusRow.getAttribute("CustBranchName"));

        }

        ViewObject bookMileDtl =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();

        Row cusRow1 = bookMileDtl.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("InstallmentAmount",
                                                       cusRow1.getAttribute("InstallmentAmount") ==
                                                       null ? "" :
                                                       cusRow1.getAttribute("InstallmentAmount"));
//        System.err.println("EXIT");

        return "receipt";

    }

    public void onClickPDFReportReceipt(FacesContext facesContext,
                                        java.io.OutputStream outputStream) {

        try {
            Object result =
                runReciptReport("//reports//Recommendation Receipt.rtf");
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
            "SELECT XXPM_REPORT_PKG.Xxpm_provisional_rec_receipt('" +
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
                ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
            Row re = quoteVO.getCurrentRow();

            String quoteNumber =
                re.getAttribute("RecommendNumber") == null ? "" :
                re.getAttribute("RecommendNumber").toString();
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

    public ServletContext getContext() {
        return (ServletContext)getFacesContext().getExternalContext().getContext();
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }


    public String onPageDirection() {
        // Add event code here...
        String val =
            ADFContext.getCurrent().getPageFlowScope().get("Resval") == null ?
            "" :
            ADFContext.getCurrent().getPageFlowScope().get("Resval").toString();
        return val;
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
        String ackFlagStatus="Y";
        ViewObject rcptVo1 =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        System.out.println("Count RcptVo1 :"+rcptVo1.getEstimatedRowCount());
        String action = ADFContext.getCurrent().getPageFlowScope().get("Action").toString();
        if (action.equalsIgnoreCase("Rejection")){
        //            System.out.println("Rejection action :"+action);
        }else{
        if (rcptVo1.getEstimatedRowCount() > 0) {
        RowSetIterator rs = rcptVo1.createRowSet(null);
            while(rs.hasNext()){
                 Row rsRow = rs.next();
                System.out.println("Ack Flag : "+rsRow.getAttribute("AckFlag"));  
                String ackF = rsRow.getAttribute("AckFlag")==null ? "" : rsRow.getAttribute("AckFlag").toString();
                if (ackF.equalsIgnoreCase("N") || ackF.equalsIgnoreCase("")) {
                    ackFlagStatus="N";
                    break;
                }
            }
            rs.closeRowSetIterator();
        }
     }
        if (ackFlagStatus.equalsIgnoreCase("Y")){
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup3().show(popup34);
        }else{
            JSFUtils.addFacesErrorMessage("Please Acknowledge all the receipts before approval"); 
        }
    }
    
    public void onInvokeBypassAppr(ActionEvent actionEvent) {
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup27().show(popup34);

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


    public void onClickPDFReport(FacesContext facesContext,
                                 java.io.OutputStream outputStream) {

        try {
            Object result = runReport("//reports//Reservation Form.rtf");
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
            "SELECT XXPM_REPORT_PKG.Xxpm_reservation_form('" + p_offer_number +
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
                ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
            Row re = quoteVO.getCurrentRow();
            String quoteNumber =
                re.getAttribute("RecommendNumber") == null ? "" :
                re.getAttribute("RecommendNumber").toString();
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
    //****************************Recommendation Line level Receipt genration-Start****************************//

    public void onClickPDFLineReceipt(FacesContext facesContext,
                                      java.io.OutputStream outputStream) {

        try {
            Object result =
                runLineReciptReport("//reports//Recommendation Line Receipt.rtf");
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
            "SELECT XXPM_REPORT_PKG.Xxpm_recommendreceipt_form('" +
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

    public void onClickRevise(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject RecVo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row rowse = RecVo.getCurrentRow();


        Map map = new HashMap();
        String RecommendNumber =
            rowse.getAttribute("RecommendNumber").toString();
        String CreatedBy = rowse.getAttribute("CreatedBy").toString();
        map.put("recomNo", RecommendNumber);
        map.put("userId", CreatedBy);

        rowse.setAttribute("Status", "DRA");


        OperationBinding ob = ADFUtils.findOperation("ReviseRecommendation");
        ob.getParamsMap().putAll(map);
        ob.execute();


    }


    public String Revise() {
        // Add event code here...


        ViewObject RecVo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row rowse = RecVo.getCurrentRow();


        ViewObject RecVo3 =
            ADFUtils.findIterator("RecommendHeader_VO3Iterator").getViewObject();
        // Row rowse3 = RecVo3.getCurrentRow();
        ViewCriteria offerDtlVC = RecVo3.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("RecommendNumber",
                                 rowse.getAttribute("RecommendNumber"));
        offerDtlVC.addRow(offerDtlVCR);
        RecVo3.applyViewCriteria(offerDtlVC);
        RecVo3.executeQuery();

        if (RecVo3.first().getAttribute("Status").equals("APR")) {


            Map map = new HashMap();
            String RecommendNumber =
                rowse.getAttribute("RecommendNumber").toString();
            String CreatedBy = rowse.getAttribute("CreatedBy").toString();
            map.put("recomNo", RecommendNumber);
            map.put("userId", CreatedBy);

            // rowse.setAttribute("Status", "DRA");


            OperationBinding ob =ADFUtils.findOperation("ReviseRecommendation");
            ob.getParamsMap().putAll(map);
            ob.execute();


        }


        return null;
    }


    public void onClickingBooking(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject vo=ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row r=vo.getCurrentRow();
        
        System.err.println("PRINT="+r.getAttribute("BookingId"));
        Object bookid=r.getAttribute("BookingId");
        Long count=recommendationvalidation(bookid);
        System.err.println("COUNT="+count);
        if (valueChangeEvent.getNewValue() != null) {
            if(count==0){
            onSumofReceiptFormBooking();
            }else
            {
                r.setAttribute("MilestoneName_Trans",null);
                r.setAttribute("BookingNo_Trans",null);
                r.setAttribute("LeaseStartDate_Trans",null);
                r.setAttribute("LeaseEndDate_Trans",null);
                r.setAttribute("BookingAmount_trans",null);
                r.setAttribute("InvoiceAmount_Trans",null);
                r.setAttribute("Payment_amount_Trans",null);
                r.setAttribute("Currency_Trans",null);
                r.setAttribute("OrgId",null);
                r.setAttribute("BookingId",null);
                r.setAttribute("BookingNo_Trans",null);
                JSFUtils.addFacesErrorMessage("Booking Number is already exist for another transaction");
            }
        }
    }

    public long recommendationvalidation(Object bookingid)
      {
          ViewObject vo=ADFUtils.findIterator("RecommendationDuplicate_ROVO1Iterator").getViewObject();   
                 ViewCriteria vc=vo.createViewCriteria();
                 vc.reset();
                 ViewCriteriaRow vcr=vc.createViewCriteriaRow();
                 vcr.setAttribute("BookingId",bookingid);
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
    public long submitrecommendationvalidation(Object bookingid)
      {
          ViewObject vo=ADFUtils.findIterator("RecommendationDuplicate_ROVO1Iterator").getViewObject();   
                 ViewCriteria vc=vo.createViewCriteria();
                 vc.reset();
                 ViewCriteriaRow vcr=vc.createViewCriteriaRow();
                 vcr.setAttribute("BookingId",bookingid);
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
//                               }
                               
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
    public void refrshBookingDtlVo2onEdit(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject bookingDtlVo =
            ADFUtils.findIterator("BookingDetail_VO2Iterator").getViewObject();

        ViewCriteria vwc = bookingDtlVo.createViewCriteria();
        ViewCriteriaRow vwcRow = vwc.createViewCriteriaRow();
        vwcRow.setAttribute("BookingId", row.getAttribute("BookingId"));
        vwc.addRow(vwcRow);
        bookingDtlVo.applyViewCriteria(vwc);
        bookingDtlVo.executeQuery();
               
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public void customRecommendSearch_QL(QueryEvent queryEvent) {
        DCIteratorBinding iter = (DCIteratorBinding) getBindings().get("SearchRecommendationRoVo1Iterator");
        /**Get Offer ViewObject from Iterator*/
        ViewObjectImpl vo = (ViewObjectImpl) iter.getViewObject();
        String unitDummy=null;
        if (vo.getNamedWhereClauseParam("b_unitNumDummy") != null) {
            unitDummy = vo.getNamedWhereClauseParam("b_unitNumDummy").toString();
            System.out.println("Booking UnitNumber:: "+unitDummy);
            vo.setNamedWhereClauseParam("b_unitNumTrans", unitDummy);
            vo.setNamedWhereClauseParam("b_unitNumDummy", null);
            }
        
        ADFUtils.invokeMethodExpression("#{bindings.SearchRecommVCQuery.processQuery}", Object.class,
                                        QueryEvent.class, queryEvent);
        if (unitDummy != null) {
            vo.setNamedWhereClauseParam("b_unitNumTrans", null);
            vo.setNamedWhereClauseParam("b_unitNumDummy", unitDummy);
            }
    }
    
    public boolean getApprovalUser() {
            ViewObject OfferHrdVO =
                ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
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
    
    public boolean getApprovalUser_rej() {
            ViewObject OfferHrdVO =
                ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
            boolean flag = false;
            String flowWith =
                OfferHrdVO.getCurrentRow().getAttribute("FlowWith") == null ?
                null :
                OfferHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
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
    public boolean getPaymentPlanChangeRender() {
            ViewObject rcHdrVo =
                ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
            boolean flag = true;
            String paymentPlanName =
                rcHdrVo.getCurrentRow().getAttribute("MilestoneName_Trans") == null ?
                "" :
                rcHdrVo.getCurrentRow().getAttribute("MilestoneName_Trans").toString();
            if (!paymentPlanName.equals("")) {
                if (paymentPlanName.contains("Single")) {
                    flag = false;
                } else {
                    flag = true;
                }
            } else {
                flag = true;
            }
            return flag;
        }
     
    public void exportToExcel(FacesContext facesContext,
                              java.io.OutputStream outputStream) {
        // Add event code here...
        try {

                                HSSFWorkbook workbook = new HSSFWorkbook();
                                HSSFSheet sheet =
                                    workbook.createSheet("Payments & Documents");
                                HSSFRow rowhead = sheet.createRow((short)0);
                                rowhead.createCell(0).setCellValue("Payments & Documents No");
                                sheet.setColumnWidth(0, 6000);
                                rowhead.createCell(1).setCellValue("Booking No");
                                sheet.setColumnWidth(1, 3000);
//                                rowhead.createCell(1).setCellValue("Property Name");
//                                sheet.setColumnWidth(1, 3000);
                                rowhead.createCell(2).setCellValue("Building Name");
                                sheet.setColumnWidth(2, 6000);
                                rowhead.createCell(3).setCellValue("Unit Name");
                                sheet.setColumnWidth(3, 3000);
                                rowhead.createCell(4).setCellValue("Customer Name");
                                sheet.setColumnWidth(4, 6500);
                                rowhead.createCell(5).setCellValue("RC Status");
                                sheet.setColumnWidth(5, 3500);
                                rowhead.createCell(6).setCellValue("RC Sub Status");
                                sheet.setColumnWidth(6, 4500);
                                rowhead.createCell(7).setCellValue("Unit Status");
                                sheet.setColumnWidth(7, 3500);
                                rowhead.createCell(8).setCellValue("Payment Plan");
                                sheet.setColumnWidth(8, 5000);
                                rowhead.createCell(9).setCellValue("Lease Start Date");
                                sheet.setColumnWidth(9, 3500);
                                rowhead.createCell(10).setCellValue("Lease End Date");
                                sheet.setColumnWidth(10, 3500);
                                rowhead.createCell(11).setCellValue("Creation Date");
                                sheet.setColumnWidth(11, 3500);
                                rowhead.createCell(12).setCellValue("Currency");
                                sheet.setColumnWidth(12, 3500);
                                rowhead.createCell(13).setCellValue("Set Rent");
                                sheet.setColumnWidth(13, 3500);
                                rowhead.createCell(14).setCellValue("Net Rent");
                                sheet.setColumnWidth(14, 3500);
                                rowhead.createCell(15).setCellValue("Discount");
                                sheet.setColumnWidth(15, 3500);
                                rowhead.createCell(16).setCellValue("Tax Amount");
                                sheet.setColumnWidth(16, 3500);
                                rowhead.createCell(17).setCellValue("Unit Description");
                                sheet.setColumnWidth(17, 5500);
                                rowhead.createCell(18).setCellValue("Mobile No");
                                sheet.setColumnWidth(18, 4500);
                                rowhead.createCell(19).setCellValue("Phone No");
                                sheet.setColumnWidth(19, 4500);
                                rowhead.createCell(20).setCellValue("Email Id");
                                sheet.setColumnWidth(20, 6000);
                                rowhead.createCell(21).setCellValue("Offer Flag");
                                sheet.setColumnWidth(21, 4500);
                                
                                ViewObject actVO =
                                    ADFUtils.findIterator("SearchRecommendationRoVo1Iterator").getViewObject();
                                actVO.executeQuery();
                                if (actVO.getEstimatedRowCount() > 0) {
                                    RowSetIterator rs = actVO.createRowSetIterator(null);
                                    int excelRowData = 1;
                                    while (rs.hasNext()) {
                                        Row actRow = rs.next();
                                        String recoNo =
                                            actRow.getAttribute("RecommendNumber") != null ?
                                            actRow.getAttribute("RecommendNumber").toString() : 
                                                                    "";
                                        String bookingNo =
                                            actRow.getAttribute("BookingnumberTrans") != null ?
                                            actRow.getAttribute("BookingnumberTrans").toString() :
                                            "";
                                        String buildName =
                                            actRow.getAttribute("Buildname") != null ?
                                            actRow.getAttribute("Buildname").toString() :
                                            "";
                                        String unitName =
                                            actRow.getAttribute("Unitname") != null ?
                                            actRow.getAttribute("Unitname").toString() :
                                            "";
                                        String custName =
                                            actRow.getAttribute("CustName") != null ?
                                            actRow.getAttribute("CustName").toString() : 
                                                                                "";
                                                                        String rcStatus =    actRow.getAttribute("Status")==null ? "" 
                                            : actRow.getAttribute("Status").toString().equalsIgnoreCase("DRA") ? "Draft"
                                            : actRow.getAttribute("Status").toString().equalsIgnoreCase("PEN") ? "Pending"
                                            : actRow.getAttribute("Status").toString().equalsIgnoreCase("APR") ? "Approved"
                                            : actRow.getAttribute("Status").toString().equalsIgnoreCase("BO") ? "Booked"
                                            : actRow.getAttribute("Status").toString().equalsIgnoreCase("REJ") ? "Rejected"
                                            : actRow.getAttribute("Status").toString().equalsIgnoreCase("CANC") ? "Cancelled"
                                            : actRow.getAttribute("Status").toString();
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
                                            actRow.getAttribute("SubStatus").toString() :
                                            "";
                                        String msName =
                                            actRow.getAttribute("MilestonenameTrans") != null ? 
                                            actRow.getAttribute("MilestonenameTrans").toString() :
                                            "";
                                        String fromDate =
                                            actRow.getAttribute("LeasestartdateTrans") != null ?
                                            actRow.getAttribute("LeasestartdateTrans").toString() :
                                            "";
                                        String toDate =
                                            actRow.getAttribute("LeaseenddateTrans") != null ?
                                            actRow.getAttribute("LeaseenddateTrans").toString() :
                                            "";
                                        String createDate =
                                            actRow.getAttribute("CreateDate") != null ?
                                            actRow.getAttribute("CreateDate").toString() :
                                            "";
                                        String currency =
                                            actRow.getAttribute("CurrencyTrans") != null ?
                                            actRow.getAttribute("CurrencyTrans").toString() :
                                            "";
                                        String setRent =
                                            actRow.getAttribute("SetRent") != null ?
                                            actRow.getAttribute("SetRent").toString() :
                                            "";
                                        String netRent =
                                            actRow.getAttribute("NetRent") != null ?
                                            actRow.getAttribute("NetRent").toString() :
                                            "";
                                        String disValue =
                                            actRow.getAttribute("DiscAmt") != null ?
                                            actRow.getAttribute("DiscAmt").toString() :
                                            "";
                                        String taxAmt =
                                            actRow.getAttribute("TaxAmount") != null ?
                                            actRow.getAttribute("TaxAmount").toString() :
                                            "";
                                        String unitDescription =
                                            actRow.getAttribute("UnitDescription") != null ?
                                            actRow.getAttribute("UnitDescription").toString() :
                                            "";
                                        String mblNo =
                                            actRow.getAttribute("MobileNumber") != null ?
                                            actRow.getAttribute("MobileNumber").toString() :
                                            "";
                                        String phNo =
                                            actRow.getAttribute("PhoneNumber") != null ?
                                            actRow.getAttribute("PhoneNumber").toString() :
                                            "";
                                        String emailId =
                                            actRow.getAttribute("EmailId") != null ?
                                            actRow.getAttribute("EmailId").toString() :
                                            "";
                                        String offerFlag =
                                              actRow.getAttribute("OfferFlag") == null ? ""
                                            : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("N") ? "New" 
                                            : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("R") ? "Renewal"
                                            : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("S") ? "Short Renewal"
                                            : "";

                                        HSSFRow row = sheet.createRow((short)excelRowData);
                                        row.createCell(0).setCellValue(recoNo);
                                        row.createCell(1).setCellValue(bookingNo);
                                        row.createCell(2).setCellValue(buildName);
                                        row.createCell(3).setCellValue(unitName);
                                        row.createCell(4).setCellValue(custName);
                                        row.createCell(5).setCellValue(rcStatus);
                                        row.createCell(6).setCellValue(subStatus);
                                        row.createCell(7).setCellValue(unitStatus);
                                        row.createCell(8).setCellValue(msName);
                                        row.createCell(9).setCellValue(fromDate);
                                        row.createCell(10).setCellValue(toDate);
                                        row.createCell(11).setCellValue(createDate);
                                        row.createCell(12).setCellValue(currency);
                                        row.createCell(13).setCellValue(setRent);
                                        row.createCell(14).setCellValue(netRent);
                                        row.createCell(15).setCellValue(disValue);
                                        row.createCell(16).setCellValue(taxAmt);
                                        row.createCell(17).setCellValue(unitDescription);
                                        row.createCell(18).setCellValue(mblNo);
                                        row.createCell(19).setCellValue(phNo);
                                        row.createCell(20).setCellValue(emailId);
                                        row.createCell(21).setCellValue(offerFlag);
                                                                        
                                        excelRowData++;
                                    }
                                }
                                workbook.write(outputStream);
                                outputStream.flush();
                            } catch (Exception e) {
                                System.err.println("BDS" + e.getMessage());
                            }
    }

    public void setGil2(RichGoImageLink gil2) {
        this.gil2 = gil2;
    }

    public RichGoImageLink getGil2() {
        return gil2;
    }

    public void setPopup5(RichPopup popup5) {
        this.popup5 = popup5;
    }

    public RichPopup getPopup5() {
        return popup5;
    }

    public void onClickDelete(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Delete1").execute();
        ADFUtils.findOperation("Commit").execute();
    }
    //auto create LA
    public void onClickForLA() {
        // Add event code here...
        ViewObject vo=ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row r=vo.getCurrentRow();
        String recomNo=r.getAttribute("RecommendNumber")==null?"null":r.getAttribute("RecommendNumber").toString();
        System.out.println("onClickForLA Recom No ::"+ recomNo );
          OperationBinding op=ADFUtils.findOperation("autoLeaseLA");
          op.getParamsMap().put("recomNo",recomNo);
          op.getParamsMap().put("userId","null");
          String flag=op.execute().toString();
          JSFUtils.addFacesInformationMessage(flag);
        
    }
    //for AckFlag from addEditRC screen itself
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
             this.getIt70().setValue(uName);
             
            }else{
    //                this.getId7().setValue(null);
                r.setAttribute("AckDate", null);
                this.getIt70().setValue(null);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.sbc1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.it70);
    }

    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }

    public void setIt70(RichInputText it70) {
        this.it70 = it70;
    }

    public RichInputText getIt70() {
        return it70;
    }
    //for auto create OC transaction
    public void onClickForOC() {
        // Add event code here...
        ViewObject vo=ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        ViewCriteria vwc = vo.createViewCriteria();
        ViewCriteriaRow vwcRow = vwc.createViewCriteriaRow();
        vwcRow.setAttribute("RecommendId", row.getAttribute("RecommendId"));
        vwc.addRow(vwcRow);
        vo.applyViewCriteria(vwc);
        vo.executeQuery();
        if (vo.getEstimatedRowCount()> 0){
        String leaseNo=vo.first().getAttribute("LeaseNumber")==null?"null":vo.first().getAttribute("LeaseNumber").toString();
        System.out.println("onClickForOC Lease No ::"+ leaseNo );
          OperationBinding op=ADFUtils.findOperation("autoCreateOC");
          op.getParamsMap().put("leaseNo",leaseNo);
          op.getParamsMap().put("userId","null");
          String flag=op.execute().toString();
          JSFUtils.addFacesInformationMessage(flag);
        }
    }
//for inserting oc lines for security depo
    public void doAddOcSecDepoLines(ActionEvent actionEvent) {
        // Add event code here...
        Object recommendationListener =
            JSFUtils.resolveExpression("#{pageFlowScope.TransId}");
        //        if (recommendationListener.equals("OT")) {
         if (recommendationListener.equals("OC")) {
            ViewObject bookingMilestoneDtlVo =
                ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
            ADFUtils.findOperation("CreateInsert2").execute();
        //            RecoomenHdrVo.getCurrentRow().getAttribute("OrgId");
            bookingMilestoneDtlVo.getCurrentRow().setAttribute("OfferRecoOrgId", RecoomenHdrVo.getCurrentRow().getAttribute("OrgId"));
            System.out.println("Booking Milestone Detail Id : "+bookingMilestoneDtlVo.getCurrentRow().getAttribute("BookingMsDtlId"));
//            AdfFacesContext.getCurrentInstance().addPartialTarget(t6);
        }
    }
    //creating receipt for all sec depo
    public String onCreateReceiptForSecDepo() {


        ViewObject vo =
            ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));
        ViewObject BMtlvo =
                    ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
                Row BMrows = BMtlvo.getCurrentRow();
        ViewObject offerLnsVO2 =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        ViewCriteria vc = offerLnsVO2.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();

        vcRow.setAttribute("BookingId", row.getAttribute("BookingId"));
        vc.addRow(vcRow);
        offerLnsVO2.applyViewCriteria(vc);
        offerLnsVO2.executeQuery();

        if (offerLnsVO2.getEstimatedRowCount() > 0) {
            Row cusRow = offerLnsVO2.first();
            
            ADFContext.getCurrent().getPageFlowScope().put("funcId",
                                                           row.getAttribute("FuncId") ==
                                                           null ? "" :
                                                           row.getAttribute("FuncId"));
            ADFContext.getCurrent().getPageFlowScope().put("scfnId",
                                                           row.getAttribute("RecommendId") ==
                                                           null ? "" :
                                                           row.getAttribute("RecommendId"));
            ADFContext.getCurrent().getPageFlowScope().put("OrgId",
                                                           row.getAttribute("OrgId") ==
                                                           null ? "" :
                                                           row.getAttribute("OrgId"));
            ADFContext.getCurrent().getPageFlowScope().put("CustName",
                                                           cusRow.getAttribute("CustName") ==
                                                           null ? "" :
                                                           cusRow.getAttribute("CustName"));
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
             //15-Nov-22 for oc divide based on vat and non vat//for attribute6
             String isVat = ADFContext.getCurrent().getPageFlowScope().get("isVat")==null ? "NO_VAT" : ADFContext.getCurrent().getPageFlowScope().get("isVat").toString();
             //08-sep-2020 for all receipts to capture BookingMsDtlId in receipt Attribute3 mainly for OC report
             String bkMsdtlId = BMrows.getAttribute("BookingMsDtlId") == null ? "" : BMrows.getAttribute("BookingMsDtlId").toString();
             System.out.println("bkMsdtlId ::"+bkMsdtlId);
             ADFContext.getCurrent().getPageFlowScope().put("remark", bkMsdtlId);
             //17-sep-2020 for security deposit SD payment mode
             ADFContext.getCurrent().getPageFlowScope().put("SDPayMode","SD");
             ADFContext.getCurrent().getPageFlowScope().put("modeType","SD");
            //passing null as to avoid pagePlowScope
            ADFContext.getCurrent().getPageFlowScope().put("DueDate", "" );
          String a = ADFContext.getCurrent().getPageFlowScope().get("A").toString();
          System.out.println("a : "+a);
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
//                ADFContext.getCurrent().getPageFlowScope().put("OrgId", "300000001937178" );
                ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "DV" );
                ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "Developer Charges" );
            }
        }

         }
        return "receipt";
    }

    public void doChangeStatusToDraft(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject vo=ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row=vo.getCurrentRow();
        ViewObject funApvHistRoVo = ADFUtils.findIterator("getApprovalHistoryROVo1Iterator").getViewObject();
        System.err.println("Recommend ID="+row.getAttribute("RecommendId"));
        String status = row.getAttribute("Status") == null ? "" : row.getAttribute("Status").toString();
        String rcId = row.getAttribute("RecommendId") == null ? "" : row.getAttribute("RecommendId").toString();
        String userId =
            ADFContext.getCurrent().getSessionScope().get("userId") == null ?
            null :
            ADFContext.getCurrent().getSessionScope().get("userId").toString();
        String funcId = row.getAttribute("FuncId") == null ? "0" : row.getAttribute("FuncId").toString();
        String reason = "Request Change to Draft";
        System.out.println("Status :"+status);
        
        ViewObject bkHdrVo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        ViewCriteria ovc = bkHdrVo.createViewCriteria();
        ViewCriteriaRow ovcRow = ovc.createViewCriteriaRow();
        ovcRow.setAttribute("BookingId1",row.getAttribute("BookingId"));
        ovc.addRow(ovcRow);
        bkHdrVo.applyViewCriteria(ovc);
        bkHdrVo.executeQuery();
        if (bkHdrVo.getEstimatedRowCount() != 1) {
        } else {
        String ofStatus = bkHdrVo.first().getAttribute("Status1")==null ? "" : bkHdrVo.first().getAttribute("Status1").toString();
        if (ofStatus.equalsIgnoreCase("BO")){
//        bkHdrVo.first().setAttribute("Status1", "APR");
        }
        }
//        row.setAttribute("Status", "DRA");
        //calling pkg
        onDirectToDraft(rcId,userId,funcId,reason);
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Changes done Successfully");
    }
    //for move In process through Rightnow to exclude car parking
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

    public void onDirectRejectionClickonDrft(ActionEvent actionEvent) {
        // Add event code here...
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getP20().show(popup34);
    }

    public void onclickDirectRejectionDraft(ActionEvent actionEvent) {
        // Add event code here...
        String ResultVal = null;
        ViewObject vo = ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String rcId = row.getAttribute("RecommendId") == null ? "" : row.getAttribute("RecommendId").toString();
        String funcId = row.getAttribute("FuncId") == null ? "" : row.getAttribute("FuncId").toString();
        String userId = ADFContext.getCurrent().getSessionScope().get("userId") == null ?
                    null :
                    ADFContext.getCurrent().getSessionScope().get("userId").toString();        
        String Reason = this.dirctRejctReason.getValue() == null ? "Rejected" : this.dirctRejctReason.getValue().toString();
//        row.setAttribute("FlowStatus", null);
//        row.setAttribute("FlowLevel", null);
//        row.setAttribute("FlowWith", null);
        //        row.setAttribute("UserGrpId", null);
//        row.setAttribute("Status", "REJ");
        onDoDirectRejection(rcId,userId,funcId,Reason);
    }
    
    public void onDoDirectRejection(String rcId,String userId,String funcId,String reason){
    
          OperationBinding op=ADFUtils.findOperation("directRejectionFromDraft");
          op.getParamsMap().put("rcId",rcId);
          op.getParamsMap().put("userId",userId);
          op.getParamsMap().put("funcId",funcId);
          op.getParamsMap().put("reason",reason);
          String flag=op.execute().toString();
          JSFUtils.addFacesInformationMessage(flag);
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

    public void setP20(RichPopup p20) {
        this.p20 = p20;
    }

    public RichPopup getP20() {
        return p20;
    }

    public void setDirctRejctReason(RichInputText dirctRejctReason) {
        this.dirctRejctReason = dirctRejctReason;
    }

    public RichInputText getDirctRejctReason() {
        return dirctRejctReason;
    }

    public void doChngPaymentPlan(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void onSelectPaymentPlanChng(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String mileHrdId=null;
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject vo = ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String paymentPlanName = row.getAttribute("MilestoneName_Trans") == null ?
                                 "" :
                                 row.getAttribute("MilestoneName_Trans").toString();
        if (paymentPlanName.contains("Single")) {
//            System.out.println("Single PPlan");
            JSFUtils.addFacesErrorMessage("Single Payment Plan is not changable !!!");
        } else {            
        String bkId = row.getAttribute("BookingId") == null ? "" : row.getAttribute("BookingId").toString();
        mileHrdId = valueChangeEvent.getNewValue() == null ? null : valueChangeEvent.getNewValue().toString();
        String userName =
            ADFContext.getCurrent().getSessionScope().get("userName") == null ?
            null :
            ADFContext.getCurrent().getSessionScope().get("userName").toString();
        System.out.println("bkId :"+bkId+" mileHrdId : "+mileHrdId);
        if (valueChangeEvent.getNewValue() != null) {
            OperationBinding op=ADFUtils.findOperation("paymentPlanChange");
            op.getParamsMap().put("bkId",bkId);
            op.getParamsMap().put("mileHrdId",mileHrdId);
            op.getParamsMap().put("userName",userName);
            String flag=op.execute().toString();
            JSFUtils.addFacesInformationMessage(flag);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(t6);
        AdfFacesContext.getCurrentInstance().addPartialTarget(it5);
        }
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void doEntrAmtOcLine(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ViewObject bkMsdtlVo2 = ADFUtils.findIterator("Booking_Milestone_VO2Iterator").getViewObject();
        Row r = bkMsdtlVo2.getCurrentRow();
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
                    taxamtBD = taxamtBD.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    totlAmtBD = amtBD.add(taxamtBD);
                }
                r.setAttribute("InstallmentAmount", totlAmtBD);
                r.setAttribute("Attribute3", taxamtBD);
    }

    public void doSelectTaxCodeOcLine(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ViewObject bkMsdtlVo2 = ADFUtils.findIterator("Booking_Milestone_VO2Iterator").getViewObject();
        Row r = bkMsdtlVo2.getCurrentRow();
                String taxCode=null;
                BigDecimal taxCbd = new BigDecimal(0);
                BigDecimal amtBD = new BigDecimal(0);
                BigDecimal taxamtBD = new BigDecimal(0);
                BigDecimal percntBD = new BigDecimal(100);
                BigDecimal totlAmtBD = new BigDecimal(0);
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

    public void onEntrrOcSecDepLineAmt(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ViewObject bkMsdtlVo2 = ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        Row r = bkMsdtlVo2.getCurrentRow();
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
                    taxamtBD = taxamtBD.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    totlAmtBD = amtBD.add(taxamtBD);
                }
                r.setAttribute("InstallmentAmount", totlAmtBD);
                r.setAttribute("Attribute3", taxamtBD);
    }

    public void onSelectTaxOCSecDepoLine(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ViewObject bkMsdtlVo2 = ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        Row r = bkMsdtlVo2.getCurrentRow();
                String taxCode=null;
                BigDecimal taxCbd = new BigDecimal(0);
                BigDecimal amtBD = new BigDecimal(0);
                BigDecimal taxamtBD = new BigDecimal(0);
                BigDecimal percntBD = new BigDecimal(100);
                BigDecimal totlAmtBD = new BigDecimal(0);
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

    public void setPopup27(RichPopup popup27) {
        this.popup27 = popup27;
    }

    public RichPopup getPopup27() {
        return popup27;
    }
}
