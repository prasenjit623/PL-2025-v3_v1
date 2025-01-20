package view.backing;

import com.model.util.CommonJBOException;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.StringReader;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.ReturnPopupEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.event.ReturnEvent;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

import view.WsPayloadForCreateAccounts;

public class AddEditOtherChargesBb {
    private RichInputListOfValues leaseAgreId_Trans;
    private RichInputText leaseAgreeId;
    private RichPopup popUp1;
    private RichInputText reason;
    private RichTable table_t4;
    private RichInputText othersTotalRate;
    private RichInputText receiptTotal;
    private static String propertyBundle =
        "view.PropertyLease_ViewControllerBundle";
    private RichSelectOneChoice oc_type;
    private RichTable table_t8;
    private RichInputText receiptResponse;
    private RichPanelFormLayout getOtherChargesform;
    private RichSelectOneRadio ocFlag;
    private RichInputListOfValues cancelNo;
    private RichTable table_t11;
    private RichCommandButton generate_invoice_cb3;
    private RichPopup popup5;
    private RichTable t13;
    private RichSelectBooleanCheckbox sbc1;
    private RichInputText it70;
    private RichInputDate id7;
    private RichInputDate id8;

    public AddEditOtherChargesBb() {
        super();
    }

    ViewObject ocHdrVo =
        ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
    ViewObject leaseAgrmtVo =
        ADFUtils.findIterator("SearchLeaseAgreement_ROVO1Iterator").getViewObject();
    ViewObject bookingMsVo =
        ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
    ViewObject receiptVo =
        ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
    ViewObject receiptVo6 =
        ADFUtils.findIterator("Receipt_VO6Iterator").getViewObject();


    public void onSelectOfBookingNo(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //        if(valueChangeEvent.getNewValue()!= valueChangeEvent.getOldValue()){
        //                             ViewCriteria leaseAgrmtVC = leaseAgrmtVo.createViewCriteria();
        //                             ViewCriteriaRow leaseAgrmtVCR = leaseAgrmtVC.createViewCriteriaRow();
        //                             leaseAgrmtVCR.setAttribute("BookingId", ocHdrVo.getCurrentRow().getAttribute("BookingId"));
        //                             leaseAgrmtVC.addRow(leaseAgrmtVCR);
        //                             leaseAgrmtVo.applyViewCriteria(leaseAgrmtVC);
        //                             leaseAgrmtVo.executeQuery();
        //                             System.out.println("count for refresh "+leaseAgrmtVo.getEstimatedRowCount());
        //            if(leaseAgrmtVo.getEstimatedRowCount()==0){
        //                    this.getLeaseAgreId_Trans().setValue(null);
        //                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.getLeaseAgreId_Trans());
        //                         }
        //        }
        if (valueChangeEvent.getNewValue() != null) {
            Object ocHdrId = ocHdrVo.getCurrentRow().getAttribute("OcHdrId");
            createOtherChargesOnClickBookingNo(ocHdrId);
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
        }
    }

    public String createOtherChargesOnClickBookingNo(Object ocHdrId) {
        ADFContext.getCurrent().getPageFlowScope().put("ocHdrId", ocHdrId);
        ocHdrVo.getCurrentRow().getAttribute("BookingId");
        System.out.println("lease id from oc header :: " +
                           ocHdrVo.getCurrentRow().getAttribute("LeaseAgreementId"));
        System.out.println("BookingId_Trans " +
                           ocHdrVo.getCurrentRow().getAttribute("BookingId_Trans"));
        System.out.println("BookingId " +
                           ocHdrVo.getCurrentRow().getAttribute("BookingId"));
        ViewCriteria leaseAgrmtVC = leaseAgrmtVo.createViewCriteria();
        ViewCriteriaRow leaseAgrmtVCR = leaseAgrmtVC.createViewCriteriaRow();
        //        leaseAgrmtVCR.setAttribute("LeaseAgreementId", ocHdrVo.getCurrentRow().getAttribute("LeaseAgreementId"));
        leaseAgrmtVCR.setAttribute("BookingId",
                                   ocHdrVo.getCurrentRow().getAttribute("BookingId"));
        leaseAgrmtVC.addRow(leaseAgrmtVCR);
        leaseAgrmtVo.applyViewCriteria(leaseAgrmtVC);
        leaseAgrmtVo.executeQuery();
        System.out.println("Estimated row count " +
                           leaseAgrmtVo.getEstimatedRowCount());
        if (leaseAgrmtVo.getEstimatedRowCount() > 0) {
            Row r = leaseAgrmtVo.first();
            Object leaseAgreementId = r.getAttribute("LeaseAgreementId");
            System.out.println("LeaseAgreementId from Lease table " +
                               r.getAttribute("LeaseAgreementId"));
            ocHdrVo.getCurrentRow().setAttribute("LeaseAgreementId",
                                                 leaseAgreementId);
        }
        return "success";
    }

    public void onSelectOfLeaseNo(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            Object ocHdrId = ocHdrVo.getCurrentRow().getAttribute("OcHdrId");
            createOtherConClickLeaseNo(ocHdrId);
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(t4);

        }
        if (bookingMsVo.getEstimatedRowCount() != 0) {
        ocHdrVo.getCurrentRow().setAttribute("DestinationBu", "300000001937178");
        }
    }

    public String createOtherConClickLeaseNo(Object ocHdrId) {
        ADFContext.getCurrent().getPageFlowScope().put("ocHdrId", ocHdrId);
        ocHdrVo.getCurrentRow().getAttribute("LeaseAgreementId");
        ViewCriteria leaseAgrmtVC = leaseAgrmtVo.createViewCriteria();
        ViewCriteriaRow leaseAgrmtVCR = leaseAgrmtVC.createViewCriteriaRow();
        leaseAgrmtVCR.setAttribute("LeaseAgreementId",
                                   ocHdrVo.getCurrentRow().getAttribute("LeaseAgreementId"));
        leaseAgrmtVC.addRow(leaseAgrmtVCR);
        leaseAgrmtVo.applyViewCriteria(leaseAgrmtVC);
        leaseAgrmtVo.executeQuery();
        System.out.println("Estimated row count " +
                           leaseAgrmtVo.getEstimatedRowCount());
        if (leaseAgrmtVo.getEstimatedRowCount() > 0) {
            Row r = leaseAgrmtVo.first();
            Object bookingId = r.getAttribute("BookingId");
            System.out.println("BookingId from Lease table " +
                               r.getAttribute("BookingId"));
            ocHdrVo.getCurrentRow().setAttribute("BookingId", bookingId);
        }
        return "success";
    }

    public void doSave(ActionEvent actionEvent) {
        String status = ocHdrVo.getCurrentRow().getAttribute("Status")==null ? "" : ocHdrVo.getCurrentRow().getAttribute("Status").toString();
        if (status.equalsIgnoreCase("DRA")){
        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("N")){
        System.out.println("during save ocDtl data " +
                           bookingMsVo.getEstimatedRowCount());
        if (bookingMsVo.getEstimatedRowCount() != 0) {

            if (ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber") ==
                null) {
                //genarating oc no
                String name =
                    xxfnd.generateDocNo("OC", "OtherChargesAppModuleDataControl").toString();
                Object valu = name;
                ocHdrVo.getCurrentRow().setAttribute("OtherChargesNumber",
                                                     valu);
                //setting func_id
                ViewObject getFuncodeVo =
                    ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                getFuncodeVo.setNamedWhereClauseParam("F_ID", "OC");
                getFuncodeVo.executeQuery();
                ocHdrVo.getCurrentRow().setAttribute("FuncId",
                                                     getFuncodeVo.first().getAttribute("FuncId"));
                //
            }
            //17-May for setting othersTotalRate in oc
            doCalculate();
            onSaveSetOcId();
            System.out.println("OC Total oc :: " +
                               ocHdrVo.getCurrentRow().getAttribute("OthersTotalRate"));
            System.out.println("Receipt Total oc :: " +
                               ocHdrVo.getCurrentRow().getAttribute("ReceiptTotal"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(othersTotalRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(receiptTotal);
            //
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Other Charges Saved.....!");
        } else {
            JSFUtils.addFacesErrorMessage("Create Other Charges Detail !!!");
        }
        }
        
        //IF OcFlag is Cancellation then
        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("C")){
            ViewObject bookingMsVo4 =
                ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
            System.out.println("during save ocDtl for OcFlag C data " +
                               bookingMsVo4.getEstimatedRowCount());
            if (bookingMsVo4.getEstimatedRowCount() != 0) {

                if (ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber") ==
                    null) {
                    //genarating oc no
                    String name =
                        xxfnd.generateDocNo("OC", "OtherChargesAppModuleDataControl").toString();
                    Object valu = name;
                    ocHdrVo.getCurrentRow().setAttribute("OtherChargesNumber",
                                                         valu);
                    //setting func_id
                    ViewObject getFuncodeVo =
                        ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                    getFuncodeVo.setNamedWhereClauseParam("F_ID", "OC");
                    getFuncodeVo.executeQuery();
                    ocHdrVo.getCurrentRow().setAttribute("FuncId",
                                                         getFuncodeVo.first().getAttribute("FuncId"));
                    //
                }
                //17-May for setting othersTotalRate in oc
                doCalculateForCancel();
                onSaveSetOcIdForCancellation();
                System.out.println("OC Total oc :: " +
                                   ocHdrVo.getCurrentRow().getAttribute("OthersTotalRate"));
                System.out.println("Receipt Total oc :: " +
                                   ocHdrVo.getCurrentRow().getAttribute("ReceiptTotal"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(othersTotalRate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(receiptTotal);
                //
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Other Charges Saved.....!");
            } else {
                JSFUtils.addFacesErrorMessage("Create Other Charges Detail !!!");
            }
        }
        }else{
            doCalForNotDraft();
            System.out.println("Not draft : "+status);
                    ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Changes Saved.....!");
        }
    }

    public void doCalculate() {
        //17-May for setting othersTotalRate in oc
        //        int total = 0;
        //        int rcptTotal = 0;
                BigDecimal total = new BigDecimal("0");
                BigDecimal rcptTotal = new BigDecimal("0");
                //for total oc calcu
                RowSetIterator bMsRsi = bookingMsVo.createRowSetIterator(null);
                while (bMsRsi.hasNext()) {
                    Row r = bMsRsi.next();
                    String InstllAmount =
                        r.getAttribute("InstallmentAmount") == null ? "0" :
                        r.getAttribute("InstallmentAmount").toString();
                    System.out.println("InstallmentAmount = " + InstllAmount);
        //            int instAmt = Integer.parseInt(InstllAmount);
                    BigDecimal instAmt = new BigDecimal(InstllAmount);
                    total = instAmt.add(total);
                }
                //for total receipt calcu
                String dBu = ocHdrVo.getCurrentRow().getAttribute("DestinationBu")== null ? "" : ocHdrVo.getCurrentRow().getAttribute("DestinationBu").toString();
                if (dBu.equals("300000001937178")){     
                RowSetIterator rRsi = receiptVo.createRowSetIterator(null);
                while (rRsi.hasNext()) {
                    Row row = rRsi.next();
                    String rcptAmt =
                        row.getAttribute("ReceivedAmount") == null ? "0" : row.getAttribute("ReceivedAmount").toString();
                    System.out.println("Receipt Amt = " + rcptAmt);
        //            int rAmt = Integer.parseInt(rcptAmt);
                    BigDecimal rAmt = new BigDecimal(rcptAmt);
                    rcptTotal = rAmt.add(rcptTotal);
                }
                }
                //11-May-2020
        if (!dBu.equals("300000001937178")){     
        RowSetIterator rRsi = receiptVo6.createRowSetIterator(null);
        while (rRsi.hasNext()) {
            Row row = rRsi.next();
            String rcptAmt =
                row.getAttribute("ReceivedAmount") == null ? "0" : row.getAttribute("ReceivedAmount").toString();
            System.out.println("Receipt Amt = " + rcptAmt);
        //            int rAmt = Integer.parseInt(rcptAmt);
            BigDecimal rAmt = new BigDecimal(rcptAmt);
            rcptTotal = rAmt.add(rcptTotal);
        }
        }
        ocHdrVo.getCurrentRow().setAttribute("OthersTotalRate", total);
        ocHdrVo.getCurrentRow().setAttribute("ReceiptTotal", rcptTotal);
    }
    
    public void doCalculateForCancel() {
        //17-May for setting othersTotalRate in oc
//        int total = 0;
        BigDecimal total = new BigDecimal("0");
//        int rcptTotal = 0;
        BigDecimal rcptTotal = new BigDecimal("0");
        BigDecimal instAmt = new BigDecimal("0");
        BigDecimal rAmt = new BigDecimal("0");
        //for total oc calcu
        ViewObject bookingMsVo4 =
            ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        ViewObject receiptVo4 =
            ADFUtils.findIterator("Receipt_VO4Iterator").getViewObject();
        RowSetIterator bMsRsi = bookingMsVo4.createRowSetIterator(null);
        while (bMsRsi.hasNext()) {
            Row r = bMsRsi.next();
            String InstllAmount =
                r.getAttribute("InstallmentAmount") == null ? "0" :
                r.getAttribute("InstallmentAmount").toString();
            System.out.println("InstallmentAmount = " + InstllAmount);
            instAmt = new BigDecimal(InstllAmount);
            total = instAmt.add(total);
        }
        //for total receipt calcu
        RowSetIterator rRsi = receiptVo4.createRowSetIterator(null);
        while (rRsi.hasNext()) {
            Row row = rRsi.next();
            String rcptAmt =
                row.getAttribute("ReceivedAmount") == null ? "0" : row.getAttribute("ReceivedAmount").toString();
            System.out.println("Receipt Amt = " + rcptAmt);
            rAmt = new BigDecimal(rcptAmt);
            rcptTotal = rAmt.add(rcptTotal);
        }
        ocHdrVo.getCurrentRow().setAttribute("OthersTotalRate", total);
        ocHdrVo.getCurrentRow().setAttribute("ReceiptTotal", rcptTotal);
    }


    public void setLeaseAgreId_Trans(RichInputListOfValues leaseAgreId_Trans) {
        this.leaseAgreId_Trans = leaseAgreId_Trans;
    }

    public RichInputListOfValues getLeaseAgreId_Trans() {
        return leaseAgreId_Trans;
    }

    public void setLeaseAgreeId(RichInputText leaseAgreeId) {
        this.leaseAgreeId = leaseAgreeId;
    }

    public RichInputText getLeaseAgreeId() {
        return leaseAgreeId;
    }

    public String onSaveAndClose() {
        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("N")){
        System.out.println("during save ocDtl data " +
                           bookingMsVo.getEstimatedRowCount());
        if (bookingMsVo.getEstimatedRowCount() > 0) {

            if (ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber") ==
                null) {
                //genarating oc no
                String name =
                    xxfnd.generateDocNo("OC", "OtherChargesAppModuleDataControl").toString();
                Object valu = name;
                ocHdrVo.getCurrentRow().setAttribute("OtherChargesNumber",
                                                     valu);
                //setting func_id
                ViewObject getFuncodeVo =
                    ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                getFuncodeVo.setNamedWhereClauseParam("F_ID", "OC");
                getFuncodeVo.executeQuery();
                ocHdrVo.getCurrentRow().setAttribute("FuncId",
                                                     getFuncodeVo.first().getAttribute("FuncId"));
                //
            }
            //17-May for setting othersTotalRate in oc
            doCalculate();
            onSaveSetOcId();
            System.out.println("OC Total oc :: " +
                               ocHdrVo.getCurrentRow().getAttribute("OthersTotalRate"));
            System.out.println("Receipt Total oc :: " +
                               ocHdrVo.getCurrentRow().getAttribute("ReceiptTotal"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(othersTotalRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(receiptTotal);
            //

            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Other Charges Saved.....!");

        } else {
            JSFUtils.addFacesErrorMessage("Create Other Charges Detail !!!");
        }

        return "back";
        }
        // when OcFlag is Cancellation 
        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("C")){
            ViewObject bookingMsVo4 =
                ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
            System.out.println("during save ocDtl data " + 
                               bookingMsVo4.getEstimatedRowCount());
            if (bookingMsVo4.getEstimatedRowCount() > 0) {

                if (ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber") ==
                    null) {
                    //genarating oc no
                    String name =
                        xxfnd.generateDocNo("OC", "OtherChargesAppModuleDataControl").toString();
                    Object valu = name;
                    ocHdrVo.getCurrentRow().setAttribute("OtherChargesNumber",
                                                         valu);
                    //setting func_id
                    ViewObject getFuncodeVo =
                        ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                    getFuncodeVo.setNamedWhereClauseParam("F_ID", "OC");
                    getFuncodeVo.executeQuery();
                    ocHdrVo.getCurrentRow().setAttribute("FuncId",
                                                         getFuncodeVo.first().getAttribute("FuncId"));
                    //
                }
                //17-May for setting othersTotalRate in oc
                doCalculateForCancel();
                onSaveSetOcIdForCancellation();
                System.out.println("OC Total oc :: " +
                                   ocHdrVo.getCurrentRow().getAttribute("OthersTotalRate"));
                System.out.println("Receipt Total oc :: " +
                                   ocHdrVo.getCurrentRow().getAttribute("ReceiptTotal"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(othersTotalRate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(receiptTotal);
                //

                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Other Charges Saved.....!");

            } else {
                JSFUtils.addFacesErrorMessage("Create Other Charges Detail !!!");
            }

            return "back";
        }
        return "";
    }


    public String onClickSubmit() {
        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("N")){
        if (bookingMsVo.getEstimatedRowCount() == 0) {
            JSFUtils.addFacesErrorMessage("Create Other Charges Detail !!!");
            return null;
        }
        }
        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("C")){
            ViewObject bookingMsVo4 =
                ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        if (bookingMsVo4.getEstimatedRowCount() == 0) {
            JSFUtils.addFacesErrorMessage("Create Other Charges Detail !!!");
            return null;
        }
        }
        if(ocHdrVo.getCurrentRow().getAttribute("DestinationBu") != null) {
//        if (ocHdrVo.getCurrentRow().getAttribute("BillToAddre") != null || ocHdrVo.getCurrentRow().getAttribute("ShipToAddre") != null){
        if (ocHdrVo.getCurrentRow().getAttribute("BillToAddre") != null ){
        onSaveAndClose();
        String totalOC =
            ocHdrVo.getCurrentRow().getAttribute("OthersTotalRate").toString();
        String totalRcpt =
            ocHdrVo.getCurrentRow().getAttribute("ReceiptTotal").toString();
        if (totalOC.equals(totalRcpt)) {
            String ResultVal = null;

            Row row = ocHdrVo.getCurrentRow();
            Object org = ocHdrVo.getCurrentRow().getAttribute("OrgId");
            Object prop = ocHdrVo.getCurrentRow().getAttribute("PropertyId");
            Object build = ocHdrVo.getCurrentRow().getAttribute("BuildingId");
            System.err.println("row.getAttribute(\"FuncId\") " +
                               row.getAttribute("FuncId"));
            try {
//                ResultVal =
//                        xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
//                                              row.getAttribute("FuncId"),
//                                              row.getAttribute("OcHdrId"), 0,
//                                              "XXPM_OC_HEADER", "STATUS",
//                                              "OC_HDR_ID", org, prop, build,
//                                              null, null);
          OperationBinding op=ADFUtils.findOperation("submitOcForAppr");
          op.getParamsMap().put("ocId",row.getAttribute("OcHdrId").toString());
          ResultVal=op.execute().toString();
//          JSFUtils.addFacesInformationMessage(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            System.out.println("resultVal after calling submit package :: " +
                               ResultVal);
            if (ResultVal.equalsIgnoreCase("Success")) {
                if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("N")){
                onChangeStatusForPending();
                }
                if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("C")){
                    onChangeStatusForPendingCancellation();
                }
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Submitted For Approval");
            } else {
                JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
            }
        } else {
            JSFUtils.addFacesErrorMessage("Total Receipt amt should be equal to Total Other Charges...!");
        }
        }else{
            JSFUtils.addFacesErrorMessage("Please select Bill To Address !!!");
            return null;
        }
        //09-May-2020
        //to show a info for creating penalty if OC types contains -Cheque returns or Cheque Replacement
        RowSetIterator rsi = null;
        //For OcFlag N
        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("N")){
        System.out.println("Estimate count BM VO1 :"+bookingMsVo.getEstimatedRowCount());           
            try {
                rsi = bookingMsVo.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    System.out.println("OC type in ocFlag N - "+ r.getAttribute("InstallmentType"));
                    String instType = r.getAttribute("InstallmentType") == null ? "" : r.getAttribute("InstallmentType").toString();
                    if (instType.equalsIgnoreCase("CHEQUE_RUTN_FEE") || instType.equalsIgnoreCase("CHEQUE_RUTN_AMD_SHJ") || instType.equalsIgnoreCase("CHEQUE_RUTN_AMD_DXB") || instType.equalsIgnoreCase("CHQ_REP_RES_SHJ_ALM")
                    || instType.equalsIgnoreCase("CHQ_REP_COM_SHJ_ALM") || instType.equalsIgnoreCase("CHQ_RUT_RES_SHJ_ALM") || instType.equalsIgnoreCase("CHQ_RUT_COM_SHJ_ALM") || instType.equalsIgnoreCase("CHQ_REP_DXB_ALM")
                    || instType.equalsIgnoreCase("CHQ_RUT_DXB_ALM") || instType.equalsIgnoreCase("CHQ_REP_PAYMENT_DUB") || instType.equalsIgnoreCase("CHQ_RUT_PAYMENT_DUB") || instType.equalsIgnoreCase("CHQ_REP_PAYMENT_SHJ")
                    || instType.equalsIgnoreCase("CHQ_RUT_PAYMENT_SHJ") ){
                        JSFUtils.addFacesInformationMessage("Please create Penalty against the Cheque Replacement or Return !!!");  
                    }
                }
            } catch (Exception e) {
                    System.out.println(e);
            } finally {
                rsi.closeRowSetIterator();
            }
        }
        //for ocFlag C
        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("C")){
            ViewObject bk_MsVo =
                ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        System.out.println("Estimate count BM VO1 :"+bk_MsVo.getEstimatedRowCount());           
            try {
                rsi = bk_MsVo.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    System.out.println("OC type in ocFlag C - "+ r.getAttribute("InstallmentType"));
                    String instType = r.getAttribute("InstallmentType") == null ? "" : r.getAttribute("InstallmentType").toString();
                    if (instType.equalsIgnoreCase("CHEQUE_RUTN_FEE") || instType.equalsIgnoreCase("CHEQUE_RUTN_AMD_SHJ") || instType.equalsIgnoreCase("CHEQUE_RUTN_AMD_DXB") || instType.equalsIgnoreCase("CHQ_REP_RES_SHJ_ALM")
                    || instType.equalsIgnoreCase("CHQ_REP_COM_SHJ_ALM") || instType.equalsIgnoreCase("CHQ_RUT_RES_SHJ_ALM") || instType.equalsIgnoreCase("CHQ_RUT_COM_SHJ_ALM") || instType.equalsIgnoreCase("CHQ_REP_DXB_ALM")
                    || instType.equalsIgnoreCase("CHQ_RUT_DXB_ALM") || instType.equalsIgnoreCase("CHQ_REP_PAYMENT_DUB") || instType.equalsIgnoreCase("CHQ_RUT_PAYMENT_DUB") || instType.equalsIgnoreCase("CHQ_REP_PAYMENT_SHJ")
                    || instType.equalsIgnoreCase("CHQ_RUT_PAYMENT_SHJ") ){
                        JSFUtils.addFacesInformationMessage("Please create Penalty against the Cheque Replacement or Return !!!");  
                    }
                }
            } catch (Exception e) {
                    System.out.println(e);
            } finally {
                rsi.closeRowSetIterator();
            }
        }
        //
        }
          else{
             JSFUtils.addFacesInformationMessage("Please select Destination BU");
         }

        return "back";
    }

    public String onClickAddOfDtl() {
        Row row = ocHdrVo.getCurrentRow();
        ocHdrVo.getCurrentRow().getAttribute("BookingId");
        bookingMsVo.first().setAttribute("BookingId",
                                         ocHdrVo.getCurrentRow().getAttribute("BookingId"));
        return null;
    }

    public void onInvokeAppOrReject(ActionEvent actionEvent) {
        //08-sep-2020 validation for approve only when all receipts are ack 
        String ackFlagStatus="Y";
                ViewObject rcptVo3 =
                    ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
                System.out.println("Count RcptVo1 :"+rcptVo3.getEstimatedRowCount());
        String action = ADFContext.getCurrent().getPageFlowScope().get("Action").toString();
        if (action.equalsIgnoreCase("Rejection")){
        //            System.out.println("Rejection action :"+action);
        }else{
                if (rcptVo3.getEstimatedRowCount() > 0) {
                RowSetIterator rs = rcptVo3.createRowSet(null);
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
        this.getPopUp1().show(popup34);
        }else{
                    JSFUtils.addFacesErrorMessage("Please Acknowledge all the receipts before approval"); 
                }
    }

    public void setPopUp1(RichPopup popUp1) {
        this.popUp1 = popUp1;
    }

    public RichPopup getPopUp1() {
        return popUp1;
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

//    public void onClickApprove(ActionEvent actionEvent) {
//        String result = "Y";
//        if (result == "Y") {
//            Map<String, BigDecimal> ResultVal =
//                new HashMap<String, BigDecimal>();
//            ViewObject vo =
//                ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
//            Row row = vo.getCurrentRow();
//            String Reason = 
//                this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
//            //
//            System.out.println("func id :: " + row.getAttribute("FuncId"));
//            System.out.println("OcHdrId id :: " + row.getAttribute("OcHdrId"));
//            System.out.println("UserGrpId id :: " + row.getAttribute("UserGrpId"));
//            System.out.println("FlowLevel id :: " + row.getAttribute("FlowLevel"));
//            System.out.println("FlowWith id :: " + row.getAttribute("FlowWith"));
//            //
//            try {
//                ResultVal =
//                        xxfnd.invokeResponsePkgs("xxfnd_util_pkg.update_response",
//                                                 row.getAttribute("FuncId"),
//                                                 row.getAttribute("OcHdrId"),
//                                                 row.getAttribute("UserGrpId"),
//                                                 row.getAttribute("FlowLevel"),
//                                                 row.getAttribute("FlowWith"),
//                                                 Reason, "A", 0,
//                                                 "XXPM_OC_HEADER", "STATUS",
//                                                 "OC_HDR_ID");
//
//
//            } catch (SQLException e) {
//                System.err.println("ERROR" + e);
//            }
//            //ResultVal
//            System.err.println("ERROR" + ResultVal);
//
//
//            for (Map.Entry m : ResultVal.entrySet()) {
//                System.out.println("KEY" + m.getKey() + "VALUE " +
//                                   m.getValue());
//
//                if (m.getKey().equals("Success")) {
//                    //vo.executeQuery();
//
//                    String ress =
//                        m.getValue() == null ? "null" : m.getValue().toString();
//                    if (ress.equals("null")) {
//
//                    }
//                    //04-June  for change of status of Milestone and Receipt
//                    String status = row.getAttribute("Status").toString();
////                    if (status.equalsIgnoreCase("APR")) {
//                          onChangeStatus();
////                        onSaveSetOcId();
////                    }
//                    //
//
//                    ADFUtils.findOperation("Commit").execute();
//                    JSFUtils.addFacesInformationMessage("Approved....");
//                } else {
//                    JSFUtils.addFacesErrorMessage("Error in Approve process!");
//                }
//            }
//        }
//    }
    
    public void onClickApprove(ActionEvent actionEvent) {
        String result = "Y";
        if (result == "Y") {
            String ResultVal = null;
            ViewObject vo =
                ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
            Row row = vo.getCurrentRow();
            String Reason = 
                this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
            //
            System.out.println("func id :: " + row.getAttribute("FuncId"));
            System.out.println("OcHdrId id :: " + row.getAttribute("OcHdrId"));
            System.out.println("UserGrpId id :: " + row.getAttribute("UserGrpId"));
            System.out.println("FlowLevel id :: " + row.getAttribute("FlowLevel"));
            System.out.println("FlowWith id :: " + row.getAttribute("FlowWith"));
            //
            try {
                OperationBinding op=ADFUtils.findOperation("responseOcForAppr");
                          op.getParamsMap().put("ocId",row.getAttribute("OcHdrId").toString());
                          op.getParamsMap().put("reason",Reason);
                          op.getParamsMap().put("apr_rej","A");
                          ResultVal=op.execute().toString();
                //          JSFUtils.addFacesInformationMessage(flag);
            } catch (Exception e) {
                System.err.println("ERROR" + e);
            }
 
                if (ResultVal.equals("Success")) {
                    //vo.executeQuery();

                    //04-June  for change of status of Milestone and Receipt
                    String status = row.getAttribute("Status").toString();
//                    if (status.equalsIgnoreCase("APR")) {
                          onChangeStatus();
//                        onSaveSetOcId();
//                    }
                    //

                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Approved....");
                } else {
                    JSFUtils.addFacesErrorMessage("Error in Approve process!");
                }
        }
    }  

    public void onChangeStatus() {
        ViewObject bookingMsVo3 =
            ADFUtils.findIterator("Booking_Milestone_VO3Iterator").getViewObject();
        ViewObject receiptVo3 =
            ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
        RowSetIterator rsi = null;
        if (bookingMsVo3.getEstimatedRowCount() > 0) {
            System.out.println("On apprv for Ms " +
                               bookingMsVo3.getEstimatedRowCount());

            try {
                rsi = bookingMsVo3.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "APR");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }

        if (receiptVo3.getEstimatedRowCount() > 0) {
            System.out.println("On apprv for Rcpt " +
                               receiptVo3.getEstimatedRowCount());
            try {
                rsi = receiptVo3.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "APR");
                    //for receipt status
                    r.setAttribute("ReceiptStatus", "APR");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }
    }
    
    public void onChangeStatusForRej() {
        ViewObject bookingMsVo2 =
            ADFUtils.findIterator("Booking_Milestone_VO3Iterator").getViewObject();
        ViewObject receiptVo2 =
            ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
        RowSetIterator rsi = null;
        if (bookingMsVo2.getEstimatedRowCount() > 0) {
            System.out.println("On rej for Ms " +
                               bookingMsVo2.getEstimatedRowCount());

            try {
                rsi = bookingMsVo2.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "REJ");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }

        if (receiptVo2.getEstimatedRowCount() > 0) {
            System.out.println("On rej for Rcpt " +
                               receiptVo2.getEstimatedRowCount());
            try {
                rsi = receiptVo2.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "REJ");
                    //Receipt status change on Reject 
                    r.setAttribute("ReceiptStatus", "REJ");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }
    }
    public void onChangeStatusForPending() {
        String dBu = ocHdrVo.getCurrentRow().getAttribute("DestinationBu")==null ? "" : ocHdrVo.getCurrentRow().getAttribute("DestinationBu").toString();
        ViewObject bookingMsVo2 =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        ViewObject receiptVo2;
        if(dBu.equalsIgnoreCase("300000001937178")){
        receiptVo2 =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        }else {
        receiptVo2 =
                ADFUtils.findIterator("Receipt_VO6Iterator").getViewObject();
        }
        RowSetIterator rsi = null;
        if (bookingMsVo2.getEstimatedRowCount() > 0) {
            System.out.println("On apprv for Ms " +
                               bookingMsVo2.getEstimatedRowCount());

            try {
                rsi = bookingMsVo2.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "PEN");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }

        if (receiptVo2.getEstimatedRowCount() > 0) {
            System.out.println("On apprv for Rcpt " +
                               receiptVo2.getEstimatedRowCount());
            try {
                rsi = receiptVo2.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "PEN");
                    //Receipt status change on submit
                    r.setAttribute("ReceiptStatus", "PEN");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }
    }
    public void onChangeStatusForPendingCancellation() {
        ViewObject bookingMsVo4 =
            ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        ViewObject receiptVo4 =
            ADFUtils.findIterator("Receipt_VO4Iterator").getViewObject();
        RowSetIterator rsi = null;
        if (bookingMsVo4.getEstimatedRowCount() > 0) {
            System.out.println("On apprv for Ms " +
                               bookingMsVo4.getEstimatedRowCount());

            try {
                rsi = bookingMsVo4.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "PEN");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }

        if (receiptVo4.getEstimatedRowCount() > 0) {
            System.out.println("On apprv for Rcpt " +
                               receiptVo4.getEstimatedRowCount());
            try {
                rsi = receiptVo4.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "PEN");
                    //Receipt status change on submit
                    r.setAttribute("ReceiptStatus", "PEN");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }
    }


    public void onClickReject(ActionEvent actionEvent) {
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Rejected" : this.reason.getValue().toString();


        try {
//            ResultVal =
//                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
//                                            row.getAttribute("FuncId"),
//                                            row.getAttribute("OcHdrId"),
//                                            row.getAttribute("UserGrpId"),
//                                            row.getAttribute("FlowLevel"),
//                                            row.getAttribute("FlowWith"),
//                                            Reason, "R", 0, "XXPM_OC_HEADER",
//                                            "STATUS", "OC_HDR_ID");
                OperationBinding op=ADFUtils.findOperation("responseOcForAppr");
                          op.getParamsMap().put("ocId",row.getAttribute("OcHdrId").toString());
                          op.getParamsMap().put("reason",Reason);
                          op.getParamsMap().put("apr_rej","R");
                          ResultVal=op.execute().toString();
                //          JSFUtils.addFacesInformationMessage(flag);

        } catch (Exception e) {
            System.out.println(e);
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            onChangeStatusForRej();
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Rejected....");

        } else {
            JSFUtils.addFacesErrorMessage("Error in Reject process!");
        }

    }

    public void setReason(RichInputText reason) {
        this.reason = reason;
    }

    public RichInputText getReason() {
        return reason;
    }

    public String doCreateReceipt() {
        ViewObject vo =
            ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        if(row.getAttribute("DestinationBu") != null) {
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));

        ViewObject custVo =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        ViewCriteria vc = custVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("BookingId", row.getAttribute("BookingId"));
        vc.addRow(vcRow);
        custVo.applyViewCriteria(vc);
        custVo.executeQuery();

        if (custVo.getEstimatedRowCount() > 0) {
            Row cusRow = custVo.first();
            //for OcFlag C
//            if(row.getAttribute("OcFlag").equals("C")){
                ADFContext.getCurrent().getPageFlowScope().put("CancelId",
                                                               row.getAttribute("CancelId") ==
                                                               null ? "" :
                                                               row.getAttribute("CancelId"));
//            }
            //for setting OC value in attribut5 to restrict receipt display in BK nad RC
            ADFContext.getCurrent().getPageFlowScope().put("Attribute5","OC");
            ADFContext.getCurrent().getPageFlowScope().put("OcId",
                                                           row.getAttribute("OcHdrId") ==
                                                           null ? "" :
                                                           row.getAttribute("OcHdrId"));
            ADFContext.getCurrent().getPageFlowScope().put("OcNo",
                                                           row.getAttribute("OtherChargesNumber") ==
                                                           null ? "" :
                                                           row.getAttribute("OtherChargesNumber"));
            ADFContext.getCurrent().getPageFlowScope().put("OrgId",
                                                           row.getAttribute("DestinationBu") ==
                                                           null ? "" :
                                                           row.getAttribute("DestinationBu"));
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
            //ADFContext.getCurrent().getPageFlowScope().put("recType", "OC");
            //for stoping scopes for taking values from generate rcpt
            ADFContext.getCurrent().getPageFlowScope().put("DueDate", "");
            ADFContext.getCurrent().getPageFlowScope().put("BookingMsId", "");

            //for setting in receivedAmt in receipt
            ADFContext.getCurrent().getPageFlowScope().put("Amount", "");
            ADFContext.getCurrent().getPageFlowScope().put("Type", "");
//            ADFContext.getCurrent().getPageFlowScope().put("OrgId",
//                                                           row.getAttribute("OrgId") ==
//                                                           null ? "" :
//                                                           row.getAttribute("OrgId"));
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
            //                    ADFContext.getCurrent().getPageFlowScope().put("recType", "OC");
            String dBu = row.getAttribute("DestinationBu")==null ? "" : row.getAttribute("DestinationBu").toString();
                if (dBu.equalsIgnoreCase("300000001937178")){
                ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "OT" );
                ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "" );
                }else{
                    ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "DV" );
                    ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "Developer Charges" );
                }

        }
        return "receipt";
        }else{
            JSFUtils.addFacesInformationMessage("Please select Destination BU");
            return "";
        }
    }

    public String doEditReceipt() {
        // Add event code here...
        ViewObject vo =
            ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        //vo6
        ViewObject Rvo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row re = Rvo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("recid",
                                                       re.getAttribute("ReceiptId"));
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));
        ADFContext.getCurrent().getPageFlowScope().put("TransId", "ER");
        return "Edit";
    }
    //vo6
    public String doEditReceiptVo6() {
        // Add event code here...
        ViewObject vo =
            ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        //vo6
        ViewObject Rvo =
            ADFUtils.findIterator("Receipt_VO6Iterator").getViewObject();
        Row re = Rvo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("recid",
                                                       re.getAttribute("ReceiptId"));
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));
        ADFContext.getCurrent().getPageFlowScope().put("TransId", "ER");
        return "Edit";
    }
   // edit receipt for Cancellation OC 
    public String doEditReceiptForCancellationOC() {
        // Add event code here...
        ViewObject vo =
            ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        ViewObject Rvo =
            ADFUtils.findIterator("Receipt_VO4Iterator").getViewObject();
        Row re = Rvo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("recid",
                                                       re.getAttribute("ReceiptId"));
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));
        ADFContext.getCurrent().getPageFlowScope().put("TransId", "ER");
        return "Edit";
    }

    public void doDeleteReceipt(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Delete1").execute();
//        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
//        this.getPopup5().show(popup34);
    }
    
    public void doDeleteReceiptVo6(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Delete5").execute();
    //        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
    //        this.getPopup5().show(popup34);
    }
    public void onClickDelete(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Delete1").execute();
        ADFUtils.findOperation("Commit").execute();
    }
    //delete of receipt for Cancellation OC
    public void doDeleteReceiptForCancellationOC(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Delete4").execute();
    }

    public void onReturn(ReturnEvent returnEvent) {
        // Add event code here...
        //vo6
        ViewObject Rvo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Rvo.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(table_t4);
    }
//for cancellation vo4
    public void onReturnForCancellationOC(ReturnEvent returnEvent) {
        // Add event code here...
        ViewObject Rvo =
            ADFUtils.findIterator("Receipt_VO4Iterator").getViewObject();
        Rvo.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(table_t11);
    }
    public void setTable_t4(RichTable table_t4) {
        this.table_t4 = table_t4;
    }

    public RichTable getTable_t4() {
        return table_t4;
    }

    public void onReturnEdit(ReturnEvent returnEvent) {
        AdfFacesContext.getCurrentInstance().addPartialTarget(table_t8);
    }

    public void doCreateOCdetail(ActionEvent actionEvent) {
        ViewObject vo =
            ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        if(ocHdrVo.getCurrentRow().getAttribute("DestinationBu") != null) {
        ADFUtils.findOperation("CreateInsert").execute();
        bookingMsVo.getCurrentRow().setAttribute("SourceFuncId",
                                                 ocHdrVo.getCurrentRow().getAttribute("FuncId"));
        bookingMsVo.getCurrentRow().setAttribute("SourceFuncRefId",
                                                 ocHdrVo.getCurrentRow().getAttribute("OcHdrId"));
        bookingMsVo.getCurrentRow().setAttribute("OrgId",
                                                 ocHdrVo.getCurrentRow().getAttribute("DestinationBu"));
        }
        else{
            JSFUtils.addFacesInformationMessage("Please select Destination BU");  
        }
    }
    //for cancellation OC vo4
    public void doCreateOC_CancelMilestoneLine(ActionEvent actionEvent) {
        if(ocHdrVo.getCurrentRow().getAttribute("DestinationBu") != null) {
        ViewObject bookingMsVo4 = ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        ADFUtils.findOperation("CreateInsert1").execute();
        bookingMsVo4.getCurrentRow().setAttribute("SourceFuncId",
                                                 ocHdrVo.getCurrentRow().getAttribute("FuncId"));
        bookingMsVo4.getCurrentRow().setAttribute("SourceFuncRefId",
                                                 ocHdrVo.getCurrentRow().getAttribute("OcHdrId"));
        bookingMsVo4.getCurrentRow().setAttribute("BookingHdrId",
                                                 ocHdrVo.getCurrentRow().getAttribute("BookingId"));
        bookingMsVo4.getCurrentRow().setAttribute("OrgId",
                                                 ocHdrVo.getCurrentRow().getAttribute("DestinationBu"));
        }
        else{
            JSFUtils.addFacesInformationMessage("Please select Destination BU");
        }
    }

    public void setOthersTotalRate(RichInputText othersTotalRate) {
        this.othersTotalRate = othersTotalRate;
    }

    public RichInputText getOthersTotalRate() {
        return othersTotalRate;
    }

    public void setReceiptTotal(RichInputText receiptTotal) {
        this.receiptTotal = receiptTotal;
    }

    public RichInputText getReceiptTotal() {
        return receiptTotal;
    }


    /*
     * This method is used for pushing the Property Lease data
     * to Oracle AR Invoice module through invoice interface payload
     *
     */

    public void pushInvoiceInterfaceLineDltsofOtherCharges(ActionEvent actionEvent) {
        try {

            ViewObject otherChargeVO =
                ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
            RowSetIterator otherChargesHdrRS =
                otherChargeVO.createRowSetIterator(null);
            int transactionValue = 1;
            while (otherChargesHdrRS.hasNext()) {
                Row currRow = otherChargesHdrRS.next();
                String getLeaseType = "";
                String getTrxnsType = "";
                String validationFlag = "Y";

                Object bookingId =
                    otherChargeVO.getCurrentRow().getAttribute("BookingId");
                Object otherChargeId =
                    otherChargeVO.getCurrentRow().getAttribute("OcHdrId");
                Object leaseID =
                    otherChargeVO.getCurrentRow().getAttribute("LeaseAgreementId");
                System.err.println(bookingId);

                ViewObject invoiceInterfaceValueVO =
                    ADFUtils.findIterator("getInvoiceInterfacePayloadValuesforOtherCharges1Iterator").getViewObject();

                invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_BOOKING_ID",
                                                                 bookingId);
                invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_OTHER_CHR_ID",
                                                                 otherChargeId);
                invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_LEASE_ID",
                                                                 leaseID);
                invoiceInterfaceValueVO.executeQuery();

                if (invoiceInterfaceValueVO.first() != null) {
                   
                    Object unitId = currRow.getAttribute("UnitId");
//                    Object orgId = "300000001937178";
                    Object orgId = otherChargeVO.getCurrentRow().getAttribute("DestinationBu");
                    Object buildingName = invoiceInterfaceValueVO.first().getAttribute("BuildName");
                    Object unitName = invoiceInterfaceValueVO.first().getAttribute("UnitName");                  
//                    Object amount =
//                        invoiceInterfaceValueVO.first().getAttribute("OthersTotalRate"); //Base Rate                
                    Object billCustomerAccountNumber =
                        invoiceInterfaceValueVO.first().getAttribute("CustomerNumber");
                    Object billCustomerSiteNumber =
                        invoiceInterfaceValueVO.first().getAttribute("BillToAddre");
                    Object billingDate = getCurrentDateForPayload();
                    Object comments = "Property Lease Module";
                    Object ruleStartDate =
                        invoiceInterfaceValueVO.first().getAttribute("LeaseStartDate");
                    Object cancelDate =
                        invoiceInterfaceValueVO.first().getAttribute("CancelDate");
                    //for handling trnx date for N and C
                    Object createDate = null;
                    if(otherChargeVO.getCurrentRow().getAttribute("OcFlag").equals("N")) {
                        Object creationDate =
                            otherChargeVO.getCurrentRow().getAttribute("CreateDate");
                     createDate = creationDate;
                    }
                    
                    if(otherChargeVO.getCurrentRow().getAttribute("OcFlag").equals("C")) {
                     createDate = cancelDate;
                    }
                    Object trxDate = createDate;
                    //
                    Object currencyCode = "AED";
                    Object description = "Property Lease Module";
//                    JSFUtils.addFacesInformationMessage("===Lease Start Date==" +
//                                                        ruleStartDate);
                    JSFUtils.addFacesInformationMessage("===Creation date for N and Termination date for C == " + trxDate);
//                        Object glDate = invokeReport(ruleStartDate.toString());
                    
                    Object glDate = invokeReport(trxDate.toString());
                    JSFUtils.addFacesInformationMessage("===Output from BI Report==" +
                                                        glDate);
                    Object ruleEndDate =
                        invoiceInterfaceValueVO.first().getAttribute("LeaseEndDate");
                    currRow.setAttribute("GlDate", glDate);
                    //                  currRow.setAttribute("GlDate", ruleStartDate);
                    Object glFromBookingDtl = currRow.getAttribute("GlDate");
                    JSFUtils.addFacesInformationMessage("===GL Date From DB==" +
                                                        glFromBookingDtl);
                    Object unitSellingPrice =
                        invoiceInterfaceValueVO.first().getAttribute("OthersTotalRate");
                    Object lineType = "LINE";
                    Object quantity = "1";
                    Object paymentTermsName = "IMMEDIATE";
                    Object taxCode = "VAT 0%";
                    Object flexContext = "Property_Leasing";
                    Object leaseNumber =
                        invoiceInterfaceValueVO.first().getAttribute("LeaseNumber");
                    //for cancel no
                    Object cancelNo =
                        invoiceInterfaceValueVO.first().getAttribute("CancelNumber");
                    Object bookingNumber =
                        invoiceInterfaceValueVO.first().getAttribute("BookingNumber");
                    Object otherChargesNumber =
                        invoiceInterfaceValueVO.first().getAttribute("OtherChargesNumber");
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
//05-Feb-2020                    
// ar setup  for each charge type
            ViewObject getBookingMsDtlForOC =
                ADFUtils.findIterator("getBookingMsDtlForOC_RoVo1Iterator").getViewObject();
                    getBookingMsDtlForOC.setNamedWhereClauseParam("p_oc_id", otherChargeId);
                    getBookingMsDtlForOC.setNamedWhereClauseParam("p_bk_id", bookingId);
                    getBookingMsDtlForOC.executeQuery();
                    System.out.println("Estimated row count getBookingMsDtlForOC_RoVo :"+getBookingMsDtlForOC.getEstimatedRowCount());
            RowSetIterator rsiOC = getBookingMsDtlForOC.createRowSetIterator(null);
                    int i=1;
                    while(rsiOC.hasNext()) {  
                        System.out.println("iterator no i :"+i); 
                        
                        Row rowOcMsDtl = rsiOC.next();
                        Object instalType = rowOcMsDtl.getAttribute("InstallmentType");
//                        Object amount = rowOcMsDtl.getAttribute("InstallmentAmount");
                        Object atrb6InvAmt = rowOcMsDtl.getAttribute("Attribute6")==null ? "0" :rowOcMsDtl.getAttribute("Attribute6");
                        Object amount = rowOcMsDtl.getAttribute("Attribute4")==null ? rowOcMsDtl.getAttribute("InstallmentAmount"):rowOcMsDtl.getAttribute("Attribute4");
                        //for partial invoice keeping balance
                        if (!atrb6InvAmt.equals("0") && !atrb6InvAmt.equals("0.0")){
                            amount=atrb6InvAmt;
                        }
                        taxCode = rowOcMsDtl.getAttribute("Attribute2")== null ? "VAT 0%" : rowOcMsDtl.getAttribute("Attribute2");
                        int vatInt = Integer.parseInt(taxCode.toString());
                        if(vatInt==5){
                            taxCode="VAT 5%";  
                        }else{
                            taxCode="VAT 0%"; 
                        }
                        System.out.println("ChargeType OC :"+instalType);
                        System.out.println("Install amount OC :"+amount);
                        System.out.println("Tax code OC :"+taxCode);
//
                    if (orgId == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("==Business Unit is Required==");
                    }
                     if (unitName == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("==Unit Name is Required==");
                    }
                    if (buildingName == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("==Building Name is Required==");
                    } else {
                        System.err.println("Lease Type--" +
                                           invoiceInterfaceValueVO.first().getAttribute("LeaseType"));
                        if ((invoiceInterfaceValueVO.first().getAttribute("LeaseType") !=
                             null) 
//                            &&
//                            (invoiceInterfaceValueVO.first().getAttribute("LeaseType").toString().equalsIgnoreCase("DEFAULT"))
                        ) 
                        {

                            Map<String, Object> arSetupMap = null;
                            System.err.println("Enter in to the loop");
                            arSetupMap =
                                    getArSetupDetails(orgId.toString(),instalType.toString());
                            getLeaseType = "DEFAULT";
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
                            System.err.println("Exit in to the loop other charges");

                        }
                    }

                    //                    System.err.println("==Business Unit==" + orgId);
                    //                    System.err.println("==amount==" + amount);
                    //                    System.err.println("==batchSourceName==" +
                    //                                       batchSourceName);
                    //                    System.err.println("==customerTrxTypeName==" +
                    //                                       customerTrxTypeName);
                    //                    System.err.println("==billCustomerAccountNumber==" +
                    //                                       billCustomerAccountNumber);
                    //                    System.err.println("==billCustomerSiteNumber==" +
                    //                                       billCustomerSiteNumber);
                    //                    System.err.println("==billingDate==" + billingDate);
                    //                    System.err.println("==comments==" + comments);
                    //                    System.err.println("==trxDate==" + trxDate);
                    //                    System.err.println("==currencyCode==" + currencyCode);
                    //                    System.err.println("==description==" + description);
                    //                    //                    System.err.println("==glDate==" + glDate);
                    //                    System.err.println("==glDate==" + ruleStartDate);
                    //                    System.err.println("==invoicingRuleName==" +
                    //                                       invoicingRuleName);
                    //                    System.err.println("==accountingRuleName==" +
                    //                                       accountingRuleName);
                    //                    System.err.println("==ruleEndDate==" + ruleEndDate);
                    //                    System.err.println("==ruleStartDate==" + ruleStartDate);
                    //                    System.err.println("==unitSellingPrice==" +
                    //                                       unitSellingPrice);
                    //                    System.err.println("==lineType==" + lineType);
                    //                    System.err.println("==quantity==" + quantity);
                    //                    System.err.println("==paymentTermsName==" +
                    //                                       paymentTermsName);
                    //                    //                    System.err.println("==taxCode==" + taxCode);
                    //                    System.err.println("==flexContext==" + flexContext);
                    //                    System.err.println("==leaseNumber==" + leaseNumber);
                    //                    System.err.println("==bookingNumber==" + bookingNumber);
                    //                    System.err.println("==accountClass==" + accountClass);
                    //                    System.err.println("==dynamicInsertion==" +
                    //                                       dynamicInsertion);
                    //                    System.err.println("==segmentedCode==" + segmentedCode);
                    //                    System.err.println("==ledgerName==" + ledgerName);
                    //                    System.err.println("==enabledFlag==" + enabledFlag);
                    //                    System.err.println("==fromDate==" + fromDate);
                    //                    System.err.println("==toDate==" + toDate);
                    if (orgId == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Business Unit is Required");
                    }
                    if (unitId != null)
                        //                        segmentedCode = currRow.getAttribute("UnitShortcode");
                        segmentedCode =
                                getCodeCombination(orgId.toString(), "OT",
                                                   unitId.toString());
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

                    //                    if (glDate == null) {
                    //                        validationFlag = "N";
                    //                        JSFUtils.addFacesErrorMessage("GL Date is Required");
                    //                    }

                    if (ruleStartDate == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("GL Date is Required");
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
                    if (flexContext == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Flex Context is Required");

                    }
                    if (leaseNumber == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("Lease Number is Required");

                    }
                    if (otherChargesNumber == null) {

                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("other Charges Trx Number is Required");

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
                        System.out.println("Inside Y validationFlag");
                        JSONObject obj = new JSONObject();
                        obj.put("orgId", orgId.toString());
                        obj.put("unitName", unitName.toString());
                        obj.put("buildingName", buildingName.toString());
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
                        obj.put("invoicingRuleName",
                                invoicingRuleName.toString());
                        obj.put("invoicingRuleName", "");
                        obj.put("accountingRuleName", "");
                        obj.put("ruleEndDate", "");
                        obj.put("ruleStartDate", "");
                        obj.put("unitSellingPrice", amount.toString());
                        obj.put("lineType", lineType.toString());
                        obj.put("quantity", quantity.toString());
                        obj.put("paymentTermsName", paymentTermsName.toString());
                        obj.put("taxCode", taxCode);
                        obj.put("flexContext", flexContext.toString());
                        System.out.println("==Lease no + Other Charge no==" +
                                           leaseNumber.toString() + "/" +
                                           otherChargesNumber.toString());
                        //for OcFlag N 
//                        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("N")){
                        obj.put("leaseNumber",
                                leaseNumber.toString() + "/" + otherChargesNumber.toString());
//                        }
                        //for OcFlag C 
//                        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("C")){
//                        obj.put("leaseNumber",
//                                cancelNo.toString() + "/" + otherChargesNumber.toString());
//                        }
                        //                        obj.put("otherChargesNumber",
                        //                                otherChargesNumber.toString());
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
//                        obj.put("transactions", transactionValue + "");
                        obj.put("transactions", i);
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
                        System.out.println("Near webservice url");
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
                        System.out.println("Invoice Response in json" +
                                           out.toString());
                        String responseOut = out.toString();
                        if (responseOut != null){
                        //                        responseOut.contains("{\"result\":\"Success\"}");
                        ocHdrVo.getCurrentRow().setAttribute("IntegrationResponse", responseOut);
                        ADFUtils.findOperation("Commit").execute();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(generate_invoice_cb3);
                        }
//                        break;

                    }
//for ar setup
            i++;
                    }
                    rsiOC.closeRowSetIterator();
                }
            }
            otherChargesHdrRS.closeRowSetIterator();

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error in invoicePayload" + e);
        }
    }

    public Object getCurrentDateForPayload() {
        Calendar cal = Calendar.getInstance();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Object sysDate = sdf.format(cal.getTime());
        return sysDate;
    }

    //    /* This method will return the Tax code for Lookup */
    //
    //    public Object getTaxCodeFromLookup(Object p_TaxVal) {
    //        Object taxCode = null;
    //        try {
    //            ViewObject taxCodeVO =
    //                ADFUtils.findIterator("getTaxCodeROVO1Iterator").getViewObject();
    //            taxCodeVO.setNamedWhereClauseParam("p_TaxVal", p_TaxVal);
    //            taxCodeVO.executeQuery();
    //            if (taxCodeVO.first() != null) {
    //                taxCode =
    //                        taxCodeVO.first().getAttribute("LookupValueNameDisp") ==
    //                        null ? "ZR 0%" :
    //                        taxCodeVO.first().getAttribute("LookupValueNameDisp").toString();
    //            }
    //        } catch (Exception e) {
    //            JSFUtils.addFacesInformationMessage("Error in TaxCode" + e);
    //        }
    //        return taxCode;
    //    }

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
            arSetupMap.put("accountingRuleName", "");
            //                           arSetupVO.first().getAttribute("AccountingRuleName"));
            arSetupMap.put("invoicingRuleName", "");
            //                           arSetupVO.first().getAttribute("InvoicingRule"));
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
            returnResult = operation.execute();
            returnResult = operation.execute();
        } catch (Exception e) {
            System.err.println("e" + e.toString());
            JSFUtils.addFacesInformationMessage("Error in getCCMethod" + e);
        }
        return returnResult;
    }

    // Invoking Report which is used for GL period validation

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
        System.out.println("Request Payload ----> " + xmlInput);
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
                    System.err.println("Error Response----> " +
                                       out.toString());
                    fault =
                            doc.getElementsByTagName("faultstring").item(0).getTextContent();
                }
                JSFUtils.addFacesInformationMessage("==Error Reponse form Report==" +
                                                    fault);
                return fault;

            } else {

                String reportResponse = getResponseAsString(out.toString());
                System.out.println("Report Reponse : " + reportResponse);
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
            JSFUtils.addFacesInformationMessage("==Error==" + e);
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


    // To get the Invoice Res //

    public void getInvoiceRes(ActionEvent actionEvent) {

        String leaseNumber = "";

        try {
            ViewObject otherChargesVO =
                ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
            String otherChargesNo =
                otherChargesVO.getCurrentRow().getAttribute("OtherChargesNumber") ==
                null ? "0" :
                otherChargesVO.getCurrentRow().getAttribute("OtherChargesNumber").toString();

            ViewObject leaseVO =
                ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
            ViewCriteria vc = leaseVO.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("LeaseAgreementId",
                               otherChargesVO.getCurrentRow().getAttribute("LeaseAgreementId"));
            vc.addRow(vcRow);
            leaseVO.applyViewCriteria(vc);
            leaseVO.executeQuery();
            System.out.println("==Row Count==" +
                               leaseVO.getEstimatedRowCount());
            if (leaseVO.first() != null) {
                leaseNumber =
                        leaseVO.first().getAttribute("LeaseNumber").toString();
            }
            System.out.println("==Report input==" +
                               (leaseNumber + "/" + otherChargesNo));

            invokeARInvoiceBIWS(leaseNumber + "/" + otherChargesNo);
            otherChargesVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getOtherChargesform);


        } catch (Exception e) {
            //JSFUtils.addFacesInformationMessage("Error" + e);
            //System.out.println("Exception : " + e.getMessage());

            BindingContext bctx = BindingContext.getCurrent();
            ((DCBindingContainer)bctx.getCurrentBindingsEntry()).reportException(new CommonJBOException("TEST",
                                                                                                        propertyBundle));
        }
    }

    public void invokeARInvoiceBIWS(String p_other_charge_num) {
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
                "                 <pub:name>p_lease_number</pub:name>\n" +
                "                 <pub:values>\n" +
                "                    <pub:item>" + p_other_charge_num +
                "</pub:item>\n" +
                "                 </pub:values>\n" +
                "              </pub:item>\n" +
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
            JSFUtils.addFacesInformationMessage("Payload - " + Payload);
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

            //            System.err.println("Response String--" + out);
            int responseCode = response.code();
            //            System.err.println("RESPONSE CODE--" + responseCode);
            getARInvoiceBIWSRespValue(responseCode, out.toString());


        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("ERROR IN CATCH BLOCK--" + e);
        }

    }

    public String getARInvoiceBIWSRespValue(int respCode, String out) {
        String resp = "";
        //        JSFUtils.addFacesInformationMessage("Output Stream--" + out);
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
                        bindings.getOperationBinding("getARInvoiceTrxDetailsOtherCharge");
                    Map args = method.getParamsMap();
                    JSFUtils.addFacesInformationMessage("==Calling AM==" +
                                                        reportOutput.getElementsByTagName("P_LEASE_NUMBER").item(0).getTextContent().toString());
                    String otherChargeNumber =
                        reportOutput.getElementsByTagName("P_LEASE_NUMBER").item(0).getTextContent().toString();
                    //s1=s1.substring(0,s1.indexOf("/"));  ----(LA-1309/OC-3017")
                    //s1=s1.substring(1,8);

                    otherChargeNumber =
                            otherChargeNumber.substring(otherChargeNumber.indexOf("/"));
                    otherChargeNumber =
                            otherChargeNumber.substring(1, 8).toString(); //OC-3017
                    //                    System.out.println("otherChargeNumber==="+otherChargeNumber);

                    //args.put("pOtherChargeNum", otherChargeNumber);
                    args.put("pCustomerTrxId",
                             reportOutput.getElementsByTagName("CUSTOMER_TRX_ID").item(0).getTextContent().toString());
                    args.put("pCustomerTrxNo",
                             reportOutput.getElementsByTagName("TRX_NUMBER").item(0).getTextContent().toString());
                    Object a = method.execute();
                    JSFUtils.addFacesInformationMessage("RESPONSE--" + a);
                    //                    JSFUtils.addFacesInformationMessage("OUT PUT" +
                    //                                                        reportOutput.getElementsByTagName("P_LEASE_NUMBER ").item(0).getTextContent());
                    //
                    //                    System.err.println("P_LEASE_NUMBER " +
                    //                                       reportOutput.getElementsByTagName("P_LEASE_NUMBER ").item(0).getTextContent());
                    //                    System.err.println("CUSTOMER_TRX_ID" +
                    //                                       reportOutput.getElementsByTagName("CUSTOMER_TRX_ID").item(0).getTextContent());
                    //                    System.err.println("TRX_NUMBER" +
                    //                                       reportOutput.getElementsByTagName("TRX_NUMBER").item(0).getTextContent());
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

    /* This method is used to create the receipt in AR */

    public void arReceiptCreation(ActionEvent actionEvent) {

//        String validationFlag = "Y";
//        try {
//            Object amount = null;
//            Object currencyCode = "AED";
//            Object orgId = null;
//            Object customerId = null;
//            Object receiptDate = null;
//            Object receiptMethodId = null;
//            Object receiptNumber = null;
//            Object leaseNumber = null;
//            Object bookingNumber = null;
//            Object building = null;
//            Object unit = null;
//            Object receiptPayMode = null;
//            Object chequeEffectiveDate = null;
//            Object chequeNo = null;
//            Object environment = "prod";
//
//            ViewObject receiptVO =
//                ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
//            receiptPayMode = receiptVO.getCurrentRow().getAttribute("PayMode");
//            receiptNumber =
//                    receiptVO.getCurrentRow().getAttribute("ReceiptNumber");
//            if (receiptPayMode == null) {
//                validationFlag = "N";
//                JSFUtils.addFacesErrorMessage("Receipt Payment Mode is Required");
//            } else {
//
//                chequeEffectiveDate =
//                        receiptVO.getCurrentRow().getAttribute("PayRefDate");
//                chequeNo =
//                        receiptVO.getCurrentRow().getAttribute("PayRefNumber");
//                receiptNumber =
//                        receiptVO.getCurrentRow().getAttribute("ReceiptNumber");
//                receiptDate =
//                        receiptVO.getCurrentRow().getAttribute("ReceiptDate");
//                amount =
//                        receiptVO.getCurrentRow().getAttribute("RecommendedAmount");
//
//                ViewObject leaseVO =
//                    ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
//                Object bookingId =
//                    leaseVO.getCurrentRow().getAttribute("BookingId");
//                ViewObject invoiceInterfaceValueVO =
//                    ADFUtils.findIterator("getReceiptPayloadforotherCharges_ROVO1Iterator").getViewObject();
//                invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_BOOKING_ID",
//                                                                 bookingId);
//                invoiceInterfaceValueVO.executeQuery();
//                if (invoiceInterfaceValueVO.first() != null) {
//                    orgId =
//                            invoiceInterfaceValueVO.first().getAttribute("OrgId");
//                    bookingNumber =
//                            invoiceInterfaceValueVO.first().getAttribute("BookingNumber");
//                    leaseNumber =
//                            invoiceInterfaceValueVO.first().getAttribute("LeaseNumber");
//                    customerId =
//                            invoiceInterfaceValueVO.first().getAttribute("CustIdAr");
//                }
//
//                if (orgId != null && receiptPayMode != null) {
//                    ViewObject receiptMethodVO =
//                        ADFUtils.findIterator("getReceiptMethod_ROVO1Iterator").getViewObject();
//                    receiptMethodVO.setNamedWhereClauseParam("BV_ORG_ID",
//                                                             orgId.toString());
//                    receiptMethodVO.setNamedWhereClauseParam("BV_TYPE",
//                                                             receiptPayMode.toString());
//                    receiptMethodVO.executeQuery();
//                    if (receiptMethodVO.first() != null) {
//                        receiptMethodId =
//                                receiptMethodVO.first().getAttribute("ReceiptMethodId");
//                    }
//                }
//
//                if (amount == null) {
//                    validationFlag = "N";
//                    JSFUtils.addFacesErrorMessage("Receipt amount is Required");
//                }
//
//                //                if (chequeEffectiveDate == null) {
//                //                    validationFlag = "N";
//                //                    JSFUtils.addFacesErrorMessage("Maturity Date is Required");
//                //                }
//                if (orgId == null) {
//                    validationFlag = "N";
//                    JSFUtils.addFacesErrorMessage("Organization details is Required");
//                }
//                if (customerId == null) {
//                    validationFlag = "N";
//                    JSFUtils.addFacesErrorMessage("customer details is Required");
//                }
//                if (receiptDate == null) {
//                    validationFlag = "N";
//                    JSFUtils.addFacesErrorMessage("Receipt Date is Required");
//                }
//                if (receiptMethodId == null) {
//                    validationFlag = "N";
//                    JSFUtils.addFacesErrorMessage("Receipt Method is Required");
//                }
//                if (receiptNumber == null) {
//                    validationFlag = "N";
//                    JSFUtils.addFacesErrorMessage("Receipt Number is Required");
//                }
//                if (leaseNumber == null) {
//                    validationFlag = "N";
//                    JSFUtils.addFacesErrorMessage("Lease Number is Required");
//                }
//                if (bookingNumber == null) {
//                    validationFlag = "N";
//                    JSFUtils.addFacesErrorMessage("Booking Number is Required");
//                }
//            }
//
//
//            if (validationFlag == "Y") {
//                JSONObject obj = new JSONObject();
//
//                obj.put("amount", amount.toString());
//                obj.put("currencyCode", currencyCode.toString());
//                obj.put("glDate", receiptDate.toString());
//                if (chequeEffectiveDate != null) {
//                    obj.put("maturityDate", chequeEffectiveDate.toString());
//                } else {
//                    obj.put("maturityDate", receiptDate.toString());
//                }
//                obj.put("orgId", orgId.toString());
//                obj.put("customerId", customerId.toString());
//                obj.put("receiptDate", receiptDate.toString());
//                obj.put("receiptMethodId", receiptMethodId.toString());
//                if (chequeNo == null) {
//                    obj.put("receiptNumber", receiptNumber.toString());
//                } else {
//                    obj.put("receiptNumber", chequeNo.toString());
//                }
//                obj.put("leaseNumber", leaseNumber.toString());
//                obj.put("bookingNumber", bookingNumber.toString());
//                obj.put("building", building);
//                obj.put("unit", unit);
//                obj.put("environment", environment.toString());
//
//                JSFUtils.addFacesInformationMessage("Receipt Create JSON Payload" +
//                                                    obj.toString());
//                OkHttpClient client = new OkHttpClient();
//                MediaType mediaType = MediaType.parse("application/json");
//                RequestBody body =
//                    RequestBody.create(mediaType, obj.toJSONString());
//                Request request =
//                    new Request.Builder().url("http://144.21.73.214/Al-MiskIntegrations/webresources/receipt/create/v1").post(body).addHeader("Content-Type",
//                                                                                                                                              "application/json").addHeader("Cache-Control",
//                                                                                                                                                                            "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                  "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
//
//                Response response = client.newCall(request).execute();
//                JSFUtils.addFacesInformationMessage("Receipt Create JSON Payload Response" +
//                                                    response);
//                InputStream isr = response.body().byteStream();
//                BufferedReader reader =
//                    new BufferedReader(new InputStreamReader(isr));
//                StringBuilder out = new StringBuilder();
//                String resultsXml;
//
//                while ((resultsXml = reader.readLine()) != null) {
//                    out.append(resultsXml);
//                }
//                JSFUtils.addFacesInformationMessage("Receipt Response" + out);
//
//                JSONParser parser = new JSONParser();
//                JSONObject jsonObject =
//                    (JSONObject)parser.parse(out.toString());
//                //                                JSFUtils.addFacesInformationMessage("Invoice Response as JSON" +
//                //                                                                    jsonObject);
//                Object receiptId = jsonObject.get("cash_reciept_id");
//                JSFUtils.addFacesInformationMessage("Invoice Response in  receiptId" +
//                                                    jsonObject);
//                receiptVO.getCurrentRow().setAttribute("Attribute1",
//                                                       receiptId);
//                //                this.attributResponse.setValue(receiptId);
//                //                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAttributResponse());
//                ADFUtils.findOperation("Commit").execute();
//            }
//
//        } catch (Exception e) {
//            JSFUtils.addFacesInformationMessage("Error in Receipt Create--" +
//                                                e);
//        }
    }

    public String onCreateInstallReceipt() {

        Row row = ocHdrVo.getCurrentRow();
        if(row.getAttribute("DestinationBu") != null){
        Row rows = bookingMsVo.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));
        ViewObject bookingCustVo =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        ViewCriteria vc = bookingCustVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("BookingId", row.getAttribute("BookingId"));
        vc.addRow(vcRow);
        bookingCustVo.applyViewCriteria(vc);
        bookingCustVo.executeQuery();

        if (bookingCustVo.getEstimatedRowCount() > 0) {
            Row cusRow = bookingCustVo.first();
            
            //            if(row.getAttribute("OcFlag").equals("C")){
                        ADFContext.getCurrent().getPageFlowScope().put("CancelId",
                                                                           row.getAttribute("CancelId") ==
                                                                           null ? "" :
                                                                           row.getAttribute("CancelId"));
            //            }
            //for setting OC value in attribut5 to restrict receipt display in BK nad RC
            ADFContext.getCurrent().getPageFlowScope().put("Attribute5","OC");
                        ADFContext.getCurrent().getPageFlowScope().put("OcId",
                                                                       row.getAttribute("OcHdrId") ==
                                                                       null ? "" :
                                                                       row.getAttribute("OcHdrId"));
                        ADFContext.getCurrent().getPageFlowScope().put("OcNo",
                                                                       row.getAttribute("OtherChargesNumber") ==
                                                                       null ? "" :
                                                                       row.getAttribute("OtherChargesNumber"));
            ADFContext.getCurrent().getPageFlowScope().put("OrgId",
                                                           row.getAttribute("DestinationBu") ==
                                                           null ? "" :
                                                           row.getAttribute("DestinationBu"));
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
                                                           rows.getAttribute("DueDate") ==
                                                           null ? "" :
                                                           rows.getAttribute("DueDate"));
            //08-sep-2020 for all receipts to capture BookingMsDtlId in receipt Attribute3 mainly for OC report
            String bkMsdtlId = rows.getAttribute("BookingMsDtlId") == null ? "" : rows.getAttribute("BookingMsDtlId").toString();
            System.out.println("bkMsdtlId ::"+bkMsdtlId);
            ADFContext.getCurrent().getPageFlowScope().put("remark", bkMsdtlId);
            //03-apr-2021
            String insTyp2=rows.getAttribute("InstallmentType2")==null?"":rows.getAttribute("InstallmentType2").toString();
            if(insTyp2.contains("SEC_DEP")){
                ADFContext.getCurrent().getPageFlowScope().put("modeType","SD");
            }else{
                ADFContext.getCurrent().getPageFlowScope().put("modeType","Normal");   
            }

            //#{pageFlowScope.BookingMsId}

            ADFContext.getCurrent().getPageFlowScope().put("BookingMsId",
                                                           rows.getAttribute("BookingMsDtlId") ==
                                                           null ? "" :
                                                           rows.getAttribute("BookingMsDtlId"));
            //for setting in receivedAmt in receipt
            ADFContext.getCurrent().getPageFlowScope().put("Amount",
                                                           rows.getAttribute("InstallmentAmount") ==
                                                           null ? "" :
                                                           rows.getAttribute("InstallmentAmount"));
//       Description
            ViewObject lookUpVo = ADFUtils.findIterator("Lookup_View_ROVO1Iterator").getViewObject();
                        ViewCriteria vC = lookUpVo.createViewCriteria();
                        ViewCriteriaRow vCRow = vC.createViewCriteriaRow();
                        vCRow.setAttribute("LookupValueName", rows.getAttribute("InstallmentType"));
                        vC.addRow(vCRow);
                        lookUpVo.applyViewCriteria(vC);
                        lookUpVo.executeQuery();
                        if (lookUpVo.getEstimatedRowCount() > 0) { 
                            Row lookUpVoRow = lookUpVo.first();
                            String lookupValueDisp = lookUpVoRow.getAttribute("LookupValueNameDisp").toString();
                            ADFContext.getCurrent().getPageFlowScope().put("Dscrption", lookupValueDisp );
                            String dBu = row.getAttribute("DestinationBu")==null ? "" : row.getAttribute("DestinationBu").toString();
                            if (dBu.equalsIgnoreCase("300000001937178")){
                            ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "OT" );
                            ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "" );
                            }else{
                                ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "DV" );
                                ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "Developer Charges" );
                            }
                        }
        //for updating flag in receipt in case of cheque replacement
        ViewObject bookingMsVo1 =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        Row r = bookingMsVo1.getCurrentRow();
        String ocType = r.getAttribute("InstallmentType")==null ? "" : r.getAttribute("InstallmentType").toString();        
        System.out.println("type :: "+r.getAttribute("InstallmentType"));
//        System.out.println("type2 :: "+r.getAttribute("InstallmentType2"));        
                if (ocType.contains("CHQ_REP_PAYMENT")) {
                    System.out.println("Contains CHQ_REP_PAYMENT ::"+ocType);
                    ADFContext.getCurrent().getPageFlowScope().put("tktChqRepFlag", "Y");
                }else{
                    ADFContext.getCurrent().getPageFlowScope().put("tktChqRepFlag", ""); 
                }
        }

        return "receipt";
        }else{
            JSFUtils.addFacesInformationMessage("Please select Destination BU"); 
            return "";
        }
    }
//    this generate receipt is for cancellation
    public String onCreateInstallReceiptForCancel() {

        Row row = ocHdrVo.getCurrentRow();
        if(row.getAttribute("DestinationBu") != null){
        ViewObject bookingMsVo4 =
            ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        Row rows = bookingMsVo4.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       row.getAttribute("BookingId"));
        ViewObject bookingCustVo =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        ViewCriteria vc = bookingCustVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("BookingId", row.getAttribute("BookingId"));
        vc.addRow(vcRow);
        bookingCustVo.applyViewCriteria(vc);
        bookingCustVo.executeQuery();

        if (bookingCustVo.getEstimatedRowCount() > 0) {
            Row cusRow = bookingCustVo.first();
            //for oc flag C
            if(row.getAttribute("OcFlag").equals("C")){
                ADFContext.getCurrent().getPageFlowScope().put("CancelId",
                                                               row.getAttribute("CancelId") ==
                                                               null ? "" :
                                                               row.getAttribute("CancelId"));
            }
            //for setting OC value in attribut5 to restrict receipt display in BK nad RC
            ADFContext.getCurrent().getPageFlowScope().put("Attribute5","OC");
            ADFContext.getCurrent().getPageFlowScope().put("OcId",
                                                           row.getAttribute("OcHdrId") ==
                                                           null ? "" :
                                                           row.getAttribute("OcHdrId"));
            ADFContext.getCurrent().getPageFlowScope().put("OcNo",
                                                           row.getAttribute("OtherChargesNumber") ==
                                                           null ? "" :
                                                           row.getAttribute("OtherChargesNumber"));
            ADFContext.getCurrent().getPageFlowScope().put("OrgId",
                                                           row.getAttribute("DestinationBu") ==
                                                           null ? "" :
                                                           row.getAttribute("DestinationBu"));
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
                                                           rows.getAttribute("DueDate") ==
                                                           null ? "" :
                                                           rows.getAttribute("DueDate"));
            //08-sep-2020 for all receipts to capture BookingMsDtlId in receipt Attribute3 mainly for OC report
            String bkMsdtlId = rows.getAttribute("BookingMsDtlId") == null ? "" : rows.getAttribute("BookingMsDtlId").toString();
            System.out.println("bkMsdtlId ::"+bkMsdtlId);
            ADFContext.getCurrent().getPageFlowScope().put("remark", bkMsdtlId);
            //03-apr-2021
            String insTyp2=rows.getAttribute("InstallmentType2")==null?"":rows.getAttribute("InstallmentType2").toString();
            if(insTyp2.contains("SEC_DEP")){
            ADFContext.getCurrent().getPageFlowScope().put("modeType","SD");
            }else{
            ADFContext.getCurrent().getPageFlowScope().put("modeType","Normal");
            }
            //#{pageFlowScope.BookingMsId}

            ADFContext.getCurrent().getPageFlowScope().put("BookingMsId",
                                                           rows.getAttribute("BookingMsDtlId") ==
                                                           null ? "" :
                                                           rows.getAttribute("BookingMsDtlId"));
            //for setting in receivedAmt in receipt
            ADFContext.getCurrent().getPageFlowScope().put("Amount",
                                                           rows.getAttribute("InstallmentAmount") ==
                                                           null ? "" :
                                                           rows.getAttribute("InstallmentAmount"));
            ViewObject lookUpVo =
                    ADFUtils.findIterator("Lookup_View_ROVO1Iterator").getViewObject();
            ViewCriteria vC = lookUpVo.createViewCriteria();
            ViewCriteriaRow vCRow = vC.createViewCriteriaRow();
            vCRow.setAttribute("LookupValueName", rows.getAttribute("InstallmentType"));
            vC.addRow(vCRow);
            lookUpVo.applyViewCriteria(vC);
            lookUpVo.executeQuery();
            if (lookUpVo.getEstimatedRowCount() > 0) {
            Row lookUpVoRow = lookUpVo.first();
            String lookupValueDisp = lookUpVoRow.getAttribute("LookupValueNameDisp").toString();
            ADFContext.getCurrent().getPageFlowScope().put("Dscrption", lookupValueDisp );
            String dBu = row.getAttribute("DestinationBu")==null ? "" : row.getAttribute("DestinationBu").toString();
                if (dBu.equalsIgnoreCase("300000001937178")){
                ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "OT" );
                ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "" );
                }else{
                    ADFContext.getCurrent().getPageFlowScope().put("chrgTyp", "DV" );
                    ADFContext.getCurrent().getPageFlowScope().put("chrgTypDesc", "Developer Charges" );
                }
            }
            //for updating flag in receipt in case of cheque replacement 
            String ocType = rows.getAttribute("InstallmentType")==null ? "" : rows.getAttribute("InstallmentType").toString();        
            System.out.println("type :: "+rows.getAttribute("InstallmentType"));
            //        System.out.println("type2 :: "+rows.getAttribute("InstallmentType2"));
                    if (ocType.contains("CHQ_REP_PAYMENT")) {
                        System.out.println("Contains CHQ_REP_PAYMENT ::"+ocType);
                        ADFContext.getCurrent().getPageFlowScope().put("tktChqRepFlag", "Y");
                    }else{
                        ADFContext.getCurrent().getPageFlowScope().put("tktChqRepFlag", ""); 
                    }
            
        }

        return "receipt";
        }else{
            JSFUtils.addFacesInformationMessage("Please select Destination BU"); 
            return "";
        }
    }

    public void returnReceipt(ReturnEvent returnEvent) {
        doCalculate();
        AdfFacesContext.getCurrentInstance().addPartialTarget(othersTotalRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(receiptTotal);
        ViewObject Rvo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Rvo.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(table_t4);
    }
    //this is for cancel case VO4
    public void returnReceiptForCancel(ReturnEvent returnEvent) {
        doCalculateForCancel();
        AdfFacesContext.getCurrentInstance().addPartialTarget(othersTotalRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(receiptTotal);
        ViewObject Rvo =
            ADFUtils.findIterator("Receipt_VO4Iterator").getViewObject();
        Rvo.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(table_t11);
    }

    public void setOc_type(RichSelectOneChoice oc_type) {
        this.oc_type = oc_type;
    }

    public RichSelectOneChoice getOc_type() {
        return oc_type;
    }

    public void onDoCancel(ActionEvent actionEvent) {
        ADFUtils.findOperation("Rollback").execute();
    }

    public void setTable_t8(RichTable table_t8) {
        this.table_t8 = table_t8;
    }

    public RichTable getTable_t8() {
        return table_t8;
    }

    public boolean getApprovalUser() {
        boolean flag = false;
        String flowWith =
            ocHdrVo.getCurrentRow().getAttribute("FlowWith") == null ? null :
            ocHdrVo.getCurrentRow().getAttribute("FlowWith").toString();
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

    /* This method is used to create the receipt in AR */

    public void receiptCreationAR(ActionEvent actionEvent) {
        String validationFlag = "Y";
        try {
            Object amount = null;
            Object currencyCode = "AED";
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
                ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
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
                        receiptVO.getCurrentRow().getAttribute("Description")==null? " "
                       :receiptVO.getCurrentRow().getAttribute("Description");

                ViewObject OtherChargesVO =
                    ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
                Object bookingId =
                    OtherChargesVO.getCurrentRow().getAttribute("BookingId");
                Object otherChargesID =
                    OtherChargesVO.getCurrentRow().getAttribute("OcHdrId");

                ViewObject invoiceInterfaceValueVO =
                    ADFUtils.findIterator("getReceiptPayloadDtls_OtherCharges_ROVO1Iterator").getViewObject();
                invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_BOOKING_ID",
                                                                 bookingId);
                invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_OC_HDR_ID",
                                                                 otherChargesID);
                invoiceInterfaceValueVO.executeQuery();
                if (invoiceInterfaceValueVO.first() != null) {
//                    orgId = "300000001937178";
                    orgId = ocHdrVo.getCurrentRow().getAttribute("DestinationBu");
//                            invoiceInterfaceValueVO.first().getAttribute("OrgId");
                    bookingNumber =
                            invoiceInterfaceValueVO.first().getAttribute("BookingNumber");
                    leaseNumber =
                            invoiceInterfaceValueVO.first().getAttribute("LeaseNumber");
                    customerId =
                            invoiceInterfaceValueVO.first().getAttribute("CustIdAr");
                    unit =
                            invoiceInterfaceValueVO.first().getAttribute("UnitName");
                    building =
                            invoiceInterfaceValueVO.first().getAttribute("BuildName");
                }

                if (orgId != null && receiptPayMode != null) {
                    ViewObject receiptMethodVO =
                        ADFUtils.findIterator("getReceiptMethod_ROVO1Iterator").getViewObject();
                    System.err.println("==org id===="+orgId);
                    receiptMethodVO.setNamedWhereClauseParam("BV_ORG_ID",
                                                             orgId.toString());
                    receiptMethodVO.setNamedWhereClauseParam("BV_TYPE",
                                                             receiptPayMode.toString());
                    receiptMethodVO.executeQuery();
                    System.out.println("==OTHER CHARGES RECEIPT COUNT==" +
                                       receiptMethodVO.getEstimatedRowCount());
                    if (receiptMethodVO.first() != null) {
                        receiptMethodId =
                                receiptMethodVO.first().getAttribute("ReceiptMethodId");
                    }
                }

                if (amount == null) {
                    validationFlag = "N";
                    JSFUtils.addFacesErrorMessage("Receipt amount is Required");
                }
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
                Object receiptId = jsonObject.get("cash_reciept_id");
                JSFUtils.addFacesInformationMessage("Invoice Response in  receiptId" +
                                                    jsonObject);
                receiptVO.getCurrentRow().setAttribute("Attribute1",
                                                       receiptId);
                this.receiptResponse.setValue(receiptId);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getReceiptResponse());
                ADFUtils.findOperation("Commit").execute();
            }

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error in Receipt Create--" +
                                                e);
        }
    }

    public void setReceiptResponse(RichInputText receiptResponse) {
        this.receiptResponse = receiptResponse;
    }

    public RichInputText getReceiptResponse() {
        return receiptResponse;
    }

    /* This method is used to apply the receipt in AR using invoice details */

    public void arReceiptApply(ActionEvent actionEvent) {
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
            transactionDate = null;
            accountingDate = null;
            applicationDate = null;

            ViewObject receiptVO1 =
                ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
            Row currRow = receiptVO1.getCurrentRow();

            ViewObject otherChargesHdrVO =
                ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
            ViewObject leaseAgreemntVo =
                ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
            ViewCriteria vc = leaseAgreemntVo.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("LeaseAgreementId",
                               otherChargesHdrVO.getCurrentRow().getAttribute("LeaseAgreementId"));
            vc.addRow(vcRow);
            leaseAgreemntVo.applyViewCriteria(vc);
            leaseAgreemntVo.executeQuery();
            //            System.out.println("==Count=="+leaseAgreemntVo.getEstimatedRowCount());

            amountApplied = currRow.getAttribute("RecommendedAmount");
            customerTrxId =
                    otherChargesHdrVO.getCurrentRow().getAttribute("CustomerTrxnId");
            receipt_Number = currRow.getAttribute("ReceiptNumber");
            receiptAmount = currRow.getAttribute("RecommendedAmount");
            receipt_Date = currRow.getAttribute("ReceiptDate");
            cashRecieptId = currRow.getAttribute("Attribute1");
            invoiceDateLS =
                    leaseAgreemntVo.first().getAttribute("LeaseStartDate");

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
                obj.put("transactionDate", transactionDate.toString());
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
                obj.put("accountingDate", glDateValidation);
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
                obj.put("applicationDate", applicationDate.toString());
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

    public void setGetOtherChargesform(RichPanelFormLayout getOtherChargesform) {
        this.getOtherChargesform = getOtherChargesform;
    }

    public RichPanelFormLayout getGetOtherChargesform() {
        return getOtherChargesform;
    }

    public void globalAppr(ActionEvent actionEvent) {
        // Add event code here...
        String status = "APR";
        Row otherChargeHeader = ocHdrVo.getCurrentRow();
        otherChargeHeader.setAttribute("Status", status);
        onChangeStatus();
        onSaveSetOcId();
        ADFUtils.findOperation("Commit").execute();
        ocHdrVo.executeQuery();
    }
//calling from save 
    public void onSaveSetOcId() {
        ViewObject bookingMsVo2 =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        ViewObject receiptVo2 =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        RowSetIterator rsi = null;
        if (bookingMsVo2.getEstimatedRowCount() > 0) {
            System.out.println("No of OC lines - " +
                               bookingMsVo2.getEstimatedRowCount());

            try {
                rsi = bookingMsVo2.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("OcId", ocHdrVo.getCurrentRow().getAttribute("OcHdrId"));
                    r.setAttribute("OcNo", ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                    System.out.println("OC ID - "+ ocHdrVo.getCurrentRow().getAttribute("OcHdrId"));
                    System.out.println("OC no - "+ ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                }
            } catch (Exception e) {
                    System.out.println(e);
            } finally {
                rsi.closeRowSetIterator();
            }
        }

        if (receiptVo2.getEstimatedRowCount() > 0) {
            System.out.println("No of receipt Lines - " +
                               receiptVo2.getEstimatedRowCount());
            try {
                rsi = receiptVo2.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("OcId", ocHdrVo.getCurrentRow().getAttribute("OcHdrId"));
                    r.setAttribute("OcNo", ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                    System.out.println("OC ID receipt- "+ ocHdrVo.getCurrentRow().getAttribute("OcHdrId"));
                    System.out.println("OC no receipt - "+ ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                rsi.closeRowSetIterator();
            }
        }
    }

    public void onSaveSetOcIdForCancellation() {
        ViewObject bookingMsVo2 =
            ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        ViewObject receiptVo2 =
            ADFUtils.findIterator("Receipt_VO4Iterator").getViewObject();
        RowSetIterator rsi = null;
        if (bookingMsVo2.getEstimatedRowCount() > 0) {
            System.out.println("No of OC lines - " +
                               bookingMsVo2.getEstimatedRowCount());

            try {
                rsi = bookingMsVo2.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("OcId", ocHdrVo.getCurrentRow().getAttribute("OcHdrId"));
                    r.setAttribute("OcNo", ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                    System.out.println("OC ID - "+ ocHdrVo.getCurrentRow().getAttribute("OcHdrId"));
                    System.out.println("OC no - "+ ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                }
            } catch (Exception e) {
                    System.out.println(e);
            } finally {
                rsi.closeRowSetIterator();
            }
        }

        if (receiptVo2.getEstimatedRowCount() > 0) {
            System.out.println("No of receipt Lines - " +
                               receiptVo2.getEstimatedRowCount());
            try {
                rsi = receiptVo2.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("OcId", ocHdrVo.getCurrentRow().getAttribute("OcHdrId"));
                    r.setAttribute("OcNo", ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                    System.out.println("OC ID receipt- "+ ocHdrVo.getCurrentRow().getAttribute("OcHdrId"));
                    System.out.println("OC no receipt - "+ ocHdrVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                rsi.closeRowSetIterator();
            }
        }
    }

    public void setOcFlag(RichSelectOneRadio ocFlag) {
        this.ocFlag = ocFlag;
    }

    public RichSelectOneRadio getOcFlag() {
        return ocFlag;
    }

    public void onSelectOcFlag(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
//        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
//        if (valueChangeEvent.getNewValue() == "N") {
//        System.out.println("get new value :"+valueChangeEvent.getNewValue());
//            this.cancelNo.setValue(null);
//            ocHdrVo.getCurrentRow().setAttribute("CancelId", null);
//            System.out.println("inside iff");
//        }else{
//            System.out.println("get new value :"+valueChangeEvent.getNewValue());
//            System.out.println("inside else");
//        }
//        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getCancelNo());
    }

    public void setCancelNo(RichInputListOfValues cancelNo) {
        this.cancelNo = cancelNo;
    }

    public RichInputListOfValues getCancelNo() {
        return cancelNo;
    }

    public void onSelectCancelNo(ValueChangeEvent valueChangeEvent) {
        if (bookingMsVo.getEstimatedRowCount() != 0) {
        ocHdrVo.getCurrentRow().setAttribute("DestinationBu", "300000001937178");
        }
//        ocHdrVo.getCurrentRow().getAttribute("CancelNo_Trans");
//        System.out.println("CancelNo_Trans ::"+ ocHdrVo.getCurrentRow().getAttribute("CancelNo_Trans"));
//        System.out.println("Cancel ID ::"+ ocHdrVo.getCurrentRow().getAttribute("CancelId"));
//        System.out.println("Create Date ::"+ ocHdrVo.getCurrentRow().getAttribute("CreateDate"));
//        //
//        Object trxDate = null;
//        Object create = null;
////        Object creationDate =
////            ocHdrVo.getCurrentRow().getAttribute("CreateDate");
//        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("N")) {
//            Object creationDate =
//                ocHdrVo.getCurrentRow().getAttribute("CreateDate");
//         create = creationDate;
//        }
//        if(ocHdrVo.getCurrentRow().getAttribute("OcFlag").equals("C")) {
//            Object creationDate =
//                ocHdrVo.getCurrentRow().getAttribute("CreateDate");
//         create = creationDate;
//        }
//        trxDate = create;
//        System.out.println("after date ::"+trxDate);
//        System.out.println("trxDatex --"+trxDate);
////        if( trxDate = null){}
//        //
    }

    public void setTable_t11(RichTable table_t11) {
        this.table_t11 = table_t11;
    }

    public RichTable getTable_t11() {
        return table_t11;
    }

    public void setGenerate_invoice_cb3(RichCommandButton generate_invoice_cb3) {
        this.generate_invoice_cb3 = generate_invoice_cb3;
    }

    public RichCommandButton getGenerate_invoice_cb3() {
        return generate_invoice_cb3;
    }

    public void setPopup5(RichPopup popup5) {
        this.popup5 = popup5;
    }

    public RichPopup getPopup5() {
        return popup5;
    }

    public void setT13(RichTable t13) {
        this.t13 = t13;
    }

    public RichTable getT13() {
        return t13;
    }

    public void onReturnVo6(ReturnEvent returnEvent) {
        // Add event code here...
        //vo6
        ViewObject Rvo =
            ADFUtils.findIterator("Receipt_VO6Iterator").getViewObject();
        Rvo.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(t13);
    }

    public void doHandleTktChqRepFlag(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject bookingMsVo1 =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        Row r = bookingMsVo1.getCurrentRow();
        String ocType = r.getAttribute("InstallmentType")==null ? "" : r.getAttribute("InstallmentType").toString();        
        System.out.println("type :: "+r.getAttribute("InstallmentType"));
        System.out.println("type2 :: "+r.getAttribute("InstallmentType2"));
        
                if (ocType.contains("CHQ_REP_PAYMENT")) {
                    System.out.println("Contains CHQ_REP_PAYMENT_SHJ");
                    r.setAttribute("TktChqRepFlag", "Y");
                }
    }

    public void doHandleTktChqRepFlagCancel(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject bookingMsVo4 =
            ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        Row r = bookingMsVo4.getCurrentRow();
        String ocType = r.getAttribute("InstallmentType")==null ? "" : r.getAttribute("InstallmentType").toString();        
        System.out.println("type :: "+r.getAttribute("InstallmentType"));
        System.out.println("type2 :: "+r.getAttribute("InstallmentType2"));
        
                if (ocType.contains("CHQ_REP_PAYMENT")) {
                    System.out.println("Contains CHQ_REP_PAYMENT_SHJ");
                    r.setAttribute("TktChqRepFlag", "Y");
                }
    }

    public void doSaveHandleGlobalSite(ActionEvent actionEvent) {
        // Add event code here...
        String resp = ocHdrVo.getCurrentRow().getAttribute("IntegrationResponse")== null ? "": ocHdrVo.getCurrentRow().getAttribute("IntegrationResponse").toString();
        System.out.println("Response :"+resp);
        if(resp.equalsIgnoreCase("{\"result\":\"Success\"}")){
        ocHdrVo.getCurrentRow().setAttribute("IntegrationResponse", null);
            }
        ADFUtils.findOperation("Commit").execute();
//        JSFUtils.addFacesInformationMessage("Other Charges Saved.....!");
    }
    //07-Sep-2020 for handling in case of pending, approved and rej
    public void doCalForNotDraft() {
    
        BigDecimal total = new BigDecimal("0");
    //        int rcptTotal = 0;
        BigDecimal rcptTotal = new BigDecimal("0");
        BigDecimal instAmt = new BigDecimal("0");
        BigDecimal rAmt = new BigDecimal("0");
        //for total oc calcu
        ViewObject bookingMsVo3 =
            ADFUtils.findIterator("Booking_Milestone_VO3Iterator").getViewObject();
        ViewObject receiptVo3 =
            ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
        RowSetIterator bMsRsi = bookingMsVo3.createRowSetIterator(null);
        while (bMsRsi.hasNext()) {
            Row r = bMsRsi.next();
            String InstllAmount =
                r.getAttribute("InstallmentAmount") == null ? "0" :
                r.getAttribute("InstallmentAmount").toString();
            System.out.println("InstallmentAmount = " + InstllAmount);
            instAmt = new BigDecimal(InstllAmount);
            total = instAmt.add(total);
        }
        //for total receipt calcu
        RowSetIterator rRsi = receiptVo3.createRowSetIterator(null);
        while (rRsi.hasNext()) {
            Row row = rRsi.next();
            String rcptAmt =
                row.getAttribute("ReceivedAmount") == null ? "0" : row.getAttribute("ReceivedAmount").toString();
            System.out.println("Receipt Amt = " + rcptAmt);
            rAmt = new BigDecimal(rcptAmt);
            rcptTotal = rAmt.add(rcptTotal);
        }
        ocHdrVo.getCurrentRow().setAttribute("OthersTotalRate", total);
        ocHdrVo.getCurrentRow().setAttribute("ReceiptTotal", rcptTotal);
    }

    public void onCheckCashierFlag(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject vo=ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
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
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.id7);
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

    public void onEntrAmtOcLineVO1(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ViewObject bkMsdtlVo1 = ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        Row r = bkMsdtlVo1.getCurrentRow();
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
                    taxamtBD = (amtBD.multiply(taxCbd)).divide(percntBD, 2);
                    totlAmtBD = amtBD.add(taxamtBD);
                }
                r.setAttribute("InstallmentAmount", totlAmtBD);
                r.setAttribute("Attribute3", taxamtBD);
    }

    public void onSlctTaxCodeLineVO1(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ViewObject bkMsdtlVo1 = ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        Row r = bkMsdtlVo1.getCurrentRow();
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
                    taxamtBD = (amtBD.multiply(taxCbd)).divide(percntBD, 2);
                    totlAmtBD = amtBD.add(taxamtBD);
                }
                r.setAttribute("InstallmentAmount", totlAmtBD);
                r.setAttribute("Attribute3", taxamtBD);
    }

    public void onEntrAmtOcLineVO4(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ViewObject bkMsdtlVo4 = ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        Row r = bkMsdtlVo4.getCurrentRow();
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
                    taxamtBD = (amtBD.multiply(taxCbd)).divide(percntBD, 2);
                    totlAmtBD = amtBD.add(taxamtBD);
                }
                r.setAttribute("InstallmentAmount", totlAmtBD);
                r.setAttribute("Attribute3", taxamtBD);
    }

    public void onSlctTaxCodeLineVO4(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ViewObject bkMsdtlVo4 = ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        Row r = bkMsdtlVo4.getCurrentRow();
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
                    taxamtBD = (amtBD.multiply(taxCbd)).divide(percntBD, 2);
                    totlAmtBD = amtBD.add(taxamtBD);
                }
                r.setAttribute("InstallmentAmount", totlAmtBD);
                r.setAttribute("Attribute3", taxamtBD);
    }

    public void setId7(RichInputDate id7) {
        this.id7 = id7;
    }

    public RichInputDate getId7() {
        return id7;
    }

    public void responseCashRcptId(ActionEvent actionEvent) {
        try {
                            ViewObject rcptVo =
                                ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
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
    //                    "              <pub:item>\n" +
    //                    "                 <pub:name>p_charge_type</pub:name>\n" +
    //                    "                 <pub:values>\n" +
    //                    "                    <pub:item/>\n" +
    //                    "                 </pub:values>\n" +
    //                    "              </pub:item>              \n" +
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

    public void setId8(RichInputDate id8) {
        this.id8 = id8;
    }

    public RichInputDate getId8() {
        return id8;
    }

    public void doChangeTransactionDate(ActionEvent actionEvent) {
        ViewObject otherChargeVO = ADFUtils.findIterator("OtherChargesHeader_VO1Iterator").getViewObject();
        String ocId = otherChargeVO.getCurrentRow().getAttribute("OcHdrId")==null?"":otherChargeVO.getCurrentRow().getAttribute("OcHdrId").toString();
        String dateTnx = id8.getValue()==null?"":id8.getValue().toString();
        OperationBinding op=ADFUtils.findOperation("chngTnxDate");
        op.getParamsMap().put("ocId",ocId);
        op.getParamsMap().put("dateTnx",dateTnx);
        String flag=op.execute().toString();
        JSFUtils.addFacesInformationMessage(flag);
    }

    public void doCalInvAmtBlnc(ValueChangeEvent valueChangeEvent) {
        ViewObject bkMsdtlVo1 = ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        Row r = bkMsdtlVo1.getCurrentRow();
        BigDecimal attr6InvAmtBD = new BigDecimal(0);
                        BigDecimal taxCbd = new BigDecimal(0);
                        BigDecimal amtBD = new BigDecimal(0);
                        BigDecimal invoiceAmtBD = new BigDecimal(0);
                        BigDecimal percntBD = new BigDecimal(100);
                        BigDecimal balncBD = new BigDecimal(0);
                        System.out.println("New value :"+valueChangeEvent.getNewValue());
                        String amt = r.getAttribute("InstallmentAmount")==null?"0":r.getAttribute("InstallmentAmount").toString();
                        String taxCode = r.getAttribute("Attribute2")==null?"0":r.getAttribute("Attribute2").toString();
                        String attr6InvAmt = valueChangeEvent.getNewValue()==null ? "0" : valueChangeEvent.getNewValue().toString();
//                            attr6InvAmtBD = new BigDecimal(attr6InvAmt);
                            if(valueChangeEvent.getNewValue()!=null && valueChangeEvent.getNewValue()!="0"){
                                System.out.println("In");
                            attr6InvAmtBD = new BigDecimal(attr6InvAmt);
                            System.out.println("New value again inside :"+taxCode);
                            taxCbd = new BigDecimal(taxCode);
                            amtBD = new BigDecimal(amt);
                            invoiceAmtBD = (attr6InvAmtBD.multiply(taxCbd)).divide(percntBD, 2).add(attr6InvAmtBD);              
                            balncBD = amtBD.subtract(invoiceAmtBD);
                            r.setAttribute("Attribute7", balncBD);
                        }
    }

    public void doCalInvAmtVo3Blnc(ValueChangeEvent valueChangeEvent) {
        ViewObject bkMsdtlVo3 = ADFUtils.findIterator("Booking_Milestone_VO3Iterator").getViewObject();
        Row r = bkMsdtlVo3.getCurrentRow();
        BigDecimal attr6InvAmtBD = new BigDecimal(0);
                        BigDecimal taxCbd = new BigDecimal(0);
                        BigDecimal amtBD = new BigDecimal(0);
                        BigDecimal invoiceAmtBD = new BigDecimal(0);
                        BigDecimal percntBD = new BigDecimal(100);
                        BigDecimal balncBD = new BigDecimal(0);
                        System.out.println("New value :"+valueChangeEvent.getNewValue());
                        String amt = r.getAttribute("InstallmentAmount")==null?"0":r.getAttribute("InstallmentAmount").toString();
                        String taxCode = r.getAttribute("Attribute2")==null?"0":r.getAttribute("Attribute2").toString();
                        String attr6InvAmt = valueChangeEvent.getNewValue()==null ? "0" : valueChangeEvent.getNewValue().toString();
                            attr6InvAmtBD = new BigDecimal(attr6InvAmt);
                            if(valueChangeEvent.getNewValue()!=null && valueChangeEvent.getNewValue()!="0"){
                                System.out.println("In");
                            attr6InvAmtBD = new BigDecimal(attr6InvAmt);
                            System.out.println("New value again inside :"+taxCode);
                            taxCbd = new BigDecimal(taxCode);
                            amtBD = new BigDecimal(amt);
                            invoiceAmtBD = (attr6InvAmtBD.multiply(taxCbd)).divide(percntBD, 2).add(attr6InvAmtBD);
                            balncBD = amtBD.subtract(invoiceAmtBD);
                            r.setAttribute("Attribute7", balncBD);
                        }
    }

    public void doCalInvAmtVo4Blnc(ValueChangeEvent valueChangeEvent) {
        ViewObject bkMsdtlVo4 = ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        Row r = bkMsdtlVo4.getCurrentRow();
        BigDecimal attr6InvAmtBD = new BigDecimal(0);
                        BigDecimal taxCbd = new BigDecimal(0);
                        BigDecimal amtBD = new BigDecimal(0);
                        BigDecimal invoiceAmtBD = new BigDecimal(0);
                        BigDecimal percntBD = new BigDecimal(100);
                        BigDecimal balncBD = new BigDecimal(0);
                        System.out.println("New value :"+valueChangeEvent.getNewValue());
                        String amt = r.getAttribute("InstallmentAmount")==null?"0":r.getAttribute("InstallmentAmount").toString();
                        String taxCode = r.getAttribute("Attribute2")==null?"0":r.getAttribute("Attribute2").toString();
                        String attr6InvAmt = valueChangeEvent.getNewValue()==null ? "0" : valueChangeEvent.getNewValue().toString();
                            attr6InvAmtBD = new BigDecimal(attr6InvAmt);
                            if(valueChangeEvent.getNewValue()!=null && valueChangeEvent.getNewValue()!="0"){
                                System.out.println("In");
                            attr6InvAmtBD = new BigDecimal(attr6InvAmt);
                            System.out.println("New value again inside :"+taxCode);
                            taxCbd = new BigDecimal(taxCode);
                            amtBD = new BigDecimal(amt);
                            invoiceAmtBD = (attr6InvAmtBD.multiply(taxCbd)).divide(percntBD, 2).add(attr6InvAmtBD);
                            balncBD = amtBD.subtract(invoiceAmtBD);
                            r.setAttribute("Attribute7", balncBD);
                        }
    }
}
