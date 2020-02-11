package oiasso.system.listadocoches.api.facades.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import oiasso.system.listadocoches.api.beans.Coche;
import oiasso.system.listadocoches.api.daos.CocheDao;
import oiasso.system.listadocoches.api.facades.CocheFacade;

@Service
public class CocheFacadeImpl implements CocheFacade {

	@Autowired
	private CocheDao cocheDao; 
	
	@Override
	public Page<Coche> findAll(Pageable pageable) {
		return cocheDao.findAll(pageable);
	}

	@Override
	public Coche findByMatricula(String matricula) {
		return cocheDao.findByMatricula(matricula);
	}
	
	@Override
	public Page<Coche> findByFechaMatriculacionBetween(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable) {
		return cocheDao.findByFechaMatriculacionBetween(fechaInicio, fechaFin, pageable);
	}



}
