import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoungestEldestWorkers {
    private String type;
    private String name;
    private String birthday;

}
