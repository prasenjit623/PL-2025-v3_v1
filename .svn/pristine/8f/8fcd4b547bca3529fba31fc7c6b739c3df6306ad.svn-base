package view.backing;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class ReceiptOC {
    private RichInputText it7;
    private RichInputText it6;
    private RichInputDate id2;
    private RichInputText it3;
    private RichInputText it26;
    private RichInputText it19;
    private RichInputText it17;
    private RichInputDate id1;
    private RichSelectBooleanCheckbox sbc1;
    private RichSelectOneChoice soc2;
    private RichSelectOneChoice soc4;

    public ReceiptOC() {
        super();
    }

    public String onClickRcptSave() {
        String bck ="toSave";
        ViewObject vo =
            ADFUtils.findIterator("Receipt_VO5Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String bkId=row.getAttribute("BookingId")==null?"":row.getAttribute("BookingId").toString();
        if(bkId.equals("")){
            bck="backToAddEditOcDp";
        }
        String finance = (String)JSFUtils.resolveExpression("#{sessionScope.UR}");
                String ack_flag = sbc1.getValue().toString();
                if((finance.equalsIgnoreCase("ACCCOUNTS") && ack_flag.equalsIgnoreCase("false")) 
//                   || 
//                   (finance.equalsIgnoreCase("ACCOUNTS_MANAGER") && ack_flag.equalsIgnoreCase("false")) 
                ){ 
                    return null;
                }
                else {   
                 //for calculating total receipt amt and saving in db of recom table   
//                    doCalculate();
                    return bck; 
                }
    }

    public void onClickOKRecActnLstn(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject vo =
            ADFUtils.findIterator("Receipt_VO5Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        //
        String finance =
                  (String)JSFUtils.resolveExpression("#{sessionScope.UR}");
        String ack_flag = sbc1.getValue().toString();
        
        if((finance.equalsIgnoreCase("ACCCOUNTS") && ack_flag.equalsIgnoreCase("false")) 
//           ||
//           (finance.equalsIgnoreCase("ACCOUNTS_MANAGER") && ack_flag.equalsIgnoreCase("false")) 
        ){   
        JSFUtils.addFacesErrorMessage("Please tick the Cashier Acknowledged box");
        }else{
        if (row.getAttribute("ReceiptNumber") == null) {
            String val = xxfnd.generateDocNo("RT", "Booking_AMDataControl");
            Object rVal = val;
            row.setAttribute("ReceiptNumber", rVal);
        }
            if(row.getAttribute("SourceFuncId") == null){
                row.setAttribute("SourceFuncId", "15");
            }
        ADFUtils.findOperation("Commit").execute();
        }
    }

    public void onClickRcptCancel(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Rollback").execute();
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
    }

    public void onChangePayMode(ValueChangeEvent valueChangeEvent) {
        if ((valueChangeEvent.getNewValue() != null &&
                             valueChangeEvent.getNewValue().toString().contains("Cash")) ||
            (valueChangeEvent.getNewValue() != null &&
                                         valueChangeEvent.getNewValue().toString().contains("CASH"))) {
                             id2.setRequired(false);
                             it6.setRequired(false);
                         } else {
                             id2.setRequired(true);
                             it6.setRequired(true);
                         }
                         AdfFacesContext.getCurrentInstance().addPartialTarget(id2);
                         AdfFacesContext.getCurrentInstance().addPartialTarget(it6);
    }
    
    public boolean getChangePayMode() {
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO5Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        Object receiptMethodvalue =
            re.getAttribute("PayMode") == null ? "" : re.getAttribute("PayMode").toString();
        String s1 = receiptMethodvalue.toString();
        boolean conditionForReceiptMethod = s1.contains("Cash") == true ? true : s1.contains("CASH") == true ? true : false;
        
        return conditionForReceiptMethod;
    }

    public void onChangeRecCharge(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
               ViewObject receiptVo =
                   ADFUtils.findIterator("Receipt_VO5Iterator").getViewObject();
               Row re = receiptVo.getCurrentRow();
               if (valueChangeEvent.getNewValue() != null) {

                   if (valueChangeEvent.getNewValue().equals("DV")) {
                       re.setAttribute("RctDesc", "Developer Charges");
        //                       this.it17.setDisabled(true);
                   }

                   if (valueChangeEvent.getNewValue().equals("CN")) {
                       re.setAttribute("RctDesc", "Cancellation Charges");
        //                       this.it17.setDisabled(true);
                   }
                   if (valueChangeEvent.getNewValue().equals("OT")) {
                       re.setAttribute("RctDesc", "");
        //                       this.it17.setDisabled(false);
                   }


               }
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void onChangeChequeDate(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        ViewObject receiptVo =
        ADFUtils.findIterator("Receipt_VO5Iterator").getViewObject();
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
        this.it26.setValue("0");
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.it26);
        } else {
        re.setAttribute("DiffInDays", days);
        this.it26.setValue(days);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.it26);
        }

        }
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
                System.out.println(e);
            }

            try {
                date2 = simpleDateFormat.parse(endDate);
            } catch (ParseException e) {
                System.out.println(e);
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

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void onCalcDateDiff(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO5Iterator").getViewObject();
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
                this.it26.setValue(null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.it26);
            }
        }
    }

    public void setIt26(RichInputText it26) {
        this.it26 = it26;
    }

    public RichInputText getIt26() {
        return it26;
    }

    public void setIt19(RichInputText it19) {
        this.it19 = it19;
    }

    public RichInputText getIt19() {
        return it19;
    }

    public void onChangeReceivedAmnt(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {

            this.it17.setValue(this.getIt19().getValue());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.it17);
        }
    }

    public void setIt17(RichInputText it17) {
        this.it17 = it17;
    }

    public RichInputText getIt17() {
        return it17;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void onCheckCashierFlag(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            String cshrFlg = valueChangeEvent.getNewValue().toString();
            if (cshrFlg.equalsIgnoreCase("true")){
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        //                Date date = new Date(timeStamp);
             this.getId1().setValue(timeStamp);
             String uName = ADFContext.getCurrent().getSessionScope().get("userName").toString();
             System.out.println("uName : " + uName);
             this.getIt3().setValue(uName);
             
            }else{
                this.getId1().setValue(null); 
                this.getIt3().setValue(null);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.sbc1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.it3);
    }

    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }

    public void onSlctPaymentType(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo = ADFUtils.findIterator("Receipt_VO5Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        if (valueChangeEvent.getNewValue() != null) {
            String pTyp = valueChangeEvent.getNewValue().toString();
            String orgId = re.getAttribute("OrgId") == null ? "" : re.getAttribute("OrgId").toString();
            String normOrSD = re.getAttribute("Attribute2") == null ? "" : re.getAttribute("Attribute2").toString();
            System.out.println("pTyp :"+pTyp+" orgId "+orgId+" normOrSD "+normOrSD);
            //Sharjah
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "Cash-Revenue-ADCB");
                soc2.setValue("Cash-Revenue-ADCB");
                soc4.setValue("Cash-Revenue-ADCB");
                System.out.println("PayMode cash :"+soc2.getValue());
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-Cash-ADCB");
                soc2.setValue("SD-Cash-ADCB");
                soc4.setValue("SD-Cash-ADCB");
                System.out.println("PayMode sd cash :"+soc2.getValue());
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
        //                    re.setAttribute("PayMode", "EFT-Revenue-ADCB");
                soc2.setValue("EFT-Revenue-ADCB");
                soc4.setValue("EFT-Revenue-ADCB");
                System.out.println("PayMode eft :"+re.getAttribute("PayMode"));
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
        //                    re.setAttribute("PayMode", "SD-EFT-ADCB");
                soc2.setValue("SD-EFT-ADCB");
                soc4.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "CDC-Revenue-ADCB");
                soc2.setValue("CDC-Revenue-ADCB");
                soc4.setValue("CDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-CDC-ADCB");
                soc2.setValue("SD-CDC-ADCB");
                soc4.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "PDC-Revenue-ADCB");
                soc2.setValue("PDC-Revenue-ADCB");
                soc4.setValue("PDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-PDC-ADCB");
                soc2.setValue("SD-PDC-ADCB");
                soc4.setValue("SD-PDC-ADCB");
            }
            //Dubai
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "Cash-Revenue-ADCB");
                soc2.setValue("Cash-Revenue-ADCB");
                soc4.setValue("Cash-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-Cash-ADCB");
                soc2.setValue("SD-Cash-ADCB");
                soc4.setValue("SD-Cash-ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
        //                    re.setAttribute("PayMode", "EFT-Revenue-ADCB");
                soc2.setValue("EFT-Revenue-ADCB");
                soc4.setValue("EFT-Revenue-ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
        //                    re.setAttribute("PayMode", "SD-EFT-ADCB");
                soc2.setValue("SD-EFT-ADCB");
                soc4.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "CDC-Revenue-ADCB");
                soc2.setValue("CDC-Revenue-ADCB");
                soc4.setValue("CDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-CDC-ADCB");
                soc2.setValue("SD-CDC-ADCB");
                soc4.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "PDC-Revenue-ADCB");
                soc2.setValue("PDC-Revenue-ADCB");
                soc4.setValue("PDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-PDC-ADCB");
                soc2.setValue("SD-PDC-ADCB");
                soc4.setValue("SD-PDC-ADCB");
            }
            //Almisk properties management
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "Cash-Al Misk-ADCB");
                soc2.setValue("Cash_Al Misk_ADCB");
                soc4.setValue("Cash_Al Misk_ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
        //                    re.setAttribute("PayMode", "EFT-Al Misk-ADCB");
                soc2.setValue("EFT_Al Misk_ADCB");
                soc4.setValue("EFT_Al Misk_ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "CDC-Al Misk-ADCB");
                soc2.setValue("CDC_Al Misk_ADCB");
                soc4.setValue("CDC_Al Misk_ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "PDC-Al Misk-ADCB");
                soc2.setValue("PDC_Al Misk_ADCB");
                soc4.setValue("PDC_Al Misk_ADCB");
            }
            //Alfa holding dummy receipt method
            if(orgId.equalsIgnoreCase("300000007801262")){
                soc2.setValue(" ");
                soc4.setValue(" ");
            }
            //
            //Alfa Smart BU
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "Cash-Al Misk-ADCB");
                soc2.setValue("Cash_Alfa Smart_ADCB");
                soc4.setValue("Cash_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "Cash-Al Misk-ADCB");
                soc2.setValue("SD-Cash-ADCB");
                soc4.setValue("SD-Cash-ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                    re.setAttribute("PayMode", "EFT-Al Misk-ADCB");
                soc2.setValue("EFT_Alfa Smart_ADCB");
                soc4.setValue("EFT_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                    re.setAttribute("PayMode", "EFT-Al Misk-ADCB");
            soc2.setValue("SD-EFT-ADCB");
            soc4.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "CDC-Al Misk-ADCB");
                soc2.setValue("CDC_Alfa Smart_ADCB");
                soc4.setValue("CDC_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "CDC-Al Misk-ADCB");
                soc2.setValue("SD-CDC-ADCB");
                soc4.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "PDC-Al Misk-ADCB");
                soc2.setValue("PDC_Alfa Smart_ADCB");
                soc4.setValue("PDC_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "PDC-Al Misk-ADCB");
                soc2.setValue("SD-PDC-ADCB");
                soc4.setValue("SD-PDC-ADCB");
            }
            //ALF Technical
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "Cash-Revenue-ADCB");
                soc2.setValue("CASH-ALFTECH-ADCB");
                soc4.setValue("CASH-ALFTECH-ADCB");
                System.out.println("PayMode cash :"+soc2.getValue());
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "SD-Cash-ADCB");
                soc2.setValue("SD-Cash-ADCB");
                soc4.setValue("SD-Cash-ADCB");
                System.out.println("PayMode sd cash :"+soc2.getValue());
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                    re.setAttribute("PayMode", "EFT-Revenue-ADCB");
                soc2.setValue("EFT-ALFTECH-ADCB");
                soc4.setValue("EFT-ALFTECH-ADCB");
                System.out.println("PayMode eft :"+re.getAttribute("PayMode"));
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                    re.setAttribute("PayMode", "SD-EFT-ADCB");
                soc2.setValue("SD-EFT-ADCB");
                soc4.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "CDC-Revenue-ADCB");
                soc2.setValue("CDC-ALFTECH-ADCB");
                soc4.setValue("CDC-ALFTECH-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "SD-CDC-ADCB");
                soc2.setValue("SD-CDC-ADCB");
                soc4.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "PDC-Revenue-ADCB");
                soc2.setValue("PDC-ALFTECH-ADCB");
                soc4.setValue("PDC-ALFTECH-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "SD-PDC-ADCB");
                soc2.setValue("SD-PDC-ADCB");
                soc4.setValue("SD-PDC-ADCB");
            }
            //
            if ((valueChangeEvent.getNewValue() != null &&
                                 valueChangeEvent.getNewValue().toString().contains("Cash")) ||
                (valueChangeEvent.getNewValue() != null &&
                                             valueChangeEvent.getNewValue().toString().contains("CASH"))) {
                                 id2.setRequired(false);
                                 it6.setRequired(false);
                             } else {
                                 id2.setRequired(true);
                                 it6.setRequired(true);
                             }
                             AdfFacesContext.getCurrentInstance().addPartialTarget(soc2);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(soc4);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(id2);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(it6);
        }
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSoc4(RichSelectOneChoice soc4) {
        this.soc4 = soc4;
    }

    public RichSelectOneChoice getSoc4() {
        return soc4;
    }

    public String doCancelOk() {
        // Add event code here...
        String bck ="toSave";
        ViewObject vo = ADFUtils.findIterator("Receipt_VO5Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String ocFlag = ADFContext.getCurrent().getPageFlowScope().get("ocFlag").toString();
        System.out.println("ocFlag %%"+ocFlag);
//        String bkId=row.getAttribute("BookingId")==null?"0":row.getAttribute("BookingId").toString();
            if(ocFlag.equals("DP")){
                bck="backToAddEditOcDp";
            }
        return bck;
    }
}
