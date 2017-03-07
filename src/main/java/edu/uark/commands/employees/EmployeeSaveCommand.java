package edu.uark.commands.employees;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Employee;
import edu.uark.models.api.enums.EmployeeApiRequestStatus;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;


/**
 * Created by tejnakk on 3/6/17.
 */
public class EmployeeSaveCommand implements ResultCommandInterface <Employee> {
    @Override
    public Employee execute() {
        if (StringUtils.isBlank(this.apiEmployee.getLookupCode())) {
            return (new Employee()).setApiRequestStatus(EmployeeApiRequestStatus.INVALID_INPUT);
        }

        EmployeeEntity employeeEntity = this.employeeRepository.get(this.apiEmployee.getId());
        if (employeeEntity != null) {
            this.apiEmployee = employeeEntity.synchronize(this.apiEmployee);
        } else {
            employeeEntity = this.employeeRepository.byLookupCode(this.apiEmployee.getLookupCode());
            if (employeeEntity == null) {
                employeeEntity = new EmployeeEntity(this.apiEmployee);
            } else {
                return (new Employee()).setApiRequestStatus(EmployeeApiRequestStatus.LOOKUP_CODE_ALREADY_EXISTS);
            }
        }

        employeeEntity.save();
        if ((new UUID(0, 0)).equals(this.apiEmployee.getId())) {
            this.apiEmployee.setId(employeeEntity.getId());
        }

        return this.apiEmployee;
    }

    //Properties
    private Employee apiEmployee;
    public Employee getApiEmployee() {
        return this.apiEmployee;
    }
    public EmployeeSaveCommand setApiEmployee(Employee apiEmployee) {
        this.apiEmployee = apiEmployee;
        return this;
    }

    private EmployeeRepositoryInterface employeeRepository;
    public EmployeeRepositoryInterface getEmployeeRepository() {
        return this.employeeRepository;
    }
    public EmployeeSaveCommand setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
        this.employeeRepository = employeeRepository;
        return this;
    }

    public EmployeeSaveCommand() {
        this.employeeRepository = new EmployeeRepository();
    }
}
