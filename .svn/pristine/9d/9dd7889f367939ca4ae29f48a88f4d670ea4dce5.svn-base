import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.ListIterator;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
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

public class MoveInMoveOut {
    private RichTable t1;
    private RichSelectOneChoice soc3;
    private RichTable t2;
    private RichTable t3;
    private RichPopup popup3;
    private RichInputText reason;

    public MoveInMoveOut() {
    }
    ViewObject MoveinOuthdrvo =
        ADFUtils.findIterator("MoveInOut_VO1Iterator").getViewObject();
    ViewObject PropertyMaster_VO1Iterator =
        ADFUtils.findIterator("PropertyMaster_VO1Iterator").getViewObject();

    ViewObject ApplianceVo1 =
        ADFUtils.findIterator("ApplianceDetails_VO1Iterator").getViewObject();

    ViewObject KeyVo1 =
        ADFUtils.findIterator("KeyDetails_VO1Iterator").getViewObject();

    ViewObject MeterVo1 =
        ADFUtils.findIterator("MeterReading_VO1Iterator").getViewObject();

    ViewObject ApplianceVo2 =
        ADFUtils.findIterator("ApplianceDetails_VO2Iterator").getViewObject();

    ViewObject KeyVo2 =
        ADFUtils.findIterator("KeyDetails_VO2Iterator").getViewObject();

    ViewObject MeterVo2 =
        ADFUtils.findIterator("MeterReading_VO2Iterator").getViewObject();

    ViewObject ApplianceVo3 =
        ADFUtils.findIterator("ApplianceDetails_VO3Iterator").getViewObject();

    ViewObject KeyVo3 =
        ADFUtils.findIterator("KeyDetails_VO3Iterator").getViewObject();

    ViewObject MeterVo3 =
        ADFUtils.findIterator("MeterReading_VO3Iterator").getViewObject();

    public Object getBuisnessUnit(Object PropertyId) {
        Object result = null;
        ViewCriteria offerDtlVC =
            PropertyMaster_VO1Iterator.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("PropertyId", PropertyId);
        offerDtlVC.addRow(offerDtlVCR);
        PropertyMaster_VO1Iterator.applyViewCriteria(offerDtlVC);
        PropertyMaster_VO1Iterator.executeQuery();
        Row re = PropertyMaster_VO1Iterator.first();
        if (PropertyMaster_VO1Iterator.getEstimatedRowCount() > 0) {
            result = re.getAttribute("OrgId");
        }


        return result;
    }


    public void onAttributesSave() {
        ViewObject getBookingDtl =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        ViewCriteria offerDtlVC = getBookingDtl.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("BookingId",
                                 MoveinOuthdrvo.getCurrentRow().getAttribute("BookingId"));
        offerDtlVC.addRow(offerDtlVCR);
        getBookingDtl.applyViewCriteria(offerDtlVC);
        //getBookingDtl.setNamedWhereClauseParam
        getBookingDtl.executeQuery();


        MoveinOuthdrvo.getCurrentRow().setAttribute("PropertyId",
                                                    getBookingDtl.first().getAttribute("PropertyId"));
        MoveinOuthdrvo.getCurrentRow().setAttribute("BuildingId",
                                                    getBookingDtl.first().getAttribute("BuildingId"));
        MoveinOuthdrvo.getCurrentRow().setAttribute("OrgId",
                                                    getBuisnessUnit(getBookingDtl.first().getAttribute("PropertyId")));


    }

    public void onClickSave(ActionEvent actionEvent) {
        // Add event code here...
        
        Object leaseNo=JSFUtils.resolveExpression("#{bindings.CancelNo_Trans.inputValue}");
        String smoveout=ADFContext.getCurrent().getSessionScope().get("moveInOut").toString();
        if(smoveout.equalsIgnoreCase("O") && leaseNo==null)
        {
           JSFUtils.addFacesErrorMessage("Please select Final and Approved Cancelation Lease No");
        }
        else{
            ViewObject getFuncodeVo = ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                    getFuncodeVo.setNamedWhereClauseParam("F_ID", "MI");
                    getFuncodeVo.executeQuery();
                    Object Funcode = getFuncodeVo.first().getAttribute("FuncId");
                    String Fcode = Funcode == null ? "" : Funcode.toString();
                    ViewObject OfferHdrVo =ADFUtils.findIterator("MoveInOut_VO1Iterator").getViewObject();
                    Row re = OfferHdrVo.getCurrentRow();
            
                    // ViewObject Property=ADFUtils.findIterator("PropertyBuildings_VO1Iterator").getViewObject();
                    //  Row re=Property.getCurrentRow();
                    if (re.getAttribute("MoveInOutNumber") == null) {
                        String name =
                            xxfnd.generateDocNo("MI", "MoveInOut_AMDataControl").toString();
                        Object valu = name;
            
                        re.setAttribute("MoveInOutNumber", valu);
                        re.setAttribute("FuncId",
                                        getFuncodeVo.first().getAttribute("FuncId"));
            
                    }
                    onAttributesSave();
                    ADFUtils.findOperation("Commit").execute();
        }
//       
    }

    public void onClickAttachments(ActionEvent actionEvent) {
        ViewObject vo =
            ADFUtils.findIterator("MoveInOut_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        JSFUtils.setExpressionValue("#{pageFlowScope.movefunid}", 1);
        JSFUtils.setExpressionValue("#{pageFlowScope.moveinfunrefid}",
                                    row.getAttribute("MoveInOutId"));
    }

    public void onClickSubmit(ActionEvent actionEvent) {
        // Add event code here...

        onClickSave(actionEvent);
        String ResultVal = null;
        ViewObject vo =ADFUtils.findIterator("MoveInOut_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        Object org = vo.getCurrentRow().getAttribute("OrgId");
        Object prop = vo.getCurrentRow().getAttribute("PropertyId");
        Object unit = vo.getCurrentRow().getAttribute("BuildingId");
        //----CANCELLATION VALIDATION--//
        
        String scope=ADFContext.getCurrent().getSessionScope().get("moveInOut")==null?"x":ADFContext.getCurrent().getSessionScope().get("moveInOut").toString();
                                 if(scope.equalsIgnoreCase("O")){
                          ViewObject cancelvo=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
                                         ViewObject mimovo=ADFUtils.findIterator("MoveInOut_VO1Iterator").getViewObject();
                                         Row r=mimovo.getCurrentRow();
                                         System.err.println("Print"+r.getAttribute("LeaseAgreementId"));
                                      String l=r.getAttribute("LeaseAgreementId")==null?"l":r.getAttribute("LeaseAgreementId").toString();
                                                 ViewCriteria vc=cancelvo.createViewCriteria();
                                                 ViewCriteriaRow vcr=vc.createViewCriteriaRow();
                                                 vcr.setAttribute("LeaseAgreementId",r.getAttribute("LeaseAgreementId"));
                                                 vc.addRow(vcr);
                                                  cancelvo.applyViewCriteria(vc);
                                                  cancelvo.executeQuery();
                                         System.err.println("row count"+cancelvo.getEstimatedRowCount());
                                         RowSetIterator itr=cancelvo.createRowSetIterator(null);
                                         while(itr.hasNext())
                                         {
                                            Row crow=itr.next();
                                             String pfs=crow.getAttribute("ProposeFinalStatus")==null?"":crow.getAttribute("ProposeFinalStatus").toString();
                                                if(pfs.equalsIgnoreCase("Final"))
                                        {
                                            try {
                                                ResultVal =
                                                        xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
                                                                              row.getAttribute("FuncId"),
                                                                              row.getAttribute("MoveInOutId"), 0,
                                                                              "XXPM_MOVE_IN_OUT", "STATUS",
                                                                              "MOVE_IN_OUT_ID", org, prop, unit,
                                                                              null, null);


                                            } catch (SQLException e) {
                                            }

                                            if (ResultVal.equalsIgnoreCase("Success")) {
                                                ADFUtils.findOperation("Commit").execute();
                                                JSFUtils.addFacesInformationMessage("Submitted For Approval");
                                            } else {
                                                JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
                                            }                                            
                                        }
                                             else
                                            {
                                                    JSFUtils.addFacesInformationMessage("Please change cancellation to final mode");
                                            }
                                         }
                                 }
        
        //----------------------------//
      
    }

    public void onClickApprove(ActionEvent actionEvent) {
        // Add event code here...
        String ResultVal = null;
       String scope=null;
        String a=null;
       String l=null;
        int count=0;
        ViewObject vo =
            ADFUtils.findIterator("MoveInOut_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Approved" : this.reason.getValue().toString();


//          count++;

        try {
            ResultVal =
                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
                                            row.getAttribute("FuncId"),
                                            row.getAttribute("MoveInOutId"),
                                            row.getAttribute("UserGrpId"),
                                            row.getAttribute("FlowLevel"),
                                            row.getAttribute("FlowWith"),
                                           Reason, "A", 0,
                                            "XXPM_MOVE_IN_OUT", "STATUS",
                                            "MOVE_IN_OUT_ID");
//            count++;
            if (ResultVal.equalsIgnoreCase("Success")) {
//            count++;
//                vo.executeQuery();//error code
                JSFUtils.addFacesInformationMessage("Approved Successfully");
                
                //set cancellation vo
                
                scope=ADFContext.getCurrent().getSessionScope().get("moveInOut")==null?"x":ADFContext.getCurrent().getSessionScope().get("moveInOut").toString();
                           if(scope.equalsIgnoreCase("O")){
//                               count++;
                                   ViewObject cancelvo=ADFUtils.findIterator("Cancellation_VO1Iterator").getViewObject();
                                   ViewObject mimovo=ADFUtils.findIterator("MoveInOut_VO1Iterator").getViewObject();
                                   Row r=mimovo.getCurrentRow();
                                   System.err.println("Print"+r.getAttribute("LeaseAgreementId"));
                                   l=r.getAttribute("LeaseAgreementId")==null?"l":r.getAttribute("LeaseAgreementId").toString();
                                           ViewCriteria vc=cancelvo.createViewCriteria();
                                           ViewCriteriaRow vcr=vc.createViewCriteriaRow();
                                           vcr.setAttribute("LeaseAgreementId",r.getAttribute("LeaseAgreementId"));
                                           vc.addRow(vcr);
                                            cancelvo.applyViewCriteria(vc);
                                            cancelvo.executeQuery();
                                   System.err.println("row count"+cancelvo.getEstimatedRowCount());
                                   RowSetIterator itr=cancelvo.createRowSetIterator(null);
                                   while(itr.hasNext())
                                   {
                                      Row crow=itr.next();
                                       String pfs=crow.getAttribute("ProposeFinalStatus")==null?"":crow.getAttribute("ProposeFinalStatus").toString();
                                                                              if(pfs.equalsIgnoreCase("Final"))
                                                                              {
                                                                             crow.setAttribute("Attribute10","Y");
                                                                              }
                                   // System.err.println("--"+crow.getAttribute("CancelId"));
                                      
                                 
                                   }
                                   itr.closeRowSetIterator(); 
                               ADFUtils.findOperation("Commit").execute();
                               }
//                count++;
                
            } else {
                JSFUtils.addFacesErrorMessage("Error in Approve process!");
            }
//            a=String.valueOf(count);
//           
//            JSFUtils.addFacesErrorMessage(a+"-----"+scope+"-----------"+l);

        } catch (SQLException e) {
//            String error=e.toString();
//            JSFUtils.addFacesErrorMessage("error"+error);
//            JSFUtils.addFacesErrorMessage(a+"-----"+scope+"-----------"+l);
        }
        
        
    }

    public void onClickReject(ActionEvent actionEvent) {
        // Add event code here...
        String ResultVal = null;
        ViewObject vo =
            ADFUtils.findIterator("MoveInOut_VO1Iterator").getViewObject();
        Row row = vo.getCurrentRow();
        String Reason =
            this.reason.getValue() == null ? "Rejected" : this.reason.getValue().toString();

        try {
            ResultVal =
                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
                                            row.getAttribute("FuncId"),
                                            row.getAttribute("MoveInOutId"),
                                            row.getAttribute("UserGrpId"),
                                            row.getAttribute("FlowLevel"),
                                            row.getAttribute("FlowWith"),
                                           Reason, "R", 0,
                                            "XXPM_MOVE_IN_OUT", "STATUS",
                                            "MOVE_IN_OUT_ID");


        } catch (SQLException e) {
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            vo.executeQuery();
            JSFUtils.addFacesInformationMessage("Rejected Successfully");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Approve process!");
        }
    }

    public void onClickCancel(ActionEvent actionEvent) {
//        ADFUtils.findOperation("Rollback").execute();
    }

    public void moveOutVCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        String smoveout=ADFContext.getCurrent().getSessionScope().get("moveInOut").toString();
                       if(smoveout.equalsIgnoreCase("O")){
        ViewObject Vo =
            ADFUtils.findIterator("MoveInOut_VO1Iterator").getViewObject();
        Object vclID =
            Vo.getCurrentRow().getAttribute("LeaseAgreementId").toString();
        ViewObject mInOutVo1 =
            ADFUtils.findIterator("MoveInOut_VO1Iterator").getViewObject();
        Object mId =
            mInOutVo1.getCurrentRow().getAttribute("LeaseAgreementId");

        Object outputofSetProp =
            JSFUtils.resolveExpression("#{pageFlowScope.Move}")==null?"":JSFUtils.resolveExpression("#{pageFlowScope.Move}");
        if (outputofSetProp.equals("MOUT")) {

            ViewObject mInOutVo4 =
                ADFUtils.findIterator("MoveInOut_VO4Iterator").getViewObject();
            ViewCriteria vc = mInOutVo4.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("LeaseAgreementId", vclID);
            //                               valueChangeEvent.getNewValue());
            vc.addRow(vcRow);
            mInOutVo4.applyViewCriteria(vc);
            mInOutVo4.executeQuery();
             
            //***********************Appliance View Criteria************************//
            System.err.println("IIII"+mInOutVo4.getEstimatedRowCount());
            Long count=mInOutVo4.getEstimatedRowCount();
            String moveid=count.toString();
            if(moveid.equalsIgnoreCase("0")){
                JSFUtils.addFacesErrorMessage("Please create Move In");
                }
            else{
            ViewCriteria vc3 = ApplianceVo3.createViewCriteria();
            ViewCriteriaRow vcRow3 = vc3.createViewCriteriaRow();
            vcRow3.setAttribute("MoveInOutId",
                                mInOutVo4.first().getAttribute("MoveInOutId"));
            vc3.addRow(vcRow3);
            ApplianceVo3.applyViewCriteria(vc3);
            ApplianceVo3.executeQuery();

            RowSetIterator applianceRS =
                ApplianceVo3.createRowSetIterator(null);
            while (applianceRS.hasNext()) {
                Row appRow3 = applianceRS.next();
                Row appRow1 = ApplianceVo1.createRow();
                appRow1.setAttribute("ItemCode",
                                     appRow3.getAttribute("ItemCode"));
                appRow1.setAttribute("Description",
                                     appRow3.getAttribute("Description"));
                appRow1.setAttribute("Status", appRow3.getAttribute("Status"));

                ApplianceVo1.insertRow(appRow1);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            ApplianceVo1.executeQuery();
            //***********************Key View Criteria************************//

            ViewCriteria keyVC3 = KeyVo3.createViewCriteria();
            ViewCriteriaRow keyVCRow3 = keyVC3.createViewCriteriaRow();
            keyVCRow3.setAttribute("MoveInOutId",
                                   mInOutVo4.first().getAttribute("MoveInOutId"));
            keyVC3.addRow(keyVCRow3);
            KeyVo3.applyViewCriteria(keyVC3);
            KeyVo3.executeQuery();

            RowSetIterator keyRS = KeyVo3.createRowSetIterator(null);
            System.err.println("ROW COUNT KEY LINES " +
                               KeyVo3.getEstimatedRowCount());

            while (keyRS.hasNext()) {
                Row keyRow3 = keyRS.next();
                Row keyRow1 = KeyVo1.createRow();

                keyRow1.setAttribute("KeyCode",
                                     keyRow3.getAttribute("KeyCode"));
                keyRow1.setAttribute("Description",
                                     keyRow3.getAttribute("Description"));
                keyRow1.setAttribute("Status", keyRow3.getAttribute("Status"));
                KeyVo1.insertRow(keyRow1);

            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
            KeyVo1.executeQuery();
            //***********************Meter View Criteria************************//

            ViewCriteria meterVC3 = MeterVo3.createViewCriteria();
            ViewCriteriaRow meterVCRow3 = meterVC3.createViewCriteriaRow();
            meterVCRow3.setAttribute("MoveInOutId",
                                     mInOutVo4.first().getAttribute("MoveInOutId"));
            meterVC3.addRow(meterVCRow3);
            MeterVo3.applyViewCriteria(meterVC3);
            MeterVo3.executeQuery();

            RowSetIterator meterRS = MeterVo3.createRowSetIterator(null);
            System.err.println("ROW COUNT METER LINES " +
                               MeterVo3.getEstimatedRowCount());

            while (meterRS.hasNext()) {
                Row meterRow3 = meterRS.next();
                Row meterRow1 = MeterVo1.createRow();


                meterRow1.setAttribute("MeterCode",
                                       meterRow3.getAttribute("MeterCode"));
                meterRow1.setAttribute("MeterValue",
                                       meterRow3.getAttribute("MeterValue"));
                meterRow1.setAttribute("Description",
                                       meterRow3.getAttribute("Description"));
                meterRow1.setAttribute("Status",
                                       meterRow3.getAttribute("Status"));
                MeterVo1.insertRow(meterRow1);

            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
            MeterVo1.executeQuery();
            }//end of move in validation
        }
                       }//end of move out

    }//end of method

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }

    public void onClickSync(ActionEvent actionEvent) {
        try {
            ArrayList appliances = new ArrayList();
            ArrayList lookup = new ArrayList();
            //ArrayList newDataList=new ArrayList();

            ViewObject UserVO =
                ADFUtils.findIterator("ApplianceDetails_VO1Iterator").getViewObject();

            Row userIdrow = UserVO.getCurrentRow();
            Object Userid = userIdrow.getAttribute("MoveInOutId");

            ViewCriteria vc = UserVO.createViewCriteria();
            ViewCriteriaRow viewrow = vc.createViewCriteriaRow();
            viewrow.setAttribute("MoveInOutId", Userid);
            vc.addRow(viewrow);
            UserVO.applyViewCriteria(vc);
            UserVO.executeQuery();
            Row rows = UserVO.first();
            RowSetIterator rs = UserVO.createRowSet("");
            while (rs.hasNext()) {
                rows = rs.next();
                String str = rows.getAttribute("ItemCode").toString();
                appliances.add(str);

            }
            System.out.println("KeyList" + appliances);
            System.out.println("keyListSize" + appliances.size());

            //list from SubMenuROVO
            ViewObject Menu =
                ADFUtils.findIterator("Lookup_View_ROVO4Iterator").getViewObject();


            ViewCriteria vc1 = Menu.createViewCriteria();
            ViewCriteriaRow viewrow1 = vc1.createViewCriteriaRow();
            viewrow1.setAttribute("LookupTypeName", "APPLIANCES");
            vc1.addRow(viewrow1);
            Menu.applyViewCriteria(vc1);
            Menu.executeQuery();

            RowSetIterator menuRow = Menu.createRowSetIterator("");
            while (menuRow.hasNext()) {
                Row re = menuRow.next();
                lookup.add(re.getAttribute("LookupValueName"));
                System.err.println("LOOK UP VALUE" +
                                   re.getAttribute("LookupValueName"));
            }
            System.out.println("ROVOMENU" + lookup.size());
            lookup.removeAll(appliances);
            System.out.println("Result" + lookup);
            System.out.println("Result" + lookup.size());

            if (lookup.size() == 0) {
                JSFUtils.addFacesInformationMessage("No Record to Synchronize");

            } else {
                ListIterator li = lookup.listIterator();
                while (li.hasNext()) {
                    Object str = li.next();
                    System.err.println("insertData" + str);

                    Row createRow = UserVO.createRow();
                    createRow.setAttribute("MoveInOutId", Userid);
                    createRow.setAttribute("ItemCode", str);
                    UserVO.insertRow(createRow);
                    UserVO.executeQuery();
                }
                JSFUtils.addFacesInformationMessage("Record synchronized Successfully!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickKeySync(ActionEvent actionEvent) {
        try {
            ArrayList key = new ArrayList();
            ArrayList lookup = new ArrayList();
            //ArrayList newDataList=new ArrayList();

            ViewObject UserVO =
                ADFUtils.findIterator("KeyDetails_VO1Iterator").getViewObject();

            Row userIdrow = UserVO.getCurrentRow();
            Object Userid = userIdrow.getAttribute("MoveInOutId");

            ViewCriteria vc = UserVO.createViewCriteria();
            ViewCriteriaRow viewrow = vc.createViewCriteriaRow();
            viewrow.setAttribute("MoveInOutId", Userid);
            vc.addRow(viewrow);
            UserVO.applyViewCriteria(vc);
            UserVO.executeQuery();
            Row rows = UserVO.first();
            RowSetIterator rs = UserVO.createRowSet("");
            while (rs.hasNext()) {
                rows = rs.next();
                String str = rows.getAttribute("KeyCode").toString();
                key.add(str);

            }
            System.out.println("ApplianceList" + key);
            System.out.println("ApplianceListSize" + key.size());

            //list from SubMenuROVO
            ViewObject Menu =
                ADFUtils.findIterator("Lookup_View_ROVO4Iterator").getViewObject();


            ViewCriteria vc1 = Menu.createViewCriteria();
            ViewCriteriaRow viewrow1 = vc1.createViewCriteriaRow();
            viewrow1.setAttribute("LookupTypeName", "HANDOVER_KEYS");
            vc1.addRow(viewrow1);
            Menu.applyViewCriteria(vc1);
            Menu.executeQuery();

            RowSetIterator menuRow = Menu.createRowSetIterator("");
            while (menuRow.hasNext()) {
                Row re = menuRow.next();
                lookup.add(re.getAttribute("LookupValueName"));
                System.err.println("LOOK UP VALUE" +
                                   re.getAttribute("LookupValueName"));
            }
            System.out.println("ROVOMENU" + lookup.size());
            lookup.removeAll(key);
            System.out.println("Result" + lookup);
            System.out.println("Result" + lookup.size());

            if (lookup.size() == 0) {
                JSFUtils.addFacesInformationMessage("No Record to Synchronize");

            } else {
                ListIterator li = lookup.listIterator();
                while (li.hasNext()) {
                    Object str = li.next();
                    System.err.println("insertData" + str);

                    Row createRow = UserVO.createRow();
                    createRow.setAttribute("MoveInOutId", Userid);
                    createRow.setAttribute("KeyCode", str);
                    UserVO.insertRow(createRow);
                    UserVO.executeQuery();
                }
                JSFUtils.addFacesInformationMessage("Record synchronized Successfully!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickMeterReadingListSync(ActionEvent actionEvent) {
        try {
            ArrayList meterReadingList = new ArrayList();
            ArrayList lookup = new ArrayList();
            //ArrayList newDataList=new ArrayList();

            ViewObject UserVO =
                ADFUtils.findIterator("MeterReading_VO1Iterator").getViewObject();

            Row userIdrow = UserVO.getCurrentRow();
            Object Userid = userIdrow.getAttribute("MoveInOutId");

            ViewCriteria vc = UserVO.createViewCriteria();
            ViewCriteriaRow viewrow = vc.createViewCriteriaRow();
            viewrow.setAttribute("MoveInOutId", Userid);
            vc.addRow(viewrow);
            UserVO.applyViewCriteria(vc);
            UserVO.executeQuery();
            Row rows = UserVO.first();
            RowSetIterator rs = UserVO.createRowSet("");
            while (rs.hasNext()) {
                rows = rs.next();
                String str = rows.getAttribute("MeterCode").toString();
                meterReadingList.add(str);

            }
            System.out.println("MeterReadingList" + meterReadingList);
            System.out.println("MeterReadingSize" + meterReadingList.size());

            //list from SubMenuROVO
            ViewObject Menu =
                ADFUtils.findIterator("Lookup_View_ROVO4Iterator").getViewObject();


            ViewCriteria vc1 = Menu.createViewCriteria();
            ViewCriteriaRow viewrow1 = vc1.createViewCriteriaRow();
            viewrow1.setAttribute("LookupTypeName", "METER_READINGS");
            vc1.addRow(viewrow1);
            Menu.applyViewCriteria(vc1);
            Menu.executeQuery();

            RowSetIterator menuRow = Menu.createRowSetIterator("");
            while (menuRow.hasNext()) {
                Row re = menuRow.next();
                lookup.add(re.getAttribute("LookupValueName"));
                System.err.println("LOOK UP VALUE" +
                                   re.getAttribute("LookupValueName"));
            }
            System.out.println("ROVOMENU" + lookup.size());
            lookup.removeAll(meterReadingList);
            System.out.println("Result" + lookup);
            System.out.println("Result" + lookup.size());

            if (lookup.size() == 0) {
                JSFUtils.addFacesInformationMessage("No Record to Synchronize");

            } else {
                ListIterator li = lookup.listIterator();
                while (li.hasNext()) {
                    Object str = li.next();
                    System.err.println("insertData" + str);

                    Row createRow = UserVO.createRow();
                    createRow.setAttribute("MoveInOutId", Userid);
                    createRow.setAttribute("MeterCode", str);
                    UserVO.insertRow(createRow);
                    UserVO.executeQuery();
                }
                JSFUtils.addFacesInformationMessage("Record synchronized Successfully!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onclickAppOrRej(ActionEvent actionEvent) {
        // Add event code here...
        Object val =
            ADFContext.getCurrent().getPageFlowScope().get("Action") == null ?
            "" :
            ADFContext.getCurrent().getPageFlowScope().get("Action").toString();

        if (val.equals("Approval")) {
            onClickApprove(actionEvent);
        }


        if (val.equals("Rejection")) {
            onClickReject(actionEvent);
        }


    }

    public void onInvokeAppOrrejec(ActionEvent actionEvent) {
        // Add event code here...
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPopup3().show(popup34);
    }

    public void setPopup3(RichPopup popup3) {
        this.popup3 = popup3;
    }

    public RichPopup getPopup3() {
        return popup3;
    }


    public void setReason(RichInputText reason) {
        this.reason = reason;
    }

    public RichInputText getReason() {
        return reason;
    }

    public String onClickCancelAction() {
        BigDecimal M = (BigDecimal)ADFUtils.evaluateEL("#{sessionScope.EditMoveInOut}");
                
                 System.err.println("----M---"+M);
                 if(M == null){
                     ADFUtils.findOperation("Rollback").execute();
                 }else{
                     return "LA";
                     }
                 
                return "goBack";
    }

   
}
