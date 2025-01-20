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
import oracle.jbo.ViewObject;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import util.ADFUtils;

public class SearchBuilding {
  private RichPageTemplate pt1;
  private RichPanelGroupLayout pgl1;
  private RichPanelGridLayout pgl2;
  private RichGridRow gr1;
  private RichGridCell gc1;
  private RichGridCell gc2;
  private RichOutputLabel ol1;
  private RichSpacer s1;
  private RichSpacer s2;
  private RichPanelBox pb1;
  private RichPanelCollection pc1;
  private RichTable t1;
  private RichQuery qryId1;
  private RichToolbar t2;
    private RichCommandImageLink cil1;
    private RichCommandImageLink cil2;
    private RichCommandImageLink cil3;
  private RichSpacer s3;

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

  public void setT1(RichTable t1) {
    this.t1 = t1;
  }

  public RichTable getT1() {
    return t1;
  }


  public void setQryId1(RichQuery qryId1) {
    this.qryId1 = qryId1;
  }

  public RichQuery getQryId1() {
    return qryId1;
  }

  public void setT2(RichToolbar t2) {
    this.t2 = t2;
  }

  public RichToolbar getT2() {
    return t2;
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

  public void setS3(RichSpacer s3) {
    this.s3 = s3;
  }

  public RichSpacer getS3() {
    return s3;
  }
    public void exportToExcel(FacesContext facesContext,
                              OutputStream outputStream) {
        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Buildings");
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("Building Name");
            sheet.setColumnWidth(0, 5000);
            rowhead.createCell(1).setCellValue("Building No");
            sheet.setColumnWidth(1, 3000);
            rowhead.createCell(2).setCellValue("Property Name");
            sheet.setColumnWidth(2, 5000);
            rowhead.createCell(3).setCellValue("Short Code");
            sheet.setColumnWidth(3, 3000);
            rowhead.createCell(4).setCellValue("Type");
            sheet.setColumnWidth(4, 4500);
            rowhead.createCell(5).setCellValue("Business Unit");
            sheet.setColumnWidth(5, 6500);
            rowhead.createCell(6).setCellValue("Description");
            sheet.setColumnWidth(6, 6500);
            
            ViewObject actVO =
                ADFUtils.findIterator("SearchBuilding_ROVO1Iterator").getViewObject();
            actVO.executeQuery();
            if (actVO.getEstimatedRowCount() > 0) {
                RowSetIterator rs = actVO.createRowSetIterator(null);
                int excelRowData = 1;
                while (rs.hasNext()) {
                    Row actRow = rs.next();
                    String buildName =
                        actRow.getAttribute("BuildName") != null ?
                        actRow.getAttribute("BuildName").toString() : "";
                    String buildNo =
                        actRow.getAttribute("BuildNumber") != null ? 
                        actRow.getAttribute("BuildNumber").toString() : "";
                    String pName =
                        actRow.getAttribute("PropertyName") != null ? 
                        actRow.getAttribute("PropertyName").toString() : "";
                    String buildShortCode =
                        actRow.getAttribute("BuildShortcode") != null ? 
                        actRow.getAttribute("BuildShortcode").toString() : "";
                    String buildType =
                        actRow.getAttribute("BuildType") != null ?
                        actRow.getAttribute("BuildType").toString() : "";
                    String orgName =
                        actRow.getAttribute("OrgName") != null ?
                        actRow.getAttribute("OrgName").toString() : "";
                    String desc =
                        actRow.getAttribute("Description") != null ?
                        actRow.getAttribute("Description").toString() : "";


                    HSSFRow row = sheet.createRow((short)excelRowData);
                    row.createCell(0).setCellValue(buildName);
                    row.createCell(1).setCellValue(buildNo);
                    row.createCell(2).setCellValue(pName);
                    row.createCell(3).setCellValue(buildShortCode);
                    row.createCell(4).setCellValue(buildType);
                    row.createCell(5).setCellValue(orgName);
                    row.createCell(6).setCellValue(desc);
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
