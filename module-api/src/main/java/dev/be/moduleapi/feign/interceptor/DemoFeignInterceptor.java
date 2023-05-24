package dev.be.moduleapi.feign.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        if(Objects.equals(template.method(), Request.HttpMethod.GET.name())){
            System.out.println("[GET] = " + template.queries());
            return;
        }

        String encodedString = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);
        System.out.println("[Post] = " + encodedString);

        template.body(encodedString);
    }
}
