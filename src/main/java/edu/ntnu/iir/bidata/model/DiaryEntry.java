package edu.ntnu.iir.bidata.model;

/**
 * Diary entry represents a single trainingdiary entry.
 *
 * <p>Each entry stores information about a training session: - A unique ID - Title of the session -
 * Information/content of the session - Duration of the session - Specific exercise (running,
 * cycling, strength)
 */
public class DiaryEntry {
  private static int nextId = 0;
  private int id;
  private String author = null;
  private String title = null;
  private String content = null;
  private int duration;
  private String exerciseType = null;

  /**
   * The constructor creates a new DiaryEntry object with the given parameters title, author,
   * content, duration and exerciseType.
   *
   * <p>In addition, the constructor also assigns a unique ID to every entry.
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
  }

    /**
     *
     * @return
     */
  public int getId()
  {
    return this.id;
  }

    /**
     *
     * @return
     */
  public String getTitle()
  {
    return this.title;
  }

    /**
     *
     * @return
     */
  public String getContentOfSession()
  {
    return this.content;
  }

    /**
     *
     * @return
     */
  public String getAuthor()
  {
    return this.author;
  }

    /**
     *
     * @return
     */
  public String getExerciseType()
  {
    return this.exerciseType;
  }

    /**
     *
     * @param title
     */
  public void setNewTitle(String title)
  {
      this.title = title;
  }

    /**
     *
     * @param content
     */
  public void setNewContent(String content)
  {
      this.content = content;
  }

    /**
     *
     * @param author
     */
  public void setNewAuthor(String author)
  {
      this.author = author;
  }

    /**
     *
     * @param exercise
     */
  public void setNewExerciseType(String exercise)
  {
      this.exerciseType = exercise;
  }
  

    /**
     *
     * @param duration
     */
  public void setMinDuration(int duration)
  {
    if (duration <= 0) {
      System.out.println("Duration of the session cannot be less than 0");
    } else if (duration > 1440) {
      System.out.println("Duration of the session can not exeed 24 hours");
    } else {
      this.duration = duration;
    }
  }

  public void printDiaryInfo()
  {
    System.out.println("ID: " + id);
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("Content: " + content);
    System.out.println("Duration: " + duration + " min");
    System.out.println("Exercise type: " + exerciseType);
  }
}
