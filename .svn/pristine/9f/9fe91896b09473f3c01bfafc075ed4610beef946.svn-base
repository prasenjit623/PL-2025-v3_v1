package view.backing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.math.BigDecimal;

import java.math.RoundingMode;

import java.sql.SQLException;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import oracle.adf.view.rich.component.rich.RichPopup;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import oracle.adf.model.BindingContext;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

import weblogic.cluster.singleton.Leasing;

public class AddEditCancellationBb {
    private RichSelectOneChoice nocBy;
    private RichInputDate nocDateEntered;
    private RichInputDate nocDateActual;
    private RichInputText netDue;
    private RichInputText netDueAttribute;
    private RichTable ctable;
    private RichColumn arTable;
    private RichOutputText netDueop;
    static String isChanged="N";
    private RichPopup apprRejPopup;
    private RichInputText reason;
    private RichPopup finalPopUp;
    private RichPopup p20;
    private RichInputText dirctRejctReason;

    public AddEditCancellationBb() {
        super();
    }

  
    public void onClickSave(ActionEvent actionEvent) {
//        ViewObject vo=ADFUtils.findIterator("SrearchCancellation_RoVo2Iterator").getViewObject();
//        Row r=vo.getCurrentRow();
//        System.err.println("---leaseid----"+r.getAttribute("LeaseAgreementId"));
//        Long leasecount=leaseValidation(r.getAttribute("LeaseAgreementId"));
//        System.err.println("---leasecount----"+leasecount);
//        if(leasecount>0)
//        {
//            JSFUtils.addFacesErrorMessage("Please Change Contract Number");
//        }
//        else{
        
//        ----
        try {
            
        
        ViewObject BookingHdrVo =
            ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row bookRow = BookingHdrVo.getCurrentRow();
        if(bookRow.getAttribute("LeaseAgreementId") != null){
            ViewObject getFuncodeVo =
                ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
            getFuncodeVo.setNamedWhereClauseParam("F_ID", "CN");
            getFuncodeVo.executeQuery();
            if (bookRow.getAttribute("CancelNumber") == null) {
                String name =
                    xxfnd.generateDocNo("CN", "Cancellation_AMDataControl").toString();
                Object valu = name;
                bookRow.setAttribute("CancelNumber", valu);
                bookRow.setAttribute("FuncId",
                                     getFuncodeVo.first().getAttribute("FuncId"));
            }
           
        //vaidating tax code is empty or not
                String nullflag = "N";
                ViewObject cancelduevo =
                    ADFUtils.findIterator("CancelDueAmountDtl_VO1Iterator").getViewObject();
                long count = cancelduevo.getEstimatedRowCount();
                if (isChanged.equalsIgnoreCase("N")) {

                    RowSetIterator itr =
                        cancelduevo.createRowSetIterator(null);

                    while (itr.hasNext()) {
                        Row cancelduerow = itr.next();
                        if (cancelduerow.getAttribute("TaxCode") == null) {
                            nullflag = "Y";
                        }
                    }
                    itr.closeRowSetIterator();
                }
                if (count != 0 && isChanged.equalsIgnoreCase("N") &&
                    nullflag.equalsIgnoreCase("Y")) {
                    JSFUtils.addFacesErrorMessage("Please select add tax code in due table");
                } else {
                    //
                    ADFUtils.findOperation("Commit").execute();
                    //            BookingHdrVo.executeQuery();

                    onClickCalculate(actionEvent);
                    //setting due value
                    Double gettingNetDue=getnetdue();
                    BigDecimal convertingFinalAmount = new BigDecimal(gettingNetDue);
                    ViewObject voc=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
                                Row rows=voc.getCurrentRow();
                    
                    rows.setAttribute("Netdue",convertingFinalAmount);
                    
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.netDueAttribute);
                    //
                    //this is handled through schedular 26-May-2020
//                    if(rows.getAttribute("NocDateActual")!=null)
//                    {
//                        ViewObject bookingdetailvo=ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
//                        Row bookdtlrow=bookingdetailvo.getCurrentRow();
//                        
//                        Object cancelId=rows.getAttribute("CancelId");
//                        Object leaseId=rows.getAttribute("LeaseAgreementId");
//                        Object UnitId=bookdtlrow.getAttribute("UnitId");
//                        System.err.println(cancelId+"--"+leaseId+"--"+UnitId);
//                        BigDecimal bcancelId = (BigDecimal)cancelId;
//                        BigDecimal bleaseId = (BigDecimal)leaseId;
//                        BigDecimal bUnitId =new BigDecimal(UnitId.toString());
//                        System.err.println(bcancelId+"--"+bleaseId+"--"+bUnitId);
////                       
//                        //package calling
//                        OperationBinding ob=ADFUtils.findOperation("getStatusChange");
//                        ob.getParamsMap().put("cancelid",bcancelId);
//                        ob.getParamsMap().put("leaseid",bleaseId);
//                        ob.getParamsMap().put("unitid",bUnitId);
//                        ob.execute();
//                        
//                    }
                    
                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Cancellation Saved.....!");
                }
                
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
//        -----
//        }
    }

    public void onClickClose(ActionEvent actionEvent) {
        ADFUtils.findOperation("Rollback").execute();
    }

    public void setNocBy(RichSelectOneChoice nocBy) {
        this.nocBy = nocBy;
    }

    public RichSelectOneChoice getNocBy() {
        return nocBy;
    }

    public void setNocDateEntered(RichInputDate nocDateEntered) {
        this.nocDateEntered = nocDateEntered;
    }

    public RichInputDate getNocDateEntered() {
        return nocDateEntered;
    }

    public void setNocDateActual(RichInputDate nocDateActual) {
        this.nocDateActual = nocDateActual;
    }

    public RichInputDate getNocDateActual() {
        return nocDateActual;
    }

    public void onSelectNocDateEntered(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void vcDateAdditionLogic(ValueChangeEvent valueChangeEvent) {
//        ViewObject cancel =
//                    ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
//        Row cancelRow = cancel.getCurrentRow();
//        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
//        if (valueChangeEvent.getNewValue() != null) {
//            String nocBY= nocBy.getValue().toString();
//            System.out.println("NOC BY ::"+nocBY);
//            String nocDateE= nocDateEntered.getValue().toString();
//            System.out.println("NOC DATE ENTERED ::"+nocDateE);
//            if(nocBY.equalsIgnoreCase("BY_LESSEE")){
//                try {
//                        System.out.println("inside BY_LESSEE");
//                        nocDateActual.setValue(cancelRow.getAttribute("NocDateEntered"));    
//                    }catch(Exception e){
//                             e.printStackTrace();
//                         }
//            }
//            if(nocBY.equalsIgnoreCase("BY_LESSOR")){
//                System.out.println("inside BY_LESSOR");
//                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//                Calendar c = Calendar.getInstance();
//                try{
//                    //Setting the date to the given date
//                    String date = sdf.format(cancelRow.getAttribute("NocDateEntered"));
//                    c.setTime(sdf.parse(date));
//                    c.add(Calendar.DATE, 4);
//                    Date dd = c.getTime();
//                    java.sql.Date sqlDate = new java.sql.Date(dd.getTime());
////                    oracle.jbo.domain.Date domadate = new oracle.jbo.domain.Date(sqlDate);
//                    nocDateActual.setValue(sqlDate);
//                    }catch(Exception e){
//                             e.printStackTrace();
//                         }
//            }
//        }

    }

    public void onClickTerminationDate(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance()); 
      
        String terminationDate = valueChangeEvent.getNewValue().toString();
        String sterminationDate="";
        Date date = new Date();
        try {
            date =new SimpleDateFormat("yyyy-MM-dd").parse(terminationDate);
            System.err.println("--DDD--"+date);
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
             String strDate = formatter.format(date);  
             System.out.println("Date Format with dd-MM-yyyy : "+strDate);  
            sterminationDate=strDate.toString();
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
             OperationBinding binding=ADFUtils.findOperation("getdetails");
        ViewObject voc=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
                    Row rows=voc.getCurrentRow();
        if(rows.getAttribute("LeaseAgreementNoTrans")!=null){
                    System.err.println(rows.getAttribute("LeaseAgreementId"));
               BigDecimal leaseid = (BigDecimal)rows.getAttribute("LeaseAgreementId");
               BigDecimal orgid = (BigDecimal)JSFUtils.resolveExpression("#{bindings.OrgId.inputValue}");
               binding.getParamsMap().put("p_lease_id",leaseid);
               binding.getParamsMap().put("p_org_id",orgid);
               binding.getParamsMap().put("p_termination_date",sterminationDate);
               try {
            ArrayList obj = (ArrayList)binding.execute();
            BigDecimal p_consumed_days=null;
            BigDecimal p_remaining_days=null;
            BigDecimal p_daily_rental_rate=null;
            BigDecimal p_daily_discount_rate=null;
            if (obj != null) {
                          
                        p_consumed_days = (BigDecimal)(obj.get(0)==null?"0":obj.get(0));
                        p_remaining_days = (BigDecimal)(obj.get(1)==null?"0":obj.get(1));
                        p_daily_rental_rate = (BigDecimal)(obj.get(2)==null?"0":obj.get(2));
                        p_daily_discount_rate = (BigDecimal)(obj.get(3)==null?"0":obj.get(3));
                        
                    }
            ViewObject vo=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
            Row r=vo.getCurrentRow();
            r.setAttribute("DaysConsumed",p_consumed_days);
            r.setAttribute("DaysRemaining",p_remaining_days);
            r.setAttribute("DailyRentalRate",p_daily_rental_rate);
            r.setAttribute("DailyDiscountingRate",p_daily_discount_rate);
        } catch (Exception e) {
         JSFUtils.addFacesInformationMessage("No data found");
            e.printStackTrace();
        }
        //create cancellation detail with validation
//        OperationBinding ob=ADFUtils.findOperation("getcancellation");
//        ob.getParamsMap().put("leaseid",leaseid);
//        ob.execute();
//        AdfFacesContext.getCurrentInstance().addPartialTarget(ctable);
        
        //execute cancelheadervo
       isChanged="Y";
       System.err.println("Date Flag"+isChanged);
                    }
            
    }

    public void onClickTaxCode(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject cnHdrVo =
            ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
               Row cnHdrRow = cnHdrVo.getCurrentRow();
        String dayConsumed = cnHdrRow.getAttribute("DaysConsumed")==null?"":cnHdrRow.getAttribute("DaysConsumed").toString();
        String dayRemain = cnHdrRow.getAttribute("DaysRemaining")==null?"":cnHdrRow.getAttribute("DaysRemaining").toString();
        String staxcode=JSFUtils.resolveExpression("#{row.bindings.TaxCode.attributeValue}")==null?"0":JSFUtils.resolveExpression("#{row.bindings.TaxCode.attributeValue}").toString();
        String scancelamount=JSFUtils.resolveExpression("#{row.bindings.CancelAmount.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{row.bindings.CancelAmount.inputValue}").toString();
        String cancelcharge=JSFUtils.resolveExpression("#{row.bindings.CancelationCharges.attributeValue}")==null?"0.0":JSFUtils.resolveExpression("#{row.bindings.CancelationCharges.attributeValue}").toString();
           System.out.println("CancelationCharges for due table :"+cancelcharge);
           BigDecimal cnclAmt=new BigDecimal(scancelamount);
           BigDecimal oneDayTax = new BigDecimal("0");
           BigDecimal dtaxamount = new BigDecimal("0");
           BigDecimal dtotalamount = new BigDecimal("0");           
           Double daysR=Double.parseDouble(dayRemain);
           Double taxamount;
           Double totalamount;
        
           Double taxcode=Double.parseDouble(staxcode);
           Double cancelamount=Double.parseDouble(scancelamount);
//            if((daysR >= 0) || (daysR < 0 && cancelcharge.equals("OD"))){
           taxamount=(cancelamount*taxcode)/100.0;
           totalamount=cancelamount+taxamount;
           dtaxamount=new BigDecimal(taxamount);
           dtotalamount=new BigDecimal(totalamount);
//        }else{
//           System.out.println("Less than zero :"+daysR);
//           Double daysCnsumd=Double.parseDouble(dayConsumed);
//           daysCnsumd = daysCnsumd*(-1);
//           Double daysRmn=Double.parseDouble(dayRemain);
//           taxamount=(cancelamount*taxcode)/100.0; 
//           Double ovrstyTax = (taxamount/daysCnsumd)*daysRmn;
//           totalamount=cancelamount+ovrstyTax;
//           dtaxamount=new BigDecimal(ovrstyTax);
//           dtotalamount=new BigDecimal(totalamount);
//           }
           JSFUtils.setExpressionValue("#{row.bindings.TaxAmount.inputValue}",dtaxamount);
           JSFUtils.setExpressionValue("#{row.bindings.TotalAmount.inputValue}",dtotalamount);
//   ===
        ViewObject voar=ADFUtils.findIterator("CancelDueAmountArDtl_VO2Iterator").getViewObject();
//        String cancelcharge=JSFUtils.resolveExpression("#{row.bindings.CancelationCharges.attributeValue}")==null?"0.0":JSFUtils.resolveExpression("#{row.bindings.CancelationCharges.attributeValue}").toString();
        System.err.println("PPP"+cancelcharge);
        RowSetIterator itr=voar.createRowSetIterator(null);
        
        int i=0;
        int j=0;
        String aramount=null;
        if(cancelcharge.equalsIgnoreCase("RENT_INC"))
       {
        System.err.println("TAxcode1"+taxcode);
            
            while(itr.hasNext())
            {
                Row arrow=itr.next();
                
                if(i<3)
                {
                    aramount=arrow.getAttribute("CancelAmount")==null?null:arrow.getAttribute("CancelAmount").toString();
                    Double cancelamountAR=Double.parseDouble(aramount);
                    System.err.println(arrow.getAttribute("CancelAmount"));
                    Double  taxamountAR=(cancelamountAR*taxcode)/100.0;
                    Double  totalamountAr=0.0;
                    Object ob="IAPTD";
                    if(arrow.getAttribute("CancelationCharges").equals(ob)){
                        totalamountAr=-(cancelamountAR+taxamountAR);
                    }else{
                            totalamountAr=cancelamountAR+taxamountAR;
                        }
                   
//                    CancelAmount,TaxCode,TaxAmount,TotalAmount/IAPTD

                BigDecimal dtaxamountAR=new BigDecimal(taxamountAR);
                BigDecimal dtotalamountAr=new BigDecimal(totalamountAr);
                  arrow.setAttribute("TaxCode",staxcode);
                    arrow.setAttribute("TaxAmount",dtaxamountAR);
                    arrow.setAttribute("TotalAmount",dtotalamountAr);
                   
                }
                
              i++;
            }
            itr.closeRowSetIterator();
              
        }
        else
        {
            
            while(itr.hasNext())
            {
                Row arrow=itr.next();
                
                if(j==3)
                {
                    aramount=arrow.getAttribute("CancelAmount")==null?null:arrow.getAttribute("CancelAmount").toString();
                    Double cancelamountAR=Double.parseDouble(aramount);
                    System.err.println(arrow.getAttribute("CancelAmount"));
                    Double  taxamountAR=(cancelamountAR*taxcode)/100.0;
                    Double  totalamountAr=cancelamountAR+taxamountAR;
            //                    CancelAmount,TaxCode,TaxAmount,TotalAmount
                BigDecimal dtaxamountAR=new BigDecimal(taxamountAR);
                BigDecimal dtotalamountAr=new BigDecimal(totalamountAr);
                  arrow.setAttribute("TaxCode",staxcode);
                    arrow.setAttribute("TaxAmount",dtaxamountAR);
                    arrow.setAttribute("TotalAmount",dtotalamountAr);
                }
                
              j++;
            }
            itr.closeRowSetIterator();
        
        }
        //setting due value
                            Double gettingNetDue=getnetdue();
                            BigDecimal convertingFinalAmount = new BigDecimal(gettingNetDue);
                            ViewObject voc=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
                                        Row rows=voc.getCurrentRow();
                            
                            rows.setAttribute("Netdue",convertingFinalAmount);
                            
                            AdfFacesContext.getCurrentInstance().addPartialTarget(this.netDueAttribute);
                            //

    }
    
    public Double gettotal()
    {
        ViewObject voar=ADFUtils.findIterator("CancelDueAmountArDtl_VO2Iterator").getViewObject();
        RowSetIterator itr=voar.createRowSetIterator(null);
        Double fam=0.0;
        while(itr.hasNext())
        {
        Row r=itr.next();
            String amt=r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString();
            Double damt=Double.parseDouble(amt);
             fam=fam+damt;
            
        }
        itr.closeRowSetIterator();
        String wavedamount=JSFUtils.resolveExpression("#{bindings.AmountWaived.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.AmountWaived.inputValue}").toString();
        Double dwaveamt=Double.parseDouble(wavedamount);
        Double a=fam-dwaveamt;
//        if(a<=0.0)
//        {
//            a=0.0;
//        }
        
//        String crtCaseAdjmt=JSFUtils.resolveExpression("#{bindings.CourtCaseAdjustmentAmt.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.CourtCaseAdjustmentAmt.inputValue}").toString();
//        Double dcrtCaseAdjmt=Double.parseDouble(crtCaseAdjmt);
//        String netCrtCaseAdjmt=JSFUtils.resolveExpression("#{bindings.NetCourtCaseAdjustmentAmt.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.NetCourtCaseAdjustmentAmt.inputValue}").toString();
//        Double dnetCrtCaseAdjmt=Double.parseDouble(netCrtCaseAdjmt);
//        if (dcrtCaseAdjmt!=0 && dcrtCaseAdjmt!=0.0){
//        a=a+dnetCrtCaseAdjmt;
//        }
        return a;
    }
    
    public Double gettotalafterCourtcaseAdjstmnt()
    {
        ViewObject voar=ADFUtils.findIterator("CancelDueAmountArDtl_VO2Iterator").getViewObject();
        RowSetIterator itr=voar.createRowSetIterator(null);
        Double fam=0.0;
        while(itr.hasNext())
        {
        Row r=itr.next();
            String amt=r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString();
            Double damt=Double.parseDouble(amt);
             fam=fam+damt;
            
        }
        itr.closeRowSetIterator();
        String wavedamount=JSFUtils.resolveExpression("#{bindings.AmountWaived.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.AmountWaived.inputValue}").toString();
        Double dwaveamt=Double.parseDouble(wavedamount);
        Double a=fam-dwaveamt;
    //        if(a<=0.0)
    //        {
    //            a=0.0;
    //        }
        String crtCaseAdjmt=JSFUtils.resolveExpression("#{bindings.CourtCaseAdjustmentAmt.inputValue}")==null?"":JSFUtils.resolveExpression("#{bindings.CourtCaseAdjustmentAmt.inputValue}").toString();        
        String netCrtCaseAdjmt=JSFUtils.resolveExpression("#{bindings.NetCourtCaseAdjustmentAmt.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.NetCourtCaseAdjustmentAmt.inputValue}").toString();
        
        if (!crtCaseAdjmt.equals("")){
//        Double dcrtCaseAdjmt=Double.parseDouble(crtCaseAdjmt);
        Double dnetCrtCaseAdjmt=Double.parseDouble(netCrtCaseAdjmt);
        a=a+dnetCrtCaseAdjmt;
        }
        return a;
    }
    public double getnetdue()
        {
            ViewObject cnnVo =
                ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
            Row cnnVoRow = cnnVo.getCurrentRow();
            ViewObject vo=ADFUtils.findIterator("CancelDueAmountDtl_VO1Iterator").getViewObject();
            RowSetIterator itr=vo.createRowSet(null);
            Double netdue=0.0;String stotal="";String cancelcharge=null;Double originalamt=0.0;
            String clearedamount=JSFUtils.resolveExpression("#{bindings.ChequeClearedAmount.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.ChequeClearedAmount.inputValue}").toString();
            String wavedamount=JSFUtils.resolveExpression("#{bindings.AmountWaived.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.AmountWaived.inputValue}").toString();
           
//            String secDepo=JSFUtils.resolveExpression("#{bindings.SecurityDepositTrans.inputValue}")!=null ? (JSFUtils.resolveExpression("#{bindings.SecurityDepositTrans.inputValue}").toString()) : JSFUtils.resolveExpression("#{bindings.Attribute6.inputValue}") !=null ? (JSFUtils.resolveExpression("#{bindings.Attribute6.inputValue}").toString()) : "0.0";
            String secDepoClred=JSFUtils.resolveExpression("#{bindings.SecurityDepoCleared.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.SecurityDepoCleared.inputValue}").toString();
            String maintenanceDeduc=JSFUtils.resolveExpression("#{bindings.MaintenanceDeduction.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.MaintenanceDeduction.inputValue}").toString();
            String coutcaseAdjmt=JSFUtils.resolveExpression("#{bindings.CourtCaseAdjustmentAmt.inputValue}")==null?"":JSFUtils.resolveExpression("#{bindings.CourtCaseAdjustmentAmt.inputValue}").toString();
//            String netdueS=JSFUtils.resolveExpression("#{bindings.Netdue.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.Netdue.inputValue}").toString();
            Double dclearedamount=Double.parseDouble(clearedamount);
            Double dwavedamount=Double.parseDouble(wavedamount);
            Double othertotal=dclearedamount+dwavedamount;
            
//            Double dsecDepo=Double.parseDouble(secDepo);
            Double dsecDepoClred=Double.parseDouble(secDepoClred);
            Double dmaintenanceDeduc=Double.parseDouble(maintenanceDeduc);

//            othertotal=othertotal-dsecDepo+dsecDepoClred-dmaintenanceDeduc;
            othertotal=othertotal+dsecDepoClred-dmaintenanceDeduc;
            
            while(itr.hasNext())
            {
                Row r=itr.next();
                cancelcharge=r.getAttribute("CancelationCharges")==null?"0.0":r.getAttribute("CancelationCharges").toString();
                if(cancelcharge.equalsIgnoreCase("OD"))
                {
                    originalamt=Double.parseDouble(r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString());
                }
                else
                {
                    stotal=r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString();
                    netdue=netdue+Double.parseDouble(stotal);
                }
               
            }
            itr.closeRowSetIterator();        
            vo.reset();           
          Double a=netdue-othertotal-originalamt;
          //
          if (!coutcaseAdjmt.equals("")){
          Double dcoutcaseAdjmt=Double.parseDouble(coutcaseAdjmt);
          Double dnetcoutcaseAdjmt=0.0;
          dnetcoutcaseAdjmt=dcoutcaseAdjmt-a;
          BigDecimal bd = new BigDecimal(dnetcoutcaseAdjmt).setScale(2, RoundingMode.HALF_UP);
          double val2 = bd.doubleValue();
          cnnVoRow.setAttribute("NetCourtCaseAdjustmentAmt", val2);
          }else{
              cnnVoRow.setAttribute("NetCourtCaseAdjustmentAmt", null);
          }

          //negative value
          
//          if(a<=0.0)
//          {
//              a=0.0;
//            }
               
            return a;
        }
    
    public double getnetdueAfterCourtcaseAdjmnt()
        {
            ViewObject cnnVo =
                ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
            Row cnnVoRow = cnnVo.getCurrentRow();
            ViewObject vo=ADFUtils.findIterator("CancelDueAmountDtl_VO1Iterator").getViewObject();
            RowSetIterator itr=vo.createRowSet(null);
            Double netdue=0.0;String stotal="";String cancelcharge=null;Double originalamt=0.0;
            String clearedamount=JSFUtils.resolveExpression("#{bindings.ChequeClearedAmount.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.ChequeClearedAmount.inputValue}").toString();
            String wavedamount=JSFUtils.resolveExpression("#{bindings.AmountWaived.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.AmountWaived.inputValue}").toString();
           
    //            String secDepo=JSFUtils.resolveExpression("#{bindings.SecurityDepositTrans.inputValue}")!=null ? (JSFUtils.resolveExpression("#{bindings.SecurityDepositTrans.inputValue}").toString()) : JSFUtils.resolveExpression("#{bindings.Attribute6.inputValue}") !=null ? (JSFUtils.resolveExpression("#{bindings.Attribute6.inputValue}").toString()) : "0.0";
            String secDepoClred=JSFUtils.resolveExpression("#{bindings.SecurityDepoCleared.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.SecurityDepoCleared.inputValue}").toString();
            String maintenanceDeduc=JSFUtils.resolveExpression("#{bindings.MaintenanceDeduction.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.MaintenanceDeduction.inputValue}").toString();
            String coutcaseAdjmt=JSFUtils.resolveExpression("#{bindings.CourtCaseAdjustmentAmt.inputValue}")==null?"":JSFUtils.resolveExpression("#{bindings.CourtCaseAdjustmentAmt.inputValue}").toString();
            String netCoutcaseAdjmt=JSFUtils.resolveExpression("#{bindings.NetCourtCaseAdjustmentAmt.inputValue}")==null?"":JSFUtils.resolveExpression("#{bindings.NetCourtCaseAdjustmentAmt.inputValue}").toString();
    //            String netdueS=JSFUtils.resolveExpression("#{bindings.Netdue.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.Netdue.inputValue}").toString();
            Double dclearedamount=Double.parseDouble(clearedamount);
            Double dwavedamount=Double.parseDouble(wavedamount);
            Double othertotal=dclearedamount+dwavedamount;
            
    //            Double dsecDepo=Double.parseDouble(secDepo);
            Double dsecDepoClred=Double.parseDouble(secDepoClred);
            Double dmaintenanceDeduc=Double.parseDouble(maintenanceDeduc);
//            Double dcoutcaseAdjmt=Double.parseDouble(coutcaseAdjmt);
    //            Double dnetdueS=Double.parseDouble(netdueS);
    //            Double dnetcoutcaseAdjmt=dcoutcaseAdjmt-dnetdueS;
    //            othertotal=othertotal-dsecDepo+dsecDepoClred-dmaintenanceDeduc;
            othertotal=othertotal+dsecDepoClred-dmaintenanceDeduc;
            
            while(itr.hasNext())
            {
                Row r=itr.next();
                cancelcharge=r.getAttribute("CancelationCharges")==null?"0.0":r.getAttribute("CancelationCharges").toString();
                if(cancelcharge.equalsIgnoreCase("OD"))
                {
                    originalamt=Double.parseDouble(r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString());
                }
                else
                {
                    stotal=r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString();
                    netdue=netdue+Double.parseDouble(stotal);
                }
               
            }
            itr.closeRowSetIterator();        
            vo.reset();           
          Double a=netdue-othertotal-originalamt;
          //
          if (!coutcaseAdjmt.equals("")){
          Double dnetcoutcaseAdjmt=Double.parseDouble(netCoutcaseAdjmt);
          a=dnetcoutcaseAdjmt+a;//dnetdueAftrCrtCaseAdj
          }

          //negative value
          
    //          if(a<=0.0)
    //          {
    //              a=0.0;
    //            }
               
            return a;
        }


    public double getnetdueP()
        {
           
            ViewObject vo=ADFUtils.findIterator("CancellationDetailProposed_ROVO1Iterator").getViewObject();
            RowSetIterator itr=vo.createRowSet(null);
            Double netdue=0.0;String stotal="";String cancelcharge=null;Double originalamt=0.0;
            String clearedamount=JSFUtils.resolveExpression("#{bindings.ChequeClearedAmount1.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.ChequeClearedAmount1.inputValue}").toString();
            String wavedamount=JSFUtils.resolveExpression("#{bindings.AmountWaived1.inputValue}")==null?"0.0":JSFUtils.resolveExpression("#{bindings.AmountWaived1.inputValue}").toString();
           
            Double dclearedamount=Double.parseDouble(clearedamount);
            Double dwavedamount=Double.parseDouble(wavedamount);
            Double othertotal=dclearedamount+dwavedamount;
            while(itr.hasNext())
            {
                Row r=itr.next();
                cancelcharge=r.getAttribute("CancelationCharges")==null?"0.0":r.getAttribute("CancelationCharges").toString();
                if(cancelcharge.equalsIgnoreCase("OD"))
                {
                    originalamt=Double.parseDouble(r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString());
                }
                else
                {
                    stotal=r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString();
                    netdue=netdue+Double.parseDouble(stotal);
                }
               
            }
            itr.closeRowSetIterator();        
            vo.reset();           
          Double a=netdue-othertotal-originalamt;
          //negative value
          
    //          if(a<=0.0)
    //          {
    //              a=0.0;
    //            }
               
            return a;
        }
    public void setNetDue(RichInputText netDue) {
        this.netDue = netDue;
    }

    public RichInputText getNetDue() {
        return netDue;
    }

    public void setNetDueAttribute(RichInputText netDueAttribute) {
        this.netDueAttribute = netDueAttribute;
    }

    public RichInputText getNetDueAttribute() {
        return netDueAttribute;
    }

    public void setCtable(RichTable ctable) {
        this.ctable = ctable;
    }

    public RichTable getCtable() {
        return ctable;
    }

    public void onClickCalculate(ActionEvent actionEvent) {
        ViewObject voc=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row r=voc.getCurrentRow();
        ViewObject vo=ADFUtils.findIterator("CancelDueAmountDtl_VO1Iterator").getViewObject();
        long count=vo.getEstimatedRowCount();
        System.err.println("CCC"+count);
        BigDecimal DaysConsumed = (BigDecimal)r.getAttribute("DaysConsumed");
        BigDecimal DaysRemaining = (BigDecimal)r.getAttribute("DaysRemaining");
        BigDecimal DailyRentalRate = (BigDecimal)r.getAttribute("DailyRentalRate");
        BigDecimal DailyDiscountingRate = (BigDecimal)r.getAttribute("DailyDiscountingRate");
        System.err.println(isChanged);
        if(count==0){
        
        BigDecimal leaseid = (BigDecimal)r.getAttribute("CancelId");
//      BigDecimal leaseid = (BigDecimal)JSFUtils.resolveExpression("#{bindings.LeaseAgreementId.inputValue}");
        OperationBinding ob=ADFUtils.findOperation("getcancellation");
        ob.getParamsMap().put("leaseid",leaseid);
        ob.getParamsMap().put("DaysConsumed",DaysConsumed);
        ob.getParamsMap().put("DaysRemaining",DaysRemaining);
        ob.getParamsMap().put("DailyRentalRate",DailyRentalRate);
        ob.getParamsMap().put("DailyDiscountingRate",DailyDiscountingRate);
            
        ob.execute();
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(ctable);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(arTable);
        isChanged="N";
        }
        else if(isChanged.equalsIgnoreCase("Y"))
        {
            BigDecimal leaseid = (BigDecimal)r.getAttribute("CancelId");
          //BigDecimal leaseid = (BigDecimal)JSFUtils.resolveExpression("#{bindings.LeaseAgreementId.inputValue}");
            OperationBinding ob=ADFUtils.findOperation("getcancellation");
            ob.getParamsMap().put("leaseid",leaseid);
            ob.getParamsMap().put("DaysConsumed",DaysConsumed);
            ob.getParamsMap().put("DaysRemaining",DaysRemaining);
            ob.getParamsMap().put("DailyRentalRate",DailyRentalRate);
            ob.getParamsMap().put("DailyDiscountingRate",DailyDiscountingRate);
            ob.execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ctable);
          //AdfFacesContext.getCurrentInstance().addPartialTarget(arTable);
            isChanged="N";
        }
        
      
        
        
    }
    
    public long leaseValidation(Object leaseno)
    {
        ViewObject vo=ADFUtils.findIterator("SrearchCancellation_RoVo2Iterator").getViewObject();
        ViewCriteria vc=vo.createViewCriteria();
        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
        vcr.setAttribute("LeaseNumber",leaseno);
        vc.addRow(vcr);
        vo.applyViewCriteria(vc);
        vo.executeQuery();
        //--
        Long count=vo.getEstimatedRowCount();
        System.out.println("Count of LA row in searchCN :"+count);
        String Flag="ND";
        if(count>0)
        {
            RowSetIterator itr=vo.createRowSetIterator(null);
              while(itr.hasNext())
              {
                  Row r=itr.next();
                  
                  System.err.println("Print="+r.getAttribute("Status"));
                  if(!r.getAttribute("Status").toString().equalsIgnoreCase("REJ"))
                  {
                      Flag="D";
                      System.err.println("Flag="+Flag);
                      
                  }
          
                  
              }
            itr.closeRowSetIterator();  
            if(Flag.equalsIgnoreCase("D"))
            {
                count = new Long(1);
            }
            else
            {
                count=new Long(0);
            }
        }
    
        
        
        return count;
    }

    public void onClickLease(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject vo=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row r=vo.getCurrentRow();
        System.out.println("Booking Id ::"+r.getAttribute("BookingId")==null?"0":r.getAttribute("BookingId"));
        //to handle multiple units
        ViewObject bkdVo=ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        ViewCriteria vc=bkdVo.createViewCriteria();
        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
        vcr.setAttribute("BookingId",r.getAttribute("BookingId")==null?"0":r.getAttribute("BookingId"));
        vc.addRow(vcr);
        bkdVo.applyViewCriteria(vc);
        bkdVo.executeQuery();
        System.out.println("Estmt Rows ::"+bkdVo.getEstimatedRowCount());
        BigDecimal bRate = new BigDecimal(0);
        BigDecimal bRateTotal = new BigDecimal(0);
        BigDecimal tRate = new BigDecimal(0);
        BigDecimal tRateTotal = new BigDecimal(0);
        RowSetIterator bkditr=bkdVo.createRowSetIterator(null);
        while(bkditr.hasNext())
        {
            Row bkdrow=bkditr.next();
            String baseR=bkdrow.getAttribute("BaseRate")==null?"0":bkdrow.getAttribute("BaseRate").toString();
            String totalR=bkdrow.getAttribute("TotalRate")==null?"0":bkdrow.getAttribute("TotalRate").toString();
            System.out.println("BaseRate :"+baseR+" TotalRate :"+totalR);
            bRate=new BigDecimal(baseR);            
            bRateTotal = bRateTotal.add(bRate);
            tRate = new BigDecimal(totalR);
            tRateTotal = tRateTotal.add(tRate);
         }
        bkditr.closeRowSetIterator();
        System.out.println("Total BaseRate :"+bRateTotal+" Total TotalRate :"+tRateTotal);
        r.setAttribute("BaseRate", bRateTotal);
        r.setAttribute("TotalRate", tRateTotal);
        System.err.println("---leaseid----"+r.getAttribute("LeaseAgreementNoTrans"));
        Long count=leaseValidation(r.getAttribute("LeaseAgreementNoTrans"));
        if(count>0)
        {
                       r.setAttribute("OrgId",null);
                       r.setAttribute("BookingId",null);
                       r.setAttribute("OfferId",null);
                       r.setAttribute("RecommendId",null);
                       r.setAttribute("ConStartDate",null);
                       r.setAttribute("ConEndDate",null);
                       r.setAttribute("CustomerName",null);
                       r.setAttribute("BaseRate",null);
                       r.setAttribute("TotalRate",null);
                       r.setAttribute("LeaseAgreementId",null);
                       r.setAttribute("LeaseAgreementNoTrans",null);
            JSFUtils.addFacesErrorMessage("Contract Number is already created for cancellation");
        }
    }

    public void setArTable(RichColumn arTable) {
        this.arTable = arTable;
    }

    public RichColumn getArTable() {
        return arTable;
    }

    public void setNetDueop(RichOutputText netDueop) {
        this.netDueop = netDueop;
    }

    public RichOutputText getNetDueop() {
        return netDueop;
    }
//    public String onClickSubmit(ActionEvent actionEvent) {
      public String onClickSubmit() {
        String actn ="";
        String nullflag = "N";
        ViewObject cHdr =
            ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row cHdrRow = cHdr.getCurrentRow();
        String sts = cHdrRow.getAttribute("Status")==null ? "" : cHdrRow.getAttribute("Status").toString();
        String pfsts = cHdrRow.getAttribute("ProposeFinalStatus")==null ? "" : cHdrRow.getAttribute("ProposeFinalStatus").toString();
        String nocActualDate = cHdrRow.getAttribute("NocDateActual") == null ? "" : cHdrRow.getAttribute("NocDateActual").toString();
        String nocBy = cHdrRow.getAttribute("NocBy") == null ? "" : cHdrRow.getAttribute("NocBy").toString();
       
        String YorN = doValidateMsRcptAmt();
        if(YorN.equalsIgnoreCase("N")){
            JSFUtils.addFacesErrorMessage("Other Charges and Receipts Amount should be same !!!"); 
        return "";
        }      
        if(sts.equalsIgnoreCase("DRA") && pfsts.equalsIgnoreCase("Final") && nocActualDate.equalsIgnoreCase("") && !nocBy.equalsIgnoreCase("REJ")){
            JSFUtils.addFacesErrorMessage("Please fill the NOC Date Actual field !!!");
            return "";
            } else {
            System.out.println("else");
                        ViewObject cancelduevo =
                            ADFUtils.findIterator("CancelDueAmountDtl_VO1Iterator").getViewObject();
                        long count = cancelduevo.getEstimatedRowCount();
                        if (isChanged.equalsIgnoreCase("N")) {

                            RowSetIterator itr =
                                cancelduevo.createRowSetIterator(null);

                            while (itr.hasNext()) {
                                Row cancelduerow = itr.next();
                                if (cancelduerow.getAttribute("TaxCode") == null) {
                                    nullflag = "Y";
                                }
                            }
                            itr.closeRowSetIterator();
                        }
                        if (count != 0 && isChanged.equalsIgnoreCase("N") &&
                            nullflag.equalsIgnoreCase("Y")) {
                            JSFUtils.addFacesErrorMessage("Please select add tax code in due table");
                            return "";
                        } else {
            String ResultVal = null;
//            String canceldate = null;
//            String unitname = null;
//            String EmailId = null;
            ViewObject cvo =ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
//            ViewObject bddvo =ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
//            ViewObject suvo =ADFUtils.findIterator("masterdetail_ROVO1Iterator").getViewObject();
//            Row bdrow = bddvo.getCurrentRow();
            Row r = cvo.getCurrentRow();
//            EmailId =
//                    r.getAttribute("Description") == null ? "0" : r.getAttribute("Description").toString();
//            System.err.println("EmailID" + r.getAttribute("Description"));
//            System.err.println("CancelDate" + r.getAttribute("CancelDate"));
//            System.err.println("UnitId" + bdrow.getAttribute("UnitId"));
//            bdrow.getAttribute("PropertyId");
//            bdrow.getAttribute("BuildingId");
//            canceldate = r.getAttribute("CancelDate").toString();
//                            
//            ViewObject mastervo=ADFUtils.findIterator("masterdetail_ROVO1Iterator").getViewObject();
//            mastervo.setNamedWhereClauseParam("bv_unitid",bdrow.getAttribute("UnitId"));
//            mastervo.executeQuery();
//            System.err.println("rowcount"+mastervo.getEstimatedRowCount());
//            RowSetIterator masteritr=mastervo.createRowSetIterator(null);
//            String UnitNumber=null,BuildName=null,PropertyName=null;
//            while(masteritr.hasNext())
//            {
//                Row mrow=masteritr.next();
//                UnitNumber=mrow.getAttribute("UnitNumber")==null?"empty":mrow.getAttribute("UnitNumber").toString();
//                BuildName=mrow.getAttribute("BuildName")==null?"empty":mrow.getAttribute("BuildName").toString();
//                PropertyName=mrow.getAttribute("PropertyName")==null?"empty":mrow.getAttribute("PropertyName").toString();
//            }
//            masteritr.closeRowSetIterator();
//            
//            System.err.println("Unitno"+UnitNumber); 
//            System.err.println("BuildName"+BuildName);
//            System.err.println("PropertyName"+PropertyName);
////          r.setAttribute("Status", "APR");
//            //                                                    ----mail notification----
//            ArrayList<String> ar = new ArrayList<String>();
//           // ar.add("balaji.swamynathan@4iapps.com");
//            ar.add(EmailId);
//            String htmlBody =MailTemplates.submit(canceldate,UnitNumber,BuildName,PropertyName);
//            String subject = "Cancellation/Termination Notification";
//            MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
//            JSFUtils.addFacesInformationMessage("Mail has been send successfully");
            //                                                   -----mail notificattion-----
                                                               r.getAttribute("OrgId");
                                                               System.err.println("Orgid"+r.getAttribute("OrgId"));
                                                                System.err.println("functid"+r.getAttribute("FuncId"));
                                                                System.err.println("cancelid"+r.getAttribute("CancelId"));
                                                                ViewObject bdvo =ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
                                                                Row rr=bdvo.getCurrentRow();
                                                                rr.getAttribute("PropertyId");
                                                                rr.getAttribute("BuildingId");
                                                                System.err.println("P"+rr.getAttribute("PropertyId"));
                                                                System.err.println("B"+rr.getAttribute("BuildingId"));
//                                            r.setAttribute("Status","APR");
                                                                try {
                                                                    ResultVal = xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
                                                                                              r.getAttribute("FuncId"),
                                                                                              r.getAttribute("CancelId"),
                                                                                              0, "XXPM_CANCELLATION", "STATUS",
                                                                                              "CANCEL_ID",r.getAttribute("OrgId"),rr.getAttribute("PropertyId"),rr.getAttribute("BuildingId"),
                                                                                              null, null);
                                                                    
                                                                } catch (SQLException e) {
                                                                    System.out.println(e);
                                                                }
                                                                if (ResultVal.equalsIgnoreCase("Success")) {
                                                                    
                                                                    JSFUtils.addFacesInformationMessage("Submitted For Approval");
                                                                } else {
                                                                    JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
                                                                }
                                                 ADFUtils.findOperation("Commit").execute(); 
                                        
                                        }
            }
        return "cancel";

    }
    //to validate other charges and receipt amt
    public String doValidateMsRcptAmt(){
        ViewObject cHdr =
            ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row cHdrRow = cHdr.getCurrentRow();
        ViewObject bmVo =
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();       
        ViewObject rVo =
            ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
                BigDecimal total = new BigDecimal("0");
                BigDecimal rcptTotal = new BigDecimal("0");
                //for total oc calcu
                RowSetIterator bMsRsi = bmVo.createRowSetIterator(null);
                while (bMsRsi.hasNext()) {
                    Row r = bMsRsi.next();
                    String InstllAmount =
                        r.getAttribute("InstallmentAmount") == null ? "0" :
                        r.getAttribute("InstallmentAmount").toString();
                    System.out.println("InstallmentAmount = " + InstllAmount);
        //            int instAmt = Integer.parseInt(InstllAmount);
                    BigDecimal instAmt = new BigDecimal(InstllAmount);
                    total = instAmt.add(total);
                }
                //for total receipt calcu
                   
                RowSetIterator rRsi = rVo.createRowSetIterator(null);
                while (rRsi.hasNext()) {
                    Row row = rRsi.next();
                    String rcptAmt =
                        row.getAttribute("ReceivedAmount") == null ? "0" : row.getAttribute("ReceivedAmount").toString();
                    System.out.println("Cancel Receipt Amt = " + rcptAmt);
        //            int rAmt = Integer.parseInt(rcptAmt);
                    BigDecimal rAmt = new BigDecimal(rcptAmt);
                    rcptTotal = rAmt.add(rcptTotal);
                }
                if(total.equals(rcptTotal)){
                    return "Y";
                }                
        return "N";
    }
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    Long jbds=null;
    Long jbdd=null;
    Long jbdas=null;
    //dubai ccid
    String dline1="300000001947356";
    String dline2="300000002489394";
    String dline3="300000002489394";
    String dline4="300000002519136";
    String dline5="300000001947445";
    String doverstay="300000001947356";
    //sharjah ccid
    String sline1="300000001947357";
    String sline2="300000002489398";
    String sline3="300000002489398";
    String sline4="300000002514033";
    String sline5="300000001947449";
    String soverstay="300000001947357";
    //Alfa Smart Real Estate ccid
    String asline1="300000022143754";//Invoiced Amount Post Termination Date
    String asline2="300000022143778";//Post Termination Discount
    String asline3="300000022143778";//Pre-Termination Discount
    String asline4="300000022143766";//penalty
    String asline5="300000022131724";//waived penalty
    String asoverstay="300000022143754";//over stay
    
    public void onClickInvoice(ActionEvent actionEvent) throws IOException,
                                                               ParserConfigurationException,
                                                               SAXException,
                                                               Exception {
      ViewObject cancelvo=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
      Row cancelheaderrow=cancelvo.getCurrentRow();
        Object CancelNo=cancelheaderrow.getAttribute("CancelNumber");
        Object BookingId=cancelheaderrow.getAttribute("BookingId");
        Object OrgId=cancelheaderrow.getAttribute("OrgId");
        Object LeaseAgreementId=cancelheaderrow.getAttribute("LeaseAgreementId");
        Object ConStartDate=cancelheaderrow.getAttribute("ConStartDate");
        Object ConEndDate=cancelheaderrow.getAttribute("ConEndDate");
        Object CancelNumber=cancelheaderrow.getAttribute("CancelNumber");
        Object CancelDate=cancelheaderrow.getAttribute("CancelDate");
        Object DaysRemaining=cancelheaderrow.getAttribute("DaysRemaining");
        String crtcasAdj=cancelheaderrow.getAttribute("CourtCaseAdjustmentAmt")==null ? "" : cancelheaderrow.getAttribute("CourtCaseAdjustmentAmt").toString();
        String netCourtcasAdjmnt=cancelheaderrow.getAttribute("NetCourtCaseAdjustmentAmt")==null ? "" : cancelheaderrow.getAttribute("NetCourtCaseAdjustmentAmt").toString();
        BigDecimal oldbd =
            (BigDecimal)(cancelheaderrow.getAttribute("AmountWaived")==null?new BigDecimal(0):cancelheaderrow.getAttribute("AmountWaived"));
        BigDecimal bd=oldbd.negate();
        Object AmountWaived = bd;
        //include VAT for waive amt to nulify penalty on 19-Jun-2021
        BigDecimal vat= new BigDecimal(0.05);
        BigDecimal netWaive= new BigDecimal(0);
        BigDecimal cantaxArBD = new BigDecimal(0);
        String daysRmng = DaysRemaining.toString();
        System.out.println("daysRmng string :"+daysRmng);
        int daysRI  = Integer.parseInt(daysRmng);
        System.out.println("daysRmng daysRI int :"+daysRI);
        String isWaiveVat = cancelheaderrow.getAttribute("Attribute3")==null?"NO":cancelheaderrow.getAttribute("Attribute3").toString();
      
        //get unit id from booking detail
        ViewObject bookingdetailvo=ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        Row bookdtlrow=bookingdetailvo.getCurrentRow();
        Object UnitId=bookdtlrow.getAttribute("UnitId");
        
    
        //get unit id end
       
        Double dayremaining=cancelheaderrow.getAttribute("DaysRemaining")==null?0.0:Double.parseDouble(cancelheaderrow.getAttribute("DaysRemaining").toString());
        
        //get org name
       ViewObject buvo=ADFUtils.findIterator("Org_ROVO1Iterator").getViewObject();
        ViewCriteria vc=buvo.createViewCriteria();
        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
        vcr.setAttribute("OrgId",cancelheaderrow.getAttribute("OrgId"));
        vc.addRow(vcr);
        buvo.applyViewCriteria(vc);
        buvo.executeQuery();
        String buName="";
        RowSetIterator buitr=buvo.createRowSetIterator(null);
        while(buitr.hasNext())
        {
            Row burow=buitr.next();
            buName=burow.getAttribute("OrgName")==null?"":burow.getAttribute("OrgName").toString();
        }
        buitr.closeRowSetIterator();
        //get org name end
        String line1s="";
        String line1e="";
        String line2s="";
        String line2e="";
        String line3s="";
        String line3e="";
        String line4s="";
        String line4e="";
        String line5s="";
        String line5e="";
        //get offertype
        ViewObject offertyperovo=ADFUtils.findIterator("OfferType_ROVO1Iterator").getViewObject();
        offertyperovo.setNamedWhereClauseParam("BV_bookingid",BookingId);
        offertyperovo.executeQuery();
        String offertype="";
        System.err.println("count"+offertyperovo.getEstimatedRowCount());
        RowSetIterator offeritr=offertyperovo.createRowSetIterator(null);
        while(offeritr.hasNext())
        {
           Row offerrow=offeritr.next();
            offertype=offerrow.getAttribute("OfferType")==null?"null":offerrow.getAttribute("OfferType").toString();
        }
        offeritr.closeRowSetIterator();
        //get offertype end
        
        
        if(buName.equalsIgnoreCase("Leasing Sharjah"))
        {
       
            //sharjah--early
            if(dayremaining>0.0)
            {
                line1s=dateplusone(CancelDate.toString());
                line1e=ConEndDate.toString();
                line2s=dateplusone(CancelDate.toString());
                line2e=ConEndDate.toString();
                //COM---commercial
                
                if(offertype.equalsIgnoreCase("COM"))
                {
                    line3s=dateplusone(CancelDate.toString());
                    line3e=dateplusone(CancelDate.toString());
                    line4s=dateplusone(CancelDate.toString());
                    line4e=dateplusone(CancelDate.toString());  
                }
                else
                {
                    line3s=CancelDate.toString();
                    line3e=CancelDate.toString();
                    line4s=CancelDate.toString();
                    line4e=CancelDate.toString();
                }
                
                
            }
            else
            {
                //sharjah--late
                line5s=dateplusone(ConEndDate.toString());
                line5e=CancelDate.toString();
            } 
        
        }
        else if(buName.equalsIgnoreCase("Leasing Dubai"))
        {
           
            //Dubai--early
            if(dayremaining>0.0)
            {
                line1s=dateplusone(CancelDate.toString());
                line1e=ConEndDate.toString();
                line2s=dateplusone(CancelDate.toString());;
                line2e=ConEndDate.toString();
                line3s=CancelDate.toString();
                line3e=CancelDate.toString();
                line4s=CancelDate.toString();
                line4e=CancelDate.toString();
            }
            else
            {
            //Dubai--late
                line5s=dateplusone(ConEndDate.toString());
                line5e=CancelDate.toString();
                
            } 
        }
        //Alfa Smart Real Estate
        else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))
        {
           
            //Alfa Smart Real Estate--early
            if(dayremaining>0.0)
            {
                line1s=dateplusone(CancelDate.toString());
                line1e=ConEndDate.toString();
                line2s=dateplusone(CancelDate.toString());;
                line2e=ConEndDate.toString();
                line3s=CancelDate.toString();
                line3e=CancelDate.toString();
                line4s=CancelDate.toString();
                line4e=CancelDate.toString();
            }
            else
            {
            //Alfa Smart Real Estate--late
                line5s=dateplusone(ConEndDate.toString());
                line5e=CancelDate.toString();
                
            } 
        }
        
//        --------------integration---------------------
        int transactionValue = 1;
        String getLeaseType = "";
        String getTrxnsType = "";
        String validationFlag = "Y";
        ViewObject invoiceInterfaceValueVO=ADFUtils.findIterator("getPayloadInformationCancellation_ROVO1Iterator").getViewObject();
        
        invoiceInterfaceValueVO.setNamedWhereClauseParam("BV_BOOKING_ID",BookingId);
        System.err.println("+BookingId+"+BookingId);
        invoiceInterfaceValueVO.executeQuery();

        if (invoiceInterfaceValueVO.first() != null) {
            Object taxValue =
                invoiceInterfaceValueVO.first().getAttribute("TaxCode") ==
                null ? "0" :
                invoiceInterfaceValueVO.first().getAttribute("TaxCode");
            Object unitId = UnitId;
            Object orgId =
                invoiceInterfaceValueVO.first().getAttribute("OrgId");
            //xx
            Object amount =
                invoiceInterfaceValueVO.first().getAttribute("BaseRate");
            Object billCustomerAccountNumber =
                invoiceInterfaceValueVO.first().getAttribute("CustomerNumber");
            Object billCustomerSiteNumber =
                invoiceInterfaceValueVO.first().getAttribute("BillToAddr");
            Object billingDate = getCurrentDateForPayload();
            //xx
            Object comments = "Property Lease Module";
//            Object comments = "TEST AR";
            //xx
            Object ruleStartDate =
                invoiceInterfaceValueVO.first().getAttribute("LeaseStartDate");
            Object trxDate = ruleStartDate;
            Object currencyCode = "AED";
            Object description = "Property Lease Module";
//            Object description = "TEST AR";
            //okhttp
            Object glDate="";
//            Object glDate = invokeReport(ruleStartDate.toString());
            //xx
            Object ruleEndDate =
                invoiceInterfaceValueVO.first().getAttribute("LeaseEndDate");
            bookdtlrow.setAttribute("GlDate", glDate);
            Object glFromBookingDtl = bookdtlrow.getAttribute("GlDate");
            //xx
            Object unitSellingPrice =
                invoiceInterfaceValueVO.first().getAttribute("BaseRate");
            Object lineType = "LINE";
            Object quantity = "1";
            Object paymentTermsName = "IMMEDIATE";
            Object taxCode = getTaxCodeFromLookup(taxValue);
//            Object taxCode ="VAT 0%";
            Object flexContext = "Property_Leasing";
            Object leaseNumber =
                invoiceInterfaceValueVO.first().getAttribute("LeaseNumber");
            Object bookingNumber =
                invoiceInterfaceValueVO.first().getAttribute("BookingNumber");
            Object dynamicInsertion = "Y";
            Object segmentedCode = null;
            Object enabledFlag = "true";
            Object fromDate = getCurrentDateForPayload();
            Object toDate = getCurrentDateForPayload();
            Object environment = null;
            Object ledgerName = null;
            Object accountClass = null;
            Object invoicingRuleName = null;
            Object batchSourceName = null;
            Object customerTrxTypeName = null;
            Object codeCombinationId = null;
            Object accountingRuleName = null;
            Object revAccountId = null;
            Object unitName=invoiceInterfaceValueVO.first().getAttribute("UnitName");
            Object buildingName =
                invoiceInterfaceValueVO.first().getAttribute("BuildName");
            if (orgId == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("==Business Unit is Required==");
            }
            if (unitName == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("==Unit Name is Required==");
            }
            if (buildingName == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("==Building Name is Required==");

            } else {

                //AR setup
                Map<String, Object> arSetupMap = null;
                arSetupMap =
                        getArSetupDetails(orgId.toString(),
                                          "LSM");
                environment = arSetupMap.get("environment");
                ledgerName = arSetupMap.get("ledgerName");
                accountClass = arSetupMap.get("accountClass");
                invoicingRuleName =
                        arSetupMap.get("invoicingRuleName");
                batchSourceName =
                        arSetupMap.get("batchSourceName");
                customerTrxTypeName =
                        arSetupMap.get("customerTrxTypeName");
                codeCombinationId =
                        arSetupMap.get("codeCombinationId");
                accountingRuleName =
                        arSetupMap.get("accountingRuleName");

                revAccountId = arSetupMap.get("revAccountId");

            }
//            System.err.println("==Business Unit==" + orgId);
//            System.err.println("environment"+environment);
//            System.err.println("ledgerName"+ledgerName);
//            System.err.println("accountClass"+accountClass);
//            System.err.println("batchSourceName"+batchSourceName);
//            System.err.println("customerTrxTypeName"+customerTrxTypeName);
//            System.err.println("codeCombinationId"+codeCombinationId);
//            System.err.println("accountingRuleName"+accountingRuleName);
//            System.err.println("revAccountId"+revAccountId);
//            
//                                System.err.println("==amount=="+amount);
//                                System.err.println("==batchSourceName=="+batchSourceName);
//                                System.err.println("==customerTrxTypeName=="+customerTrxTypeName);
//                                System.err.println("==billCustomerAccountNumber=="+billCustomerAccountNumber);
//                                System.err.println("==billCustomerSiteNumber=="+billCustomerSiteNumber);
//                                System.err.println("==billingDate=="+billingDate);
//                                System.err.println("==comments=="+comments);
//                                System.err.println("==trxDate=="+trxDate);
//                                System.err.println("==currencyCode=="+currencyCode);
//                                System.err.println("==description=="+description);
//                                System.err.println("==glDate=="+glDate);
//                                System.err.println("==invoicingRuleName=="+invoicingRuleName);
//                                System.err.println("==accountingRuleName=="+accountingRuleName);
//                                System.err.println("==ruleEndDate=="+ruleEndDate);
//                                System.err.println("==ruleStartDate=="+ruleStartDate);
//                                System.err.println("==unitSellingPrice=="+unitSellingPrice);
//                                System.err.println("==lineType=="+lineType);
//                                System.err.println("==quantity=="+quantity);
//                                System.err.println("==paymentTermsName=="+paymentTermsName);
//                                System.err.println("==taxCode=="+taxCode);
//                                System.err.println("==flexContext=="+flexContext);
//                                System.err.println("==leaseNumber=="+leaseNumber);
//                                System.err.println("==bookingNumber=="+bookingNumber);
//                                System.err.println("==accountClass=="+accountClass);
//                                System.err.println("==dynamicInsertion=="+dynamicInsertion);
//                                System.err.println("==segmentedCode=="+segmentedCode);
//                                System.err.println("==ledgerName=="+ledgerName);
//                                System.err.println("==enabledFlag=="+enabledFlag);
//                                System.err.println("==fromDate=="+fromDate);
//                                System.err.println("==toDate=="+toDate);
            if (orgId == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Business Unit is Required");
            } else {
                if (unitId != null)
                    segmentedCode =
                            getCodeCombination(orgId.toString(),"LSM", unitId.toString());
                System.err.println("SSSS"+segmentedCode);
            }
            if (amount == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Amount is Required");

            }

            if (batchSourceName == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Batch Source Name is Required");

            }

            if (customerTrxTypeName == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Customer Transaction Type Name Unit is Required");

            }
            if (billCustomerAccountNumber == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Bill Customer AccountNumber Unit is Required");

            }
            if (billCustomerSiteNumber == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Bill Customer Site Number is Required");

            }

            if (billingDate == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Billing Date is Required");
            }


            if (comments == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("comments is Required");
            }

            if (trxDate == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("trxDate is Required");
            }


            if (currencyCode == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("currencyCode is Required");
            }


            if (description == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("description is Required");
            }


            //glDate

            if (glDate == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("GL Date is Required");
            }


            if (invoicingRuleName == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Invoicing Rule Name is Required");
            }


            if (accountingRuleName == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Accounting Rule Name is Required");

            }

            if (ruleEndDate == null) {
                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Rule End Date is Required");
            }

            if (ruleStartDate == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Rule Start Date is Required");

            }

            if (unitSellingPrice == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Unit Selling Price is Required");

            }
            if (lineType == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("LineType is Required");

            }
            if (quantity == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Quantity is Required");

            }
            if (paymentTermsName == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Payment Terms Name is Required");

            }
            if (taxCode == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Tax Code is Required");

            }
            if (flexContext == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Flex Context is Required");

            }
            if (leaseNumber == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Lease Number is Required");

            }
            if (bookingNumber == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Booking Number is Required");

            }
            if (accountClass == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Account Class is Required");

            }
            if (dynamicInsertion == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Dynamic Insertion is Required");

            }
            if (segmentedCode == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Segmented Code is Required");

            }
            if (ledgerName == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Ledger Name is Required");

            }
            if (enabledFlag == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("Enabled Flag is Required");

            }
            if (fromDate == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("From Date is Required");

            }

            if (toDate == null) {

                validationFlag = "N";
                JSFUtils.addFacesErrorMessage("To Date is Required");

            }
            
            ViewObject cancelARvo=ADFUtils.findIterator("CancelDueAmountArDtl_VO2Iterator").getViewObject();
                   ViewObject chargenamevo=ADFUtils.findIterator("Lookup_View_chargename").getViewObject();
                              RowSetIterator aritr=cancelARvo.createRowSetIterator(null);
                              Long rowcount=cancelARvo.getEstimatedRowCount();
                              System.err.println("ARCount"+cancelARvo.getEstimatedRowCount());
                              Object[] cancellationcharge=new Object[4];
                              Object[] cancellationchargeid=new Object[4];
                              Object[] cancellationamtount=new Object[4];
                              Object[] cancellationtaxamt=new Object[4];
                              int oc=0;double damount=0.0;
                              double taxLineArD=0.0;
                              Row[] filterrow=null;
                              while(aritr.hasNext())
                              {
                              Row arrow=aritr.next();
                              cancellationchargeid[oc]=arrow.getAttribute("CancelationCharges");
//                              String stotalamount=arrow.getAttribute("TotalAmount")==null?"0.0":arrow.getAttribute("TotalAmount").toString();
                              String stotalamount=arrow.getAttribute("CancelAmount")==null?"0.0":arrow.getAttribute("CancelAmount").toString();
                            //tax
                              String taxLine =arrow.getAttribute("TaxAmount")==null?"0.0":arrow.getAttribute("TaxAmount").toString();
                                  if(cancellationchargeid[oc].toString().equalsIgnoreCase("IAPTD")){
                                      stotalamount="-"+stotalamount;
                                      System.out.println("stotalamount %%%%%%% "+stotalamount);
                                  }
                              damount=Double.parseDouble(stotalamount);
//                              cancellationamtount[oc]=Math.round(damount);
                              cancellationamtount[oc]=df2.format(damount);
                                  
                              taxLineArD=Double.parseDouble(taxLine);
                              taxLineArD =Double.parseDouble(df2.format(taxLineArD));
                              cancellationtaxamt[oc]=df2.format(taxLineArD);
                            //for penalty 30%
                            if(cancellationchargeid[oc].toString().equalsIgnoreCase("PENALTY_PERCENT")){                                

                                if(isWaiveVat.equalsIgnoreCase("YES")){ //early cancellation 
                                      cantaxArBD = new BigDecimal(cancellationtaxamt[oc].toString());
                                      System.out.println("cantaxArBD PENALTY_PERCENT :"+cantaxArBD);
                                      netWaive = bd.add(cantaxArBD);
                                      AmountWaived = netWaive;  
                                      System.out.println("under YES and greater than 0 case");
                                      System.out.println("netWaive :"+netWaive+" AmountWaived :"+AmountWaived);
                                      }
                            }  
                                  //for penalty 3 months
                                  if(cancellationchargeid[oc].toString().equalsIgnoreCase("PENALTY_MON")){                                

                                      if(isWaiveVat.equalsIgnoreCase("YES")){  
                                            cantaxArBD = new BigDecimal(cancellationtaxamt[oc].toString());
                                            System.out.println("cantaxArBD PENALTY_PERCENT :"+cantaxArBD);
                                            netWaive = bd.add(cantaxArBD);
                                            AmountWaived = netWaive;  
                                            System.out.println("under YES and greater than 0 case");
                                            System.out.println("netWaive :"+netWaive+" AmountWaived :"+AmountWaived);
                                            }
                                  }
                                 filterrow=chargenamevo.getFilteredRows("LookupValueName",cancellationchargeid[oc]);
                                  for(Row r:filterrow)
                                  {
                                       cancellationcharge[oc]=r.getAttribute("LookupValueNameDisp");
                                  }
                               oc++; 
                              }
                              aritr.closeRowSetIterator();
            System.err.println("amount1"+cancellationamtount[0]);
            System.err.println("amount2"+cancellationamtount[1]);
            System.err.println("amount3"+cancellationamtount[2]);
            System.err.println("amount4"+cancellationamtount[3]);
            System.err.println("Tax amount4 cancellationtaxamt[3]"+cancellationtaxamt[3]);
            System.err.println("CancellationNo"+CancelNo);
           //pushing 4 rows to saas
            if(rowcount==4)
            {
                if (validationFlag == "Y") {
                                            //line one=====================================
                                            JSONObject obj = new JSONObject();
                                            obj.put("orgId", orgId.toString());
                                            obj.put("unitName", unitName);
                                            obj.put("buildingName", buildingName);
                                            //obj.put("amount",amount.toString());
                                            obj.put("amount",cancellationamtount[0]);
                                            obj.put("batchSourceName", batchSourceName.toString());
                                            obj.put("customerTrxTypeName", customerTrxTypeName.toString());
                                            obj.put("billCustomerAccountNumber",
                                                    billCustomerAccountNumber.toString());
                                            obj.put("billCustomerSiteNumber",
                                                    billCustomerSiteNumber.toString());
                                            obj.put("billingDate", billingDate.toString());
                                            obj.put("comments", comments.toString());
//                                            obj.put("trxDate",line1s);CancelDate
                                            obj.put("trxDate",CancelDate.toString());
                                            obj.put("currencyCode", currencyCode.toString());
                                            //                                    obj.put("description",description.toString());
                                            obj.put("description",cancellationcharge[0].toString());
                                            obj.put("glDate",CancelDate.toString());      
//                                            obj.put("glDate", glFromBookingDtl.toString());
                                            //                        obj.put("glDate", cutOffDate);
                                            obj.put("invoicingRuleName", invoicingRuleName.toString());
                                            obj.put("accountingRuleName", accountingRuleName.toString());
                                            obj.put("ruleEndDate",line1e);
                                            obj.put("ruleStartDate",line1s);
                                            obj.put("unitSellingPrice",cancellationamtount[0]);
                                            obj.put("lineType", lineType.toString());
                                            obj.put("quantity", quantity.toString());
                                            obj.put("paymentTermsName", paymentTermsName.toString());
                                            obj.put("taxCode", taxCode.toString());
                                            obj.put("flexContext", flexContext.toString());
                                            obj.put("leaseNumber", leaseNumber.toString());
                                            obj.put("bookingNumber", bookingNumber.toString());
                                            obj.put("accountClass", accountClass.toString());
                                            obj.put("dynamicInsertion", dynamicInsertion.toString());
                                            obj.put("segmentedCode", segmentedCode.toString());
                                            obj.put("ledgerName", ledgerName.toString());
                                            obj.put("enabledFlag", enabledFlag.toString());
                                            obj.put("fromDate", fromDate.toString());
                                            obj.put("toDate", toDate.toString());
                                            obj.put("environment", environment.toString());
                                            obj.put("transactions", transactionValue + "");
//                                            Leasing Dubai=300000001937102;
//                                            Leasing Sharjah=300000001937026;
//                                            if(orgId.toString().equalsIgnoreCase("300000001937102"))
                                            if(buName.equalsIgnoreCase("Leasing Dubai"))
                                            {
                                             
                                               jbdd=new Long(dline1);
                                                obj.put("ccId", jbdd);
                                            }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                                            {
                                                jbds=new Long(sline1);
                                                obj.put("ccId", jbds);
                                            }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                                            {
                                                jbdas=new Long(asline1);
                                                obj.put("ccId", jbdas);
                                            }
                                           
//                                            obj.put("tenantYears","0");
                                            obj.put("cancellationNo",CancelNo);
                                            
                            
                            
                                            JSFUtils.addFacesInformationMessage("Invoice Actual JSON Object" +
                                                                                obj.toString());
                                            System.out.println("Invoice Actual JSON Object" +
                                                               obj.toString());
                                            OkHttpClient client = new OkHttpClient();
                                            MediaType mediaType = MediaType.parse("application/json");
                                            RequestBody body =
                                                RequestBody.create(mediaType, obj.toJSONString());
                                            Request request =
                                                new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body).addHeader("Content-Type",
                                                                                                                                                                           "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                         "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                               "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                     //test instance                       
//                     Request request =
//                         new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body).addHeader("Content-Type",
//                                                                                                                                                    "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                  "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                        "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                            
                                            Response response = client.newCall(request).execute();
                            
                                            JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                                response);
                                            InputStream isr = response.body().byteStream();
                                            BufferedReader reader =
                                                new BufferedReader(new InputStreamReader(isr));
                                            StringBuilder out = new StringBuilder();
                                            String resultsXml;
                            
                                            while ((resultsXml = reader.readLine()) != null) {
                                                out.append(resultsXml);
                                            }
                            
                                            JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                                                out.toString());
                                            String responseOut = out.toString();
                                            if (responseOut != null) {
                                                //                        responseOut.contains("{\"result\":\"Success\"}");
                                                //                                    leaseVO.getCurrentRow().setAttribute("IntegrationResponse", responseOut);
                                                //                                    ADFUtils.findOperation("Commit").execute();
                                                //                                    AdfFacesContext.getCurrentInstance().addPartialTarget(generate_invoice_cb15);
                                            }
                                            System.out.println("Invoice Response in json" +
                                                               out.toString());
                                            transactionValue++;
                                            //line two==============================================
                                            JSONObject obj2 = new JSONObject();
                                            obj2.put("orgId", orgId.toString());
                                            obj2.put("unitName", unitName);
                                            obj2.put("buildingName", buildingName);
                                            //                obj2.put("amount",amount.toString());
                                            obj2.put("amount",cancellationamtount[1]);
                                            obj2.put("batchSourceName", batchSourceName.toString());
                                            obj2.put("customerTrxTypeName",
                                                     customerTrxTypeName.toString());
                                            obj2.put("billCustomerAccountNumber",
                                                     billCustomerAccountNumber.toString());
                                            obj2.put("billCustomerSiteNumber",
                                                     billCustomerSiteNumber.toString());
                                            obj2.put("billingDate", billingDate.toString());
                                            obj2.put("comments", comments.toString());
//                                            obj2.put("trxDate",line2s);
                                            obj2.put("trxDate",CancelDate.toString());
                                            obj2.put("currencyCode", currencyCode.toString());
                                            //                obj2.put("description",description.toString());
                                            obj2.put("description",cancellationcharge[1].toString());
                                            obj2.put("glDate",CancelDate.toString());
//                                            obj2.put("glDate", glFromBookingDtl.toString());
                                            //                        obj2.put("glDate", cutOffDate);
                                            obj2.put("invoicingRuleName", invoicingRuleName.toString());
                                            obj2.put("accountingRuleName", accountingRuleName.toString());
                                            obj2.put("ruleEndDate",line2e);
                                            obj2.put("ruleStartDate",line2s);
                                            obj2.put("unitSellingPrice",cancellationamtount[1]);
                                            obj2.put("lineType", lineType.toString());
                                            obj2.put("quantity", quantity.toString());
                                            obj2.put("paymentTermsName", paymentTermsName.toString());
                                            obj2.put("taxCode", taxCode.toString());
                                            obj2.put("flexContext", flexContext.toString());
                                            obj2.put("leaseNumber", leaseNumber.toString());
                                            obj2.put("bookingNumber", bookingNumber.toString());
                                            obj2.put("accountClass", accountClass.toString());
                                            obj2.put("dynamicInsertion", dynamicInsertion.toString());
                                            obj2.put("segmentedCode", segmentedCode.toString());
                                            obj2.put("ledgerName", ledgerName.toString());
                                            obj2.put("enabledFlag", enabledFlag.toString());
                                            obj2.put("fromDate", fromDate.toString());
                                            obj2.put("toDate", toDate.toString());
                                            obj2.put("environment", environment.toString());
                                            obj2.put("transactions", transactionValue + "");
//                                            Leasing Dubai=300000001937102;
                                            // Leasing Sharjah=300000001937026;
                                          if(buName.equalsIgnoreCase("Leasing Dubai"))//(orgId.toString().equalsIgnoreCase("300000001937102"))
                                          {
                                           jbdd=new Long(dline2);
                                           obj2.put("ccId", jbdd);
                                           }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                                          {
                                          jbds=new Long(sline2);
                                          obj2.put("ccId", jbds);
                                          }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                                            {
                                                jbdas=new Long(asline2);
                                                obj2.put("ccId", jbdas);
                                            }
//                                            obj2.put("ccId", revAccountId);
//                                            obj2.put("tenantYears","0");
                                            obj2.put("cancellationNo",CancelNo);
                            
                            
                                            JSFUtils.addFacesInformationMessage("Invoice Actual JSON object" +
                                                                                obj2.toString());
                                            System.out.println("Invoice Actual JSON obj2ect" +
                                                               obj2.toString());
                                            OkHttpClient client2 = new OkHttpClient();
                                            MediaType mediaType2 = MediaType.parse("application/json");
                                            RequestBody body2 =
                                                RequestBody.create(mediaType2, obj2.toJSONString());
                                            Request request2 =
                                                new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body2).addHeader("Content-Type",
                                                                                                                                                                            "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                          "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                                "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                     //test instance                       
//                     Request request2 =
//                         new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body2).addHeader("Content-Type",
//                                                                                                                                                     "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                   "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                         "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                            
                                            Response response2 = client2.newCall(request2).execute();
                            
                                            JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                                response2);
                                            InputStream isr2 = response2.body().byteStream();
                                            BufferedReader reader2 =
                                                new BufferedReader(new InputStreamReader(isr2));
                                            StringBuilder out2 = new StringBuilder();
                                            String resultsXml2;
                            
                                            while ((resultsXml2 = reader2.readLine()) != null) {
                                                out2.append(resultsXml2);
                                            }
                            
                                            JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                                                out2.toString());
                                            String responseOut2 = out2.toString();
                                            if (responseOut2 != null) {
                                                //                        responseOut2.contains("{\"result\":\"Success\"}");
                                                //                                    leaseVO.getCurrentRow().setAttribute("IntegrationResponse", responseOut2);
                            
                            
                                            }
                                            System.out.println("Invoice Response in json" +
                                                               out2.toString());
                                            transactionValue++;
                            
                            
                                            //line 3=============================================================
                                            JSONObject obj3 = new JSONObject();
                                            obj3.put("orgId", orgId.toString());
                                            obj3.put("unitName", unitName);
                                            obj3.put("buildingName", buildingName);
                                            //                obj3.put("amount",amount.toString());
                                            obj3.put("amount",cancellationamtount[2]);
                                            obj3.put("batchSourceName", batchSourceName.toString());
                                            obj3.put("customerTrxTypeName",
                                                     customerTrxTypeName.toString());
                                            obj3.put("billCustomerAccountNumber",
                                                     billCustomerAccountNumber.toString());
                                            obj3.put("billCustomerSiteNumber",
                                                     billCustomerSiteNumber.toString());
                                            obj3.put("billingDate", billingDate.toString());
                                            obj3.put("comments", comments.toString());
//                                            obj3.put("trxDate",line3s);
                                            obj3.put("trxDate",CancelDate.toString());
                                            obj3.put("currencyCode", currencyCode.toString());
                                            //                obj3.put("description",description.toString());
                                            obj3.put("description",cancellationcharge[2].toString());
                                            obj3.put("glDate",CancelDate.toString());
//                                            obj3.put("glDate", glFromBookingDtl.toString());
                                            //                        obj3.put("glDate", cutOffDate);
                                            obj3.put("invoicingRuleName", invoicingRuleName.toString());
                                            obj3.put("accountingRuleName", accountingRuleName.toString());
                                            obj3.put("ruleEndDate",line3e);
                                            obj3.put("ruleStartDate",line3s);
                                            obj3.put("unitSellingPrice",cancellationamtount[2]);
                                            obj3.put("lineType", lineType.toString());
                                            obj3.put("quantity", quantity.toString());
                                            obj3.put("paymentTermsName", paymentTermsName.toString());
                                            obj3.put("taxCode", taxCode.toString());
                                            obj3.put("flexContext", flexContext.toString());
                                            obj3.put("leaseNumber", leaseNumber.toString());
                                            obj3.put("bookingNumber", bookingNumber.toString());
                                            obj3.put("accountClass", accountClass.toString());
                                            obj3.put("dynamicInsertion", dynamicInsertion.toString());
                                            obj3.put("segmentedCode", segmentedCode.toString());
                                            obj3.put("ledgerName", ledgerName.toString());
                                            obj3.put("enabledFlag", enabledFlag.toString());
                                            obj3.put("fromDate", fromDate.toString());
                                            obj3.put("toDate", toDate.toString());
                                            obj3.put("environment", environment.toString());
                                            obj3.put("transactions", transactionValue + "");
//                                            Leasing Dubai=300000001937102;
                                                                                   // Leasing Sharjah=300000001937026;
                                                                                 if(buName.equalsIgnoreCase("Leasing Dubai"))//(orgId.toString().equalsIgnoreCase("300000001937102"))
                                                                                 {
                                                                                  jbdd=new Long(dline3);
                                                                                  obj3.put("ccId",jbdd);
                                                                                  }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                                                                                 {
                                                                                 jbds=new Long(sline3);
                                                                                 obj3.put("ccId",jbds);
                                                                                  }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                                            {
                                                jbdas=new Long(asline3);
                                                obj3.put("ccId", jbdas);
                                            }
//                                            obj3.put("ccId", revAccountId);
//                                            obj3.put("tenantYears","0");
                                            obj3.put("cancellationNo",CancelNo);
                            
                                            JSFUtils.addFacesInformationMessage("Invoice Actual JSON object" +
                                                                                obj3.toString());
                                            System.out.println("Invoice Actual JSON object" +
                                                               obj3.toString());
                                            OkHttpClient client3 = new OkHttpClient();
                                            MediaType mediaType3 = MediaType.parse("application/json");
                                            RequestBody body3 =
                                                RequestBody.create(mediaType3, obj3.toJSONString());
                                            Request request3 =
                                                new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body3).addHeader("Content-Type",
                                                                                                                                                                            "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                          "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                                "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                     //test instance                       
//                     Request request3 =
//                         new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body3).addHeader("Content-Type",
//                                                                                                                                                     "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                   "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                         "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                            
                                            Response response3 = client3.newCall(request3).execute();
                            
                                            JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                                response3);
                                            InputStream isr3 = response3.body().byteStream();
                                            BufferedReader reader3 =
                                                new BufferedReader(new InputStreamReader(isr3));
                                            StringBuilder out3 = new StringBuilder();
                                            String resultsXml3;
                            
                                            while ((resultsXml3 = reader3.readLine()) != null) {
                                                out3.append(resultsXml3);
                                            }
                            
                                            JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                                                out3.toString());
                                            String responseOut3 = out3.toString();
                                            if (responseOut3 != null) {
                                                //                        responseOut3.contains("{\"result\":\"Success\"}");
                                                //                                    leaseVO.getCurrentRow().setAttribute("IntegrationResponse", responseOut3);
//                                                ADFUtils.findOperation("Commit").execute();
                            
                                            }
                                            System.out.println("Invoice Response in json" +
                                                               out3.toString());
                                            transactionValue++;
                            
                                            //line four=====================================================
                                            JSONObject obj4 = new JSONObject();
                                            obj4.put("orgId", orgId.toString());
                                            obj4.put("unitName", unitName);
                                            obj4.put("buildingName", buildingName);
                                            //                obj4.put("amount",amount.toString());
                                            obj4.put("amount",cancellationamtount[3]);
                                            obj4.put("batchSourceName", batchSourceName.toString());
                                            obj4.put("customerTrxTypeName",
                                                     customerTrxTypeName.toString());
                                            obj4.put("billCustomerAccountNumber",
                                                     billCustomerAccountNumber.toString());
                                            obj4.put("billCustomerSiteNumber",
                                                     billCustomerSiteNumber.toString());
                                            obj4.put("billingDate", billingDate.toString());
                                            obj4.put("comments", comments.toString());
                                            obj4.put("trxDate",CancelDate.toString());
//                                            obj4.put("trxDate",line4s);
                                            obj4.put("currencyCode", currencyCode.toString());
                                            //                obj4.put("description",description.toString());
                                            obj4.put("description",cancellationcharge[3].toString());
                                            obj4.put("glDate",CancelDate.toString());
//                                            obj4.put("glDate", glFromBookingDtl.toString());
                                            //                        obj4.put("glDate", cutOffDate);
                                            obj4.put("invoicingRuleName", invoicingRuleName.toString());
                                            obj4.put("accountingRuleName", accountingRuleName.toString());
                                            obj4.put("ruleEndDate",line4e);
                                            obj4.put("ruleStartDate",line4s);
                                            obj4.put("unitSellingPrice",cancellationamtount[3]);
                                            obj4.put("lineType", lineType.toString());
                                            obj4.put("quantity", quantity.toString());
                                            obj4.put("paymentTermsName", paymentTermsName.toString());
                                            if(isWaiveVat.equalsIgnoreCase("YES")){
                                                obj4.put("taxCode", "VAT 0%");
                                            }else{
                                            obj4.put("taxCode", taxCode.toString());
                                            }
                                            obj4.put("flexContext", flexContext.toString());
                                            obj4.put("leaseNumber", leaseNumber.toString());
                                            obj4.put("bookingNumber", bookingNumber.toString());
                                            obj4.put("accountClass", accountClass.toString());
                                            obj4.put("dynamicInsertion", dynamicInsertion.toString());
                                            obj4.put("segmentedCode", segmentedCode.toString());
                                            obj4.put("ledgerName", ledgerName.toString());
                                            obj4.put("enabledFlag", enabledFlag.toString());
                                            obj4.put("fromDate", fromDate.toString());
                                            obj4.put("toDate", toDate.toString());
                                            obj4.put("environment", environment.toString());
                                            obj4.put("transactions", transactionValue + "");
//                                            Leasing Dubai=300000001937102;
                                           // Leasing Sharjah=300000001937026;
                                            if(buName.equalsIgnoreCase("Leasing Dubai"))//(orgId.toString().equalsIgnoreCase("300000001937102"))
                                             {
                                            jbdd=new Long(dline4);
                                            obj4.put("ccId",jbdd);
                                          }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                                          {
                                          jbds=new Long(sline4);
                                          obj4.put("ccId",jbds);
                                          }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                                            {
                                                jbdas=new Long(asline4);
                                                obj4.put("ccId", jbdas);
                                            }
//                                            obj4.put("ccId", revAccountId);
//                                            obj4.put("tenantYears","0");
                                            obj4.put("cancellationNo",CancelNo);
                            
                                            JSFUtils.addFacesInformationMessage("Invoice Actual JSON object" +
                                                                                obj4.toString());
                                            System.out.println("Invoice Actual JSON object" +
                                                               obj4.toString());
                                            OkHttpClient client4 = new OkHttpClient();
                                            MediaType mediaType4 = MediaType.parse("application/json");
                                            RequestBody body4 =
                                                RequestBody.create(mediaType4, obj4.toJSONString());
                                            Request request4 =
                                                new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body4).addHeader("Content-Type",
                                                                                                                                                                            "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                          "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                                "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                     //test instance                       
//                     Request request4 =
//                         new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body4).addHeader("Content-Type",
//                                                                                                                                                     "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                   "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                         "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                            
                                            Response response4 = client4.newCall(request4).execute();
                            
                                            JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                                response4);
                                            InputStream isr4 = response4.body().byteStream();
                                            BufferedReader reader4 =
                                                new BufferedReader(new InputStreamReader(isr4));
                                            StringBuilder out4 = new StringBuilder();
                                            String resultsXml4;
                            
                                            while ((resultsXml4 = reader4.readLine()) != null) {
                                                out4.append(resultsXml4);
                                            }
                            
                                            JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                                                out4.toString());
                                            String responseOut4 = out4.toString();
                                            if (responseOut4 != null) {
                                                //                        responseOut4.contains("{\"result\":\"Success\"}");
                                                //                                     leaseVO.getCurrentRow().setAttribute("IntegrationResponse", responseOut4);
                                                cancelheaderrow.setAttribute("Attribute9", "Success");
                                                ADFUtils.findOperation("Commit").execute();
                            
                                            }
                                            System.out.println("Invoice Response in json" +
                                                               out4.toString());
                                            transactionValue++;
//                                      -----------      
                                         //=============line 5
                                         JSONObject obj6 = new JSONObject();
                                                                                    obj6.put("orgId", orgId.toString());
                                                                                    obj6.put("unitName", unitName);
                                                                                    obj6.put("buildingName", buildingName);
                                                                                    //                obj6.put("amount",amount.toString());
                                                                                    obj6.put("amount",AmountWaived);
                                                                                    obj6.put("batchSourceName", batchSourceName.toString());
                                                                                    obj6.put("customerTrxTypeName",
                                                                                             customerTrxTypeName.toString());
                                                                                    obj6.put("billCustomerAccountNumber",
                                                                                             billCustomerAccountNumber.toString());
                                                                                    obj6.put("billCustomerSiteNumber",
                                                                                             billCustomerSiteNumber.toString());
                                                                                    obj6.put("billingDate", billingDate.toString());
                                                                                    obj6.put("comments", comments.toString());
                                                                                    obj6.put("trxDate",CancelDate.toString());
//                                                                                    obj6.put("trxDate",line4s);
                                                                                    obj6.put("currencyCode", currencyCode.toString());
                                                                                    //                obj6.put("description",description.toString());
                                                                                    obj6.put("description","waiverd penalty");
                                                                                    obj6.put("glDate",CancelDate.toString());
//                                                                                    obj6.put("glDate", glFromBookingDtl.toString());
                                                                                    //                        obj6.put("glDate", cutOffDate);
                                                                                    obj6.put("invoicingRuleName", invoicingRuleName.toString());
                                                                                    obj6.put("accountingRuleName", accountingRuleName.toString());
                                                                                    obj6.put("ruleEndDate",line4e);
                                                                                    obj6.put("ruleStartDate",line4s);
                                                                                    obj6.put("unitSellingPrice",AmountWaived);
                                                                                    obj6.put("lineType", lineType.toString());
                                                                                    obj6.put("quantity", quantity.toString());
                                                                                    obj6.put("paymentTermsName", paymentTermsName.toString());
                                                                                    obj6.put("taxCode", "VAT 0%");
                                                                                    obj6.put("flexContext", flexContext.toString());
                                                                                    obj6.put("leaseNumber", leaseNumber.toString());
                                                                                    obj6.put("bookingNumber", bookingNumber.toString());
                                                                                    obj6.put("accountClass", accountClass.toString());
                                                                                    obj6.put("dynamicInsertion", dynamicInsertion.toString());
                                                                                    obj6.put("segmentedCode", segmentedCode.toString());
                                                                                    obj6.put("ledgerName", ledgerName.toString());
                                                                                    obj6.put("enabledFlag", enabledFlag.toString());
                                                                                    obj6.put("fromDate", fromDate.toString());
                                                                                    obj6.put("toDate", toDate.toString());
                                                                                    obj6.put("environment", environment.toString());
                                                                                    obj6.put("transactions", transactionValue + "");
//                                            Leasing Dubai=300000001937102;
                                            // Leasing Sharjah=300000001937026;
                                            if(buName.equalsIgnoreCase("Leasing Dubai"))//(orgId.toString().equalsIgnoreCase("300000001937102"))
                                             {
                                            jbdd=new Long(dline5);
                                            obj6.put("ccId", jbdd);
                                            }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                                            {
                                            jbds=new Long(sline5);
                                            obj6.put("ccId", jbds);
                                            }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                                            {
                                                jbdas=new Long(asline5);
                                                obj6.put("ccId", jbdas);
                                            }
//                                                                                    obj6.put("ccId", revAccountId);
//                                                                                    obj6.put("tenantYears","0");
                                                                                    obj6.put("cancellationNo",CancelNo);
                                                                    
                                                                                    JSFUtils.addFacesInformationMessage("Invoice Actual JSON object" +
                                                                                                                        obj6.toString());
                                                                                    System.out.println("Invoice Actual JSON object" +
                                                                                                       obj6.toString());
                                                                                    OkHttpClient client6 = new OkHttpClient();
                                                                                    MediaType mediaType6 = MediaType.parse("application/json");
                                                                                    RequestBody body6 =
                                                                                        RequestBody.create(mediaType6, obj6.toJSONString());
                                                                                    Request request6 =
                                                                                        new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body6).addHeader("Content-Type",
                                                                                                                                                                                                                    "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                                                                  "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                                                                        "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                     //test instance                                                               
//                     Request request6 =
//                         new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body6).addHeader("Content-Type",
//                                                                                                                                                     "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                   "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                         "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                                                                    
                                                                                    Response response6 = client6.newCall(request6).execute();
                                                                    
                                                                                    JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                                                                        response6);
                                                                                    InputStream isr6 = response6.body().byteStream();
                                                                                    BufferedReader reader6 =
                                                                                        new BufferedReader(new InputStreamReader(isr6));
                                                                                    StringBuilder out6 = new StringBuilder();
                                                                                    String resultsXml6;
                                                                    
                                                                                    while ((resultsXml6 = reader6.readLine()) != null) {
                                                                                        out6.append(resultsXml6);
                                                                                    }
                                                                    
                                                                                    JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                                                                                        out6.toString());
                                                                                    String responseOut6 = out6.toString();
                                                                                    if (responseOut6 != null) {
                                                                                        //                        responseOut6.contains("{\"result\":\"Success\"}");
                                                                                        //                                    leaseVO.getCurrentRow().setAttribute("IntegrationResponse", responseOut6);
                                                                                        cancelheaderrow.setAttribute("Attribute9", "Success");
                                                                                        ADFUtils.findOperation("Commit").execute();
                                                                    
                                                                                    }
                                                                                    System.out.println("Invoice Response in json" +
                                                                                                       out6.toString());
                                                                                    transactionValue++;                                                                                 
            //=============line 6
            Double dCrtcasAdj = new Double(0.0);
            if(!crtcasAdj.equals("")){   //only to handle null case
            dCrtcasAdj = new Double(crtcasAdj);
               JSONObject obj7 = new JSONObject();
                                                                                                obj7.put("orgId", orgId.toString());
                                                                                                obj7.put("unitName", unitName);
                                                                                                obj7.put("buildingName", buildingName);
                                                                                                //                obj7.put("amount",amount.toString());
                                                                                                obj7.put("amount",netCourtcasAdjmnt);
                                                                                                obj7.put("batchSourceName", batchSourceName.toString());
                                                                                                obj7.put("customerTrxTypeName",
                                                                                                         customerTrxTypeName.toString());
                                                                                                obj7.put("billCustomerAccountNumber",
                                                                                                         billCustomerAccountNumber.toString());
                                                                                                obj7.put("billCustomerSiteNumber",
                                                                                                         billCustomerSiteNumber.toString());
                                                                                                obj7.put("billingDate", billingDate.toString());
                                                                                                obj7.put("comments", comments.toString());
                                                                                                obj7.put("trxDate",CancelDate.toString());
            //                                                                                  obj7.put("trxDate",line4s);
                                                                                                obj7.put("currencyCode", currencyCode.toString());
                                                                                                //                obj7.put("description",description.toString());
                                                                                                obj7.put("description","Court Case Adjustment");
                                                                                                obj7.put("glDate",CancelDate.toString());
            //                                                                                  obj7.put("glDate", glFromBookingDtl.toString());
                                                                                                //                        obj7.put("glDate", cutOffDate);
                                                                                                obj7.put("invoicingRuleName", invoicingRuleName.toString());
                                                                                                obj7.put("accountingRuleName", accountingRuleName.toString());
                                                                                                obj7.put("ruleEndDate",line4e);
                                                                                                obj7.put("ruleStartDate",line4s);
                                                                                                obj7.put("unitSellingPrice",netCourtcasAdjmnt);
                                                                                                obj7.put("lineType", lineType.toString());
                                                                                                obj7.put("quantity", quantity.toString());
                                                                                                obj7.put("paymentTermsName", paymentTermsName.toString());
                                                                                                obj7.put("taxCode", "VAT 0%");
                                                                                                obj7.put("flexContext", flexContext.toString());
                                                                                                obj7.put("leaseNumber", leaseNumber.toString());
                                                                                                obj7.put("bookingNumber", bookingNumber.toString());
                                                                                                obj7.put("accountClass", accountClass.toString());
                                                                                                obj7.put("dynamicInsertion", dynamicInsertion.toString());
                                                                                                obj7.put("segmentedCode", segmentedCode.toString());
                                                                                                obj7.put("ledgerName", ledgerName.toString());
                                                                                                obj7.put("enabledFlag", enabledFlag.toString());
                                                                                                obj7.put("fromDate", fromDate.toString());
                                                                                                obj7.put("toDate", toDate.toString());
                                                                                                obj7.put("environment", environment.toString());
                                                                                                obj7.put("transactions", transactionValue + "");
            //                                            Leasing Dubai=300000001937102;
                                                        // Leasing Sharjah=300000001937026;
                                                        if(buName.equalsIgnoreCase("Leasing Dubai"))//(orgId.toString().equalsIgnoreCase("300000001937102"))
                                                         {
                                                        jbdd=new Long(dline5);
                                                        obj7.put("ccId", jbdd);
                                                        }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                                                        {
                                                        jbds=new Long(sline5);
                                                        obj7.put("ccId", jbds);
                                                        }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                                                        {
                                                        jbdas=new Long(asline5);
                                                        obj7.put("ccId", jbdas);
                                                        }
            //                                                                                    obj7.put("ccId", revAccountId);
            //                                                                                    obj7.put("tenantYears","0");
                                                                                                obj7.put("cancellationNo",CancelNo);
                                                                                
                                                                                                JSFUtils.addFacesInformationMessage("Invoice Actual JSON object" +
                                                                                                                                    obj7.toString());
                                                                                                System.out.println("Invoice Actual JSON object" +
                                                                                                                   obj7.toString());
                                                                                                OkHttpClient client7 = new OkHttpClient();
                                                                                                MediaType mediaType7 = MediaType.parse("application/json");
                                                                                                RequestBody body7 =
                                                                                                    RequestBody.create(mediaType7, obj7.toJSONString());
                                                                                                Request request7 =
                                                                                                    new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body7).addHeader("Content-Type",
                                                                                                                                                                                                                                "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                                                                              "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                                                                                    "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                                                                                                //test instance
//                                                                                                 Request request7 =
//                                                                                                     new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body7).addHeader("Content-Type",
//                                                                                                                                                                                                                                 "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                                                                                               "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                                                                                                     "493ffe37-eaac-45fc-9962-8c6883aff73e").build();                
                                                                                
                                                                                                Response response7 = client7.newCall(request7).execute();
                                                                                
                                                                                                JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                                                                                    response7);
                                                                                                InputStream isr7 = response6.body().byteStream();
                                                                                                BufferedReader reader7 =
                                                                                                    new BufferedReader(new InputStreamReader(isr7));
                                                                                                StringBuilder out7 = new StringBuilder();
                                                                                                String resultsXml7;
                                                                                
                                                                                                while ((resultsXml7 = reader7.readLine()) != null) {
                                                                                                    out6.append(resultsXml7);
                                                                                                }
                                                                                
                                                                                                JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                                                                                                    out7.toString());
                                                                                                String responseOut7 = out7.toString();
                                                                                                if (responseOut7 != null) {
                                                                                                    //                        responseOut7.contains("{\"result\":\"Success\"}");
                                                                                                    //                                    leaseVO.getCurrentRow().setAttribute("IntegrationResponse", responseOut6);
                                                                                                    cancelheaderrow.setAttribute("Attribute9", "Success");
                                                                                                    ADFUtils.findOperation("Commit").execute();
                                                                                
                                                                                                }
                                                                                                System.out.println("Invoice Response in json" +
                                                                                                                   out7.toString());
                                                                                                transactionValue++;
                                                                                             }
            
                 } //end of if validation 
            }
            //pushing 1 rows to saas + 1 row waived amt (total=2 push)
            else if(rowcount==1)
            {
                //line 1============================overstay=================================
                JSONObject obj5 = new JSONObject();
                obj5.put("orgId", orgId.toString());
                obj5.put("unitName", unitName);
                obj5.put("buildingName", buildingName);
                //                obj5.put("amount",amount.toString());
                obj5.put("amount",cancellationamtount[0].toString());
                obj5.put("batchSourceName", batchSourceName.toString());
                obj5.put("customerTrxTypeName",
                         customerTrxTypeName.toString());
                obj5.put("billCustomerAccountNumber",
                         billCustomerAccountNumber.toString());
                obj5.put("billCustomerSiteNumber",
                         billCustomerSiteNumber.toString());
                obj5.put("billingDate", billingDate.toString());
                obj5.put("comments", comments.toString());
                obj5.put("trxDate",CancelDate.toString());
//                obj5.put("trxDate",line5s);
                obj5.put("currencyCode", currencyCode.toString());
                //                obj5.put("description",description.toString());
                obj5.put("description",cancellationcharge[0].toString());
                obj5.put("glDate",CancelDate.toString());
//                obj5.put("glDate", glFromBookingDtl.toString());
                //                        obj5.put("glDate", cutOffDate);
                obj5.put("invoicingRuleName", invoicingRuleName.toString());
                obj5.put("accountingRuleName", accountingRuleName.toString());
                obj5.put("ruleEndDate",line5e);
                obj5.put("ruleStartDate",line5s);
                obj5.put("unitSellingPrice",cancellationamtount[0].toString());
                obj5.put("lineType", lineType.toString());
                obj5.put("quantity", quantity.toString());
                obj5.put("paymentTermsName", paymentTermsName.toString());
                obj5.put("taxCode", taxCode.toString());
                obj5.put("flexContext", flexContext.toString());
                obj5.put("leaseNumber", leaseNumber.toString());
                obj5.put("bookingNumber", bookingNumber.toString());
                obj5.put("accountClass", accountClass.toString());
                obj5.put("dynamicInsertion", dynamicInsertion.toString());
                obj5.put("segmentedCode", segmentedCode.toString());
                obj5.put("ledgerName", ledgerName.toString());
                obj5.put("enabledFlag", enabledFlag.toString());
                obj5.put("fromDate", fromDate.toString());
                obj5.put("toDate", toDate.toString());
                obj5.put("environment", environment.toString());
                obj5.put("transactions", transactionValue + "");
//                Leasing Dubai=300000001937102;
                // Leasing Sharjah=300000001937026;
                if(buName.equalsIgnoreCase("Leasing Dubai"))//(orgId.toString().equalsIgnoreCase("300000001937102"))
                 {
                jbdd=new Long(doverstay);
                obj5.put("ccId",jbdd); 
                }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                {
                jbds=new Long(soverstay);
                obj5.put("ccId",jbds);
                }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                {
                jbdas=new Long(asoverstay);
                obj5.put("ccId", jbdas);
                }
//              obj5.put("ccId", revAccountId);
//                obj5.put("tenantYears","0");
                obj5.put("cancellationNo",CancelNo);
                
                JSFUtils.addFacesInformationMessage("Invoice Actual JSON object" +
                                                    obj5.toString());
                System.out.println("Invoice Actual JSON obj2ect" +
                                   obj5.toString());
                OkHttpClient client5 = new OkHttpClient();
                MediaType mediaType5 = MediaType.parse("application/json");
                RequestBody body5 =
                    RequestBody.create(mediaType5, obj5.toJSONString());
                Request request5 =
                    new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body5).addHeader("Content-Type",
                                                                                                                                                "application/json").addHeader("Cache-Control",
                                                                                                                                                                              "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                    "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                //test instance
//                Request request5 =
//                    new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body5).addHeader("Content-Type",
//                                                                                                                                                "application/json").addHeader("Cache-Control",
//                                                                                                                                                                              "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                    "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                
                Response response5 = client5.newCall(request5).execute();
                
                JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                    response5);
                InputStream isr5 = response5.body().byteStream();
                BufferedReader reader5 =
                    new BufferedReader(new InputStreamReader(isr5));
                StringBuilder out5 = new StringBuilder();
                String resultsXml5;
                
                while ((resultsXml5 = reader5.readLine()) != null) {
                    out5.append(resultsXml5);
                }
                
                JSFUtils.addFacesInformationMessage("Invoice Response in json" +out5.toString());
                String responseOut5 = out5.toString();
                if (responseOut5 != null) {                    
                    cancelheaderrow.setAttribute("Attribute9", "Success");
                    ADFUtils.findOperation("Commit").execute();                
                }
                System.out.println("Invoice Response in json" +
                                   out5.toString());
                transactionValue++;

                //                -----------
                                         //=============line 2
                                         JSONObject obj6 = new JSONObject();
                                                                                    obj6.put("orgId", orgId.toString());
                                                                                    obj6.put("unitName", unitName);
                                                                                    obj6.put("buildingName", buildingName);
                                                                                    //                obj6.put("amount",amount.toString());
                                                                                    obj6.put("amount",AmountWaived);
                                                                                    obj6.put("batchSourceName", batchSourceName.toString());
                                                                                    obj6.put("customerTrxTypeName",
                                                                                             customerTrxTypeName.toString());
                                                                                    obj6.put("billCustomerAccountNumber",
                                                                                             billCustomerAccountNumber.toString());
                                                                                    obj6.put("billCustomerSiteNumber",
                                                                                             billCustomerSiteNumber.toString());
                                                                                    obj6.put("billingDate", billingDate.toString());
                                                                                    obj6.put("comments", comments.toString());
                                                                                    obj6.put("trxDate",CancelDate.toString());
                //                                                                                    obj6.put("trxDate",line4s);
                                                                                    obj6.put("currencyCode", currencyCode.toString());
                                                                                    //                obj6.put("description",description.toString());
                                                                                    obj6.put("description","waiverd penalty");
                                                                                    obj6.put("glDate",CancelDate.toString());
                //                                                                                    obj6.put("glDate", glFromBookingDtl.toString());
                                                                                    //                        obj6.put("glDate", cutOffDate);
                                                                                    obj6.put("invoicingRuleName", invoicingRuleName.toString());
                                                                                    obj6.put("accountingRuleName", accountingRuleName.toString());
                                                                                    obj6.put("ruleEndDate",line5e);
                                                                                    obj6.put("ruleStartDate",line5s);
                                                                                    obj6.put("unitSellingPrice",AmountWaived);
                                                                                    obj6.put("lineType", lineType.toString());
                                                                                    obj6.put("quantity", quantity.toString());
                                                                                    obj6.put("paymentTermsName", paymentTermsName.toString());
                                                                                     if(isWaiveVat.equalsIgnoreCase("YES")){
                                                                                    obj6.put("taxCode", taxCode.toString());
                                                                                     }else{
                                                                                    obj6.put("taxCode", "VAT 0%");
                                                                                     }
                                                                                    obj6.put("flexContext", flexContext.toString());
                                                                                    obj6.put("leaseNumber", leaseNumber.toString());
                                                                                    obj6.put("bookingNumber", bookingNumber.toString());
                                                                                    obj6.put("accountClass", accountClass.toString());
                                                                                    obj6.put("dynamicInsertion", dynamicInsertion.toString());
                                                                                    obj6.put("segmentedCode", segmentedCode.toString());
                                                                                    obj6.put("ledgerName", ledgerName.toString());
                                                                                    obj6.put("enabledFlag", enabledFlag.toString());
                                                                                    obj6.put("fromDate", fromDate.toString());
                                                                                    obj6.put("toDate", toDate.toString());
                                                                                    obj6.put("environment", environment.toString());
                                                                                    obj6.put("transactions", transactionValue + "");
                //                                            Leasing Dubai=300000001937102;
                                            // Leasing Sharjah=300000001937026;
                                            if(buName.equalsIgnoreCase("Leasing Dubai"))//(orgId.toString().equalsIgnoreCase("300000001937102"))
                                             {
                                            jbdd=new Long(dline5);
                                            obj6.put("ccId", jbdd);
                                            }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                                            {
                                            jbds=new Long(sline5);
                                            obj6.put("ccId", jbds);
                                            }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                                            {
                                            jbdas=new Long(asline5);
                                            obj6.put("ccId", jbdas);
                                            }
                //                                                                                    obj6.put("ccId", revAccountId);
                //                                                                                    obj6.put("tenantYears","0");
                                                                                    obj6.put("cancellationNo",CancelNo);
                                                                    
                                                                                    JSFUtils.addFacesInformationMessage("Invoice Actual JSON object" +
                                                                                                                        obj6.toString());
                                                                                    System.out.println("Invoice Actual JSON object" +
                                                                                                       obj6.toString());
                                                                                                    OkHttpClient client6 = new OkHttpClient();
                                                                                                    MediaType mediaType6 = MediaType.parse("application/json");
                                                                                                    RequestBody body6 =
                                                                                                        RequestBody.create(mediaType6, obj6.toJSONString());
                                                                                                    Request request6 =
                                                                                                        new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body6).addHeader("Content-Type",
                                                                                                                                                                                                                                    "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                                                                                  "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                                                                                        "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                 //test instance                                                                                   
//                Request request6 =
//                    new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body6).addHeader("Content-Type",
//                                                                                                                                                "application/json").addHeader("Cache-Control",
//                                                                                                                                                                              "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                    "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                
                                                                                                    Response response6 = client6.newCall(request6).execute();
                
                                                                                                    JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                                                                                        response6);
                                                                                                    InputStream isr6 = response6.body().byteStream();
                                                                                                    BufferedReader reader6 =
                                                                                                        new BufferedReader(new InputStreamReader(isr6));
                                                                                                    StringBuilder out6 = new StringBuilder();
                                                                                                    String resultsXml6;
                
                                                                                                    while ((resultsXml6 = reader6.readLine()) != null) {
                                                                                                        out6.append(resultsXml6);
                                                                                                    }
                
                                                                                                    JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                                                                                                        out6.toString());
                                                                                                    String responseOut6 = out6.toString();
                                                                                                    if (responseOut6 != null) {
                                                                                                        cancelheaderrow.setAttribute("Attribute9", "Success");
                                                                                                        ADFUtils.findOperation("Commit").execute();
                                                                                                    }
                                                                                                    System.out.println("Invoice Response in json" +
                                                                                                                       out6.toString());
                                                                                    transactionValue++; 
                //=============line 3 //if  court case adjstment is there then
                Double dCrtcasAdj = new Double(0.0);
                if(!crtcasAdj.equals("")){   //only to handle null case
                dCrtcasAdj = new Double(crtcasAdj);
                   JSONObject obj7 = new JSONObject();
                                                                                                    obj7.put("orgId", orgId.toString());
                                                                                                    obj7.put("unitName", unitName);
                                                                                                    obj7.put("buildingName", buildingName);
                                                                                                    //                obj7.put("amount",amount.toString());
                                                                                                    obj7.put("amount",netCourtcasAdjmnt);
                                                                                                    obj7.put("batchSourceName", batchSourceName.toString());
                                                                                                    obj7.put("customerTrxTypeName",
                                                                                                             customerTrxTypeName.toString());
                                                                                                    obj7.put("billCustomerAccountNumber",
                                                                                                             billCustomerAccountNumber.toString());
                                                                                                    obj7.put("billCustomerSiteNumber",
                                                                                                             billCustomerSiteNumber.toString());
                                                                                                    obj7.put("billingDate", billingDate.toString());
                                                                                                    obj7.put("comments", comments.toString());
                                                                                                    obj7.put("trxDate",CancelDate.toString());
                //                                                                                  obj7.put("trxDate",line4s);
                                                                                                    obj7.put("currencyCode", currencyCode.toString());
                                                                                                    //                obj7.put("description",description.toString());
                                                                                                    obj7.put("description","Court Case Adjustment");
                                                                                                    obj7.put("glDate",CancelDate.toString());
                //                                                                                  obj7.put("glDate", glFromBookingDtl.toString());
                                                                                                    //                        obj7.put("glDate", cutOffDate);
                                                                                                    obj7.put("invoicingRuleName", invoicingRuleName.toString());
                                                                                                    obj7.put("accountingRuleName", accountingRuleName.toString());
                                                                                                    obj7.put("ruleEndDate",line5e);
                                                                                                    obj7.put("ruleStartDate",line5s);
                                                                                                    obj7.put("unitSellingPrice",netCourtcasAdjmnt);
                                                                                                    obj7.put("lineType", lineType.toString());
                                                                                                    obj7.put("quantity", quantity.toString());
                                                                                                    obj7.put("paymentTermsName", paymentTermsName.toString());
                                                                                                    obj7.put("taxCode", "VAT 0%");
                                                                                                    obj7.put("flexContext", flexContext.toString());
                                                                                                    obj7.put("leaseNumber", leaseNumber.toString());
                                                                                                    obj7.put("bookingNumber", bookingNumber.toString());
                                                                                                    obj7.put("accountClass", accountClass.toString());
                                                                                                    obj7.put("dynamicInsertion", dynamicInsertion.toString());
                                                                                                    obj7.put("segmentedCode", segmentedCode.toString());
                                                                                                    obj7.put("ledgerName", ledgerName.toString());
                                                                                                    obj7.put("enabledFlag", enabledFlag.toString());
                                                                                                    obj7.put("fromDate", fromDate.toString());
                                                                                                    obj7.put("toDate", toDate.toString());
                                                                                                    obj7.put("environment", environment.toString());
                                                                                                    obj7.put("transactions", transactionValue + "");
                //                                            Leasing Dubai=300000001937102;
                                                            // Leasing Sharjah=300000001937026;
                                                            if(buName.equalsIgnoreCase("Leasing Dubai"))//(orgId.toString().equalsIgnoreCase("300000001937102"))
                                                             {
                                                            jbdd=new Long(dline5);
                                                            obj7.put("ccId", jbdd);
                                                            }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                                                            {
                                                            jbds=new Long(sline5);
                                                            obj7.put("ccId", jbds);
                                                            }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                                                            {
                                                            jbdas=new Long(asline5);
                                                            obj7.put("ccId", jbdas);
                                                            }
                //                                                                                    obj7.put("ccId", revAccountId);
                //                                                                                    obj7.put("tenantYears","0");
                                                                                                    obj7.put("cancellationNo",CancelNo);
                                                                                    
                                                                                                    JSFUtils.addFacesInformationMessage("Invoice Actual JSON object" +
                                                                                                                                        obj7.toString());
                                                                                                    System.out.println("Invoice Actual JSON object" +
                                                                                                                       obj7.toString());
                                                                                                    OkHttpClient client7 = new OkHttpClient();
                                                                                                    MediaType mediaType7 = MediaType.parse("application/json");
                                                                                                    RequestBody body7 =
                                                                                                        RequestBody.create(mediaType7, obj7.toJSONString());
                                                                                                    Request request7 =
                                                                                                        new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body7).addHeader("Content-Type",
                                                                                                                                                                                                                                    "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                                                                                  "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                                                                                        "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                                                                                                    //test instance
//                                                                                                     Request request7 =
//                                                                                                         new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body7).addHeader("Content-Type",
//                                                                                                                                                                                                                                     "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                                                                                                   "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                                                                                                         "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                                                                                    
                                                                                                    Response response7 = client7.newCall(request7).execute();
                                                                                    
                                                                                                    JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                                                                                        response7);
                                                                                                    InputStream isr7 = response6.body().byteStream();
                                                                                                    BufferedReader reader7 =
                                                                                                        new BufferedReader(new InputStreamReader(isr7));
                                                                                                    StringBuilder out7 = new StringBuilder();
                                                                                                    String resultsXml7;
                                                                                    
                                                                                                    while ((resultsXml7 = reader7.readLine()) != null) {
                                                                                                        out6.append(resultsXml7);
                                                                                                    }
                                                                                    
                                                                                                    JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                                                                                                        out7.toString());
                                                                                                    String responseOut7 = out7.toString();
                                                                                                    if (responseOut7 != null) {
                                                                                                        //                        responseOut7.contains("{\"result\":\"Success\"}");
                                                                                                        //                                    leaseVO.getCurrentRow().setAttribute("IntegrationResponse", responseOut6);
                                                                                                        cancelheaderrow.setAttribute("Attribute9", "Success");
                                                                                                        ADFUtils.findOperation("Commit").execute();
                                                                                    
                                                                                                    }
                                                                                                    System.out.println("Invoice Response in json" +
                                                                                                                       out7.toString());
                                                                                                    transactionValue++;
                                                                                                 }
  
            }
            else
            {   
                if(!AmountWaived.equals(new BigDecimal(0)) ){
                //=============only waived amt for net case
                JSONObject obj6 = new JSONObject();
                                                           obj6.put("orgId", orgId.toString());
                                                           obj6.put("unitName", unitName);
                                                           obj6.put("buildingName", buildingName);
                                                           //                obj6.put("amount",amount.toString());
                                                           obj6.put("amount",AmountWaived);
                                                           obj6.put("batchSourceName", batchSourceName.toString());
                                                           obj6.put("customerTrxTypeName",
                                                                    customerTrxTypeName.toString());
                                                           obj6.put("billCustomerAccountNumber",
                                                                    billCustomerAccountNumber.toString());
                                                           obj6.put("billCustomerSiteNumber",
                                                                    billCustomerSiteNumber.toString());
                                                           obj6.put("billingDate", billingDate.toString());
                                                           obj6.put("comments", comments.toString());
                                                           obj6.put("trxDate",CancelDate.toString());
                //                                                                                    obj6.put("trxDate",line4s);
                                                           obj6.put("currencyCode", currencyCode.toString());
                                                           //                obj6.put("description",description.toString());
                                                           obj6.put("description","waiverd penalty");
                                                           obj6.put("glDate",CancelDate.toString());
                //                                                                                    obj6.put("glDate", glFromBookingDtl.toString());
                                                           //                        obj6.put("glDate", cutOffDate);
                                                           obj6.put("invoicingRuleName", invoicingRuleName.toString());
                                                           obj6.put("accountingRuleName", accountingRuleName.toString());
                                                           obj6.put("ruleEndDate",line5e);
                                                           obj6.put("ruleStartDate",line5s);
                                                           obj6.put("unitSellingPrice",AmountWaived);
                                                           obj6.put("lineType", lineType.toString());
                                                           obj6.put("quantity", quantity.toString());
                                                           obj6.put("paymentTermsName", paymentTermsName.toString());
                                                              if(isWaiveVat.equalsIgnoreCase("YES")){
                                                           obj6.put("taxCode", taxCode.toString());
                                                              }else{
                                                           obj6.put("taxCode", "VAT 0%");
                                                              }
                                                           obj6.put("flexContext", flexContext.toString());
                                                           obj6.put("leaseNumber", leaseNumber.toString());
                                                           obj6.put("bookingNumber", bookingNumber.toString());
                                                           obj6.put("accountClass", accountClass.toString());
                                                           obj6.put("dynamicInsertion", dynamicInsertion.toString());
                                                           obj6.put("segmentedCode", segmentedCode.toString());
                                                           obj6.put("ledgerName", ledgerName.toString());
                                                           obj6.put("enabledFlag", enabledFlag.toString());
                                                           obj6.put("fromDate", fromDate.toString());
                                                           obj6.put("toDate", toDate.toString());
                                                           obj6.put("environment", environment.toString());
                                                           obj6.put("transactions", transactionValue + "");
                //                                            Leasing Dubai=300000001937102;
                   // Leasing Sharjah=300000001937026;
                   if(buName.equalsIgnoreCase("Leasing Dubai"))//(orgId.toString().equalsIgnoreCase("300000001937102"))
                    {
                   jbdd=new Long(dline5);
                   obj6.put("ccId", jbdd);
                       System.out.println("Dubai ccId ::"+jbdd);
                   }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                   {
                   jbds=new Long(sline5);
                   obj6.put("ccId", jbds);
                       System.out.println("Sharjah ccId ::"+jbdd);
                   }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                   {
                    jbdas=new Long(asline5);
                    obj6.put("ccId", jbdas);
                   }
                //                                                                                    obj6.put("ccId", revAccountId);
                //                                                                                    obj6.put("tenantYears","0");
                                                           obj6.put("cancellationNo",CancelNo);
                                           
                                                           JSFUtils.addFacesInformationMessage("Invoice Actual JSON object" +
                                                                                               obj6.toString());
                                                           System.out.println("Invoice Actual JSON object" +
                                                                              obj6.toString());
                                                           OkHttpClient client6 = new OkHttpClient();
                                                           MediaType mediaType6 = MediaType.parse("application/json");
                                                           RequestBody body6 =
                                                               RequestBody.create(mediaType6, obj6.toJSONString());
                                                           Request request6 =
                                                               new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body6).addHeader("Content-Type",
                                                                                                                                                                                           "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                                         "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                                               "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                     //test instance                                      
//                    Request request6 =
//                        new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body6).addHeader("Content-Type",
//                                                                                                                                                    "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                  "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                        "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                                           
                                                           Response response6 = client6.newCall(request6).execute();
                                           
                                                           JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                                               response6);
                                                           InputStream isr6 = response6.body().byteStream();
                                                           BufferedReader reader6 =
                                                               new BufferedReader(new InputStreamReader(isr6));
                                                           StringBuilder out6 = new StringBuilder();
                                                           String resultsXml6;
                                           
                                                           while ((resultsXml6 = reader6.readLine()) != null) {
                                                               out6.append(resultsXml6);
                                                           }
                                           
                                                           JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                                                               out6.toString());
                                                           String responseOut6 = out6.toString();
                                                           if (responseOut6 != null) {
                                                               //                        responseOut6.contains("{\"result\":\"Success\"}");
                                                               //                                    leaseVO.getCurrentRow().setAttribute("IntegrationResponse", responseOut6);
                                                               cancelheaderrow.setAttribute("Attribute9", "Success");
                                                               ADFUtils.findOperation("Commit").execute();
                                           
                                                           }
                                                           System.out.println("Invoice Response in json" +
                                                                              out6.toString());
                                                           transactionValue++;
                    //=============line 3 //if  court case adjstment is there then
                    Double dCrtcasAdj = new Double(0.0);
                    if(!crtcasAdj.equals("")){   //only to handle null case
                    dCrtcasAdj = new Double(crtcasAdj);
                       JSONObject obj7 = new JSONObject();
                                                                                                        obj7.put("orgId", orgId.toString());
                                                                                                        obj7.put("unitName", unitName);
                                                                                                        obj7.put("buildingName", buildingName);
                                                                                                        //                obj7.put("amount",amount.toString());
                                                                                                        obj7.put("amount",netCourtcasAdjmnt);
                                                                                                        obj7.put("batchSourceName", batchSourceName.toString());
                                                                                                        obj7.put("customerTrxTypeName",
                                                                                                                 customerTrxTypeName.toString());
                                                                                                        obj7.put("billCustomerAccountNumber",
                                                                                                                 billCustomerAccountNumber.toString());
                                                                                                        obj7.put("billCustomerSiteNumber",
                                                                                                                 billCustomerSiteNumber.toString());
                                                                                                        obj7.put("billingDate", billingDate.toString());
                                                                                                        obj7.put("comments", comments.toString());
                                                                                                        obj7.put("trxDate",CancelDate.toString());
                    //                                                                                  obj7.put("trxDate",line4s);
                                                                                                        obj7.put("currencyCode", currencyCode.toString());
                                                                                                        //                obj7.put("description",description.toString());
                                                                                                        obj7.put("description","Court Case Adjustment");
                                                                                                        obj7.put("glDate",CancelDate.toString());
                    //                                                                                  obj7.put("glDate", glFromBookingDtl.toString());
                                                                                                        //                        obj7.put("glDate", cutOffDate);
                                                                                                        obj7.put("invoicingRuleName", invoicingRuleName.toString());
                                                                                                        obj7.put("accountingRuleName", accountingRuleName.toString());
                                                                                                        obj7.put("ruleEndDate",line5e);
                                                                                                        obj7.put("ruleStartDate",line5s);
                                                                                                        obj7.put("unitSellingPrice",netCourtcasAdjmnt);
                                                                                                        obj7.put("lineType", lineType.toString());
                                                                                                        obj7.put("quantity", quantity.toString());
                                                                                                        obj7.put("paymentTermsName", paymentTermsName.toString());
                                                                                                        obj7.put("taxCode", "VAT 0%");
                                                                                                        obj7.put("flexContext", flexContext.toString());
                                                                                                        obj7.put("leaseNumber", leaseNumber.toString());
                                                                                                        obj7.put("bookingNumber", bookingNumber.toString());
                                                                                                        obj7.put("accountClass", accountClass.toString());
                                                                                                        obj7.put("dynamicInsertion", dynamicInsertion.toString());
                                                                                                        obj7.put("segmentedCode", segmentedCode.toString());
                                                                                                        obj7.put("ledgerName", ledgerName.toString());
                                                                                                        obj7.put("enabledFlag", enabledFlag.toString());
                                                                                                        obj7.put("fromDate", fromDate.toString());
                                                                                                        obj7.put("toDate", toDate.toString());
                                                                                                        obj7.put("environment", environment.toString());
                                                                                                        obj7.put("transactions", transactionValue + "");
                    //                                            Leasing Dubai=300000001937102;
                                                                // Leasing Sharjah=300000001937026;
                                                                if(buName.equalsIgnoreCase("Leasing Dubai"))//(orgId.toString().equalsIgnoreCase("300000001937102"))
                                                                 {
                                                                jbdd=new Long(dline5);
                                                                obj7.put("ccId", jbdd);
                                                                }else if(buName.equalsIgnoreCase("Leasing Sharjah"))//(orgId.toString().equalsIgnoreCase("300000001937026"))
                                                                {
                                                                jbds=new Long(sline5);
                                                                obj7.put("ccId", jbds);
                                                                }else if(buName.equalsIgnoreCase("Alfa Smart Real Estate"))//(orgId.toString().equalsIgnoreCase("300000014909142"))
                                                                {
                                                                jbdas=new Long(asline5);
                                                                obj7.put("ccId", jbdas);
                                                                }
                    //                                                                                    obj7.put("ccId", revAccountId);
                    //                                                                                    obj7.put("tenantYears","0");
                                                                                                        obj7.put("cancellationNo",CancelNo);
                                                                                        
                                                                                                        JSFUtils.addFacesInformationMessage("Invoice Actual JSON object" +
                                                                                                                                            obj7.toString());
                                                                                                        System.out.println("Invoice Actual JSON object" +
                                                                                                                           obj7.toString());
                                                                                                        OkHttpClient client7 = new OkHttpClient();
                                                                                                        MediaType mediaType7 = MediaType.parse("application/json");
                                                                                                        RequestBody body7 =
                                                                                                            RequestBody.create(mediaType7, obj7.toJSONString());
                                                                                                        Request request7 =
                                                                                                            new Request.Builder().url("http://130.61.18.88/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body7).addHeader("Content-Type",
                                                                                                                                                                                                                                        "application/json").addHeader("Cache-Control",
                                                                                                                                                                                                                                                                      "no-cache").addHeader("Postman-Token",
                                                                                                                                                                                                                                                                                            "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                                                                                                        //test instance
//                                                                                                         Request request7 =
//                                                                                                             new Request.Builder().url("https://almisksoat1-wls-1.miskprops.com:8002/Al-MiskIntegrations/webresources/invoicecreation/v1").post(body7).addHeader("Content-Type",
//                                                                                                                                                                                                                                         "application/json").addHeader("Cache-Control",
//                                                                                                                                                                                                                                                                       "no-cache").addHeader("Postman-Token",
//                                                                                                                                                                                                                                                                                             "493ffe37-eaac-45fc-9962-8c6883aff73e").build();
                                                                                        
                                                                                                        Response response7 = client7.newCall(request7).execute();
                                                                                        
                                                                                                        JSFUtils.addFacesInformationMessage("Invoice response Payload" +
                                                                                                                                            response7);
                                                                                                        InputStream isr7 = response6.body().byteStream();
                                                                                                        BufferedReader reader7 =
                                                                                                            new BufferedReader(new InputStreamReader(isr7));
                                                                                                        StringBuilder out7 = new StringBuilder();
                                                                                                        String resultsXml7;
                                                                                        
                                                                                                        while ((resultsXml7 = reader7.readLine()) != null) {
                                                                                                            out6.append(resultsXml7);
                                                                                                        }
                                                                                        
                                                                                                        JSFUtils.addFacesInformationMessage("Invoice Response in json" +
                                                                                                                                            out7.toString());
                                                                                                        String responseOut7 = out7.toString();
                                                                                                        if (responseOut7 != null) {
                                                                                                            //                        responseOut7.contains("{\"result\":\"Success\"}");
                                                                                                            //                                    leaseVO.getCurrentRow().setAttribute("IntegrationResponse", responseOut6);
                                                                                                            cancelheaderrow.setAttribute("Attribute9", "Success");
                                                                                                            ADFUtils.findOperation("Commit").execute();
                                                                                        
                                                                                                        }
                                                                                                        System.out.println("Invoice Response in json" +
                                                                                                                           out7.toString());
                                                                                                        transactionValue++;
                                                                                                     }      
//
                } 
                else{   //close if
                JSFUtils.addFacesErrorMessage("AR Line is Empty");
                    }// end of calling rest service
                    JSFUtils.addFacesErrorMessage("AR Line is Empty");
                }
        }

    }
    public Map<String, Object> getArSetupDetails(String p_orgdId,
                                                 String p_chargeType) {
        Map<String, Object> arSetupMap = null;

        arSetupMap = new HashMap<String, Object>();
        ViewObject arSetupVO =
            ADFUtils.findIterator("getARSetupDetails_ROVO1Iterator").getViewObject();
        //        ViewCriteriaManager vcm = arSetupVO.getViewCriteriaManager();
        //        ViewCriteria vc = vcm.getViewCriteria("findByChargeTypeAndOrg");
        //        VariableValueManager vvm = vc.ensureVariableManager();
        //        vvm.setVariableValue("p_Org", p_orgdId);
        //        vvm.setVariableValue("p_ChargeType", p_chargeType);
        //        arSetupVO.applyViewCriteria(vc);
        arSetupVO.setNamedWhereClauseParam("p_Org", p_orgdId);
        arSetupVO.setNamedWhereClauseParam("p_ChargeType", p_chargeType);
        System.err.println("Org ID " + p_orgdId + "Charge ID " + p_chargeType);
        arSetupVO.executeQuery();
        if (arSetupVO.first() != null) {
            arSetupMap.put("customerTrxTypeName",
                           arSetupVO.first().getAttribute("TxnType"));
            arSetupMap.put("batchSourceName",
                           arSetupVO.first().getAttribute("TxnSource"));
            arSetupMap.put("codeCombinationId",
                           arSetupVO.first().getAttribute("RevAccountId"));
            arSetupMap.put("accountingRuleName",
                           arSetupVO.first().getAttribute("AccountingRuleName"));
            arSetupMap.put("invoicingRuleName",
                           arSetupVO.first().getAttribute("InvoicingRule"));
            arSetupMap.put("ledgerName",
                           arSetupVO.first().getAttribute("LedgerName"));
            arSetupMap.put("environment",
                           arSetupVO.first().getAttribute("Environment"));
            arSetupMap.put("accountClass",
                           arSetupVO.first().getAttribute("AccountClass"));
            arSetupMap.put("revAccountId",
                           arSetupVO.first().getAttribute("RevAccountId"));
        } else {
            JSFUtils.addFacesErrorMessage("Please define the AR Setup details");

        }
        return arSetupMap;
    }
    public Object getCodeCombination(String pBusinessUnitId,
                                         String pChargeType, String pUnitId) {
            Object returnResult = null;
            try {
               
                BindingContainer bindings =
                    BindingContext.getCurrent().getCurrentBindingsEntry();
                OperationBinding operation =
                    bindings.getOperationBinding("getCodeSegmentCombination");
                System.err.println("pBusinessUnitId" + pBusinessUnitId);
                System.err.println("pChargeType" + pChargeType);
                System.err.println("pUnitId" + pUnitId);
                
                JSFUtils.setExpressionValue("#{pageFlowScope.pChargeType}",
                                            pChargeType);
                JSFUtils.setExpressionValue("#{pageFlowScope.pBusinessUnitId}",
                                            pBusinessUnitId);
                JSFUtils.setExpressionValue("#{pageFlowScope.pUnitId}", pUnitId);

                //            Object unitId = pUnitId;
                //            Map map = new HashMap();
                //            map.put("pBusinessUnitId", bid.toString());
                //            map.put("pChargeType", chargeType.toString());
                //            map.put("pUnitId", unitId.toString());
                //            operation.getParamsMap().putAll(map);
//                returnResult = operation.execute();

                            operation.getParamsMap().put("pBusinessUnitId",pBusinessUnitId);
                            operation.getParamsMap().put("pChargeType",pChargeType);
                            operation.getParamsMap().put("pUnitId",pUnitId);
                returnResult = operation.execute();
            } catch (Exception e) {
                System.err.println("e" + e.toString());
                JSFUtils.addFacesInformationMessage("Error in getCCMethod" + e);
            }
            return returnResult;
        }
    public Object getCurrentDateForPayload() {
        Calendar cal = Calendar.getInstance();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Object sysDate = sdf.format(cal.getTime());
        return sysDate;
    }
    public Object getTaxCodeFromLookup(Object p_TaxVal) {
        Object taxCode = null;
        try {
            ViewObject taxCodeVO =
                ADFUtils.findIterator("getTaxCodeROVO1Iterator").getViewObject();
            taxCodeVO.setNamedWhereClauseParam("p_TaxVal", p_TaxVal);
            taxCodeVO.executeQuery();
            if (taxCodeVO.first() != null) {
                taxCode =
                        taxCodeVO.first().getAttribute("LookupValueNameDisp") ==
                        null ? "ZR 0%" :
                        taxCodeVO.first().getAttribute("LookupValueNameDisp").toString();
            }
        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error in TaxCode" + e);
        }
        return taxCode;
    }
    public synchronized String invokeReport(String glDate) throws IOException,
                                                                  ParserConfigurationException,
                                                                  SAXException,
                                                                  Exception {

        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder1 = new OkHttpClient.Builder();
        builder1.connectTimeout(30, TimeUnit.SECONDS);
        builder1.readTimeout(30, TimeUnit.SECONDS);
        builder1.writeTimeout(30, TimeUnit.SECONDS);
        client = builder1.build();
        MediaType mediaType = MediaType.parse("text/xml");
        String xmlInput = getPayload(glDate);
        RequestBody body = RequestBody.create(mediaType, xmlInput);
        //                System.out.println("Request Payload ----> " + xmlInput);
        JSFUtils.addFacesInformationMessage("==Request to Report==" +
                                            xmlInput);
        String error = null;
        String cutOffDate = null;
        Request request =
            new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com/xmlpserver/services/PublicReportService").post(body).addHeader("content-type","text/xml").addHeader("SOAPACTION", "").build();
        try {

            Response response = client.newCall(request).execute();
            InputStream isr = response.body().byteStream();
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }

            int responseCode = response.code();
            if (responseCode > 200) {
                String fault = null;

                if (out.toString().contains(";TEXT&gt;")) {
                    fault = getFaultString(out.toString());
                } else {
                    DocumentBuilder builder =
                        DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    InputSource src = new InputSource();
                    src.setCharacterStream(new StringReader(out.toString()));
                    Document doc = builder.parse(src);
                    //                    System.err.println("Error Response----> " +
                    //                                       out.toString());
                    fault =
                            doc.getElementsByTagName("faultstring").item(0).getTextContent();
                }
                JSFUtils.addFacesInformationMessage("==Error Reponse form Report==" +
                                                    fault);
                return fault;

            } else {

                String reportResponse = getResponseAsString(out.toString());
                //                System.out.println("Report Reponse : " + reportResponse);
                //                DocumentBuilder db;
                //                db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                //                InputSource is = new InputSource();
                //                is.setCharacterStream(new StringReader(reportResponse));
                //                Document doc = db.parse(is);
                //                NodeList nodes = doc.getElementsByTagName("G_1");
                //                Node n = nodes.item(0);
                //                Element e = (Element)n;
                //                cutOffDate = e.getAttribute("CUTOFF_DATE");


                JSFUtils.addFacesInformationMessage("==Response Bytes to String==" +
                                                    reportResponse);

                DocumentBuilder builder =
                    DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource src = new InputSource();
                src.setCharacterStream(new StringReader(reportResponse));
                Document doc = builder.parse(src);
                cutOffDate =
                        doc.getElementsByTagName("CUTOFF_DATE").item(0).getTextContent();

                JSFUtils.addFacesInformationMessage("==GL DATE FORM REPORT RES==" +
                                                    cutOffDate);
            }
            reader.close();
        } catch (Exception e) {
            error = e.toString();
            e.printStackTrace();
        }
        return cutOffDate;
    }
    public synchronized static String getResponseAsString(String resp) throws ParserConfigurationException,
                                                                              SAXException,
                                                                              IOException {
        String response = resp;
        DocumentBuilder builder =
            DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(response));
        Document doc = builder.parse(src);
        response =
                doc.getElementsByTagName("reportBytes").item(0).getTextContent();


        /*******DECODE BYTES TO STRING************/
        byte[] val = DatatypeConverter.parseBase64Binary(response);
        response = new String(val);
        return response;
    }


    public synchronized static String getFaultString(String xml) {

        String faultString = "";
        int firstFault = xml.indexOf(";TEXT&gt;");
        int firstFault_last = xml.indexOf("&lt;/TEXT&");
        faultString = xml.substring(firstFault + 9, firstFault_last);
        //        System.err.println("FAULT STRING : " + faultString);
        return faultString;
    }

    public String getPayload(String glDate) {

        String payload =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pub=\"http://xmlns.oracle.com/oxp/service/PublicReportService\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <pub:runReport>\n" +
            "         <pub:reportRequest>\n" +
            "            <pub:parameterNameValues>\n" +
            "               <pub:item>\n" +
            "                  <pub:name>p_date</pub:name>\n" +
            "                  <pub:values>\n" +
            "                     <pub:item>" + glDate + "</pub:item>\n" +
            "                  </pub:values>\n" +
            "               </pub:item>\n" +
            "            </pub:parameterNameValues>\n" +
            "            <pub:reportAbsolutePath>/Custom/Property Lease/Reports/GL Period.xdo</pub:reportAbsolutePath>\n" +
            "         </pub:reportRequest>\n" +
            "         <pub:userID>erp_user</pub:userID>\n" +
            "         <pub:password>welcome@4i</pub:password>\n" +
            "      </pub:runReport>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";

        return payload;
    }
   
    public String dateplusone(String sdate)
    {
        Date date = new Date();
        String strDate="";
               try {
        //string to date
                   date =
                           new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
                   System.err.println("--DDD--"+date);
     //increment date
                   Calendar cal = Calendar.getInstance();
                   cal.setTime(date);
                   cal.add(Calendar.DATE, 1);
                   cal.getTime();
                   
        //date to date with format      
                   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
                    strDate = formatter.format(cal.getTime());  
                    System.out.println("Date Format with yyyy-MM-dd : "+strDate);  

                   
   
                   
               } catch (ParseException e) {
                   e.printStackTrace();
               }
        return strDate;
    }

    ViewObject cancelvo=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
    public void onClickGenerateResponse(ActionEvent actionEvent) {
     
        Row cancelheaderrow=cancelvo.getCurrentRow();
          String CancelNo=cancelheaderrow.getAttribute("CancelNumber").toString();
          invokeARInvoiceBIWS(CancelNo);
    }
    public void invokeARInvoiceBIWS(String p_cancel_charge_num) {
            try {
                String Payload =
                    "<soapenv:Envelope xmlns:pub=\"http://xmlns.oracle.com/oxp/service/PublicReportService\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "       <pub:runReport>\n" +
                    "        <pub:reportRequest>\n" +
                    "           <pub:attributeCalendar/>\n" +
                    "           <pub:attributeFormat>xml</pub:attributeFormat>\n" +
                    "           <pub:attributeLocale>en-US</pub:attributeLocale>\n" +
                    "           <pub:attributeTemplate>Simple</pub:attributeTemplate>\n" +
                    "           <pub:attributeTimezone/>\n" +
                    "           <pub:attributeUILocale/>\n" +
                    "           <pub:byPassCache>true</pub:byPassCache>\n" +
                    "           <pub:dynamicDataSource/>\n" +
                    "           <pub:flattenXML>true</pub:flattenXML>\n" +
                    "           <pub:parameterNameValues>\n" +
                    "              <pub:item>\n" +
                    "                 <pub:name>p_cancelno</pub:name>\n" +
                    "                 <pub:values>\n" +
                    "                    <pub:item>" + p_cancel_charge_num +
                    "</pub:item>\n" +
                    "                 </pub:values>\n" +
                    "              </pub:item>\n" +
                    "           </pub:parameterNameValues>\n" +
                    "           <pub:reportAbsolutePath>Custom/Property Lease/Reports/Receivable Trx Number Cancellation.xdo</pub:reportAbsolutePath>\n" +
                    "           <pub:reportData/>\n" +
                    "           <pub:reportOutputPath/>\n" +
                    "           <pub:reportRawData/>\n" +
                    "           <pub:sizeOfDataChunkDownload>-1</pub:sizeOfDataChunkDownload>\n" +
                    "        </pub:reportRequest>\n" +
                    "        <pub:userID>ERP_user</pub:userID>\n" +
                    "        <pub:password>welcome@4i</pub:password>\n" +
                    "     </pub:runReport>\n" +
                    "  </soapenv:Body>\n" +
                    "</soapenv:Envelope>\n";


                Payload = Payload.replaceAll("&", "&");
                System.err.println("Bi Payload--" + Payload);
//                JSFUtils.addFacesInformationMessage("" + Payload);
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("text/xml");
                RequestBody body = RequestBody.create(mediaType, Payload);
                Request request =
                    new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com/xmlpserver/services/PublicReportService?wsdl").post(body).addHeader("SOAPAction",
                                                                                                                                                            "").build();
                //            Request request =
                //                new Request.Builder().url("https://egzy.fa.em2.oraclecloud.com/xmlpserver/services/PublicReportService?wsdl").post(body).addHeader("SOAPAction",
                //                                                                                                                                                   "").build();
                String strResp = null;
                Response response = client.newCall(request).execute();
                InputStream isr = response.body().byteStream();
                BufferedReader reader =
                    new BufferedReader(new InputStreamReader(isr));
                StringBuilder out = new StringBuilder();
                String resultsXml;
                while ((resultsXml = reader.readLine()) != null) {
                    out.append(resultsXml);
                }

                //            System.err.println("Response String--" + out);
                int responseCode = response.code();
                //            System.err.println("RESPONSE CODE--" + responseCode);
                getARInvoiceBIWSRespValue(responseCode, out.toString());


            } catch (Exception e) {
                JSFUtils.addFacesInformationMessage("ERROR IN CATCH BLOCK--" + e);
            }

        }
    public String getARInvoiceBIWSRespValue(int respCode, String out) {
           String resp = "";
           //        JSFUtils.addFacesInformationMessage("Output Stream--" + out);
           try {
               DocumentBuilder builder =
                   DocumentBuilderFactory.newInstance().newDocumentBuilder();
               InputSource src = new InputSource();
               src.setCharacterStream(new StringReader(out));
               Document doc = builder.parse(src);
               if (respCode > 200) {
                   resp =
    doc.getElementsByTagName("faultstring").item(0).getTextContent();
                   System.err.println("ERROR--" +
                                      doc.getElementsByTagName("faultstring").item(0).getTextContent());
                   JSFUtils.addFacesInformationMessage("ERROR--" +
                                                       doc.getElementsByTagName("faultstring").item(0).getTextContent().toString());
                   src = new InputSource();
                   src.setCharacterStream(new StringReader("<faultstring>" +
                                                           resp +
                                                           "</faultstring>"));
                   doc = builder.parse(src);
                   resp =
    doc.getElementsByTagName("TEXT").item(0).getTextContent();
               } else {
                   resp =
    doc.getElementsByTagName("reportBytes").item(0).getTextContent();
                   System.err.println("Wlcome--" +
                                      doc.getElementsByTagName("reportBytes").item(0).getTextContent());
                   byte b[] =
                       Base64.decode(doc.getElementsByTagName("reportBytes").item(0).getTextContent());
                   String tempPass = new String(b);
                   System.err.println("HELLO" + tempPass);
                   DocumentBuilder builder1 =
                       DocumentBuilderFactory.newInstance().newDocumentBuilder();
                   InputSource src1 = new InputSource();
                   src1.setCharacterStream(new StringReader(tempPass));
                   Document reportOutput = builder1.parse(src1);

                   if (
                       notNull(reportOutput.getElementsByTagName("TRX_NUMBER").item(0)) &&
                       notNull(reportOutput.getElementsByTagName("CUSTOMER_TRX_ID").item(0))) {
                       String customer_txt_id=reportOutput.getElementsByTagName("CUSTOMER_TRX_ID").item(0).getTextContent().toString();
                       String transactionNo=reportOutput.getElementsByTagName("TRX_NUMBER").item(0).getTextContent().toString();
//                       JSFUtils.addFacesInformationMessage(customer_txt_id);
                       Row r=cancelvo.getCurrentRow();
                       r.setAttribute("Attribute1",customer_txt_id);
                       r.setAttribute("Attribute2",transactionNo);
                       ADFUtils.findOperation("Commit");
                       
                           //                       Attribute1
//                                           System.err.println("P_LEASE_NUMBER " +
//                                                              reportOutput.getElementsByTagName("P_LEASE_NUMBER ").item(0).getTextContent());
//                                           System.err.println("CUSTOMER_TRX_ID" +
//                                                              reportOutput.getElementsByTagName("CUSTOMER_TRX_ID").item(0).getTextContent());
//                                           System.err.println("TRX_NUMBER" +
//                                                              reportOutput.getElementsByTagName("TRX_NUMBER").item(0).getTextContent());
                   }

               }
           } catch (Exception e) {
               e.printStackTrace();
           }
           return resp;
       }
    public boolean notNull(Object ob) {
        if (ob != null && !"".equals(ob)) {
            return true;
        } else {
            return false;
        }
    }

    public void setApprRejPopup(RichPopup apprRejPopup) {
        this.apprRejPopup = apprRejPopup;
    }

    public RichPopup getApprRejPopup() {
        return apprRejPopup;
    }

    public void setReason(RichInputText reason) {
        this.reason = reason;
    }

    public RichInputText getReason() {
        return reason;
    }

    public void apprRejPopUpCall(ActionEvent actionEvent) {
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getApprRejPopup().show(popup34);

    }

    public void onClickPopUpSave(ActionEvent actionEvent) {
        Object val = ADFContext.getCurrent().getPageFlowScope().get("Action") == null ?
                    "" :
                    ADFContext.getCurrent().getPageFlowScope().get("Action").toString();
                if (val.equals("Approval")) {
                    onClickApprove(actionEvent);
                }
                if (val.equals("Rejection")) {
                    onClickReject(actionEvent);
                }
    }
    
    public void onClickApprove(ActionEvent actionEvent) {
           String result = "Y";
           if (result == "Y") {
               Map<String, BigDecimal> ResultVal =
                   new HashMap<String, BigDecimal>();
               ViewObject vo =
                   ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
               Row row = vo.getCurrentRow();
               String sts = row.getAttribute("Status")==null ? "" : row.getAttribute("Status").toString();
               String Reason = 
                   this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();
               //
               System.out.println("func id :: " + row.getAttribute("FuncId"));
               System.out.println("OcHdrId id :: " + row.getAttribute("CancelId"));
               System.out.println("UserGrpId id :: " + row.getAttribute("UserGrpId"));
               System.out.println("FlowLevel id :: " + row.getAttribute("FlowLevel"));
               System.out.println("FlowWith id :: " + row.getAttribute("FlowWith"));
               //
               try {
                   ResultVal =
                           xxfnd.invokeResponsePkgs("xxfnd_util_pkg.update_response",
                                                    row.getAttribute("FuncId"),
                                                    row.getAttribute("CancelId"),
                                                    row.getAttribute("UserGrpId"),
                                                    row.getAttribute("FlowLevel"),
                                                    row.getAttribute("FlowWith"),
                                                    Reason, "A", 0,
                                                    "XXPM_CANCELLATION", "STATUS",
                                                    "CANCEL_ID");

                  
               } catch (SQLException e) {
                   System.err.println("ERROR" + e);
               }
               //ResultVal
               System.err.println("ERROR" + ResultVal);


               for (Map.Entry m : ResultVal.entrySet()) {
                   System.out.println("KEY" + m.getKey() + "VALUE " +
                                      m.getValue());

                   if (m.getKey().equals("Success")) {

                       String ress =
                           m.getValue() == null ? "null" : m.getValue().toString();
                       if (ress.equals("null")) {
//                           ------mail notification-------
                                                                 
                                       String canceldate = null;
                                       String EmailId = null;
                                       
                                       ViewObject cvo = ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
                                       ViewObject bddvo =ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
                                      
                                       Row bdrow = bddvo.getCurrentRow();
                                       Row r = cvo.getCurrentRow();
                                       EmailId = r.getAttribute("Description") == null ? "0" : r.getAttribute("Description").toString();
                                       System.err.println("EmailID" + r.getAttribute("Description"));
                                       System.err.println("CancelDate" + r.getAttribute("CancelDate"));
                                       System.err.println("UnitId" + bdrow.getAttribute("UnitId"));
                                      
                                       canceldate = r.getAttribute("CancelDate").toString();
                                                       
                                       ViewObject mastervo=ADFUtils.findIterator("masterdetail_ROVO1Iterator").getViewObject();
                                       mastervo.setNamedWhereClauseParam("bv_unitid",bdrow.getAttribute("UnitId"));
                                       mastervo.executeQuery();
                                       System.err.println("rowcount"+mastervo.getEstimatedRowCount());
                                       RowSetIterator masteritr=mastervo.createRowSetIterator(null);
                                       String UnitName=null,BuildName=null,PropertyName=null;
                                       String customer=null;
                                       String cnNo=null;
                                       String PorF_proReport =null;
                                       String F_finalReport ="";
                                       String proOrFinalStatus =r.getAttribute("ProposeFinalStatus")==null ? "" : r.getAttribute("ProposeFinalStatus").toString();
                                       customer=r.getAttribute("CustomerName")==null ? "" : r.getAttribute("CustomerName").toString();
                                       cnNo=r.getAttribute("CancelNumber")==null ? "" : r.getAttribute("CancelNumber").toString();
                                       if(proOrFinalStatus.equalsIgnoreCase("Proposed")){
                                           //PROD
                                           PorF_proReport="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/Cancellation/proposedAndFinal/"+cnNo;
                                           //TEST
//                                           PorF_proReport="https://almlbprd.miskprops.com/Al-MuskRtfServicesDemo1/webresources/rest/Cancellation/proposedAndFinal/"+cnNo;
                                       }
                                       if(proOrFinalStatus.equalsIgnoreCase("Final")){
                                           //PROD
                                           PorF_proReport="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/Cancellation/proposedAndFinal_H/"+cnNo;
                                           F_finalReport="https://almlbprd.miskprops.com/Al-MuskRtfServices/webresources/rest/Cancellation/proposedAndFinal/"+cnNo;
                                           //TEST
//                                           PorF_proReport="https://almlbprd.miskprops.com/Al-MuskRtfServicesDemo1/webresources/rest/Cancellation/proposedAndFinal_H/"+cnNo;
//                                           F_finalReport="https://almlbprd.miskprops.com/Al-MuskRtfServicesDemo1/webresources/rest/Cancellation/proposedAndFinal/"+cnNo;                                           
                                       }
                                       while(masteritr.hasNext())
                                       {
                                           Row mrow=masteritr.next();
                                           UnitName=mrow.getAttribute("UnitName")==null?"empty":mrow.getAttribute("UnitName").toString();
                                           BuildName=mrow.getAttribute("BuildName")==null?"empty":mrow.getAttribute("BuildName").toString();
                                           PropertyName=mrow.getAttribute("PropertyName")==null?"empty":mrow.getAttribute("PropertyName").toString();
                                          }
                                       masteritr.closeRowSetIterator();
                                       
                                       System.err.println("UnitName"+UnitName); 
                                       System.err.println("BuildName"+BuildName);
                                       System.err.println("PropertyName"+PropertyName);
                           //            r.setAttribute("Status", "APR");
                                       //                                                    ----mail notification----
                                       ArrayList<String> ar = new ArrayList<String>();
                                      // ar.add("balaji.swamynathan@4iapps.com");
                                       ar.add(EmailId);
                                       String htmlBody =MailTemplates.submit(canceldate,UnitName,BuildName,PropertyName,customer,cnNo,proOrFinalStatus,PorF_proReport,F_finalReport);
                                       String subject = "Cancellation/Termination Notification";
                                       MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress ,ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
                                       JSFUtils.addFacesInformationMessage("Mail has been sent successfully");
                                       //                                                  
                                                             
                    //for updating cancel status and cancel tag
//                    if(sts.equalsIgnoreCase("APR")){       //here sts is PEN on Approve
                        doUpdateCancelStsAndCancelTag();  
//                    }
                           //                      ------mail notification----------
                            
                       
                       }
                       //04-June  for change of status of Milestone and Receipt
                        String status = row.getAttribute("Status").toString();
                        if (status.equalsIgnoreCase("APR")) {
//                           onChangeStatus();
//                           onSaveSetOcId();
                        setUnitStatus();
                        }
                       
                       ADFUtils.findOperation("Commit").execute();
                       JSFUtils.addFacesInformationMessage("Approved....");
                   } else {
                       JSFUtils.addFacesErrorMessage("Error in Approve process!");
                   }
               }
           }
       }
    //change unit status to available on approved
    public void setUnitStatus() {
        ViewObject BookingDtlVO1 =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        ViewObject PropertyUnits_VO1 =
            ADFUtils.findIterator("PropertyUnits_VO1Iterator").getViewObject();
        RowSetIterator quoteMileRS = BookingDtlVO1.createRowSetIterator(null);
        while (quoteMileRS.hasNext()) {
            Row r1 = quoteMileRS.next();
            ViewCriteria vc = PropertyUnits_VO1.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("UnitId", r1.getAttribute("UnitId"));
            vc.addRow(vcRow);
            PropertyUnits_VO1.applyViewCriteria(vc);
            PropertyUnits_VO1.executeQuery();
            Row re = PropertyUnits_VO1.first();
            re.setAttribute("Status", "AVAL");
        }
        PropertyUnits_VO1.executeQuery();
        ADFUtils.findOperation("Commit").execute();

    }
    
    public void doUpdateCancelStsAndCancelTag(){

        ViewObject canVO=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row row = canVO.getCurrentRow();
        String cnId=row.getAttribute("CancelId")==null?"":row.getAttribute("CancelId").toString();
        OperationBinding op=ADFUtils.findOperation("updateCancelledTagOnApproved");
                  op.getParamsMap().put("cnId",cnId);
                  String flag=op.execute().toString();
                  JSFUtils.addFacesInformationMessage(flag);
    }
    
    public void onClickReject(ActionEvent actionEvent) {
           String ResultVal = null;
           ViewObject vo =
               ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
           Row row = vo.getCurrentRow();
           String Reason =
               this.reason.getValue() == null ? "Rejected" : this.reason.getValue().toString();


           try {
               ResultVal =
                       xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
                                               row.getAttribute("FuncId"),
                                               row.getAttribute("CancelId"),
                                               row.getAttribute("UserGrpId"),
                                               row.getAttribute("FlowLevel"),
                                               row.getAttribute("FlowWith"),
                                               Reason, "R", 0, "XXPM_CANCELLATION",
                                               "STATUS", "CANCEL_ID");


           } catch (SQLException e) {
               System.out.println(e);
           }
           if (ResultVal.equalsIgnoreCase("Success")) {
//               onChangeStatusForRej();
               ADFUtils.findOperation("Commit").execute();
               JSFUtils.addFacesInformationMessage("Rejected....");

           } else {
               JSFUtils.addFacesErrorMessage("Error in Reject process!");
           }

       }
    public boolean getApprovalUser() {
           ViewObject OfferHrdVO =
               ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
           boolean flag = false;
           String flowWith =
               OfferHrdVO.getCurrentRow().getAttribute("FlowWith") == null ?
               null :
               OfferHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
           String LoginUserId =
               ADFContext.getCurrent().getSessionScope().get("userId") == null ?
               null :
               ADFContext.getCurrent().getSessionScope().get("userId").toString();
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

    public void doCreateOCdetail(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject vo=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        ViewObject bookingMsVo = 
            ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
        Row r=vo.getCurrentRow();
        ADFUtils.findOperation("CreateInsert").execute();
        bookingMsVo.getCurrentRow().setAttribute("BookingHdrId", r.getAttribute("BookingId"));
        bookingMsVo.getCurrentRow().setAttribute("SourceFuncId", r.getAttribute("FuncId"));
        bookingMsVo.getCurrentRow().setAttribute("SourceFuncRefId", r.getAttribute("CancelId"));
        bookingMsVo.getCurrentRow().setAttribute("CancelId", r.getAttribute("CancelId"));
        bookingMsVo.getCurrentRow().setAttribute("OrgId", r.getAttribute("OrgId"));
    }

    public void onClickCheckClearAount(ValueChangeEvent valueChangeEvent) {
        //setting due value
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                            Double gettingNetDue=getnetdue();
                            BigDecimal convertingFinalAmount = new BigDecimal(gettingNetDue);
                            ViewObject voc=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
                                        Row rows=voc.getCurrentRow();
                            
                            rows.setAttribute("Netdue",convertingFinalAmount);
                            
                            AdfFacesContext.getCurrentInstance().addPartialTarget(this.netDueAttribute);
                            //
    }
    public double getTotalAmount()
        {
           
            ViewObject vo=ADFUtils.findIterator("CancelDueAmountDtl_VO1Iterator").getViewObject();
            RowSetIterator itr=vo.createRowSet(null);
            Double netdue=0.0;String stotal="";Double originalamt=0.0;String cancelcharge=null;
          
            while(itr.hasNext())
            {
                Row r=itr.next();
                cancelcharge=r.getAttribute("CancelationCharges")==null?"0.0":r.getAttribute("CancelationCharges").toString();
                                if(cancelcharge.equalsIgnoreCase("OD"))
                                {
                                    originalamt=Double.parseDouble(r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString());
                                }
                                else
                                {
                                    stotal=r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString();
                                    netdue=netdue+Double.parseDouble(stotal);
                                }
            }
            itr.closeRowSetIterator();        
            vo.reset();           
          
               
            return netdue-originalamt;
        }
    
    
    
    public double getTotalAmountP()
        {
           
            ViewObject vo=ADFUtils.findIterator("CancellationDetailProposed_ROVO1Iterator").getViewObject();
            RowSetIterator itr=vo.createRowSet(null);
            Double netdue=0.0;String stotal="";Double originalamt=0.0;String cancelcharge=null;
          
            while(itr.hasNext())
            {
                Row r=itr.next();
                cancelcharge=r.getAttribute("CancelationCharges")==null?"0.0":r.getAttribute("CancelationCharges").toString();
                                if(cancelcharge.equalsIgnoreCase("OD"))
                                {
                                    originalamt=Double.parseDouble(r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString());
                                }
                                else
                                {
                                    stotal=r.getAttribute("TotalAmount")==null?"0.0":r.getAttribute("TotalAmount").toString();
                                    netdue=netdue+Double.parseDouble(stotal);
                                }
            }
            itr.closeRowSetIterator();        
            vo.reset();           
          
               
            return netdue-originalamt;
        }



    public String onClickFinal(ActionEvent actionEvent) {
        ViewObject voc=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row rows=voc.getCurrentRow();
        //comit for tax code and total tax amt 07-June-2020
//        ADFUtils.findOperation("Commit").execute();
        ViewObject cnDueAmtDtlVo=ADFUtils.findIterator("CancelDueAmountDtl_VO1Iterator").getViewObject();
        RowSetIterator itr=cnDueAmtDtlVo.createRowSetIterator(null);
        String taxFlag ="Y";
        while(itr.hasNext())
        {
            Row r=itr.next();
            if (r.getAttribute("TaxCode") == null) {
                taxFlag = "N";
                break;
            }
        }
        itr.closeRowSetIterator();
        if (taxFlag.equalsIgnoreCase("Y")){
        onClickSave(actionEvent);
        //
        String cancelidS=rows.getAttribute("CancelId")==null?"0":rows.getAttribute("CancelId").toString();
        Long cancelidL=new Long(cancelidS);
        System.err.println("Cancelid->"+cancelidL);
       // package calling//
        OperationBinding ob=ADFUtils.findOperation("cancellation_proposal");
        ob.getParamsMap().put("P_cancellationId",cancelidL);
        ob.execute();
       // package end//
        rows.setAttribute("ProposeFinalStatus","Final");
        rows.setAttribute("Status","DRA");
        rows.setAttribute("UserGrpId",null);
        rows.setAttribute("FlowStatus",null);
        rows.setAttribute("FlowLevel",null);
        rows.setAttribute("FlowWith",null);
        
        ADFUtils.findOperation("Commit").execute();
//        AdfFacesContext.getCurrentInstance().addPartialTarget(this.netDueAttribute);
        }else{
            JSFUtils.addFacesErrorMessage("Please select add tax code in due table !!!");
            return "";
        }
        return "cancel";
    }
    
    public boolean getfinalstatus()
    {
        boolean flag=true;
        ViewObject voc=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row rows=voc.getCurrentRow();
        Object status=rows.getAttribute("Status")==null?"":rows.getAttribute("Status");
        Object ProposeFinalStatus=rows.getAttribute("ProposeFinalStatus")==null?"":rows.getAttribute("ProposeFinalStatus");
        if(ProposeFinalStatus.equals("Proposed") && status.equals("APR"))
        {
            flag=false;
        }else if(ProposeFinalStatus.equals("Final"))
        {
            flag=true;
        }
        return flag;
    }
    //for getting max date for termination date wrt termination date
    public Date getMaxDate() {
        Date date = new Date();
               ViewObject cnVo =
                   ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
               Row cnRow = cnVo.getCurrentRow();
               String cnDate = cnRow.getAttribute("NocDateActual") == null ? "" : cnRow.getAttribute("NocDateActual").toString();
                System.out.println("Date before Addition: "+cnDate);
                if(!cnDate.equalsIgnoreCase("")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                try{
                   c.setTime(sdf.parse(cnDate));
                
                //Incrementing the date by 1 day
                c.add(Calendar.DAY_OF_MONTH, 1);  
                String newDate = sdf.format(c.getTime());  
                System.out.println("Date Incremented by One: "+newDate);
                
                date = sdf.parse(newDate);
                  }catch(ParseException e){
                   e.printStackTrace();
                  }
                return date;
                }else{
                return null;
                }
    }

    public void setFinalPopUp(RichPopup finalPopUp) {
        this.finalPopUp = finalPopUp;
    }

    public RichPopup getFinalPopUp() {
        return finalPopUp;
    }

    public void onClickFinalForPopUp(ActionEvent actionEvent) {
        // Add event code here...
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
                this.getFinalPopUp().show(popup34);
    }

    public String doActionOnClickProceed() {
        // Add event code here...
        ViewObject cnDueAmtDtlVo=ADFUtils.findIterator("CancelDueAmountDtl_VO1Iterator").getViewObject();
        RowSetIterator itr=cnDueAmtDtlVo.createRowSetIterator(null);
//        String taxFlag ="Y";
        while(itr.hasNext())
        {
            Row r=itr.next();
            if (r.getAttribute("TaxCode") == null) {
//                taxFlag = "N";
                return "";
            }
        }
        itr.closeRowSetIterator();
        return "cancel";
    }

    public void doChangeStatusToDraft(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject vo=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row row=vo.getCurrentRow();

        ViewObject leaseVo =
            ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();
        ViewCriteria ovc = leaseVo.createViewCriteria();
        ViewCriteriaRow ovcRow = ovc.createViewCriteriaRow();
        ovcRow.setAttribute("LeaseAgreementId",row.getAttribute("LeaseAgreementId"));
        ovc.addRow(ovcRow);
        leaseVo.applyViewCriteria(ovc);
        leaseVo.executeQuery();
        if (leaseVo.getEstimatedRowCount() != 1) {
        } else {
        String laStatus = leaseVo.first().getAttribute("Status")==null ? "" : leaseVo.first().getAttribute("Status").toString();
       System.out.println("laStatus :"+laStatus);
        if (laStatus.equalsIgnoreCase("CANC")){
        leaseVo.first().setAttribute("Status", "APR");
          }
        }
        String LoginUserId =
            ADFContext.getCurrent().getSessionScope().get("userId") == null ?
            null :
            ADFContext.getCurrent().getSessionScope().get("userId").toString();
        row.setAttribute("Status", "DRA");
        row.setAttribute("Attribute7", LoginUserId);
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Changes done Successfully");
    }

    public void doHandleIntgr(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject cnVo = ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        String resp = cnVo.getCurrentRow().getAttribute("Attribute9")==null ? "" : cnVo.getCurrentRow().getAttribute("Attribute9").toString();
        System.out.println("Response :"+resp);
        if(!resp.equalsIgnoreCase("")){
        cnVo.getCurrentRow().setAttribute("Attribute9", null);
        ADFUtils.findOperation("Commit").execute();
      }
    }

    public void doCancelStatus(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject vo=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row r=vo.getCurrentRow();
        System.out.println("Booking Id ::"+r.getAttribute("BookingId")==null?"0":r.getAttribute("BookingId"));
        //to handle multiple units
        ViewObject bkdVo=ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        ViewCriteria vc=bkdVo.createViewCriteria();
        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
        vcr.setAttribute("BookingId",r.getAttribute("BookingId")==null?"0":r.getAttribute("BookingId"));
        vc.addRow(vcr);
        bkdVo.applyViewCriteria(vc);
        bkdVo.executeQuery();
        System.out.println("Estmt Rows ::"+bkdVo.getEstimatedRowCount());
        BigDecimal bRate = new BigDecimal(0);
        BigDecimal bRateTotal = new BigDecimal(0);
        BigDecimal tRate = new BigDecimal(0);
        BigDecimal tRateTotal = new BigDecimal(0);
        
        RowSetIterator bkditr=bkdVo.createRowSetIterator(null);
        while(bkditr.hasNext())
        {
            Row bkdrow=bkditr.next();
            String baseR=bkdrow.getAttribute("BaseRate")==null?"0":bkdrow.getAttribute("BaseRate").toString();
            String totalR=bkdrow.getAttribute("TotalRate")==null?"0":bkdrow.getAttribute("TotalRate").toString();
            String canSts=bkdrow.getAttribute("CancelStatus")==null?"Y":bkdrow.getAttribute("CancelStatus").toString();
            System.out.println("BaseRate :"+baseR+" TotalRate :"+totalR);
            if(canSts.equalsIgnoreCase("Y")){
            bRate=new BigDecimal(baseR);            
            bRateTotal = bRateTotal.add(bRate);
            tRate = new BigDecimal(totalR);
            tRateTotal = tRateTotal.add(tRate);
            }
         }
        bkditr.closeRowSetIterator();
        System.out.println("Total BaseRate :"+bRateTotal+" Total TotalRate :"+tRateTotal);
        r.setAttribute("BaseRate", bRateTotal);
        r.setAttribute("TotalRate", tRateTotal);
        JSFUtils.addFacesInformationMessage("Please reselect the Termination Date for recalculation !!!");
    }

    public void onDirectRejectionClickonDrft(ActionEvent actionEvent) {
        // Add event code here...
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getP20().show(popup34);
    }

    public void setP20(RichPopup p20) {
        this.p20 = p20;
    }

    public RichPopup getP20() {
        return p20;
    }

    public void onclickDirectRejectionDraft(ActionEvent actionEvent) {
        // Add event code here...
        String ResultVal = null;
        ViewObject vo = ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String cnId = row.getAttribute("CancelId") == null ? "" : row.getAttribute("CancelId").toString();
        String funcId = row.getAttribute("FuncId") == null ? "" : row.getAttribute("FuncId").toString();
        String userId = ADFContext.getCurrent().getSessionScope().get("userId") == null ?
                        null :
                        ADFContext.getCurrent().getSessionScope().get("userId").toString();        
        String reasonCN = this.dirctRejctReason.getValue() == null ? "Rejected" : this.dirctRejctReason.getValue().toString();
        OperationBinding op=ADFUtils.findOperation("directRejectionFromDraft");
                  op.getParamsMap().put("cnId",cnId);
                  op.getParamsMap().put("userId",userId);
                  op.getParamsMap().put("funcId",funcId);
                  op.getParamsMap().put("reason",reasonCN);
                  String flag=op.execute().toString();
                  JSFUtils.addFacesInformationMessage(flag);
    }

    public void setDirctRejctReason(RichInputText dirctRejctReason) {
        this.dirctRejctReason = dirctRejctReason;
    }

    public RichInputText getDirctRejctReason() {
        return dirctRejctReason;
    }

    public void onChangePrimaryUnit(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject bkdVo=ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        String pryUnit = valueChangeEvent.getNewValue()==null?"N" : valueChangeEvent.getNewValue().toString();
        System.out.println("pryUnit :"+pryUnit);
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Primary Unit have been modified and saved !!!");
    }
}
