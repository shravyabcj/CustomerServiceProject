package com.ekthasol.utilityservice.jms.registration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * @author Shravya Peddiraju
 * This class sends the message to the queue.
 */
@Component("queueSender")
public class JmsQueueSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * @param text
	 * This method sends the messsage to the queue.
	 */
	public void sendMessage(final String text) {

		this.jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				message.setJMSReplyTo(new ActiveMQQueue("Recv2Send"));
				return message;
			}
		});
	}
}