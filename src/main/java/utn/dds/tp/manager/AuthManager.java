package utn.dds.tp.manager;

import utn.dds.tp.user.Usuario;
import utn.dds.tp.user.aux.Token;

import java.util.Date;
import java.util.Map;

/**
 * Created by aleoz on 9/6/16.
 */
public class AuthManager {

    // Mapping: username -> Usuario
    private Map<String, Usuario> usuarios;

    // Mapping: token -> usuario
    private Map<Long, Usuario> loggedUsers;

    /**
     * Inicia nueva sesion para un usuario.
     * Devuelve el token generado
     * @param user
     * @param pass
     * @return
     */
    public long login(String user, String pass){
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
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
