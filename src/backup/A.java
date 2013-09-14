package backup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/H2013";
		
		// Test
		
		String inputFile = "A-in.txt";
		String outputFile = "A-out.txt";
		
		// Small
		
//		String inputFile = "A-small-1-attempt0.in";
//		String outputFile = "A-small-1-attempt0.out";
		
		
		// Large
		
//		String inputFile = "A-large-practice.in";
//		String outputFile = "A-large-practice.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int M = in.nextInt();

			Map<String, Integer> ID = new HashMap<String, Integer>();
			int[][] oppo = new int[M][2];
			int id = 0;
			for(int j=0;j<M;j++){
				
				String s1 = in.next();
				
				if(!ID.containsKey(s1)){
					System.out.println(s1 + " :" + id);
					ID.put(s1, id++);
				}

				
				String s2 = in.next();
				
				if(!ID.containsKey(s2)){
					System.out.println(s2 + " :" + id);
					ID.put(s2, id++);
				}

				oppo[j][0] = ID.get(s1);
				oppo[j][1] = ID.get(s2);
			}
			
			
			
			int N = ID.size();
			
			
			int[][] map = new int[N][N];
			for(int j=0;j<N;j++){
				for(int k=0;k<N;k++){
					map[j][k] = 0;
				}
			}
			for(int j=0;j<M;j++){
				map[oppo[j][0]][oppo[j][1]] = 1;
				map[oppo[j][1]][oppo[j][0]] = 1;
			}
			int[] code = new int[N];
			for(int j=0;j<N;j++){
				StringBuffer s = new StringBuffer();
				for(int k=0;k<N;k++){
					s.append(map[j][k]);
				}
				
				code[j] = Integer.parseInt(s.toString(), 2);
			}
			
			for(int j=0;j<N;j++){
				System.out.println(code[j]);
			}
//			ArrayList<Integer> teamA = new ArrayList<Integer>();
//			ArrayList<Integer> teamB = new ArrayList<Integer>();
//			boolean[] flag = new boolean[N];
//			boolean result = true;
//			
//			for(int j=0;j<N;j++){
//				flag[j] = false;
//			}
//			
//			teamA.add(0);
//			flag[0] = true;
//			
//			boolean isChanged = true;
//			while(!isFinish(flag)){
//				System.out.println("here");
//				
//				while(isChanged){
//					
//				for(int j=0;j<teamA.size();j++){
//					for(int k=0;k<N;k++){
//						if(map[teamA.get(j)][k] == 1){
//							if(teamA.contains(k)){
//								System.out.println("A, COFLIC"+teamA.get(j)+","+k);
//								result = false;
//								break;
//							}else if(!teamB.contains(k)){
//								System.out.println("B:add " + k);
//								teamB.add(k);
//								isChanged = true;
//								flag[k] = true;
//							}else{
//								isChanged = false;
//							}
//						}
//					}
//					if(result == false)
//						break;
//				}
//				
//				for(int j=0;j<teamB.size();j++){
//					for(int k=0;k<N;k++){
//						if(map[teamB.get(j)][k] == 1){
//							if(teamB.contains(k)){
//								System.out.println("b, confick"+teamB.get(j)+","+k);
//								result = false;
//								break;
//							}else if(!teamA.contains(k)){
//								System.out.println("A:add " + k);
//								teamA.add(k);
//								isChanged = true;
//								flag[k] = true;
//							}else{
//								isChanged = false;
//							}
//						}
//					}
//					
//					if(result == false)
//						break;
//				}
//				
//				if(result == false)
//					break;
//				
//				
//				
//				}
//				
//				
//				if(result == false)
//					break;
//				
//				else{
//					
//					System.out.println(teamA);
//					System.out.println(teamB);
//					teamA.clear();
//					teamB.clear();
//					
//					for(int j=0;j<N;j++){
//						if(flag[j] == false){
//							teamA.add(j);
//							flag[j] = true;
//							isChanged = true;
//						}
//					}
//				}
//			}
			
//			System.out.println(result);
			
			out.print("Case #"+(i+1)+": ");
			
//			if(result)
//				out.println("Yes");
//			else
//				out.println("No");
			
		}
		
		in.close();
		out.close();

	}

	private static boolean isFinish(boolean[] flag) {
		for(int i=0;i<flag.length;i++){
			if(flag[i] == false){
				return false;
			}
		}
		return true;
	}

}
