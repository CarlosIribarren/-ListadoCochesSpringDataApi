package oiasso.system.listadocoches.api.assembers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import oiasso.system.listadocoches.api.beans.Coche;
import oiasso.system.listadocoches.api.controllers.CocheController;

@Component
public class CocheAssembler implements RepresentationModelAssembler <Coche, EntityModel<Coche>> {

	@Override
	public EntityModel<Coche> toModel(Coche coche) {
		// Para cada coche se añade un link con su propio link
		Link self = linkTo(methodOn(CocheController.class).findByMatricula(coche.getMatricula())).withSelfRel();
		// Se pueden añadir los links que se quieran " return new EntityModel<>(coche, self, otro,...);"
		return new EntityModel<>(coche, self);

	}

}
