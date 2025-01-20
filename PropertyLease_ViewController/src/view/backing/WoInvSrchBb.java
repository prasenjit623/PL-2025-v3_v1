package view.backing;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.context.AdfFacesContext;

public class WoInvSrchBb {
    private RichShowDetailItem tab1;
    private RichShowDetailItem tab2;

    public WoInvSrchBb() {
    }

    public void setTab1(RichShowDetailItem tab1) {
        this.tab1 = tab1;
    }

    public RichShowDetailItem getTab1() {
        return tab1;
    }
    
    public String getBackToTab() {
        Boolean flag=true;
        String tabNav =
            ADFContext.getCurrent().getPageFlowScope().get("tabSlct") == null ?
            "tab1" :
            ADFContext.getCurrent().getPageFlowScope().get("tabSlct").toString(); 
        AdfFacesContext.getCurrentInstance().addPartialTarget(tab1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(tab2);
        return tabNav;
    }

    public void setTab2(RichShowDetailItem tab2) {
        this.tab2 = tab2;
    }

    public RichShowDetailItem getTab2() {
        return tab2;
    }
}
