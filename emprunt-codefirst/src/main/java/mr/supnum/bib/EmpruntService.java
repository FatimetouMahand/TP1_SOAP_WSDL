package mr.supnum.bib;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebParam;


@WebService(serviceName = "EmpruntService")
public class EmpruntService {

    @WebMethod
    public Emprunt emprunterLivre(
            @WebParam(name = "idAdherent") String idAdherent,
            @WebParam(name = "isbn") String isbn)
            throws LivreIndisponibleException {

        if (isbn == null || isbn.isEmpty()) {
            throw new LivreIndisponibleException(
                "ISBN invalide",
                new LivreIndisponibleInfo(isbn, "ISBN invalide")
            );
        }

        return new Emprunt("EMP001", "2026-12-01");
    }

    @WebMethod
    public double penalite(int joursRetard) {
        return joursRetard * 10.0;
    }
}
