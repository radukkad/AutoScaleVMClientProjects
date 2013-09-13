package edu.sjsu.group6.servlet.listener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	private int sessionCount = 0;

	public void sessionCreated(HttpSessionEvent event) {
		synchronized (this) {
			sessionCount++;
		}
		sendRequest("add");
		System.out.println("Session Created: " + event.getSession().getId());
		System.out.println("Total Sessions: " + sessionCount);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		synchronized (this) {
			sessionCount--;
		}
		sendRequest("remove");

		System.out.println("Session Destroyed: " + event.getSession().getId());
		System.out.println("Total Sessions: " + sessionCount);
	}

	public void sendRequest(String action) {
		try {
			// i.e.: request =
			// "http://example.com/index.php?param1=a&param2=b&param3=c";

			java.net.InetAddress addr = java.net.InetAddress.getLocalHost();
			String hostname = addr.getHostName();
			
			String params = "vmName="+hostname+"&action="+ action;
			URL url = new URL("http://samapp3.aws.af.cm/ManageSession");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(
					conn.getOutputStream());
			writer.write(params);
			writer.flush();
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			writer.close();
			reader.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
