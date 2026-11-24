package mr.supnum.bib;

import jakarta.xml.ws.Endpoint;
import mr.supnum.bib.impl.EmpruntServiceImpl;

public class App {

    public static void main(String[] args) {

        String url = "http://localhost:8080/bib/EmpruntService";

        Endpoint.publish(url, new EmpruntServiceImpl());

        System.out.println("Service SOAP Contract-first lancé !");
        System.out.println("WSDL : " + url + "?wsdl");
    }
}