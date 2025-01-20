package view.backing;

import javax.faces.event.ActionEvent;

import oracle.adf.share.ADFContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditResourceBb {
    public AddEditResourceBb() {
    }

    public void doSave(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject rscVo = ADFUtils.findIterator("WoSchedulerTnxResource_VO1Iterator").getViewObject();
        Row row = rscVo.getCurrentRow();
        System.out.println("Estm count wo resource :"+rscVo.getEstimatedRowCount());
        
        if(rscVo.getEstimatedRowCount()>0){
            String woId = ADFContext.getCurrent().getPageFlowScope().get("woId").toString();
            String woNo = ADFContext.getCurrent().getPageFlowScope().get("woNo").toString();//interfaceSatus
            
        RowSetIterator tnxResourceRsi = rscVo.createRowSetIterator(null);
        while (tnxResourceRsi.hasNext()) {
            Row ro = tnxResourceRsi.next();
//            String woSchMainHdrId = ro.getAttribute("WoSchMainHdrId")==null?"":ro.getAttribute("WoSchMainHdrId").toString();
//            ro.setAttribute("WoSchMainHdrId", row.getAttribute("WoSchMainHdrId"));
            ro.setAttribute("WoId", woId);
            ro.setAttribute("WoNo", woNo);
        }
        rscVo.closeRowSetIterator();
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully !!!");
        }
    }

    public void onDoCancel(ActionEvent actionEvent) {
        ADFUtils.findOperation("Rollback").execute();
    }

    public void doCreateResource(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("CreateInsert").execute();
        ViewObject rscVo = ADFUtils.findIterator("WoSchedulerTnxResource_VO1Iterator").getViewObject();
        Row row = rscVo.getCurrentRow();
        Long i = rscVo.getEstimatedRowCount();
        System.out.println("i%%"+i);
        Long y = new Long(0);
        y=i*10;
        String resrcSeqNo=Long.toString(y);
        System.out.println("resrcSeqNo%%"+resrcSeqNo);
        rscVo.getCurrentRow().setAttribute("ResourceSequenceNumber", resrcSeqNo);
    }

    public void doReworkForResrcLine(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void onClickCompleteWoResLine(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void deleteResourceLine(ActionEvent actionEvent) {
        // Add event code here...
    }
}
