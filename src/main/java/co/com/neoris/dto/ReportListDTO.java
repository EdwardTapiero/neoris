package co.com.neoris.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data transfer object
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportListDTO {

    private List<ReportDTO> reportes;

}
