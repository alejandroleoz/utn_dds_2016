package utn.dds.tp.user.aux;

import java.util.Date;

/**
 * Created by aleoz on 9/7/16.
 */
public class Token {

    private Long token;
    private Date expirationDate;

    public Token(Long token, Date expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public Long getToken() {
        return token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public boolean isValidToken() {
        long currentTime = new Date().getTime();
        return currentTime <= this.expirationDate.getTime();
    }
}
