package mng.main.lambda.removeif;

import org.apache.commons.lang3.RandomStringUtils;

public class UserRemoveIfEntity {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email.toLowerCase();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String id;
    public String email;
    String pwd;
    public Boolean flagActive = Boolean.FALSE;


    public UserRemoveIfEntity(String id, String email, String pwd, Boolean flagActive) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.flagActive = flagActive;
    }





    public static UserRemoveIfEntity createRandomActive() {
        return new UserRemoveIfEntity(
                RandomStringUtils.randomNumeric(2),
                RandomStringUtils.randomAlphanumeric(15),
                RandomStringUtils.randomAlphanumeric(10),
                Boolean.TRUE
        );
    }

    public static UserRemoveIfEntity createRandomInactive() {
        return new UserRemoveIfEntity(
                RandomStringUtils.randomNumeric(2),
                RandomStringUtils.randomAlphanumeric(15),
                RandomStringUtils.randomAlphanumeric(10),
                Boolean.FALSE
        );
    }



    public void setActive() {
        this.flagActive = Boolean.TRUE;
    }

    public void setDesactive() {
        this.flagActive = Boolean.FALSE;
    }



    public String describe() {
        StringBuffer sb = new StringBuffer();
        sb.append("ID:").append(this.id)
                .append(" EMAIL:").append(this.email)
                .append(" FLAG_ACTIVE:").append(this.flagActive);
        return sb.toString();
    }



}
