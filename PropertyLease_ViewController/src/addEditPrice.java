import antlr.collections.List;

import java.io.IOException;

import java.io.OutputStream;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.domain.Date;

import org.apache.myfaces.trinidad.model.UploadedFile;

import util.ADFUtils;
import util.JSFUtils;

import view.backing.DownlaodExcel;
import view.backing.ExcelDataUpload;

public class addEditPrice {
    private RichPopup p1;
    private RichTable t1;
    private RichInputFile if1;
    private RichPopup p2;
    private RichTable t4;
    private RichInputComboboxListOfValues propertyNameTransId;
    private RichInputComboboxListOfValues buildingNameTransId;
    private RichInputComboboxListOfValues unitNameTransId;

    public addEditPrice() {
    }



    public int ValidateDuplicateUnits(){
        int count=0;
        
        //PlLinesVO3Iterator
        
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        
        ViewObject offerLnsVO =
            ADFUtils.findIterator("PlLinesVO2Iterator").getViewObject();
        RowSetIterator mileDtlRs =
            offerLnsVO.createRowSetIterator(null);
        while (mileDtlRs.hasNext()) {
            Row mileDtlRow = mileDtlRs.next();
            if(mileDtlRow.getAttribute("UnitNameTrans")!=null){
                System.err.println("UNITSSSSSS "+mileDtlRow.getAttribute("UnitNameTrans"));
                list1.add((String)mileDtlRow.getAttribute("UnitNameTrans")); 
            }
           
        }
      
      
        ViewObject pllinesVo =
            ADFUtils.findIterator("PlLinesVO2Iterator").getViewObject();
        RowSetIterator pllinesVoRs =
            pllinesVo.createRowSetIterator(null);
        while (pllinesVoRs.hasNext()) {
            Row mileDtlRowss = pllinesVoRs.next();
            if(mileDtlRowss.getAttribute("UnitNameTrans")!=null){
                System.err.println("ESXISTING UNITS "+mileDtlRowss.getAttribute("UnitNameTrans"));
                list2.add((String)mileDtlRowss.getAttribute("UnitNameTrans")); 
            }
           
        }
        
      
      
        Map<String,Integer> repeatationMap= new HashMap<String,Integer>();
        for(String str : list1){

            if(repeatationMap.containsKey(str)) {
                repeatationMap.put(str,repeatationMap.get(str) + 1);
            }
            else {
                repeatationMap.put(str, 1);
            }
        }
       
        for(int repatCount : repeatationMap.values()){
            if(repatCount > 1) {
                count++;
            }
        }
        return count;
    }





    public String onValidateDuplicateUnit(Object ob) {
        String result = "N";
        ViewObject offerLnsVO2 =
            ADFUtils.findIterator("PlLinesVO1Iterator").getViewObject();
        ViewCriteria vc = offerLnsVO2.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("UnitId", ob);
        vc.addRow(vcRow);
        offerLnsVO2.applyViewCriteria(vc);
        offerLnsVO2.executeQuery();

        if (offerLnsVO2.getEstimatedRowCount() > 0) {
            result = "Y";
        }

        return result;
    }

    public String onSave() {
        int count = 0;
        String ret = "";
        String ress ="Y";
        ViewObject offerLnsVO =
            ADFUtils.findIterator("PlLinesVO2Iterator").getViewObject();
        Object val =
            ADFContext.getCurrent().getSessionScope().get("addEditPriceList") ==
            null ? "" :
            ADFContext.getCurrent().getSessionScope().get("addEditPriceList").toString();

        Row plHeaderRow = PLHeaderVO.getCurrentRow();
        try {
            
                java.util.Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2099");
                java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
                oracle.jbo.domain.Date domadate = new oracle.jbo.domain.Date(sqlDate);
                plHeaderRow.setAttribute("EndDate", domadate);
            System.out.println("End Date d "+plHeaderRow.getAttribute("EndDate"));
             } catch (ParseException e) {
            System.out.println(e);
             }

        if (plHeaderRow.getAttribute("OrgNameTrans") != null &&
            plHeaderRow.getAttribute("PlName") != null &&
            plHeaderRow.getAttribute("CurrencyNameTrans") != null &&
            plHeaderRow.getAttribute("StartDate") != null &&
            plHeaderRow.getAttribute("EndDate") != null ) {
            int counts=0;
            counts = ValidateDuplicateUnits();
            
            System.err.println("counts"+counts);
            
            
            if (val.equals("Add")) {
                RowSetIterator mileDtlRs =
                    offerLnsVO.createRowSetIterator(null);
                while (mileDtlRs.hasNext()) {
                    Row mileDtlRow = mileDtlRs.next();
                    // Create New row in offer Milestone Detail
                    Row offerMileStoneDtlRow = offerLnsVO.first();
                    String result =
                        onValidateDuplicateUnit(offerMileStoneDtlRow.getAttribute("UnitId")).toString();
                    if (result.equals("Y")) {
                        count++;
                    }
                }
            }
            //13-april-2020 to default start and end date for all the associated units same as header price list
            ViewObject plHdrVo =
                ADFUtils.findIterator("PlHeader_VO1Iterator").getViewObject();
            Row hdrRow = plHdrVo.getCurrentRow();
            if(hdrRow.getAttribute("StartDate") != null || hdrRow.getAttribute("EndDate") != null){
                ViewObject plLineVo =
                    ADFUtils.findIterator("PlLinesVO2Iterator").getViewObject();
//                ViewCriteria vc = plLineVo.createViewCriteria();
//                ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
//                vcRow.setAttribute("PlId", hdrRow.getAttribute("PlId"));
//                vc.addRow(vcRow);
//                plLineVo.applyViewCriteria(vc);
//                plLineVo.executeQuery();
                if (plLineVo.getEstimatedRowCount() > 0) {
                System.out.println("Estimated count of no of units :"+plLineVo.getEstimatedRowCount());
                    RowSetIterator plLineVoRS = plLineVo.createRowSetIterator(null);
                    while (plLineVoRS.hasNext()) {
                        Row plLineVoRSrow = plLineVoRS.next();
                        System.out.println("start date :"+hdrRow.getAttribute("StartDate"));
                        System.out.println("end date :"+hdrRow.getAttribute("EndDate"));
                        plLineVoRSrow.setAttribute("StartDate", hdrRow.getAttribute("StartDate"));
                        plLineVoRSrow.setAttribute("EndDate", hdrRow.getAttribute("EndDate"));
                    }
                } 
            }
            
            if (offerLnsVO.getEstimatedRowCount() > 0) {
                if (counts == 0) {
                
                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Price List Saved Successfully...");
                    ret = "save";
                } else {
                    JSFUtils.addFacesErrorMessage("Duplicates of Units are Found....");
                }
            } else {
                JSFUtils.addFacesErrorMessage("You have to mention the Price List Details..!");
            }
            
            
        } else {
            ress = "N";
            if (plHeaderRow.getAttribute("OrgNameTrans") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Business Unit");
            }
            if (plHeaderRow.getAttribute("PlName") == null) {
                JSFUtils.addFacesErrorMessage("You must enter a Price List Name");
            }
            if (plHeaderRow.getAttribute("CurrencyNameTrans") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Currency");
            }
            if (plHeaderRow.getAttribute("StartDate") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Start Date");
            }
            if (plHeaderRow.getAttribute("EndDate") == null) {
                JSFUtils.addFacesErrorMessage("You must select a End Date");
            }
        }
        return ret;

    }


    public void onClickSave(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("addEditPriceList").toString().equalsIgnoreCase("Edit")) {
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Price List Information Saved Successfully");
        } else {

            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Price List Information Saved Successfully");

        }
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void onClickPopupCancel(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getP1().hide();
    }
    ExcelDataUpload excelstatus = new ExcelDataUpload();
    ViewObject offerLnsVO =
        ADFUtils.findIterator("PlLinesVO2Iterator").getViewObject();
    ViewObject findIdVO =
        ADFUtils.findIterator("getID1Iterator").getViewObject();
    ViewObject PLHeaderVO =
        ADFUtils.findIterator("PlHeader_VO1Iterator").getViewObject();
    ViewObject lookUpCodeVO =
        ADFUtils.findIterator("getLookupCode1Iterator").getViewObject();//getUnitNameROVO1Iterator
        ViewObject fndUnitVo =
            ADFUtils.findIterator("getUnitNameROVO1Iterator").getViewObject();
        


    public void onUploadExcel(ValueChangeEvent valueChangeEvent) throws IOException {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        UploadedFile file = (UploadedFile)valueChangeEvent.getNewValue();
        Object startDate =
            PLHeaderVO.getCurrentRow().getAttribute("StartDate") == null ?
            new Date() : PLHeaderVO.getCurrentRow().getAttribute("StartDate");
        Object endDaate =
            PLHeaderVO.getCurrentRow().getAttribute("EndDate") == null ?
            new Date() : PLHeaderVO.getCurrentRow().getAttribute("EndDate");
        Object revDate =
            PLHeaderVO.getCurrentRow().getAttribute("RevisionDate") == null ?
            new Date() :
            PLHeaderVO.getCurrentRow().getAttribute("RevisionDate");

        if (PLHeaderVO.getCurrentRow().getAttribute("PlId") != null) {
            String pid =
                PLHeaderVO.getCurrentRow().getAttribute("PlId").toString();
            System.err.println("==onChangeUpload==" + file.getContentType());
            if (file.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") ||
                file.getContentType().equalsIgnoreCase("application/xlsx") ||
                file.getContentType().equalsIgnoreCase("application/kset")) {
                excelstatus.uploadPriceList(file.getInputStream(), t4,
                                            findIdVO,fndUnitVo, pid, startDate, endDaate,
                                            revDate, lookUpCodeVO);
                AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
            } else if (file.getContentType().equalsIgnoreCase("application/vnd.ms-excel")) {
                if (file.getFilename().toUpperCase().endsWith(".XLS")) {
                    excelstatus.uploadPriceList(file.getInputStream(), t4,
                                                findIdVO,fndUnitVo,pid, startDate,
                                                endDaate, revDate,
                                                lookUpCodeVO);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
                }
            }
        }

    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void downLoadPLTemplate(FacesContext facesContext,
                                   OutputStream outputStream) {
        DownlaodExcel.plTemplateDownlaod(facesContext, outputStream);
    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public String onClickAdd() {
        ADFContext.getCurrent().getPageFlowScope().put("menuadd", "add");
        ADFUtils.findOperation("CreateInsert").execute();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.p2.show(hints);

        AdfFacesContext.getCurrentInstance().addPartialTarget(p2);
        return null;
    }

    public String onClickEdit() {
        ADFContext.getCurrent().getPageFlowScope().put("menuadd", "edit");

        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.p2.show(hints);

        AdfFacesContext.getCurrentInstance().addPartialTarget(p2);
        return null;
    }

    public void onClickCancel(PopupCanceledEvent popupCanceledEvent) {
        String addmenu =
            (String)(ADFContext.getCurrent().getPageFlowScope().get("menuadd") ==
                     null ? "null" :
                     ADFContext.getCurrent().getPageFlowScope().get("menuadd"));
        System.err.println(addmenu);

        if (addmenu.equalsIgnoreCase("edit")) {
            UIComponent myPopupComponent = popupCanceledEvent.getComponent();
            oracle.adf.view.rich.util.ResetUtils.reset(myPopupComponent);

        } else if (addmenu.equalsIgnoreCase("add")) {
            ViewObject vo =
                ADFUtils.findIterator("PlLinesVO2Iterator").getViewObject();
            vo.removeCurrentRow();

        }
    }

    public void priceListDialogueListerner(DialogEvent dialogEvent) {
        String outcome = dialogEvent.getOutcome().ok.name();
        if (outcome.equals(DialogEvent.Outcome.ok.name())) {
            System.out.println("OK Invoked");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
        }
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void setPropertyNameTransId(RichInputComboboxListOfValues propertyNameTransId) {
        this.propertyNameTransId = propertyNameTransId;
    }

    public RichInputComboboxListOfValues getPropertyNameTransId() {
        return propertyNameTransId;
    }

    public void setBuildingNameTransId(RichInputComboboxListOfValues buildingNameTransId) {
        this.buildingNameTransId = buildingNameTransId;
    }

    public RichInputComboboxListOfValues getBuildingNameTransId() {
        return buildingNameTransId;
    }

    public void setUnitNameTransId(RichInputComboboxListOfValues unitNameTransId) {
        this.unitNameTransId = unitNameTransId;
    }

    public RichInputComboboxListOfValues getUnitNameTransId() {
        return unitNameTransId;
    }

    public void onPropertyChange(ValueChangeEvent valueChangeEvent) {
        this.buildingNameTransId.setValue(null);
        this.unitNameTransId.setValue(null);
    }

    public void onClickVCLforValidation(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            Object minmumRate = valueChangeEvent.getNewValue();
            ViewObject priceListVO =
                ADFUtils.findIterator("PlLinesVO2Iterator").getViewObject();
            Object basePrice =
                priceListVO.getCurrentRow().getAttribute("BasePrice");
            String bprice =
                basePrice.toString() == null ? "" : basePrice.toString();
            String minPrice =
                minmumRate.toString() == null ? "" : minmumRate.toString();
            if (Float.parseFloat(minPrice) <= Float.parseFloat(bprice)) {
            } else {
                Row r = priceListVO.getCurrentRow();
                r.setAttribute("MinPrice", null);
                JSFUtils.addFacesErrorMessage("Minimum rate should be less than or equal to the Base price");
            }
        }

    }

    public void onCheckUnits(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            
            ArrayList<String> list = new ArrayList<String>();
            ViewObject offerLnsVO =
                ADFUtils.findIterator("PlLinesVO2Iterator").getViewObject();
            RowSetIterator mileDtlRs =
                offerLnsVO.createRowSetIterator(null);
            while (mileDtlRs.hasNext()) {
                Row mileDtlRow = mileDtlRs.next();
                if(mileDtlRow.getAttribute("UnitNameTrans")!=null){
                    System.err.println("UNITSSSSSS "+mileDtlRow.getAttribute("UnitNameTrans"));
                    list.add((String)mileDtlRow.getAttribute("UnitNameTrans")); 
                }
               
            }
            
            System.out.println("a : " + Collections.frequency(list, valueChangeEvent.getNewValue()));
            
            int count=Collections.frequency(list, valueChangeEvent.getNewValue().toString());
            
            if(count>0){
                offerLnsVO.getCurrentRow().setAttribute("UnitNameTrans", "");
                JSFUtils.addFacesErrorMessage("Unit is Already Exists for this PriceList...");
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.unitNameTransId);
            }
            
            
        }
        
    }
}
