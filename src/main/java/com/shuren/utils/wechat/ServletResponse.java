package com.shuren.utils.wechat;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2015/11/13.
 */
public class ServletResponse {
	public static void WriteJson(HttpServletResponse response, String rv, String callback) {
		if (rv == null) {
			rv = "";
		}
		if (response != null) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			try {
				response.getWriter().write(callback + "(" + rv + ")");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				response = null;
			}
		}
	}

	public static void WriteJsonForApp(HttpServletResponse response, String rv) {
		if (rv == null) {
			rv = "";
		}
		if (response != null) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			try {
				response.getWriter().write("" + rv + "");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				response = null;
			}
		}
	}
}

