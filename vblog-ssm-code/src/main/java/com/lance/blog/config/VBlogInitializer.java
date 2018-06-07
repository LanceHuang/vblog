package com.lance.blog.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * @author Lance
 */
public class VBlogInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{VBlogRootConfig.class, PersistentConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{VBlogServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CharacterEncodingFilter("UTF-8")};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        ServletRegistration.Dynamic statViewServlet = servletContext.addServlet("StatViewServlet", new StatViewServlet());
        statViewServlet.setInitParameter("loginUsername", "lance");
        statViewServlet.setInitParameter("loginPassword", "123");
        statViewServlet.addMapping("/druid/*");

        FilterRegistration.Dynamic webStatFilter = servletContext.addFilter("WebStatFilter", new WebStatFilter());
        webStatFilter.setInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        webStatFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
