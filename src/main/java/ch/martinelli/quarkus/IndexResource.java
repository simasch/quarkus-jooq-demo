package ch.martinelli.quarkus;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import static ch.martinelli.quarkus.db.tables.Employee.EMPLOYEE;

@Path("/")
public class IndexResource {

    @Inject
    DSLContext dsl;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Result<Record> employee = dsl.select().from(EMPLOYEE).fetch();

        return employee.toString();
    }
}
