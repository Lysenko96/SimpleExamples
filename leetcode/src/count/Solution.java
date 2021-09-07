package count;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {

	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

		List<Item> itemsList = new ArrayList<>();
		for (List<String> item : items) {
			Item i = new Item();
			i.setType(item.get(0));
			i.setColor(item.get(1));
			i.setName(item.get(2));
			System.out.println(i);
			itemsList.add(i);
		}
		int count = 0;
		for (Item i : itemsList) {
			if (ruleKey.equals("type") && i.getType().equals(ruleValue)) {
				count++;
			} else if (ruleKey.equals("color") && i.getColor().equals(ruleValue)) {
				count++;
			} else if (ruleKey.equals("name") && i.getName().equals(ruleValue)) {
				count++;
			}
		}
		System.out.println(count);
		return count;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.countMatches(
				Arrays.asList(Arrays.asList("phone", "blue", "pixel"), Arrays.asList("computer", "silver", "lenovo")),
				"color", "silver");
	}
}

class Item {

	private String type;
	private String color;
	private String name;

	public Item() {

	}

	public Item(String type, String color, String name) {
		this.type = type;
		this.color = color;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		return Objects.equals(color, other.color) && Objects.equals(name, other.name)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Item [type=" + type + ", color=" + color + ", name=" + name + "]";
	}

}
