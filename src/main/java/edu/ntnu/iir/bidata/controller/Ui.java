package edu.ntnu.iir.bidata.controller;

import edu.ntnu.iir.bidata.controller.menus.EntryOverview;
import edu.ntnu.iir.bidata.controller.menus.MainMenu;
import edu.ntnu.iir.bidata.controller.view.DiaryPrinter;
import edu.ntnu.iir.bidata.model.DiaryRegister;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Handles the user interface for the diary application.
 *
 * <p>This class is responsible for initializing the diary entries and starting the application.
 */
public class Ui {
  private DiaryRegister register;
  private DiaryPrinter printer;

  /** Initializes the diary entries. */
  public void init() {
    register = new DiaryRegister();
    printer = new DiaryPrinter();

    try {
      register.createAndAddDiaryEntry("Maraton", "Jonas", "Halvmaraton", 90, "løping");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println("------------------------------");
    }
    try {
      register.createAndAddDiaryEntryCustomDate(
          "Halvmaraton",
          "Jonas",
          "Halvmaraton",
          90,
          "løping",
          LocalDate.of(2025, 10, 4));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println("------------------------------");
    }
  }

  /** Starts the application. */
  public void start() {
    printer.printWelcomeMessage();
    Scanner inputReader = new Scanner(System.in);
    boolean running = true;



    while (running){
      int mainMenuChoice = inputReader.nextInt();
      MainMenu mainMenu = MainMenu.values()[mainMenuChoice];

      switch (mainMenu){
        case ENTRY_OVERVIEW:


          boolean runningOverviewMenu = true;

          while (runningOverviewMenu) {
            printer.printChooseOperationMessage();
            int overviewMenuChoice = inputReader.nextInt();
            EntryOverview entryOverview = EntryOverview.values()[overviewMenuChoice];


            switch (entryOverview){
              case SHOW_ALL_ENTRIES:
                printer.printAllDiaryEntries(register);
                break;

              case SHOW_ENTRIES_FROM_DATE:
                printer.printEnterDayMessage();
                int day = inputReader.nextInt();
                printer.printEnterMonthMessage();
                int month = inputReader.nextInt();
                printer.printEnterYearMessage();
                int year = inputReader.nextInt();
                LocalDate date = LocalDate.of(year, month, day);
                printer.printDiaryEntryFromDate(date, register);




                break;
            }

          }
          break;

        default:
          running = false;
      }


    }





   // System.out.println();
    //System.out.println("Welcome to the diary application!");
    //printer.printAllDiaryEntries(register);
  }
}
