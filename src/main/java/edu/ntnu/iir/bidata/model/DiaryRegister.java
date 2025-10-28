package edu.ntnu.iir.bidata.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DiaryRegister {
  ArrayList<DiaryEntry> diaryEntries;

  public DiaryRegister() {
    diaryEntries = new ArrayList<>();
  }

  public void createAndAddDiaryEntry(String title, String author, String content, int duration, String exerciseType){
    DiaryEntry newEntry = new DiaryEntry(title, author, content, duration, exerciseType);
    diaryEntries.add(newEntry);
  }

  public void createAndAddDiaryEntryCustomDate(String title, String author, String content, int duration, String exerciseType, LocalDateTime date){
    DiaryEntry newEntry = new DiaryEntry(title, author, content, duration, exerciseType, date);
    diaryEntries.add(newEntry);
  }

  public ArrayList<DiaryEntry> getDiaryEntries() {
    return diaryEntries;
  }

}


