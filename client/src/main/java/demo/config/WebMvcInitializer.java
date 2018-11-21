package demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public final class WebMvcInitializer extends
    AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {MvcAppWebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/*"};
  }

  @Override
  public void onStartup(final ServletContext servletContext)
      throws ServletException {
    registerHiddenFieldFilter(servletContext);
  }

  private void registerHiddenFieldFilter(final ServletContext aContext) {
    aContext.addFilter("hiddenHttpMethodFilter",
        new HiddenHttpMethodFilter())
        .addMappingForUrlPatterns(null, true, "/*");
  }

}
