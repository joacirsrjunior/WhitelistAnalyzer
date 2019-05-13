package br.com.joacirjunior.whitelist.producer;

import br.com.joacirjunior.whitelist.enums.ECommandType;
import br.com.joacirjunior.whitelist.model.ICommand;
import br.com.joacirjunior.whitelist.model.InsertCommand;
import br.com.joacirjunior.whitelist.model.ValidationCommand;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${whitelist.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${whitelist.rabbitmq.routingkey}")
	private String routingkey;

	public void produce(ICommand command){
		amqpTemplate.convertAndSend(exchange, routingkey, command);
		System.out.println("Send message = " + command);
	}

	/*
	public void produce(InsertCommand insertCommand){
		Message msg = MessageBuilder.withBody(insertCommand.toString().getBytes())
				.setHeader("type-command", ECommandType.INSERTION)
				.build();
		amqpTemplate.convertAndSend(exchange, routingkey, msg);
		System.out.println("Send message = " + msg.toString());
	}

	public void produce(ValidationCommand validationCommand){
		Message msg = MessageBuilder.withBody(validationCommand.toString().getBytes())
				.setHeader("type-command", ECommandType.VALIDATION)
				.build();
		amqpTemplate.convertAndSend(exchange, routingkey, msg);
		System.out.println("Send message = " + msg.toString());
	}
	 */

}