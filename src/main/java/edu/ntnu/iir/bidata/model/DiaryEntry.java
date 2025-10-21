package edu.ntnu.iir.bidata.model;

import java.time.LocalDateTime;

/**
 * Diary entry represents a single trainingdiary entry.
 *
 * <p>Each entry stores information about a training session: - A unique ID - Title of the session -
 * Information/content of the session - Duration of the session - Specific exercise (running,
 * cycling, strength)
 */
public class DiaryEntry {
  private static int nextId = 0;
  private final int id;
  private String author;
  private String title;
  private String content;
  private int duration;
  private String exerciseType;
  private final LocalDateTime date;

  /**
   * Creates a new DiaryEntry with current date.
   *
   * <p>This constructor also assigns a unique ID to every entry and the current date and time
   *
   * @param title title of the training session.
   * @param author name of the author of the training session.
   * @param content notes about the training session.
   * @param duration duration of the training session.
   * @param exerciseType type of exercise.
   */
  public DiaryEntry(
      String title, String author, String content, int duration, String exerciseType) {
    nextId = nextId + 1;
    this.id = nextId;
    setNewTitle(title);
    setMinDuration(duration);
    setNewContent(content);
    setNewAuthor(author);
    setNewExerciseType(exerciseType);
    this.date = LocalDateTime.now();
  }

  /**
   * Creates a new DiaryEntry with custom date.
   *
   * <p>In addition, the constructor also assigns a unique ID to every entry.
   *
   * @param title title of the training session.
   * @param author name of the author of the training session.
   * @param content notes about the training session.
   * @param duration duration of the training session.
   * @param exerciseType type of exercise.
   * @param date custom date of the training session.
   */
  public DiaryEntry(
      String title,
      String author,
      String content,
      int duration,
      String exerciseType,
      LocalDateTime date) {
    nextId = nextId + 1;
    this.id = nextId;
    setNewTitle(title);
    setMinDuration(duration);
    setNewContent(content);
    setNewAuthor(author);
    setNewExerciseType(exerciseType);
    this.date = date;
  }

  /**
   * Returns the unique ID of this diary entry.
   *
   * @return the unique ID of the entry
   */
  public int getId() {
    return this.id;
  }

  /**
   * Returns the title of this diary entry.
   *
   * @return the title of the entry
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Returns the content of this diary entry.
   *
   * @return the content of the entry
   */
  public String getContentOfSession() {
    return this.content;
  }

  /**
   * Returns the author of this diary entry.
   *
   * @return the author of the entry
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * Returns the exercise type of this diary entry.
   *
   * @return the exercise type of the entry
   */
  public String getExerciseType() {
    return this.exerciseType;
  }

  public int getDuration() {
    return this.duration;
  }

  /**
   * Sets a new title for the entry.
   *
   * @param title the new title to set.
   */
  public void setNewTitle(String title) {
    if (title == null || title.equals("")) {
      throw new IllegalArgumentException("Title is missing");
    } else {
      this.title = title;
    }
  }

  /**
   * Sets a new content for the entry.
   *
   * @param content the new content to set.
   */
  public void setNewContent(String content) {
    if (content == null || content.equals("")) {
      throw new IllegalArgumentException("Content is missing");
    } else {
      this.content = content;
    }
  }

  /**
   * Sets a new author for the entry.
   *
   * @param author the new author to set.
   */
  public void setNewAuthor(String author) {
    if (author == null || author.equals("")) {
      throw new IllegalArgumentException("Author is missing");
    } else {
      this.author = author;
    }
  }

  /**
   * Sets a new exercise type for the entry.
   *
   * @param exercise the new exercise type to set.
   */
  public void setNewExerciseType(String exercise) {
    if (exercise == null || exercise.equals("")) {
      throw new IllegalArgumentException("Exercise type is missing");
    } else {
      this.exerciseType = exercise;
    }
  }

  /**
   * Sets a duratoin for the entry. The duration must be greater than 0 and less than 1440. Else it
   * will throw an exception.
   *
   * @param duration the new duration to set.
   */
  public void setMinDuration(int duration) {
    if (duration <= 0) {
      throw new IllegalArgumentException("Duration of the session must be greater than 0");
    } else if (duration > 1440) {
      throw new IllegalArgumentException("Duration of the session can not exeed 24 hours");
    } else {
      this.duration = duration;
    }
  }

  /** Prints the diary entry information to the console. */
  public void printDiaryInfo() {
    System.out.println("ID: " + id);
    System.out.println();
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("Content: " + content);
    System.out.println("Duration: " + duration + " min");
    System.out.println("Exercise type: " + exerciseType);
    System.out.println();
    System.out.println("Date and time: " + date);
    System.out.println("-------------------------------------------");
  }
}
