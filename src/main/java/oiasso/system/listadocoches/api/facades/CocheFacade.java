package oiasso.system.listadocoches.api.facades;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import oiasso.system.listadocoches.api.dtos.CocheDTO;
import oiasso.system.listadocoches.api.entitys.Coche;

public interface CocheFacade {

	Page<CocheDTO> findAll(Pageable pageable);
	
	CocheDTO findByMatricula(String matricula);
	
	Page<CocheDTO> findByFechaMatriculacionBetween(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable);
	
}
