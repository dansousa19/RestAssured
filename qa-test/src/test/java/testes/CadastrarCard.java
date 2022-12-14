package testes;

import static org.junit.Assert.assertEquals;
import org.json.simple.JSONObject;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CadastrarCard {

	RequestSpecification request;
	Response response;

	@Test
	public void testConsultar() {

		request = RestAssured.given().header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("brand", "MASTER");
		json.put("customerId", 1);
		json.put("cvc", 570);
		json.put("expirationMoth", 4);
		json.put("expirationYear", 2026);
		json.put("holderName", "Jose Cabral Ramos");
		json.put("number", "4356874523650001");

		request.body(json.toJSONString());

		response = request.post("http://localhost:9090/card");
		System.out.println(response.asPrettyString());

	}

}