package cl.eftec.leerrest.controlador;

import cl.eftec.leerrest.model.Quote;
import cl.eftec.leerrest.model.Value;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
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

    @RequestMapping("enviar/")
    public String enviar(Model model) {
        String url="http://192.168.0.130:8080/insertar";
        RestTemplate restTemplate = new RestTemplate();
        // creamos los datos a mano
        Value val=new Value();
            val.setId(1L); // la L es de long
            val.setQuote("comentario");
        Quote obj=new Quote();
            obj.setType("tipo");
            obj.setValue(val);

        HttpEntity<Quote> request = new HttpEntity<>(obj);
        Quote resultado = restTemplate.postForObject(url, request, Quote.class);

        model.addAttribute("quote",resultado);
        return "leer";
    }



}
