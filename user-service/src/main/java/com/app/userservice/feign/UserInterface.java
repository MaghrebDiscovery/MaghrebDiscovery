package com.app.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("commentaire-service")
public interface UserInterface {
}
