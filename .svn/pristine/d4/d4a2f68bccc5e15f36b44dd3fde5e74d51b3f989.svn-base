package view.backing;

import java.io.DataInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.RichTextString;

public class DownlaodExcel {
    public DownlaodExcel() {
        super();
    }
    
    
    

    public static void plTemplateDownlaod(FacesContext facesContext,OutputStream outputStream) {
            try {
                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("PriceListDetails");

                sheet.setColumnWidth(0, 3500);
                sheet.setColumnWidth(1, 6500);
                sheet.setColumnWidth(2, 3500);
                sheet.setColumnWidth(3, 3700);
                sheet.setColumnWidth(4, 3500);
                sheet.setColumnWidth(5, 3500);
                sheet.setColumnWidth(6, 3500);
                sheet.setColumnWidth(7, 3500);
                sheet.setColumnWidth(8, 3500);
                sheet.setColumnWidth(9, 3500);
                sheet.setColumnWidth(10, 3500);
                sheet.setColumnWidth(11, 3500);
                sheet.setColumnWidth(12, 3500);
                sheet.setColumnWidth(13, 3500);

                HSSFRow rowhead = sheet.createRow((short)0);

                CellStyle cellStyle = workbook.createCellStyle();
                CreationHelper createHelper = workbook.getCreationHelper();
                short dateFormat = createHelper.createDataFormat().getFormat("MM-dd-yyyy");
                cellStyle.setDataFormat(dateFormat);
                
                
                rowhead.createCell(0).setCellValue("Property Name");
                rowhead.createCell(1).setCellValue("Build Name");
                rowhead.createCell(2).setCellValue("Unit Name");
                rowhead.createCell(3).setCellValue("Base Price");
                rowhead.createCell(4).setCellValue("Min Price");
                rowhead.createCell(5).setCellValue("Municipality Charges");
                rowhead.createCell(6).setCellValue("Electricity Charges");
                rowhead.createCell(7).setCellValue("Security Deposite");
                rowhead.createCell(8).setCellValue("Third Party Charges");
                rowhead.createCell(9).setCellValue("Other Govnt Charges New");
                rowhead.createCell(10).setCellValue("Other Govnt Charges Renew");
                rowhead.createCell(11).setCellValue("Ejari Payment");
                rowhead.createCell(12).setCellValue("UnitType");
                rowhead.createCell(13).setCellValue("Municipality Percentage");
                
//                rowhead.createCell(5).setCellValue("Start Date");
//                rowhead.createCell(5).setCellValue(new Date());
//                rowhead.createCell(6).setCellValue("End Date");
//                cellStyle.setDataFormat((short)6);
//              rowhead.createCell(7).setCellValue("RevisionDate");
                sheet.createFreezePane(0, 1, 0, 1);

                workbook.write(outputStream);
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    //
    public static void woHdrTemplateDownlaod(FacesContext facesContext,OutputStream outputStream) {
            try {
                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("WO Header");

                sheet.setColumnWidth(0, 6500);
                sheet.setColumnWidth(1, 6500);
                sheet.setColumnWidth(2, 6500);
//                sheet.setColumnWidth(3, 3700);
//                sheet.setColumnWidth(4, 3500);
//                sheet.setColumnWidth(5, 3500);
//                sheet.setColumnWidth(6, 3500);
//                sheet.setColumnWidth(7, 3500);
//                sheet.setColumnWidth(8, 3500);
//                sheet.setColumnWidth(9, 3500);
//                sheet.setColumnWidth(10, 3500);
//                sheet.setColumnWidth(11, 3500);
//                sheet.setColumnWidth(12, 3500);
//                sheet.setColumnWidth(13, 3500);

                HSSFRow rowhead = sheet.createRow((short)0);

                CellStyle cellStyle = workbook.createCellStyle();
                CreationHelper createHelper = workbook.getCreationHelper();
                short dateFormat = createHelper.createDataFormat().getFormat("MM-dd-yyyy");
                cellStyle.setDataFormat(dateFormat);
                
                
                rowhead.createCell(0).setCellValue("WO ID");
                rowhead.createCell(1).setCellValue("WO Name");
                rowhead.createCell(2).setCellValue("Asset Name");
//                rowhead.createCell(3).setCellValue("Base Price");
//                rowhead.createCell(4).setCellValue("Min Price");
//                rowhead.createCell(5).setCellValue("Municipality Charges");
//                rowhead.createCell(6).setCellValue("Electricity Charges");
//                rowhead.createCell(7).setCellValue("Security Deposite");
//                rowhead.createCell(8).setCellValue("Third Party Charges");
//                rowhead.createCell(9).setCellValue("Other Govnt Charges New");
//                rowhead.createCell(10).setCellValue("Other Govnt Charges Renew");
//                rowhead.createCell(11).setCellValue("Ejari Payment");
//                rowhead.createCell(12).setCellValue("UnitType");
//                rowhead.createCell(13).setCellValue("Municipality Percentage");
                
    //                rowhead.createCell(5).setCellValue("Start Date");
    //                rowhead.createCell(5).setCellValue(new Date());
    //                rowhead.createCell(6).setCellValue("End Date");
    //                cellStyle.setDataFormat((short)6);
    //              rowhead.createCell(7).setCellValue("RevisionDate");
                //for making cell integer
//                sheet.createFreezePane(0, 1, 0, 1);

                workbook.write(outputStream);
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
