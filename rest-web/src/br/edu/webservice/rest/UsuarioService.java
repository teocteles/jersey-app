package br.edu.webservice.rest;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.edu.webservice.dao.UsuarioDAO;

@Path("/user")
public class UsuarioService {
	
	private UsuarioDAO usuarioDAO;
	
	@PostConstruct
	private void init() {
		usuarioDAO = new UsuarioDAO();
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean isLoggedIn(@QueryParam("usuario") String usuario, @QueryParam("senha") String senha) {
		try {
			return usuarioDAO.isLoggedIn(usuario, senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
}
