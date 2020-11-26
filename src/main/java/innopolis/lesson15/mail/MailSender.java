package innopolis.lesson15.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailSender {

    public static void main(String[] args) {

        try {
            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtps");
            props.put("mail.smtps.host", "smtp.gmail.com");
            props.put("mail.smtps.auth", "true");
            props.put("mail.smtps.sendpartial", "true");
            props.put("mail.debug", "true");

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            message.setSubject("тестовое письмо!");
            message.setText("Asta la vista, baby!");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("ritraferza@nedoz.com"));
            message.setSentDate(new Date());
            String userLogin = "ri4ara@gmail.com";
            String userPassword = "DarkSouls3";
            Transport transport = session.getTransport();
            transport.connect("smtp.gmail.com", 465, userLogin, userPassword);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
