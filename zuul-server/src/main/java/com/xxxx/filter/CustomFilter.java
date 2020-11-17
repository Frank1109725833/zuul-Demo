package com.xxxx.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : ymd
 * @Date : 2020/11/17 0017 21:58
 * @Version 1.0
 * @Description :
 */
@Component
public class CustomFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(CustomFilter.class);
    /**
     *过滤器类型
     * pre
     * routing
     * post
     * error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序
     * 数值越小，优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 执行条件
     * true 开启
     * false 关闭
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体操作
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 获取请求上下文
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        logger.warn("CustomFilter...method={}, url={}",
                request.getMethod(),
                request.getRequestURL().toString());
        return null;
    }
}
