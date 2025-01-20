package view.backing;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditPoInvHdrBb {
    public AddEditPoInvHdrBb() {
        super();
    }
    ViewObject poInvHdrVo = ADFUtils.findIterator("PoInvHdr_VO1Iterator").getViewObject();

    public void doPoSave(ActionEvent actionEvent) {
        Row row = poInvHdrVo.getCurrentRow();//PoInvHdr_VO1Iterator
//        ViewObject getFuncodeVo = ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
//        getFuncodeVo.setNamedWhereClauseParam("F_ID", "POINV");
//        getFuncodeVo.executeQuery();
//        if(row.getAttribute("PoInvHdrNo")==null){
//            String poInvHdrId = row.getAttribute("PoInvHdrId")==null?"":row.getAttribute("PoInvHdrId").toString();
//            System.out.println("PoInvHdrId on save ::"+poInvHdrId);
//            row.setAttribute("WoInvHdrNo", "POINV-"+poInvHdrId); 
//            String name = xxfnd.generateDocNo("POINV", "WoInv_AMDataControl").toString();
//            row.setAttribute("FuncId", getFuncodeVo.first().getAttribute("FuncId"));
//        }
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Saved Successfully !!!");
    }

    public void doSlctPoSubTyp(ValueChangeEvent valueChangeEvent) {
        Row row = poInvHdrVo.getCurrentRow();
        String closedDate = row.getAttribute("ClosedDate")==null?"":row.getAttribute("ClosedDate").toString();
        System.out.println("closedDate :"+closedDate);
        String mnth = "";
        if (closedDate.substring(5, 7).equals("01")){
            mnth = "JAN";
        }else if (closedDate.substring(5, 7).equals("02")){
            mnth = "FEB";
        }
        else if (closedDate.substring(5, 7).equals("03")){
            mnth = "MAR";
        }
        else if (closedDate.substring(5, 7).equals("04")){
            mnth = "APR";
        }
        else if (closedDate.substring(5, 7).equals("05")){
            mnth = "MAY";
        }
        else if (closedDate.substring(5, 7).equals("06")){
            mnth = "JUN";
        }
        else if (closedDate.substring(5, 7).equals("07")){
            mnth = "JUL";
        }
        else if (closedDate.substring(5, 7).equals("08")){
            mnth = "AUG";
        }
        else if (closedDate.substring(5, 7).equals("09")){
            mnth = "SEP";
        }
        else if (closedDate.substring(5, 7).equals("10")){
            mnth = "OCT";
        }
        else if (closedDate.substring(5, 7).equals("11")){
            mnth = "NOV";
        }        
        else if (closedDate.substring(5, 7).equals("12")){
            mnth = "DEC";
        }
        String grpName = "81494/"+mnth+"/"+"2022";
        System.out.println("mnth :"+mnth);
        row.setAttribute("Attribute1", grpName);
    }
}
