package view.backing.fragments;

import java.io.OutputStream;

import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import util.ADFUtils;

public class SearchUnit {
  private RichPageTemplate pt1;
  private RichPanelGroupLayout pgl1;
  private RichPanelGridLayout pgl2;
  private RichGridRow gr1;
  private RichGridCell gc1;
  private RichGridCell gc2;
  private RichOutputLabel ol1;
  private RichPanelBox pb1;
  private RichPanelCollection pc1;
  private RichQuery qryId1;
    private RichTable resId1;
    private RichToolbar t1;
    private RichCommandImageLink cil1;
    private RichCommandImageLink cil2;
    private RichCommandImageLink cil3;
  private RichSpacer s1;
  private RichSpacer s2;
    private RichSpacer s3;
    private RichCommandImageLink cil4;

    public void setPt1(RichPageTemplate pt1) {
    this.pt1 = pt1;
  }

  public RichPageTemplate getPt1() {
    return pt1;
  }

  public void setPgl1(RichPanelGroupLayout pgl1) {
    this.pgl1 = pgl1;
  }

  public RichPanelGroupLayout getPgl1() {
    return pgl1;
  }

  public void setPgl2(RichPanelGridLayout pgl2) {
    this.pgl2 = pgl2;
  }

  public RichPanelGridLayout getPgl2() {
    return pgl2;
  }

  public void setGr1(RichGridRow gr1) {
    this.gr1 = gr1;
  }

  public RichGridRow getGr1() {
    return gr1;
  }

  public void setGc1(RichGridCell gc1) {
    this.gc1 = gc1;
  }

  public RichGridCell getGc1() {
    return gc1;
  }

  public void setGc2(RichGridCell gc2) {
    this.gc2 = gc2;
  }

  public RichGridCell getGc2() {
    return gc2;
  }

  public void setOl1(RichOutputLabel ol1) {
    this.ol1 = ol1;
  }

  public RichOutputLabel getOl1() {
    return ol1;
  }


  public void setPb1(RichPanelBox pb1) {
    this.pb1 = pb1;
  }

  public RichPanelBox getPb1() {
    return pb1;
  }

  public void setPc1(RichPanelCollection pc1) {
    this.pc1 = pc1;
  }

  public RichPanelCollection getPc1() {
    return pc1;
  }


  public void setQryId1(RichQuery qryId1) {
        this.qryId1 = qryId1;
    }

    public RichQuery getQryId1() {
        return qryId1;
    }

    public void setResId1(RichTable resId1) {
        this.resId1 = resId1;
    }

    public RichTable getResId1() {
        return resId1;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setCil1(RichCommandImageLink cil1) {
        this.cil1 = cil1;
    }

    public RichCommandImageLink getCil1() {
        return cil1;
    }

    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
    }

    public void setCil3(RichCommandImageLink cil3) {
        this.cil3 = cil3;
    }

    public RichCommandImageLink getCil3() {
        return cil3;
    }

  public void setS1(RichSpacer s1) {
    this.s1 = s1;
  }

  public RichSpacer getS1() {
    return s1;
  }

  public void setS2(RichSpacer s2) {
    this.s2 = s2;
  }

  public RichSpacer getS2() {
    return s2;
  }

    public void exportToExcel(FacesContext facesContext,
                              OutputStream outputStream) {
        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Units");
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("Unit Name");
            sheet.setColumnWidth(0, 3000);
            rowhead.createCell(1).setCellValue("Unit No");
            sheet.setColumnWidth(1, 3000);
            rowhead.createCell(2).setCellValue("Property Name");
            sheet.setColumnWidth(2, 5000);
            rowhead.createCell(3).setCellValue("Building Name");
            sheet.setColumnWidth(3, 5000);
            rowhead.createCell(4).setCellValue("Unit Short Code");
            sheet.setColumnWidth(4, 4500);
            rowhead.createCell(5).setCellValue("SEWA/DEWA Number");
            sheet.setColumnWidth(5, 5000);
            rowhead.createCell(6).setCellValue("Unit Type");
            sheet.setColumnWidth(6, 4000);
            rowhead.createCell(7).setCellValue("Area Type");
            sheet.setColumnWidth(7, 5000);
            rowhead.createCell(8).setCellValue("View Type");
            sheet.setColumnWidth(8, 5000);
            rowhead.createCell(9).setCellValue("No.of Bed Space");
            sheet.setColumnWidth(9, 3000);
            rowhead.createCell(10).setCellValue("Status");
            sheet.setColumnWidth(10, 4000);
            rowhead.createCell(11).setCellValue("Description");
            sheet.setColumnWidth(11, 6000);
            rowhead.createCell(12).setCellValue("Unit Category");
            sheet.setColumnWidth(12, 4000);
            rowhead.createCell(13).setCellValue("Area Value");
            sheet.setColumnWidth(13, 4000);
            ViewObject actVO =
                ADFUtils.findIterator("SearchUnits_ROVO1Iterator").getViewObject();
            actVO.executeQuery();
            if (actVO.getEstimatedRowCount() > 0) {
                RowSetIterator rs = actVO.createRowSetIterator(null);
                int excelRowData = 1;
                while (rs.hasNext()) {
                    Row actRow = rs.next();
                    String unitName =
                        actRow.getAttribute("UnitName") != null ?
                        actRow.getAttribute("UnitName").toString() : "";
                    String unitNo =
                        actRow.getAttribute("UnitNumber") != null ? 
                        actRow.getAttribute("UnitNumber").toString() : "";
                    String pName =
                        actRow.getAttribute("PropertyName") != null ? 
                        actRow.getAttribute("PropertyName").toString() : "";
                    String buildName =
                        actRow.getAttribute("BuildName") != null ? 
                        actRow.getAttribute("BuildName").toString() : "";
                    String unitShortCode =
                        actRow.getAttribute("UnitShortcode") != null ? 
                        actRow.getAttribute("UnitShortcode").toString() : "";
                    String sewaDewaNo =
                        actRow.getAttribute("DocRefNumber3") != null ? 
                        actRow.getAttribute("DocRefNumber3").toString() : "";
                    String unitType =
                        actRow.getAttribute("UnitTypeDis") != null ?
                        actRow.getAttribute("UnitTypeDis").toString() : "";
                    String areaType =
                        actRow.getAttribute("AreaTypeDis") != null ?
                        actRow.getAttribute("AreaTypeDis").toString() : "";
                    String viewType =
                        actRow.getAttribute("ViewTypeDis") != null ?
                        actRow.getAttribute("ViewTypeDis").toString() : "";
                    String noOfRooms =
                        actRow.getAttribute("NoOfRooms") != null ?
                        actRow.getAttribute("NoOfRooms").toString() : "";
                    String status =
                        actRow.getAttribute("Status") == null ? "" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("AVAL") ?
                        "Available" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("BOOK") ?
                        "Booked" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("ALOT") ?
                        "Allotted" :
                        actRow.getAttribute("Status").toString();
                    String description =
                        actRow.getAttribute("Description") != null ? actRow.getAttribute("Description").toString() :
                        "";
                    String unitCatg =
                        actRow.getAttribute("UnitCategory") != null ? actRow.getAttribute("UnitCategory").toString() :
                        "";
                    String areaValue =
                        actRow.getAttribute("AreaValue") != null ? actRow.getAttribute("AreaValue").toString() :
                        "";


                    HSSFRow row = sheet.createRow((short)excelRowData);
                    row.createCell(0).setCellValue(unitName);
                    row.createCell(1).setCellValue(unitNo);
                    row.createCell(2).setCellValue(pName);
                    row.createCell(3).setCellValue(buildName);
                    row.createCell(4).setCellValue(unitShortCode);
                    row.createCell(5).setCellValue(sewaDewaNo);
                    row.createCell(6).setCellValue(unitType);
                    row.createCell(7).setCellValue(areaType);
                    row.createCell(8).setCellValue(viewType);
                    row.createCell(9).setCellValue(noOfRooms);
                    row.createCell(10).setCellValue(status);
                    row.createCell(11).setCellValue(description);
                    row.createCell(12).setCellValue(unitCatg);
                    row.createCell(13).setCellValue(areaValue);
                    excelRowData++;
                }
            }
            workbook.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            System.err.println("BDS" + e.getMessage());
        }
        
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setCil4(RichCommandImageLink cil4) {
        this.cil4 = cil4;
    }

    public RichCommandImageLink getCil4() {
        return cil4;
    }
//Available units
    public void exportToExcelAval(FacesContext facesContext,
                                  OutputStream outputStream) {
        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Available Units");
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("Unit Name");
            sheet.setColumnWidth(0, 3000);
            rowhead.createCell(1).setCellValue("Building Name");
            sheet.setColumnWidth(1, 3000);
            rowhead.createCell(2).setCellValue("Customer");
            sheet.setColumnWidth(2, 5000);
            rowhead.createCell(3).setCellValue("NOC Date");
            sheet.setColumnWidth(3, 5000);
            ViewObject actVO =
                ADFUtils.findIterator("GetXxxpmUnitCnDtls_RoVo1Iterator").getViewObject();
            ViewCriteria vc = actVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("UnitStatus","AVAL");
            vc.addRow(vcr);
            actVO.applyViewCriteria(vc);
            actVO.executeQuery();
            if (actVO.getEstimatedRowCount() > 0) {
                RowSetIterator rs = actVO.createRowSetIterator(null);
                int excelRowData = 1;
                while (rs.hasNext()) {
                    Row actRow = rs.next();
                    String unitName =
                        actRow.getAttribute("UnitName") != null ?
                        actRow.getAttribute("UnitName").toString() : "";
                    String buildName =
                        actRow.getAttribute("BuildName") != null ? 
                        actRow.getAttribute("BuildName").toString() : "";
                    String custName =
                        actRow.getAttribute("CustName") != null ? 
                        actRow.getAttribute("CustName").toString() : "";
                    String nocDateActual =
                        actRow.getAttribute("NocDateActual") != null ? 
                        actRow.getAttribute("NocDateActual").toString() : "";
                    
                    HSSFRow row = sheet.createRow((short)excelRowData);
                    row.createCell(0).setCellValue(unitName);
                    row.createCell(1).setCellValue(buildName);
                    row.createCell(2).setCellValue(custName);
                    row.createCell(3).setCellValue(nocDateActual);
                    excelRowData++;
                }
            }
            workbook.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            System.err.println("BDS" + e.getMessage());
        }
    }
    //Overstay units
    public void exportToExcelOvrSty(FacesContext facesContext,
                                  OutputStream outputStream) {
        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Available Units");
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("Unit Name");
            sheet.setColumnWidth(0, 3000);
            rowhead.createCell(1).setCellValue("Building Name");
            sheet.setColumnWidth(1, 3000);
            rowhead.createCell(2).setCellValue("Customer");
            sheet.setColumnWidth(2, 5000);
            rowhead.createCell(3).setCellValue("Contract Start Date");
            sheet.setColumnWidth(3, 5000);
            rowhead.createCell(4).setCellValue("Contract End Date");
            sheet.setColumnWidth(4, 5000);
            rowhead.createCell(5).setCellValue("Phone No");
            sheet.setColumnWidth(5, 5000);
            rowhead.createCell(6).setCellValue("Email Id");
            sheet.setColumnWidth(6, 5000);
            ViewObject actVO =
                ADFUtils.findIterator("GetXxxpmUnitCnDtls_RoVo1Iterator").getViewObject();
            ViewCriteria vc = actVO.createViewCriteria();
            vc.reset();
            actVO.reset();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("UnitStatus","not like 'AVAL'");
            vcr.setAttribute("DaysRemaining","like '-'");
            vc.addRow(vcr);
            actVO.applyViewCriteria(vc);
            actVO.executeQuery();
            if (actVO.getEstimatedRowCount() > 0) {
                RowSetIterator rs = actVO.createRowSetIterator(null);
                int excelRowData = 1;
                while (rs.hasNext()) {
                    Row actRow = rs.next();
                    String unitName =
                        actRow.getAttribute("UnitName") != null ?
                        actRow.getAttribute("UnitName").toString() : "";
                    String buildName =
                        actRow.getAttribute("BuildName") != null ? 
                        actRow.getAttribute("BuildName").toString() : "";
                    String custName =
                        actRow.getAttribute("CustName") != null ? 
                        actRow.getAttribute("CustName").toString() : "";
                    String leaseStartDate =
                        actRow.getAttribute("LeaseStartDate") != null ? 
                        actRow.getAttribute("LeaseStartDate").toString() : "";
                    String leaseEndDate =
                        actRow.getAttribute("LeaseEndDate") != null ? 
                        actRow.getAttribute("LeaseEndDate").toString() : "";
                    String phoneNo =
                        actRow.getAttribute("PhoneNo") != null ? 
                        actRow.getAttribute("PhoneNo").toString() : "";
                    String emailId =
                        actRow.getAttribute("EmailId") != null ? 
                        actRow.getAttribute("EmailId").toString() : "";
                    
                    HSSFRow row = sheet.createRow((short)excelRowData);
                    row.createCell(0).setCellValue(unitName);
                    row.createCell(1).setCellValue(buildName);
                    row.createCell(2).setCellValue(custName);
                    row.createCell(3).setCellValue(leaseStartDate);
                    row.createCell(4).setCellValue(leaseEndDate);
                    row.createCell(5).setCellValue(phoneNo);
                    row.createCell(6).setCellValue(emailId);
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
