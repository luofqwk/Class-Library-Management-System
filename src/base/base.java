package base;

import view.ChangePassword;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import view.LoginView;
public class base{
    public static String rootpath=System.getProperty("user.dir");
    public static void setBar(JFrame frame,String account,int a) {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("管理");
		menuBar.add(mnNewMenu);
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("修改账号密码");
		mntmNewMenuItem_2.setIcon(new ImageIcon(base.rootpath+"\\img\\更改密码.png"));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                frame.dispose();
				ChangePassword window=new ChangePassword(account,a);
				window.setVisible1();
			}});

		
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("账号");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("注销");
		mntmNewMenuItem.setIcon(new ImageIcon(base.rootpath+"\\img\\注销.png"));
		mnNewMenu_1.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginView window=new LoginView();
				window.setVisible1();
			}});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出");
		mntmNewMenuItem_1.setIcon(new ImageIcon(base.rootpath+"\\img\\进入.png"));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				//打开登录界面
				LoginView window=new LoginView();
				window.setVisible1();
			}});
	}
}