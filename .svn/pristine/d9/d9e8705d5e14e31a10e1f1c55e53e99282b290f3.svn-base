import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import util.ADFUtils;

public class SearchLead {
    private RichInputText it3;
    private RichTable resId1;

    public SearchLead() {
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }
    
    ViewObject searchLeadVO = ADFUtils.findIterator("SearchLeadROVO1Iterator").getViewObject();
    public void onClickSearch(ActionEvent actionEvent) {
        if(it3.getValue()!=null){
                ViewCriteria vc  = searchLeadVO.createViewCriteria();
                ViewCriteriaRow vcr =  vc.createViewCriteriaRow();
                vcr.setAttribute("LeadNumber", "like %"+it3.getValue()+"%");
                vc.addRow(vcr);
                searchLeadVO.applyViewCriteria(vc);
                searchLeadVO.executeQuery();
                }
                else{
                    //ViewObject conHdrVO = ADFUtils.findIterator("contractROVO1Iterator").getViewObject();
                    ViewCriteria vc  = searchLeadVO.createViewCriteria();
                    ViewCriteriaRow vcr =  vc.createViewCriteriaRow();
                    vcr.setAttribute("LeadNumber", "");
                    vc.addRow(vcr);
                    searchLeadVO.applyViewCriteria(vc);
                    searchLeadVO.executeQuery();
                }
                AdfFacesContext.getCurrentInstance().addPartialTarget(resId1);
    }

    public void setResId1(RichTable resId1) {
        this.resId1 = resId1;
    }

    public RichTable getResId1() {
        return resId1;
    }
}
