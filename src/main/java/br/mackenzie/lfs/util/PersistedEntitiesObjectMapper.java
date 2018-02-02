package br.mackenzie.lfs.util;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.lang.reflect.Field;

@Component
public class PersistedEntitiesObjectMapper {

    private EntityManager entityManager;
    private static final ModelMapper modelMapper = new ModelMapper();

    Logger logger = LoggerFactory.getLogger(PersistedEntitiesObjectMapper.class);

    @Autowired
    public PersistedEntitiesObjectMapper (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @param entityClass, the <code>Class</code> defining the Entity to which the dto object will be converted to
     * @param dto, the source object to be converted
     * @return the converted object
     * */
    public <T> T convertDTOToEntity (Object dto, Class<T> entityClass) {

        Object id = getEntityId(dto);
        if (id == null) {
            logger.info("Id is null");
            return modelMapper.map(dto, entityClass);
        } else {
            logger.info("Id is not null");
            T persistedObject = entityManager.find(entityClass,id);
            modelMapper.map(dto,persistedObject);
            return persistedObject;
        }

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
