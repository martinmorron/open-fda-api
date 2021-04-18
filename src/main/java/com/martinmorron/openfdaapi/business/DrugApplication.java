package com.martinmorron.openfdaapi.business;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PACKAGE)
@Document
public class DrugApplication {

    @Id
    private final String id;

    @Indexed(unique=true)
    private final String applicationNumber;

    private List<String> manufacturerName;
    private List<String> substanceName;
    private List<String> productNumbers;
}
