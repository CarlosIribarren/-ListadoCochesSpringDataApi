package oiasso.system.listadocoches.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import oiasso.system.listadocoches.api.assembers.CocheAssembler;
import oiasso.system.listadocoches.api.beans.Coche;
import oiasso.system.listadocoches.api.facades.CocheFacade;
import oiasso.system.listadocoches.api.filters.CocheFilter;
import oiasso.system.listadocoches.api.validators.CocheFilterValidator;

@RestController
@RequestMapping("/api/coche")
public class CocheController {

	// *********************
	// ***** InitBinder ****
	// *********************
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(new CocheFilterValidator());
	}
	
	// *********************
	// ***** Atributos *****
	// *********************	
	
	@Autowired
	private CocheFacade cocheFacade;
	
    @Autowired
    private PagedResourcesAssembler<Coche> pagedAssembler;
	
    @Autowired
    private CocheAssembler cocheAssembler;
	
	// *********************
	// ****** Metodos ******
	// *********************
    
	@GetMapping("/{matricula:(\\d{4})([A-Z]{3})}")
	public EntityModel<Coche> findByMatricula(@PathVariable String matricula ) {
		Coche coche = cocheFacade.findByMatricula(matricula);
		return cocheAssembler.toModel(coche);
	}
    
    /**
     * No hace falta recibir los parametros de size, page,... como @RequestParam(value = "page") Integer page...
     * Si vienen en la URL, Spring MVC hace el binding de esos parametros por nosotros en la clase Pageable.
     */
	@GetMapping("")
	public PagedModel<EntityModel<Coche>> findAll(Pageable pageable) {
		Page<Coche> content = cocheFacade.findAll(pageable);
		return pagedAssembler.toModel(content, cocheAssembler);
	}
	

	/**
	 * Spring MVC automaticamente hace por nosotros el binding de los paramteros de la URL inicio y fin.
	 * No hay que configurar nada.
	 */
	@GetMapping("/findByFechaMatriculacionBetween")
	public ResponseEntity<Object> findByFechaMatriculacionBetween( @Valid CocheFilter cocheFilter, Pageable pageable, BindingResult bindingResult) {
		Page<Coche> content = cocheFacade.findByFechaMatriculacionBetween(cocheFilter.getFechaInicio(), cocheFilter.getFechaFin(), pageable);
		PagedModel<EntityModel<Coche>> response = pagedAssembler.toModel(content, cocheAssembler); 
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
