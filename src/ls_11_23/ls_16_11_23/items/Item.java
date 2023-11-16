package ls_11_23.ls_16_11_23.items;

import java.time.LocalDate;

public record Item(String name, LocalDate date, Producer producer,
                   boolean isCrush, float price) {
}
