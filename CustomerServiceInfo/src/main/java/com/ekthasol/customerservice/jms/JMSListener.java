package com.ekthasol.customerservice.jms;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.ekthasol.customerservice.service.MessageService;

/**
 * @author Shravya Peddiraju JMS listener class to retrieve the messages from
 *         the sender and update service id to the given customer id.
 */
@Component("JMSListener")
public class JMSListener implements SessionAwareMessageListener<TextMessage> {

	/**
	 * JMS listener class to retrieve the messages from the sender and update
	 * service id to the given customer id.
	 */
	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {
		// TODO Auto-generated method stub
		if (message instanceof TextMessage) {
			String msg;

			msg = ((TextMessage) message).getText();
			String[] msgAry = msg.split(" ");

			int c_id = Integer.parseInt(msgAry[0]);
			int serv_id = Integer.parseInt(msgAry[1]);

			MessageService messService = new MessageService();

			messService.setCustomerService(c_id, serv_id);

			/*
			 * ActiveMQTextMessage textMessage = new ActiveMQTextMessage(); if
			 * (update > 0) textMessage.setText("ACK"); else
			 * textMessage.setText("Failed to insert");
			 * 
			 * MessageProducer producer =
			 * session.createProducer(message.getJMSReplyTo());
			 * producer.send(textMessage);
			 */
		}
	}
}