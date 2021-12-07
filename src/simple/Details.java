package simple;

import javax.swing.*;



import java.awt.*;



import java.awt.event.*;



import javax.swing.border.*;



public class Details extends JFrame {

	/**

	 * 

	 */

	private static final long serialVersionUID = 1L;

	JTextField tenbittf = new JTextField(9);

	JTextField p10tf = new JTextField(9);

	JTextField p8tf = new JTextField(9);

	JTextField twoshifttf = new JTextField(9);

	JTextField oneshifttf = new JTextField(9);

	JTextField p8tf2 = new JTextField(9);


	JTextField plaintf = new JTextField(9);

	JTextField iptf = new JTextField(9);

	JTextField fktf = new JTextField(9);

	JTextField swtf = new JTextField(9);

	JTextField fktf2 = new JTextField(9);

	JTextField ipreversetf = new JTextField(9);

	JTextField ciphertf = new JTextField(9);


	JTextField decryptiontf = new JTextField(9);

	JTextField ipreverseetf = new JTextField(9);

	JTextField fkktf = new JTextField(9);

	JTextField swwtf = new JTextField(9);

	JTextField fkktf2 = new JTextField(9);

	JTextField ipptf = new JTextField(9);

	JTextField cipherrtf = new JTextField(9);


	KeyGenPanel keygenpnl = new KeyGenPanel();

	LeftPanel leftpnl = new LeftPanel();

	RightPanel rpnl = new RightPanel();


	public Details() {

		super("암호화 상세과정");


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container cp = getContentPane();

		cp.setLayout(new GridLayout(1,3));	
		
		

		keygenpnl.setLayout(new GridLayout(12, 1, 10, 10));

		leftpnl.setLayout(new GridLayout(14, 1, 5, 5));

		rpnl.setLayout(new GridLayout(14, 1, 5, 5));


		cp.add(leftpnl);

		cp.add(keygenpnl);

		cp.add(rpnl);


		setSize(700,430);
		setVisible(true);

	}



	class KeyGenPanel extends JPanel {

		/**

		 * 

		 */

		private static final long serialVersionUID = 1L;

		TitledBorder keytb = new TitledBorder(new LineBorder(Color.DARK_GRAY), "KEY-GENERATION");

		JLabel tenbitbin = new JLabel("10-bits key");

		JLabel p10lbl = new JLabel("P10 (3 5 2 7 4 10 1 9 8 6)");

		JLabel oneshitlbl = new JLabel("1bit Left Shift");

		JLabel p8lbl = new JLabel("P8(6 3 7 4 8 5 10 9)");

		JLabel twoshiftlbl = new JLabel("2bit Left Shift");

		JLabel p8lbl2 = new JLabel("P8(6 3 7 4 8 5 10 9)");



		public KeyGenPanel() {

			tenbittf.setText("");

			this.setBorder(keytb);

			this.add(tenbitbin);

			this.add(tenbittf);

			this.add(p10lbl);

			this.add(p10tf);

			this.add(oneshitlbl);

			this.add(oneshifttf);

			this.add(p8lbl);

			this.add(p8tf);

			this.add(twoshiftlbl);

			this.add(twoshifttf);

			this.add(p8lbl2);

			this.add(p8tf2);
			
			tenbittf.setToolTipText("입력받은 십진수를 10bit 이진수형태로 변환합니다.");
			p10tf.setToolTipText("P10순열로 치환합니다.");
			oneshifttf.setToolTipText("재정렬된 값을 좌우 5bit씩 나눈 후 각각 LS(Left Shift)-1bit를 수행합니다.");
			p8tf.setToolTipText("위의 결과를 합쳐서 P8의 순열로 치환하여 8bit의 K1을 생성합니다.");
			twoshifttf.setToolTipText("위의 결과를 다시 각각 LS(Left Shift)-2bit를 수행합니다.");
			p8tf2.setToolTipText("위의 결과를 합쳐서 P8의 순열로 치환하여 8bit의 K2를 생성합니다.");
		}

	}



	class LeftPanel extends JPanel {

		/**

		 * 

		 */

		private static final long serialVersionUID = 1L;

		TitledBorder centertb = new TitledBorder(new LineBorder(Color.DARK_GRAY), "ENCRYPTION");

		JLabel plainlbl = new JLabel("사용자가 입력한 평문");

		JLabel iplbl = new JLabel("IP (2 6 3 1 4 8 5 7)");

		JLabel fklbl = new JLabel("Fk");

		JLabel swlbl = new JLabel("Switch");

		JLabel fklbl2 = new JLabel("Fk");

		JLabel ipreverselbl = new JLabel("IP-1 ( 4 1 3 5 7 2 8 6)");

		JLabel cipherlbl = new JLabel("암호화된 암호문");
		
		

		public LeftPanel() {

			this.setBorder(centertb);	

			p8tf.setBackground(Color.pink);

			p8tf2.setBackground(Color.pink);

			ciphertf.setForeground(Color.RED);

			plaintf.setForeground(Color.BLUE);

			this.add(plainlbl);

			this.add(plaintf);

			this.add(iplbl);

			this.add(iptf);

			this.add(fklbl);

			this.add(fktf);

			this.add(swlbl);

			this.add(swtf);

			this.add(fklbl2);

			this.add(fktf2);

			this.add(ipreverselbl);

			this.add(ipreversetf);

			this.add(cipherlbl);

			this.add(ciphertf);
			
			plaintf.setToolTipText("사용자가 입력한 평문입니다.");
			iptf.setToolTipText("평문 8bit를 IP순열로 치환합니다.");
			fktf.setToolTipText("E/P -> S-BOX -> P4 -> IP후의 왼쪽 4비트와 XOR 논리연산을 합니다.");
			swtf.setToolTipText("Fk의 4비트와 IP 후의 오른쪽 4비트와 왼쪽 오른쪽 자리를 바꾸어 줍니다.");
			fktf2.setToolTipText("E/P -> S-BOX -> P4 -> IP후의 왼쪽 4비트와 XOR 논리연산을 합니다.");
			ipreversetf.setToolTipText("IP-1 순열로 치환합니다.");
			ciphertf.setToolTipText("평문이 이진수 형태로 암호화가 되었습니다.");
		}

	}



	class RightPanel extends JPanel {

		/**

		 * 

		 */

		private static final long serialVersionUID = 1L;

		TitledBorder righttb = new TitledBorder(new LineBorder(Color.DARK_GRAY), "DECRYPTION");

		JLabel plainlbl = new JLabel("복호화된 평문");

		JLabel ipreverselbl = new JLabel("IP-1 (4 1 3 5 7 2 8 6)");

		JLabel fk2lbl = new JLabel("Fk");

		JLabel swlbl = new JLabel("Switch");

		JLabel fklbl = new JLabel("Fk");

		JLabel iplbl = new JLabel("IP (2 6 3 1 4 8 5 7)");

		JLabel encryptionlbl = new JLabel("암호화된 암호문");


		public RightPanel() {

			this.setBorder(righttb);

			decryptiontf.setForeground(Color.BLUE);

			cipherrtf.setForeground(Color.RED);

			this.add(plainlbl);

			this.add(decryptiontf);

			this.add(ipreverselbl);

			this.add(ipreverseetf);

			this.add(fk2lbl);

			this.add(fkktf);

			this.add(swlbl);

			this.add(swwtf); 

			this.add(fklbl);

			this.add(fkktf2);

			this.add(iplbl);

			this.add(ipptf);

			this.add(encryptionlbl);

			this.add(cipherrtf);
			
			
			decryptiontf.setToolTipText("사용자가 입력한 평문으로 복호화가 되었습니다.");
			ipreverseetf.setToolTipText("IP-1 순열로 치환합니다.");
			fkktf.setToolTipText("E/P -> S-BOX -> P4 -> IP후의 왼쪽 4비트와 XOR 논리연산을 합니다.");
			swwtf.setToolTipText("Fk의 4비트와 IP 후의 오른쪽 4비트와 왼쪽 오른쪽 자리를 바꾸어 줍니다.");
			fkktf2.setToolTipText("E/P -> S-BOX -> P4 -> IP후의 왼쪽 4비트와 XOR 논리연산을 합니다.");
			ipptf.setToolTipText("8bit를 IP순열로 치환합니다.");
			cipherrtf.setToolTipText("암호화된 암호문입니다.");

		}

	}
	
}



