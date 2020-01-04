package controller;

import model.IUser;

public interface IFeatures {

  /**
   * A method that allows a user to accept a message
   * @param message the Message being sent
   */
  public void acceptMessage(String message);

  /**
   * A method that allows a user to ask for help
   * @param toAsk the list of users to be asked for help
   */
  public void askForHelp(IUser... toAsk);

  /**
   * A method that allows this user to request to be friends with another user.
   * @param other the desired other user to befriend.
   */
  public void requestFriend(IUser other);


}
