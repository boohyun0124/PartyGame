package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.CharacterDao;
import dao.MonsterDao;
import vo.MonsterVo;
import vo.UserCharacterVo;
import vo.UserVo;

@SuppressWarnings("serial")
public class Stage1 extends JFrame{
	Container c = getContentPane();
	//�ǳ�
	JPanel northPanel = new JPanel();
	screenPanel screen = new screenPanel();
	JPanel healerPanel = new JPanel();
	JPanel wizardPanel = new JPanel();
	JPanel dealerPanel = new JPanel();
	JPanel tankerPanel = new JPanel();
	JPanel monsterPanel = new JPanel();
	
	//��� �̹���
	Image Background = new ImageIcon("images/stage1Background.jpg").getImage();
	//ĳ���� �̹���
	Image tanker_image = new ImageIcon("images/tanker.png").getImage();
	Image dealer_image = new ImageIcon("images/dealer.png").getImage();
	Image wizard_image = new ImageIcon("images/wizard.png").getImage();
	Image healer_image = new ImageIcon("images/healer.png").getImage();

	//���� �̹���
	Image monsterPikachu_image = new ImageIcon("images/SpongebobAndPatrickFat.jpg").getImage();	
	//������
	KeyESC listener = new KeyESC();
	buttonAction buttonActionlistener = new buttonAction();
	
	//Healer
	JLabel healer_name = new JLabel("Healer");
	JButton healer_attack = new JButton("����");
	JButton healer_skill1 = new JButton("HP����");
	JButton healer_skill2 = new JButton("MP����");
	JButton healer_skill3 = new JButton("�̱���");
	//Wizard
	JLabel wizard_name = new JLabel("Wizard");
	JButton wizard_attack = new JButton("�⺻ ����");
	JButton wizard_skill1 = new JButton("��*2+��*2+ü");
	JButton wizard_skill2 = new JButton("��*5");
	JButton wizard_skill3 = new JButton("�̱���");
	//Dealer
	JLabel dealer_name = new JLabel("Dealer");
	JButton dealer_attack = new JButton("�⺻ ����");
	JButton dealer_skill1 = new JButton("��*2+��*3");
	JButton dealer_skill2 = new JButton("��*2+ü");
	JButton dealer_skill3 = new JButton("��*8");
	//Tanker
	JLabel tanker_name = new JLabel("Tanker");
	JButton tanker_attack = new JButton("�⺻ ����");
	JButton tanker_skill1 = new JButton("��*5 ȸ��");
	JButton tanker_skill2 = new JButton("��*2");
	JButton tanker_skill3 = new JButton("�̱���");
	//Monster
	JLabel monsterLabel = new JLabel("��������� ���̰� �ú� �̴ϴ�.");
	JButton monster_attack = new JButton("Ȯ��");
	//���� ���� ���� ����
	String tanker_hp = "";
	String dealer_hp = "";
	String wizard_hp = "";
	String healer_hp = "";
	String tanker_mp = "";
	String dealer_mp = "";
	String wizard_mp = "";
	String healer_mp = "";
	
	//�� ��
	String SpongebobAndPatrickFat_hp = "";
	
	//NorthPanel �ԷµǴ� ��
	String time = "0";
	JLabel timer = new JLabel();
	JLabel ESC_info = new JLabel("ESC�� ������ �������ͽ� â�� ���ɴϴ�.");
	
	//getInstance
	CharacterDao characterDao = CharacterDao.getInstance();
	UserCharacterVo characterVo = new UserCharacterVo();
	MonsterDao monsterDao = MonsterDao.getInstance();
	MonsterVo monsterVo = new MonsterVo();
	
	//�α��� �� ����
	UserVo loginVo;
	
	//drawStringSkill--------------------------------------------------------------------------------------------
	attack_effect attack_Ef = new attack_effect();
	heal_effect heal_Ef = new heal_effect();
	wizard_skill1_effect wizard_skill1_Ef = new wizard_skill1_effect();
	wizard_skill2_effect wizard_skill2_Ef = new wizard_skill2_effect();
	dealer_skill1_effect dealer_skill1_Ef = new dealer_skill1_effect();
	dealer_skill2_effect dealer_skill2_Ef = new dealer_skill2_effect();
		
	//������ ���̽����� Monster ���� �ҷ�����
	MonsterVo songVo = monsterDao.SpongebobAndPatrickFat_Info(monsterVo);
	
	public Stage1(UserVo loginVo) {
		this.loginVo = loginVo;
		characterVo.setUser_id(loginVo.getUser_id());
		characterVo.setUser_name(loginVo.getUser_name());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("��Ƽ ���");
		setStats();
		setMonsterStats();
		setNorthpanel();
		setSouthpanel();
		setScreen();
		setSize(1280, 720);
		setVisible(true);
		
		screen.requestFocus();
	}


	private void setMonsterStats() {
		//��ī�� ����
		int SpongebobAndPatrickFat_health_int = songVo.getAbility_health();
			//HP
			int SpongebobAndPatrickFat_hp_int = SpongebobAndPatrickFat_health_int*10;
			SpongebobAndPatrickFat_hp = String.valueOf(SpongebobAndPatrickFat_hp_int);
	}

	public void setStats() {
		//������ ���̽��� ������ �����;� ��
		UserCharacterVo tankerVo = characterDao.TankerInfo(characterVo);
		UserCharacterVo dealerVo = characterDao.DealerInfo(characterVo);
		UserCharacterVo wizardVo = characterDao.WizardInfo(characterVo);
		UserCharacterVo healerVo = characterDao.HealerInfo(characterVo);
		//��Ŀ ����
		int tanker_magic_int = tankerVo.getAbility_magic();
		int tanker_health_int = tankerVo.getAbility_health();
			//HP
			int tanker_hp_int = tanker_health_int*10;
			tanker_hp = String.valueOf(tanker_hp_int);
			//MP
			int tanker_mp_int = tanker_magic_int*5;
			tanker_mp = String.valueOf(tanker_mp_int);
		
		//���� ����		
		int dealer_magic_int = dealerVo.getAbility_magic();
		int dealer_health_int = dealerVo.getAbility_health();
			//HP
			int dealer_hp_int = dealer_health_int*10;
			dealer_hp = String.valueOf(dealer_hp_int);
			//MP
			int dealer_mp_int = dealer_magic_int*5;
			dealer_mp = String.valueOf(dealer_mp_int);
		//������ ����		
		int wizard_magic_int = wizardVo.getAbility_magic();
		int wizard_health_int = wizardVo.getAbility_health();
			//HP
			int wizard_hp_int = wizard_health_int*10;
			wizard_hp = String.valueOf(wizard_hp_int);
			//MP
			int wizard_mp_int = wizard_magic_int*5;
			wizard_mp = String.valueOf(wizard_mp_int);
		//���� ����
		int healer_magic_int = healerVo.getAbility_magic();
		int healer_health_int = healerVo.getAbility_health();
			//HP
			int healer_hp_int = healer_health_int*10;
			healer_hp = String.valueOf(healer_hp_int);
			//MP
			int healer_mp_int = healer_magic_int*5;
			healer_mp = String.valueOf(healer_mp_int);
	}
	private void setNorthpanel() {
		timer.setText(time);
		northPanel.add(ESC_info);
		northPanel.add(timer);
		c.add(northPanel, BorderLayout.NORTH);
	}
	private void setScreen() {
		screen.setLayout(null);
		screen.addKeyListener(listener);
		c.add(screen);
	}
	
	private void setSouthpanel() {
		//������ ����
		healer_attack.addActionListener(buttonActionlistener);
		healer_skill1.addActionListener(buttonActionlistener);
		healer_skill2.addActionListener(buttonActionlistener);
		healer_skill3.addActionListener(buttonActionlistener);
		
		wizard_attack.addActionListener(buttonActionlistener);
		wizard_skill1.addActionListener(buttonActionlistener);
		wizard_skill2.addActionListener(buttonActionlistener);
		wizard_skill3.addActionListener(buttonActionlistener);
		
		dealer_attack.addActionListener(buttonActionlistener);
		dealer_skill1.addActionListener(buttonActionlistener);
		dealer_skill2.addActionListener(buttonActionlistener);
		dealer_skill3.addActionListener(buttonActionlistener);
		
		tanker_attack.addActionListener(buttonActionlistener);
		tanker_skill1.addActionListener(buttonActionlistener);
		tanker_skill2.addActionListener(buttonActionlistener);
		tanker_skill3.addActionListener(buttonActionlistener);
		
		monster_attack.addActionListener(buttonActionlistener);
				
		//ȭ�� �߰�
		healerPanel.add(healer_name);
		healerPanel.add(healer_attack);
		healerPanel.add(healer_skill1);
		healerPanel.add(healer_skill2);
		healerPanel.add(healer_skill3);
		
		wizardPanel.add(wizard_name);
		wizardPanel.add(wizard_attack);
		wizardPanel.add(wizard_skill1);
		wizardPanel.add(wizard_skill2);
		wizardPanel.add(wizard_skill3);
		
		dealerPanel.add(dealer_name);
		dealerPanel.add(dealer_attack);
		dealerPanel.add(dealer_skill1);
		dealerPanel.add(dealer_skill2);
		dealerPanel.add(dealer_skill3);
		
		tankerPanel.add(tanker_name);
		tankerPanel.add(tanker_attack);
		tankerPanel.add(tanker_skill1);
		tankerPanel.add(tanker_skill2);
		tankerPanel.add(tanker_skill3);
		
		monsterPanel.add(monsterLabel);
		monsterPanel.add(monster_attack);
		c.add(wizardPanel, BorderLayout.SOUTH);			
		c.add(dealerPanel, BorderLayout.SOUTH);			
		c.add(tankerPanel, BorderLayout.SOUTH);			
		c.add(monsterPanel, BorderLayout.SOUTH);
		wizardPanel.setVisible(false);
		dealerPanel.setVisible(false);
		tankerPanel.setVisible(false);
		monsterPanel.setVisible(false);
		c.add(healerPanel, BorderLayout.SOUTH);			
	}
	class buttonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			//������ ��������
			UserCharacterVo tankerVo = characterDao.TankerInfo(characterVo);
			UserCharacterVo dealerVo = characterDao.DealerInfo(characterVo);
			UserCharacterVo wizardVo = characterDao.WizardInfo(characterVo);
			UserCharacterVo healerVo = characterDao.HealerInfo(characterVo);
			//ĳ���� HP, ����
			int tanker_hp_int = Integer.parseInt(tanker_hp);
			int dealer_hp_int = Integer.parseInt(dealer_hp);
			int wizard_hp_int = Integer.parseInt(wizard_hp);
			int healer_hp_int = Integer.parseInt(healer_hp);
			int tanker_defense_int = tankerVo.getAbility_defense();
			int dealer_defense_int = dealerVo.getAbility_defense();
			int wizard_defense_int = wizardVo.getAbility_defense();
			int healer_defense_int = healerVo.getAbility_defense();
			//���� ����
			int pikachu_hp_int = Integer.parseInt(SpongebobAndPatrickFat_hp); //��ī�� HP
			int pikachu_defense_int = songVo.getAbility_Defense(); //��ī�� ����
			int pikachu_power_int = songVo.getAbility_power(); //��ī�� ���ݷ�
			//timer
			
			//healer �ൿ ��ư
			if (source == healer_attack) { //�⺻ ����
				int healer_power_int = healerVo.getAbility_power();				
				int healer_attack_result = pikachu_hp_int - (healer_power_int - pikachu_defense_int);
				SpongebobAndPatrickFat_hp = String.valueOf(healer_attack_result);
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//effect
				screen.add(attack_Ef);
				attack_Ef.setVisible(true);
				Thread thr = new Thread(new attack_effect());
				thr.start();				
				//ȭ�� ����
				screen.setVisible(false);
				screen.setVisible(true);
				//���� �ǳ�
				healerPanel.setVisible(false);
				c.add(wizardPanel, BorderLayout.SOUTH);
				wizardPanel.setVisible(true);
				
			}else if (source == healer_skill1) { //��ų1
				int healer_magic_int = healerVo.getAbility_magic();
				//
				int tanker_heal_result = tanker_hp_int + (healer_magic_int*2);
				int dealer_heal_result = dealer_hp_int + (healer_magic_int*2);
				int wizard_heal_result = wizard_hp_int + (healer_magic_int*2);
				int healer_heal_result = healer_hp_int + (healer_magic_int*2);
				//
				tanker_hp = String.valueOf(tanker_heal_result);
				dealer_hp = String.valueOf(dealer_heal_result);
				wizard_hp = String.valueOf(wizard_heal_result);
				healer_hp = String.valueOf(healer_heal_result);
				//effect
				screen.add(heal_Ef);
				heal_Ef.setVisible(true);
				Thread thr = new Thread(new heal_effect());
				thr.start();
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				healerPanel.setVisible(false);
				c.add(wizardPanel, BorderLayout.SOUTH);
				wizardPanel.setVisible(true);
			}else if (source == healer_skill2) { //��ų2
				int healer_magic_int = healerVo.getAbility_magic();
				int tanker_mp_int = Integer.parseInt(tanker_mp);
				int dealer_mp_int = Integer.parseInt(dealer_mp);
				int wizard_mp_int = Integer.parseInt(wizard_mp);
				int healer_mp_int = Integer.parseInt(healer_mp);
				//
				int tanker_mpheal_result = tanker_mp_int + (healer_magic_int*2);
				int dealer_mpheal_result = dealer_mp_int + (healer_magic_int*2);
				int wizard_mpheal_result = wizard_mp_int + (healer_magic_int*2);
				int healer_mpheal_result = healer_mp_int + (healer_magic_int*2);
				//effect
				screen.add(heal_Ef);
				heal_Ef.setVisible(true);
				Thread thr = new Thread(new heal_effect());
				thr.start();
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//
				tanker_mp = String.valueOf(tanker_mpheal_result);
				dealer_mp = String.valueOf(dealer_mpheal_result);
				wizard_mp = String.valueOf(wizard_mpheal_result);
				healer_mp = String.valueOf(healer_mpheal_result);
				//
				screen.setVisible(false);
				screen.setVisible(true);
				healerPanel.setVisible(false);
				c.add(wizardPanel, BorderLayout.SOUTH);
				wizardPanel.setVisible(true);
			}else if (source == healer_skill3) { //��ų3
				
//				healerPanel.setVisible(false);
//				wizardPanel.setVisible(true);
			}
			//wizard �ൿ ��ư
			if (source == wizard_attack) { //�⺻����
				int wizard_power_int = wizardVo.getAbility_power();				
				int wizard_attack_result = pikachu_hp_int - (wizard_power_int - pikachu_defense_int);
				SpongebobAndPatrickFat_hp = String.valueOf(wizard_attack_result);
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//effect
				screen.add(attack_Ef);
				attack_Ef.setVisible(true);
				Thread thr = new Thread(new attack_effect());
				thr.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				wizardPanel.setVisible(false);
				c.add(dealerPanel, BorderLayout.SOUTH);
				dealerPanel.setVisible(true);
				
			}else if (source == wizard_skill1) { //��ų1
				int wizard_magic_int = wizardVo.getAbility_magic();
				int wizard_health_int = wizardVo.getAbility_health();
				int wizard_attack_result = pikachu_hp_int - ((wizard_magic_int*2)+(wizard_defense_int*2)+wizard_health_int);
				SpongebobAndPatrickFat_hp = String.valueOf(wizard_attack_result);
				//effect
				screen.add(wizard_skill1_Ef);
				wizard_skill1_Ef.setVisible(true);
				Thread thr = new Thread(new wizard_skill1_effect());
				thr.start();
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				wizardPanel.setVisible(false);
				c.add(dealerPanel, BorderLayout.SOUTH);
				dealerPanel.setVisible(true);
				
			}else if (source == wizard_skill2) { //��ų2
				int wizard_magic_int = wizardVo.getAbility_magic();
				int wizard_attack_result = pikachu_hp_int - (wizard_magic_int*5);
				SpongebobAndPatrickFat_hp = String.valueOf(wizard_attack_result);
				//effect
				screen.add(wizard_skill2_Ef);
				wizard_skill2_Ef.setVisible(true);
				Thread thr = new Thread(new wizard_skill2_effect());
				thr.start();
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				wizardPanel.setVisible(false);
				c.add(dealerPanel, BorderLayout.SOUTH);
				dealerPanel.setVisible(true);
				
			}else if (source == wizard_skill3) { //��ų3
//				wizardPanel.setVisible(false);
//				dealerPanel.setVisible(true);
			}
			//dealer �ൿ ��ư
			if (source == dealer_attack) { //�⺻ ����
				int dealer_power_int = dealerVo.getAbility_power();
				int dealer_attack_result = pikachu_hp_int - (dealer_power_int - pikachu_defense_int);
				SpongebobAndPatrickFat_hp = String.valueOf(dealer_attack_result);
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//effect
				screen.add(attack_Ef);
				attack_Ef.setVisible(true);
				Thread thr = new Thread(new attack_effect());
				thr.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				dealerPanel.setVisible(false);
				c.add(tankerPanel, BorderLayout.SOUTH);
				tankerPanel.setVisible(true);
				
			}else if (source == dealer_skill1) { //��ų1
				int dealer_power_int = dealerVo.getAbility_power();
				int dealer_magic_int = dealerVo.getAbility_magic();
				int dealer_attack_result = pikachu_hp_int - ((dealer_power_int*2) + (dealer_magic_int*3) - pikachu_defense_int);
				SpongebobAndPatrickFat_hp = String.valueOf(dealer_attack_result);				
				//effect
				screen.add(dealer_skill1_Ef);
				dealer_skill1_Ef.setVisible(true);
				Thread thre = new Thread(new dealer_skill1_effect());
				thre.start();
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				dealerPanel.setVisible(false);
				c.add(tankerPanel, BorderLayout.SOUTH);
				tankerPanel.setVisible(true);
				
			}else if (source == dealer_skill2) { //��ų2
				int dealer_power_int = dealerVo.getAbility_power();
				int dealer_health_int = dealerVo.getAbility_health();
				int dealer_attack_result = pikachu_hp_int - ((dealer_power_int*2)+dealer_health_int - pikachu_defense_int);
				SpongebobAndPatrickFat_hp = String.valueOf(dealer_attack_result);				
				//effect
				screen.add(dealer_skill2_Ef);
				dealer_skill2_Ef.setVisible(true);
				Thread thre = new Thread(new dealer_skill2_effect());
				thre.start();
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				dealerPanel.setVisible(false);
				c.add(tankerPanel, BorderLayout.SOUTH);
				tankerPanel.setVisible(true);
			}else if (source == dealer_skill3) { //��ų3
				int dealer_power_int = dealerVo.getAbility_power();
				int dealer_attack_result = pikachu_hp_int - ((dealer_power_int*8) - pikachu_defense_int);
				SpongebobAndPatrickFat_hp = String.valueOf(dealer_attack_result);
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				dealerPanel.setVisible(false);
				c.add(tankerPanel, BorderLayout.SOUTH);
				tankerPanel.setVisible(true);
				
			}
			//tanker �ൿ ��ư
			if (source == tanker_attack) { //�⺻ ����
				int tanker_power_int = tankerVo.getAbility_power();
				int tanker_attack_result = pikachu_hp_int - (tanker_power_int - pikachu_defense_int);
				SpongebobAndPatrickFat_hp = String.valueOf(tanker_attack_result);
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//effect
				screen.add(attack_Ef);
				attack_Ef.setVisible(true);
				Thread thr = new Thread(new attack_effect());
				thr.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				tankerPanel.setVisible(false);
				c.add(monsterPanel, BorderLayout.SOUTH);
				monsterPanel.setVisible(true);
				
			}else if (source == tanker_skill1) { //��ų1
				int tanker_magic_int = tankerVo.getAbility_magic();
				int tanker_heal_result = tanker_hp_int + (tanker_magic_int*5);
				tanker_hp = String.valueOf(tanker_heal_result);
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				tankerPanel.setVisible(false);
				c.add(monsterPanel, BorderLayout.SOUTH);
				monsterPanel.setVisible(true);
				
			}else if (source == tanker_skill2) { //��ų2
				int tanker_attack_result = pikachu_hp_int - ((tanker_defense_int*2) - pikachu_defense_int);
				SpongebobAndPatrickFat_hp = String.valueOf(tanker_attack_result);
				//Ÿ�̸�
				timer.setText(time);
				northPanel.setVisible(false);
				northPanel.setVisible(true);
				Thread th = new Thread(new effect_timer());
				th.start();
				//
				screen.setVisible(false);
				screen.setVisible(true);
				tankerPanel.setVisible(false);
				c.add(monsterPanel, BorderLayout.SOUTH);
				monsterPanel.setVisible(true);
				
			}else if (source == tanker_skill3) { //��ų3
//				tankerPanel.setVisible(false);
//				monsterPanel.setVisible(true);
			}
			//���� �ൿ
			if (source == monster_attack) {
				int Attack = (int)(Math.random()*6);
				if (pikachu_hp_int <= 0) {
					System.out.println(pikachu_hp_int);
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Ʃ�丮�� ��");
				}
				if (Attack == 0) {
					int monster_attack_tanker = tanker_hp_int - (pikachu_power_int - tanker_defense_int);
					tanker_hp = String.valueOf(monster_attack_tanker);
					//Ÿ�̸�
					timer.setText(time);
					northPanel.setVisible(false);
					northPanel.setVisible(true);
					Thread th = new Thread(new effect_timer());
					th.start();
					//
					monsterPanel.setVisible(false);
					c.add(healerPanel, BorderLayout.SOUTH);
					healerPanel.setVisible(true);
					screen.setVisible(false);
					screen.setVisible(true);
					
				}else if (Attack == 1) {
					int monster_attack_tanker = tanker_hp_int - (pikachu_power_int - tanker_defense_int);
					tanker_hp = String.valueOf(monster_attack_tanker);
					//Ÿ�̸�
					timer.setText(time);
					northPanel.setVisible(false);
					northPanel.setVisible(true);
					Thread th = new Thread(new effect_timer());
					th.start();
					//
					monsterPanel.setVisible(false);
					c.add(healerPanel, BorderLayout.SOUTH);
					healerPanel.setVisible(true);
					screen.setVisible(false);
					screen.setVisible(true);
					//
					if (pikachu_hp_int <= 0) {
						System.out.println(pikachu_hp_int);
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Ʃ�丮�� ��");
					}
				}else if (Attack == 2) {
					int monster_attack_tanker = tanker_hp_int - (pikachu_power_int - tanker_defense_int);
					tanker_hp = String.valueOf(monster_attack_tanker);
					//Ÿ�̸�
					timer.setText(time);
					northPanel.setVisible(false);
					northPanel.setVisible(true);
					Thread th = new Thread(new effect_timer());
					th.start();
					//
					monsterPanel.setVisible(false);
					c.add(healerPanel, BorderLayout.SOUTH);
					healerPanel.setVisible(true);
					screen.setVisible(false);
					screen.setVisible(true);
				}else if (Attack == 3) {
					int monster_attack_dealer = dealer_hp_int - (pikachu_power_int - dealer_defense_int);
					dealer_hp = String.valueOf(monster_attack_dealer);
					//Ÿ�̸�
					timer.setText(time);
					northPanel.setVisible(false);
					northPanel.setVisible(true);
					Thread th = new Thread(new effect_timer());
					th.start();
					//
					monsterPanel.setVisible(false);
					c.add(healerPanel, BorderLayout.SOUTH);
					healerPanel.setVisible(true);
					screen.setVisible(false);
					screen.setVisible(true);
				}else if (Attack == 4) {
					int monster_attack_wizard = wizard_hp_int - (pikachu_power_int - wizard_defense_int);
					wizard_hp = String.valueOf(monster_attack_wizard);
					//Ÿ�̸�
					timer.setText(time);
					northPanel.setVisible(false);
					northPanel.setVisible(true);
					Thread th = new Thread(new effect_timer());
					th.start();
					//
					monsterPanel.setVisible(false);
					c.add(healerPanel, BorderLayout.SOUTH);
					healerPanel.setVisible(true);
					screen.setVisible(false);
					screen.setVisible(true);
				}else if (Attack == 5) {
					int monster_attack_healer = healer_hp_int - (pikachu_power_int - healer_defense_int);
					healer_hp = String.valueOf(monster_attack_healer);
					//Ÿ�̸�
					timer.setText(time);
					northPanel.setVisible(false);
					northPanel.setVisible(true);
					Thread th = new Thread(new effect_timer());
					th.start();
					//
					monsterPanel.setVisible(false);
					c.add(healerPanel, BorderLayout.SOUTH);
					healerPanel.setVisible(true);
					screen.setVisible(false);
					screen.setVisible(true);
				} 
			}
			
		}		
	}
	
	public class screenPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//��� �׸���
			g.drawImage(Background, 0, 0, null);
			//ĳ���� �׸���
			g.drawImage(tanker_image, 500, 500, null);
			g.drawImage(dealer_image, 400, 500, null);
			g.drawImage(wizard_image, 300, 500, null);
			g.drawImage(healer_image, 200, 500, null);
//			//���� �׸���
			g.drawImage(monsterPikachu_image, 750, 200, null);
			//���� ����
			g.setFont(new Font("���� ���", Font.BOLD, 20));
			g.setColor(Color.RED);
			g.drawString("HP:"+tanker_hp, 500, 400);
			g.drawString("HP:"+dealer_hp, 400, 400);
			g.drawString("HP:"+wizard_hp, 300, 400);
			g.drawString("HP:"+healer_hp, 200, 400);
			
			g.drawString("HP:"+SpongebobAndPatrickFat_hp, 850, 150); //�� ��
			g.setColor(Color.BLUE);
			g.drawString("MP:"+tanker_mp, 500, 450);
			g.drawString("MP:"+dealer_mp, 400, 450);
			g.drawString("MP:"+wizard_mp, 300, 450);
			g.drawString("MP:"+healer_mp, 200, 450);
			g.setColor(Color.WHITE);
			g.drawString("Tanker", 500, 610);
			g.drawString("Dealer", 400, 610);
			g.drawString("Wizard", 300, 610);
			g.drawString("Healer", 200, 610);
			//�� �̸�
			g.setColor(Color.BLACK);
			g.fillRect(820, 80, 250, 25);
			g.setColor(Color.WHITE);
			g.drawString("BOSS ��������� ����", 850, 100);
		}
	}
	class effect_timer implements Runnable {
		
		@Override
		public void run() {
			int pikachu_hp_int = Integer.valueOf(SpongebobAndPatrickFat_hp);
			int tanker_hp_int = Integer.valueOf(tanker_hp);
			int dealer_hp_int = Integer.valueOf(dealer_hp);
			int wizard_hp_int = Integer.valueOf(wizard_hp);
			int healer_hp_int = Integer.valueOf(healer_hp);
			int num = Integer.valueOf(timer.getText());
			while(num<1) {
				try {
					Thread.sleep(1000);
					timer.setText(String.valueOf(++num));
					System.out.println(pikachu_hp_int);
					if (pikachu_hp_int <= 0) {
						System.out.println(pikachu_hp_int);
						
						Stage1.this.dispose();
						JOptionPane.showMessageDialog(null, "Stage1 Ŭ����");
					}else if (tanker_hp_int <= 0 || dealer_hp_int <= 0 || wizard_hp_int <= 0 || healer_hp_int <= 0) {
						Stage1.this.dispose();
						JOptionPane.showMessageDialog(null, "���� ����");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}		
	}
	class attack_effect extends JLabel implements Runnable {
		public attack_effect() {
			setIcon(new ImageIcon("images/attack_effect.png"));
			setSize(200, 200);
			setLocation(800, 200);
		}
		@Override
		public void run() {
			int num = Integer.valueOf(timer.getText());
			int n = 1;
			while(num < 1) {//��ų �ൿ
				num = Integer.valueOf(timer.getText()); //�ð��帧 ��������
				try {
					Thread.sleep(500);					
					if (n==1) {
						attack_Ef.setLocation(800, 400);
					}else {
						attack_Ef.setLocation(900, 300);
					}
					n = n*-1;
					
				} catch (InterruptedException e) {				
					e.printStackTrace();
				}
			}
			if (num == 1) {
				attack_Ef.setLocation(800, 200);
				attack_Ef.setVisible(false); //�������
			}
		}		
	}
	class heal_effect extends JLabel implements Runnable {
		public heal_effect() {
			setIcon(new ImageIcon("images/healer_heal.png"));
			setSize(500, 500);
			setLocation(10, 200);
		}
		@Override
		public void run() {
			int num1 = Integer.valueOf(timer.getText());
			int heal_X = heal_Ef.getX();
			int heal_Y = heal_Ef.getY();
			while(num1 < 1) {
				num1 = Integer.valueOf(timer.getText());
				try {
					Thread.sleep(100);
					heal_Y -= 10;
					heal_Ef.setLocation(heal_X, heal_Y);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			if (num1 == 1) {
				heal_Ef.setLocation(10, 200);
				heal_Ef.setVisible(false); //�������
			}
		}
		
	}
	class wizard_skill1_effect extends JLabel implements Runnable {
		public wizard_skill1_effect() {
			setIcon(new ImageIcon("images/wizard_skill1.png"));
			setSize(200, 200);
			setLocation(800, 200);
		}
		@Override
		public void run() {
			int num1 = Integer.valueOf(timer.getText());
			int skill_X = wizard_skill1_Ef.getX();
			int skill_Y = wizard_skill1_Ef.getY();
			int n=1;
			while(num1 < 1) {
				num1 = Integer.valueOf(timer.getText());
				try {
					Thread.sleep(100);
					if (n == 1) {
						wizard_skill1_Ef.setLocation(skill_X+100, skill_Y+100);
					}else {
						wizard_skill1_Ef.setLocation(skill_X, skill_Y+200);
					}
					n = n*-1;
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			if (num1 == 1) {
				wizard_skill1_Ef.setLocation(800, 200);
				wizard_skill1_Ef.setVisible(false); //�������
			}
		}
		
	}
	class wizard_skill2_effect extends JLabel implements Runnable {
		public wizard_skill2_effect() {
			setIcon(new ImageIcon("images/wizard_skill2.png"));
			setSize(600, 500);
			setLocation(500, 100);
		}
		@Override
		public void run() {
			int num1 = Integer.valueOf(timer.getText());
			int skill_X = wizard_skill2_Ef.getX();
			int skill_Y = wizard_skill2_Ef.getY();
			while(num1 < 1) {
				num1 = Integer.valueOf(timer.getText());
				try {
					Thread.sleep(50);
					skill_X += 10;
					wizard_skill2_Ef.setLocation(skill_X, skill_Y);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			if (num1 == 1) {
				wizard_skill2_Ef.setLocation(500, 100);
				wizard_skill2_Ef.setVisible(false); //�������
			}
		}
		
	}
	class dealer_skill1_effect extends JLabel implements Runnable {
		public dealer_skill1_effect() {
			setIcon(new ImageIcon("images/dealer_skill1.png"));
			setSize(500, 500);
			setLocation(400, 250);
		}
		@Override
		public void run() {
			int num1 = Integer.valueOf(timer.getText());
			int skill_X = dealer_skill1_Ef.getX();
			int skill_Y = dealer_skill1_Ef.getY();
			while(num1 < 1) {
				num1 = Integer.valueOf(timer.getText());
				try {
					Thread.sleep(50);
					dealer_skill1_Ef.setLocation(skill_X, skill_Y);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			if (num1 == 1) {
				dealer_skill1_Ef.setVisible(false); //�������
			}
		}
		
	}
	class dealer_skill2_effect extends JLabel implements Runnable {
		public dealer_skill2_effect() {
			setIcon(new ImageIcon("images/dealer_skill2.png"));
			setSize(500, 500);
			setLocation(400, 250);
		}
		@Override
		public void run() {
			int num1 = Integer.valueOf(timer.getText());
			int skill_X = dealer_skill2_Ef.getX();
			int skill_Y = dealer_skill2_Ef.getY();
			while(num1 < 1) {
				num1 = Integer.valueOf(timer.getText());
				try {
					Thread.sleep(50);
					dealer_skill2_Ef.setLocation(skill_X, skill_Y);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			if (num1 == 1) {
				dealer_skill2_Ef.setVisible(false); //�������
			}
		}
		
	}

	class KeyESC implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_ESCAPE:
				tapEx tapex = new tapEx(loginVo);
				tapex.setVisible(true);																						
				break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}
		
	}
}
