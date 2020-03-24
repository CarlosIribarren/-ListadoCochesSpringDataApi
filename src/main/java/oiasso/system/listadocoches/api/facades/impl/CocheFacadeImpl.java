package oiasso.system.listadocoches.api.facades.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import oiasso.system.listadocoches.api.converters.CocheConverter;
import oiasso.system.listadocoches.api.daos.CocheDao;
import oiasso.system.listadocoches.api.dtos.CocheDTO;
import oiasso.system.listadocoches.api.entitys.Coche;
import oiasso.system.listadocoches.api.facades.CocheFacade;

@Service
public class CocheFacadeImpl implements CocheFacade {

	@Autowired
	private CocheDao cocheDao; 

	@Autowired
	private CocheConverter cocheConverter;
	
	@Override
	public Page<CocheDTO> findAll(Pageable pageable) {
		Page<Coche> coches = cocheDao.findAll(pageable);
		Page<CocheDTO> cochesDTO = cocheConverter.fromEntity(coches, pageable);
		return cochesDTO;
	}

	@Override
	public CocheDTO findByMatricula(String matricula) {
		Coche cocheEntity = cocheDao.findByMatricula(matricula);
		CocheDTO cocheDTO = cocheConverter.fromEntity(cocheEntity);
		return cocheDTO;
	}
	
	@Override
	public Page<CocheDTO> findByFechaMatriculacionBetween(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable) {
		Page<Coche> coches = cocheDao.findByFechaMatriculacionBetween(fechaInicio, fechaFin, pageable);
		Page<CocheDTO> cochesDTO = cocheConverter.fromEntity(coches, pageable);
		return cochesDTO;
	}



}
