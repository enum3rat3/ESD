package com.enum3rat3.studentfeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainBillDetails {
    private String description;
    private int amount;
    private String billDate;
    private String deadline;
    private int domainId;
}
