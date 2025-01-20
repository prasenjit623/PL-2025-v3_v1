package view.backing;

import javax.faces.event.ValueChangeEvent;


import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;

public class ARSetup {
    public ARSetup() {
    }

    public void onChangelisterner(ValueChangeEvent valueChangeEvent) {
        String a=valueChangeEvent.getNewValue().toString();
        JSFUtils.addFacesInformationMessage(a);
}

    ViewObject arSetupVo =
        ADFUtils.findIterator("ArSetup_VO1Iterator").getViewObject();
    
    public String onValidateFields() {
        // Add event code here...
        String res="goBack";
        String val="Y";
        if(arSetupVo.getCurrentRow().getAttribute("ConcatenatedSegment")==null){
            
            JSFUtils.addFacesErrorMessage("Concatenated Segmentis Required");
            res="y";
            val="N";
            
        }
        if(arSetupVo.getCurrentRow().getAttribute("AccountingRuleName")==null){
            
            JSFUtils.addFacesErrorMessage("Accounting Rule Name is Required");
            res="y";
            val="N";
            
        }
        if(arSetupVo.getCurrentRow().getAttribute("LedgerName")==null){
            
            JSFUtils.addFacesErrorMessage("Ledger Name is Required");
            res="y";
            val="N";
            
        }
        if(arSetupVo.getCurrentRow().getAttribute("IntercompanyGlCode")==null){
            
            JSFUtils.addFacesErrorMessage("Intercompany Gl Code is Required");
            res="y";
            val="N";
            
        }
        //CostCenterGlCode RevAccountId
//        if(arSetupVo.getCurrentRow().getAttribute("CostCenterGlCode")==null){
//            
//            JSFUtils.addFacesInformationMessage("CostCenter Gl Codeis Required");
//            res="y";
//            val="N";
//            
//        }
        
        if(arSetupVo.getCurrentRow().getAttribute("RevAccountId")==null){
            
            JSFUtils.addFacesErrorMessage("Code Combnation Id is Required");
            res="y";
            val="N";
            
        }
        
        
       
        
        if(val=="Y"){
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Saved");
        }
        
        
        return res;
    }
}
