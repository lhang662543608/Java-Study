package _04_web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lhang
 * @create 2020-08-15 16:36
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}