package san.jee.cecherz.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    private String user_email;
    private String token;

    public EmailSender(String user_email, String token) {
        this.user_email = user_email;
        this.token = token;
    }
    public void sendEmail() {
        String email = "mailbox.jmtrain@gmail.com";
        String password = "Pangeon66#";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user_email));
            message.setSubject("Link weryfikacyjny portalu JMTrain.");

            message.setContent(
                    "<h3>:: Wiadomość z portalu JMTrain ::</h3><hr />" +
                        "<h4>Witaj ! <br />" +
                        user_email + " klinkij w link aby potwierdzić chęć rejestracji: <br />" +
                        "http://localhost:8080/JMTrain/ActivateAccount?key1=" + user_email + "&key2=" + token + "</h4><hr />" +
                        "<h5>Jeśli ta wiadomość trafiła do Ciebie przypadkiem zignoruj ją.</h5>",
                    "text/html; charset=utf-8");
            message.saveChanges();
            System.out.println(message);
            Transport.send(message);
        } catch(Exception e) {
            System.out.println("--EmailSender | sendEmail()--");
            System.out.println(e.toString());
        }

    }

    public static void main(String[] args) {
        EmailSender sender = new EmailSender("pangeon@tlen.pl", "753f369");
        sender.sendEmail();
    }

}
