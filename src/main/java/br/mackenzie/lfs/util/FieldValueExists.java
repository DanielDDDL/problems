package br.mackenzie.lfs.util;

public interface FieldValueExists {

	<T> boolean fieldValueExists(String fieldName, Object value, Class<T> entityClass);
	
}
