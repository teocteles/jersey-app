package br.edu.webservice.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.persistence.platform.database.HSQLPlatform;
import org.glassfish.jersey.server.model.ParamQualifier;

import br.edu.webservice.entity.Pessoa;
import br.edu.webservice.util.Constantes;
import javafx.scene.media.Media;

@Path("/")
public class AloMundoService {
	
	@GET
	public String aloMundo() {
		return "Alô Mundo";
	}
	
	@POST
	public String aloMundoPost() {
		return "Alo mundo post";
	}
	
	@GET
	@Path("html")
	public String html() {
		return "<h1> Teste html </h1>";
	}
	
	@GET
	@Path("nohtml")
	@Produces(MediaType.TEXT_PLAIN)
	public String naoInterpretaHtml() {
		return "<h1> Nao interpreta o html </h1>";
	}
	
	@GET
	@Path("parametro")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String mensagemComParametro(@QueryParam("msg") String msg) {
		return "<h1> Nao interpreta o html </h1>"+msg;
	}
	
	@GET
	@Path("parametro2/{msg}")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.TEXT_PLAIN)
	public String msgParametro2(@PathParam("msg") String msg) {
		return "Param: "+msg;
	}
	
	@POST
	@Path("json")
	@Produces(Constantes.APPLICATION_JSON_UTF8)
	@Consumes(Constantes.APPLICATION_JSON_UTF8)
	public Pessoa testJson(Pessoa p) {
		System.out.println(p.getNome());
		
		p.setNome("Cláudia");
		
		List<Pessoa> filhos = new ArrayList<>();
		Map<String, Pessoa> irmaos = new HashMap<>();
		
		for(int i = 1; i < 5; i++) {
			Pessoa filho = new Pessoa();
			filho.setNome("Filho "+i);

			Pessoa irmao = new Pessoa();
			irmao.setNome("Irmao" +i);
			irmaos.put(String.valueOf(i),irmao);
			
			filhos.add(filho);
			
		}
		
		p.setIrmaos(irmaos);
		p.setFilhos(filhos);
		
		return p;
	}
	
	
	
	

}
