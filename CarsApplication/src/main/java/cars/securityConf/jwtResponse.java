package cars.securityConf;

public class jwtResponse {

    private String token;

    public jwtResponse(String token) {

        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

