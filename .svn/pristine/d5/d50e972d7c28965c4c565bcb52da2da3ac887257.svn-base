package view.backing.fragments;

import java.math.BigDecimal;

import java.sql.SQLException;

import javax.faces.component.UISelectItems;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;


import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.component.UIXGroup;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditMilestones {
    private RichPageTemplate pt1;
    private RichPanelBox pb1;
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichInputDate id1;
    private RichInputText it6;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichSelectOneChoice soc2;
    private UISelectItems si2;
    private RichInputText it7;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private UIXGroup g1;
    private RichPanelFormLayout pfl2;
    private RichInputText it8;
    private RichInputText it9;
    private RichInputText it10;
    private RichInputText it11;
    private RichInputText it12;
    private RichInputDate id2;
    private RichInputText it13;
    private RichSelectOneChoice soc4;
    private UISelectItems si4;
    private RichSelectOneChoice soc5;
    private UISelectItems si5;
    private RichInputText it14;
    private RichInputText it16;
    private RichSelectOneChoice soc6;
    private UISelectItems si6;
    private RichPanelBox pb2;
    private RichTable t1;
    private RichPanelCollection pc1;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichCommandButton cb2;
    private RichToolbar t2;
    private RichCommandImageLink cil1;
    private RichCommandImageLink cil2;
    private RichCommandButton cb4;
    private RichPanelGroupLayout pgl2;
    private RichSpacer s3;
    private RichSpacer s5;
    private RichSpacer s4;
    private RichCommandButton cb3;
    private RichCommandButton cb5;
    private RichCommandButton cb6;
    private RichCommandButton cb7;
    private RichCommandImageLink cil3;
    private RichInputComboboxListOfValues orgnameTransId;
    private RichSelectBooleanCheckbox sbc1;
    private RichPopup popup3;
    private RichPopup p2;

    ViewObject Property =
        ADFUtils.findIterator("MilestonesHdr_VO1Iterator").getViewObject();
    Row re = Property.getCurrentRow();
    private RichCommandButton cb1;
    private RichPopup p5;
    private RichDialog d3;
    private RichTable t3;

    public void setPt1(RichPageTemplate pt1) {
        this.pt1 = pt1;
    }

    public RichPageTemplate getPt1() {
        return pt1;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
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
    public void setIt16(RichInputText it16) {
        this.it16 = it16;
    }
    

    public RichInputText getIt16() {
        return it16;
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

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
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

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
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

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setIt13(RichInputText it13) {
        this.it13 = it13;
    }

    public RichInputText getIt13() {
        return it13;
    }

    public void setSoc4(RichSelectOneChoice soc4) {
        this.soc4 = soc4;
    }

    public RichSelectOneChoice getSoc4() {
        return soc4;
    }

    public void setSi4(UISelectItems si4) {
        this.si4 = si4;
    }

    public UISelectItems getSi4() {
        return si4;
    }

    public void setSoc5(RichSelectOneChoice soc5) {
        this.soc5 = soc5;
    }

    public RichSelectOneChoice getSoc5() {
        return soc5;
    }

    public void setSi5(UISelectItems si5) {
        this.si5 = si5;
    }

    public UISelectItems getSi5() {
        return si5;
    }

    public void setIt14(RichInputText it14) {
        this.it14 = it14;
    }

    public RichInputText getIt14() {
        return it14;
    }

    public void setSoc6(RichSelectOneChoice soc6) {
        this.soc6 = soc6;
    }

    public RichSelectOneChoice getSoc6() {
        return soc6;
    }

    public void setSi6(UISelectItems si6) {
        this.si6 = si6;
    }

    public UISelectItems getSi6() {
        return si6;
    }

    public void setPb2(RichPanelBox pb2) {
        this.pb2 = pb2;
    }

    public RichPanelBox getPb2() {
        return pb2;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
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


    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
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

    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
    }


    public String onClickSubmit() {
        String result = "";
        ViewObject MiestonesDtlVo =
            ADFUtils.findIterator("MilestonesDtl_VO1Iterator").getViewObject();
        RowSetIterator rs = MiestonesDtlVo.createRowSetIterator("");
        
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding parentIter = (DCIteratorBinding)bindings.get("MilestonesHdr_VO1Iterator");

        
        BigDecimal Total = new BigDecimal(0);
        while (rs.hasNext()) {
            Row r = rs.next();
            BigDecimal InstallPCt =
                new BigDecimal(r.getAttribute("InstallmentPct").toString());

            Total = Total.add(InstallPCt);

        }
        int n = Total.compareTo(new BigDecimal(100));

        if (n < 0) {

            JSFUtils.addFacesErrorMessage("Installment Percentage Should be 100");

            result = "no";


        } else {
            //            ViewObject MilestonesVo=ADFUtils.findIterator("MilestonesHdr_VO1Iterator").getViewObject();
            //            Row MilestonesRow=MilestonesVo.getCurrentRow();
            //            MilestonesRow.setAttribute("Status", "SM");
            //            ADFUtils.findOperation("Commit").execute();
            //            JSFUtils.addFacesInformationMessage("Submitted Successfully...!");

            String ResultVal = null;
            ViewObject vo =
                ADFUtils.findIterator("MilestonesHdr_VO1Iterator").getViewObject();
            Row row = vo.getCurrentRow();
            Object org = vo.getCurrentRow().getAttribute("OrgId");
            try {
                ResultVal =
                        xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
                                                  row.getAttribute("FuncId"),
                                              row.getAttribute("MsHdrId"), 0,
                                              "XXPL_MILESTONES_HDR", "STATUS",
                                              "MS_HDR_ID", org, null, null,
                                              null, null);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (ResultVal.equalsIgnoreCase("Success")) {
                Key parentKey = parentIter.getCurrentRow().getKey();            
                ADFUtils.findOperation("Commit").execute();
                parentIter.executeQuery();
                parentIter.setCurrentRowWithKey(parentKey.toStringFormat(true));
                JSFUtils.addFacesInformationMessage("Submitted For Approval");
            } else {
                JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
            }

            result = "back";

        }


        return result;

    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }


    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }


    public void setS5(RichSpacer s5) {
        this.s5 = s5;
    }

    public RichSpacer getS5() {
        return s5;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setCb5(RichCommandButton cb5) {
        this.cb5 = cb5;
    }

    public RichCommandButton getCb5() {
        return cb5;
    }
    String ress = "Y";

    public void onClockSave(ActionEvent actionEvent) {

        if (re.getAttribute("MilestoneName") != null &&
            re.getAttribute("MilestoneShortcode") != null &&
            re.getAttribute("orgnameTrans") != null &&
            re.getAttribute("MilestoneDate") != null) {

            ViewObject getFuncodeVo =
                ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
            getFuncodeVo.setNamedWhereClauseParam("F_ID", "MS");
            getFuncodeVo.executeQuery();
            Object Funcode = getFuncodeVo.first().getAttribute("FuncId");

            if (re.getAttribute("MilestoneNumber") == null) {
                String name =
                    xxfnd.generateDocNo("MS", "Milestones_AMDataControl").toString();
                Object valu = name;

                re.setAttribute("MilestoneNumber", valu);
                re.setAttribute("FuncId",
                                getFuncodeVo.first().getAttribute("FuncId"));

            }
            Property.executeQuery();
            OperationBinding binding =
                (OperationBinding)ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Saved Successfully");

        } else {
            ress = "N";
            if (re.getAttribute("MilestoneName") == null) {
                JSFUtils.addFacesErrorMessage("You must enter a Payment plan Name");
            }
            if (re.getAttribute("MilestoneShortcode") == null) {
                JSFUtils.addFacesErrorMessage("You must enter a Payment plan Short code");
            }
            if (re.getAttribute("orgnameTrans") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Business Unit");
            }
            if (re.getAttribute("MilestoneDate") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Payment plan Date");
            }


        }

    }

    public String OnClickPageClose() {
        if (ress == "Y") {
            return "back";
        }
        return null;
    }

    public void onclickSubmit(ActionEvent actionEvent) {
        // Add event code here...
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("MilestonesHdr_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        Object org = vo.getCurrentRow().getAttribute("OrgId");


        try {
            ResultVal =
                    xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
                                          row.getAttribute("FuncId"),
                                          row.getAttribute("MsHdrId"), 0,
                                          "XXPL_MILESTONES_HDR", "STATUS",
                                          "MS_HDR_ID", org, null, null, null,
                                          null);


        } catch (SQLException e) {
        }

        if (ResultVal.equalsIgnoreCase("Success")) {
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Submitted For Approval");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
        }
    }

    public void onClickApprove(ActionEvent actionEvent) {
        // Add event code here...
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("MilestonesHdr_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();


        try {
            ResultVal =
                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
                                            row.getAttribute("FuncId"),
                                            row.getAttribute("MsHdrId"),
                                            row.getAttribute("UserGrpId"),
                                            row.getAttribute("FlowLevel"),
                                            row.getAttribute("FlowWith"),
                                            "Approved", "A", 0,
                                            "XXPL_MILESTONES_HDR", "STATUS",
                                            "MS_HDR_ID");


        } catch (SQLException e) {
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            vo.executeQuery();
            JSFUtils.addFacesInformationMessage("Approved....");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Approve process!");
        }

    }

    public void OnClickReject(ActionEvent actionEvent) {
        // Add event code here...
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("MilestonesHdr_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();


        try {
            ResultVal =
                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
                                            row.getAttribute("FuncId"),
                                            row.getAttribute("MsHdrId"),
                                            row.getAttribute("UserGrpId"),
                                            row.getAttribute("FlowLevel"),
                                            row.getAttribute("FlowWith"),
                                            "Rejected", "R", 0,
                                            "XXPL_MILESTONES_HDR", "STATUS",
                                            "MS_HDR_ID");


        } catch (SQLException e) {
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            vo.executeQuery();
            JSFUtils.addFacesInformationMessage("Rejected....");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Approve process!");
        }

    }

    public void setCb6(RichCommandButton cb6) {
        this.cb6 = cb6;
    }

    public RichCommandButton getCb6() {
        return cb6;
    }

    public void setCb7(RichCommandButton cb7) {
        this.cb7 = cb7;
    }

    public RichCommandButton getCb7() {
        return cb7;
    }


    public void setCil3(RichCommandImageLink cil3) {
        this.cil3 = cil3;
    }

    public RichCommandImageLink getCil3() {
        return cil3;
    }

    public void setOrgnameTransId(RichInputComboboxListOfValues orgnameTransId) {
        this.orgnameTransId = orgnameTransId;
    }

    public RichInputComboboxListOfValues getOrgnameTransId() {
        return orgnameTransId;
    }

    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }

    public void onclickAppOrRej(ActionEvent actionEvent) {
        // Add event code here...
        Object val =
            ADFContext.getCurrent().getPageFlowScope().get("Action") == null ?
            "" :
            ADFContext.getCurrent().getPageFlowScope().get("Action").toString();

        if (val.equals("Approval")) {
            onClickApprove(actionEvent);
        }


        if (val.equals("Rejection")) {
            OnClickReject(actionEvent);
        }


    }

    public void onInvokeAppOrrejec(ActionEvent actionEvent) {
        // Add event code here...
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup3().show(popup34);
    }

    public void setPopup3(RichPopup popup3) {
        this.popup3 = popup3;
    }

    public RichPopup getPopup3() {
        return popup3;
    }
    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public void onClickApproveOrREej(ActionEvent actionEvent) {
        // Add event code here...
        Object val =
            ADFContext.getCurrent().getPageFlowScope().get("Action") == null ?
            "" :
            ADFContext.getCurrent().getPageFlowScope().get("Action").toString();

        if (val.equals("Approval")) {
            onClickApprove(actionEvent);
        }


        if (val.equals("Rejection")) {
            OnClickReject(actionEvent);
        }
        
    }
    
    public boolean getApprovalUser() {
        ViewObject msHdr =
            ADFUtils.findIterator("MilestonesHdr_VO1Iterator").getViewObject();
        boolean flag = false;
        String flowWith =
            msHdr.getCurrentRow().getAttribute("FlowWith") == null ?
            null :
            msHdr.getCurrentRow().getAttribute("FlowWith").toString();
        System.err.println("==flow With=="+flowWith);
        String LoginUserId =
            ADFContext.getCurrent().getSessionScope().get("userId") == null ?
            null :
            ADFContext.getCurrent().getSessionScope().get("userId").toString();
        System.err.println("==Login UserId=="+LoginUserId);

        if (flowWith != null && LoginUserId != null) {
            if (flowWith.equalsIgnoreCase(LoginUserId)) {
                flag = true;
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setP5(RichPopup popup1) {
        this.p5 = popup1;
    }

    public RichPopup getP5() {
        return p5;
    }

    public void setD3(RichDialog d3) {
        this.d3 = d3;
    }

    public RichDialog getD3() {
        return d3;
    }


    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }
}
