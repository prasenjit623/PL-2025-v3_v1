package view.backing;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
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
public class ReceiptRecBean {
    private RichSelectBooleanCheckbox sbc1;
    private RichInputComboboxListOfValues ilov1;
    private RichInputText it3;
    private RichInputDate id2;
    private RichInputText it26;
    private RichInputDate id1;
    private RichInputText it29;
    private RichInputText it28;
    private RichInputText it4;
    private RichInputText it2;
    private RichSelectOneChoice soc3;
    private RichSelectOneChoice soc1;
    private RichSelectOneChoice soc5;

    public ReceiptRecBean() {
    }

    public String onClickSave() {
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
    public void doCalculate() {
           BigDecimal total=new BigDecimal("0");
//           int total = 0;
//           int rcptTotal = 0;
           BigDecimal rcptTotal=new BigDecimal("0");
                       ViewObject rcptVo3 =
                           ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
                       ViewObject rcptVo2 =
                           ADFUtils.findIterator("Receipt_VO2Iterator").getViewObject();
                       ViewCriteria vc = rcptVo2.createViewCriteria();
                       ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                       vcRow.setAttribute("BookingId", rcptVo3.getCurrentRow().getAttribute("BookingId"));
                       vcRow.setAttribute("SourceFuncId", "not like 15");
                       vcRow.setAttribute("RctType", "not like CN");
                       vc.addRow(vcRow);
                       rcptVo2.applyViewCriteria(vc);
                       rcptVo2.executeQuery();
                       System.out.println("nos.... of rcpt :" + rcptVo2.getEstimatedRowCount());
           //for total receipt calcu
           RowSetIterator rRsi = rcptVo2.createRowSetIterator(null);
           while (rRsi.hasNext()) {
               Row row = rRsi.next();
               String rcptAmt =
                   row.getAttribute("ReceivedAmount") == null ? "0" : row.getAttribute("ReceivedAmount").toString();
               System.out.println("Receipt Amt = " + rcptAmt);
               BigDecimal rAmt = new BigDecimal(rcptAmt);
               rcptTotal = rAmt.add(rcptTotal);
           }
           System.out.println("total receipt :"+rcptTotal);
           Object recomId = JSFUtils.resolveExpression("#{pageFlowScope.scfnId}");
           System.out.println("recom ID:"+recomId);
           ViewObject recomVo =
               ADFUtils.findIterator("RecommendHeader_VO1Iterator").getViewObject();
           ViewCriteria viewc = recomVo.createViewCriteria();
           ViewCriteriaRow viewcRow = viewc.createViewCriteriaRow();
           viewcRow.setAttribute("RecommendId", recomId);
           viewc.addRow(viewcRow);
           recomVo.applyViewCriteria(viewc);
           recomVo.executeQuery();
           recomVo.first().setAttribute("ReceiptAmount",rcptTotal);
           ADFUtils.findOperation("Commit").execute();
       }

    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }

    public void onClickOKRec(ActionEvent actionEvent) {
               ViewObject vo =
                   ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
               Row row = vo.getCurrentRow();
               //
               String finance =
                         (String)JSFUtils.resolveExpression("#{sessionScope.UR}");
               String ack_flag = sbc1.getValue().toString();
               
        if((finance.equalsIgnoreCase("ACCCOUNTS") && ack_flag.equalsIgnoreCase("false")) 
//           ||
//            (finance.equalsIgnoreCase("ACCOUNTS_MANAGER") && ack_flag.equalsIgnoreCase("false")) 
        ){   
            JSFUtils.addFacesErrorMessage("Please tick the Cashier Acknowledged box");
        }else{
               if (row.getAttribute("ReceiptNumber") == null) {
                   String val = xxfnd.generateDocNo("RT", "Booking_AMDataControl");
                   Object rVal = val;
                   row.setAttribute("ReceiptNumber", rVal);
               }
            if(row.getAttribute("SourceFuncId") == null){
                row.setAttribute("SourceFuncId", "10");
            }
            String bmsdId =
                JSFUtils.resolveExpression("#{pageFlowScope.BmsdId}")== null ? ""
                :JSFUtils.resolveExpression("#{pageFlowScope.BmsdId}").toString();
            if (!bmsdId.equalsIgnoreCase("")){
                ViewObject bkMsDtlVo1 =
                    ADFUtils.findIterator("Booking_Milestone_VO2Iterator").getViewObject();
                bkMsDtlVo1.getCurrentRow().setAttribute("Attribute1", "RECEIPT_CREATED");
                System.out.println("Inside receiptRC mbmsdID if condn");
                System.out.println("bmsdtl id inside RcptRC : "+bmsdId);
            }
            ADFUtils.findOperation("Commit").execute();
        }
    }

    public void onClickCancel(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.findOperation("Rollback").execute();
    }

    public void setIlov1(RichInputComboboxListOfValues ilov1) {
        this.ilov1 = ilov1;
    }

    public RichInputComboboxListOfValues getIlov1() {
        return ilov1;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void onChangePayMode(ValueChangeEvent valueChangeEvent) {
        if ((valueChangeEvent.getNewValue() != null &&
                             valueChangeEvent.getNewValue().toString().contains("Cash")) ||
            (valueChangeEvent.getNewValue() != null &&
                                         valueChangeEvent.getNewValue().toString().contains("CASH"))) {
                             id2.setRequired(false);
                             it2.setRequired(false);
                         } else {
                             id2.setRequired(true);
                             it2.setRequired(true);
                         }
                         AdfFacesContext.getCurrentInstance().addPartialTarget(id2);
                         AdfFacesContext.getCurrentInstance().addPartialTarget(it2);
    }

    public void onChangeRecCharge(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
               ViewObject receiptVo =
                   ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
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

    public void setIt26(RichInputText it26) {
        this.it26 = it26;
    }

    public RichInputText getIt26() {
        return it26;
    }

    public void onChangeChequeDate(ValueChangeEvent valueChangeEvent) {
        // Add event code here...

        ViewObject receiptVo =
        ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
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
    
    public boolean getChangePayMode() {
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        Object receiptMethodvalue =
            re.getAttribute("PayMode") == null ? "" : re.getAttribute("PayMode").toString();
        String s1 = receiptMethodvalue.toString();
        boolean conditionForReceiptMethod = s1.contains("Cash") == true ? true : s1.contains("CASH") == true ? true : false;

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
    public void onCheckCashierFlag(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            String cshrFlg = valueChangeEvent.getNewValue().toString();
            if (cshrFlg.equalsIgnoreCase("true")){
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    //                Date date = new Date(timeStamp);
             this.getId1().setValue(timeStamp);
             String uName = ADFContext.getCurrent().getSessionScope().get("userName").toString();
             System.out.println("uName : " + uName);
             this.getIt29().setValue(uName);
             
            }else{
                this.getId1().setValue(null); 
                this.getIt29().setValue(null);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.sbc1);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.it29);
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setIt29(RichInputText it29) {
        this.it29 = it29;
    }

    public RichInputText getIt29() {
        return it29;
    }
    public void onCalcDateDiff(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo =
            ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
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
    public void onChangeReceivedAmnt(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {

            this.it4.setValue(this.getIt28().getValue());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.it4);

        }
    }

    public void setIt28(RichInputText it28) {
        this.it28 = it28;
    }

    public RichInputText getIt28() {
        return it28;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void onSlctPaymentType(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo = ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        if (valueChangeEvent.getNewValue() != null) {
            String pTyp = valueChangeEvent.getNewValue().toString();
            String orgId = re.getAttribute("OrgId") == null ? "" : re.getAttribute("OrgId").toString();
            String normOrSD = re.getAttribute("Attribute2") == null ? "Normal" : re.getAttribute("Attribute2").toString();
            System.out.println("pTyp :"+pTyp+" orgId "+orgId+" normOrSD "+normOrSD);
            //Sharjah
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
//                re.setAttribute("PayMode", "Cash-Revenue-ADCB");
                soc3.setValue("Cash-Revenue-ADCB");
                soc1.setValue("Cash-Revenue-ADCB");
                soc5.setValue("Cash-Revenue-ADCB");
                System.out.println("PayMode cash :"+re.getAttribute("PayMode"));
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
//                re.setAttribute("PayMode", "SD-Cash-ADCB");
                soc3.setValue("SD-Cash-ADCB");
                soc1.setValue("SD-Cash-ADCB");
                soc5.setValue("SD-Cash-ADCB");
                System.out.println("PayMode sd cash :"+soc5.getValue());
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
//                    re.setAttribute("PayMode", "EFT-Revenue-ADCB");
                soc3.setValue("EFT-Revenue-ADCB");
                soc1.setValue("EFT-Revenue-ADCB");
                soc5.setValue("EFT-Revenue-ADCB");
                System.out.println("PayMode eft :"+re.getAttribute("PayMode"));
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
//                    re.setAttribute("PayMode", "SD-EFT-ADCB");
                soc3.setValue("SD-EFT-ADCB");
                soc1.setValue("SD-EFT-ADCB");
                soc5.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
//                re.setAttribute("PayMode", "CDC-Revenue-ADCB");
                soc3.setValue("CDC-Revenue-ADCB");
                soc1.setValue("CDC-Revenue-ADCB");
                soc5.setValue("CDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
//                re.setAttribute("PayMode", "SD-CDC-ADCB");
                soc3.setValue("SD-CDC-ADCB");
                soc1.setValue("SD-CDC-ADCB");
                soc5.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("Normal")){
//                re.setAttribute("PayMode", "PDC-Revenue-ADCB");
                soc3.setValue("PDC-Revenue-ADCB");
                soc1.setValue("PDC-Revenue-ADCB");
                soc5.setValue("PDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937026") && normOrSD.equalsIgnoreCase("SD")){
//                re.setAttribute("PayMode", "SD-PDC-ADCB");
                soc3.setValue("SD-PDC-ADCB");
                soc1.setValue("SD-PDC-ADCB");
                soc5.setValue("SD-PDC-ADCB");
            }
            //Dubai
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
//                re.setAttribute("PayMode", "Cash-Revenue-ADCB");
                soc3.setValue("Cash-Revenue-ADCB");
                soc1.setValue("Cash-Revenue-ADCB");
                soc5.setValue("Cash-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
//                re.setAttribute("PayMode", "SD-Cash-ADCB");
                soc3.setValue("SD-Cash-ADCB");
                soc1.setValue("SD-Cash-ADCB");
                soc5.setValue("SD-Cash-ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
//                    re.setAttribute("PayMode", "EFT-Revenue-ADCB");
                soc3.setValue("EFT-Revenue-ADCB");
                soc1.setValue("EFT-Revenue-ADCB");
                soc5.setValue("EFT-Revenue-ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
//                    re.setAttribute("PayMode", "SD-EFT-ADCB");
                soc3.setValue("SD-EFT-ADCB");
                soc1.setValue("SD-EFT-ADCB");
                soc5.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
//                re.setAttribute("PayMode", "CDC-Revenue-ADCB");
                soc3.setValue("CDC-Revenue-ADCB");
                soc1.setValue("CDC-Revenue-ADCB");
                soc5.setValue("CDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
//                re.setAttribute("PayMode", "SD-CDC-ADCB");
                soc3.setValue("SD-CDC-ADCB");
                soc1.setValue("SD-CDC-ADCB");
                soc5.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("Normal")){
//                re.setAttribute("PayMode", "PDC-Revenue-ADCB");
                soc3.setValue("PDC-Revenue-ADCB");
                soc1.setValue("PDC-Revenue-ADCB");
                soc5.setValue("PDC-Revenue-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937102") && normOrSD.equalsIgnoreCase("SD")){
//                re.setAttribute("PayMode", "SD-PDC-ADCB");
                soc3.setValue("SD-PDC-ADCB");
                soc1.setValue("SD-PDC-ADCB");
                soc5.setValue("SD-PDC-ADCB");
            }
            //Almisk properties management
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
//                re.setAttribute("PayMode", "Cash-Al Misk-ADCB");
                soc3.setValue("Cash_Al Misk_ADCB");
                soc1.setValue("Cash_Al Misk_ADCB");
                soc5.setValue("Cash_Al Misk_ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
//                    re.setAttribute("PayMode", "EFT-Al Misk-ADCB");
                soc3.setValue("EFT_Al Misk_ADCB");
                soc1.setValue("EFT_Al Misk_ADCB");
                soc5.setValue("EFT_Al Misk_ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
//                re.setAttribute("PayMode", "CDC-Al Misk-ADCB");
                soc3.setValue("CDC_Al Misk_ADCB");
                soc1.setValue("CDC_Al Misk_ADCB");
                soc5.setValue("CDC_Al Misk_ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000001937178") && normOrSD.equalsIgnoreCase("Normal")){
//                re.setAttribute("PayMode", "PDC-Al Misk-ADCB");
                soc3.setValue("PDC_Al Misk_ADCB");
                soc1.setValue("PDC_Al Misk_ADCB");
                soc5.setValue("PDC_Al Misk_ADCB");
            }
            //Alfa holding dummy receipt method
            if(orgId.equalsIgnoreCase("300000007801262") || orgId.equalsIgnoreCase("")){
                soc3.setValue(" ");
                soc1.setValue(" ");
                soc5.setValue(" ");
            }
            //
            //Alfa Smart BU
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "Cash-Al Misk-ADCB");
                soc3.setValue("Cash_Alfa Smart_ADCB");
                soc1.setValue("Cash_Alfa Smart_ADCB");
                soc5.setValue("Cash_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "Cash-Al Misk-ADCB");
                soc3.setValue("SD-Cash-ADCB");
                soc1.setValue("SD-Cash-ADCB");
                soc5.setValue("SD-Cash-ADCB");
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                    re.setAttribute("PayMode", "EFT-Al Misk-ADCB");
                soc3.setValue("EFT_Alfa Smart_ADCB");
                soc1.setValue("EFT_Alfa Smart_ADCB");
                soc5.setValue("EFT_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                    re.setAttribute("PayMode", "EFT-Al Misk-ADCB");
            soc3.setValue("SD-EFT-ADCB");
            soc1.setValue("SD-EFT-ADCB");
            soc5.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "CDC-Al Misk-ADCB");
                soc3.setValue("CDC_Alfa Smart_ADCB");
                soc1.setValue("CDC_Alfa Smart_ADCB");
                soc5.setValue("CDC_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "CDC-Al Misk-ADCB");
                soc3.setValue("SD-CDC-ADCB");
                soc1.setValue("SD-CDC-ADCB");
                soc5.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "PDC-Al Misk-ADCB");
                soc3.setValue("PDC_Alfa Smart_ADCB");
                soc1.setValue("PDC_Alfa Smart_ADCB");
                soc5.setValue("PDC_Alfa Smart_ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000021774129") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "PDC-Al Misk-ADCB");
                soc3.setValue("SD-PDC-ADCB");
                soc1.setValue("SD-PDC-ADCB");
                soc5.setValue("SD-PDC-ADCB");
            }
            //ALF Technical
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "Cash-Revenue-ADCB");
                soc3.setValue("CASH-ALFTECH-ADCB");
                soc1.setValue("CASH-ALFTECH-ADCB");
                soc5.setValue("CASH-ALFTECH-ADCB");
                System.out.println("PayMode cash :"+re.getAttribute("PayMode"));
            }
            if(pTyp.equalsIgnoreCase("CASH") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "SD-Cash-ADCB");
                soc3.setValue("SD-Cash-ADCB");
                soc1.setValue("SD-Cash-ADCB");
                soc5.setValue("SD-Cash-ADCB");
                System.out.println("PayMode sd cash :"+soc5.getValue());
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                    re.setAttribute("PayMode", "EFT-Revenue-ADCB");
                soc3.setValue("EFT-ALFTECH-ADCB");
                soc1.setValue("EFT-ALFTECH-ADCB");
                soc5.setValue("EFT-ALFTECH-ADCB");
                System.out.println("PayMode eft :"+re.getAttribute("PayMode"));
            }
                if(pTyp.equalsIgnoreCase("EFT") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                    re.setAttribute("PayMode", "SD-EFT-ADCB");
                soc3.setValue("SD-EFT-ADCB");
                soc1.setValue("SD-EFT-ADCB");
                soc5.setValue("SD-EFT-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "CDC-Revenue-ADCB");
                soc3.setValue("CDC-ALFTECH-ADCB");
                soc1.setValue("CDC-ALFTECH-ADCB");
                soc5.setValue("CDC-ALFTECH-ADCB");
            }
            if(pTyp.equalsIgnoreCase("CDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "SD-CDC-ADCB");
                soc3.setValue("SD-CDC-ADCB");
                soc1.setValue("SD-CDC-ADCB");
                soc5.setValue("SD-CDC-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("Normal")){
            //                re.setAttribute("PayMode", "PDC-Revenue-ADCB");
                soc3.setValue("PDC-ALFTECH-ADCB");
                soc1.setValue("PDC-ALFTECH-ADCB");
                soc5.setValue("PDC-ALFTECH-ADCB");
            }
            if(pTyp.equalsIgnoreCase("PDC") && orgId.equalsIgnoreCase("300000002841399") && normOrSD.equalsIgnoreCase("SD")){
            //                re.setAttribute("PayMode", "SD-PDC-ADCB");
                soc3.setValue("SD-PDC-ADCB");
                soc1.setValue("SD-PDC-ADCB");
                soc5.setValue("SD-PDC-ADCB");
            }
            //
            if ((valueChangeEvent.getNewValue() != null &&
                                 valueChangeEvent.getNewValue().toString().contains("Cash")) ||
                (valueChangeEvent.getNewValue() != null &&
                                             valueChangeEvent.getNewValue().toString().contains("CASH"))) {
                                 id2.setRequired(false);
                                 it2.setRequired(false);
                             } else {
                                 id2.setRequired(true);
                                 it2.setRequired(true);
                             }
                             AdfFacesContext.getCurrentInstance().addPartialTarget(soc3);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(soc1);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(soc5);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(id2);
                             AdfFacesContext.getCurrentInstance().addPartialTarget(it2);
                             
        }
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSoc5(RichSelectOneChoice soc5) {
        this.soc5 = soc5;
    }

    public RichSelectOneChoice getSoc5() {
        return soc5;
    }

    public void onChkVatDesc(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject receiptVo = ADFUtils.findIterator("Receipt_VO3Iterator").getViewObject();
        Row re = receiptVo.getCurrentRow();
        System.out.println("Description before :"+re.getAttribute("Description"));
        if (valueChangeEvent.getNewValue() != null) {
//            if(valueChangeEvent.getNewValue().equals("Y")){
            re.setAttribute("Description", "VAT");
            System.out.println("Description :"+re.getAttribute("Description"));
//            }else{
//                re.setAttribute("Description", "");
//                System.out.println("Description else :"+re.getAttribute("Description"));
//            }
        }
    }
}
