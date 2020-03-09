package frame;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import dao.CharacterDao;
import vo.UserCharacterVo;
import vo.UserVo;

@SuppressWarnings("serial")
public class tapEx extends JFrame{
	Container c = getContentPane();
	JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
	//tanker
	ImageIcon tanker_Image = new ImageIcon("images/tanker_info.png");	
	JPanel tanker_Info = new JPanel();
	JLabel tanker_power = new JLabel("공격력");
	JTextField tanker_power_text = new JTextField(10);
	JLabel tanker_magic = new JLabel("마력");
	JTextField tanker_magic_text = new JTextField(10);
	JLabel tanker_defense = new JLabel("방어력");
	JTextField tanker_defense_text = new JTextField(10);
	JLabel tanker_health = new JLabel("체력");
	JTextField tanker_health_text = new JTextField(10);
	//dealer
	ImageIcon dealer_Image = new ImageIcon("images/dealer_info.png");
	JPanel dealer_Info = new JPanel();
	JLabel dealer_power = new JLabel("공격력");
	JTextField dealer_power_text = new JTextField(10);
	JLabel dealer_magic = new JLabel("마력");
	JTextField dealer_magic_text = new JTextField(10);
	JLabel dealer_defense = new JLabel("방어력");
	JTextField dealer_defense_text = new JTextField(10);
	JLabel dealer_health = new JLabel("체력");
	JTextField dealer_health_text = new JTextField(10);
	//wizard
	ImageIcon wizard_Image = new ImageIcon("images/wizard_info.png");
	JPanel wizard_Info = new JPanel();
	JLabel wizard_power = new JLabel("공격력");
	JTextField wizard_power_text = new JTextField(10);
	JLabel wizard_magic = new JLabel("마력");
	JTextField wizard_magic_text = new JTextField(10);
	JLabel wizard_defense = new JLabel("방어력");
	JTextField wizard_defense_text = new JTextField(10);
	JLabel wizard_health = new JLabel("체력");
	JTextField wizard_health_text = new JTextField(10);
	//healer
	ImageIcon healer_Image = new ImageIcon("images/healer_info.png");
	JPanel healer_Info = new JPanel();
	JLabel healer_power = new JLabel("공격력");
	JTextField healer_power_text = new JTextField(10);
	JLabel healer_magic = new JLabel("마력");
	JTextField healer_magic_text = new JTextField(10);
	JLabel healer_defense = new JLabel("방어력");
	JTextField healer_defense_text = new JTextField(10);
	JLabel healer_health = new JLabel("체력");
	JTextField healer_health_text = new JTextField(10);
	
	
	//Label
	JLabel point_Label1 = new JLabel("남은 포인트");
	JLabel point_Label2 = new JLabel("남은 포인트");
	JLabel point_Label3 = new JLabel("남은 포인트");
	JLabel point_Label4 = new JLabel("남은 포인트");
	
	//tanker_Button
	JButton tanker_power_up = new JButton("up");
	JButton tanker_power_down = new JButton("down");
	JButton tanker_magic_up = new JButton("up");
	JButton tanker_magic_down = new JButton("down");
	JButton tanker_defense_up = new JButton("up");
	JButton tanker_defense_down = new JButton("down");
	JButton tanker_health_up = new JButton("up");
	JButton tanker_health_down = new JButton("down");
	
	JTextField tanker_point = new JTextField(); //tanker Point
	JButton tanker_result = new JButton("확인");
	
	//dealer_Button
	JButton dealer_power_up = new JButton("up");
	JButton dealer_power_down = new JButton("down");
	JButton dealer_magic_up = new JButton("up");
	JButton dealer_magic_down = new JButton("down");
	JButton dealer_defense_up = new JButton("up");
	JButton dealer_defense_down = new JButton("down");
	JButton dealer_health_up = new JButton("up");
	JButton dealer_health_down = new JButton("down");
	
	JTextField dealer_point = new JTextField(); //dealer Point
	JButton dealer_result = new JButton("확인");
	
	//wizard_Button
	JButton wizard_power_up = new JButton("up");
	JButton wizard_power_down = new JButton("down");
	JButton wizard_magic_up = new JButton("up");
	JButton wizard_magic_down = new JButton("down");
	JButton wizard_defense_up = new JButton("up");
	JButton wizard_defense_down = new JButton("down");
	JButton wizard_health_up = new JButton("up");
	JButton wizard_health_down = new JButton("down");
	
	JTextField wizard_point = new JTextField(); //wizard Point
	JButton wizard_result = new JButton("확인");
	
	//healer_Button
	JButton healer_power_up = new JButton("up");
	JButton healer_power_down = new JButton("down");
	JButton healer_magic_up = new JButton("up");
	JButton healer_magic_down = new JButton("down");
	JButton healer_defense_up = new JButton("up");
	JButton healer_defense_down = new JButton("down");
	JButton healer_health_up = new JButton("up");
	JButton healer_health_down = new JButton("down");
	
	JTextField healer_point = new JTextField(); //healer Point
	JButton healer_result = new JButton("확인");
	
	//getInstance--------------------------------------------------------------------------
		CharacterDao characterDao = CharacterDao.getInstance();
		UserCharacterVo characterVo = new UserCharacterVo();
	UserVo loginVo;
		
	//리스너
	ButtonClick buttonListener = new ButtonClick();
	ESCKey esckeylistener = new ESCKey();
	
	//포인트 숫자 //나중에 데이터 베이스로 따로 관리 해야됨
	int point = 20;
	
	public tapEx(UserVo loginVo) {
		this.loginVo = loginVo;
		characterVo.setUser_id(loginVo.getUser_id());
		characterVo.setUser_name(loginVo.getUser_name());
		setTitle("esc키 리스너 사용 캐릭터 정보보기");
		setTankerInfo();
		setDealerInfo();
		setWizardInfo();
		setHealerInfo();
		tab.addTab("탱커 정보", tanker_Image, tanker_Info);
		tab.addTab("딜러 정보", dealer_Image, dealer_Info);
		tab.addTab("마법사 정보", wizard_Image, wizard_Info);
		tab.addTab("힐러 정보", healer_Image, healer_Info);
		c.addKeyListener(esckeylistener);
		c.add(tab);
		
		setSize(500, 500);
		setVisible(true);
		
		c.requestFocus();
	}
	
	//탱커
	private void setTankerInfo() {
		
		//데이터 베이스 정보 불러오기
		UserCharacterVo dao = characterDao.TankerInfo(characterVo);
		tanker_power_text.setText(String.valueOf(dao.getAbility_power()));
		tanker_magic_text.setText(String.valueOf(dao.getAbility_magic()));
		tanker_defense_text.setText(String.valueOf(dao.getAbility_defense()));
		tanker_health_text.setText(String.valueOf(dao.getAbility_health()));
		
		//버튼 마우스 리스너
		tanker_power_up.addMouseListener(buttonListener);
		tanker_power_down.addMouseListener(buttonListener);
		tanker_magic_up.addMouseListener(buttonListener);
		tanker_magic_down.addMouseListener(buttonListener);
		tanker_defense_up.addMouseListener(buttonListener);
		tanker_defense_down.addMouseListener(buttonListener);
		tanker_health_up.addMouseListener(buttonListener);
		tanker_health_down.addMouseListener(buttonListener);
		
		tanker_result.addMouseListener(buttonListener);
		
		//남은 포인트
		tanker_point.setText(String.valueOf(point));
		
		//
		tanker_power_down.setVisible(false);
		tanker_magic_down.setVisible(false);
		tanker_defense_down.setVisible(false);
		tanker_health_down.setVisible(false);
		
		//탭에 추가
		tanker_power_text.setEditable(false);
		tanker_magic_text.setEditable(false);
		tanker_defense_text.setEditable(false);
		tanker_health_text.setEditable(false);
		tanker_point.setEditable(false);
		tanker_Info.setLayout(new GridLayout(5,4));
		tanker_Info.add(tanker_power);
		tanker_Info.add(tanker_power_text); //공
		tanker_Info.add(tanker_power_up);
		tanker_Info.add(tanker_power_down);
		tanker_Info.add(tanker_magic);
		tanker_Info.add(tanker_magic_text); //마
		tanker_Info.add(tanker_magic_up);
		tanker_Info.add(tanker_magic_down);
		tanker_Info.add(tanker_defense);
		tanker_Info.add(tanker_defense_text); //방
		tanker_Info.add(tanker_defense_up);
		tanker_Info.add(tanker_defense_down);
		tanker_Info.add(tanker_health);
		tanker_Info.add(tanker_health_text); //체
		tanker_Info.add(tanker_health_up);
		tanker_Info.add(tanker_health_down);
		
		tanker_Info.add(point_Label1);
		tanker_Info.add(tanker_point);
		tanker_Info.add(tanker_result);
	}
	
	//딜러
	private void setDealerInfo() {	
		//데이터 베이스 정보 가져오기
		UserCharacterVo dao = characterDao.DealerInfo(characterVo);
		dealer_power_text.setText(String.valueOf(dao.getAbility_power()));
		dealer_magic_text.setText(String.valueOf(dao.getAbility_magic()));
		dealer_defense_text.setText(String.valueOf(dao.getAbility_defense()));
		dealer_health_text.setText(String.valueOf(dao.getAbility_health()));
		
		//버튼 마우스 리스너
		dealer_power_up.addMouseListener(buttonListener);
		dealer_power_down.addMouseListener(buttonListener);
		dealer_magic_up.addMouseListener(buttonListener);
		dealer_magic_down.addMouseListener(buttonListener);
		dealer_defense_up.addMouseListener(buttonListener);
		dealer_defense_down.addMouseListener(buttonListener);
		dealer_health_up.addMouseListener(buttonListener);
		dealer_health_down.addMouseListener(buttonListener);
		
		dealer_result.addMouseListener(buttonListener);
		
		//남은 포인트
		dealer_point.setText(String.valueOf(point));
		
		//
		dealer_power_down.setVisible(false);
		dealer_magic_down.setVisible(false);
		dealer_defense_down.setVisible(false);
		dealer_health_down.setVisible(false);
		
		//탭에 추가
		dealer_power_text.setEditable(false);
		dealer_magic_text.setEditable(false);
		dealer_defense_text.setEditable(false);
		dealer_health_text.setEditable(false);
		dealer_point.setEditable(false);
		dealer_Info.setLayout(new GridLayout(5,4));
		dealer_Info.add(dealer_power);
		dealer_Info.add(dealer_power_text); //공
		dealer_Info.add(dealer_power_up);
		dealer_Info.add(dealer_power_down);
		dealer_Info.add(dealer_magic);
		dealer_Info.add(dealer_magic_text); //마
		dealer_Info.add(dealer_magic_up);
		dealer_Info.add(dealer_magic_down);
		dealer_Info.add(dealer_defense);
		dealer_Info.add(dealer_defense_text); //방
		dealer_Info.add(dealer_defense_up);
		dealer_Info.add(dealer_defense_down);
		dealer_Info.add(dealer_health);
		dealer_Info.add(dealer_health_text); //체
		dealer_Info.add(dealer_health_up);
		dealer_Info.add(dealer_health_down);
		
		dealer_Info.add(point_Label2);
		dealer_Info.add(dealer_point);
		dealer_Info.add(dealer_result);
	}
	
	//마법사
	private void setWizardInfo() {

		//데이터 베이스 정보 가져오기
		UserCharacterVo dao = characterDao.WizardInfo(characterVo);
		wizard_power_text.setText(String.valueOf(dao.getAbility_power()));
		wizard_magic_text.setText(String.valueOf(dao.getAbility_magic()));
		wizard_defense_text.setText(String.valueOf(dao.getAbility_defense()));
		wizard_health_text.setText(String.valueOf(dao.getAbility_health()));
		
		//버튼 마우스 리스너
		wizard_power_up.addMouseListener(buttonListener);
		wizard_power_down.addMouseListener(buttonListener);
		wizard_magic_up.addMouseListener(buttonListener);
		wizard_magic_down.addMouseListener(buttonListener);
		wizard_defense_up.addMouseListener(buttonListener);
		wizard_defense_down.addMouseListener(buttonListener);
		wizard_health_up.addMouseListener(buttonListener);
		wizard_health_down.addMouseListener(buttonListener);
		
		wizard_result.addMouseListener(buttonListener);
		
		//남은 포인트
		wizard_point.setText(String.valueOf(point));
		
		//
		wizard_power_down.setVisible(false);
		wizard_magic_down.setVisible(false);
		wizard_defense_down.setVisible(false);
		wizard_health_down.setVisible(false);
		
		//탭에 추가
		wizard_power_text.setEditable(false);
		wizard_magic_text.setEditable(false);
		wizard_defense_text.setEditable(false);
		wizard_health_text.setEditable(false);
		wizard_point.setEditable(false);
		wizard_Info.setLayout(new GridLayout(5,4));
		wizard_Info.add(wizard_power);
		wizard_Info.add(wizard_power_text); //공
		wizard_Info.add(wizard_power_up);
		wizard_Info.add(wizard_power_down);
		wizard_Info.add(wizard_magic);
		wizard_Info.add(wizard_magic_text); //마
		wizard_Info.add(wizard_magic_up);
		wizard_Info.add(wizard_magic_down);
		wizard_Info.add(wizard_defense);
		wizard_Info.add(wizard_defense_text); //방
		wizard_Info.add(wizard_defense_up);
		wizard_Info.add(wizard_defense_down);
		wizard_Info.add(wizard_health);
		wizard_Info.add(wizard_health_text); //체
		wizard_Info.add(wizard_health_up);
		wizard_Info.add(wizard_health_down);
		
		wizard_Info.add(point_Label3);
		wizard_Info.add(wizard_point);
		wizard_Info.add(wizard_result);
	}
	
	//힐러
	private void setHealerInfo() {
		
		//데이터 베이스 정보 가져오기
		UserCharacterVo dao = characterDao.HealerInfo(characterVo);
		healer_power_text.setText(String.valueOf(dao.getAbility_power()));
		healer_magic_text.setText(String.valueOf(dao.getAbility_magic()));
		healer_defense_text.setText(String.valueOf(dao.getAbility_defense()));
		healer_health_text.setText(String.valueOf(dao.getAbility_health()));
		
		//버튼 마우스 리스너
		healer_power_up.addMouseListener(buttonListener);
		healer_power_down.addMouseListener(buttonListener);
		healer_magic_up.addMouseListener(buttonListener);
		healer_magic_down.addMouseListener(buttonListener);
		healer_defense_up.addMouseListener(buttonListener);
		healer_defense_down.addMouseListener(buttonListener);
		healer_health_up.addMouseListener(buttonListener);
		healer_health_down.addMouseListener(buttonListener);
		
		healer_result.addMouseListener(buttonListener);
		
		//남은 포인트
		healer_point.setText(String.valueOf(point));
		
		//
		healer_power_down.setVisible(false);
		healer_magic_down.setVisible(false);
		healer_defense_down.setVisible(false);
		healer_health_down.setVisible(false);
		
		//탭에 추가
		healer_power_text.setEditable(false);
		healer_magic_text.setEditable(false);
		healer_defense_text.setEditable(false);
		healer_health_text.setEditable(false);
		healer_point.setEditable(false);
		healer_Info.setLayout(new GridLayout(5,4));
		healer_Info.add(healer_power);
		healer_Info.add(healer_power_text); //공
		healer_Info.add(healer_power_up);
		healer_Info.add(healer_power_down);
		healer_Info.add(healer_magic);
		healer_Info.add(healer_magic_text); //마
		healer_Info.add(healer_magic_up);
		healer_Info.add(healer_magic_down);
		healer_Info.add(healer_defense);
		healer_Info.add(healer_defense_text); //방
		healer_Info.add(healer_defense_up);
		healer_Info.add(healer_defense_down);
		healer_Info.add(healer_health);
		healer_Info.add(healer_health_text); //체
		healer_Info.add(healer_health_up);
		healer_Info.add(healer_health_down);
		
		healer_Info.add(point_Label4);
		healer_Info.add(healer_point);
		healer_Info.add(healer_result);
		
		
	}
	//keyListener
	class ESCKey implements KeyListener {		
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_ESCAPE:
				tapEx.this.dispose();
			}
			
		}
		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {}		
	}
	//MouseAdapter
	class ButtonClick extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			Object source = e.getSource();
			
			//----------------------------------------------------------------------------------up, down
			//tanker listener
			if (source == tanker_power_up) {
				//
				int power = Integer.parseInt(tanker_power_text.getText());
				power += 1;
				tanker_power_text.setText(String.valueOf(power));
				//
				point -= 1;
				tanker_point.setText(String.valueOf(point));				
			}else if (source == tanker_power_down) {
				int power = Integer.parseInt(tanker_power_text.getText());
				power -= 1;
				tanker_power_text.setText(String.valueOf(power));
				//
				point += 1;
				tanker_point.setText(String.valueOf(point));
			}else if (source == tanker_magic_up) {
				int magic = Integer.parseInt(tanker_magic_text.getText());
				magic += 1;
				tanker_magic_text.setText(String.valueOf(magic));
				//
				point -= 1;
				tanker_point.setText(String.valueOf(point));
			}else if (source == tanker_magic_down) {
				int magic = Integer.parseInt(tanker_magic_text.getText());
				magic -= 1;
				tanker_magic_text.setText(String.valueOf(magic));
				//
				point += 1;
				tanker_point.setText(String.valueOf(point));
			}else if (source == tanker_defense_up) {
				int defense = Integer.parseInt(tanker_defense_text.getText());
				defense += 1;
				tanker_defense_text.setText(String.valueOf(defense));
				//
				point -= 1;
				tanker_point.setText(String.valueOf(point));
			}else if (source == tanker_defense_down) {
				int defense = Integer.parseInt(tanker_defense_text.getText());
				defense -= 1;
				tanker_defense_text.setText(String.valueOf(defense));
				//
				point += 1;
				tanker_point.setText(String.valueOf(point));
			}else if (source == tanker_health_up) {
				int health = Integer.parseInt(tanker_health_text.getText());
				health += 1;
				tanker_health_text.setText(String.valueOf(health));
				//
				point -= 1;
				tanker_point.setText(String.valueOf(point));
			}else if (source == tanker_health_down) {
				int health = Integer.parseInt(tanker_health_text.getText());
				health -= 1;
				tanker_health_text.setText(String.valueOf(health));
				//
				point += 1;
				tanker_point.setText(String.valueOf(point));
			}
			//dealer listener
			if (source == dealer_power_up) {							
				int power = Integer.parseInt(dealer_power_text.getText());
				power += 1;
				dealer_power_text.setText(String.valueOf(power));
				//
				point -= 1;
				dealer_point.setText(String.valueOf(point));
			}else if (source == dealer_power_down) {
				int power = Integer.parseInt(dealer_power_text.getText());
				power -= 1;
				dealer_power_text.setText(String.valueOf(power));
				//
				point += 1;
				dealer_point.setText(String.valueOf(point));
			}else if (source == dealer_magic_up) {
				int magic = Integer.parseInt(dealer_magic_text.getText());
				magic += 1;
				dealer_magic_text.setText(String.valueOf(magic));
				//
				point -= 1;
				dealer_point.setText(String.valueOf(point));
			}else if (source == dealer_magic_down) {
				int magic = Integer.parseInt(dealer_magic_text.getText());
				magic -= 1;
				dealer_magic_text.setText(String.valueOf(magic));
				//
				point += 1;
				dealer_point.setText(String.valueOf(point));
			}else if (source == dealer_defense_up) {
				int defense = Integer.parseInt(dealer_defense_text.getText());
				defense += 1;
				dealer_defense_text.setText(String.valueOf(defense));
				//
				point -= 1;
				dealer_point.setText(String.valueOf(point));
			}else if (source == dealer_defense_down) {
				int defense = Integer.parseInt(dealer_defense_text.getText());
				defense -= 1;
				dealer_defense_text.setText(String.valueOf(defense));
				//
				point += 1;
				dealer_point.setText(String.valueOf(point));
			}else if (source == dealer_health_up) {
				int health = Integer.parseInt(dealer_health_text.getText());
				health += 1;
				dealer_health_text.setText(String.valueOf(health));
				//
				point -= 1;
				dealer_point.setText(String.valueOf(point));
			}else if (source == dealer_health_down) {
				int health = Integer.parseInt(dealer_health_text.getText());
				health -= 1;
				dealer_health_text.setText(String.valueOf(health));
				//
				point += 1;
				dealer_point.setText(String.valueOf(point));
			}
			//wizard listener
			if (source == wizard_power_up) {							
				int power = Integer.parseInt(wizard_power_text.getText());
				power += 1;
				wizard_power_text.setText(String.valueOf(power));
				//
				point -= 1;
				wizard_point.setText(String.valueOf(point));
			}else if (source == wizard_power_down) {
				int power = Integer.parseInt(wizard_power_text.getText());
				power -= 1;
				wizard_power_text.setText(String.valueOf(power));
				//
				point += 1;
				wizard_point.setText(String.valueOf(point));
			}else if (source == wizard_magic_up) {
				int magic = Integer.parseInt(wizard_magic_text.getText());
				magic += 1;
				wizard_magic_text.setText(String.valueOf(magic));
				//
				point -= 1;
				wizard_point.setText(String.valueOf(point));
			}else if (source == wizard_magic_down) {
				int magic = Integer.parseInt(wizard_magic_text.getText());
				magic -= 1;
				wizard_magic_text.setText(String.valueOf(magic));
				//
				point += 1;
				wizard_point.setText(String.valueOf(point));
			}else if (source == wizard_defense_up) {
				int defense = Integer.parseInt(wizard_defense_text.getText());
				defense += 1;
				wizard_defense_text.setText(String.valueOf(defense));
				//
				point -= 1;
				wizard_point.setText(String.valueOf(point));
			}else if (source == wizard_defense_down) {
				int defense = Integer.parseInt(wizard_defense_text.getText());
				defense -= 1;
				wizard_defense_text.setText(String.valueOf(defense));
				//
				point += 1;
				wizard_point.setText(String.valueOf(point));
			}else if (source == wizard_health_up) {
				int health = Integer.parseInt(wizard_health_text.getText());
				health += 1;
				wizard_health_text.setText(String.valueOf(health));
				//
				point -= 1;
				wizard_point.setText(String.valueOf(point));
			}else if (source == wizard_health_down) {
				int health = Integer.parseInt(wizard_health_text.getText());
				health -= 1;
				wizard_health_text.setText(String.valueOf(health));
				//
				point += 1;
				wizard_point.setText(String.valueOf(point));
			}
			//healer listener
			if (source == healer_power_up) {
				//공격력 업
				int power = Integer.parseInt(healer_power_text.getText());
				power += 1;
				healer_power_text.setText(String.valueOf(power));
				//남은 포인트
				point -= 1;
				healer_point.setText(String.valueOf(point));
			}else if (source == healer_power_down) {
				//공격력 다운
				int power = Integer.parseInt(healer_power_text.getText());
				power -= 1;
				healer_power_text.setText(String.valueOf(power));
				//남은 포인트
				point += 1;
				healer_point.setText(String.valueOf(point));
			}else if (source == healer_magic_up) {
				//마력 업
				int magic = Integer.parseInt(healer_magic_text.getText());
				magic += 1;
				healer_magic_text.setText(String.valueOf(magic));
				//남은 포인트
				point -= 1;
				healer_point.setText(String.valueOf(point));
			}else if (source == healer_magic_down) {
				//마력 다운
				int magic = Integer.parseInt(healer_magic_text.getText());
				magic -= 1;
				healer_magic_text.setText(String.valueOf(magic));
				//
				point += 1;
				healer_point.setText(String.valueOf(point));
			}else if (source == healer_defense_up) {
				//방어력 업
				int defense = Integer.parseInt(healer_defense_text.getText());
				defense += 1;
				healer_defense_text.setText(String.valueOf(defense));
				//
				point -= 1;
				healer_point.setText(String.valueOf(point));
			}else if (source == healer_defense_down) {
				//방어력 다운
				int defense = Integer.parseInt(healer_defense_text.getText());
				defense -= 1;
				healer_defense_text.setText(String.valueOf(defense));
				//
				point += 1;
				healer_point.setText(String.valueOf(point));
			}else if (source == healer_health_up) {
				//체력 업
				int health = Integer.parseInt(healer_health_text.getText());
				health += 1;							
				healer_health_text.setText(String.valueOf(health));
				//
				point -= 1;
				healer_point.setText(String.valueOf(point));
			}else if (source == healer_health_down) {
				//체력 다운
				int health = Integer.parseInt(healer_health_text.getText());
				health -= 1;
				healer_health_text.setText(String.valueOf(health));
				//
				point += 1;
				healer_point.setText(String.valueOf(point));
			}
			//--------------------------------------------------------up, down visible
			if (point == 0) {
				tanker_power_up.setVisible(false);
				tanker_magic_up.setVisible(false);
				tanker_defense_up.setVisible(false);
				tanker_health_up.setVisible(false);
				
				dealer_power_up.setVisible(false);
				dealer_magic_up.setVisible(false);
				dealer_defense_up.setVisible(false);
				dealer_health_up.setVisible(false);
				
				wizard_power_up.setVisible(false);
				wizard_magic_up.setVisible(false);
				wizard_defense_up.setVisible(false);
				wizard_health_up.setVisible(false);
				
				healer_power_up.setVisible(false);
				healer_magic_up.setVisible(false);
				healer_defense_up.setVisible(false);
				healer_health_up.setVisible(false);
			}else {
				tanker_power_up.setVisible(true);
				tanker_magic_up.setVisible(true);
				tanker_defense_up.setVisible(true);
				tanker_health_up.setVisible(true);
				
				dealer_power_up.setVisible(true);
				dealer_magic_up.setVisible(true);
				dealer_defense_up.setVisible(true);
				dealer_health_up.setVisible(true);
				
				wizard_power_up.setVisible(true);
				wizard_magic_up.setVisible(true);
				wizard_defense_up.setVisible(true);
				wizard_health_up.setVisible(true);
				
				healer_power_up.setVisible(true);
				healer_magic_up.setVisible(true);
				healer_defense_up.setVisible(true);
				healer_health_up.setVisible(true);
			}
			if (point == 20) {
				tanker_power_down.setVisible(false);
				tanker_magic_down.setVisible(false);
				tanker_defense_down.setVisible(false);
				tanker_health_down.setVisible(false);
				
				dealer_power_down.setVisible(false);
				dealer_magic_down.setVisible(false);
				dealer_defense_down.setVisible(false);
				dealer_health_down.setVisible(false);
				
				wizard_power_down.setVisible(false);
				wizard_magic_down.setVisible(false);
				wizard_defense_down.setVisible(false);
				wizard_health_down.setVisible(false);
				
				healer_power_down.setVisible(false);
				healer_magic_down.setVisible(false);
				healer_defense_down.setVisible(false);
				healer_health_down.setVisible(false);
			}else {
				tanker_power_down.setVisible(true);
				tanker_magic_down.setVisible(true);
				tanker_defense_down.setVisible(true);
				tanker_health_down.setVisible(true);
				
				dealer_power_down.setVisible(true);
				dealer_magic_down.setVisible(true);
				dealer_defense_down.setVisible(true);
				dealer_health_down.setVisible(true);
				
				wizard_power_down.setVisible(true);
				wizard_magic_down.setVisible(true);
				wizard_defense_down.setVisible(true);
				wizard_health_down.setVisible(true);
				
				healer_power_down.setVisible(true);
				healer_magic_down.setVisible(true);
				healer_defense_down.setVisible(true);
				healer_health_down.setVisible(true);
			}
			
			// ------------------------------------------------------------------------------------result button
			// tanker result button
			if (source == tanker_result) {
				//데이터 베이스
				String user_id = loginVo.getUser_id();
				String user_name = loginVo.getUser_name();
				String tanker_power = tanker_power_text.getText();
				int tanker_power_int = Integer.parseInt(tanker_power);
				String tanker_magic = tanker_magic_text.getText();
				int tanker_magic_int = Integer.parseInt(tanker_magic);
				String tanker_defense = tanker_defense_text.getText();
				int tanker_defense_int = Integer.parseInt(tanker_defense);
				String tanker_health = tanker_health_text.getText();
				int tanker_health_int = Integer.parseInt(tanker_health);
				
				UserCharacterVo tankerResult = new UserCharacterVo(user_id, user_name, "tanker", tanker_power_int, tanker_magic_int, tanker_defense_int, tanker_health_int);
				characterDao.updateCharacterInfo(tankerResult);
				//Point
				point = Integer.parseInt(tanker_point.getText());
			}
			// dealer result button
			if (source == dealer_result) {
				//데이터 베이스
				String user_id = loginVo.getUser_id();
				String user_name = loginVo.getUser_name();
				String dealer_power = dealer_power_text.getText();
				int dealer_power_int = Integer.parseInt(dealer_power);
				String dealer_magic = dealer_magic_text.getText();
				int dealer_magic_int = Integer.parseInt(dealer_magic);
				String dealer_defense = dealer_defense_text.getText();
				int dealer_defense_int = Integer.parseInt(dealer_defense);
				String dealer_health = dealer_health_text.getText();
				int dealer_health_int = Integer.parseInt(dealer_health);
				
				UserCharacterVo dealerResult = new UserCharacterVo(user_id, user_name, "dealer", dealer_power_int, dealer_magic_int, dealer_defense_int, dealer_health_int);
				characterDao.updateCharacterInfo(dealerResult);
				//Point
				point = Integer.parseInt(dealer_point.getText());
			}
			// wizard result button
			if (source == wizard_result) {
				//데이터 베이스
				String user_id = loginVo.getUser_id();
				String user_name = loginVo.getUser_name();
				String wizard_power = wizard_power_text.getText();
				int wizard_power_int = Integer.parseInt(wizard_power);
				String wizard_magic = wizard_magic_text.getText();
				int wizard_magic_int = Integer.parseInt(wizard_magic);
				String wizard_defense = wizard_defense_text.getText();
				int wizard_defense_int = Integer.parseInt(wizard_defense);
				String wizard_health = wizard_health_text.getText();
				int wizard_health_int = Integer.parseInt(wizard_health);
				
				UserCharacterVo wizardResult = new UserCharacterVo(user_id, user_name, "wizard", wizard_power_int, wizard_magic_int, wizard_defense_int, wizard_health_int);
				characterDao.updateCharacterInfo(wizardResult);
				//Point
				point = Integer.parseInt(wizard_point.getText());
			}
			// healer result button
			if (source == healer_result) {
				//데이터 베이스
				String user_id = loginVo.getUser_id();
				String user_name = loginVo.getUser_name();
				String healer_power = healer_power_text.getText();
				int healer_power_int = Integer.parseInt(healer_power);
				String healer_magic = healer_magic_text.getText();
				int healer_magic_int = Integer.parseInt(healer_magic);
				String healer_defense = healer_defense_text.getText();
				int healer_defense_int = Integer.parseInt(healer_defense);
				String healer_health = healer_health_text.getText();
				int healer_health_int = Integer.parseInt(healer_health);
				
				UserCharacterVo healerResult = new UserCharacterVo(user_id, user_name, "healer", healer_power_int, healer_magic_int, healer_defense_int, healer_health_int);
				characterDao.updateCharacterInfo(healerResult);
				//Point
				point = Integer.parseInt(healer_point.getText());
			}
		}
	}
}
