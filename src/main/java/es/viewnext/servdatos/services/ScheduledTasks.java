package es.viewnext.servdatos.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import es.viewnext.servdatos.beans.Garbage;
import es.viewnext.servdatos.beans.GarbageRepository;

/**
 * 
 * Tarea programada sobre la clases del proyecto
 */
@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	
	/**
	 * Objeto repositorio para acceder a la tabla
	 */
	@Autowired
	private GarbageRepository repoGarb;

	@Scheduled(fixedRateString ="${console.schedule.rate}", initialDelay=5000)
	public void reportCurrentTime() {
		final String hora = dateFormat.format(new Date());
		log.info("The time is now {}", hora);
		Garbage garb = new Garbage();
		garb.setDescription("Contentenido fecha:_" + hora);
		log.info("-->Inserting Object Garbage:" + hora);
		repoGarb.save(garb);

	}

	private int getRandom() {
		Random random = new Random();
		return random.nextInt(99999);
	}
}
