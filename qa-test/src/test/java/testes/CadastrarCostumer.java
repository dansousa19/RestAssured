package testes;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.MassaDados;

public class CadastrarCostumer {
	
	RequestSpecification request = RestAssured.given().header("Content-Type", "application/json");
	JSONObject json = new JSONObject();
	
	MassaDados dados = new MassaDados();
	
	public JSONObject enviarDados(String nome) {
		
		json.put("birthDate", dados.birthDate);
		json.put("lastName", nome);
		json.put("name", "Jose");	
		return json;
	}

	
	@Test
	public void cadastrarCustomerExistente() {	
		enviarDados("Jose Cabral Ramos");
		request.body(json.toJSONString());
		Response response = request.post("http://localhost:9090/customer");
		assertEquals(400, response.getStatusCode());
	}
	

	@Test
	public void cadastrarCustomer() {	
		enviarDados(dados.gerarLastName());
		request.body(json.toJSONString());
		Response response = request.post("http://localhost:9090/customer");
		assertEquals(200, response.getStatusCode());
	}
	

}
