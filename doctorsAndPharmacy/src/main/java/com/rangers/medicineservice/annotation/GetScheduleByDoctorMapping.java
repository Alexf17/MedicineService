package com.rangers.medicineservice.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Operation(summary = "Obtaining the date and time of the doctor's schedule.",
        description = "Receiving the date and time of a doctor's appointment using his ID," +
                " the response comes in JSON format.",
        responses = {
                @ApiResponse(responseCode = "200", description = "found"),
                @ApiResponse(responseCode = "404", description = "not found")
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        },
        hidden = false
)
public @interface GetScheduleByDoctorMapping {
        @AliasFor(annotation = RequestMapping.class, attribute = "path")
        String[] path() default {};
}
