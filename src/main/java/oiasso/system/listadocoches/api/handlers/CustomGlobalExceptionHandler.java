package oiasso.system.listadocoches.api.handlers;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// *********************
	// ***** Constantes ****
	// *********************

	private static final Logger LOG = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);
	
	

	/**
	 * Se define un capturador de excepciones general. para cuando no cumple las validaciones.
	 * Asi nos evitamos tener que escribir en cada metodo del controlador que aparezca @Valid el siguiente trozo de codigo:
	 * 
	 *  	if(bindingResult.hasErrors()) {
	 *  		return new ResponseEntity<>(bindingResult. getAllErrors(), HttpStatus.BAD_REQUEST);
	 *  	}
	 */
	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        body.put("errors", ex.getAllErrors());

        return new ResponseEntity<>(body, headers, status);
	}
    
    
	// *************************
	// ***** Otros Errores  ****
	// *************************
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleErrorException(HttpServletRequest req, Exception ex) {
		LOG.error("Se ha producido un error interno.",ex);
		return new ResponseEntity<>("Se ha producido un error", null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
}
