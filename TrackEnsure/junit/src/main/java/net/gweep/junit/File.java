package net.gweep.junit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

	private String name;
	private LocalDateTime dateTime;
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@Override
	public String toString() {
		if (dateTime != null) {
			String formattedDateTime = dateTime.format(FORMATTER);
			return "File [name=" + name + ", dateTime=" + formattedDateTime + "]";
		} else {
			return "File [name=" + name + ", dateTime=" + dateTime + "]";
		}
	}
}