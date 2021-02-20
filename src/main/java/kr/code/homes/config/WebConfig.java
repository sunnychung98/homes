package kr.code.homes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * servelt 관련 설정
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * 스프링한테 내가 만든 인터셉터를 쓰라고
     * 설정하게 되는 메서드
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //해당 메서드가 받는 파라미터인 InterceptorRegistry 는 스프링 내부 객체로 임의의 인터셉터를 저장하는 객체
        registry.addInterceptor(new ProcessInterceptor());

        /* 개발자가 만든 인터셉터를  지정하고
         *   인터셉터에 적용되는 경로 또는 적용하지 말아야할 경로를 추가하는 부분
         *  적용해야할 경로와 적용하지 말아야할 경로를 추가해보세요
         * */
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Bean
    MappingJackson2JsonView jsonView(){
		//jsonView
		return new MappingJackson2JsonView();
	}
    
}
