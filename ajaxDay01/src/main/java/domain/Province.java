/**
 * @Author wpzhang
 * @Date 2019/6/13
 * @Description
 */
package domain;

import java.util.Objects;

/**
 * @program: ajax
 * @description:
 * @author: wpzhang
 * @create: 2019-06-13 17:18
 **/
public class Province {
    public Province(){}

    public Province(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    private Integer id;
    private String code;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return Objects.equals(id, province.id) &&
                Objects.equals(code, province.code) &&
                Objects.equals(name, province.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name);
    }
}