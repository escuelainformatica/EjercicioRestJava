package cl.eftec.leerrest.controlador;

import cl.eftec.leerrest.crud.CoffeeCrud;
import cl.eftec.leerrest.model.Coffee;
import cl.eftec.leerrest.model.Quote;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoffeeRest {

    @Autowired
    private CoffeeCrud coffeeCrud;

    @GetMapping( "coffee/list")
    public List<Coffee> listar() {
        List<Coffee> listar= (List<Coffee>) coffeeCrud.findAll();
        return listar;
    }
    @PostMapping( "coffee/insertar")
    public Coffee Insertar(@RequestBody Coffee coffee) {
        coffeeCrud.save(coffee);
        return coffee;
    }
}
