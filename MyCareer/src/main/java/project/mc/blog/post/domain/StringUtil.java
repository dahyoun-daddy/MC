package project.mc.blog.post.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;



/**
 * String Util
 * @author SIST
 *
 */
public class StringUtil {

	
	public static String currDate(String type) {
		Date date=new Date();
		SimpleDateFormat  sdf=new SimpleDateFormat(type);
		return sdf.format(date);
	}
	
	
	
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-","");
		
	}
	
	
	public static void debugPrint(boolean flag,String msg){
		if(flag){
			
		}
	}
	
	public static String sqlInjectPro(String str){
		String retStr = "";
		retStr = str.replaceAll("'", "");//' -->""
		return retStr;
	}
	
	/**
	 * NVL 
	 * @param str
	 * @return retStr
	 */
	public static String nvl(String str,String defVal){
		String retStr = "";
		if(str == null || str.equals("") ){
			retStr = defVal;
		}else{
			retStr = str.trim();  
		}
		
		return retStr;
	}
	
	
	/**
	   * Paging처리 
	   * @param maxNum_i
	   * @param currPageNoIn_i
	   * @param rowsPerPage_i
	   * @param bottomCount_i
	   * @param url_i
	   * @param scriptName_i
	   * @return
	   */
	public static String renderPaging(int maxNum_i, int currPageNoIn_i, int rowsPerPage_i, int bottomCount_i,
			String url_i, String scriptName_i) {
			int maxNum = 0; 
			int currPageNo = 1; 
			int rowPerPage = 10;
			int bottomCount = 10; 

			maxNum = maxNum_i;
			currPageNo = currPageNoIn_i;
			rowPerPage = rowsPerPage_i;
			bottomCount = bottomCount_i;

			String url = url_i; 
			String scriptName = scriptName_i; 

			int maxPageNo = ((maxNum - 1) / rowPerPage) + 1;
			int startPageNo = ((currPageNo - 1) / bottomCount) * bottomCount + 1;
			int endPageNo = ((currPageNo - 1) / bottomCount + 1) * bottomCount;
			int nowBlockNo = ((currPageNo - 1) / bottomCount) + 1;
			int maxBlockNo = ((maxNum - 1) / bottomCount) + 1;

			int inx = 0;
			StringBuilder html = new StringBuilder();
			if (currPageNo > maxPageNo) {
				return "";
			}

			html.append("<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">   \n");
			html.append("<tr> 																						\n");
			html.append("<td class=\"list_num\">                                                                    \n");
			html.append("<ul class=\"pagination pagination-sm\"> 	                                                \n");
			// <<
			if (nowBlockNo > 1 && nowBlockNo <= maxBlockNo) {
				html.append("<li><a href=\"javascript:" + scriptName + "( '" + url+ "', 1 );\">  \n");
				html.append("&laquo;   \n");
				html.append("</a></li>      \n");
			}

			// <
			if (startPageNo > bottomCount) {
				html.append("<li><a href=\"javascript:" + scriptName + "( '" + url + "'," + (startPageNo - 1)+ ");\"> \n");
				html.append("<        \n");
				html.append("</a></li>     \n");
			}



			// 1 2 3 ... 10	(?��?��보여주기)
			for (inx = startPageNo; inx <= maxPageNo && inx <= endPageNo; inx++) {
				
				if (inx == currPageNo) {
					html.append("<li class='active'><a href='#'>" + inx	+ "</a></li>");
				} else {
					html.append("<li><a href=\"javascript:" + scriptName + "('" + url + "'," + inx+ ");\" class=\"num_text\">" + inx + "</a></li> \n");
				}
			}
			
			// >
			if (maxPageNo >= inx) {
				html.append("<li><a href=\"javascript:" + scriptName + "('" + url + "',"+ ((nowBlockNo * bottomCount) + 1) + ");\"> \n");
				html.append(">                       \n");
				html.append("</a></li>              \n");
			}

			// >>
			if (maxPageNo >= inx) {
				html.append("<li><a href=\"javascript:" + scriptName + "('" + url + "'," + maxPageNo+ ");\">      \n");
				html.append("&raquo;     \n");
				html.append("</a></li>    \n");
			}
			html.append("</ul>		\n");
			html.append("</td>  	\n");
			html.append("</tr>  	\n");
			html.append("</table>   \n");

			return html.toString();
		}
	
}
