package myapp.service;

import myapp.model.Car;

import java.util.List;

public interface CarService {
    public List<Car>findAll();
    public List<Car>search(String keyword);

}
