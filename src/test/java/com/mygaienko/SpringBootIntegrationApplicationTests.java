package com.mygaienko;

import com.mygaienko.config.ActiveMQConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootIntegrationApplicationTests {

	@Autowired
	@Qualifier("jmsConnectionFactory")
	private ConnectionFactory jmsConnectionFactory;

	private Session session;
	private Destination destination;
	private MessageProducer producer;


	@Before
	public void init() throws JMSException {
		Connection conn = jmsConnectionFactory.createConnection();
		conn.start();

		session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		destination = session.createQueue(ActiveMQConfig.HELLO_QUEUE);
		producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	}

	@Test
	public void test() throws JMSException, InterruptedException {

		TextMessage txtMessage = session.createTextMessage();
		txtMessage.setText("Larry the Cable Guy");

		producer.send(destination, txtMessage);

		Thread.sleep(3000);
	}

}
