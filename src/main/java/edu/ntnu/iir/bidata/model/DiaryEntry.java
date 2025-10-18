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
  private String author = null;
  private String title = null;
  private String content = null;
  private int duration;
  private String exerciseType = null;
  private final LocalDateTime date;

  /**
   *
   *Creates a new DiaryEntry with current date.
   * @param title         title of the training session.
   * @param author        name of the author of the training session.
   * @param content       notes about the training session.
   * @param duration      duration of the training session.
   * @param exerciseType  type of exercise.
   *
   * <p>This constructor also assigns a unique ID to every entry and the current date and time.
   */
  public DiaryEntry(
      String title, String author, String content, int duration, String exerciseType) {
    nextId = nextId + 1;
    this.id = nextId;
    this.title = title;
    setMinDuration(duration);
    this.content = content;
    this.author = author;
    this.exerciseType = exerciseType;
    this.date = LocalDateTime.now();
  }

    /**
     * Creates a new DiaryEntry with custom date.
     * @param title         title of the training session.
     * @param author        name of the author of the training session.
     * @param content       notes about the training session.
     * @param duration      duration of the training session.
     * @param exerciseType  type of exercise.
     * @param date          custom date of the training session.
     *
     *<p>In addition, the constructor also assigns a unique ID to every entry.
     */
  public DiaryEntry(
          String title, String author, String content, int duration, String exerciseType, LocalDateTime date) {
      nextId = nextId + 1;
      this.id = nextId;
      setTitle(title);
      setMinDuration(duration);
      this.content = content;
      this.author = author;
      this.exerciseType = exerciseType;
      this.date = date;
    }

    /**
     *
     * @return the unique ID of the entry
     */
  public int getId()
  {
    return this.id;
  }

    /**
     *
     * @return the title of the entry
     */
  public String getTitle()
  {
    return this.title;
  }

    /**
     *
     * @return the content of the entry
     */
  public String getContentOfSession()
  {
    return this.content;
  }

    /**
     *
     * @return the author of the entry
     */
  public String getAuthor()
  {
    return this.author;
  }

    /**
     *
     * @return the exercise type of the entry
     */
  public String getExerciseType()
  {
    return this.exerciseType;
  }

    /**
     *
     * @param title
     *
     * Sets a new title for the entry.
     *
     */
  public void setNewTitle(String title)
  {
      setTitle(title);
  }

    /**
     *
     * @param content
     *
     * Sets a new content for the entry.
     *
     */
  public void setNewContent(String content)
  {
      this.content = content;
  }

    /**
     *
     * @param author
     *
     * Sets a new author for the entry.
     *
     */
  public void setNewAuthor(String author)
  {
      this.author = author;
  }

    /**
     *
     * @param exercise
     *
     * Sets a new exercise type for the entry.
     *
     */
  public void setNewExerciseType(String exercise)
  {
      this.exerciseType = exercise;
  }
  

    /**
     *
     * @param duration
     *
     * Sets a duratoin for the entry.
     *
     */
  public void setMinDuration(int duration)
  {
    if (duration <= 0) {
      throw new IllegalArgumentException("Duration of the session must be greater than 0");
    } else if (duration > 1440) {
      throw new IllegalArgumentException("Duration of the session can not exeed 24 hours");
    } else {
      this.duration = duration;
    }
  }

  public void setTitle(String title){
      if (title == null || title.equals("")){
          throw new IllegalArgumentException("Title is missing ");
    } else {
          this.title = title;
      }
  }

  public void printDiaryInfo()
  {
    System.out.println("ID: " + id);
    System.out.println();
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("Content: " + content);
    System.out.println("Duration: " + duration + " min");
    System.out.println("Exercise type: " + exerciseType);
    System.out.println();
    System.out.println("Date and time: " + date);
  }
}