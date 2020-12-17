import static org.junit.Assert.fail;

import java.awt.List;
import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class TestApp {

	@Test
    public void ecrireMessageOK() throws ActionNonAutoriseeException {
        // Etape 1 : préparation des objets
        Canal c = new Canal();

        Message m = new Message();
        m.setDestinataire((Destinataire) c);
        m.setTexte("Bonne fêtes de fin d'année !");

        Utilisateur utilisateur = new Utilisateur();
        c.getMapping_role_utilisateurs().put(new Role("Membre"), Arrays.asList(utilisateur));
        c.getMapping_role_habilitations().put(new Role("Membre"), Arrays.asList(Habilitation.ECRITURE));

        // Etape 2 : appel de la méthode testée
        c.ecrireMessage(utilisateur, m);

        // Etape 3 test du retour
        List<Message> historiques = c.getHistoriques();
        Assert.assertEquals(1, historiques.size());
        System.out.println(historiques.get(0).getTexte());
    }

	    @Test
	    public void ecrireMessageKO() throws ActionNonAutoriseeException {

	        // Etape 1 : préparation des objets
	        Canal c = new Canal();

	        Message m = new Message();
	        m.setDestinataire((Destinataire) c);
	        m.setTexte("Bonne année 2021 !");

	        Utilisateur utilisateur = new Utilisateur();

	        c.ecrireMessage(utilisateur, m);

			// Etape 3 test du retour
			fail("L'exception aurait du être levée, on ne doit pas passer ici !");
	    }
}
