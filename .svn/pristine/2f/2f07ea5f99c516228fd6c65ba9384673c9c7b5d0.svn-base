package view.backing;

import java.io.InputStream;


import oracle.adf.view.rich.component.rich.data.RichTable;




import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.io.InputStream;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.myfaces.trinidad.model.CollectionModel;

import oracle.jbo.uicli.binding.JUCtrlHierBinding;


import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;


import org.apache.poi.ss.usermodel.Cell;

import util.ADFUtils;
import util.JSFUtils;


public class ExcelDataUpload {
    public ExcelDataUpload() {
        super();
    }
    
    
    public String uploadPriceList(InputStream xlsx, RichTable t1, ViewObject IdVo,ViewObject IdVo1,String pid, Object startDate, Object endDate, Object revDate,ViewObject lookUpCodeVO){
         org.apache.poi.ss.usermodel.Workbook workbook = null;
                        List<String> errorRows = new ArrayList<String>();
                        String rowNum=null;
                        int errorCount=0;
                String excelStatus = "N";
                int sheetIndex = 0;
                if (sheetIndex == 0) {
                    CollectionModel cModel = (CollectionModel)t1.getValue();
                    JUCtrlHierBinding tableBinding = (JUCtrlHierBinding)cModel.getWrappedData();
                    DCIteratorBinding iter = tableBinding.getDCIteratorBinding();
                    try {
                        workbook = WorkbookFactory.create(xlsx);
                    } catch (Exception e) {
                        System.err.println("Exception in Line Workbook : " + e);
                    }
                    org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(sheetIndex);
                    Integer skipRw = 1;
                    Integer skipcnt = 1;
                    int columnCount = 0;
                    Integer totalNumberofRows = 0;
                    System.out.println("Excel Total Number of Column ==>" + sheet.getRow(0).getLastCellNum());
                    System.out.println("---Excel Total Row Count ==>" + sheet.getLastRowNum());
                    //System.out.println("---Excel Total Row Count ==>"+sheet.getPhysicalNumberOfRows());
                    
                    totalNumberofRows = sheet.getLastRowNum();
                    System.out.println("--Total Number of Rows in excel sheet==>>" +totalNumberofRows);
                    //Iterate over excel rows
                    for (org.apache.poi.ss.usermodel.Row tempRow : sheet) {
                        //
                        Object propertyId=0;
                        Object buildiD=0;
                        if (skipcnt == 1) {
                            columnCount = tempRow.getPhysicalNumberOfCells();
                            System.err.println("==Column Count==>" + columnCount);
                        }
                        //skip first row and start from 2 row .3 row.4 row..5 row..?
                        if (skipcnt > skipRw) {
                            System.err.println("skipcnt---skipRw" + skipcnt + "---" +skipRw);
                            //Create new row in table
                            ADFUtils.findOperation("CreateInsert").execute();
                            System.err.println("New Line Adding");
                            oracle.jbo.Row linerow =iter.getNavigatableRowIterator().getCurrentRow();

                            int Index = 0;
                            //Iterate over (1 row's) columns
                            for (int column = 0; column < columnCount; column++) {
                                // Get column and it's cell
                                Cell MytempCell = tempRow.getCell(column);
                               
                                
                                if (MytempCell != null) {
                                    Index = MytempCell.getColumnIndex();
                                } else {
                                    //Index++;
                                }
                                // checking Index
                                try {
                                    
                                    if (Index == 0) {
                                        System.out.println("MytempCell0--->"+MytempCell);
                                        if (MytempCell != null) {
                                            Object id=0;
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                id=getId(IdVo, "PROPERTY_ID", "XXPL_PROPERTY_MASTER", "PROPERTY_NAME", MytempCell.getStringCellValue());
                                                propertyId=getId(IdVo, "PROPERTY_ID", "XXPL_PROPERTY_MASTER", "PROPERTY_NAME", MytempCell.getStringCellValue());
                                                if(id.equals(0)){
                                                     System.err.println("---Error---");   
                                                        if(rowNum==null){
                                                        rowNum="Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }else{
                                                        rowNum=rowNum+", Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                    }
                                                }else{
                                                    linerow.setAttribute("PlId",pid);    
                                                    linerow.setAttribute("PropertyId",id); 
                                                    linerow.setAttribute("StartDate",startDate);  
                                                    linerow.setAttribute("EndDate",endDate);  
                                                    linerow.setAttribute("RevisionDate",revDate);  
                                                    
                                                }
                                                break;
                                            case 0:
                                                id=getId(IdVo, "PROPERTY_ID", "XXPL_PROPERTY_MASTER", "PROPERTY_NAME", MytempCell.getStringCellValue());
                                                propertyId=getId(IdVo, "PROPERTY_ID", "XXPL_PROPERTY_MASTER", "PROPERTY_NAME", MytempCell.getStringCellValue());
                                                if(id.equals(0)){
                                                     System.err.println("---Error---");
                                                    if(rowNum==null){
                                                    rowNum="Row: "+(skipcnt-1);
                                                    errorCount=errorCount+1;
                                                    }else{
                                                    rowNum=rowNum+", Row: "+(skipcnt-1);
                                                    errorCount=errorCount+1;
                                                    }
                                                }else{
                                                    linerow.setAttribute("PlId",pid);    
                                                    linerow.setAttribute("PropertyId",id);    
                                                    linerow.setAttribute("StartDate",startDate);  
                                                    linerow.setAttribute("EndDate",endDate);  
                                                    linerow.setAttribute("RevisionDate",revDate);  
                                                }
                                             default : 
                                                System.err.println("---Error---");
                                                if(rowNum==null){
                                                rowNum="Row: "+(skipcnt-1);
                                                errorCount=errorCount+1;
                                                }else{
                                                rowNum=rowNum+", Row: "+(skipcnt-1);
                                                errorCount=errorCount+1;
                                                }
                                            }
                                            System.out.println("=Property ID=0==>" +linerow.getAttribute("PropertyId"));
                                        } else {
                                            System.err.println("!!!!!!!!!Property is blank!!!!!!!!!");
                                                 if(rowNum==null){
                                                 rowNum="Row: "+(skipcnt-1);
                                                 errorCount=errorCount+1;
                                                 }else{
                                                 rowNum=rowNum+", Row: "+(skipcnt-1);
                                                 errorCount=errorCount+1;
                                                 }
                                        }
                                    } else if (Index == 1) {
                                        System.out.println("MytempCell 1--->"+MytempCell);
                                        if (MytempCell != null) {
                                        Object id=0;
                                            switch (MytempCell.getCellType()) {
                                                case 1:
                                                    id=getId(IdVo, "BUILD_ID", "XXPL_PROPERTY_BUILDINGS", "BUILD_NAME", MytempCell.getStringCellValue());
                                                
                                                    buildiD=getId(IdVo, "BUILD_ID", "XXPL_PROPERTY_BUILDINGS", "BUILD_NAME", MytempCell.getStringCellValue());
                                                    if(id.equals(0)){
                                                         System.err.println("---Error---");   
                                                        if(rowNum==null){
                                                        rowNum="Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }else{
                                                        rowNum=rowNum+", Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }
                                                    }else{
                                                        linerow.setAttribute("BuildId",id);    
                                                    }
                                                    break;
                                                case 0:
                                                   id=getId(IdVo, "BUILD_ID", "XXPL_PROPERTY_BUILDINGS", "BUILD_NAME", MytempCell.getStringCellValue());
                                                buildiD=getId(IdVo, "BUILD_ID", "XXPL_PROPERTY_BUILDINGS", "BUILD_NAME", MytempCell.getStringCellValue());
                                                    if(id.equals(0)){
                                                         System.err.println("---Error---");  
                                                        if(rowNum==null){
                                                        rowNum="Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }else{
                                                        rowNum=rowNum+", Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }
                                                    }else{
                                                        linerow.setAttribute("BuildId",id);    
                                                    }
                                                default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }
                                            System.out.println("=building=0==>" +linerow.getAttribute("BuildId"));
                                        } else {
                                            System.err.println("!!!!!!!!!Building is blank!!!!!!!!!");
                                                                              if(rowNum==null){
                                                                              rowNum="Row: "+(skipcnt-1);
                                                                              errorCount=errorCount+1;
                                                                              }else{
                                                                              rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                              errorCount=errorCount+1;
                                                                              }
                                        }
                                    } else if (Index == 2) {
                                        System.out.println("MytempCell 2--->"+MytempCell);
                                        if (MytempCell != null) {
                                        Object id=0;
                                            switch (MytempCell.getCellType()) {
                                                case 1:
                                                    id=getunitId(IdVo1, "UNIT_ID", "XXPL_PROPERTY_UNITS", "UNIT_NAME", MytempCell.getStringCellValue(),propertyId,buildiD);
                                                
                                                    if(id.equals(0)){
                                                         System.out.println("---Error---");  
                                                            if(rowNum==null){
                                                            rowNum="Row: "+(skipcnt-1);
                                                            errorCount=errorCount+1;
                                                            }else{
                                                            rowNum=rowNum+", Row: "+(skipcnt-1);
                                                            errorCount=errorCount+1;
                                                            }
                                                    }else{
                                                        linerow.setAttribute("UnitId",id);    
                                                    }
                                                    break;
                                                case 0:
                                                    //id=getId(IdVo, "BUILD_ID", "XXPL_PROPERTY_BUILDINGS", "BUILD_NAME", MytempCell.getStringCellValue());
                                                    id=getunitId(IdVo1, "UNIT_ID", "XXPL_PROPERTY_UNITS", "UNIT_NAME", MytempCell.getStringCellValue(),propertyId,buildiD);                                                
                                                    if(id.equals(0)){
                                                         System.err.println("---Error---");   
                                                        if(rowNum==null){
                                                        rowNum="Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }else{
                                                        rowNum=rowNum+", Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }
                                                    }else{
                                                        linerow.setAttribute("UnitId",id);    
                                                    }
                                                default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }
                                            System.out.println("=unit=2==>" +linerow.getAttribute("UnitId"));
                                        } else {
                                            System.err.println("!!!!!!!!!unit is blank!!!!!!!!!");
                                                                                  if(rowNum==null){
                                                                                  rowNum="Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }else{
                                                                                  rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }
                                        }
                                    } else if (Index == 3) {
                                        System.out.println("MytempCell 3--->"+MytempCell);
                                        if (MytempCell != null) {
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("BasePrice",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("BasePrice",MytempCell.getNumericCellValue());
                                                break;
                                            default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }
                                            
                                            System.out.println("=base rate=3==>" +linerow.getAttribute("BasePrice"));
                                        } else {
                                            System.err.println("!!!!!!!!!BasePrice is blank!!!!!!!!!");
                                                                                  if(rowNum==null){
                                                                                  rowNum="Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }else{
                                                                                  rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }
                                        }
                                    } else if (Index == 4) {
                                        System.out.println("MytempCell 4--->"+MytempCell);
                                        if (MytempCell != null) {
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("MinPrice",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("MinPrice",MytempCell.getNumericCellValue());
                                                break;
                                            default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }

                                            System.out.println("=MinPrice=4==>" +linerow.getAttribute("MinPrice"));
                                        } else {
                                            System.err.println("!!!!!!!!!MinPrice is blank!!!!!!!!!");
                                                                                  if(rowNum==null){
                                                                                  rowNum="Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }else{
                                                                                  rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }
                                        }
                                    }else if (Index == 5) {
                                        System.out.println("MytempCell--5--->"+MytempCell);
                                        if (MytempCell != null) {
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("MunicipalityCharges",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("MunicipalityCharges",MytempCell.getNumericCellValue());
                                                break;
                                            default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }
                                            System.out.println("=MunicipalityCharges=5==>" +linerow.getAttribute("MunicipalityCharges"));
                                        } else {
                                            System.err.println("!!!!!!!!!MunicipalityCharges is blank!!!!!!!!!");
                                                                                  if(rowNum==null){
                                                                                  rowNum="Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }else{
                                                                                  rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }
                                        }
                                    }else if (Index == 6) {
                                        System.out.println("MytempCell-6--->"+MytempCell);
                                        if (MytempCell != null) {
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("ElectricityCharges",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("ElectricityCharges",MytempCell.getNumericCellValue());
                                                break;
                                            }
                                            System.out.println("=ElectricityCharges=3==>" +linerow.getAttribute("ElectricityCharges"));
                                        } else {
                                            System.err.println("!!!!!!!!!ElectricityCharges is blank!!!!!!!!!");
                                                                                  if(rowNum==null){
                                                                                  rowNum="Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }else{
                                                                                  rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }
                                        }
                                    }else if (Index == 13) {
                                        System.out.println("MytempCell-13--->"+MytempCell);
                                        if (MytempCell != null) {
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("MunicipalityPercentage",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                double perc = MytempCell.getNumericCellValue();
                                                System.out.println("Percentage %: "+perc);
                                                int percValue = (int) perc;
                                                System.out.println("Int Percentage: "+percValue);
                                                linerow.setAttribute("MunicipalityPercentage",percValue);
                                                break;
                                            }
                                            System.out.println("=MunicipalityPercentage=13==>" +linerow.getAttribute("MunicipalityPercentage"));
                                        } else {
                                            System.err.println("!!!!!!!!!MunicipalityPercentage is blank!!!!!!!!!");
                                                                                  if(rowNum==null){
                                                                                  rowNum="Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }else{
                                                                                  rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }
                                        }
                                    }
                                    else if (Index == 7) {
                                        System.out.println("MytempCell 7--->"+MytempCell);
                                        if (MytempCell != null) {
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("SecurityDeposite",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("SecurityDeposite",MytempCell.getNumericCellValue());
                                                break;
                                            default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }
                                            System.out.println("=SecurityDeposite=3==>" +linerow.getAttribute("SecurityDeposite"));
                                        } else {
                                            System.err.println("!!!!!!!!!SecurityDeposite is blank!!!!!!!!!");
                                                                                  if(rowNum==null){
                                                                                  rowNum="Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }else{
                                                                                  rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }
                                        }
                                        }else if (Index == 8) {
                                                                                System.out.println("MytempCell 8--->"+MytempCell);
                                                                                if (MytempCell != null) {
                                                                                    switch (MytempCell.getCellType()) {
                                                                                    case 1:
                                                                                        linerow.setAttribute("ThirdPartyServCharge",MytempCell.getStringCellValue());
                                                                                        break;
                                                                                    case 0:
                                                                                        linerow.setAttribute("ThirdPartyServCharge",MytempCell.getNumericCellValue());
                                                                                        break;
                                                                                    default : 
                                                                                           System.err.println("---Error---");
                                                                                           if(rowNum==null){
                                                                                           rowNum="Row: "+(skipcnt-1);
                                                                                           errorCount=errorCount+1;
                                                                                           }else{
                                                                                           rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                           errorCount=errorCount+1;
                                                                                           }
                                                                                    }
                                                                                    System.out.println("=ThirdPartyServCharge=8==>" +linerow.getAttribute("ThirdPartyServCharge"));
                                                                                } else {
                                                                                    System.err.println("!!!!!!!!!ThirdPartyServCharge is blank!!!!!!!!!");
                                                                                                                          if(rowNum==null){
                                                                                                                          rowNum="Row: "+(skipcnt-1);
                                                                                                                          errorCount=errorCount+1;
                                                                                                                          }else{
                                                                                                                          rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                                                          errorCount=errorCount+1;
                                                                                                                          }
                                                                                }
                                                                            }
                                        else if (Index == 9) {
                                                                                System.out.println("MytempCell 9--->"+MytempCell);
                                                                                if (MytempCell != null) {
                                                                                    switch (MytempCell.getCellType()) {
                                                                                    case 1:
                                                                                        linerow.setAttribute("OtherGovntChargeNew",MytempCell.getStringCellValue());
                                                                                        break;
                                                                                    case 0:
                                                                                        linerow.setAttribute("OtherGovntChargeNew",MytempCell.getNumericCellValue());
                                                                                        break;
                                                                                    default : 
                                                                                           System.err.println("---Error---");
                                                                                           if(rowNum==null){
                                                                                           rowNum="Row: "+(skipcnt-1);
                                                                                           errorCount=errorCount+1;
                                                                                           }else{
                                                                                           rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                           errorCount=errorCount+1;
                                                                                           }
                                                                                    }
                                                                                    System.out.println("=OtherGovntChargeNew=9==>" +linerow.getAttribute("OtherGovntChargeNew"));
                                                                                } else {
                                                                                    System.err.println("!!!!!!!!!OtherGovntChargeNew is blank!!!!!!!!!");
                                                                                                                          if(rowNum==null){
                                                                                                                          rowNum="Row: "+(skipcnt-1);
                                                                                                                          errorCount=errorCount+1;
                                                                                                                          }else{
                                                                                                                          rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                                                          errorCount=errorCount+1;
                                                                                                                          }
                                                                                }
                                                                            }
                                        else if (Index == 10) {
                                                                                System.out.println("MytempCell 10--->"+MytempCell);
                                                                                if (MytempCell != null) {
                                                                                    switch (MytempCell.getCellType()) {
                                                                                    case 1:
                                                                                        linerow.setAttribute("OtherGovntChargeRnew",MytempCell.getStringCellValue());
                                                                                        break;
                                                                                    case 0:
                                                                                        linerow.setAttribute("OtherGovntChargeRnew",MytempCell.getNumericCellValue());
                                                                                        break;
                                                                                    default : 
                                                                                           System.err.println("---Error---");
                                                                                           if(rowNum==null){
                                                                                           rowNum="Row: "+(skipcnt-1);
                                                                                           errorCount=errorCount+1;
                                                                                           }else{
                                                                                           rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                           errorCount=errorCount+1;
                                                                                           }
                                                                                    }
                                                                                    System.out.println("=OtherGovntChargeRnew=10==>" +linerow.getAttribute("OtherGovntChargeRnew"));
                                                                                } else {
                                                                                    System.err.println("!!!!!!!!!OtherGovntChargeRnew is blank!!!!!!!!!");
                                                                                                                          if(rowNum==null){
                                                                                                                          rowNum="Row: "+(skipcnt-1);
                                                                                                                          errorCount=errorCount+1;
                                                                                                                          }else{
                                                                                                                          rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                                                          errorCount=errorCount+1;
                                                                                                                          }
                                                                                }
                                                                            }
                                        else if (Index == 11) {
                                                                                System.out.println("MytempCell 11--->"+MytempCell);
                                                                                if (MytempCell != null) {
                                                                                    switch (MytempCell.getCellType()) {
                                                                                    case 1:
                                                                                        linerow.setAttribute("EjariPaymentCharge",MytempCell.getStringCellValue());
                                                                                        break;
                                                                                    case 0:
                                                                                        linerow.setAttribute("EjariPaymentCharge",MytempCell.getNumericCellValue());
                                                                                        break;
                                                                                    default : 
                                                                                           System.err.println("---Error---");
                                                                                           if(rowNum==null){
                                                                                           rowNum="Row: "+(skipcnt-1);
                                                                                           errorCount=errorCount+1;
                                                                                           }else{
                                                                                           rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                           errorCount=errorCount+1;
                                                                                           }
                                                                                    }
                                                                                    System.out.println("=EjariPaymentCharge=11==>" +linerow.getAttribute("EjariPaymentCharge"));
                                                                                } else {
                                                                                    System.err.println("!!!!!!!!!EjariPaymentCharge is blank!!!!!!!!!");
                                                                                                                          if(rowNum==null){
                                                                                                                          rowNum="Row: "+(skipcnt-1);
                                                                                                                          errorCount=errorCount+1;
                                                                                                                          }else{
                                                                                                                          rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                                                          errorCount=errorCount+1;
                                                                                                                          }
                                                                                }
                                                                            }
                                    else if (Index == 12) {
                                        System.out.println("MytempCell 12--->"+MytempCell);
                                        if (MytempCell != null) {
                                        Object id=0;
                                            switch (MytempCell.getCellType()) {
                                                case 1:
                                                    id=getLookUpCodeVO(lookUpCodeVO, MytempCell.getStringCellValue());
                                                    if(id.equals(0)){
                                                         System.err.println("---Error---");   
                                                        if(rowNum==null){
                                                        rowNum="Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }else{
                                                        rowNum=rowNum+", Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }
                                                    }else{
                                                        linerow.setAttribute("UnitType",id);    
                                                    }
                                                    break;
                                                case 0:
                                                id=getLookUpCodeVO(lookUpCodeVO, MytempCell.getStringCellValue());
                                                    if(id.equals(0)){
                                                         System.err.println("---Error---");   
                                                        if(rowNum==null){
                                                        rowNum="Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }else{
                                                        rowNum=rowNum+", Row: "+(skipcnt-1);
                                                        errorCount=errorCount+1;
                                                        }
                                                    }else{
                                                        linerow.setAttribute("UnitType",id);    
                                                    }
                                                break;
                                            default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }
                                            System.out.println("=UnitType=0==>" +linerow.getAttribute("UnitType"));
                                        } else {
                                            System.err.println("!!!!!!!!!UnitType is blank!!!!!!!!!");
                                                                              if(rowNum==null){
                                                                              rowNum="Row: "+(skipcnt-1);
                                                                              errorCount=errorCount+1;
                                                                              }else{
                                                                              rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                              errorCount=errorCount+1;
                                                                              }
                                        }
                                    }
                                    
                                    
                                    
                                    
                                    
                                    
                                    /*
                                    else if (Index==5){
                                        if(MytempCell!=null){
                                            System.err.println("MytempCell.getCellType()==>"+MytempCell.getCellType());
                                            java.util.Date date = MytempCell.getDateCellValue();
                                            System.err.println("Excel--Date==>"+date);
                                            DateFormat dateFormat =new SimpleDateFormat("MM/dd/yyyy");
                                            String date1 = dateFormat.format(date);
                                            System.err.println("String--Date==>"+date1);
                                            try {
                                                date = dateFormat.parse(date1);
                                                System.err.println("Parse--Date==>"+date);
                                            } catch (ParseException e) {
                                                }
                                            java.sql.Date sqlDate =new java.sql.Date(date.getTime());
                                            System.err.println("sql--Date==>"+sqlDate);
                                            oracle.jbo.domain.Date jboDate =new oracle.jbo.domain.Date(sqlDate);
                                            System.err.println("jbo--Date==>"+jboDate);
                                            linerow.setAttribute("StartDate",jboDate);
                                            System.out.println("Sdate-->"+linerow.getAttribute("StartDate"));
//                                          System.err.println("=StartDate=5==>" +linerow.getAttribute("StartDate"));
                                        }else{
                                            System.err.println("!!!!!!!!!StartDate is blank!!!!!!!!!");
                                            //                                      if(rowNum==null){
                                            //                                      rowNum="Row: "+skipcnt;
                                            //                                      errorCount=errorCount+1;
                                            //                                      }else{
                                            //                                      rowNum=rowNum+", Row: "+skipcnt;
                                            //                                      errorCount=errorCount+1;
                                            //                                      } 
                                        }
                                    } else if(Index==6){
                                        if(MytempCell!=null){
                                            System.err.println("MytempCell.getCellType()==>"+MytempCell.getCellType());
                                            java.util.Date date = MytempCell.getDateCellValue();
                                            System.err.println("Excel--Date==>"+date);
                                            DateFormat dateFormat =new SimpleDateFormat("MM/dd/yyyy");
                                            String date1 = dateFormat.format(date);
                                            System.err.println("String--Date==>"+date1);
                                            try {
                                                date = dateFormat.parse(date1);
                                                System.err.println("Parse--Date==>"+date);
                                            } catch (ParseException e) {
                                                }
                                            java.sql.Date sqlDate =new java.sql.Date(date.getTime());   
                                            System.err.println("sql--Date==>"+sqlDate);
                                            oracle.jbo.domain.Date jboDate =new oracle.jbo.domain.Date(sqlDate);
                                            System.err.println("jbo--Date==>"+jboDate);
                                            linerow.setAttribute("EndDate",jboDate);
                                            System.out.println("EndDate-->"+linerow.getAttribute("EndDate"));
//                                         linerow.setAttribute("EndDate",getExcelDate((Cell)MytempCell.getDateCellValue()));      
                                            System.err.println("=EndDate=5==>" +linerow.getAttribute("EndDate"));
                                        }else{
                                            System.err.println("!!!!!!!!!EndDate is blank!!!!!!!!!");
                                            //                                      if(rowNum==null){
                                            //                                      rowNum="Row: "+skipcnt;
                                            //                                      errorCount=errorCount+1;
                                            //                                      }else{
                                            //                                      rowNum=rowNum+", Row: "+skipcnt;
                                            //                                      errorCount=errorCount+1;
                                            //                                      } 
                                        } 
                                    }
//                                    else if (Index == 7) {
//                                        if (MytempCell != null) {
//                                            switch (MytempCell.getCellType()) {
//                                            case 1:
//                                                linerow.setAttribute("RevisionNo",MytempCell.getStringCellValue());
//                                                break;
//                                            case 0:
//                                                linerow.setAttribute("RevisionNo",MytempCell.getNumericCellValue());
//                                                break;
//                                            }
//
//                                            System.err.println("=RevisionNo=7==>" +linerow.getAttribute("RevisionNo"));
//                                        } else {
//                                            System.err.println("!!!!!!!!!RevisionNo is blank!!!!!!!!!");
//                                            //                                      if(rowNum==null){
//                                            //                                      rowNum="Row: "+skipcnt;
//                                            //                                      errorCount=errorCount+1;
//                                            //                                      }else{
//                                            //                                      rowNum=rowNum+", Row: "+skipcnt;
//                                            //                                      errorCount=errorCount+1;
//                                            //                                      }
//                                        }
//                                    }
                                    else if(Index==7){
                                        System.err.println("MytempCell.getCellType()==>"+MytempCell.getCellType());
                                        if(MytempCell!=null){
                                            java.util.Date date = MytempCell.getDateCellValue();
                                            System.err.println("Excel--Date==>"+date);
                                            DateFormat dateFormat =new SimpleDateFormat("MM/dd/yyyy");
                                            String date1 = dateFormat.format(date);
                                            System.err.println("String--Date==>"+date1);
                                            try {
                                                date = dateFormat.parse(date1);
                                                System.err.println("Parse--Date==>"+date);
                                            } catch (ParseException e) {
                                                }
                                            java.sql.Date sqlDate =new java.sql.Date(date.getTime());   
                                            System.err.println("sql--Date==>"+sqlDate);
                                            oracle.jbo.domain.Date jboDate =new oracle.jbo.domain.Date(sqlDate);
                                            System.err.println("jbo--Date==>"+jboDate);
                                            linerow.setAttribute("RevisionDate",jboDate);
                                            System.out.println("RevisionDate-->"+linerow.getAttribute("RevisionDate"));;
//                                          linerow.setAttribute("RevisionDate",getExcelDate((Cell)MytempCell.getDateCellValue()));   
                                            System.err.println("=RevisionDate=5==>" +linerow.getAttribute("RevisionDate"));
                                        }else{
                                            System.err.println("!!!!!!!!!RevisionDate is blank!!!!!!!!!");
                                            //                                      if(rowNum==null){
                                            //                                      rowNum="Row: "+skipcnt;
                                            //                                      errorCount=errorCount+1;
                                            //                                      }else{
                                            //                                      rowNum=rowNum+", Row: "+skipcnt;
                                            //                                      errorCount=errorCount+1;
                                            //                                      } 
                                        } 
                                    }
//                                      else if (Index == 8) {
//                                        if (MytempCell != null) {
//                                        System.err.println("MytempCell.getCellType()==>"+MytempCell.getCellType());
//                                            switch (MytempCell.getCellType()) {
//                                            case 1:
//                                                System.err.println("MytempCell.getStringCellValue()-->>"+MytempCell.getNumericCellValue());
//                                                linerow.setAttribute("RevisedBy",MytempCell.getStringCellValue());
//                                                break;
//                                            case 0:
//                                                linerow.setAttribute("RevisedBy",MytempCell.getNumericCellValue());
//                                                break;
//                                            }
//
//                                            System.err.println("=RevisedBy=9==>" +linerow.getAttribute("RevisedBy"));
//                                        } else {
//                                            System.err.println("!!!!!!!!!RevisedBy is blank!!!!!!!!!");
//                                            //                                      if(rowNum==null){
//                                            //                                      rowNum="Row: "+skipcnt;
//                                            //                                      errorCount=errorCount+1;
//                                            //                                      }else{
//                                            //                                      rowNum=rowNum+", Row: "+skipcnt;
//                                            //                                      errorCount=errorCount+1;
//                                            //                                      }
//                                        }
//                                    }
*/

                                } catch (Exception e) {
                                    System.err.println("Exception Occured at Line & column position is.... " +
                                                       Index);
                                    e.printStackTrace();
                                }
                                // one row completed
                            }
                            ////skip first n row for labels.
                        }

                                String errorStr=ADFContext.getCurrent().getSessionScope().get("error")==null?"":ADFContext.getCurrent().getSessionScope().get("error").toString();
                                if("error".equalsIgnoreCase(errorStr)){
                                    errorRows.add(skipcnt+",");
                               }
                        
                        if (totalNumberofRows >= skipcnt) {
                            skipcnt++;
                        }
                        System.err.println("Sheet ROW--" + skipcnt);
                    }
                            for (String temp : errorRows) {
                                System.out.println("Error ROw---"+temp);
                                JSFUtils.addFacesErrorMessage("Please provide correct values in Column "+temp);
                            }
                                if(errorCount!=0){
                                    JSFUtils.addFacesErrorMessage("Please provide correct values in "+rowNum+" in Excell");
                                }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
                    JSFUtils.addFacesInformationMessage("Line Added Successfully");
//                    ADFUtils.findOperation("Commit").execute();
                    excelStatus = "Y";
            }
        return excelStatus ;
    }
    
    public String uploadWoHdr(InputStream xlsx, RichTable t1){
         org.apache.poi.ss.usermodel.Workbook workbook = null;
                        List<String> errorRows = new ArrayList<String>();
                        String rowNum=null;
                        int errorCount=0;
                String excelStatus = "N";
                int sheetIndex = 0;
                if (sheetIndex == 0) {
                    CollectionModel cModel = (CollectionModel)t1.getValue();
                    JUCtrlHierBinding tableBinding = (JUCtrlHierBinding)cModel.getWrappedData();
                    DCIteratorBinding iter = tableBinding.getDCIteratorBinding();
                    try {
                        workbook = WorkbookFactory.create(xlsx);
                    } catch (Exception e) {
                        System.err.println("Exception in Line Workbook : " + e);
                    }
                    org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(sheetIndex);
                    Integer skipRw = 1;
                    Integer skipcnt = 1;
                    int columnCount = 0;
                    Integer totalNumberofRows = 0;
                    System.out.println("Excel Total Number of Column ==>" + sheet.getRow(0).getLastCellNum());
                    System.out.println("---Excel Total Row Count ==>" + sheet.getLastRowNum());
                    //System.out.println("---Excel Total Row Count ==>"+sheet.getPhysicalNumberOfRows());
                    
                    totalNumberofRows = sheet.getLastRowNum();
                    System.out.println("--Total Number of Rows in excel sheet==>>" +totalNumberofRows);
                    //Iterate over excel rows
                    for (org.apache.poi.ss.usermodel.Row tempRow : sheet) {
                        //
                        Object propertyId=1;
                        Object buildiD=1;
                        if (skipcnt == 1) {
                            columnCount = tempRow.getPhysicalNumberOfCells();
                            System.err.println("==Column Count==>" + columnCount);
                        }
                        //skip first row and start from 2 row .3 row.4 row..5 row..?
                        if (skipcnt > skipRw) {
                            System.err.println("skipcnt---skipRw" + skipcnt + "---" +skipRw);
                            //Create new row in table
                            ADFUtils.findOperation("CreateInsert").execute();
                            System.err.println("New Line Adding");
                            oracle.jbo.Row linerow =iter.getNavigatableRowIterator().getCurrentRow();

                            int Index = 0;
                            //Iterate over (1 row's) columns
                            for (int column = 0; column < columnCount; column++) {
                                // Get column and it's cell
                                Cell MytempCell = tempRow.getCell(column);
                               System.err.println("get cell no -->"+MytempCell);
                                
                                if (MytempCell != null) {
                                    Index = MytempCell.getColumnIndex();
                                } else {
                                    //Index++;
                                }
                                // checking Index
                                try {
                                    
                                    if (Index == 0) {
                                        System.out.println("MytempCell0--->"+MytempCell);
                                        if (MytempCell != null) {
                                            String woId="1";
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("WorkOrderId",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("WorkOrderId",MytempCell.getNumericCellValue());
                                                break;
                                             default : 
                                                System.err.println("---Error---");
                                                if(rowNum==null){
                                                rowNum="Row: "+(skipcnt-1);
                                                errorCount=errorCount+1;
                                                }else{
                                                rowNum=rowNum+", Row: "+(skipcnt-1);
                                                errorCount=errorCount+1;
                                                }
                                            }
                                            System.out.println("=Wo ID=0==>" +linerow.getAttribute("WorkOrderId"));
                                        } else {
                                            System.err.println("!!!!!!!!!Wo Id is blank!!!!!!!!!");
                                                 if(rowNum==null){
                                                 rowNum="Row: "+(skipcnt-1);
                                                 errorCount=errorCount+1;
                                                 }else{
                                                 rowNum=rowNum+", Row: "+(skipcnt-1);
                                                 errorCount=errorCount+1;
                                                 }
                                        }
                                    } else if (Index == 1) {
                                        System.out.println("MytempCell 1--->"+MytempCell);
                                        if (MytempCell != null) {
                                        Object woNo=1;
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("WorkOrder",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("WorkOrder",MytempCell.getNumericCellValue());
                                                break;
                                                default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }
                                            System.out.println("=WorkOrder=1==>" +linerow.getAttribute("WorkOrder"));
                                        } else {
                                            System.err.println("!!!!!!!!!Wo No is blank!!!!!!!!!");
                                                                              if(rowNum==null){
                                                                              rowNum="Row: "+(skipcnt-1);
                                                                              errorCount=errorCount+1;
                                                                              }else{
                                                                              rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                              errorCount=errorCount+1;
                                                                              }
                                        }
                                    } else if (Index == 2) {
                                        System.out.println("MytempCell 2--->"+MytempCell);
                                        if (MytempCell != null) {
                                        Object asset=1;
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("Asset",MytempCell.getStringCellValue());
                                                linerow.setAttribute("Item",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("Asset",MytempCell.getNumericCellValue());
                                                linerow.setAttribute("Item",MytempCell.getStringCellValue());
                                                break;
                                                default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }
                                            System.out.println("=Asset=2==>" +linerow.getAttribute("Asset"));
                                        } else {
                                            System.err.println("!!!!!!!!!Asset is blank!!!!!!!!!");
                                                                                  if(rowNum==null){
                                                                                  rowNum="Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }else{
                                                                                  rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                  errorCount=errorCount+1;
                                                                                  }
                                        }
                                                        } else if (Index == 3) {
                                                            System.out.println("MytempCell 3--->"+MytempCell);
                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("Type",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("Type",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=Type=3==>" +linerow.getAttribute("Type"));
                                                            } else {
                                                                System.err.println("!!!!!!!!!Type is blank!!!!!!!!!");
                                                                                                      if(rowNum==null){
                                                                                                      rowNum="Row: "+(skipcnt-1);
                                                                                                      errorCount=errorCount+1;
                                                                                                      }else{
                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                                      errorCount=errorCount+1;
                                                                                                      }
                                                            }
                                                        } else if (Index == 4) {
                                                            System.out.println("MytempCell 4--->"+MytempCell);
                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("Status",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("Status",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=Status=4==>" +linerow.getAttribute("Status"));
                                                            } else {
                                                                System.err.println("!!!!!!!!!Status is blank!!!!!!!!!");
                                                                                                      if(rowNum==null){
                                                                                                      rowNum="Row: "+(skipcnt-1);
                                                                                                      errorCount=errorCount+1;
                                                                                                      }else{
                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                                      errorCount=errorCount+1;
                                                                                                      }
                                                            }
                                                        } else if (Index == 5) {
                                                            System.out.println("MytempCell 5--->"+MytempCell);
                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("StartDate",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("StartDate",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=StartDate=5==>" +linerow.getAttribute("StartDate"));
                                                            } else {
                                                                System.err.println("!!!!!!!!!StartDate is blank!!!!!!!!!");
                                                                                                      if(rowNum==null){
                                                                                                      rowNum="Row: "+(skipcnt-1);
                                                                                                      errorCount=errorCount+1;
                                                                                                      }else{
                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                                      errorCount=errorCount+1;
                                                                                                      }
                                                            }
                                                        } else if (Index == 6) {
                                                            System.out.println("MytempCell 6--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("CompletionDate",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("CompletionDate",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=CompletionDate=6==>" +linerow.getAttribute("CompletionDate"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!CompletionDate is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 7) {
                                                            System.out.println("MytempCell 7--->"+MytempCell);
                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("ReleasedDate",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("ReleasedDate",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=ReleasedDate=7==>" +linerow.getAttribute("ReleasedDate"));
                                                            } else {
                                                                System.err.println("!!!!!!!!!ReleasedDate is blank!!!!!!!!!");
                                                                                                      if(rowNum==null){
                                                                                                      rowNum="Row: "+(skipcnt-1);
                                                                                                      errorCount=errorCount+1;
                                                                                                      }else{
                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                                                      errorCount=errorCount+1;
                                                                                                      }
                                                            }
                                                        } else if (Index == 8) {
                                                            System.out.println("MytempCell 8--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("ClosedDate",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("ClosedDate",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=ClosedDate=8==>" +linerow.getAttribute("ClosedDate"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!ClosedDate is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 9) {
                                                            System.out.println("MytempCell 9--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("BillableTo",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("BillableTo",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=BillableTo=9==>" +linerow.getAttribute("BillableTo"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!BillableTo is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            } 
                                                        } else if (Index == 10) {
                                                            System.out.println("MytempCell 10--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("DefaultSupplyType",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("DefaultSupplyType",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=DefaultSupplyType=10==>" +linerow.getAttribute("DefaultSupplyType"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!DefaultSupplyType is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 11) {
                                                            System.out.println("MytempCell 11--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("SubType",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("SubType",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=SubType=11==>" +linerow.getAttribute("SubType"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!SubType is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 12) {
                                                            System.out.println("MytempCell 12--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("ResourceCost",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("ResourceCost",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=ResourceCost=12==>" +linerow.getAttribute("ResourceCost"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!ResourceCost is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 13) {
                                                            System.out.println("MytempCell 13--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("MaterialCost",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("MaterialCost",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=MaterialCost=13==>" +linerow.getAttribute("MaterialCost"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!MaterialCost is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 14) {
                                                            System.out.println("MytempCell 14--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("BillableContractStatus",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("BillableContractStatus",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=BillableContractStatus=13==>" +linerow.getAttribute("BillableContractStatus"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!BillableContractStatus is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 15) {
                                                            System.out.println("MytempCell 15--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("LandlordName",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("LandlordName",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=LandlordName=15==>" +linerow.getAttribute("LandlordName"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!LandlordName is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 16) {
                                                            System.out.println("MytempCell 16--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("CreatedBy",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("CreatedBy",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=CreatedBy=16==>" +linerow.getAttribute("CreatedBy"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!CreatedBy is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 17) {
                                                            System.out.println("MytempCell 17--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("CreationDate",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("CreationDate",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=CreationDate=17==>" +linerow.getAttribute("CreationDate"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!CreationDate is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 18) {
                                                            System.out.println("MytempCell 18--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("LastUpdatedBy",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("LastUpdatedBy",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=LastUpdatedBy=18==>" +linerow.getAttribute("LastUpdatedBy"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!LastUpdatedBy is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 19) {
                                                            System.out.println("MytempCell 19--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("LastUpdateDate",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("LastUpdateDate",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=LastUpdateDate=19==>" +linerow.getAttribute("LastUpdateDate"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!LastUpdateDate is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                        
                                                    //else for if else cond
                                                    }else{
//                                                        linerow.setAttribute("Asset",asset);    
                                                    }
//                                                break;
                                                                    
                                } catch (Exception e) {
                                    System.err.println("Exception Occured at Line & column position is.... " + Index);
                                    e.printStackTrace();
                                }
                                // one row completed
                            }
                            ////skip first n row for labels.
                        }

                                String errorStr=ADFContext.getCurrent().getSessionScope().get("error")==null?"":ADFContext.getCurrent().getSessionScope().get("error").toString();
                                if("error".equalsIgnoreCase(errorStr)){
                                    errorRows.add(skipcnt+",");
                               }
                        
                        if (totalNumberofRows >= skipcnt) {
                            skipcnt++;
                        }
                        System.err.println("Sheet ROW--" + skipcnt);
                    }
                            for (String temp : errorRows) {
                                System.out.println("Error ROw---"+temp);
                                JSFUtils.addFacesErrorMessage("Please provide correct values in Column "+temp);
                            }
                                if(errorCount!=0){
                                    JSFUtils.addFacesErrorMessage("Please provide correct values in "+rowNum+" in Excell");
                                }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
                    JSFUtils.addFacesInformationMessage("WO Added Successfully");
    //                    ADFUtils.findOperation("Commit").execute();
                    excelStatus = "Y";
            }
        return excelStatus ;
    }   
    
    public String uploadWoOpResource(InputStream xlsx, RichTable t1){
         org.apache.poi.ss.usermodel.Workbook workbook = null;
                        List<String> errorRows = new ArrayList<String>();
                        String rowNum=null;
                        int errorCount=0;
                String excelStatus = "N";
                int sheetIndex = 0;
                if (sheetIndex == 0) {
                    CollectionModel cModel = (CollectionModel)t1.getValue();
                    JUCtrlHierBinding tableBinding = (JUCtrlHierBinding)cModel.getWrappedData();
                    DCIteratorBinding iter = tableBinding.getDCIteratorBinding();
                    try {
                        workbook = WorkbookFactory.create(xlsx);
                    } catch (Exception e) {
                        System.err.println("Exception in Line Workbook : " + e);
                    }
                    org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(sheetIndex);
                    Integer skipRw = 1;
                    Integer skipcnt = 1;
                    int columnCount = 0;
                    Integer totalNumberofRows = 0;
                    System.out.println("Excel Total Number of Column ==>" + sheet.getRow(0).getLastCellNum());
                    System.out.println("---Excel Total Row Count ==>" + sheet.getLastRowNum());
                    //System.out.println("---Excel Total Row Count ==>"+sheet.getPhysicalNumberOfRows());
                    
                    totalNumberofRows = sheet.getLastRowNum();
                    System.out.println("--Total Number of Rows in excel sheet==>>" +totalNumberofRows);
                    //Iterate over excel rows
                    for (org.apache.poi.ss.usermodel.Row tempRow : sheet) {
                        //
                        Object propertyId=1;
                        Object buildiD=1;
                        if (skipcnt == 1) {
                            columnCount = tempRow.getPhysicalNumberOfCells();
                            System.err.println("==Column Count==>" + columnCount);
                        }
                        //skip first row and start from 2 row .3 row.4 row..5 row..?
                        if (skipcnt > skipRw) {
                            System.err.println("skipcnt---skipRw" + skipcnt + "---" +skipRw);
                            //Create new row in table
                            ADFUtils.findOperation("CreateInsert1").execute();
                            System.err.println("New Line Adding");
                            oracle.jbo.Row linerow =iter.getNavigatableRowIterator().getCurrentRow();

                            int Index = 0;
                            //Iterate over (1 row's) columns
                            for (int column = 0; column < columnCount; column++) {
                                // Get column and it's cell
                                Cell MytempCell = tempRow.getCell(column);
                               System.err.println("get cell no -->"+MytempCell);
                                
                                if (MytempCell != null) {
                                    Index = MytempCell.getColumnIndex();
                                } else {
                                    //Index++;
                                }
                                // checking Index
                                try {
                                    
                                    if (Index == 0) {
                                        System.out.println("MytempCell0--->"+MytempCell);
//                                        if (MytempCell != null) {
                                            String woId="1";
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("BuildName",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("BuildName",MytempCell.getNumericCellValue());
                                                break;
                                             default : 
                                                System.err.println("---Error---");
                                                if(rowNum==null){
                                                rowNum="Row: "+(skipcnt-1);
                                                errorCount=errorCount+1;
                                                }else{
                                                rowNum=rowNum+", Row: "+(skipcnt-1);
                                                errorCount=errorCount+1;
                                                }
                                            }
                                            System.out.println("=BuildName=0==>" +linerow.getAttribute("BuildName"));
//                                        } else {
//                                            System.err.println("!!!!!!!!!BuildName is blank!!!!!!!!!");
//                                                 if(rowNum==null){
//                                                 rowNum="Row: "+(skipcnt-1);
//                                                 errorCount=errorCount+1;
//                                                 }else{
//                                                 rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                 errorCount=errorCount+1;
//                                                 }
//                                        }
                                    } else if (Index == 1) {
                                        System.out.println("MytempCell 1--->"+MytempCell);
                                        if (MytempCell != null) {
                                        Object woNo=1;
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("WorkOrderNumber",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("WorkOrderNumber",MytempCell.getNumericCellValue());
                                                break;
                                                default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }
                                            System.out.println("=WorkOrderNumber=1==>" +linerow.getAttribute("WorkOrderNumber"));
                                        } else {
                                            System.err.println("!!!!!!!!!WorkOrderNumber is blank!!!!!!!!!");
                                                                              if(rowNum==null){
                                                                              rowNum="Row: "+(skipcnt-1);
                                                                              errorCount=errorCount+1;
                                                                              }else{
                                                                              rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                              errorCount=errorCount+1;
                                                                              }
                                        }
                                    } else if (Index == 2) {
                                        System.out.println("MytempCell 2--->"+MytempCell);
//                                        if (MytempCell != null) {
                                        Object asset=1;
                                            switch (MytempCell.getCellType()) {
                                            case 1:
                                                linerow.setAttribute("RequiredUsage",MytempCell.getStringCellValue());
                                                break;
                                            case 0:
                                                linerow.setAttribute("RequiredUsage",MytempCell.getNumericCellValue());
                                                break;
                                                default : 
                                                   System.err.println("---Error---");
                                                   if(rowNum==null){
                                                   rowNum="Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }else{
                                                   rowNum=rowNum+", Row: "+(skipcnt-1);
                                                   errorCount=errorCount+1;
                                                   }
                                            }
                                            System.out.println("=RequiredUsage=2==>" +linerow.getAttribute("RequiredUsage"));
//                                        } else {
//                                            System.err.println("!!!!!!!!!RequiredUsage is blank!!!!!!!!!");
//                                                                                  if(rowNum==null){
//                                                                                  rowNum="Row: "+(skipcnt-1);
//                                                                                  errorCount=errorCount+1;
//                                                                                  }else{
//                                                                                  rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                  errorCount=errorCount+1;
//                                                                                  }
//                                        }
                                                        } else if (Index == 3) {
                                                            System.out.println("MytempCell 3--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("InverseRequiredUsage",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("InverseRequiredUsage",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=InverseRequiredUsage=3==>" +linerow.getAttribute("InverseRequiredUsage"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!InverseRequiredUsage is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 4) {
                                                            System.out.println("MytempCell 4--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("AssignedUnits",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("AssignedUnits",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=AssignedUnits=4==>" +linerow.getAttribute("AssignedUnits"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!AssignedUnits is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 5) {
                                                            System.out.println("MytempCell 5--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("ChargeType",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("ChargeType",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=ChargeType=5==>" +linerow.getAttribute("ChargeType"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!ChargeType is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 6) {
                                                            System.out.println("MytempCell 6--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("Scheduled",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("Scheduled",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=Scheduled=6==>" +linerow.getAttribute("Scheduled"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!CompletionDate is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 7) {
                                                            System.out.println("MytempCell 7--->"+MytempCell);
//                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("UomCode",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("UomCode",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=UomCode=7==>" +linerow.getAttribute("UomCode"));
//                                                            } else {
//                                                                System.err.println("!!!!!!!!!UomCode is blank!!!!!!!!!");
//                                                                                                      if(rowNum==null){
//                                                                                                      rowNum="Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }else{
//                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
//                                                                                                      errorCount=errorCount+1;
//                                                                                                      }
//                                                            }
                                                        } else if (Index == 8) {
                                                            System.out.println("MytempCell 8--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("Code",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("Code",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=Code=8==>" +linerow.getAttribute("Code"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!ClosedDate is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 9) {
                                                            System.out.println("MytempCell 9--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("UsageRate",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("UsageRate",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=UsageCode=9==>" +linerow.getAttribute("UsageRate"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!BillableTo is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 10) {
                                                            System.out.println("MytempCell 10--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("StartDate",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("StartDate",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=StartDate=10==>" +linerow.getAttribute("StartDate"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!DefaultSupplyType is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 11) {
                                                            System.out.println("MytempCell 11--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("CompletionDate",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("CompletionDate",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=CompletionDate=11==>" +linerow.getAttribute("CompletionDate"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!SubType is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 12) {
                                                            System.out.println("MytempCell 12--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("Name",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("Name",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=Name=12==>" +linerow.getAttribute("Name"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!ResourceCost is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 13) {
                                                            System.out.println("MytempCell 13--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("Description",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("Description",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=Description=13==>" +linerow.getAttribute("Description"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!MaterialCost is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 14) {
                                                            System.out.println("MytempCell 14--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("DescriptionCode",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("DescriptionCode",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=DescriptionCode=13==>" +linerow.getAttribute("DescriptionCode"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!BillableContractStatus is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 15) {
                                                            System.out.println("MytempCell 15--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("ResourceType",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("ResourceType",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=ResourceType=15==>" +linerow.getAttribute("ResourceType"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!LandlordName is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 16) {
                                                            System.out.println("MytempCell 16--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("ActualResourceUsage",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("ActualResourceUsage",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=ActualResourceUsage=16==>" +linerow.getAttribute("ActualResourceUsage"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!CreatedBy is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 17) {
                                                            System.out.println("MytempCell 17--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("Basis",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("Basis",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=Basis=17==>" +linerow.getAttribute("Basis"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!CreationDate is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 18) {
                                                            System.out.println("MytempCell 18--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("Activity",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("Activity",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=Activity=18==>" +linerow.getAttribute("Activity"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!LastUpdatedBy is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                                                        } else if (Index == 19) {
                                                            System.out.println("MytempCell 19--->"+MytempCell);
    //                                                            if (MytempCell != null) {
                                                            Object asset=1;
                                                                switch (MytempCell.getCellType()) {
                                                                case 1:
                                                                    linerow.setAttribute("ResourceId",MytempCell.getStringCellValue());
                                                                    break;
                                                                case 0:
                                                                    linerow.setAttribute("ResourceId",MytempCell.getNumericCellValue());
                                                                    break;
                                                                    default : 
                                                                       System.err.println("---Error---");
                                                                       if(rowNum==null){
                                                                       rowNum="Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }else{
                                                                       rowNum=rowNum+", Row: "+(skipcnt-1);
                                                                       errorCount=errorCount+1;
                                                                       }
                                                                }
                                                                System.out.println("=ResourceId=19==>" +linerow.getAttribute("ResourceId"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!LastUpdateDate is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
    } else if (Index == 20) {
        System.out.println("MytempCell 20--->"+MytempCell);
    //                                                            if (MytempCell != null) {
        Object asset=1;
            switch (MytempCell.getCellType()) {
            case 1:
                linerow.setAttribute("WoOperationId",MytempCell.getStringCellValue());
                break;
            case 0:
                linerow.setAttribute("WoOperationId",MytempCell.getNumericCellValue());
                break;
                default : 
                   System.err.println("---Error---");
                   if(rowNum==null){
                   rowNum="Row: "+(skipcnt-1);
                   errorCount=errorCount+1;
                   }else{
                   rowNum=rowNum+", Row: "+(skipcnt-1);
                   errorCount=errorCount+1;
                   }
            }
            System.out.println("=WoOperationId=20==>" +linerow.getAttribute("WoOperationId"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!LastUpdateDate is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
    } else if (Index == 21) {
        System.out.println("MytempCell 21--->"+MytempCell);
    //                                                            if (MytempCell != null) {
        Object asset=1;
            switch (MytempCell.getCellType()) {
            case 1:
                linerow.setAttribute("OperationSeqNumber",MytempCell.getStringCellValue());
                break;
            case 0:
                linerow.setAttribute("OperationSeqNumber",MytempCell.getNumericCellValue());
                break;
                default : 
                   System.err.println("---Error---");
                   if(rowNum==null){
                   rowNum="Row: "+(skipcnt-1);
                   errorCount=errorCount+1;
                   }else{
                   rowNum=rowNum+", Row: "+(skipcnt-1);
                   errorCount=errorCount+1;
                   }
            }
            System.out.println("=OperationSeqNumber=21==>" +linerow.getAttribute("OperationSeqNumber"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!LastUpdateDate is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
    } else if (Index == 22) {
        System.out.println("MytempCell 22--->"+MytempCell);
    //                                                            if (MytempCell != null) {
        Object asset=1;
            switch (MytempCell.getCellType()) {
            case 1:
                linerow.setAttribute("OperationName",MytempCell.getStringCellValue());
                break;
            case 0:
                linerow.setAttribute("OperationName",MytempCell.getNumericCellValue());
                break;
                default : 
                   System.err.println("---Error---");
                   if(rowNum==null){
                   rowNum="Row: "+(skipcnt-1);
                   errorCount=errorCount+1;
                   }else{
                   rowNum=rowNum+", Row: "+(skipcnt-1);
                   errorCount=errorCount+1;
                   }
            }
            System.out.println("=OperationName=22==>" +linerow.getAttribute("OperationName"));
    //                                                            } else {
    //                                                                System.err.println("!!!!!!!!!LastUpdateDate is blank!!!!!!!!!");
    //                                                                                                      if(rowNum==null){
    //                                                                                                      rowNum="Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }else{
    //                                                                                                      rowNum=rowNum+", Row: "+(skipcnt-1);
    //                                                                                                      errorCount=errorCount+1;
    //                                                                                                      }
    //                                                            }
                        
                                                    //else for if else cond
                                                    }else{
    //                                                        linerow.setAttribute("Asset",asset);
                                                    }
    //                                                break;
                                                                    
                                } catch (Exception e) {
                                    System.err.println("Exception Occured at Line & column position is.... " + Index);
                                    e.printStackTrace();
                                }
                                // one row completed
                            }
                            ////skip first n row for labels.
                        }

                                String errorStr=ADFContext.getCurrent().getSessionScope().get("error")==null?"":ADFContext.getCurrent().getSessionScope().get("error").toString();
                                if("error".equalsIgnoreCase(errorStr)){
                                    errorRows.add(skipcnt+",");
                               }
                        
                        if (totalNumberofRows >= skipcnt) {
                            skipcnt++;
                        }
                        System.err.println("Sheet ROW--" + skipcnt);
                    }
                            for (String temp : errorRows) {
                                System.out.println("Error ROw---"+temp);
                                JSFUtils.addFacesErrorMessage("Please provide correct values in Column "+temp);
                            }
                                if(errorCount!=0){
                                    JSFUtils.addFacesErrorMessage("Please provide correct values in "+rowNum+" in Excell");
                                }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
                    JSFUtils.addFacesInformationMessage("WO Added Successfully");
    //                    ADFUtils.findOperation("Commit").execute();
                    excelStatus = "Y";
            }
        return excelStatus ;
    }
    
    
    public oracle.jbo.domain.Date  getExcelDate(Cell getDateCellValue){
        oracle.jbo.domain.Date  jboDate=null;
        java.util.Date date = (Date)getDateCellValue;
        DateFormat dateFormat =new SimpleDateFormat("MM/dd/yyyy");
        String date1 = dateFormat.format(date);
        try {
            date = dateFormat.parse(date1);
        } catch (Exception e) {
        }
        java.sql.Date sqlDate =new java.sql.Date(date.getTime());
       jboDate =new oracle.jbo.domain.Date(sqlDate);
        return jboDate;
    }
    
    
    public Object getId(ViewObject IdVo, String SelectColumn,String tableName, String whereColumn, String getStringCellValue){
        Object ID=null;
        System.err.println("--"+SelectColumn);
        System.err.println("--"+tableName);
        System.err.println("--"+whereColumn);
        System.err.println("--"+getStringCellValue);
        IdVo.setNamedWhereClauseParam("BV_SELECT_COLUMN", SelectColumn);
        IdVo.setNamedWhereClauseParam("BV_TABLENAME", tableName);
        IdVo.setNamedWhereClauseParam("BV_WHERE_COLUMN", whereColumn);
        IdVo.setNamedWhereClauseParam("BV_VALUE", getStringCellValue);
        IdVo.executeQuery();
        ID=IdVo.first().getAttribute("Id")==null?0:IdVo.first().getAttribute("Id");
        return ID;
    }
    
    public Object getunitId(ViewObject IdVo, String SelectColumn,String tableName, String whereColumn, String getStringCellValue,Object propertyId ,Object BuildID){
        Object ID=null;
        System.err.println("--"+SelectColumn);
        System.err.println("--"+tableName);
        System.err.println("--"+whereColumn);
        System.err.println("--"+getStringCellValue);
        System.err.println("--"+getStringCellValue);
        System.err.println("--"+propertyId);
        System.err.println("--"+BuildID);
        
        
        IdVo.setNamedWhereClauseParam("p_column_name", SelectColumn);
        IdVo.setNamedWhereClauseParam("p_table_name", tableName);
        IdVo.setNamedWhereClauseParam("p_where_condtion", whereColumn);
        IdVo.setNamedWhereClauseParam("p_value", getStringCellValue);
        IdVo.setNamedWhereClauseParam("p_propertyId", propertyId);
        IdVo.setNamedWhereClauseParam("p_buildId", BuildID);
        IdVo.executeQuery();
        ID=IdVo.first().getAttribute("Id")==null?0:IdVo.first().getAttribute("Id");
        return ID;
    }
    
    
    
    
    
    
    public Object getLookUpCodeVO(ViewObject lookUpCodeVO, String getStringCellValue){
        Object lookUpCode=null;
        lookUpCodeVO.setNamedWhereClauseParam("BV_VALUE", getStringCellValue);
        lookUpCodeVO.executeQuery();
        lookUpCode=lookUpCodeVO.first().getAttribute("LookupValueName")==null?0:lookUpCodeVO.first().getAttribute("LookupValueName");
        return lookUpCode;
    }
    
    
    
    
}
