package oiasso.system.listadocoches.api.daos;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import oiasso.system.listadocoches.api.entitys.Coche;


public interface CocheDao extends PagingAndSortingRepository<Coche, Integer> {

	Coche findByMatricula(String matricula);
	
	Page<Coche> findByFechaMatriculacionBetween(LocalDate inicio, LocalDate fin, Pageable pageable);

}
