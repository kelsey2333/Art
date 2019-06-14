package servlet; /**
 * @Author wpzhang
 * @Date 2019/6/13
 * @Description
 */

import dao.CityDao;
import dao.ProvinceDao;
import dao.TownDao;
import dao.impl.CityDaoImpl;
import dao.impl.ProvinceDaoImpl;
import dao.impl.TownDaoImpl;
import domain.City;
import domain.Province;
import domain.Town;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: ajax
 * @description: 城市下拉选
 * @author: wpzhang
 * @create: 2019-06-13 16:32
 **/
@WebServlet(name = "SelectServlet",urlPatterns = "*.province")
public class SelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();
        String uriStr = getUri(uri);
        resp.setContentType("text/html;charset=utf-8");
        switch (uriStr){
            case "list":
                ProvinceDao provinceDao = new ProvinceDaoImpl();
                List<Province> provinces = provinceDao.selectAllProvinces();
                JSONArray jsonArray = JSONArray.fromObject(provinces);
                resp.getWriter().write(jsonArray.toString());
                break;
            case "city":
                String provincecode = req.getParameter("code");
                CityDao cityDao = new CityDaoImpl();
                List<City> cities = cityDao.selectCitiesByProcode(provincecode);
                JSONArray jsonArray1 = JSONArray.fromObject(cities);
                resp.getWriter().write(jsonArray1.toString());
                break;
            case "town":
                String citycode = req.getParameter("code");
                TownDao townDao = new TownDaoImpl();
                List<Town> towns = townDao.selectTownsByCitycode(citycode);
                JSONArray jsonArray2 = JSONArray.fromObject(towns);
                resp.getWriter().write(jsonArray2.toString());
                break;
        }

    }

    /**
     * @Param
     * @description 获取后缀
     * @date 2019/6/10 16:12
     * @return
     */

    private static String  getUri(String requestURI) {
        int start = requestURI.lastIndexOf("/")+1;
        int end = requestURI.lastIndexOf(".");
        return requestURI.substring(start,end);
    }
}