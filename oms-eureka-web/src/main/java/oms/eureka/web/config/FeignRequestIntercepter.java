package oms.eureka.web.config;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;
/**
 * 通过拦截feign客户端请求，把本地线程头部信息的cookie传递给feign客户端调用的服务
 * @author wangqi
 *
 */
@Component
public class FeignRequestIntercepter implements RequestInterceptor {
	@Override
	   public void apply(RequestTemplate requestTemplate) {
	       //通过RequestContextHolder获取本地请求
	       RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
	       if (requestAttributes == null){
	           return;
	       }
	       //获取本地线程绑定的请求对象
	       HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
	       //给请求模板附加本地线程头部信息，主要是cookie信息
	       Enumeration<String> headerNames = request.getHeaderNames();
	       while (headerNames.hasMoreElements()){
	           String name = headerNames.nextElement();
	           requestTemplate.header(name,request.getHeader(name));
	       }

	   }
}
