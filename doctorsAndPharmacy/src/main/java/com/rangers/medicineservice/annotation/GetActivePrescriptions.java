package com.rangers.medicineservice.annotation;

import com.rangers.medicineservice.controller.handler.ErrorExtension;
import com.rangers.medicineservice.dto.PrescriptionDto;
import com.rangers.medicineservice.entity.Medicine;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Operation(
        summary = "Show all active prescriptions",
        description = "Get a list of all active prescriptions",
        tags = {"PRESCRIPTION"},
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "All active prescriptions found",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = PrescriptionDto.class)
                        )
                ),

                @ApiResponse(
                        responseCode = "400",
                        description = "No active prescriptions found",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ErrorExtension.class)
                        )
                )
        },
        security = {
                @SecurityRequirement(name = "safety requirements")
        }
)
public @interface GetActivePrescriptions {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
