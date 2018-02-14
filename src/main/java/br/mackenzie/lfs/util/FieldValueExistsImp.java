package br.mackenzie.lfs.util;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;

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
		
		//TODO find a more "beautiful" way of retrieving objects from database
		//if possible, query them using a where clause
		List<T> results = em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
		
		for(T result : results) {
			
			try {
				if(PropertyUtils.getProperty(result, fieldName).equals(value))
					return true;
				
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				throw new RuntimeException("Problems accessing property value");
			}
			
		}
		
		return false;
	}

}
