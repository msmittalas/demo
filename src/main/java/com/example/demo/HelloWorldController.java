package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.identity.DefaultAzureCredentialBuilder;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

@RestController
public class HelloWorldController {

	Logger logger= LoggerFactory.getLogger(HelloWorldController.class);
	
	@GetMapping(path = "/")
	public String getWorld()
	{
		
		String keyVaultName = System.getenv("KEY_VAULT_NAME");
		String kvUri = "https://" + keyVaultName + ".vault.azure.net";

		SecretClient secretClient = new SecretClientBuilder()
		    .vaultUrl(kvUri)
		    .credential(new DefaultAzureCredentialBuilder().build())
		    .buildClient();
		
		
		
		
		logger.info("Salman info");
		logger.trace("Salman trace");
		logger.debug("Salman debug");
		logger.error("Salman error");
		logger.warn("Salman warn");
		//secretClient.setSecret(new KeyV)
		return secretClient.getSecret("employeetablestring").getValue();
	}
}
