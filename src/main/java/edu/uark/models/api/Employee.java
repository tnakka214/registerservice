package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;

public class Employee {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer employeeID;
    private Boolean isActive;
    private String role;
    private Integer manager;
    private String password;
    private LocalDateTime createdOn;
    private Integer count;
    private String lookupCode;

    public UUID getId() {
        return this.id;
    }
    public Employee setId(UUID id) {
        this.id = id;
        return this;
    }


    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }
    public Employee setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    private EmployeeApiRequestStatus apiRequestStatus;
    public EmployeeApiRequestStatus getApiRequestStatus() {
        return this.apiRequestStatus;
    }
    public Employee setApiRequestStatus(EmployeeApiRequestStatus apiRequestStatus) {
        if (this.apiRequestStatus != apiRequestStatus) {
            this.apiRequestStatus = apiRequestStatus;
        }

        return this;
    }

    private String apiRequestMessage;
    public String getApiRequestMessage() {
        return this.apiRequestMessage;
    }
    public Employee setApiRequestMessage(String apiRequestMessage) {
        if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
            this.apiRequestMessage = apiRequestMessage;
        }

        return this;
    }

    public int getCount() {
        return this.count;
    }
    public Employee setCount(int count) {
        this.count = count;
        return this;
    }

    public String getLookupCode() {
        return this.lookupCode;
    }
    public Employee setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
        return this;
    }

    public Employee() {
        this.id = new UUID(0, 0);
        this.createdOn = LocalDateTime.now();
        this.apiRequestMessage = StringUtils.EMPTY;
        this.apiRequestStatus = EmployeeApiRequestStatus.OK;
        this.count = -1;
        this.lookupCode = "";
    }

    public Employee(EmployeeEntity employeeEntity) {
        this.id = employeeEntity.getId();
        this.createdOn = employeeEntity.getCreatedOn();
        this.count = employeeEntity.getCount();
        this.lookupCode = employeeEntity.getLookupCode();
        this.apiRequestMessage = StringUtils.EMPTY;
        this.apiRequestStatus = EmployeeApiRequestStatus.OK;
    }
}
