package com.shuttle.major.fetch;

import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.fetch.fallback.ServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 14:53
 */

@FeignClient(value = "service", fallback = ServiceFallback.class)
public interface ServiceFetch {

    @GetMapping("/service/exist/{id}")
    ReturnMessage<Object> exist(@PathVariable long id);
}
