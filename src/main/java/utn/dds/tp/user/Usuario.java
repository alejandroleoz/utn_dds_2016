package utn.dds.tp.user;

import utn.dds.tp.user.aux.Token;


/**
 * Created by aleoz on 9/6/16.
 */
public class Usuario {

    private String username;
    private String password;
    private Token activeToken;
    private Role role;

    public Usuario(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Token getActiveToken() {
        return activeToken;
    }

    public void setActiveToken(Token activeToken) {
        this.activeToken = activeToken;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
