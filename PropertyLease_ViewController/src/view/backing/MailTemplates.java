package view.backing;

import java.util.ArrayList;

import org.python.parser.ast.For;

public class MailTemplates {
    public MailTemplates() {
        super();
    }
    
    public static final String FromAddress="info@miskprops.com";
       public static final String FromAddressPassword="Baf65172";
       public static final String smtpPORT="smtp.office365.com";
      
       /**********************double quotes convert into single quotes*****************************************/

           public static String quotesReplace(String htmldata){
                   String out=htmldata.replace( "\"",  "'");
                   //StringBuilder builder = new StringBuilder("<html> <body>");
                   //builder.append(out);
                   //builder.append("</body> </html>");
                   ////System.err.println("----HTML BODY value---"+builder.toString());    
                   //return builder.toString();
                   //System.out.println("---Quotes Replace Output-----: "+out);
                   return out;
                   }
     
     /***************************************************************************************************/
      
      
       // Mail Tem 
       public static String submit(String canceldate, String unit, String building,String property,
                                  String customer,String cnNo,String proOrFinalStatus,String PorF_proReport,String F_finalReport){
           
           String Msg="<html>\n" + 
           "<head>\n" + 
           "<title>Page Title</title>\n" + 
           "</head>\n" + 
           "<body>\n" + 
           "\n" + 
           "<p>Dear "+customer+",</p>\n" + 
           "<p>The Cancellation Number "+cnNo+" has been Approved for "+proOrFinalStatus+" status for the below assets - </p>\n" + 
           "<p>   1.Property name - "+property+" </p>\n" +
           "<p>   2.Building name - "+building+" </p>\n" +
           "<p>   3.Unit Name - "+unit+" </p>\n" +
           "<p>The pdf report of this cancellation can be downloaded by clicking the below respective link -</p>\n" +
           "<p><a href="+PorF_proReport+" target='_blank'>For Proposed Report</a></p>\n" +
           "<p><a href="+F_finalReport+" target='_blank'>For Final Report</a></p>\n" +
           "<p>Thanks</p>\n" +
           "\n" + 
           "</body>\n" + 
           "</html>";
           String Html_Msg=quotesReplace(Msg);
           return Html_Msg;
       }
     
    // Mail for onSubmitForApr
    public static String onSubmitForAprTmplt(String propName, String buildName, ArrayList<String> unitNameAL, String userName, String tnxNo,
                                             String tnxName,String custName,String startDate,String endDate,String netRent,String pdfReport){
        
        String Msg="<html>\n" + 
        "<head>\n" + 
        "<title>Page Title</title>\n" + 
        "</head>\n" + 
        "<body style=\"background-color:AliceBlue;\">\n" + 
        "\n" + 
        "<p>Dear "+userName+",</p>\n" + 
        "\n" +
        "<p>Good Day !!!</p>\n" +    
        "\n" +
        "<p>The transaction Number "+tnxNo+" has been sent for your approval for the below assets - </p>\n" + 
//        "<p>   1.Property name - "+propName+" </p>\n" +
//        "<p>   2.Building name - "+buildName+" </p>\n" +
//        "<p>   3.Unit Name - "+unitNameAL+" </p>\n" +
        "<table style=\"border: 2px solid black;width: 100%;\">\n"+
          "<tr style=\"background-color:Yellow;\">\n"+
            "<th>"+tnxName+"</th>\n"+
            "<th>Customer Name</th>\n"+
            "<th>Building Name</th>\n"+
            "<th>Unit Name</th>\n"+
            "<th>Contract Start Date</th>\n"+
            "<th>Contract End Date</th>\n"+
            "<th>Net Rent</th>\n"+
          "</tr>\n"+
          "<tr style=\"background-color:LightGray;\">\n"+
            "<td>"+tnxNo+"</td>\n"+
            "<td>"+custName+"</td>\n"+
            "<td>"+buildName+"</td>\n"+
            "<td>"+unitNameAL+"</td>\n"+
            "<td>"+startDate+"</td>\n"+
            "<td>"+endDate+"</td>\n"+
            "<td>"+netRent+"</td>\n"+
          "</tr>\n"+
        "</table>\n"+
        "\n"+
        "<p><b>Download :</b> The pdf report of this transaction can be downloaded by clicking " +
        "<a href="+pdfReport+" target='_blank'>Here</a></p>"+
//        "<p><a href="+PorF_proReport+" target='_blank'>For Proposed Report</a></p>\n" +
//        "<p><a href="+F_finalReport+" target='_blank'>For Final Report</a></p>\n" +
        "\n"+
        "<p>Thanks,</p>\n" +
        "<p>Almisk</p>\n" +
        "\n" + 
        "</body>\n" + 
        "</html>";
        String Html_Msg=quotesReplace(Msg);
        return Html_Msg;
    }
    
    // Mail for onApproved
    public static String onApprovedTmplt(String propName, String buildName, ArrayList<String> unitNameAL, String userName, String tnxNo,
                                             String tnxName,String custName,String startDate,String endDate,String netRent,String pdfReport){
        
        String Msg="<html>\n" + 
        "<head>\n" + 
        "<title>Page Title</title>\n" + 
        "</head>\n" + 
        "<body style=\"background-color:AliceBlue;\">\n" + 
        "\n" + 
        "<p>Dear "+userName+",</p>\n" + 
        "\n" +
        "<p>Good Day !!!</p>\n" +    
        "\n" +
        "<p>The transaction Number "+tnxNo+" has been approved successfully for the below assets - </p>\n" + 
        //        "<p>   1.Property name - "+propName+" </p>\n" +
        //        "<p>   2.Building name - "+buildName+" </p>\n" +
        //        "<p>   3.Unit Name - "+unitNameAL+" </p>\n" +
        "<table style=\"border: 2px solid black;width: 100%;\">\n"+
          "<tr style=\"background-color:Yellow;\">\n"+
            "<th>"+tnxName+"</th>\n"+
            "<th>Customer Name</th>\n"+
            "<th>Building Name</th>\n"+
            "<th>Unit Name</th>\n"+
            "<th>Contract Start Date</th>\n"+
            "<th>Contract End Date</th>\n"+
            "<th>Net Rent</th>\n"+
          "</tr>\n"+
          "<tr style=\"background-color:LightGray;\">\n"+
            "<td>"+tnxNo+"</td>\n"+
            "<td>"+custName+"</td>\n"+
            "<td>"+buildName+"</td>\n"+
            "<td>"+unitNameAL+"</td>\n"+
            "<td>"+startDate+"</td>\n"+
            "<td>"+endDate+"</td>\n"+
            "<td>"+netRent+"</td>\n"+
          "</tr>\n"+
        "</table>\n"+
        "\n"+
        "<p><b>Download :</b> The pdf report of this transaction can be downloaded by clicking " +
        "<a href="+pdfReport+" target='_blank'>Here</a></p>"+
        //        "<p><a href="+PorF_proReport+" target='_blank'>For Proposed Report</a></p>\n" +
        //        "<p><a href="+F_finalReport+" target='_blank'>For Final Report</a></p>\n" +
        "\n"+
        "<p>Thanks,</p>\n" +
        "<p>Almisk</p>\n" +
        "\n" + 
        "</body>\n" + 
        "</html>";
        String Html_Msg=quotesReplace(Msg);
        return Html_Msg;
    }

}
