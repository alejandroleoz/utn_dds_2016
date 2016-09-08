package utn.dds.tp.manager;

import utn.dds.tp.Flyweight;
import utn.dds.tp.user.Usuario;
import utn.dds.tp.user.aux.Token;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleoz on 9/6/16.
 */
public class AuthManager {

    // Mapping: token -> usuario
    private Map<Long, Usuario> loggedUsers;


    public AuthManager() {
        this.loggedUsers = new HashMap<>();
    }

    /**
     * Inicia nueva sesion para un usuario.
     * Devuelve el token generado
     * @param user
     * @param pass
     * @return
     */
    public long login(String user, String pass){
        for (Map.Entry<String, Usuario> entry : this.getUsuarios().entrySet()) {
            Usuario usrObj = entry.getValue();
            String username = usrObj.getUsername();
            String password = usrObj.getPassword();
            if(username.equals(user) && password.equals(pass)){
                Token tkn = this.iniciarSesion(usrObj);
                return tkn.getToken();
            }
        }
        return 0;
    }

    /**
     * Cierra sesion para el usuario
     * @param user
     * @param token
     * @return
     */
    public boolean logout(String user, Long token){
        Usuario usuario = this.loggedUsers.get(token);
        if(usuario != null){
            this.loggedUsers.remove(token);
            usuario.setActiveToken(null);
            return true;
        }
        return false;
    }

    /**
     * Chequea si el token es valido para el usuario
     * @param user
     * @param token
     * @return
     */
    public boolean checkToken(String user, Long token){
        Usuario usrObj = this.loggedUsers.get(token);
        return usrObj != null && usrObj.getActiveToken().isValidToken();
    }

    /**
     * Devuelve los usuarios del sistema
     * Mapping: username -> Usuario
     * @return
     */
    private Map<String, Usuario> getUsuarios() {
        return Flyweight.getInstance().getUserManager().getUsuarios();
    }

    /**
     * Registra el usuario como logueado y le asigna un nuevo token
     * @param user
     * @return
     */
    private Token iniciarSesion(Usuario user){
        Long tkn = Math.round(Math.random() * 100000);
        Token token = new Token(tkn, new Date(2018, 11, 31));
        user.setActiveToken(token);
        this.loggedUsers.put(tkn, user);
        return token;
    }
}
