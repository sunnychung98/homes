package kr.code.homes.config;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProcessInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = false;
        /*
          세션 체크를 해서 로그인 상태가 아닐경우  로그인화면으로 이동시키는 로직이 들어간다.
         */
        return result;
    }

    /**
     * 해당 리퀘스트가 ajax 에 의한 것인지
     * 확인하는 메서드
     * @param req
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest req) {
        String header = req.getHeader("AJAX");
        if ("true".equals(header)){
            return true;
        }else{
            return false;
        }
    }
}
