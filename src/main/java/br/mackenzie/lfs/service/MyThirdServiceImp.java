package br.mackenzie.lfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyThirdServiceImp implements MyThirdService {

    @Autowired
    private SomeOtherService someOtherService;

    @Override
    public int yetAnother(int one, int two) {
        someOtherService.someOtherMethod("Something");
        return one + two;
    }
}
