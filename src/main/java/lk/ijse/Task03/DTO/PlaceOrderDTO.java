package lk.ijse.Task03.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderDTO {
    private long customerId;
    private LocalDate orderDate;
    private double totalAmount;
    private List<Long> itemIdList;
}
