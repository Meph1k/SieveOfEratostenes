/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.lab1.piotrsuwala.tests;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.polsl.java.lab1.piotrsuwala.model.LogicValuesGroups;

public class LogicValuesGroupsTest {
    LogicValuesGroups logicValuesGroups;
            
    @Test
    public void testSetGroupsPositive() {
        //given
        ArrayList<ArrayList<int[]>> listOfLists = new ArrayList<ArrayList<int[]>>();
        ArrayList<int[]> singleList = new ArrayList<int[]>();
        logicValuesGroups = new LogicValuesGroups();
        //when 
        int[] values = {1, 3};
        singleList.add(values);
        listOfLists.add(singleList);
        singleList = new ArrayList<int[]>();
        values = new int[] {1, 4};
        singleList.add(values);
        listOfLists.add(singleList);
        singleList = new ArrayList<int[]>();
        values = new int[] {2, 2};
        singleList.add(values);
        listOfLists.add(singleList);
        singleList = new ArrayList<int[]>();
        values = new int[] {2, 3};
        singleList.add(values);
        listOfLists.add(singleList);
        singleList = new ArrayList<int[]>();
        values = new int[] {3, 2};
        singleList.add(values);
        listOfLists.add(singleList);
        singleList = new ArrayList<int[]>();
        values = new int[] {4, 3};
        singleList.add(values);
        listOfLists.add(singleList);
        singleList = new ArrayList<int[]>();
        //then
        Boolean areEqual = listOfLists.equals(logicValuesGroups.getListOfLists());
        assertEquals("Lists should not be equal", areEqual, true);
    }
    
    @Test
    public void testSetGroupsNegative() {
        //given
        ArrayList<ArrayList<int[]>> listOfLists = new ArrayList<ArrayList<int[]>>();
        ArrayList<int[]> singleList = new ArrayList<int[]>();
        logicValuesGroups = new LogicValuesGroups();
        //when
        int[] values = {1, 3};
        singleList.add(values);
        values = new int[] {1, 4};
        singleList.add(values);
        listOfLists.add(singleList);
        values = new int[] {2, 1};
        singleList.add(values);
        values = new int[] {2, 3};
        singleList.add(values);
        listOfLists.add(singleList);
        values = new int[] {3, 2};
        singleList.add(values);
        values = new int[] {3, 3};
        singleList.add(values);
        listOfLists.add(singleList);
        values = new int[] {4, 3};
        singleList.add(values);
        listOfLists.add(singleList);
        //then
        Boolean areEqual = listOfLists.equals(logicValuesGroups.getListOfLists());
        assertEquals("Lists should not be equal", areEqual, false);
    }
}
