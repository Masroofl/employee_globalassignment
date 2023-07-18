package com.global.payload;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String id;
    private String employeeName;
    private String phoneNumber;
    private String email;
    private String reportsTo;
    private String profileImage;
}

