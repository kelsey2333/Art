/**
 * @Author wpzhang
 * @Date 2019/5/29
 * @Description
 */
package domain;

import java.util.List;
import java.util.Objects;

/**
 * @program: servletDay06
 * @description:
 * @author: wpzhang
 * @create: 2019-05-29 15:43
 **/
public class Role {
    public Role(){}
    private Integer id;
    private String roleName;
    private List<String> powerNames;

    public List<String> getPowerNames() {
        return powerNames;
    }

    public void setPowerNames(List<String> powerNames) {
        this.powerNames = powerNames;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
//        this.powerNames = powerNames;
}
    public Role(Integer id, String roleName,List<String> powerNames) {
        this.id = id;
        this.roleName = roleName;
        this.powerNames = powerNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(powerNames, role.powerNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, powerNames);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", powerNames=" + powerNames +
                '}';
    }
}