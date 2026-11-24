package mr.supnum.bib;

import jakarta.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.publish(
            "http://localhost:8080/emprunt",
            new EmpruntService()
        );

        System.out.println("Service SOAP démarré !");
        System.out.println("WSDL : http://localhost:8080/emprunt?wsdl");
    }
}