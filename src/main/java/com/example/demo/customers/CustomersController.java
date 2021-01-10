package com.example.demo.customers;

import com.example.demo.validation.ValidList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.validation.Valid;
import java.util.concurrent.ForkJoinPool;

@Api("Customer management system")
@RequestMapping("/customers")
@RequiredArgsConstructor
@RestController
public class CustomersController {

    private final CustomerService customerService;

    @ApiOperation(
            value = "Sort customers due time oldest to newest",
            response = Customer.class,
            responseContainer = "List",
            notes = "This will sort values with a *stream* and *compareTo*")
    @PostMapping("/duetime-sort")
    public ResponseEntity<?> sortWithStream(@RequestBody @Valid ValidList<Customer> customers) {
        return new ResponseEntity<>(customerService.sortDueTimeOldToNewWithStream(customers), HttpStatus.OK);
    }

    @ApiOperation(
            value = "Sort customers due time oldest to newest",
            response = Customer.class,
            responseContainer = "List",
            notes = "This will sort values *asynchronous* with a *stream* and *compareTo*")
    @PostMapping("/async-duetime-sort")
    @ResponseStatus(HttpStatus.OK)
    public DeferredResult<ResponseEntity<?>> sortWithStreamAsync(@RequestBody @Valid ValidList<Customer> customers) {
        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();
        ForkJoinPool.commonPool().submit(() -> {
            output.setResult(ResponseEntity.ok(customerService.sortDueTimeOldToNewWithStream(customers)));
        });
        return output;
    }

}

