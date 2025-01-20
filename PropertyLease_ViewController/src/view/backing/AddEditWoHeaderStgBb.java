package view.backing;

import java.io.IOException;
import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;

import oracle.jbo.domain.Date;

import org.apache.myfaces.trinidad.model.UploadedFile;

import util.ADFUtils;
import util.JSFUtils;

public class AddEditWoHeaderStgBb {
    private RichInputText fromDate;
    private RichInputText toDate;
    private RichInputFile if1;
    private RichTable t1;
    private RichInputFile if2;
    private RichTable t4;

    public AddEditWoHeaderStgBb() {
    }

    ExcelDataUpload excelstatus = new ExcelDataUpload();
    
    public void doSave(ActionEvent actionEvent) {
        ViewObject woHdrVo = ADFUtils.findIterator("WoHeader_VO1Iterator").getViewObject();
        ViewObject woOpRrcVo = ADFUtils.findIterator("OpResourceStg_VO1Iterator").getViewObject();
        //Wo header
        if(woHdrVo.getEstimatedRowCount()>0){
        ViewObject woHdrRoVo = ADFUtils.findIterator("GetWoHdrInfo_ROVO1Iterator").getViewObject();
        System.out.println("Total counts of existing wo rows before adding :"+woHdrRoVo.getEstimatedRowCount());
        JSFUtils.addFacesInformationMessage("Total counts of existing wo rows before adding :"+woHdrRoVo.getEstimatedRowCount());
        System.out.println("Get Estimate count of wo rows :"+woHdrVo.getEstimatedRowCount());
        JSFUtils.addFacesInformationMessage("Get Estimate count of wo rows : "+woHdrVo.getEstimatedRowCount());
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage(woHdrVo.getEstimatedRowCount()+" records Saved Successfully !!!");
        woHdrRoVo.executeQuery();
        System.out.println("Total counts of existing wo rows after adding :"+woHdrRoVo.getEstimatedRowCount());
        JSFUtils.addFacesInformationMessage("Total counts of existing wo rows after adding :"+woHdrRoVo.getEstimatedRowCount());
        }
        //operation resource
        if(woOpRrcVo.getEstimatedRowCount()>0){
        System.out.println("Get Estimate count of wo rows :"+woOpRrcVo.getEstimatedRowCount());
        JSFUtils.addFacesInformationMessage("Get Estimate count of wo rows : "+woOpRrcVo.getEstimatedRowCount());
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage(woOpRrcVo.getEstimatedRowCount()+" records Saved Successfully !!!");
        }
    }

    public void doCancel(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Rollback").execute();
    }

    public void getWoCounts(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject woHdrVo = ADFUtils.findIterator("WoHeader_VO1Iterator").getViewObject();
        ViewObject woHdrRoVo = ADFUtils.findIterator("GetWoHdrInfo_ROVO1Iterator").getViewObject();
        System.out.println("Total counts of existing wo rows before adding :"+woHdrRoVo.getEstimatedRowCount());
        JSFUtils.addFacesInformationMessage("Total counts of existing wo rows before adding :"+woHdrRoVo.getEstimatedRowCount());
        System.out.println("Get Estimate count of wo rows :"+woHdrVo.getEstimatedRowCount());
        JSFUtils.addFacesInformationMessage("Get Estimate count of wo rows : "+woHdrVo.getEstimatedRowCount());
    }

    public void doCallAutoWoInvPkg(ActionEvent actionEvent) {
        String frmDate = fromDate.getValue()== null ?"":fromDate.getValue().toString();
        String tooDate = toDate.getValue()== null ?"":toDate.getValue().toString();
        System.out.println("frmDate :"+frmDate+" tooDate :"+tooDate);
        if (!frmDate.equals("") && !tooDate.equals("")){
        OperationBinding op=ADFUtils.findOperation("callAutoWoInv");
        op.getParamsMap().put("fromDate",frmDate);
        op.getParamsMap().put("toDate",tooDate);
        String flag=op.execute().toString();
        JSFUtils.addFacesInformationMessage(flag);
        }else{
            JSFUtils.addFacesErrorMessage("Please check From date and To date : frmDate :"+frmDate+"toDate :"+toDate);
        }
    }

    public void setFromDate(RichInputText fromDate) {
        this.fromDate = fromDate;
    }

    public RichInputText getFromDate() {
        return fromDate;
    }

    public void setToDate(RichInputText toDate) {
        this.toDate = toDate;
    }

    public RichInputText getToDate() {
        return toDate;
    }

    public void downLoadWoHdrTemplate(FacesContext facesContext,
                                      OutputStream outputStream) {
        DownlaodExcel.woHdrTemplateDownlaod(facesContext, outputStream);
    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    public void onUploadExcel(ValueChangeEvent valueChangeEvent) throws IOException {
        ViewObject woHdrVo = ADFUtils.findIterator("WoHeader_VO1Iterator").getViewObject();
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        UploadedFile file = (UploadedFile)valueChangeEvent.getNewValue();
            System.err.println("==onChangeUpload==" + file.getContentType());
            if (file.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") ||
                file.getContentType().equalsIgnoreCase("application/xlsx") ||
                file.getContentType().equalsIgnoreCase("application/kset")) {
                excelstatus.uploadWoHdr(file.getInputStream(), t1);
                AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            } else if (file.getContentType().equalsIgnoreCase("application/vnd.ms-excel")) {
                if (file.getFilename().toUpperCase().endsWith(".XLS")) {
                    excelstatus.uploadWoHdr(file.getInputStream(), t1);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
                }
            }
        
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void onUploadExcelOpResource(ValueChangeEvent valueChangeEvent) throws IOException {
        ViewObject woHdrVo = ADFUtils.findIterator("WoHeader_VO1Iterator").getViewObject();
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        UploadedFile file = (UploadedFile)valueChangeEvent.getNewValue();
            System.err.println("==onChangeUpload==" + file.getContentType());
            if (file.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") ||
                file.getContentType().equalsIgnoreCase("application/xlsx") ||
                file.getContentType().equalsIgnoreCase("application/kset")) {
                excelstatus.uploadWoOpResource(file.getInputStream(), t4);
                AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
            } else if (file.getContentType().equalsIgnoreCase("application/vnd.ms-excel")) {
                if (file.getFilename().toUpperCase().endsWith(".XLS")) {
                    excelstatus.uploadWoOpResource(file.getInputStream(), t4);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
                }
            }
    }

    public void setIf2(RichInputFile if2) {
        this.if2 = if2;
    }

    public RichInputFile getIf2() {
        return if2;
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }
}
