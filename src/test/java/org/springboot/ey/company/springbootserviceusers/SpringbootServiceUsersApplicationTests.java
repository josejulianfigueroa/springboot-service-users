package org.springboot.ey.company.springbootserviceusers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.ey.company.springbootserviceusers.entity.Telefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringbootServiceUsersApplication.class)
@ActiveProfiles("test")
@ComponentScan(basePackages = { "org.springboot.ey.company.springbootserviceusers.*" })
public class SpringbootServiceUsersApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testEndpointInsertarUsuariosOk() throws Exception {
		List<Telefono> phonesList = new ArrayList<>();
		Telefono phone1 = new Telefono("87104600", "9", "56") ;
		Telefono phone2 = new Telefono("44444600", "9", "56");
		phonesList.add(phone1);
		phonesList.add(phone2);
		Set<String> roles = new HashSet<>();
		roles.add("admin");
		DataUsersInTest dataUsersIn = new DataUsersInTest();
		dataUsersIn.setEmail("julian@gmail.com");
		dataUsersIn.setName("julian");
		dataUsersIn.setPassword("Arrrr42");
		dataUsersIn.setRoles(roles);
		dataUsersIn.setPhones(phonesList);

		this.mvc.perform(post("http://localhost:8050/api/v1/usuarios/insertar")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataUsersIn)))
				.andExpect(status()
						.isOk()).andReturn();
	}

	@Test
	public void testEndpointInsertarUsuariosEmailInvalido() throws Exception {
		List<Telefono> phonesList = new ArrayList<>();
		Telefono phone1 = new Telefono("87104600", "9", "56") ;
		Telefono phone2 = new Telefono("44444600", "9", "56");
		phonesList.add(phone1);
		phonesList.add(phone2);
		Set<String> roles = new HashSet<>();
		roles.add("admin");
		DataUsersInTest dataUsersIn = new DataUsersInTest();
		dataUsersIn.setEmail("juliangmail.com");
		dataUsersIn.setName("julian");
		dataUsersIn.setPassword("Arrrr42");
		dataUsersIn.setRoles(roles);
		dataUsersIn.setPhones(phonesList);

		this.mvc.perform(post("http://localhost:8050/api/v1/usuarios/insertar")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataUsersIn)))
				.andExpect(content().string("{\"codigo\":\"400 BAD_REQUEST\",\"mensaje\":\"El email no es válido\"}")).andReturn();
	}

	@Test
	public void testEndpointInsertarUsuariosPasswordIncorrecto() throws Exception {
		List<Telefono> phonesList = new ArrayList<>();
		Telefono phone1 = new Telefono("87104600", "9", "56") ;
		Telefono phone2 = new Telefono("44444600", "9", "56");
		phonesList.add(phone1);
		phonesList.add(phone2);
		Set<String> roles = new HashSet<>();
		roles.add("admin");
		DataUsersInTest dataUsersIn = new DataUsersInTest();
		dataUsersIn.setEmail("julian@gmail.com");
		dataUsersIn.setName("julian");
		dataUsersIn.setPassword("Arrrr");
		dataUsersIn.setRoles(roles);
		dataUsersIn.setPhones(phonesList);

		this.mvc.perform(post("http://localhost:8050/api/v1/usuarios/insertar")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataUsersIn)))
				.andExpect(content().string("{\"codigo\":\"400 BAD_REQUEST\",\"mensaje\":\"El password debe tener el siguiente formatato: Una Mayuscula, letras minúsculas, y dos numeros, ejemplo Aprueba22\"}")).andReturn();
	}

	@Test
	public void testEndpointInsertarUsuariosEmailYaExiste() throws Exception {
		List<Telefono> phonesList = new ArrayList<>();
		Telefono phone1 = new Telefono("87104600", "9", "56") ;
		Telefono phone2 = new Telefono("44444600", "9", "56");
		phonesList.add(phone1);
		phonesList.add(phone2);
		Set<String> roles = new HashSet<>();
		roles.add("admin");
		DataUsersInTest dataUsersIn = new DataUsersInTest();
		dataUsersIn.setEmail("julian@gmail.com");
		dataUsersIn.setName("julian");
		dataUsersIn.setPassword("Arrrr22");
		dataUsersIn.setRoles(roles);
		dataUsersIn.setPhones(phonesList);

		this.mvc.perform(post("http://localhost:8050/api/v1/usuarios/insertar")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataUsersIn)))
				.andExpect(status()
						.isOk()).andReturn();

		this.mvc.perform(post("http://localhost:8050/api/v1/usuarios/insertar")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataUsersIn)))
				.andExpect(content().string("{\"codigo\":\"400 BAD_REQUEST\",\"mensaje\":\"El email ya existe en la base de datos\"}")).andReturn();
	}

	@Test
	public void testEndpointListarUsuarios() throws Exception {
		List<Telefono> phonesList = new ArrayList<>();
		Telefono phone1 = new Telefono("87104600", "9", "56") ;
		Telefono phone2 = new Telefono("44444600", "9", "56");
		phonesList.add(phone1);
		phonesList.add(phone2);
		Set<String> roles = new HashSet<>();
		roles.add("admin");
		DataUsersInTest dataUsersIn = new DataUsersInTest();
		dataUsersIn.setEmail("julian11@gmail.com");
		dataUsersIn.setName("julian");
		dataUsersIn.setPassword("Arrrr22");
		dataUsersIn.setRoles(roles);
		dataUsersIn.setPhones(phonesList);

		this.mvc.perform(post("http://localhost:8050/api/v1/usuarios/insertar")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataUsersIn)))
				.andExpect(status()
						.isOk()).andReturn();

		LoginUsuarioTest dataLogin = new LoginUsuarioTest("julian11@gmail.com", "Arrrr22");
		MvcResult mvcResult = this.mvc.perform(post("http://localhost:8050/api/v1/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataLogin)))
				.andExpect(status()
						.isOk()).andReturn();

		String responseData = mvcResult.getResponse().getContentAsString();
		JwtDtoTest responseDto = new Gson().fromJson(responseData, JwtDtoTest.class);

		this.mvc.perform(get("http://localhost:8050/api/v1/usuarios/listar")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + responseDto.getToken())
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void testEndpointVerUsuarioPorEmail() throws Exception {
		List<Telefono> phonesList = new ArrayList<>();
		Telefono phone1 = new Telefono("87104600", "9", "56") ;
		Telefono phone2 = new Telefono("44444600", "9", "56");
		phonesList.add(phone1);
		phonesList.add(phone2);
		Set<String> roles = new HashSet<>();
		roles.add("admin");
		DataUsersInTest dataUsersIn = new DataUsersInTest();
		dataUsersIn.setEmail("julian33@gmail.com");
		dataUsersIn.setName("julian");
		dataUsersIn.setPassword("Arrrr22");
		dataUsersIn.setRoles(roles);
		dataUsersIn.setPhones(phonesList);

		this.mvc.perform(post("http://localhost:8050/api/v1/usuarios/insertar")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataUsersIn)))
				.andExpect(status()
						.isOk()).andReturn();

		LoginUsuarioTest dataLogin = new LoginUsuarioTest("julian33@gmail.com", "Arrrr22");
		MvcResult mvcResult = this.mvc.perform(post("http://localhost:8050/api/v1/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataLogin)))
				.andExpect(status()
						.isOk()).andReturn();

		String responseData = mvcResult.getResponse().getContentAsString();
		JwtDtoTest responseDto = new Gson().fromJson(responseData, JwtDtoTest.class);

		this.mvc.perform(get("http://localhost:8050/api/v1/usuarios/ver/julian33@gmail.com")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + responseDto.getToken())
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void testEndpointVerUsuarioPorEmailNoExiste() throws Exception {
		List<Telefono> phonesList = new ArrayList<>();
		Telefono phone1 = new Telefono("87104600", "9", "56") ;
		Telefono phone2 = new Telefono("44444600", "9", "56");
		phonesList.add(phone1);
		phonesList.add(phone2);
		Set<String> roles = new HashSet<>();
		roles.add("admin");
		DataUsersInTest dataUsersIn = new DataUsersInTest();
		dataUsersIn.setEmail("julian44@gmail.com");
		dataUsersIn.setName("julian");
		dataUsersIn.setPassword("Arrrr22");
		dataUsersIn.setRoles(roles);
		dataUsersIn.setPhones(phonesList);

		this.mvc.perform(post("http://localhost:8050/api/v1/usuarios/insertar")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataUsersIn)))
				.andExpect(status()
						.isOk()).andReturn();

		LoginUsuarioTest dataLogin = new LoginUsuarioTest("julian44@gmail.com", "Arrrr22");
		MvcResult mvcResult = this.mvc.perform(post("http://localhost:8050/api/v1/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataLogin)))
				.andExpect(status()
						.isOk()).andReturn();

		String responseData = mvcResult.getResponse().getContentAsString();
		JwtDtoTest responseDto = new Gson().fromJson(responseData, JwtDtoTest.class);

		this.mvc.perform(get("http://localhost:8050/api/v1/usuarios/ver/julian55@gmail.com")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + responseDto.getToken())
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string("{\"codigo\":\"204 NO_CONTENT\",\"mensaje\":\"No existe el registro\"}")).andReturn();
	}

	@Test
	public void testEndpointDeleteUsuario() throws Exception {
		List<Telefono> phonesList = new ArrayList<>();
		Telefono phone1 = new Telefono("87104600", "9", "56") ;
		Telefono phone2 = new Telefono("44444600", "9", "56");
		phonesList.add(phone1);
		phonesList.add(phone2);
		Set<String> roles = new HashSet<>();
		roles.add("admin");
		DataUsersInTest dataUsersIn = new DataUsersInTest();
		dataUsersIn.setEmail("julian88@gmail.com");
		dataUsersIn.setName("julian");
		dataUsersIn.setPassword("Arrrr22");
		dataUsersIn.setRoles(roles);
		dataUsersIn.setPhones(phonesList);

		this.mvc.perform(post("http://localhost:8050/api/v1/usuarios/insertar")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataUsersIn)))
				.andExpect(status()
						.isOk()).andReturn();

		LoginUsuarioTest dataLogin = new LoginUsuarioTest("julian88@gmail.com", "Arrrr22");
		MvcResult mvcResult = this.mvc.perform(post("http://localhost:8050/api/v1/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(dataLogin)))
				.andExpect(status()
						.isOk()).andReturn();

		String responseData = mvcResult.getResponse().getContentAsString();
		JwtDtoTest responseDto = new Gson().fromJson(responseData, JwtDtoTest.class);

		this.mvc.perform(delete("http://localhost:8050/api/v1/usuarios/delete/5")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + responseDto.getToken())
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string("{\"codigo\":\"200 OK\",\"mensaje\":\"El usuario ha sido eliminado con éxito\"}")).andReturn();

		this.mvc.perform(get("http://localhost:8050/api/v1/usuarios/ver/julian88@gmail.com")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + responseDto.getToken())
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string("{\"codigo\":\"204 NO_CONTENT\",\"mensaje\":\"No existe el registro\"}")).andReturn();
	}
}
