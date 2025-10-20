package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.model.DiaryEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;




public class DiaryEntryTest {

    @Test
    public void testValidDuration(){
        DiaryEntry diaryentry = new DiaryEntry("Langkøyring", "Martin", "Intervalløkt 17x13", 2, "Løping");
        Assertions.assertEquals(2, diaryentry.getDuration());
    }

    @Test
    public void testInvalidDuration(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DiaryEntry diaryentry2 = new DiaryEntry("Sykling", "Noah", "Halvmaraton", -2, "Løping");
        });
    }





}
