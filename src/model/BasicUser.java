package model;

import java.util.HashMap;
import java.util.Map;

/**
 * A basic implementation of a user
 */
public class BasicUser implements IUser {

  private String name;
  private String status;
  private HashMap<INeed, Affirmative> currentneeds;


  private BasicUser(UserBuilder builder) {
    this.name = builder.name;
    this.status = builder.status;
    this.currentneeds = builder.currentneeds;
  }

  // A builder to construct a default user and later allow for customized entries.
  public class UserBuilder {
    public String name;
    public String status;
    public HashMap<INeed, Affirmative> currentneeds;

    public UserBuilder(String name){
      this.name = name;
      this.status = "Just downloaded iNeed!";
      this.currentneeds.put(new Need("Physical Contact"), Affirmative.NEUTRAL);
      this.currentneeds.put(new Need("Verbal Affirmation"), Affirmative.NEUTRAL);
      this.currentneeds.put(new Need("Make me laugh"), Affirmative.NEUTRAL);
      this.currentneeds.put(new Need("Let me be heard"), Affirmative.NEUTRAL);
      this.currentneeds.put(new Need("Give me space"), Affirmative.NEUTRAL);
      this.currentneeds.put(new Need("Give me some company"), Affirmative.NEUTRAL);
    }

    public BasicUser build(){
      return new BasicUser(this);
    }

  }

  @Override
  public void requestFriend(IUser other) {

  }

  @Override
  public void takeFriendRequest() {

  }

  @Override
  public void acceptFriendRequest() {

  }

  @Override
  public void createNeed(String need) {
    this.currentneeds.put(new Need(need), Affirmative.NEUTRAL);
  }

  @Override
  public void changeNeed(INeed toChange, Affirmative changeTo) {
    if (!this.currentneeds.containsKey(toChange)) {
      throw new IllegalArgumentException();
    }
    for (Map.Entry<INeed, Affirmative> entry : this.currentneeds.entrySet()) {
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
  public void deleteNeed(INeed toDelete) {
    this.currentneeds.remove(toDelete);
  }

  @Override
  public void askForHelp(IUser... toAsk) {
    String message = this.helpMessageGenerator();
    for(IUser user: toAsk) {
      user.getMessage(message);
    }
  }

  @Override
  public void getMessage(String message) {

  }

  private String helpMessageGenerator() {
    String message = "Your friend needs help! Try one of these things:";
    for (Map.Entry<INeed, Affirmative> entry : this.currentneeds.entrySet()) {
      if (entry.getValue().equals(Affirmative.YES)) {
        message = message + "\n - " + entry.getValue().toString();
      }
    }
    return message;
  }


}
