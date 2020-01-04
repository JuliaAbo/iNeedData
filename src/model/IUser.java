package model;

/**
 * An interface that represents the behaviors that a User can take in this system.
 */
public interface IUser {


  /**
   * A method that allows a user to accept a friend request, becoming friends with the given user.
   */
  public void acceptFriendRequest(IUser personRequestingFriendship);

  /**
   * This allows the user to create their own customized need.
   * @param need the string description of their need.
   */
  public void createNeed(String need);

  /**
   * This is a method that allows a user to update what their current Needs are.
   * @param toChange the need that should be updated.
   */
  public void changeNeed(INeeds toChange, Affirmative changeTo);

  /**
   * A method that allows a user to update their currrent status as desired.
   * @param status the status to be updated with.
   */
  public void changeStatus(String status);

  /**
   * Allows a user to delete a need that is no longer relevant to them.
   * @param toDelete
   */
  public void deleteNeed(INeeds toDelete);



  /**
   * A method that allows a friend to be removed from a user's friend list.
   * @param toRemove
   */
  public void removeFriend(IUser toRemove);

  /**
   * A method that retrieves the identifying name of this user.
   * @return the name of this user.
   */
  public String getName();
}
