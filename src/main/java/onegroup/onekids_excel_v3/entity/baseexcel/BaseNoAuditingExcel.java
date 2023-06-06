package onegroup.onekids_excel_v3.entity.baseexcel;

import lombok.Getter;
import lombok.Setter;
import onegroup.onekids_excel_v3.common.AppConstant;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseNoAuditingExcel<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime autoCreateDate;

    private Long idCreated;

    private T createdBy;

    private LocalDateTime createdDate;

    private Long idModified;

    private T lastModifieBy;

    private LocalDateTime lastModifieDate;

    @Column(nullable = false, columnDefinition = "bit default 1")
    private boolean delActive = AppConstant.APP_TRUE;

}
