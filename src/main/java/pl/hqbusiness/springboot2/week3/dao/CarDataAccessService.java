package pl.hqbusiness.springboot2.week3.dao;

import org.springframework.stereotype.Repository;
import pl.hqbusiness.springboot2.week3.model.Car;
import pl.hqbusiness.springboot2.week3.model.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("carFakeDao")
public class CarDataAccessService implements CarDao {

  private static final List<Car> DB = new ArrayList<>(Arrays.asList(
      new Car(1L, "BMV", "i8", Color.BLACK, 2020),
      new Car(2L, "Honda", "Civic", Color.BLUE, 2018),
      new Car(3L, "Audi", "A8", Color.GREEN, 2011)
  ));

  @Override
  public java.util.List<Car> getCars() {
    return DB;
  }

  @Override
  public Optional<Car> getCar(Long id) {
    return DB.stream().filter(car -> car.getId().equals(id)).findFirst();
  }

  @Override
  public boolean addCar(Car car) {
    if (car.getId() == null) {
      car.setId((long) DB.size() + 1);
    }
    return DB.add(car);
  }

  @Override
  public boolean updateCar(Car car) {
    Optional<Car> carToUpdate = getCar(car.getId());
    if (carToUpdate.isPresent()) {
      DB.remove(carToUpdate.get());
      DB.add(car);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteCar(Long id) {
    return getCar(id).map(DB::remove).orElse(false);
  }

  @Override
  public List<Car> findCarsByColor(Color color) {
    return DB
        .stream()
        .filter(car -> car.getColor().equals(color))
        .collect(Collectors.toList());
  }

  @Override
  public boolean repaintCar(Long id, Color color) {
    Optional<Car> carOptional = getCar(id);

    if (carOptional.isPresent()) {
      carOptional.get().setColor(color);
      return true;
    }
    return false;
  }

  @Override
  public List<Car> findCarsByYears(Integer yearFrom, Integer yearTo) {
    return DB.stream()
        .filter(car -> car.getYear() >= yearFrom && car.getYear() <= yearTo)
        .collect(Collectors.toList());
  }
}
