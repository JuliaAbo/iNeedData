package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A basic implementation of a user
 */
public class BasicUser implements IUser {

  private String name;
  private String status;
  private HashMap<INeeds, Affirmative> currentneeds;
  private ArrayList<IUser> friends;


  private BasicUser(UserBuilder builder) {
    this.name = builder.name;
    this.status = builder.status;
    this.currentneeds = builder.currentneeds;
    this.friends = new ArrayList<IUser>();
  }

  // A builder to construct a default user and later allow for customized entries.
  public class UserBuilder {
    public String name;
    public String status;
    public HashMap<INeeds, Affirmative> currentneeds;

    public UserBuilder(String name){
      this.name = name;
      this.status = "Just downloaded iNeed!";
      this.currentneeds.put(new Needs("Physical Contact"), Affirmative.NEUTRAL);
      this.currentneeds.put(new Needs("Verbal Affirmation"), Affirmative.NEUTRAL);
      this.currentneeds.put(new Needs("Make me laugh"), Affirmative.NEUTRAL);
      this.currentneeds.put(new Needs("Let me be heard"), Affirmative.NEUTRAL);
      this.currentneeds.put(new Needs("Give me space"), Affirmative.NEUTRAL);
      this.currentneeds.put(new Needs("Give me some company"), Affirmative.NEUTRAL);
    }

    // A method that allows a client to construct a user with custom needs from their creation.
    public UserBuilder Need(INeeds needToAdd, Affirmative defaultValue) {
      this.currentneeds.put(needToAdd, defaultValue);
      return this;
    }


    // A constructor that builds a BasicUser with presets.
    public BasicUser build(){
      return new BasicUser(this);
    }

  }

  @Override
  public void acceptFriendRequest(IUser personRequestingFriendship) {
    this.friends.add(personRequestingFriendship);
  }

  @Override
  public void createNeed(String need) {
    this.currentneeds.put(new Needs(need), Affirmative.NEUTRAL);
  }

  @Override
  public void changeNeed(INeeds toChange, Affirmative changeTo) {
    if (!this.currentneeds.containsKey(toChange)) {
      throw new IllegalArgumentException();
    }
    for (Map.Entry<INeeds, Affirmative> entry : this.currentneeds.entrySet()) {
      if (entry.getKey().equals(toChange)) {
        entry.setValue(changeTo);
      }
    }
  }

  @Override
  public void changeStatus(String status) {
    this.status = status;
  }

  @Override
  public void deleteNeed(INeeds toDelete) {
    this.currentneeds.remove(toDelete);
  }

 /* @Override
  public void askForHelp(IUser... toAsk) {
    String message = this.helpMessageGenerator();
    for(IUser user: toAsk) {
      user.getMessage(message);
    }
  }
*/

  @Override
  public void removeFriend(IUser toRemove) {
    this.friends.remove(toRemove);
  }

  @Override
  public String getName() {
    return this.name;
  }

  private String helpMessageGenerator() {
    String message = "Your friend needs help! Try one of these things:";
    for (Map.Entry<INeeds, Affirmative> entry : this.currentneeds.entrySet()) {
      if (entry.getValue().equals(Affirmative.YES)) {
        message = message + "\n - " + entry.getValue().toString();
      }
    }
    return message;
  }


}
