package com.tp.config;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class MailConfig {
	
	
	@Resource
	private Environment env;
	
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public JavaMailSender javaMailService()
	{
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

		javaMailSender.setHost(env.getRequiredProperty("mail.smtp.host"));
		javaMailSender.setPort(Integer.parseInt(env.getRequiredProperty("mail.smtp.port")));
		javaMailSender.setUsername(env.getRequiredProperty("flp.classteacher.noreply.mail"));
		javaMailSender.setPassword(env.getRequiredProperty("flp.classteacher.noreply.password"));

		javaMailSender.setJavaMailProperties(getMailProperties());

		return javaMailSender;
	}
	
	/**
	 * 
	 * @return
	 */
		private Properties getMailProperties()
		{
			Properties properties = new Properties();
			properties.setProperty("mail.transport.protocol", "smtp");
			properties.setProperty("mail.smtp.auth", env.getRequiredProperty("mail.smtp.auth"));
			properties.setProperty("mail.smtp.starttls.enable", env.getRequiredProperty("mail.smtp.starttls.enable"));
			properties.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
			return properties;
		}
		
		/*@Bean
		public VelocityEngine getVelocityEngine() throws VelocityException, IOException
		{
			VelocityEngineFactory factory = new VelocityEngineFactory();
			Properties props = new Properties();
			props.put("resource.loader", "class");
			props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			factory.setVelocityProperties(props);
			return factory.createVelocityEngine();
		}*/

}
