package bayt.app.employeeservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class APIResponseDTO {
    private EmployeeDto employee;
    private DepartmentDto department;
}
