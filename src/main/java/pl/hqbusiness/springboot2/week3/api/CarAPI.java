package pl.hqbusiness.springboot2.week3.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hqbusiness.springboot2.week3.model.Car;
import pl.hqbusiness.springboot2.week3.model.Color;
import pl.hqbusiness.springboot2.week3.service.CarService;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarAPI {

  private CarService carService;

  public CarAPI(CarService carService) {
    this.carService = carService;
  }

  @GetMapping
  public ResponseEntity<List<Car>> getCars() {
    return ResponseEntity.ok(carService.getCars());
  }

  @GetMapping(path="/{id}")
  public ResponseEntity<Car> getCar(@PathVariable Long id) {
    return carService.getCar(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
  }

  @PostMapping
  public ResponseEntity<Void> addCar(@RequestBody Car car){
    return carService.addCar(car)
        ? ResponseEntity.ok().build()
        : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  @PutMapping
  public ResponseEntity<Void> updateCar(@RequestBody Car car) {
    return carService.updateCar(car)
        ? ResponseEntity.ok().build()
        : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCar(@PathVariable Long id){
    return carService.deleteCar(id)
        ? ResponseEntity.ok().build()
        : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  @PutMapping(path = "/{id}/repaint/{color}")
  public ResponseEntity<Void> repaintCar(@PathVariable Long id, @PathVariable Color color) {
    return carService.repaintCar(id, color)
        ? ResponseEntity.ok().build()
        : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  @GetMapping(path="/filter-by-color")
  public ResponseEntity<List<Car>> filterCarsByColor(@RequestParam Color color){
    List<Car> colorCars = carService.findCarsByColor(color);

    return !colorCars.isEmpty()
      ? ResponseEntity.ok(colorCars)
      : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  @GetMapping(path="/color/{color}")
  public ResponseEntity<List<Car>> findCarsByColor(@PathVariable Color color){
    List<Car> colorCars = carService.findCarsByColor(color);

    return ResponseEntity.ok(colorCars);
  }
}
