package oiasso.system.listadocoches.api.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public abstract class AbstractConverter<E, D> {

	public abstract E fromDto(D dto);

	public abstract D fromEntity(E entity);

	public List<E> fromDto(List<D> dtos){
		if(dtos == null) return null;
		return dtos.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
	}
	
	public List<D> fromEntity(List<E> entities){
		if(entities == null) return null;
		return entities.stream().map(entity -> fromEntity(entity)).collect(Collectors.toList());
	}

	public Page<D> fromEntity(Page<E> pages, Pageable pageable){
		if(pages == null) return null;
		List<E> entities = pages.getContent();
		List<D> collection = entities.stream().map(entity -> fromEntity(entity)).collect(Collectors.toList());
		Page<D> pageCollectionDTO = new PageImpl<>(collection, pageable, collection.size());
		return  pageCollectionDTO;
	}

}
