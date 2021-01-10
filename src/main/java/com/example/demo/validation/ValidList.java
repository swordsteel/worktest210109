package com.example.demo.validation;

import com.google.common.collect.ForwardingList;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ValidList<T> extends ForwardingList<T> {

    private List<@Valid T> list = new ArrayList<>();

    @Override
    protected List<T> delegate() {
        return list;
    }

}
