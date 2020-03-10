package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.core.annotation.QueryParam;

@EnableBinding(Source.class)
@RestController
public class SendRecQueueController {

	
	@Autowired
    private Source source;
	
	@GetMapping("/sendMessage")
	public String sendMessage(@QueryParam("name") String name)
	{
		String message="Hello World!"+name;
		for(int i=0;i<1000;i++)
		source.output().send(new GenericMessage<String>(message+i));
		return "message has been sent";
	}
	@GetMapping("/getMessage")
	public String getMessage()
	{
		String message="";
		return "message is "+message;
	}
	
	
}
