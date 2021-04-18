package com.martinmorron.openfdaapi.business;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter(value = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class OpenFdaResponse {

    private final Meta meta;
    private final List<Result> results;

}
