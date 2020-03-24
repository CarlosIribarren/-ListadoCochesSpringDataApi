package oiasso.system.listadocoches.api.validators;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import oiasso.system.listadocoches.api.dtos.CocheFilterDTO;

/**
 * Valida que en el filtro de Coches la fecha de inicio no sea inferior a la fecha de fin.
 */
public class CocheFilterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CocheFilterDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		CocheFilterDTO cocheFilter = (CocheFilterDTO) target;
		

			LocalDate fechaInicio = cocheFilter.getFechaInicio();
			LocalDate fechaFin = cocheFilter.getFechaFin();

			if (fechaInicio != null && fechaFin != null) {
				if (fechaInicio.isAfter(fechaFin)) {
					errors.rejectValue("fechaInicio", "La fecha de inicio tiene que ser anterior a la fecha de fin");
					errors.rejectValue("fechaFin", "La fecha de fin tiene que ser posterior a la fecha de inicio");
				}
			}
			
		


	}

}
