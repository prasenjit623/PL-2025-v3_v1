package view.backing;

import com.model.util.CommonJBOException;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.StringReader;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;

import org.xml.sax.SAXException;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditOcDpBb {
    private RichInputText othersTotalRate;
    private RichInputText receiptTotal;
    private RichCommandButton generate_invoice_cb3;
    private RichPopup popUp1;
    private RichInputText reason;
    private static String propertyBundle = "view.PropertyLease_ViewControllerBundle";
    private RichInputText receiptResponse;
    private RichSelectBooleanCheckbox sbc1;
    private RichInputText it70;
    private RichInputDate id5;

    public AddEditOcDpBb() {
    }
    
    ViewObject ocHdrDpVo = ADFUtils.findIterator("OcDpHdr_VO1Iterator").getViewObject();
    ViewObject bkMsdtlVo1 = ADFUtils.findIterator("OcBkMilestoneDtlDp_VO1Iterator").getViewObject();
    ViewObject rcptDpVo1 = ADFUtils.findIterator("OcReceiptDp_VO1Iterator").getViewObject();

    public void onEntrAmtOcLineVO1(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
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

    public String onCreateInstallReceipt() {
        
        Row row = ocHdrDpVo.getCurrentRow();
        Row rowMs = bkMsdtlVo1.getCurrentRow();
        if(row.getAttribute("DestinationBu") != null){
        ADFContext.getCurrent().getPageFlowScope().put("BookingId","");
        ADFContext.getCurrent().getPageFlowScope().put("CancelId","");
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
                                                           row.getAttribute("Cust_Name_Trans") ==
                                                           null ? "" :
                                                           row.getAttribute("Cust_Name_Trans"));
            ADFContext.getCurrent().getPageFlowScope().put("CustBankName","");
            ADFContext.getCurrent().getPageFlowScope().put("CustBankAccNumber","");
            ADFContext.getCurrent().getPageFlowScope().put("CustBranchName","");
            ADFContext.getCurrent().getPageFlowScope().put("DueDate","");
            //08-sep-2020 for all receipts to capture BookingMsDtlId in receipt Attribute3 mainly for OC report
            String bkMsdtlId = rowMs.getAttribute("BookingMsDtlId") == null ? "" : rowMs.getAttribute("BookingMsDtlId").toString();
            System.out.println("bkMsdtlId ::"+bkMsdtlId);
            ADFContext.getCurrent().getPageFlowScope().put("remark", bkMsdtlId);
            //03-apr-2021
            String insTyp2=rowMs.getAttribute("InstallmentType")==null?"":rowMs.getAttribute("InstallmentType").toString();
            if(insTyp2.contains("SEC_DEP")){
                ADFContext.getCurrent().getPageFlowScope().put("modeType","SD");
            }else{
                ADFContext.getCurrent().getPageFlowScope().put("modeType","Normal");   
            }

            ADFContext.getCurrent().getPageFlowScope().put("BookingMsId",
                                                           rowMs.getAttribute("BookingMsDtlId") ==
                                                           null ? "" :
                                                           rowMs.getAttribute("BookingMsDtlId"));
            //for setting in receivedAmt in receipt
            ADFContext.getCurrent().getPageFlowScope().put("Amount",
                                                           rowMs.getAttribute("InstallmentAmount") ==
                                                           null ? "" :
                                                           rowMs.getAttribute("InstallmentAmount"));
        //       Description
            ViewObject lookUpVo = ADFUtils.findIterator("Lookup_View_ROVO1Iterator").getViewObject();
                        ViewCriteria vC = lookUpVo.createViewCriteria();
                        ViewCriteriaRow vCRow = vC.createViewCriteriaRow();
                        vCRow.setAttribute("LookupValueName", rowMs.getAttribute("InstallmentType"));
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
        
        String ocType = rowMs.getAttribute("InstallmentType")==null ? "" : rowMs.getAttribute("InstallmentType").toString();        
        System.out.println("type :: "+rowMs.getAttribute("InstallmentType"));
                if (ocType.contains("CHQ_REP_PAYMENT")) {
                    System.out.println("Contains CHQ_REP_PAYMENT ::"+ocType);
                    ADFContext.getCurrent().getPageFlowScope().put("tktChqRepFlag", "Y");
                }else{
                    ADFContext.getCurrent().getPageFlowScope().put("tktChqRepFlag", ""); 
                }
        return "addRcptOcDp";
        }else{
            JSFUtils.addFacesInformationMessage("Please select Destination BU"); 
            return "";
        }
        }

    public String doEditReceipt() {
        Row row = ocHdrDpVo.getCurrentRow();
        Row re = rcptDpVo1.getCurrentRow();
        ADFContext.getCurrent().getPageFlowScope().put("recid", re.getAttribute("ReceiptId"));
        ADFContext.getCurrent().getPageFlowScope().put("BookingId","");
        ADFContext.getCurrent().getPageFlowScope().put("TransId", "ER");
        return "editRcptOcDp";
    }

    public void doCreateOCdetail(ActionEvent actionEvent) {
        Row row = ocHdrDpVo.getCurrentRow();
        if(ocHdrDpVo.getCurrentRow().getAttribute("DestinationBu") != null) {
        ADFUtils.findOperation("CreateInsert").execute();
        bkMsdtlVo1.getCurrentRow().setAttribute("SourceFuncId",
                                                 ocHdrDpVo.getCurrentRow().getAttribute("FuncId"));
        bkMsdtlVo1.getCurrentRow().setAttribute("SourceFuncRefId",
                                                 ocHdrDpVo.getCurrentRow().getAttribute("OcHdrId"));
        bkMsdtlVo1.getCurrentRow().setAttribute("OrgId",
                                                 ocHdrDpVo.getCurrentRow().getAttribute("DestinationBu"));
        bkMsdtlVo1.getCurrentRow().setAttribute("OcId",
                                                 ocHdrDpVo.getCurrentRow().getAttribute("OcHdrId"));
        }
        else{
            JSFUtils.addFacesInformationMessage("Please select Destination BU");  
        }    }

    public void doSave(ActionEvent actionEvent) {
        
        String status = ocHdrDpVo.getCurrentRow().getAttribute("Status")==null ? "" : ocHdrDpVo.getCurrentRow().getAttribute("Status").toString();
        if(ocHdrDpVo.getCurrentRow().getAttribute("OcFlag").equals("DP")){
        System.out.println("during save ocDtl data " + bkMsdtlVo1.getEstimatedRowCount());
        if (bkMsdtlVo1.getEstimatedRowCount() != 0) {

            if (ocHdrDpVo.getCurrentRow().getAttribute("OtherChargesNumber") == null) {
                //genarating oc no
                String name =
                    xxfnd.generateDocNo("OC", "OtherChargesAppModuleDataControl").toString();
                Object valu = name;
                ocHdrDpVo.getCurrentRow().setAttribute("OtherChargesNumber",valu);
                //setting func_id
                ViewObject getFuncodeVo =
                    ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                getFuncodeVo.setNamedWhereClauseParam("F_ID", "OC");
                getFuncodeVo.executeQuery();
                ocHdrDpVo.getCurrentRow().setAttribute("FuncId",getFuncodeVo.first().getAttribute("FuncId"));
                //
            }
            //17-May for setting othersTotalRate in oc
            doCalculate();
            onSaveSetOcId();
            System.out.println("OC Total oc :: " +
                               ocHdrDpVo.getCurrentRow().getAttribute("OthersTotalRate"));
            System.out.println("Receipt Total oc :: " +
                               ocHdrDpVo.getCurrentRow().getAttribute("ReceiptTotal"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(othersTotalRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(receiptTotal);
            //
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Other Charges Saved.....!");
        } else {
            JSFUtils.addFacesErrorMessage("Create Other Charges Detail !!!");
          }
         }
        
    }
    public void doCalculate() {
                BigDecimal total = new BigDecimal("0");
                BigDecimal rcptTotal = new BigDecimal("0");
                //for total oc calcu
                RowSetIterator bMsRsi = bkMsdtlVo1.createRowSetIterator(null);
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
                String dBu = ocHdrDpVo.getCurrentRow().getAttribute("DestinationBu")== null ? "" : ocHdrDpVo.getCurrentRow().getAttribute("DestinationBu").toString();
                RowSetIterator rRsi = rcptDpVo1.createRowSetIterator(null);
                while (rRsi.hasNext()) {
                    Row row = rRsi.next();
                    String rcptAmt =
                        row.getAttribute("ReceivedAmount") == null ? "0" : row.getAttribute("ReceivedAmount").toString();
                    System.out.println("Receipt Amt = " + rcptAmt);
        //            int rAmt = Integer.parseInt(rcptAmt);
                    BigDecimal rAmt = new BigDecimal(rcptAmt);
                    rcptTotal = rAmt.add(rcptTotal);
                }
        rRsi.closeRowSetIterator();
        ocHdrDpVo.getCurrentRow().setAttribute("OthersTotalRate", total);
        ocHdrDpVo.getCurrentRow().setAttribute("ReceiptTotal", rcptTotal);
    }
   
    public void onSaveSetOcId() {
        RowSetIterator rsi = null;
        if (bkMsdtlVo1.getEstimatedRowCount() > 0) {
            System.out.println("No of OC lines - " + bkMsdtlVo1.getEstimatedRowCount());
            try {
                rsi = bkMsdtlVo1.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("OcId", ocHdrDpVo.getCurrentRow().getAttribute("OcHdrId"));
                    r.setAttribute("OcNo", ocHdrDpVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                    System.out.println("OC ID - "+ ocHdrDpVo.getCurrentRow().getAttribute("OcHdrId"));
                    System.out.println("OC no - "+ ocHdrDpVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                }
            } catch (Exception e) {
                    System.out.println(e);
            } finally {
                rsi.closeRowSetIterator();
            }
        }

        if (rcptDpVo1.getEstimatedRowCount() > 0) {
            System.out.println("No of receipt Lines - " + rcptDpVo1.getEstimatedRowCount());
            try {
                rsi = rcptDpVo1.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("OcId", ocHdrDpVo.getCurrentRow().getAttribute("OcHdrId"));
                    r.setAttribute("OcNo", ocHdrDpVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                    System.out.println("OC ID receipt- "+ ocHdrDpVo.getCurrentRow().getAttribute("OcHdrId"));
                    System.out.println("OC no receipt - "+ ocHdrDpVo.getCurrentRow().getAttribute("OtherChargesNumber"));
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                rsi.closeRowSetIterator();
            }
        }
    }

    public String onSaveAndClose() {
        System.out.println("during save ocDtl data " + bkMsdtlVo1.getEstimatedRowCount());
        if (bkMsdtlVo1.getEstimatedRowCount() > 0) {

            if (ocHdrDpVo.getCurrentRow().getAttribute("OtherChargesNumber") ==
                null) {
                //genarating oc no
                String name =
                    xxfnd.generateDocNo("OC", "OtherChargesAppModuleDataControl").toString();
                Object valu = name;
                ocHdrDpVo.getCurrentRow().setAttribute("OtherChargesNumber",valu);
                //setting func_id
                ViewObject getFuncodeVo =
                    ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                getFuncodeVo.setNamedWhereClauseParam("F_ID", "OC");
                getFuncodeVo.executeQuery();
                ocHdrDpVo.getCurrentRow().setAttribute("FuncId",
                                                     getFuncodeVo.first().getAttribute("FuncId"));
                //
            }
            //17-May for setting othersTotalRate in oc
            doCalculate();
            onSaveSetOcId();
            System.out.println("OC Total oc :: " +
                               ocHdrDpVo.getCurrentRow().getAttribute("OthersTotalRate"));
            System.out.println("Receipt Total oc :: " +
                               ocHdrDpVo.getCurrentRow().getAttribute("ReceiptTotal"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(othersTotalRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(receiptTotal);
            //

            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Other Charges Saved.....!");

        } else {
            JSFUtils.addFacesErrorMessage("Create Other Charges Detail !!!");
        }

        return "backToSrch";
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

    public void onInvokeAppOrReject(ActionEvent actionEvent) {
        String ackFlagStatus="Y";
        System.out.println("Count RcptVo1 :"+rcptDpVo1.getEstimatedRowCount());
        String action = ADFContext.getCurrent().getPageFlowScope().get("Action").toString();
        if (action.equalsIgnoreCase("Rejection")){
        //            System.out.println("Rejection action :"+action);
        }else{
                if (rcptDpVo1.getEstimatedRowCount() > 0) {
                RowSetIterator rs = rcptDpVo1.createRowSet(null);
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

    public void globalAppr(ActionEvent actionEvent) {
        // Add event code here...
        String status = "APR";
        Row otherChargeHeader = ocHdrDpVo.getCurrentRow();
        otherChargeHeader.setAttribute("Status", status);
        onChangeStatus();
        onSaveSetOcId();
        ADFUtils.findOperation("Commit").execute();
        ocHdrDpVo.executeQuery();
    }
    
    public void onChangeStatus() {
        RowSetIterator rsi = null;
        if (bkMsdtlVo1.getEstimatedRowCount() > 0) {
            System.out.println("On apprv for Ms " + bkMsdtlVo1.getEstimatedRowCount());

            try {
                rsi = bkMsdtlVo1.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "APR");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }

        if (rcptDpVo1.getEstimatedRowCount() > 0) {
            System.out.println("On apprv for Rcpt " + rcptDpVo1.getEstimatedRowCount());
            try {
                rsi = rcptDpVo1.createRowSetIterator(null);
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

    public String onClickSubmit() {
        if(ocHdrDpVo.getCurrentRow().getAttribute("OcFlag").equals("DP")){
        if (bkMsdtlVo1.getEstimatedRowCount() == 0) {
            JSFUtils.addFacesErrorMessage("Create Other Charges Detail !!!");
            return null;
        }
        }
        
        if(ocHdrDpVo.getCurrentRow().getAttribute("DestinationBu") != null) {
        if (ocHdrDpVo.getCurrentRow().getAttribute("BillToAddre") != null ){
        onSaveAndClose();
        String totalOC =
            ocHdrDpVo.getCurrentRow().getAttribute("OthersTotalRate").toString();
        String totalRcpt =
            ocHdrDpVo.getCurrentRow().getAttribute("ReceiptTotal").toString();
        if (totalOC.equals(totalRcpt)) {
            String ResultVal = null;

            Row row = ocHdrDpVo.getCurrentRow();
//            Object org = ocHdrDpVo.getCurrentRow().getAttribute("OrgId");
//            Object prop = ocHdrDpVo.getCurrentRow().getAttribute("PropertyId");
//            Object build = ocHdrDpVo.getCurrentRow().getAttribute("BuildingId");
            System.err.println("row.getAttribute(\"FuncId\") " + row.getAttribute("FuncId"));
            try {
          OperationBinding op=ADFUtils.findOperation("submitOcForApprDP");
          op.getParamsMap().put("ocId",row.getAttribute("OcHdrId").toString());
          ResultVal=op.execute().toString();
        //          JSFUtils.addFacesInformationMessage(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            System.out.println("resultVal after calling submit package :: " + ResultVal);
            if (ResultVal.equalsIgnoreCase("Success")) {
                if(ocHdrDpVo.getCurrentRow().getAttribute("OcFlag").equals("DP")){
                onChangeStatusForPending();
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
        if(ocHdrDpVo.getCurrentRow().getAttribute("OcFlag").equals("DP")){
        System.out.println("Estimate count BM VO1 :"+bkMsdtlVo1.getEstimatedRowCount());           
            try {
                rsi = bkMsdtlVo1.createRowSetIterator(null);
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
        }
          else{
             JSFUtils.addFacesInformationMessage("Please select Destination BU");
         }

        return "backToSrch";        
    }
    
    public void onChangeStatusForPending() {
        String dBu = ocHdrDpVo.getCurrentRow().getAttribute("DestinationBu")==null ? "" : ocHdrDpVo.getCurrentRow().getAttribute("DestinationBu").toString();
        RowSetIterator rsi = null;
        if (bkMsdtlVo1.getEstimatedRowCount() > 0) {
            System.out.println("On apprv for Ms " + bkMsdtlVo1.getEstimatedRowCount());

            try {
                rsi = bkMsdtlVo1.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "PEN");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }

        if (rcptDpVo1.getEstimatedRowCount() > 0) {
            System.out.println("On apprv for Rcpt " + rcptDpVo1.getEstimatedRowCount());
            try {
                rsi = rcptDpVo1.createRowSetIterator(null);
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

    public void onDoCancel(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Rollback").execute();
    }

    public void pushInvoiceInterfaceLineDltsofOtherCharges(ActionEvent actionEvent) {
            try {
                RowSetIterator otherChargesHdrRS = ocHdrDpVo.createRowSetIterator(null);
                int transactionValue = 1;
                while (otherChargesHdrRS.hasNext()) {
                    Row currRow = otherChargesHdrRS.next();
                    String getLeaseType = "";
                    String getTrxnsType = "";
                    String validationFlag = "Y";
                    
                    Object otherChargeId =
                        ocHdrDpVo.getCurrentRow().getAttribute("OcHdrId");
                                           
                        Object orgIdD = ocHdrDpVo.getCurrentRow().getAttribute("DestinationBu");
                        Object billCustomerAccountNumber ="";
                        Object billCustomerSiteNumber ="";
                        Object billingDate = getCurrentDateForPayload();
                        Object comments = "Property Lease Module";
                        Object ruleStartDate =getCurrentDateForPayload();
                        Object createDate = null;
                        if(ocHdrDpVo.getCurrentRow().getAttribute("OcFlag").equals("DP")) {
                            Object creationDate =
                                ocHdrDpVo.getCurrentRow().getAttribute("CreateDate");
                         createDate = creationDate;
                        }
                        Object trxDate = createDate;
                        //
                        Object currencyCode = "AED";
                        Object description = "Property Lease Module";
                        Object glDate = trxDate;
                        JSFUtils.addFacesInformationMessage("===Output from BI Report==" + glDate);
                        Object ruleEndDate =createDate;
                        currRow.setAttribute("GlDate", glDate);
                        Object glFromBookingDtl = currRow.getAttribute("GlDate");
                        Object unitSellingPrice =null;
                        Object lineType = "LINE";
                        Object quantity = "1";
                        Object paymentTermsName = "IMMEDIATE";
                        Object taxCode = "VAT 0%";
                        Object flexContext = "Property_Leasing";
                        Object leaseNumber =null;
                        //for cancel no
                        Object cancelNo =null;
                        Object bookingNumber =null;
                        Object otherChargesNumber = ocHdrDpVo.getCurrentRow().getAttribute("OtherChargesNumber");
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
                    ADFUtils.findIterator("getOcDpBkMsDtlInvoiceLines_RoVo1Iterator").getViewObject();
                        getBookingMsDtlForOC.setNamedWhereClauseParam("p_oc_id", otherChargeId);
                        getBookingMsDtlForOC.executeQuery();
                        System.out.println("Estimated row count getBookingMsDtlForOC_RoVo :"+getBookingMsDtlForOC.getEstimatedRowCount());
                RowSetIterator rsiOC = getBookingMsDtlForOC.createRowSetIterator(null);
                        int i=1;
                        while(rsiOC.hasNext()) {  
                            System.out.println("iterator no i :"+i); 
                            
                            Row rowOcMsDtl = rsiOC.next();
                            billCustomerAccountNumber = rowOcMsDtl.getAttribute("CustomerNumber");
                            billCustomerSiteNumber = rowOcMsDtl.getAttribute("BillToAddre");
                            Object instalType = rowOcMsDtl.getAttribute("InstallmentType");
                            Object amount = rowOcMsDtl.getAttribute("Attribute4")==null ? rowOcMsDtl.getAttribute("InstallmentAmount"):rowOcMsDtl.getAttribute("Attribute4");
                            unitSellingPrice=amount;
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
                        if (orgIdD == null) {
                            validationFlag = "N";
                            JSFUtils.addFacesErrorMessage("==Destination Business Unit is Required==");
                        }else {
                                Map<String, Object> arSetupMap = null;
                                System.err.println("Enter in to the loop");
                                arSetupMap =
                                        getArSetupDetails(orgIdD.toString(),instalType.toString());
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

                        segmentedCode ="";
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
                        if (otherChargesNumber == null) {

                            validationFlag = "N";
                            JSFUtils.addFacesErrorMessage("other Charges Trx Number is Required");

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
                            obj.put("orgId", orgIdD.toString());
                            obj.put("unitName", "");
                            obj.put("buildingName", "");
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
                            obj.put("leaseNumber",otherChargesNumber.toString());
                            obj.put("bookingNumber", "");
                            obj.put("accountClass", accountClass.toString());
                            obj.put("dynamicInsertion", dynamicInsertion.toString());
                            obj.put("segmentedCode", segmentedCode.toString());
                            obj.put("ledgerName", ledgerName.toString());
                            obj.put("enabledFlag", enabledFlag.toString());
                            obj.put("fromDate", fromDate.toString());
                            obj.put("toDate", toDate.toString());
                            obj.put("environment", environment.toString());
                            obj.put("transactions", i);
                            obj.put("ccId", revAccountId);

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
                            ocHdrDpVo.getCurrentRow().setAttribute("IntegrationResponse", responseOut);
                            ADFUtils.findOperation("Commit").execute();
                            AdfFacesContext.getCurrentInstance().addPartialTarget(generate_invoice_cb3);
                            }
                        }
            //for ar setup
                i++;
                        }
                        rsiOC.closeRowSetIterator();
                }
                otherChargesHdrRS.closeRowSetIterator();

            } catch (Exception e) {
                JSFUtils.addFacesInformationMessage("Error in invoicePayload" + e);
            }
        }
    
    public Map<String, Object> getArSetupDetails(String p_orgdId, String p_chargeType) {
        Map<String, Object> arSetupMap = null;

        arSetupMap = new HashMap<String, Object>();
        ViewObject arSetupVO =
            ADFUtils.findIterator("getARSetupDetails_ROVO1Iterator").getViewObject();
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

        public Object getCurrentDateForPayload() {
        Calendar cal = Calendar.getInstance();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Object sysDate = sdf.format(cal.getTime());
        return sysDate;
        }

    public void getInvoiceRes(ActionEvent actionEvent) {
        String leaseNumber = "";
        try {
            String otherChargesNo =
                ocHdrDpVo.getCurrentRow().getAttribute("OtherChargesNumber") ==
                null ? "0" :
                ocHdrDpVo.getCurrentRow().getAttribute("OtherChargesNumber").toString();

            invokeARInvoiceBIWS(otherChargesNo);
            ocHdrDpVo.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(generate_invoice_cb3);


        } catch (Exception e) {
            BindingContext bctx = BindingContext.getCurrent();
            ((DCBindingContainer)bctx.getCurrentBindingsEntry()).reportException(new CommonJBOException("TEST", propertyBundle));
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
//                    otherChargeNumber =
//                            otherChargeNumber.substring(otherChargeNumber.indexOf("/"));
//                    otherChargeNumber =
//                            otherChargeNumber.substring(1, 8).toString(); //OC-3017
                    args.put("pCustomerTrxId",
                             reportOutput.getElementsByTagName("CUSTOMER_TRX_ID").item(0).getTextContent().toString());
                    args.put("pCustomerTrxNo",
                             reportOutput.getElementsByTagName("TRX_NUMBER").item(0).getTextContent().toString());
                    Object a = method.execute();
                    JSFUtils.addFacesInformationMessage("RESPONSE--" + a);
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

    public void setGenerate_invoice_cb3(RichCommandButton generate_invoice_cb3) {
        this.generate_invoice_cb3 = generate_invoice_cb3;
    }

    public RichCommandButton getGenerate_invoice_cb3() {
        return generate_invoice_cb3;
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
    
    public void onClickApprove(ActionEvent actionEvent) {
        String result = "Y";
        if (result == "Y") {
            String ResultVal = null;
            Row row = ocHdrDpVo.getCurrentRow();
            String Reason = 
                this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
            //
//            System.out.println("func id :: " + row.getAttribute("FuncId"));
//            System.out.println("OcHdrId id :: " + row.getAttribute("OcHdrId"));
//            System.out.println("UserGrpId id :: " + row.getAttribute("UserGrpId"));
//            System.out.println("FlowLevel id :: " + row.getAttribute("FlowLevel"));
//            System.out.println("FlowWith id :: " + row.getAttribute("FlowWith"));
            //
            try {
                OperationBinding op=ADFUtils.findOperation("responseOcForApprDP");
                          op.getParamsMap().put("ocId",row.getAttribute("OcHdrId").toString());
                          op.getParamsMap().put("reason",Reason);
                          op.getParamsMap().put("apr_rej","A");
                          ResultVal=op.execute().toString();
                //          JSFUtils.addFacesInformationMessage(flag);
            } catch (Exception e) {
                System.err.println("ERROR" + e);
            }
    
                if (ResultVal.equals("Success")) {
                    //04-June  for change of status of Milestone and Receipt
//                    String status = row.getAttribute("Status").toString();
//                    onChangeStatus();
                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Approved....");
                } else {
                    JSFUtils.addFacesErrorMessage("Error in Approve process!");
                }
        }
    }
    
    public void onClickReject(ActionEvent actionEvent) {
        String ResultVal = null;
        Row row = ocHdrDpVo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Rejected" : this.reason.getValue().toString();

        try {
                OperationBinding op=ADFUtils.findOperation("responseOcForApprDP");
                          op.getParamsMap().put("ocId",row.getAttribute("OcHdrId").toString());
                          op.getParamsMap().put("reason",Reason);
                          op.getParamsMap().put("apr_rej","R");
                          ResultVal=op.execute().toString();
                //          JSFUtils.addFacesInformationMessage(flag);

        } catch (Exception e) {
            System.out.println(e);
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
//            onChangeStatusForRej();
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Rejected....");

        } else {
            JSFUtils.addFacesErrorMessage("Error in Reject process!");
        }

    }
    
    public void onChangeStatusForRej() {
        
        RowSetIterator rsi = null;
        if (bkMsdtlVo1.getEstimatedRowCount() > 0) {
            System.out.println("On rej for Ms " + bkMsdtlVo1.getEstimatedRowCount());

            try {
                rsi = bkMsdtlVo1.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row r = rsi.next();
                    r.setAttribute("Status", "REJ");
                }
            } catch (Exception e) {

            } finally {
                rsi.closeRowSetIterator();
            }
        }

        if (rcptDpVo1.getEstimatedRowCount() > 0) {
            System.out.println("On rej for Rcpt " + rcptDpVo1.getEstimatedRowCount());
            try {
                rsi = rcptDpVo1.createRowSetIterator(null);
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

    public void setReason(RichInputText reason) {
        this.reason = reason;
    }

    public RichInputText getReason() {
        return reason;
    }

    public void doSaveHandleGlobalSite(ActionEvent actionEvent) {
        // Add event code here...
    }

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
            Object environment = "prod";

            receiptPayMode = rcptDpVo1.getCurrentRow().getAttribute("PayMode");
            receiptNumber =
                    rcptDpVo1.getCurrentRow().getAttribute("ReceiptNumber");
            if (receiptPayMode == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Receipt Payment Mode is Required");
            } else {

                chequeEffectiveDate =
                        rcptDpVo1.getCurrentRow().getAttribute("PayRefDate");
                chequeNo =
                        rcptDpVo1.getCurrentRow().getAttribute("PayRefNumber");
                receiptNumber =
                        rcptDpVo1.getCurrentRow().getAttribute("ReceiptNumber");
                receiptDate =
                        rcptDpVo1.getCurrentRow().getAttribute("ReceiptDate");
                amount =
                        rcptDpVo1.getCurrentRow().getAttribute("RecommendedAmount");

                Object otherChargesID = ocHdrDpVo.getCurrentRow().getAttribute("OcHdrId");
                leaseNumber= ocHdrDpVo.getCurrentRow().getAttribute("OtherChargesNumber");

                ViewObject invoiceInterfaceValueVO =
                    ADFUtils.findIterator("getOcDpBkMsDtlInvoiceLines_RoVo1Iterator").getViewObject();
                invoiceInterfaceValueVO.setNamedWhereClauseParam("p_oc_id", otherChargesID);
                invoiceInterfaceValueVO.executeQuery();
                if (invoiceInterfaceValueVO.first() != null) {
                    orgId = ocHdrDpVo.getCurrentRow().getAttribute("DestinationBu");
                    customerId = invoiceInterfaceValueVO.first().getAttribute("CustId");
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
            }


            if (validationFlag == "Y") {
                JSONObject obj = new JSONObject();

                obj.put("amount", amount.toString());
                obj.put("currencyCode", currencyCode.toString());
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
                obj.put("bookingNumber", "");
                obj.put("building", "");
                obj.put("unit", "");
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
                JSFUtils.addFacesInformationMessage("Invoice Response in  receiptId" + jsonObject);
                rcptDpVo1.getCurrentRow().setAttribute("Attribute1", receiptId);
                this.receiptResponse.setValue(receiptId);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getReceiptResponse());
                ADFUtils.findOperation("Commit").execute();
            }

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error in Receipt Create--" +
                                                e);
        }
    }

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

            Row currRow = rcptDpVo1.getCurrentRow();

            amountApplied = currRow.getAttribute("RecommendedAmount");
            customerTrxId = ocHdrDpVo.getCurrentRow().getAttribute("CustomerTrxnId");
            receipt_Number = currRow.getAttribute("ReceiptNumber");
            receiptAmount = currRow.getAttribute("RecommendedAmount");
            receipt_Date = currRow.getAttribute("ReceiptDate");
            cashRecieptId = currRow.getAttribute("Attribute1");
            invoiceDateLS = ocHdrDpVo.getCurrentRow().getAttribute("CreateDate");
//                    leaseAgreemntVo.first().getAttribute("LeaseStartDate");

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

    public void setReceiptResponse(RichInputText receiptResponse) {
        this.receiptResponse = receiptResponse;
    }

    public RichInputText getReceiptResponse() {
        return receiptResponse;
    }

    public void onCheckCashierFlag(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        Row r=rcptDpVo1.getCurrentRow();
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
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.id5);
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

    public void setId5(RichInputDate id5) {
        this.id5 = id5;
    }

    public RichInputDate getId5() {
        return id5;
    }
}
