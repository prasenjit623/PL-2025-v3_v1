package view;

public class WsPayloadForCreateAccounts {
    public WsPayloadForCreateAccounts() {
        super();
    }

    public String getPayload(String created, String expires, String[] codes,
                             String userName, String password) {


        String payload =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/accountCombinationService/types/\" xmlns:acc=\"http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/accountCombinationService/\">\n" +
            "   <soapenv:Header>\n" +
            "<wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
            "         <wsu:Timestamp wsu:Id=\"TS-B6C9C3574217989111153199515459014\">\n" +
            "            <wsu:Created>" + created + "</wsu:Created>\n" +
            "            <wsu:Expires>" + expires + "</wsu:Expires>\n" +
            "         </wsu:Timestamp>\n" +
            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-B6C9C3574217989111153199494551212\">\n" +
            "            <wsse:Username>" + userName + "</wsse:Username>\n" +
            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" +
            password + "</wsse:Password>\n" +
            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">lJRyvNk3Xl0A9u6j21o8CA==</wsse:Nonce>\n" +
            "            <wsu:Created>" + created + "</wsu:Created>\n" +
            "         </wsse:UsernameToken>\n" +
            "      </wsse:Security>\n" +
            "   </soapenv:Header>\n" +
            "   <soapenv:Body>\n" +
            "      <typ:validateAndCreateAccounts>\n" +
            "         <!--Zero or more repetitions:-->\n" +
            "         <typ:validationInputRowList>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:DynamicInsertion>Y</acc:DynamicInsertion>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:Segment1>" + codes[0] + "</acc:Segment1>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:Segment2>" + codes[1] + "</acc:Segment2>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:Segment3>" + codes[2] + "</acc:Segment3>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:Segment4>" + codes[3] + "</acc:Segment4>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:Segment5>" + codes[4] + "</acc:Segment5>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:Segment6>" + codes[5] + "</acc:Segment6>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:Segment7>" + codes[6] + "</acc:Segment7>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:Segment8>" + codes[7] + "</acc:Segment8>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:LedgerName>UAT Misk Primary ledger</acc:LedgerName>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:EnabledFlag>true</acc:EnabledFlag>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:FromDate>2018-04-04</acc:FromDate>\n" +
            "            <!--Optional:-->\n" +
            "            <acc:ToDate>2019-04-04</acc:ToDate>\n" +
            "         </typ:validationInputRowList>\n" +
            "      </typ:validateAndCreateAccounts>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";
        return payload;
    }
}
