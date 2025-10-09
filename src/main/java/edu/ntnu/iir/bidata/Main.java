package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.model.DiaryEntry;

/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 */
public class Main {
    public static void main(String[] args) {
        DiaryEntry diaryEntry = new DiaryEntry("Afternoon run", "Jonas", "4x4. 4 min på, 2 min av", -2, "Running");
        DiaryEntry diaryEntry2 = new DiaryEntry("Afternoon run", "Jonas", "4x4. 4 min på, 2 min av", -2, "Running");
        diaryEntry.printDiaryInfo();
        System.out.println("---------------------------------------");
        diaryEntry2.printDiaryInfo();
    }
}
