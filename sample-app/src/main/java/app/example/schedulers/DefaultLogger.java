/**
 * 
 */
package app.example.schedulers;

import java.text.MessageFormat;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import app.example.models.User;

/**
 * @author cbezmen
 *
 */
@Component
public class DefaultLogger {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultLogger.class);

	@Scheduled(fixedRate = 5000)
	public void job() {
		final Random random = new Random();

		final User user = new User("Can", "Bezmen", 26);

		final String userString = MessageFormat.format("name={0} lastName={1} age={2}", user.getName(),
				user.getLastName(), user.getAge());

		final int randomValue = random.nextInt(10);
		if (randomValue % 3 == 0) {
			LOG.info(" {}", userString);
		} else if (randomValue % 3 == 1) {
			LOG.warn("{}", userString);
		} else {
			LOG.error("{}", userString);
		}
	}

}
