package cl.eftec.leerrest.crud;


import cl.eftec.leerrest.model.Coffee;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.repository.CrudRepository;

@Persistent
public interface CoffeeCrud extends CrudRepository<Coffee,Integer> {

}
