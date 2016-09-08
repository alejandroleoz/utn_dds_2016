package utn.dds.tp.manager;

import static org.junit.Assert.*;
import org.junit.Test;
import utn.dds.tp.Flyweight;
import utn.dds.tp.user.Admin;
import utn.dds.tp.user.Usuario;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by aleoz on 9/7/16.
 */
public class TestAuthManager {

    @Test
    public void test() {

        UserManager userManager = Flyweight.getInstance().getUserManager();
        userManager.addUsuario(new Usuario("alejandro", "123", Flyweight.getInstance().getRole(Admin.ROLE)));
        userManager.addUsuario(new Usuario("ezequiel", "456", Flyweight.getInstance().getRole(Admin.ROLE)));

        AuthManager authManager = Flyweight.getInstance().getAuthManager();

        // login OK
        long tokenOk = authManager.login("alejandro", "123");
        assertTrue("Token generado (login ok)", tokenOk > 0);
        assertTrue("Ususario logueado", authManager.checkToken("alejandro", tokenOk));

        // chequea usuarios logueados
        this.checkLoggedUsers(authManager, 1);

        // cierra sesion
        assertFalse("Cerrar sesion (falla)", authManager.logout("alejandro", Long.valueOf(123)));
        assertTrue("Cerrar sesion", authManager.logout("alejandro", tokenOk));

        // chequea usuarios logueados
        this.checkLoggedUsers(authManager, 0);

        // login FAIL
        long tokenFail = authManager.login("alejandro", "aaa");
        assertFalse("Token no generado (login falla)", tokenFail > 0);
        assertFalse("Ususario no logueado", authManager.checkToken("alejandro", Long.valueOf(0)));
        this.checkLoggedUsers(authManager, 0);
    }

    /**
     * White box test
     * Chequea la cantidad de usuarios logueados
     * @param authManager
     * @param expected
     */
    private void checkLoggedUsers(AuthManager authManager, int expected) {
        try {
            Field field = AuthManager.class.getDeclaredField("loggedUsers");
            field.setAccessible(true);

            Map loggedUSers = (Map) field.get(authManager);
            assertTrue(expected + " usuarios logueados", loggedUSers.values().size() == expected);

            field.setAccessible(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
