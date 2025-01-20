package view.backing;
import javax.el.ELContext;

import javax.el.ExpressionFactory;

import javax.el.ValueExpression;

import javax.faces.context.FacesContext;

//import javax.mail.internet.InternetAddress;

/**********1st Approach***************/
 import java.util.ArrayList;
 import java.util.Properties;
 import javax.activation.DataHandler;
 import javax.activation.DataSource;
 import javax.activation.FileDataSource;
 import javax.mail.BodyPart;
 import javax.mail.Message;
 import javax.mail.MessagingException;
 import javax.mail.Multipart;
 import javax.mail.NoSuchProviderException;
 import javax.mail.PasswordAuthentication;
 import javax.mail.Session;
 import javax.mail.Transport;
 import javax.mail.internet.AddressException;
 import javax.mail.internet.InternetAddress;
 import javax.mail.internet.MimeBodyPart;
 import javax.mail.internet.MimeMessage;
 import javax.mail.internet.MimeMultipart;


public class MailServices {
    public MailServices() {
        super();
    }
    public static Object evaluateEL(String el) {
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    ELContext elContext = facesContext.getELContext();
                    ExpressionFactory expressionFactory =
                    facesContext.getApplication().getExpressionFactory();
                    ValueExpression exp =
                    expressionFactory.createValueExpression(elContext, el,
                    Object.class);

                    return exp.getValue(elContext);
                    }
    
    /**********1st Approach***************/

             public static String sendMail(String msg, String subject, String FromUser, ArrayList<String> ToUser, String pwd,
                                    String hostName, String isAnyAtchmnt, ArrayList<String> fileNameNPath) {
                 // Setting Properties
                 Properties emailProperties = new Properties();
                 emailProperties.put("mail.smtp.host", hostName);
                 emailProperties.put("mail.smtp.auth", "true");
                 emailProperties.put("mail.smtp.starttls.enable", "true");
                 //Login Credentials
                 final String user = FromUser;  //change accordingly
                 final String password = pwd;  //change accordingly
                 //Authenticating...
                 Session session = Session.getInstance(emailProperties, new javax.mail.Authenticator() {
                     public PasswordAuthentication getPasswordAuthentication() {
                         return new PasswordAuthentication(user, password);
                     }
                 });
                 //1) create MimeBodyPart object and set your message content
                 MimeMessage message = new MimeMessage(session);
                 try {
                     message.setFrom(new InternetAddress(user));
                     for (String email : ToUser) {
                         //System.out.println("Mail Id is-" + email);
                         message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                     }
                     message.setSubject(subject);
                     BodyPart messageBody = new MimeBodyPart();
                     messageBody.setContent(msg, "text/html");
                     // If there is any attachment to send
                     //5) create Multipart object and add MimeBodyPart objects to this object
                     Multipart multipart = new MimeMultipart();
                     multipart.addBodyPart(messageBody);
                     if ("Y".equalsIgnoreCase(isAnyAtchmnt)) {
                         //2) create new MimeBodyPart object and set DataHandler object to this object
                         for (String path : fileNameNPath) {
                             MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                             //System.out.println("Exact path--->" + path);
                             DataSource source = new FileDataSource(path);
                             messageBodyPart2.setDataHandler(new DataHandler(source));
                             // //System.out.println("FileName is-"+path.substring(path.lastIndexOf("//")+1, path.length()));
                             messageBodyPart2.setFileName(path.substring(path.lastIndexOf("//") + 2, path.length()));
                             multipart.addBodyPart(messageBodyPart2);
                         }
                         //6) set the multiplart object to the message object
                         message.setContent(multipart);
                         message.saveChanges();
                     }
                     //If there is plain eMail- No Attachment
                     else {
                         message.setContent(msg, "text/html"); //for a html email
                     }
                 } catch (MessagingException e) {
                 }
                 Transport transport = null;
                 try {
                     transport = session.getTransport("smtp");
                 } catch (NoSuchProviderException e) {
                     //System.out.println("No such Provider Exception");
                 }
                 try {
                     transport.connect(hostName, FromUser, pwd);
                     transport.sendMessage(message, message.getAllRecipients());
                     transport.close();
                     //System.out.println("Email sent successfully.");
                     return "Y";
                 } catch (MessagingException e) {
                     //System.out.println("Messaging Exception" + e);
                     return "N";
                 }
             }

}
