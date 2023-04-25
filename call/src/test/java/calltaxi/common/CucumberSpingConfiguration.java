package calltaxi.common;

import calltaxi.CallApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CallApplication.class })
public class CucumberSpingConfiguration {}
