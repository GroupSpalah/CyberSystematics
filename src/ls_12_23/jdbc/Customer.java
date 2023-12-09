package ls_12_23.jdbc;

import java.time.LocalDate;

public record Customer(int customerNo, String firstName, String lastName,
                       String middleName, String city, String phone,
                       String address1, String address2, LocalDate dateSystem) {

    public Customer(String firstName, String lastName, String middleName, String city,
                    String phone, String address1, String address2, LocalDate dateSystem) {
        this(0, firstName, lastName, middleName, city, phone, address1, address2, dateSystem);
    }
}
