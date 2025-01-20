package view.backing;

import javax.faces.event.ActionEvent;

import oracle.jbo.ViewCriteria;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import util.ADFUtils;
import util.JSFUtils;

public class CheckListResponse {
    private RichPanelCollection pc1;
    private RichTable t1;
    private RichToolbar t2;
    private RichCommandImageLink cil1;
    private RichSpacer s1;
    private RichCommandImageLink cil2;
    private RichSpacer s2;
    private RichSpacer s3;
    private RichCommandButton cb1;
    private RichCommandButton cb2;

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }

    public void setCil1(RichCommandImageLink cil1) {
        this.cil1 = cil1;
    }

    public RichCommandImageLink getCil1() {
        return cil1;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
    }

    public void OnCLickAddCheckList(ActionEvent actionEvent) {
        ViewObject vo1 =
            ADFUtils.findIterator("ChecklistResponse_VO1Iterator").getViewObject();
        ViewObject equipVO =
            ADFUtils.findIterator("CheckListResponse_ROVO1Iterator").getViewObject();
        ViewObjectImpl eqImpl = (ViewObjectImpl)equipVO.getViewObject();
        equipVO.setNamedWhereClauseParam("bv_func_id",
                                         JSFUtils.resolveExpression("#{pageFlowScope.Funcid}"));
        equipVO.setNamedWhereClauseParam("bv_attr1",
                                         JSFUtils.resolveExpression("#{pageFlowScope.Lookup}"));
        eqImpl.applyViewCriteria(eqImpl.getViewCriteria("finbyid"));
        eqImpl.getViewObject().executeQuery();
        if (equipVO.getEstimatedRowCount() > 0) {
            RowSetIterator rs = equipVO.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r1 = rs.next();
                Row r = vo1.createRow();
                r.setAttribute("FuncId",
                               JSFUtils.resolveExpression("#{pageFlowScope.Funcid}"));
                r.setAttribute("FuncRefId",
                               JSFUtils.resolveExpression("#{pageFlowScope.FuncreFid}"));

                r.setAttribute("Attribute1",
                               JSFUtils.resolveExpression("#{pageFlowScope.Lookup}"));
                r.setAttribute("FuncClId", r1.getAttribute("FuncClId"));
                
                vo1.insertRow(r);
            }

        } else {
            JSFUtils.addFacesInformationMessage("No CheckList Has been define");
        }
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

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }
}
