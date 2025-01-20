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

public class ReceiptBKBean {
    private RichInputText it7;
    private RichInputDate id2;
    private RichInputText it5;
    private RichInputText it14;
    private RichInputText it15;
    private RichInputText it17;
    private RichInputDate id3;
    private RichSelectBooleanCheckbox sbc1;
    private RichSelectOneChoice soc1;
    private RichSelectOneChoice soc2;
    private RichSelectOneChoice soc4;
    private RichSelectOneChoice soc5;

    public ReceiptBKBean() {
        super();
    }

    public String onClickRcptSave() {
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
                    return "toSave"; 
                }
    }
   
    public void onClickOKRecActnLstn(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject vo =
            ADFUtils.findIterator("Receipt_VO2Iterator").getViewObject();
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
                row.setAttribute("SourceFuncId", "7");
            }
            String bmsdId =
                JSFUtils.resolveExpression("#{pageFlowScope.BmsdId}")== null ? ""
                :JSFUtils.resolveExpression("#{pageFlowScope.BmsdId}").toString();
            if (!bmsdId.equalsIgnoreCase("")){
                ViewObject bkMsDtlVo1 =
                    ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
                bkMsDtlVo1.getCurrentRow().setAttribute("Attribute1", "RECEIPT_CREATED");
                System.out.println("Inside receiptBK mbmsdID if condn");
                System.out.println("bmsdtl id inside RcptBK : "+bmsdId);
            }
        ADFUtils.findOperation("Commit").execute();
        }
    }

    public void onChangePayMode(ValueChangeEvent valueChangeEvent) {
        if ((valueChangeEvent.getNewValue() != null &&
                             valueChangeEvent.getNewValue().toString().contains("Cash")) ||
            (valueChangeEvent.getNewValue() != null &&
                                         valueChangeEvent.getNewValue().toString().contains("CASH"))) {
                             id2.setRequired(false);
                             it7.setRequired(false);
                         } else {
                             id2.setRequired(true);
                             it7.setRequired(true);
                         }
                         AdfFacesContext.getCurrentInstance().addPartialTarget(id2);
                         AdfFacesContext.getCurrentInstance().addPartialTarget(it7);
    }
    public boolean getChangePayMode() {
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO2Iterator").getViewObject();
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
                   ADFUtils.findIterator("Receipt_VO2Iterator").getViewObject();
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
//
                    String onlyForBkDv=JSFUtils.resolveExpression("#{pageFlowScope.A}")==null?"0":JSFUtils.resolveExpression("#{pageFlowScope.A}").toString();
                   if (valueChangeEvent.getNewValue().equals("OT") || valueChangeEvent.getNewValue().equals("CN")){
                    System.out.println(onlyForBkDv);
                       re.setAttribute("RctType", "DV");
                       re.setAttribute("RctDesc", "Developer Charges");
                       AdfFacesContext.getCurrentInstance().addPartialTarget(soc1);
                       JSFUtils.addFacesErrorMessage("Please create other charges from other charges panel");
                   }
               }
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
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
        ADFUtils.findIterator("Receipt_VO2Iterator").getViewObject();
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
        this.it14.setValue("0");
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.it14);
        } else {
        re.setAttribute("DiffInDays", days);
        this.it14.setValue(days);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.it14);
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

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void onCalcDateDiff(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO2Iterator").getViewObject();
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
                this.it14.setValue(null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.it14);
            }
        }
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

    public void setIt17(RichInputText it17) {
        this.it17 = it17;
    }

    public RichInputText getIt17() {
        return it17;
    }

    public void onChangeReceivedAmnt(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {

            this.it17.setValue(this.getIt15().getValue());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.it17);

        }
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void onClickRcptCancel(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Rollback").execute();
    }

    public void onCheckCashierFlag(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            String cshrFlg = valueChangeEvent.getNewValue().toString();
            if (cshrFlg.equalsIgnoreCase("true")){
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        //                Date date = new Date(timeStamp);
             this.getId3().setValue(timeStamp);
             String uName = ADFContext.getCurrent().getSessionScope().get("userName").toString();
             System.out.println("uName : " + uName);
             this.getIt5().setValue(uName);
             
            }else{
                this.getId3().setValue(null); 
                this.getIt5().setValue(null);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.sbc1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.it5);
    }

    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void onSlctPaymentType(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo = ADFUtils.findIterator("Receipt_VO2Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        if (valueChangeEvent.getNewValue() != null) {
            String pTyp = valueChangeEvent.getNewValue().toString();
            String orgId = re.getAttribute("OrgId") == null ? "" : re.getAttribute("OrgId").toString();
            String normOrSD = re.getAttribute("Attribute2") == null ? "Normal" : re.getAttribute("Attribute2").toString();
            System.out.println("pTyp :"+pTyp+" orgId "+orgId+" normOrSD "+normOrSD);
            //Sharjah
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "Cash-Revenue-ADCB");
                soc2.setValue("Cash-Revenue-ADCB");
                soc4.setValue("Cash-Revenue-ADCB");
                soc5.setValue("Cash-Revenue-ADCB");
                System.out.println("PayMode cash :"+re.getAttribute("PayMode"));
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-Cash-ADCB");
                soc2.setValue("SD-Cash-ADCB");
                soc4.setValue("SD-Cash-ADCB");
                soc5.setValue("SD-Cash-ADCB");
                System.out.println("PayMode sd cash :"+re.getAttribute("PayMode"));
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
        //                    re.setAttribute("PayMode", "EFT-Revenue-ADCB");
                soc2.setValue("EFT-Revenue-ADCB");
                soc4.setValue("EFT-Revenue-ADCB");
                soc5.setValue("EFT-Revenue-ADCB");
                System.out.println("PayMode eft :"+re.getAttribute("PayMode"));
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
        //                    re.setAttribute("PayMode", "SD-EFT-ADCB");
                soc2.setValue("SD-EFT-ADCB");
                soc4.setValue("SD-EFT-ADCB");
                soc5.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "CDC-Revenue-ADCB");
                soc2.setValue("CDC-Revenue-ADCB");
                soc4.setValue("CDC-Revenue-ADCB");
                soc5.setValue("CDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-CDC-ADCB");
                soc2.setValue("SD-CDC-ADCB");
                soc4.setValue("SD-CDC-ADCB");
                soc5.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "PDC-Revenue-ADCB");
                soc2.setValue("PDC-Revenue-ADCB");
                soc4.setValue("PDC-Revenue-ADCB");
                soc5.setValue("PDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-PDC-ADCB");
                soc2.setValue("SD-PDC-ADCB");
                soc4.setValue("SD-PDC-ADCB");
                soc5.setValue("SD-PDC-ADCB");
            }
            //Dubai
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "Cash-Revenue-ADCB");
                soc2.setValue("Cash-Revenue-ADCB");
                soc4.setValue("Cash-Revenue-ADCB");
                soc5.setValue("Cash-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-Cash-ADCB");
                soc2.setValue("SD-Cash-ADCB");
                soc4.setValue("SD-Cash-ADCB");
                soc5.setValue("SD-Cash-ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
        //                    re.setAttribute("PayMode", "EFT-Revenue-ADCB");
                soc2.setValue("EFT-Revenue-ADCB");
                soc4.setValue("EFT-Revenue-ADCB");
                soc5.setValue("EFT-Revenue-ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
        //                    re.setAttribute("PayMode", "SD-EFT-ADCB");
                soc2.setValue("SD-EFT-ADCB");
                soc4.setValue("SD-EFT-ADCB");
                soc5.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "CDC-Revenue-ADCB");
                soc2.setValue("CDC-Revenue-ADCB");
                soc4.setValue("CDC-Revenue-ADCB");
                soc5.setValue("CDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-CDC-ADCB");
                soc2.setValue("SD-CDC-ADCB");
                soc4.setValue("SD-CDC-ADCB");
                soc5.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "PDC-Revenue-ADCB");
                soc2.setValue("PDC-Revenue-ADCB");
                soc4.setValue("PDC-Revenue-ADCB");
                soc5.setValue("PDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
        //                re.setAttribute("PayMode", "SD-PDC-ADCB");
                soc2.setValue("SD-PDC-ADCB");
                soc4.setValue("SD-PDC-ADCB");
                soc5.setValue("SD-PDC-ADCB");
            }
            //Almisk properties management
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "Cash-Al Misk-ADCB");
                soc2.setValue("Cash_Al Misk_ADCB");
                soc4.setValue("Cash_Al Misk_ADCB");
                soc5.setValue("Cash_Al Misk_ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
        //                    re.setAttribute("PayMode", "EFT-Al Misk-ADCB");
                soc2.setValue("EFT_Al Misk_ADCB");
                soc4.setValue("EFT_Al Misk_ADCB");
                soc5.setValue("EFT_Al Misk_ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "CDC-Al Misk-ADCB");
                soc2.setValue("CDC_Al Misk_ADCB");
                soc4.setValue("CDC_Al Misk_ADCB");
                soc5.setValue("CDC_Al Misk_ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
        //                re.setAttribute("PayMode", "PDC-Al Misk-ADCB");
                soc2.setValue("PDC_Al Misk_ADCB");
                soc4.setValue("PDC_Al Misk_ADCB");
                soc5.setValue("PDC_Al Misk_ADCB");
            }
            //Alfa holding dummy receipt method
            if(orgId.equalsIgnoreCase("300000007801262") || orgId.equalsIgnoreCase("")){
                soc2.setValue(" ");
                soc4.setValue(" ");
                soc5.setValue(" ");
            }
            //
            //Alfa smart
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "Cash-Al Misk-ADCB");
                soc2.setValue("Cash_Alfa Smart_ADCB");
                soc4.setValue("Cash_Alfa Smart_ADCB");
                soc5.setValue("Cash_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "Cash-Al Misk-ADCB");
                soc2.setValue("SD-Cash-ADCB");
                soc4.setValue("SD-Cash-ADCB");
                soc5.setValue("SD-Cash-ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                    re.setAttribute("PayMode", "EFT-Al Misk-ADCB");
                soc2.setValue("EFT_Alfa Smart_ADCB");
                soc4.setValue("EFT_Alfa Smart_ADCB");
                soc5.setValue("EFT_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                    re.setAttribute("PayMode", "EFT-Al Misk-ADCB");
            soc2.setValue("SD-EFT-ADCB");
            soc4.setValue("SD-EFT-ADCB");
            soc5.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "CDC-Al Misk-ADCB");
                soc2.setValue("CDC_Alfa Smart_ADCB");
                soc4.setValue("CDC_Alfa Smart_ADCB");
                soc5.setValue("CDC_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "CDC-Al Misk-ADCB");
                soc2.setValue("SD-CDC-ADCB");
                soc4.setValue("SD-CDC-ADCB");
                soc5.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "PDC-Al Misk-ADCB");
                soc2.setValue("PDC_Alfa Smart_ADCB");
                soc4.setValue("PDC_Alfa Smart_ADCB");
                soc5.setValue("PDC_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "PDC-Al Misk-ADCB");
                soc2.setValue("SD-PDC-ADCB");
                soc4.setValue("SD-PDC-ADCB");
                soc5.setValue("SD-PDC-ADCB");
            }
            //ALF Technical
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "Cash-Revenue-ADCB");
                soc2.setValue("CASH-ALFTECH-ADCB");
                soc4.setValue("CASH-ALFTECH-ADCB");
                soc5.setValue("CASH-ALFTECH-ADCB");
                System.out.println("PayMode cash :"+re.getAttribute("PayMode"));
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "SD-Cash-ADCB");
                soc2.setValue("SD-Cash-ADCB");
                soc4.setValue("SD-Cash-ADCB");
                soc5.setValue("SD-Cash-ADCB");
                System.out.println("PayMode sd cash :"+re.getAttribute("PayMode"));
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                    re.setAttribute("PayMode", "EFT-Revenue-ADCB");
                soc2.setValue("EFT-ALFTECH-ADCB");
                soc4.setValue("EFT-ALFTECH-ADCB");
                soc5.setValue("EFT-ALFTECH-ADCB");
                System.out.println("PayMode eft :"+re.getAttribute("PayMode"));
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                    re.setAttribute("PayMode", "SD-EFT-ADCB");
                soc2.setValue("SD-EFT-ADCB");
                soc4.setValue("SD-EFT-ADCB");
                soc5.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "CDC-Revenue-ADCB");
                soc2.setValue("CDC-ALFTECH-ADCB");
                soc4.setValue("CDC-ALFTECH-ADCB");
                soc5.setValue("CDC-ALFTECH-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "SD-CDC-ADCB");
                soc2.setValue("SD-CDC-ADCB");
                soc4.setValue("SD-CDC-ADCB");
                soc5.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "PDC-Revenue-ADCB");
                soc2.setValue("PDC-ALFTECH-ADCB");
                soc4.setValue("PDC-ALFTECH-ADCB");
                soc5.setValue("PDC-ALFTECH-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "SD-PDC-ADCB");
                soc2.setValue("SD-PDC-ADCB");
                soc4.setValue("SD-PDC-ADCB");
                soc5.setValue("SD-PDC-ADCB");
            }
            //
            if ((valueChangeEvent.getNewValue() != null &&
                                 valueChangeEvent.getNewValue().toString().contains("Cash")) ||
                (valueChangeEvent.getNewValue() != null &&
                                             valueChangeEvent.getNewValue().toString().contains("CASH"))) {
                                 id2.setRequired(false);
                                 it7.setRequired(false);
                             } else {
                                 id2.setRequired(true);
                                 it7.setRequired(true);
                             }
                             AdfFacesContext.getCurrentInstance().addPartialTarget(soc2);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(soc4);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(soc5);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(id2);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(it7);
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

    public void setSoc5(RichSelectOneChoice soc5) {
        this.soc5 = soc5;
    }

    public RichSelectOneChoice getSoc5() {
        return soc5;
    }

    public void onChkVatDesc(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo = ADFUtils.findIterator("Receipt_VO2Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        if (valueChangeEvent.getNewValue() != null) {
//            if(valueChangeEvent.getNewValue().equals("Y")){
            re.setAttribute("Description", "VAT");
//            }else{
//                re.setAttribute("Description", "");
//            }
        }
    }
}
