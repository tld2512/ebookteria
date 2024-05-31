package com.ebookteria.gateway.service;

import com.ebookteria.gateway.dto.ApiResponse;
import com.ebookteria.gateway.dto.request.IntrospectRequest;
import com.ebookteria.gateway.dto.response.IntrospectResponse;
import com.ebookteria.gateway.repository.IdentityClient;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdentityService {
    IdentityClient identityClient;

    public Mono<ApiResponse<IntrospectResponse>> introspect(String token){
        return identityClient.introspect(IntrospectRequest.builder()
                .token(token)
                .build());
    }
}
