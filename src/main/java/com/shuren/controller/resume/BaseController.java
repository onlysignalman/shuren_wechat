package com.shuren.controller.resume;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shuren.bean.resume.BaseReturns;
import com.shuren.utils.wechat.ServletResponse;

import net.sf.json.JSONObject;

public class BaseController {
	
    
    private ThreadLocal<HttpServletRequest> myRequest = new ThreadLocal<HttpServletRequest>();
    private ThreadLocal<HttpServletResponse> myResponse = new ThreadLocal<HttpServletResponse>();
    private ThreadLocal<Long> curuserid = new ThreadLocal<Long>(); 
    private ThreadLocal<String> curusername = new ThreadLocal<String>();
    private ThreadLocal<String> curnickname = new ThreadLocal<String>();
    private ThreadLocal<String> curcookie = new ThreadLocal<String>(); 
    private ThreadLocal<String> curclientcode = new ThreadLocal<String>();    
    private ThreadLocal<String> cursessionid = new ThreadLocal<String>();
    private ThreadLocal<String> curip = new ThreadLocal<String>();    
    private ThreadLocal<String> curadminrealname = new ThreadLocal<String>();
    private ThreadLocal<Integer> currole = new ThreadLocal<Integer>();
    private ThreadLocal<String> curfunctionkey = new ThreadLocal<String>();
    
    public HttpServletRequest getRequest(){
        return myRequest.get();
    }
    public HttpServletResponse getResponse(){
        return myResponse.get();
    }
    public ThreadLocal<HttpServletRequest> getMyRequest() {
        return myRequest;
    }
    public void setMyRequest(ThreadLocal<HttpServletRequest> myRequest) {
        this.myRequest = myRequest;
    }
    public ThreadLocal<HttpServletResponse> getMyResponse() {
        return myResponse;
    }
    public void setMyResponse(ThreadLocal<HttpServletResponse> myResponse) {
        this.myResponse = myResponse;
    }    
    public String getCurclientcode() {
    	return curclientcode.get();
    }    
    public void setCurclientcode(String curclientcode) {
    	this.curclientcode.set(curclientcode);
    }    
    public String getCurcookie() {
        return curcookie.get();
    }
    public void setCurcookie(String curcookie) {
        this.curcookie.set(curcookie);
    }
    public long getCuruserid() {
        return curuserid.get() ;
    }
    public void setCuruserid(long curuserid) {
        this.curuserid.set(curuserid);
    }
    public String getCurusername() {
        return curusername.get();
    }
    public void setCurusername(String curusername) {
        this.curusername.set(curusername);
    }
    public String getCurnickname() {
        return curnickname.get();
    }
    public void setCurnickname(String curnickname) {
        this.curnickname.set(curnickname);
    }    
    public String getCurip() {
		return curip.get();
	}
	public void setCurip(String curip) {
		this.curip.set(curip);
	}
	public String getCuradminrealname() {
		return curadminrealname.get();
	}
	public void setCuradminrealname(String curadminrealname) {
		this.curadminrealname.set(curadminrealname);
	}
	public int getCurrole() {
		return currole.get();
	}
	public void setCurrole(Integer currole) {
		this.currole.set(currole);
	}
	public String getCurfunctionkey() {
		return curfunctionkey.get();
	}
	public void setCurfunctionkey(String curfunctionkey) {
		this.curfunctionkey.set(curfunctionkey);
	}

	private Logger logger = Logger.getLogger(BaseController.class);
    
    public String getCursessionid() {
		return cursessionid.get();
	}
	public void setCursessionid(String cursessionid) {
		this.cursessionid.set(cursessionid);
	}
	private void initSessionId() {
		if(getRequest() != null) {
			String sessionid = getRequest().getHeader("zx_Token");
			if(sessionid != null && sessionid.length() > 0) {
				setCursessionid(sessionid);	
			}			
		}
	}	
	
	private void initFunctionkey() {
		String functionkey = getRequest().getRequestURI();
		if(functionkey.indexOf("/") == 0) {
			functionkey = functionkey.substring(1, functionkey.length());
		}
		if(functionkey.lastIndexOf("/") == functionkey.length() - 1) {
			functionkey = functionkey.substring(0, functionkey.length() - 1);
		}
		setCurfunctionkey(functionkey);
	}
    
    /*** 
     * Get request query string, form method : post 
     *  
     * @param request 
     * @return byte[] 
     * @throws IOException 
     */  
    public static byte[] getRequestPostBytes(HttpServletRequest request)  
            throws IOException {  
        int contentLength = request.getContentLength();  
        /*当无请求参数时，request.getContentLength()返回-1 */  
        if(contentLength<0){  
            return null;  
        }  
        byte buffer[] = new byte[contentLength];  
        for (int i = 0; i < contentLength;) {  
  
            int readlen = request.getInputStream().read(buffer, i,  
                    contentLength - i);  
            if (readlen == -1) {  
                break;  
            }  
            i += readlen;  
        }  
        return buffer;  
    }  
  
    /*** 
     * Get request query string, form method : post 
     *  
     * @param request 
     * @return 
     * @throws IOException 
     */  
    public static String getRequestPostStr(HttpServletRequest request)  
            throws IOException {  
        byte buffer[] = getRequestPostBytes(request);  
        String charEncoding = request.getCharacterEncoding();  
        if (charEncoding == null) {  
            charEncoding = "UTF-8";  
        }  
        return new String(buffer, charEncoding);  
    }  
    
    @ExceptionHandler  
    public void exp(HttpServletRequest request, Exception ex) {  
        logger.error(" 出现错误：" + getRequest().getRequestURL().toString() +"|"+ ex.getMessage() );
    }

    public<T>  void WriteJson(T bean) {
    //  HttpServletRequest request = getRequest();//getServletrequest();
    //  HttpServletResponse response = getResponse();// getServletresponse();
        String callback = getRequest().getParameter("callback");
        
        if( bean==null){
            BaseReturns returnBase= new BaseReturns();
            returnBase.setError("服务器错误");
            returnBase.setStatus(0);
            bean = (T)returnBase;
        } 
        try {
            String json = JSONObject.fromObject(bean).toString();
            if (callback != null && !callback.equals("")) {
                ServletResponse.WriteJson(getResponse(), json, callback);
            } else {
                ServletResponse.WriteJsonForApp(getResponse(), json);
            }
        } catch (Exception e) {
          e.printStackTrace();
        }
    }    
}
