package com.ebookteria.notification.service;

import com.ebookteria.notification.dto.request.EmailRequest;
import com.ebookteria.notification.dto.request.SendEmailRequest;
import com.ebookteria.notification.dto.request.Sender;
import com.ebookteria.notification.dto.response.EmailResponse;
import com.ebookteria.notification.exception.AppException;
import com.ebookteria.notification.exception.ErrorCode;
import com.ebookteria.notification.repository.httpClient.EmailClient;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;

    String apiKey = "your-brevo-apikey";

    public EmailResponse sendEmail(SendEmailRequest request) {
        EmailRequest emailRequest = EmailRequest.builder()
                .sender(Sender.builder()
                        .name("Pipi Lily DotCom")
                        .email("pipililyhd@gmail.com")
                        .build())
                .to(List.of(request.getTo()))
                .subject(request.getSubject())
                .htmlContent(request.getHtmlContent())
                .build();
        try {
            return emailClient.sendEmail(apiKey, emailRequest);
        } catch (FeignException e){
            throw new AppException(ErrorCode.CANNOT_SEND_EMAIL);
        }
    }
}
