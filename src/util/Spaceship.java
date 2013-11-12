package util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author doshide
 */
public class Spaceship {
    
    public static HashMap<String, Integer> map;
    public static ArrayList<String> list;
    public static int[] color;
    public static int[][] g;
    public static int n;
    
    public static int getMinDist(int x, int y) {
        int[] d = new int[n];
        boolean[] expand = new boolean[n];
        for (int i = 0; i < n; i ++) {
            d[i] = -1;
            expand[i] = false;
        }
        d[x] = 0;
        for (int t = 0; t < n; t ++) {
            int min = 100000000;
            int k = -1;
            for (int i = 0; i < n; i ++) {
                if ((!expand[i]) && (d[i] != -1) && (d[i] < min)) {
                    min = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                break;
            }
            expand[k] = true;
            for (int i = 0; i < n; i ++) {
                if ((g[k][i] != -1) && ((d[i] == -1) || (d[i] > min + g[k][i]))){
                    d[i] = min + g[k][i];
                }
            }
        }
        return d[y];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader(new File("E-small-attempt0.in")));
        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k ++) {
            map = new HashMap<>();
            list = new ArrayList<>();
            int l = Integer.parseInt(br.readLine());
            color = new int[l];
            for (int i = 0; i < l; i ++) {
                String tmp = br.readLine();
                if (!map.containsKey(tmp)) {
                    map.put(tmp, list.size());
                    list.add(tmp);
                }
                color[i] = map.get(tmp);
            }
            n = list.size();
            g = new int[n][n];
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    g[i][j] = -1;
                }
                g[i][i] = 0;
            }
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i ++) {
                String[] tmp = br.readLine().split(" ");
                int x = color[Integer.parseInt(tmp[0]) - 1];
                int y = color[Integer.parseInt(tmp[1]) - 1];
                int cost = Integer.parseInt(tmp[2]);
                if ((g[x][y] == -1) || (g[x][y] > cost)) {
                    g[x][y] = cost;
                }
            }
            int s = Integer.parseInt(br.readLine());
            System.out.println("Case #" + (k + 1) + ":");
            for (int i = 0; i < s; i ++) {
                String[] tmp = br.readLine().split(" ");
                int x = color[Integer.parseInt(tmp[0]) - 1];
                int y = color[Integer.parseInt(tmp[1]) - 1];
                System.out.println(getMinDist(x, y));
            }
        }
    }
}