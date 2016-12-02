/**
 *    Copyright  2016  tianjunwei
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.tianjunwei.interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * @author tianjunwei
 * @time 2016 下午7:33:06
 */
public class LanguageCookieInterceptor implements HandlerInterceptor{  
	  
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  
            throws Exception {  
        String language = request.getParameter("language");  
        if (language != null&&language.equals("zh")) {  
            Locale locale = new Locale("zh", "CN");  
            (new CookieLocaleResolver()).setLocale (request, response, locale);  
            request.setAttribute("language", language);  
        } else if (language != null&&language.equals("en")) {  
            Locale locale = new Locale("en", "US");  
            (new CookieLocaleResolver()).setLocale (request, response, locale);  
            request.setAttribute("language", language);  
        } else {  
            (new CookieLocaleResolver()).setLocale (request, response,  
                    LocaleContextHolder.getLocale());  
            language = LocaleContextHolder.getLocale().getLanguage();  
            request.setAttribute("language", language);  
        }  
        return true;  
    }  
  
    @Override  
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {  
          
    }  
  
    @Override  
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
          
    }  
  
}
