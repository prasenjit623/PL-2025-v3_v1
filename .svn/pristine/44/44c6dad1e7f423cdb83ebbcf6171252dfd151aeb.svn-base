package view.backing.fragments;


import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;

import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;

import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;

import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditBuilding {
    private RichPageTemplate pt1;
    private RichPanelBox pb1;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichInputText it6;
    private RichSelectOneChoice soc2;
    private UISelectItems si2;
    private RichInputText it7;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichInputText it8;
    private RichInputText it9;
    private RichInputText it10;
    private RichInputText it11;
    private RichInputText it12;
    private RichInputText it13;
    private RichInputText it14;
    private RichInputText it15;
    private RichInputText it16;
    private RichInputText it17;
    private RichInputText it18;
    private RichInputText it19;
    private RichInputText it20;
    private RichInputText it21;
    private RichInputText it22;
    private RichInputDate id1;
    private RichInputText it23;
    private RichInputDate id2;
    private RichInputText it24;
    private RichPanelFormLayout pfl2;
    private RichPanelFormLayout pfl3;
    private RichPanelBox pb2;
    private RichPanelBox pb3;
    private RichPanelGroupLayout pgl2;
    private RichPanelGroupLayout pgl3;
    private RichPanelGroupLayout pgl4;
    private RichSpacer s1;
    private RichSpacer s2;
    private RichPanelFormLayout pfl4;
    private RichPanelGroupLayout pgl5;
    private RichSpacer s3;
    private RichSpacer s4;
    private RichPanelTabbed pt2;
    private RichShowDetailItem tab1;
    private RichShowDetailItem tab2;
    private RichShowDetailItem tab3;
    private RichPanelBox pb4;
    private RichPanelBox pb5;
    private RichPanelBox pb6;
    private RichPanelCollection pc1;
    private RichPanelCollection pc2;
    private RichPanelCollection pc3;
    private RichTable t1;
    private RichTable t2;
    private RichSpacer s5;
    private RichToolbar t3;
    private RichCommandImageLink cil2;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichCommandButton cb3;
    private RichToolbar t4;
    private RichCommandButton cb4;
    private RichCommandButton cb5;
    private RichCommandButton cb6;
    private RichInputComboboxListOfValues propertyTransId;
    private RichPanelGroupLayout pgl6;
    private RichPanelGroupLayout pgl7;
    private RichSpacer spacer1;
    private RichPanelBox pb7;
    private RichPanelFormLayout pfl5;
    private RichInputText it32;
    private RichInputText it33;
    private RichInputText it34;
    private RichInputDate id3;
    private RichInputText it35;
    private RichSpacer spacer2;
    private RichShowDetailItem sdi1;
    private RichPanelCollection pc4;
    private RichPanelBox pb8;
    private RichToolbar t6;
    private RichCommandImageLink cil3;
    private RichCommandImageLink cil4;
    private RichSpacer s6;
    private RichTable t7;
    private RichCommandImageLink cil5;
    private RichSpacer s7;
    private RichSelectOneChoice soc8;
    private UISelectItems si8;
    private RichSelectOneChoice soc9;
    private UISelectItems si9;
    private RichCommandButton cb7;

    public void setPt1(RichPageTemplate pt1) {
        this.pt1 = pt1;
    }

    public RichPageTemplate getPt1() {
        return pt1;
    }


    public void onClickSave(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject getFuncodeVo=ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
        getFuncodeVo.setNamedWhereClauseParam("F_ID", "BD");
        getFuncodeVo.executeQuery();
        Object Funcode=getFuncodeVo.first().getAttribute("FuncId");
        String Fcode=Funcode==null?"":Funcode.toString();
        ViewObject Property =
            ADFUtils.findIterator("PropertyBuildings_VO1Iterator").getViewObject();
        Row re = Property.getCurrentRow();
        if (re.getAttribute("BuildNumber") == null) {
            String name =
                xxfnd.generateDocNo("BD", "PropertyBuilding_AMDataControl").toString();
            Object valu = name;

            re.setAttribute("BuildNumber", valu);
            re.setAttribute("FuncId",getFuncodeVo.first().getAttribute("FuncId"));
        }
        //
        String unitCatg = re.getAttribute("Attribute1")==null ? "" : re.getAttribute("Attribute1").toString();
        String unitInChrg = re.getAttribute("Attribute2")==null ? "" : re.getAttribute("Attribute2").toString();
        String buildId = re.getAttribute("BuildId")==null ? "" : re.getAttribute("BuildId").toString();
        String aplyInChrgPFS = ADFContext.getCurrent().getPageFlowScope().get("ApplyIncharge")==null ? "" : ADFContext.getCurrent().getPageFlowScope().get("ApplyIncharge").toString();
        String resp = null;
        String userName =
            ADFContext.getCurrent().getSessionScope().get("userName") ==
            null ? "Anonymous" :
            ADFContext.getCurrent().getSessionScope().get("userName").toString();
        if(aplyInChrgPFS.equalsIgnoreCase("ApplyIncharge")){
            try{
            ADFContext.getCurrent().getPageFlowScope().put("ApplyIncharge", "");
            OperationBinding op=ADFUtils.findOperation("BuildUnitInchargeHsty");
            op.getParamsMap().put("buildId",buildId);
            op.getParamsMap().put("userName",userName);
            op.getParamsMap().put("unitCatg",unitCatg);
            op.getParamsMap().put("unitInChrg",unitInChrg);
            resp=op.execute().toString();
            //          JSFUtils.addFacesInformationMessage(flag);
            }catch(Exception e){
                System.err.println("Exception ::"+e);
            }
        }
        OperationBinding binding =
            (OperationBinding)ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully");
    }

    public void onClickClose(ActionEvent actionEvent) {
        OperationBinding binding =
            (OperationBinding)ADFUtils.findOperation("Rollback").execute();
    }


    public void onclickaddArea(ActionEvent actionEvent) {
        ViewObject BuildVo =
            ADFUtils.findIterator("PropertyBuildings_VO1Iterator").getViewObject();
        Row re = BuildVo.getCurrentRow();
        if (re.getAttribute("PropertyId") != null) {
            OperationBinding op =
                (OperationBinding)ADFUtils.findOperation("CreateInsert").execute();


            ViewObject AreaVo =
                ADFUtils.findIterator("PropertyArea_VO1Iterator").getViewObject();
            Row areaRo = AreaVo.getCurrentRow();
            areaRo.setAttribute("PropertyId", re.getAttribute("PropertyId"));
            AreaVo.executeQuery();
        } else {
            JSFUtils.addFacesErrorMessage("Please Select Property ..!");
        }

    }
    public void onApplyForInchrg(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            if(valueChangeEvent.getNewValue()!=null){
                //apply inchrg
            ADFContext.getCurrent().getPageFlowScope().put("ApplyIncharge", "ApplyIncharge");
            
            ViewObject Property = ADFUtils.findIterator("PropertyBuildings_VO1Iterator").getViewObject();
                    Row re = Property.getCurrentRow();
                    String unitCatg = re.getAttribute("Attribute1")==null ? "" : re.getAttribute("Attribute1").toString();
                    String unitInChrg = re.getAttribute("Attribute2")==null ? "" : re.getAttribute("Attribute2").toString();
                    String buildId = re.getAttribute("BuildId")==null ? "" : re.getAttribute("BuildId").toString();
            //        String unitCatgUnit = re.getAttribute("UnitCategory")==null ? "" : re.getAttribute("UnitCategory").toString();
             
                    if (!unitInChrg.equals("")){
                    ViewObject unitVo = ADFUtils.findIterator("PropertyUnits_VO1Iterator").getViewObject();
                        RowSetIterator utRSI = unitVo.createRowSetIterator(null);
                        //unit catg not selected all t
                        if(unitCatg.equals("")){
                        ViewCriteria vc = unitVo.createViewCriteria();
                        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                        vcRow.setAttribute("BuildId", buildId);
                        vc.addRow(vcRow);
                        unitVo.applyViewCriteria(vc);
                        unitVo.executeQuery();
                        if(unitVo.getEstimatedRowCount()>0){
                        while (utRSI.hasNext()) {
                            Row r1 = utRSI.next();
                            r1.setAttribute("Attribute2", unitInChrg);
                        }
                         utRSI.closeRowSetIterator();
                     }
                        } 
                        //unit catg selected
                        if(!unitCatg.equals("")){
                        ViewCriteria vc = unitVo.createViewCriteria();
                        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                        vcRow.setAttribute("BuildId", buildId);
                        vcRow.setAttribute("UnitCategory", unitCatg);
                        vc.addRow(vcRow);
                        unitVo.applyViewCriteria(vc);
                        unitVo.executeQuery();
                        if(unitVo.getEstimatedRowCount()>0){
                        while (utRSI.hasNext()) {
                            Row r1 = utRSI.next();
                            r1.setAttribute("Attribute2", unitInChrg);
                        }
                         utRSI.closeRowSetIterator();
                     }
                        }
                    }
            }
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setPgl1(RichPanelGridLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGridLayout getPgl1() {
        return pgl1;
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


    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSi2(UISelectItems si2) {
        this.si2 = si2;
    }

    public UISelectItems getSi2() {
        return si2;
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSi3(UISelectItems si3) {
        this.si3 = si3;
    }

    public UISelectItems getSi3() {
        return si3;
    }

    public void setIt8(RichInputText it8) {
        this.it8 = it8;
    }

    public RichInputText getIt8() {
        return it8;
    }

    public void setIt9(RichInputText it9) {
        this.it9 = it9;
    }

    public RichInputText getIt9() {
        return it9;
    }

    public void setIt10(RichInputText it10) {
        this.it10 = it10;
    }

    public RichInputText getIt10() {
        return it10;
    }

    public void setIt11(RichInputText it11) {
        this.it11 = it11;
    }

    public RichInputText getIt11() {
        return it11;
    }

    public void setIt12(RichInputText it12) {
        this.it12 = it12;
    }

    public RichInputText getIt12() {
        return it12;
    }

    public void setIt13(RichInputText it13) {
        this.it13 = it13;
    }

    public RichInputText getIt13() {
        return it13;
    }

    public void setIt14(RichInputText it14) {
        this.it14 = it14;
    }

    public RichInputText getIt14() {
        return it14;
    }

    public void setIt15(RichInputText it15) {
        this.it15 = it15;
    }

    public RichInputText getIt15() {
        return it15;
    }

    public void setIt16(RichInputText it16) {
        this.it16 = it16;
    }

    public RichInputText getIt16() {
        return it16;
    }

    public void setIt17(RichInputText it17) {
        this.it17 = it17;
    }

    public RichInputText getIt17() {
        return it17;
    }

    public void setIt18(RichInputText it18) {
        this.it18 = it18;
    }

    public RichInputText getIt18() {
        return it18;
    }

    public void setIt19(RichInputText it19) {
        this.it19 = it19;
    }

    public RichInputText getIt19() {
        return it19;
    }

    public void setIt20(RichInputText it20) {
        this.it20 = it20;
    }

    public RichInputText getIt20() {
        return it20;
    }

    public void setIt21(RichInputText it21) {
        this.it21 = it21;
    }

    public RichInputText getIt21() {
        return it21;
    }

    public void setIt22(RichInputText it22) {
        this.it22 = it22;
    }

    public RichInputText getIt22() {
        return it22;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setIt23(RichInputText it23) {
        this.it23 = it23;
    }

    public RichInputText getIt23() {
        return it23;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setIt24(RichInputText it24) {
        this.it24 = it24;
    }

    public RichInputText getIt24() {
        return it24;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }

    public void setPb2(RichPanelBox pb2) {
        this.pb2 = pb2;
    }

    public RichPanelBox getPb2() {
        return pb2;
    }

    public void setPb3(RichPanelBox pb3) {
        this.pb3 = pb3;
    }

    public RichPanelBox getPb3() {
        return pb3;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setPfl4(RichPanelFormLayout pfl4) {
        this.pfl4 = pfl4;
    }

    public RichPanelFormLayout getPfl4() {
        return pfl4;
    }

    public void setPgl5(RichPanelGroupLayout pgl5) {
        this.pgl5 = pgl5;
    }

    public RichPanelGroupLayout getPgl5() {
        return pgl5;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setPt2(RichPanelTabbed pt2) {
        this.pt2 = pt2;
    }

    public RichPanelTabbed getPt2() {
        return pt2;
    }

    public void setTab1(RichShowDetailItem tab1) {
        this.tab1 = tab1;
    }

    public RichShowDetailItem getTab1() {
        return tab1;
    }

    public void setTab2(RichShowDetailItem tab2) {
        this.tab2 = tab2;
    }

    public RichShowDetailItem getTab2() {
        return tab2;
    }

    public void setTab3(RichShowDetailItem tab3) {
        this.tab3 = tab3;
    }

    public RichShowDetailItem getTab3() {
        return tab3;
    }

    public void setPb4(RichPanelBox pb4) {
        this.pb4 = pb4;
    }

    public RichPanelBox getPb4() {
        return pb4;
    }

    public void setPb5(RichPanelBox pb5) {
        this.pb5 = pb5;
    }

    public RichPanelBox getPb5() {
        return pb5;
    }

    public void setPb6(RichPanelBox pb6) {
        this.pb6 = pb6;
    }

    public RichPanelBox getPb6() {
        return pb6;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setPc2(RichPanelCollection pc2) {
        this.pc2 = pc2;
    }

    public RichPanelCollection getPc2() {
        return pc2;
    }

    public void setPc3(RichPanelCollection pc3) {
        this.pc3 = pc3;
    }

    public RichPanelCollection getPc3() {
        return pc3;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setS5(RichSpacer s5) {
        this.s5 = s5;
    }

    public RichSpacer getS5() {
        return s5;
    }

    public void setT3(RichToolbar t3) {
        this.t3 = t3;
    }

    public RichToolbar getT3() {
        return t3;
    }

    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
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

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setT4(RichToolbar t4) {
        this.t4 = t4;
    }

    public RichToolbar getT4() {
        return t4;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public void setCb5(RichCommandButton cb5) {
        this.cb5 = cb5;
    }

    public RichCommandButton getCb5() {
        return cb5;
    }

    public String onClickReturn() {

        String scopeVal = null;
        Object Val =
            ADFContext.getCurrent().getPageFlowScope().get("SUBEditBuildId") ==
            null ? "" :
            ADFContext.getCurrent().getPageFlowScope().get("SUBEditBuildId").toString();

        if (Val.equals("SUBTABBUILDING")) {
            scopeVal = "returntoProperty";
        } else {
            scopeVal = "back";
        }

        return scopeVal;
    }

    public void setCb6(RichCommandButton cb6) {
        this.cb6 = cb6;
    }

    public RichCommandButton getCb6() {
        return cb6;
    }

    public void onClickAttachments(ActionEvent actionEvent) {
        JSFUtils.setExpressionValue("#{pageFlowScope.bufuncId}", 1);
        JSFUtils.setExpressionValue("#{pageFlowScope.buId}",
                                    JSFUtils.resolveExpression("#{bindings.BuildId.inputValue}"));
    }

    public void setPropertyTransId(RichInputComboboxListOfValues propertyTransId) {
        this.propertyTransId = propertyTransId;
    }

    public RichInputComboboxListOfValues getPropertyTransId() {
        return propertyTransId;
    }

    public void setPgl6(RichPanelGroupLayout pgl6) {
        this.pgl6 = pgl6;
    }

    public RichPanelGroupLayout getPgl6() {
        return pgl6;
    }

    public void setPgl7(RichPanelGroupLayout pgl7) {
        this.pgl7 = pgl7;
    }

    public RichPanelGroupLayout getPgl7() {
        return pgl7;
    }

    public void setSpacer1(RichSpacer spacer1) {
        this.spacer1 = spacer1;
    }

    public RichSpacer getSpacer1() {
        return spacer1;
    }

    public void setPb7(RichPanelBox pb7) {
        this.pb7 = pb7;
    }

    public RichPanelBox getPb7() {
        return pb7;
    }

    public void setPfl5(RichPanelFormLayout pfl5) {
        this.pfl5 = pfl5;
    }

    public RichPanelFormLayout getPfl5() {
        return pfl5;
    }

    public void setIt32(RichInputText it32) {
        this.it32 = it32;
    }

    public RichInputText getIt32() {
        return it32;
    }

    public void setIt33(RichInputText it33) {
        this.it33 = it33;
    }

    public RichInputText getIt33() {
        return it33;
    }

    public void setIt34(RichInputText it34) {
        this.it34 = it34;
    }

    public RichInputText getIt34() {
        return it34;
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void setIt35(RichInputText it35) {
        this.it35 = it35;
    }

    public RichInputText getIt35() {
        return it35;
    }

    public void setSpacer2(RichSpacer spacer2) {
        this.spacer2 = spacer2;
    }

    public RichSpacer getSpacer2() {
        return spacer2;
    }

    public void setSdi1(RichShowDetailItem sdi1) {
        this.sdi1 = sdi1;
    }

    public RichShowDetailItem getSdi1() {
        return sdi1;
    }


    public void setPc4(RichPanelCollection pc4) {
        this.pc4 = pc4;
    }

    public RichPanelCollection getPc4() {
        return pc4;
    }

    public void setPb8(RichPanelBox pb8) {
        this.pb8 = pb8;
    }

    public RichPanelBox getPb8() {
        return pb8;
    }

    public void setT6(RichToolbar t6) {
        this.t6 = t6;
    }

    public RichToolbar getT6() {
        return t6;
    }

    public void setCil3(RichCommandImageLink cil3) {
        this.cil3 = cil3;
    }

    public RichCommandImageLink getCil3() {
        return cil3;
    }

    public void setCil4(RichCommandImageLink cil4) {
        this.cil4 = cil4;
    }

    public RichCommandImageLink getCil4() {
        return cil4;
    }

    public void setS6(RichSpacer s6) {
        this.s6 = s6;
    }

    public RichSpacer getS6() {
        return s6;
    }

    public void setT7(RichTable t7) {
        this.t7 = t7;
    }

    public RichTable getT7() {
        return t7;
    }

    public void onClickAddVendor(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject Property =
            ADFUtils.findIterator("PropertyBuildings_VO1Iterator").getViewObject();
        ADFContext.getCurrent().getPageFlowScope().put("pValue", "PB");
        ADFContext.getCurrent().getPageFlowScope().put("pId", Property.getCurrentRow().getAttribute("PropertyId"));
        ADFUtils.findOperation("CreateInsert1").execute();
        
    }

    public void setCil5(RichCommandImageLink cil5) {
        this.cil5 = cil5;
    }

    public RichCommandImageLink getCil5() {
        return cil5;
    }

    public void setS7(RichSpacer s7) {
        this.s7 = s7;
    }

    public RichSpacer getS7() {
        return s7;
    }

    public void setSoc8(RichSelectOneChoice soc8) {
        this.soc8 = soc8;
    }

    public RichSelectOneChoice getSoc8() {
        return soc8;
    }

    public void setSi8(UISelectItems si8) {
        this.si8 = si8;
    }

    public UISelectItems getSi8() {
        return si8;
    }

    public void setSoc9(RichSelectOneChoice soc9) {
        this.soc9 = soc9;
    }

    public RichSelectOneChoice getSoc9() {
        return soc9;
    }

    public void setSi9(UISelectItems si9) {
        this.si9 = si9;
    }

    public UISelectItems getSi9() {
        return si9;
    }

    public void setCb7(RichCommandButton cb7) {
        this.cb7 = cb7;
    }

    public RichCommandButton getCb7() {
        return cb7;
    }
}
