package view.backing.fragments;

import com.sun.faces.context.FacesContextImpl;

import java.util.List;

import javax.faces.component.UISelectItems;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
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
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.model.AutoSuggestUIHints;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditVisitorLog {
    private RichPageTemplate pt1;
    private RichPanelStretchLayout psl1;
    private RichPanelBox pb1;
    private RichPanelGroupLayout pgl1;
    private RichPanelBox pb2;
    private RichPanelBox pb3;
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputDate id1;
    private RichSelectOneChoice soc2;
    private UISelectItems si2;
    private RichInputText it4;
    private RichInputText it5;
    private RichInputText it6;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichSelectBooleanCheckbox sbc1;
    private RichSelectOneChoice soc4;
    private UISelectItems si4;
    private RichInputText it7;
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
    private RichInputText it23;
    private RichInputText it24;
    private RichInputText it25;
    private RichInputText it26;
    private RichInputText it27;
    private RichInputText it28;
    private RichInputText it29;
    private RichInputText it30;
    private RichInputText it31;
    private RichInputText it32;
    private RichInputDate id2;
    private RichSelectOneChoice soc5;
    private UISelectItems si5;
    private RichInputText it33;
    private RichInputDate id3;
    private RichInputText it45;
    private RichPanelFormLayout pfl2;
    private RichPanelFormLayout pfl4;
    private RichSpacer s8;
    private RichPopup p1;
    private RichPanelFormLayout pfl3;
    private RichPanelFormLayout pfl5;
    private RichSpacer s9;
    private RichPanelGridLayout pgl3;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichToolbar t1;
    private RichCommandButton cb3;
    private RichSelectOneChoice soc6;
    private UISelectItems si6;
    private RichSelectOneChoice soc7;
    private UISelectItems si7;
    private RichSelectOneChoice soc8;
    private UISelectItems si8;
    private RichSelectBooleanCheckbox sbc2;
    private RichPanelFormLayout pfl6;
    private RichInputText it34;
    private UISelectItems si9;
    private RichInputComboboxListOfValues permenentCountryTransId;
    private RichInputComboboxListOfValues nationalityTransId;
    private RichInputComboboxListOfValues orgNameTransId;
    private RichInputComboboxListOfValues residenceTransId;
    private RichInputComboboxListOfValues curCountry_TransId;
    private RichPanelGroupLayout pgl4;
    private RichInputText it35;
    private RichInputText it36;
    private RichInputText it37;
    private RichInputText it38;
    private RichOutputText ot2;
    private RichOutputText ot4;
    private RichOutputText ot5;
    private RichPanelGridLayout pgl5;
    private RichGridRow gr2;
    private RichGridCell gc3;
    private RichGridCell gc4;
    private RichPanelGridLayout pgl6;
    private RichGridRow gr3;
    private RichGridCell gc5;
    private RichGridCell gc6;
    private RichGridRow gr4;
    private RichGridCell gc7;
    private RichGridCell gc8;
    private RichGridRow gr5;
    private RichGridCell gc9;
    private RichGridCell gc10;
    private RichOutputText ot6;
    private RichPanelGridLayout pgl7;
    private RichGridRow gr6;
    private RichGridCell gc11;
    private RichGridCell gc12;
    private RichGridRow gr7;
    private RichGridCell gc13;
    private RichGridCell gc14;
    private RichGridRow gr8;
    private RichGridCell gc15;
    private RichGridCell gc16;
    private RichPanelGroupLayout pgl8;
    private RichOutputText ot8;
    private RichOutputText ot9;
    private RichOutputText ot10;
    private RichOutputText ot11;
    private RichOutputText ot12;
    private RichSpacer s1;
    private RichSpacer s3;
    private RichInputText it39;
    private RichInputText it40;
    private RichInputDate id4;
    private RichPanelFormLayout pfl7;
    private RichInputText it41;
    private RichInputText it42;
    private RichInputDate id5;
    private RichInputDate id6;
    private RichInputText it43;
    private RichInputText it44;
    private RichInputText it46;
    private RichInputText it47;
    private RichInputText it48;
    private RichInputText it49;
    private RichCommandButton cb6;

    public void setPt1(RichPageTemplate pt1) {
        this.pt1 = pt1;
    }

    public RichPageTemplate getPt1() {
        return pt1;
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
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

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
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

    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
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

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
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

    public void setIt23(RichInputText it23) {
        this.it23 = it23;
    }

    public RichInputText getIt23() {
        return it23;
    }

    public void setIt24(RichInputText it24) {
        this.it24 = it24;
    }

    public RichInputText getIt24() {
        return it24;
    }

    public void setIt25(RichInputText it25) {
        this.it25 = it25;
    }

    public RichInputText getIt25() {
        return it25;
    }

    public void setIt26(RichInputText it26) {
        this.it26 = it26;
    }

    public RichInputText getIt26() {
        return it26;
    }

    public void setIt27(RichInputText it27) {
        this.it27 = it27;
    }

    public RichInputText getIt27() {
        return it27;
    }

    public void setIt28(RichInputText it28) {
        this.it28 = it28;
    }

    public RichInputText getIt28() {
        return it28;
    }

    public void setIt29(RichInputText it29) {
        this.it29 = it29;
    }

    public RichInputText getIt29() {
        return it29;
    }

    public void setIt30(RichInputText it30) {
        this.it30 = it30;
    }

    public RichInputText getIt30() {
        return it30;
    }

    public void setIt31(RichInputText it31) {
        this.it31 = it31;
    }

    public RichInputText getIt31() {
        return it31;
    }

    public void setIt32(RichInputText it32) {
        this.it32 = it32;
    }

    public RichInputText getIt32() {
        return it32;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
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

    public void setIt33(RichInputText it33) {
        this.it33 = it33;
    }

    public RichInputText getIt33() {
        return it33;
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }


    public void setIt45(RichInputText it45) {
        this.it45 = it45;
    }

    public RichInputText getIt45() {
        return it45;
    }


    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }


    public void setPfl4(RichPanelFormLayout pfl4) {
        this.pfl4 = pfl4;
    }

    public RichPanelFormLayout getPfl4() {
        return pfl4;
    }

    public void setS8(RichSpacer s8) {
        this.s8 = s8;
    }

    public RichSpacer getS8() {
        return s8;
    }

    ViewObject leadVO =
        ADFUtils.findIterator("LeadVO1Iterator").getViewObject();
    Row rows = leadVO.getCurrentRow();
    String ress = "Y";

    public void onClickSaveLead(ActionEvent actionEvent) {
        //        if(ADFContext.getCurrent().getSessionScope().get("addEditLead").toString().equalsIgnoreCase("Edit")){

        Object session = null;
        session =
                JSFUtils.resolveExpression("#{sessionScope.resultVal}").toString();
        if (session.equals("EditLead")) {

            if (rows.getAttribute("OrgId") != null &&
                rows.getAttribute("LeadName") != null &&
                rows.getAttribute("EmailId") != null &&
                rows.getAttribute("MobileNumber") != null ){
//                rows.getAttribute("EmiratesIdRef1") != null &&
//                rows.getAttribute("EmiratesIdRef2") != null &&
//                rows.getAttribute("EmiratesIdRef3") != null &&
//                rows.getAttribute("EmiratesIdRef4") != null) {

                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Lead Information Saved Successfully");

            } else {
                ress = "N";
                if (rows.getAttribute("OrgId") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Business Unit");
                }
                if (rows.getAttribute("LeadName") == null) {
                    JSFUtils.addFacesErrorMessage("You must enter a Lead Name");
                }
                if (rows.getAttribute("EmailId") == null) {
                    JSFUtils.addFacesErrorMessage("You must enter a Email Id");
                }
                if (rows.getAttribute("MobileNumber") == null) {
                    JSFUtils.addFacesErrorMessage("You must enter a Mobile Number");
                }
//                if (rows.getAttribute("EmiratesIdRef1") == null &&
//                    rows.getAttribute("EmiratesIdRef2") == null &&
//                    rows.getAttribute("EmiratesIdRef3") == null &&
//                    rows.getAttribute("EmiratesIdRef4") == null) {
//                    JSFUtils.addFacesErrorMessage("You must enter a valid Emirates Id (eg:784-1988-5904810-4)");
//                }
                //                if (rows.getAttribute("ResidentId") == null) {
                //                    JSFUtils.addFacesErrorMessage("You must enter a Emirate ID");
                //                }

            }

        } else {

                if (rows.getAttribute("OrgId") != null &&
                    rows.getAttribute("LeadName") != null &&
                    rows.getAttribute("EmailId") != null &&
                    rows.getAttribute("MobileNumber") != null){
//                    rows.getAttribute("EmiratesIdRef1") != null &&
//                    rows.getAttribute("EmiratesIdRef2") != null &&
//                    rows.getAttribute("EmiratesIdRef3") != null &&
//                    rows.getAttribute("EmiratesIdRef4") != null) {

                // leadVO.getCurrentRow().setAttribute("LeadNumber",
                // "LEAD-" + leadVO.getCurrentRow().getAttribute("LeadId"));

                ViewObject getFuncodeVo =
                    ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                getFuncodeVo.setNamedWhereClauseParam("F_ID", "LD");
                getFuncodeVo.executeQuery();
                Object Funcode = getFuncodeVo.first().getAttribute("FuncId");
                String Fcode = Funcode == null ? "" : Funcode.toString();

                if (leadVO.getCurrentRow().getAttribute("LeadNumber") ==
                    null) {
                    String name =
                        xxfnd.generateDocNo("LD", "LeadAppModuleDataControl").toString();
                    Object valu = name;

                    leadVO.getCurrentRow().setAttribute("LeadNumber", valu);
                    leadVO.getCurrentRow().setAttribute("FuncId",
                                                        getFuncodeVo.first().getAttribute("FuncId"));

                }


                ADFUtils.findOperation("Commit").execute();
                JSFUtils.numberFaceMessage("Lead",
                                           leadVO.getCurrentRow().getAttribute("LeadNumber"));
            } else {
                ress = "N";
                if (rows.getAttribute("OrgId") == null) {
                    JSFUtils.addFacesErrorMessage("You must select a Business Unit");
                }
                if (rows.getAttribute("LeadName") == null) {
                    JSFUtils.addFacesErrorMessage("You must enter a Lead Name");
                }
                if (rows.getAttribute("EmailId") == null) {
                    JSFUtils.addFacesErrorMessage("You must enter a Email Id");
                }
                if (rows.getAttribute("MobileNumber") == null) {
                    JSFUtils.addFacesErrorMessage("You must enter a Mobile Number");
                }
//                if (rows.getAttribute("EmiratesIdRef1") == null &&
//                    rows.getAttribute("EmiratesIdRef2") == null &&
//                    rows.getAttribute("EmiratesIdRef3") == null &&
//                    rows.getAttribute("EmiratesIdRef4") == null) {
//                    JSFUtils.addFacesErrorMessage("You must enter a valid Emirates Id (eg:784-1988-5904810-4)");
//                }
                //                if (rows.getAttribute("ResidentId") == null) {
                //                    JSFUtils.addFacesErrorMessage("You must enter a Emirate ID");
                //                }

            }
        }
    }

    public String OnClickPageClose() {
        if (ress == "Y") {
            return "goBack";
        }
        return null;
    }

    public void onClickLeadPopCancel(ActionEvent actionEvent) {
        this.getP1().cancel();
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }

    public void setPfl5(RichPanelFormLayout pfl5) {
        this.pfl5 = pfl5;
    }

    public RichPanelFormLayout getPfl5() {
        return pfl5;
    }

    public void setS9(RichSpacer s9) {
        this.s9 = s9;
    }

    public RichSpacer getS9() {
        return s9;
    }

    public void onChangeFname(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            it6.setValue(valueChangeEvent.getNewValue());
            AdfFacesContext.getCurrentInstance().addPartialTarget(it6);
        }
    }

    public void onChangeLname(ValueChangeEvent valueChangeEvent) {
        // Check vcl not null
        if (valueChangeEvent.getNewValue() != null) {
            // check First name not null
            if (it4.getValue() != null) {
                String fname = it4.getValue().toString();
                String lname = valueChangeEvent.getNewValue().toString();
                String name = fname.concat(" " + lname);
                it6.setValue(name);
                AdfFacesContext.getCurrentInstance().addPartialTarget(it6);

            }
        }
    }

    public void setPgl3(RichPanelGridLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGridLayout getPgl3() {
        return pgl3;
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


    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
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

    public void setSoc7(RichSelectOneChoice soc7) {
        this.soc7 = soc7;
    }

    public RichSelectOneChoice getSoc7() {
        return soc7;
    }

    public void setSi7(UISelectItems si7) {
        this.si7 = si7;
    }

    public UISelectItems getSi7() {
        return si7;
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

    public void setSbc2(RichSelectBooleanCheckbox sbc2) {
        this.sbc2 = sbc2;
    }

    public RichSelectBooleanCheckbox getSbc2() {
        return sbc2;
    }

    public void setPfl6(RichPanelFormLayout pfl6) {
        this.pfl6 = pfl6;
    }

    public RichPanelFormLayout getPfl6() {
        return pfl6;
    }

    public void onChangeActivePR(ValueChangeEvent valueChangeEvent) {
        //        System.err.println("NEW VAL" + valueChangeEvent.getNewValue());
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject visitorVO =
            ADFUtils.findIterator("LeadVO1Iterator").getViewObject();
        if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("true")) {
            //            System.err.println("YES");
            visitorVO.getCurrentRow().setAttribute("CurAddress1",
                                                   visitorVO.getCurrentRow().getAttribute("PerAddress1"));
            visitorVO.getCurrentRow().setAttribute("CurAddress2",
                                                   visitorVO.getCurrentRow().getAttribute("PerAddress2"));
            visitorVO.getCurrentRow().setAttribute("CurAddress3",
                                                   visitorVO.getCurrentRow().getAttribute("PerAddress3"));
            visitorVO.getCurrentRow().setAttribute("CurAddress4",
                                                   visitorVO.getCurrentRow().getAttribute("PerAddress4"));
            visitorVO.getCurrentRow().setAttribute("CurCity",
                                                   visitorVO.getCurrentRow().getAttribute("PerCity"));
            visitorVO.getCurrentRow().setAttribute("CurCountry",
                                                   visitorVO.getCurrentRow().getAttribute("PerCountry"));
//            System.err.println("===PE COUNT==="+ visitorVO.getCurrentRow().getAttribute("permenentCountryTrans"));
            visitorVO.getCurrentRow().setAttribute("CurCountry_Trans",
                                                   visitorVO.getCurrentRow().getAttribute("permenentCountryTrans"));
//            System.err.println("===COUNTRY==="+ visitorVO.getCurrentRow().getAttribute("PerCountry"));
           
            this.it12.setDisabled(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it12);
            this.it13.setDisabled(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it13);
            this.it14.setDisabled(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it14);
            this.it15.setDisabled(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it15);
            this.it16.setDisabled(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it16);
            this.soc8.setDisabled(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(soc8);
            this.permenentCountryTransId.setDisabled(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(permenentCountryTransId);
        } else {
            //            System.err.println("NO");
            visitorVO.getCurrentRow().setAttribute("CurAddress1", null);
            visitorVO.getCurrentRow().setAttribute("CurAddress2", null);
            visitorVO.getCurrentRow().setAttribute("CurAddress3", null);
            visitorVO.getCurrentRow().setAttribute("CurAddress4", null);
            visitorVO.getCurrentRow().setAttribute("CurCity", null);
            visitorVO.getCurrentRow().setAttribute("CurCountry", null);
            visitorVO.getCurrentRow().setAttribute("CurCountry_Trans", null);
            this.it12.setDisabled(Boolean.FALSE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it12);
            this.it13.setDisabled(Boolean.FALSE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it13);
            this.it14.setDisabled(Boolean.FALSE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it14);
            this.it15.setDisabled(Boolean.FALSE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it15);
            this.it16.setDisabled(Boolean.FALSE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it16);
            this.soc8.setDisabled(Boolean.FALSE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(soc8);
            this.permenentCountryTransId.setDisabled(Boolean.FALSE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(permenentCountryTransId);
        }
    }

    public void setIt34(RichInputText it34) {
        this.it34 = it34;
    }

    public RichInputText getIt34() {
        return it34;
    }

    public void setSi9(UISelectItems si9) {
        this.si9 = si9;
    }

    public UISelectItems getSi9() {
        return si9;
    }


    //    public List (FacesContext facesContext,
    //                 AutoSuggestUIHints autoSuggestUIHints) {
    //        // Add event code here...
    //        return null;
    //    }


    public void setPermenentCountryTransId(RichInputComboboxListOfValues permenentCountryTransId) {
        this.permenentCountryTransId = permenentCountryTransId;
    }

    public RichInputComboboxListOfValues getPermenentCountryTransId() {
        return permenentCountryTransId;
    }

    public void setNationalityTransId(RichInputComboboxListOfValues nationalityTransId) {
        this.nationalityTransId = nationalityTransId;
    }

    public RichInputComboboxListOfValues getNationalityTransId() {
        return nationalityTransId;
    }


    public void setOrgNameTransId(RichInputComboboxListOfValues orgNameTransId) {
        this.orgNameTransId = orgNameTransId;
    }

    public RichInputComboboxListOfValues getOrgNameTransId() {
        return orgNameTransId;
    }


    public void setResidenceTransId(RichInputComboboxListOfValues residenceTransId) {
        this.residenceTransId = residenceTransId;
    }

    public RichInputComboboxListOfValues getResidenceTransId() {
        return residenceTransId;
    }

    public void setCurCountry_TransId(RichInputComboboxListOfValues curCountry_TransId) {
        this.curCountry_TransId = curCountry_TransId;
    }

    public RichInputComboboxListOfValues getCurCountry_TransId() {
        return curCountry_TransId;
    }

    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }

    public void setIt35(RichInputText it35) {
        this.it35 = it35;
    }

    public RichInputText getIt35() {
        return it35;
    }

    public void setIt36(RichInputText it36) {
        this.it36 = it36;
    }

    public RichInputText getIt36() {
        return it36;
    }

    public void setIt37(RichInputText it37) {
        this.it37 = it37;
    }

    public RichInputText getIt37() {
        return it37;
    }

    public void setIt38(RichInputText it38) {
        this.it38 = it38;
    }

    public RichInputText getIt38() {
        return it38;
    }

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }

    public void setOt4(RichOutputText ot4) {
        this.ot4 = ot4;
    }

    public RichOutputText getOt4() {
        return ot4;
    }

    public void setOt5(RichOutputText ot5) {
        this.ot5 = ot5;
    }

    public RichOutputText getOt5() {
        return ot5;
    }

    public void setPgl5(RichPanelGridLayout pgl5) {
        this.pgl5 = pgl5;
    }

    public RichPanelGridLayout getPgl5() {
        return pgl5;
    }

    public void setGr2(RichGridRow gr2) {
        this.gr2 = gr2;
    }

    public RichGridRow getGr2() {
        return gr2;
    }

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }

    public void setGc4(RichGridCell gc4) {
        this.gc4 = gc4;
    }

    public RichGridCell getGc4() {
        return gc4;
    }


    public void setPgl6(RichPanelGridLayout pgl6) {
        this.pgl6 = pgl6;
    }

    public RichPanelGridLayout getPgl6() {
        return pgl6;
    }

    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setGc5(RichGridCell gc5) {
        this.gc5 = gc5;
    }

    public RichGridCell getGc5() {
        return gc5;
    }

    public void setGc6(RichGridCell gc6) {
        this.gc6 = gc6;
    }

    public RichGridCell getGc6() {
        return gc6;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridRow getGr4() {
        return gr4;
    }

    public void setGc7(RichGridCell gc7) {
        this.gc7 = gc7;
    }

    public RichGridCell getGc7() {
        return gc7;
    }

    public void setGc8(RichGridCell gc8) {
        this.gc8 = gc8;
    }

    public RichGridCell getGc8() {
        return gc8;
    }

    public void setGr5(RichGridRow gr5) {
        this.gr5 = gr5;
    }

    public RichGridRow getGr5() {
        return gr5;
    }

    public void setGc9(RichGridCell gc9) {
        this.gc9 = gc9;
    }

    public RichGridCell getGc9() {
        return gc9;
    }

    public void setGc10(RichGridCell gc10) {
        this.gc10 = gc10;
    }

    public RichGridCell getGc10() {
        return gc10;
    }

    public void setOt6(RichOutputText ot6) {
        this.ot6 = ot6;
    }

    public RichOutputText getOt6() {
        return ot6;
    }

    public void setPgl7(RichPanelGridLayout pgl7) {
        this.pgl7 = pgl7;
    }

    public RichPanelGridLayout getPgl7() {
        return pgl7;
    }

    public void setGr6(RichGridRow gr6) {
        this.gr6 = gr6;
    }

    public RichGridRow getGr6() {
        return gr6;
    }

    public void setGc11(RichGridCell gc11) {
        this.gc11 = gc11;
    }

    public RichGridCell getGc11() {
        return gc11;
    }

    public void setGc12(RichGridCell gc12) {
        this.gc12 = gc12;
    }

    public RichGridCell getGc12() {
        return gc12;
    }

    public void setGr7(RichGridRow gr7) {
        this.gr7 = gr7;
    }

    public RichGridRow getGr7() {
        return gr7;
    }

    public void setGc13(RichGridCell gc13) {
        this.gc13 = gc13;
    }

    public RichGridCell getGc13() {
        return gc13;
    }

    public void setGc14(RichGridCell gc14) {
        this.gc14 = gc14;
    }

    public RichGridCell getGc14() {
        return gc14;
    }

    public void setGr8(RichGridRow gr8) {
        this.gr8 = gr8;
    }

    public RichGridRow getGr8() {
        return gr8;
    }

    public void setGc15(RichGridCell gc15) {
        this.gc15 = gc15;
    }

    public RichGridCell getGc15() {
        return gc15;
    }

    public void setGc16(RichGridCell gc16) {
        this.gc16 = gc16;
    }

    public RichGridCell getGc16() {
        return gc16;
    }

    public void setPgl8(RichPanelGroupLayout pgl8) {
        this.pgl8 = pgl8;
    }

    public RichPanelGroupLayout getPgl8() {
        return pgl8;
    }

    public void setOt8(RichOutputText ot8) {
        this.ot8 = ot8;
    }

    public RichOutputText getOt8() {
        return ot8;
    }

    public void setOt9(RichOutputText ot9) {
        this.ot9 = ot9;
    }

    public RichOutputText getOt9() {
        return ot9;
    }

    public void setOt10(RichOutputText ot10) {
        this.ot10 = ot10;
    }

    public RichOutputText getOt10() {
        return ot10;
    }

    public void setOt11(RichOutputText ot11) {
        this.ot11 = ot11;
    }

    public RichOutputText getOt11() {
        return ot11;
    }

    public void setOt12(RichOutputText ot12) {
        this.ot12 = ot12;
    }

    public RichOutputText getOt12() {
        return ot12;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setIt39(RichInputText it39) {
        this.it39 = it39;
    }

    public RichInputText getIt39() {
        return it39;
    }


    public void setIt40(RichInputText it40) {
        this.it40 = it40;
    }

    public RichInputText getIt40() {
        return it40;
    }

    public void setId4(RichInputDate id4) {
        this.id4 = id4;
    }

    public RichInputDate getId4() {
        return id4;
    }

    public void setPfl7(RichPanelFormLayout pfl7) {
        this.pfl7 = pfl7;
    }

    public RichPanelFormLayout getPfl7() {
        return pfl7;
    }

    public void setIt41(RichInputText it41) {
        this.it41 = it41;
    }

    public RichInputText getIt41() {
        return it41;
    }

    public void setIt42(RichInputText it42) {
        this.it42 = it42;
    }

    public RichInputText getIt42() {
        return it42;
    }

    public void setId5(RichInputDate id5) {
        this.id5 = id5;
    }

    public RichInputDate getId5() {
        return id5;
    }

    public void setId6(RichInputDate id6) {
        this.id6 = id6;
    }

    public RichInputDate getId6() {
        return id6;
    }

    public void setIt43(RichInputText it43) {
        this.it43 = it43;
    }

    public RichInputText getIt43() {
        return it43;
    }

    public void setIt44(RichInputText it44) {
        this.it44 = it44;
    }

    public RichInputText getIt44() {
        return it44;
    }

    public void setIt46(RichInputText it46) {
        this.it46 = it46;
    }

    public RichInputText getIt46() {
        return it46;
    }

    public void setIt47(RichInputText it47) {
        this.it47 = it47;
    }

    public RichInputText getIt47() {
        return it47;
    }

    public void setIt48(RichInputText it48) {
        this.it48 = it48;
    }

    public RichInputText getIt48() {
        return it48;
    }

    public void setIt49(RichInputText it49) {
        this.it49 = it49;
    }

    public RichInputText getIt49() {
        return it49;
    }

    public void setCb6(RichCommandButton cb6) {
        this.cb6 = cb6;
    }

    public RichCommandButton getCb6() {
        return cb6;
    }
}
