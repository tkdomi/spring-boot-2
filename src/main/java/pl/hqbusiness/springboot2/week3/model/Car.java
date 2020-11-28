package pl.hqbusiness.springboot2.week3.model;

public class Car {
  private Long id;
  private String mark;
  private String model;
  private Color color;
  private Integer year;

  public Car() {
  }

  public Car(long id, String mark, String model, Color color, Integer year) {
    this.id = id;
    this.mark = mark;
    this.model = model;
    this.color = color;
    this.year = year;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Car{" +
        "id=" + id +
        ", mark='" + mark + '\'' +
        ", model='" + model + '\'' +
        ", color=" + color +
        ", year=" + year +
        '}';
  }
}
