package test.pivotal.pal.trackerapi;

import org.junit.Before;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class ApiTest {

    @LocalServerPort
    private String port;

    protected TestRestTemplate authorizedRestTemplate;
    protected TestRestTemplate unauthorizedRestTemplate;

    @Before
    public void setUp() throws Exception {
        RestTemplateBuilder builder = new RestTemplateBuilder()
                .rootUri("http://localhost:" + port)
                .basicAuthorization("user", "password");
        authorizedRestTemplate = new TestRestTemplate(builder);

        builder = new RestTemplateBuilder()
                .rootUri("http://localhost:" + port);
        unauthorizedRestTemplate = new TestRestTemplate(builder);
    }

}
