package view.backing.fragments;

import java.math.BigDecimal;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.component.UIXGroup;

import util.ADFUtils;

public class SearchMilestones {
    private RichPageTemplate pt1;
    private RichPanelGridLayout pgl2;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichSpacer s1;
    private RichOutputText ot1;
    private RichPanelGroupLayout pgl3;
  private RichQuery qryId1;
    private RichTable resId1;
    private RichPanelCollection pc1;
    private RichToolbar t1;
    private RichCommandImageLink cil1;
    private RichCommandImageLink cil2;
  private RichSpacer s2;
  private RichSpacer s3;
    private RichCommandImageLink cil3;
    private RichSpacer s4;
  private RichPanelBox pb2;
    private UIXGroup g1;
    private RichCommandImageLink commandImageLink1;
    private RichSpacer s5;

    public void setPt1(RichPageTemplate pt1) {
        this.pt1 = pt1;
    }

    public RichPageTemplate getPt1() {
        return pt1;
    }


    public void setPgl2(RichPanelGridLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGridLayout getPgl2() {
        return pgl2;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichGridCell getGc2() {
        return gc2;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }


    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }


  public void setQryId1(RichQuery qryId1) {
        this.qryId1 = qryId1;
    }

    public RichQuery getQryId1() {
        return qryId1;
    }

    public void setResId1(RichTable resId1) {
        this.resId1 = resId1;
    }

    public RichTable getResId1() {
        return resId1;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setCil1(RichCommandImageLink cil1) {
        this.cil1 = cil1;
    }

    public RichCommandImageLink getCil1() {
        return cil1;
    }

    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
    }

  public void setS2(RichSpacer s2) {
    this.s2 = s2;
  }

  public RichSpacer getS2() {
    return s2;
  }

  public void setS3(RichSpacer s3) {
    this.s3 = s3;
  }

  public RichSpacer getS3() {
    return s3;
  }

    public void setCil3(RichCommandImageLink cil3) {
        this.cil3 = cil3;
    }

    public RichCommandImageLink getCil3() {
        return cil3;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }




    public String Revise(){
        ViewObject SearchVo=ADFUtils.findIterator("SearchMilestones_ROVO1Iterator").getViewObject();
        ViewObject MilestoneVo=ADFUtils.findIterator("MilestonesHdr_VO2Iterator").getViewObject();
        ViewCriteria vc = MilestoneVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("MsHdrId", SearchVo.getCurrentRow().getAttribute("MsHdrId"));
        vc.addRow(vcRow);
        MilestoneVo.applyViewCriteria(vc);
        MilestoneVo.executeQuery();
        Row re=MilestoneVo.first();
        re.setAttribute("Status", "REV");
        String revisionVal = re.getAttribute("Revision")==null?"0":re.getAttribute("Revision").toString();
        System.out.println("===Revision==="+revisionVal);
        BigDecimal val=new BigDecimal(revisionVal);
        val=val.add(new BigDecimal(1));
        System.out.println("==Count=="+val);
        re.setAttribute("Revision", val);
        MilestoneVo.executeQuery();
        ADFUtils.findOperation("Commit").execute();
        return "edit";
    }

    public void onClickRevise(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject SearchVo=ADFUtils.findIterator("SearchMilestones_ROVO1Iterator").getViewObject();
        ViewObject MilestoneVo=ADFUtils.findIterator("MilestonesHdr_VO2Iterator").getViewObject();
        ViewCriteria vc = MilestoneVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        
        
        vcRow.setAttribute("MsHdrId", SearchVo.getCurrentRow().getAttribute("MsHdrId"));
        vc.addRow(vcRow);
        
        MilestoneVo.applyViewCriteria(vc);
        MilestoneVo.executeQuery();
        Row re=MilestoneVo.first();
        re.setAttribute("Status", "REV");
        BigDecimal val=new BigDecimal(re.getAttribute("Revision").toString());
        val=val.add(new BigDecimal(1));
        re.setAttribute("Revision", val);
        MilestoneVo.executeQuery();
         ADFUtils.findOperation("Commit").execute();


    }

  public void setPb2(RichPanelBox pb2) {
    this.pb2 = pb2;
  }

  public RichPanelBox getPb2() {
    return pb2;
  }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setCommandImageLink1(RichCommandImageLink commandImageLink1) {
        this.commandImageLink1 = commandImageLink1;
    }

    public RichCommandImageLink getCommandImageLink1() {
        return commandImageLink1;
    }

    public void setS5(RichSpacer s5) {
        this.s5 = s5;
    }

    public RichSpacer getS5() {
        return s5;
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public void customSearchLeaseAgmt_QL(QueryEvent queryEvent) {
        DCIteratorBinding iter = (DCIteratorBinding) getBindings().get("SearchLeaseAgreementInfo_RoVo1Iterator");
        /**Get Offer ViewObject from Iterator*/
        ViewObjectImpl vo = (ViewObjectImpl) iter.getViewObject();
        String unitDummy=null;
        if (vo.getNamedWhereClauseParam("b_unitNumDummy") != null) {
            unitDummy = vo.getNamedWhereClauseParam("b_unitNumDummy").toString();
            System.out.println("Booking UnitNumber:: "+unitDummy);
            vo.setNamedWhereClauseParam("b_unitNumTrans", unitDummy);
            vo.setNamedWhereClauseParam("b_unitNumDummy", null);
            }
        
        ADFUtils.invokeMethodExpression("#{bindings.SearchLeaseAgreementInfoRoVoCriteriaQuery.processQuery}", Object.class,
                                        QueryEvent.class, queryEvent);
        if (unitDummy != null) {
            vo.setNamedWhereClauseParam("b_unitNumTrans", null);
            vo.setNamedWhereClauseParam("b_unitNumDummy", unitDummy);
            }
    }
}
