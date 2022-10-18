package cision.com.gcp.firestore.poc.user;

import com.google.cloud.firestore.annotation.DocumentId;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collectionName = "users")
public class User {

  @DocumentId
  private String id;
  private String name;
  private int age;
  private List<Integer> pets;

}
