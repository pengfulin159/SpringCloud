package com.pfltest.service_zuultest.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


/*
 * zuul不仅只是路由，并且还能过滤，做一些安全验证:
 * 
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：

    pre：路由之前
    routing：路由之时
    post： 路由之后
    error：发送错误调用
	
	方法：
    filterOrder：过滤的顺序
    shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
    run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 */
public class MyFilter extends ZuulFilter{
	private static Logger log = LoggerFactory.getLogger(MyFilter.class);
	
	public Object run() {
		 RequestContext ctx = RequestContext.getCurrentContext();
	     HttpServletRequest request = ctx.getRequest();
	     log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
	     Object accessToken = request.getParameter("token");
	     if(accessToken == null) {
	        log.warn("token is empty");
	        ctx.setSendZuulResponse(false);			// 过滤该请求，不对其进行路由  ，设置为true表示对该请求进行路由
	        ctx.setResponseStatusCode(401);			//返回错误码
            // ctx.set("isSuccess", true);// 设值，让下一个 看到上一个Filter的状态
	        // ctx.setResponseBody("{\"result\":\"username is not correct!\"}");// 返回错误内容
	        try {
	            ctx.getResponse().getWriter().write("token is empty");
	        }catch (Exception e){
	        }
	        return null;
	     }
	     log.info("ok");
	     return null;
	}

	public boolean shouldFilter() {		//是否执行该过滤器
		return true;				//执行
		/*
		 * 	RequestContext ctx = RequestContext.getCurrentContext();
		 *  //如果前一个过滤器的结果为true，则说明上一个过滤器成功了，需要进入当前的过滤，如果前一个过滤器的结果为false，则说明上一个过滤器没有成功，则无需进行下面的过滤动作了，直接跳过后面的所有过滤器并返回结果
			return (boolean) ctx.get("isSuccess");
		 */
	}

	@Override
	public String filterType() {		//路由之前过滤			顺序先看filterType再看filterOrder
		return "pre";
	}

	@Override
	public int filterOrder() {			//通过int值来定义过滤器的执行顺序  
		return 0;			//最优先，数字越大，优先级越低
	}	

}
