package view.backing;

import javax.faces.event.ActionEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;

public class AddEditLandLordMaster {
    private RichPopup p1;

    public AddEditLandLordMaster() {
    }
    
    ViewObject lndLrdMstrVo = ADFUtils.findIterator("LandLordMaster_VO1Iterator").getViewObject();
    ViewObject lndLrdMstrUntDtlsVo = ADFUtils.findIterator("LandLordUnitDtls_VO1Iterator").getViewObject(); 
    ViewObject lndLrdMstrAprvFlwVo = ADFUtils.findIterator("LandLordAprvlFlow_VO1Iterator").getViewObject();
    
    public void doSave(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully !!!");
    }

    public void doCancel(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Rollback").execute();
    }

    public void doCreateUnitDtlsLine(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("CreateInsert").execute();
        lndLrdMstrUntDtlsVo.getCurrentRow().setAttribute("OrgId", lndLrdMstrVo.getCurrentRow().getAttribute("OrgId"));
        lndLrdMstrUntDtlsVo.getCurrentRow().setAttribute("PropertyManagement", lndLrdMstrVo.getCurrentRow().getAttribute("PropertyManagement"));
    }

    public void doSaveProprtyMangmt(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Commit").execute();
        p1.hide();
    }

    public void doCancelProprtyMngmnt(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Rollback").execute();
        p1.hide();
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void doCreateLandLrdApprvlFlwLine(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("CreateInsert1").execute();
        lndLrdMstrAprvFlwVo.getCurrentRow().setAttribute("OrgId", lndLrdMstrVo.getCurrentRow().getAttribute("OrgId"));
        lndLrdMstrAprvFlwVo.getCurrentRow().setAttribute("PropertyManagement", lndLrdMstrVo.getCurrentRow().getAttribute("PropertyManagement"));
    }

    public void doChangeAllPendingApprover(ActionEvent actionEvent) {        
        Row r = lndLrdMstrAprvFlwVo.getCurrentRow();
        ViewObject getLndLrdAprFwRoVo = ADFUtils.findIterator("GetLandlordApprFlwDtls_RoVo1Iterator").getViewObject();
        ViewCriteria vc = getLndLrdAprFwRoVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("LandlordTnxId",r.getAttribute("LandlordTnxId"));
        vcRow.setAttribute("Seq",r.getAttribute("Seq"));
        vcRow.setAttribute("LandlordAprvlFlowId",r.getAttribute("LandlordAprvlFlowId"));
        vc.addRow(vcRow);
        getLndLrdAprFwRoVo.applyViewCriteria(vc);
        getLndLrdAprFwRoVo.executeQuery();            
        String landlordTnxId = r.getAttribute("LandlordTnxId")==null?"0":r.getAttribute("LandlordTnxId").toString();
        String seq = r.getAttribute("Seq")==null?"0":r.getAttribute("Seq").toString();
        String screen = r.getAttribute("Code")==null?"":r.getAttribute("Code").toString();
        String aprvlFlowId = r.getAttribute("LandlordAprvlFlowId")==null?"":r.getAttribute("LandlordAprvlFlowId").toString();
        String approverId = r.getAttribute("UserId")==null?"0":r.getAttribute("UserId").toString();
        String updaterName =
            ADFContext.getCurrent().getSessionScope().get("userName") == null ?
            "Anonymous" :
            ADFContext.getCurrent().getSessionScope().get("userName").toString();
//        if (getLndLrdAprFwRoVo.first().getAttribute("UserId").equals(approverId)) {
            
        OperationBinding op=ADFUtils.findOperation("changeAllPendingApprover");
        op.getParamsMap().put("landlordTnxId",landlordTnxId);
        op.getParamsMap().put("seq",seq);
        op.getParamsMap().put("aprvlFlowId",aprvlFlowId);
        op.getParamsMap().put("approverId",approverId);
        op.getParamsMap().put("updaterName",updaterName);
        String flag=op.execute().toString();
        JSFUtils.addFacesInformationMessage(flag);
//        System.out.println("aprvlFlowId :"+aprvlFlowId+" new approver : "+approverId+" updaterName :"+updaterName+" getLndLrdAprFwRoVo.first().getAttribute(\"UserId\") :"+getLndLrdAprFwRoVo.first().getAttribute("UserId"));
//        }else{
//            JSFUtils.addFacesErrorMessage("Please save the new approver first and than proceed !!!"); 
//        }
    }
}
