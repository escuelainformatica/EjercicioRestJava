package cl.eftec.leerrest.controlador;

import cl.eftec.leerrest.model.Quote;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteRest {

    @PostMapping("insertar")
    public Quote insertar(@RequestBody Quote quote) {
        return quote;
    }
}
