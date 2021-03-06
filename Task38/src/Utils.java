import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utils {
	public static void sendMessage(String content) {
		Properties props = new Properties();
		props.put("mail.smtp.host", Task38.smtpHost);
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", Task38.smtpPort);

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Task38.gmail,
								Task38.pass);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Task38.gmail));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(Task38.toAddress));
			message.setSubject(Task38.subject);
			message.setText(content);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
