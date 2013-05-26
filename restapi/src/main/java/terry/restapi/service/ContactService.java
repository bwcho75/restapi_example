package terry.restapi.service;

// service

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import terry.restapi.dao.ContactDao;
import terry.restapi.model.ContactVo;

@Path("/contact")
public class ContactService {
	ContactDao dao;
	public void setContactDao(ContactDao dao){this.dao = dao;}
	
	@POST
	public void create(ContactVo contact){
		
	}
	@GET
	@Produces("application/json")
	@Path("{email}")
	public ContactVo get(@PathParam("email") String email){
		return dao.get(email);
	}
	@PUT
	@Path("{email}")
	public void update(@PathParam("email") String email, ContactVo contact){
		dao.update(email, contact);
	}
}
