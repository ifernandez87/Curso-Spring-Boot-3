package es.ejemplo.seccion6.interceptores.interceptors;

import java.util.Random;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component(value = "loadingTimeInterceptor")
@Slf4j
@SuppressWarnings("null")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    @SuppressWarnings("null")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info(this.getClass() + "PreHandle -> Loading time Interceptor: Starting... ");
        HandlerMethod method = ((HandlerMethod) handler);
        log.info(this.getClass() + "PreHandle -> Method Name:" + method.getMethod().getName());
        request.setAttribute("startDate", System.currentTimeMillis());

        Random random = new Random();
        int delay = random.nextInt(500);

        Thread.sleep(delay);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        long endDate = System.currentTimeMillis();
        long startDate = (long) request.getAttribute("startDate");

        long result = endDate - startDate;

        log.info(this.getClass() + " [postHandle] -> Service Time:[" + result + "]");

        log.info(this.getClass() + " [postHandle] -> Loading time Interceptor: Coming out... ");
        HandlerMethod method = ((HandlerMethod) handler);
        log.info(this.getClass() + " [postHandle] -> Method Name:" + method.getMethod().getName());
    }

}
