package view.backing;

import java.math.BigDecimal;

import java.math.RoundingMode;

import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UISelectItems;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;

import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class AddEditExtCan {
    private RichPanelGroupLayout pgl1;
    private RichPanelGroupLayout pgl2;
    private RichPanelBox pb1;
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichInputDate id1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichSelectOneChoice soc2;
    private UISelectItems si2;
    private RichInputText it2;
    private RichInputDate id2;
    private RichInputText it5;
    private RichInputText it6;
    private RichInputText it7;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichPanelBox pb2;
    private RichTable t1;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichCommandButton cb3;
    private RichPanelCollection pc1;
    private RichCommandButton cb4;
    private RichCommandButton cb5;
    private RichCommandButton cb6;
    private RichInputDate id4;
    private RichInputDate id5;
    private RichCommandButton cb7;
    private RichPopup p1;
    private RichDialog d1;
    private RichTable t2;
    private RichInputText it12;
    private RichSpacer s1;
    Map<String, Boolean> map = new HashMap();

    ViewObject extensionVO =
        ADFUtils.findIterator("ExtCanVO1Iterator").getViewObject();
    Row extensionRow = extensionVO.getCurrentRow();

    ViewObject getFuncodeVo =
        ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();

    ViewObject leaseAgreementVO =
        ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();

    ViewObject carparksVO =
        ADFUtils.findIterator("getCarParkingUnitDetailsforExtension_ROVO3Iterator").getViewObject();

    ViewObject BookingDtl =
        ADFUtils.findIterator("OfferDetail_VO1Iterator").getViewObject();

    BigDecimal extensionRequestedDays = new BigDecimal(0);
    Date leaseEndDate = new Date();
    Date leaseStartDate = new Date();

    private RichSpacer s2;
    private RichPanelBox pb3;
    private RichSpacer s3;
    private RichTable t4;
    private RichPanelCollection pc2;
    private RichSelectOneChoice soc9;
    private UISelectItems si13;
    private RichPanelBox pb4;
    private RichSpacer s4;
    private RichPanelCollection pc3;
    private RichTable t5;
    private RichTable t6;
    private RichPanelGroupLayout pgl4;
    private RichPanelGridLayout pgl5;
    private RichGridRow gr2;
    private RichGridCell gc3;
    private RichGridCell gc4;
    private RichOutputText ot17;
    private RichInputListOfValues trans_SmartSearchLeaseIdId;
    private RichInputListOfValues leaseNumberSmartSearch_TransId;
    private RichInputText it18;
    private RichSelectOneRadio sor1;
    private UISelectItems si16;

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSi2(UISelectItems si2) {
        this.si2 = si2;
    }

    public UISelectItems getSi2() {
        return si2;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }


    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
    }


    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSi3(UISelectItems si3) {
        this.si3 = si3;
    }

    public UISelectItems getSi3() {
        return si3;
    }

    public void setPb2(RichPanelBox pb2) {
        this.pb2 = pb2;
    }

    public RichPanelBox getPb2() {
        return pb2;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }


    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void onAttributesSave() {

        ViewObject BookingDtl =
            ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
        ViewCriteria offerDtlVC = BookingDtl.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("BookingId",
                                 extensionVO.getCurrentRow().getAttribute("BookingId"));
        offerDtlVC.addRow(offerDtlVCR);
        BookingDtl.applyViewCriteria(offerDtlVC);
        BookingDtl.executeQuery();

        if (BookingDtl.getEstimatedRowCount() > 0) {
            extensionVO.getCurrentRow().setAttribute("PropertyId",
                                                     BookingDtl.first().getAttribute("PropertyId"));
            extensionVO.getCurrentRow().setAttribute("BuildId",
                                                     BookingDtl.first().getAttribute("BuildingId"));
        }
    }

    public void onClickApprove(ActionEvent actionEvent) {
        String ResultVal = null;

        try {
            ResultVal =
                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
                                            extensionRow.getAttribute("FuncId"),
                                            extensionRow.getAttribute("ExtnCanclId"),
                                            extensionRow.getAttribute("UserGrpId"),
                                            extensionRow.getAttribute("FlowLevel"),
                                            extensionRow.getAttribute("FlowWith"),
                                            "Approved", "A", 0,
                                            "XXPM_EXTEN_CANCEL", "STATUS",
                                            "EXTN_CANCL_ID");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            //onExtendtheOffer();
            updateDates();
            extensionVO.executeQuery();
            // ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Approved Successfully");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Approve process!");
        }

    }

    public void onExtendtheOffer() {

        ViewObject bookingHdr =
            ADFUtils.findIterator("BookingHeader_VO2Iterator").getViewObject();
        ViewCriteria offerDtlVC = bookingHdr.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("BookingId",
                                 extensionVO.getCurrentRow().getAttribute("BookingId"));
        offerDtlVC.addRow(offerDtlVCR);
        bookingHdr.applyViewCriteria(offerDtlVC);
        //getBookingDtl.setNamedWhereClauseParam
        bookingHdr.executeQuery();


        if (bookingHdr.getEstimatedRowCount() > 0) {


            ViewObject offerHdr =
                ADFUtils.findIterator("OfferHrd_VO1Iterator").getViewObject();
            ViewCriteria offerDtlVCs = offerHdr.createViewCriteria();
            ViewCriteriaRow offerDtlVCRs = offerDtlVCs.createViewCriteriaRow();
            //1
            offerDtlVCRs.setAttribute("OfferHdrId",
                                      bookingHdr.first().getAttribute("OfferHdrId"));
            offerDtlVCs.addRow(offerDtlVCRs);
            offerHdr.applyViewCriteria(offerDtlVCs);
            //getBookingDtl.setNamedWhereClauseParam
            offerHdr.executeQuery();

            if (offerHdr.getEstimatedRowCount() > 0) {

                Row first = offerHdr.first();

                System.err.println("======" +
                                   extensionVO.getCurrentRow().getAttribute("DueDate"));

                first.setAttribute("OfferToDate",
                                   extensionVO.getCurrentRow().getAttribute("DueDate")); //DueDate
                offerHdr.executeQuery();
            }
        }
    }


    public void onClickReject(ActionEvent actionEvent) {
        String ResultVal = null;
        try {
            ResultVal =
                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
                                            extensionRow.getAttribute("FuncId"),
                                            extensionRow.getAttribute("ExtnCanclId"),
                                            extensionRow.getAttribute("UserGrpId"),
                                            extensionRow.getAttribute("FlowLevel"),
                                            extensionRow.getAttribute("FlowWith"),
                                            "Rejected", "R", 0,
                                            "XXPM_EXTEN_CANCEL", "STATUS",
                                            "EXTN_CANCL_ID");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            extensionVO.executeQuery();
            JSFUtils.addFacesInformationMessage("Rejected Successfully");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Approve process!");
        }

    }


    public void onClickSubmit(ActionEvent actionEvent) {

        onclickSaveUsingProcedure(actionEvent);
        String ResultVal = null;

        Object org = extensionVO.getCurrentRow().getAttribute("OrgId");
        Object prop = extensionVO.getCurrentRow().getAttribute("PropertyId");
        Object unit = extensionVO.getCurrentRow().getAttribute("BuildId");

        try {
            ResultVal =
                    xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
                                          extensionRow.getAttribute("FuncId"),
                                          extensionRow.getAttribute("ExtnCanclId"),
                                          0, "XXPM_EXTEN_CANCEL", "STATUS",
                                          "EXTN_CANCL_ID", org, prop, unit,
                                          null, null);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (ResultVal.equalsIgnoreCase("Success")) {
            JSFUtils.addFacesInformationMessage("Submitted For Approval");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Submission Process...!");
        }
    }

    public BigDecimal extesionCalculation() {

        //Lease start date and end date diffrence
        long leasestartandEndDateDif =
            leaseEndDate.getTime() - leaseStartDate.getTime();
        int leasestartandEndDateDifActual =
            (int)(leasestartandEndDateDif / (1000 * 60 * 60 * 24));
        System.err.println("Lease Start & End date diff " +
                           leasestartandEndDateDifActual);
        BigDecimal leasestartandEndDateDifActualBD =
            new BigDecimal(leasestartandEndDateDifActual);

        //Rent per day
        String leaseAmountObj =
            extensionRow.getAttribute("Offer_Total_Trans") == null ? "0" :
            extensionRow.getAttribute("Offer_Total_Trans").toString();
        BigDecimal bigDecLeaseAmount = new BigDecimal(leaseAmountObj);

        BigDecimal rentPerDay =
            bigDecLeaseAmount.divide(leasestartandEndDateDifActualBD, 2,
                                     RoundingMode.HALF_UP);
        System.err.println("==rent Per Day==" + rentPerDay);

        //Rent for contract extension days
        BigDecimal rentforContractExtensionDays =
            rentPerDay.multiply(extensionRequestedDays);
        System.err.println("==Rent for Contract Extension Days==" +
                           rentforContractExtensionDays);

        return rentforContractExtensionDays;
    }

    public void onclickSave(ActionEvent actionEvent) {

        //Mandatory fields validation
        if (extensionRow.getAttribute("LeaseAgreementId") != null &&
            extensionRow.getAttribute("TransDate") != null &&
            extensionRow.getAttribute("ExtensionDays") != null) {
            //            extensionRow.getAttribute("Currency") != null) {
            String leaseId =
                extensionRow.getAttribute("LeaseAgreementId") == null ? "N" :
                extensionRow.getAttribute("LeaseAgreementId").toString();

            //Getting Request date
            String reqDate =
                extensionRow.getAttribute("TransDate") == null ? "" :
                extensionRow.getAttribute("TransDate").toString();
            Date extensionReqDate = new Date();
            try {
                extensionReqDate =
                        new SimpleDateFormat("yyyy-MM-dd").parse(reqDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //Getting Due date
            String dueDate =
                extensionRow.getAttribute("DueDate") == null ? "" :
                extensionRow.getAttribute("DueDate").toString();
            Date extensionDueDate = new Date();
            try {
                extensionDueDate =
                        new SimpleDateFormat("yyyy-MM-dd").parse(dueDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //Getting Lease Start date
            String leaseEndDateObj =
                extensionRow.getAttribute("LeaseEndDateTrans") == null ? "" :
                extensionRow.getAttribute("LeaseEndDateTrans").toString();
            try {
                leaseEndDate =
                        new SimpleDateFormat("yyyy-MM-dd").parse(leaseEndDateObj);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //Getting Lease End date
            String leaseStartDateObj =
                extensionRow.getAttribute("LeaseStartDateTrans") == null ? "" :
                extensionRow.getAttribute("LeaseStartDateTrans").toString();
            try {
                leaseStartDate =
                        new SimpleDateFormat("yyyy-MM-dd").parse(leaseStartDateObj);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            long diffDays =
                extensionDueDate.getTime() - leaseEndDate.getTime();

            int daysCount = (int)(diffDays / (1000 * 60 * 60 * 24));
            extensionRequestedDays = new BigDecimal(daysCount);
            System.err.println("Diff days b/w ext.Requ date and ext.Due date " +
                               daysCount);

            if (extensionRow.getAttribute("LEASE_TYPE_TRANS") == null ||
                extensionRow.getAttribute("LEASE_TYPE_TRANS").equals("CAR_PARKING")) {
                if (leaseId != "N" && reqDate != null && dueDate != null) {

                    String ResVal =
                        carParkingExtension(leaseId, extensionReqDate,
                                            extensionDueDate,
                                            extensionRequestedDays).toString();
                    BigDecimal outCome = new BigDecimal(ResVal);
                    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("actualCarParkingRefund",
                                                                                outCome);
                    Object CarParkingRefundObj =
                        AdfFacesContext.getCurrentInstance().getPageFlowScope().get("actualCarParkingRefund") ==
                        null ? 0 :
                        AdfFacesContext.getCurrentInstance().getPageFlowScope().get("actualCarParkingRefund");
                    String s = CarParkingRefundObj.toString();
                    BigDecimal carParkingUnit = new BigDecimal(s);
                    BigDecimal totalRefundAmountCP = carParkingUnit;
                    //Null validation is to avoid the re-calculation on click submit
                    if (totalRefundAmountCP != null) {
                        //Auto Number Generation
                        getFuncodeVo.setNamedWhereClauseParam("F_ID", "ET");
                        getFuncodeVo.executeQuery();
                        Object Funcode =
                            getFuncodeVo.first().getAttribute("FuncId");
                        String Fcode =
                            Funcode == null ? "" : Funcode.toString();
                        if (extensionRow.getAttribute("TransNumber") == null) {
                            String name =
                                xxfnd.generateDocNo("ET", "MoveInOut_AMDataControl").toString();
                            Object valu = name;

                            extensionRow.setAttribute("TransNumber", valu);
                            extensionRow.setAttribute("FuncId",
                                                      getFuncodeVo.first().getAttribute("FuncId"));
                            //End for Auto Number Generation

                            System.err.println("Net Refund Amount" +
                                               totalRefundAmountCP);
                            extensionRow.setAttribute("Amount",
                                                      totalRefundAmountCP);

                            onAttributesSave();
                            JSFUtils.addFacesInformationMessage("Saved Successfully");
                            ADFUtils.findOperation("Commit").execute();
                        }

                    }
                }
            } else {

                //                if (daysCount >= 15 &&
                //                    (extensionReqDate.compareTo(leaseEndDate) <= 0)) { //*****Revised logic on Feb-6***//

                //Null validation is to avoid the re-calculation on click submit

                //                    if (extensionRow.getAttribute("Amount") == null) {
                getFuncodeVo.setNamedWhereClauseParam("F_ID", "ET");
                getFuncodeVo.executeQuery();
                Object Funcode = getFuncodeVo.first().getAttribute("FuncId");
                String Fcode = Funcode == null ? "" : Funcode.toString();
                if (extensionRow.getAttribute("TransNumber") == null) {
                    String name =
                        xxfnd.generateDocNo("ET", "MoveInOut_AMDataControl").toString();
                    Object valu = name;

                    extensionRow.setAttribute("TransNumber", valu);
                    extensionRow.setAttribute("FuncId",
                                              getFuncodeVo.first().getAttribute("FuncId"));
                }
                //Lease start date and end date diffrence
                long leasestartandEndDateDif =
                    leaseEndDate.getTime() - leaseStartDate.getTime();
                int leasestartandEndDateDifActual =
                    (int)(leasestartandEndDateDif / (1000 * 60 * 60 * 24));
                System.err.println("Lease Start & End date diff " +
                                   leasestartandEndDateDifActual);
                int totalNoOfLeaseDays = leasestartandEndDateDifActual + 1;

                BigDecimal leasestartandEndDateDifActualBD =
                    new BigDecimal(totalNoOfLeaseDays);


                //Rent per day
                String leaseAmountObj =
                    extensionRow.getAttribute("Offer_Total_Trans") == null ?
                    "0" :
                    extensionRow.getAttribute("Offer_Total_Trans").toString();
                BigDecimal bigDecLeaseAmount = new BigDecimal(leaseAmountObj);

                BigDecimal rentPerDay =
                    bigDecLeaseAmount.divide(leasestartandEndDateDifActualBD,
                                             2, RoundingMode.HALF_UP);
                System.err.println("==rent Per Day==" + rentPerDay);

                //Rent for contract extension days
                BigDecimal rentforContractExtensionDays =
                    rentPerDay.multiply(extensionRequestedDays);
                System.err.println("==Rent for Contract Extension Days==" +
                                   rentforContractExtensionDays);


                //Check the car parking is available for the normal units
                String ResVal = "0";
                BigDecimal outCome = new BigDecimal(0);

                if (leaseId != "N" && reqDate != null && dueDate != null) {

                    if (carparksVO.getEstimatedRowCount() > 0) {
                        RowSetIterator leaseAgreementVORS =
                            carparksVO.createRowSetIterator(null);
                        while (leaseAgreementVORS.hasNext()) {
                            Row r = leaseAgreementVORS.next();
                            System.err.println("==Trans check box o/p==" +
                                               r.getAttribute("CheckBoxeYn"));
                            updateCheckbox(r.getAttribute("UnitId"),
                                           r.getAttribute("OfferDtlId"),
                                           r.getAttribute("CheckBoxeYn"));
                            if (r.getAttribute("CheckBoxeYn") == "Y") {
                                //Invoke Carparking Calculation inside this if loop
                                String taxCode =
                                    extensionRow.getAttribute("TaxCodeTrans") ==
                                    null ? "" :
                                    extensionRow.getAttribute("TaxCodeTrans").toString();
                                ResVal =
                                        carParkingExtensionforNormalUnits(leaseId,
                                                                          extensionReqDate,
                                                                          extensionDueDate,
                                            //                                    taxCode,
                                            extensionRequestedDays).toString();
                                System.err.println("==inside if ---> Res Val==" +
                                                   ResVal);
                                outCome = new BigDecimal(ResVal);
                                System.err.println("==inside if ---> ==out Come==" +
                                                   outCome);
                            }
                        }
                    }
                    System.err.println("==out Come==" + outCome);

                    AdfFacesContext.getCurrentInstance().getPageFlowScope().put("actualCarParkingRefund",
                                                                                outCome);
                    System.err.println("==Outcome==" + outCome);
                }
                //Total Rent payable amount for extension
                Object CarParkingRefundObj =
                    AdfFacesContext.getCurrentInstance().getPageFlowScope().get("actualCarParkingRefund") ==
                    null ? 0 :
                    AdfFacesContext.getCurrentInstance().getPageFlowScope().get("actualCarParkingRefund");
                String s = CarParkingRefundObj.toString();
                BigDecimal carParkingUnit = new BigDecimal(s);

                BigDecimal actualRentPayableforExtension =
                    rentforContractExtensionDays.add(carParkingUnit);
                System.err.println("==Actual Rent Payable for Extension==" +
                                   actualRentPayableforExtension);
                extensionRow.setAttribute("Amount",
                                          actualRentPayableforExtension);
                onAttributesSave();
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Saved Successfully");
                //                    }
                //                } else {
                //                    if (daysCount < 15) {
                //                        JSFUtils.addFacesErrorMessage("Minimum Extension requested should be 15 days, Please review your Extension Days");
                //                    }
                //                    if (extensionReqDate.compareTo(leaseEndDate) > 0) {
                //                        JSFUtils.addFacesErrorMessage("Extension request date should not be less than Lease end date");
                //                    }
                //                }
            }

        } else {
            if (extensionRow.getAttribute("LeaseAgreementId") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Lease Number");
            }
            if (extensionRow.getAttribute("TransDate") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Request Date");
            }
            if (extensionRow.getAttribute("ExtensionDays") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Extension Days");
            }
            //            if (extensionRow.getAttribute("Currency") == null) {
            //                JSFUtils.addFacesErrorMessage("You must enter a Currency");
            //            }
        }
    }

    //Car Parking extension which is attached with the normal units

    public BigDecimal carParkingExtensionforNormalUnits(String p_LeaseId,
                                                        Date canReqDate,
                                                        Date canDueDate,
                                                        BigDecimal extdays) {
        BigDecimal netCarParkRefund = new BigDecimal(0);

        try {
            System.err.println("==Lease ID==" + p_LeaseId);
            ViewCriteria leaseAgreementVC =
                leaseAgreementVO.createViewCriteria();
            ViewCriteriaRow leaseAgreementVORow =
                leaseAgreementVC.createViewCriteriaRow();
            leaseAgreementVORow.setAttribute("CarParkLeaseAgreId",
                                             p_LeaseId); //LeaseAgreementId
            leaseAgreementVC.addRow(leaseAgreementVORow);
            leaseAgreementVO.applyViewCriteria(leaseAgreementVC);
            leaseAgreementVO.executeQuery();
            System.err.println("==COUNT==" +
                               leaseAgreementVO.getEstimatedRowCount());

            if (leaseAgreementVO.getEstimatedRowCount() > 0) {

                RowSetIterator leaseAgreementVORS =
                    leaseAgreementVO.createRowSetIterator(null);
                while (leaseAgreementVORS.hasNext()) {

                    Row leaseAgreementVOCurrRow = leaseAgreementVORS.next();
                    String cpLeaseStDateObj =
                        leaseAgreementVOCurrRow.getAttribute("LeaseStartDate") ==
                        null ? "" :
                        leaseAgreementVOCurrRow.getAttribute("LeaseStartDate").toString();
                    String cpLeaseEnDateObj =
                        leaseAgreementVOCurrRow.getAttribute("LeaseEndDate") ==
                        null ? "" :
                        leaseAgreementVOCurrRow.getAttribute("LeaseEndDate").toString();

                    String OfferTotalObjCP =
                        leaseAgreementVOCurrRow.getAttribute("OfferTotal") ==
                        null ? "0" :
                        leaseAgreementVOCurrRow.getAttribute("OfferTotal").toString();

                    Date CPLeaseStartDate = new Date();
                    try {
                        CPLeaseStartDate =
                                new SimpleDateFormat("yyyy-MM-dd").parse(cpLeaseStDateObj);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Date CPLeaseEndDate = new Date();
                    try {
                        CPLeaseEndDate =
                                new SimpleDateFormat("yyyy-MM-dd").parse(cpLeaseEnDateObj);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    long diffDaysCP =
                        canDueDate.getTime() - canReqDate.getTime();
                    int daysCountCP =
                        (int)(diffDaysCP / (1000 * 60 * 60 * 24));
                    System.err.println("Diff of b/w Requ date and extension date " +
                                       daysCountCP);

                    //                    if ((daysCountCP >= 15) &&
                    //                        (canDueDate.compareTo(CPLeaseEndDate) <= 0)) {    //*****Revised logic on Feb-6***//

                    //Lease start date and end date diffrence
                    long leasestartandEndDateDifCP =
                        CPLeaseEndDate.getTime() - CPLeaseStartDate.getTime();
                    int leasestartandEndDateDifActualCP =
                        (int)(leasestartandEndDateDifCP /
                              (1000 * 60 * 60 * 24));
                    int totalNoOfLeaseDays =
                        leasestartandEndDateDifActualCP + 1;

                    BigDecimal leaseSTEDDateDiff =
                        new BigDecimal(totalNoOfLeaseDays);
                    System.err.println("==Big Deci Lease Start & End date diff CP== " +
                                       leaseSTEDDateDiff);

                    //Offer Total
                    BigDecimal offerTotalCP = new BigDecimal(OfferTotalObjCP);
                    System.err.println("==Offer Total==" + offerTotalCP);

                    //Rent Per day CP
                    BigDecimal rentPerDay =
                        offerTotalCP.divide(leaseSTEDDateDiff, 2,
                                            RoundingMode.HALF_UP);
                    System.err.println("==rent Per Day CP==" + rentPerDay);

                    //Tax Calculation Adding on Feb-6 Revision


                    //Rent for contract extension days
                    BigDecimal carParkRentForExtension =
                        rentPerDay.multiply(extdays);
                    System.err.println("==Car Park rent for extension amount==" +
                                       carParkRentForExtension);

                    netCarParkRefund =
                            netCarParkRefund.add(carParkRentForExtension);

                    //                    } else {
                    //                        if (daysCountCP < 15) {
                    //                            JSFUtils.addFacesErrorMessage("Minimum Extension requested should be 15 days, Please review your Extension Days");
                    //                        }
                    //                        if (canDueDate.compareTo(CPLeaseEndDate) > 0) {
                    //                            JSFUtils.addFacesErrorMessage("Extension request date should not be less than Lease end date");
                    //                        }
                    //                    }
                }
            }

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error" + e);
        }
        return netCarParkRefund;
    }

    //      Car Parking Unit Extension

    public BigDecimal carParkingExtension(String p_LeaseId, Date canReqDate,
                                          Date canDueDate,
                                          BigDecimal extdays) {
        BigDecimal netCarParkRefund = new BigDecimal(0);

        try {
            System.err.println("==Lease ID==" + p_LeaseId);
            ViewCriteria leaseAgreementVC =
                leaseAgreementVO.createViewCriteria();
            ViewCriteriaRow leaseAgreementVORow =
                leaseAgreementVC.createViewCriteriaRow();
            leaseAgreementVORow.setAttribute("LeaseAgreementId",
                                             p_LeaseId); //LeaseAgreementId
            leaseAgreementVC.addRow(leaseAgreementVORow);
            leaseAgreementVO.applyViewCriteria(leaseAgreementVC);
            leaseAgreementVO.executeQuery();
            System.err.println("==COUNT==" +
                               leaseAgreementVO.getEstimatedRowCount());

            if (leaseAgreementVO.getEstimatedRowCount() > 0) {

                RowSetIterator leaseAgreementVORS =
                    leaseAgreementVO.createRowSetIterator(null);
                while (leaseAgreementVORS.hasNext()) {

                    Row leaseAgreementVOCurrRow = leaseAgreementVORS.next();
                    String cpLeaseStDateObj =
                        leaseAgreementVOCurrRow.getAttribute("LeaseStartDate") ==
                        null ? "" :
                        leaseAgreementVOCurrRow.getAttribute("LeaseStartDate").toString();
                    String cpLeaseEnDateObj =
                        leaseAgreementVOCurrRow.getAttribute("LeaseEndDate") ==
                        null ? "" :
                        leaseAgreementVOCurrRow.getAttribute("LeaseEndDate").toString();

                    String OfferTotalObjCP =
                        leaseAgreementVOCurrRow.getAttribute("OfferTotal") ==
                        null ? "0" :
                        leaseAgreementVOCurrRow.getAttribute("OfferTotal").toString();

                    Date CPLeaseStartDate = new Date();
                    try {
                        CPLeaseStartDate =
                                new SimpleDateFormat("yyyy-MM-dd").parse(cpLeaseStDateObj);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Date CPLeaseEndDate = new Date();
                    try {
                        CPLeaseEndDate =
                                new SimpleDateFormat("yyyy-MM-dd").parse(cpLeaseEnDateObj);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    long diffDaysCP =
                        canDueDate.getTime() - canReqDate.getTime();
                    int daysCountCP =
                        (int)(diffDaysCP / (1000 * 60 * 60 * 24));
                    System.err.println("Diff of b/w Requ date and extension date " +
                                       daysCountCP);

                    //                    if ((daysCountCP >= 15) &&
                    //                        (canDueDate.compareTo(CPLeaseEndDate) <= 0)) {   //*****Revised logic on Feb-6***//

                    //Lease start date and end date diffrence
                    long leasestartandEndDateDifCP =
                        CPLeaseEndDate.getTime() - CPLeaseStartDate.getTime();
                    int leasestartandEndDateDifActualCP =
                        (int)(leasestartandEndDateDifCP /
                              (1000 * 60 * 60 * 24));
                    int totalNoOfLeaseDays =
                        leasestartandEndDateDifActualCP + 1;

                    BigDecimal leaseSTEDDateDiff =
                        new BigDecimal(totalNoOfLeaseDays);
                    System.err.println("==Big Deci Lease Start & End date diff CP== " +
                                       leaseSTEDDateDiff);

                    //Offer Total
                    BigDecimal offerTotalCP = new BigDecimal(OfferTotalObjCP);
                    System.err.println("==Offer Total==" + offerTotalCP);

                    //Rent Per day CP
                    BigDecimal rentPerDay =
                        offerTotalCP.divide(leaseSTEDDateDiff, 2,
                                            RoundingMode.HALF_UP);
                    System.err.println("==rent Per Day CP==" + rentPerDay);

                    //Rent for contract extension days
                    BigDecimal carParkRentForExtension =
                        rentPerDay.multiply(extdays);
                    System.err.println("==Car Park rent for extension amount==" +
                                       carParkRentForExtension);

                    netCarParkRefund =
                            netCarParkRefund.add(carParkRentForExtension);

                    //                    } else {
                    //                        if (daysCountCP < 15) {
                    //                            JSFUtils.addFacesErrorMessage("Minimum Extension requested should be 15 days, Please review your Extension Days");
                    //                        }
                    //                        if (canDueDate.compareTo(CPLeaseEndDate) > 0) {
                    //                            JSFUtils.addFacesErrorMessage("Extension request date should not be less than Lease end date");
                    //                        }
                    //                    }
                }
            }

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error" + e);
        }
        return netCarParkRefund;
    }

    public void onclickCancel(ActionEvent actionEvent) {
        //        ADFUtils.findOperation("Rollback").execute();
    }

    public void onclickSaveUsingProcedure(ActionEvent actionEvent) {
        String leaseId = "";
        String extdays = "";
        String flag = "";
        BigDecimal extAmt = new BigDecimal(0);
        List extList;
        if (extensionRow.getAttribute("LeaseAgreementId") != null &&
            extensionRow.getAttribute("TransDate") != null &&
            extensionRow.getAttribute("ExtensionDays") != null) {
            //Getting Input parameters
            leaseId =
                    extensionRow.getAttribute("LeaseAgreementId") == null ? "N" :
                    extensionRow.getAttribute("LeaseAgreementId").toString();
            //            System.err.println("==Lease Agreement Id==" +
            //                               extensionRow.getAttribute("LeaseAgreementId").toString());
            extdays =
                    extensionRow.getAttribute("ExtensionDays") == null ? "N" :
                    extensionRow.getAttribute("ExtensionDays").toString();
            //            System.err.println("==Extension Days==" +
            //                               extensionRow.getAttribute("ExtensionDays").toString());
            flag =
extensionRow.getAttribute("TransType") == null ? "N" : extensionRow.getAttribute("TransType").toString();
            //            System.err.println("==Type==" +
            //                               extensionRow.getAttribute("TransType").toString());
            //Package invoking
            extList =
                    xxfnd.extensionCalculation(leaseId, extdays, flag, "ExtensionCancellation_AMDataControl");

            if (extList.size() == 2) {
                if (extList.get(0).toString().equalsIgnoreCase("Success") &&
                    !extList.get(1).toString().equalsIgnoreCase("")) {
                    extAmt = new BigDecimal(extList.get(1).toString());
                } else if (extList.get(0).toString().equalsIgnoreCase("Success") &&
                           extList.get(1).toString().equalsIgnoreCase("")) {
                    JSFUtils.addFacesErrorMessage("No Data returned from package");
                }
            } else {
                JSFUtils.addFacesErrorMessage("Package Return Message : " +
                                              extList.get(0).toString());
                JSFUtils.addFacesErrorMessage("Error in Extension Calculation : " +
                                              extList.get(2).toString());
            }

            if (extensionRow.getAttribute("Amount") == null) {
                getFuncodeVo.setNamedWhereClauseParam("F_ID", "ET");
                getFuncodeVo.executeQuery();
                Object Funcode = getFuncodeVo.first().getAttribute("FuncId");
                String Fcode = Funcode == null ? "" : Funcode.toString();
                if (extensionRow.getAttribute("TransNumber") == null) {
                    String name =
                        xxfnd.generateDocNo("ET", "MoveInOut_AMDataControl").toString();
                    Object valu = name;
                    extensionRow.setAttribute("TransNumber", valu);
                    extensionRow.setAttribute("FuncId",
                                              getFuncodeVo.first().getAttribute("FuncId"));
                }
            }
            
           //
           
            System.out.println("Amount before setting extAmt "+ extensionRow.getAttribute("Amount"));
            extensionRow.setAttribute("Amount", extAmt);
            
            String amt = extensionRow.getAttribute("Amount")==null ? "0.0" : extensionRow.getAttribute("Amount").toString();
            BigDecimal amount = new BigDecimal(amt);
            System.out.println("Amount after setting extAmt "+ extensionRow.getAttribute("Amount")+" and extAmt is "+extAmt+" amt=amount "+amt);
            
            //for incorporating discount
            System.out.println("Discount Type:: "+extensionRow.getAttribute("DiscountType"));
            String disTyp = extensionRow.getAttribute("DiscountType")==null ? "" : extensionRow.getAttribute("DiscountType").toString();
            System.out.println("Discount Type after:: "+extensionRow.getAttribute("DiscountType"));
            String disAmtOrPrcnt = extensionRow.getAttribute("DiscountValue")==null ? "" : extensionRow.getAttribute("DiscountValue").toString();
            
        if(extensionRow.getAttribute("DiscountType")!=null && extensionRow.getAttribute("DiscountValue")!=null){  
            
            if (disTyp.equalsIgnoreCase("PCT")) {
                BigDecimal disPrcnt = new BigDecimal(disAmtOrPrcnt);
                BigDecimal totalAmtAftrDis = amount.subtract(disPrcnt.divide(new BigDecimal(100)).multiply(amount));
                System.out.println("percentage "+totalAmtAftrDis);
                extensionRow.setAttribute("Amount", totalAmtAftrDis);
            }
            if(disTyp.equalsIgnoreCase("AMT")){
                    BigDecimal disAmt = new BigDecimal(disAmtOrPrcnt);
                    BigDecimal totalAmtAftrDis = amount.subtract(disAmt);
                    System.out.println("amount "+totalAmtAftrDis);
                    extensionRow.setAttribute("Amount", totalAmtAftrDis);
                }
            }
            
            //
            onAttributesSave();
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Saved Successfully");

        } else {
            if (extensionRow.getAttribute("LeaseAgreementId") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Lease Number");
            }
            if (extensionRow.getAttribute("TransDate") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Request Date");
            }
            if (extensionRow.getAttribute("ExtensionDays") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Extension Days");
            }
        }
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public void setCb5(RichCommandButton cb5) {
        this.cb5 = cb5;
    }

    public RichCommandButton getCb5() {
        return cb5;
    }

    public void setCb6(RichCommandButton cb6) {
        this.cb6 = cb6;
    }

    public RichCommandButton getCb6() {
        return cb6;
    }

    public void setId4(RichInputDate id4) {
        this.id4 = id4;
    }

    public RichInputDate getId4() {
        return id4;
    }

    public void setId5(RichInputDate id5) {
        this.id5 = id5;
    }

    public RichInputDate getId5() {
        return id5;
    }


    public void updateDates() {


        Map map = new HashMap();
        String bookid = extensionRow.getAttribute("BookingId").toString();
        String milesid = extensionRow.getAttribute("ExtnCanclId").toString();
        String userid = extensionRow.getAttribute("CreatedBy").toString();
        map.put("bookingid", bookid);
        map.put("extnid", milesid);
        map.put("userId", userid);


        OperationBinding ob =
            ADFUtils.findOperation("UpdateOfferAndLeaseDate");
        ob.getParamsMap().putAll(map);
        ob.execute();
    }


    public void setCb7(RichCommandButton cb7) {
        this.cb7 = cb7;
    }

    public RichCommandButton getCb7() {
        return cb7;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setD1(RichDialog d1) {
        this.d1 = d1;
    }

    public RichDialog getD1() {
        return d1;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public String onclickcancel() {
        String M = (String)ADFUtils.evaluateEL("#{sessionScope.transno}");

        System.err.println("----M---" + M);
        if (M == null) {
            ADFUtils.findOperation("Rollback").execute();
        } else {
            return "LA";
        }

        return "back";

    }

    public void setIt12(RichInputText it12) {
        this.it12 = it12;
    }

    public RichInputText getIt12() {
        return it12;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public String onClickExtDateValidation(ValueChangeEvent valueChangeEvent) {

        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {

            //Object to String and String to Integer conversion
            System.err.println("==VCL==" + valueChangeEvent.getNewValue());
            Object extensionObj = valueChangeEvent.getNewValue();
            String extDays = extensionObj.toString();
            int extensionDaysActual = Integer.parseInt(extDays);
            String requestDateObj =
                extensionRow.getAttribute("LeaseEndDateTrans") == null ? "" :
                extensionRow.getAttribute("LeaseEndDateTrans").toString();

            Date requestDate = new Date();
            try {
                requestDate =
                        new SimpleDateFormat("yyyy-MM-dd").parse(requestDateObj);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //Adding the extesnion days with the date
            Calendar c = Calendar.getInstance();
            c.setTime(requestDate);

            //Passing the days extesnion days to add with extesnion date
            c.add(Calendar.DATE, extensionDaysActual);

            DateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
            String extesnionDateObj = dateFormate.format(c.getTime());

            Date extesnionDate = new Date();
            try {
                extesnionDate =
                        new SimpleDateFormat("yyyy-MM-dd").parse(extesnionDateObj);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            java.sql.Date sqlDate = new java.sql.Date(extesnionDate.getTime());
            oracle.jbo.domain.Date domaindate =
                new oracle.jbo.domain.Date(sqlDate);
            extensionRow.setAttribute("DueDate", domaindate);

        }
        return null;

    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }


    public void setPb3(RichPanelBox pb3) {
        this.pb3 = pb3;
    }

    public RichPanelBox getPb3() {
        return pb3;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void setPc2(RichPanelCollection pc2) {
        this.pc2 = pc2;
    }

    public RichPanelCollection getPc2() {
        return pc2;
    }


    public void setSoc9(RichSelectOneChoice soc9) {
        this.soc9 = soc9;
    }

    public RichSelectOneChoice getSoc9() {
        return soc9;
    }

    public void setSi13(UISelectItems si13) {
        this.si13 = si13;
    }

    public UISelectItems getSi13() {
        return si13;
    }

    public void id1(ValueChangeEvent valueChangeEvent) {
    }

    public void setPb4(RichPanelBox pb4) {
        this.pb4 = pb4;
    }

    public RichPanelBox getPb4() {
        return pb4;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setPc3(RichPanelCollection pc3) {
        this.pc3 = pc3;
    }

    public RichPanelCollection getPc3() {
        return pc3;
    }


    public void setT5(RichTable t5) {
        this.t5 = t5;
    }

    public RichTable getT5() {
        return t5;
    }

    public void setT6(RichTable t6) {
        this.t6 = t6;
    }

    public RichTable getT6() {
        return t6;
    }


    public void OnCollectCheckedCararks() {
        System.err.println("==COUNT==" + carparksVO.getEstimatedRowCount());

        if (carparksVO.getEstimatedRowCount() > 0) {

            RowSetIterator leaseAgreementVORS =
                carparksVO.createRowSetIterator(null);
            while (leaseAgreementVORS.hasNext()) {
                Row re = leaseAgreementVORS.next();
                System.err.println("CheckBox" +
                                   re.getAttribute("CheckBox_Trans"));


            }
        }
    }


    public void onSelectCheckbox(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        System.err.println(valueChangeEvent.getPhaseId());
        map.put(valueChangeEvent.getPhaseId().toString(),
                (Boolean)valueChangeEvent.getNewValue());
        System.err.println("valueChangeEvent" +
                           valueChangeEvent.getNewValue());

    }

    public void updateCheckbox(Object UnitId, Object OfferDtlID,
                               Object activeyn) {

        ViewCriteria offerDtlVC = BookingDtl.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        //1
        offerDtlVCR.setAttribute("UnitId", UnitId);
        offerDtlVCR.setAttribute("OfferDtlId", OfferDtlID);
        offerDtlVC.addRow(offerDtlVCR);
        BookingDtl.applyViewCriteria(offerDtlVC);
        BookingDtl.executeQuery();
        if (BookingDtl.first() != null) {
            BookingDtl.first().setAttribute("CheckBoxeYn", activeyn);
        }
        ADFUtils.findOperation("Commit").execute();

    }


    public void onSelectYN(ValueChangeEvent valueChangeEvent) {

        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //        map.put(valueChangeEvent.getPhaseId().toString(),
        //                (Boolean)valueChangeEvent.getNewValue());
        System.err.println("valueChangeEvent" +
                           valueChangeEvent.getNewValue());

    }


    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }

    public void setPgl5(RichPanelGridLayout pgl5) {
        this.pgl5 = pgl5;
    }

    public RichPanelGridLayout getPgl5() {
        return pgl5;
    }

    public void setGr2(RichGridRow gr2) {
        this.gr2 = gr2;
    }

    public RichGridRow getGr2() {
        return gr2;
    }

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }

    public void setGc4(RichGridCell gc4) {
        this.gc4 = gc4;
    }

    public RichGridCell getGc4() {
        return gc4;
    }

    public void setOt17(RichOutputText ot17) {
        this.ot17 = ot17;
    }

    public RichOutputText getOt17() {
        return ot17;
    }

    public void setTrans_SmartSearchLeaseIdId(RichInputListOfValues trans_SmartSearchLeaseIdId) {
        this.trans_SmartSearchLeaseIdId = trans_SmartSearchLeaseIdId;
    }

    public RichInputListOfValues getTrans_SmartSearchLeaseIdId() {
        return trans_SmartSearchLeaseIdId;
    }

    public void setLeaseNumberSmartSearch_TransId(RichInputListOfValues leaseNumberSmartSearch_TransId) {
        this.leaseNumberSmartSearch_TransId = leaseNumberSmartSearch_TransId;
    }

    public RichInputListOfValues getLeaseNumberSmartSearch_TransId() {
        return leaseNumberSmartSearch_TransId;
    }


    public void setIt18(RichInputText it18) {
        this.it18 = it18;
    }

    public RichInputText getIt18() {
        return it18;
    }

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
    }

    public void setSi16(UISelectItems si16) {
        this.si16 = si16;
    }

    public UISelectItems getSi16() {
        return si16;
    }
}
