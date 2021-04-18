package com.martinmorron.openfdaapi.business;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
class OpenFdaResponse {

    private Meta meta;
    private List<Result> results;

}
