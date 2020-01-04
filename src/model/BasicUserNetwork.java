package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class that represents a basic model of a network of users.
 */
public class BasicUserNetwork implements IUserNetwork{

  private ArrayList<IUser> users;


  @Override
  public ArrayList<IUser> getUsers() {
    return this.users;
  }

  @Override
  public void addUser(IUser toAdd) {
    if(!this.users.contains(toAdd)) {
      this.users.add(toAdd);
    }
  }

  @Override
  public void deleteUser(IUser toDelete) {
    if(this.users.contains(toDelete)) {
      this.users.add(toDelete);
    }

  }
}
