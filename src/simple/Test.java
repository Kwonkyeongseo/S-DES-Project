package simple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class Test extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	S_DES sdes = new S_DES();
	Details detail = new Details();
	KeyGenerationPanel keypnl = new KeyGenerationPanel();
	CipherPanel ciphpnl = new CipherPanel();
	
	JButton resetbtn = new JButton("초기화");
	JButton detailbtn = new JButton("세부사항");

	String a;
	int b;
	char ch;

	public Test() {
		
		super("S-DES 19110047 권경서");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		detail.setLocationRelativeTo(null);
		detail.setVisible(false);
//		detail.dispose();
		Container cp = getContentPane();
		//		cp.setLayout(new GridLayout(1,2, 30, 10));
		cp.setLayout(new FlowLayout(FlowLayout.CENTER, 15,15));

		cp.add(keypnl);
		cp.add(ciphpnl);
		cp.add(resetbtn);
		cp.add(detailbtn);
		
		detailbtn.setEnabled(false);
		resetbtn.addActionListener(new cpActionListener());
		detailbtn.addActionListener(new cpActionListener());
		
		setSize(700,450);
		setVisible(true);
	
	}
	

	class cpActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == resetbtn) {
				keypnl.keytf.setEditable(true);

				keypnl.keybtn.setEnabled(true);

				keypnl.k1tf.setEditable(true);

				keypnl.k2tf.setEditable(true);

				keypnl.keytf.setText("");

				keypnl.k1tf.setText("");

				keypnl.k2tf.setText("");

				keypnl.k1tf.setBackground(Color.white);

				keypnl.k2tf.setBackground(Color.white);

				ciphpnl.ciphertf.setText("");

				ciphpnl.ciphertf.setEditable(true);

				ciphpnl.ciphertf2.setText("");

				ciphpnl.ciphertf2.setEditable(true);

				ciphpnl.plaintf.setText("");

				ciphpnl.plaintf.setEditable(true);

				ciphpnl.plaintf2.setText("");

				ciphpnl.plaintf2.setEditable(true);

				ciphpnl.enbtn.setEnabled(true);

				ciphpnl.debtn.setEnabled(true);
				detailbtn.setEnabled(false);
				
				
				sdes.tot=0;
				sdes.d=1;
				
				detail.p10tf.setText("");
				detail.p8tf.setText("");
				detail.twoshifttf.setText("");
				detail.oneshifttf.setText(""); 
				detail.p8tf.setText(""); 
				detail.plaintf.setText(""); 
				detail.iptf.setText(""); 
				detail.fktf.setText(""); 
				detail.swtf.setText(""); 
				detail.fktf2.setText(""); 
				detail.ipreversetf.setText(""); 
				detail.ciphertf.setText(""); 
				detail.decryptiontf.setText(""); 
				detail.ipreverseetf.setText(""); 
				detail.fkktf.setText(""); 
				detail.swwtf.setText(""); 
				detail.fkktf2.setText(""); 
				detail.ipptf.setText(""); 
				detail.cipherrtf.setText(""); 
				detail.tenbittf.setText("");
				detail.p8tf2.setText("");
			}
			
			else if(e.getSource() == detailbtn) {
				int result = JOptionPane.showConfirmDialog(null, "암호화 과정을 보시겠습니까?", "Comfirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {

				}
				else if(result == JOptionPane.YES_OPTION) {
					detail.setVisible(true);
					dispose();
	
				}
				else {

				}

			}
		}
	}
 

	class KeyGenerationPanel extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		TitledBorder tb1 = new TitledBorder(new LineBorder(Color.DARK_GRAY),"Key Generation");

		JLabel keytitle = new JLabel("key(0~1023)입력 : ");

		JLabel k1title = new JLabel("K1     값");

		JLabel k2title = new JLabel("K2     값");

		JTextField keytf = new JTextField(8);

		JTextField k1tf= new JTextField(8);

		JTextField k2tf = new JTextField(8);

		JButton keybtn = new JButton("키 생성");

		JButton detailbtn = new JButton("세부사항");

		JPanel subpanel = new JPanel();
		

		public KeyGenerationPanel() {

			this.setLayout(new FlowLayout(FlowLayout.CENTER,25,15));

			this.setBorder(tb1);

			this.add(keytitle);

			this.add(keytf);

			this.add(keybtn);
			

			subpanel.setLayout(new GridLayout(2, 2, 5, 5));

			subpanel.add(k1title);

			subpanel.add(k1tf);

			subpanel.add(k2title);

			subpanel.add(k2tf);

			this.add(subpanel);

			keybtn.addActionListener(new MyActionListener());

		}
		

		class  MyActionListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {

				try {

					if(e.getSource() == keybtn) {

						sdes.deci = Integer.parseInt(keytf.getText());

						sdes.tenbit();

						for(int i=0; i<10;i++)
							detail.tenbittf.setText(detail.tenbittf.getText()+sdes.digits[i]);
						detail.tenbittf.setEditable(false);
						
						sdes.input=sdes.digits;
						
						
						sdes.key_generation();
				
						for(int i=0; i<10;i++)
							detail.p10tf.setText(detail.p10tf.getText()+sdes.dep10[i]);
						detail.p10tf.setEditable(false);
						
						for(int i=0; i<10;i++)
							detail.oneshifttf.setText(detail.oneshifttf.getText()+sdes.oneshift[i]);
						detail.oneshifttf.setEditable(false);
						
						for(int i=0;i<8;i++)
							detail.p8tf.setText(detail.p8tf.getText()+sdes.k1[i]);
						detail.p8tf.setEditable(false);
						
						for(int i=0;i<10;i++)
							detail.twoshifttf.setText(detail.twoshifttf.getText()+sdes.twoshift[i]);
						detail.twoshifttf.setEditable(false);
						
						for(int i=0;i<8;i++)
							detail.p8tf2.setText(detail.p8tf2.getText()+sdes.k2[i]);
						detail.p8tf2.setEditable(false);
						
						
						String pw[]=new String[8];

						String pw2[]=new String[8];


						for(int i=0;i<8;i++) {

							pw[i]=Integer.toString(sdes.k1[i]);

							pw2[i] = Integer.toString(sdes.k2[i]);

						}


						for(int i=0;i<8;i++) {

							k1tf.setText(k1tf.getText()+ pw[i]);

							k2tf.setText(k2tf.getText()+ pw2[i]);

						}

						

						keybtn.setEnabled(false);

						k1tf.setEditable(false);

						k2tf.setEditable(false);

						k1tf.setBackground(Color.pink);

						k2tf.setBackground(Color.pink);
					

					}



				} catch(NumberFormatException er) {

					if(sdes.deci >= 1024) {

						JOptionPane.showMessageDialog(null, "1024미만으로 입력하세요.", "Danger!", JOptionPane.ERROR_MESSAGE);
						keytf.setText("");

					}

					else
						JOptionPane.showMessageDialog(null, "key값을 올바르게 입력하세요.", "Danger!",  JOptionPane.ERROR_MESSAGE);
					keytf.setText("");
				}

			}

		}

	}
	

	class CipherPanel extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		TitledBorder tb2 = new TitledBorder(new LineBorder(Color.DARK_GRAY), "S-DES");
		TitledBorder entb = new TitledBorder(new LineBorder(Color.DARK_GRAY), "ENCRYPTION");
		TitledBorder detb = new TitledBorder(new LineBorder(Color.DARK_GRAY), "DECRYPTION");
		JPanel enpnl = new JPanel();
		JPanel depnl = new JPanel();

		JLabel plainlbl = new JLabel("평문 입력(A~Z, a~z) :");
		JLabel plainlbl2 = new JLabel("복호화된 평문 :");

		JLabel cipherlbl = new JLabel("암호문 입력  : ");
		JLabel cipherlbl2 = new JLabel("암호화된 암호문 : ");

		JTextField plaintf = new JTextField(8);
		JTextField plaintf2 = new JTextField(8);

		JTextField ciphertf = new JTextField(8);
		JTextField ciphertf2 = new JTextField(8);

		JButton enbtn = new JButton("Encryption");

		JButton debtn = new JButton("Decryption");


		public CipherPanel() {
			this.setBorder(tb2);
			//			this.setLayout(new FlowLayout());
			this.setLayout(new GridLayout(2,1,10,10));
			enpnl.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
			enpnl.setBorder(entb);
			enpnl.add(plainlbl);
			enpnl.add(plaintf);
			enpnl.add(cipherlbl2);
			enpnl.add(ciphertf2);
			enpnl.add(enbtn);
		

			depnl.setLayout(new FlowLayout(FlowLayout.CENTER, 15,20));
			depnl.setBorder(detb);
			depnl.add(cipherlbl);
			depnl.add(ciphertf);
			depnl.add(plainlbl2);
			depnl.add(plaintf2);
			depnl.add(debtn);

			this.add(enpnl);
			this.add(depnl);

			enbtn.addActionListener(new MySecondActionListener());
			debtn.addActionListener(new MySecondActionListener());			

		}



		class MySecondActionListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {

				try {

					if(e.getSource()==enbtn) {
						

						String pw = plaintf.getText();
						
						detail.plaintf.setText(""+pw);
						detail.plaintf.setEditable(false);
						
						char pw1 = pw.charAt(0);


						pw = Integer.toBinaryString(pw1);


						//pw : tobinarystring후 이진수로 변한 숫자 

						for(int i=0; i<8;i++) {

							if(i==0)

								sdes.input[i]=0;

							else {

								pw1 = pw.charAt(i-1);

								sdes.input[i] = Integer.parseInt(String.valueOf(pw1));

							}

						}

						//여기까지 평문으로 받은 문자를 이진수로 변환하여 8자리를 만들어준다.

						sdes.ip();

						//						for(int i=0;i<8;i++)
						//
						//							System.out.print(sdes.tmp[i]);
						//
						//						System.out.println();
						for(int i=0; i<8; i++) {
							detail.iptf.setText(detail.iptf.getText() + sdes.dep8[i]);
							detail.iptf.setEditable(false);
						}
						
						sdes.ep();

						//						for(int i=0;i<8;i++)
						//
						//							System.out.print(sdes.tmp2[i]);
						//
						//						System.out.println();

						sdes.xor_k1();

						//						for(int i=0;i<8;i++)
						//
						//							System.out.print(sdes.tmp3[i]);
						//
						//						System.out.println();



						sdes.s_box();

						//						for(int i=0;i<4;i++)
						//
						//							System.out.print(sdes.tmp2[i]);
						//
						//						System.out.println();

						sdes.p4();

						//						for(int i=0;i<4;i++)
						//
						//							System.out.print(sdes.tmp3[i]);
						//
						//						System.out.println();

						sdes.ipXORp4();

						//						for(int i=0;i<4;i++)
						//
						//							System.out.print(sdes.tmp2[i]);
						//
						//						System.out.println();

						for(int i=0; i<8; i++) {
							detail.fktf.setText(detail.fktf.getText() + sdes.tmp2[i]);
							detail.fktf.setEditable(false);
						}
						
						
						
						sdes.sw();
						//
						//						for(int i=0;i<8;i++)
						//
						//							System.out.print(sdes.tmp[i]);
						//
						//						System.out.println();

						for(int i=0; i<8; i++) {
							detail.swtf.setText(detail.swtf.getText() + sdes.tmp[i]);
							detail.swtf.setEditable(false);
						}
						sdes.ep();

						//						for(int i=0;i<8;i++)

						//							System.out.print(sdes.tmp2[i]);

						//						System.out.println();

						sdes.xor_k2();

						sdes.s_box();

						sdes.p4();

						sdes.ipXORp4();
						
						for(int i=0; i<8; i++) {
							detail.fktf2.setText(detail.fktf2.getText() + sdes.tmp2[i]);
							detail.fktf2.setEditable(false);
						}

						sdes.ip_1();
						for(int i=0; i<8; i++) {
							detail.ipreversetf.setText(detail.ipreversetf.getText() + sdes.tmp3[i]);
							detail.ipreversetf.setEditable(false);
						}
						
						for(int i=0; i<8; i++) {
							detail.ciphertf.setText(detail.ciphertf.getText() + sdes.tmp3[i]);
							detail.ciphertf.setEditable(false);
						}
						
						
						for(int i=0; i<8; i++) {
							ciphertf2.setText(ciphertf2.getText()+Integer.toString(sdes.tmp3[i]));
							ciphertf.setText(ciphertf.getText()+Integer.toString(sdes.tmp3[i]));
						
						}
						
						ciphertf.setForeground(Color.RED);
						ciphertf2.setForeground(Color.RED);
						ciphertf.setEditable(false);
						ciphertf2.setEditable(false);
						enbtn.setEnabled(false);	
					}


					else if(e.getSource()==debtn) {

						String pw = ciphertf.getText();

						for(int i=0; i<8; i++) {

							char pw1 = pw.charAt(i);

							sdes.input[i] = Integer.parseInt(String.valueOf(pw1));

						}
						
						for(int i=0; i<8; i++) {
							detail.cipherrtf.setText(detail.cipherrtf.getText() + sdes.tmp3[i]);
							detail.cipherrtf.setEditable(false);
						}

						sdes.ip();
						
						for(int i=0; i<8; i++) {
							detail.ipptf.setText(detail.ipptf.getText() + sdes.tmp[i]);
							detail.ipptf.setEditable(false);
						}

						sdes.ep();

						sdes.xor_k2();

						sdes.s_box();

						sdes.p4();

						sdes.ipXORp4();
						
						for(int i=0; i<8; i++) {
							detail.fkktf2.setText(detail.fkktf2.getText() + sdes.tmp2[i]);
							detail.fkktf2.setEditable(false);
						}


						sdes.sw();
						
						for(int i=0; i<8; i++) {
							detail.swwtf.setText(detail.swwtf.getText() + sdes.tmp[i]);
							detail.swwtf.setEditable(false);
						}

						sdes.ep();

						sdes.xor_k1();

						sdes.s_box();

						sdes.p4();

						sdes.ipXORp4();
						
						for(int i=0; i<8; i++) {
							detail.fkktf.setText(detail.fkktf.getText() + sdes.tmp2[i]);
							detail.fkktf.setEditable(false);
						}

						sdes.ip_1();
						
						for(int i=0; i<8; i++) {
							detail.ipreverseetf.setText(detail.ipreverseetf.getText() + sdes.tmp3[i]);
							detail.ipreverseetf.setEditable(false);
						}

						sdes.changedecimal();

						ch = (char)sdes.tot;
						
						detail.decryptiontf.setText(detail.decryptiontf.getText()+ch);
						detail.decryptiontf.setEditable(false);
						
						plaintf2.setText(plaintf2.getText()+ch);
						plaintf2.setForeground(Color.BLUE);
						plaintf2.setEditable(false);
						debtn.setEnabled(false);
						detailbtn.setEnabled(true);
					}

				} catch(StringIndexOutOfBoundsException eo) {
					


				}

			}

		}
		
	}

}