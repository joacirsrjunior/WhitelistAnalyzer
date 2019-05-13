package br.com.joacirjunior.whitelist;

import br.com.joacirjunior.whitelist.model.InsertCommand;
import br.com.joacirjunior.whitelist.model.ValidationCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import br.com.joacirjunior.whitelist.producer.Producer;

@SpringBootApplication
public class WhitelistAnalyzerApp implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(WhitelistAnalyzerApp.class, args);
	}
	
	@Autowired
	Producer producer;

	@Override
	public void run(String... args) throws Exception {

		this.sendInsertMessages();

		this.sendValidationMessages();

	}

	// Send a message with insert command to RabbitMQ
	private void sendInsertMessages(){
		producer.produce(new InsertCommand("Google", "1111"));
		producer.produce(new InsertCommand("Google", "2222"));
		producer.produce(new InsertCommand("Facebook", "3333"));
		producer.produce(new InsertCommand("Globo", "4444"));
		producer.produce(new InsertCommand("", "5555"));
		producer.produce(new InsertCommand("", "6666"));
	}

	// Send a message with validation command to RabbitMQ
	private void sendValidationMessages(){
		producer.produce(new ValidationCommand("Google", "www.google.com.br", 1001));
		producer.produce(new ValidationCommand("Facebook", "www.facebook.com", 1002));
		producer.produce(new ValidationCommand("Globo", "www.globo.com.br", 1003));
		producer.produce(new ValidationCommand("Globo", "www.globoesporte.com.br", 1004));
		producer.produce(new ValidationCommand("Google", "www.youtube.com.br", 1005));
		producer.produce(new ValidationCommand("Facebook", "www.instagram.com", 1006));
		producer.produce(new ValidationCommand("Grupo Folha", "www.uol.com.br", 1007));
	}
}