import java.io.IOException;
import java.io.OutputStream;

import java.math.BigDecimal;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.context.AdfFacesContext;

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
import util.xxfnd;

public class SearchOffers {
    private RichInputText leadNumber;
    private RichInputText customerName;
    private RichInputText customerNumber;
    private RichInputText enterBy;
    private RichSelectOneChoice propertyName;
    private RichSelectOneChoice buildingName;
    private RichSelectOneChoice unitName;
    private RichTable t2;
    String andCondition=null;
    private RichInputText offerNumber;

    public SearchOffers() {
    }

    public void setLeadNumber(RichInputText leadNumber) {
        this.leadNumber = leadNumber;
    }

    public RichInputText getLeadNumber() {
        return leadNumber;
    }

    public void setCustomerName(RichInputText customerName) {
        this.customerName = customerName;
    }

    public RichInputText getCustomerName() {
        return customerName;
    }

    public void setCustomerNumber(RichInputText customerNumber) {
        this.customerNumber = customerNumber;
    }

    public RichInputText getCustomerNumber() {
        return customerNumber;
    }

    public void setEnterBy(RichInputText enterBy) {
        this.enterBy = enterBy;
    }

    public RichInputText getEnterBy() {
        return enterBy;
    }

    public void setPropertyName(RichSelectOneChoice propertyName) {
        this.propertyName = propertyName;
    }

    public RichSelectOneChoice getPropertyName() {
        return propertyName;
    }

    public void setBuildingName(RichSelectOneChoice buildingName) {
        this.buildingName = buildingName;
    }

    public RichSelectOneChoice getBuildingName() {
        return buildingName;
    }

    public void setUnitName(RichSelectOneChoice unitName) {
        this.unitName = unitName;
    }

    public RichSelectOneChoice getUnitName() {
        return unitName;
    }

    ViewObject offerHrdVO =
        ADFUtils.findIterator("searchOffersInfoROVO1Iterator").getViewObject();
    ViewObject offerDetVO =
        ADFUtils.findIterator("searchOfferDetailROVO1Iterator").getViewObject();

    public void onClickCustSearch(ActionEvent actionEvent) {
        andCondition = null;
        ArrayList<String> UnitId=new ArrayList<String>();
        ArrayList<String> PropertyId=new ArrayList<String>();
        ArrayList<String> BuildingId=new ArrayList<String>();

        if (leadNumber.getValue() == null || leadNumber.getValue() == "") {
        } else {
            if (andCondition != null) {
                andCondition =andCondition +
                        "LEAD_NUMBER=" + "'" + leadNumber.getValue().toString() +
                        "'";
            } else {
                andCondition =
                        "LEAD_NUMBER=" + "'" + leadNumber.getValue().toString() +
                        "'";
            }
        }

        {
            
            if (customerName.getValue() == null || customerName.getValue() == "") {
            } else {
            if (customerName.getValue() != null||customerName.getValue() == "") {
                if (andCondition != null) {
                    andCondition =andCondition +
                            "AND LEAD_NAME=" + "'" + customerName.getValue().toString() +
                            "'";
                } else {
                    andCondition =
                            "LEAD_NAME=" + "'" + customerName.getValue().toString() +
                            "'";
                }
            }
            }
            
            
            if (customerNumber.getValue() == null || customerNumber.getValue() == "") {
            } else {
            if (customerNumber.getValue() != null ||customerNumber.getValue() != "" ) {
                if (andCondition != null) {
                    andCondition =andCondition +
                            "AND MOBILE_NUMBER=" + "'" + customerNumber.getValue().toString() +
                            "'";
                } else {
                    andCondition =
                            "MOBILE_NUMBER=" + "'" + customerNumber.getValue().toString() +
                            "'";
                }
            }
            }
            
            if (offerNumber.getValue() == null || offerNumber.getValue() == "") {
            } else {
            if (offerNumber.getValue() != null ||offerNumber.getValue() != "" ) {
                if (andCondition != null) {
                    andCondition =andCondition +
                            "AND OFFER_NUMBER=" + "'" + offerNumber.getValue().toString() +
                            "'";
                } else {
                    andCondition =
                            "OFFER_NUMBER=" + "'" + offerNumber.getValue().toString() +
                            "'";
                }
            }
            }
            
            if (enterBy.getValue() == null || enterBy.getValue() == "") {
            } else {
            
            if (enterBy.getValue() != null||enterBy.getValue() == "") {
                if (andCondition != null) {
                    andCondition =andCondition +
                            "AND CREATED_BY=" + "'" + enterBy.getValue().toString() +
                            "'";
                } else {
                    andCondition =
                            "CREATED_BY=" + "'" + enterBy.getValue().toString() +
                            "'";
                }
            }
            }
            
            if (propertyName.getValue() == null || propertyName.getValue() == "") {
            } else {
            if (propertyName.getValue() != null||propertyName.getValue() != "") {
                if (andCondition != null) {
                    PropertyId=new ArrayList<String>();
                    PropertyId=resultIdValues(propertyName.getValue().toString(),"", "");
                   
                    
                    
                    
                    
                    
                    
                
                } else {
                    PropertyId=new ArrayList<String>();
                    PropertyId=resultIdValues(propertyName.getValue().toString(),"", "");
                   
                    
                }
                
            }
            }
            
            
            if (buildingName.getValue() == null || buildingName.getValue() == "") {
            } else {
            if (buildingName.getValue() != null||buildingName.getValue() != "") {
                if (andCondition != null) {
                   
                        
                    BuildingId=new ArrayList<String>();
                   
                    BuildingId=resultIdValues("",buildingName.getValue().toString(),"");
                    
                    
                                    
                  
                }else{
                    BuildingId=new ArrayList<String>();
                    BuildingId=resultIdValues("",buildingName.getValue().toString(),"");
                    
                    
                    System.out.println("Idvals:" +BuildingId);
                }
                
            }
            }
            
            
            if (unitName.getValue() == null || unitName.getValue() == "") {
            } else {
            if (unitName.getValue() != null||unitName.getValue() != "") {
                if (andCondition != null) {
                   
                    UnitId=new ArrayList<String>();
                    UnitId=resultIdValues("","", unitName.getValue().toString());
                    
                    
                  
                }
                else{
                    UnitId=new ArrayList<String>();
                    UnitId=resultIdValues("","", unitName.getValue().toString());
                    
                    
                }
            }
            }
              
            ArrayList<String> Set1=new ArrayList<String>();
              
              if(PropertyId.size()>0){
                   Set1=new ArrayList<String>(new LinkedHashSet<String>(PropertyId));
              }
            if(BuildingId.size()>0){
                 Set1=new ArrayList<String>(new LinkedHashSet<String>(BuildingId));
            }
            if(UnitId.size()>0){
               Set1 =new ArrayList<String>(new LinkedHashSet<String>(UnitId));
            }
            
            String str =Set1.toString();
            if(Set1.size()>0){
            if (andCondition != null) {

               // ArrayList<String> Set1=new ArrayList<String>(new LinkedHashSet<String>(PropertyId));

                                  str = str.replaceAll("[\\[\\]]", "");
                                 andCondition=andCondition+"AND OFFER_HDR_ID IN ("+str+")";

            } else {





                                  str = str.replaceAll("[\\[\\]]", "");
                                 andCondition ="OFFER_HDR_ID IN ("+str+")";


            }
            }


            offerHrdVO.setWhereClause(andCondition);
            offerHrdVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(t2);

        }
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }
    
    public String Revise(){
        ViewObject SearchVo=ADFUtils.findIterator("searchOffersInfoROVO1Iterator").getViewObject();
        ViewObject MilestoneVo=ADFUtils.findIterator("OfferHrd_VO2Iterator").getViewObject();
        ViewCriteria vc = MilestoneVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        
        
        vcRow.setAttribute("OfferHdrId", SearchVo.getCurrentRow().getAttribute("OfferHdrId"));
        vc.addRow(vcRow);
        
        MilestoneVo.applyViewCriteria(vc);
        MilestoneVo.executeQuery();
        Row re=MilestoneVo.first();
        re.setAttribute("Status", "REV");
        BigDecimal val=new BigDecimal(re.getAttribute("RevisionNo").toString());
        val=val.add(new BigDecimal(1));
        re.setAttribute("RevisionNo", val);
        MilestoneVo.executeQuery();
         ADFUtils.findOperation("Commit").execute();
        return "offer";
    }
    
    public ArrayList<String> resultIdValues(String value1,String value2 ,String value3)    {
        ArrayList<String> result = new ArrayList<String>();
        
        ViewObject DistVO=ADFUtils.findIterator("DistinctOfferDetailROVO1Iterator").getViewObject();
        DistVO.setNamedWhereClauseParam("P_PROP", value1);
        DistVO.setNamedWhereClauseParam("P_BUILD", value2);
        DistVO.setNamedWhereClauseParam("P_UNIT", value3);
        DistVO.executeQuery();
       //Row re=DistVO.first();
       RowSetIterator rs = DistVO.createRowSetIterator("");
               
                while (rs.hasNext()) {
                    Row re=rs.next();
                    
                    result.add(re.getAttribute("OfferHdrId").toString());
                    
                    
                }
        
        
//        numbers.add(5);
//        numbers.add(11);
//        numbers.add(3);
        return(result);
    }


    public void onClickReset(ActionEvent actionEvent) {
        // Add event code here...
        andCondition=null;
        offerHrdVO.setWhereClause(andCondition);
        offerHrdVO.executeQuery();
        
        this.propertyName.setValue("");
        this.buildingName.setValue("");
        this.unitName.setValue("");
        this.leadNumber.setValue("");
        this.customerName.setValue("");
        this.customerNumber.setValue("");
        this.enterBy.setValue("");
    }

    public void OnclickRevise(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject SearchVo=ADFUtils.findIterator("searchOffersInfoROVO1Iterator").getViewObject();
        ViewObject MilestoneVo=ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
        ViewCriteria vc = MilestoneVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        
        
        vcRow.setAttribute("OfferHdrId", SearchVo.getCurrentRow().getAttribute("OfferHdrId"));
        vc.addRow(vcRow);
        
        MilestoneVo.applyViewCriteria(vc);
        MilestoneVo.executeQuery();
        Row re=MilestoneVo.first();
        re.setAttribute("Status", "REV");
        BigDecimal val=new BigDecimal(re.getAttribute("RevisionNo").toString());
        val=val.add(new BigDecimal(1));
        re.setAttribute("RevisionNo", val);
    }

    public void setOfferNumber(RichInputText offerNumber) {
        this.offerNumber = offerNumber;
    }

    public RichInputText getOfferNumber() {
        return offerNumber;
    }

    public void onRevise(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject OfferHdr=ADFUtils.findIterator("searchOffersInfoROVO1Iterator").getViewObject();
       xxfnd fnd=new xxfnd();
       
       String result=fnd.reviseOffer(OfferHdr.getCurrentRow().getAttribute("OfferNumber").toString(), OfferHdr.getCurrentRow().getAttribute("CreatedBy").toString(), "OfferAppModuleDataControl").toString();
        System.err.println("ERRRRROR_MSG"+result);
        
        ViewObject MilestoneVo=ADFUtils.findIterator("OfferHrd_VO2Iterator").getViewObject();
        ViewCriteria vc = MilestoneVo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        
        
        vcRow.setAttribute("OfferHdrId", OfferHdr.getCurrentRow().getAttribute("OfferHdrId"));
        vc.addRow(vcRow);
        
        MilestoneVo.applyViewCriteria(vc);
        MilestoneVo.executeQuery();
        Row re=MilestoneVo.first();
        re.setAttribute("Status", "DRA");
        
        MilestoneVo.executeQuery();
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void customOfferSearch_QL(QueryEvent queryEvent) {
        DCIteratorBinding iter = (DCIteratorBinding) getBindings().get("searchOffersInfoROVO1Iterator");
        /**Get Offer ViewObject from Iterator*/
        ViewObjectImpl vo = (ViewObjectImpl) iter.getViewObject();
        String unitDummy=null;
        String propertyDummy = null;
        String buildDummy = null;
        if (vo.getNamedWhereClauseParam("b_unitNumDummy") != null) {
            unitDummy = vo.getNamedWhereClauseParam("b_unitNumDummy").toString();
            System.out.println("UnitNumber:: "+unitDummy);
            vo.setNamedWhereClauseParam("b_unitNumTrans", unitDummy);
            vo.setNamedWhereClauseParam("b_unitNumDummy", null);
            }
        if (vo.getNamedWhereClauseParam("b_propDummy") != null) {
            propertyDummy = vo.getNamedWhereClauseParam("b_propDummy").toString();
            System.out.println("PropertyNumber:: "+propertyDummy);
            vo.setNamedWhereClauseParam("b_propTrans", propertyDummy);
            vo.setNamedWhereClauseParam("b_propDummy", null);
            }
        if (vo.getNamedWhereClauseParam("b_buildDummy") != null) {
            buildDummy = vo.getNamedWhereClauseParam("b_buildDummy").toString();
            System.out.println("BuildingNumber:: "+buildDummy);
            vo.setNamedWhereClauseParam("b_buildTrans", buildDummy);
            vo.setNamedWhereClauseParam("b_buildDummy", null);
            }
        ADFUtils.invokeMethodExpression("#{bindings.searchOffersInfoROVOCriteriaQuery.processQuery}", Object.class,
                                        QueryEvent.class, queryEvent);
        if (unitDummy != null) {
            vo.setNamedWhereClauseParam("b_unitNumTrans", null);
            vo.setNamedWhereClauseParam("b_unitNumDummy", unitDummy);
            }
        if (propertyDummy != null) {
            vo.setNamedWhereClauseParam("b_propTrans", null);
            vo.setNamedWhereClauseParam("b_propDummy", unitDummy);
            }
        if (buildDummy != null) {
            vo.setNamedWhereClauseParam("b_buildTrans", null);
            vo.setNamedWhereClauseParam("b_buildDummy", unitDummy);
            }
    }
    
   
    
        public void exportToExcel(javax.faces.context.FacesContext facesContext,
                                  OutputStream outputStream) {
            // Add event code here...
            try {

                        HSSFWorkbook workbook = new HSSFWorkbook();
                        HSSFSheet sheet =
                            workbook.createSheet("Offer");
                        HSSFRow rowhead = sheet.createRow((short)0);
                        rowhead.createCell(0).setCellValue("Offer No");
                        sheet.setColumnWidth(0, 3000);
                        rowhead.createCell(1).setCellValue("Lead No");
                        sheet.setColumnWidth(1, 3000);
                        rowhead.createCell(2).setCellValue("Building Name");
                        sheet.setColumnWidth(2, 6000);
                        rowhead.createCell(3).setCellValue("Unit Name");
                        sheet.setColumnWidth(3, 3000);
                        rowhead.createCell(4).setCellValue("Business Unit");
                        sheet.setColumnWidth(4, 5500);
                        rowhead.createCell(5).setCellValue("Offer Date");
                        sheet.setColumnWidth(5, 4500);
                        rowhead.createCell(6).setCellValue("Expected Lease Start Date");
                        sheet.setColumnWidth(6, 6000);
                        rowhead.createCell(7).setCellValue("Expected Lease End Date");
                        sheet.setColumnWidth(7, 6000);
                        rowhead.createCell(8).setCellValue("Offer Status");
                        sheet.setColumnWidth(8, 4000);
                        rowhead.createCell(9).setCellValue("Offer Sub Status");
                        sheet.setColumnWidth(9, 5000);
                        rowhead.createCell(10).setCellValue("Unit Status");
                        sheet.setColumnWidth(10, 4000);
                        rowhead.createCell(11).setCellValue("Customer Name");
                        sheet.setColumnWidth(11, 6000);
                        rowhead.createCell(12).setCellValue("Contact Number");
                        sheet.setColumnWidth(12, 5000);
                        rowhead.createCell(13).setCellValue("Entered By");
                        sheet.setColumnWidth(13, 5000);
                        rowhead.createCell(14).setCellValue("Net Rent");
                        sheet.setColumnWidth(14, 3500);
                        rowhead.createCell(15).setCellValue("Set Rent");
                        sheet.setColumnWidth(15, 3500);
                        rowhead.createCell(16).setCellValue("Discount");
                        sheet.setColumnWidth(16, 3500);
                        rowhead.createCell(17).setCellValue("Tax Amount");
                        sheet.setColumnWidth(17, 3000);
                        rowhead.createCell(18).setCellValue("Unit Description");
                        sheet.setColumnWidth(18, 5000);
                        rowhead.createCell(19).setCellValue("Offer Flag");
                        sheet.setColumnWidth(19, 4000);
                        rowhead.createCell(20).setCellValue("Contract No");
                        sheet.setColumnWidth(20, 4000);
                        ViewObject actVO =
                            ADFUtils.findIterator("searchOffersInfoROVO1Iterator").getViewObject();
                        actVO.executeQuery();
                        if (actVO.getEstimatedRowCount() > 0) {
                            RowSetIterator rs = actVO.createRowSetIterator(null);
                            int excelRowData = 1;
                            while (rs.hasNext()) {
                                Row actRow = rs.next();
                                String offerNo =
                                    actRow.getAttribute("OfferNumber") != null ?
                                    actRow.getAttribute("OfferNumber").toString() : 
                                                            "";
                                String leadNo =
                                    actRow.getAttribute("Leadnumber") != null ?
                                    actRow.getAttribute("Leadnumber").toString() :
                                    "";
                                String buildName =
                                    actRow.getAttribute("BuildName") != null ?
                                    actRow.getAttribute("BuildName").toString() :
                                    "";
                                String unitName =
                                    actRow.getAttribute("Unitname") != null ?
                                    actRow.getAttribute("Unitname").toString() :
                                    "";
                                String bUnit =
                                    actRow.getAttribute("Businessunit") != null ?
                                    actRow.getAttribute("Businessunit").toString() : "";
                                String offerDate =
                                    actRow.getAttribute("OfferDate") != null ? 
                                                            actRow.getAttribute("OfferDate").toString() :
                                    "";
                                String fromDate =
                                    actRow.getAttribute("OfferFromDate") != null ?
                                    actRow.getAttribute("OfferFromDate").toString() :
                                    "";
                                String toDate =
                                    actRow.getAttribute("OfferToDate") != null ?
                                    actRow.getAttribute("OfferToDate").toString() :
                                    "";
                                String offerStatus =    actRow.getAttribute("Status")==null ? "" 
                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("DRA") ? "Draft"
                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("PEN") ? "Pending"
                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("APR") ? "Approved"
                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("BO") ? "Booked"
                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("REJ") ? "Rejected"
                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("CANC") ? "Cancelled"
                                    : actRow.getAttribute("Status").toString().equalsIgnoreCase("TERM") ? "Terminated"
                                    : actRow.getAttribute("Status").toString();
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
                                    actRow.getAttribute("SubStatus").toString() :
                                    "";
                                String leadName =
                                    actRow.getAttribute("Leadname") != null ?
                                    actRow.getAttribute("Leadname").toString() :
                                    "";
                                String mNo =
                                    actRow.getAttribute("Mobilenumber") != null ?
                                    actRow.getAttribute("Mobilenumber").toString() :
                                    "";
                                String createdBy =
                                    actRow.getAttribute("CreatedBy") != null ?
                                    actRow.getAttribute("CreatedBy").toString() :
                                    "";
                                String netRent =
                                    actRow.getAttribute("NetRent") != null ?
                                    actRow.getAttribute("NetRent").toString() :
                                    "";
                                String setRent =
                                    actRow.getAttribute("SetRent") != null ?
                                    actRow.getAttribute("SetRent").toString() :
                                    "";
                                String disValue =
                                    actRow.getAttribute("DiscValue") != null ?
                                    actRow.getAttribute("DiscValue").toString() :
                                    "";
                                String taxAmt =
                                    actRow.getAttribute("TaxAmountTrans") != null ?
                                    actRow.getAttribute("TaxAmountTrans").toString() :
                                    "";
                                String unitDescption =
                                    actRow.getAttribute("UnitDescription") != null ?
                                    actRow.getAttribute("UnitDescription").toString() :
                                    "";
                                String offerFlag =
                                    actRow.getAttribute("OfferFlag") == null ? ""
                                    : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("N") ? "New" 
                                    : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("R") ? "Renewal"
                                    : actRow.getAttribute("OfferFlag").toString().equalsIgnoreCase("S") ? "Short Renewal"
                                    : "";
                                String leaseNo =
                                    actRow.getAttribute("LeaseNumber") != null ?
                                    actRow.getAttribute("LeaseNumber").toString() :
                                    "";
                                
                                HSSFRow row = sheet.createRow((short)excelRowData);
                                row.createCell(0).setCellValue(offerNo);
                                row.createCell(1).setCellValue(leadNo);
                                row.createCell(2).setCellValue(buildName);
                                row.createCell(3).setCellValue(unitName);
                                row.createCell(4).setCellValue(bUnit);
                                row.createCell(5).setCellValue(offerDate);
                                row.createCell(6).setCellValue(fromDate);
                                row.createCell(7).setCellValue(toDate);
                                row.createCell(8).setCellValue(offerStatus);
                                row.createCell(9).setCellValue(subStatus);
                                row.createCell(10).setCellValue(unitStatus);
                                row.createCell(11).setCellValue(leadName);
                                row.createCell(12).setCellValue(mNo);
                                row.createCell(13).setCellValue(createdBy);
                                row.createCell(14).setCellValue(netRent);
                                row.createCell(15).setCellValue(setRent);
                                row.createCell(16).setCellValue(disValue);
                                row.createCell(17).setCellValue(taxAmt);
                                row.createCell(18).setCellValue(unitDescption);
                                row.createCell(19).setCellValue(offerFlag);
                                row.createCell(20).setCellValue(leaseNo);
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
