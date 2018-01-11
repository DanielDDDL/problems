package br.mackenzie.lfs.model;

import org.springframework.stereotype.Service;

@Service
public class InterfaceImplementer implements InterfaceX, InterfaceY {

    @Override
    public void someMethod() {
        //something
    }

    @Override
    public int someOtherMethod() {
        return 1;
    }

    @Override
    public int someThirdMethod(String andAParameter) {
        return 2;
    }

    @Override
    public int someFourthMethod(String anotherOne, int andAnother) {
        return 3;
    }
}
