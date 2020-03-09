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
import vo.UserVo;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame{
	Container c = getContentPane();
	JPanel northPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();
	JLabel titleLabel = new JLabel("파티 사냥");
	JLabel idLabel = new JLabel("ID :");
	JLabel pwLabel = new JLabel("PW :");
	JTextField idText = new JTextField();
	JPasswordField pwText = new JPasswordField();
	JButton confirm = new JButton("확인");
	JButton join = new JButton("가입 하기");
	//리스너
	buttonListener button = new buttonListener();
	//getInstance
	LoginDao loginDao = LoginDao.getInstance();
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인 창");
		setUi();
		setResizable(false);
		setSize(300, 150);
		setVisible(true);
	}
	private void setUi() {
		setNorthPanel();
		setCenterPanel();
		setSouthPanel();
	}
	
	private void setNorthPanel() {
		northPanel.add(titleLabel);
		c.add(northPanel, BorderLayout.NORTH);
	}
	
	private void setCenterPanel() {
		centerPanel.add(idLabel);
		centerPanel.add(idText);
		centerPanel.add(pwLabel);
		centerPanel.add(pwText);
		centerPanel.setLayout(new GridLayout(2, 2));
		c.add(centerPanel);		
	}
	
	private void setSouthPanel() {
		confirm.addActionListener(button);
		join.addActionListener(button);
		southPanel.add(confirm);
		southPanel.add(join);
		c.add(southPanel, BorderLayout.SOUTH);		
	}
	class buttonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == confirm) {
				String id_text = idText.getText();
				char[] pw_char = pwText.getPassword();
				String pw_text = new String(pw_char);
				UserVo vo = new UserVo();
				vo.setUser_id(id_text);
				vo.setUser_pw(pw_text);
				UserVo loginVo = loginDao.login(vo);				
				if (loginVo != null) {					
					MainFrame mainFrame = new MainFrame(loginVo);
					mainFrame.setVisible(true);
					LoginFrame.this.dispose();
				}
			}else if (source == join) {
				new JoinFrame();
			}
		}		
	}
}
