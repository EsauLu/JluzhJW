package com.jluzh.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;

import com.jluzh.control.Controller;
import com.jluzh.view.MainFream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setDefaultConfig();
		Controller ctrl=new Controller();
//		new MainFream(null).setVisible(true);
	}
	
	/**
	 * 配置GUI属性默认值
	 */
	private static void setDefaultConfig(){
		
		Font font_1=new Font("宋体", Font.PLAIN, 16);//字体
//		Font font_2=new Font("黑体", Font.PLAIN, 18);//字体		
		
		//文字抗锯齿
		System.setProperty("awt.useSystemAAFontSettings", "on"); 
		System.setProperty("swing.aatext", "true");		
		
		//默认UI风格
		UIManager.put("OptionPane.font", font_1);
		UIManager.put("Button.font", font_1);
		UIManager.put("Label.font", font_1);
		UIManager.put("TextField.font", font_1);
		UIManager.put("PasswordField.font", font_1);
		UIManager.put("TextArea.font", font_1);
		UIManager.put("ComboBox.font", font_1);
		UIManager.put("List.font", font_1);
		UIManager.put("Panel.background", Color.white);
		UIManager.put("Label.background", Color.white);
		UIManager.put("OptionPane.background", Color.white);//
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
	}

}














































