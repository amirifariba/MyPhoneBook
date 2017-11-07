package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FEATURE")
public class Feature {
	@Id
	@GeneratedValue
	@Column(name = "featureId")
	private int featureId;

	@Column(name = "featureName", nullable = false)
	private String featureName;

	public int getFeatureId() {
		return featureId;
	}

	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public Feature(int featureId, String featureName) {
		this.featureId = featureId;
		this.featureName = featureName;
	}

	public Feature(String featureName) {
		this.featureName = featureName;
	}

	public Feature() {
	}

}
