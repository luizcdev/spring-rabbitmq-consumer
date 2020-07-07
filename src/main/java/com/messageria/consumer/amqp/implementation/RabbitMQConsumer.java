package com.messageria.consumer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.messageria.consumer.amqp.AmqpConsumer;
import com.messageria.consumer.dto.Message;
import com.messageria.consumer.service.ConsumerService;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {
	
	@Autowired
	private ConsumerService consumerService;

	@Override
	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
	public void consumer(Message message) {
		try {
			consumerService.action(message);
		} catch(Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}
	
}
