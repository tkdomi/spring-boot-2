package pl.hqbusiness.springboot2.week3.service;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.hqbusiness.springboot2.week3.dao.CarDao;
import pl.hqbusiness.springboot2.week3.model.Car;
import pl.hqbusiness.springboot2.week3.model.Color;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

  private final CarDao carDao;

  @Autowired
  public CarService(@Qualifier("carMysqlDao") CarDao carDao) {
    this.carDao = carDao;
  }

  public List<Car> getCars() {
    return carDao.getCars();
  }

  public Optional<Car> getCar(Long id) {
    return carDao.getCar(id);
  }

  public boolean addCar(Car car){
    return carDao.addCar(car);
  }

  public boolean updateCar(Car car) {
    return carDao.updateCar(car);
  }

  public boolean deleteCar(Long id) {
    return carDao.deleteCar(id);
  }

  public boolean repaintCar(long id, Color color) {
    return carDao.repaintCar(id, color);
  }

  public List<Car> findCarsByColor(Color color) {
    return carDao.findCarsByColor(color);
  }

  public List<Car> findCarsByYears(Integer yearFrom, Integer yearTo) { return carDao.findCarsByYears(yearFrom, yearTo); }
}
