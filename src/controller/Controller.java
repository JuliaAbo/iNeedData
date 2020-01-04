package controller;

import model.BasicUserNetwork;
import model.IUserNetwork;
import view.INeedView;

public class Controller {

  private IUserNetwork model;
  private INeedView view;

  public Controller(IUserNetwork model, INeedView view){
    this.model = model;
    this.view = view;
  }




}
