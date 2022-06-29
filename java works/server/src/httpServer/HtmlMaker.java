package httpServer;

public class HtmlMaker {
	
	private HtmlMaker() {
	}
	
	public static String makeHtml() {
		String html = "";
		html+="<!DOCTYPE html>";
		html+="<html>";
		html+=makeHeader();
		html+="</html>";
		return html;
	}
	
	public static String makeHeader() {
		String head = "";
		head+="<head>";
		head+="    <meta charset=\"UTF-8\">";
		head+="    <meta name=\"author\" content=\"Dochi\">";
		head+="    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">";
		head+="    <title>Example</title>";
		head+="    <link rel='icon' href='data:;base64,iVBORw0KGgo='>";
		head+="    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>";
		head+="    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>";
		head+="    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>";
		head+="</head>";
		return head;
	}
	
	public static String makeBody(String str) {
		String body = "";
		body+="   <body>";
		body+=str;
		body+="   </body>";
		return body;
	}
}
