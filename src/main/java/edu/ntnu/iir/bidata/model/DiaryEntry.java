package edu.ntnu.iir.bidata.model;

import java.time.LocalDate;

/**
 * Represents a single entry in the training diary.
 *
 * <p>Each diary entry stores information about a training session, including: </p>
 * <ul>
 *   <li>A unique ID</li>
 *   <li>The author of the session</li>
 *   <li>The title of the session</li>
 *   <li>The content of the session</li>
 *   <li>The duration of the session in minutes</li>
 *   <li>The exercise type of the session</li>
 *   <li>The date of the session</li>
 * </ul>
 */
public class DiaryEntry {
  private static int nextId = 0;
  private final int id;
  private String author;
  private String title;
  private String content;
  private int duration;
  private String exerciseType;
  private LocalDate date;

  /**
   * Creates a new DiaryEntry with the current date.
   *
   * <p>The constructor assigns a unique ID to the entry and validates all
   * fields before setting them. Any invalid values will result in an IllegalArgumentException</p>
   *
   * @param title         title of the training session.
   * @param author        name of the author of the training session.
   * @param content       notes about the training session.
   * @param duration      duration of the training session.
   * @param exerciseType  type of exercise.
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
    this.date = LocalDate.now();
  }

  /**
   * Creates a new DiaryEntry with the custom date.
   *
   * <p>The constructor assigns a unique ID to the entry and validates all
   * fields before setting them. Any invalid values will result in an IllegalArgumentException</p>
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
      LocalDate date) {
    nextId = nextId + 1;
    this.id = nextId;
    setNewTitle(title);
    setMinDuration(duration);
    setNewContent(content);
    setNewAuthor(author);
    setNewExerciseType(exerciseType);
    setDate(date);
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
   * Returns the date of this diary entry.
   *
   * @return the date of the entry
   */
  public LocalDate getDate() {
    return this.date;
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
   * @throws IllegalArgumentException if the title is null or empty.
   */
  public void setNewTitle(String title) {
    if (title == null || title.isEmpty()) {
      throw new IllegalArgumentException("Title is missing - diary entry could not be created!");
    } else {
      this.title = title;
    }
  }

  /**
   * Sets a new content for the entry.
   *
   * @param content the new content to set.
   * @throws IllegalArgumentException if the content is null or empty.
   */
  public void setNewContent(String content) {
    if (content == null || content.isEmpty()) {
      throw new IllegalArgumentException("Content is missing - diary entry could not be created!");
    } else {
      this.content = content;
    }
  }

  /**
   * Sets a new author for the entry.
   *
   * @param author the new author to set.
   * @throws IllegalArgumentException if the author is null or empty.
   */
  public void setNewAuthor(String author) {
    if (author == null || author.isEmpty()) {
      throw new IllegalArgumentException("Author is missing - diary entry could not be created!");
    } else {
      this.author = author;
    }
  }

  /**
   * Sets a new exercise type for the entry.
   *
   * @param exercise the new exercise type to set.
   * @throws IllegalArgumentException if the exercise type is null or empty.
   */
  public void setNewExerciseType(String exercise) {
    if (exercise == null || exercise.isEmpty()) {
      throw new IllegalArgumentException(
          "Exercise type is missing - " + "diary entry could not be created!");
    } else {
      this.exerciseType = exercise;
    }
  }

  /**
   * Sets a duration for the entry.
   *
   * <p>The duration must be between 1 and 1440 minutes (24 hours). </p>
   *
   * @param duration the new duration to set.
   * @throws IllegalArgumentException if the duration is outside the valid range.
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

  /**
   * Sets a new date for the entry.
   *
   * <p>The date cannot be in the future.</p>
   *
   * @param date the new date to set.
   * @throws IllegalArgumentException if the date is in the future.
   */
  public void setDate(LocalDate date) {
    if (date.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException(
          "You cannot set a date in the future - " + "diary entry could not be created!");
    } else {
      this.date = date;
    }
  }
}
