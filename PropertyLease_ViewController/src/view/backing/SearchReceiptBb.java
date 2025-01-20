package view.backing;

import java.io.OutputStream;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.event.ReturnEvent;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import util.ADFUtils;

public class SearchReceiptBb {
    private RichTable table_resId1;

    public SearchReceiptBb() {
        super();
    }

    public void returnSearchOnClickAdd(ReturnEvent returnEvent) {
        // Add event code here...
        ViewObject searchReceiptROVO =
            ADFUtils.findIterator("SearchReceiptRoVo1Iterator").getViewObject();
        searchReceiptROVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(table_resId1);
    }

    public void setTable_resId1(RichTable table_resId1) {
        this.table_resId1 = table_resId1;
    }

    public RichTable getTable_resId1() {
        return table_resId1;
    }

    public void onClickAdd(ActionEvent actionEvent) {
        // Add event code here...
//        ADFContext.getCurrent().getPageFlowScope().put("receiptType", "MS");
    }

    public void returnOnClickEdit(ReturnEvent returnEvent) {
        // Add event code here...
        ViewObject searchReceiptROVO =
            ADFUtils.findIterator("SearchReceiptRoVo1Iterator").getViewObject();
             searchReceiptROVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(table_resId1);
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    public void customReceiptSearch_QL(QueryEvent queryEvent) {
        DCIteratorBinding iter = (DCIteratorBinding) getBindings().get("SearchReceiptRoVo1Iterator");
                /**Get Offer ViewObject from Iterator*/
                ViewObjectImpl vo = (ViewObjectImpl) iter.getViewObject();
                String unitDummy=null;
                if (vo.getNamedWhereClauseParam("p_unitNum_dummy") != null) {
                    unitDummy = vo.getNamedWhereClauseParam("p_unitNum_dummy").toString();
                    System.out.println("UnitNumber:: "+unitDummy);
                    vo.setNamedWhereClauseParam("p_unitNum_trans", unitDummy);
                    vo.setNamedWhereClauseParam("p_unitNum_dummy", null);
    }
    ADFUtils.invokeMethodExpression("#{bindings.SearchVCQuery8.processQuery}", Object.class,
                                            QueryEvent.class, queryEvent);
            if (unitDummy != null) {
                vo.setNamedWhereClauseParam("p_unitNum_trans", null);
                vo.setNamedWhereClauseParam("p_unitNum_dummy", unitDummy);
                }
    }

    public void exportToExcel(javax.faces.context.FacesContext facesContext,
                              OutputStream outputStream) {
        try {

                    HSSFWorkbook workbook = new HSSFWorkbook();
                    HSSFSheet sheet = workbook.createSheet("Receipts");
                    HSSFRow rowhead = sheet.createRow((short)0);
                    rowhead.createCell(0).setCellValue("Receipt No");
                    sheet.setColumnWidth(0, 3000);
                    rowhead.createCell(1).setCellValue("Receipt Date");
                    sheet.setColumnWidth(1, 5500);
                    rowhead.createCell(2).setCellValue("Property Name");
                    sheet.setColumnWidth(2, 3000);
                    rowhead.createCell(3).setCellValue("Building Name");
                    sheet.setColumnWidth(3, 5000);
                    rowhead.createCell(4).setCellValue("Unit Name");
                    sheet.setColumnWidth(4, 3000);
                    rowhead.createCell(5).setCellValue("Customer Name");
                    sheet.setColumnWidth(5, 6000);
                    rowhead.createCell(6).setCellValue("Currency Code");
                    sheet.setColumnWidth(6, 3500);
                    rowhead.createCell(7).setCellValue("Receipt Amount");
                    sheet.setColumnWidth(7, 6000);
                    rowhead.createCell(8).setCellValue("Payment Mode");
                    sheet.setColumnWidth(8, 6000);
                    rowhead.createCell(9).setCellValue("Cheque No");
                    sheet.setColumnWidth(9, 5000);
                    rowhead.createCell(10).setCellValue("Maturity Date");
                    sheet.setColumnWidth(10, 5000);
                    rowhead.createCell(11).setCellValue("Bank Name");
                    sheet.setColumnWidth(11, 6000);
                    rowhead.createCell(12).setCellValue("Description");
                    sheet.setColumnWidth(12, 6000);
                    rowhead.createCell(13).setCellValue("Receipt Type");
                    sheet.setColumnWidth(13, 6000);
                    rowhead.createCell(14).setCellValue("Offer No");
                    sheet.setColumnWidth(14, 5000);
                    rowhead.createCell(15).setCellValue("OF Submitted By");
                    sheet.setColumnWidth(15, 6000);
                    rowhead.createCell(16).setCellValue("Booking No");
                    sheet.setColumnWidth(16, 5000);
                    rowhead.createCell(17).setCellValue("BK Submitted By");
                    sheet.setColumnWidth(17, 6000);
                    rowhead.createCell(18).setCellValue("RC No");
                    sheet.setColumnWidth(18, 5000);
                    rowhead.createCell(19).setCellValue("RC Submitted By");
                    sheet.setColumnWidth(19, 6000);
                    rowhead.createCell(20).setCellValue("LA No");
                    sheet.setColumnWidth(20, 5000);
                    rowhead.createCell(21).setCellValue("LA Submitted By");
                    sheet.setColumnWidth(21, 6000);
                    rowhead.createCell(22).setCellValue("LA Approved Date");
                    sheet.setColumnWidth(22, 6000);
                    rowhead.createCell(23).setCellValue("OC No");
                    sheet.setColumnWidth(23, 5000);
                    rowhead.createCell(24).setCellValue("OC Submitted By");
                    sheet.setColumnWidth(24, 6000);
                    rowhead.createCell(25).setCellValue("Cancel No");
                    sheet.setColumnWidth(25, 5000);
                    rowhead.createCell(26).setCellValue("CN Submitted By");
                    sheet.setColumnWidth(26, 6000);
                    rowhead.createCell(27).setCellValue("Cashier Acknowledged ?");
                    sheet.setColumnWidth(27, 6000);
                    rowhead.createCell(28).setCellValue("Cashier Acknowledged By");
                    sheet.setColumnWidth(28, 6000);
                    rowhead.createCell(29).setCellValue("Acknowledged Date");
                    sheet.setColumnWidth(29, 6000);
                    rowhead.createCell(30).setCellValue("Manual Receipt Voucher No");
                    sheet.setColumnWidth(30, 6000);
                    rowhead.createCell(31).setCellValue("Created By");
                    sheet.setColumnWidth(31, 6000);
                    rowhead.createCell(32).setCellValue("Receipt Status");
                    sheet.setColumnWidth(32, 6000);
                    rowhead.createCell(33).setCellValue("Phone No");
                    sheet.setColumnWidth(33, 5000);
                    rowhead.createCell(34).setCellValue("Purpose Of Rent");
                    sheet.setColumnWidth(34, 6000);
                    rowhead.createCell(35).setCellValue("Saas Receipt Status");
                    sheet.setColumnWidth(35, 6000);
                                
                    ViewObject actVO =
                        ADFUtils.findIterator("SearchReceiptRoVo1Iterator").getViewObject();
                    actVO.executeQuery();
                    if (actVO.getEstimatedRowCount() > 0) {
                        RowSetIterator rs = actVO.createRowSetIterator(null);
                        int excelRowData = 1;
                        while (rs.hasNext()) {
                            Row actRow = rs.next();
                            String receiptNo =
                                actRow.getAttribute("ReceiptNumber") != null ?
                                actRow.getAttribute("ReceiptNumber").toString() : "";
                            String receiptDate =
                                actRow.getAttribute("ReceiptDate") != null ?
                                actRow.getAttribute("ReceiptDate").toString() :
                                "";
                                                String propertyName =
                                actRow.getAttribute("PropertyName") != null ?
                                actRow.getAttribute("PropertyName").toString() : "";
                            String buildName =
                                actRow.getAttribute("BuildName") != null ?
                                actRow.getAttribute("BuildName").toString() : "";
                            String unitName =
                                actRow.getAttribute("UnitnameListaggTrans") != null ? 
                                                        actRow.getAttribute("UnitnameListaggTrans").toString() : "";
                            String customerName =
                                actRow.getAttribute("CustomerName") != null ?
                                actRow.getAttribute("CustomerName").toString() : "";
                                                String currencyCode =
                                actRow.getAttribute("CurrencyCode") != null ?
                                actRow.getAttribute("CurrencyCode").toString() : "";
                                                String receivedAmount =
                                actRow.getAttribute("ReceivedAmount") != null ?
                                actRow.getAttribute("ReceivedAmount").toString() : "";
                                                String payMode =
                                actRow.getAttribute("PayMode") != null ?
                                actRow.getAttribute("PayMode").toString() : "";
                                                String payRefNumber =
                                actRow.getAttribute("PayRefNumber") != null ?
                                actRow.getAttribute("PayRefNumber").toString() : "";
                                                String payRefDate =
                                actRow.getAttribute("PayRefDate") != null ?
                                actRow.getAttribute("PayRefDate").toString() : "";
                                                String bankName =
                                actRow.getAttribute("BankName") != null ?
                                actRow.getAttribute("BankName").toString() : "";
                                                String bankBranchName =
                                actRow.getAttribute("BankBranchName") != null ?
                                actRow.getAttribute("BankBranchName").toString() : "";
                                                String drawnBy =
                                actRow.getAttribute("DrawnBy") != null ?
                                actRow.getAttribute("DrawnBy").toString() : "";
                                                String description =
                                actRow.getAttribute("Description") != null ?
                                actRow.getAttribute("Description").toString() : "";
                                                String rcptType =
                                actRow.getAttribute("RctDesc") != null ?
                                actRow.getAttribute("RctDesc").toString() : "";
                                                String bookingNo =
                                actRow.getAttribute("BookingNumber") != null ?
                                actRow.getAttribute("BookingNumber").toString() : "";
                                                String ackFlag =
                                actRow.getAttribute("AckFlag") != null ?
                                actRow.getAttribute("AckFlag").toString() : "";
                            String ackBy =
                                actRow.getAttribute("AckBy") != null ?
                                actRow.getAttribute("AckBy").toString() : "";
                            String ackDate =
                                actRow.getAttribute("AckDate") != null ?
                                actRow.getAttribute("AckDate").toString() : "";
                            String manualRcptVuchrNo =
                                actRow.getAttribute("ManualReceiptVoucherNumber") != null ?
                                actRow.getAttribute("ManualReceiptVoucherNumber").toString() : "";
                            String createdBy =
                                actRow.getAttribute("CreatedBy") != null ?
                                actRow.getAttribute("CreatedBy").toString() : "";
                            //for receipt status
                    //                            String bookingId =
                    //                                actRow.getAttribute("BookingId") != null ?
                    //                                actRow.getAttribute("BookingId").toString() : "";
                    //                            ViewObject leaseVo =
                    //                                        ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
                    //                            ViewCriteria leaseDtlVCs = leaseVo.createViewCriteria();
                    //                            ViewCriteriaRow leaseDtlVCRs = leaseDtlVCs.createViewCriteriaRow();
                    //                            leaseDtlVCRs.setAttribute("BookingId", bookingId);
                    //                            leaseDtlVCs.addRow(leaseDtlVCRs);
                    //                            leaseVo.applyViewCriteria(leaseDtlVCs);
                    //                            leaseVo.executeQuery();
                    //                            if (leaseVo.first() != null) {
                    ////                                String receiptStatus = leaseVo.first().getAttribute("Status").toString();
                    //                            }
                            
                            String receiptStatus =
                                actRow.getAttribute("ReceiptStatus") == null ? "" :
                                actRow.getAttribute("ReceiptStatus").toString().equalsIgnoreCase("DRA") ?
                                "Draft" :
                                actRow.getAttribute("ReceiptStatus").toString().equalsIgnoreCase("PEN") ?
                                "Pending" :
                                actRow.getAttribute("ReceiptStatus").toString().equalsIgnoreCase("APR") ?
                                "Approved" :
                                actRow.getAttribute("ReceiptStatus").toString().equalsIgnoreCase("BO") ?
                                "Booked" :
                                actRow.getAttribute("ReceiptStatus").toString().equalsIgnoreCase("REJ") ?
                                "Rejected" :
                                actRow.getAttribute("ReceiptStatus").toString().equalsIgnoreCase("CAN") ?
                                "Cancelled" :
                                actRow.getAttribute("ReceiptStatus").toString().equalsIgnoreCase("TERM") ?
                                "Terminated" :
                                actRow.getAttribute("ReceiptStatus").toString();
                            String phNo =
                                actRow.getAttribute("PhoneNumber") != null ?
                                actRow.getAttribute("PhoneNumber").toString() : "";
                            
                            
                            String prposRent =
                            actRow.getAttribute("PurposeOfRent") != null ?
                            actRow.getAttribute("PurposeOfRent").toString() : "";
                            String saasRcptSts =
                            actRow.getAttribute("SaasReceiptStatus") != null ?
                            actRow.getAttribute("SaasReceiptStatus").toString() : "";
                            String offerNo =
                            actRow.getAttribute("OfferNumber") != null ?
                            actRow.getAttribute("OfferNumber").toString() : "";
                            String ofSubmittedBy =
                            actRow.getAttribute("OfSubmittedBy") != null ?
                            actRow.getAttribute("OfSubmittedBy").toString() : "";
                            String bkSubmittedBy =
                            actRow.getAttribute("BkSubmittedBy") != null ?
                            actRow.getAttribute("BkSubmittedBy").toString() : "";
                            String rcNo =
                            actRow.getAttribute("RecommendNoTrans") != null ?
                            actRow.getAttribute("RecommendNoTrans").toString() : "";
                            String rcSubmittedBy =
                            actRow.getAttribute("RcSubmittedBy") != null ?
                            actRow.getAttribute("RcSubmittedBy").toString() : "";
                            String contractNo =
                            actRow.getAttribute("LeaseNumber") != null ?
                            actRow.getAttribute("LeaseNumber").toString() : "";
                            String laSubmittedBy =
                            actRow.getAttribute("LaSubmittedBy") != null ?
                            actRow.getAttribute("LaSubmittedBy").toString() : "";
                            String laApprovedDate =
                            actRow.getAttribute("LaApprovedDate") != null ?
                            actRow.getAttribute("LaApprovedDate").toString() : "";
                            String ocNo =
                            actRow.getAttribute("OcNo") != null ?
                            actRow.getAttribute("OcNo").toString() : "";
                            String ocSubmittedBy =
                            actRow.getAttribute("OcSubmittedBy") != null ?
                            actRow.getAttribute("OcSubmittedBy").toString() : "";
                            String cnNo =
                            actRow.getAttribute("CancelNumber") != null ?
                            actRow.getAttribute("CancelNumber").toString() : "";
                            String cnSubmittedBy =
                            actRow.getAttribute("CnSubmittedBy") != null ?
                            actRow.getAttribute("CnSubmittedBy").toString() : "";
                            
                            HSSFRow row = sheet.createRow((short)excelRowData);
                            row.createCell(0).setCellValue(receiptNo);
                            row.createCell(1).setCellValue(receiptDate);
                            row.createCell(2).setCellValue(propertyName);
                            row.createCell(3).setCellValue(buildName);
                            row.createCell(4).setCellValue(unitName);
                            row.createCell(5).setCellValue(customerName);
                            row.createCell(6).setCellValue(currencyCode);
                            row.createCell(7).setCellValue(receivedAmount);
                            row.createCell(8).setCellValue(payMode);
                            row.createCell(9).setCellValue(payRefNumber);
                            row.createCell(10).setCellValue(payRefDate);
                            row.createCell(11).setCellValue(bankName);
                            row.createCell(12).setCellValue(description);
                            row.createCell(13).setCellValue(rcptType);
                            row.createCell(14).setCellValue(offerNo);
                            row.createCell(15).setCellValue(ofSubmittedBy);
                            row.createCell(16).setCellValue(bookingNo);
                            row.createCell(17).setCellValue(bkSubmittedBy);
                            row.createCell(18).setCellValue(rcNo);
                            row.createCell(19).setCellValue(rcSubmittedBy);
                            row.createCell(20).setCellValue(contractNo);
                            row.createCell(21).setCellValue(laSubmittedBy);
                            row.createCell(22).setCellValue(laApprovedDate);
                            row.createCell(23).setCellValue(ocNo);
                            row.createCell(24).setCellValue(ocSubmittedBy);
                            row.createCell(25).setCellValue(cnNo);
                            row.createCell(26).setCellValue(cnSubmittedBy);
                            row.createCell(27).setCellValue(ackFlag);
                            row.createCell(28).setCellValue(ackBy);
                            row.createCell(29).setCellValue(ackDate);
                            row.createCell(30).setCellValue(manualRcptVuchrNo);
                            row.createCell(31).setCellValue(createdBy);                            
                            row.createCell(32).setCellValue(receiptStatus);
                            row.createCell(33).setCellValue(phNo);
                            row.createCell(34).setCellValue(prposRent);
                            row.createCell(35).setCellValue(saasRcptSts);
                                                
                            excelRowData++;
                        }
                    }
                    workbook.write(outputStream);
                    outputStream.flush();
                } catch (Exception e) {
                    System.err.println("BDS" + e.getMessage());
                }
    }
}
