package com.tp.util;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.tp.Entity.EmployeeDetails;

@Component
public class MailSenderUtil {

	@Autowired
	JavaMailSender mailSender;

	/*@Autowired
	VelocityEngine velocityEngine;*/

	// send mail for verification while end user is registered
	public void sendConfirmationEmail(EmployeeDetails employeeDetails) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setSubject("User Verification Mail");
				message.setTo("geniousamresh@gmail.com");
				/*Map<String, Object> model = new HashMap<String, Object>();
				model.put("user", user);
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, "user-verification.vm", model);*/
				message.setText("Hello Dear", true);
			}
		};
		send(preparator);
	}

	
	@Async
	private void send(MimeMessagePreparator preparator) {
		mailSender.send(preparator);

	}


	
	
  
	
	
}
