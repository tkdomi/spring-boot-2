package pl.hqbusiness.springboot2.week3.dao;

import pl.hqbusiness.springboot2.week3.model.Car;
import pl.hqbusiness.springboot2.week3.model.Color;

import java.util.List;
import java.util.Optional;

public interface CarDao {

  List<Car> getCars();

  Optional<Car> getCar(Long id);

  boolean addCar(Car car);

  boolean updateCar(Car car);

  boolean deleteCar(Long id);

  boolean repaintCar(Long id, Color color);

  List<Car> findCarsByColor(Color color);

  List<Car> findCarsByYears(Integer yearFrom, Integer yearTo);
}
