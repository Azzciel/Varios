/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one;

import java.util.ArrayList;

/**
 *
 * @author Jose Llaguno
 */
public class interseccion {

    ArrayList result;
    int[] a, b, c;
    int x = 0, y = 0, z = 0;

    public ArrayList inter(int[] a, int[] b, int[] c) {
        this.a = a;
        this.b = b;
        this.c = c;
        while (!done()) {
            if (a[x] == b[y] && b[y] == c[z]) {
                result.add(a[x]);
            } else if (a[x] > b[y]) {
                x++;
            } else if (b[y] > c[z]) {
                y++;
            } else {
                z++;
            }
        }
        return result;
    }

    private boolean done() {
        return x >= a.length || y >= b.length || z >= c.length;
    }

}
