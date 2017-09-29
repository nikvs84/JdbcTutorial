import bl.Util;
import service.AddressService;
import service.EmplProjService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Connection;
import java.sql.SQLException;

public class Domain {
    public static void main(String[] args) throws SQLException {
        new AddressService().getAll().forEach(System.out::println); // address -> System.out.println(address)
        new EmployeeService().getAll().forEach(System.out::println); // employee -> System.out.println(employee)
        new ProjectService().getAll().forEach(System.out::println); // project -> System.out.println(project)
        new EmplProjService().getAll().forEach(System.out::println); // emplProj -> System.out.println(emplProj)
    }
}
