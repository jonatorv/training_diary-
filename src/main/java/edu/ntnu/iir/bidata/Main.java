package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.controller.Ui;

/**
 * The entry point of the application.
 *
 * <p>This class is responsible for creating the Ui instance and
 * starting the training diary application. </p>
 */
public class Main {

  /**
   * The main method of the program.
   *
   * <p>It initializes the user interface, loads initial data, and starts the application loop.</p>
   *
   * @param args the command line arguments (not used)
   */
  public static void main(String[] args) {
    Ui ui = new Ui();
    ui.init();
    ui.start();
  }
}
