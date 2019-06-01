package cl.eftec.leerrest.controlador;

import cl.eftec.leerrest.model.Quote;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class QuoteController {

    @RequestMapping("quote/")
    public String leer(Model model) {
        // HATEOAS (falta el modelo)
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        model.addAttribute("quota",quote);
        return "leer";
    }

    @RequestMapping("listar/")
    public String listar(Model model) {
        // HATEOAS (falta el modelo)
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Quote>> entidades =
                restTemplate.exchange("https://gturnquist-quoters.cfapps.io/api/",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Quote>>() {
                        });
        List<Quote> listado=entidades.getBody();
        model.addAttribute("listado",listado);
        return "leer";
    }
}
