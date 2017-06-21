//qq�ͻ��˵�¼����

package com.qq.client.view;

import javax.swing.*;

import com.qq.client.model.QqClientUser;
import com.qq.common.User;

import java.awt.event.*;
import java.awt.*;
public class QqClientLogin extends JFrame implements ActionListener {
	//���山����Ҫ�����
	
	JLabel jbl1;
	
	//�����в���Ҫ�����
	//�в�������JPanel,��һ�ݽ�ѡ����ڹ���
	
	JTabbedPane jtp;
	JPanel jp2,jp3,jp4;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;
	
	
    //�����ϲ���Ҫ�����
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QqClientLogin qqClientLogin = new QqClientLogin();

	}
    
	public QqClientLogin(){
		
		//������
		
		jbl1 = new JLabel(new ImageIcon("image/tou.gif"));
		
		//�����в�
		
		jp2 = new JPanel (new GridLayout(3,3));
		jp2_jbl1 = new JLabel("QQ����",JLabel.CENTER);
	    jp2_jbl2 = new JLabel("QQ����",JLabel.CENTER);
	    jp2_jbl3 = new JLabel("��������",JLabel.CENTER);
	    jp2_jbl3.setForeground(Color.BLUE);
	    jp2_jbl4 = new JLabel("�������뱣��",JLabel.CENTER);
	    jp2_jb1 = new JButton(new ImageIcon("image/clear.gif"));
	    jp2_jtf = new JTextField();
	    jp2_jpf = new JPasswordField();
	    jp2_jcb1 = new JCheckBox("�����¼");
	    jp2_jcb2 = new JCheckBox("��ס����");
	    //����ѡ�����
	    jtp = new JTabbedPane();
	    jtp.add("QQ����",jp2);
	    jp3 = new JPanel();//���������ﴴ��ָ��
	    jtp.add("�ֻ�����",jp3);
	    
	    jp4 = new JPanel();
	    jtp.add("�����ʼ�",jp4);
	    
	    
	    
	    //�ѿؼ�����˳����뵽jp2
	    jp2.add(jp2_jbl1);
	    jp2.add(jp2_jtf);
	    jp2.add(jp2_jb1);
	    jp2.add(jp2_jbl2);
	    jp2.add(jp2_jpf );
	    jp2.add(jp2_jbl3);
	    jp2.add(jp2_jcb1);
	    jp2.add(jp2_jcb2);
	    jp2.add(jp2_jbl4);
	    
		//�����ϲ�
		jp1 = new JPanel(new FlowLayout());//new FlowLayout() ����ʡ��
		jp1_jb1 = new JButton(new ImageIcon("image/denglu.gif"));
		
		//��Ӧ�û������½
		jp1_jb1.addActionListener(this);
		jp1_jb2 = new JButton(new ImageIcon("image/quxiao.gif"));
		jp1_jb3 = new JButton(new ImageIcon("image/xiangdao.gif"));
		
		//��������ť�ŵ�jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		
		this.add(jbl1,"North");
		this.add(jtp,"Center");
		this.add(jp1, "South");
		this.setSize(350,240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		//����û������½
		if(arg0.getSource() == jp1_jb1)
		{
			QqClientUser qqClientUser = new QqClientUser();
			User u = new User();
			
			u.setUserId(jp2_jtf.getText().trim());
			u.setPasswd(new String(jp2_jpf.getPassword()));
			
			try {
				if(qqClientUser.checkUser(u))
				{
					new QqFriendList();
					
					this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"�û����������");
				}
			}  catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
