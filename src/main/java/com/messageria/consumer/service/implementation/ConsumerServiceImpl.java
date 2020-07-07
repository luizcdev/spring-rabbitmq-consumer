package com.messageria.consumer.service.implementation;

import org.springframework.stereotype.Service;

import com.messageria.consumer.dto.Message;
import com.messageria.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Override
	public void action(Message message) throws Exception {		
		System.out.println( message.getText() );
	}

}
