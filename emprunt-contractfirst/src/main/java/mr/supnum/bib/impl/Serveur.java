package mr.supnum.bib.impl;

import jakarta.xml.ws.Endpoint;

public class Serveur {

    public static void main(String[] args) {

        String url = "http://localhost:8080/bib/EmpruntService";

        Endpoint.publish(url, new EmpruntServiceImpl());

        System.out.println("Service SOAP Contract-first lancé !");
        System.out.println("WSDL : " + url + "?wsdl");
    }
}