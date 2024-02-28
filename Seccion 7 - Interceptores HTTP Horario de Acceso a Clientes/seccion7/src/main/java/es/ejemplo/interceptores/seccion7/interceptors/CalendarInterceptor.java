package es.ejemplo.interceptores.seccion7.interceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component(value = "calendarInterceptor")
@SuppressWarnings("null")
public class CalendarInterceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private int openHour;

    @Value("${config.calendar.close}")
    private int closeHour;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= openHour && hour < closeHour) {
            StringBuilder message = new StringBuilder("Bienvenidos al horario de atencion a clientes");
            message.append(", atendemos desde las ");
            message.append(openHour);
            message.append("hrs.");
            message.append(" hasta las ");
            message.append(closeHour);
            message.append("hrs.");
            message.append("Gracias por su visita!");
            request.setAttribute("message", message.toString());
            return true;
        }
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<String, Object>();
        StringBuilder message = new StringBuilder("Fuera del horario de atencion al cliente");
        data.put("message", message.toString());
        data.put("date", new Date().toString());
        response.setContentType("application/json");
        response.setStatus(401);
        response.getWriter().write(mapper.writeValueAsString(data));
        return false;
    }

}
