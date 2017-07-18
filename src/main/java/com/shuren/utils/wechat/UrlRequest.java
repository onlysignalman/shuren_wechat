package com.shuren.utils.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlRequest {

    private final static int TIMEOUT = 1000 * 5;
    
    public static String sendGet(String url, String param, String charset, String cookie) {
    	return sendGet(url, param, charset, cookie, "");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static String sendGet(String url, String param, String charset, String cookie, String header) {
    	if(url.lastIndexOf(",") == url.length() - 1) {
    		url = url.substring(0, url.length() - 1);
    	}
        if (charset == "") {
            charset = "utf-8";
        }
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);

            URLConnection connection = realUrl.openConnection();
            
            connection.setConnectTimeout(TIMEOUT);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            if (!cookie.equals("")) {
                connection.setRequestProperty("Cookie", cookie);
            }
            if(header != null && header.length() > 0) {  
            	String[] arrheader = header.split(";");
            	if(arrheader != null && arrheader.length > 0) {
            		for(int i = 0; i < arrheader.length; i++) {
            			if(arrheader[i].split("=").length == 2) {
            				connection.setRequestProperty(arrheader[i].split("=")[0], arrheader[i].split("=")[1]);			
            			}
            		}
            	}            	
            }

            connection.connect();

            Map<String, List<String>> map = connection.getHeaderFields();

            for (String key : map.keySet()) {
                //System.out.println(key + "--->" + map.get(key));
            }

            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Map logmap = new HashMap();
		logmap.put("url", url);
		logmap.put("param", param);
		logmap.put("result", result);
		logmap.put("cookie", cookie);
		logmap.put("header", header);
		logmap.put("requesttype", "get");
        return result;
    }

    public static String sendGet(String url, String param, String charset) {
        String result = sendGet(url, param, charset, "");       
        return result;
    }

    public static String sendGet(String url, String param) {
        String result = sendGet(url, param, "utf-8");
        return result;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static String sendPost(String url, String param, String charset, String cookie, String header) {
    	if(url.lastIndexOf(",") == url.length() - 1) {
    		url = url.substring(0, url.length() - 1);
    	}
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);

            URLConnection conn = realUrl.openConnection();            

            conn.setConnectTimeout(TIMEOUT);
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            
            if (!cookie.equals("")) {
            	conn.setRequestProperty("Cookie", cookie);
            }
            if(header != null && header.length() > 0) {  
            	String[] arrheader = header.split(";");
            	if(arrheader != null && arrheader.length > 0) {
            		for(int i = 0; i < arrheader.length; i++) {
            			if(arrheader[i].split("=").length == 2) {
            				conn.setRequestProperty(arrheader[i].split("=")[0], arrheader[i].split("=")[1]);			
            			}
            		}
            	}            	
            }

            conn.setDoOutput(true);
            conn.setDoInput(true);

            out = new PrintWriter(conn.getOutputStream());

            out.print(param);

            out.flush();

            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Map logmap = new HashMap();
		logmap.put("url", url);
		logmap.put("param", param);
		logmap.put("result", result);
		logmap.put("cookie", cookie);
		logmap.put("header", header);
		logmap.put("requesttype", "post");
        return result;
    }

    public static String sendPost(String url, String param) {
        String result = sendPost(url, param, "utf-8");
        return result;
    }
    
    public static String sendPost(String url, String param, String charset) {
    	String result = sendPost(url, param, "utf-8", "", "");
        return result;
    }

    public static String sendPost(String url, String param, String charset, String cookie) {
    	String result = sendPost(url, param, "utf-8", cookie, "");
        return result;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static String sendPost2(String url, String param, String charset, String cookie, String header) throws Exception {
    	if(url.lastIndexOf(",") == url.length() - 1) {
    		url = url.substring(0, url.length() - 1);
    	}
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
       
            URL realUrl = new URL(url);

            URLConnection conn = realUrl.openConnection();            

            conn.setConnectTimeout(TIMEOUT);
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type","application/json; charset=UTF-8"); 
            conn.setRequestProperty("Charset", "UTF-8");
            if (!cookie.equals("")) {
            	conn.setRequestProperty("Cookie", cookie);
            }
            if(header != null && header.length() > 0) {  
            	String[] arrheader = header.split(";");
            	if(arrheader != null && arrheader.length > 0) {
            		for(int i = 0; i < arrheader.length; i++) {
            			if(arrheader[i].split("=").length == 2) {
            				conn.setRequestProperty(arrheader[i].split("=")[0], arrheader[i].split("=")[1]);			
            			}
            		}
            	}            	
            }

            conn.setDoOutput(true);
            conn.setDoInput(true);            

            out = new PrintWriter(conn.getOutputStream());            

            out.write(new String(param.getBytes(charset)));
            out.flush();

            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        

        
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
        Map logmap = new HashMap();
		logmap.put("url", url);
		logmap.put("param", param);
		logmap.put("result", result);
		logmap.put("cookie", cookie);
		logmap.put("header", header);
		logmap.put("requesttype", "post");
        return result;
    }

}
