package es.viewnext.servdatos.beans;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarbageRepository  extends CrudRepository<Garbage, Integer> {

}


