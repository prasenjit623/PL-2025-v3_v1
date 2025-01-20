package view.backing.fragments;


import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;

import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
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
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditUnit {
    private RichPageTemplate pt1;
    private RichPanelBox pb1;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichToolbar t1;
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichSelectOneChoice soc2;
    private UISelectItems si2;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichInputText it6;
    private RichInputText it7;
    private RichInputText it8;
    private RichInputText it9;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichInputText it10;
    private RichSelectOneChoice soc4;
    private UISelectItems si4;
    private RichSelectOneChoice soc5;
    private UISelectItems si5;
    private RichSelectOneChoice soc6;
    private UISelectItems si6;
    private RichInputText it11;
    private RichInputText it12;
    private RichInputText it13;
    private RichInputText it14;
    private RichSelectOneChoice soc7;
    private UISelectItems si7;
    private RichInputText it15;
    private RichSelectOneChoice soc8;
    private UISelectItems si8;
    private RichInputText it16;
    private RichSelectOneChoice soc9;
    private UISelectItems si9;
    private RichInputText it17;
    private RichSelectOneChoice soc10;
    private UISelectItems si10;
    private RichInputText it18;
    private RichSelectOneChoice soc11;
    private UISelectItems si11;
    private RichInputText it19;
    private RichInputText it20;
    private RichInputText it21;
    private RichSelectOneChoice soc12;
    private UISelectItems si12;
    private RichSelectOneChoice soc13;
    private UISelectItems si13;
    private RichSelectOneChoice soc14;
    private UISelectItems si14;
    private RichInputText it22;
    private RichInputText it23;
    private RichPanelFormLayout pfl2;
    private RichPanelFormLayout pfl3;
    private RichPanelFormLayout pfl4;
    private RichPanelFormLayout pfl5;
    private RichPanelFormLayout pfl6;
    private RichPanelGroupLayout pgl2;
    private RichSpacer s1;
    private RichOutputText ot1;
    private RichSpacer s2;
    private RichPanelGroupLayout pgl3;
    private RichSpacer s3;
    private RichSpacer s4;
    private RichOutputText ot2;
    private RichPanelGroupLayout pgl4;
    private RichSpacer s5;
    private RichSpacer s6;
    private RichOutputText ot3;
    private RichPanelGroupLayout pgl5;
    private RichSpacer s7;
    private RichSpacer s8;
    private RichOutputText ot4;
    private RichPanelGroupLayout pgl6;
    private RichSpacer s9;
    private RichSpacer s10;
    private RichOutputText ot5;
    private RichPanelFormLayout pfl7;
    private RichPanelBox pb2;
    private RichPanelBox pb3;
    private RichPanelBox pb4;
    private RichPanelBox pb5;
    private RichPanelBox pb6;
    private RichPanelGroupLayout pgl7;
    private RichPanelGroupLayout pgl8;
    private RichPanelGroupLayout pgl9;
    private RichPanelGroupLayout pgl10;
    private RichPanelGroupLayout pgl11;
    private RichPanelGroupLayout pgl12;
    private RichSpacer s11;
    private RichSpacer s12;
    private RichPanelGroupLayout pgl13;
    private RichSpacer s13;
    private RichSpacer s14;
    private RichSpacer s15;
    private RichSpacer s16;
    private RichPanelGroupLayout pgl14;
    private RichSpacer s17;
    private RichPanelFormLayout pfl8;
    private RichPanelFormLayout pfl9;
    private RichPanelGroupLayout pgl15;
    private RichSpacer s18;
    private RichSpacer s19;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichCommandButton cb3;
    private RichPanelTabbed pt2;
    private RichShowDetailItem tab1;
    private RichShowDetailItem tab2;
    private RichShowDetailItem tab3;
    private RichShowDetailItem tab4;
    private RichShowDetailItem tab5;
    private RichPanelCollection pc1;
    private RichPanelCollection pc2;
    private RichPanelCollection pc3;
    private RichPanelCollection pc4;
    private RichPanelCollection pc5;
    private RichTable t2;
    private RichPanelBox pb7;
    private RichPanelBox pb8;
    private RichPanelBox pb9;
    private RichPanelBox pb10;
    private RichPanelBox pb11;
    private RichToolbar t3;
    private RichCommandImageLink cil2;
    private RichTable t4;
    private RichToolbar t5;
    private RichCommandImageLink cil3;
    private RichSpacer s20;
    private RichSpacer s21;
    private RichSpacer s22;
    private RichPopup p1;
    private RichDialog d1;
    private RichTable t6;
    private RichToolbar t7;
    private RichCommandButton cb4;
    private RichCommandButton cb5;
    private RichSpacer s23;
    private RichCommandImageLink cil4;
    private RichSpacer s24;
    private RichCommandButton cb6;
    private RichCommandButton cb7;
    private RichCommandButton cb8;
    private RichInputComboboxListOfValues unitTypeTransId;
    private RichInputComboboxListOfValues propertyTransId;
    private RichInputComboboxListOfValues buildingTransId;
    private RichShowDetailItem sdi1;
    private RichPanelBox pb12;
    private RichTable t8;
    private RichPanelCollection pc6;
    private RichToolbar t9;
    private RichCommandImageLink cil5;
    private RichCommandImageLink cil6;
    private RichSpacer s25;
    private RichTable t10;
    private static String oldstatus=null;
    private static String newvalue=null;

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


    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
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

    public void setIt10(RichInputText it10) {
        this.it10 = it10;
    }

    public RichInputText getIt10() {
        return it10;
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

    public void setIt15(RichInputText it15) {
        this.it15 = it15;
    }

    public RichInputText getIt15() {
        return it15;
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

    public void setIt16(RichInputText it16) {
        this.it16 = it16;
    }

    public RichInputText getIt16() {
        return it16;
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

    public void setIt17(RichInputText it17) {
        this.it17 = it17;
    }

    public RichInputText getIt17() {
        return it17;
    }

    public void setSoc10(RichSelectOneChoice soc10) {
        this.soc10 = soc10;
    }

    public RichSelectOneChoice getSoc10() {
        return soc10;
    }

    public void setSi10(UISelectItems si10) {
        this.si10 = si10;
    }

    public UISelectItems getSi10() {
        return si10;
    }

    public void setIt18(RichInputText it18) {
        this.it18 = it18;
    }

    public RichInputText getIt18() {
        return it18;
    }

    public void setSoc11(RichSelectOneChoice soc11) {
        this.soc11 = soc11;
    }

    public RichSelectOneChoice getSoc11() {
        return soc11;
    }

    public void setSi11(UISelectItems si11) {
        this.si11 = si11;
    }

    public UISelectItems getSi11() {
        return si11;
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

    public void setSoc12(RichSelectOneChoice soc12) {
        this.soc12 = soc12;
    }

    public RichSelectOneChoice getSoc12() {
        return soc12;
    }

    public void setSi12(UISelectItems si12) {
        this.si12 = si12;
    }

    public UISelectItems getSi12() {
        return si12;
    }

    public void setSoc13(RichSelectOneChoice soc13) {
        this.soc13 = soc13;
    }

    public RichSelectOneChoice getSoc13() {
        return soc13;
    }

    public void setSi13(UISelectItems si13) {
        this.si13 = si13;
    }

    public UISelectItems getSi13() {
        return si13;
    }

    public void setSoc14(RichSelectOneChoice soc14) {
        this.soc14 = soc14;
    }

    public RichSelectOneChoice getSoc14() {
        return soc14;
    }

    public void setSi14(UISelectItems si14) {
        this.si14 = si14;
    }

    public UISelectItems getSi14() {
        return si14;
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

    public void setPfl4(RichPanelFormLayout pfl4) {
        this.pfl4 = pfl4;
    }

    public RichPanelFormLayout getPfl4() {
        return pfl4;
    }

    public void setPfl5(RichPanelFormLayout pfl5) {
        this.pfl5 = pfl5;
    }

    public RichPanelFormLayout getPfl5() {
        return pfl5;
    }

    public void setPfl6(RichPanelFormLayout pfl6) {
        this.pfl6 = pfl6;
    }

    public RichPanelFormLayout getPfl6() {
        return pfl6;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
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

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
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

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }

    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }

    public void setS5(RichSpacer s5) {
        this.s5 = s5;
    }

    public RichSpacer getS5() {
        return s5;
    }

    public void setS6(RichSpacer s6) {
        this.s6 = s6;
    }

    public RichSpacer getS6() {
        return s6;
    }

    public void setOt3(RichOutputText ot3) {
        this.ot3 = ot3;
    }

    public RichOutputText getOt3() {
        return ot3;
    }

    public void setPgl5(RichPanelGroupLayout pgl5) {
        this.pgl5 = pgl5;
    }

    public RichPanelGroupLayout getPgl5() {
        return pgl5;
    }

    public void setS7(RichSpacer s7) {
        this.s7 = s7;
    }

    public RichSpacer getS7() {
        return s7;
    }

    public void setS8(RichSpacer s8) {
        this.s8 = s8;
    }

    public RichSpacer getS8() {
        return s8;
    }

    public void setOt4(RichOutputText ot4) {
        this.ot4 = ot4;
    }

    public RichOutputText getOt4() {
        return ot4;
    }

    public void setPgl6(RichPanelGroupLayout pgl6) {
        this.pgl6 = pgl6;
    }

    public RichPanelGroupLayout getPgl6() {
        return pgl6;
    }

    public void setS9(RichSpacer s9) {
        this.s9 = s9;
    }

    public RichSpacer getS9() {
        return s9;
    }

    public void setS10(RichSpacer s10) {
        this.s10 = s10;
    }

    public RichSpacer getS10() {
        return s10;
    }

    public void setOt5(RichOutputText ot5) {
        this.ot5 = ot5;
    }

    public RichOutputText getOt5() {
        return ot5;
    }

    public void setPfl7(RichPanelFormLayout pfl7) {
        this.pfl7 = pfl7;
    }

    public RichPanelFormLayout getPfl7() {
        return pfl7;
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

    public void setPgl7(RichPanelGroupLayout pgl7) {
        this.pgl7 = pgl7;
    }

    public RichPanelGroupLayout getPgl7() {
        return pgl7;
    }

    public void setPgl8(RichPanelGroupLayout pgl8) {
        this.pgl8 = pgl8;
    }

    public RichPanelGroupLayout getPgl8() {
        return pgl8;
    }

    public void setPgl9(RichPanelGroupLayout pgl9) {
        this.pgl9 = pgl9;
    }

    public RichPanelGroupLayout getPgl9() {
        return pgl9;
    }

    public void setPgl10(RichPanelGroupLayout pgl10) {
        this.pgl10 = pgl10;
    }

    public RichPanelGroupLayout getPgl10() {
        return pgl10;
    }

    public void setPgl11(RichPanelGroupLayout pgl11) {
        this.pgl11 = pgl11;
    }

    public RichPanelGroupLayout getPgl11() {
        return pgl11;
    }

    public void setPgl12(RichPanelGroupLayout pgl12) {
        this.pgl12 = pgl12;
    }

    public RichPanelGroupLayout getPgl12() {
        return pgl12;
    }

    public void setS11(RichSpacer s11) {
        this.s11 = s11;
    }

    public RichSpacer getS11() {
        return s11;
    }

    public void setS12(RichSpacer s12) {
        this.s12 = s12;
    }

    public RichSpacer getS12() {
        return s12;
    }

    public void setPgl13(RichPanelGroupLayout pgl13) {
        this.pgl13 = pgl13;
    }

    public RichPanelGroupLayout getPgl13() {
        return pgl13;
    }

    public void setS13(RichSpacer s13) {
        this.s13 = s13;
    }

    public RichSpacer getS13() {
        return s13;
    }

    public void setS14(RichSpacer s14) {
        this.s14 = s14;
    }

    public RichSpacer getS14() {
        return s14;
    }

    public void setS15(RichSpacer s15) {
        this.s15 = s15;
    }

    public RichSpacer getS15() {
        return s15;
    }

    public void setS16(RichSpacer s16) {
        this.s16 = s16;
    }

    public RichSpacer getS16() {
        return s16;
    }

    public void setPgl14(RichPanelGroupLayout pgl14) {
        this.pgl14 = pgl14;
    }

    public RichPanelGroupLayout getPgl14() {
        return pgl14;
    }

    public void setS17(RichSpacer s17) {
        this.s17 = s17;
    }

    public RichSpacer getS17() {
        return s17;
    }


    public void setPfl8(RichPanelFormLayout pfl8) {
        this.pfl8 = pfl8;
    }

    public RichPanelFormLayout getPfl8() {
        return pfl8;
    }

    public void setPfl9(RichPanelFormLayout pfl9) {
        this.pfl9 = pfl9;
    }

    public RichPanelFormLayout getPfl9() {
        return pfl9;
    }


    public void setPgl15(RichPanelGroupLayout pgl15) {
        this.pgl15 = pgl15;
    }

    public RichPanelGroupLayout getPgl15() {
        return pgl15;
    }

    public void setS18(RichSpacer s18) {
        this.s18 = s18;
    }

    public RichSpacer getS18() {
        return s18;
    }

    public void setS19(RichSpacer s19) {
        this.s19 = s19;
    }

    public RichSpacer getS19() {
        return s19;
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

    public void setTab4(RichShowDetailItem tab4) {
        this.tab4 = tab4;
    }

    public RichShowDetailItem getTab4() {
        return tab4;
    }

    public void setTab5(RichShowDetailItem tab5) {
        this.tab5 = tab5;
    }

    public RichShowDetailItem getTab5() {
        return tab5;
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

    public void setPc4(RichPanelCollection pc4) {
        this.pc4 = pc4;
    }

    public RichPanelCollection getPc4() {
        return pc4;
    }

    public void setPc5(RichPanelCollection pc5) {
        this.pc5 = pc5;
    }

    public RichPanelCollection getPc5() {
        return pc5;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setPb7(RichPanelBox pb7) {
        this.pb7 = pb7;
    }

    public RichPanelBox getPb7() {
        return pb7;
    }

    public void setPb8(RichPanelBox pb8) {
        this.pb8 = pb8;
    }

    public RichPanelBox getPb8() {
        return pb8;
    }

    public void setPb9(RichPanelBox pb9) {
        this.pb9 = pb9;
    }

    public RichPanelBox getPb9() {
        return pb9;
    }

    public void setPb10(RichPanelBox pb10) {
        this.pb10 = pb10;
    }

    public RichPanelBox getPb10() {
        return pb10;
    }

    public void setPb11(RichPanelBox pb11) {
        this.pb11 = pb11;
    }

    public RichPanelBox getPb11() {
        return pb11;
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

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void setT5(RichToolbar t5) {
        this.t5 = t5;
    }

    public RichToolbar getT5() {
        return t5;
    }

    public void setCil3(RichCommandImageLink cil3) {
        this.cil3 = cil3;
    }

    public RichCommandImageLink getCil3() {
        return cil3;
    }


    public void setS20(RichSpacer s20) {
        this.s20 = s20;
    }

    public RichSpacer getS20() {
        return s20;
    }

    public void setS21(RichSpacer s21) {
        this.s21 = s21;
    }

    public RichSpacer getS21() {
        return s21;
    }

    public void setS22(RichSpacer s22) {
        this.s22 = s22;
    }

    public RichSpacer getS22() {
        return s22;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setD1(RichDialog d1) {
        this.d1 = d1;
    }

    public RichDialog getD1() {
        return d1;
    }


    public void setT6(RichTable t6) {
        this.t6 = t6;
    }

    public RichTable getT6() {
        return t6;
    }

    public void setT7(RichToolbar t7) {
        this.t7 = t7;
    }

    public RichToolbar getT7() {
        return t7;
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

    public void setS23(RichSpacer s23) {
        this.s23 = s23;
    }

    public RichSpacer getS23() {
        return s23;
    }

    public void setCil4(RichCommandImageLink cil4) {
        this.cil4 = cil4;
    }

    public RichCommandImageLink getCil4() {
        return cil4;
    }

    public void setS24(RichSpacer s24) {
        this.s24 = s24;
    }

    public RichSpacer getS24() {
        return s24;
    }

    public void onClickCarPark(ActionEvent actionEvent) {
        try {
            ViewObject vo =
                ADFUtils.findIterator("getCarparkingForUnits_ROVO1Iterator").getViewObject();
            ViewObject Cvo =
                ADFUtils.findIterator("PropertyCarparks_VO1Iterator").getViewObject();
            RowSetIterator rs = vo.createRowSet("");
            while (rs.hasNext()) {
                Row rows = rs.next();
                if (rows.getAttribute("CheckBox_TRans") != null) {
                    Boolean bo = (Boolean)rows.getAttribute("CheckBox_TRans");
                    if (bo == true && bo != null) {
                        String isDuplicate = null;
                        isDuplicate =
                                checkDuplicateCarparkUnit(rows.getAttribute("UnitId"));
                        if (isDuplicate.equals("N")) {
                            Row createRow = Cvo.createRow();
                            createRow.setAttribute("CpUnitId",
                                                   rows.getAttribute("UnitId"));
                            createRow.setAttribute("CpUnitNumber",
                                                   rows.getAttribute("UnitNumber"));
                            createRow.setAttribute("CpStatus", "AL");

                            Cvo.insertRow(createRow);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public String checkDuplicateCarparkUnit(Object CpUnitId) {

        String s2 = CpUnitId.toString();
        String isDuplicate = "N";
        try {
            ViewObject unitCarparkVO =
                ADFUtils.findIterator("PropertyCarparks_VO1Iterator").getViewObject();
            RowSetIterator unitCarparkRS =
                unitCarparkVO.createRowSetIterator(null);
            while (unitCarparkRS.hasNext()) {
                Row currentRow = unitCarparkRS.next();
                System.out.println("Unit is ----" +
                                   currentRow.getAttribute("CpUnitId"));
                String s1 = currentRow.getAttribute("CpUnitId").toString();
                if (s2.equals(s1))
                    isDuplicate = "Y";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDuplicate;
    }

    public void onClickUnitType(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());

    }

    public void OnCreateCarParking(ActionEvent actionEvent) {
        //    OperationBinding op =
        //      (OperationBinding)ADFUtils.findOperation("CreateInsert1").execute();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        p1.show(hints);
    }


    public String onClickSaveandClose() {
        ViewObject AreaVo =
            ADFUtils.findIterator("PropertyArea_VO2Iterator").getViewObject();
        ViewObject PropertyVo =
            ADFUtils.findIterator("PropertyUnits_VO1Iterator").getViewObject();
        Row PropertyCurrRow = PropertyVo.getCurrentRow();

        if (AreaVo.getEstimatedRowCount() > 0) {
            RowSetIterator rs = AreaVo.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r1 = rs.next();
                r1.setAttribute("PropertyId",
                                PropertyCurrRow.getAttribute("PropertyId"));
                r1.setAttribute("BuildId",
                                PropertyCurrRow.getAttribute("BuildId"));
            }
            AreaVo.executeQuery();
        }
        return "back";
    }


    public void onclickaddArea(ActionEvent actionEvent) {
        ViewObject BuildVo =
            ADFUtils.findIterator("PropertyUnits_VO1Iterator").getViewObject();
        Row re = BuildVo.getCurrentRow();
        if (re.getAttribute("PropertyId") != null) {
            if (re.getAttribute("BuildId") != null) {
                OperationBinding op =
                    (OperationBinding)ADFUtils.findOperation("CreateInsert").execute();
                ViewObject AreaVo =
                    ADFUtils.findIterator("PropertyArea_VO2Iterator").getViewObject();
                Row areaRo = AreaVo.getCurrentRow();
                areaRo.setAttribute("PropertyId",
                                    re.getAttribute("PropertyId"));
                areaRo.setAttribute("BuildId", re.getAttribute("BuildId"));
                AreaVo.executeQuery();
            } else {
                JSFUtils.addFacesErrorMessage("Please Select Building ..!");
            }
        } else {
            JSFUtils.addFacesErrorMessage("Please Select Property ..!");
        }

    }

    public void onClickRemoveCarPark(ActionEvent actionEvent) {
        try {
            ViewObject unitCarparkVo =
                ADFUtils.findIterator("PropertyCarparks_VO1Iterator").getViewObject();
            Row crow = unitCarparkVo.getCurrentRow();
            ViewObject vo =
                ADFUtils.findIterator("PropertyArea_VO2Iterator").getViewObject();
            ViewCriteria vc = vo.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("UnitId", crow.getAttribute("CpUnitId"));
            vc.addRow(vcRow);
            vo.applyViewCriteria(vc);
            vo.executeQuery();
            Row rows = vo.first();
            rows.setAttribute("Status", "A");
            vo.executeQuery();

            crow.remove();
            OperationBinding opBndMaster = ADFUtils.findOperation("Commit");
            opBndMaster.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onChangeAreaValue(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            ViewObject vo =
                ADFUtils.findIterator("PropertyArea_VO2Iterator").getViewObject();
            Row re = vo.getCurrentRow();
            if (re.getAttribute("Area").equals("CHARGE")) {
                float pr1 =
                    Float.parseFloat(valueChangeEvent.getNewValue().toString());
                oracle.jbo.domain.Number totalVal =
                    new oracle.jbo.domain.Number(pr1);
                this.it11.setValue(totalVal);

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.it11);

                calculateTotalRate();
            }


        }


    }

    private void calculateTotalRate() {
        try {
            float total = 0;
            float br = 0;
            float pr1 = 0;
            float pr2 = 0;
            float pr3 = 0;
            float pr4 = 0;
            float pr5 = 0;
            float ca = 0;
            float pp = 0;
            if (getIt13().getValue() != null) {
                br = Float.parseFloat(getIt13().getValue().toString());
            } else {
                br = 0;
            }
            if (getIt14().getValue() != null) {
                pr1 = Float.parseFloat(getIt14().getValue().toString());
            } else {
                pr1 = 0;
            }
            if (getIt15().getValue() != null) {
                pr2 = Float.parseFloat(getIt15().getValue().toString());
            } else {
                pr2 = 0;
            }

            if (getIt16().getValue() != null) {
                pr3 = Float.parseFloat(getIt16().getValue().toString());
                System.out.println(pr3);
            } else {
                pr3 = 0;
                System.out.println(pr3);
            }
            if (getIt17().getValue() != null) {
                pr4 = Float.parseFloat(getIt17().getValue().toString());
            } else {
                pr4 = 0;
            }
            if (getIt18().getValue() != null) {
                pr5 = Float.parseFloat(getIt18().getValue().toString());
            } else {
                pr5 = 0;
            }
            if (getIt11().getValue() != null) {
                ca = Float.parseFloat(getIt11().getValue().toString());
            } else {
                ca = 0;
            }
            total = br + pr1 + pr2 + pr3 + pr4 + pr5;
            oracle.jbo.domain.Number totalVal =
                new oracle.jbo.domain.Number(total);
            //        System.err.println("=====" + totalVal);
            this.getIt19().setValue(totalVal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getIt19());
            pp = total * ca;
            //        System.err.println("MAIN TOTAL----" + pp);
            oracle.jbo.domain.Number totalPP =
                new oracle.jbo.domain.Number(pp);
            //        System.err.println("=====" + totalPP);

            this.getIt20().setValue(totalPP);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onChangeBaseRate(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            calculateTotalRate();
        }

    }

    public void onPremium5(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            calculateTotalRate();
        }
    }


    public void onPremium4(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            calculateTotalRate();
        }
    }

    public void onPremium3(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            calculateTotalRate();
        }
    }

    public void onPremium2(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            calculateTotalRate();
        }
    }

    public void onPremium1(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            calculateTotalRate();
        }
    }


    public void onchangeCharea(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());

        if (valueChangeEvent.getNewValue() != null) {
            calculateTotalRate();
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

    public void onClickSave(ActionEvent actionEvent) {
        ViewObject getFuncodeVo=ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
        getFuncodeVo.setNamedWhereClauseParam("F_ID", "UT");
        getFuncodeVo.executeQuery();
        Object Funcode=getFuncodeVo.first().getAttribute("FuncId");
        String Fcode=Funcode==null?"":Funcode.toString();
        ViewObject Property =
            ADFUtils.findIterator("PropertyUnits_VO1Iterator").getViewObject();
        Row re = Property.getCurrentRow();
        if (re.getAttribute("UnitNumber") == null) {
            String name =
                xxfnd.generateDocNo("UT", "PropertyUnits_AMDataControl").toString();
            Object valu = name;

            re.setAttribute("UnitNumber", valu);
            re.setAttribute("FuncId",getFuncodeVo.first().getAttribute("FuncId"));
        }
        else
        {
         ViewObject unitstatus=ADFUtils.findIterator("UnitStatusLog_VO1Iterator").getViewObject();
         ViewObject lookup=ADFUtils.findIterator("LookupDetails_ROVO1Iterator").getViewObject();
         Row[] filter=lookup.getFilteredRows("LookupValueName",oldstatus);
            
            Object oldvalues=null;
            Object newvalues=null;
            for(Row row:filter)
                       {
                        oldvalues = row.getAttribute("LookupValueNameDisp");
                           
                       }
            lookup.reset();
            Row[] filter1=lookup.getFilteredRows("LookupValueName",newvalue);
            for(Row row1:filter1)
                       {
                        newvalues = row1.getAttribute("LookupValueNameDisp");
                           
                       }
          Row r=unitstatus.createRow();
//          JSFUtils.addFacesInformationMessage(newvalues.toString()+""+oldvalues.toString());
            r.setAttribute("Unitid",re.getAttribute("UnitId"));
            r.setAttribute("Unitnumber",re.getAttribute("UnitNumber"));
            r.setAttribute("Oldstatus",oldvalues);
            r.setAttribute("Newsatatus",newvalues);
            unitstatus.insertRow(r);
        }

        OperationBinding binding =
            (OperationBinding)ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully");
    }

    public String onClickReturn() {
        String scopeVal = null;
        Object Val =
            ADFContext.getCurrent().getPageFlowScope().get("SUBEditUnitId") ==
            null ? "" :
            ADFContext.getCurrent().getPageFlowScope().get("SUBEditUnitId").toString();
        if (Val.equals("SUBTABUNIT")) {
            scopeVal = "returntoProperty";
        } else {
            scopeVal = "back";
        }
        return scopeVal;
    }
    public void onClickClose(ActionEvent actionEvent) {
      OperationBinding binding =
        (OperationBinding)ADFUtils.findOperation("Rollback").execute();
    }

    public void setCb8(RichCommandButton cb8) {
        this.cb8 = cb8;
    }

    public RichCommandButton getCb8() {
        return cb8;
    }

    public void onClickAttachments(ActionEvent actionEvent) {
        JSFUtils.setExpressionValue("#{pageFlowScope.unitfuncId}", 1);
        JSFUtils.setExpressionValue("#{pageFlowScope.unitId}", JSFUtils.resolveExpression("#{bindings.UnitId.inputValue}"));
        
    }

    public void setUnitTypeTransId(RichInputComboboxListOfValues unitTypeTransId) {
        this.unitTypeTransId = unitTypeTransId;
    }

    public RichInputComboboxListOfValues getUnitTypeTransId() {
        return unitTypeTransId;
    }

    public void setPropertyTransId(RichInputComboboxListOfValues propertyTransId) {
        this.propertyTransId = propertyTransId;
    }

    public RichInputComboboxListOfValues getPropertyTransId() {
        return propertyTransId;
    }

    public void setBuildingTransId(RichInputComboboxListOfValues buildingTransId) {
        this.buildingTransId = buildingTransId;
    }

    public RichInputComboboxListOfValues getBuildingTransId() {
        return buildingTransId;
    }

    public void setSdi1(RichShowDetailItem sdi1) {
        this.sdi1 = sdi1;
    }

    public RichShowDetailItem getSdi1() {
        return sdi1;
    }

    public void setPb12(RichPanelBox pb12) {
        this.pb12 = pb12;
    }

    public RichPanelBox getPb12() {
        return pb12;
    }

    public void setT8(RichTable t8) {
        this.t8 = t8;
    }

    public RichTable getT8() {
        return t8;
    }

    public void setPc6(RichPanelCollection pc6) {
        this.pc6 = pc6;
    }

    public RichPanelCollection getPc6() {
        return pc6;
    }

    public void setT9(RichToolbar t9) {
        this.t9 = t9;
    }

    public RichToolbar getT9() {
        return t9;
    }

    public void setCil5(RichCommandImageLink cil5) {
        this.cil5 = cil5;
    }

    public RichCommandImageLink getCil5() {
        return cil5;
    }

    public void setCil6(RichCommandImageLink cil6) {
        this.cil6 = cil6;
    }

    public RichCommandImageLink getCil6() {
        return cil6;
    }

    public void setS25(RichSpacer s25) {
        this.s25 = s25;
    }

    public RichSpacer getS25() {
        return s25;
    }

    public void setT10(RichTable t10) {
        this.t10 = t10;
    }

    public RichTable getT10() {
        return t10;
    }

    public void onchangestatus(ValueChangeEvent valueChangeEvent) {
        oldstatus=valueChangeEvent.getOldValue()==null?"null":valueChangeEvent.getOldValue().toString();
        newvalue=valueChangeEvent.getNewValue()==null?"null":valueChangeEvent.getNewValue().toString();
        
    }
}
