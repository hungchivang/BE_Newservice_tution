package onegroup.onekids_excel_v3.entity.excel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "status_excel")
public class StatusExcel {
    @Id
    private String idGuid;
    private String status;
    private String fileName;
    private LocalDateTime createdDate;
}
