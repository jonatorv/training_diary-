package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.controller.Ui;

/**
 * The main starting point of your application. Let this class create the instance of your
 * main-class that starts your application.
 */
public class Main {

  /**
   * The main method. This is where the application initialization and starting takes place.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Ui ui = new Ui();
    ui.init();
    ui.start();
  }
}

