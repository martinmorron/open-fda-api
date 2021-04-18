package com.martinmorron.openfdaapi.api;

import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class DrugApplicationDTO {

    private final String applicationNumber;
    private final List<String> manufacturerName;
    private final List<String> substanceName;
    private final List<String> productNumbers;
}
