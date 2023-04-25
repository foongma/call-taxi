package calltaxi.common;

import calltaxi.TaxiApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { TaxiApplication.class })
public class CucumberSpingConfiguration {}
