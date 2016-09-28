package com.jluzh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.jluzh.control.Controller;
import com.jluzh.jw.blean.Course;
import com.jluzh.jw.blean.CourseTable;

public class MainFream extends JFrame {


//	private JLabel m_stu_name_lablel;
	private JLabel m_stu_id_lablel;
	private JLabel m_stu_academe_lablel;
	private JLabel m_stu_major_lablel;
	private JLabel m_stu_classid_lablel;
	private JLabel m_welcome_label;

//	private JTextField m_stu_name_field;
	private JTextField m_stu_id_field;
	private JTextField m_stu_academe_field;
	private JTextField m_stu_major_field;
	private JTextField m_stu_classid_field;

	private JButton m_course_table_btn;
	private JButton m_personal_info_btn;
	private JButton m_scorce_btn;

	private JComboBox<String > m_xnd_comb;
	private JComboBox<String > m_xqd_comb;
	private JComboBox<String > m_week_comb;
	
	private CourseTablePanel m_courses_table;
	
	private Controller mController;
	
	public MainFream(Controller controller) {
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
		Dimension size=new Dimension(getPreferredSize().width+200, (int)(getPreferredSize().height*1.5));
		
		this.setTitle("正方教务系统");
		this.setSize(size);
		this.setLocation((srceen.width-size.width)/2, (srceen.height-size.height)/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	private void initUI(){

		JPanel top_panel=new JPanel(new GridLayout());
		
		JPanel top_left_panel=new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));
		top_left_panel.add(m_course_table_btn);
		top_left_panel.add(m_scorce_btn);
		top_left_panel.add(m_personal_info_btn);
		
		JPanel top_right_panel=new JPanel(new FlowLayout(FlowLayout.RIGHT,20,20));
		top_right_panel.add(m_welcome_label);

		top_panel.add(top_left_panel,BorderLayout.WEST);
		top_panel.add(top_right_panel,BorderLayout.EAST);
		
		this.add(top_panel,BorderLayout.NORTH);
		
		JPanel content_panel=new JPanel(new BorderLayout(0,20));
		JPanel info_panel=new JPanel(new BorderLayout());
		
		JPanel info_left_panel=new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));		
		JPanel tem=new JPanel();
		tem.add(m_stu_id_lablel);
		tem.add(m_stu_id_field);
		info_left_panel.add(tem);
		
		tem=new JPanel();
		tem.add(m_stu_academe_lablel);
		tem.add(m_stu_academe_field);
		info_left_panel.add(tem);
		
		tem=new JPanel();
		tem.add(m_stu_major_lablel);
		tem.add(m_stu_major_field);
		info_left_panel.add(tem);
		
		tem=new JPanel();
		tem.add(m_stu_classid_lablel);
		tem.add(m_stu_classid_field);
		info_left_panel.add(tem);
		info_panel.add(info_left_panel,BorderLayout.WEST);			

		JPanel info_right_panel=new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));	
		info_right_panel.add(m_xnd_comb);
		info_right_panel.add(new JLabel("学年第"));
		info_right_panel.add(m_xqd_comb);
		info_right_panel.add(new JLabel("学期第"));
		info_right_panel.add(m_week_comb);
		info_right_panel.add(new JLabel("周"));
		info_right_panel.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
		info_panel.add(info_right_panel,BorderLayout.EAST);			
		
		info_panel.setBorder(BorderFactory.createLineBorder(Color.gray));		
		content_panel.add(info_panel,BorderLayout.NORTH);
		
		m_courses_table.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		content_panel.add(m_courses_table);
		
		content_panel.setBorder(BorderFactory.createLineBorder(Color.white, 20));
		
		this.add(content_panel, BorderLayout.CENTER);
		
	}
	
	private void initData(){
//		m_stu_name_lablel=new JLabel("姓名:");
		m_stu_id_lablel=new JLabel("学号:");
		m_stu_academe_lablel=new JLabel("学院:");
		m_stu_major_lablel=new JLabel("专业:");
		m_stu_classid_lablel=new JLabel("班级:");
		m_welcome_label=new JLabel("欢迎您！卢一少");

//		m_stu_name_field=new JTextField("卢一少",15);
		m_stu_id_field=new JTextField("04140814",10);
		m_stu_academe_field=new JTextField("计算机科学与技术系",20);
		m_stu_major_field=new JTextField("软件工程",10);
		m_stu_classid_field=new JTextField("8班",5);
		
//		m_stu_name_field.setEditable(false);
		m_stu_id_field.setEditable(false);
		m_stu_academe_field.setEditable(false);
		m_stu_major_field.setEditable(false);
		m_stu_classid_field.setEditable(false);

		m_course_table_btn=new JButton("课程表");
		m_personal_info_btn=new JButton("个人信息");
		m_scorce_btn=new JButton("成绩");
		
		m_xnd_comb=new JComboBox<String>();
		m_xqd_comb=new JComboBox<String>();
		String[] num={"1","2","3","4","5","6",
				"7","8","9","10","11","12",
				"13","14","15","16","17","18",
				"19","20","21","22","23","24"
				};
		m_week_comb=new JComboBox<String>(num);
			
		m_courses_table=new CourseTablePanel(12, 7);
		
	}
	
	private void setBtnListener() {
		// TODO Auto-generated method stub
		m_xnd_comb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED){
					selectXndOrXqd();
				}
			}
		});
		m_xqd_comb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED){
					selectXndOrXqd();
				}
			}
		});
		m_week_comb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getStateChange() == ItemEvent.SELECTED){
					try {
						int n=Integer.parseInt((String)m_week_comb.getSelectedItem());
						m_courses_table.updateCourseTable(n);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	private void selectXndOrXqd(){
//		String curr=m_xnd_comb.get
		String xnd=(String)m_xnd_comb.getSelectedItem();
		String xqd=(String)m_xqd_comb.getSelectedItem();
		mController.qureyCourseTable(xnd, xqd);
	}
	
	/**
	 * 显示课表
	 * @param courseTable 课表
	 */
	public void showCourseTable(CourseTable courseTable) {
		try {
			int n=Integer.parseInt((String)m_week_comb.getSelectedItem());
			m_courses_table.setCourseTable(courseTable.getCourses(), n);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置学年度和学期选择下拉框
	 * @param xnds 学年度选项
	 * @param xqds 学期选项
	 */
	public void setXndOrXqdComb(String xnds[],String xqds[]){
		m_xnd_comb.setModel(new DefaultComboBoxModel<String>(xnds));
		m_xqd_comb.setModel(new DefaultComboBoxModel<String>(xqds));
	}
	
}
















































