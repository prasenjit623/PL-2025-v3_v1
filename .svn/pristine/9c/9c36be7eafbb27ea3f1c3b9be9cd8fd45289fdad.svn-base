package view.backing.fragments;


import java.math.BigDecimal;

import javax.el.ELContext;
import javax.el.ExpressionFactory;


import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.application.Application;

import oracle.adf.model.AttributeBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import javax.el.ValueExpression;

import javax.faces.component.UISelectItems;

import oracle.adf.view.faces.bi.component.chart.UIPieChart;
import oracle.adf.view.faces.bi.component.chart.UIPieDataItem;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
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

public class AddEditProperty {
  private RichPageTemplate pt1;
  boolean flag = false;
  private RichSelectOneChoice soc6;
  private RichPanelBox pb1;
  private RichPanelFormLayout pfl1;
  private RichInputText it1;
  private RichInputText it2;
  private RichInputText it3;
  private RichInputText it4;
  private RichInputText it5;
  private RichSelectOneChoice soc1;
  private UISelectItems si1;
  private RichSelectOneChoice soc2;
  private UISelectItems si2;
  private RichInputText it6;
  private RichSelectOneChoice soc3;
  private UISelectItems si3;
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
  private RichInputDate id1;
  private RichInputText it28;
  private RichInputDate id2;
  private RichInputText it29;
  private RichInputText it30;
  private RichInputText it31;
  private RichInputText it32;
  private RichInputText it33;
  private RichInputText it34;
  private RichInputText it35;
  private RichPanelGroupLayout pgl1;
  private RichPanelFormLayout pfl3;
  private RichPanelFormLayout pfl4;
  private RichPanelBox pb2;
  private RichPanelBox pb3;
  private RichPanelGroupLayout pgl2;
  private RichPanelGroupLayout pgl3;
  private RichSpacer s1;
  private RichSpacer s2;
  private RichSpacer s3;
  private RichPanelFormLayout pfl2;
  private RichPanelBox pb4;
  private RichPanelFormLayout pfl5;
  private RichPanelBox pb5;
  private RichPanelGroupLayout pgl4;
  private RichPanelGroupLayout pgl5;
  private RichPanelGroupLayout pgl6;
  private RichSpacer s4;
  private RichSpacer s5;
  private RichSpacer s6;
    private RichPanelFormLayout pfl6;
  private RichPanelGroupLayout pgl7;
  private RichSpacer s8;
  private RichSpacer s9;
  private RichPanelTabbed pt2;
  private RichShowDetailItem tab1;
  private RichShowDetailItem tab2;
  private RichShowDetailItem tab3;
  private RichShowDetailItem tab4;
  private RichShowDetailItem tab5;
  private RichSpacer s10;
  private RichPanelBox pb6;
  private RichPanelBox pb7;
  private RichPanelBox pb8;
  private RichPanelBox pb9;
  private RichPanelBox pb10;
  private RichPanelCollection pc1;
  private RichPanelCollection pc2;
  private RichPanelCollection pc3;
  private RichPanelCollection pc4;
  private RichPanelCollection pc5;
  private RichTable t1;
  private RichTable t2;
  private RichTable t3;
  private RichPanelGridLayout pgl8;
  private RichGridRow gr1;
  private RichGridCell gc1;
  private RichGridCell gc2;
  private RichToolbar t4;
  private RichCommandButton cb3;
  private RichToolbar t5;
  private RichCommandImageLink cil2;
  private RichPopup p1;
  private RichDialog d1;
  private RichOutputText ot4;
    private RichSpacer s11;
    private RichSpacer s12;
  private RichCommandButton cb5;
   
    private RichCommandButton cb440;
    private RichCommandButton cb4;
    private RichCommandButton cb1;
    private UIPieChart pieChart1;
    private UIPieDataItem di1;
    private RichInputComboboxListOfValues orgNameTransId;
    private RichInputComboboxListOfValues locationTransId;
    private RichShowDetailItem sdi1;
    private RichPanelCollection pc6;
    private RichPanelBox pb11;
    private RichToolbar t7;
    private RichCommandImageLink cil3;
    private RichCommandImageLink cil4;
    private RichSpacer s7;
    private RichTable t9;
    private RichTable t6;


    public void setAreaLOVId(RichSelectOneChoice soc6) {
    this.soc6 = soc6;
  }

  public RichSelectOneChoice getAreaLOVId() {
    return soc6;
  }

  public void setPt1(RichPageTemplate pt1) {
    this.pt1 = pt1;
  }

  public RichPageTemplate getPt1() {
    return pt1;
  }


  public String onValidateSalableChargable() {
    String areaFlag = "N";
    int Sale = 0;
    int Cha = 0;
    Double sa = new Double(0);
    Double Ch = new Double(0);
    try {
      ViewObject AreaVo2 =
        ADFUtils.findIterator("PropertyArea_VO1Iterator").getViewObject();
      Row re = AreaVo2.first();
      RowSetIterator rs = AreaVo2.createRowSet("");
      while (rs.hasNext()) {
        re = rs.next();
        if (re.getAttribute("Area").equals("SALE")) {
          String sal = re.getAttribute("Value").toString();
          sa = new Double(sal);
        }
        if (re.getAttribute("Area").equals("CHARGE")) {
          String charge = re.getAttribute("Value").toString();
          Ch = new Double(charge);
        }
      }
      if (Ch <= sa) {
        areaFlag = "Y";
      } else {
        areaFlag = "N";
      }
    } catch (NumberFormatException nfe) {
      nfe.printStackTrace();
    }
    return areaFlag;
  }


//  public void onAreaChangeVCL(ValueChangeEvent valueChangeEvent) {
//
//    try {
//      valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
//      Object oldValue = valueChangeEvent.getOldValue();
//      Object selectedCode =
//        this.getValueFrmExpression("#{row.bindings.Area.attributeValue}");
//      String result = checkArea(selectedCode);
//      if (result.equals("Y")) {
//        soc6.setValue(oldValue);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(soc6);
//        RichPopup.PopupHints hints = new RichPopup.PopupHints();
//        p1.show(hints);
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }

  public Object getValueFrmExpression(String data) {

      Object Message = null;
      FacesContext fc = FacesContext.getCurrentInstance();
      Application app = fc.getApplication();
      ExpressionFactory elFactory = app.getExpressionFactory();
      ELContext elContext = fc.getELContext();
      ValueExpression valueExp =
        elFactory.createValueExpression(elContext, data, Object.class);
      Object obj = valueExp.getValue(elContext);
      if (obj != null) {
        Message = obj;
      }
      return Message;
    }

  public String checkArea(Object areaType) {
    String s2 = areaType.toString();
    String isDuplicate = "N";
    try {
      ViewObject propertyAreaVO =
        ADFUtils.findIterator("PropertyArea_VO1Iterator").getViewObject();
      Row[] areaRows = propertyAreaVO.getFilteredRows("Area", s2);
      if (areaRows.length > 1)
        return isDuplicate = "Y";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return isDuplicate;
  }


//  public void OnClickPopupOkBtn(ActionEvent actionEvent) {
//    p1.hide();
//  }


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

  public void setId1(RichInputDate id1) {
    this.id1 = id1;
  }

  public RichInputDate getId1() {
    return id1;
  }

  public void setIt28(RichInputText it28) {
    this.it28 = it28;
  }

  public RichInputText getIt28() {
    return it28;
  }

  public void setId2(RichInputDate id2) {
    this.id2 = id2;
  }

  public RichInputDate getId2() {
    return id2;
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

  public void setIt35(RichInputText it35) {
    this.it35 = it35;
  }

  public RichInputText getIt35() {
    return it35;
  }


  public void setPgl1(RichPanelGroupLayout pgl1) {
    this.pgl1 = pgl1;
  }

  public RichPanelGroupLayout getPgl1() {
    return pgl1;
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


  public void setS3(RichSpacer s3) {
    this.s3 = s3;
  }

  public RichSpacer getS3() {
    return s3;
  }

  public void setPfl2(RichPanelFormLayout pfl2) {
    this.pfl2 = pfl2;
  }

  public RichPanelFormLayout getPfl2() {
    return pfl2;
  }

  public void setPb4(RichPanelBox pb4) {
    this.pb4 = pb4;
  }

  public RichPanelBox getPb4() {
    return pb4;
  }

  public void setPfl5(RichPanelFormLayout pfl5) {
    this.pfl5 = pfl5;
  }

  public RichPanelFormLayout getPfl5() {
    return pfl5;
  }

  public void setPb5(RichPanelBox pb5) {
    this.pb5 = pb5;
  }

  public RichPanelBox getPb5() {
    return pb5;
  }

  public void setPgl4(RichPanelGroupLayout pgl4) {
    this.pgl4 = pgl4;
  }

  public RichPanelGroupLayout getPgl4() {
    return pgl4;
  }

  public void setPgl5(RichPanelGroupLayout pgl5) {
    this.pgl5 = pgl5;
  }

  public RichPanelGroupLayout getPgl5() {
    return pgl5;
  }

  public void setPgl6(RichPanelGroupLayout pgl6) {
    this.pgl6 = pgl6;
  }

  public RichPanelGroupLayout getPgl6() {
    return pgl6;
  }

  public void setS4(RichSpacer s4) {
    this.s4 = s4;
  }

  public RichSpacer getS4() {
    return s4;
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


    public void setPfl6(RichPanelFormLayout pfl6) {
    this.pfl6 = pfl6;
  }

  public RichPanelFormLayout getPfl6() {
    return pfl6;
  }

  public void setPgl7(RichPanelGroupLayout pgl7) {
    this.pgl7 = pgl7;
  }

  public RichPanelGroupLayout getPgl7() {
    return pgl7;
  }

  public void setS8(RichSpacer s8) {
    this.s8 = s8;
  }

  public RichSpacer getS8() {
    return s8;
  }

  public void setS9(RichSpacer s9) {
    this.s9 = s9;
  }

  public RichSpacer getS9() {
    return s9;
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

  public void setS10(RichSpacer s10) {
    this.s10 = s10;
  }

  public RichSpacer getS10() {
    return s10;
  }

  public void setPb6(RichPanelBox pb6) {
    this.pb6 = pb6;
  }

  public RichPanelBox getPb6() {
    return pb6;
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

  public void setT3(RichTable t3) {
    this.t3 = t3;
  }

  public RichTable getT3() {
    return t3;
  }


  public void setPgl8(RichPanelGridLayout pgl8) {
    this.pgl8 = pgl8;
  }

  public RichPanelGridLayout getPgl8() {
    return pgl8;
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


  public void setT4(RichToolbar t4) {
    this.t4 = t4;
  }

  public RichToolbar getT4() {
    return t4;
  }


  public void setCb3(RichCommandButton cb3) {
    this.cb3 = cb3;
  }

  public RichCommandButton getCb3() {
    return cb3;
  }

  public void setT5(RichToolbar t5) {
    this.t5 = t5;
  }

  public RichToolbar getT5() {
    return t5;
  }

  public void setCil2(RichCommandImageLink cil2) {
    this.cil2 = cil2;
  }

  public RichCommandImageLink getCil2() {
    return cil2;
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

  public void setOt4(RichOutputText ot4) {
    this.ot4 = ot4;
  }

  public RichOutputText getOt4() {
    return ot4;
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

  public void setCb5(RichCommandButton cb5) {
    this.cb5 = cb5;
  }

  public RichCommandButton getCb5() {
    return cb5;
  }

  public void onClickLeadPopCancel(ActionEvent actionEvent) {
    this.getP1().cancel();
  }

    
    public void onClickTest(ActionEvent actionEvent) {
        // Add event code here...
        String name =
            xxfnd.generateDocNo("PT", "PropertyMaster_AMDataControl").toString();
        
    }

   
    public void onClickSave(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject getFuncodeVo=ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
        getFuncodeVo.setNamedWhereClauseParam("F_ID", "PT");
        getFuncodeVo.executeQuery();
        Object Funcode=getFuncodeVo.first().getAttribute("FuncId");
        String Fcode=Funcode==null?"":Funcode.toString();
        ViewObject Property =
            ADFUtils.findIterator("PropertyMaster_VO1Iterator").getViewObject();
        Row re=Property.getCurrentRow();
        if(re.getAttribute("PropertyNumber")==null){
            String name =
                xxfnd.generateDocNo("PT", "PropertyMaster_AMDataControl").toString();
        Object valu=name;
        
        re.setAttribute("PropertyNumber", valu);
        re.setAttribute("FuncId", getFuncodeVo.first().getAttribute("FuncId"));
        
        }

        OperationBinding binding =
            (OperationBinding)ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully");


    }

    public void setCb440(RichCommandButton cb440) {
        this.cb440 = cb440;
    }

    public RichCommandButton getCb440() {
        return cb440;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
}

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void onClickAttachments(ActionEvent actionEvent) {
        JSFUtils.setExpressionValue("#{pageFlowScope.profuncId}", 1);
        JSFUtils.setExpressionValue("#{pageFlowScope.proId}", JSFUtils.resolveExpression("#{bindings.PropertyId.inputValue}"));
    }

    public void setPieChart1(UIPieChart pieChart1) {
        this.pieChart1 = pieChart1;
    }

    public UIPieChart getPieChart1() {
        return pieChart1;
    }

    public void setDi1(UIPieDataItem di1) {
        this.di1 = di1;
    }

    public UIPieDataItem getDi1() {
        return di1;
    }

    public void setOrgNameTransId(RichInputComboboxListOfValues orgNameTransId) {
        this.orgNameTransId = orgNameTransId;
    }

    public RichInputComboboxListOfValues getOrgNameTransId() {
        return orgNameTransId;
    }

    public void setLocationTransId(RichInputComboboxListOfValues locationTransId) {
        this.locationTransId = locationTransId;
    }

    public RichInputComboboxListOfValues getLocationTransId() {
        return locationTransId;
    }

    public void setSdi1(RichShowDetailItem sdi1) {
        this.sdi1 = sdi1;
    }

    public RichShowDetailItem getSdi1() {
        return sdi1;
    }

   

    public void setPc6(RichPanelCollection pc6) {
        this.pc6 = pc6;
    }

    public RichPanelCollection getPc6() {
        return pc6;
    }

    public void setPb11(RichPanelBox pb11) {
        this.pb11 = pb11;
    }

    public RichPanelBox getPb11() {
        return pb11;
    }

    public void setT7(RichToolbar t7) {
        this.t7 = t7;
    }

    public RichToolbar getT7() {
        return t7;
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


    public void setS7(RichSpacer s7) {
        this.s7 = s7;
    }

    public RichSpacer getS7() {
        return s7;
    }


    public RichTable getT9() {
        return t9;
    }

    public void setT6(RichTable t6) {
        this.t6 = t6;
    }

    public RichTable getT6() {
        return t6;
    }
}
