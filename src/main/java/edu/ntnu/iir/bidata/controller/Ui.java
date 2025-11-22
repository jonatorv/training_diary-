package edu.ntnu.iir.bidata.controller;

import edu.ntnu.iir.bidata.controller.menus.EntryAdministrations;
import edu.ntnu.iir.bidata.controller.menus.EntryOverview;
import edu.ntnu.iir.bidata.controller.menus.MainMenu;
import edu.ntnu.iir.bidata.controller.view.DiaryPrinter;
import edu.ntnu.iir.bidata.model.DiaryRegister;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides a console-based user interface for the application.
 *
 * <p>This class is responsible for displaying menus, validating choices, delegating tasks to the
 * DiaryRegister, and uses the DiaryPrinter to generate output.
 */
public class Ui {
  private DiaryRegister register;
  private DiaryPrinter printer;

  private static final String INVALIDINPUT =
      "Invalid input - please enter a number " + "corresponding to the menu options!";

  /**
   * Initializes the user interface by creating an instance of the DiaryRegister and DiaryPrinter.
   *
   * <p>The method also initializes two diary entries in the register for demonstration purposes.
   */
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
          "Halvmaraton", "Jonas", "Maraton", 90, "løping", LocalDate.of(2025, 10, 4));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println("------------------------------");
    }
  }

  /**
   * Starts the main application.
   *
   * <p>This method displays the welcome message and repeatedly reads the user´s main menu choice.
   * Based on the selected options, it delegates the user to either the overview menu or
   * administration menu. When the user selects the EXIT option, it will terminate the session and
   * exit the program.
   */
  public void start() {
    printer.printWelcomeMessage();
    Scanner inputReader = new Scanner(System.in);
    boolean running = true;

    while (running) {
      printer.printNumberOfEntries(register);
      printer.printNumberOfEntriesFromDate(LocalDate.now(), register);
      int mainMenuChoice = 0;
      boolean invalidMainMenu = false;
      try {
        mainMenuChoice = inputReader.nextInt();
      } catch (InputMismatchException e) {
        System.out.println(INVALIDINPUT);
        inputReader.nextLine();
        invalidMainMenu = true;
      }

      if (mainMenuChoice < 0 || mainMenuChoice >= MainMenu.values().length) {
        printer.printInvalidOptionMessage();
      } else if (invalidMainMenu) {
        // Do nothing, already handled in catch block above.
      } else {

        MainMenu mainMenu = MainMenu.values()[mainMenuChoice];
        switch (mainMenu) {
          // ---------------------------------------------------------------------------------------
          case ENTRY_OVERVIEW:
            runOverviewMenu(inputReader);
            break;
          // ---------------------------------------------------------------------------------------
          case ENTRY_ADMINISTRATIONS:
            runAdministrationMenu(inputReader);
            break;

          case EXIT:
            running = false;
            break;

          default:
            printer.printInvalidOptionMessage();
            break;
        }
      }
    }
  }

  /**
   * Runs the overview menu loop and handles all the overview menu options.
   *
   * <p>This method repeatedly displays the overview menu, reads the user´s choice, validates the
   * input, and performs the corresponding action such as printing all the entries, printing all the
   * entries from a specific date, or printing all the entries sorted by date (newest first). The
   * loop terminates when the user selects the EXIT option.
   *
   * @param inputReader Scanner for user input.
   */
  private void runOverviewMenu(Scanner inputReader) {
    boolean runningOverviewMenu = true;
    while (runningOverviewMenu) {
      printer.printChooseOperationMessage();
      int overviewMenuChoice = 0;
      boolean invalidRunningOverviewMenu = false;
      try {
        overviewMenuChoice = inputReader.nextInt();
      } catch (InputMismatchException e) {
        System.out.println(INVALIDINPUT);
        inputReader.nextLine();
        invalidRunningOverviewMenu = true;
      }

      if (overviewMenuChoice < 0 || overviewMenuChoice >= EntryOverview.values().length) {
        printer.printInvalidOptionMessage();
      } else if (invalidRunningOverviewMenu) {
        // Do nothing, already handled in catch block above.
      } else {
        EntryOverview entryOverview = EntryOverview.values()[overviewMenuChoice];

        switch (entryOverview) {
          case PRINT_ALL_DIARY_ENTRIES:
            printer.printAllDiaryEntries(register);
            break;

          case PRINT_DIARY_ENTRIES_FROM_DATE:
            printDiaryEntryFromDate(inputReader);
            break;

          case PRINT_DIARY_ENTRIES_SORTED_BY_DATE:
            printer.printDiaryEntriesSortedByDate(register);
            break;

          case EXIT:
            runningOverviewMenu = false;
            printer.printWelcomeMessage();
            break;

          default:
            printer.printInvalidOptionMessage();
            break;
        }
      }
    }
  }

  /**
   * Runs the administration menu loop and handles all the administration menu options.
   *
   * <p>This method repeatedly displays the administration menu, reads the user´s choice, validates
   * the input, and performs the corresponding action such as creating entries, creating entries
   * with a custom date, or deleting entries from a specific date. The loop terminates when the user
   * selects the EXIT option.
   *
   * @param inputReader Scanner for user input.
   */
  private void runAdministrationMenu(Scanner inputReader) {
    boolean runningAdministrationMenu = true;

    while (runningAdministrationMenu) {
      printer.printAdministrationMenuMessage();
      int administrationMenuChoice = 0;
      boolean invalidAdministrationMenu = false;
      try {
        administrationMenuChoice = inputReader.nextInt();
      } catch (InputMismatchException e) {
        System.out.println(INVALIDINPUT);
        inputReader.nextLine();
        invalidAdministrationMenu = true;
      }

      if (administrationMenuChoice < 0
          || administrationMenuChoice >= EntryAdministrations.values().length) {
        printer.printInvalidOptionMessage();
      } else if (invalidAdministrationMenu) {
        // Do nothing, already handled in catch block above.
      } else {
        EntryAdministrations entryAdministrations =
            EntryAdministrations.values()[administrationMenuChoice];

        switch (entryAdministrations) {
          case CREATE_AND_ADD_DIARY_ENTRY:
            createAndAddDiaryEntry(inputReader);
            break;

          case CREATE_AND_ADD_DIARY_ENTRY_CUSTOM_DATE:
            createAndAddDiaryEntryCustomDate(inputReader);
            break;

          case DELETE_DIARY_ENTRY_FROM_DATE:
            deleteDiaryEntryFromDate(inputReader);
            break;

          case EXIT:
            runningAdministrationMenu = false;
            printer.printWelcomeMessage();
            break;

          default:
            printer.printInvalidOptionMessage();
            break;
        }
      }
    }
  }

  /**
   * Deletes a diary entries from a specific date in the register, based on user input.
   *
   * <p>The method reads a day, month, and a year from the user and deletes all diary entries stored
   * on that date. Invalid number input, invalid calender dates, or other illegal values are handled
   * internally to prevent the program from crashing.
   *
   * @param inputReader Scanner for user input.
   */
  private void deleteDiaryEntryFromDate(Scanner inputReader) {
    int day;
    int year;
    int month;
    try {
      printer.printEnterDayMessage();
      day = inputReader.nextInt();
      printer.printEnterMonthMessage();
      month = inputReader.nextInt();
      printer.printEnterYearMessage();
      year = inputReader.nextInt();
      LocalDate date = LocalDate.of(year, month, day);
      int oldSize = register.getDiaryEntries().size();
      register.deleteDiaryEntryFromDate(date);
      int newSize = register.getDiaryEntries().size();

      if (newSize < oldSize) {
        printer.deleteDiaryEntryTrueMessage();
      } else {
        printer.deleteDiaryEntryFalseMessage();
      }

    } catch (InputMismatchException e) {
      System.out.println("Date must be a number - diary entry could not be deleted!");
      inputReader.nextLine();
    } catch (DateTimeException e) {
      System.out.println("Invalid date entered - diary entry could not be deleted!");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Creates and adds a diary entry to the register using a custom date, based on user input.
   *
   * <p>The method reads title, author, content, exerciseType, and at specific date (day, month, and
   * year) from the user. If duration is not a valid number or is outside the allowed range (1-1440
   * minutes), the input is discarded and the entry is not created. The method also handles invalid
   * or empty input for all the other fields and prevents dates or invalid diary entries from being
   * added to the register.
   *
   * @param inputReader Scanner for user input.
   */
  private void createAndAddDiaryEntryCustomDate(Scanner inputReader) {
    inputReader.nextLine();
    printer.printEnterTitleMessage();
    String title = inputReader.nextLine();
    printer.printEnterAuthorMessage();
    String author = inputReader.nextLine();
    printer.printEnterContentMessage();
    String content = inputReader.nextLine();
    printer.printEnterDurationMessage();
    int duration;
    try {
      duration = inputReader.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Duration must be a number - diary entry could not be created!");
      inputReader.nextLine();
      return;
    }
    printer.printEnterExerciseTypeMessage();
    String exerciseType = inputReader.next();

    try {
      printer.printEnterDayMessage();
      int day = inputReader.nextInt();
      printer.printEnterMonthMessage();
      int month = inputReader.nextInt();
      printer.printEnterYearMessage();
      int year = inputReader.nextInt();

      LocalDate date = LocalDate.of(year, month, day);

      register.createAndAddDiaryEntryCustomDate(
          title, author, content, duration, exerciseType, date);
    } catch (DateTimeException e) {
      System.out.println("Invalid date entered - diary entry could not be created!");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Creates and adds a diary entry to the register using the current date, based on user input.
   *
   * <p>The method reads title, author, content, and exerciseType from the user. If duration is not
   * a valid number or is outside the allowed range (1-1440 minutes), the input is discarded and the
   * entry is not created. The method also handles invalid or empty input for the rest of the
   * fields, ensuring that no invalid diary entry is added to the register.
   *
   * @param inputReader Scanner for user input.
   */
  private void createAndAddDiaryEntry(Scanner inputReader) {
    inputReader.nextLine();
    printer.printEnterTitleMessage();
    String title = inputReader.nextLine();
    printer.printEnterAuthorMessage();
    String author = inputReader.nextLine();
    printer.printEnterContentMessage();
    String content = inputReader.nextLine();
    printer.printEnterDurationMessage();
    int duration;
    try {
      duration = inputReader.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Duration must be a number - diary entry could not be created!");
      inputReader.nextLine();
      return;
    }
    printer.printEnterExerciseTypeMessage();
    String exerciseType = inputReader.next();

    try {
      register.createAndAddDiaryEntry(title, author, content, duration, exerciseType);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Print diary entries from a date specified by the user.
   *
   * <p>The method reads a day, month and a year from the user and displays all diary entries stored
   * on that date. Any invalid number, invalid date values, or lookup errors in the register are
   * handled internally.
   *
   * @param inputReader Scanner for user input.
   */
  private void printDiaryEntryFromDate(Scanner inputReader) {
    try {
      printer.printEnterDayMessage();
      int day = inputReader.nextInt();
      printer.printEnterMonthMessage();
      int month = inputReader.nextInt();
      printer.printEnterYearMessage();
      int year = inputReader.nextInt();
      LocalDate date = LocalDate.of(year, month, day);
      printer.printDiaryEntryFromDate(date, register);

    } catch (InputMismatchException e) {
      System.out.println("Date must be a number! Please try again.");
      inputReader.nextLine();
    } catch (DateTimeException e) {
      System.out.println("Invalid date entered - diary entry could not be printed!");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
