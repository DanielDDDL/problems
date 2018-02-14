package br.mackenzie.lfs.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Id;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Component;

@Component
public class FieldValueExistsImp implements FieldValueExists {

	private EntityManager em;
	
	public FieldValueExistsImp(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public <T> boolean fieldValueExists(String fieldName, Object value, Class<T> entityClass) {
				
		Object idFromRequestObject = getId(value);
				
		//TODO find a more "beautiful" way of retrieving objects from database
		//if possible, query them using a where clause
		List<T> results = em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
		
		for(T result : results) {
			
			try {
				
				Object idFromRetrievedObject = getId(result);
				
				boolean equalTitles  = PropertyUtils.getProperty(result, fieldName).equals(PropertyUtils.getProperty(value, fieldName));
				boolean differentIds = !idFromRetrievedObject.equals(idFromRequestObject);
								
				if(equalTitles && differentIds) 
					return true;
				
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				throw new RuntimeException("Problems accessing property value");
			}
			
		}
		
		return false;
	}
	
	private Object getId(Object object) {

		for (Field field : object.getClass().getDeclaredFields()) {
			if (field.getAnnotation(Id.class) != null) {
				try {
					field.setAccessible(true);
					return field.get(object);
				} catch (IllegalAccessException e) {
					throw new RuntimeException();
				}
			}
		}

		return null;

	}
	
}
