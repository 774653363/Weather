package ek.zhou.weather.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;

/**
 * City List.
 * 
 * @since 1.0.0 2017年11月23日

 */
@XStreamAlias("c")
public class CityList implements Serializable {
	@XStreamImplicit(itemFieldName = "d")
	private List<City> cityList;

	public CityList() {
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
}
