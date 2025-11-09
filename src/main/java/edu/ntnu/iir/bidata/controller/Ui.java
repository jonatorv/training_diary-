package edu.ntnu.iir.bidata.controller;

import edu.ntnu.iir.bidata.controller.menus.EntryAdministrations;
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
          "Halvmaraton", "Jonas", "Halvmaraton", 90, "løping", LocalDate.of(2025, 10, 4));
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

    while (running) {
      int mainMenuChoice = inputReader.nextInt();
      MainMenu mainMenu = MainMenu.values()[mainMenuChoice];

      switch (mainMenu) {
        // --------------------------------------------------------------------------------------------
        case ENTRY_OVERVIEW:
          boolean runningOverviewMenu = true;

          while (runningOverviewMenu) {
            printer.printChooseOperationMessage();
            int overviewMenuChoice = inputReader.nextInt();
            EntryOverview entryOverview = EntryOverview.values()[overviewMenuChoice];

            switch (entryOverview) {
              case PRINT_ALL_DIARY_ENTRIES:
                printer.printAllDiaryEntries(register);
                break;

              case PRINT_DIARY_ENTRIES_FROM_DATE:
                printer.printEnterDayMessage();
                int day = inputReader.nextInt();
                printer.printEnterMonthMessage();
                int month = inputReader.nextInt();
                printer.printEnterYearMessage();
                int year = inputReader.nextInt();
                LocalDate date = LocalDate.of(year, month, day);

                try {
                  printer.printDiaryEntryFromDate(date, register);
                } catch (IllegalArgumentException e) {
                  System.out.println(e.getMessage());
                }
                break;

              case PRINT_DIARY_ENTRIES_SORTED_BY_DATE:
                printer.printDiaryEntriesSortedByDate(register);
                break;

              case EXIT:
                runningOverviewMenu = false;
                break;

              default:
                System.out.println("Invalid option! Try again.");
                break;
            }
          }
          break;

        // ---------------------------------------------------------------------------------------
        case ENTRY_ADMINISTRATIONS:
          boolean runningAdministrationMenu = true;

          while (runningAdministrationMenu) {
            int administrationMenuChoice = inputReader.nextInt();
            EntryAdministrations entryAdministrations =
                EntryAdministrations.values()[administrationMenuChoice];

            switch (entryAdministrations) {
              case CREATE_AND_ADD_DIARY_ENTRY:
                printer.printEnterTitleMessage();
                String title = inputReader.next();
                printer.printEnterAuthorMessage();
                String author = inputReader.next();
                printer.printEnterContentMessage();
                String content = inputReader.next();
                printer.printEnterDurationMessage();
                int duration = inputReader.nextInt();
                printer.printEnterExerciseTypeMessage();
                String exerciseType = inputReader.next();

                register.createAndAddDiaryEntry(title, author, content, duration, exerciseType);
                break;

              case EXIT:
                runningAdministrationMenu = false;
                break;

              default:
                System.out.println("Invalid option! Try again.");
                break;
            }
          }
          break;

        case EXIT:
          running = false;
          break;

        default:
          System.out.println("Invalid option! Try again.");
          break;
      }
    }
  }
}
