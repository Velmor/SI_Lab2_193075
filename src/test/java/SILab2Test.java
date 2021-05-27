import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<Time> createList(Time... elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }


    @Test
    void multipleConditionAndBranchTest() {


        Time time = new Time(10,10,0);
        Time time1 = new Time(-10,10,0);
        Time time2 = new Time(100,10,0);
        Time time3 = new Time(10,-10,0);
        Time time4 = new Time(10,20,-100);
        Time time5 = new Time(24,0,0);
        Time time6 = new Time(24,30,20);

       
        List<Integer> result = new ArrayList<>();
        result.add(36600);
        assertEquals(result, SILab2.function(createList(time)));

       
        RuntimeException ex ;
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(createList(time1)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));
        

        ex=assertThrows(RuntimeException.class, ()->SILab2.function(createList(time2)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

       

        ex=assertThrows(RuntimeException.class, ()->SILab2.function(createList(time3)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        

        ex=assertThrows(RuntimeException.class, ()->SILab2.function(createList(time4)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

       

        List<Integer> result1 = new ArrayList<>();
        result1.add(86400);
        assertEquals(result1, SILab2.function(createList(time5)));

       

        ex=assertThrows(RuntimeException.class, ()->SILab2.function(createList(time6)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

     

    }




}