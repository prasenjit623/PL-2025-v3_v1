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
                    rowhead.createCell(12).setCellValue("Bank Branch Name");
                    sheet.setColumnWidth(12, 4000);
                    rowhead.createCell(13).setCellValue("Drawn By");
                    sheet.setColumnWidth(13, 6000);
                    rowhead.createCell(14).setCellValue("Description");
                    sheet.setColumnWidth(14, 6000);
                    rowhead.createCell(15).setCellValue("Receipt Type");
                    sheet.setColumnWidth(15, 6000);
                    rowhead.createCell(16).setCellValue("Booking No");
                    sheet.setColumnWidth(16, 5000);
                    rowhead.createCell(17).setCellValue("Cashier Acknowledged ?");
                    sheet.setColumnWidth(17, 6000);
                    rowhead.createCell(18).setCellValue("Cashier Acknowledged By");
                    sheet.setColumnWidth(18, 6000);
                    rowhead.createCell(19).setCellValue("Acknowledged Date");
                    sheet.setColumnWidth(19, 6000);
                    rowhead.createCell(20).setCellValue("Manual Receipt Voucher No");
                    sheet.setColumnWidth(20, 6000);
                    rowhead.createCell(21).setCellValue("Created By");
                    sheet.setColumnWidth(21, 6000);
                    rowhead.createCell(22).setCellValue("Receipt Status");
                    sheet.setColumnWidth(22, 6000);
                    rowhead.createCell(23).setCellValue("Phone No");
                    sheet.setColumnWidth(23, 5000);
                    rowhead.createCell(24).setCellValue("Contract No");
                    sheet.setColumnWidth(24, 5000);
                    rowhead.createCell(25).setCellValue("OC No");
                    sheet.setColumnWidth(25, 5000);
                    rowhead.createCell(26).setCellValue("Purpose Of Rent");
                    sheet.setColumnWidth(26, 6000);
                                
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
                                actRow.getAttribute("UnitNameTrans") != null ? 
                                                        actRow.getAttribute("UnitNameTrans").toString() : "";
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
                            String contractNo =
                            actRow.getAttribute("LeaseNumber") != null ?
                            actRow.getAttribute("LeaseNumber").toString() : "";
                            String ocNo =
                            actRow.getAttribute("OcNo") != null ?
                            actRow.getAttribute("OcNo").toString() : "";
                            String prposRent =
                            actRow.getAttribute("PurposeOfRent") != null ?
                            actRow.getAttribute("PurposeOfRent").toString() : "";

                            
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
                            row.createCell(12).setCellValue(bankBranchName);
                            row.createCell(13).setCellValue(drawnBy);
                            row.createCell(14).setCellValue(description);
                            row.createCell(15).setCellValue(rcptType);
                            row.createCell(16).setCellValue(bookingNo);
                            row.createCell(17).setCellValue(ackFlag);
                            row.createCell(18).setCellValue(ackBy);
                            row.createCell(19).setCellValue(ackDate);
                            row.createCell(20).setCellValue(manualRcptVuchrNo);
                            row.createCell(21).setCellValue(createdBy);                            
                            row.createCell(22).setCellValue(receiptStatus);
                            row.createCell(23).setCellValue(phNo);
                            row.createCell(24).setCellValue(contractNo);
                            row.createCell(25).setCellValue(ocNo);
                            row.createCell(26).setCellValue(prposRent);
                                                
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
