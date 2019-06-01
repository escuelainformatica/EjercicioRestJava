package cl.eftec.leerrest.controlador;

import cl.eftec.leerrest.model.Quote;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class QuoteController {

    @RequestMapping("quote/")
    public String leer() {

        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return "leer";
    }
}
