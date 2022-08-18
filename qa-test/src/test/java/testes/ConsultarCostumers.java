package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConsultarCostumers {
	
	
	Response response = RestAssured.get("http://localhost:9090/customer");
	
	
	
	@Test
	public void consultar() {
		System.out.println(response.asPrettyString());
		assertEquals(200, response.getStatusCode());
	}

}
