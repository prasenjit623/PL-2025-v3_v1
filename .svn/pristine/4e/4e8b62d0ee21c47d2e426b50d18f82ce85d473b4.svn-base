package view.backing;

import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import util.ADFUtils;

public class SearchOtherChargesBb {
    public SearchOtherChargesBb() {
        super();
    }
//    ViewObject ocHdrVo=ADFUtils.findIterator("OtherCharges_VO1Iterator").getViewObject();
//    ViewObject ocDtlVo=ADFUtils.findIterator("OtherChargesDetail_VO1Iterator").getViewObject();
//    public void doCreate(ActionEvent actionEvent) {
//        
//        // Insert OC Header
//        Row ocHdrRow=ocHdrVo.createRow();
////        bookHrdRow.setAttribute("OfferHdrId", Val);
//        ocHdrVo.insertRow(ocHdrRow);
//        
//        // Filetering Offer Line
////        ViewObject offerDtlVO=this.OfferDtl_VO1.getViewObject();
//        ViewCriteria ocDtlVC=ocDtlVo.createViewCriteria();
//        ViewCriteriaRow ocDtlVCRow=ocDtlVC.createViewCriteriaRow();
////        ocDtlVCRow.setAttribute("OfferHdrId", Val);
//        ocDtlVC.addRow(ocDtlVCRow);
//        ocDtlVo.applyViewCriteria(ocDtlVC);
//        ocDtlVo.executeQuery();
//        
//    }

    public void exportToExcel(FacesContext facesContext,
                              OutputStream outputStream) {
        try {

                                        HSSFWorkbook workbook = new HSSFWorkbook();
                                        HSSFSheet sheet =
                                            workbook.createSheet("Other Charges");//sheet name
                                        HSSFRow rowhead = sheet.createRow((short)0);
                                        rowhead.createCell(0).setCellValue("Other Charges No");//header name
                                        sheet.setColumnWidth(0, 4000);
                                        rowhead.createCell(1).setCellValue("Contract No");
                                        sheet.setColumnWidth(1, 3000);
                                        rowhead.createCell(2).setCellValue("Booking No");
                                        sheet.setColumnWidth(2, 3000);
                                        rowhead.createCell(3).setCellValue("Payments & Documents No");
                                        sheet.setColumnWidth(3, 6000);
                                        rowhead.createCell(4).setCellValue("Property Name");
                                        sheet.setColumnWidth(4, 6000);
                                        rowhead.createCell(5).setCellValue("Building Name");
                                        sheet.setColumnWidth(5, 6000);
                                        rowhead.createCell(6).setCellValue("Unit Name");
                                        sheet.setColumnWidth(6, 6000);
                                        rowhead.createCell(7).setCellValue("Customer Name");
                                        sheet.setColumnWidth(7, 8000);
                                        rowhead.createCell(8).setCellValue("Status");
                                        sheet.setColumnWidth(8, 3500);
                                        rowhead.createCell(9).setCellValue("Total Other Charges");
                                        sheet.setColumnWidth(9, 3500);
                                        rowhead.createCell(10).setCellValue("Total Receipt Amount");
                                        sheet.setColumnWidth(10, 3500);
                                        rowhead.createCell(11).setCellValue("Destination BU");
                                        sheet.setColumnWidth(11, 6000);
                                        rowhead.createCell(12).setCellValue("Lease Start Date");
                                        sheet.setColumnWidth(12, 4000);
                                        rowhead.createCell(13).setCellValue("Lease End Date");
                                        sheet.setColumnWidth(13, 4000);
                                        rowhead.createCell(14).setCellValue("Create Date");
                                        sheet.setColumnWidth(14, 3500);
                                        
                                        ViewObject actVO =
                                            ADFUtils.findIterator("SearchOC_ROVO1Iterator").getViewObject();
                                        actVO.executeQuery();
                                        if (actVO.getEstimatedRowCount() > 0) {
                                            RowSetIterator rs = actVO.createRowSetIterator(null);
                                            int excelRowData = 1;
                                            while (rs.hasNext()) {
                                                Row actRow = rs.next();
                                                String ocNo =
                                                    actRow.getAttribute("OtherChargesNumber") != null ?
                                                    actRow.getAttribute("OtherChargesNumber").toString() : 
                                                     "";
                                                String lsNo =
                                                    actRow.getAttribute("LeaseNumber") != null ?
                                                    actRow.getAttribute("LeaseNumber").toString() :
                                                    "";
                                                String bkNo =
                                                    actRow.getAttribute("BookingNumberTrans") != null ?
                                                    actRow.getAttribute("BookingNumberTrans").toString() : 
                                                    "";
                                                
                                                String recoNo =
                                                    actRow.getAttribute("RecommendNumberTrans") != null ? 
                                                    actRow.getAttribute("RecommendNumberTrans").toString() :
                                                    "";
                                                                
                                                String pName =
                                                    actRow.getAttribute("PropertyNameTrans") != null ? 
                                                    actRow.getAttribute("PropertyNameTrans").toString() :
                                                    "";                         
                                                String bName =
                                                    actRow.getAttribute("BuildingNameTrans") != null ? 
                                                    actRow.getAttribute("BuildingNameTrans").toString() :
                                                    "";
                                                String uName =
                                                    actRow.getAttribute("UnitNameTrans") != null ? 
                                                    actRow.getAttribute("UnitNameTrans").toString() :
                                                    ""; 
                                                                                                
                                                String custName =
                                                    actRow.getAttribute("CustName") != null ?
                                                    actRow.getAttribute("CustName").toString() :
                                                    "";
                                                String status =    
                                                    actRow.getAttribute("Status")==null ? "" 
                                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("DRA") ? "Draft"
                                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("PEN") ? "Pending"
                                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("APR") ? "Approved"
                                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("BO") ? "Booked"
                                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("REJ") ? "Rejected"
                                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("CAN") ? "Cancelled"
                                                    : actRow.getAttribute("Status").toString();
                                                String ocTotalRate =
                                                    actRow.getAttribute("OthersTotalRate") != null ?
                                                    actRow.getAttribute("OthersTotalRate").toString() :
                                                    "";
                                                String rcptTotal =
                                                    actRow.getAttribute("ReceiptTotal") != null ?
                                                    actRow.getAttribute("ReceiptTotal").toString() :
                                                    "";
                                                String DOrgName =
                                                    actRow.getAttribute("DOrgName") != null ?
                                                    actRow.getAttribute("DOrgName").toString() :
                                                    "";
                                                String leaseStDt =
                                                    actRow.getAttribute("LeaseStartDate") != null ?
                                                    actRow.getAttribute("LeaseStartDate").toString() :
                                                    "";
                                                String leaseEnDt =
                                                    actRow.getAttribute("LeaseEndDate") != null ?
                                                    actRow.getAttribute("LeaseEndDate").toString() :
                                                    "";
                                                String createDt =
                                                    actRow.getAttribute("CreateDate") != null ?
                                                    actRow.getAttribute("CreateDate").toString() :
                                                    "";

                                                HSSFRow row = sheet.createRow((short)excelRowData);
                                                row.createCell(0).setCellValue(ocNo);
                                                row.createCell(1).setCellValue(lsNo);
                                                row.createCell(2).setCellValue(bkNo);
                                                row.createCell(3).setCellValue(recoNo);
                                                row.createCell(4).setCellValue(pName);
                                                row.createCell(5).setCellValue(bName);
                                                row.createCell(6).setCellValue(uName);
                                                row.createCell(7).setCellValue(custName);
                                                row.createCell(8).setCellValue(status);
                                                row.createCell(9).setCellValue(ocTotalRate);
                                                row.createCell(10).setCellValue(rcptTotal);
                                                row.createCell(11).setCellValue(DOrgName);
                                                row.createCell(12).setCellValue(leaseStDt);
                                                row.createCell(13).setCellValue(leaseEnDt);
                                                row.createCell(14).setCellValue(createDt);
                                                                                
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
