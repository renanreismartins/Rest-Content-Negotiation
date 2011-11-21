package br.com.renan.resource;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.renan.model.Funcionario;

@Path("/funcionarios")
public class FuncionarioResource {

	Map<Integer, Funcionario> repository = new HashMap<Integer, Funcionario>();

	public FuncionarioResource() {
		Funcionario renan = new Funcionario(1, "Renan Reis", "/foto.jpg");
		repository.put(1, renan);
	}

	@GET
	@Path("{id}")
	@Produces({ "application/xml", "application/json" })
	public Funcionario getFuncionario(@PathParam("id") Integer id) {
		Funcionario funcionario = repository.get(id);
		return funcionario;
	}

	@GET
	@Path("{id}")
	@Produces({ "image/jpeg", "image/jpg" })
	public byte[] getPhoto(@PathParam("id") Integer id) {
		Funcionario funcionario = repository.get(1);
		
		try {
			InputStream is = this.getClass().getResourceAsStream(funcionario.getCaminhoFoto());

			BufferedImage img = ImageIO.read(is);

			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			ImageIO.write(img, "jpg", bao);

			return bao.toByteArray();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}