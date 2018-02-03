package br.mackenzie.lfs.util;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mackenzie.lfs.model.dto.DTO;

@Component
public class PersistedEntitiesObjectMapper {

    private EntityManager entityManager;
    Logger log = LoggerFactory.getLogger(ModelMapper.class);

    @Autowired
    public PersistedEntitiesObjectMapper (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @param entityClass, the Class defining the Entity to which the dto object will be converted to
     * @param dto, the source object to be converted
     * @return the converted object
     * */
    public <T> T convertDTOToEntity (DTO <T> dto, Class<T> entityClass) {

        Object id = getEntityId(dto);
        
        T persistedObject = null;
        
        if(id != null) 
        	persistedObject = entityManager.find(entityClass, id);
        	
        if(id == null || persistedObject == null)
        	return dto.convertToNonExistingEntity(entityClass);
        else
        	return dto.convertToExistingEntity(persistedObject);

    }

    /**
     * Search for the id of a given dto object
     *
     * @param dto, object through which fields the id annotation will be looked for
     * @return return id as a object, if it is declared as a field; null otherwise
     * */
    private Object getEntityId(Object dto) {

        for(Field field : dto.getClass().getDeclaredFields()) {
            if(field.getAnnotation(Id.class) != null) {
                try {
                    field.setAccessible(true);
                    return field.get(dto);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException();
                }
            }
        }

        return null;

    }

}
