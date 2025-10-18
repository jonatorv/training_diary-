package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.model.DiaryEntry;

/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");


        DiaryEntry diaryEntry = null;
        DiaryEntry diaryEntry2 = null;

        try{
            diaryEntry = new DiaryEntry("Afternoon run", "Jonas", "4x4. 4 min på, 2 min av", 2, "Running");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------");

        }

        try{
            diaryEntry2 = new DiaryEntry("Afternoon run", "Jonas", "4x4. 4 min på, 2 min av", 1, "Running");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------");

        }


        if (diaryEntry != null){
            diaryEntry.printDiaryInfo();
            System.out.println("---------------------------------------");

        }

        if (diaryEntry2 != null){
            diaryEntry2.printDiaryInfo();
            System.out.println("---------------------------------------");
        }

        try{
            diaryEntry.setNewTitle("");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage() + "or title was not updated.");
            System.out.println();
        }

        diaryEntry.printDiaryInfo();
    }
}
