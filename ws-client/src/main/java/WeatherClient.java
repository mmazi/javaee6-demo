import com.housing.javaee6demo.ws.imported.Forecast;
import com.housing.javaee6demo.ws.imported.ForecastReturn;
import com.housing.javaee6demo.ws.imported.Weather;
import com.housing.javaee6demo.ws.imported.WeatherReturn;
import com.housing.javaee6demo.ws.imported.WeatherSoap;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.List;

/**
 * @author Matija Mazi <br/>
 * @created 11.2.12 21:57
 */
public class WeatherClient {
    public static void main(String[] args) throws Exception {
        Weather weather = new Weather(new URL("http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl"), new QName("http://ws.cdyne.com/WeatherWS/", "Weather"));
        WeatherSoap weatherSoap = weather.getWeatherSoap();

        WeatherReturn bhWeather = weatherSoap.getCityWeatherByZIP("90210");
        System.out.println(bhWeather.getCity());
        System.out.println(bhWeather.getDescription());
        System.out.println(bhWeather.getTemperature());
        System.out.println(bhWeather.getWind());
        System.out.println("========================================");

        ForecastReturn bhWeatherFcst = weatherSoap.getCityForecastByZIP("90210");
        System.out.println(bhWeatherFcst.getCity());
        List<Forecast> fcst = bhWeatherFcst.getForecastResult().getForecast();
        for (Forecast forecast : fcst) {
            System.out.println("------------------------");
            System.out.println(forecast.getDate());
            System.out.println(forecast.getDesciption());
            System.out.println(forecast.getProbabilityOfPrecipiation());
            System.out.println(forecast.getTemperatures().getMorningLow());
            System.out.println(forecast.getTemperatures().getDaytimeHigh());
        }
    }
}
