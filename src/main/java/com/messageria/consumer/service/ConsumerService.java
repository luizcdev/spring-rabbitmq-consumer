package com.messageria.consumer.service;

import com.messageria.consumer.dto.Message;

public interface ConsumerService {
	
	void action( Message message ) throws Exception;

}
