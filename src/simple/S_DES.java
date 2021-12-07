package simple;


public class S_DES {


	int tmp[] = new int[10];

	int tmp2[]  = new int[10];

	int tmp3[] = new int[10];

	int input[] = new int[10];

	int k1[] = new int[8];

	int k2[] = new int[8];

	int right[] = new int[4];
	
	int tot = 0;
	int d = 1;
	
	int a, b;

	int index = 0, row = 0, col = 0;

	int p10[] = {3, 5, 2, 7, 4, 10, 1, 9, 8, 6};

	int p8[] = {6, 3, 7, 4, 8, 5, 10, 9};

	int ip[] = {2, 6, 3, 1, 4, 8, 5, 7};

	int ep[] = {4, 1, 2, 3, 2, 3, 4, 1};

	int s0[][] = {{1, 0, 3, 2},

			{3, 2, 1, 0},

			{0, 2, 1, 3},

			{3, 1, 3, 2}};

	int s1[][] = {{0, 1, 2, 3},

			{2, 0, 1, 3},

			{3, 0, 1, 0},

			{2, 1, 0, 3}};

	int p4[] = {2, 4, 3, 1};

	int ip1[] = {4, 1, 3, 5, 7, 2, 8, 6};

 

	int deci;

	int [] digits;

 
	int dep10[] = new int[10];
	int oneshift[] =  new int[10];
	int twoshift[] = new int[10];
	int dep8[] = new int[8];
	
	public void key_generation() {

		//Permutation10

		for(int i = 0; i < 10; i++) {

			index = p10[i];

			tmp[i] = input[index-1];

		}
		
		for(int i=0; i<10; i++)
			dep10[i] = tmp[i];
 

 

		//P10 left shift

		a = tmp[0]; b = tmp[5];
		
		for(int i = 0; i < 5; i++) {
			if(i == 4) {

				tmp[4] = a;

				tmp[9] = b;

			}

			else {

				tmp[i]=tmp[i + 1];

				tmp[i + 5] = tmp[i + 6];

			}
			
		}
		
		for(int i=0; i<10; i++)
			oneshift[i] = tmp[i];
 
		
 

		//afterP8 key1 generation

		for(int i = 0; i < 8; i++) {

			index = p8[i];

			k1[i] = tmp[index-1];

		}

 

		//left shift by2 key2 generation

		for(int j = 0; j < 2; j++) {

			a = tmp[0]; b = tmp[5];

			for(int i = 0; i < 5; i++) {

				if(i == 4) {

					tmp[4] = a;

					tmp[9] = b;

				}

				else {

					tmp[i]=tmp[i + 1];

					tmp[i + 5] = tmp[i + 6];

				}

			}

		}
		
		for(int i=0; i<10; i++)
			twoshift[i] = tmp[i];

 

		for(int i = 0; i < 8; i++) {

			index = p8[i];

			k2[i] = tmp[index-1];

		}

	}

	

 

	//IP(8)

	public void ip() {

		for(int i = 0; i < 8; i++) {

			index = ip[i];

			tmp[i] = input[index-1];

		}

		for(int i=0; i<8; i++)
			dep8[i]=tmp[i];

//		for(int i = 0; i < 4;i++)

//			left[i]=tmp[i];

//		for(int i = 4; i < 8;i++)

//			right[i-4] = tmp[i];

	}

 

	//E/P

	public void ep() {

		for(int i=0; i<4;i++)

			right[i]=tmp[i+4];

		for(int i = 0; i < 8; i++) {

			index = ep[i];

			tmp2[i] = right[index-1];

		}

	}

	

 

	//k1과 E/P_output XOR

	public void xor_k1() {

		for(int i = 0;i < 8;i++) {

			index = tmp2[i]^k1[i];

			tmp3[i] = index;

		}

	}

 

	public void s_box() {

		

		row = tmp3[0]*2 + tmp3[3];

		col  = tmp3[1]*2 + tmp3[2];

 

		index = s0[row][col];

//		System.out.println("s0 index:" + index);

		tmp2[0] = index/2;

		tmp2[1] = index%2;

 

		row = tmp3[4]*2 + tmp3[7];

		col  = tmp3[5]*2 + tmp3[6];

		

		index = s1[row][col];

//		System.out.println("s1 index: "+index);

		tmp2[2] = index/2;

		tmp2[3] = index%2;

	}

 

	public void p4() {

		for(int i = 0; i < 4;i++) {

			index = p4[i];

			tmp3[i] = tmp2[index-1];

		}

	}

 

	public void ipXORp4() {

		for(int i = 0; i < 4; i++) {

			index = tmp[i] + tmp3[i];

			if(index == 1)

				tmp2[i] = 1;

			else

				tmp2[i] = 0;

	
//		for(int i = 0; i<4; i++) {

//			index = left[i]^tmp3[i];

//			tmp2[i]=index;

//			}

		}

	}

 

	public void sw() {

		for(int i = 0; i<8; i++) {

			if(i<4)

				tmp[i] = tmp[i+4];

			else

				tmp[i] = tmp2[i-4];

		}

		

//		for(int i = 0; i< 4; i++) {

//			tmp[i] = right[i];

//		}

//		for(int i =4;i<8;i++)

//			tmp[i] = tmp2[i-4];

		

	}
 

	public void xor_k2() {

		for(int i=0;i<8;i++) {

			index = tmp2[i]^k2[i];

			tmp3[i] = index;

		}	

	}


	public void ip_1() {

		for(int i =0;i<4;i++) {

			tmp[i] = tmp2[i];

		}

		for(int i =0;i<8;i++) {

			index=ip1[i];

			tmp3[i]=tmp[index-1];

		}

	}
	
	public void changedecimal() {
		for(int i=7; i>=0; i--) {
			tot = tot + (d*tmp3[i]);
			d = d * 2;
		}
		
//		System.out.print(tot);
	}
	

 // change 10bit
	public void tenbit() {
		String result = "";
		String fina2;
		for(int i=deci; i>0; i/=2) {

			result = String.valueOf(i%2) + result;

		}
		int fina = Integer.parseInt(result);

		fina2 = String.format("%010d", fina);

		digits = new int[fina2.length()];

		for( int i = 0; i < fina2.length(); i++)
			digits[i] = fina2.charAt(i) - '0';
	
	}
}