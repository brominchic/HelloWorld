package lessons.car;

public enum Fuel{

  Diesel ("Diesel"),
  Gas ("Gas"),
  test (null);
  private String title;


  Fuel(String title) {
    this.title = title;
  }
  public String getTitle() {
    return title;
  }
}