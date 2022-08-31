package com.poli.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Camilo Beltrán
 * @since  28/08/2022
 */
public class ServerUtils {

	private static ServerSocket server;
	private static int port = 9876;	


	public void startServe() throws IOException {
		server = new ServerSocket(port);		
	}

	public void readMessages() throws IOException, ClassNotFoundException {
		while(true){

			Socket socket = server.accept();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			if(message.contains("create")) {
				try {
					FileUtils.writeString(message.replace("create", ""));
					oos.writeObject("SAVE OK ");
				}catch(Exception e){
					oos.writeObject("SAVE NO-OK");
					e.printStackTrace();
				}
			}else if(message.contains("search")) {
				boolean res = FileUtils.searchAcount(message.replace("search", ""));
				if(res)
					oos.writeObject("Account exist ");
				else
					oos.writeObject("Account not exist");

			}



			ois.close();
			oos.close();
			socket.close();
		}

	}

}
