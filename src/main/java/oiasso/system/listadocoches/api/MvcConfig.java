package oiasso.system.listadocoches.api;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {

	/**
	 * 	Si realizamoso una petición ajax desde JavaScript, estas peticiones por defecto están limitadas a ficheros JavaScript
	 *  que nos descarguemos desde el mismo servidor. Es decir, solo se pueden realizar llamadas ajax desde JavaScript desde ficheros
	 *  descargados desde el mismo servidor al que hacemos la peticion. Si intentamos hacer la llamada desde un fichero que no se ha 
	 *  descargado desde el mismo servidor, dara un error de CORS. Para permitir que se puedan hacer llamadas AJAX desde ficheros js
	 *  que no se han descargado desde el mismo servidor, se permiten CORS para todas las URLs.
	 */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
	
}
