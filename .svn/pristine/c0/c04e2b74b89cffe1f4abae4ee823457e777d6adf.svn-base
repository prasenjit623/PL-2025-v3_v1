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

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import org.json.simple.JSONObject;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditWoInvHdrBb {
    private RichPopup p3;
    private RichInputText reason;
    private RichInputText it18;
    private RichInputText it1;
    private static String propertyBundle = "view.PropertyLease_ViewControllerBundle";
    private RichPanelFormLayout woInvHdrform;

    public AddEditWoInvHdrBb() {
    }
    ViewObject woInvHdrVo = ADFUtils.findIterator("WoInvHdr_VO1Iterator").getViewObject();
    ViewObject woInvDtlRoVo = ADFUtils.findIterator("WoInvDtls_RoVo1Iterator").getViewObject();
    ViewObject woInvDtlArVo = ADFUtils.findIterator("WoInvDetailAr_VO1Iterator").getViewObject();
    
    public void doSave(ActionEvent actionEvent) {
        Row row = woInvHdrVo.getCurrentRow();
        ViewObject getFuncodeVo = ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
        getFuncodeVo.setNamedWhereClauseParam("F_ID", "WOINV");
        getFuncodeVo.executeQuery();
        if(row.getAttribute("WoInvHdrNo")==null){
            String woInvHdrId = row.getAttribute("WoInvHdrId")==null?"":row.getAttribute("WoInvHdrId").toString();
            System.out.println("WoInvHdrId on save ::"+woInvHdrId);
            row.setAttribute("WoInvHdrNo", "WOINV-"+woInvHdrId); 
            String name = xxfnd.generateDocNo("WOINV", "WoInv_AMDataControl").toString();
            row.setAttribute("FuncId", getFuncodeVo.first().getAttribute("FuncId"));
        }
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully !!!");
    }

    public String onSaveAndClose() {
        // Add event code here...
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully !!!");
        return "back";
    }

    public String onClickSubmit() {
        // Add event code here...
        Row row = woInvHdrVo.getCurrentRow();
        Object org =
            row.getAttribute("OrgId") == null ? 0 :
            row.getAttribute("OrgId");
        Object prop =
            row.getAttribute("PropertyId") == null ? 0 :
            row.getAttribute("PropertyId");
        Object unit =
            row.getAttribute("BuildingId") == null ? 0 :
            row.getAttribute("BuildingId");
        String ResultVal = null;
        try {
            ResultVal =
                    xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
                                          row.getAttribute("FuncId"),
                                          row.getAttribute("WoInvHdrId"),
                                          0, "XXPM_WO_INV_HEADER", "STATUS",
                                          "WO_INV_HDR_ID", org, prop, unit,
                                          null, null);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (ResultVal.equalsIgnoreCase("Success")) {

            JSFUtils.addFacesInformationMessage("Submitted For Approval");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
        }
        return "back";
    }

    public void onDoCancel(ActionEvent actionEvent) {
        ADFUtils.findOperation("Rollback").execute();
    }

    public void onInvokeAppOrReject(ActionEvent actionEvent) {
        // Add event code here...
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getP3().show(popup34);
    }

    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
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
    
    public void onClickApprove(ActionEvent actionEvent) {

        Map<String, BigDecimal> ResultVal = new HashMap<String, BigDecimal>();
        Row row = woInvHdrVo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
        try {
            ResultVal =
                    xxfnd.invokeResponsePkgs("xxfnd_util_pkg.update_response",
                                             row.getAttribute("FuncId"),
                                             row.getAttribute("WoInvHdrId"),
                                             row.getAttribute("UserGrpId"),
                                             row.getAttribute("FlowLevel"),
                                             row.getAttribute("FlowWith"),
                                             Reason, "A", 0,
                                             "XXPM_WO_INV_HEADER", "STATUS",
                                             "WO_INV_HDR_ID");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (Map.Entry m : ResultVal.entrySet()) {
            System.out.println("KEY" + m.getKey() + "VALUE " + m.getValue());

            if (m.getKey().equals("Success")) {
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Approved Successfully");
            } else {
                JSFUtils.addFacesErrorMessage("Error in Approve process!");
            }
        }
    }

    public void onClickReject(ActionEvent actionEvent) {
        String ResultVal = null;
        Row row = woInvHdrVo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Rejected" : this.reason.getValue().toString();

        try {
            ResultVal =
                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
                                            row.getAttribute("FuncId"),
                                            row.getAttribute("WoInvHdrId"),
                                            row.getAttribute("UserGrpId"),
                                            row.getAttribute("FlowLevel"),
                                            row.getAttribute("FlowWith"),
                                            Reason, "R", 0,
                                            "XXPM_WO_INV_HEADER", "STATUS",
                                            "WO_INV_HDR_ID");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Rejected Successfully");
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

    public void doGenerateInvoice(ActionEvent actionEvent) throws IOException {
        // Add event code here...
        try {

            int transactionValue = 1;
                String getLeaseType = "";
                String getTrxnsType = "";
                String validationFlag = "Y";
            Row row = woInvHdrVo.getCurrentRow();
            Row r = woInvDtlRoVo.getCurrentRow();
            String billableTo = row.getAttribute("BillableTo")==null ? "":row.getAttribute("BillableTo").toString();
            String billableStatus = row.getAttribute("SerialNumber")==null ? "":row.getAttribute("SerialNumber").toString();
//            if(billableTo.equalsIgnoreCase("Landlord")){
            RowSetIterator invoiceRS = woInvHdrVo.createRowSetIterator(null);
                while (invoiceRS.hasNext()) {
                Row currRow = invoiceRS.next();
                    Object taxValue ="VAT 0%";
                    Object unitId = currRow.getAttribute("UnitId");
                    Object orgId ="300000002841399";
//                        currRow.getAttribute("OrgId");
//                Object amount ="0";
//                    if (billableStatus.equalsIgnoreCase("Under Contract")){
//                         amount = currRow.getAttribute("MaterialCost");  
//                    }else{
//                     amount = currRow.getAttribute("TotalCost");
//                    }
//                Object amount =
//                    currRow.getAttribute("MaterialCost");
                    Object billCustomerAccountNumber = "";
                    Object billCustomerSiteNumber = "";
//                    if(billableTo.equalsIgnoreCase("Landlord")){
//                    billCustomerAccountNumber = "290036";
//                    billCustomerSiteNumber = "266231";
//                    }else{
//                        billCustomerAccountNumber = currRow.getAttribute("Customernumber");
//                        billCustomerSiteNumber = currRow.getAttribute("BillToAddre");
//                    }
                    billCustomerAccountNumber = currRow.getAttribute("Customernumber");
                    billCustomerSiteNumber = currRow.getAttribute("BillToAddre");
                    Object billingDate = getCurrentDateForPayload();
                    Object comments = "Property Lease Module";
                    Object ruleStartDate = getCurrentDateForPayload();
                    row.setAttribute("GlDate", ruleStartDate);
//                        currRow.getAttribute("LeaseStartDate");
                    //                    Object trxDate = getCurrentDateForPayload(); //JAN-8 commented bcoz logic change
                    Object trxDate = ruleStartDate;
                    Object currencyCode = "AED";
                    Object description = "";
//                    Object glDate = getCurrentDateForPayload(); //JAN-8 commented bcoz logic change
                    Object glDate = getClosedDate(currRow.getAttribute("ClosedDate"));//getClosedDate
//                    System.out.println("glDate ::"+glDate);
                    JSFUtils.addFacesInformationMessage("== rule Start Date==" + ruleStartDate);
//                    Object glDate = invokeReport(ruleStartDate.toString());
//                    JSFUtils.addFacesInformationMessage("===Output from BI Report==" +
//                                                        glDate);
                    Object ruleEndDate = ruleStartDate;
                    Object unitSellingPrice = "0";
//                if (billableStatus.equalsIgnoreCase("Under Contract")){
//                     unitSellingPrice = currRow.getAttribute("MaterialCost");  
//                }else{
//                 unitSellingPrice =currRow.getAttribute("TotalCost");
//                }
//                    Object unitSellingPrice = currRow.getAttribute("TotalCost");
//                    Object unitSellingPrice = currRow.getAttribute("MaterialCost");
                    Object lineType = "LINE";
                    Object quantity = "1";
                    Object paymentTermsName = "IMMEDIATE";
                    Object taxCode = "VAT 0%";
                    Object flexContext = "Property_Leasing";
                    Object leaseNumber = currRow.getAttribute("WoInvHdrNo");
                    Object bookingNumber = currRow.getAttribute("WorkOrder");
                    Object dynamicInsertion = "Y";
                    Object segmentedCode = currRow.getAttribute("Asset");
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
                    Object unitName = r.getAttribute("UnitName")==null ? "" : r.getAttribute("UnitName");
                    Object buildingName = r.getAttribute("BuildName")==null ? "" : r.getAttribute("BuildName");
                    Object amount = "0";
                    Object chrgType = "";
                RowSetIterator rsiAR = woInvDtlArVo.createRowSetIterator(null);
                int i=1;
                while(rsiAR.hasNext()) {  
                    System.out.println("iterator no i :"+i);                    
                    Row rowArLine = rsiAR.next();
                chrgType = rowArLine.getAttribute("Charges");
                    description=chrgType;
                amount = rowArLine.getAttribute("Amount")==null ? "0" : rowArLine.getAttribute("Amount");
//                if (billableStatus.equalsIgnoreCase("Under Contract")){
//                    amount = currRow.getAttribute("MaterialCost");  
//                }else{
//                    amount = currRow.getAttribute("TotalCost");
//                }
                unitSellingPrice = amount;
                taxCode = rowArLine.getAttribute("TaxCode")== null ? "0" : rowArLine.getAttribute("TaxCode");
                int vatInt = Integer.parseInt(taxCode.toString());
                if(vatInt==5){
                    taxCode="VAT 5%";  
                }else{
                    taxCode="VAT 0%"; 
                }
                System.out.println("ChargeType OC :"+chrgType);
                System.out.println("Line wise amount ar :"+amount);
                System.out.println("Tax code WO inv :"+taxCode);
                    
                    if (unitName == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("==Unit Name is Required==");
                    }
                    if (buildingName == null) {
                        validationFlag = "N";
                        JSFUtils.addFacesErrorMessage("==Building Name is Required==");
                        
                    } 
                                Map<String, Object> arSetupMap = null;
                                arSetupMap = getArSetupDetails(orgId.toString(),chrgType.toString());
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
                        obj.put("amount", amount.toString());
                        obj.put("batchSourceName", batchSourceName.toString());
                        obj.put("customerTrxTypeName", customerTrxTypeName.toString());
                        obj.put("billCustomerAccountNumber", billCustomerAccountNumber.toString());
                        obj.put("billCustomerSiteNumber", billCustomerSiteNumber.toString());
                        obj.put("billingDate", billingDate.toString());
                        obj.put("comments", comments.toString());
                        obj.put("trxDate", trxDate.toString());
                        obj.put("currencyCode", currencyCode.toString());
                        obj.put("description", description.toString());
                        obj.put("glDate", glDate);
                        obj.put("invoicingRuleName", invoicingRuleName.toString());
                        obj.put("accountingRuleName", accountingRuleName.toString());
                        obj.put("ruleEndDate", ruleEndDate.toString());
                        obj.put("ruleStartDate", ruleStartDate.toString());
                        obj.put("unitSellingPrice", unitSellingPrice.toString());
                        obj.put("lineType", lineType.toString());
                        obj.put("quantity", quantity.toString());
                        obj.put("paymentTermsName", paymentTermsName.toString());
                        obj.put("taxCode", taxCode.toString());
                        obj.put("flexContext", flexContext.toString());
                        obj.put("leaseNumber", leaseNumber.toString());
                        obj.put("bookingNumber", bookingNumber.toString());
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
//                                responseOut.contains("{\"result\":\"Success\"}");
                        if(responseOut.contains("Success")){
                        row.setAttribute("InvStatus", "INVOICED");
//                        ADFUtils.findOperation("Commit").execute();
//                        AdfFacesContext.getCurrentInstance().addPartialTarget(generate_invoice_cb15);
                        }else{
                            row.setAttribute("InvStatus", "Error");
                        }
                            ADFUtils.findOperation("Commit").execute();
                        }
                        System.out.println("Invoice Response in json" + out.toString());
                    }
                    i++;
                        }
                rsiAR.closeRowSetIterator();
            } // first while loop
//            }else{
//                JSFUtils.addFacesInformationMessage("Billable to is not Landlord so no invoice !!!");
//            }

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error in invoicePayload" + e);
        }
    }
    
    public Map<String, Object> getArSetupDetails(String p_orgdId,
                                                 String p_chargeType) {
        Map<String, Object> arSetupMap = null;

        arSetupMap = new HashMap<String, Object>();
        ViewObject arSetupVO = ADFUtils.findIterator("getARSetupDetails_ROVO1Iterator").getViewObject();
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
    
    public Object getCurrentDateForPayload() {
        Calendar cal = Calendar.getInstance();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Object sysDate = sdf.format(cal.getTime());
        return sysDate;
    }
    
    public Object getClosedDate(Object closedDate) {
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Object sysDate = sdf.format(closedDate);
        return sysDate;
    }

    public void doSyncInvoice(ActionEvent actionEvent) {
        // Add event code here...
        String leaseNumber = "";
        try {
            Row row = woInvHdrVo.getCurrentRow();
            String woInvHdrNo = row.getAttribute("WoInvHdrNo") == null ? "0" : row.getAttribute("WoInvHdrNo").toString();
             System.out.println("==Report input==" +woInvHdrNo);

            invokeARInvoiceBIWS(woInvHdrNo);
//            otherChargesVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.woInvHdrform);
        } catch (Exception e) {
            //JSFUtils.addFacesInformationMessage("Error" + e);
            //System.out.println("Exception : " + e.getMessage());
            BindingContext bctx = BindingContext.getCurrent();
            ((DCBindingContainer)bctx.getCurrentBindingsEntry()).reportException(new CommonJBOException("TEST", propertyBundle));
        }
    }
    
    public void invokeARInvoiceBIWS(String p_woInvHdrNo) {
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
                "                    <pub:item>" + p_woInvHdrNo +
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
                    OperationBinding method = bindings.getOperationBinding("getARInvoiceTrxDetailsWoInv");
                    Map args = method.getParamsMap();
                    JSFUtils.addFacesInformationMessage("==Calling AM==" +
                                                        reportOutput.getElementsByTagName("P_LEASE_NUMBER").item(0).getTextContent().toString());
                    String otherChargeNumber =
                        reportOutput.getElementsByTagName("P_LEASE_NUMBER").item(0).getTextContent().toString();
                    //s1=s1.substring(0,s1.indexOf("/"));  ----(LA-1309/OC-3017")
                    //s1=s1.substring(1,8);

//                    otherChargeNumber =
//                            otherChargeNumber.substring(otherChargeNumber.indexOf("/"));
//                    otherChargeNumber =
//                            otherChargeNumber.substring(1, 8).toString(); //OC-3017
                    //                    System.out.println("otherChargeNumber==="+otherChargeNumber);
                    String woInvHdrNo = woInvHdrVo.getCurrentRow().getAttribute("WoInvHdrNo")==null?""
                                        : woInvHdrVo.getCurrentRow().getAttribute("WoInvHdrNo").toString();
                    args.put("pWoInvNum", woInvHdrNo);
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
    public void doSelectTaxCode(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Row r = woInvDtlArVo.getCurrentRow();
        BigDecimal taxCbd = new BigDecimal(0);
        BigDecimal amtBD = new BigDecimal(0);
        BigDecimal taxamtBD = new BigDecimal(0);
        BigDecimal percntBD = new BigDecimal(100);
        BigDecimal totlAmtBD = new BigDecimal(0);
        System.out.println("New value :"+valueChangeEvent.getNewValue());
        String amt = r.getAttribute("Amount")==null?"0":r.getAttribute("Amount").toString();
        String taxCode = valueChangeEvent.getNewValue()==null ? "0" : valueChangeEvent.getNewValue().toString();
        if(valueChangeEvent.getNewValue()!=null){
            taxCbd = new BigDecimal(taxCode);
            amtBD = new BigDecimal(amt);
            taxamtBD = (amtBD.multiply(taxCbd)).divide(percntBD);
            taxamtBD = taxamtBD.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            totlAmtBD = amtBD.add(taxamtBD);
        }
        r.setAttribute("TotalAmount", totlAmtBD);
        r.setAttribute("TaxAmount", taxamtBD);
        BigDecimal totlInvArAmtBD = new BigDecimal(0);
        RowSetIterator rs = woInvDtlArVo.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row rowAr = rs.next();   
            String totlAmt = rowAr.getAttribute("TotalAmount")==null ? "0" : rowAr.getAttribute("TotalAmount").toString();
            System.out.println("Total amt on tax line wise ::"+totlAmt);
            BigDecimal invArAmtBD = new BigDecimal(totlAmt);
            totlInvArAmtBD = totlInvArAmtBD.add(invArAmtBD);
        }
        rs.closeRowSetIterator();
        woInvHdrVo.getCurrentRow().setAttribute("TotalInvCost", totlInvArAmtBD);
    }

    public void onSelectWoNo(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        BigDecimal mtrlCostBD = new BigDecimal(0);
        BigDecimal rscCostBD = new BigDecimal(0);
        BigDecimal markupCostDB = new BigDecimal(0);
        BigDecimal markupPercentDB = new BigDecimal(0.2);
        BigDecimal totlInvCostDB = new BigDecimal(0);
        String materialCost = "0";
        String resourceCost = "0";
        String markupCost = "0";
        Row row = woInvHdrVo.getCurrentRow();
        String woInvHdrId = row.getAttribute("WoInvHdrId")==null ? "0" : row.getAttribute("WoInvHdrId").toString();
        String woNo = valueChangeEvent.getNewValue()==null ? "":valueChangeEvent.getNewValue().toString();
        ViewObject getWoInfoRoVo = ADFUtils.findIterator("GetWoHdrInfo_ROVO1Iterator").getViewObject();
        ViewCriteria vc=getWoInfoRoVo.createViewCriteria();
        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
        vcr.setAttribute("WorkOrder",woNo);
        vc.addRow(vcr);
        getWoInfoRoVo.applyViewCriteria(vc);
        getWoInfoRoVo.executeQuery();
        if(getWoInfoRoVo.getEstimatedRowCount()>0){
            materialCost = getWoInfoRoVo.first().getAttribute("MaterialCost")==null ?"0":getWoInfoRoVo.first().getAttribute("MaterialCost").toString();
            resourceCost = getWoInfoRoVo.first().getAttribute("ResourceCost")==null ?"0":getWoInfoRoVo.first().getAttribute("ResourceCost").toString();
        }
//        String materialCost = it18.getValue()==null ? "0" : it18.getValue().toString();
//        String resourceCost = it1.getValue()==null ? "0" : it1.getValue().toString();
        System.out.println("mCost %%"+materialCost+" rCost %%"+resourceCost);
        String userName =
            ADFContext.getCurrent().getSessionScope().get("userName") == null ?
            null :
            ADFContext.getCurrent().getSessionScope().get("userName").toString();
//        materialCost = row.getAttribute("MaterialCost")==null ? "0" : row.getAttribute("MaterialCost").toString();
//        resourceCost = row.getAttribute("ResourceCost")==null ? "0" : row.getAttribute("ResourceCost").toString();
        System.out.println("materialCost ::"+materialCost+" resourceCost::"+resourceCost);
        if(valueChangeEvent.getNewValue()!=null){
           
            mtrlCostBD = new BigDecimal(materialCost);
            rscCostBD = new BigDecimal(resourceCost);
            markupCostDB = mtrlCostBD.multiply(markupPercentDB);
            markupCostDB = markupCostDB.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            totlInvCostDB = (mtrlCostBD.add(rscCostBD)).add(markupCostDB);
//            doCreateArLinesCalPkg(woInvHdrId,materialCost,resourceCost,userName);
            row.setAttribute("TotalInvCost", totlInvCostDB);
            markupCost = markupCostDB.toString();
            System.out.println("woInvHdrId::"+woInvHdrId+" materialCost ::"+materialCost+" resourceCost ::"+resourceCost+" markupCost ::"+markupCost+" userName ::"+userName);
            //do insert
            doInsrtWoInvArLines(woInvHdrId,materialCost,resourceCost,markupCost,userName);
            RowSetIterator rs = woInvDtlArVo.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row rowAr = rs.next();   
                BigDecimal totlInvArAmtBD = new BigDecimal(0);
                String totlAmt = rowAr.getAttribute("TotalAmount")==null ? "0" : rowAr.getAttribute("TotalAmount").toString();
                BigDecimal invArAmtBD = new BigDecimal(totlAmt);
                totlInvArAmtBD = invArAmtBD.add(invArAmtBD);
            }
            rs.closeRowSetIterator();
        }       
    }
    
    public void doInsrtWoInvArLines(String woInvHdrId,String materialCost,String resourceCost,String markupCost,String userName) {
        RowSetIterator rs = woInvDtlArVo.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row r = rs.next();
            r.remove();
        }
        //Insert MATERIAL_COST line 1
        Row rwM = woInvDtlArVo.createRow();
        rwM.setAttribute("WoInvHdrId", woInvHdrId);
        rwM.setAttribute("Charges", "MATERIAL_COST");
        rwM.setAttribute("TaxCode", "0");
        rwM.setAttribute("TaxAmount", "0");
        rwM.setAttribute("Amount", materialCost);
        rwM.setAttribute("TotalAmount", materialCost);
        rwM.setAttribute("CreatedBy", userName);
//        rwM.setAttribute("CreationDate", "");
        rwM.setAttribute("LastUpdatedBy", userName);
//        rwM.setAttribute("LastUpdateDate", "");
        woInvDtlArVo.insertRow(rwM);
        //Insert RESOURCE_COST line 2
        Row rwR = woInvDtlArVo.createRow();
        rwR.setAttribute("WoInvHdrId", woInvHdrId);
        rwR.setAttribute("Charges", "RESOURCE_COST");
        rwR.setAttribute("TaxCode", "0");
        rwR.setAttribute("TaxAmount", "0");
        rwR.setAttribute("Amount", resourceCost);
        rwR.setAttribute("TotalAmount", resourceCost);
        rwR.setAttribute("CreatedBy", userName);
        //        rwR.setAttribute("CreationDate", "");
        rwR.setAttribute("LastUpdatedBy", userName);
        //        rwR.setAttribute("LastUpdateDate", "");
        woInvDtlArVo.insertRow(rwR);
        //Inserrt MARKUP line 3
        Row rwMup = woInvDtlArVo.createRow();
        rwMup.setAttribute("WoInvHdrId", woInvHdrId);
        rwMup.setAttribute("Charges", "MARKUP");
        rwMup.setAttribute("TaxCode", "0");
        rwMup.setAttribute("TaxAmount", "0");
        rwMup.setAttribute("Amount", markupCost);
        rwMup.setAttribute("TotalAmount", markupCost);
        rwMup.setAttribute("CreatedBy", userName);
        //        rwMup.setAttribute("CreationDate", "");
        rwMup.setAttribute("LastUpdatedBy", userName);
        //        rwMup.setAttribute("LastUpdateDate", "");
        woInvDtlArVo.insertRow(rwMup);
    }
    
    public void doCreateArLinesCalPkg(String wo_inv_hdr_id,String material_cost,String resource_cost,String user_name){
        
              OperationBinding op=ADFUtils.findOperation("createWoArLines");
              op.getParamsMap().put("wo_inv_hdr_id",wo_inv_hdr_id);
              op.getParamsMap().put("material_cost",material_cost);
              op.getParamsMap().put("resource_cost",resource_cost);
              op.getParamsMap().put("user_name",user_name);
              String flag=op.execute().toString();
              JSFUtils.addFacesInformationMessage(flag);
        }

    public void setIt18(RichInputText it18) {
        this.it18 = it18;
    }

    public RichInputText getIt18() {
        return it18;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void onDoCancelWo(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void setWoInvHdrform(RichPanelFormLayout woInvHdrform) {
        this.woInvHdrform = woInvHdrform;
    }

    public RichPanelFormLayout getWoInvHdrform() {
        return woInvHdrform;
    }
}
