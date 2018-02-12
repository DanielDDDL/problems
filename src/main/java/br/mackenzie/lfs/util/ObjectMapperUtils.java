package br.mackenzie.lfs.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


public class ObjectMapperUtils {

    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private ObjectMapperUtils () { }

    public static <D,T> D map (final T entity, Class<D> resultClass) {
        return modelMapper.map(entity, resultClass);
    }

    public static <D,T> List<D> mapAll(final Collection<T> entityList, Class<D> resultClass) {
        return entityList.stream()
                .map(entity -> map(entity, resultClass))
                .collect(Collectors.toList());
    }
}
