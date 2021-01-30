package com.zlm.gateway;

import java.util.Arrays;

/**
 * @author zlm
 */
public class GatewayApplication {
    public static final String GATEWAY_NAME="NIOGateway";
    public static final String GATEWAY_VERSION="3.0.0";
    public static void main(String[] args) {
        String backendServices = "http://localhost:8801,http://localhost:8802,http://localhost:8803";
        String[] list  = backendServices.split("\\,");
        String gatewayPort = System.getProperty("gatewayPort","8888");

        int port = Integer.parseInt(gatewayPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        HttpInboundServer server = new HttpInboundServer(port, Arrays.asList(list));
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for serverList:" + backendServices);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
