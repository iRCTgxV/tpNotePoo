import static org.junit.Assert.fail;

import java.awt.List;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class TestApp {
	private Canal c;
	@BeforeClass
	public void init() {
		c = new Canal(1,"canal 1",null,null,null,null);
	}

	@Test
    public void ecrireMessageKO() throws ActionNonAutoriseeException {

        // Etape 1 : pr�paration des objets
        Canal c = new Canal();

        Message m = new Message();
        m.setDestinataire((Destinataire) c);
        m.setTexte("Bonne ann�e 2021 !");

        Utilisateur utilisateur = new Utilisateur();

        c.ecrireMessage(utilisateur, m);

		// Etape 3 test du retour
		fail("L'exception aurait du �tre lev�e, on ne doit pas passer ici !");
    }
	
	@Test
	public void getHistoriqueOK() {
		c.getHistoriques();
	}
	
	@Test
	public void getMapping_role_utilisateursOK() {
		c.getMapping_role_utilisateurs();
	}
	
	@Test
	public void getMapping_role_habilitationsOK() {
		c.getMapping_role_habilitations();
	}
	
	@Test
    public void ecrireMessageOK() throws ActionNonAutoriseeException {
        // Etape 1 : pr�paration des objets
        Canal c = new Canal();

        Message m = new Message();
        m.setDestinataire((Destinataire) c);
        m.setTexte("Bonne f�tes de fin d'ann�e !");

        Utilisateur utilisateur = new Utilisateur();
        c.getMapping_role_utilisateurs().put(new Role("Membre"), Arrays.asList(utilisateur));
        c.getMapping_role_habilitations().put(new Role("Membre"), Arrays.asList(Habilitation.ECRITURE));

        // Etape 2 : appel de la m�thode test�e
        c.ecrireMessage(utilisateur, m);

        // Etape 3 test du retour
        List<Message> historiques = c.getHistoriques();
        Assert.assertEquals(1, historiques.size());
        System.out.println(historiques.get(0).getTexte());
    }

	    
	    
}
