package pl.hqbusiness.springboot2.week6.model;

public class Movie {

  private String name;
  private Integer year;
  private String producer;

  public Movie(String name, Integer year, String producer) {
    this.name = name;
    this.year = year;
    this.producer = producer;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  @Override
  public String toString() {
    return "Movie{" +
        "name='" + name + '\'' +
        ", year=" + year +
        ", producer='" + producer + '\'' +
        '}';
  }
}
