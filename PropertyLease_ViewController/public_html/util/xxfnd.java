package util;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.server.ApplicationModuleImpl;

import oracle.jdbc.OracleTypes;

public class xxfnd {
    public xxfnd() {
        super();
    }


    private static Object[][] dobProcArgs = null;


    public static String reviseOffer(String offerNo, String userId,
                                     String AMDDataControl) {

        CallableStatement st = null;
        String returnmsg = "";
        double d1 = 0;
        String returnid = "";
        ApplicationModuleImpl applModule =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(AMDDataControl);
        String sql = " begin \n" +
            "             xxpm_offer_rev_pkg.revise_offer(:p_offer_num,:p_user_id ,:p_err_code,:p_err_msg);\n" +
            "             END;";

        st =
 applModule.getDBTransaction().createCallableStatement(sql, applModule.getDBTransaction().DEFAULT);


        Object offer_num = offerNo.toString();
        Object user_id = userId.toString();
        try {
            st.setObject("p_offer_num", offer_num);
            st.setObject("p_user_id", user_id);

            st.registerOutParameter("p_err_code", Types.VARCHAR);
            st.registerOutParameter("p_err_msg", Types.VARCHAR);


            st.execute();


            Object returni = st.getObject("p_err_msg").toString();
            //returnid=Double.toString(d1);
            returnmsg = returni.toString();


        } catch (SQLException sqle) {
            return "Failed to prepare for delivery11";
        } catch (Exception e) {
            return "Failed to prepare for delivery12";
        }

        finally {
            try {
                if (st != null && !st.isClosed()) {

                    st.close();
                }
            } catch (SQLException e) {
                return "Failed to prepare for delivery13";

            }


        }

        return returnmsg;
    }

    public static String generateDocNo(String lookupValue,
                                       String AMDDataControl) {

        CallableStatement st = null;
        String returnmsg = "";
        double d1 = 0;
        String returnid = "";
        ApplicationModuleImpl applModule =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(AMDDataControl);
        String sql = " begin \n" +
            "             xxfnd_pkg.get_next_number(:p_func_code,:p_next_num ,:p_func_id,:p_err_code,:p_err_msg);\n" +
            "             END;";

        st =
 applModule.getDBTransaction().createCallableStatement(sql, applModule.getDBTransaction().DEFAULT);


        Object obj = lookupValue.toString();
        try {
            st.setObject("p_func_code", obj);
            st.registerOutParameter("p_next_num", Types.VARCHAR);
            st.registerOutParameter("p_func_id", Types.NUMERIC);
            st.registerOutParameter("p_err_code", Types.VARCHAR);
            st.registerOutParameter("p_err_msg", Types.VARCHAR);


            st.execute();


            Object returni = st.getObject("p_next_num").toString();
            //returnid=Double.toString(d1);
            returnmsg = returni.toString();


        } catch (SQLException sqle) {
            return "Failed to prepare for delivery11";
        } catch (Exception e) {
            return "Failed to prepare for delivery12";
        }

        finally {
            try {
                if (st != null && !st.isClosed()) {

                    st.close();
                }
            } catch (SQLException e) {
                return "Failed to prepare for delivery13";

            }


        }

        return returnmsg;
    }


    public static String invokeSubmitPkg(String submitPkg, Object func_id,
                                         Object ref_id, Object level_no,
                                         String tableName,
                                         String app_status_column,
                                         String pk_column, Object attribute1,
                                         Object attribute2, Object attribute3,
                                         Object attribute4,
                                         Object attribute5) throws SQLException {

        String flag = null;
        String pkgMethod = "call " + submitPkg + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        oracle.jbo.domain.Number p_func_id =
            new oracle.jbo.domain.Number(func_id.toString()); //func_id.toString()
        oracle.jbo.domain.Number p_ref_id =
            new oracle.jbo.domain.Number(ref_id.toString());
        oracle.jbo.domain.Number p_level_no =
            new oracle.jbo.domain.Number(level_no.toString());
        // int p_level_no=Integer.parseInt(level_no.toString());
        String p_table_name = tableName;
        String p_app_status_column = app_status_column;
        String p_pk_column = pk_column;
        String p_flow_with = null;
        String p_attribute1 = attribute1 == null ? "" : attribute1.toString();
        String p_attribute2 = attribute2 == null ? "" : attribute2.toString();
        String p_attribute3 = attribute3 == null ? "" : attribute3.toString();
        String p_attribute4 = attribute4 == null ? "" : attribute4.toString();
        String p_attribute5 = attribute5 == null ? "" : attribute5.toString();

        String p_err_code = null;
        String p_err_msg = null;

        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);

        dobProcArgs =
                new Object[][] { { "IN", p_func_id, OracleTypes.NUMBER }, //0
                    { "IN", p_ref_id, OracleTypes.NUMBER }, //1
                    { "IN", p_level_no, OracleTypes.NUMBER }, //2
                    { "IN", p_table_name, OracleTypes.VARCHAR }, //3
                    { "IN", p_app_status_column, OracleTypes.VARCHAR }, //4
                    { "IN", p_pk_column, OracleTypes.VARCHAR }, //5
                    { "IN", p_attribute1, OracleTypes.VARCHAR }, //6
                    { "IN", p_attribute2, OracleTypes.VARCHAR }, //7
                    { "IN", p_attribute3, OracleTypes.VARCHAR }, //8
                    { "IN", p_attribute4, OracleTypes.VARCHAR }, //9
                    { "IN", p_attribute5, OracleTypes.VARCHAR }, //10
                    { "OUT", p_err_code, OracleTypes.VARCHAR }, //11
                    { "OUT", p_err_msg, OracleTypes.VARCHAR }, //12
                    } ;

        try {
            DBUtils.callDBStoredProcedure(am.getDBTransaction(), pkgMethod,
                                          dobProcArgs);
            flag = (String)dobProcArgs[12][1];


        } catch (SQLException e) {
            flag = (String)dobProcArgs[12][1];

        }
        return flag;
    }

    public static String invokeResponsePkg(String responsePkg, Object func_id,
                                           Object ref_id, Object user_id,
                                           Object level_no, Object appr_id,
                                           String response, String ar_status,
                                           Object fwd_to, String tableName,
                                           String status_column,
                                           String pk_column) throws SQLException {
        String flag = null;
        String returnArray[] = null;
        String pkgMethod =
            "call " + responsePkg + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object uu = null;
        ADFContext.getCurrent().getSessionScope().put("StatusFlow", null);
        oracle.jbo.domain.Number p_func_id =
            new oracle.jbo.domain.Number(func_id.toString());
        oracle.jbo.domain.Number p_ref_id =
            new oracle.jbo.domain.Number(ref_id.toString());
        oracle.jbo.domain.Number p_user_grp_id =
            new oracle.jbo.domain.Number(user_id.toString());
        oracle.jbo.domain.Number p_level_no =
            new oracle.jbo.domain.Number(level_no.toString());
        oracle.jbo.domain.Number p_appr_id =
            new oracle.jbo.domain.Number(appr_id.toString());

        String p_response = response;
        String p_ar_status = ar_status;
        oracle.jbo.domain.Number p_fwd_to =
            new oracle.jbo.domain.Number(fwd_to.toString());
        String p_table_name = tableName;
        String p_status_column = status_column;
        String p_pk_column = pk_column;
        String p_flow_status = null;
        String p_err_code = null;
        String p_err_msg = null;


        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
        dobProcArgs =
                new Object[][] { { "IN", p_func_id, OracleTypes.NUMBER }, //0
                    { "IN", p_ref_id, OracleTypes.NUMBER },
                    { "IN", p_user_grp_id, OracleTypes.NUMBER }, //1
                    { "IN", p_level_no, OracleTypes.NUMBER }, //2
                    { "IN", p_appr_id, OracleTypes.NUMBER }, //3
                    { "IN", p_response, OracleTypes.VARCHAR }, //4
                    { "IN", p_ar_status, OracleTypes.VARCHAR }, //5
                    { "IN", p_fwd_to, OracleTypes.NUMBER }, //6
                    { "IN", p_table_name, OracleTypes.VARCHAR }, //7
                    { "IN", p_status_column, OracleTypes.VARCHAR }, //8
                    { "IN", p_pk_column, OracleTypes.VARCHAR },
                    { "OUT", p_flow_status, OracleTypes.NUMBER },
                    { "OUT", p_err_code, OracleTypes.VARCHAR }, //10
                    { "OUT", p_err_msg, OracleTypes.VARCHAR } //11
                    } ;

        try {
            DBUtils.callDBStoredProcedure(am.getDBTransaction(), pkgMethod,
                                          dobProcArgs);

            System.err.println("p_flow_status" + (String)dobProcArgs[13][1]);

            Object re = (String)dobProcArgs[13][1];

            ADFContext.getCurrent().getSessionScope().put("StatusFlow", re);

            // uu = dobProcArgs[11][1];


        } catch (SQLException e) {
        }

        flag = (String)dobProcArgs[13][1];
        //returnArray[1] = uu==null?"0":uu.toString();


        return flag;
    }


    public static Map<String, BigDecimal> invokeResponsePkgs(String responsePkg,
                                                             Object func_id,
                                                             Object ref_id,
                                                             Object user_id,
                                                             Object level_no,
                                                             Object appr_id,
                                                             String response,
                                                             String ar_status,
                                                             Object fwd_to,
                                                             String tableName,
                                                             String status_column,
                                                             String pk_column) throws SQLException {
        String flag = null;
        String returnArray[] = null;
        String pkgMethod =
            "call " + responsePkg + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object uu = null;
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();

        oracle.jbo.domain.Number p_func_id =
            new oracle.jbo.domain.Number(func_id.toString());
        oracle.jbo.domain.Number p_ref_id =
            new oracle.jbo.domain.Number(ref_id.toString());
        oracle.jbo.domain.Number p_user_grp_id =
            new oracle.jbo.domain.Number(user_id.toString());
        oracle.jbo.domain.Number p_level_no =
            new oracle.jbo.domain.Number(level_no.toString());
        oracle.jbo.domain.Number p_appr_id =
            new oracle.jbo.domain.Number(appr_id.toString());

        String p_response = response;
        String p_ar_status = ar_status;
        oracle.jbo.domain.Number p_fwd_to =
            new oracle.jbo.domain.Number(fwd_to.toString());
        String p_table_name = tableName;
        String p_status_column = status_column;
        String p_pk_column = pk_column;
        String p_flow_status = null;
        String p_err_code = null;
        String p_err_msg = null;


        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
        dobProcArgs =
                new Object[][] { { "IN", p_func_id, OracleTypes.NUMBER }, //0
                    { "IN", p_ref_id, OracleTypes.NUMBER },
                    { "IN", p_user_grp_id, OracleTypes.NUMBER }, //1
                    { "IN", p_level_no, OracleTypes.NUMBER }, //2
                    { "IN", p_appr_id, OracleTypes.NUMBER }, //3
                    { "IN", p_response, OracleTypes.VARCHAR }, //4
                    { "IN", p_ar_status, OracleTypes.VARCHAR }, //5
                    { "IN", p_fwd_to, OracleTypes.NUMBER }, //6
                    { "IN", p_table_name, OracleTypes.VARCHAR }, //7
                    { "IN", p_status_column, OracleTypes.VARCHAR }, //8
                    { "IN", p_pk_column, OracleTypes.VARCHAR },
                    { "OUT", p_flow_status, OracleTypes.NUMBER },
                    { "OUT", p_err_code, OracleTypes.VARCHAR }, //10
                    { "OUT", p_err_msg, OracleTypes.VARCHAR } //11
                    } ;

        try {
            DBUtils.callDBStoredProcedure(am.getDBTransaction(), pkgMethod,
                                          dobProcArgs);

            System.err.println("p_flow_status" +
                               (BigDecimal)dobProcArgs[11][1]);

            // ADFContext.getCurrent().getSessionScope().put("StatusFlow",
            //(BigDecimal)dobProcArgs[11][1]);

            //  uu = dobProcArgs[11][1];

            //  flag=(String)dobProcArgs[13][1]==null?"":(String)dobProcArgs[13][1];


        } catch (SQLException e) {
        }

        //returnArray[0] = dobProcArgs[11][1].;
        // returnArray[1] = (String)dobProcArgs[13][1];

        map.put((String)dobProcArgs[13][1], (BigDecimal)dobProcArgs[11][1]);

        return map;
    }


    public static String submitMailPkg(String submitMailPkg, String from,
                                       String to, String nameOfNofication,
                                       String noficationNumber,
                                       String User) throws SQLException {

        String flag = null;
        String pkgMethod = "call " + submitMailPkg + "(?,?,?,?,?,?,?)";
        String p_from = from;
        String p_to = to;
        String p_nameOfNofication = nameOfNofication;
        String p_noficationNumber = noficationNumber;
        String p_User = User;
        String p_err_code = null;
        String p_err_msg = null;

        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);

        dobProcArgs =
                new Object[][] { { "IN", p_from, OracleTypes.VARCHAR }, //0
                    { "IN", p_to, OracleTypes.VARCHAR }, //1
                    { "IN", p_nameOfNofication, OracleTypes.VARCHAR }, //2
                    { "IN", p_noficationNumber, OracleTypes.VARCHAR }, //3
                    { "IN", p_User, OracleTypes.VARCHAR }, //4
                    { "OUT", p_err_code, OracleTypes.VARCHAR }, //5
                    { "OUT", p_err_msg, OracleTypes.VARCHAR }, //6
                    } ;

        try {
            DBUtils.callDBStoredProcedure(am.getDBTransaction(), pkgMethod,
                                          dobProcArgs);
            flag = (String)dobProcArgs[6][1];
        } catch (SQLException e) {
            flag = (String)dobProcArgs[6][1];
        }
        return flag;
    }

    public static String priceListRenewal(String plid, String user,
                                          String AMDDataControl) {

        CallableStatement st = null;
        String returnmsg = "";
        double d1 = 0;
        String returnid = "";
        ApplicationModuleImpl applModule =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(AMDDataControl);
        String sql = " begin \n" +
            "             XXPM_PRICELIST_PKG.pll_main(:pl_revison_id,:p_user_id ,:p_err_code,:p_err_msg);\n" +
            "             END;";

        st =
 applModule.getDBTransaction().createCallableStatement(sql, applModule.getDBTransaction().DEFAULT);


        Object obj = plid.toString();
        Object users = user.toString();
        try {
            st.setObject("pl_revison_id", obj);
            st.setObject("p_user_id", users);
            st.registerOutParameter("p_err_code", Types.VARCHAR);
            st.registerOutParameter("p_err_msg", Types.VARCHAR);


            st.execute();


            Object returni = st.getObject("p_err_msg").toString();
            //returnid=Double.toString(d1);
            returnmsg = returni.toString();


        } catch (SQLException sqle) {
            return "Failed to prepare for delivery11";
        } catch (Exception e) {
            return "Failed to prepare for delivery12";
        }

        finally {
            try {
                if (st != null && !st.isClosed()) {

                    st.close();
                }
            } catch (SQLException e) {
                return "Failed to prepare for delivery13";

            }


        }

        return returnmsg;
    }


    public static String offerRenewal(String offer_num, String user,
                                      String AMDDataControl) {

        CallableStatement st = null;
        String returnmsg = "";
        double d1 = 0;
        String returnid = "";
        ApplicationModuleImpl applModule =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(AMDDataControl);
        String sql = " begin \n" +
            "             xxpm_offer_renew_pkg.autocreate(:p_offer_num,:p_user_id ,:p_err_code,:p_err_msg);\n" +
            "             END;";

        st =
 applModule.getDBTransaction().createCallableStatement(sql, applModule.getDBTransaction().DEFAULT);

        Object obj = offer_num.toString();
        Object users = user.toString();
        try {
            st.setObject("p_offer_num", obj);
            st.setObject("p_user_id", users);
            st.registerOutParameter("p_err_code", Types.VARCHAR);
            st.registerOutParameter("p_err_msg", Types.VARCHAR);
            st.execute();
            Object returni = st.getObject("p_err_msg").toString();
            returnmsg = returni.toString();

        } catch (SQLException sqle) {
            return "Failed to prepare for delivery11";
        } catch (Exception e) {
            return "Failed to prepare for delivery12";
        }

        finally {
            try {
                if (st != null && !st.isClosed()) {
                    st.close();
                }
            } catch (SQLException e) {
                return "Failed to prepare for delivery13";

            }
        }
        return returnmsg;
    }


    public static List extensionCalculation(String p_lease_id,
                                            String p_ext_day,
                                            String P_TRANS_TYPE,
                                            String AMDDataControl) {

        CallableStatement st = null;
        List list = new ArrayList();
        String returnMsg = "";
        String extensionAmount = "";
        ApplicationModuleImpl applModule =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(AMDDataControl);
        String sql = " begin \n" +
            "             XXPM_CAN_EXT_PKG.xxpm_extension_rates(:p_lease_id,:p_ext_day ,:P_TRANS_TYPE,:p_err_code,:p_err_msg,:p_rent_ext_amount);\n" +
            "             END;";

        st =
 applModule.getDBTransaction().createCallableStatement(sql, applModule.getDBTransaction().DEFAULT);

        try {
            //            System.err.println("==Lease Id==" + p_lease_id);
            //            System.err.println("==Ext days==" + p_ext_day);
            //            System.err.println("==screen type==" + P_TRANS_TYPE);
            st.setObject("p_lease_id", p_lease_id);
            st.setObject("p_ext_day", p_ext_day);
            st.setObject("P_TRANS_TYPE", P_TRANS_TYPE);
            st.registerOutParameter("p_err_code", Types.VARCHAR);
            st.registerOutParameter("p_err_msg", Types.VARCHAR);
            st.registerOutParameter("p_rent_ext_amount", Types.DOUBLE);
            st.execute();

            if (st.getObject("p_err_msg") != null) {
                returnMsg = st.getObject("p_err_msg").toString();
            } else {
                returnMsg = "Success";
            }
            list.add(returnMsg);
            if (st.getObject("p_rent_ext_amount") != null &&
                returnMsg.equalsIgnoreCase("Success")) {
                extensionAmount = st.getObject("p_rent_ext_amount").toString();
                //                System.err.println("==Extension o/p procdure call==" +
                //                                   extensionAmount);
            } else {
                extensionAmount = "";
            }
            list.add(extensionAmount);
        } catch (Exception e) {
            System.err.println("==Exception==" + e);
            list.add(e);
        } finally {
            try {
                if (st != null) {
                    //                    if (st != null && !st.isClosed()) {
                    st.close();
                }
            } catch (SQLException e) {
                list.add(e);
            }
        }
        return list;
    }
}
