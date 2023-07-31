package model_classes;

import java.util.Objects;

public class NewsletterModel {
	public String name;
	public String frequency;
	public String description;
	@Override
	public int hashCode() {
		return Objects.hash(description, frequency, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsletterModel other = (NewsletterModel) obj;
		return Objects.equals(description, other.description) && Objects.equals(frequency, other.frequency)
				&& Objects.equals(name, other.name);
	}
}