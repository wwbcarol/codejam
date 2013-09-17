package util;

public class U {

	public static <E extends Object>void da(E[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}
	
	public static <E extends Object>void daa(E[][] arrays){
		for(int i=0;i<arrays.length;i++){
			for(int j=0;j<arrays[0].length;j++){
				System.out.print(arrays[i][j] + " ");
			}
			System.out.println("");
		}
	}
	public static void PI(int i){
		System.out.println("----------Case:" + (i + 1) + "---------");
	}

}
