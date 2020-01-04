package model;

/**
 * An interface that represents the behaviors that a User can take in this system.
 */
public interface IUser {

  /**
   * A method that allows this user to request to be friends with another user.
   * @param other the desired other user to befriend.
   */
  public void requestFriend(IUser other);

  /**
   * A method that allows this user to recieve a friend quest and file it to be managed.
   */
  public void takeFriendRequest();

  /**
   * A method that allows a user to accept a friend request, becoming friends with the given user.
   */
  public void acceptFriendRequest();

  /**
   * This allows the user to create their own customized need.
   * @param need the string description of their need.
   */
  public void createNeed(String need);

  /**
   * This is a method that allows a user to update what their current Needs are.
   * @param toChange the need that should be updated.
   */
  public void changeNeed(INeed toChange, Affirmative changeTo);

  /**
   * A method that allows a user to update their currrent status as desired.
   * @param status the status to be updated with.
   */
  public void changeStatus(String status);

  /**
   * Allows a user to delete a need that is no longer relevant to them.
   * @param toDelete
   */
  public void deleteNeed(INeed toDelete);

  /**
   * A method that allows a user to send a message to their friends asking for help, based on
   * their profile information.
   */
  public void askForHelp(IUser... toAsk);


  /**
   * A method that allows for a message to be recieved by a user.
   * @param message the message to be recieved.
   */
  public void getMessage(String message);
}
