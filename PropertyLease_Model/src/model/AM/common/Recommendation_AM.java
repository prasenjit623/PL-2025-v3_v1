package model.AM.common;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 09 14:41:19 IST 2018
// ---------------------------------------------------------------------
public interface Recommendation_AM extends ApplicationModule {
    String InvokeReceiptStatus(String bookid, String milesid);

    String InvokeReceiptAmnValidate(String bookid, String milesid);

    String ReviseRecommendation(String recomNo, String userId);

    String InvokeSumofRceiptAmount(String bookid);

    String autoLeaseLA(String recomNo, String userId);

    String autoCreateOC(String leaseNo, String userId);

    String directRejectionFromDraft(String rcId, String userId, String funcId,
                                    String reason);

    String directToDraft(String rcId, String userId, String funcId,
                         String reason);

    String paymentPlanChange(String bkId, String mileHrdId, String userName);


    String responseRcForAppr(String rcId, String reason, String apr_rej);

    String submitRcForAppr(String rcId, String userName);
}
