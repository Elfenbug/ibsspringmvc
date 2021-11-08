package ru.ibs.spring.mvc.service;

public class PetrolEngineImpl implements Engine {
    @Override
    public String powerUp() {
        return "On petrol";
    }

}
