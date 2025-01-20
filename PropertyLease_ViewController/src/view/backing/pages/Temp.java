package view.backing.pages;

import java.io.OutputStream;

import java.math.BigDecimal;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelAccordion;
import oracle.adf.view.rich.component.rich.layout.RichPanelSplitter;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import util.ADFUtils;
import util.xxfnd;

public class Temp {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelSplitter ps1;
    private RichPanelAccordion pa1;
    private RichShowDetailItem masters;
    private RichShowDetailItem transactions;
    private String taskFlowId = "/WEB-INF/Property_BTF.xml#Property_BTF";
    private RichCommandLink cl1;
    private RichCommandLink cl2;
    private RichCommandLink cl3;
    private RichRegion r1;
    private RichCommandLink commandLink1;
  private RichCommandLink cl6;
  private RichCommandLink cl7;
  private RichCommandLink cl8;
    private RichCommandLink cl9;
    private RichPopup pop1;
    private RichInputText muncharge;


    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }

    public void setPs1(RichPanelSplitter ps1) {
        this.ps1 = ps1;
    }

    public RichPanelSplitter getPs1() {
        return ps1;
    }

    public void setPa1(RichPanelAccordion pa1) {
        this.pa1 = pa1;
    }

    public RichPanelAccordion getPa1() {
        return pa1;
    }

    public void setMasters(RichShowDetailItem masters) {
        this.masters = masters;
    }

    public RichShowDetailItem getMasters() {
        return masters;
    }

    public void setTransactions(RichShowDetailItem transactions) {
        this.transactions = transactions;
    }

    public RichShowDetailItem getTransactions() {
        return transactions;
    }


    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }


    public String property_BTF() {
        taskFlowId = "/WEB-INF/Property_BTF.xml#Property_BTF";
        return null;
    }

    public void setCl1(RichCommandLink cl1) {
        this.cl1 = cl1;
    }

    public RichCommandLink getCl1() {
        return cl1;
    }

    public String building_BTF() {
        taskFlowId = "/WEB-INF/Building_BTF.xml#Building_BTF";
        return null;
    }

    public void setCl2(RichCommandLink cl2) {
        this.cl2 = cl2;
    }

    public RichCommandLink getCl2() {
        return cl2;
    }

    public String units_BTF() {
        taskFlowId = "/WEB-INF/Units_BTF.xml#Units_BTF";
        return null;
    }


    public void setCl3(RichCommandLink cl3) {
        this.cl3 = cl3;
    }

    public RichCommandLink getCl3() {
        return cl3;
    }

    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }

    public RichRegion getR1() {
        return r1;
    }

    public void setCommandLink1(RichCommandLink commandLink1) {
        this.commandLink1 = commandLink1;
    }

    public RichCommandLink getCommandLink1() {
        return commandLink1;
    }


  public void setCl6(RichCommandLink cl5) {
    this.cl6 = cl5;
  }

  public RichCommandLink getCl6() {
    return cl6;
  }

    public void setCl5(RichCommandLink cl5) {
        this.cl6 = cl5;
    }

    public RichCommandLink getCl5() {
        return cl6;
    }

  public void setCl7(RichCommandLink cl7) {
    this.cl7 = cl7;
  }

  public RichCommandLink getCl7() {
    return cl7;
  }

  public void setCl8(RichCommandLink cl8) {
    this.cl8 = cl8;
  }

  public RichCommandLink getCl8() {
    return cl8;
  }

    public void setCl9(RichCommandLink cl9) {
        this.cl9 = cl9;
    }

    public RichCommandLink getCl9() {
        return cl9;
    }

   

    public void setPop1(RichPopup pop1) {
        this.pop1 = pop1;
    }

    public RichPopup getPop1() {
        return pop1;
    }
    
    public void onclickPricelistRenewal(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("CreateInsert3").execute();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
                 this.getPop1().show(hints);
        
        
    
    }


    public void onClickGoRenewal(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Commit2").execute();
        ViewObject vo = ADFUtils.findIterator("RevisionVO1Iterator").getViewObject();
        String plid=vo.getCurrentRow().getAttribute("PlRevisonId").toString();
       
        System.err.println("RevisionId"+plid);
       
        xxfnd.priceListRenewal(plid,"api","PriceList_AMDataControl");
    }

    public void onCalcMuniCharge(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject vo = ADFUtils.findIterator("PlLinesVO2Iterator").getViewObject();
        Row milesDtlRow=vo.getCurrentRow(); 
        String BaseRate =
            milesDtlRow.getAttribute("BasePrice") == null ? "0" :
            milesDtlRow.getAttribute("BasePrice").toString();
        String MuniCiPer =
            milesDtlRow.getAttribute("MunicipalityPercentage") == null ? "0" :
            milesDtlRow.getAttribute("MunicipalityPercentage").toString();
        


        BigDecimal VTotal = new BigDecimal(0);
        BigDecimal BRate = new BigDecimal(BaseRate);
                        BigDecimal MuniciPer = new BigDecimal(MuniCiPer);
                        BigDecimal TotalPercentage = new BigDecimal(100);
                        
                        
                        VTotal =
                (BRate.multiply(MuniciPer)).divide(TotalPercentage);
                        
                        
                        
       
        
        Object Tot=VTotal;
        milesDtlRow.setAttribute("MunicipalityCharges",Tot);
        this.muncharge.setValue(Tot);
        AdfFacesContext.getCurrentInstance().addPartialTarget(muncharge);
                        

        

        
        
        
    }

    public void setMuncharge(RichInputText muncharge) {
        this.muncharge = muncharge;
    }

    public RichInputText getMuncharge() {
        return muncharge;
    }

    public void exportToExcel(FacesContext facesContext,
                              OutputStream outputStream) {
        // Add event code here...
        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Price List");
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("Price List Name");
            sheet.setColumnWidth(0, 6000);
            rowhead.createCell(1).setCellValue("Business Unit");
            sheet.setColumnWidth(1, 6500);
            rowhead.createCell(2).setCellValue("Property Name");
            sheet.setColumnWidth(2, 6000);
            rowhead.createCell(3).setCellValue("Building Name");
            sheet.setColumnWidth(3, 6000);
            rowhead.createCell(4).setCellValue("Unit Name");
            sheet.setColumnWidth(4, 3500);
            rowhead.createCell(5).setCellValue("Revision No");
            sheet.setColumnWidth(5, 3000);
            rowhead.createCell(6).setCellValue("Date");
            sheet.setColumnWidth(6, 3500);
            rowhead.createCell(7).setCellValue("Revised By");
            sheet.setColumnWidth(7, 6000);
            rowhead.createCell(8).setCellValue("Description");
            sheet.setColumnWidth(8, 6000);
            ViewObject actVO =
                ADFUtils.findIterator("SearchPriceListROVO1Iterator").getViewObject();
            actVO.executeQuery();
            if (actVO.getEstimatedRowCount() > 0) {
                RowSetIterator rs = actVO.createRowSetIterator(null);
                int excelRowData = 1;
                while (rs.hasNext()) {
                    Row actRow = rs.next();
                    String plName =
                        actRow.getAttribute("PlName") != null ?
                        actRow.getAttribute("PlName").toString() : "";
                    String orgName =
                        actRow.getAttribute("OrgName") != null ?
                        actRow.getAttribute("OrgName").toString() :
                        "";
                    String propertyName =
                        actRow.getAttribute("Propertyname") != null ?
                        actRow.getAttribute("Propertyname").toString() : "";
                    String buildName =
                        actRow.getAttribute("BuildName") != null ? actRow.getAttribute("BuildName").toString() :
                        "";
                    String unitName =
                        actRow.getAttribute("UnitName") != null ? actRow.getAttribute("UnitName").toString() :
                        "";
                    String revisionNo =
                        actRow.getAttribute("RevisionNo") != null ?
                        actRow.getAttribute("RevisionNo").toString() : "";
                    String revisionDate =
                        actRow.getAttribute("RevisionDate") != null ?
                        actRow.getAttribute("RevisionDate").toString() : "";
                    String revisedBy =
                        actRow.getAttribute("RevisedBy") != null ?
                        actRow.getAttribute("RevisedBy").toString() : "";
                    String description =
                        actRow.getAttribute("Description") != null ?
                        actRow.getAttribute("Description").toString() : "";
                    
                    HSSFRow row = sheet.createRow((short)excelRowData);
                    row.createCell(0).setCellValue(plName);
                    row.createCell(1).setCellValue(orgName);
                    row.createCell(2).setCellValue(propertyName);
                    row.createCell(3).setCellValue(buildName);
                    row.createCell(4).setCellValue(unitName);
                    row.createCell(5).setCellValue(revisionNo);
                    row.createCell(6).setCellValue(revisionDate);
                    row.createCell(7).setCellValue(revisedBy);
                    row.createCell(8).setCellValue(description);
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
