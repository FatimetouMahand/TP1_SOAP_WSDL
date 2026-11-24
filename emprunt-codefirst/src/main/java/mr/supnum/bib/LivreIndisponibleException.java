package mr.supnum.bib;

import jakarta.xml.ws.WebFault;

@WebFault(
    name = "LivreIndisponible",
    targetNamespace = "http://supnum.mr/bib"
)
public class LivreIndisponibleException extends Exception {

    private final LivreIndisponibleInfo faultInfo;

    public LivreIndisponibleException(String message, LivreIndisponibleInfo info) {
        super(message);
        this.faultInfo = info;
    }

    public LivreIndisponibleInfo getFaultInfo() {
        return faultInfo;
    }
}