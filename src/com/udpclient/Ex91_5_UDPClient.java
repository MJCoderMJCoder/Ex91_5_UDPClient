package com.udpclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//客户端代码
public class Ex91_5_UDPClient {

	public static void main(String[] args) {
		String host = "localhost"; //指定本机为主机
		DatagramSocket datagramSocket = null; //定义数据报套接字（用来传送数据报）
		try {
			datagramSocket = new DatagramSocket(); //客户端创建一个数据报套接字，由系统自动分配端口号
			byte [] sendBuffer;
			//创建一个字节数组，用来保存数据报信息的数据部分
			//这个信息最初是字符串对象，在调用getBytes()方法之后，可以转换成字节序列
			sendBuffer = new String("This is a datagram").getBytes();
			InetAddress address = InetAddress.getByName(host); //将主机名转换成InetAddress对象
			
			//创建一个DatagramPacket对象，它封装了对字节数组的引用和目标地址信息
			DatagramPacket datagramPacket = new DatagramPacket(sendBuffer, 
					sendBuffer.length, address, 5555);
			datagramSocket.send(datagramPacket); //通过socket发送数据报
			byte[] receiveBuffer = new byte[200]; //创建一个字节数组保存服务器的返回
			
			//创建一个DatagramPacket对象，这个对象保存了服务器的返回值
			datagramPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length, address, 5555);
			datagramSocket.receive(datagramPacket); //通过socket接受的数据报
			System.out.println(new String(datagramPacket.getData())); //打印服务器返回并保存在数据报中的值
			
		} catch (IOException e) {
			System.out.println(e.toString()); //打印出错信息
		} finally {
			if (datagramSocket != null)
				datagramSocket.close();
		}
	}

}
