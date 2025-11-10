package edu.ntnu.iir.bidata.controller;

import edu.ntnu.iir.bidata.controller.menus.EntryAdministrations;
import edu.ntnu.iir.bidata.controller.menus.EntryOverview;
import edu.ntnu.iir.bidata.controller.menus.MainMenu;
import edu.ntnu.iir.bidata.controller.view.DiaryPrinter;
import edu.ntnu.iir.bidata.model.DiaryRegister;
import java.time.DateTimeException;
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
      if (mainMenuChoice < 0 || mainMenuChoice >= MainMenu.values().length) {
        printer.printInvalidOptionMessage();
        continue;
      }

      MainMenu mainMenu = MainMenu.values()[mainMenuChoice];
      switch (mainMenu) {
        // --------------------------------------------------------------------------------------------
        case ENTRY_OVERVIEW:
          boolean runningOverviewMenu = true;
          while (runningOverviewMenu) {
            printer.printChooseOperationMessage();
            int overviewMenuChoice = inputReader.nextInt();
            if (overviewMenuChoice < 0 || overviewMenuChoice >= EntryOverview.values().length) {
              printer.printInvalidOptionMessage();
              continue;
            }
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
                printer.printWelcomeMessage();
                break;

              default:
                printer.printInvalidOptionMessage();
                break;
            }
          }
          break;

        // ---------------------------------------------------------------------------------------
        case ENTRY_ADMINISTRATIONS:
          boolean runningAdministrationMenu = true;

          while (runningAdministrationMenu) {
            printer.printAdministrationMenuMessage();
            int administrationMenuChoice = inputReader.nextInt();
            if (administrationMenuChoice < 0
                || administrationMenuChoice >= EntryAdministrations.values().length) {
              printer.printInvalidOptionMessage();
              continue;
            }
            EntryAdministrations entryAdministrations =
                EntryAdministrations.values()[administrationMenuChoice];

            String title;
            String author;
            String content;
            int duration = 0;
            String exerciseType;
            int day = 0;
            int month = 0;
            int year = 0;

            switch (entryAdministrations) {
              case CREATE_AND_ADD_DIARY_ENTRY:
                inputReader.nextLine();
                printer.printEnterTitleMessage();
                title = inputReader.nextLine();
                printer.printEnterAuthorMessage();
                author = inputReader.nextLine();
                printer.printEnterContentMessage();
                content = inputReader.nextLine();
                printer.printEnterDurationMessage();
                duration = inputReader.nextInt();
                printer.printEnterExerciseTypeMessage();
                exerciseType = inputReader.next();

                try {
                  register.createAndAddDiaryEntry(title, author, content, duration, exerciseType);
                } catch (IllegalArgumentException e) {
                  System.out.println(e.getMessage());
                }
                break;

              case CREATE_AND_ADD_DIARY_ENTRY_CUSTOM_DATE:
                inputReader.nextLine();
                printer.printEnterTitleMessage();
                title = inputReader.nextLine();
                printer.printEnterAuthorMessage();
                author = inputReader.nextLine();
                printer.printEnterContentMessage();
                content = inputReader.nextLine();
                printer.printEnterDurationMessage();
                duration = inputReader.nextInt();
                printer.printEnterExerciseTypeMessage();
                exerciseType = inputReader.next();

                try {
                  printer.printEnterDayMessage();
                  day = inputReader.nextInt();
                  printer.printEnterMonthMessage();
                  month = inputReader.nextInt();
                  printer.printEnterYearMessage();
                  year = inputReader.nextInt();

                  LocalDate date = LocalDate.of(year, month, day);

                  register.createAndAddDiaryEntryCustomDate(
                      title, author, content, duration, exerciseType, date);
                } catch (DateTimeException e) {
                  System.out.println(e.getMessage());
                } catch (IllegalArgumentException e) {
                  System.out.println(e.getMessage());
                }
                break;

              case DELETE_DIARY_ENTRY_FROM_DATE:
                printer.printEnterDayMessage();
                day = inputReader.nextInt();
                printer.printEnterMonthMessage();
                month = inputReader.nextInt();
                printer.printEnterYearMessage();
                year = inputReader.nextInt();
                LocalDate date = LocalDate.of(year, month, day);
                register.deleteDiaryEntryFromDate(date);
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
