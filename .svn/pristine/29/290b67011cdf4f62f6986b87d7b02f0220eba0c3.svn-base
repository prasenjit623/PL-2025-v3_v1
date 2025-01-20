package view.backing;

import java.io.OutputStream;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import util.ADFUtils;
import util.JSFUtils;

public class SearchBooking {
  private RichPanelGroupLayout pgl1;
  private RichPanelGridLayout pgl2;
  private RichGridRow gr1;
  private RichGridCell gc1;
  private RichGridCell gc2;
  private RichSpacer s1;
  private RichPanelBox pb1;
  private RichOutputLabel ol1;
    private RichPanelGroupLayout pgl3;
  private RichQuery qryId1;
    private RichTable resId1;
    private RichPanelCollection pc2;
  private RichSpacer s2;
  
  ViewObject BookingHdrVo=ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
  ViewObject BookingDtlVo=ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
    ViewObject BookingMsDtlVo=ADFUtils.findIterator("Booking_Milestone_VO1Iterator").getViewObject();
    ViewObject PropertyUnits02=ADFUtils.findIterator("PropertyUnits_VO2Iterator").getViewObject();
    ViewObject OfferHrd_VO1=ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
    //OfferDetail_VO2Iterator
    //BookingCustomer_VO1Iterator
    ViewObject OfferDtl_VO1=ADFUtils.findIterator("OfferDetail_VO2Iterator").getViewObject();
    ViewObject BookingCustomer_VO1=ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
    //OfferMilestoneDetail_VO1Iterator
    ViewObject OfferMilestoneDetail_VO1=ADFUtils.findIterator("OfferMilestoneDetail_VO1Iterator").getViewObject();
    private RichToolbar t1;
    private RichCommandImageLink cil1;
    private RichSpacer s3;
    private RichCommandImageLink cil3;
    private RichCommandImageLink cil2;
    private RichSpacer s4;
    private RichInputDate id1;
    private RichInputDate id2;
    private RichInputText it1;

    public String  ValidateUnitStatus(Object val){
        ViewObject OfferDtlVo =
        PropertyUnits02.getViewObject();
        
            
                   ViewCriteria vc = OfferDtlVo.createViewCriteria();
                   ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        
                   
    vcRow.setAttribute("UnitId", val);
                   vc.addRow(vcRow);
                   
                   OfferDtlVo.applyViewCriteria(vc);
                   OfferDtlVo.executeQuery();
                   Row re=OfferDtlVo.first();
                   String St=re.getAttribute("Status").toString();
        return St;
        
        
    }
    
    public Object validateDate(String Status){
        Object result=null;
        if(Status.equals("AVAL")||Status.equals("A")){
            ViewObject BkHdrVo =
              BookingHdrVo.getViewObject();
            Row re=BkHdrVo.getCurrentRow();
      String DateFr =
        re.getAttribute("BookingDate") == null ? "" : re.getAttribute("BookingDate").toString();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1=new Date();
                    try {
                        date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
                    } catch (ParseException e) {
                    }
            Calendar c = Calendar.getInstance();
                                  c.setTime(date1);
                                  c.add(Calendar.DATE, 1);

                                  DateFormat format12 = new SimpleDateFormat("yyyy-MM-dd");
                                  String formatted = format12.format(c.getTime());
                                  
            result=formatted;
            
        }else{
            Object Val = ADFContext.getCurrent().getPageFlowScope().get("OfferId")==null?"":ADFContext.getCurrent().getPageFlowScope().get("OfferId").toString();
            ViewObject offerHdrVO=OfferHrd_VO1.getViewObject();
            ViewCriteria offerHdrVC=offerHdrVO.createViewCriteria();
            ViewCriteriaRow offerHdrVCR=offerHdrVC.createViewCriteriaRow();
            offerHdrVCR.setAttribute("OfferHdrId", Val);
            offerHdrVC.addRow(offerHdrVCR);
            offerHdrVO.applyViewCriteria(offerHdrVC);
            offerHdrVO.executeQuery();
    //            ViewObject BkHdrVo =
    //            this.getBookingHeader_VO1().getViewObject();
            Row re=offerHdrVO.getCurrentRow();
      String DateFr =
        re.getAttribute("OfferToDate") == null ? "" : re.getAttribute("OfferToDate").toString();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1=new Date();
                    try {
                        date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
                    } catch (ParseException e) {
                    }
            Calendar c = Calendar.getInstance();
                                  c.setTime(date1);
                                  c.add(Calendar.DATE, 1);

                                  DateFormat format12 = new SimpleDateFormat("yy-MM-dd");
                                  String formatted = format12.format(c.getTime());
            result=formatted;
             
        }
        
        
        return result;
    }
    
    public String CreateBooking(Object offerid){
        Object Val = offerid;
        ADFContext.getCurrent().getPageFlowScope().put("OfferId",offerid);
        
        // Insert Booking Header
        Row bookHrdRow=BookingHdrVo.createRow();
        bookHrdRow.setAttribute("OfferHdrId", Val);
        BookingHdrVo.insertRow(bookHrdRow);
        
        // Filetering Offer Line
        ViewObject offerDtlVO=this.OfferDtl_VO1.getViewObject();
        ViewCriteria offerDtlVC=offerDtlVO.createViewCriteria();
        ViewCriteriaRow offerDtlVCR=offerDtlVC.createViewCriteriaRow();
        offerDtlVCR.setAttribute("OfferHdrId", Val);
        offerDtlVC.addRow(offerDtlVCR);
        offerDtlVO.applyViewCriteria(offerDtlVC);
        offerDtlVO.executeQuery();
        
        RowSetIterator OfferDtlRS=offerDtlVO.createRowSetIterator(null);
        while(OfferDtlRS.hasNext()){
            Row OfferDtlRow=OfferDtlRS.next();
            // inserting Row
            Row bookingRow=BookingDtlVo.createRow();
    //            bookingRow.setAttribute("BookingId", this.getBookingHeader_VO1().getCurrentRow().getAttribute("BookingId"));
            bookingRow.setAttribute("PropertyId", OfferDtlRow.getAttribute("PropertyId"));
            bookingRow.setAttribute("BuildingId", OfferDtlRow.getAttribute("BuildingId"));
            String UnitStatus =ValidateUnitStatus(OfferDtlRow.getAttribute("UnitId")) == null ? "" :ValidateUnitStatus(OfferDtlRow.getAttribute("UnitId")).toString();
            String val= validateDate(UnitStatus).toString();
            //String val= validateDate(UnitStatus).toString();
            Date date1=new Date();
                  try {
                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(val);
                    } catch (ParseException e) {
                                   }
            bookingRow.setAttribute("UnitId", OfferDtlRow.getAttribute("UnitId"));
            bookingRow.setAttribute("BaseRate", OfferDtlRow.getAttribute("BaseRate"));
            bookingRow.setAttribute("Attribute3", OfferDtlRow.getAttribute("Attribute3"));
            bookingRow.setAttribute("TaxAmount", OfferDtlRow.getAttribute("TaxAmount"));
            bookingRow.setAttribute("TotalRate", OfferDtlRow.getAttribute("TotalRate"));
            
                  java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
                  oracle.jbo.domain.Date domadate=new oracle.jbo.domain.Date(sqlDate);
                  bookingRow.setAttribute("UnitAvlFrom", domadate);
                  bookingRow.setAttribute("UnitAvlStatus", UnitStatus);
            
            this.BookingDtlVo.insertRow(bookingRow);
        }
        this.BookingDtlVo.executeQuery();
        
     
     
        CreateMilestone();
        Row BRe=this.BookingCustomer_VO1.createRow();
        BookingCustomer_VO1.insertRow(BRe);
        BookingCustomer_VO1.executeQuery();
       
     
        
        
    //        ViewObject OfferHdrVo=this.getOfferHrd_VO1().getViewObject();
    //        ViewCriteria vc = OfferHdrVo.createViewCriteria();
    //        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
    //        vcRow.setAttribute("OfferHdrId", Val);
    //        vc.addRow(vcRow);
    //
    //        OfferHdrVo.applyViewCriteria(vc);
    //        OfferHdrVo.executeQuery();
    //        Row OfferHdrRow=OfferHdrVo.first();
    //
    //        ViewObject BookingHdrVo=this.getBookingHeader_VO1().getViewObject();
    //        Row BHdrrow=BookingHdrVo.createRow();
    //        BHdrrow.setAttribute("OfferHdrId", OfferHdrRow.getAttribute("OfferHdrId"));
    //        BHdrrow.setAttribute("TotalRent", OfferHdrRow.getAttribute("OfferTotal"));
    //
    //        //BHdrrow.setAttribute("BookingDueDate", OfferHdrRow.getAttribute("OfferDate"));
    //
    //        BookingHdrVo.insertRow(BHdrrow);
    //       BookingHdrVo.executeQuery();
        
        
    //
    //        ViewObject BookingDtlVo=this.getBookingDetail_VO1().getViewObject();
    //        Row BKdtlRe=BookingDtlVo.createRow();
    //
        
       
        
        
        
       // BookingDtl.executeQuery();
        
        return "Suceess";
    }
    //-----MILESTONE
    public String CreateMilestone(){
        Object Val = ADFContext.getCurrent().getPageFlowScope().get("OfferId")==null?"":ADFContext.getCurrent().getPageFlowScope().get("OfferId").toString();
        
        // Filetering Offer Line
        ViewObject milestoneDtlVO=this.OfferMilestoneDetail_VO1.getViewObject();
        ViewCriteria offerDtlVC=milestoneDtlVO.createViewCriteria();
        ViewCriteriaRow offerDtlVCR=offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("OfferHdrId", Val);
        offerDtlVC.addRow(offerDtlVCR);
        milestoneDtlVO.applyViewCriteria(offerDtlVC);
        milestoneDtlVO.executeQuery();
      //  System.err.println("Booking ID===>"+this.getBookingHeader_VO1().getCurrentRow().getAttribute("BookingId"));
        // Iterating Lines
        RowSetIterator OfferDtlRS=milestoneDtlVO.createRowSetIterator(null);
        while(OfferDtlRS.hasNext()){
            Row OfferDtlRow=OfferDtlRS.next();
            // inserting Row
            Row bookingRow=this.BookingMsDtlVo.createRow();
    //            bookingRow.setAttribute("BookingId", this.getBookingHeader_VO1().getCurrentRow().getAttribute("BookingId"));
            bookingRow.setAttribute("SeqNumber", OfferDtlRow.getAttribute("SeqNumber"));
            bookingRow.setAttribute("InstallmentType", OfferDtlRow.getAttribute("InstallmentType"));
    //            String UnitStatus =ValidateUnitStatus(OfferDtlRow.getAttribute("UnitId")) == null ? "" :ValidateUnitStatus(OfferDtlRow.getAttribute("UnitId")).toString();
           // String val= validateDate(UnitStatus).toString();
            //String val= validateDate(UnitStatus).toString();
    //            Date date1=new Date();
    //                  try {
    //                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(val);
    //                    } catch (ParseException e) {
    //                                   }
            bookingRow.setAttribute("InstallmentPct", OfferDtlRow.getAttribute("InstallmentPct"));
            bookingRow.setAttribute("InstallmentAmount", OfferDtlRow.getAttribute("InstallmentAmount"));
            bookingRow.setAttribute("Criteria", OfferDtlRow.getAttribute("Criteria"));
            bookingRow.setAttribute("ChargeType", OfferDtlRow.getAttribute("ChargeType"));
            bookingRow.setAttribute("PaymentTerm", OfferDtlRow.getAttribute("PaymentTerm"));
            bookingRow.setAttribute("DueDate", OfferDtlRow.getAttribute("DueDate"));
            bookingRow.setAttribute("MilestoneType","BK");
    //            MilestoneType
    //                  java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
    //                  oracle.jbo.domain.Date domadate=new oracle.jbo.domain.Date(sqlDate);
    //                  bookingRow.setAttribute("UnitAvlFrom", domadate);
    //                  bookingRow.setAttribute("UnitAvlStatus", UnitStatus);
            
            this.BookingMsDtlVo.insertRow(bookingRow);
        }
        this.BookingMsDtlVo.executeQuery();
     
     
     
     
     
        
        
    //        ViewObject OfferHdrVo=this.getOfferHrd_VO1().getViewObject();
    //        ViewCriteria vc = OfferHdrVo.createViewCriteria();
    //        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
    //        vcRow.setAttribute("OfferHdrId", Val);
    //        vc.addRow(vcRow);
    //
    //        OfferHdrVo.applyViewCriteria(vc);
    //        OfferHdrVo.executeQuery();
    //        Row OfferHdrRow=OfferHdrVo.first();
    //
    //        ViewObject BookingHdrVo=this.getBookingHeader_VO1().getViewObject();
    //        Row BHdrrow=BookingHdrVo.createRow();
    //        BHdrrow.setAttribute("OfferHdrId", OfferHdrRow.getAttribute("OfferHdrId"));
    //        BHdrrow.setAttribute("TotalRent", OfferHdrRow.getAttribute("OfferTotal"));
    //
    //        //BHdrrow.setAttribute("BookingDueDate", OfferHdrRow.getAttribute("OfferDate"));
    //
    //        BookingHdrVo.insertRow(BHdrrow);
    //       BookingHdrVo.executeQuery();
        
        
    //
    //        ViewObject BookingDtlVo=this.getBookingDetail_VO1().getViewObject();
    //        Row BKdtlRe=BookingDtlVo.createRow();
    //
        
       
        
        
        
       // BookingDtl.executeQuery();
        
        return "Suceess";
    }  
  public void onOffer(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if(valueChangeEvent.getNewValue()!=null||valueChangeEvent.getNewValue()!=""){
            
            CreateBooking(valueChangeEvent.getNewValue());
            
        }
        
       
    }

  public void setPgl1(RichPanelGroupLayout pgl1) {
    this.pgl1 = pgl1;
  }

  public RichPanelGroupLayout getPgl1() {
    return pgl1;
  }

  public void setPgl2(RichPanelGridLayout pgl2) {
    this.pgl2 = pgl2;
  }

  public RichPanelGridLayout getPgl2() {
    return pgl2;
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


  public void setS1(RichSpacer s1) {
    this.s1 = s1;
  }

  public RichSpacer getS1() {
    return s1;
  }

  public void setPb1(RichPanelBox pb1) {
    this.pb1 = pb1;
  }

  public RichPanelBox getPb1() {
    return pb1;
  }


  public void setOl1(RichOutputLabel ol1) {
    this.ol1 = ol1;
  }

  public RichOutputLabel getOl1() {
    return ol1;
  }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }


  public void setQryId1(RichQuery qryId1) {
        this.qryId1 = qryId1;
    }

    public RichQuery getQryId1() {
        return qryId1;
    }

    public void setResId1(RichTable resId1) {
        this.resId1 = resId1;
    }

    public RichTable getResId1() {
        return resId1;
    }

    public void setPc2(RichPanelCollection pc2) {
        this.pc2 = pc2;
    }

    public RichPanelCollection getPc2() {
        return pc2;
    }

  public void setS2(RichSpacer s2) {
    this.s2 = s2;
  }

  public RichSpacer getS2() {
    return s2;
  }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setCil1(RichCommandImageLink cil1) {
        this.cil1 = cil1;
    }

    public RichCommandImageLink getCil1() {
        return cil1;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setCil3(RichCommandImageLink cil3) {
        this.cil3 = cil3;
    }

    public RichCommandImageLink getCil3() {
        return cil3;
    }

    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }


    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public void customBookingSearch_QL(QueryEvent queryEvent) {
        DCIteratorBinding iter = (DCIteratorBinding) getBindings().get("SearchBookingROVO1Iterator");
        /**Get Offer ViewObject from Iterator*/
        ViewObjectImpl vo = (ViewObjectImpl) iter.getViewObject();
        String unitDummy=null;
        if (vo.getNamedWhereClauseParam("b_unitNumDummy") != null) {
            unitDummy = vo.getNamedWhereClauseParam("b_unitNumDummy").toString();
            System.out.println("Booking UnitNumber:: "+unitDummy);
            vo.setNamedWhereClauseParam("b_unitNumTrans", unitDummy);
            vo.setNamedWhereClauseParam("b_unitNumDummy", null);
            }
        
        ADFUtils.invokeMethodExpression("#{bindings.SearchQuery.processQuery}", Object.class,
                                        QueryEvent.class, queryEvent);
        if (unitDummy != null) {
            vo.setNamedWhereClauseParam("b_unitNumTrans", null);
            vo.setNamedWhereClauseParam("b_unitNumDummy", unitDummy);
            }
    }

    public void exportToExcel(FacesContext facesContext,
                              OutputStream outputStream) {
        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Booking");
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("Booking No");
            sheet.setColumnWidth(0, 3500);
            rowhead.createCell(1).setCellValue("Offer No");
            sheet.setColumnWidth(1, 3500);
            //            rowhead.createCell(1).setCellValue("Property Name");
            //            sheet.setColumnWidth(1, 3000);
            rowhead.createCell(2).setCellValue("Building Name");
            sheet.setColumnWidth(2, 5000);
            rowhead.createCell(3).setCellValue("Unit Name");
            sheet.setColumnWidth(3, 4000);
            rowhead.createCell(4).setCellValue("Booking Date");
            sheet.setColumnWidth(4, 3500);
            rowhead.createCell(5).setCellValue("Booking Status");
            sheet.setColumnWidth(5, 4000);
            rowhead.createCell(6).setCellValue("Booking Sub Status");
            sheet.setColumnWidth(6, 5000);
            rowhead.createCell(7).setCellValue("Unit Status");
            sheet.setColumnWidth(7, 4000);
            rowhead.createCell(8).setCellValue("Lead Name");
            sheet.setColumnWidth(8, 6000);
            rowhead.createCell(9).setCellValue("Customer");
            sheet.setColumnWidth(9, 6000);
            rowhead.createCell(10).setCellValue("Customer Move in Date");
            sheet.setColumnWidth(10, 3500);
            rowhead.createCell(11).setCellValue("Booked By");
            sheet.setColumnWidth(11, 5000);
            rowhead.createCell(12).setCellValue("Set Rent");
            sheet.setColumnWidth(12, 4000);
            rowhead.createCell(13).setCellValue("Net Rent");
            sheet.setColumnWidth(13, 4000);
            rowhead.createCell(14).setCellValue("Discount");
            sheet.setColumnWidth(14, 4000);
            rowhead.createCell(15).setCellValue("Tax Amount");
            sheet.setColumnWidth(15, 3500);
            rowhead.createCell(16).setCellValue("Unit Description");
            sheet.setColumnWidth(16, 8000);
            rowhead.createCell(17).setCellValue("Mobile No");
            sheet.setColumnWidth(17, 6000);
            rowhead.createCell(18).setCellValue("Phone No");
            sheet.setColumnWidth(18, 6000);
            rowhead.createCell(19).setCellValue("Email Id");
            sheet.setColumnWidth(19, 6000);
            rowhead.createCell(20).setCellValue("Offer Flag");
            sheet.setColumnWidth(20, 4500);
            ViewObject actVO =
                ADFUtils.findIterator("SearchBookingROVO1Iterator").getViewObject();
            actVO.executeQuery();
            if (actVO.getEstimatedRowCount() > 0) {
                RowSetIterator rs = actVO.createRowSetIterator(null);
                int excelRowData = 1;
                while (rs.hasNext()) {
                    Row actRow = rs.next();
                    String bkNo =
                        actRow.getAttribute("BookingNumber") != null ?
                        actRow.getAttribute("BookingNumber").toString() : "";
                    String ofrNo =
                        actRow.getAttribute("Offernumber") != null ?
                        actRow.getAttribute("Offernumber").toString() :
                        "";
                    String buildName =
                        actRow.getAttribute("Buildname") != null ?
                        actRow.getAttribute("Buildname").toString() : "";
                    String unitName =
                        actRow.getAttribute("Unitname") != null ? actRow.getAttribute("Unitname").toString() :
                        "";
                    String bookingDate =
                        actRow.getAttribute("BookingDate") != null ? actRow.getAttribute("BookingDate").toString() :
                        "";
                    String bkStatus =
                        actRow.getAttribute("Status") == null ? "" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("DRA") ?
                        "Draft" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("PEN") ?
                        "Pending" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("APR") ?
                        "Approved" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("BO") ?
                        "Booked" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("REJ") ?
                        "Rejected" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("CANC") ?
                        "Cancelled" :
                        actRow.getAttribute("Status").toString().equalsIgnoreCase("TERM") ?
                        "Terminated" :
                        actRow.getAttribute("Status").toString();
                    String unitStatus =    actRow.getAttribute("UnitStatus")==null ? "" 
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("ALOT") ? "Allotted"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("BOOK") ? "Booked"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("AVAL") ? "Available"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("BLOCK") ? "Blocked"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("NOT_AVAL") ? "Not Available"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("OFFER") ? "Offered"
                        : actRow.getAttribute("UnitStatus").toString().equalsIgnoreCase("HOLD") ? "Hold"
                        : actRow.getAttribute("UnitStatus").toString();
                    String subStatus =
                        actRow.getAttribute("SubStatus") != null ?
                        actRow.getAttribute("SubStatus").toString() : "";
                    String leadName =
                        actRow.getAttribute("LeadName") != null ?
                        actRow.getAttribute("LeadName").toString() : "";
                    String custName =
                        actRow.getAttribute("CustName") != null ?
                        actRow.getAttribute("CustName").toString() : "";
                    String custMovInDate =
                        actRow.getAttribute("CustReqMoveinDate") != null ?
                        actRow.getAttribute("CustReqMoveinDate").toString() : "";
                    String bookedBy =
                        actRow.getAttribute("PerformedBy") != null ?
                        actRow.getAttribute("PerformedBy").toString() : "";
                    String SetRent =
                        actRow.getAttribute("SetRent") != null ?
                        actRow.getAttribute("SetRent").toString() : "";
                    String NetRent =
                        actRow.getAttribute("NetRent") != null ?
                        actRow.getAttribute("NetRent").toString() : "";
                    String DiscountValue =
                        actRow.getAttribute("DiscAmt") != null ?
                        actRow.getAttribute("DiscAmt").toString() : "";
                    String TaxAmount =
                        actRow.getAttribute("TaxAmount") != null ?
                        actRow.getAttribute("TaxAmount").toString() : "";
                    String UnitDescription =
                        actRow.getAttribute("UnitDescription") != null ?
                        actRow.getAttribute("UnitDescription").toString() : "";
                    String MobileNumber =
                        actRow.getAttribute("MobileNumber") != null ?
                        actRow.getAttribute("MobileNumber").toString() : "";
                    String PhoneNumber =
                        actRow.getAttribute("PhoneNumber") != null ?
                        actRow.getAttribute("PhoneNumber").toString() : "";
                    String EmailId =
                        actRow.getAttribute("EmailId") != null ?
                        actRow.getAttribute("EmailId").toString() : "";
                    String offerFlag =
                        actRow.getAttribute("OfferFlag") == null ? ""
                        : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("N") ? "New" 
                        : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("R") ? "Renewal"
                        : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("S") ? "Short Renewal"
                        : "";


                    HSSFRow row = sheet.createRow((short)excelRowData);
                    row.createCell(0).setCellValue(bkNo);
                    row.createCell(1).setCellValue(ofrNo);
                    row.createCell(2).setCellValue(buildName);
                    row.createCell(3).setCellValue(unitName);
                    row.createCell(4).setCellValue(bookingDate);
                    row.createCell(5).setCellValue(bkStatus);
                    row.createCell(6).setCellValue(subStatus);
                    row.createCell(7).setCellValue(unitStatus);
                    row.createCell(8).setCellValue(leadName);
                    row.createCell(9).setCellValue(custName);
                    row.createCell(10).setCellValue(custMovInDate);
                    row.createCell(11).setCellValue(bookedBy);
                    row.createCell(12).setCellValue(SetRent);
                    row.createCell(13).setCellValue(NetRent);
                    row.createCell(14).setCellValue(DiscountValue);
                    row.createCell(15).setCellValue(TaxAmount);
                    row.createCell(16).setCellValue(UnitDescription);
                    row.createCell(17).setCellValue(MobileNumber);
                    row.createCell(18).setCellValue(PhoneNumber);
                    row.createCell(19).setCellValue(EmailId);
                    row.createCell(20).setCellValue(offerFlag);
                    excelRowData++;
                }
            }
            workbook.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            System.err.println("BDS" + e.getMessage());
        }
    }
}
