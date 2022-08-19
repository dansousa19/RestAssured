package testes;

import static org.junit.Assert.assertEquals;
import org.json.simple.JSONObject;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CadastrarCustomer {
	
	RequestSpecification request;
	Response response;

	@Test
	public void testConsultar() {

		request = RestAssured.given().header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("birthDate", "1977-06-13");
		json.put("lastName", "Cabral Ramos");
		json.put("name", "Jose");

		request.body(json.toJSONString());

		response = request.post("http://localhost:9090/customer");
		//Para consutar basta trocar de post para get
		System.out.println(response.asPrettyString());

	}

}