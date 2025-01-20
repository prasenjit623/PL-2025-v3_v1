package view;

public class WspayloadForRecieptCancel {
    public WspayloadForRecieptCancel() {
        super();
    }

    public String getPayload(String created, String expires, String userName,
                             String password) {
        String payload =
            "<soapenv:Envelope xmlns:com=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/types/\">\n" +
            "   <soapenv:Header>\n" +
            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-B6C9C3574217989111153200179538920\">\n" +
            "            <wsse:Username>" + userName + "</wsse:Username>\n" +
            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" +
            password + "</wsse:Password>\n" +
            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">PY60j9zSglihXdbM9+l8DQ==</wsse:Nonce>\n" +
            "            <wsu:Created>" + created + "</wsu:Created>\n" +
            "         </wsse:UsernameToken>\n" +
            "         <wsu:Timestamp wsu:Id=\"TS-B6C9C3574217989111153200178953019\">\n" +
            "            <wsu:Created>" + created + "</wsu:Created>\n" +
            "            <wsu:Expires>" + expires + "</wsu:Expires>\n" +
            "         </wsu:Timestamp>\n" +
            "      </wsse:Security>\n" +
            "   </soapenv:Header>\n" +
            "   <soapenv:Body>\n" +
            "      <typ:createReverseReceipt>\n" +
            "         <typ:reverseReceipt>\n" +
            "            <com:ReceiptNumber>RT-1168</com:ReceiptNumber>\n" +
            "            <com:ReversalCategory>REV</com:ReversalCategory>\n" +
            "            <com:ReversalDate>2018-07-12</com:ReversalDate>\n" +
            "            <com:ReversalReasonCode>NSF</com:ReversalReasonCode>\n" +
            "            <com:ReversalComments>Reversing Receipt</com:ReversalComments>\n" +
            "            <com:BusinessUnit>Leasing Sharjah Business Unit UAT</com:BusinessUnit>\n" +
            "            <com:ReversalGlDate>2018-07-12</com:ReversalGlDate>\n" +
            "         </typ:reverseReceipt>\n" +
            "      </typ:createReverseReceipt>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";
        return payload;
    }
}
