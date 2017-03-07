package edu.uark.models.api.enums;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by tejnakk on 3/6/17.
 */
public enum EmployeeApiRequestStatus {
    OK(0),
    INVALID_INPUT(1),
    UNKNOWN_ERROR(2),
    NOT_FOUND(3),
    LOOKUP_CODE_ALREADY_EXISTS(4);

    public int getValue() {
        return value;
    }

    public static EmployeeApiRequestStatus map(int key) {
        if (valueMap == null) {
            valueMap = new HashMap<Integer, EmployeeApiRequestStatus>();

            for (EmployeeApiRequestStatus status : EmployeeApiRequestStatus.values()) {
                valueMap.put(status.getValue(), status);
            }
        }

        return (valueMap.containsKey(key) ? valueMap.get(key) : EmployeeApiRequestStatus.UNKNOWN_ERROR);
    }

    private int value;

    private static Map<Integer, EmployeeApiRequestStatus> valueMap = null;

    private EmployeeApiRequestStatus(int value) {
        this.value = value;
    }
}
