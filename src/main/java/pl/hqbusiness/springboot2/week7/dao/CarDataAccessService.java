package pl.hqbusiness.springboot2.week7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.hqbusiness.springboot2.week3.dao.CarDao;
import pl.hqbusiness.springboot2.week3.model.Car;
import pl.hqbusiness.springboot2.week3.model.Color;

import java.util.List;
import java.util.Optional;

@Repository("carMysqlDao")
public class CarDataAccessService implements CarDao {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public CarDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Car> getCars() {
    String sql = "SELECT * FROM cars";
    return jdbcTemplate.query(sql, (rs, rowNum) ->
        new Car(rs.getLong("id"),
            rs.getString("mark"),
            rs.getString("model"),
            Color.valueOf(rs.getString("color")),
            rs.getInt("year")));
  }

  @Override
  public Optional<Car> getCar(Long id) {
    String sql = "SELECT * FROM cars WHERE id = ?";
    Car car = jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
        new Car(rs.getLong("id"),
            rs.getString("mark"),
            rs.getString("model"),
            Color.valueOf(rs.getString("color")),
            rs.getInt("year")), id);
    return Optional.of(car);
  }

  @Override
  public boolean addCar(Car car) {
    String sql = "INSERT INTO cars (mark, model, color, year) VALUES (?, ?, ?, ?)";
    System.out.println(car);
    try {
      jdbcTemplate.update(sql, car.getMark(), car.getModel(), car.getColor().toString(), car.getYear());
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return false;
    }
    return true;
  }

  @Override
  public boolean updateCar(Car car) {
    String sql = "UPDATE cars SET mark = ?, model = ?, color = ?, year = ? WHERE id = ?";
    try {
      jdbcTemplate.update(sql, car.getMark(), car.getModel(), car.getColor().toString(), car.getYear(), car.getId());
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return false;
    }
    return true;
  }

  @Override
  public boolean deleteCar(Long id) {
    String sql = "DELETE FROM cars WHERE id = ?";
    try {
      jdbcTemplate.update(sql, id);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return false;
    }
    return true;
  }

  @Override
  public boolean repaintCar(Long id, Color color) {
    Optional<Car> car = getCar(id);
    if (car.isPresent()) {
      car.get().setColor(color);
      return updateCar(car.get());
    }
    return false;
  }

  @Override
  public List<Car> findCarsByColor(Color color) {
    String sql = "SELECT * FROM cars WHERE color = ?";
    return jdbcTemplate.query(sql, (rs, rowNum) ->
        new Car(rs.getLong("id"),
            rs.getString("mark"),
            rs.getString("model"),
            Color.valueOf(rs.getString("color")),
            rs.getInt("year")), color.toString());
  }

  @Override
  public List<Car> findCarsByYears(Integer yearFrom, Integer yearTo) {
    String sql = "SELECT * FROM cars WHERE year >= ? AND year <= ?";
    return jdbcTemplate.query(sql, (rs, rowNum) ->
        new Car(rs.getLong("id"),
            rs.getString("mark"),
            rs.getString("model"),
            Color.valueOf(rs.getString("color")),
            rs.getInt("year")), yearFrom, yearTo);
  }
}
