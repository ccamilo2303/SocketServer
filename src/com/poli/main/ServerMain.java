package com.poli.main;

import java.io.IOException;

import com.poli.utils.FileUtils;
import com.poli.utils.ServerUtils;

/**
 * @author Camilo Beltrán
 * @since  28/08/2022
 */
public class ServerMain {

	public static void main(String args[]) throws IOException, ClassNotFoundException{
		ServerUtils serverUtil = new ServerUtils();
		FileUtils.createDataFile();
		
		serverUtil.startServe();
		serverUtil.readMessages();
		
	}

}
