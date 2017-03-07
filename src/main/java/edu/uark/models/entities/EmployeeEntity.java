package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import com.sun.org.apache.xerces.internal.impl.dv.xs.BooleanDV;
import com.sun.org.apache.xerces.internal.impl.dv.xs.StringDV;
import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.fieldnames.ProductFieldNames;
import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Product;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.repositories.EmployeeRepository;

public class EmployeeEntity extends BaseEntity<EmployeeEntity> {
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


    @Override
    protected void fillFromRecord(ResultSet rs) throws SQLException {
        this.firstName = rs.getString(EmployeeFieldNames.FIRSTNAME);
        this.lastName = rs.getString(EmployeeFieldNames.LASTNAME);
        this.employeeID = rs.getInt(EmployeeFieldNames.EMPLOYEE_ID);
        this.isActive = rs.getBoolean(EmployeeFieldNames.IS_ACTIVE);
        this.role = rs.getString(EmployeeFieldNames.ROLE);
        this.manager = rs.getInt(EmployeeFieldNames.MANAGER);
        this.password = rs.getString(EmployeeFieldNames.PASSWORD);
        this.createdOn = rs.getTimestamp(EmployeeFieldNames.CREATED_ON).toLocalDateTime();
        this.count = rs.getInt(EmployeeFieldNames.COUNT);
    }

    @Override
    protected Map<String, Object> fillRecord(Map<String, Object> record) {

        record.put(
                EmployeeFieldNames.FIRSTNAME,
                this.firstName
        );

        record.put(
                EmployeeFieldNames.LASTNAME,
                this.lastName
        );

        record.put(
                EmployeeFieldNames.EMPLOYEE_ID,
                this.employeeID
        );

        record.put(
                EmployeeFieldNames.IS_ACTIVE,
                this.isActive
        );

        record.put(
                EmployeeFieldNames.ROLE,
                this.role
        );

        record.put(
                EmployeeFieldNames.MANAGER,
                this.manager
        );

        record.put(
                EmployeeFieldNames.PASSWORD,
                this.password
        );

        record.put(
                EmployeeFieldNames.CREATED_ON,
                Timestamp.valueOf(this.createdOn)
        );

        record.put(
                EmployeeFieldNames.COUNT,
                this.count
        );

        record.put(
                EmployeeFieldNames.LOOKUP_CODE,
                this.lookupCode
        );

        return record;
    }
    public int getCount() {
        return this.count;
    }
    public EmployeeEntity setCount(int count) {
        if (this.count != count) {
            this.count = count;
            this.propertyChanged(EmployeeFieldNames.COUNT);
        }

        return this;
    }


    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    public String getLookupCode() {
        return this.lookupCode;
    }

    public EmployeeEntity setLookupCode(String lookupCode) {
        if (!StringUtils.equals(this.lookupCode, lookupCode)) {
            this.lookupCode = lookupCode;
            this.propertyChanged(EmployeeFieldNames.LOOKUP_CODE);
        }

        return this;
    }

    public Employee synchronize(Employee apiEmployee) {
        this.setCount(apiEmployee.getCount());
        this.setLookupCode(apiEmployee.getLookupCode());

        apiEmployee.setCreatedOn(this.createdOn);

        return apiEmployee;
    }


    public EmployeeEntity() {
        super(new EmployeeRepository());

        this.count = -1;
        this.lookupCode = StringUtils.EMPTY;
        this.createdOn = LocalDateTime.now();
    }

    public EmployeeEntity(Employee id) {
        super(id.getId(), new EmployeeRepository());

        this.count = -1;
        this.lookupCode = StringUtils.EMPTY;
        this.createdOn = LocalDateTime.now();
    }
}
