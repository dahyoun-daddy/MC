package project.mc.commons;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import project.mc.blog.recruit.domain.ParseVO;


public class RecruitParse {

	
	public List<ParseVO> SaramParse() throws Exception {
		//DocFactory 선언
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//HttpConnection을 통한 InputStream을 가져오는 객체 선언
		RecruitCon pj = new RecruitCon();
		InputStream is = pj.getXmlFromUrl();
		
		//DocFactory에 빌드를 올릴 빌더 선언
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//빌더안에 넣을 Document 객체 선언
		Document doc =  builder.parse(is);
		
		//Document객체 전체를 받을 Parent Node인 Root 엘리먼트 선언
		Element root = doc.getDocumentElement();
		
		//Root엘리먼트 안에 모든 자식 Node를  받아줄 NodeList 객체 선언
		NodeList total = root.getChildNodes();

		
		//job-search의 자식노드인 Jobs를 찾아서 다시 NodeList 객체로 선언
		NodeList jobs_d = root.getElementsByTagName("jobs");
		//jobs를 담아주는 엘리먼트 p를 선언	
		Element p = (Element)jobs_d.item(0);
		
		
		//jobs의 자식노드인 Job을 다시 NodeList 객체로 선언
		NodeList p_Total = p.getElementsByTagName("job");
		//job을 담아주는 Element 선언
		Element job = null;
		
		//자식노드 HashMap 선언
		HashMap<String,Object> map = new HashMap<String,Object>();
		//Map에서 꺼낸 데이터를 실제 사용할 곳으로 담아서 Return 해줄 List
		List<ParseVO> list = new ArrayList<ParseVO>();
		//job에 자식노드의 값을 담아줄 NodeList 객체 생성
		NodeList s_list = null;
		
		
		for(int i=0;i<p_Total.getLength();i++) {
			job = (Element)p_Total.item(i);
			s_list = job.getChildNodes();
			for(int j=0; j<s_list.getLength(); j++){
		         Node no = s_list.item(j);
		         map.put(no.getNodeName(), no.getTextContent());

			}
			 String url = (String) map.get("url");
			 String company = (String)map.get("company");
			 String position = (String)map.get("position");
			 String close_time = (String) map.get("expiration-timestamp");
			 String salary = (String)map.get("salary");
			 long unixTime = Long.parseLong(close_time);
			 Date date = new Date(unixTime*1000L);
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 String date1 = sdf.format(date);
			
			 StringTokenizer st = new StringTokenizer(position.trim(), "\n");
			 String result = st.nextToken();
	         System.out.println("!url!: "+url);
	         System.out.println("!company!: "+company.trim());
	         System.out.println("!close_time!: "+date1);
	         System.out.println("!salary!: "+salary);
	         System.out.println("!result!: "+result);
	         ParseVO vo = new ParseVO();
	         vo.setReSubject(result);
	         vo.setReCompany(company.trim());
	         vo.setReExDate(date1);
	         vo.setReSalary(salary);
	         vo.setReUrl(url);
	         System.out.println(vo.toString());
	         list.add(vo);
		}
		
	
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println("VO=" + list.get(i).toString());
		}
		
		
		is.close();
		
		return list;
	}
}
