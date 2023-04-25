package calltaxi.infra;

import calltaxi.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/taxis")
@Transactional
public class TaxiController {

    @Autowired
    TaxiRepository taxiRepository;

    @RequestMapping(
        value = "taxis/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Taxi accept(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taxi/accept  called #####");
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);

        optionalTaxi.orElseThrow(() -> new Exception("No Entity Found"));
        Taxi taxi = optionalTaxi.get();
        taxi.accept();

        taxiRepository.save(taxi);
        return taxi;
    }

    @RequestMapping(
        value = "taxis/{id}/departure",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Taxi departure(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taxi/departure  called #####");
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);

        optionalTaxi.orElseThrow(() -> new Exception("No Entity Found"));
        Taxi taxi = optionalTaxi.get();
        taxi.departure();

        taxiRepository.save(taxi);
        return taxi;
    }

    @RequestMapping(
        value = "taxis/{id}/boarding",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Taxi boarding(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taxi/boarding  called #####");
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);

        optionalTaxi.orElseThrow(() -> new Exception("No Entity Found"));
        Taxi taxi = optionalTaxi.get();
        taxi.boarding();

        taxiRepository.save(taxi);
        return taxi;
    }

    @RequestMapping(
        value = "taxis/{id}/arrival",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Taxi arrival(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taxi/arrival  called #####");
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);

        optionalTaxi.orElseThrow(() -> new Exception("No Entity Found"));
        Taxi taxi = optionalTaxi.get();
        taxi.arrival();

        taxiRepository.save(taxi);
        return taxi;
    }

    @RequestMapping(
        value = "taxis/{id}/payment",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Taxi payment(
        @PathVariable(value = "id") Long id,
        @RequestBody PaymentCommand paymentCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taxi/payment  called #####");
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);

        optionalTaxi.orElseThrow(() -> new Exception("No Entity Found"));
        Taxi taxi = optionalTaxi.get();
        taxi.payment(paymentCommand);

        taxiRepository.save(taxi);
        return taxi;
    }
}
