package br.mackenzie.lfs.model.dto;

import org.modelmapper.ModelMapper;

import br.mackenzie.lfs.util.ObjectMapperUtils;

/**
 * The type informed on declarion is the entity to which the DTO class will be
 * converted to
 */
public abstract class DTO<T,D> {

	private static final ModelMapper modelMapper = new ModelMapper();

	public T convertToExistingEntity(T existingEntity) {
		modelMapper.map(this, existingEntity);
		return existingEntity;
	}

	public T convertToNonExistingEntity(Class<T> classType) {
		return modelMapper.map(this, classType);
	}

	public D convertEntityToDto(T entity, Class<D> dtoClass) {
		return ObjectMapperUtils.map(entity, dtoClass);
	}

}
