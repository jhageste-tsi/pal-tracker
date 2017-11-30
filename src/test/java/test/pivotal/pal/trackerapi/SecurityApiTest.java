package test.pivotal.pal.trackerapi;

import io.pivotal.pal.tracker.PalTrackerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PalTrackerApplication.class, webEnvironment = RANDOM_PORT)
public class SecurityApiTest extends ApiTest {

    @Test
    public void unauthorizedTest() {
        ResponseEntity<String> response = unauthorizedRestTemplate.getForEntity("/info", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void authorizedTest() {
        ResponseEntity<String> response = authorizedRestTemplate.getForEntity("/info", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
