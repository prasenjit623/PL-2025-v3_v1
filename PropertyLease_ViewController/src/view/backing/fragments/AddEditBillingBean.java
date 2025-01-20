package view.backing.fragments;

import java.math.BigDecimal;

import java.util.Iterator;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.VO.Booking_Milestone_VORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.model.RowKeySet;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditBillingBean {
    private RichPopup msPopup;
    private RichTable msTable_Binding;
    private RichTable msparent_table_binding;

    public AddEditBillingBean() {
    }

    public String openPopUp() {
        // Add event code here...
        return null;
    }
    
    ViewObject billingDtlVO = ADFUtils.findIterator("Booking_Milestone_VO3Iterator").getViewObject();
    
    public void showMspopUp_AL(ActionEvent actionevent){
        ViewObject offerLnsVO2 = ADFUtils.findIterator("Booking_Milestone_VO4Iterator").getViewObject();
        ViewCriteria vc = offerLnsVO2.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        
        BigDecimal bookingId = (BigDecimal)ADFUtils.getBoundAttributeValue("BookingId");
        vcRow.setAttribute("BookingHdrId", bookingId);
        vc.addRow(vcRow);
        vc.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
        offerLnsVO2.applyViewCriteria(vc);
        offerLnsVO2.executeQuery();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        msPopup.show(hints);
    }

    public void setMsPopup(RichPopup msPopup) {
        this.msPopup = msPopup;
    }

    public RichPopup getMsPopup() {
        return msPopup;
    }

    public void msPopup_PFL(PopupFetchEvent popupFetchEvent) {
        // Add event code here...
    }

    public void setMsTable_Binding(RichTable msTable_Binding) {
        this.msTable_Binding = msTable_Binding;
    }

    public RichTable getMsTable_Binding() {
        return msTable_Binding;
    }
    
    public void msDetailDialogueListerner(DialogEvent dialogEvent) {
        String outcome = dialogEvent.getOutcome().ok.name();
        if (outcome.equals(DialogEvent.Outcome.ok.name())) {
            ViewObject mileVO = ADFUtils.findIterator("Booking_Milestone_VO3Iterator").getViewObject();
            mileVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(msparent_table_binding);
            System.out.println("Excecuted Successfully New .. !!!!!!!!!");
        }
    }

    public void setMsparent_table_binding(RichTable msparent_table_binding) {
        this.msparent_table_binding = msparent_table_binding;
    }

    public RichTable getMsparent_table_binding() {
        return msparent_table_binding;
    }

    public void selectRow_VCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        BigDecimal billingId = (BigDecimal)ADFUtils.getBoundAttributeValue("BillingId");
        String newValue = valueChangeEvent.getNewValue().toString();
        RichTable table = this.getMsTable_Binding();
        RowKeySet rowKeys = table.getSelectedRowKeys();
        DCIteratorBinding itBind = ADFUtils.findIterator("Booking_Milestone_VO4Iterator");
        RowSetIterator rw = itBind.getRowSetIterator();
        Iterator rowIter = rowKeys.iterator();
        while (rowIter.hasNext())
        {
            Key key = (Key)((List)rowIter.next()).get(0);
            Booking_Milestone_VORowImpl row = (Booking_Milestone_VORowImpl)rw.getRow(key);
            if(null != newValue && "false".equalsIgnoreCase(newValue)){
                row.setBillingId(null);
            }
            if(null != newValue && "true".equalsIgnoreCase(newValue)){
                row.setBillingId(billingId);
            }
        }
    }
    
    public void delete_AL(ActionEvent actionevent){
        BigDecimal bg = new BigDecimal(0);
        RichTable table = this.getMsparent_table_binding();
        RowKeySet rowKeys = table.getSelectedRowKeys();
        DCIteratorBinding itBind = ADFUtils.findIterator("Booking_Milestone_VO3Iterator");
        RowSetIterator rw = itBind.getRowSetIterator();
        Iterator rowIter = rowKeys.iterator();
        while (rowIter.hasNext()){
            Key key = (Key)((List)rowIter.next()).get(0);
            Booking_Milestone_VORowImpl row = (Booking_Milestone_VORowImpl)rw.getRow(key);
            row.setBillingId(null);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(msparent_table_binding);
    }
    
    public void save_AL(ActionEvent actionEvent){
        ViewObject billingVO = ADFUtils.findIterator("Billing_VO2Iterator").getViewObject();
//        BigDecimal billingId = (BigDecimal)ADFUtils.getBoundAttributeValue("BillingId");
//        String billingNo = "BL-"+billingId;
//        System.out.println("Billing Number:::: "+billingNo);
//        billingVO.getCurrentRow().setAttribute("BillingNumber", billingNo);
        //      
            
        if(billingDtlVO.getEstimatedRowCount()!=0){
        
          if (billingVO.getCurrentRow().getAttribute("BillingNumber") == null) {
            //genarating billing no
            String name =
                xxfnd.generateDocNo("BL", "BookingAppModuleDataControl").toString();
            Object valu = name;
            billingVO.getCurrentRow().setAttribute("BillingNumber", valu);
        }
        //
        billingVO.getApplicationModule().getTransaction().commit();
        JSFUtils.addFacesInformationMessage("Saved Successfully...");
        }else{
               JSFUtils.addFacesErrorMessage("Create Billing Details !!!");
           }
//        /**
//         * Re-Execute to be in same billing ID
//         */
//        ViewCriteria vc = billingVO.createViewCriteria();
//        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
//        vcRow.setAttribute("BillingId", billingId);
//        vc.addRow(vcRow);
//        billingVO.applyViewCriteria(vc);
//        billingVO.executeQuery();
    }
    
    public String saveandcancel_AC(){
        ViewObject billingVO = ADFUtils.findIterator("Billing_VO2Iterator").getViewObject();
//        BigDecimal billingId = (BigDecimal)ADFUtils.getBoundAttributeValue("BillingId");
//        String billingNo = "BL-"+billingId;
//        System.out.println("Billing Number:::: "+billingNo);
//        billingVO.getCurrentRow().setAttribute("BillingNumber", billingNo);
//        billingVO.getApplicationModule().getTransaction().commit();
                if(billingDtlVO.getEstimatedRowCount()!=0){
        
          if (billingVO.getCurrentRow().getAttribute("BillingNumber") == null) {
            //genarating billing no
            String name =
                xxfnd.generateDocNo("BL", "BookingAppModuleDataControl").toString();
            Object valu = name;
            billingVO.getCurrentRow().setAttribute("BillingNumber", valu);
        }
        //
        billingVO.getApplicationModule().getTransaction().commit();
        JSFUtils.addFacesInformationMessage("Saved Successfully...");
        }else{
               JSFUtils.addFacesErrorMessage("Create Billing Details !!!");
           }
        ViewObject searchBillingVo = ADFUtils.findIterator("SearchBilling_ROVO1Iterator").getViewObject();
        searchBillingVo.executeQuery();
        
        return "cancel";
    }

    public void doRefreshSearchTable(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject searchBillingVo = ADFUtils.findIterator("SearchBilling_ROVO1Iterator").getViewObject();
        searchBillingVo.executeQuery();
    }
}
