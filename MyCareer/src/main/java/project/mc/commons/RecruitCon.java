package project.mc.commons;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RecruitCon {


	public InputStream getXmlFromUrl(String pageNo) {
		URL url = null;
		String modUrl = "http://api.saramin.co.kr/job-search?ind_cd=301&start="+pageNo+"&count=10";
		
		HttpURLConnection httpUrl = null;
		InputStream ips = null;
		try {
			url = new URL(modUrl);
			URLConnection urlConnection = url.openConnection();
			httpUrl = (HttpURLConnection) urlConnection;
			
			httpUrl.setDoInput(true);
			httpUrl.setDoOutput(true);
			httpUrl.setRequestMethod("GET");
			httpUrl.setUseCaches(false);
			httpUrl.setDefaultUseCaches(false);
			httpUrl.setRequestProperty("Content-Type", "text/xml");
			
			ips = httpUrl.getInputStream();
			
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return ips;
	}
	
}
