package oiasso.system.listadocoches.api.facades;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import oiasso.system.listadocoches.api.beans.Coche;

public interface CocheFacade {

	Page<Coche> findAll(Pageable pageable);
	
	Coche findByMatricula(String matricula);
	
	Page<Coche> findByFechaMatriculacionBetween(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable);
	
}
