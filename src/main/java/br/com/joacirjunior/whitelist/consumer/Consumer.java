package br.com.joacirjunior.whitelist.consumer;

import br.com.joacirjunior.whitelist.model.ICommand;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@RabbitListener(queues="${whitelist.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(ICommand command) {
	    System.out.println("Recieved Message: " + command.toString() + " - TYPE: " + command.getCommandType());
    }

}