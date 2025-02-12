package model.VO;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import model.EO.OtherChargesHeader_EOImpl;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 14 09:08:14 IST 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OcDpHdr_VORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        OcHdrId {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getOcHdrId();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setOcHdrId((BigDecimal)value);
            }
        }
        ,
        OtherChargesNumber {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getOtherChargesNumber();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setOtherChargesNumber((String)value);
            }
        }
        ,
        OcFlag {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getOcFlag();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setOcFlag((String)value);
            }
        }
        ,
        DestinationBu {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getDestinationBu();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setDestinationBu((BigDecimal)value);
            }
        }
        ,
        CustId {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getCustId();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setCustId((BigDecimal)value);
            }
        }
        ,
        BillToAddre {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getBillToAddre();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setBillToAddre((String)value);
            }
        }
        ,
        ShipToAddre {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getShipToAddre();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setShipToAddre((String)value);
            }
        }
        ,
        PropertyId {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getPropertyId();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setPropertyId((Number)value);
            }
        }
        ,
        BuildingId {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getBuildingId();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setBuildingId((Number)value);
            }
        }
        ,
        UnitId {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getUnitId();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setUnitId((BigDecimal)value);
            }
        }
        ,
        OthersTotalRate {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getOthersTotalRate();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setOthersTotalRate((BigDecimal)value);
            }
        }
        ,
        ReceiptTotal {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getReceiptTotal();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setReceiptTotal((BigDecimal)value);
            }
        }
        ,
        GlDate {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getGlDate();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setGlDate((Date)value);
            }
        }
        ,
        FuncId {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getFuncId();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setFuncId((BigDecimal)value);
            }
        }
        ,
        FlowWith {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getFlowWith();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setFlowWith((BigDecimal)value);
            }
        }
        ,
        FlowStatus {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getFlowStatus();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setFlowStatus((String)value);
            }
        }
        ,
        FlowLevel {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getFlowLevel();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setFlowLevel((BigDecimal)value);
            }
        }
        ,
        CustomerTrxnId {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getCustomerTrxnId();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setCustomerTrxnId((BigDecimal)value);
            }
        }
        ,
        CustomerTrxnNum {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getCustomerTrxnNum();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setCustomerTrxnNum((String)value);
            }
        }
        ,
        CreationDate {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getCreationDate();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setCreationDate((Timestamp)value);
            }
        }
        ,
        CreatedBy {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        LastUpdateDate {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getLastUpdateDate();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setLastUpdateDate((Timestamp)value);
            }
        }
        ,
        LastUpdatedBy {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getLastUpdatedBy();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setLastUpdatedBy((String)value);
            }
        }
        ,
        LastUpdateLogin {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getLastUpdateLogin();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setLastUpdateLogin((String)value);
            }
        }
        ,
        Status {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getStatus();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setStatus((String)value);
            }
        }
        ,
        IntegrationResponse {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getIntegrationResponse();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setIntegrationResponse((String)value);
            }
        }
        ,
        CreateDate {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getCreateDate();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setCreateDate((Date)value);
            }
        }
        ,
        Cust_Name_Trans {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getCust_Name_Trans();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setCust_Name_Trans((String)value);
            }
        }
        ,
        TnxTypeLandlord {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getTnxTypeLandlord();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setTnxTypeLandlord((String)value);
            }
        }
        ,
        CashInvolved {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getCashInvolved();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setCashInvolved((String)value);
            }
        }
        ,
        LandlordName {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getLandlordName();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setLandlordName((String)value);
            }
        }
        ,
        ReceiptCreation {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getReceiptCreation();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setReceiptCreation((String)value);
            }
        }
        ,
        TrxDate {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getTrxDate();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setTrxDate((Date)value);
            }
        }
        ,
        OcBkMilestoneDtlDp_VO {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getOcBkMilestoneDtlDp_VO();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        OcReceiptDp_VO {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getOcReceiptDp_VO();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        getApprovalHistoryROVo {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getgetApprovalHistoryROVo();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        OcPropDtl_RoVo {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getOcPropDtl_RoVo();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        GetCustomerDetailsROVO1 {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getGetCustomerDetailsROVO1();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Org_ROVO1 {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getOrg_ROVO1();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Lookup_View_ROVO1 {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getLookup_View_ROVO1();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Lookup_View_ROVO2 {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getLookup_View_ROVO2();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Lookup_View_ROVO3 {
            public Object get(OcDpHdr_VORowImpl obj) {
                return obj.getLookup_View_ROVO3();
            }

            public void put(OcDpHdr_VORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(OcDpHdr_VORowImpl object);

        public abstract void put(OcDpHdr_VORowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int OCHDRID = AttributesEnum.OcHdrId.index();
    public static final int OTHERCHARGESNUMBER = AttributesEnum.OtherChargesNumber.index();
    public static final int OCFLAG = AttributesEnum.OcFlag.index();
    public static final int DESTINATIONBU = AttributesEnum.DestinationBu.index();
    public static final int CUSTID = AttributesEnum.CustId.index();
    public static final int BILLTOADDRE = AttributesEnum.BillToAddre.index();
    public static final int SHIPTOADDRE = AttributesEnum.ShipToAddre.index();
    public static final int PROPERTYID = AttributesEnum.PropertyId.index();
    public static final int BUILDINGID = AttributesEnum.BuildingId.index();
    public static final int UNITID = AttributesEnum.UnitId.index();
    public static final int OTHERSTOTALRATE = AttributesEnum.OthersTotalRate.index();
    public static final int RECEIPTTOTAL = AttributesEnum.ReceiptTotal.index();
    public static final int GLDATE = AttributesEnum.GlDate.index();
    public static final int FUNCID = AttributesEnum.FuncId.index();
    public static final int FLOWWITH = AttributesEnum.FlowWith.index();
    public static final int FLOWSTATUS = AttributesEnum.FlowStatus.index();
    public static final int FLOWLEVEL = AttributesEnum.FlowLevel.index();
    public static final int CUSTOMERTRXNID = AttributesEnum.CustomerTrxnId.index();
    public static final int CUSTOMERTRXNNUM = AttributesEnum.CustomerTrxnNum.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATELOGIN = AttributesEnum.LastUpdateLogin.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int INTEGRATIONRESPONSE = AttributesEnum.IntegrationResponse.index();
    public static final int CREATEDATE = AttributesEnum.CreateDate.index();
    public static final int CUST_NAME_TRANS = AttributesEnum.Cust_Name_Trans.index();
    public static final int TNXTYPELANDLORD = AttributesEnum.TnxTypeLandlord.index();
    public static final int CASHINVOLVED = AttributesEnum.CashInvolved.index();
    public static final int LANDLORDNAME = AttributesEnum.LandlordName.index();
    public static final int RECEIPTCREATION = AttributesEnum.ReceiptCreation.index();
    public static final int TRXDATE = AttributesEnum.TrxDate.index();
    public static final int OCBKMILESTONEDTLDP_VO = AttributesEnum.OcBkMilestoneDtlDp_VO.index();
    public static final int OCRECEIPTDP_VO = AttributesEnum.OcReceiptDp_VO.index();
    public static final int GETAPPROVALHISTORYROVO = AttributesEnum.getApprovalHistoryROVo.index();
    public static final int OCPROPDTL_ROVO = AttributesEnum.OcPropDtl_RoVo.index();
    public static final int GETCUSTOMERDETAILSROVO1 = AttributesEnum.GetCustomerDetailsROVO1.index();
    public static final int ORG_ROVO1 = AttributesEnum.Org_ROVO1.index();
    public static final int LOOKUP_VIEW_ROVO1 = AttributesEnum.Lookup_View_ROVO1.index();
    public static final int LOOKUP_VIEW_ROVO2 = AttributesEnum.Lookup_View_ROVO2.index();
    public static final int LOOKUP_VIEW_ROVO3 = AttributesEnum.Lookup_View_ROVO3.index();

    /**
     * This is the default constructor (do not remove).
     */
    public OcDpHdr_VORowImpl() {
    }

    /**
     * Gets OtherCharges_EO entity object.
     * @return the OtherCharges_EO
     */
    public OtherChargesHeader_EOImpl getOtherCharges_EO() {
        return (OtherChargesHeader_EOImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for OC_HDR_ID using the alias name OcHdrId.
     * @return the OC_HDR_ID
     */
    public BigDecimal getOcHdrId() {
        return (BigDecimal) getAttributeInternal(OCHDRID);
    }

    /**
     * Sets <code>value</code> as attribute value for OC_HDR_ID using the alias name OcHdrId.
     * @param value value to set the OC_HDR_ID
     */
    public void setOcHdrId(BigDecimal value) {
        setAttributeInternal(OCHDRID, value);
    }

    /**
     * Gets the attribute value for OTHER_CHARGES_NUMBER using the alias name OtherChargesNumber.
     * @return the OTHER_CHARGES_NUMBER
     */
    public String getOtherChargesNumber() {
        return (String) getAttributeInternal(OTHERCHARGESNUMBER);
    }

    /**
     * Sets <code>value</code> as attribute value for OTHER_CHARGES_NUMBER using the alias name OtherChargesNumber.
     * @param value value to set the OTHER_CHARGES_NUMBER
     */
    public void setOtherChargesNumber(String value) {
        setAttributeInternal(OTHERCHARGESNUMBER, value);
    }

    /**
     * Gets the attribute value for OC_FLAG using the alias name OcFlag.
     * @return the OC_FLAG
     */
    public String getOcFlag() {
        return (String) getAttributeInternal(OCFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for OC_FLAG using the alias name OcFlag.
     * @param value value to set the OC_FLAG
     */
    public void setOcFlag(String value) {
        setAttributeInternal(OCFLAG, value);
    }

    /**
     * Gets the attribute value for DESTINATION_BU using the alias name DestinationBu.
     * @return the DESTINATION_BU
     */
    public BigDecimal getDestinationBu() {
        return (BigDecimal) getAttributeInternal(DESTINATIONBU);
    }

    /**
     * Sets <code>value</code> as attribute value for DESTINATION_BU using the alias name DestinationBu.
     * @param value value to set the DESTINATION_BU
     */
    public void setDestinationBu(BigDecimal value) {
        setAttributeInternal(DESTINATIONBU, value);
    }

    /**
     * Gets the attribute value for CUST_ID using the alias name CustId.
     * @return the CUST_ID
     */
    public BigDecimal getCustId() {
        return (BigDecimal) getAttributeInternal(CUSTID);
    }

    /**
     * Sets <code>value</code> as attribute value for CUST_ID using the alias name CustId.
     * @param value value to set the CUST_ID
     */
    public void setCustId(BigDecimal value) {
        setAttributeInternal(CUSTID, value);
    }

    /**
     * Gets the attribute value for BILL_TO_ADDRE using the alias name BillToAddre.
     * @return the BILL_TO_ADDRE
     */
    public String getBillToAddre() {
        return (String) getAttributeInternal(BILLTOADDRE);
    }

    /**
     * Sets <code>value</code> as attribute value for BILL_TO_ADDRE using the alias name BillToAddre.
     * @param value value to set the BILL_TO_ADDRE
     */
    public void setBillToAddre(String value) {
        setAttributeInternal(BILLTOADDRE, value);
    }

    /**
     * Gets the attribute value for SHIP_TO_ADDRE using the alias name ShipToAddre.
     * @return the SHIP_TO_ADDRE
     */
    public String getShipToAddre() {
        return (String) getAttributeInternal(SHIPTOADDRE);
    }

    /**
     * Sets <code>value</code> as attribute value for SHIP_TO_ADDRE using the alias name ShipToAddre.
     * @param value value to set the SHIP_TO_ADDRE
     */
    public void setShipToAddre(String value) {
        setAttributeInternal(SHIPTOADDRE, value);
    }

    /**
     * Gets the attribute value for PROPERTY_ID using the alias name PropertyId.
     * @return the PROPERTY_ID
     */
    public Number getPropertyId() {
        return (Number)getAttributeInternal(PROPERTYID);
    }

    /**
     * Sets <code>value</code> as attribute value for PROPERTY_ID using the alias name PropertyId.
     * @param value value to set the PROPERTY_ID
     */
    public void setPropertyId(Number value) {
        setAttributeInternal(PROPERTYID, value);
    }

    /**
     * Gets the attribute value for BUILDING_ID using the alias name BuildingId.
     * @return the BUILDING_ID
     */
    public Number getBuildingId() {
        return (Number)getAttributeInternal(BUILDINGID);
    }

    /**
     * Sets <code>value</code> as attribute value for BUILDING_ID using the alias name BuildingId.
     * @param value value to set the BUILDING_ID
     */
    public void setBuildingId(Number value) {
        setAttributeInternal(BUILDINGID, value);
    }

    /**
     * Gets the attribute value for UNIT_ID using the alias name UnitId.
     * @return the UNIT_ID
     */
    public BigDecimal getUnitId() {
        return (BigDecimal) getAttributeInternal(UNITID);
    }

    /**
     * Sets <code>value</code> as attribute value for UNIT_ID using the alias name UnitId.
     * @param value value to set the UNIT_ID
     */
    public void setUnitId(BigDecimal value) {
        setAttributeInternal(UNITID, value);
    }

    /**
     * Gets the attribute value for OTHERS_TOTAL_RATE using the alias name OthersTotalRate.
     * @return the OTHERS_TOTAL_RATE
     */
    public BigDecimal getOthersTotalRate() {
        return (BigDecimal) getAttributeInternal(OTHERSTOTALRATE);
    }

    /**
     * Sets <code>value</code> as attribute value for OTHERS_TOTAL_RATE using the alias name OthersTotalRate.
     * @param value value to set the OTHERS_TOTAL_RATE
     */
    public void setOthersTotalRate(BigDecimal value) {
        setAttributeInternal(OTHERSTOTALRATE, value);
    }

    /**
     * Gets the attribute value for RECEIPT_TOTAL using the alias name ReceiptTotal.
     * @return the RECEIPT_TOTAL
     */
    public BigDecimal getReceiptTotal() {
        return (BigDecimal) getAttributeInternal(RECEIPTTOTAL);
    }

    /**
     * Sets <code>value</code> as attribute value for RECEIPT_TOTAL using the alias name ReceiptTotal.
     * @param value value to set the RECEIPT_TOTAL
     */
    public void setReceiptTotal(BigDecimal value) {
        setAttributeInternal(RECEIPTTOTAL, value);
    }

    /**
     * Gets the attribute value for GL_DATE using the alias name GlDate.
     * @return the GL_DATE
     */
    public Date getGlDate() {
        return (Date) getAttributeInternal(GLDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for GL_DATE using the alias name GlDate.
     * @param value value to set the GL_DATE
     */
    public void setGlDate(Date value) {
        setAttributeInternal(GLDATE, value);
    }

    /**
     * Gets the attribute value for FUNC_ID using the alias name FuncId.
     * @return the FUNC_ID
     */
    public BigDecimal getFuncId() {
        return (BigDecimal) getAttributeInternal(FUNCID);
    }

    /**
     * Sets <code>value</code> as attribute value for FUNC_ID using the alias name FuncId.
     * @param value value to set the FUNC_ID
     */
    public void setFuncId(BigDecimal value) {
        setAttributeInternal(FUNCID, value);
    }

    /**
     * Gets the attribute value for FLOW_WITH using the alias name FlowWith.
     * @return the FLOW_WITH
     */
    public BigDecimal getFlowWith() {
        return (BigDecimal) getAttributeInternal(FLOWWITH);
    }

    /**
     * Sets <code>value</code> as attribute value for FLOW_WITH using the alias name FlowWith.
     * @param value value to set the FLOW_WITH
     */
    public void setFlowWith(BigDecimal value) {
        setAttributeInternal(FLOWWITH, value);
    }

    /**
     * Gets the attribute value for FLOW_STATUS using the alias name FlowStatus.
     * @return the FLOW_STATUS
     */
    public String getFlowStatus() {
        return (String) getAttributeInternal(FLOWSTATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for FLOW_STATUS using the alias name FlowStatus.
     * @param value value to set the FLOW_STATUS
     */
    public void setFlowStatus(String value) {
        setAttributeInternal(FLOWSTATUS, value);
    }

    /**
     * Gets the attribute value for FLOW_LEVEL using the alias name FlowLevel.
     * @return the FLOW_LEVEL
     */
    public BigDecimal getFlowLevel() {
        return (BigDecimal) getAttributeInternal(FLOWLEVEL);
    }

    /**
     * Sets <code>value</code> as attribute value for FLOW_LEVEL using the alias name FlowLevel.
     * @param value value to set the FLOW_LEVEL
     */
    public void setFlowLevel(BigDecimal value) {
        setAttributeInternal(FLOWLEVEL, value);
    }

    /**
     * Gets the attribute value for CUSTOMER_TRXN_ID using the alias name CustomerTrxnId.
     * @return the CUSTOMER_TRXN_ID
     */
    public BigDecimal getCustomerTrxnId() {
        return (BigDecimal) getAttributeInternal(CUSTOMERTRXNID);
    }

    /**
     * Sets <code>value</code> as attribute value for CUSTOMER_TRXN_ID using the alias name CustomerTrxnId.
     * @param value value to set the CUSTOMER_TRXN_ID
     */
    public void setCustomerTrxnId(BigDecimal value) {
        setAttributeInternal(CUSTOMERTRXNID, value);
    }

    /**
     * Gets the attribute value for CUSTOMER_TRXN_NUM using the alias name CustomerTrxnNum.
     * @return the CUSTOMER_TRXN_NUM
     */
    public String getCustomerTrxnNum() {
        return (String) getAttributeInternal(CUSTOMERTRXNNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for CUSTOMER_TRXN_NUM using the alias name CustomerTrxnNum.
     * @param value value to set the CUSTOMER_TRXN_NUM
     */
    public void setCustomerTrxnNum(String value) {
        setAttributeInternal(CUSTOMERTRXNNUM, value);
    }

    /**
     * Gets the attribute value for CREATION_DATE using the alias name CreationDate.
     * @return the CREATION_DATE
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATION_DATE using the alias name CreationDate.
     * @param value value to set the CREATION_DATE
     */
    public void setCreationDate(Timestamp value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**
     * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
     * @return the CREATED_BY
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy.
     * @param value value to set the CREATED_BY
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for LAST_UPDATE_DATE using the alias name LastUpdateDate.
     * @return the LAST_UPDATE_DATE
     */
    public Timestamp getLastUpdateDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for LAST_UPDATE_DATE using the alias name LastUpdateDate.
     * @param value value to set the LAST_UPDATE_DATE
     */
    public void setLastUpdateDate(Timestamp value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**
     * Gets the attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @return the LAST_UPDATED_BY
     */
    public String getLastUpdatedBy() {
        return (String) getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @param value value to set the LAST_UPDATED_BY
     */
    public void setLastUpdatedBy(String value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for LAST_UPDATE_LOGIN using the alias name LastUpdateLogin.
     * @return the LAST_UPDATE_LOGIN
     */
    public String getLastUpdateLogin() {
        return (String) getAttributeInternal(LASTUPDATELOGIN);
    }

    /**
     * Sets <code>value</code> as attribute value for LAST_UPDATE_LOGIN using the alias name LastUpdateLogin.
     * @param value value to set the LAST_UPDATE_LOGIN
     */
    public void setLastUpdateLogin(String value) {
        setAttributeInternal(LASTUPDATELOGIN, value);
    }

    /**
     * Gets the attribute value for STATUS using the alias name Status.
     * @return the STATUS
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for STATUS using the alias name Status.
     * @param value value to set the STATUS
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for INTEGRATION_RESPONSE using the alias name IntegrationResponse.
     * @return the INTEGRATION_RESPONSE
     */
    public String getIntegrationResponse() {
        return (String) getAttributeInternal(INTEGRATIONRESPONSE);
    }

    /**
     * Sets <code>value</code> as attribute value for INTEGRATION_RESPONSE using the alias name IntegrationResponse.
     * @param value value to set the INTEGRATION_RESPONSE
     */
    public void setIntegrationResponse(String value) {
        setAttributeInternal(INTEGRATIONRESPONSE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CreateDate.
     * @return the CreateDate
     */
    public Date getCreateDate() {
        return (Date) getAttributeInternal(CREATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CreateDate.
     * @param value value to set the  CreateDate
     */
    public void setCreateDate(Date value) {
        setAttributeInternal(CREATEDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Cust_Name_Trans.
     * @return the Cust_Name_Trans
     */
    public String getCust_Name_Trans() {
        String custName=null;
                         if (getCustId()!= null) {
                             Row[] deptRows;
                             deptRows =
                                     getGetCustomerDetailsROVO1().getFilteredRows("CustId", getCustId());
                             if (deptRows.length > 0) {
                                 custName = deptRows[0].getAttribute("CustomerName").toString();
                             }
                             return custName;
                         } else {
        return (String) getAttributeInternal(CUST_NAME_TRANS);
                         }
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Cust_Name_Trans.
     * @param value value to set the  Cust_Name_Trans
     */
    public void setCust_Name_Trans(String value) {
        setAttributeInternal(CUST_NAME_TRANS, value);
    }

    /**
     * Gets the attribute value for TNX_TYPE_LANDLORD using the alias name TnxTypeLandlord.
     * @return the TNX_TYPE_LANDLORD
     */
    public String getTnxTypeLandlord() {
        return (String) getAttributeInternal(TNXTYPELANDLORD);
    }

    /**
     * Sets <code>value</code> as attribute value for TNX_TYPE_LANDLORD using the alias name TnxTypeLandlord.
     * @param value value to set the TNX_TYPE_LANDLORD
     */
    public void setTnxTypeLandlord(String value) {
        setAttributeInternal(TNXTYPELANDLORD, value);
    }

    /**
     * Gets the attribute value for CASH_INVOLVED using the alias name CashInvolved.
     * @return the CASH_INVOLVED
     */
    public String getCashInvolved() {
        return (String) getAttributeInternal(CASHINVOLVED);
    }

    /**
     * Sets <code>value</code> as attribute value for CASH_INVOLVED using the alias name CashInvolved.
     * @param value value to set the CASH_INVOLVED
     */
    public void setCashInvolved(String value) {
        setAttributeInternal(CASHINVOLVED, value);
    }

    /**
     * Gets the attribute value for LANDLORD_NAME using the alias name LandlordName.
     * @return the LANDLORD_NAME
     */
    public String getLandlordName() {
        return (String) getAttributeInternal(LANDLORDNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for LANDLORD_NAME using the alias name LandlordName.
     * @param value value to set the LANDLORD_NAME
     */
    public void setLandlordName(String value) {
        setAttributeInternal(LANDLORDNAME, value);
    }

    /**
     * Gets the attribute value for RECEIPT_CREATION using the alias name ReceiptCreation.
     * @return the RECEIPT_CREATION
     */
    public String getReceiptCreation() {
        return (String) getAttributeInternal(RECEIPTCREATION);
    }

    /**
     * Sets <code>value</code> as attribute value for RECEIPT_CREATION using the alias name ReceiptCreation.
     * @param value value to set the RECEIPT_CREATION
     */
    public void setReceiptCreation(String value) {
        setAttributeInternal(RECEIPTCREATION, value);
    }

    /**
     * Gets the attribute value for TRX_DATE using the alias name TrxDate.
     * @return the TRX_DATE
     */
    public Date getTrxDate() {
        return (Date) getAttributeInternal(TRXDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for TRX_DATE using the alias name TrxDate.
     * @param value value to set the TRX_DATE
     */
    public void setTrxDate(Date value) {
        setAttributeInternal(TRXDATE, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link OcBkMilestoneDtlDp_VO.
     */
    public RowIterator getOcBkMilestoneDtlDp_VO() {
        return (RowIterator)getAttributeInternal(OCBKMILESTONEDTLDP_VO);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link OcReceiptDp_VO.
     */
    public RowIterator getOcReceiptDp_VO() {
        return (RowIterator)getAttributeInternal(OCRECEIPTDP_VO);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link getApprovalHistoryROVo.
     */
    public RowIterator getgetApprovalHistoryROVo() {
        return (RowIterator)getAttributeInternal(GETAPPROVALHISTORYROVO);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link OcPropDtl_RoVo.
     */
    public RowIterator getOcPropDtl_RoVo() {
        return (RowIterator)getAttributeInternal(OCPROPDTL_ROVO);
    }

    /**
     * Gets the view accessor <code>RowSet</code> GetCustomerDetailsROVO1.
     */
    public RowSet getGetCustomerDetailsROVO1() {
        return (RowSet)getAttributeInternal(GETCUSTOMERDETAILSROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> Org_ROVO1.
     */
    public RowSet getOrg_ROVO1() {
        return (RowSet)getAttributeInternal(ORG_ROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> Lookup_View_ROVO1.
     */
    public RowSet getLookup_View_ROVO1() {
        return (RowSet)getAttributeInternal(LOOKUP_VIEW_ROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> Lookup_View_ROVO2.
     */
    public RowSet getLookup_View_ROVO2() {
        return (RowSet)getAttributeInternal(LOOKUP_VIEW_ROVO2);
    }

    /**
     * Gets the view accessor <code>RowSet</code> Lookup_View_ROVO3.
     */
    public RowSet getLookup_View_ROVO3() {
        return (RowSet)getAttributeInternal(LOOKUP_VIEW_ROVO3);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
