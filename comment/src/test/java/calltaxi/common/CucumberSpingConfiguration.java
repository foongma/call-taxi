package calltaxi.common;

import calltaxi.CommentApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CommentApplication.class })
public class CucumberSpingConfiguration {}
