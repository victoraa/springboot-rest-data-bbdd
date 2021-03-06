package es.viewnext.servdatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.viewnext.servdatos.beans.Garbage;
import es.viewnext.servdatos.exception.GarbageNotFoundExcept;
import es.viewnext.servdatos.services.GarbageService;
import es.viewnext.servdatos.services.UsersService;

/**
 * Controller de la aplicación
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class servRestController {
	/** Instacia a servicio garbage*/
	@Autowired
	private GarbageService garbServ;
	
	@Autowired
	private UsersService usuServ;
	
	
	@GetMapping("/hola")
	public String hola () {
		return "Hola Servicio. ";
	}
	
	@GetMapping("/temperatura")
	public String temp () {
		
		return garbServ.getRestJson();
	}
	
	@GetMapping("/count")
	public String count() {
		return String.valueOf(garbServ.getCountDatabase());
	}
	
	@GetMapping("/countData")
	public String countData() {
		return "Hola Servicio. Elemt tabla garbage: "+garbServ.getCountDatabase() + "<br /> Tabla Usuarios: "+usuServ.getCountDatabase();
	}

	
	@GetMapping(path="/add") 
	public @ResponseBody Garbage addNewUser (@RequestParam String descripcion) {
		Garbage gar = new Garbage();
		gar.setDescription(descripcion);
		
		return garbServ.insert(gar);
		
	}
	
	@GetMapping("get/{id}")
    public Garbage get(@PathVariable("id") Integer id) {
        return garbServ.get(id).orElseThrow(GarbageNotFoundExcept::new);
    }
	
	@GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {

		garbServ.delete(id);
		return "OK";
    }
	
	
	@GetMapping("/getAll")
	public List<Garbage> getAllGarbage() {
		return garbServ.getAllGarbage();
	}
	
}
