package edu.ntnu.iir.bidata.model;

/**
 * Diary entry represents a single trainingdiary entry.
 *
 * <p>Each entry stores information about a training session:
 * - A unique ID
 * - Title of the session
 * - Information/content of the session
 * - Duration of the session
 * - Specific exercise (running, cycling, strength)
 */
public class DiaryEntry {
  private static int nextId = 0;
  private int id;
  private String title = null;
  private String content = null;
  private int duration;
  private String exerciseType = null;

  DiaryEntry(String title, String content, int duration, String exerciseType) {
    nextId = nextId + 1;
    this.id = nextId;
    this.title = title;
    this.content = content;
    this.duration = duration;
    this.exerciseType = exerciseType;
  }
}
