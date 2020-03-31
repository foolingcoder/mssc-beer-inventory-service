package guru.sfg.beer.inventory.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JmsConfig {

	public static final String NEW_INVENTORY_QUEUE = "inventory-queue";
	
	public static final String ALLOCATE_ORDER_QUEUE = "ALLOCATE_ORDER_QUEUE";

	public static final String ALLOCATE_ORDER_RESPONSE_QUEUE = "ALLOCATE_ORDER_RESPONSE_QUEUE";
	
	public static final String DEALLOCATE_ORDER_QUEUE = "DEALLOCATE_ORDER_QUEUE";
	
    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}