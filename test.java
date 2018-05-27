import java.lang.Math.*;

class test {


	public static void main(String[] args) {
		int x[] = {1,2,3,4};
		int s = 1;
		while (x[0]<5){
			while (x[1]<6){
				while (x[2]<7){
					while (x[3] < 8){
						System.out.print((s++)+" : "+ x[0]+""+x[1]+""+x[2]+""+(x[3]++)+"\n");
					}
					System.out.println();
					if (x[2] <= 6) x[3] = (++x[2])+1;
					else break;
				}
				if (x[1] <= 5) {
					x[2] = (++x[1])+1;
					x[3] = x[2]+1;
				}
				else break;

			}
			if (x[0] <= 4) {
				x[1] = (++x[0])+1;
				x[2] = x[1]+1;
				x[3] = x[2]+1;
		 	}
			else break;
		}
		// x[0]++;
	}
}
