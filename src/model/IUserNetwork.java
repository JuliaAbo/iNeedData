package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This represents the model of the program, which is a network of users.
 * It works primarily by
 */
public interface IUserNetwork {

  /**
   * A method that returns the users in a system.
   * @return
   */
  public ArrayList<IUser> getUsers();

  /**
   * A method that adds a user to the network.
   * @param toAdd the user to add.
   */
  public void addUser(IUser toAdd);

  /**
   * A method that delets a user from the network.
   * @param toDelete the user to delete.
   */
  public void deleteUser(IUser toDelete);


}
