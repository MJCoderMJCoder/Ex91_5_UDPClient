package com.udpclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//�ͻ��˴���
public class Ex91_5_UDPClient {

	public static void main(String[] args) {
		String host = "localhost"; //ָ������Ϊ����
		DatagramSocket datagramSocket = null; //�������ݱ��׽��֣������������ݱ���
		try {
			datagramSocket = new DatagramSocket(); //�ͻ��˴���һ�����ݱ��׽��֣���ϵͳ�Զ�����˿ں�
			byte [] sendBuffer;
			//����һ���ֽ����飬�����������ݱ���Ϣ�����ݲ���
			//�����Ϣ������ַ��������ڵ���getBytes()����֮�󣬿���ת�����ֽ�����
			sendBuffer = new String("This is a datagram").getBytes();
			InetAddress address = InetAddress.getByName(host); //��������ת����InetAddress����
			
			//����һ��DatagramPacket��������װ�˶��ֽ���������ú�Ŀ���ַ��Ϣ
			DatagramPacket datagramPacket = new DatagramPacket(sendBuffer, 
					sendBuffer.length, address, 5555);
			datagramSocket.send(datagramPacket); //ͨ��socket�������ݱ�
			byte[] receiveBuffer = new byte[200]; //����һ���ֽ����鱣��������ķ���
			
			//����һ��DatagramPacket����������󱣴��˷������ķ���ֵ
			datagramPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length, address, 5555);
			datagramSocket.receive(datagramPacket); //ͨ��socket���ܵ����ݱ�
			System.out.println(new String(datagramPacket.getData())); //��ӡ���������ز����������ݱ��е�ֵ
			
		} catch (IOException e) {
			System.out.println(e.toString()); //��ӡ������Ϣ
		} finally {
			if (datagramSocket != null)
				datagramSocket.close();
		}
	}

}
