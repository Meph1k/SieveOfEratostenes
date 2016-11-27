package pl.polsl.java.lab1.piotrsuwala.model;

import java.util.ArrayList;

/**
 * Gathers logic values into groups
 * @version 1.0
 * @author Piotr
 */
public class LogicValuesGroups {
    ArrayList<ArrayList<int[]>> listOfListsWithGrous;
    
    /**
     * Constructor. Launches the setGroups method
     */
    
    public LogicValuesGroups() {
        listOfListsWithGrous = new ArrayList<ArrayList<int[]>>();
        setGroups();
    }
    
    /**
     * Sets logic values into groups
     */
    
    private void setGroups() {
        int[][] karnaughMapPrimes = new KarnaughMapPrimes().getKarnaughMap4x4WithPrimes();
        ArrayList<ArrayList<int[]>> listOfLists = new ArrayList<ArrayList<int[]>>();
        ArrayList<int[]> singleList = new ArrayList<int[]>();
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                Boolean endOfOnes = false;
                if (1 == karnaughMapPrimes[i][j]) {
                    int[] indeces = {i, j};
                    singleList.add(indeces);
                } else {
                    singleList = new ArrayList<int[]>();
                    endOfOnes = true;
                }
                if (true == endOfOnes) {
                    if (singleList.size() % 2 != 0 && singleList.size() != 1) {
                        singleList.remove(singleList.size() - 1);
                    }
                    listOfLists.add(singleList);
                }
            }
        }
        listOfListsWithGrous = listOfLists;
    }
    
    public ArrayList<ArrayList<int[]>> getListOfLists() {
        return listOfListsWithGrous;
    }
    
    /**
     * Converts 2D list to 2D array
     * @return 2D array
     */
    
    public int[][] getMatrixFrom2DList() {
        ArrayList<ArrayList<int[]>> values = listOfListsWithGrous;
        int[][] newArray = new int[5][5];
        int index1 = 0;
        int index2 = 0;
        for (ArrayList<int[]> value : values) {
            for (int[] arr1 : value) {
                for (int i : arr1) {
                    newArray[index1][index2] = i;
                    index2++;
                }
                index2 = 0;
                index1++;
            }
            index1 = 0;
        }
        return newArray;
    };
}
