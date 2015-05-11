package network;

import java.io.*;
import java.net.*;

import android.os.AsyncTask;

public class Request extends AsyncTask<String, String, String>{
	
	String response = "No response";
	
	public Request(){
		
	}
	
	public String doRequest(String text) throws IOException {
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress("206.127.182.253", 3000), 3000);

		
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				socket.getOutputStream(), "UTF8"));
		;
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		
		sendMessage(out, text);
		
		String response = readResponse(in);
		
		out.close();
		in.close();
		socket.close();
		
		return response;
	}

	private static void sendMessage(BufferedWriter out, String text)
			throws IOException {

		out.write(text + "\r\n");

		out.write("\r\n");
		out.flush();
	}

	private static String readResponse(BufferedReader in) throws IOException {

		String line, output = null;
		while ((line = in.readLine()) != null) {
			output += '\n' + line;
		}
		
		return output;
		
	}

	@Override
	protected String doInBackground(String... arg) {
		String text = "doInBackground";
		try {
			text = doRequest(arg[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	@Override
	protected void onPostExecute(String text){
		response = text;
	}
	
	public String getResponse(){
		return response;
	}
	
}
