package utn.dds.tp.manager;

import utn.dds.tp.user.Usuario;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleoz on 9/6/16.
 */
public class UserManager {

    private Map<String, Usuario> usuarios;

    public UserManager() {
        this.usuarios = new HashMap<>();
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean addUsuario(Usuario usuario){
        if(this.usuarios.get(usuario.getUsername()) == null) {
            this.usuarios.put(usuario.getUsername(), usuario);
            return true;
        }
        return false;
    }
}
