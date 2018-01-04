package br.mackenzie.lfs.service;

import org.springframework.stereotype.Service;

@Service
public class SomeOtherServiceImp implements SomeOtherService {

    @Override
    public String someOtherMethod(String someParameter) {
        return someParameter;
    }
}
