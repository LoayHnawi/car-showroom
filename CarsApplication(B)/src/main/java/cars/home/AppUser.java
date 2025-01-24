package cars.home;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="users")
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id_user;

    @Column(name = "username")
    private String nameUser;

    @Column(name = "password")
    private String password;

    private Date created;

    public AppUser() {}
    public AppUser(String nameUser, String password) {
        this.nameUser = nameUser;
        this.password = password;
        this.created = new Date();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nameUser;
    }

    public Integer getId_user() {
        return id_user;
    }
    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }


    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
