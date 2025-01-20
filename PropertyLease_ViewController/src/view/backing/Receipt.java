package view.backing;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import java.util.concurrent.TimeUnit;

import javax.faces.component.UISelectItems;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
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
import oracle.adf.view.rich.component.rich.output.RichMessages;
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

import org.apache.myfaces.trinidad.component.UIXGroup;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class Receipt {
    private RichPanelGroupLayout pgl1;
    private RichPanelGroupLayout pgl2;
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichInputDate id1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichInputText it5;
    private RichInputDate id2;
    private RichInputText it6;
    private RichInputText it7;
    private RichInputText it8;
    private RichInputText it9;
    private RichInputText it10;
    private RichInputText it11;
    private RichInputText it12;
    private RichInputText it13;
    private RichInputDate id3;
    private RichInputDate id4;
    private RichPanelBox pb1;
    private RichPanelGridLayout pgl3;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichCommandButton cb1;
    private RichPanelCollection pc11;
    private RichPanelCollection pc2;
    private RichSpacer s1;
    private UIXGroup g2;
    private RichGridCell gc2;
    private RichTable t1;
    private RichMessages m1;

    private RichToolbar t2;
    private RichCommandImageLink cil1;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichInputText it17;
    private RichCommandButton cb3;
    private RichCommandImageLink cil2;
    private RichSpacer s3;
    private RichPanelFormLayout pfl2;
    String Flag = "Y";
    String val = "Y";
    private RichInputListOfValues customerName_TransId;
    private RichInputListOfValues ilov1;
    private RichSelectBooleanCheckbox sbc1;
    private RichInputDate id6;
    private RichOutputText ot2;
    private RichSelectOneChoice soc4;
    private UISelectItems si4;
    private RichInputText it18;
    private RichInputText it19;
    private RichInputText it20;

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
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

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
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

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
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

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void setId4(RichInputDate id4) {
        this.id4 = id4;
    }

    public RichInputDate getId4() {
        return id4;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
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

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }


    public String onBack() {
        String retruns = "toSave";
        if (val == "N") {
            retruns = null;
        }

        return retruns;
    }


    public void onClickOKRec(ActionEvent actionEvent) {
        ViewObject rfshRcptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator1").getViewObject();
        ViewObject vo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        //
        String finance =
                  (String)JSFUtils.resolveExpression("#{sessionScope.UR}");
        String ack_flag = sbc1.getValue().toString();
        
        if((finance.equalsIgnoreCase("ACCCOUNTS") && ack_flag.equalsIgnoreCase("false")) ||
           (finance.equalsIgnoreCase("ACCOUNTS_MANAGER") && ack_flag.equalsIgnoreCase("false")) ){   
        JSFUtils.addFacesErrorMessage("Please tick the Cashier Acknowledged box");
        }else{
        if (row.getAttribute("ReceiptNumber") == null) {
            String val = xxfnd.generateDocNo("RT", "Booking_AMDataControl");
            Object rVal = val;
            row.setAttribute("ReceiptNumber", rVal);
        }
        ADFUtils.findOperation("Commit").execute();
        rfshRcptVo.executeQuery();
        }   
    }

    public void setPc11(RichPanelCollection pc1) {
        this.pc11 = pc1;
    }

    public RichPanelCollection getPc11() {
        return pc11;
    }


    public void setPc2(RichPanelCollection pc2) {
        this.pc2 = pc2;
    }

    public RichPanelCollection getPc2() {
        return pc2;
    }

    public String DiffinDays(String startDate, String endDate) {
        String str = "0";
        if (startDate != null && endDate != null) {
            System.err.println("startDate" + startDate);
            System.err.println("endDate" + endDate);
            SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");


            Date date1 = null;
            Date date2 = null;
            try {
                date1 = simpleDateFormat.parse(startDate);
            } catch (ParseException e) {
            }

            try {
                date2 = simpleDateFormat.parse(endDate);
            } catch (ParseException e) {
            }


            long diffInDays = date2.getTime() - date1.getTime();

            long getDiff =
                TimeUnit.DAYS.convert(diffInDays, TimeUnit.MILLISECONDS);

            // using TimeUnit class from java.util.concurrent package
            //long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);


            long diffDays = diffInDays / (24 * 60 * 60 * 1000);

            str = String.valueOf(diffDays);

            int n = Integer.parseInt(str);

            int x = Math.abs(n);
            str = Integer.toString(x);


        }


        return str;
    }

    public void onCalcDateDiff(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();


        if (valueChangeEvent != null) {
            String endDate =
                re.getAttribute("PayRecDate") == null ? "" : re.getAttribute("PayRecDate").toString();

            //String endDate = (String)receiptVo.getCurrentRow().getAttribute("PayRecDate");
            String stDate =
                re.getAttribute("PayRefDate") == null ? "" : re.getAttribute("PayRefDate").toString();
            String res =
                DiffinDays(stDate, endDate) == null ? "" : DiffinDays(stDate,
                                                                      endDate).toString();
            Object days = res;
            re.setAttribute("DiffInDays", days);
        }
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setG2(UIXGroup g2) {
        this.g2 = g2;
    }

    public UIXGroup getG2() {
        return g2;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichGridCell getGc2() {
        return gc2;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc11 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc11;
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

    public void setIt17(RichInputText it17) {
        this.it17 = it17;
    }

    public RichInputText getIt17() {
        return it17;
    }

    public void onCalculateDays() {


    }

    public void onChangeRecCharge(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        if (valueChangeEvent.getNewValue() != null) {

            if (valueChangeEvent.getNewValue().equals("DV")) {
                re.setAttribute("RctDesc", "Developer Charges");
                this.it17.setDisabled(true);
            }

            if (valueChangeEvent.getNewValue().equals("CN")) {
                re.setAttribute("RctDesc", "Cancellation Charges");
                this.it17.setDisabled(true);
            }
            if (valueChangeEvent.getNewValue().equals("OT")) {
                re.setAttribute("RctDesc", "");
                this.it17.setDisabled(false);
            }


        }

    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void onClickCancel(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Rollback").execute();

    }


    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
    }

    public void onClickLineAdd(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding binding = ADFUtils.findOperation("CreateInsert");
        binding.execute();
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

//
        public void onChangePayMode(ValueChangeEvent valueChangeEvent) {
                 if ((valueChangeEvent.getNewValue() != null &&
                     valueChangeEvent.getNewValue().toString().contains("Cash")) ||
                     (valueChangeEvent.getNewValue() != null &&
                      valueChangeEvent.getNewValue().toString().contains("CASH")) ) {
                     id2.setRequired(false);
                     it5.setRequired(false);
                 } else {
                     id2.setRequired(true);
                     it5.setRequired(true);
                 }
                 AdfFacesContext.getCurrentInstance().addPartialTarget(id2);
                 AdfFacesContext.getCurrentInstance().addPartialTarget(it5);
         }
      //
        
    public void onChangeChequeDate(ValueChangeEvent valueChangeEvent) {
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        if (valueChangeEvent != null &&
            re.getAttribute("PayRecDate") != null) {
            String endDate =
                re.getAttribute("PayRecDate") == null ? "" : re.getAttribute("PayRecDate").toString();
            String stDate = valueChangeEvent.getNewValue().toString();
            String res =
                DiffinDays(stDate, endDate) == null ? "" : DiffinDays(stDate,
                                                                      endDate).toString();
            Object days = res;
            int dayss = Integer.parseInt(res);
            if (dayss > 30) {
                re.setAttribute("DiffInDays", "0");
                JSFUtils.addFacesInformationMessage("Days should be equal or less than 30..!");
                this.it13.setValue("0");
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.it13);
            } else {
                re.setAttribute("DiffInDays", days);
                this.it13.setValue(days);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.it13);
            }

        }
    }
    private Date minDate = new Date();

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMinDate() {
        try {
            String Finance =
                (String)JSFUtils.resolveExpression("#{sessionScope.UR}");
            String currentDate = null;
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            if (Finance.equalsIgnoreCase("ROLE_SALES_PERSON/SALE_MANAGER")) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_MONTH, -170);
                java.util.Date date = cal.getTime();
                currentDate = formatter.format(date);
                minDate = formatter.parse(currentDate);
            } else {
                Calendar cal = Calendar.getInstance();
                java.util.Date date = cal.getTime();
                currentDate = formatter.format(date);
                minDate = formatter.parse(currentDate);
            }


            return formatter.parse(currentDate);
        } catch (Exception e) {
            return null;
        }
    }

    public void onChangeReceivedAmnt(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {

            this.it11.setValue(this.getIt12().getValue());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.it11);

        }
    }

    public void onValidateTotalAppliedAmount(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject OfferDtlVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        if (OfferDtlVo.getEstimatedRowCount() > 0) {
            RowSetIterator rs = OfferDtlVo.createRowSet("");
            //BigDecimal totalRecAmnt=new BigDecimal(0);
            Double totalRecAmnt = new Double(0);

            while (rs.hasNext()) {

                Row detailRow = rs.next();

                System.err.println("==========AMOUNT" +
                                   detailRow.getAttribute("RecommendedAmount"));

                String amnt =
                    detailRow.getAttribute("RecommendedAmount") == null ? "0" :
                    detailRow.getAttribute("RecommendedAmount").toString();
                Double RecAmnt = new Double(amnt);
                totalRecAmnt = totalRecAmnt + RecAmnt;


            }


        }


    }


    public void onValidate30Days(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {

            String val = valueChangeEvent.getNewValue().toString();
            int dayss = Integer.parseInt(val);
            if (dayss > 30) {

                JSFUtils.addFacesInformationMessage("Days should be below 30..!");
                //id2
                //val="N";
                this.it13.setValue(null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.it13);
            }
        }


    }

    //    public String onChangePayMode(ValueChangeEvent valueChangeEvent) {
    //        if (valueChangeEvent.getNewValue() != null) {
    //            Object receiptMethodvalue = valueChangeEvent.getNewValue();
    ////            System.err.println("==receipt Method value==" +
    ////                               receiptMethodvalue);
    //            String s1 = receiptMethodvalue.toString();
    ////            System.err.println("=String value="+s1);
    //            Boolean conditionForReceiptMethod = s1.contains("Cash");
    //            Object PayMode= ADFContext.getCurrent().getSessionScope().put("PayMode", "Y");
    //            if (conditionForReceiptMethod == true) {
    ////                System.err.println("===Inside loop===");
    //                setFlag("N");
    //                PayMode= ADFContext.getCurrent().getSessionScope().put("PayMode", "N");
    ////                System.err.println("===Inside loop Flag==="+Flag);
    //            }
    //        }
    ////        System.err.println("===Inside loop Flag 1==="+Flag);
    //        return Flag;
    //    }

    public boolean getChangePayMode() {
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        Object receiptMethodvalue =
            re.getAttribute("PayMode") == null ? "" : re.getAttribute("PayMode").toString();
        String s1 = receiptMethodvalue.toString();
        boolean conditionForReceiptMethod = s1.contains("Cash");

//        Object PayMode = null;
//        if (conditionForReceiptMethod == true) {
//            PayMode =
//                    ADFContext.getCurrent().getSessionScope().put("PayMode", "Y");
//        } else {
//            PayMode =
//                    ADFContext.getCurrent().getSessionScope().put("PayMode", "N");
//        }
        return conditionForReceiptMethod;
    }

    //    public String onChangePayMode(Boolean b){
    //            ViewObject receiptVo =
    //                ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
    //            Row re = receiptVo.getCurrentRow();
    //            if((re.getAttribute("PayRefNumber")!=null&&(re.getAttribute("PayRefDate")!=null))){
    //
    //            }else{
    //
    //            }
    //        return Flag;
    //    }

    public void setFlag(String Flag) {
        this.Flag = Flag;
    }

    public String getFlag() {
        return Flag;
    }

    public void setCustomerName_TransId(RichInputListOfValues customerName_TransId) {
        this.customerName_TransId = customerName_TransId;
    }

    public RichInputListOfValues getCustomerName_TransId() {
        return customerName_TransId;
    }

    public void setIlov1(RichInputListOfValues ilov1) {
        this.ilov1 = ilov1;
    }

    public RichInputListOfValues getIlov1() {
        return ilov1;
    }


    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }
    public void onCheckCashierFlag(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            String cshrFlg = valueChangeEvent.getNewValue().toString();
            if (cshrFlg.equalsIgnoreCase("true")){
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
//                Date date = new Date(timeStamp);
             this.getId6().setValue(timeStamp);
             String uName = ADFContext.getCurrent().getSessionScope().get("userName").toString();
             System.out.println("uName : " + uName);
             this.getIt18().setValue(uName);
             
            }else{
                this.getId6().setValue(null); 
                this.getIt18().setValue(null);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.sbc1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.it18);
    }


    public void setId6(RichInputDate id6) {
        this.id6 = id6;
    }

    public RichInputDate getId6() {
        return id6;
    }

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
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
    public String onClickSave() {
        // Add event code here...
        String finance = (String)JSFUtils.resolveExpression("#{sessionScope.UR}");
        String ack_flag = sbc1.getValue().toString();
        if((finance.equalsIgnoreCase("ACCCOUNTS") && ack_flag.equalsIgnoreCase("false")) || 
           (finance.equalsIgnoreCase("ACCOUNTS_MANAGER") && ack_flag.equalsIgnoreCase("false")) ){ 
            return null;
        }
        else {
            return "toSave"; 
        }
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
}
