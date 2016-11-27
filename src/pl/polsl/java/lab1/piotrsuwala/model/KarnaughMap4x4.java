package pl.polsl.java.lab1.piotrsuwala.model;

/**
 * creates a simble 4x4 Karnaugh Map
 * @version 1.0
 * @author Piotr
 */
public class KarnaughMap4x4 {
    int[][] karnaughMap4x4;
    
    /**
     * Constructor which initializes the 4x4 Karnaugh Map
     */
    
    public KarnaughMap4x4() {
        karnaughMap4x4 = new int[5][5];
        karnaughMap4x4[0][1] = 0;
        karnaughMap4x4[0][2] = 1;
        karnaughMap4x4[0][3] = 11;
        karnaughMap4x4[0][4] = 10;
        karnaughMap4x4[1][0] = 0;
        karnaughMap4x4[2][0] = 1;
        karnaughMap4x4[3][0] = 11;
        karnaughMap4x4[4][0] = 10;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                karnaughMap4x4[i][j] = 0;
            }
        }
    }
    
    public int[][] getKarnaughMap4x4() {
        return karnaughMap4x4;
    }
    
    public void setKarnaughMap4x4(int[][] karnaughMap4x4) {
        this.karnaughMap4x4 = karnaughMap4x4;
    }
}
