package API;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.PublicKey;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;


public class API_Example {
	
	private static ArrayList<API> apiList = new ArrayList<API>();
	public static void main(String[] args) {
	
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao dia chi IP :  ");
		String input = scanner.nextLine();
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://ip-api.com/json/"+input+""))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			
			if (response.statusCode() == 200)
			{
				API api = new API(response.body());
				apiList.add(api);
				
				for (API objApi : apiList) {
					if (objApi.getStatus().equals("success"))
					{
						System.out.println("Status: "+objApi.getStatus());
						System.out.println("Country: "+objApi.getCountry());
					}
					else {
						System.out.println("Message :"+objApi.getMessage());
						break;
					}
				}
				
			}
			else {
				System.out.println("Day la dia chi private nhe cu , ngu nhu bo !!");
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
}