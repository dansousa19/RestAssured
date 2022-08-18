package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class MassaDados {

	public String birthDate = "1977-06-13";

	public String gerarLastName() {
		String nome = RandomStringUtils.randomAlphabetic(3);
		return nome.toLowerCase();
	}

}
