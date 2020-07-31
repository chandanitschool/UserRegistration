package in.nit.message;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Message {
	
	public static void main(String[] args) {
		String pwd="Mr. Satya I am Success Sending Mobile Message Using TextLocal Api ";
		Message.sendSms(pwd);
	}

	public static void sendSms(String pwd) {
		try {
			String apiKey="apiKey="+"6V4fz7QzK5Q-HmQos1HxQ84AHE7woYqen1N84j3pTJ";
			String message="&message="+URLEncoder.encode(pwd,"UTF-8");
			String numbers="&numbers="+"7008508931";
			String apiURL="https://api.textlocal.in/send/?"+apiKey+message+numbers;
			
			URL url=new URL(apiURL);
			URLConnection conn=url.openConnection();
			conn.setDoOutput(true);
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line ="";
			StringBuilder sb=new StringBuilder();
			
			while((line=reader.readLine())!=null) {
				sb.append(line).append("\n");
			}
			System.out.println(sb.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
