package Controll;

public interface Controller<T>{
    /**
     * CRUD + find smth */
  //  public void create(kwag*  args**);  Object... x
//    public void update();
    // TODO get instance get stuff
    public T find_by_id(int id);
    public void delete(int id);

}
