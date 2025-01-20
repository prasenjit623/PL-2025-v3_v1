import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.event.ReturnEvent;

import util.ADFUtils;

public class booking {
    public booking() {
        
        
    }

    public void onOfferNoProcess(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        
        
        ViewObject BookingDtl=ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        
        ViewObject OfferHdrVo=ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();;
        ViewCriteria vc = OfferHdrVo.createViewCriteria();
               ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
               
               vcRow.setAttribute("OfferHdrId", valueChangeEvent.getNewValue());
               vc.addRow(vcRow);
               
               OfferHdrVo.applyViewCriteria(vc);
               OfferHdrVo.executeQuery();
        ViewObject OfferDtlVo=ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();
        Row detailRow=OfferDtlVo.first();
        RowSetIterator rs = OfferDtlVo.createRowSet("");
                                       while (rs.hasNext()) {
                                          
                                             detailRow = rs.next();
                                           
                                          // Row detBokrow=BookingDtl.createRow();
                                            ADFUtils.findOperation("CreateInsert").execute();
                                           Row detBokrow=BookingDtl.getCurrentRow();
                                           detBokrow.setAttribute("PropertyId", detailRow.getAttribute("PropertyId"));
                                           detBokrow.setAttribute("BuildingId", detailRow.getAttribute("BuildingId"));
                                           detBokrow.setAttribute("UnitId", detailRow.getAttribute("UnitId"));
                                           detBokrow.setAttribute("BaseRate", detailRow.getAttribute("BaseRate"));
                                           detBokrow.setAttribute("DiscountRate", detailRow.getAttribute("DiscountAmount"));
                                           detBokrow.setAttribute("TaxAmount", detailRow.getAttribute("TaxAmount"));
                                           detBokrow.setAttribute("TotalRate", detailRow.getAttribute("TotalRate"));
                                           
                                           BookingDtl.insertRow(detBokrow);
        
                                       }
        
    }



   
  








    public void receiptReturnListener(ReturnEvent returnEvent) {
//        ViewObject VO=ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
//        VO.executeQuery();
        String Totalrent = "";
        BindingContext bc = BindingContext.getCurrent();
          DCBindingContainer dcb =
            (DCBindingContainer)bc.getCurrentBindingsEntry();
          DCIteratorBinding iter =
            dcb.findIteratorBinding("Receipt_VO1Iterator");
          iter.executeQuery();
          //RequestContext.getCurrentInstance().addPartialTarget(returnEvent.getComponent().getParent().getParent());
          
          
          ViewObject OfferDtlVo=ADFUtils.findIterator("Receipt_VO1Iterator").getViewObject();
          if(OfferDtlVo.getEstimatedRowCount()>0){
              RowSetIterator rs = OfferDtlVo.createRowSet("");
              //BigDecimal totalRecAmnt=new BigDecimal(0);
              Double totalRecAmnt = new Double(0);
              
              while (rs.hasNext()) {
              
                 Row detailRow = rs.next();
               
//               System.err.println("==========AMOUNT"+detailRow.getAttribute("RecommendedAmount"));
               
               String amnt=detailRow.getAttribute("RecommendedAmount")== null ? "0" :
               detailRow.getAttribute("RecommendedAmount").toString();
               Double RecAmnt = new Double(amnt);
               totalRecAmnt=totalRecAmnt+RecAmnt;
               
              }
              
              BigDecimal TotalRecAmn=BigDecimal.valueOf(totalRecAmnt);
              
              ViewObject BookHdr =
               ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
//              System.err.println("==Booking Row count in Add=="+BookHdr.getEstimatedRowCount());
              if(BookHdr.first()!=null){
               Totalrent =
               BookHdr.first().getAttribute("BaseRate") == null ? "0" :
               BookHdr.first().getAttribute("BaseRate").toString();
              }else{
                  Totalrent ="0";
              }
//              ViewObject BookHdr =
//               ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
//              String Totalrent =
//               BookHdr.getCurrentRow().getAttribute("TotalRent") == null ? "0" :
//               BookHdr.getCurrentRow().getAttribute("TotalRent").toString();
//              String BookAmnt ="0";
              // valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
              Double Totalre = new Double(Totalrent);
              Double ValueforYear = Totalre / 365;
              Double NofDuDays = totalRecAmnt / ValueforYear;


              ViewObject BkHdrVo =
               ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
              Row re = BkHdrVo.getCurrentRow();
              String DateFr =
               re.getAttribute("BookingDate") == null ? "" : re.getAttribute("BookingDate").toString();
//              SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
              Date date1 = new Date();
              try {
               date1 = new SimpleDateFormat("yyyy-MM-dd").parse(DateFr);
              } catch (ParseException e) {
                  e.printStackTrace();
              }
              Calendar c = Calendar.getInstance();
              c.setTime(date1);
              c.add(Calendar.DATE, (int)Math.round(NofDuDays));
              DateFormat format12 = new SimpleDateFormat("yyyy-MM-dd");
              String formatted = format12.format(c.getTime());

              Date date2 = new Date();
              try {
               date2 = new SimpleDateFormat("yyyy-MM-dd").parse(formatted);
              } catch (ParseException e) {
                  e.printStackTrace();

              }

              java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
              oracle.jbo.domain.Date domadate = new oracle.jbo.domain.Date(sqlDate);
              re.setAttribute("BookingDueDate", domadate);
              re.setAttribute("BookingAmount", TotalRecAmn);
              
              
          }
          
          
          
          
          
    }
}
