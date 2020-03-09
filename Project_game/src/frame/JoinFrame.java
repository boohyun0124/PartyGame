package frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.LoginDao;
import vo.UserCharacterVo;
import vo.UserVo;

@SuppressWarnings("serial")
public class JoinFrame extends JFrame{
	Container c = getContentPane();
	JPanel northPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();
	
	JLabel title = new JLabel("가입 하기");
	JLabel idLabel = new JLabel("ID :");
	JLabel nameLabel = new JLabel("NAME :");
	JLabel pwLabel = new JLabel("PW :");
	JLabel pwAgainLabel = new JLabel("PW_Again :");
	
	JTextField idText = new JTextField();
	JTextField nameText = new JTextField();
	JPasswordField pwText = new JPasswordField();
	JPasswordField pwAgainText = new JPasswordField();
	
	JButton confirm = new JButton("확인");
	JButton cancel = new JButton("취소");
	//리스너
	buttonListener button = new buttonListener();
	//getInstance
	LoginDao loginDao = LoginDao.getInstance();
	
	public JoinFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("가입 하기");
		setUi();
		setSize(300, 200);
		setVisible(true);
	}
	private void setUi() {
		setNorthPanel();
		setCenterPanel();
		setSouthPanel();		
	}
	private void setNorthPanel() {
		northPanel.add(title);
		c.add(northPanel, BorderLayout.NORTH);
	}
	
	private void setCenterPanel() {
		centerPanel.setLayout(new GridLayout(4,2));
		centerPanel.add(idLabel);
		centerPanel.add(idText);
		centerPanel.add(nameLabel);
		centerPanel.add(nameText);
		centerPanel.add(pwLabel);
		centerPanel.add(pwText);
		centerPanel.add(pwAgainLabel);
		centerPanel.add(pwAgainText);
		c.add(centerPanel);
	}
	
	private void setSouthPanel() {
		confirm.addActionListener(button);
		cancel.addActionListener(button);
		southPanel.add(confirm);
		southPanel.add(cancel);
		c.add(southPanel, BorderLayout.SOUTH);		
	}
	
	class buttonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == confirm) {
				String id_text = idText.getText();
				String name_text = nameText.getText();
				char[] pw_char = pwText.getPassword();
				char[] pw_again_char = pwAgainText.getPassword();
				String pw_text = new String(pw_char);
				String pw_again_text = new String(pw_again_char);
				if (pw_text.equals(pw_again_text)) {
					//user_table
					UserVo inputUser = new UserVo(id_text, pw_text, name_text);
					loginDao.joinUserInfo(inputUser);
					//user_character_table
					UserCharacterVo inputTanker = new UserCharacterVo(id_text, name_text, "tanker", 20, 10, 25, 30);
					UserCharacterVo inputDealer = new UserCharacterVo(id_text, name_text, "dealer", 40, 20, 15, 25);
					UserCharacterVo inputWizard = new UserCharacterVo(id_text, name_text, "wizard", 10, 40, 10, 20);
					UserCharacterVo inputHealer = new UserCharacterVo(id_text, name_text, "healer", 10, 35, 15, 20);
					loginDao.joinCharacterInfo(inputTanker);
					loginDao.joinCharacterInfo(inputDealer);
					loginDao.joinCharacterInfo(inputWizard);
					loginDao.joinCharacterInfo(inputHealer);
					JoinFrame.this.dispose();
				}else {
					System.out.println("비밀번호 확인");
				}
				
			}else if (source == cancel) {
				JoinFrame.this.dispose();
			}
		}		
	}
}
