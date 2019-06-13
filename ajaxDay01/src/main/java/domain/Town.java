/**
 * @Author wpzhang
 * @Date 2019/6/14
 * @Description
 */
package domain;

import java.util.Objects;

/**
 * @program: ajax
 * @description:
 * @author: wpzhang
 * @create: 2019-06-14 06:43
 **/
public class Town {
    public Town(){}

    public Town(Integer id, String code, String name, String citycode) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.citycode = citycode;
    }

    private Integer id;
    private String code;
    private String name;
    private String citycode;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    @Override
    public String toString() {
        return "Town{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", citycode='" + citycode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return Objects.equals(id, town.id) &&
                Objects.equals(code, town.code) &&
                Objects.equals(name, town.name) &&
                Objects.equals(citycode, town.citycode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, citycode);
    }
}