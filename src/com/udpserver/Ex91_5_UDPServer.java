package com.udpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//服务端程序
public class Ex91_5_UDPServer {

	public static void main(String[] args) throws IOException {
		System.out.println("Server starting...\n");
		DatagramSocket s = new DatagramSocket(5555); //创建一个绑定到5555端口的数据报套接字;用来传送数据报
		byte [] data = new byte[200]; //创建一个用于保存数据报的字节数组
		
		//创建一个DatagramPacket对象封装了一个指向字节数组和目标地址信息
		//这个该DatagramPacket对象没有初始化地址是因为它包含了来自客户端的地址信息
		DatagramPacket dgp = new DatagramPacket(data, data.length);
		while (true) {
			s.receive(dgp); //从客户端接受数据报
			System.out.println(new String(data)); //显示数据报的内容
			s.send(dgp); //回应一个信息给客户端(向解析出的地址端口发包）
		}		
	}
}
