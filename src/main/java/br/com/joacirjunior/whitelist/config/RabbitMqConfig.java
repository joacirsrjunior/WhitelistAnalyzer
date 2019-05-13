package br.com.joacirjunior.whitelist.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;

@Configuration
public class RabbitMqConfig {
	
	@Value("${whitelist.rabbitmq.queue}")
	String queueName;

	
	@Value("${whitelist.rabbitmq.exchange}")
	String exchange;
	
	@Value("${whitelist.rabbitmq.routingkey}")
	private String routingkey;
	
    @Bean
    Queue queue() {
        return new Queue(queueName, true, false, false);
    }

    @Bean
    DirectExchange exchange() {
    	return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    /*
    @Bean
    HeadersExchange exchange(){
        return new HeadersExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, HeadersExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).where("type-command").matches(ECommandType.VALIDATION);
    }
    */
	
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory jsaFactory(ConnectionFactory connectionFactory,
                                                           SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());
        return factory;
    }

}
