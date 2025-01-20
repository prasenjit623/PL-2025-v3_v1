package view.backing;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditSchedulerWoTnx {
    private RichPopup popUp1;
    private RichInputText reason;
    private RichPopup p3;
    private RichInputText reWorkReason;
    private RichInputText it211;

    public AddEditSchedulerWoTnx() {
    }

    ViewObject woSchMainHdrVo = ADFUtils.findIterator("WoSchedulingMainHdr_VO1Iterator").getViewObject();
    ViewObject woSchTnxHdr = ADFUtils.findIterator("WoSchedulerTnxHdr_VO1Iterator").getViewObject();
    ViewObject woSchTnxResrc = ADFUtils.findIterator("WoSchedulerTnxResource_VO1Iterator").getViewObject();
    
    public void onInvokeAppOrReject(ActionEvent actionEvent) {
        // Add event code here...
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopUp1().show(popup34);
    }

    public void setPopUp1(RichPopup popUp1) {
        this.popUp1 = popUp1;
    }

    public RichPopup getPopUp1() {
        return popUp1;
    }

    public void onclickAppOrRej(ActionEvent actionEvent) {
        Object val =
            ADFContext.getCurrent().getPageFlowScope().get("Action") == null ?
            "" :
            ADFContext.getCurrent().getPageFlowScope().get("Action").toString();
        if (val.equals("Approval")) {
            onClickApprove(actionEvent);
        }
        if (val.equals("Rejection")) {
            onClickReject(actionEvent);
        }
    }
    
    public void onClickApprove(ActionEvent actionEvent) {
        String result = "Y";
        if (result == "Y") {
            Map<String, BigDecimal> ResultVal =
                new HashMap<String, BigDecimal>();
            Row row = woSchMainHdrVo.getCurrentRow();
            String Reason = 
                this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
            //
            System.out.println("func id :: " + row.getAttribute("FuncId"));
            System.out.println("WoSchMainHdrId id :: " + row.getAttribute("WoSchMainHdrId"));
            System.out.println("UserGrpId id :: " + row.getAttribute("UserGrpId"));
            System.out.println("FlowLevel id :: " + row.getAttribute("FlowLevel"));
            System.out.println("FlowWith id :: " + row.getAttribute("FlowWith"));
            //
            try {
                ResultVal =
                        xxfnd.invokeResponsePkgs("xxfnd_util_pkg.update_response",
                                                 row.getAttribute("FuncId"),
                                                 row.getAttribute("WoSchMainHdrId"),
                                                 row.getAttribute("UserGrpId"),
                                                 row.getAttribute("FlowLevel"),
                                                 row.getAttribute("FlowWith"),
                                                 Reason, "A", 0,
                                                 "XXPM_WO_SCHEDULING_MAIN_HDR", "STATUS",
                                                 "WO_SCH_MAIN_HDR_ID");


            } catch (SQLException e) {
                System.err.println("ERROR" + e);
            }
            //ResultVal
            System.err.println("ERROR" + ResultVal);


            for (Map.Entry m : ResultVal.entrySet()) {
                System.out.println("KEY" + m.getKey() + "VALUE " +
                                   m.getValue());

                if (m.getKey().equals("Success")) {
                    //vo.executeQuery();

                    String ress =
                        m.getValue() == null ? "null" : m.getValue().toString();
                    if (ress.equals("null")) {

                    }
                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Approved....");
                } else {
                    JSFUtils.addFacesErrorMessage("Error in Approve process!");
                }
            }
        }
    }
    
    public void onClickReject(ActionEvent actionEvent) {
        String ResultVal = null;
        Row row = woSchMainHdrVo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Rejected" : this.reason.getValue().toString();


        try {
            ResultVal =
                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
                                            row.getAttribute("FuncId"),
                                            row.getAttribute("WoSchMainHdrId"),
                                            row.getAttribute("UserGrpId"),
                                            row.getAttribute("FlowLevel"),
                                            row.getAttribute("FlowWith"),
                                            Reason, "R", 0, "XXPM_WO_SCHEDULING_MAIN_HDR",
                                            "STATUS", "WO_SCH_MAIN_HDR_ID");


        } catch (SQLException e) {
            System.out.println(e);
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Rejected....");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Reject process!");
        }

    }

    public void setReason(RichInputText reason) {
        this.reason = reason;
    }

    public RichInputText getReason() {
        return reason;
    }

    public void addSchWoResourceTnxDtl(ActionEvent actionEvent) {
        ViewObject vo =
                    ADFUtils.findIterator("WoSchedulerTnxHdr_VO1Iterator").getViewObject();
                Row row = vo.getCurrentRow();
                ADFUtils.findOperation("CreateInsert1").execute();
                ViewObject woSchResourceVo = ADFUtils.findIterator("WoSchedulerTnxResource_VO1Iterator").getViewObject();
                System.out.println("Count ::"+woSchResourceVo.getEstimatedRowCount());
                woSchResourceVo.getCurrentRow().setAttribute("ResourceSequenceNumber", woSchResourceVo.getEstimatedRowCount()*10);
                String scWoTnxId = woSchResourceVo.getCurrentRow().getAttribute("ScWoTnxId")==null ?"":woSchResourceVo.getCurrentRow().getAttribute("ScWoTnxId").toString();
                String woId = null;
            ViewObject getAllWoDtlRoVo = ADFUtils.findIterator("getAllWoRscTnxDtls_RoVo1Iterator").getViewObject();           
            ViewCriteria vc = getAllWoDtlRoVo.createViewCriteria();
                    ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                    vcRow.setAttribute("ScWoTnxId", scWoTnxId);
                    vc.addRow(vcRow);
                    getAllWoDtlRoVo.applyViewCriteria(vc);
                    getAllWoDtlRoVo.executeQuery();
                    if (getAllWoDtlRoVo.getEstimatedRowCount()>0){
                        Row rww = getAllWoDtlRoVo.first();
                        woId = rww.getAttribute("WoId")==null?"":rww.getAttribute("WoId").toString();
                        System.out.println("woId inside ::"+woId);
                    }
            woSchResourceVo.getCurrentRow().setAttribute("WoId", woId); 
        }

    public void deleteSchWoResourceTnxDtl(ActionEvent actionEvent) {
        ADFUtils.findOperation("Delete1").execute();
    }

    public void doCreateWoSchTnxHdr(ActionEvent actionEvent) {
        ViewObject vo =
                    ADFUtils.findIterator("WoSchedulerTnxHdr_VO1Iterator").getViewObject();
                Row row = vo.getCurrentRow();
                ADFUtils.findOperation("CreateInsert").execute();
            System.out.println("Count ::"+vo.getEstimatedRowCount());
//            RowSetIterator tnxResourceRsi = vo.createRowSetIterator(null);
//                while (tnxResourceRsi.hasNext()) {
//                    Row ro = tnxResourceRsi.next();
//                    String woSchMainHdrId = ro.getAttribute("WoSchMainHdrId")==null?"":ro.getAttribute("WoSchMainHdrId").toString();
//                    if(woSchMainHdrId.equals("")){
//                    ro.setAttribute("WoSchMainHdrId", row.getAttribute("WoSchMainHdrId"));
//                    }
//                }
//            addSchWoResourceTnxDtl(actionEvent);
        }

    public void deleteSchWoTnxHdr(ActionEvent actionEvent) {
        ADFUtils.findOperation("Delete").execute();
    }

    public void doSave(ActionEvent actionEvent) {
        ViewObject vo = ADFUtils.findIterator("WoSchedulerTnxHdr_VO1Iterator").getViewObject();
        ViewObject woSchResourceVo = ADFUtils.findIterator("WoSchedulerTnxResource_VO1Iterator").getViewObject();
        Row row = woSchMainHdrVo.getCurrentRow();
        //WoSchedulerTnxHdr_VO1Iterator
        System.out.println("Estm count WoSchTnxHdr :"+vo.getEstimatedRowCount());
        //WoSchedulerTnxResource_VO1Iterator
        System.out.println("Estm count wo resource :"+vo.getEstimatedRowCount());
        ViewObject getFuncodeVo = ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
        getFuncodeVo.setNamedWhereClauseParam("F_ID", "WOSCH");
        getFuncodeVo.executeQuery();
        //WoSchedulerTnxResource_VO1Iterator
        System.out.println("Estm count WoSchTnxHdr :"+woSchResourceVo.getEstimatedRowCount());
        RowSetIterator tnxResourceRsi = woSchResourceVo.createRowSetIterator(null);
        while (tnxResourceRsi.hasNext()) {
            Row ro = tnxResourceRsi.next();
            String woSchMainHdrId = ro.getAttribute("WoSchMainHdrId")==null?"":ro.getAttribute("WoSchMainHdrId").toString();
            if(woSchMainHdrId.equals("")){
            ro.setAttribute("WoSchMainHdrId", row.getAttribute("WoSchMainHdrId"));
            }
        }
        woSchResourceVo.closeRowSetIterator();
        if(row.getAttribute("WoSchMainHdrNo")==null){
            String woSchMainHdrId = row.getAttribute("WoSchMainHdrId")==null?"":row.getAttribute("WoSchMainHdrId").toString();
            System.out.println("woSchMainHdrId on save ::"+woSchMainHdrId);
            row.setAttribute("WoSchMainHdrNo", "WOSCH-"+woSchMainHdrId); 
            String name = xxfnd.generateDocNo("WOSCH", "WoScheduler_AMDataControl").toString();
            row.setAttribute("FuncId", getFuncodeVo.first().getAttribute("FuncId"));
        }
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully !!!");
    }

    public String onSaveAndClose() {
        // Add event code here...
        ViewObject vo = ADFUtils.findIterator("WoSchedulerTnxHdr_VO1Iterator").getViewObject();
        ViewObject woSchResourceVo = ADFUtils.findIterator("WoSchedulerTnxResource_VO1Iterator").getViewObject();
        Row row = woSchMainHdrVo.getCurrentRow();
        //WoSchedulerTnxHdr_VO1Iterator
        System.out.println("Estm count WoSchTnxHdr :"+vo.getEstimatedRowCount());
        ViewObject getFuncodeVo = ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
        getFuncodeVo.setNamedWhereClauseParam("F_ID", "WOSCH");
        getFuncodeVo.executeQuery();
        //WoSchedulerTnxResource_VO1Iterator
        System.out.println("Estm count WoSchTnxHdr :"+woSchResourceVo.getEstimatedRowCount());
        RowSetIterator tnxResourceRsi = woSchResourceVo.createRowSetIterator(null);
        while (tnxResourceRsi.hasNext()) {
            Row ro = tnxResourceRsi.next();
            String woSchMainHdrId = ro.getAttribute("WoSchMainHdrId")==null?"":ro.getAttribute("WoSchMainHdrId").toString();
            if(woSchMainHdrId.equals("")){
            ro.setAttribute("WoSchMainHdrId", row.getAttribute("WoSchMainHdrId"));
            }
        }
        woSchResourceVo.closeRowSetIterator();
        if(row.getAttribute("WoSchMainHdrNo")==null){
            String woSchMainHdrId = row.getAttribute("WoSchMainHdrId")==null?"":row.getAttribute("WoSchMainHdrId").toString();
            System.out.println("woSchMainHdrId on save ::"+woSchMainHdrId);
            row.setAttribute("WoSchMainHdrNo", "WOSCH-"+woSchMainHdrId); 
//            String name = xxfnd.generateDocNo("WOSCH", "WoScheduler_AMDataControl").toString();
            row.setAttribute("FuncId", getFuncodeVo.first().getAttribute("FuncId"));
        }
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully !!!");
        return "back";
    }

    public String onClickSubmit() {
        // Add event code here...
        String ResultVal=null;
        onSaveAndClose();
        Row row = woSchMainHdrVo.getCurrentRow();
//                    Object org = woSchTnxHdr.getCurrentRow().getAttribute("OrgId");
//                    Object prop = woSchTnxHdr.getCurrentRow().getAttribute("PropertyId");
//                    Object build = woSchTnxHdr.getCurrentRow().getAttribute("BuildingId");
        Object org = "300000001937026";
        Object prop = "103";
        Object build = "103";
                    System.err.println("onClickSubmit data : OrgId "+org+" prop "+prop+" build "+build);
                    try {
                        ResultVal =
                                xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
                                                      row.getAttribute("FuncId"),
                                                      row.getAttribute("WoSchMainHdrId"), 0,
                                                      "XXPM_WO_SCHEDULING_MAIN_HDR", "STATUS",
                                                      "WO_SCH_MAIN_HDR_ID", org, prop, build,
                                                      null, null);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }                   
                    System.out.println("resultVal after calling submit package :: " +
                                       ResultVal);
                    if (ResultVal.equalsIgnoreCase("Success")) {
                        ADFUtils.findOperation("Commit").execute();
                        JSFUtils.addFacesInformationMessage("Submitted For Approval");                                        
                    } else {
                        JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
                    }
        return null;
    }

    public void onDoCancel(ActionEvent actionEvent) {
        ADFUtils.findOperation("Rollback").execute();
    }

    public void onSelectWO(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Row row = woSchMainHdrVo.getCurrentRow();
        Object woSchMainHdrId = woSchMainHdrVo.getCurrentRow().getAttribute("WoSchMainHdrId");
        woSchTnxHdr.getCurrentRow().setAttribute("WoSchMainHdrId", woSchMainHdrId);
    }

    public void doReSet(ActionEvent actionEvent) {
        // Add event code here...
        Row row = woSchMainHdrVo.getCurrentRow();
        row.setAttribute("Status2", "Rework");
//        row.setAttribute("UserGrpId", "");
//        row.setAttribute("FlowLevel", "");
//        row.setAttribute("FlowWith", "");
        ADFUtils.findOperation("Commit").execute();
//        String woSchMainHdrId = row.getAttribute("WoSchMainHdrId")==null?"":row.getAttribute("WoSchMainHdrId").toString();
//        String userId = ADFContext.getCurrent().getSessionScope().get("userId") == null ? "api" :
//                        ADFContext.getCurrent().getSessionScope().get("userId").toString();        
//        String reason = this.reWorkReason.getValue() == null ? "Rejected" : this.reWorkReason.getValue().toString();
//        doReworkHist(woSchMainHdrId,userId,reason);
    }
    
    public void doReworkHist(String woSchMainHdrId,String userId,String reason){
        
              OperationBinding op=ADFUtils.findOperation("directRejectionFromDraft");
              op.getParamsMap().put("mainId",woSchMainHdrId);
              op.getParamsMap().put("userId",userId);
              op.getParamsMap().put("reason",reason);
              String flag=op.execute().toString();
              JSFUtils.addFacesInformationMessage(flag);
        }

    public void doCompletedTrigger(ActionEvent actionEvent) {
        // Add event code here...
        Row row = woSchMainHdrVo.getCurrentRow();
        row.setAttribute("Status2", "Rework Completed");
        ADFUtils.findOperation("Commit").execute();
    }

    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public void setReWorkReason(RichInputText reWorkReason) {
        this.reWorkReason = reWorkReason;
    }

    public RichInputText getReWorkReason() {
        return reWorkReason;
    }

    public void doReWork(ActionEvent actionEvent) {
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getP3().show(popup34);
    }

    public void onClickCompleteWoLine(ActionEvent actionEvent) {
        // Add event code here...
        Row row = woSchTnxHdr.getCurrentRow(); 
        row.setAttribute("Status", "Rework Completed");
        ViewCriteria vc = woSchTnxResrc.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("ScWoTnxId", row.getAttribute("ScWoTnxId"));
        vc.addRow(vcRow);
        woSchTnxResrc.applyViewCriteria(vc);
        woSchTnxResrc.executeQuery();
        if (woSchTnxResrc.getEstimatedRowCount()>0){
        RowSetIterator rsi = woSchTnxResrc.createRowSetIterator(null);
        while(rsi.hasNext()){
            Row r = rsi.next();
            r.setAttribute("Status", "Completed");
        }
            rsi.closeRowSetIterator();
        }
    }

    public void onClickCompleteWoResLine(ActionEvent actionEvent) {
        // Add event code here...
        Row row = woSchTnxResrc.getCurrentRow();
        row.setAttribute("Status", "Rework Completed");
        woSchMainHdrVo.getCurrentRow().setAttribute("InterfaceStatus", "TRANSFER_WORK_ORDER");
    }

    public void doReworkForResrcLine(ActionEvent actionEvent) {
        // Add event code here...
        Row row = woSchTnxResrc.getCurrentRow();
        row.setAttribute("Status", "Rework");
    }

    public void doReworkForTnxHdrLine(ActionEvent actionEvent) {
        // Add event code here...
        Row row = woSchTnxHdr.getCurrentRow(); 
        row.setAttribute("Status", "Rework");
        ViewCriteria vc = woSchTnxResrc.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("ScWoTnxId", row.getAttribute("ScWoTnxId"));
        vc.addRow(vcRow);
        woSchTnxResrc.applyViewCriteria(vc);
        woSchTnxResrc.executeQuery();
        if (woSchTnxResrc.getEstimatedRowCount()>0){
        RowSetIterator rsi = woSchTnxResrc.createRowSetIterator(null);
        while(rsi.hasNext()){
            Row r = rsi.next();
            r.setAttribute("Status", "Rework");
        }
            rsi.closeRowSetIterator();
        }
    }

    public void doTransferToFusion(ActionEvent actionEvent) {
        // Add event code here...
        Row row = woSchTnxHdr.getCurrentRow(); 
        row.setAttribute("Status", "Transferred");
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Scheduler for "+row.getAttribute("WoNo") +" processed successfully !!!");
    }
    public void doPushToSaaSMainHdr(ActionEvent actionEvent) {
        // Add event code here...
        Row row = woSchMainHdrVo.getCurrentRow();
        row.setAttribute("InterfaceStatus", "TRANSFER_WORK_ORDER");
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Associated WO resource ready to pushed to SaaS !!!");
    }

    public void doSrchForeman(ActionEvent actionEvent) {
        String woSchMainHdrId = woSchMainHdrVo.getCurrentRow().getAttribute("WoSchMainHdrId")==null ? "" : woSchMainHdrVo.getCurrentRow().getAttribute("WoSchMainHdrId").toString();
        String foreman = it211.getValue()==null ? "" : it211.getValue().toString();
        ViewCriteria vc = woSchTnxHdr.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("WoSchMainHdrId", woSchMainHdrId);
        vcRow.setAttribute("AssignedForman", foreman);
        vc.addRow(vcRow);
        woSchTnxHdr.applyViewCriteria(vc);
        woSchTnxHdr.executeQuery();
    }

    public void setIt211(RichInputText it211) {
        this.it211 = it211;
    }

    public RichInputText getIt211() {
        return it211;
    }

    public void doReset(ActionEvent actionEvent) {
        String woSchMainHdrId = woSchMainHdrVo.getCurrentRow().getAttribute("WoSchMainHdrId")==null ? "" : woSchMainHdrVo.getCurrentRow().getAttribute("WoSchMainHdrId").toString();
        woSchTnxHdr.resetExecuted();
        ViewCriteria vc = woSchTnxHdr.createViewCriteria();        
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("WoSchMainHdrId", woSchMainHdrId);
        vc.addRow(vcRow);
        woSchTnxHdr.applyViewCriteria(vc);
        woSchTnxHdr.executeQuery();
    }
}
