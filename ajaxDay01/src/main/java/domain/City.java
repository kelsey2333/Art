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
 * @create: 2019-06-14 05:48
 **/
public class City {
    public City(){}

    public City(Integer id, String code, String name, String provincecode) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.provincecode = provincecode;
    }

    private Integer id;
    private String code;
    private String name;
    private String provincecode;

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

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", provincecode='" + provincecode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(code, city.code) &&
                Objects.equals(name, city.name) &&
                Objects.equals(provincecode, city.provincecode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, provincecode);
    }
}