import java.util.List;
import java.util.Map;

public class Canal {

	int Ordre;
	String nom;
	List<Message> historiques;
	List<Webhook> webhooks;
	Map<Role,List<Utilisateur>> mapping_role_utilisateur;
	Map<Role,List<Habilitation>> mapping_role_habilitations;
	

	
	public Canal(int ordre, String nom, List<Message> historiques, List<Webhook> webhooks,
			Map<Role, List<Utilisateur>> mapping_role_utilisateur,
			Map<Role, List<Habilitation>> mapping_role_habilitations) {
		super();
		Ordre = ordre;
		this.nom = nom;
		this.historiques = historiques;
		this.webhooks = webhooks;
		this.mapping_role_utilisateur = mapping_role_utilisateur;
		this.mapping_role_habilitations = mapping_role_habilitations;
	}
	public Canal() {
		// TODO Auto-generated constructor stub
	}
	void ecrireMessage(Utilisateur u, Message m) {
		this.historiques.add(m);
	}
	public int compareTo(Canal c) {
		return this.Ordre - c.Ordre;
	}
	public Object getMapping_role_utilisateurs() {
		return this.getMapping_role_utilisateurs();
	}
	public Object getMapping_role_habilitations() {
		return this.getMapping_role_habilitations();
	}
	public List<Message> getHistoriques() {
		return this.historiques;
	}
}
