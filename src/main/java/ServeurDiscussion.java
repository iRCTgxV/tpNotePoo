import java.util.List;
import java.util.Map;

public class ServeurDiscussion {

	public ServeurDiscussion() {
		
	}
	
	Map<Role,List<Utilisateur>> mapping_role_utilisateurs;
	List<Canal> canaux;
	String nom;
	Map<Role,List<Habilitation>> mapping_role_habilitations;
}
