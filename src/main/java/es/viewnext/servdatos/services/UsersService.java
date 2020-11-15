package es.viewnext.servdatos.services;

import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.viewnext.servdatos.beans.Garbage;
import es.viewnext.servdatos.beans.Users;
import es.viewnext.servdatos.beans.UsersRepository;

/**
 * Servicios de la clase garbage
 *
 */
@Service
public class UsersService {

	private final static Logger logger = LoggerFactory.getLogger(UsersService.class);

	/** Repositorio de accesos */
	@Autowired
	private UsersRepository usersRepo;

	/**
	 * Devuelve la contidad de elementos que hay en la tabla
	 * 
	 * @return Cantidad de elementos de la tabla
	 */
	public Long getCountDatabase() {
		logger.info("Service. Count");
		sleep();
		return usersRepo.count();
	}

	/**
	 * Obtiene objeto por su id
	 * 
	 * @param id Identificar
	 * @return Objeto si exte
	 */
	public Optional<Users> get(Integer id) {
		logger.info("Service. Get " + id);
		sleep();
		return usersRepo.findById(id);
	}

	/**
	 * Inseta registro
	 * 
	 * @param garb
	 * @return Objeto insertado
	 */
	public Users insert(Users garb) {
		logger.info("Service. Insert usuario");
		sleep();
		return usersRepo.save(garb);
	}

	/**
	 * Elimina registro por si ID
	 * 
	 * @param id Identificador
	 */
	public void delete(Integer id) {
		logger.info("Service. Delete id: " + id);
		sleep();
		usersRepo.deleteById(id);

	}

	

	/**
	 * Sleep para simular retardos en las consultas
	 */
	//@CaptureSpan("otherOperations")
	private void sleep() {
		try {
			Random random = new Random();
			int milis = random.nextInt(100 - 20 + 1) + 20;
			logger.info(String.format("Sleep ---> %s ms", milis));
			Thread.sleep(milis);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
