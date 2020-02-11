package oiasso.system.listadocoches.api.variables;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * Clase donde se agrupas todas las variables de entorno para este proyecto. 
 * Solo se implementan los metodos get.
 */

@Component
public class VariablesEntornoListadoCochesAPI {

	// *********************
	// ***** Atributos *****
	// *********************
	
	@Value("${DB_URL:jdbc:postgresql://localhost:5432/db_coches}")
	private String url;

	@Value("${DB_SCHEMA:coches_schema}")
	private String schema;

	@Value("${DB_USER:user_coches}")
	private String username;

	@Value("${DB_PASSWORD:pass_coches}")
	private String password;

	// *********************
	// ****** Getter *******
	// *********************
	
	public String getUrl() {
		return url;
	}

	public String getSchema() {
		return schema;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	
	
}
