/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.lab1.piotrsuwala.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import pl.polsl.java.lab1.piotrsuwala.model.KarnaughMap4x4;

public class KarnaughMap4x4Test {
    KarnaughMap4x4 instance;
    @Test
    public void testGetKarnaughMap4x4() {
        //given
        instance = new KarnaughMap4x4();
        int[][] karnaughMap4x4;
        //when
        karnaughMap4x4 = new int[5][5];
        karnaughMap4x4[0][1] = 0b0;
        karnaughMap4x4[0][2] = 0b1;
        karnaughMap4x4[0][3] = 0b11;
        karnaughMap4x4[0][4] = 0b10;
        karnaughMap4x4[1][0] = 0b0;
        karnaughMap4x4[2][0] = 0b1;
        karnaughMap4x4[3][0] = 0b11;
        karnaughMap4x4[4][0] = 0b10;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                karnaughMap4x4[i][j] = 0;
            }
        }
        //then
        assertArrayEquals(instance.getKarnaughMap4x4(), karnaughMap4x4);
    }
}
