package com.juntralala.factorybean.data;


import lombok.Data;

@Data
public class PaymentGatewayClient {

    private String endpoint;
    private String publicKey;
    private String privateKey;

}
