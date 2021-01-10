package com.example.demo.customers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.ZonedDateTime;

@Getter
@Builder
@ApiModel(description = "Class representing a customer request/response.")
public class Customer {

    @Positive
    @ApiModelProperty(required = true, example = "1")
    private long id;

    @NotEmpty
    @NotNull
    @ApiModelProperty(required = true, example = "John Doe")
    private String name;

    @NotNull
    @ApiModelProperty(required = true, example = "2020-01-01T00:00:01-01:00")
    private ZonedDateTime duetime;

    @NotNull
    @ApiModelProperty(required = true, example = "2020-01-01T00:00:01-01:00")
    private ZonedDateTime jointime;

}
