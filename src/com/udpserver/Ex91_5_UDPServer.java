package com.udpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//����˳���
public class Ex91_5_UDPServer {

	public static void main(String[] args) throws IOException {
		System.out.println("Server starting...\n");
		DatagramSocket s = new DatagramSocket(5555); //����һ���󶨵�5555�˿ڵ����ݱ��׽���;�����������ݱ�
		byte [] data = new byte[200]; //����һ�����ڱ������ݱ����ֽ�����
		
		//����һ��DatagramPacket�����װ��һ��ָ���ֽ������Ŀ���ַ��Ϣ
		//�����DatagramPacket����û�г�ʼ����ַ����Ϊ�����������Կͻ��˵ĵ�ַ��Ϣ
		DatagramPacket dgp = new DatagramPacket(data, data.length);
		while (true) {
			s.receive(dgp); //�ӿͻ��˽������ݱ�
			System.out.println(new String(data)); //��ʾ���ݱ�������
			s.send(dgp); //��Ӧһ����Ϣ���ͻ���(��������ĵ�ַ�˿ڷ�����
		}		
	}
}
