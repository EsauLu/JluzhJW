package com.jluzh.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jluzh.control.Controller;
import com.jluzh.jw.blean.User;

/**
 * 登陆窗口
 * @author EsauLu
 *
 */
public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel m_account_lable;
	private JLabel m_passwd_lable;
	private JLabel m_check_lable;

	private JTextField m_account_field;
	private JPasswordField m_passwd_field;
	private JTextField m_check_field;

	private JLabel m_check_img_lable;
	private JLabel m_check_chang_lable;
	
	private JButton m_exit_btn;
	private JButton m_login_btn;
	
	private Controller mController;
	
	public LoginFrame(Controller controller) {
		// TODO Auto-generated constructor stub
		this.mController=controller;
		init();		
		
	}
	
	private void init() {
		// TODO Auto-generated method stub
		
		initData();
		initUI();
		setBtnListener();
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension srceen=kit.getScreenSize();
		Dimension size=new Dimension(getPreferredSize().width+100, getPreferredSize().height+50);
		
		this.setTitle("登录");
		this.setSize(size);
		this.setLocation((srceen.width-size.width)/2, (srceen.height-size.height)/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void initUI() {
		// TODO Auto-generated method stub
		
		this.setLayout(new GridBagLayout());
		
		JPanel container=new JPanel();
		GridBagLayout layout=new GridBagLayout();
		GridBagConstraints constraints=new GridBagConstraints();
		container.setLayout(layout);
		
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.anchor=GridBagConstraints.EAST;
		constraints.insets=new Insets(20, 20, 0, 0);
		layout.setConstraints(m_account_lable, constraints);
		container.add(m_account_lable);
		
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.anchor=GridBagConstraints.WEST;
		constraints.insets=new Insets(20, 0, 0, 20);
		layout.setConstraints(m_account_field, constraints);
		container.add(m_account_field);
		
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.anchor=GridBagConstraints.EAST;
		constraints.insets=new Insets(5, 20, 0, 0);
		layout.setConstraints(m_passwd_lable, constraints);
		container.add(m_passwd_lable);
		
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.anchor=GridBagConstraints.WEST;
		constraints.insets=new Insets(5, 0, 0, 20);
		layout.setConstraints(m_passwd_field, constraints);
		container.add(m_passwd_field);
		
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.anchor=GridBagConstraints.EAST;
		constraints.insets=new Insets(5, 20, 10, 0);
		layout.setConstraints(m_check_lable, constraints);
		container.add(m_check_lable);
		
		constraints.gridx=1;
		constraints.gridy=2;
		constraints.anchor=GridBagConstraints.WEST;
		constraints.insets=new Insets(5, 0, 0, 20);
		layout.setConstraints(m_check_field, constraints);
		container.add(m_check_field);
		
		JPanel check_panel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		check_panel.add(m_check_img_lable);
		check_panel.add(m_check_chang_lable);
		constraints.gridx=1;
		constraints.gridy=3;
		constraints.gridwidth=2;
		constraints.anchor=GridBagConstraints.WEST;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.insets=new Insets(5, 0, 0, 20);
		layout.setConstraints(check_panel, constraints);
		container.add(check_panel);
		
		JPanel btn_panel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
		btn_panel.add(m_exit_btn);
		btn_panel.add(m_login_btn);
		
		constraints.gridx=0;
		constraints.gridy=4;
		constraints.gridwidth=2;
		constraints.anchor=GridBagConstraints.WEST;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.insets=new Insets(10, 20, 20, 20);
		layout.setConstraints(btn_panel, constraints);
		container.add(btn_panel);
		
		this.add(container);

	}
	
	private void initData() {
		// TODO Auto-generated method stub
		
		m_account_lable=new JLabel("用户名：");
		m_passwd_lable=new JLabel("密码：");
		m_check_lable=new JLabel("验证码：");

		m_account_field=new JTextField("04140814",20);
		m_passwd_field=new JPasswordField("luyishao19931223",20);
		m_check_field=new JTextField(20);
		
		BufferedImage bim=new BufferedImage(72, 27, BufferedImage.TYPE_INT_RGB);
		bim.getGraphics().fillRect(0, 0, 72, 27);
		m_check_img_lable=new JLabel(new ImageIcon(bim));
		m_check_chang_lable=new JLabel("换一张");
		
		m_exit_btn=new JButton("退出");
		m_login_btn=new JButton("登录");
	}
	
	/**
	 * 组件的事件监听器
	 */
	private void setBtnListener() {
		// TODO Auto-generated method stub
		m_exit_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		m_login_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				User user=new User();
				user.setName(m_account_field.getText());
				user.setPasswd(m_passwd_field.getText());
				user.setCheck(m_check_field.getText());	
				m_check_field.setText("");
				if(mController.login(user)){
					LoginFrame.this.setVisible(false);
					mController.openMainFream();
				}else{
					JOptionPane.showMessageDialog(LoginFrame.this, mController.getErrorMessege());
					mController.getCheckImg();
				}
			}
		});
		m_check_chang_lable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				showCheckImg();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				m_check_chang_lable.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				m_check_chang_lable.setForeground(Color.black);
			}
		});
	}
	
	/**
	 * 更换验证码
	 */
	public void showCheckImg() {
		m_check_img_lable.setIcon(new ImageIcon(mController.getCheckImg()));
	}
	
}

















































