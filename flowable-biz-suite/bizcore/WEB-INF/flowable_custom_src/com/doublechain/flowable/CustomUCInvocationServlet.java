package com.doublechain.flowable;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;

import com.terapico.uccaf.UCInvocationServlet;

@WebServlet("/*")
public class CustomUCInvocationServlet extends UCInvocationServlet {

	private static final long serialVersionUID = 1L;
	@Value("${ucservlet.exclude.URIs}")
	private String[] excludeURIPattern;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		if (getExcludeURIPattern() != null && Stream.of(getExcludeURIPattern()).anyMatch(p -> matching(p,requestURI))) {
			return;
		}
		super.service(req, resp);
	}

	protected  boolean matching(String reg, String input) {
		return input.matches(reg.replace("?", ".?").replace("*", ".*?"));
	}
	

	public String[] getExcludeURIPattern() {
		return excludeURIPattern;
	}

	public void setExcludeURIPattern(String[] excludeURIPattern) {
		this.excludeURIPattern = excludeURIPattern;
	}
}
