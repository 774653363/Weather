package ek.zhou.weather.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * City.
 * 
 * @since 1.0.0 2017年11月23日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */

@XStreamAlias("d")
public class City implements Serializable {
	@XStreamAsAttribute
	@XStreamAlias("d1")
	private String cityId;
	@XStreamAsAttribute
	@XStreamAlias("d2")
	private String cityName;
	@XStreamAsAttribute
	@XStreamAlias("d3")
	private String cityCode;
	@XStreamAsAttribute
	@XStreamAlias("d4")
	private String province;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "City{" +
				"cityId='" + cityId + '\'' +
				", cityName='" + cityName + '\'' +
				", cityCode='" + cityCode + '\'' +
				", province='" + province + '\'' +
				'}';
	}
}
