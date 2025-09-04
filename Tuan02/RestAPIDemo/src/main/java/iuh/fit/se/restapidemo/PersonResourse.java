package iuh.fit.se.restapidemo;

import iuh.fit.se.dao.PersonStorage;
import iuh.fit.se.models.Person;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Set;

@Path("/users")
public class PersonResourse {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Person> getPersons() {
        return PersonStorage.getPersons();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") String id) {
        Person person = PersonStorage.getPerson(id);
        // Nếu không có if thì sẽ trả về 204 No Content
        if (person == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return person;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        return PersonStorage.addPerson(person)?
                Response.ok().build() :
                Response.status(Response.Status.CONFLICT).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(Person person, @PathParam("id") String id) {
        person.setId(id);
        return PersonStorage.updatePerson(person)?
                Response.ok().build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") String id) {
        return PersonStorage.removePerson(id)?
                Response.ok().build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }
}
/*
POST: http://localhost:8080/RestAPIDemo/api/users
{
    "name": "Bùi Quang Minh",
    "age": 21,
    "dob": {
        "year": 2004,
        "month": 4,
        "day": 26
    }
}

PUT: http://localhost:8080/RestAPIDemo/api/users/30
{
    "name": "Bùi Quang Vinh"
}

DELETE: http://localhost:8080/RestAPIDemo/api/users/30
 */
