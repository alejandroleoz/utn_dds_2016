package utn.dds.tp;

import utn.dds.tp.manager.*;
import utn.dds.tp.user.Admin;
import utn.dds.tp.user.Role;
import utn.dds.tp.user.Terminal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleoz on 9/7/16.
 */
public class Flyweight {
    private static Flyweight instance = null;
    private Flyweight(){
        this.setupRoles();
    }

    public static Flyweight getInstance() {
        if(instance == null){
            instance = new Flyweight();
        }
        return instance;
    }

    /* **************************************/

    private Map<String, Role> roles;
    private AuthManager authManager;
    private POIManager poiManager;
    private ReportManager reportManager;
    private RubroManager rubroManager;
    private UserManager userManager;

    // todo: configurar externamente
    private void setupRoles(){
        this.roles = new HashMap<>();
        this.roles.put(Admin.ROLE, new Admin());
        this.roles.put(Terminal.ROLE, new Terminal());
    }

    public AuthManager getAuthManager(){
        if(this.authManager == null){
            this.authManager = new AuthManager();
        }
        return this.authManager;
    }

    public POIManager getPoiManager(){
        if(this.poiManager == null){
            this.poiManager = new POIManager();
        }
        return this.poiManager;
    }

    public ReportManager getReportManager(){
        if(this.reportManager == null){
            this.reportManager = new ReportManager();
        }
        return this.reportManager;
    }

    public RubroManager getRubroManager(){
        if(this.rubroManager == null){
            this.rubroManager = new RubroManager();
        }
        return this.rubroManager;
    }

    public UserManager getUserManager(){
        if(this.userManager == null){
            this.userManager = new UserManager();
        }
        return this.userManager;
    }

    public Role getRole(String role) {
        return this.roles.get(role);
    }

}
