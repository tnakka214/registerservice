package edu.uark.commands.employees;

import edu.uark.models.api.Employee;

import org.apache.commons.lang3.StringUtils;
import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;
/**
 * Created by tejnakk on 3/6/17.
 */
public class EmployeeByLookupCodeQuery implements ResultCommandInterface<Employee> {
    @Override
    public Employee execute() {
        if (StringUtils.isBlank(this.lookupCode)) {
            return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.INVALID_INPUT);
        }

        EmployeeEntity employeeEntity = this.employeeRepository.byLookupCode(this.lookupCode);
        if (employeeEntity != null) {
            return new Employee(employeeEntity);
        } else {
            return new Employee().setApiRequestStatus(EmployeeApiRequestStatus.NOT_FOUND);
        }
    }

    //Properties 
    private String lookupCode;
    public String getLookupCode() {
        return this.lookupCode;
    }
    public EmployeeByLookupCodeQuery setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
        return this;
    }

    private EmployeeRepositoryInterface employeeRepository;
    public EmployeeRepositoryInterface getEmployeeRepository() {
        return this.employeeRepository;
    }
    public EmployeeByLookupCodeQuery setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
        this.employeeRepository = employeeRepository;
        return this;
    }

    public EmployeeByLookupCodeQuery() {
        this.employeeRepository = new EmployeeRepository();
    }

}
