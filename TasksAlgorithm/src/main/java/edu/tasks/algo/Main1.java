
private String GET_ALL_LESSON_GROUP = "SELECT * FROM lessons_groups";

// 2 lists to map take repeat keys and make list values for it 

@Override
	public Map<Integer, List<Integer>> getAllLessonIdsGroupIds() {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> lessonIds = new ArrayList<>();
		List<Integer> groupIds = new ArrayList<>();
		try (Connection connection = jdbcTemplate.getDataSource().getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet resultSet = statement.executeQuery(GET_ALL_LESSON_GROUP);
			while (resultSet.next()) {
				lessonIds.add(resultSet.getInt("lesson_id"));
				groupIds.add(resultSet.getInt("group_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Set<Integer> setKeys = new HashSet<>();
		for (Integer id : lessonIds) {
			setKeys.add(id);
		}
		List<Integer> lengths = new ArrayList<>();
		int counterRepeat = 0;
		List<Integer> listKeys = new ArrayList<>(setKeys);
		List<Integer> indexes = new ArrayList<>();
		for (int keyIndex = 0; keyIndex < listKeys.size(); keyIndex++) {
			for (int lessonIndex = 0; lessonIndex < lessonIds.size(); lessonIndex++) {
				if (listKeys.get(keyIndex).equals(lessonIds.get(lessonIndex))) {
					counterRepeat++;
					indexes.add(lessonIndex);
				}
			}
			lengths.add(counterRepeat);
			counterRepeat = 0;
		}
		List<Integer> sortedLessonIds = new ArrayList<>();
		List<Integer> sortedGroupIds = new ArrayList<>();
		for (Integer id : indexes) {
			sortedLessonIds.add(lessonIds.get(id));
			sortedGroupIds.add(groupIds.get(id));
		}
		int increment = 0;
		for (int indexKey = 0; indexKey < lengths.size(); indexKey++) {
			List<Integer> values = new ArrayList<>();
			for (int indexValue = increment; indexValue < increment + lengths.get(indexKey); indexValue++) {
				values.add(sortedGroupIds.get(indexValue));
			}
			increment += lengths.get(indexKey);
			map.put(listKeys.get(indexKey), values);
		}
		return map;
	}
