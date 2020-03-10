package com.example.demo;

import com.microsoft.azure.spring.integration.core.AzureHeaders;
import com.microsoft.azure.spring.integration.core.api.Checkpointer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Header;
@EnableBinding(Sink.class)
public class QueueMessageHandler {

	@StreamListener(Sink.INPUT)
	public void recMsg(String message, @Header(AzureHeaders.CHECKPOINTER) Checkpointer checkpointer)
	{
		System.out.println(String.format("New message received: '%s'", message));
        checkpointer.success().handle((r, ex) -> {
            if (ex == null) {
                System.out.println(String.format("Message '%s' successfully checkpointed", message));
            }
            return null;
        });
		
		
	}
}
