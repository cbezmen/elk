/**
 *
 */
package app.example.schedulers;

import app.example.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Random;

/**
 * @author cbezmen
 *
 */
@Component
@Slf4j
public class DefaultLogger {

    @Scheduled(fixedRate = 5000)
    public void job() {
        final Random random = new Random();

        final User user = new User("Can", "Bezmen", 26);

        final String userString = MessageFormat.format("name={0} lastName={1} age={2}", user.getName(),
            user.getLastName(), user.getAge());

        final int randomValue = random.nextInt(10);
        if (randomValue % 3 == 0) {
            log.info(" {}", userString);
        } else if (randomValue % 3 == 1) {
            log.warn("{}", userString);
        } else {
            log.error("{}", userString);
        }
    }

}
