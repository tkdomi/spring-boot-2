package pl.hqbusiness.springboot2.week5.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.hqbusiness.springboot2.week5.model.Weather;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherAPI {

  private final String WEATHER_API = "http://api.weatherapi.com/v1/current.json?key=f8d08bdb87e844cd8cd140203201511";

  @GetMapping
  public ResponseEntity<Weather> getWeather(@RequestParam String city) {
    RestTemplate restTemplate = new RestTemplate();
    try {
      String url = WEATHER_API + "&q=" + city;
      Weather weather = restTemplate.getForObject(url, Weather.class);

      if (weather == null) {
        throw new Exception("Weather not found");
      }

      return ResponseEntity.ok(weather);
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
