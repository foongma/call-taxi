package calltaxi.domain;

import calltaxi.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "taxis", path = "taxis")
public interface TaxiRepository
    extends PagingAndSortingRepository<Taxi, Long> {}
