package com.flight.info.manager.config;

import com.flight.info.manager.model.Aircraft;
import com.flight.info.manager.model.Airport;
import com.flight.info.manager.model.Flight;
import com.flight.info.manager.model.Passenger;
import com.flight.info.manager.model.Ticket;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Passenger.class);
        
        config.exposeIdsFor(Flight.class);
        config.exposeIdsFor(Aircraft.class);
        config.exposeIdsFor(Airport.class);
        config.exposeIdsFor(Ticket.class);
    }
}
