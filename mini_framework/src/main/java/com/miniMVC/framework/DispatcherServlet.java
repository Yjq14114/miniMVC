package com.miniMVC.framework;

import com.miniMVC.commons.JsonUtil;
import com.miniMVC.commons.StringUtil;
import com.miniMVC.framework.bean.Data;
import com.miniMVC.framework.bean.Handler;
import com.miniMVC.framework.bean.Param;
import com.miniMVC.framework.bean.View;
import com.miniMVC.framework.helper.BeanHelper;
import com.miniMVC.framework.helper.ControllerHelper;
import com.miniMVC.framework.helper.RequestHelper;
import com.miniMVC.framework.helper.UploadHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by yjq14 on 2018/3/4.
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 初始化相关Helper类
        HelperLoader.init();
        // 获取ServletContext 对象
        ServletContext servletContext = config.getServletContext();
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getJspPath() + "*");
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAssertPath() + "*");
        UploadHelper.init(servletContext);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        if (requestPath.equals("/favicon.ico")) {
            return;
        }
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (handler != null) {
            Class<?> controllerClass = handler.getControllerClass();
            Object bean = BeanHelper.getBean(controllerClass);
            Param param;
            if (UploadHelper.isMultipart(req)) {
                param = UploadHelper.createParam(req);
            } else {
                param = RequestHelper.createParam(req);
            }
            Object result;
            Method actionMethod = handler.getActionMethod();
            if (param.isEmpty()) {
                result = ReflectionUtil.invokeMethod(bean, actionMethod);
            } else {
                result = ReflectionUtil.invokeMethod(bean, actionMethod, param);
            }
            if (result instanceof View) {
                View view = (View) result;
                handleViewResult(view, req, resp);
            } else if (result instanceof Data) {
                Data data = (Data) result;
                handleDataResult(data, resp);
            }
        }
    }
    private void handleDataResult(Data data, HttpServletResponse resp) throws IOException {
        Object model = data.getModel();
                    if (model != null) {
                        resp.setContentType("application/json");
                        resp.setCharacterEncoding("UTF-8");
                        PrintWriter writer = resp.getWriter();
                        String json = JsonUtil.toJson(model);
                        writer.write(json);
                        writer.flush();
                        writer.close();
                    }
    }
    private void handleViewResult(View view, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = view.getPath();
        if (StringUtil.isNotEmpty(path)) {
            if (path.startsWith("/")) {
                response.sendRedirect(request.getContextPath() + path);
            } else {
                Map<String, Object> model = view.getModel();
                for (Map.Entry<String, Object> entry: model.entrySet()){
                    request.setAttribute(entry.getKey(), entry.getValue());
                }
                request.getRequestDispatcher(ConfigHelper.getJspPath() + path).forward(request, response);
            }
        }
    }
}
