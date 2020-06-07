/**
 * Autores: Bianca Camargo, Camila Borba e Jéssica Manoel
 */

package com.pucrs;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] s = {4, 6, 13, 4, 2, 6, 7, 9, 1, 3, 9};
        int[] f = {8, 7, 14, 5, 4, 9, 10, 11, 6, 13, 12};
        int n = s.length;

        SDMGuloso(s, f, n);

        boolean[] result = SDMGuloso1(s, f, n);

        for (int i = 0; i < n; i++) {
            if (result[i]) {
                System.out.print("[" + s[i] + ", " + f[i] + "]");
            }
        }
    }

    /**
     * @param s inícios dos intervalos
     * @param f finais dos intervalos
     * @param n número total de intervalos
     */
    public static boolean[] SDMGuloso(int[] s, int[] f, int n) {
        int cont = 0;
        boolean[] x = new boolean[n];
        int i = 0;
        for(int k = 0; k < n; k++) {
            if (s[k] > f[i] || cont == 0){
                x[k] = true;
                i = k;
                cont ++;
            }
        }

        return x;
    }

    /**
     * @param s inícios dos intervalos
     * @param f finais dos intervalos
     * @param n número total de intervalos
     */
    public static boolean[] SDMGuloso1(int[] s, int[] f, int n) {
        boolean[] x = new boolean[n];
        int k;
        for (int i = 1; i <= n; i++) {
            x[i] = true;
            k = i + 1;
            while (k < n && s[k] < f[i]) {
                k = k + 1;
            }
            i = k;
        }
        return x;
    }
}
