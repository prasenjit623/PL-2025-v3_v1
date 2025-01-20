import java.math.BigDecimal;

import java.math.RoundingMode;

import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.OperationBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import util.ADFUtils;
import util.JSFUtils;
import util.xxfnd;

public class cancellation {
    //private RichPopup popup3;
    private RichInputText reason;
    private RichInputText popup5;
    private RichPopup poppp;
    private RichInputText res;
    private RichPopup PopUp;

    public cancellation() {
    }
    ViewObject cancelVO =
        ADFUtils.findIterator("ExtCanVO1Iterator").getViewObject();
    ViewObject BookingDtl =
        ADFUtils.findIterator("BookingDetail_VO1Iterator").getViewObject();
    ViewObject PropertyUnits_VO1 =
        ADFUtils.findIterator("PropertyUnits_VO1Iterator").getViewObject();
    ViewObject PropertyUnits_VO2 =
        ADFUtils.findIterator("PropertyUnits_VO2Iterator").getViewObject();

    ViewObject leaseAgreementVO =
        ADFUtils.findIterator("LeaseAgreement_VO1Iterator").getViewObject();

    ViewObject getOfferDetailsVO =
        ADFUtils.findIterator("offerDetailsforExtnandCancel_ROVO1Iterator").getViewObject();


    public void setUnitStatus() {


        ViewCriteria offerDtlVC = BookingDtl.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        offerDtlVCR.setAttribute("BookingId",
                                 cancelVO.getCurrentRow().getAttribute("BookingId"));
        offerDtlVC.addRow(offerDtlVCR);
        BookingDtl.applyViewCriteria(offerDtlVC);
        BookingDtl.executeQuery();

        RowSetIterator quoteMileRS = BookingDtl.createRowSetIterator(null);
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

    public void onAttributesSave() {

        ViewCriteria offerDtlVC = BookingDtl.createViewCriteria();
        ViewCriteriaRow offerDtlVCR = offerDtlVC.createViewCriteriaRow();
        offerDtlVCR.setAttribute("BookingId",
                                 cancelVO.getCurrentRow().getAttribute("BookingId"));
        offerDtlVC.addRow(offerDtlVCR);
        BookingDtl.applyViewCriteria(offerDtlVC);
        BookingDtl.executeQuery();

        if (BookingDtl.getEstimatedRowCount() > 0) {
            cancelVO.getCurrentRow().setAttribute("PropertyId",
                                                  BookingDtl.first().getAttribute("PropertyId"));
            cancelVO.getCurrentRow().setAttribute("BuildId",
                                                  BookingDtl.first().getAttribute("BuildingId"));
        }


    }


    public void onclicksave(ActionEvent actionEvent) {

        Row rw = cancelVO.getCurrentRow();
        //Mandatory fields validation
        if (rw.getAttribute("LeaseAgreementId") != null &&
            rw.getAttribute("TransDate") != null &&
            rw.getAttribute("DueDate") != null) {


            BigDecimal cancellationAmount = new BigDecimal(0);
            //get location name using function
            oracle.binding.OperationBinding obs =
                ADFUtils.findOperation("invokeLocationName");
            obs.getParamsMap().put("b_lease_id",
                                   cancelVO.getCurrentRow().getAttribute("LeaseAgreementId"));
            obs.execute();
            System.err.println("==LOCATION==" + obs.getResult());

            String locationName =
                obs.getResult() == null ? "" : obs.getResult().toString();
            String leaseId =
                rw.getAttribute("LeaseAgreementId") == null ? "N" :
                rw.getAttribute("LeaseAgreementId").toString();

            String reqDate =
                rw.getAttribute("TransDate") == null ? "" : rw.getAttribute("TransDate").toString();
            Date cancellationReqDate = new Date();
            try {
                cancellationReqDate =
                        new SimpleDateFormat("yyyy-MM-dd").parse(reqDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String dueDate =
                rw.getAttribute("DueDate") == null ? "" : rw.getAttribute("DueDate").toString();
            Date cancellationDueDate = new Date();
            try {
                cancellationDueDate =
                        new SimpleDateFormat("yyyy-MM-dd").parse(dueDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String leaseEndDateObj =
                rw.getAttribute("LeaseEndDateTrans") == null ? "" :
                rw.getAttribute("LeaseEndDateTrans").toString();
            Date leaseEndDate = new Date();
            try {
                leaseEndDate =
                        new SimpleDateFormat("yyyy-MM-dd").parse(leaseEndDateObj);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String leaseStartDateObj =
                rw.getAttribute("LeaseStartDateTrans") == null ? "" :
                rw.getAttribute("LeaseStartDateTrans").toString();
            Date leaseStartDate = new Date();
            try {
                leaseStartDate =
                        new SimpleDateFormat("yyyy-MM-dd").parse(leaseStartDateObj);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (rw.getAttribute("LEASE_TYPE_TRANS") == null ||
                rw.getAttribute("LEASE_TYPE_TRANS").equals("CAR_PARKING")) {
                if (leaseId != "N" && reqDate != null && dueDate != null) {

                    //Location validation
                    String ResVal =
                        carParkingCancellation(leaseId, cancellationReqDate,
                                               cancellationDueDate).toString();
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
                    if (rw.getAttribute("NetRefundAmount") == null) {
                        //Auto Number Generation
                        ViewObject getFuncodeVo =
                            ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                        getFuncodeVo.setNamedWhereClauseParam("F_ID", "CN");
                        getFuncodeVo.executeQuery();
                        Object Funcode =
                            getFuncodeVo.first().getAttribute("FuncId");
                        String Fcode =
                            Funcode == null ? "" : Funcode.toString();
                        ViewObject OfferHdrVo =
                            ADFUtils.findIterator("ExtCanVO1Iterator").getViewObject();
                        Row re = OfferHdrVo.getCurrentRow();
                        if (re.getAttribute("TransNumber") == null) {
                            String name =
                                xxfnd.generateDocNo("CN", "MoveInOut_AMDataControl").toString();
                            Object valu = name;
                            re.setAttribute("TransNumber", valu);
                            re.setAttribute("FuncId",
                                            getFuncodeVo.first().getAttribute("FuncId"));
                        } //End for Auto Number Generation

                        System.err.println("Net Refund Amount" +
                                           totalRefundAmountCP);
                        rw.setAttribute("NetRefundAmount",
                                        totalRefundAmountCP);
                        onAttributesSave();
                        JSFUtils.addFacesInformationMessage("Saved Successfully");
                        ADFUtils.findOperation("Commit").execute();
                    }
                }
            } else {
                long diffDays =
                    cancellationDueDate.getTime() - cancellationReqDate.getTime();

                int daysCount = (int)(diffDays / (1000 * 60 * 60 * 24));
                System.err.println("DIFF DAYS b/w Requ date and cancel date " +
                                   daysCount);
                if ((daysCount >= 30) &&
                    (cancellationDueDate.compareTo(leaseEndDate) <= 0) &&
                    cancellationReqDate.compareTo(leaseEndDate) <= 0) {
                    if (rw.getAttribute("CancellationAmount") == null &&
                        rw.getAttribute("NetRefundAmount") == null) {
                        ViewObject getFuncodeVo =
                            ADFUtils.findIterator("getFunctionCodeROVO1Iterator").getViewObject();
                        getFuncodeVo.setNamedWhereClauseParam("F_ID", "CN");
                        getFuncodeVo.executeQuery();
                        Object Funcode =
                            getFuncodeVo.first().getAttribute("FuncId");
                        String Fcode =
                            Funcode == null ? "" : Funcode.toString();
                        ViewObject OfferHdrVo =
                            ADFUtils.findIterator("ExtCanVO1Iterator").getViewObject();
                        Row re = OfferHdrVo.getCurrentRow();
                        if (re.getAttribute("TransNumber") == null) {
                            String name =
                                xxfnd.generateDocNo("CN", "MoveInOut_AMDataControl").toString();
                            Object valu = name;
                            re.setAttribute("TransNumber", valu);
                            re.setAttribute("FuncId",
                                            getFuncodeVo.first().getAttribute("FuncId"));
                        }
                        //No of remaining days Calculation
                        long remainingDays =
                            leaseEndDate.getTime() - cancellationDueDate.getTime();
                        int remainingDaysActual =
                            (int)(remainingDays / (1000 * 60 * 60 * 24));
                        System.err.println("No of Remaining Days " +
                                           remainingDaysActual);

                        //Lease start date and end date diffrence
                        long leasestartandEndDateDif =
                            leaseEndDate.getTime() - leaseStartDate.getTime();
                        int leasestartandEndDateDifActual =
                            (int)(leasestartandEndDateDif /
                                  (1000 * 60 * 60 * 24));
                        System.err.println("Lease Start & End date diff " +
                                           leasestartandEndDateDifActual);
                        int totalNoOfLeaseDays = leasestartandEndDateDifActual+1;

                        //Rent per day
                        String leaseAmountObj =
                            rw.getAttribute("Offer_Total_Trans") == null ? "" :
                            rw.getAttribute("Offer_Total_Trans").toString();
                        BigDecimal bigDecLeaseAmount =
                            new BigDecimal(leaseAmountObj);
                        float leaseAmount = bigDecLeaseAmount.floatValue();
                        float rentPerDay =
                            leaseAmount / totalNoOfLeaseDays;
                        System.err.println("==rent Per Day==" + rentPerDay);

                        //Refund Amount for remaining days
                        BigDecimal refund =
                            new BigDecimal(rentPerDay * remainingDaysActual);
                        System.err.println("==refund==" + refund);

                        if (locationName.equalsIgnoreCase("Sharjah")) {
                            //cancellation amount of Unit @ 30% for Sharjah
                            BigDecimal percentage = new BigDecimal(0.3);
                            cancellationAmount = refund.multiply(percentage);
                            System.err.println("==Cancellation Amount==" +
                                               cancellationAmount);
                            rw.setAttribute("CancellationAmount",
                                            cancellationAmount);
                        } else {
                            //cancellation amount for Dubai
                            BigDecimal percentage = new BigDecimal(60);
                            cancellationAmount = refund.multiply(percentage);
                            System.err.println("==Cancellation Amount==" +
                                               cancellationAmount);
                            rw.setAttribute("CancellationAmount",
                                            cancellationAmount);
                        }

                        //Net Refund Amount
                        BigDecimal actualRefundUnitFee =
                            refund.subtract(cancellationAmount);
                        System.err.println("==Refund Unit Fee==" +
                                           actualRefundUnitFee);

                        //Check the car parking is available for the normal units or not
                        if (leaseId != "N" && reqDate != null &&
                            dueDate != null) {
                            String ResVal =
                                carParkingCancellationforNormalUnits(leaseId,
                                                                     cancellationReqDate,
                                                                     cancellationDueDate).toString();
                            BigDecimal outCome = new BigDecimal(ResVal);
                            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("actualCarParkingRefund",
                                                                                        outCome);
                            System.err.println("==Outcome==" + outCome);
                        }

                        Object CarParkingRefundObj =
                            AdfFacesContext.getCurrentInstance().getPageFlowScope().get("actualCarParkingRefund") ==
                            null ? 0 :
                            AdfFacesContext.getCurrentInstance().getPageFlowScope().get("actualCarParkingRefund");
                        String s = CarParkingRefundObj.toString();
                        BigDecimal carParkingUnit = new BigDecimal(s);

                        BigDecimal totalRefundAmount =
                            actualRefundUnitFee.add(carParkingUnit);
                        System.err.println("Net Refund Amount" +
                                           totalRefundAmount);
                        rw.setAttribute("NetRefundAmount", totalRefundAmount);
                        onAttributesSave();
                        JSFUtils.addFacesInformationMessage("Saved Successfully");
                        ADFUtils.findOperation("Commit").execute();
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Review your Request Date & Cancellation Date once again, It should be less than the lease End Date");
                }
            }
            //*************************Date Validation End*********************************//

        } else {
            if (rw.getAttribute("LeaseAgreementId") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Lease Number");
            }
            if (rw.getAttribute("TransDate") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Request Date");
            }
            if (rw.getAttribute("DueDate") == null) {
                JSFUtils.addFacesErrorMessage("You must select a Cancellation Date");
            }
        }

    }

    public BigDecimal carParkingCancellation(String p_LeaseId, Date canReqDate,
                                             Date canDueDate) {
        Object leaseid = p_LeaseId;
        String flag = "N";
        BigDecimal carParkRefund = new BigDecimal(0);

        try {

            System.err.println("==Lease ID==" + p_LeaseId);
            ViewCriteria leaseAgreementVC =
                leaseAgreementVO.createViewCriteria();
            ViewCriteriaRow leaseAgreementVORow =
                leaseAgreementVC.createViewCriteriaRow();
            leaseAgreementVORow.setAttribute("LeaseAgreementId",
                                             leaseid); //CarParkLeaseAgreId
            leaseAgreementVC.addRow(leaseAgreementVORow);
            leaseAgreementVO.applyViewCriteria(leaseAgreementVC);
            leaseAgreementVO.executeQuery();
            System.err.println("==COUNT==" +
                               leaseAgreementVO.getEstimatedRowCount());

            if (leaseAgreementVO.getEstimatedRowCount() > 0) {

                RowSetIterator leaseAgreementVORS =
                    leaseAgreementVO.createRowSetIterator(null);
                while (leaseAgreementVORS.hasNext()) {
                    flag = "Y";

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
                    System.err.println("DIFF DAYS b/w Requ date and cancel date " +
                                       daysCountCP);

                    if ((daysCountCP >= 30) &&
                        (canDueDate.compareTo(CPLeaseEndDate) <= 0)) {

                        //No of remaining days Calculation
                        long remainingDaysCP =
                            CPLeaseEndDate.getTime() - canDueDate.getTime();
                        int remainingDaysActualCP =
                            (int)(remainingDaysCP / (1000 * 60 * 60 * 24));
                        System.err.println("No of Remaining Days " +
                                           remainingDaysActualCP);

                        //Lease start date and end date diffrence
                        long leasestartandEndDateDifCP =
                            CPLeaseEndDate.getTime() -
                            CPLeaseStartDate.getTime();
                        int leasestartandEndDateDifActualCP =
                            (int)(leasestartandEndDateDifCP /
                                  (1000 * 60 * 60 * 24));
                        int totalNoOfLeaseDays = leasestartandEndDateDifActualCP+1;

                        //Remaining Days
                        BigDecimal remainingDaysActualObj =
                            new BigDecimal(remainingDaysActualCP);
                        System.err.println("==Remaining Days==" +
                                           remainingDaysActualObj);

                        BigDecimal leaseSTEDDateDiff =
                            new BigDecimal(totalNoOfLeaseDays);
                        System.err.println("==Big Deci Lease Start & End date diff CP== " +
                                           leaseSTEDDateDiff);

                        //Offer Total
                        BigDecimal offerTotalCP =
                            new BigDecimal(OfferTotalObjCP);
                        System.err.println("==Offer Total==" + offerTotalCP);
                        //Rent Per day CP
                        BigDecimal rentPerDay =
                            offerTotalCP.divide(leaseSTEDDateDiff, 2,
                                                RoundingMode.HALF_UP);
                        System.err.println("==rent Per Day CP==" + rentPerDay);
                        //Refund Amount for remaining days
                        BigDecimal refundCP =
                            rentPerDay.multiply(remainingDaysActualObj);
                        System.err.println("==refundCP CP==" + refundCP);
                        //refundCP;
                        carParkRefund = carParkRefund.add(refundCP);

                        System.err.println("==TOTAL==" + carParkRefund);

                    } else {
                        JSFUtils.addFacesErrorMessage("Review your Car Parking Request Date & Cancellation Date once again, It should be less than the lease End Date");
                    }
                }
            }
        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error" + e);
        }
        return carParkRefund;
    }


    public BigDecimal carParkingCancellationforNormalUnits(String p_LeaseId,
                                                           Date canReqDate,
                                                           Date canDueDate) {
        BigDecimal carParkRefund = new BigDecimal(0);

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
                    System.err.println("DIFF DAYS b/w Requ date and cancel date " +
                                       daysCountCP);

                    if ((daysCountCP >= 30) &&
                        (canDueDate.compareTo(CPLeaseEndDate) <= 0)) {

                        //No of remaining days Calculation
                        long remainingDaysCP =
                            CPLeaseEndDate.getTime() - canDueDate.getTime();
                        int remainingDaysActualCP =
                            (int)(remainingDaysCP / (1000 * 60 * 60 * 24));
                        System.err.println("No of Remaining Days " +
                                           remainingDaysActualCP);

                        //Lease start date and end date diffrence
                        long leasestartandEndDateDifCP =
                            CPLeaseEndDate.getTime() -
                            CPLeaseStartDate.getTime();
                        int leasestartandEndDateDifActualCP =
                            (int)(leasestartandEndDateDifCP /
                                  (1000 * 60 * 60 * 24));
                        int totalNoOfLeaseDays = leasestartandEndDateDifActualCP+1;
                        
                        //Remaining Days
                        BigDecimal remainingDaysActualObj =
                            new BigDecimal(remainingDaysActualCP);
                        System.err.println("==Remaining Days==" +
                                           remainingDaysActualObj);

                        BigDecimal leaseSTEDDateDiff =
                            new BigDecimal(totalNoOfLeaseDays);
                        System.err.println("==Big Deci Lease Start & End date diff CP== " +
                                           leaseSTEDDateDiff);

                        //Offer Total
                        BigDecimal offerTotalCP =
                            new BigDecimal(OfferTotalObjCP);
                        System.err.println("==Offer Total==" + offerTotalCP);
                        //Rent Per day CP
                        BigDecimal rentPerDay =
                            offerTotalCP.divide(leaseSTEDDateDiff, 2,
                                                RoundingMode.HALF_UP);
                        System.err.println("==rent Per Day CP==" + rentPerDay);
                        //Refund Amount for remaining days
                        BigDecimal refundCP =
                            rentPerDay.multiply(remainingDaysActualObj);
                        System.err.println("==refundCP CP==" + refundCP);
                        //refundCP;
                        carParkRefund = carParkRefund.add(refundCP);

                        System.err.println("==TOTAL==" + carParkRefund);

                    } else {
                        JSFUtils.addFacesErrorMessage("Review your Car Parking Request Date & Cancellation Date once again, It should be less than the lease End Date");
                    }
                }
            }

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Error" + e);
        }
        return carParkRefund;
    }


    public void setCarparkUnitStatus() {
        ViewObject crvo =
            ADFUtils.findIterator("canExntCarParkStatusUpdateROVO1Iterator").getViewObject();
        crvo.setNamedWhereClauseParam("p_lease_id",
                                      cancelVO.getCurrentRow().getAttribute("LeaseAgreementId"));
        crvo.executeQuery();
        if (crvo.getEstimatedRowCount() > 0) {
            RowSetIterator leaseAgreementVORS =
                crvo.createRowSetIterator(null);
            while (leaseAgreementVORS.hasNext()) {
                Row re = leaseAgreementVORS.next();
                System.err.println("UNITID" + re.getAttribute("UnitId"));
                ViewCriteria vc = PropertyUnits_VO2.createViewCriteria();
                ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                vcRow.setAttribute("UnitId", re.getAttribute("UnitId"));
                vc.addRow(vcRow);
                PropertyUnits_VO2.applyViewCriteria(vc);
                PropertyUnits_VO2.executeQuery();
                Row res = PropertyUnits_VO2.first();
                res.setAttribute("Status", "AVAL");
            }
            ADFUtils.findOperation("Commit").execute();
        }
    }


    public void onClickApprove(ActionEvent actionEvent) {
        Map<String, BigDecimal> ResultVal = new HashMap<String, BigDecimal>();

        String Reason =
            this.res.getValue() == null ? "Approved" : this.res.getValue().toString();

        Row row = cancelVO.getCurrentRow();
        try {
            ResultVal =
                    xxfnd.invokeResponsePkgs("xxfnd_util_pkg.update_response",
                                             row.getAttribute("FuncId"),
                                             row.getAttribute("ExtnCanclId"),
                                             row.getAttribute("UserGrpId"),
                                             row.getAttribute("FlowLevel"),
                                             row.getAttribute("FlowWith"),
                                             Reason, "A", 0,
                                             "XXPM_EXTEN_CANCEL", "STATUS",
                                             "EXTN_CANCL_ID");


        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Map.Entry m : ResultVal.entrySet()) {
            System.out.println("KEY" + m.getKey() + "VALUE " + m.getValue());

            if (m.getKey().equals("Success")) {
                //cancelVO.executeQuery();

                String ress =
                    m.getValue() == null ? "null" : m.getValue().toString();
                if (ress.equals("null")) {
                    setUnitStatus();
                    setCarparkUnitStatus();

                }
                JSFUtils.addFacesInformationMessage("Approved Successfully");
            } else {
                JSFUtils.addFacesErrorMessage("Error in Approve process!");
            }

        }
    }


    public void onClickReject(ActionEvent actionEvent) {
        String ResultVal = null;
        String Reason =
            this.res.getValue() == null ? "Rejected" : this.res.getValue().toString();
        Row row = cancelVO.getCurrentRow();


        try {
            ResultVal =
                    xxfnd.invokeResponsePkg("xxfnd_util_pkg.update_response",
                                            row.getAttribute("FuncId"),
                                            row.getAttribute("ExtnCanclId"),
                                            row.getAttribute("UserGrpId"),
                                            row.getAttribute("FlowLevel"),
                                            row.getAttribute("FlowWith"),
                                            Reason, "R", 0,
                                            "XXPM_EXTEN_CANCEL", "STATUS",
                                            "EXTN_CANCL_ID");
        } catch (SQLException e) {
            e.printStackTrace();

        }
        if (ResultVal.equalsIgnoreCase("Success")) {
            cancelVO.executeQuery();
            JSFUtils.addFacesInformationMessage("Rejected Successfully");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Approve process!");
        }

    }


    public void onClickSubmit(ActionEvent actionEvent) {

        onclicksave(actionEvent);
        String ResultVal = null;
        Row row = cancelVO.getCurrentRow();
        Object org = cancelVO.getCurrentRow().getAttribute("OrgId");
        Object prop = cancelVO.getCurrentRow().getAttribute("PropertyId");
        Object unit = cancelVO.getCurrentRow().getAttribute("BuildId");

        try {
            ResultVal =
                    xxfnd.invokeSubmitPkg("xxfnd_util_pkg.submit_for_approval",
                                          row.getAttribute("FuncId"),
                                          row.getAttribute("ExtnCanclId"), 0,
                                          "XXPM_EXTEN_CANCEL", "STATUS",
                                          "EXTN_CANCL_ID", org, prop, unit,
                                          null, null);
        } catch (SQLException e) {
            System.err.println("ERROR" + e.toString());
        }

        if (ResultVal.equalsIgnoreCase("Success")) {
            JSFUtils.addFacesInformationMessage("Submitted For Approval");
        } else {
            JSFUtils.addFacesErrorMessage("Error in Submission Process...!" +
                                          ResultVal);
            System.err.println("RESULT" + ResultVal);
        }
    }

    public void onclickAppOrRej(ActionEvent actionEvent) {
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
        RichPopup.PopupHints popup34 = new RichPopup.PopupHints();
        this.getPoppp().show(popup34);

    }

    //    public void .reasontPopup3(RichPopup popup3) {
    //        this.popup3 = popup3;
    //    }
    //
    //    public RichPopup getPopup3() {
    //        return popup3;
    //    }


    public String onClickReceiptTaskFlow() {
        ViewObject offerHrdVO =
            ADFUtils.findIterator("ExtCanVO1Iterator").getViewObject();
        ViewObject bookCustVO =
            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        ViewCriteria vc = bookCustVO.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("BookingId",
                           offerHrdVO.getCurrentRow().getAttribute("BookingId"));
        vc.addRow(vcRow);
        bookCustVO.applyViewCriteria(vc);
        bookCustVO.executeQuery();

        Row cusRow = bookCustVO.first();
        ViewObject vo =
            ADFUtils.findIterator("BookingHeader_VO1Iterator").getViewObject();
        //        ViewObject bookCustVO =
        //            ADFUtils.findIterator("BookingCustomer_VO1Iterator").getViewObject();
        ViewCriteria vcs = vo.createViewCriteria();
        ViewCriteriaRow vcRows = vcs.createViewCriteriaRow();
        vcRows.setAttribute("BookingId",
                            offerHrdVO.getCurrentRow().getAttribute("BookingId"));
        vcs.addRow(vcRows);
        vo.applyViewCriteria(vcs);
        vo.executeQuery();

        Row row = vo.first();


        ADFContext.getCurrent().getPageFlowScope().put("CustName",
                                                       cusRow.getAttribute("CustName") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustName"));
        ADFContext.getCurrent().getPageFlowScope().put("CustBankName",
                                                       cusRow.getAttribute("CustBankName") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustBankName"));
        ADFContext.getCurrent().getPageFlowScope().put("CustBankAccNumber",
                                                       cusRow.getAttribute("CustBankAccNumber") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustBankAccNumber"));
        ADFContext.getCurrent().getPageFlowScope().put("CustBranchName",
                                                       cusRow.getAttribute("CustBranchName") ==
                                                       null ? "" :
                                                       cusRow.getAttribute("CustBranchName"));
        ADFContext.getCurrent().getPageFlowScope().put("BookingId",
                                                       offerHrdVO.getCurrentRow().getAttribute("BookingId") ==
                                                       null ? "" :
                                                       offerHrdVO.getCurrentRow().getAttribute("BookingId"));
        ADFContext.getCurrent().getPageFlowScope().put("Amount",
                                                       offerHrdVO.getCurrentRow().getAttribute("Amount") ==
                                                       null ? "" :
                                                       offerHrdVO.getCurrentRow().getAttribute("Amount"));

        //#{pageFlowScope.InstallmentAmount}


        return "toReceipt";
    }


    public String onClickCancelAction() {
        String M = (String)ADFUtils.evaluateEL("#{sessionScope.transno}");

        if (M == null) {
            ADFUtils.findOperation("Rollback").execute();
        } else {
            return "LA";
        }

        return "goBack";

    }

    public void setPopup5(RichInputText popup5) {
        this.popup5 = popup5;
    }

    public RichInputText getPopup5() {
        return popup5;
    }

    public void setPoppp(RichPopup poppp) {
        this.poppp = poppp;
    }

    public RichPopup getPoppp() {
        return poppp;
    }

    public void setRes(RichInputText res) {
        this.res = res;
    }

    public RichInputText getRes() {
        return res;
    }
}
