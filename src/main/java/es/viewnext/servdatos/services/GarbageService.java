package es.viewnext.servdatos.services;

import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.elastic.apm.api.CaptureSpan;
import es.viewnext.servdatos.beans.Garbage;
import es.viewnext.servdatos.beans.GarbageRepository;

/**
 * Servicios de la clase garbage
 *
 */
@Service
public class GarbageService {

	private final static Logger logger = LoggerFactory.getLogger(GarbageService.class);

	/** Repositorio de accesos */
	@Autowired
	private GarbageRepository garbRepo;

	/**
	 * Devuelve la contidad de elementos que hay en la tabla
	 * 
	 * @return Cantidad de elementos de la tabla
	 */
	public Long getCountDatabase() {
		logger.info("Service. Count");
		sleep();
		return garbRepo.count();
	}

	/**
	 * Obtiene objeto por su id
	 * 
	 * @param id Identificar
	 * @return Objeto si extei
	 */
	public Optional<Garbage> get(Integer id) {
		logger.info("Service. Get " + id);
		sleep();
		return garbRepo.findById(id);
	}

	/**
	 * Inseta registro
	 * 
	 * @param garb
	 * @return Objeto insertado
	 */
	public Garbage insert(Garbage garb) {
		logger.info("Service. Insert");
		sleep();
		return garbRepo.save(garb);
	}

	/**
	 * Elimina registro por si ID
	 * 
	 * @param id Identificador
	 */
	public void delete(Integer id) {
		logger.info("Service. Delete id: " + id);
		sleep();
		garbRepo.deleteById(id);

	}

	public String getRestJson() {
		logger.info("Temperature get http api");
		sleep();
		RestTemplate restTemplate = new RestTemplate();
		String salida = restTemplate.getForObject(
				"http://api.openweathermap.org/data/2.5/weather?q=Madrid&appid=69185f607c03aa7dd139923f388591db",
				String.class);

		return salida;
	}

	/**
	 * Sleep para simular retardos en las consultas
	 */
	@CaptureSpan("otherOperations")
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
