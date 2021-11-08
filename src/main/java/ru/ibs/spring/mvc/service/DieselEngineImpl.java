package ru.ibs.spring.mvc.service;

public class DieselEngineImpl implements Engine {
    @Override
    public String powerUp() {
        return "On diesel";
    }
}
